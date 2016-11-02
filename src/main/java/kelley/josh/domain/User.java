package kelley.josh.domain;

import javax.persistence.*;

/**
 * Created by joshuakelley on 9/22/16.
 */
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNumber;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;

    public User(String firstName, String lastName, String email, String userName, String password, int accountNumber){
        this.firstName=firstName;this.lastName=lastName;this.email=email;this.userName = userName;
        this.password = password;
    }

    public User(){
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
