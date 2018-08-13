package model.etity;

public class Product {
	private int codeProduct;
	private String nameProduct;
	private int price;
	private int numberOfpro;
	private String image;
	private String codeSP;
	private String codeCompany;
	
	private int countbuy;
	
	public int getCountbuy() {
		return countbuy;
	}

	public void setCountbuy(int countbuy) {
		this.countbuy = countbuy;
	}

	public Product() {
		
	}

	public Product(int codeProduct, String nameProduct, int price, int numberOfpro, String image, String codeSP,
			String codeCompany, int countbuy) {
		super();
		this.codeProduct = codeProduct;
		this.nameProduct = nameProduct;
		this.price = price;
		this.numberOfpro = numberOfpro;
		this.image = image;
		this.codeSP = codeSP;
		this.codeCompany = codeCompany;
		this.countbuy = countbuy;
	}

	public int getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(int codeProduct) {
		this.codeProduct = codeProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfpro() {
		return numberOfpro;
	}

	public void setNumberOfpro(int numberOfpro) {
		this.numberOfpro = numberOfpro;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCodeSP() {
		return codeSP;
	}

	public void setCodeSP(String codeSP) {
		this.codeSP = codeSP;
	}

	public String getCodeCompany() {
		return codeCompany;
	}

	public void setCodeCompany(String codeCompany) {
		this.codeCompany = codeCompany;
	}
	
}
