<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		form{
			display : inline-block;
			text-align: right;
		}
	</style>
</head>
<body>
	<form action="/forum/topic/write" method="post">
		<div>
			<label for="subject">제목</label>
			<input type="text"
				   name="subject"
				   id="subject"
				   placeholder="SUBJECT"/>
		</div>
		<div>
			<label for="email">이메일</label>
			<input type="email"
				   name="email"
				   id="email"
				   placeholder="EMAIL"/>
		</div>
		<div>
			<label for="content">내용</label>
			<textarea name="content"
					  id="content"
					  placeholder="CONTENT"
					  rows="5"
					  cols="50">내용작성</textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>
</body>
</html>