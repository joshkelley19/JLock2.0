package Model;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by joshuakelley on 9/30/16.
 */
public class JDBC {
    String url = "jdbc:mysql://localhost:3306/JLock", user = "joshkelley19", password = "cleancode";
    Connection connection;
    Statement statement;

    /**
     * helper method that initializes db connection before sql operation
     * @throws SQLException
     */
    public void connect() throws SQLException{
        connection = DriverManager.getConnection(url, user, password);
    }

    public PreparedStatement addStatement(int id,String last,String first,String email,String user,String password) throws SQLException{
        PreparedStatement addStatement= connection.prepareStatement("INSERT INTO profiles " + "(id, last_name, first_name, email, user_name, password)"
                + " VALUES " + "(?, ?, ?, ?, ?, ?);");
        addStatement.setInt(1,id);addStatement.setString(2,last);addStatement.setString(3,first);addStatement.setString(4,email);addStatement.setString(5,user);addStatement.setString(6,password);

        return addStatement;
    }

    public void addProfile(int id, String last, String first, String daemail, String dauser, String dapassword){
        int rowsAffected=0;
        try {
            connect();
            statement = connection.createStatement();
            rowsAffected = addStatement(id,last,first,daemail,dauser,dapassword).executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void getProfile(String userName){
        try {
            connect();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM profiles WHERE user_name = '"+userName+"'");
            String collectedUserName = rs.getString(5);
            System.out.println(collectedUserName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAll(){
        try {
            connect();
            statement = connection.createStatement();
            ResultSet sqlResultSet = statement.executeQuery("SELECT * FROM profiles");
            //process result set, .next method returns boolean and moves line
            while (sqlResultSet.next()) {
                //get string takes column index or column label
                System.out.println(sqlResultSet.getString("last_name") + ", " + sqlResultSet.getString("first_name")+", "+sqlResultSet.getString("user_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveEntries(int profileID, ArrayList entries){
        File file = new File("Passwords.txt");//todo create file and delete file after every use
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entries);
        }catch(IOException e){
            System.out.println("You messed up the file writing");
        }
        //Types.BLOB=
        try {
            connect();
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("INSERT INTO entries " + "(accountID, entryFile)"
                    + " VALUES " + "("+profileID+",'"+file+"');");
        } catch (SQLException e) {
            System.out.println("You messed up the sql move");
        }
        file.delete();
    }

    public ArrayList<Integer> loadEntries(int accountNumber){
        ArrayList<Integer> loaded = null;
        try {//todo load arraylist of passwords
            connect();
            statement = connection.createStatement();
            ResultSet sqlResultSet = statement.executeQuery("SELECT * FROM entries WHERE accountID = '"+accountNumber+"'");
            ObjectInputStream ois = new ObjectInputStream(sqlResultSet.getAsciiStream("entryFile"));
            loaded = (ArrayList<Integer>)ois.readObject();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }//todo fix invalid stream header exception
        //todo save account info as md5 hash?
        //todo spring boot security
        return loaded;
    }

    public void update(String userName, String newPassword){
        try{
            connect();
            Statement sqlQueryStatement = connection.createStatement();
            int rowsUpdated = sqlQueryStatement.executeUpdate("UPDATE profiles " + "SET password='"+newPassword+"'"
                    + " WHERE user_name='"+userName+"'");
        }catch (SQLException e){

        }
    }

    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        jdbc.getProfile("joshkelley19");
    }
}
