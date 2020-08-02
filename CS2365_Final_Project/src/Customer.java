public class Customer extends Account {
	String name;
	String address;
	String phone;
	String credit;
	Cart cart;
	
	//Constructors
	public Customer() {
		
	}
		
	public Customer(String ID, String password, String name, String address, String phone, String credit, Cart cart) {
		super(ID, password);
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.credit = credit;
		this.cart = cart;
	}
	
	public Customer(String ID, String password, String name, String address, String phone, String credit) {
		super(ID, password);
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.credit = credit;
		this.cart = new Cart();
	}
	
	//Methods
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getCCN() {
		return this.credit;
	}
	
	public String getCart() {
		return this.cart.toString();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setCCN(String credit) {
		this.credit = credit;
	}
	
	public void setCart(Cart cart) { // needs implementation
		this.cart = cart;
	}
	
	public String toString() {
		return this.ID + "\n" + this.password + "\n" + this.name + "\n" + this.address + "\n" + this.phone + "\n" + this.credit + "\n" + this.cart.toString() + "\n";
	}
	
	public boolean equals(Object o) {
		if(o instanceof Customer) {
			Customer c = (Customer) o;
			return this.ID.equals(c.getID());
		}
		else {
			return false;
		}
	}
}