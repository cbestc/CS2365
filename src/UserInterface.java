import java.util.Scanner;
import java.util.ArrayList;

//For creating a Customer Account - use number of "unusedCCN", since it is not used by credit cards currently in database
//For creating a Supplier Account - use anything other than test Supplier Class

public class UserInterface {
	static Scanner userIn = new Scanner(System.in);
	public static Customer currentCust;
	public static Supplier currentSupp;
	public static Customer testCust = new Customer("1234", "password", "John", "my address", "my phone",
			"1111222233334444");
	public static Supplier testSupp = new Supplier("1111", "password");
	public static CreditCard testCCN = new CreditCard("1111222233334444", 2000.00, 25.25);
	//THIS IS THE CARD THAT HASNT BEEN USED - USED FOR AN ACCOUNT CREATION
	public static CreditCard unusedCCN = new CreditCard("1234123412341234", 2000.00, 25.25);
	public static Bank testBank = new Bank();
	public static ArrayList<Customer> custArray = new ArrayList<Customer>();
	public static ArrayList<Supplier> suppArray = new ArrayList<Supplier>();
	public static ArrayList<Item> catalog = new ArrayList<Item>();
	public static SelectItems catalogList = new SelectItems();
	public static Inventory testInv = new Inventory();
	public static Item testItem = new Item(2.25, "Apple", 40);
	public static OrderLog testOrderLog = new OrderLog();
	public static Order testOrder;

	public static void main(String args[]) {
		thisIsTheEntireExecution();
	}

	public static void thisIsTheEntireExecution() {
		// init databases
		testBank.cardList.add(testCCN);
		testInv.itemList.add(testItem);
		testInv.itemList.add(new Item(1.75, "Orange", 20));
		testInv.itemList.add(new Item(3.75, "Grape", 25));
		testInv.itemList.add(new Item(0.75, "Melon", 100));
		testInv.itemList.add(new Item(10.00, "Pumpkin", 5));
		testInv.itemList.add(new Item(2.25, "Mango", 10));
		testItem.setQuantity(1);
		catalog.add(testItem);
		catalog.add(new Item(1.75, "Orange", 1));
		catalog.add(new Item(3.75, "Grape", 1));
		catalog.add(new Item(0.75, "Melon", 1));
		catalog.add(new Item(10.00, "Pumpkin", 1));
		catalog.add(new Item(2.25, "Mango", 1));
		custArray.add(testCust);
		suppArray.add(testSupp);
		testBank.cardList.add(testCCN);
		//THIS IS THE CARD THAT HASNT BEEN USED - USED FOR AN ACCOUNT CREATION
		testBank.cardList.add(unusedCCN);
		int isExit = 0;
		while (isExit == 0) {
			mainMenu();
		}

	}

	public static void mainMenu() {
		System.out.println("Select option:");
		System.out.println("1:Log In");
		System.out.println("2:Create Account");
		System.out.println("3:Exit Program");
		int isExit = 0;
		int userInput = 0;
		while (isExit != 3) {
			userInput = userIn.nextInt();
			switch (userInput) {
			case (1):
				logIn();
				break;
			case (2):
				createAccount();
				break;
			case (3):
				System.exit(0);
				break;
			}
		}
	}

	public static void logIn() {
		System.out.println("Select option:");
		System.out.println("1:Customer Log In");
		System.out.println("2:Supplier Log In");
		System.out.println("3:Back");
		int isExit = 0;
		int userInput = 0;
		while (isExit == 0) {
			userInput = userIn.nextInt();
			switch (userInput) {
			case (1):
				customerLogIn();
				break;
			case (2):
				supplierLogIn();
				break;
			case (3):
				isExit = 3;
				break;
			}
		}
		mainMenu();
	}

	public static void customerLogIn() {
		String inUser;
		String inPass;
		System.out.println("Enter userID:");
		userIn.nextLine();
		inUser = userIn.nextLine();
		System.out.println("Enter password:");
		inPass = userIn.nextLine();
		Customer temp = new Customer();
		temp.setID(inUser);
		temp.setPass(inPass);
		if (custArray.contains(temp)) {
			currentCust = custArray.get(custArray.indexOf(temp));
			customerMenu();
		} else {
			System.out.println("Invalid userID or password.");
			customerLogIn();
		}
	}

	public static void supplierLogIn() {
		String inUser;
		String inPass;
		System.out.println("Enter userID:");
		userIn.nextLine();
		inUser = userIn.nextLine();
		System.out.println("Enter password:");
		inPass = userIn.nextLine();
		Supplier temp = new Supplier();
		temp.setID(inUser);
		temp.setPass(inPass);
		if (suppArray.contains(temp)) {
			currentSupp = suppArray.get(suppArray.indexOf(temp));
			supplierMenu();
		} else {
			System.out.println("Invalid userID or password.");
			supplierLogIn();
		}
	}

