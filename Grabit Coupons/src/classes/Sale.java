package classes;
import java.util.*;

public class Sale {
	private int ID;
	private String name;
	private double originalPrice;
	private double offeredPrice;
	private Date expeditionDate;
	private Date expirationDate;
	/* links */
	/* dates */
	/* pictures */
	private String description;
	private Company company;		/*Company of the Sale*/
	private Set<Category> categories = new HashSet<Category>(); /*Categories of the sale*/
	private Set<Coupon> coupons = new HashSet<Coupon>(); /*Buyers of the sale*/
	
	public Sale( String name, double originalPrice, double offeredPrice,
				Date expeditionDate, Date expirationDate, String description){
		this.name = name;
		this.originalPrice = originalPrice;
		this.offeredPrice = offeredPrice;
		this.expeditionDate = expeditionDate;
		this.expirationDate = expirationDate;
		this.description = description;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public double getOfferedPrice() {
		return offeredPrice;
	}
	public void setOfferedPrice(double offeredPrice) {
		this.offeredPrice = offeredPrice;
	}
	public Date getExpeditionDate() {
		return expeditionDate;
	}
	public void setExpeditionDate(Date expeditionDate) {
		this.expeditionDate = expeditionDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}


}
