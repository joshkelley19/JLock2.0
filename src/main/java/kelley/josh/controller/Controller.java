package kelley.josh.controller;

import Model.EntryManager;
import kelley.josh.domain.JLockEntry;
import kelley.josh.domain.User;
import Model.ProfileManager;

/**
 * Created by joshuakelley on 9/22/16.
 */
public class Controller {
    EntryManager entryManager = new EntryManager();
    JLockEntry currentEntry;
    ProfileManager profileManager = new ProfileManager();
    User currentUser;

    public boolean welcome(int selection){
        switch (selection){
            case 1:break;//signup return boolean
            case 2:break;//signin return boolean
            case 3:return false;//exit
            default:return true;
        }
        return true;
    }

    public boolean landingPage(int selection){
        switch (selection){
            case 1:break;//view entries
            case 2:break;//edit profile
            case 3:break;//
        }
        return true;
    }

    public boolean manageEntry(int selection){
        switch (selection){
            case 1:break;//addProfile
            case 2:break;//edit
            case 3:break;//delete
        }
        return true;
    }

    public void setSelectedEntry(int entryIndex){
        currentEntry=entryManager.entries.get(entryIndex);
    }

    /**
     * searches accounts to match user. if user name exists, compares entered password
     * to password connected to user name.
     * @param userName
     * @param password
     * @return boolean
     */
    public boolean searchAccounts(String userName,String password){
        for (String u: profileManager.profiles.keySet()){
            if(u.equals(userName)){
                if (profileManager.profiles.get(u).getPassword().equals(password))return true;
            }
        }
        return false;
    }

    public void setCurrentUser(User verifiedUser){
        this.currentUser = verifiedUser;
    }

}
