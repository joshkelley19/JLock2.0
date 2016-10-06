package Model;

import java.util.Date;

/**
 * Created by joshuakelley on 9/22/16.
 */
public class Profile {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private final Date dateCreated;
    private final int accountNumber;

    public Profile(String firstName, String lastName, String email, String userName, String password, int accountNumber){
        this.firstName=firstName;this.lastName=lastName;this.email=email;this.userName = userName;
        this.password = password;this.accountNumber=accountNumber;dateCreated=new Date();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return userName +" "+accountNumber;
    }
}
