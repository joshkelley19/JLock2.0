package Backend;

public class JLockEntry {
	
	private String siteName;
	private String siteUser;
	private String sitePassword;
	private int entryID;
	
	public JLockEntry(String name, String user, String pass, int entryID){
		this.siteName=name;
		this.siteUser=user;
		this.sitePassword=pass;
		//how to access list length of current profile
		this.entryID=entryID;
		
	}
	public String toString(){
	return "Entry #: " + entryID + ", Site: " + siteName + ", User Name: " + siteUser + ", Password: " + sitePassword;
	}
	
}
