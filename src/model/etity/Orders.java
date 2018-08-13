package model.etity;

import java.sql.Date;

public class Orders {
	private int codeOrder;
	private Date dateOrder;
	private Date receivedDate;
	private String fullname;
	private String address;
	private String email;
	private int price_order;
	private int id;
	private String confirm;
	private int statuss;
	
	public Orders() {
		
	}

	

	public int getStatuss() {
		return statuss;
	}



	public void setStatuss(int statuss) {
		this.statuss = statuss;
	}



	public Orders(int codeOrder, Date dateOrder, Date receivedDate, String fullname, String address, String email,
			int price_order, int id, String confirm, int statuss) {
		super();
		this.codeOrder = codeOrder;
		this.dateOrder = dateOrder;
		this.receivedDate = receivedDate;
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.price_order = price_order;
		this.id = id;
		this.confirm = confirm;
		this.statuss = statuss;
	}



	public int getCodeOrder() {
		return codeOrder;
	}

	public void setCodeOrder(int codeOrder) {
		this.codeOrder = codeOrder;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrice_order() {
		return price_order;
	}

	public void setPrice_order(int price_order) {
		this.price_order = price_order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	
}
