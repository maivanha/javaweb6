package model.etity;

public class Company {
	private String codeCompany;
	private String nameCompany;
	
	public Company() {
		
	}

	public Company(String codeCompany, String nameCompany) {
		super();
		this.codeCompany = codeCompany;
		this.nameCompany = nameCompany;
	}

	public String getCodeCompany() {
		return codeCompany;
	}

	public void setCodeCompany(String codeCompany) {
		this.codeCompany = codeCompany;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
}
