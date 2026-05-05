package TestPages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {

		String url = "jdbc:mysql://192.168.19.147:3066/ccrl_uat?useSSL=false&connectTimeout=120000&allowPublicKeyRetrieval=true";
		String username = "ccrl1";
		String password = "ccrl@123";

		/*
		 * String url =
		 * "jdbc:mysql://192.168.19.163:3066/live_dump_new?useSSL=false&connectTimeout=120000&allowPublicKeyRetrieval=true";
		 * String username = "ccrl"; String password = "Ccrl@pp0";
		 */

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("Connected successfully!");
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
	}
}