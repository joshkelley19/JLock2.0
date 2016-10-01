package Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by joshuakelley on 9/20/16.
 */
public class EntryManager {
    public ArrayList<JLockEntry> entries = new ArrayList<JLockEntry>();

    //todo select, edit entry

    public void createNewEntry(String site, String userName, String password, int clientNumber){
        //todo check for existing entry via website
        entries.add(new JLockEntry(site,userName,password,clientNumber));//in controller, must pass in currentProfile id number
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

    protected void editEntry(JLockEntry currentEntry,String site,String user,String pass){
        currentEntry.setWebsite(site);currentEntry.setUserName(user);currentEntry.setPassword(pass);
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
