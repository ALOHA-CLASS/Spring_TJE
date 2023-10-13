<%@page import="com.joeun.test.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>board/insert.jsp</h1>
	<form action="<%= root %>/board/insertPro.do">
		<input type="text" name="title"  /><br>
		<input type="text" name="writer" /><br>
		<textarea rows="5" cols="40" name="content"></textarea> <br>
		<input type="submit" value="등록">
	</form>
</body>
</html>











