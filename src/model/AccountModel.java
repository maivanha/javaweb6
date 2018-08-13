package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.Connection.MySQLConnection;
import model.etity.Account;
import model.etity.Customer;

public class AccountModel {
	public Account getAccount(String username, String userpass) throws SQLException {
		String sql = "SELECT * FROM account WHERE username = ? AND userpass = sha2(?, 256);";
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, username);
		preState.setString(2, userpass);
		
		ResultSet rs = preState.executeQuery();
		
		if(rs.next()) {
			return new Account(rs.getString(1), rs.getString(2), rs.getString(3));
		} else {
			return null;
		}
	}
	
	
	public ArrayList<Customer> getAllDetailCustomers() throws SQLException {
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		
		String sql = "SELECT * FROM customer INNER JOIN account ON customer.id = account.id;";
		Statement statement = MySQLConnection.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Customer cus;
		while(rs.next()) {
			cus = new Customer();
			cus.setId(rs.getInt("id"));
			cus.setEmail(rs.getString("email"));
			cus.setFullname(rs.getString("fullname"));
			cus.setAddress(rs.getString("address"));
			cus.setMobile(rs.getInt("mobile"));
			cus.setUsername(rs.getString("username"));
			cus.setUserpass(rs.getString("userpass"));
			
			
			cusList.add(cus);
		}
		return cusList;
	}
	
	public Customer getDetailAccountByName(String username) throws SQLException {
		String sql = "SELECT * FROM customer INNER JOIN account ON customer.id = account.id where username = ?;";
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, username);
		
		ResultSet rs = preState.executeQuery();
		Customer cus = null;
		while(rs.next()) {
			cus = new Customer();
			cus.setId(rs.getInt("id"));
			cus.setEmail(rs.getString("email"));
			cus.setFullname(rs.getString("fullname"));
			cus.setAddress(rs.getString("address"));
			cus.setMobile(rs.getInt("mobile"));
			cus.setUsername(rs.getString("username"));
			cus.setUserpass(rs.getString("userpass"));
		}
		return cus;
	}
	
	public Account getAccountByNameChangePass(String username) throws SQLException {
		String sql = "SELECT * FROM account WHERE username = ?;";
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, username);
		
		ResultSet rs = preState.executeQuery();
		Account acc = null;
		while(rs.next()) {
			acc = new Account();
			acc.setUsername(rs.getString("username"));
			acc.setUserpass(rs.getString("userpass"));
		}
		return acc;
	}
	
	public void insertAccount(String username, String userpass, String email, Customer cus) throws SQLException {
		String sql = "INSERT INTO account(username, userpass, email) VALUE (?, SHA2(?, 256), ?)";
		CustomerModel cModel = new CustomerModel();
		
		int number = 0;
		PreparedStatement preState;
		try {
			//con.setAutoCommit(false);
			preState = MySQLConnection.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			preState.setString(1, username);
			preState.setString(2, userpass);
			preState.setString(3, email);
			
			preState.executeUpdate();		
			
			ResultSet rs = preState.getGeneratedKeys();

			if(rs.next()) {
				number = rs.getInt(1);
			}
			System.out.println("number: " + number);
			
			cus.setId(number);
			//system
			cModel.insertCustomer(cus);
			
			//con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			//con.rollback();
		}	
	}
	
	public void updateDetail(Customer cus) throws SQLException {
		CustomerModel cModel = new CustomerModel();
		AccountModel aModel = new AccountModel();
		//Account acc = new Account();
		//acc.setEmail(cus.getEmail());
		//acc.setUserpass(cus.getUserpass());
		//aModel.updateAccount(acc);
		aModel.updateAccountEmail(cus.getEmail(), cus.getId());
		cModel.updateCustomer(cus);		
	}
	
	public void updateAccountPass(Account acc) throws SQLException {
		String sql = "update account set userpass= sha2(?, 256) where username = ? ";
		System.out.println("aaaa " + acc.getUsername() +"    " +acc.getUserpass());
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, acc.getUserpass());
		preState.setString(2, acc.getUsername());

		preState.executeUpdate();
		
	}
	
	public void updateAccountEmail(String email, int id) throws SQLException {
		String sql = "update account set email = ? where id = ?;";
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, email);
		preState.setInt(2, id);
		
		System.out.print("email:"+ email);
		preState.executeUpdate();
	}
	
	
	public void deleteAccount(int id) throws SQLException {
		CustomerModel cModel = new CustomerModel();
		
		cModel.deleteCustomer(id);
		
		Connection con = MySQLConnection.getConnection();
		con.setAutoCommit(false);

		String sql = "delete from account where id= ?";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setInt(1, id);
		
		preState.executeUpdate();
		con.commit();
		System.out.println(">>>>>>Xoa thanh cong");
	}
}
