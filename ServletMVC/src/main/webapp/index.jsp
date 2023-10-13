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
	<h1>Servlet MVC</h1>
	<ul>
		<li><a href="<%= root %>/board/list.do">list</a></li>
		<li><a href="<%= root %>/board/insert.do">insert</a></li>
		<li><a href="<%= root %>/board/read.do">read</a></li>
		<li><a href="<%= root %>/board/update.do">upadte</a></li>
	</ul>
	
</body>
</html>