	public void logOut() {
		System.out.println("Logging out..");
		currentCust = new Customer();
		currentSupp = new Supplier();
		mainMenu();
	}

	public static void createAccount() {
		System.out.println("Select option:");
		System.out.println("1:CreateCustomer Account");
		System.out.println("2:Create Supplier Account");
		System.out.println("3:Back");
		int isExit = 0;
		int userInput = 0;
		while (isExit == 0) {
			userInput = userIn.nextInt();
			switch (userInput) {
			case (1):
				createCustomerAccount();
			case (2):
				createSupplierAccount();
			case (3):
				isExit = 3;
			}
		}
		mainMenu();
	}

	public static void createCustomerAccount() {
		Customer temp = new Customer();
		String a = userIn.nextLine();
		System.out.print("Username: ");
		a = userIn.nextLine();
		while (a.isEmpty()) {
			System.out.println("This cannot be empty");
			System.out.print("Username: ");
			a = userIn.nextLine();
		}
		if (a == "B") {
			createAccount();
		}
		temp.setID(a);
		System.out.println();
		System.out.print("Password: ");
		a = userIn.nextLine();
		while (a.isEmpty()) {
			System.out.println("This cannot be empty");
			System.out.print("Password: ");
			a = userIn.nextLine();
		}
		temp.setPass(a);
		System.out.println();
		System.out.print("Name: ");
		a = userIn.nextLine();
		while (a.isEmpty()) {
			System.out.println("This cannot be empty");
			System.out.print("Username: ");
			a = userIn.nextLine();
		}
		temp.setName(a);
		System.out.println();
		System.out.print("Address: ");
		a = userIn.nextLine();
		while (a.isEmpty()) {
			System.out.println("This cannot be empty");
			System.out.print("Address: ");
			a = userIn.nextLine();
		}
		temp.setAddress(a);
		System.out.println();
		System.out.print("Phone: ");
		a = userIn.nextLine();
		while (a.isEmpty()) {
			System.out.println("This cannot be empty");
			System.out.print("Phone: ");
			a = userIn.nextLine();
		}
		temp.setPhone(a);
		System.out.println();
		System.out.print("Credit Card Number: ");
		a = userIn.nextLine();
		while (a.isEmpty()) {
			System.out.println("This cannot be empty");
			System.out.print("Credit Card Number: ");
			a = userIn.nextLine();
		}
		temp.setCCN(a);
		System.out.println();

		if (!custArray.contains(temp)) {
			custArray.add(temp);
			System.out.println("Account created");
			mainMenu();
		} else {
			System.out.println("Customer userID/CCN already in use");
			createCustomerAccount();
		}
	}

	public static void createSupplierAccount() {
		System.out.println("Enter new userID:");
		Supplier temp = new Supplier();
		String a = userIn.nextLine();
		System.out.print("Username: ");
		a = userIn.nextLine();
		while (a.isEmpty()) {
			System.out.println("This cannot be empty");
			System.out.print("Username: ");
			a = userIn.nextLine();
		}
		temp.setID(a);
		System.out.println();

		System.out.print("Password: ");
		a = userIn.nextLine();
		while (a.isEmpty()) {
			System.out.println("This cannot be empty");
			System.out.print("Password: ");
			a = userIn.nextLine();
		}
		temp.setPass(a);
		System.out.println();

		if (!suppArray.contains(temp)) {
			suppArray.add(temp);
			System.out.println("Account created");
			mainMenu();
		} else {
			System.out.println("Supplier userID already in use");
			createSupplierAccount();
		}
	}

	public static void customerMenu() {
		System.out.println("Select option:");
		System.out.println("1:View Catalog");
		System.out.println("2:View Current Cart");
		System.out.println("3:Remove an Item from my cart");
		System.out.println("4:Make Order Request");
		System.out.println("5:View Current Order Status");
		System.out.println("6:Log Out");
		int isExit = 0;
		int userInput = 0;
		while (isExit == 0) {
			userInput = userIn.nextInt();
			switch (userInput) {
			case (1):
				viewCatalog();
				break;
			case (2):
				viewCart();
				break;
			case (3):
				deleteItem();
				break;
			case (4):
				makeOrderRequest();
				break;
			case (5):
				viewOrderStatus();
				break;
			case (6):
				isExit = 5;
				break;
			}
		}
		logIn();
	}

