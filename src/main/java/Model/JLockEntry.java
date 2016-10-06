package Model;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Created by joshuakelley on 9/20/16.
 */
public class JLockEntry implements Comparable<JLockEntry>{
    private String website;
    private String userName;
    private Password password;//only holds encrypted password
    private final int clientAccountNumber;
    private final Date dateCreated;
    private boolean isAdministratorAccount;//necessary?

    public JLockEntry(String site, String user, Password password, int clientNum){
        this.website=site;this.userName=user;this.password=password;this.clientAccountNumber =clientNum;this.dateCreated=new Date();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getClientAccountNumber() {
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

    public void setPassword(Password password) {
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
