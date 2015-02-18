package classes;



public class User {
	
	private int id;
	private String eMail;
	private String password;
	private String name;
	private String lastName;
	private int virtualMoney;
	//Tarjetas de crédito
	private int eMailFrequency;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
