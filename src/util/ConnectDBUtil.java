package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDBUtil {
	private String url;
	private String password;
	private String user;
	private Connection conn;

	public ConnectDBUtil() {
		this.url = "jdbc:mysql://localhost:3306/newsexpress?useUnicode=true&characterEncoding=UTF-8";
		this.password = "";
		this.user = "root";
	}

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
