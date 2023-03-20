<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 페이쥐</title>
	</head>
	<body>
		<!-- 데이터 전송을 위한 태그 -->
		<!-- method="post" => 데이터 전송을 HTTP POST로 전송하도록 한다 -->
		<!-- action="/member/regist" =? /member/regist로 데이터를 전송한다 -->
		<form action="/hello-mvc/member/regist" method="post">
			<div>
				<input type="email" name="email" />
			</div>
			<div>
				<input type="text" name= "name" />
			</div>
			<div>
				<input type="password" name= "password" />
			</div>
			<div>
				<input type="submit" value="등록" />
			</div>
			<!-- Form 안에 있는 Input 태그들이 서버로 전송됨 -->
		</form>
	</body>
</html>