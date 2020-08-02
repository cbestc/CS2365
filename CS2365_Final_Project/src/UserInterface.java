import java.util.*;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * -----------Initialize---------------
		 * Scanner
		 * Catalog via object file
		 * Inventory via object file
		 * Customer Array via object file(?)
		 * Supplier Array via object file(?)
		 * Bank via object file
		 * -----------Initalize empty----------
		 * Order log (order arraylist)
		 * -----------Begin Menu---------------
		 * Show login menu
		 * Get login info via scanner
		 * Test if account with same login, password exists already in account array
		 * If not, ask if customer or supplier
		 * If customer, get Customer args and create customer, add to array
		 * If supplier, get Supplier args and create supplier, add to array
		 * Continue to specific menus
		 */
		Scanner sc = new Scanner(System.in);
		String userInput;
		Inventory inv = new Inventory();
		//Fill the inventory
		String catalog = ""; //Needs to be initalized from catalog object file
		//Fill the catalog
		ArrayList<Customer> custAccs = new ArrayList<Customer>();
		//Fill the customer accounts from our text file
		ArrayList<Supplier> suppAccs = new ArrayList<Supplier>();
		//Fill the supplier accounts from our text file
		Bank bank = new Bank();
		//Fill the bank from our object file 
		OrderLog listOfOrder = new OrderLog();
		//Initalize user accounts
		Customer cust;
		Supplier supp;
		String username;
		String pass;
		//initalize the text file that orderLog is reading from
		int loop = 1;
		while(loop != 0){
			System.out.println("Select option");
			System.out.println("1:Log in");
			System.out.println("2:Create Account");
			System.out.println("3:Exit");
			String option = sc.nextLine();
			if(option == "1") {
				System.out.println("Log in");
				System.out.println("Enter username:");
				username = sc.nextLine();
				System.out.println("Enter password");
				pass = sc.nextLine();
				//int loginType = login(username, pass)
				//If login = 1 (Customer case)
				//pull remaining customer info from text file
				//cust = new Customer(customer info)
				//call customer menu options
				System.out.println("Customer menu");
				System.out.println("1:View Catalog");
				System.out.println("2:Make Order Request");
				System.out.println("3:View Order");
				System.out.println("4:Logout");
				userInput = sc.nextLine();
				while(userInput != "4") {
					//switch case containing all customer menu options
				}
				//loop back
				
				//ElseIf login = 2 (Supplier case)
				//pull remaining supplier info from text file
				//supp = new Supplier(supplier info)
				//call supplier menu options
				System.out.println("Supplier menu");
				System.out.println("1:Confirm Shipments");
				System.out.println("2:Process Delivery Order");
				System.out.println("3:Logout");
				userInput = sc.nextLine();
				while(userInput != "3") {
					//switch case containing all supplier menu options
				}
				//loop back
				
				//Elseif login = -1 (info does not exist)
				//Display information
			}
			else if(option == "2") {
				int createOption = 1;
				while(createOption != 0) {
					System.out.println("Customer or Supplier account? %n 1:Customer %n 2:Supplier");
					String choice = sc.nextLine();
					if(choice == "1") {
						System.out.println("Enter new userID:");
						username = sc.nextLine();
						//check account database if username already exists
						//If so, output error and return to while loop
						//If not, ask for next data
						System.out.println("Enter new password:");
						pass = sc.nextLine();
						//Output that account has been created
						System.out.println("Enter name:");
						String name = sc.nextLine();
						System.out.println("Enter address:");
						String address = sc.nextLine();
						System.out.println("Enter phone number:");
						String phoneNum = sc.nextLine();
						System.out.println("Enter credit card number:");
						String CCN = sc.nextLine();
						//Validate that CCN exists
						int ccnIndex = bank.doesCCNExist(CCN);
						if(ccnIndex > 0) {
							cust = new Customer(username, pass,name, address, phoneNum, CCN);
							System.out.println("Account created");
							createOption = 0;
							//exit to main menu
						}
						else {
							CreditCard newCredit = new CreditCard(CCN);
							bank.cardList.add(newCredit);
							System.out.println("Account Created");
							createOption = 0;
							//exit to main menu
						}
					}
					else if(choice == "2") {
						System.out.println("Enter new userID:");
						username = sc.nextLine();
						//check account database if username already exists
						//If so, output error and return to while loop
						//If not, ask for next data
						System.out.println("Enter new password:");
						pass = sc.nextLine();
						//Output that account has been created
						createOption = 0;
					}
					else {
					System.out.println("User input was not an above option. Please try again.");
					}
				}
			}
			else if(option == "3") {
				loop = 0;
				return;
			}
			else {
				System.out.println("User input was not an above option. Please try again.");
			}
			//loops out
		}
			
		
		
		/*
		 * -----------------CUSTOMER MENUS-------------------
		 * Show customer menu
		 * Logout
		 * Browse Catalog
		 * Make Order request
		 * View Order
		 */
		
		/*-----------------Logout----------------
		 * Return to Begin Menu
		 */
		
		/*---------------Browse Catalog----------
		 * Display catalog
		 * Get what item they want to select and quantity
		 * Call SELECT ITEM use case
		 * create instance of item
		 * add to customer cart
		 */
		
		/*
		 * ---------------Make Order Request-------------
		 * Confirm customer input
		 * Create an Order using Customer's cart
		 * pass Order and Customer ID, Password to Order Manager
		 * Have Order manager do it's magic
		 */
		
		/*
		 * --------View Order---------
		 * Check if Customer Order exists
		 * Return order invoice in Order
		 */
		
		/*------------------SUPPLIER MENU---------------------
		 * Process Delivery Order
		 * Confirm Shipment
		 */
	}
	
}
