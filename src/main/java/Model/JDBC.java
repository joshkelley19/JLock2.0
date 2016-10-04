package Model;

import java.sql.*;

/**
 * Created by joshuakelley on 9/30/16.
 */
public class JDBC {
    Connection connection;
    Statement statement;
    String url = "jdbc:mysql://localhost:3306/JLock", user = "joshkelley19", password = "cleancode";

//    public void sqlOperation(int selection,int id,String last,String first,String email,String user,String password) {
//        try {
//            switch (selection){
//                case 1:view();
//                case 2:add(id,last,first,email,user, password);break;
//            }
//        }catch (SQLException e){
//            System.out.println("Failed brah");
//            //print "There is a problem connecting to the database
//        }
//
//    }

    public void add(int id,String last,String first,String daemail,String dauser,String dapassword){
        try {
            connection = DriverManager.getConnection(url, user, password);//strings
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("INSERT INTO profiles " + "(id, last_name, first_name, email, user_name, password)"
                    + " VALUES " + "("+id+",'"+last+"', '"+first+"', '"+daemail+"', '"+dauser+"', '"+dapassword+"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //if(rowsAffected<1)throw new SQLException();
    }

    public void viewAll(){
        try {
            connection = DriverManager.getConnection(url, user, password);
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

    public void update(String userName, String newPassword){
        try{
            Connection sqlConnection = DriverManager.getConnection(url, user, password);//strings
            Statement sqlQueryStatement = sqlConnection.createStatement();
            int rowsUpdated = sqlQueryStatement.executeUpdate("UPDATE profiles " + "SET password='"+newPassword+"'"
                    + " WHERE user_name='"+userName+"'");
        }catch (SQLException e){

        }
    }

//    public static void main(String[] args) {
//        JDBC jdbc = new JDBC();
//
//        //jdbc.sqlOperation(1,1,"!","1","1","1","1");
//        jdbc.add(2,"Kelley","Josh","joshemail","joshkelley19","cleancode");
//        jdbc.viewAll();
//        jdbc.update("joshkelley19","newjawn");
//        jdbc.viewAll();
//    }

}
