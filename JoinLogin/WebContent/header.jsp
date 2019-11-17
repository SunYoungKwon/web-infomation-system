<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="bg-deep-green">
	<div class="w3-display-container page-max-w">
		<%-- Logo --%>
		<div class="w3-margin-left w3-display-left">
	  		<h1 id="logo">
	  			<a href="index.jsp">Search Symbols</a>
	  		</h1>
  		</div>
  		
  		<%-- Header Buttons --%>
  		<div class="w3-padding w3-display-right w3-text-white">	
	  		<c:set var="userId" scope="page" value="${sessionScope.id }" />
	  		
	  		<c:choose>
	  			<c:when test="${userId eq null }">
	  				<a href="login.jsp" class="w3-padding-small w3-hide-small">로그인</a>
	  				<a href="join.jsp" class="w3-padding-small w3-hide-small">회원가입</a>
	  			</c:when>
	  			<c:otherwise>
	  				<a href="./Logout" class="w3-padding-small w3-hide-small">로그아웃</a>
	  			</c:otherwise>
	  		</c:choose>
	  		
	  		<c:remove var="userId" scope="page" />
	  		
  		</div>
 	</div>
 </header>