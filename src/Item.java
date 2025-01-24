import java.io.Serializable;

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
    
    public Item(String name, int quantity)
    {
      this.name = name;
      this.quantity = quantity;
      this.price = 0.0;
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
    
    @Override
    public boolean equals(Object o) {
    	if(o instanceof Item) {
    		Item a = (Item) o;
			return this.name.equals(a.getName());
		}
		else {
			return false;
		}
    }
    
 }