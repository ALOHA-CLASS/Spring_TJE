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
	<h1>게시글 쓰기</h1>
	
	<form action="${ pageContext.request.contextPath }/board/insert" method="POST">
		<table>
			<tr>
				<td><label for="title">제목</label></td>
				<td><input type="text" name="title" placeholder="제목" /></td>
			</tr>
			<tr>
				<td><label for="writer">작성자</label></td>
				<td><input type="text" name="writer" placeholder="작성자" /></td>
			</tr>
			<tr>
				<td><label for="title">제목</label></td>
				<td>
					<textarea rows="5" cols="20" name="content" placeholder="내용"></textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="등록" />
	</form>
</body>
</html>