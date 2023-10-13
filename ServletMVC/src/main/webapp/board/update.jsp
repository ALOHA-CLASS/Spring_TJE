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
	<h1>board/update.jsp</h1>
	<form action="<%= root %>/board/updatePro.do">
		<input type="text" name="title" value="<%= board.getTitle() %>" /><br>
		<input type="text" name="writer" value="<%= board.getWriter() %>" /><br>
		<textarea rows="5" cols="40" name="content"><%= board.getContent() %></textarea> <br>
		<input type="submit" value="수정">
	</form>
	<form action="<%= root %>/board/deletePro.do">
		<input type="submit" value="삭제">
	</form>
</body>
</html>











