import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Cart {
	ArrayList<Item> cart;

	public Cart() {
		cart = new ArrayList<Item>();
	}

	public Cart(ArrayList<Item> cart) {
		this.cart = cart;
	}

	public void printCart() {
		for (Item i : cart) {
			System.out.println("Your cart has: " + i.getQuantity() + " Of: " + i.getName());
		}
	}
	
	public void addToCart(Item in) {
		int a = 0;
		for (int i = 0; i < cart.size(); i++) {

			if (in.getName().equals(cart.get(i).getName())) {
				cart.get(i).incQuantity();
				a++;
			}
		}
		if (a == 0)
			cart.add(in);
	}

	public void priceTotal() {
		double totalPrice = 0;
		for (int i = 0; i < cart.size(); i++) {
			totalPrice = totalPrice + (cart.get(i).getPrice() * cart.get(i).getQuantity());
		}
		System.out.println("Your Carts total is: " + totalPrice);
	}
	
	public double getTotal() {
		double totalPrice = 0;
		for (int i = 0; i < cart.size(); i++) {
			totalPrice = totalPrice + (cart.get(i).getPrice() * cart.get(i).getQuantity());
		}
		return totalPrice;
	}
	
	public void emptyCart() {
		cart.clear();
	}

	public void writeToFile() {
		try {

			FileOutputStream fos = new FileOutputStream("src\\Cart");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i) != null) {
					oos.writeObject(cart.get(i));
				}
			}
			oos.writeObject(0);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
    	ois.close();
    	
    	}
    	catch(IOException | ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    }
	
	@Override
	public String toString() {
		String cartString = "";
		for (Item i : cart) {
		cartString = cartString + ("\nItem: " + i.getName() + "\tPrice per unit: " + i.getPrice() + "\tQuantity in cart: " + i.getQuantity());
		}
		return cartString;
	}
	
	public void popCart(int index)
	{
		if(cart.get(index).getQuantity() > 1)
		{
			cart.get(index).setQuantity(cart.get(index).getQuantity() - 1);
		}
		else {
			cart.remove(index);
		}
	}
}
