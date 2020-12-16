package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	public void insertMember(MemberDTO m) {
		Connection con =null;
		PreparedStatement ps=null;
		
		try {
			con = getConnection();
			String sql="select max(num) from user";
			ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				m.setNum(rs.getInt("max(num)")+1);	
			sql ="insert into user(id,pass,name,jumin,gender,tel,email,address,num) values(?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPass());
			ps.setString(3, m.getName());
			ps.setString(4, m.getJumin());
			ps.setString(5,m.getGender());	
			ps.setString(6,m.getTel());	
			ps.setString(7,m.getEmail());
			ps.setString(8,m.getAddress());
			ps.setInt(9, m.getNum());
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

	public MemberDTO getmember(String id) {

		MemberDTO bb = new MemberDTO();
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con = getConnection();
			String sql = "select *from user where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				bb.setIDoverLapcheck("아이디있음");
				bb.setId(rs.getString("id"));
				bb.setName(rs.getString("name"));
				bb.setPass(rs.getString("pass"));
				bb.setJumin(rs.getString("jumin"));
				bb.setGender(rs.getString("gender"));
				bb.setAddress(rs.getString("address"));
				bb.setTel(rs.getString("tel"));
				bb.setEmail(rs.getString("email"));
			}else {
				bb.setIDoverLapcheck("아이디없음");
			}
		} catch (Exception e) {

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

		return bb;
	}

	public int userCheck(String id, String pass) {
		int check = -1;
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			 con = getConnection();
			String sql = "select *from user where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (pass.equals(rs.getString("pass"))) {
					check = 1;
				} else {
					check = 0;
				}
			} else {
				check = -1;
			}

		} catch (Exception e) {
			System.out.println("userCheck 오류발생"+e);
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

		return check;
	}

	public void updateMember(MemberDTO m) {
		Connection con =null;
		PreparedStatement ps=null;
		try {
			con = getConnection();
			String sql = "update user set pass=?, name=?, tel=?, address=?, email=? where id=?";
			 ps = con.prepareStatement(sql);
			ps.setString(1, m.getPass());
			ps.setString(2, m.getName());
			ps.setString(3, m.getTel());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getEmail());
			ps.setString(6, m.getId());
			ps.executeUpdate();
		} catch (Exception e) {

		} finally {
			if (ps!=null) try {ps.close();} catch (SQLException e) {}		
			if (con!=null) try {con.close();} catch (SQLException e) {}		
			

		}
	}

	public Connection getConnection() throws Exception {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jspdb5";
		String user = "root";
		String password = "12345678";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);

		return con;

	}

	public void deleteMember(String id) {
		Connection con =null;
		PreparedStatement ps=null;
		try {
			con = getConnection();
			String sql = "delete from user where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {

		} finally {
			if (ps!=null) try {ps.close();} catch (SQLException e) {}
		if (con!=null) try {con.close();} catch (SQLException e) {}		
			
			 
		}
	}

	public ArrayList selectMember() {
		MemberDTO mb = null;
		ArrayList list = null;
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			 con = getConnection();
			String sql = "select *from user";
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				mb = new MemberDTO();
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("name"));
				mb.setJumin(rs.getString("jumin"));
				list.add(mb);
			}

		} catch (Exception e) {
System.out.println("select 메서드 오류"+e);
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
		return list;
	}

	public int juminCheck(String jumin) {
		int check=0;
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			 con = getConnection();
			String sql = "select *from user where jumin=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, jumin);
			rs = ps.executeQuery();
			if (rs.next()) {
				MemberDTO mdto=new MemberDTO();
				mdto.setName(rs.getString("name"));
				check=1; // 주민번호에 등록된 아이디 있음
			} else {
				check=-1; //주민번호에 등록된 아이디 없음
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			
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
		
		return check;
	}
	
	public MemberDTO IDFind (String jumin,String name) {
		MemberDTO mdto=null;
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			 con = getConnection();
			String sql = "select *from user where jumin=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, jumin);
			rs = ps.executeQuery();
			mdto=new MemberDTO();
			if (rs.next()) {
				if (name.equals(rs.getString("name"))) {
					mdto.setId(rs.getString("id"));  
					mdto.setIDoverLapcheck("찾음");    // 주민번호에 등록된 아이디 있음
				}else {
					mdto.setIDoverLapcheck("이름다름");  //주민번호 맞고 이름이 다름
					}
				} 	else {
				mdto.setIDoverLapcheck("아이디없음");   //주민번호에 등록된 아이디 없음
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			
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
		
		return mdto;
	}
	public int PassFind(String id, String jumin,String name) {
		int check = -1;
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			 con = getConnection();
			String sql = "select *from user where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (jumin.equals(rs.getString("jumin"))) {
					if(name.equals(rs.getString("name"))) {
						check = 2;		
					}else {
						check=1;
					}
				} else {
					check = 0;
				}
			} else {
				check = -1;
			}

		} catch (Exception e) {
			
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

		return check;
	}
	public void passupdate(String pass ,String id) {
		Connection con =null;
		PreparedStatement ps=null;
		try {
			con = getConnection();
			String sql = "update user set pass=? where id=? ";
			 ps = con.prepareStatement(sql);
			ps.setString(1,pass);
			ps.setString(2, id);
			ps.executeUpdate();
		} catch (Exception e) {

		} finally {
			if (ps!=null) try {ps.close();} catch (SQLException e) {}		
			if (con!=null) try {con.close();} catch (SQLException e) {}		
			

		}
	
	}
	
	public int getMember() {
		int count=0;
		
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			 con = getConnection();
			String sql = "select count(*) from user";
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
		if(rs.next()) {
			count=rs.getInt(1);
		}
			

		} catch (Exception e) {
System.out.println("select 메서드 오류"+e);
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
