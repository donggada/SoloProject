import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection instance = new DBConnection();
	private String url;
	private DBConnection() {};
	
	public static DBConnection getInstance() {
		return instance;
	}
	
	
	public void setIp(String ip) {
		url = "jdbc:mysql://" + ip + ":3306/willdb";
	}
	
	public Connection GetConnetion() {

		Connection con = null;
	
		String user = "root";
		String password = "12345678";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
		
	}
	
}
