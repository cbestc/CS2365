import java.util.ArrayList;
import java.util.Random;

public class Bank {
	ArrayList<CreditCard> cardList = new ArrayList<CreditCard>();
	public Bank()
	{
		//this.readFromFile();
	}
	//needs object files + WriteToFile + ReadToFile
	
	public int doesCCNExist(String ccn) {
		CreditCard temp = new CreditCard(ccn);
		if(this.cardList.contains(temp)) {
			return this.cardList.indexOf(temp);
		}
		else {
			return -1;
		}
	}
	
	public int authorize(String ccn, double amount) {
		int index = this.doesCCNExist(ccn);
		if(index > -1) {
			if(this.cardList.get(index).getLimit() > this.cardList.get(index).balance + amount && this.cardList.get(index).getStatus() != "Pending") {
				this.cardList.get(index).setCharge(amount);
				this.cardList.get(index).setStatus("Pending");
				return 1;
			}
			return 0; //Credit card would be put over limit
		}
		else {
			return -1; //Credit card does not exist in database
		}
	}
	
	public String purchase(String ccn, double amount) {
		String authString;
		int index = this.doesCCNExist(ccn);
		if(index > -1) {
			if(this.cardList.get(index).getLimit() > this.cardList.get(index).balance + amount) {// && this.cardList.get(index).getStatus() != "Pending") {
				this.cardList.get(index).setCharge(amount);
				
				this.cardList.get(index).setBalance(this.cardList.get(index).getBalance() - this.cardList.get(index).getCharge());
				this.cardList.get(index).setCharge(0.0);
				this.cardList.get(index).setStatus("Charged");
				Random rand = new Random();
				int authNum = Math.abs(rand.nextInt());
				authString = Integer.toString(authNum);
				return authString;
			}
			authString = "N/A";
			return authString;
			//Credit card would be put over limit
		}
		authString = "N/A";
		return authString;
		//Credit card does not exist in database
	}
}
