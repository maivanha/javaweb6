package model.etity;

public class Rating {
	private int idRating;
	private double valueRating;
	private int codeProduct;
	private String username;
	
	public Rating() {
	}
	public Rating(int idRating, double valueRating, int codeProduct, String username) {
		this.idRating = idRating;
		this.valueRating = valueRating;
		this.codeProduct = codeProduct;
		this.username = username;
	}
	public int getIdRating() {
		return idRating;
	}
	public void setIdRating(int idRating) {
		this.idRating = idRating;
	}
	public double getValueRating() {
		return valueRating;
	}
	public void setValueRating(double valueRating) {
		this.valueRating = valueRating;
	}
	public int getCodeProduct() {
		return codeProduct;
	}
	public void setCodeProduct(int codeProduct) {
		this.codeProduct = codeProduct;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
