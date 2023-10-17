<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Spring JDBC</h1>
	
	<c:if test="${ userId != null }">
		<h3>ID : ${userId}</h3>
	</c:if>
	
	<ul>
		<li><a href="${ pageContext.request.contextPath }/user/login">로그인</li>
		<li><a href="${ pageContext.request.contextPath }/user/join">회원가입</li>
		<li><a href="${ pageContext.request.contextPath }/board/list">게시판</li>
	</ul>
	

</body>
</html>
