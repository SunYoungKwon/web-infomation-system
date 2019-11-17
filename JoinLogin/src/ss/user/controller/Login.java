package ss.user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ss.user.model.LoginModel;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		Connection conn = (Connection) context.getAttribute("DBConnection");		// DB연결을 위한 객체 생성
		
		String id = request.getParameter("email");			// 입력된 아이디(email)
		String pw = request.getParameter("password");		// 입력된 비밀번호
		String login_msg = null;							// 로그인 성공여부에 따른 결과 URL저장

		HttpSession session = request.getSession(); 		// 로그인 유지를 위애 현재 로그인 정보를 저장하기위한 session

		try {
			LoginModel loginM = new LoginModel(); 				// LoginModel 객체 생성
			int loginResult = loginM.doLogin(conn, id, pw); 	// 로그인 시도

			if (loginResult == 1) { 							// 로그인 성공
				session.setAttribute("id", id); 				// session에 현재 아이디값 저장
				login_msg = "../JoinLogin/index.jsp"; 		// index.jsp페이지로 이동하는 URL
			} else if (loginResult == 0) { 						// 비밀번호 불일치 or 아이디가 존재하지 않음
				System.out.println("The ID does not exist or it is wrong PW");
				login_msg = "../JoinLogin/login.jsp?login_msg=0"; 			// 안내문구 출력을 위한 정보 전달
			} else if (loginResult == -1) { 					// DB연결 실패
				System.out.println("DB connection error");
				login_msg = "../JoinLogin/login.jsp?login_msg=-1"; 			// 안내문구 출력을 위한 정보 전달
			}

			response.sendRedirect(login_msg); 				// 해당 URL로 이동
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
