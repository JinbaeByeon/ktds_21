<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
	<link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			$("#btn_login").click(function(e){
				e.preventDefault();
				var emailVal = $("#email").val();
				var passwordVal = $("#password").val();
				if(emailVal==""){
					alert("이메일을 입력하세요");
					return;
				}
				if(passwordVal==""){
					alert("비밀번호를 입력하세요");
					return;
				}
				$.post("${pageContext.request.contextPath}/api/member/login",
					{"email":emailVal, "password":passwordVal},
					function(response){
						if(response.loginResult){
							location.href="${pageContext.request.contextPath}/boards";
						} else if(response.errorCode=="NOT_FOUND_USER"){
							alert("아이디 또는 비밀번호가 일치하지 않습니다.");
						} else if(response.status=="fail"){
							alert(response.message);
						}
					});
			});
			
			/* <c:if test="${errorCode == 'NOT_FOUND_USER'}">
				alert("아이디 또는 비밀번호가 일치하지 않습니다.");
			</c:if>
			
			$("#btn_login").click(function(e){
				e.preventDefault();
				var emailVal = $("#email").val();
				var passwordVal = $("#password").val();
				if(emailVal==""){
					alert("이메일을 입력하세요");
					return;
				}
				if(passwordVal==""){
					alert("비밀번호를 입력하세요");
					return;
				}
				$("#login_form").attr({
					"action": "${pageContext.request.contextPath}/member/login",
					"method": "post"
				}).submit();
			}); */
			
		})
	</script>
</head>
<body>

	<h1>Login</h1>
	
	<form id="login_form">
		<div>
			<label for="email">이메일</label>
			<input type="email"
				id="email"
				name="email"/>
		</div>
		<div>
			<label for="password">비밀번호</label>
			<input type="password"
				id="password"
				name="password"/>
		</div>
		<div>
			<button id="btn_login">로그인</button>
		</div>
	</form>
</body>
</html>