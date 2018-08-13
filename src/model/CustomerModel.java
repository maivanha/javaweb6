package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Connection.MySQLConnection;
import model.etity.Customer;

public class CustomerModel {
	public List<Customer> getAllCustomers() throws SQLException {
		List<Customer> cusList = new ArrayList<Customer>();

		String sql = "select * from customer";
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

			cusList.add(cus);
		}
		return cusList;
	}

	public void insertCustomer(Customer cus) throws SQLException {
		String sql = "insert into customer value(?, ?, ?, ?, ?)";
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		preState.setInt(1, cus.getId());
		preState.setString(2, cus.getEmail());
		preState.setString(3, cus.getFullname());
		preState.setString(4, cus.getAddress());
		preState.setInt(5, cus.getMobile());
		
		System.out.println("Them bang customer");
		preState.executeUpdate();
	}

	public void updateCustomer(Customer cus) throws SQLException {
		String sql = "update customer set email =?, fullname =?, address = ?, mobile =? where id = ?";
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, cus.getEmail());
		preState.setString(2, cus.getFullname());
		preState.setString(3, cus.getAddress());
		preState.setInt(4, cus.getMobile());
		preState.setInt(5, cus.getId());
		//System.out.println("cus " + cus.getAddress() + "   id: " + cus.getId());
		
		preState.executeUpdate();
	}

	public void deleteCustomer(int id) throws SQLException {
		
		Connection con = MySQLConnection.getConnection();
		con.setAutoCommit(false);
		
		String sql = "delete from customer where id= ?";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);

		preState.setInt(1, id);

		preState.executeUpdate();
		//System.out.println(">>>>>>Xoa");
		con.commit();
		System.out.println(">>>>>>Xoa thanh cong bang customer");
	}
}
