import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectItems {
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
       
    public void dispCatalog(int page, ArrayList<Item> catalog)
    {
    	
    for(int i = 0+(5*page); i < 5+(5*page); i++)
    	{
    		System.out.println(i+1 + ". " + catalog.get(i).getName() + " $" + catalog.get(i).getPrice());
    	}
    	
    	//System.out.println("I am totally working :)");
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
