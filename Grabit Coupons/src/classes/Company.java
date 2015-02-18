package classes;

public class Company {
	public String RIF;
	public String Name;
	public String eMail;
	public String address;
	public String telephoneNumber;
	public int customersNumber;
	
	public String getRIF() {
		return RIF;
	}
	public void setRIF(String rIF) {
		RIF = rIF;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public int getCustomersNumber() {
		return customersNumber;
	}
	public void setCustomersNumber(int customersNumber) {
		this.customersNumber = customersNumber;
	}
	
	
}
