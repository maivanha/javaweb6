package model.etity;

public class ProductType {
	private String codeSP;
	private String nameSP;
	
	public ProductType() {
		
	}

	public ProductType(String codeSP, String nameSP) {
		super();
		this.codeSP = codeSP;
		this.nameSP = nameSP;
	}

	public String getCodeSP() {
		return codeSP;
	}

	public void setCodeSP(String codeSP) {
		this.codeSP = codeSP;
	}

	public String getNameSP() {
		return nameSP;
	}

	public void setNameSP(String nameSP) {
		this.nameSP = nameSP;
	}	
}
