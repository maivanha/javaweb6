package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Connection.MySQLConnection;
import model.etity.Company;

public class CompanyModel {
	public List<Company> getAllCompany() throws SQLException {
		List<Company> List = new ArrayList<>();
		String sql = "SELECT * FROM company";
		
		Statement statement = MySQLConnection.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			Company c = new Company();
			c.setCodeCompany(rs.getString("codeCompany"));
			c.setNameCompany(rs.getString("nameCompany"));
			
			List.add(c);
		}
		return List;
	}
	
	public Company getAllCompanyById(String codeCompany) throws SQLException {
		String sql = "SELECT * FROM company where codeCompany = ?";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, codeCompany);
		
		ResultSet rs = preState.executeQuery();
		
		rs.next();
			Company c = new Company();
			c.setCodeCompany(rs.getString("codeCompany"));
			c.setNameCompany(rs.getString("nameCompany"));
			
		return c;
	}
	
	public void insertCompany(Company c) throws SQLException {
		String sql ="insert into company (codeCompany, nameCompany) VALUE (?, ?)";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setString(1, c.getCodeCompany());
		preState.setString(2, c.getNameCompany());
		
		preState.executeUpdate();
	}
	
	public void deleteCompany(String codeCompany) throws SQLException {
		String sql ="delete from company where codeCompany = ?";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		preState.setString(1, codeCompany);
		
		preState.executeUpdate();
	}
	
	public void updateCompany(Company c) throws SQLException {
		String sql ="update company set nameCompany = ? where codeCompany = ?";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		preState.setString(1, c.getNameCompany());
		preState.setString(2, c.getCodeCompany());
		
		preState.executeUpdate();
	}
}
