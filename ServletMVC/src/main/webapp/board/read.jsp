<%@page import="board.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Board board = (Board) request.getAttribute("board");
	String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>board/read.jsp</h1>
	<h2><%= board.getTitle() %></h2>
	<h3><%= board.getWriter() %></h3>
	<p>
		<%= board.getContent() %>
	</p>
	<form action="<%= root %>/board/deletePro.do">
		<input type="submit" value="삭제">
	</form>
</body>
</html>




