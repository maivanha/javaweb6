package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import model.Connection.MySQLConnection;
import model.etity.Product;

public class ProductModel {

	public List<Product> getProduct() throws SQLException {
		List<Product> dsSanPham = new ArrayList<>();
		String sql = "SELECT * FROM product ORDER BY codeProduct DESC;";

		Statement statement = MySQLConnection.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Product p;
		while(rs.next()) {
			p = new Product();
			p.setCodeProduct(rs.getInt("codeProduct"));
			p.setNameProduct(rs.getString("nameProduct"));
			p.setPrice(rs.getInt("price"));
			p.setNumberOfpro(rs.getInt("numberOfpro"));
			p.setImage(rs.getString("image"));
			p.setCodeSP(rs.getString("codeSP"));
			p.setCodeCompany(rs.getString("codeCompany"));

			dsSanPham.add(p);
		}
		return dsSanPham;
	}
	
	public List<Product> getPageProduct(int start, int count) throws SQLException {
		List<Product> dsSanPham = new ArrayList<>();
		String sql = "SELECT * FROM product ORDER BY codeProduct DESC limit ?, ?;";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setInt(1, start);
		preState.setInt(2, count);
		ResultSet rs = preState.executeQuery();
		Product p;
		while(rs.next()) {
			p = new Product();
			p.setCodeProduct(rs.getInt("codeProduct"));
			p.setNameProduct(rs.getString("nameProduct"));
			p.setPrice(rs.getInt("price"));
			p.setNumberOfpro(rs.getInt("numberOfpro"));
			p.setImage(rs.getString("image"));
			p.setCodeSP(rs.getString("codeSP"));
			p.setCodeCompany(rs.getString("codeCompany"));

			dsSanPham.add(p);
		}
		return dsSanPham;
	}
	
	public List<Product> getSearchProduct(HttpServletRequest request, String name) throws SQLException {
		List<Product> dsSanPham = new ArrayList<>();
		String sql = "SELECT * FROM product WHERE nameProduct LIKE ?;";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, "%"+ name + "%");
		ResultSet rs = preState.executeQuery();
		
		if(!rs.isBeforeFirst()) {
			request.setAttribute("Ketqua", "Không tìm thấy kết quả !");
		} else {
			Product p;
			while(rs.next()) {
				p = new Product();
				p.setCodeProduct(rs.getInt("codeProduct"));
				p.setImage(rs.getString("image"));
				p.setNameProduct(rs.getString("nameProduct"));

				dsSanPham.add(p);
			}
		}
		return dsSanPham;
	}
	
	public int getQuantityProduct() throws SQLException {
		String sql = "select count(*) from product;";
		
		Statement statement = MySQLConnection.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);
		
		return count;
	}

	public void insertProduct(Product p) throws SQLException {
		String sql = "INSERT INTO product (nameProduct, price, numberOfpro, image, codeSP, codeCompany) VALUE (?, ?, ?, ?, ?, ?);";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);

		preState.setString(1, p.getNameProduct());
		preState.setInt(2, p.getPrice());
		preState.setInt(3, p.getNumberOfpro());
		preState.setString(4, p.getImage());
		preState.setString(5, p.getCodeSP());
		preState.setString(6, p.getCodeCompany());

		preState.executeUpdate();
		System.out.println(">>>> Da them");
	}

	public void updateProduct(Product p) throws SQLException {
		String sql = "UPDATE product SET nameProduct = ?,price = ?, numberOfpro = ?, image = ?, codeSP = ?, codeCompany = ? WHERE codeProduct = ?;";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);

		preState.setString(1, p.getNameProduct());
		preState.setInt(2, p.getPrice());
		preState.setInt(3, p.getNumberOfpro());
		preState.setString(4, p.getImage());
		preState.setString(5, p.getCodeSP());
		preState.setString(6, p.getCodeCompany());

		preState.setInt(7, p.getCodeProduct());

		preState.executeUpdate();
		System.out.println(">>>> Da update");
	}
	
	public void updateBuyProduct(int numberOfpro, int codeProduct) throws SQLException {
		String sql = "UPDATE product SET numberOfpro = ? WHERE codeProduct = ?;";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);

		preState.setInt(1, numberOfpro);
		preState.setInt(2, codeProduct);

		preState.executeUpdate();
		System.out.println(">>>> Da update");
	}

	public void deleteProduct(int id) throws SQLException {
		String sql = "Delete from product WHERE codeProduct = ?;";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);

		preState.setInt(1, id);

		preState.executeUpdate();
		System.out.println(">>>> Da delete");
	}

	public Product getProductById(int id) throws SQLException {
		String sql = "select * from product where  codeProduct = ?;";
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);

		preState.setInt(1, id);
		ResultSet rs = preState.executeQuery();
		Product p = null;

		while(rs.next()) {
			p = new Product();
			p.setCodeProduct(rs.getInt("codeProduct"));
			p.setNameProduct(rs.getString("nameProduct"));
			p.setPrice(rs.getInt("price"));
			p.setNumberOfpro(rs.getInt("numberOfpro"));
			p.setImage(rs.getString("image"));
			p.setCodeSP(rs.getString("codeSP"));
			p.setCodeCompany(rs.getString("codeCompany"));

		}
		return p;
	}
	
	public static void main(String[] args,HttpServletRequest request) throws SQLException {
		ProductModel pModel = new ProductModel();
		String name = "s";
		
		List<Product> list = pModel.getSearchProduct(request, name);
		
		
	}
}
