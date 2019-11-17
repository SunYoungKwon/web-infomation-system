package ss.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinModel {

	public static boolean doCheckEmail(Connection conn, String email) {
		String query = "SELECT Email FROM user WHERE Email = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("This id(e-mail) already exist.");
				return false;
			} else {
				return true;		// 사용가능한 아이디(email)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean doJoin(Connection conn, String email, String pw, String name, String type) throws SQLException {

		String query = "INSERT INTO user VALUES('" + email + "', '" + pw + "', '" + name + "', '" + type + "')";		 // 입력받은 정보를 db에 추가하는 쿼리문																											

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			int i = pstmt.executeUpdate();

			if (i == 1) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}
}
