package classes;

import java.util.*;

public class PayType {
	private int ID;
	private String type;
	private Set<Coupon> coupons = new HashSet<Coupon>();
	
	public PayType(String type) {
		super();
		this.type = type;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}
	
}
