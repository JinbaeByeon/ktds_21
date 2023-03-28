<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			var cnt = 0;
			$('#btn_add_files').click(function(e){
				e.preventDefault();
				var div = $("<div class='input_file'></div>");
				var inputFile = "<input type='file'"
						+ "name='uploadFile'"
						+ "placeholder='파일을 선택하세요'/>";
				var btnDelete = "<button class = 'btn_delete'>삭제</button>"
				div.append(inputFile);
				div.append(btnDelete);
				$('#btn_add_files').before(div);
			});
			$(document).on("click",".btn_delete",function(e){
				e.preventDefault();
				$(this).closest("#files > .input_file").remove();
			});
		});
	</script>
</head>
<body>
	<div id="regist_form">
		<form method="post"
			  action="${pageContext.request.contextPath}${url}"
			  enctype="multipart/form-data" >
			<div>
				<label for = "subject">제목</label>
				<input type="text"
					   id = "subject"
					   name = "subject"
					   value = "${board.subject}"
					   placeholder="SUBJECT"/>
			</div>
			<div>
				<label for = "content">내용</label>
				<textarea id = "content"
						  name = "content"
						  placeholder="CONTENT">${board.content}
				</textarea>
			</div>
			<div id="files">
				<button id="btn_add_files">파일 추가</button>
			</div>
			<div>
				<input type="submit" value="등록">
			</div>
		</form>
	</div>
	
</body>
</html>