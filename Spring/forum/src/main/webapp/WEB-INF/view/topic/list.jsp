<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>

		table {
			border-collapse: collapse;
		}
		tr {
			text-align: center;
		}
		th, td {
			border: 1px solid #222;
		}
	</style>
</head>
<body>

	<h1>Topic List</h1>

	<c:choose>
		<c:when test="${not empty topicList}">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>SUBJECT</th>
						<th>CONTENT</th>
						<th>EMAIL</th>
						<th>CRTDT</th>
						<th>MDFYDT</th>
						<th>FILENAME</th>
						<th>ORIGINFILENAME</th>
						<th>WRITER</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${topicList}" var="topic">
						<tr>
							<td>${topic.id}</td>
							<td>${topic.subject}</td>
							<td>${topic.content}</td>
							<td>${topic.email}</td>
							<td>${topic.crtDt}</td>
							<td>${topic.mdfyDt}</td>
							<td>${topic.fileName}</td>
							<td>${topic.originFileName}</td>
							<td>${topic.memberVO.name}</td>
						</tr>
					</c:forEach>		
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<p>등록된 토픽이 없습니다. 첫 번째 토픽의 주인공이 되어보세용</p>
		</c:otherwise>
	</c:choose>
	
	
	<div>
		<a href="/forum/topic/write">글쓰기</a>
	</div>
</body>
</html>