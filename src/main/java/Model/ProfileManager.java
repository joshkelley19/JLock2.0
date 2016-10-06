package Model;

import java.util.HashMap;

/**
 * Created by joshuakelley on 9/22/16.
 */
public class ProfileManager {
    public HashMap<String, Profile> profiles = new HashMap();
    private final EntryManager entryManager;

    public ProfileManager(){
        entryManager=new EntryManager();
    }

    public Profile signIn(String username,String password){
        if(profiles.get(username).getPassword().equals(password)){
            return profiles.get(username);
        }
        return null;
    }

    public void signOut(Profile currentProfile){
        currentProfile = null;
    }

//    public boolean checkSignedIn(){
//        return currentProfile!=null;
//    }

    public Profile createProfile(String firstName, String lastName, String email, String userName, String password){
        Profile newProfile = new Profile(firstName,lastName,email,userName,password,createID());
        return newProfile;
    }

    public Profile addNewProfile(String firstName, String lastName, String email, String userName, String password){
        if(userNameTaken(userName))return null;
        return profiles.put(userName,createProfile(firstName,lastName,email,userName,password));
    }

    public boolean userNameTaken(String userName){
        for(String user: profiles.keySet()){
            if (user.equalsIgnoreCase(userName))return true;
        }
        return false;
    }

    public int createID(){
        int createdID;
        do {
            createdID=(int)(Math.random()*100000000);
        }while (checkIfIDExists(createdID)||createdID<9999999);
        return createdID;
    }

    public boolean checkIfIDExists(int createdID){
        for(String key: profiles.keySet()){
            if(profiles.get(key).getAccountNumber()==createdID)return true;
        }
        return false;
    }

    //TODO delete account
    //TODO edit account options/password redo


}
