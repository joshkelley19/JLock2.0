package Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by joshuakelley on 9/20/16.
 */
public class EntryManager {
    public ArrayList<JLockEntry> entries = new ArrayList<JLockEntry>();
    private JLockEntry selectedEntry;//todo select, edit entry

    public void createNewEntry(String site, String userName, String password, int clientNumber){
        //todo check for existing entry via website
        entries.add(new JLockEntry(site,userName,password,clientNumber));//in controller, must pass in currentProfile id number
    }

    public boolean deleteEntry(){
        for(JLockEntry entry: entries){
            if(entry.equals(selectedEntry)){
                entries.remove(entry);
                return true;
            }
        }
        return false;
    }

    public void setSelectedEntry(int entryIndex){
        selectedEntry=entries.get(entryIndex);
    }

    public ArrayList getAllEntries(){
        return entries;
    }

    protected void editEntry(String site,String user,String pass){
        selectedEntry.setWebsite(site);selectedEntry.setUserName(user);selectedEntry.setPassword(pass);
    }//todo individual field edit methods

    protected String showWebsite(){
        return selectedEntry.getWebsite();
    }

    protected String showUserName(){
        return selectedEntry.getUserName();
    }

    protected String showPassword(){
        return selectedEntry.getPassword();
    }


}
