<%@page import="com.joeun.test.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>board/update.jsp</h1>
	<!-- form 태그는 요청메소드 GET/POST 방식만 지원 -->
	<form action="${ pageContext.request.contextPath }/board/update" method="POST">
		<!-- HiddenHttpMethodFilter 필터를 사용하여 PUT 방식으로 요청 -->
		<input type="hidden" name="_method" value="PUT" />
		<input type="text" name="title" value="${ board.title }" /><br>
		<input type="text" name="writer" value="${ board.writer }" /><br>
		<textarea rows="5" cols="40" name="content">${ board.content }</textarea> <br>
		<input type="submit" value="수정">
	</form>
	<form action="${ pageContext.request.contextPath }/board/delete">
		<input type="submit" value="삭제">
	</form>
</body>
</html>















