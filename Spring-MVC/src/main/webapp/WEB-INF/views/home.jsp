<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<h3>/board</h3>
	<ul>
		<li><a href="${ pageContext.request.contextPath }/board/list">list</a></li>
		<li><a href="${ pageContext.request.contextPath }/board/insert">insert</a></li>
		<li><a href="${ pageContext.request.contextPath }/board/read?boardNo=10">read</a></li>
		<li><a href="${ pageContext.request.contextPath }/board/update?boardNo=10">update</a></li>
	</ul>
	<hr>
	<h3>/model</h3>
	<ul>
		<li><a href="${ pageContext.request.contextPath }/model/person">person</a></li>
		<li><a href="${ pageContext.request.contextPath }/model/person2">person2</a></li>
	</ul>
	<hr>
	<h3>/response</h3>
	<ul>
		<li><a href="${ pageContext.request.contextPath }/response/index">index</a></li>
		<li><a href="${ pageContext.request.contextPath }/response/view">view</a></li>
		<li><a href="${ pageContext.request.contextPath }/response/model/view">model/view</a></li>
		<li><a href="${ pageContext.request.contextPath }/response/data/board">data/board</a></li>
		<li><a href="${ pageContext.request.contextPath }/response/data/board/list">data/board/list</a></li>
		<li><a href="${ pageContext.request.contextPath }/response/data/map">data/map</a></li>
		<li><a href="${ pageContext.request.contextPath }/response/data/entity/void">data/entity/void</a></li>
		<li><a href="${ pageContext.request.contextPath }/response/data/entity/string">data/entity/string</a></li>
		<li><a href="${ pageContext.request.contextPath }/response/data/file">data/file</a></li>
	</ul>
	<hr>
	<h3>/request</h3>
	<ul>
		<li><a href="${ pageContext.request.contextPath }/request/list">list</a></li>
		<li><a href="${ pageContext.request.contextPath }/request/insert">insert</a></li>
		<li><a href="${ pageContext.request.contextPath }/request/read?boardNo=10">read</a></li>
		<li><a href="${ pageContext.request.contextPath }/request/update?boardNo=10">update</a></li>
	</ul>
	<hr>


</body>
</html>








