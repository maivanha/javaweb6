package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Connection.MySQLConnection;
import model.etity.Orders;
import model.etity.OrdersDetail;
import model.etity.Product;

public class OrdersModel {
	
	public List<Orders> getAllOrder() throws SQLException {
		List<Orders> list = new ArrayList<>();
		
		String sql = "SELECT * FROM orders ORDER BY codeOrder DESC;";
		
		Statement statement = MySQLConnection.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Orders o;
		while(rs.next()) {
			o = new Orders();
			o.setCodeOrder(rs.getInt("codeOrder"));
			o.setDateOrder(rs.getDate("dateOrder"));
			o.setReceivedDate(rs.getDate("receiveddate"));
			o.setFullname(rs.getString("fullname"));
			o.setAddress(rs.getString("address"));
			o.setEmail(rs.getString("email"));
			o.setId(rs.getInt("id"));
			o.setConfirm(rs.getString("confirm"));
			o.setPrice_order(rs.getInt("price_order"));
			o.setStatuss(rs.getInt("statuss"));
			
//			long millis = System.currentTimeMillis();
//			java.sql.Date date = new java.sql.Date(millis);
//			if(o.getStatuss() == 0) {
//				if(Integer.parseInt(o.getReceivedDate().getDay()) <= date.getDay() || o.getReceivedDate().getMonth() <= date.getMonth()) {
//					o.setStatuss(rs.getInt("1"));
//				}
//			}
			

			
			list.add(o);
		}
		return list;
	}
	
	public List<Orders> getOrderByEmail(String email) throws SQLException {
		String sql = "select * from orders where email = ?;";
		List<Orders> list = new ArrayList<>();
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, email);
		
		ResultSet rs = preState.executeQuery();
		Orders o;
		while(rs.next()) {
			o = new Orders();
			o.setCodeOrder(rs.getInt("codeOrder"));
			o.setDateOrder(rs.getDate("dateOrder"));
			o.setReceivedDate(rs.getDate("receiveddate"));
			o.setFullname(rs.getString("fullname"));
			o.setAddress(rs.getString("address"));
			o.setEmail(rs.getString("email"));
			o.setId(rs.getInt("id"));
			o.setConfirm(rs.getString("confirm"));
			o.setStatuss(rs.getInt("statuss"));
			o.setPrice_order(rs.getInt("price_order"));
			list.add(o);
		}
		return list;
	}
	
	public Orders getOrderByIdString(String codeOrder) throws SQLException {
		String sql = "select * from orders where codeOrder = ?;";
		
		int id = Integer.parseInt(codeOrder);
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setInt(1, id);
		
		ResultSet rs = preState.executeQuery();
		Orders o;
		rs.next();
			o = new Orders();
			o.setCodeOrder(rs.getInt("codeOrder"));
			o.setDateOrder(rs.getDate("dateOrder"));
			o.setReceivedDate(rs.getDate("receiveddate"));
			o.setFullname(rs.getString("fullname"));
			o.setAddress(rs.getString("address"));
			o.setEmail(rs.getString("email"));
			o.setId(rs.getInt("id"));
			o.setConfirm(rs.getString("confirm"));
			o.setPrice_order(rs.getInt("price_order"));
		return o;
	}
	
	
	public void insertOrders(Orders o, List<OrdersDetail> listOrddetail) throws SQLException {
		String sql = "INSERT INTO orders(dateOrder, receiveddate, fullname, address, email, price_order, id) VALUE (?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		// Lấy thời gian hiện tại
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		preState.setDate(1, date);
		
		// Tăng ngày và covert về kiểu java.sql.date
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 7);
		java.sql.Date datee = new java.sql.Date(c.getTimeInMillis());
		//
		
		preState.setDate(2, datee);
		preState.setString(3, o.getFullname());
		preState.setString(4, o.getAddress());
		preState.setString(5, o.getEmail());
		preState.setInt(6, o.getPrice_order());
		preState.setInt(7, o.getId());
		
		preState.executeUpdate();
		int number = 0;
		
		ResultSet rs = preState.getGeneratedKeys();
		
		if(rs.next()) {
			number = rs.getInt(1);
		}
		
		OrdersDetailModel odModel = new OrdersDetailModel();
		ProductModel pModel = new ProductModel();
		for(int i = 0; i < listOrddetail.size(); i++) {
			Product p = new Product();
			p.setNumberOfpro(pModel.getProductById(listOrddetail.get(i).getCodeProduct()).getNumberOfpro());
			System.out.println(p.getNumberOfpro());
			listOrddetail.get(i).setCodeOrder(number);
			OrdersDetail orddetail = listOrddetail.get(i);
			odModel.insertOrdersDetail(orddetail);
			pModel.updateBuyProduct(p.getNumberOfpro() - listOrddetail.get(i).getQuantity(), listOrddetail.get(i).getCodeProduct());
		}
	}
	
	////// them o.setConfirm(rs.getString("confirm"));
	public void updateOrder(Orders o) throws SQLException {
		String sql = "update orders set fullname = ?, address = ?, email = ? where codeOrder = ?;";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		//preState.setDate(1, o.getReceivedDate());
		preState.setString(1, o.getFullname());
		preState.setString(2, o.getAddress());
		preState.setString(3, o.getEmail());
		preState.setInt(4, o.getCodeOrder());
		
		preState.executeUpdate();
	}
	
	public void updateStatussOrders(int codeOrder, int statuss) throws SQLException {
		String sql = "update orders set statuss = ? where codeOrder = ?;";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setInt(1, statuss);
		preState.setInt(2, codeOrder);
		
		preState.executeUpdate();
	}
	
	public void deleteOrder(int codeOrder) throws SQLException {
		String sql = "delete from orders where codeOrder = ?;";
		
		OrdersDetailModel odModel = new OrdersDetailModel();
		odModel.deleteOrdersDetail(codeOrder);
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setInt(1, codeOrder);
		
		preState.executeUpdate();
		
		
		
	}
}
