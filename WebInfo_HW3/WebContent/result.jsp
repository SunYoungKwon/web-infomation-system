<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>계산결과</title>
</head>
<body>
	<div class="content-box">
		<h1>계산결과</h1>	
		<div class="content">
		
			<%
			String resultStr = (String) request.getAttribute("resultStr");
			%>
			
			<p class="result"><%=resultStr %></p><br>
			<div class="center">
				<a href="index.html" class="btn-retry btn">다시하기</a>
			</div>
		</div>
	</div>
</body>
</html>