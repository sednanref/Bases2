package classes;

public class SaleLink {

	private String url;
	private Sale sale;
	
	public SaleLink(String url, Sale sale) {
		super();
		this.url = url;
		this.sale = sale;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Sale getSale() {
		return sale;
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
}
