<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
	<link href="${pageContext.request.contextPath}/css/list.css" rel="stylesheet"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		$().ready(function(){
		});
	</script>
</head>
<body>
	<div>
		<img src="${pageContext.request.contextPath}/img/flying_cat.gif"/>
	</div>
	<p>	
		리스트 페이집니다
	</p>
	<c:if test="${empty user}">
		<div class="btn">
			<a href="${pageContext.request.contextPath}/member/regist">회원가입</a>
		</div>
		<div class="btn">
			<a href="${pageContext.request.contextPath}/member/login">로그인</a>
		</div>
	</c:if>
	<c:if test="${not empty user}">
		<div class="btn">
			<a href="${pageContext.request.contextPath}/board/write">글쓰기</a>
		</div>
		<div class="btn">
			<a href="${pageContext.request.contextPath}/member/check/${user.email}/">회원정보</a>
		</div>
		<div class="btn">
			<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
		</div>
	</c:if>
	
	<div>총 ${boardList.size()}건</div>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>SUBJECT</th>
				<th>EMAIL</th>
				<th>CRTDT</th>
				<th>MDFYDT</th>
				<th>WRITER</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty boardList}">
					<c:forEach items="${boardList}" var="board">
						<tr>
							<td>${board.id}</td>
							<td>
								<a href="${pageContext.request.contextPath}/board/${board.id}">${board.subject} (${board.replyList.size()})</a>
							</td>
							<td>${board.email}</td>
							<td>${board.crtDt}</td>
							<td>${board.mdfyDt}</td>
							<td>${board.memberVO.name}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr colspan="6">
						<td>
							<p>등록된 게시글이 없습니다.</p>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>