package classes;

import java.util.*;

public class Company extends User {
	private String RIF;
	private String address;
	private String telephoneNumber;
	private int customersNumber;
	private Set<Sale> offeredSales = new HashSet<Sale>(); //offers of the company
	
	
	
	public Company(String eMail, String password, String name, String RIF,
				   String address, String telephoneNumber, int customersNumber){
		super(eMail, password, name);
		this.RIF = RIF;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
		this.customersNumber = customersNumber;
	}
	
	public String getRIF() {
		return RIF;
	}
	
	public void setRIF(String rIF) {
		RIF = rIF;
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

	public Set<Sale> getOfferedSales() {
		return offeredSales;
	}

	public void setOfferedSales(Set<Sale> offeredSales) {
		this.offeredSales = offeredSales;
	}
	
	
}
