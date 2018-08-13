package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Connection.MySQLConnection;
import model.etity.News;


public class NewsModel {
	public List<News> getNews() throws SQLException {
		List<News> dsTinTuc = new ArrayList<>();
		//dsTinTuc.removeAll(dsTinTuc);
		String sql = "SELECT * FROM news ORDER BY codeNews DESC;";

		Statement statement = MySQLConnection.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		News n;
		while(rs.next()) {
			n = new News();
			
			n.setCodeNews(rs.getInt("codeNews"));
			n.setTitle(rs.getString("title"));
			n.setImage(rs.getString("image"));
			n.setContents(rs.getString("contents"));

			dsTinTuc.add(n);
		}
		return dsTinTuc;
	}
	
	public News getNewById(int id) throws SQLException {
		String sql = "SELECT * FROM news WHERE codeNews = ?;";

		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		preState.setInt(1, id);
		
		ResultSet rs = preState.executeQuery();
		News n = null;
		while(rs.next()) {
			n = new News();			
			n.setCodeNews(rs.getInt("codeNews"));
			n.setTitle(rs.getString("title"));
			n.setImage(rs.getString("image"));
			n.setContents(rs.getString("contents"));
		}
		return n;
	}
	
	public News getNewByIdString(String id) throws SQLException {
		String sql = "SELECT * FROM news WHERE codeNews = ?;";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		preState.setInt(1, Integer.parseInt(id));
		
		ResultSet rs = preState.executeQuery();
		News n = null;
		while(rs.next()) {
			n = new News();			
			n.setCodeNews(rs.getInt("codeNews"));
			n.setTitle(rs.getString("title"));
			n.setImage(rs.getString("image"));
			n.setContents(rs.getString("contents"));
		}
		return n;
	}
	
	public List<News> getNewPage(int start, int count) throws SQLException {
		List<News> list = new ArrayList<>();
		
		String sql = "select * from news limit ?, ?;";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		
		preState.setInt(1, start);
		preState.setInt(2, count);
		
		ResultSet rs = preState.executeQuery();
		while(rs.next()) {
			News n = new News();
			n.setCodeNews(rs.getInt("codeNews"));
			n.setTitle(rs.getString("title"));
			n.setImage(rs.getString("image"));
			n.setContents(rs.getString("contents"));
			
			list.add(n);
		}
		return list;
	}
	
	public int getCountNew() throws SQLException {
		String sql = "select count(*) from news;";
		
		Statement statement = MySQLConnection.getConnection().createStatement();
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);
		
		return count;
	}
	
	public void insertNews(News n) throws SQLException {
		String sql = "insert into news(title, image, contents) value(?, ?, ?);";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		 preState.setString(1, n.getTitle());
		 preState.setString(2, n.getImage());
		 preState.setString(3, n.getContents());
		 
		 preState.executeUpdate();
		 System.out.println(">>>>>> Da them tin tuc");
	}
	
	public void updateNews(News n) throws SQLException {
		String sql = "update news set title = ?, image = ?, contents = ? where codeNews = ?;";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		 preState.setString(1, n.getTitle());
		 preState.setString(2, n.getImage());
		 preState.setString(3, n.getContents());
		 preState.setInt(4, n.getCodeNews());
		 
		 System.out.println(">>>>>> Da update tin tuc");
		 System.out.println("codenew:" + n.getCodeNews() + "   " + n.getTitle());
		 preState.executeUpdate();
	}
	
	public void deleteNews(int id) throws SQLException {
		String sql = "delete from news where codeNews = ?;";
		
		PreparedStatement preState = MySQLConnection.getConnection().prepareStatement(sql);
		 preState.setInt(1, id);
		 
		 System.out.println(">>>>>> Da delete tin tuc");
		 preState.executeUpdate();
	}
}
