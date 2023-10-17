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
	<h1>게시글 읽기</h1>
	
	<form action="${ pageContext.request.contextPath }/board/delete" method="POST">
		<input type="hidden" name="boardNo" value="${board.boardNo}" />
		<table>
			<tr>
				<td><label for="title">제목</label></td>
				<td><input type="text" name="title" value="${board.title}" /></td>
			</tr>
			<tr>
				<td><label for="writer">작성자</label></td>
				<td><input type="text" name="writer" value="${board.writer}" /></td>
			</tr>
			<tr>
				<td><label for="title">제목</label></td>
				<td>
					<textarea rows="5" cols="20" name="content" >${board.content}</textarea>
				</td>
			</tr>
		</table>
		<div>
			<a href="${ pageContext.request.contextPath }/board/update?boardNo=${board.boardNo}">수정</a>
			<input type="submit" value="삭제" />
		</div>
	</form>
</body>
</html>





