<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${context}/css/common.css" rel="stylesheet"/>
<link href="${context}/css/index.css" rel="stylesheet"/>
<script type="text/javascript" src="${context}/js/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			
		});
	</script>
</head>
<body>
	<div class="fullscreen">
		<div id="gnb-menu">
			gnb메뉴
		</div>
		<div id="contents">
			<div id="side-menu">
				사이드 메뉴
			</div>
			<div id="content">
				콘텐츠
			</div>
		</div>
	</div>
</body>
</html>