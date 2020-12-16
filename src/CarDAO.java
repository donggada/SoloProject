import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class CarDAO {

	private static CarDAO instance = new CarDAO();

	private CarDAO() {
	}

	public static CarDAO getInstance() {
		return instance;
	}

	public int userCheck(String id, String pass) {
		int Count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getInstance().GetConnetion();

			String sql = "select * from member where id = ?;";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("password").equals(pass)) {
					Count = 1;
				} else {
					Count = 0;
				}

			} else {
				Count = -1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return Count;
	}

	public int userCheck2(String id, String pass) throws LoginFailException {
		int Count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getInstance().GetConnetion();

			String sql = "select * from member where id = ?;";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("password").equals(pass)) {
					Count = 1;
				} else {
					Count = 0;
					throw new LoginFailException("로그인 오류 : 일치하지 않는 패스워드");
				}

			} else {
				Count = -1;
				throw new LoginFailException("로그인 오류 : 아이디 없슴");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return Count;
	}

	public boolean insertMember(MemberBean mb) {
		boolean b = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnection.getInstance().GetConnetion();

			StringBuffer sql = new StringBuffer("insert into car");
			sql.append("(car_is_rent, car_maker, car_name, car_type,");
			sql.append(" car_people_max, car_people_possible, car_year, car_oil,");
			sql.append(" car_is_auto, car_license_type, car_license_year, car_need_year,");
			sql.append(" car_cc, car_price_normal, car_price_sale, car_function, car_trunk,");
			sql.append(" car_color, car_is_navi, car_is_pet, car_is_open, car_is_smoke)");
			sql.append(" values(?, ?, ?, ?,");
			sql.append("?, ?, ?, ?,");
			sql.append("?, ?, ?, ?,");
			sql.append("?, ?, ?, ?, ?,");
			sql.append("?, ?, ?, ?, ?)");
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setBoolean(1, mb.isCar_is_rent());
			pstmt.setString(2, mb.getCar_maker());
			pstmt.setString(3, mb.getCar_name());
			pstmt.setInt(4, mb.getCar_type());
			pstmt.setInt(5, mb.getCar_people_max());
			pstmt.setInt(6, mb.getCar_people_possible());
			pstmt.setInt(7, mb.getCar_year());
			pstmt.setInt(8, mb.getCar_oil());
			pstmt.setBoolean(9, mb.isCar_is_auto());
			pstmt.setInt(10, mb.getCar_license_type());
			pstmt.setInt(11, mb.getCar_license_year());
			pstmt.setInt(12, mb.getCar_need_year());
			pstmt.setInt(13, mb.getCar_cc());
			pstmt.setInt(14, mb.getCar_price_normal());
			pstmt.setInt(15, mb.getCar_price_sale());
			pstmt.setInt(16, mb.getCar_function());
			pstmt.setInt(17, mb.getCar_trunk());
			pstmt.setString(18, mb.getCar_color());
			pstmt.setBoolean(19, mb.isCar_is_navi());
			pstmt.setBoolean(20, mb.isCar_is_pet());
			pstmt.setBoolean(21, mb.isCar_is_open());
			pstmt.setBoolean(22, mb.isCar_is_smoke());
			
			if(pstmt.executeUpdate() == 0) {
				b = false;
			}else {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
		return b;
	}

	public ArrayList<Vector> getMemberList() throws LoginFailException {
		int Count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Vector> memberList = new ArrayList<Vector>();
		MemberBean mb = new MemberBean();

		try {
			con = DBConnection.getInstance().GetConnetion();

			String sql = "select * from car";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mb.setCar_cc(rs.getInt("car_cc"));
				mb.setCar_color(rs.getString("car_color"));
				mb.setCar_function(rs.getInt("car_function"));
				mb.setCar_id(rs.getInt("car_id")); //
				mb.setCar_is_auto(rs.getBoolean("car_is_auto"));
				mb.setCar_is_navi(rs.getBoolean("car_is_navi"));
				mb.setCar_is_open(rs.getBoolean("car_is_open"));
				mb.setCar_is_pet(rs.getBoolean("car_is_pet"));
				mb.setCar_is_rent(rs.getBoolean("car_is_rent"));
				mb.setCar_is_smoke(rs.getBoolean("car_is_smoke"));
				mb.setCar_license_type(rs.getInt("car_license_type"));
				mb.setCar_license_year(rs.getInt("car_license_year"));
				mb.setCar_maker(rs.getString("car_maker")); //
				mb.setCar_name(rs.getString("car_name")); //
				mb.setCar_need_year(rs.getInt("car_need_year"));
				mb.setCar_oil(rs.getInt("car_oil"));
				mb.setCar_people_max(rs.getInt("car_people_max")); //
				mb.setCar_people_possible(rs.getInt("car_people_possible")); //
				mb.setCar_price_normal(rs.getInt("car_price_normal"));
				mb.setCar_price_sale(rs.getInt("car_price_sale"));
				mb.setCar_trunk(rs.getInt("car_trunk"));
				mb.setCar_type(rs.getInt("car_type")); //
				mb.setCar_year(rs.getInt("car_year"));

				Vector v = new Vector();
				v.add(mb.getCar_id());
				v.add(mb.getCar_name());
				v.add(mb.isCar_is_rent());
				v.add(mb.getCar_maker());
				v.add(mb.getCar_type());
				
				v.add(mb.getCar_people_max());
				v.add(mb.getCar_people_possible());
				v.add(mb.getCar_year());
				v.add(mb.getCar_oil());
				v.add(mb.isCar_is_auto());
				
				v.add(mb.getCar_license_type());
				v.add(mb.getCar_license_year());
				v.add(mb.getCar_need_year());
				v.add(mb.getCar_cc());
				v.add(mb.getCar_price_normal());
				
				v.add(mb.getCar_price_sale());
				v.add(mb.getCar_function());
				v.add(mb.getCar_trunk());
				v.add(mb.getCar_color());
				v.add(mb.isCar_is_navi());
				
				v.add(mb.isCar_is_pet());
				v.add(mb.isCar_is_open());
				v.add(mb.isCar_is_smoke());

				memberList.add(v);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return memberList;
	}

	public boolean deleteMember(int idx) {
		int Count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnection.getInstance().GetConnetion();

			String sql = "delete from car where car_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);

			Count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		boolean b = false;

		if (Count != 0) {
			b = true;
		}

		return b;
	}

}

class LoginFailException extends Exception {

	public LoginFailException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
