import java.io.*;
import java.util.ArrayList;

public class OrderLog {
	ArrayList<Order> orderLog;
	ArrayList<Order> readyOrderLog;
	
	//Constructors
	public OrderLog() {
		this.orderLog = new ArrayList<Order>();
		this.readyOrderLog = new ArrayList<Order>();
		//this.readFromFile();
	}
		
	/*public OrderLog(String filename) {
		this.filename = filename;
	*/
	
	//Methods
	public void addOrder(Order order) {
		orderLog.add(order);
		//findReadyOrders();
	}
	
	/*public Order getOrder(Customer customer) {
		
	}*/
	
	public void findReadyOrders() {		// Finds all orders with status ready and adds to readyOrderLog
		readyOrderLog.clear();
		for(int i = 0; i < this.orderLog.size(); i++) {
            if(this.orderLog.get(i) != null) {
            	Order current = this.orderLog.get(i);
            	if(current.status == "Ready") {
            		this.readyOrderLog.add(current);
            	}
            }
        }
	}
	
	public String printReadyOrders() {
		String output = "";
		for(int i = 0; i < this.readyOrderLog.size(); i++) {
        	Order current = this.readyOrderLog.get(i);
        	output = output + "\n\tOrder " + (i+1) + ":" + current.getInvoice();
        }
		return output;
	}
	
	public String printOrders() {
		String output = "";
		for(int i = 0; i < this.orderLog.size(); i++) {
        	Order current = this.orderLog.get(i);
        	output = output + "\n\tOrder " + (i+1) + ":" + current.getInvoice();
        }
		return output;
	}
	
	public void readFromFile() {		// Will we need read and write for readyOrderLog???
        try {
	        FileInputStream fis = new FileInputStream("src\\orderlog");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        Object input;
	        boolean cont = true;
	        while(cont) {
	            input = ois.readObject();
	            
	            if(!input.equals(0)) {
	                System.out.println(1);
	                this.orderLog.add((Order)input);
	            }
	            
	            else {
	                cont = false;
	            }
	        ois.close();											// added
	        }
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void writeToFile()
    {
        try {
	        FileOutputStream fos = new FileOutputStream("orderlog.txt");
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        for(int i = 0; i < this.orderLog.size(); i++) {
	            if(this.orderLog.get(i) != null) {
	                oos.writeObject(this.orderLog.get(i));
	            }
	        }
	        oos.writeObject(0);
	        oos.close();											// added
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
	
	
}