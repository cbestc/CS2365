public class Supplier extends Account {
	//Constructors
	public Supplier() {
		
	}
	
	public Supplier(String ID, String password) {
		super(ID, password);
	}
	
	public boolean equals(Object o) {
		if(o instanceof Supplier) {
			Supplier s = (Supplier) o;
			return this.ID.equals(s.getID());
		}
		else {
			return false;
		}
	}
}