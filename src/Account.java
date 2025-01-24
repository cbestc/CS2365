public class Account {
	String ID;
	String password;
	
	//Constructors
	public Account() {
		
	}
	  
	public Account(String ID, String password) {
		this.ID = ID;
		this.password = password;
	}
	
	//Methods
	public String getID() {
		return this.ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setPass(String pass) {
		this.password = pass;
	}
	public String toString() {
		return this.ID + "\n" + this.password;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Account) {
			Account a = (Account) o;
			return this.ID.equals(a.getID());
		}
		else {
			return false;
		}
	}
}