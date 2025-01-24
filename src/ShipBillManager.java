
public class ShipBillManager{
	//static Inventory inventory;
	//static OrderLog log;
	static Order selectedOrder;
	static Customer selectedCust;
	//static String selectedName;
	static String selectedCCN;
	static double amount;
	//int choice = 1;
	
	
	public static String readyOrders(OrderLog log) {
		log.findReadyOrders();
		return log.printReadyOrders();
	}
	
	
	public static String confirmShipment(int orderChoice, Bank bank, Inventory inventory, OrderLog log) {
		
		
		selectedOrder = log.readyOrderLog.get(orderChoice - 1); 	  //by choice number
		selectedCust = selectedOrder.customer;
		//selectedName = selectedOrder.customer.getName();
		selectedCCN = selectedCust.getCCN();
		amount = selectedOrder.getPrice();
		
		String authString = bank.purchase(selectedCCN, amount);
		if(authString != "N/A") {
			inventory.commitOrder(selectedCust.cart.cart);
			//selectedCust.cart.emptyCart();				//and remove from inventory
			selectedOrder.setStatus("shipped");
			selectedOrder.setAuth(authString);
			return authString;
		}											//and display auth number	
		else {
			//display error bank denied
			return "denied";
		}
	}
}