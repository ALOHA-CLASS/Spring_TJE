<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="board.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Board> boardList = (List<Board>) request.getAttribute("boardList");
	// out.print("count : " + boardList.size());
	boardList = boardList == null ? new ArrayList<Board>() : boardList;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>board/list.jsp</h1>
	<h2><%= "count : " + boardList.size() %></h2>
	<%
		for( int i=0 ; i < boardList.size() ; i++ ) {
			Board board = boardList.get(i);	
	%>
		<h3><%= board.getTitle()  %>, <%= board.getWriter()  %>, <%= board.getContent()  %></h3>
	<%
		}
	%>
</body>
</html>











