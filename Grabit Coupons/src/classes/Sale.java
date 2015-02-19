package classes;
import java.util.*;

public class Sale {
	int ID;
	String name;
	double originalPrice;
	double offeredPrice;
	Date expeditionDate;
	Date expirationDate;
	/* links */
	/* dates */
	/* pictures */
	String description;
	
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
	
	
}
