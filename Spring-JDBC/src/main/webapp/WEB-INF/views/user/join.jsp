<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<form action="${ pageContext.request.contextPath }/user/join" method="POST">
		<input type="text" name="userId" placeholder="아이디" />	<br>
		<input type="text" name="userPw" placeholder="비밀번호" /> <br>
		<input type="text" name="name" placeholder="이름" />		<br>
		<input type="text" name="email" placeholder="이메일" />	<br>
		
		<input type="submit" value="회원가입" />
		
	</form>
</body>
</html>





