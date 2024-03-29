<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<c:set var="date" value="<%= new Random().nextInt() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../include/stylescript.jsp"/>
<script type="text/javascript">
	$().ready(function(){
		$("#new_btn").click(function(){
			location.href="${context}/mv/create";
		})
	});
</script>
</head>
<body>
	<div class="main-layout">
		<c:import url="../include/header.jsp">
			<c:param name="username" value="${user.mbrNm}"></c:param>
		</c:import>
		<div>
			<jsp:include page="../include/mvMgmtSidemenu.jsp"/>
			<jsp:include page="../include/content.jsp"/>
				<div class="path"> 
					영화관리 > 
					<a href="${context}/mv/list">영화</a>
				</div>
				
				<div class="align-right">
					<button id="new_btn" class="btn-primary">등록</button>
					<button id="delete_btn" class="btn-delete">삭제</button>
				</div>
				
			<jsp:include page="../include/footer.jsp"/>
		</div>
	</div>
</body>
</html>