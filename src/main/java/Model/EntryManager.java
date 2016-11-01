package Model;

import kelley.josh.domain.JLockEntry;

import java.util.ArrayList;

/**
 * Created by joshuakelley on 9/20/16.
 */
public class EntryManager {
    public ArrayList<JLockEntry> entries = new ArrayList<>();
    private final static PasswordManager passwordManager = new PasswordManager();

    //todo select, edit entry

    public JLockEntry createNewEntry(String site, String userName, String password, int clientNumber){
        //todo check for existing entry via website
        JLockEntry createdEntry = new JLockEntry(site,userName,passwordManager.createNewPassword(password),clientNumber);//in controller, must pass in currentProfile id number
        entries.add(createdEntry);
        return createdEntry;
    }

    public boolean deleteEntry(JLockEntry currentEntry){
        for(JLockEntry entry: entries){
            if(entry.equals(currentEntry)){
                entries.remove(entry);
                return true;
            }
        }
        return false;
    }

    public ArrayList getAllEntries(){
        return entries;
    }

    public void updatePassword(JLockEntry currentEntry,String pass){
        currentEntry.setPassword(passwordManager.createNewPassword(pass));
    }//todo individual field edit methods

    protected String showWebsite(JLockEntry currentEntry){
        return currentEntry.getWebsite();
    }

    protected String showUserName(JLockEntry currentEntry){
        return currentEntry.getUserName();
    }

    protected String showPassword(JLockEntry currentEntry){
        return currentEntry.getPassword();
    }


}
