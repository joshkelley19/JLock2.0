package kelley.josh.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by joshuakelley on 9/20/16.
 */
public class JLockEntry implements Comparable<JLockEntry>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String website;
    private String userName;
    private String password;//only holds encrypted password
    private Long clientAccountNumber;
    private final Date dateCreated;
    private Date reminderDate;

    public JLockEntry(String site, String user, String password, Long clientNum){
        this.website=site;this.userName=user;this.password=password;this.clientAccountNumber=clientNum;this.dateCreated=new Date();
    }

    public JLockEntry(){
        dateCreated = new Date();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientAccountNumber(Long clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Long getClientAccountNumber() {
        return clientAccountNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password.toString();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "Website: "+website+" User Name: "+userName;
    }

    @Override
    public int compareTo(JLockEntry o) {
        return website.compareTo(o.getWebsite());
        //not in use, comparable implementation practice only
    }
}
