
public class ShipBillManager {
	OrderLog log;
	Order selectedOrder;
	Customer selectedCust;
	String selectedName;
	String selectedCCN;
	double amount;
	int choice = 1;
	public void draft() {
		log.findReadyOrders();
		System.out.println(log.printReadyOrders());
		
		//scan for choice
		//selected = log.getOrder; 							by customer
		selectedOrder = log.readyOrderLog.get(choice); 	  //by choice number
		
		selectedCust = selectedOrder.customer;
		selectedName = selectedOrder.customer.name;
		selectedCCN = selectedCust.getCCN();
		amount = selectedOrder.getPrice();
		
		//String auth = purchase(selectedCCN, amount)
		//if(auth != NULL) {
		//	removeReserve(all cart items)				and remove from inventory
			selectedOrder.setStatus("shipped");
		//  }											and display auth number	
		//else {
		//		display error bank denied
		//	}	
	}
	
}



class SupplierInteraction {
	
}