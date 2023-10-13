<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>board/list.jsp</h1>
	
	<c:forEach var="board" items="${boardList}">
		<div>
			<h2>${board.title}</h2>
			<h3>${board.writer}</h3>
			<p>${board.content}</p>
		</div>
	</c:forEach>
	
</body>
</html>











