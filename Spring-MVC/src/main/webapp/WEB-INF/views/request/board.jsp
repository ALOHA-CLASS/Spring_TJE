<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/request/board.jsp</h1>
	
	<form action="${ pageContext.request.contextPath }/request/board" method="POST">
		<input type="text" name="boardNo" />
		<input type="submit" value="등록" />
		
	</form>
	
	<hr>
	
	<h3>/request/body</h3>
	<form action="${ pageContext.request.contextPath }/request/body" method="POST">
		<input type="text" name="title" placeholder="제목"/> <br>
		<input type="text" name="writer" placeholder="작성자" /> <br>
		<input type="text" name="content" placeholder="내용" /> <br>
		<input type="submit" value="등록" />
	</form>
	
	<hr>
	
	<h3>/request/check</h3>
	<form action="${ pageContext.request.contextPath }/request/check" method="POST">
		<input type="checkbox" name="hobby" id="exercise" value="exercise" />
		<label for="exercise">운동</label>
		<br>
		<input type="checkbox" name="hobby" id="movie" value="movie" />
		<label for="movie">영화</label>
		<br>
		<input type="checkbox" name="hobby" id="coding" value="coding" />
		<label for="coding">코딩</label>
		<br>
		<input type="submit" value="등록" />
	</form>
	
	
	<hr>
	
	<h3>/request/user</h3>
	<form action="${ pageContext.request.contextPath }/request/user" method="POST">
		<input type="text" name="id" placeholder="id"/> <br>
		<input type="text" name="name" placeholder="name"/> <br>
	
		<input type="checkbox" name="hobby" id="exercise" value="exercise" />
		<label for="exercise">운동</label>
		<br>
		<input type="checkbox" name="hobby" id="movie" value="movie" />
		<label for="movie">영화</label>
		<br>
		<input type="checkbox" name="hobby" id="coding" value="coding" />
		<label for="coding">코딩</label>
		<br>
		
		<input type="date" name="birth" /> <br>
		
		<input type="submit" value="등록" />
	</form>
	
	<hr>
	
	
	<h3>/request/file</h3>
	<form action="${ pageContext.request.contextPath }/request/file" 
		  method="POST" enctype="multipart/form-data">
		<input type="file" name="file" /> <br>
		
		<input type="submit" value="등록" />
	</form>
	
	
	<hr>
	
	
	<h3>/request/file/multi</h3>
	<form action="${ pageContext.request.contextPath }/request/file/multi" 
		  method="POST" enctype="multipart/form-data">
		<input type="file" name="file" multiple /> <br>
		
		<input type="submit" value="등록" />
	</form>
	
	<hr>
	
	
	<h3>/request/file/board</h3>
	<form action="${ pageContext.request.contextPath }/request/file/board" 
		  method="POST" enctype="multipart/form-data">
		  
		<input type="text" name="title" placeholder="제목" />  <br>
		<input type="text" name="writer" placeholder="작성자" /> <br>
		<input type="text" name="content" placeholder="내용" />   <br>
		<input type="file" name="file" multiple /> <br>
		
		<input type="submit" value="등록" />
	</form>
	
	
	<div style="height: 300px;"></div>
</body>
</html>








