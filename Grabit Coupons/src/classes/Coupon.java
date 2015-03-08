package classes;

import java.util.*;

public class Coupon {
	private int ID;
	private String owner;
	private Date payDate;
	private Date receiptDate;
	private Date useDate;
	private int quantity;
	private PayType payType;
	private String creditCard;
	private Customer buyer;
	private Sale sale;
	
	public Coupon(String owner, Date payDate, Date receiptDate, 
			int quantity, PayType payType, String creditCard, Customer buyer,
			Sale sale) {
		super();
		this.owner = owner;
		this.payDate = payDate;
		this.receiptDate = receiptDate;
		this.quantity = quantity;
		this.payType = payType;
		if(payType.getType() == "CreditCard"){
			this.creditCard = creditCard;
		}
		this.buyer = buyer;
		this.sale = sale;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	public Date getUseDate() {
		return useDate;
	}
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public PayType getPayType() {
		return payType;
	}
	public void setPayType(PayType payType) {
		this.payType = payType;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public Customer getBuyer() {
		return buyer;
	}
	public void setBuyer(Customer buyer) {
		this.buyer = buyer;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	
	
}
