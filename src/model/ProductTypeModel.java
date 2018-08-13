package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Connection.MySQLConnection;
import model.etity.ProductType;

public class ProductTypeModel {
	public List<ProductType> getAllProductType() throws SQLException {
		List<ProductType> List = new ArrayList<>();
		String sql = "SELECT * FROM producttype";
		
		Statement statement = MySQLConnection.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			ProductType p = new ProductType();
			p.setCodeSP(rs.getString("codeSP"));
			p.setNameSP(rs.getString("nameSP"));
			
			List.add(p);
		}
		return List;
	}
	
	public ProductType getProductTypeById(String codeSP) throws SQLException {
		String sql = "SELECT * FROM producttype where codeSP = ?";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, codeSP);
		
		ResultSet rs = preState.executeQuery();
		
		rs.next();
			ProductType p = new ProductType();
			p.setCodeSP(rs.getString("codeSP"));
			p.setNameSP(rs.getString("nameSP"));
			
		return p;
	}
	
	public void insertCompany(ProductType p) throws SQLException {
		String sql ="INSERT INTO producttype(codeSP, nameSP) VALUE (?, ?)";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, p.getCodeSP());
		preState.setString(2, p.getNameSP());
		
		preState.executeUpdate();
	}
	
	public void deleteCompany(String codeSP) throws SQLException {
		String sql ="delete from producttype where codeSP = ?";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		preState.setString(1, codeSP);
		
		preState.executeUpdate();
	}
	
	public void updateCompany(ProductType p) throws SQLException {
		String sql ="update producttype set nameSP = ? where codeSP = ?";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		preState.setString(1, p.getNameSP());
		preState.setString(2, p.getCodeSP());
		
		preState.executeUpdate();
	}
}
