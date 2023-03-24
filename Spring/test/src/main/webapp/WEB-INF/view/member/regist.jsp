<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		$().ready(function(){

		});
	</script>
	<style type="text/css">
		#login{
			display: inline-block;
			text-align: right;
		}
	</style>
</head>
<body>
	<c:choose>
		<c:when test="${empty member}">
			<form id="login" action="${pageContext.request.contextPath}/member/regist" method="post">
				<div>
					<label for="email">이메일</label>
					<input type="email"
						   id="email"
						   name="email"
						   placeholder="EMAIL"/>
				</div>
		</c:when>
		<c:otherwise>
			<form id="login" action="${pageContext.request.contextPath}/member/update/${member.email}" method="post">
		</c:otherwise>
	</c:choose>	
		<div>
			<label for="name">이름</label>
			<input type="text"
				   id="name"
				   name="name"
				   placeholder="NAME"/>
		</div>
		<div>
			<label for="password">비밀번호</label>
			<input type="password"
				   id="password"
				   name="password"
				   placeholder="PASSWORD"/>
		</div>
		<div>
			<input type="submit" value="확인" />
		</div>
	</form>
</body>
</html>