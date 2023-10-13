<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<% String root = request.getContextPath(); %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<ul>
	<li><a href="<%= root %>/board/list">list</a></li>
	<li><a href="<%= root %>/board/insert">insert</a></li>
	<li><a href="<%= root %>/board/read?boardNo=10">read</a></li>
	<li><a href="<%= root %>/board/update?boardNo=10"">update</a></li>
</ul>
</body>
</html>








