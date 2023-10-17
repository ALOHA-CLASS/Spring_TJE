<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	
	<a href="${ pageContext.request.contextPath }/board/insert">글쓰기</a>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일자</th>
			<th>수정일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td align="center">${board.boardNo}</td>		
				<td width="300">
					<a href="${ pageContext.request.contextPath }/board/read?boardNo=${board.boardNo}">
						${board.title}
					</a>
				</td>		
				<td align="center" width="120">${board.writer}</td>		
<%-- 				<td align="center">${board.regDate}</td>		 --%>
				<td align="center">
					<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>		
<%-- 				<td align="center">${board.updDate}</td>		 --%>
				<td align="center">
					<fmt:formatDate value="${board.updDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>		
				<td align="center">${board.views}</td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>





