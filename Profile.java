package Backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Profile {
	ArrayList<JLockEntry> websiteProfiles;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;

	
	public Profile(String first, String last, String name, String pass){
		this.userName = name;
		this.password = pass;
		this.firstName = first;
		this.lastName = last;
	}
	public String getPassword(){
		return this.password;
	}
	public String toString() {
		return userName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	public void load(){
		try(FileInputStream fs = new FileInputStream(this.toString()+".txt");ObjectInputStream o = new ObjectInputStream(fs)){
			this.websiteProfiles=(ArrayList<JLockEntry>)o.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exception");
		} catch (IOException e) {
			System.out.println("IO Exception");;
		}
	}
	private void newEntry(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Web Site: ");
		String ws = scanner.next();
		System.out.println("User Name: ");
		String un = scanner.next();
		System.out.println("Password: ");
		String pw = scanner.next();
		scanner.close();
		JLockEntry entry = new JLockEntry(ws, un, pw, websiteProfiles.size() );
		this.saveEntry(entry);
		this.saveAll();
		return;
	}
	private void saveEntry(JLockEntry entry){
		for(JLockEntry a: websiteProfiles){
			if(entry.equals(a)){
				System.out.println("This entry already exists!");
				return;
			}
		}
		if(websiteProfiles.add(entry)){
			System.out.println("Your save has been successful");
		}else{
			System.out.println("Your Save failed");
		};
	}
	private void saveAll(){
		try(FileOutputStream fs = new FileOutputStream(this.toString()+".txt");ObjectOutputStream yourEntries = new ObjectOutputStream(fs)){
			yourEntries.writeObject(websiteProfiles);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void printAll(){
		for(JLockEntry a: websiteProfiles){
			System.out.println(a.toString());
		}
	}
	public char control(){
		System.out.println("What would you like to do?");
		char pressed;
		Scanner scanner = new Scanner(System.in);
		pressed=scanner.next().toUpperCase().charAt(0);
		scanner.close();
		switch(pressed){
		case 'N': this.newEntry();break;
		case 'V': this.printAll();break;
		case 'Q': return 'Q';
		default: System.out.println("Did not understand command");
		this.control();
		break;
			
		}
		control();
		return 'Q';
	}
}
	
	
