package classes;

import java.util.*;

public class SaleDate {
	private Date date;
	private Set<Sale> sales = new HashSet<Sale>();
	
	
	public SaleDate(Date date) {
		super();
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Set<Sale> getSales() {
		return sales;
	}
	
	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}
	
}
