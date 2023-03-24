<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 상세</title>
	<link href="${pageContext.request.contextPath}/css/board_detail.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
	<script type="text/javascript">
		$().ready(function(){
			
		});
	</script>
</head>
<body>
	<p>
		<img src="${pageContext.request.contextPath}/img/스프링진스_누끼.png" style="width: 80px; height: auto"/>디테일 페이집니다
	</p>
	<div>
		<ul>
			<li id="info">
				<h1>${board.subject}</h1>
				<p>
					<span>
						<a href = "${pageContext.request.contextPath}/member/${board.email}">${board.memberVO.name}</a>
					</span> 
					<span> 작성일 : ${board.crtDt} / 수정일 : ${board.mdfyDt}</span>
				</p>
				
			</li>
			<li>
				<div id="content">
					${board.content}
				</div>
			</li>
			<li>
				<c:forEach items="${board.fileList}" var="file">
					<p>${file.originalFileName}</p>
					<p>
						<a class="btn" href="${pageContext.request.contextPath}/board/download/${file.fileId}">다운로드</a>
					</p>
				
				</c:forEach>
			</li>
			<li>
				<div id="replies">
					<c:if test="${board.replyList.get(0).reply != null}">
						<ul>
							<c:forEach items="${board.replyList}" var="reply">
								<li>
									<div class="reply" style="margin-left : ${30* reply.depth}px">
										<p>
											<span class="writer">${reply.memberVO.name}</span>
											<span class="date">${reply.crtDt} / ${reply.mdfyDt}</span>
											<span> ${reply.replyId}</span>
											<span> ${reply.prntReplyId}</span>
										</p>
										<div>
											${reply.reply}
										</div>
										<a class="btn">답글달기</a>
										<a class="btn">수정</a>
										<a class="btn" href="${pageContext.request.contextPath}/board/${board.id}/reply/delete/${reply.replyId}">삭제</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</c:if>
					<div id="submit">
						<form action="${pageContext.request.contextPath}/board/reply/create" method="post">
							<input type="text" name="boardId" value="${board.id}" hidden="true"/>
							<input type="text" name="prntReplyId"/>
							
							<div>
								<label for="email">작성자 이메일</label>
								<input type="email"
									   id="email"
									   name="email"
									   placeholder="example@naver.com"/>
							</div>
							<div>
								<label for="reply">댓글 내용</label>
								<textarea rows="4" cols="40"
										  id="reply"
										  name="reply"
										  placeholder="comment"></textarea>
							</div>
							<div>
								<input type="submit" value="등록"/>
							</div>
						</form>
					</div>
				</div>
			</li>
		</ul>
	</div>
	<a href= "${pageContext.request.contextPath}/boards">홈으로</a>
	<a href= "${pageContext.request.contextPath}/board/update/${board.id}">수정</a>
	<a href= "${pageContext.request.contextPath}/board/delete/${board.id}">삭제</a>
</body>
</html>