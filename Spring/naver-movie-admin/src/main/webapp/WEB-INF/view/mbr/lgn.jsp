<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인페이지</title>
	<link href="${context}/css/common.css" rel="stylesheet">
	<script type="text/javascript" src="${context}/js/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			$("#pwd").keydown(function(key){
				if(key.keyCode == 13){
					doLogin();
				}	
			});
			
			$("#btn-lgn").click(function(){
				doLogin();
			});
			function doLogin(){
				var data = {
						mbrId: $("#mbrId").val(),
						pwd: $("#pwd").val()
					};
					$.post("${context}/api/mbr/lgn",data,function(response){
						// Response Spec
						/* { 
							status: "200 OK",
							message: "",
							errorCode: "",
							redirectURL: ""
						} */
						if(response.status !="200 OK"){
							alert(response.errorCode + " / " + response.message);
						}
						if(response.redirectURL){
							location.href="${context}" +response.redirectURL;
						}
					});
			};
		});
	</script>
</head>
<body>
	<div class="fullscreen item-align-center bg-gray">
		<div>
			<h1>Ktds Movie System</h1>
			<div class="lgn-group align-right">
				<div class="input-group">
					<label for="mbrId">ID</label>
					<input id="mbrId"
						   name="mbrId"
						   type="text"
						   placeholder="id"/>
				</div>
				<div class="input-group">
					<label for="pwd">PWD</label>
					<input id="pwd"
						   name="pwd"
						   type="password"
						   placeholder="password"/>
				</div>
				<button class="btn-primary" id="btn-lgn">로그인</button>
			</div>
		</div>
	</div>
</body>
</html>