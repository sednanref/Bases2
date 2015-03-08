package classes;
import java.util.*;

public class Sale {
	private int ID;
	private String name;
	private double originalPrice;
	private double offeredPrice;
	private Date expeditionDate;
	private Date expirationDate;
	private Set<SaleLink> links = new HashSet<SaleLink>(); /* links */
	private Set<SaleDate> dates = new HashSet<SaleDate>(); /* dates */
	private Set<SalePicture> pictures = new HashSet<SalePicture>(); /* pictures */
	private String description;
	private Company company;		/*Company of the Sale*/
	private Category category;	 			/*Category of the sale*/
	private Set<Coupon> coupons = new HashSet<Coupon>(); /*Buyers of the sale*/
	private State state;
	
	
	public Sale( String name, double originalPrice, double offeredPrice,
				Date expeditionDate, Date expirationDate, String description){
		this.name = name;
		this.originalPrice = originalPrice;
		this.offeredPrice = offeredPrice;
		this.expeditionDate = expeditionDate;
		this.expirationDate = expirationDate;
		this.description = description;
		this.setState(new State1Waiting());
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
	
	public Set<SaleLink> getLinks() {
		return links;
	}

	public void setLinks(Set<SaleLink> links) {
		this.links = links;
	}

	public Set<SaleDate> getDates() {
		return dates;
	}

	public void setDates(Set<SaleDate> dates) {
		this.dates = dates;
	}

	public Set<SalePicture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<SalePicture> pictures) {
		this.pictures = pictures;
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

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void doAction(Date date) {
    	state.doAction(this, date);
    }

}
