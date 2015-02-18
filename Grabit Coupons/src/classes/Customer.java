package classes;

public class Customer extends User {
	
	private String lastName;
	private int virtualMoney;
	//Tarjetas de crédito
	private int eMailFrequency;
	
	public Customer(String eMail, String password, String name, String lastName,
					int virtualMoney, int eMailFrequency){
		super(eMail, password, name);
		this.lastName = lastName;
		this.virtualMoney = virtualMoney;
		this.eMailFrequency = eMailFrequency;
		
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getVirtualMoney() {
		return virtualMoney;
	}

	public void setVirtualMoney(int virtualMoney) {
		this.virtualMoney = virtualMoney;
	}

	public int geteMailFrequency() {
		return eMailFrequency;
	}

	public void seteMailFrequency(int eMailFrequency) {
		this.eMailFrequency = eMailFrequency;
	}
}
