package classes;
import java.util.*;

public class Customer extends User {
	
	private String lastName;
	private int virtualMoney;
	//Tarjetas de crédito         <---------- FALTA
	private int eMailFrequency;
	private Set<Customer> persons = new HashSet<Customer>();
	private Set<Customer> friends = new HashSet<Customer>();      
	private Set<Coupon> purchasedCoupons = new HashSet<Coupon>(); /*Coupons purchased by the Customer*/
	
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
	
    public Set<Customer> getPersons() {
		return persons;
	}

	public void setPersons(Set<Customer> persons) {
		this.persons = persons;
	}

	public Set<Customer> getFriends() {
		return friends;
	}

	public void setFriends(Set<Customer> friends) {
		this.friends = friends;
	}

	public Set<Coupon> getPurchasedCoupons() {
		return purchasedCoupons;
	}

	public void setPurchasedCoupons(Set<Coupon> purchasedCoupons) {
		this.purchasedCoupons = purchasedCoupons;
	}


}
