<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ include file="head.html" %>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="form">
		<h2>회원가입</h2>
		
		<form method="POST" action="Join" name="join" onsubmit="return checkValue();">
			<h3>필수 입력</h3>
			<div class="form-input">
				<label>아이디(이메일주소)<br />
					<input type="email" id="email" name="email" class="w3-input" maxlength="45" required>
					<input type="button" id="check_email" value="중복확인" class="w3-button w3-border" onclick="checkEmail()">
					<p id="check_email_m" class="msg"></p>
				</label>
				
				<label>비밀번호<br />
					<input type="password" name="pw" id="pw" class="w3-input w-100" onChange="checkPW()" maxlength="45" required>
				</label>
				<br />
				<label>비밀번호 확인<br />
					<input type="password" name="check_pw" class="w3-input w-100" id="check_pw" onKeyUp="checkPW()" required>
					<p id="check_pw_m" class="msg"></p>
				</label>

				<label>이름<br />
					<input type="text" name="name" class="w3-input w-100" maxlength="45" required><br />
				</label>
			</div>
			
			<hr>
		
			<h3>선택 입력</h3>
			<div class="form-input">
				<label>유형<br />
					<input type="text" name="type" class="w3-input w-100" maxlength="maxlength" placeholder="학생, 선생님 등"><br />	
				</label>
			</div>
			
			<%
			String join_msg = request.getParameter("join_msg");
			
			if (join_msg != null && join_msg.equals("0")){
				out.println("<br />");
				out.println("<p>회원가입에 실패했습니다. 다시 시도해 주십시오.</p>");
			}
			%>
			
			<input type="submit" name="submit" class="w3-button w3-border w3-padding w-90" value="가입하기">
			
		</form>
	</div>
	
	<script type="text/javascript" src="js/join.js" charset="UTF-8"></script>
</body>
</html>