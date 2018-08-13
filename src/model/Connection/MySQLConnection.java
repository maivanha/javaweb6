package model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {
	private static Connection connection;
	
	static {
		try {
			System.out.println(">>>>>>>>> Ket noi voi CSDL");
			
			if(connection == null || connection.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smobile"+ "?useUnicode=true&characterEncoding=UTF-8" ,"root", "123456");
				System.out.println(">>>>>>>> Ket noi da thanh cong");
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(">>>>>>>> Kết nối không thành công");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(">>>>>>>> Kết nối không thành công");
			e.printStackTrace();
		}
		
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		MySQLConnection.connection = connection;
	}
	
	
	public static void main(String[] args) {
		// >>>>>>>>>>>>>> Test
		
		//MySQLConnection mysqlConnection = new MySQLConnection();
		//System.out.println(mysqlConnection.getConnection());
	}
	
	
}
