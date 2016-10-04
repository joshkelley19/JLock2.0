package Model;

import java.util.HashMap;

/**
 * Created by joshuakelley on 9/22/16.
 */
public class ProfileManager {
    public HashMap<String, Profile> profiles = new HashMap();
    public Profile currentProfile;

    public boolean signIn(String username,String password){
        if(profiles.get(username).getPassword().equals(password)){
            currentProfile = profiles.get(username);
            return true;
        }
        return false;
    }

    public void signOut(){
        currentProfile = null;
    }

//    public boolean checkSignedIn(){
//        return currentProfile!=null;
//    }

    public Profile createProfile(String firstName, String lastName, String userName, String password){
        Profile newProfile = new Profile(firstName,lastName,userName,password,createID());
        return newProfile;
    }

    public boolean addNewProfile(String firstName, String lastName, String userName, String password){
        if(userNameTaken(userName))return false;
        profiles.put(userName,createProfile(firstName,lastName,userName,password));
        return true;
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
