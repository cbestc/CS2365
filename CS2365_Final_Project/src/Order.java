public class Order {
	Customer customer;
	Cart orderList;
	double price;
	String status;
	String auth;
	
	//Constructors
	public Order() {
		
	}
	
	public Order(Customer customer) {
		this.customer = customer;
	}
	
	public Order(Customer customer, String status, String auth) {
		this.customer = customer;
		this.orderList = customer.cart; // needs implementation with Item.equals()?
		this.price = customer.cart.getTotal();
		this.status = status;
		this.auth = auth;
	}
	
	//Methods
	public String getInvoice() {
		return this.customer.cart.toString() + "\n" + this.price + "\n" + this.status + "\n";
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public String getAuth() {
		return this.auth;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setAuth(String auth) {
		this.auth = auth;
	}
}