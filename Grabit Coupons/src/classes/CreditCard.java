package classes;

public class CreditCard {
	private String number;
	private Customer owner;
	
	public CreditCard(String number, Customer owner) {
		super();
		this.number = number;
		this.owner = owner;
	}

	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
}
