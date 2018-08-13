package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Connection.MySQLConnection;
import model.etity.OrdersDetail;

public class OrdersDetailModel {
	public List<OrdersDetail> getOrdersDetail() throws SQLException {
		List<OrdersDetail> list = new ArrayList<>();
		String sql = "select * from orderdetail";
		
		Statement state = MySQLConnection.getConnection().createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		OrdersDetail o;
		while(rs.next()) {
			o = new OrdersDetail();
			o.setCodeOrder(rs.getInt("codeOrder"));
			o.setCodeProduct(rs.getInt("codeProduct"));
			o.setNameProduct(rs.getString("nameProduct"));
			o.setQuantity(rs.getInt("quantity"));
			o.setPrice(rs.getInt("price"));
			o.setPrice_total(rs.getInt("price_total"));
			
			list.add(o);
		}
		
		return list;
	}
	
	public List<OrdersDetail> getOrdersDetailById(int codeOrder) throws SQLException {
		List<OrdersDetail> list = new ArrayList<>();
		String sql = "select * from orderdetail where codeOrder = ?";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setInt(1, codeOrder);
		
		ResultSet rs = preState.executeQuery();
		OrdersDetail o;
		while(rs.next()) {
			o = new OrdersDetail();
			o.setCodeOrder(rs.getInt("codeOrder"));
			o.setCodeProduct(rs.getInt("codeProduct"));
			o.setNameProduct(rs.getString("nameProduct"));
			o.setQuantity(rs.getInt("quantity"));
			o.setPrice(rs.getInt("price"));
			o.setPrice_total(rs.getInt("price_total"));
			
			list.add(o);
		}
		
		return list;
	}
	
	public void insertOrdersDetail(OrdersDetail od) throws SQLException {
		String sql = "insert into orderdetail(codeOrder, codeProduct, nameProduct, quantity, price, price_total) value (?, ?, ?, ?, ? , ?)";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setInt(1, od.getCodeOrder());
		preState.setInt(2, od.getCodeProduct());
		preState.setString(3, od.getNameProduct());
		preState.setInt(4, od.getQuantity());
		preState.setInt(5, od.getPrice());
		preState.setInt(6, od.getPrice_total());
		
		System.out.println(">>>>>>> insert orddetail "  + od.getCodeProduct() + " quanti: " + od.getQuantity());
		
		preState.executeUpdate();
		
		
	}
	
	public void deleteOrdersDetail(int codeOrder) throws SQLException {
		String sql= "delete from orderdetail where codeOrder = ?";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setInt(1, codeOrder);
		
		preState.executeUpdate();
	}
}
