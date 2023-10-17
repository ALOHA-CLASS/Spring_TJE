<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>AJAX 파일 업로드</h1>
	<form action="${ pageContext.request.contextPath }/request/ajax" method="POST"
	      enctype="multipart/form-data">
       <table class="board">
           <tr>
               <td class="label">제목</td>
               <td class="data">
                   <input type="text" name="title" id="title" class="input-text">
               </td>
           </tr>
           <tr>
               <td class="label">작성자</td>
               <td class="data">
                   <input type="text" name="writer" id="writer" class="input-text">
               </td>
           </tr>
           <tr>
               <td class="label">내용</td>
               <td class="data">
                   <textarea name="content" id="content" cols="30" rows="10" 
                             class="input-textarea"></textarea>
               </td>
           </tr>
           <tr>
               <td class="label">파일</td>
               <td class="data">
                   <input type="file" name="file" id="file" multiple>
               </td>
           </tr>
       </table>

       <div class="btn-box">
           <div class="item">
               <a href="javascript:;" class="btn" id="btn-insert">등록</a>
           </div>
       </div>
   </form>
   
   
   <!-- script -->
   <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
   <script>
   // 등록 버튼 - 클릭 이벤트
   $('#btn-insert').on('click', function() {
       // 등록 요청
       let formData = new FormData()       // 폼 데이터 객체

       let title = $('#title').val()
       let writer = $('#writer').val()
       let content = $('#content').val()
       
       formData.append('title', title)
       formData.append('writer', writer)
       formData.append('content', content)
       
       // 파일 입력 가져오기
       let file = $('#file')[0]
       let files = file.files
       // 파일 데이터 추가
       for (let i = 0; i < files.length; i++) {
           formData.append('file', files[i])
       }

       let url = 'http://localhost:8080/test/request/ajax'
       $.ajax({
           url             :   url,
           type            :   'POST',
           data            :   formData,
           contentType     :   false,
           processData     :   false,      // 데이터 컨텐츠 타입 자동 변환 여부
                                           // 기본값(true) 
                                           // true  -> contentType  : application/x-www-form-urlencoded
                                           // false -> contentType  : 데이터를 자동으로 처리하지 않고 직접 지정
           success         : function(response) {
               if( response == 'SUCCESS' ){
                   alert('등록이 완료되었습니다.')
               }
           },
           error           : function(request, status, error){
               alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
           }

       })


   })
   </script>
</body>
</html>



