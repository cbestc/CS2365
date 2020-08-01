import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    byte exit = 0;
    SelectItems test = new SelectItems(0);
    Customer barry = new Customer();
    
    ArrayList<Item> catalog = new ArrayList<Item>();
    test.readFromFile(catalog);
    barry.readFromFile();
    do{

    
    byte menuC = menuBase();
    
    switch(menuC)
    {
      case(1):
      {
        barry.emptyCart();
        break;
      }
      case(2):
      {
    	barry.printCart();
    	barry.priceTotal();
        break;
      }
      case(3):
      {	
    	int page = 0;
    	int count = 0;
    	String a = "";
    	test.dispCatalog(page,catalog);
    	do 
    	{
        a = test.userInput();
        if(a == "Next")
        {	
        	page++;
        	count = count + 5;
        	if(page > 1)
        	{
        		System.out.println("There are no more pages");
        		System.out.println("Returning you to the last page");
        		page--;
        		count = 5;
        	}
        	test.dispCatalog(page, catalog);
        }
        if(a == "Back")
        {
        	page--;
        	count = count - 5;
        	if(page <= -1)
        	{
        		System.out.println("You cannot go back any further");
        		System.out.println("Returning you to the last page");
        		page++;
        		count = 0;
        	}
        	test.dispCatalog(page, catalog);
        }
        if(a.matches("[0-9]+"))//User Returns a number
        {
        	System.out.println(Integer.parseInt(a));
        	int  b = Integer.parseInt(a);
      	  switch(b)
    		{
    		case(1):
    		{
    			
    			barry.addToCart(new Item(1.99, "Screws", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		case(2):
    		{
    			
    			barry.addToCart(new Item(2.99, "Nails", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		case(3):
    		{
    			
    			barry.addToCart(new Item(3.99, "Hammer", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		case(4):
    		{
    			
    			barry.addToCart(new Item(4.99, "Paint", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		case(5):
    		{
    			
    			barry.addToCart(new Item(5.99, "Rags", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		case(6):
    		{
    			
    			barry.addToCart(new Item(6.99, "Drill", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		case(7):
    		{
    			
    			barry.addToCart(new Item(7.99, "Extension Cord", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		case(8):
    		{
    			
    			barry.addToCart(new Item(8.99, "Hair Ties", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		case(9):
    		{
    			
    			barry.addToCart(new Item(9.99, "Phone", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		case(10):
    		{
    			
    			barry.addToCart(new Item(10.99, "Tooth Paste", 1));
    			System.out.println("Item Added to your cart");
    			//test.changeInv(b, catalog);
    			
    			break;
    		}
    		default:
    			System.out.println("Error, Returning to last page...");
    		}
        	test.dispCatalog(page, catalog);
        }
        }while(a != "Exit" && a!= "exit");
        break;
      }
      case(4):
      {
    	
        break;
      }
      case(5):
      {
    	barry.writeToFile();
    	test.writeToFile(catalog);
        exit = 1;
        break;
      }
      case(6):
      {
    	  barry.popCart();
    	  break;
      }
    }
    }while(exit != 1);
  }

  //Beginning of Methods
  private static byte menuBase()
  {
    System.out.println("---------------------------------");
    System.out.println("What would you like to do?");
    System.out.println("1. Does Nothing LOL");
    System.out.println("2. Check Cart");
    System.out.println("3. Select Items");
    System.out.println("4. Make Order Request");
    System.out.println("5. Exit");
    System.out.println("6. Pop an item from the cart");
    System.out.println("7. ");
    System.out.println("---------------------------------");
    byte choice;
    Scanner in = new Scanner(System.in);

    do
    {
      choice = in.nextByte();
      if (choice < 1 || choice > 9)
      {
        System.out.println("That is not a valid choice");
        System.out.println("Please Try Again");
        choice = in.nextByte();
      }
    }while(choice < 1 || choice > 9);
    return choice;
  }
}

class SelectItems
  {
    //Variables
    private int selection;
    
    Scanner in = new Scanner(System.in);
    //Constructors
    public SelectItems()
    {

    }

    public SelectItems(int selection)
    {
      this.selection = selection;
      
    }

    //Methods
    /*
	   * Name: 
	   * Purpose:
	   * Comment:
	   * Returns:
	 */
    public void setSelection(int selection)
    {
      this.selection = selection;
    }
    
    public int getSelection()
    {
      return selection;
    }
    /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
    public String userInput()
    {
    	
      System.out.println("What would you like to do?");
      System.out.println("Next Page, Back Page, Select an Item by Number, Exit");
      String userIn;
      userIn = in.nextLine().toUpperCase();
      
      
      if(userIn.equals("NEXT PAGE"))
      {
        System.out.println("You selected Next Page");
        return "Next";
      }
      else if(userIn.equals("BACK PAGE"))
      {
        System.out.println("You selected Back Page");
        return "Back";
      }
      else if(userIn.matches("[0-9]+"))
      {
    	  return userIn;
      }
      else if(userIn.equals("EXIT"))
      {
        System.out.println("You selected Exit");
        return "Exit";
      }
      else
      {
        System.out.println("That input was invalid.");
      }
      return "";
    }
  
    /*
    Function: getCatalog
	Purpose: Displays the Catalog in the console
	Parameters: Int Page (For page counter), Int Count (for item counter)
	Returns: N/A (Void Function
    */
    public Item[] getCatalog() 
    {
      int count = 0;
      Item[] catalog = new Item[10];
      try
      {     
      Scanner nameIn = new Scanner(new File("src\\Naming"));
      Scanner priceIn = new Scanner(new File("src\\Pricing"));
      Scanner invIn = new Scanner(new File("src\\Inventory"));
      String nameOut = nameIn.nextLine();
      String priceOut = priceIn.nextLine();
      String invOut = invIn.nextLine();
 
      while(count < 10)
      {
    	catalog[count] = new Item(Double.parseDouble(priceOut), nameOut, Integer.parseInt(invOut));
        count++;
        nameOut = nameIn.nextLine();
        priceOut = priceIn.nextLine();
        invOut = invIn.nextLine();
      }
      
      
      
      //nameIn.close();
      //priceIn.close();
      }
      catch(IOException E)
      {
        E.printStackTrace();
      }
      return catalog;
    }
    
    public void dispCatalog(int page, ArrayList<Item> catalog)
    {
    	for(int i = 0+(5*page); i < 5+(5*page); i++)
    	{
    		System.out.println(i+1 + ". " + catalog.get(i).getName() + " $" + catalog.get(i).getPrice()/* + " " + catalog[i].getQuantity() + " Left"*/);
    	}
    }
    
    public void writeToFile(ArrayList<Item> catalog)
    {
    	try
    	{
    	
    	FileOutputStream fos = new FileOutputStream("src\\TestForInv");
    	ObjectOutputStream oos = new ObjectOutputStream(fos);
    	for(int i = 0; i < catalog.size(); i++)
    		{
    			if(catalog.get(i) != null)
    			{
    			oos.writeObject(catalog.get(i));
    			}
    		}
    		oos.writeObject(0);
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void readFromFile(ArrayList<Item> catalog)
    {
    	try
    	{
    	FileInputStream fis = new FileInputStream("src\\TestForInv");
    	ObjectInputStream ois = new ObjectInputStream(fis);
    	Object input;
    	boolean cont = true;
    	while(cont)
    	{
    		input = ois.readObject();
    		if(!input.equals(0))
    		{
    			System.out.println(1);
    			catalog.add((Item)input);
    		}
    		else
    		{
    			cont = false;
    		}
    	
    	}
    	
    	
    	}
    	catch(IOException | ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	
    }
    }
    
    public void changeInv(int num, Item[] catalog)
    {
    	catalog[num-1].decQuantity();
    }

  }

  
  class Customer
  {
    //variables
    private ArrayList<Item> cart;
    CC payment;
    private String custID;
    

    //Constructors
    public Customer()
    {
    	cart = new ArrayList<Item>();
    	
    }

    public Customer(ArrayList<Item> cart)
    {
    	
    	this.cart = cart;
      
    }

    //Methods
    public void setCustID(String custID)
    {
    	this.custID = custID;
    }
    
    public String getCustID()
    {
    	return custID;
    }
    /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
    public ArrayList<Item> getCart()
    {
      return cart;
    }
    /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
    public void printCart()
    {
    	for(Item i: cart)
    	{
    		System.out.println("Your cart has: " + i.getQuantity() + " Of: " +i.getName());
    	}
    }
    
    /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
    public void addToCart(Item in)
    {
    	int a = 0;
    	for(int i = 0; i < cart.size(); i++)
    	{
    		
    		if(in.getName().equals(cart.get(i).getName()))
    		{
    			cart.get(i).incQuantity();
    			a++;
    		}
    	}
    	if(a == 0)
    	cart.add(in);
    }
    /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
    public void priceTotal()
    {
    	double totalPrice = 0;
    	for(int i = 0; i < cart.size(); i++)
    	{
    		totalPrice = totalPrice + (cart.get(i).getPrice()*cart.get(i).getQuantity());
    	}
    	System.out.println("Your Carts total is: " + totalPrice);
    }
   
    /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
   public void emptyCart()
   {
   	cart.clear();
   }
   /*
    * Name: 
    * Purpose:
    * Comment:
    * Returns:
   */
    public void writeToFile()
    {
    	try
    	{
    	
    	FileOutputStream fos = new FileOutputStream("src\\Cart");
    	ObjectOutputStream oos = new ObjectOutputStream(fos);
    	for(int i = 0; i < cart.size(); i++)
    		{
    			if(cart.get(i) != null)
    			{
    			oos.writeObject(cart.get(i));
    			}
    		}
    		oos.writeObject(0);
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
    public void readFromFile()
    {
    	try
    	{
    	FileInputStream fis = new FileInputStream("src\\Cart");
    	ObjectInputStream ois = new ObjectInputStream(fis);
    	Object input;
    	boolean cont = true;
    	while(cont)
    	{
    		input = ois.readObject();
    		if(!input.equals(0))
    		cart.add((Item)input);
    		else
    		{
    			cont = false;
    		}
    	
    	}
    	
    	
    	}
    	catch(IOException | ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void popCart()
    {
    	Scanner in = new Scanner(System.in);
    	System.out.println("What item would you like to remove?");
    	System.out.println("Type -1 to leave.");
    	int count = 0;
    	for(Item b : cart)
    	{
    		System.out.println(count + ". " + cart.get(count).getName());
    		count++;
    	}
    	String a;
    	
    	
    	int exit = 0;
    	while(exit != -1)
    	{
    		a = in.nextLine();
    		if(Integer.parseInt(a) == -1)
    		{
    			exit = -1;
    		}
    		else
    		{
    		if(cart.get(Integer.parseInt(a)).getQuantity() == 1)
    		{
    			cart.remove(Integer.parseInt(a));
    			System.out.println("Item Successfully removed!");
    		}
    		else 
    		{
    			cart.get(Integer.parseInt(a)).decQuantity();
    		}
    		}
    	}
    }
  }


  class Item implements Serializable
  {
    //Variables
	private static final long serialVersionUID = 1L;
    private double price;
    private String name;
    private int quantity;//Quantity of items in the cart?? :)
    //Constructors
    public Item()
    {
    	
    }

    public Item(double price, String name, int quantity)
    {
      this.price = price;
      this.name = name;
      this.quantity = quantity;
    }

    //Methods
    public double getPrice()
    {
      return price;
    }
    public void setPrice(double price)
    {
      this.price = price;
    }

    public String getName()
    {
      return name;
    }
    public void setName(String name)
    {
      this.name = name;
    }

    public int getQuantity()
    {
      return quantity;
    }
    public void setQuantity(int quantity)
    {
      this.quantity = quantity;
    }
    
    public void incQuantity()
    {
    	quantity++;
    }
    
    public void decQuantity()
    {
    	quantity--;
    }
  }
  
  
  class CC
  {
	  //Variables
	  private String num;
	  private double left;
	  private double limit;
	  //Constructors
	  public CC()
	  {
		  
	  }
	  
	  public CC(String num, double left, double limit)
	  {
		  this.num = num;
		  this.left = left;
		  this.limit = limit;
	  }
	  //Methods
	  /*
	  	Name: Set Number
	   	Purpose: Setter for Credit Card Number
	   	Comment: N/A
	   	Returns: N/A
	   */
	  public void setNum(String num)
	   {
		   this.num = num;
	   }
	   /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
	   public String getNum()
	   {
		   return num;
	   }
	   /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
	   public void setLeft(double left)
	   {
		   this.left = left;
	   }
	   /*
	    * Name: 
	    * Purpose:
	    * Comment:
	    * Returns:
	   */
	   public double getLeft()
	   {
		   return left;
	   }
	   
	   public void setLimit(double limit)
	   {
		   this.limit = limit;
	   }
	   
	   public double getLimit()
	   {
		   return limit;
	   }
  }
  
  class Order
  {
	  //variables
	  ArrayList<Item> ordered = new ArrayList<Item>();
	  
	  private String auth;
	  private String status;
	  //constructors
	  public Order()
	  {
		  
	  }
	  
	  public Order(String auth, String status)
	  {
		  
		  this.auth = auth;
		  this.status = status;
	  }
	  
	  //methods
	  public void addToOrdered(ArrayList<Item> cart)
	  {
		//Set Authorization Number Here
		  for(int i = 0; i < cart.size(); i++)
		  {
			  ordered.add(cart.get(i));
		  }
	  }
  }
  
  class OrderRequest
  {
	  //Variables
	  ArrayList<Order> OrderDetails = new ArrayList<Order>();
	  
	  //Constructors
	  
	  //Methods
	  public void orderRequest(ArrayList<Item> cart, Customer customer, CC cc, Order order)
	  {
		  Scanner in = new Scanner(System.in);
		  System.out.println("Here is your cart and it's total:");
		  customer.printCart();
		  customer.priceTotal();
		  int exit = 0;
		  //BANK NEEDS TO CONFIRM STUFF HERE
		  while(exit != 1)
		  {
		  if(checkBank() == 1)
		  {
			  order.addToOrdered(cart);
			  exit = 1;
		  }
		  else
		  {
			  
			  String a;
			  System.out.println("Your card was declined");
			  
				  System.out.println("Would you like to enter a new credit card number? ");
				  System.out.println("1 for yes, 0 for no");
				  a = in.nextLine();
				  if(Integer.parseInt(a) == 1)
				  {
					  String num = "";
					  num = in.nextLine();
					  cc.setNum(num);
				  }
				  else
				  {
					  exit = 1;
				  }
			  }
		  }
	  }
	  
	  public int checkBank()
	  {
		  return 0;
	  }
	  
	  
  }
  //TODO
  /*
  Things to do for Make Order Request: 
  Make Credit Card Object, needs to have total spending left
  And a Number associated with it.
  Status: Done
  Make a Delivery Order Object, needs to have: 
  Authorization Number, and an Order Status.
  Status: Done
  Make a menu to print the Order Information to Customer.
  Status: Started, Not Finished
  If card fails, make Customer ReEnter CC, or Cancel Order.
  Status: Done
  
  Things to do for Select Item:
  Remove Spaces from the User input section :)
 
 
 DO SOMETHING NICE FOR LANDON AND DOMINIC WHEN YOU ARE DONE
   
  */