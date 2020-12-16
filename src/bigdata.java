import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.MemberDTO;

public class bigdata {
public static void main(String[] args) {
	bigdb b=new bigdb();
	b.putdb();
}
}
class bigdb{
	public  Connection getConnection() throws Exception {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/willdb";
		String user = "root";
		String password = "12345678";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);

		return con;

	}

	public  void putdb() {
		Connection con =null;
		PreparedStatement ps=null;
		ArrayList set=new ArrayList();
		while(set.size()<160) {
			int rnum=(int)(Math.random()*5);
							
					set.add(rnum);
			
		}
		//System.out.println(set);
		
		
		try {
			for(int i=589; i<601; i++) {
				System.out.println(i);
				//String[] str= {"아반떼","소나타","그렌져","제네시스","GV80"};	
			con = getConnection();
			String sql="update car set car_num="+i+" where car_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			//ps.setString(1,str[(int)set.get(i)]);
			//System.out.println(str[(int)set.get(i)]);
			ps.executeUpdate();
			}
			
		} catch (Exception e) {
			System.out.println("insertuse 구문쿼리 오류 : " + e); 
		}finally {
		if (ps!=null) {
			try {ps.close();} catch (SQLException e) {}		
		}
		if (con!=null) {
			try {con.close();} catch (SQLException e) {}		
		}	
			
			
		}

	}
}


