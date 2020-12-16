package ImgDate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ImgDateDAO {

	public Connection getConnection() throws Exception {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jspdb5";
		String user = "root";
		String password = "12345678";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);

		return con;

	}
	
	public void FileUpload(ImgDataDTO idto ) {
		Connection con =null;
		PreparedStatement ps=null;
		try {
			
			con = getConnection();
			String sql="select max(num) from imgdate";
			ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

				idto.setNum(rs.getInt("max(num)")+1);	
			sql ="insert into imgdate(num,readcount,subject,fileName1,originalName,name,content,type,id,likecount) values(?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idto.getNum());
			ps.setInt(2, idto.getReadcount());
			ps.setString(3, idto.getSubject());
			ps.setString(4, idto.getFileName1());
			ps.setString(5, idto.getOriginalName1());
			ps.setString(6, idto.getName());
			ps.setString(7, idto.getCotent());
			ps.setInt(8, idto.getType());
			ps.setString(9, idto.getId());
			ps.setInt(10, idto.getLikecount());
			ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("이미지파일업로드 오류"+e);
		}finally {
			if (ps!=null) {
				try {ps.close();} catch (SQLException e) {}		
			}
			if (con!=null) {
				try {con.close();} catch (SQLException e) {}		
			}	
				
				
			}
	}
	
	
	public ArrayList<ImgDataDTO> ImgUploadList(int startRow,int pageSize,int type) {
		ArrayList<ImgDataDTO> arr= new ArrayList<ImgDataDTO>();
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			if(type==0) {
			 con = getConnection();
			String sql = "select *from imgdate order by num desc limit ?,?";
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, startRow);
			 ps.setInt(2,pageSize);
			 rs = ps.executeQuery();
			
			while (rs.next()) {
				ImgDataDTO ddto =new ImgDataDTO();
				ddto.setNum(rs.getInt(1));
				ddto.setReadcount(rs.getInt(2));;
				ddto.setSubject(rs.getString(3));
				ddto.setFileName1(rs.getString(4));
				ddto.setOriginalName1(rs.getString(5));
				ddto.setName(rs.getString(6));
				ddto.setCotent(rs.getString(7));
				ddto.setId(rs.getString(9));
				ddto.setLikecount(rs.getInt(10));
				ddto.setType(rs.getInt("type"));
				arr.add(ddto);
			}
				
			}else {
				con = getConnection();
				String sql = "select *from imgdate where type=? order by num desc limit ?,?  ";
				 ps = con.prepareStatement(sql);
				 ps.setInt(1, type);
				 ps.setInt(2, startRow);
				 ps.setInt(3,pageSize);
				 
				 
				 rs = ps.executeQuery();
				 
				
				while (rs.next()) {
					ImgDataDTO ddto =new ImgDataDTO();
					ddto.setNum(rs.getInt(1));
					ddto.setReadcount(rs.getInt(2));;
					ddto.setSubject(rs.getString(3));
					ddto.setFileName1(rs.getString(4));
					ddto.setOriginalName1(rs.getString(5));
					ddto.setName(rs.getString(6));
					ddto.setCotent(rs.getString(7));
					ddto.setId(rs.getString(9));
					ddto.setLikecount(rs.getInt(10));
					ddto.setType(rs.getInt("type"));
					arr.add(ddto);
				
			}
			
			}

		} catch (Exception e) {
System.out.println("List 메서드 오류"+e);
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
	

	public ArrayList<ImgDataDTO> ImgLook(int num) {
		ArrayList<ImgDataDTO> arr= new ArrayList<ImgDataDTO>();
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			 con = getConnection();
			 String sql="update imgdate set readcount=readcount+1 where num=?";
				 ps = con.prepareStatement(sql);
				 ps.setInt(1, num);
				 ps.executeUpdate();
			sql = "select *from imgdate where num=?";
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, num);
			 rs = ps.executeQuery();
			
			while (rs.next()) {
				ImgDataDTO ddto =new ImgDataDTO();
				ddto.setNum(rs.getInt(1));
				ddto.setReadcount(rs.getInt(2));;
				ddto.setSubject(rs.getString(3));
				ddto.setFileName1(rs.getString(4));
				ddto.setOriginalName1(rs.getString(5));
				ddto.setName(rs.getString(6));
				ddto.setCotent(rs.getString(7));
				ddto.setId(rs.getString(9));
				ddto.setLikecount(rs.getInt(10));
				ddto.setType(rs.getInt("type"));
				arr.add(ddto);
			}

		} catch (Exception e) {
System.out.println("ImgLook 메서드 오류"+e);
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
public ArrayList<ImgDataDTO> myloadList(int type ,String id) {
	ArrayList<ImgDataDTO> arr= new ArrayList<ImgDataDTO>();
	Connection con =null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	try {
		if(type==0) {
		 con = getConnection();
		String sql = "select *from imgdate where id=? order by num desc";
		 ps = con.prepareStatement(sql);
		 ps.setString(1, id);
		 rs = ps.executeQuery();
		
		while (rs.next()) {
			ImgDataDTO ddto =new ImgDataDTO();
			ddto.setNum(rs.getInt(1));
			ddto.setReadcount(rs.getInt(2));;
			ddto.setSubject(rs.getString(3));
			ddto.setFileName1(rs.getString(4));
			ddto.setOriginalName1(rs.getString(5));
			ddto.setName(rs.getString(6));
			ddto.setCotent(rs.getString(7));
			ddto.setId(rs.getString(9));
			ddto.setLikecount(rs.getInt(10));
			ddto.setType(rs.getInt("type"));
			arr.add(ddto);
		}
			
		}else {
			con = getConnection();
			String sql = "select *from imgdate where type=? and id=? order by num desc";
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, type);
			 ps.setString(2, id);
			 rs = ps.executeQuery();
			 
			
			while (rs.next()) {
				ImgDataDTO ddto =new ImgDataDTO();
				ddto.setNum(rs.getInt(1));
				ddto.setReadcount(rs.getInt(2));;
				ddto.setSubject(rs.getString(3));
				ddto.setFileName1(rs.getString(4));
				ddto.setOriginalName1(rs.getString(5));
				ddto.setName(rs.getString(6));
				ddto.setCotent(rs.getString(7));
				ddto.setId(rs.getString(9));
				ddto.setLikecount(rs.getInt(10));
				ddto.setType(rs.getInt("type"));
				arr.add(ddto);
			
		}
		
		}

	} catch (Exception e) {
System.out.println("MyList 메서드 오류"+e);
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
		String sql = "select count(*) from imgdate";
		 ps = con.prepareStatement(sql);
		
		 rs = ps.executeQuery();
		
		if (rs.next()) {
			
			count =rs.getInt(1);
		}

	} catch (Exception e) {
System.out.println("getimgdateCount 메서드 오류"+e);
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

public void likecount(int num) {
	Connection con =null;
	PreparedStatement ps=null;
	
	try {
		con = getConnection();
		 String sql="update imgdate set likecount=likecount+1 where num=?";
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, num);
			 ps.executeUpdate();
		
	} catch (Exception e) {
		System.out.println("like오류"+e);
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
