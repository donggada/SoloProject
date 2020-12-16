
	package DateRoom;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.ArrayList;

import member.MemberDTO;


	public class DateRoomDAO {
		
		public Connection getConnection() throws Exception {

			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/jspdb5";
			String user = "root";
			String password = "12345678";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);

			return con;

		}

		public void FileUpload(DateRoomDTO dd) {
			Connection con =null;
			PreparedStatement ps=null;
			try {
				
				con = getConnection();
				String sql="select max(num) from dateroom";
				ps = con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					dd.setNum(rs.getInt("max(num)")+1);	
				sql ="insert into dateroom(num,readcount,subject,fileName1,originalName1,name,content) values(?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, dd.getNum());
				ps.setInt(2, dd.getReadcount());
				ps.setString(3, dd.getSubject());
				ps.setString(4, dd.getFileName1());
				ps.setString(5, dd.getOriginalName1());
				ps.setString(6, dd.getName());
				ps.setString(7, dd.getCotent());
				ps.executeUpdate();
				}
			} catch (Exception e) {
				System.out.println("파일업로드 오류"+e);
			}finally {
				if (ps!=null) {
					try {ps.close();} catch (SQLException e) {}		
				}
				if (con!=null) {
					try {con.close();} catch (SQLException e) {}		
				}	
					
					
				}
		}
		
		public ArrayList<DateRoomDTO> DateList(int startRow,int pageSize) {
			ArrayList<DateRoomDTO> arr= new ArrayList<DateRoomDTO>();
			Connection con =null;
			PreparedStatement ps=null;
			ResultSet rs=null;

			try {
				 con = getConnection();
				String sql = "select *from dateroom order by num desc limit ?,? ";
				 ps = con.prepareStatement(sql);
				 ps.setInt(1, startRow);
				 ps.setInt(2,pageSize);
				
				 rs = ps.executeQuery();
				
				while (rs.next()) {
					DateRoomDTO ddto =new DateRoomDTO();
					ddto.setNum(rs.getInt(1));
					ddto.setReadcount(rs.getInt(2));;
					ddto.setSubject(rs.getString(3));
					ddto.setFileName1(rs.getString(4));
					ddto.setOriginalName1(rs.getString(5));
					ddto.setName(rs.getString(6));
					ddto.setCotent(rs.getString(7));
					arr.add(ddto);
				}

			} catch (Exception e) {
	System.out.println("DateList 메서드 오류"+e);
			}finally {
				if (rs!=null) {
					try {rs.close();} catch (SQLException e) {}		
				}			
				if (ps!=null) {
					try {ps.close();} catch (SQLException e) {}		
				}
				if (con!=null) {
					try {con.close();} catch (SQLException e) {}		
				}	
									
						}
			
			return arr;
		}
		
		public ArrayList<DateRoomDTO> FileDown(int num) {
			ArrayList<DateRoomDTO> arr= new ArrayList<DateRoomDTO>();
			Connection con =null;
			PreparedStatement ps=null;
			ResultSet rs=null;

			try {
				 con = getConnection();
				 String sql="update dateroom set readcount=readcount+1 where num=?";
				 ps = con.prepareStatement(sql);
				 ps.setInt(1, num);
				 ps.executeUpdate();
				 sql = "select *from dateroom where num=?";
				 ps = con.prepareStatement(sql);
			
				 ps.setInt(1, num);
				 
				 rs = ps.executeQuery();
				
				while (rs.next()) {
					DateRoomDTO ddto =new DateRoomDTO();
					ddto.setNum(rs.getInt(1));
					ddto.setReadcount(rs.getInt(2));;
					ddto.setSubject(rs.getString(3));
					ddto.setFileName1(rs.getString(4));
					ddto.setOriginalName1(rs.getString(5));
					ddto.setName(rs.getString(6));
					ddto.setCotent(rs.getString(7));
					arr.add(ddto);
				}

			} catch (Exception e) {
	System.out.println("DateList 메서드 오류"+e);
			}finally {
				if (rs!=null) {
					try {rs.close();} catch (SQLException e) {}		
				}			
				if (ps!=null) {
					try {ps.close();} catch (SQLException e) {}		
				}
				if (con!=null) {
					try {con.close();} catch (SQLException e) {}		
				}	
									
						}
			
			return arr;
		}
		
		public int getdateCount() {
			int count=0;
			Connection con =null;
			PreparedStatement ps=null;
			ResultSet rs=null;

			try {
				 con = getConnection();
				String sql = "select count(*) from dateroom";
				 ps = con.prepareStatement(sql);
				
				 rs = ps.executeQuery();
				
				if (rs.next()) {
					
					count =rs.getInt(1);
				}

			} catch (Exception e) {
	System.out.println("getdateCount 메서드 오류"+e);
			}finally {
				if (rs!=null) {
					try {rs.close();} catch (SQLException e) {}		
				}			
				if (ps!=null) {
					try {ps.close();} catch (SQLException e) {}		
				}
				if (con!=null) {
					try {con.close();} catch (SQLException e) {}		
				}	
									
						}
			
			return count;
		}
		
	}

	

