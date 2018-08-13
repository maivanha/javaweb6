package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Connection.MySQLConnection;
import model.etity.Orders;
import model.etity.Rating;

public class RatingModel {
	public Rating getRating(int codeProduct, String username) throws SQLException{
		String sql = "SELECT * FROM rating where codeProduct = ? and username = ?;";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		preState.setInt(1, codeProduct);
		preState.setString(2, username);
		ResultSet rs = preState.executeQuery();
		Rating r = new Rating();
		if(!rs.next()) {
			r.setValueRating(0);
			r.setUsername(username);
			r.setCodeProduct(codeProduct);
			r.setIdRating(0);
		} else {
			rs.beforeFirst();
			rs.next();
			r.setIdRating(rs.getInt("idRating"));
			r.setValueRating(rs.getDouble("valueRating"));
			r.setCodeProduct(rs.getInt("codeProduct"));
			r.setUsername(rs.getString("username"));
		}
		return r;
	}

	public double getRatingValue(int codeProduct) throws SQLException {
		String sql = "SELECT AVG(valueRating) AS tbc FROM rating WHERE codeProduct = ?;";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		preState.setInt(1, codeProduct);
		ResultSet rs = preState.executeQuery();
		rs.next();
		double s = rs.getDouble(1);
		return s;
	}

	public void insertRating(Rating r) throws SQLException {
		String sql = "INSERT INTO rating(valueRating, codeProduct, username) Value(?, ?, ?);";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);

		preState.setDouble(1, r.getValueRating());
		preState.setInt(2, r.getCodeProduct());
		preState.setString(3, r.getUsername());

		preState.executeUpdate();
	}

	public void updateRating(Rating r) throws SQLException {
		String sql = "Update rating set valueRating = ? where codeProduct = ? and username = ?;";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);

		preState.setDouble(1, r.getValueRating());
		preState.setInt(2, r.getCodeProduct());
		preState.setString(3, r.getUsername());

		preState.executeUpdate();
	}
}