	public static void viewCatalog() {
		int page = 0;
		int count = 0;
		String a = "";
		catalogList.dispCatalog(page, catalog);
		do {
			a = catalogList.userInput();
			if (a == "Next") {
				page++;
				count = count + 5;
				if (page > 1) {
					System.out.println("There are no more pages");
					System.out.println("Returning you to the last page");
					page--;
					count = 5;
				}
				catalogList.dispCatalog(page, catalog);
			}
			if (a == "Back") {
				page--;
				count = count - 5;
				if (page <= -1) {
					System.out.println("You cannot go back any further");
					System.out.println("Returning you to the last page");
					page++;
					count = 0;
				}
				catalogList.dispCatalog(page, catalog);
			}
			if (a.matches("[0-9]+"))// User Returns a number
			{
				System.out.println(Integer.parseInt(a));
				int b = Integer.parseInt(a);

				Item temp = new Item();
				temp = catalog.get(b - 1);
				currentCust.cart.addToCart(temp);
				catalogList.dispCatalog(page, catalog);
			}
		} while (a != "Exit" && a != "exit");
		customerMenu();
	}

	public static void viewCart() {
		for (Item i : currentCust.cart.cart) {
			System.out.println("Your cart has: " + i.getQuantity() + " Of: " + i.getName());
		}
		customerMenu();
	}

	public static void deleteItem() {

		int a;
		int exit = 0;
		while (exit != -1) {
			int count = 0;
			for (Item b : currentCust.cart.cart) {
				System.out.println(count + ". " + currentCust.cart.cart.get(count).getName());
				count++;
			}
			System.out.println("What item would you like to remove?");
			System.out.println("Type -1 to leave.");
			a = userIn.nextInt();
			if (a == -1) {
				exit = -1;
			} else {
				if (currentCust.cart.cart.get(a).getQuantity() == 1) {
					currentCust.cart.cart.remove(a);
					System.out.println("Item Successfully removed!");
				} else {
					currentCust.cart.cart.get(a).decQuantity();
				}
			}
		}
		customerMenu();
	}

	public static void makeOrderRequest() {
		System.out.println("Here is your cart and it's total:");
		currentCust.cart.printCart();
		currentCust.cart.priceTotal();
		
		int exit = 0;
		// BANK NEEDS TO CONFIRM STUFF HERE
		while (exit != 1) {
			if (testBank.authorize(currentCust.getCCN(), currentCust.cart.getTotal()) == 1) {
				testOrder = new Order(currentCust);
				testOrderLog.addOrder(testOrder);
				exit = 1;
			} else {

				String a;
				System.out.println("Your card was declined");

				System.out.println("Would you like to enter a new credit card number? ");
				System.out.println("1 for yes, 0 for no");
				a = userIn.nextLine();
				if (Integer.parseInt(a) == 1) {
					String num = "";
					num = userIn.nextLine();
					CreditCard temp = new CreditCard(num);
					temp.setCCN(num);
				} else {
					exit = 1;
				}
			}
		}
		System.out.println("Order Confirmed!");
		customerMenu();
	}

	public static void viewOrderStatus() {
		System.out.println(testOrder.getInvoice());
		customerMenu();
	}

	public static void supplierMenu() {
		System.out.println("Select option:");
		System.out.println("1:Process Delivery Order");
		System.out.println("2:Confirm Order Shipment");
		System.out.println("3:Log Out");
		int isExit = 0;
		int userInput = 0;
		while (isExit == 0) {
			userInput = userIn.nextInt();
			switch (userInput) {
			case (1):
				processDeliveryOrder();
				break;
			case (2):
				confirmShipment();
				break;
			case (3):
				isExit = 5;
				break;
			}
		}
		logIn();
	}

	public static void processDeliveryOrder() {
		System.out.println("\n----------------PROCESS DELIVERY------------------");
		
		System.out.println("The following orders have been made:");
		String readylist = DeliveryManager.callOrders(testOrderLog);
		System.out.println(readylist);
		
		System.out.println("Select an order to process");
		int orderChoice = userIn.nextInt();
		String processStatus = DeliveryManager.processOrder(orderChoice, testInv, testOrderLog);
		System.out.println(processStatus);
		supplierMenu();
		
	}

	public static void confirmShipment() {
		System.out.println("\n----------------CONFIRM SHIPMENT------------------");
		
		System.out.println("The following orders are ready:");
		String readylist = ShipBillManager.readyOrders(testOrderLog);
		System.out.println(readylist);
		
		
		System.out.println("Select an order to confirm the shipment.");
		int orderChoice = userIn.nextInt();
		String orderAuth = ShipBillManager.confirmShipment(orderChoice, testBank, testInv, testOrderLog);
		if (orderAuth != "denied") {
			System.out.println("\nOrder shipment is confirmed!\nConfirmation Number:" + orderAuth);
			testOrderLog.readyOrderLog.clear();
		}
		else {
			System.out.println("\nError! Bank denied charging the amount. Order shipment not confirmed.\n");
		}
		supplierMenu();
	}

}
