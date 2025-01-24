import java.util.ArrayList;

public class DeliveryManager {
	static Order selectedOrder;
	static Customer selectedCust;
	static String selectedCCN;
	static double amount;

	public static String processOrder(int orderChoice, Inventory inventory, OrderLog log) {
		selectedOrder = log.orderLog.get(orderChoice - 1);
		selectedCust = selectedOrder.customer;
		selectedCCN = selectedCust.getCCN();
		amount = selectedOrder.getPrice();

		for (Item i : selectedCust.cart.cart) {
			if (inventory.reserve(selectedCust.cart.cart.get(selectedCust.cart.cart.indexOf(i)).getName(),
					selectedCust.cart.cart.get(selectedCust.cart.cart.indexOf(i)).getQuantity()) == true) {
				continue;
			} else {
				return "Item failed to be reserved";
			}
		}
		selectedOrder.setStatus("Ready");
		return "Order has been reserved";

	}

	public static String callOrders(OrderLog log) {
		return log.printOrders();
	}
}
