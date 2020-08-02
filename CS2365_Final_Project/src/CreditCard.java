
public class CreditCard {
	String CCN;
	double limit;
	double balance;
	double charge;
	String status;
	
	public CreditCard(String CCN) {
		
	}
	
	public CreditCard(String ccn, double limit, double balance) {
		
	}
	
	String getCCN() {
		return this.CCN;
	}
	
	double getLimit() {
		return this.limit;
	}
	
	double getBalance() {
		return this.balance;
	}
	
	double getCharge() {
		return this.charge;
	}
	
	String getStatus() {
		return this.status;
	}
	
	void setCCN(String in) {
		this.CCN = in;
	}
	
	void setLimit(double in) {
		this.limit = in;
	}
	
	void setBalance(double in) {
		this.balance = in;
	}
	
	void setCharge(double in) {
		this.charge = in;
	}
	
	void setStatus(String in) {
		this.status = in;
	}
	
	
	public void chargeToCard() {
		this.balance = this.balance - this.charge;
		this.charge = 0.0;
		this.status = "N/A";
	}
	@Override
	public String toString() {
		String ccnString = "CCN: " + this.CCN + ", Credit limit: " + this.limit + ", Current balance: " + this.balance + "%n Pending charge: " + this.charge + ", Current status: " + this.status;
		return ccnString;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof CreditCard) {
			CreditCard a = (CreditCard) o;
			return this.CCN.equals(a.getCCN());
		}
		else {
			return false;
		}
	}
}
