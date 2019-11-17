package ss.user.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ss.user.model.JoinModel;

@WebServlet("/Join")
public class Join extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Join() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		Connection conn = (Connection) context.getAttribute("DBConnection");		// DB연결을 위한 객체 생성

		// 입력된 사용자 정보 가져오기
		String email, pw, name, type;
		email = request.getParameter("email");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		type = request.getParameter("type");
		
		boolean joinResult = false;
		
		try {
			joinResult = JoinModel.doJoin(conn, email, pw, name, type);

			String join_msg;						// 회원가입 실패 시 표시할 안내문구에 대한 정보 저장

			if (joinResult == true) {							// Join성공
				System.out.println("Succeed insertion");
				join_msg = "../JoinLogin/login.jsp";		// login페이지로 이동
			} else {											// DB에 회원정보 INSERT 실패
				System.out.println("Fail insertion");
				join_msg = "../JoinLogin/join.jsp?join_msg=0";		// 회원가입 실패 안내문구 풀력을 위한 정보 전달
			}
			
			response.sendRedirect(join_msg); 	// 해당 URL로 이동
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
