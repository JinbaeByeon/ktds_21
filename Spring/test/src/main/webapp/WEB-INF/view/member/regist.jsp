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
			$("#btn_submit").click(function(e){	
				e.preventDefault();
				<c:if test="${empty member}">
					if($.trim($("#email").val())==""){
						alert("이메일을 입력하세요");
						$("#email").focus();
						return;
					}
			    </c:if>
				if($.trim($("#name").val())==""){
					alert("이름을 입력하세요");
					$("#name").focus();
					return;
				}
				if($.trim($("#password").val())==""){
					alert("비밀번호를 입력하세요");
					$("#password").focus();
					return;
				}
				if($("#password").val() != $("#passwordConfirm").val()){
					alert("비밀번호가 일치하지 않습니다.");
					$("#passwordConfirm").focus();
					return;
				}
				$("#regist_form").attr({
					"action" :"${pageContext.request.contextPath}/member/regist",
					"method": "post"
				}).submit();
			});
		});
	</script>
	<style type="text/css">
		#regist_form{
			display: inline-block;
			text-align: right;
		}
	</style>
</head>
<body>
	<c:choose>
		<c:when test="${empty member}">
			<form id="regist_form">
				<div>
					<label for="email">이메일</label>
					<input type="email"
						   id="email"
						   name="email"
						   maxlength="100"
						   placeholder="EMAIL"/>
				</div>
		</c:when>
		<c:otherwise>
			<form id="regist_form">
		</c:otherwise>
	</c:choose>	
		<div>
			<label for="name">이름</label>
			<input type="text"
				   id="name"
				   name="name"
				   maxlength="10"
				   placeholder="NAME"/>
		</div>
		<div>
			<label for="password">비밀번호</label>
			<input type="password"
				   id="password"
				   name="password"
				   maxlength="100"
				   placeholder="PASSWORD"/>
		</div>
		<div>
			<label for="passwordConfirm">비밀번호 검증</label>
			<input type="password"
				   id="passwordConfirm"
				   name="passwordConfirm"
				   maxlength="100"
				   placeholder="PASSWORD"/>
		</div>
		<div>
			<!-- <input type="submit" value="확인" /> -->
			<button id="btn_submit">가입</button>
		</div>
	</form>
</body>
</html>