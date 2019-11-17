package ss.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
	
    public LoginModel(){}
    
	public int doLogin(Connection conn, String user_id, String user_pw) throws SQLException {
	        ResultSet rs = null;		// query실행 결과 저장을 위한 객체

	        try {
	        	PreparedStatement pstmt = conn.prepareStatement("SELECT PW FROM user WHERE Email =\"" + user_id + "\"");
	            rs = pstmt.executeQuery();		// query실행 결과를 저장
	            
	            if(rs.next()){								// 입력된 아이디에 해당되는 정보가 있을 경우
	                if(rs.getString(1).equals(user_pw))		// 비밀번호가 입력받은 값(user_pw)과 같다면
	                    return 1;    						// 로그인 성공
	                else
	                    return 0; 		// 비밀번호 불일치
	            }
	            return 0; 				// ID가 존재하지 않음
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return -1; 					// DB 연결 오류
	    }
	
}
