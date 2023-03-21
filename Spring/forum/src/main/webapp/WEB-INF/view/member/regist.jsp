<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 페이쥐</title>
	<style type="text/css">
		*{
			padding-bottom: 5px;
		}
		#login{
			display :inline-block;
			text-align: right;
		}
	</style>
</head>
<body>
	<h1>회원가입 하라우</h1>
	<form id="login" action="/forum/member/regist" method="post">
		<div>
			<label for="email">이메일</label>
			<input type="email"
				   name="email"
				   id = "email"
				   placeholder="EMAIL을 입력하세요."/>
		</div>
		<div>
			<label for="name">이름</label>
			<input type="text"
				   name="name"
				   id = "name"
				   placeholder="이름을 입력하세요."/>
		</div>
		<div>
			<label for="password">비밀번호</label>
			<input type="password"
				   name="password"
				   id = "password"
				   placeholder="비밀번호를 입력하세요."/>
		</div>
		<div>
			<input type="submit" value="회원가입"/>
		</div>
	</form>
</body>
</html>