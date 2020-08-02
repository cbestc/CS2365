import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Inventory {
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<Item> reserveList = new ArrayList<Item>();
	
	//could be incorrect - see comment for readFromFile()
	public Inventory() {
		this.readFromFile();
	}
	
	public void writeToFile() {
		try {

			FileOutputStream fos = new FileOutputStream("src\\TestForInv");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i) != null) {
					oos.writeObject(itemList.get(i));
				}
			}
			oos.writeObject(0);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//how does it load the arrayLists without returning a void?
	public void readFromFile()
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
    			itemList.add((Item)input);
    		else
    		{
    			cont = false;
    		}
    	
    	}
    	ois.close();
    	
    	}
    	catch(IOException | ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    }
	
	public boolean reserve(String itemName, int amount) {
		Item temp = new Item(itemName, amount);
		if(this.reserveList.contains(temp)) {
			int index = this.reserveList.indexOf(temp);
			int initQuantity = this.reserveList.get(index).getQuantity();
			this.reserveList.get(index).setQuantity(initQuantity + amount);
			return true;
		}
		else if(!this.reserveList.contains(temp)) {
			this.reserveList.add(temp);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isReserved(String itemName, int amount) {
		return this.reserveList.contains(new Item(itemName, amount));
	}
	
	public boolean removeReserve(String itemName, int amount) {
		Item temp = new Item(itemName, amount);
		int index = this.reserveList.indexOf(temp);
		int initQuantity = this.reserveList.get(index).getQuantity();
		if(this.reserveList.get(index).getQuantity() > amount) {
			this.reserveList.get(index).setQuantity(initQuantity - amount);
			return true;
		}
		else if(this.reserveList.get(index).getQuantity() == amount){
			this.reserveList.remove(index);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String invString = " ";
		for (Item i : itemList) {
			invString.concat("Item:" + i.getName() + ", Price per Unit: " + i.getPrice() + ", Quantity in cart: " + i.getQuantity() +"%n");
		}
		return invString;
	}
}
