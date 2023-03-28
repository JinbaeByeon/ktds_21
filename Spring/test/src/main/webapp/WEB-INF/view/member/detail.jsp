<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		$().ready(function(){

		});
	</script>
	<style type="text/css">
		table {
			border: 1px solid #111;
		}
		th, td{
			border: 1px solid #999;
			text-align: center;
		}
	</style>
</head>
<body>
	회원 디테일 페이집니다
	<div>
		이메일 : ${member.email}
	</div>
	<div>
		이름 : ${member.name}
	</div>
	<div>
		비밀번호 : ${member.password}
	</div>
	<div>
		<h2>작성 게시글 목록</h2>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>SUBJECT</th>
					<th>CONTENT</th>
					<th>CRTDT</th>
					<th>MDFYDT</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty boardList}">
						<c:forEach items="${boardList}" var="board">
							<tr>
								<td>${board.id}</td>
								<td>
									<a href="${pageContext.request.contextPath}/board/${board.id}">${board.subject}</a>
								</td>
								<td>${board.content}</td>
								<td>${board.crtDt}</td>
								<td>${board.mdfyDt}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr colspan="5">
							<td>
								<p>등록된 게시글이 없습니다.</p>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<a href = "${pageContext.request.contextPath}/boards">홈으로</a>
	<a href = "${pageContext.request.contextPath}/member/update/${member.email}/">회원정보 수정</a>
</body>
</html>