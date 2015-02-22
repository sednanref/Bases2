package classes;

public class SalePicture {
	private String path;
	private Sale sale;
	
	public SalePicture(String path) {
		super();
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public Sale getSale() {
		return sale;
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}

}