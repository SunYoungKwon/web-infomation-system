<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ include file="head.html" %>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="form">
		<h2>로그인</h2>
		
		<form name="login" method="POST" action="Login">
			<label>아이디(이메일주소)<br />
			 	<input type="email" class="w3-input w-100" name="email" maxlength="45" required>
			</label>
			<br />
			<label>비밀번호<br />
				<input type="password" class="w3-input w-100" name="password" maxlength="45" required>
			</label>
			
			<%
			String login_msg = request.getParameter("login_msg");
			
			if (login_msg != null && login_msg.equals("0")){
				out.println("<br />");
				out.println("<p>등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다</p>");
			}
			else if (login_msg != null && login_msg.equals("-1")){
				out.println("<br />");
				out.println("<p>시스템 오류: DB에 연결할 수 없습니다</p>");
			}
			%>
			
			<br />
			<input type="submit" class="w3-button w3-border w3-padding w-45" value="로그인">
			<input type="button" class="w3-button w3-border w3-padding w-45" value="회원가입" onclick="location.href='join.jsp'">
		</form>
	</div>
	
</body>
</html>