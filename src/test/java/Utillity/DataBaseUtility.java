package Utillity;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseUtility {


	public static Connection getConnection() throws Exception {
		 String url = "jdbc:mysql://192.168.19.147:3066/ccrl_uat?useSSL=false&connectTimeout=120000&allowPublicKeyRetrieval=true";
	        String username = "ccrl1";
	        String password = "ccrl@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

}
