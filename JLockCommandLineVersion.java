package FrontEnd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import Backend.Profile;

public class JLockCommandLineVersion {
	
	ArrayList<Profile> profiles;
	Profile currentProfile;
	public void setCurrentProfile(Profile profile){
		this.currentProfile = profile;
	}
	
	public JLockCommandLineVersion() {
		
			try {
				File profiles = new File("JLockProfiles.txt");
				if(!profiles.exists()){
				profiles.createNewFile();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try(FileInputStream fs = new FileInputStream("JLockProfiles.txt");ObjectInputStream o = new ObjectInputStream(fs)){
			this.profiles=(ArrayList<Profile>)o .readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exception");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void newProfile(){
		Scanner ofProfile = new Scanner(System.in);
		System.out.println("Enter First Name: ");String f = ofProfile.next();
		System.out.println("Enter Last Name: ");String l = ofProfile.next();
		System.out.println("Enter User Name: ");String u = ofProfile.next();
		System.out.println("Enter Password: ");String p = ofProfile.next();
		Profile createdProfile = new Profile(f, l, u, p);
		ofProfile.close();
		profiles.add(createdProfile);
		setCurrentProfile(createdProfile);
		saveProfiles();
	}
	public void saveProfiles(){
		try(FileOutputStream fs = new FileOutputStream("JLockProfiles.txt");ObjectOutputStream arrayOfProfiles = new ObjectOutputStream(fs)){
			arrayOfProfiles.writeObject(profiles);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static char getLetter(){
		char letter;
		Scanner p = new Scanner(System.in);
		System.out.println("Enter Letter: ");
		String d = p.next();
		letter = d.toUpperCase().charAt(0);
		p.close();
		return letter;
	}
	public void welcome(){
		System.out.println("Welcome to J-Lock");
		System.out.println("Login = L | New User = N | Quit = Q");
		char answer;		
		do{
			answer = getLetter();
		}while((answer == 'L')||(answer=='N')||(answer=='Q'));
		if(answer=='Q'){
			System.out.print("Are you sure you want to quit? ");
			char pressed = getLetter();
			if(pressed=='Q'){
				System.exit(0);
			}else{
				System.out.println("Cancelled Exit");
				this.welcome();
			}
		}else if(answer == 'L'){
			this.signIn();
		}
	}
	public void signIn(){
		Scanner profileInfo = new Scanner(System.in);
		System.out.println("User Name: ");
		String user = profileInfo.next();
		System.out.println("Password: ");
		String pass = profileInfo.next();
		profileInfo.close();
		
		for(Profile a: profiles){
			if(user == a.toString()&& pass == a.getPassword()){
				this.setCurrentProfile(a);;
			}else continue;
		}
		if(currentProfile == null){
			System.out.println("Account information entered does not match any of our accounts. Try again");
			this.welcome();
		}else currentProfile.load();
	}
	public void logOff(){
		System.out.println("Are you sure you want to sign out? Y or N");
		char response = getLetter();
		if(response=='Y'){
			setCurrentProfile(null);
			this.welcome();
		}else if(response == 'N'){
			currentProfile.control();
		}
	}
	public static void main(String[] args){
		
		JLockCommandLineVersion a = new JLockCommandLineVersion();
		
		do{
			a.welcome();
		}while(a.currentProfile.control() != 'Q');
	}
}
