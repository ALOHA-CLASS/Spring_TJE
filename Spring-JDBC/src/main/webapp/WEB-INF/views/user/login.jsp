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
	<h1>로그인</h1>
	
	<form action="${ pageContext.request.contextPath }/user/login" method="POST">
		<input type="text" name="userId" placeholder="아이디" />	<br>
		<input type="text" name="userPw" placeholder="비밀번호" /> <br>
		<input type="submit" value="로그인" /> <br>
		<div>
			<c:if test="${ param.error != null }">
				<span style="color: red;">로그인에 실패하였습니다.</span>
			</c:if>
		</div>
	</form>
	
</body>
</html>














