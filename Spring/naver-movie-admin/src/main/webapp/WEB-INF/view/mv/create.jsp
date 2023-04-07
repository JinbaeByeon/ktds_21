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
		$("#btn-add-gnr").click(function(){
			var gnr = window.open("${context}/gnr/search","장르검색", "width=500,height=500");
		})
		$(".btn-add.mvppl").click(function(){
			var ppl = window.open("${context}/mvppl/search","영화인검색", "width=500,height=500, location=no");
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
					<a href="${context}/mv/list">영화</a> >
					<a href="${context}/mv/create">등록</a>
				</div>
				
				<h1>영화 정보 등록</h1>
				<div>
					<div class="create-group">
						<label for="pstr">포스터</label>
						<img class="profile" src=""/>
						<input type="file" id="pstr" name="pstr"/>
					</div>
					<div class="create-group">
						<label for="mvTtl">영화제목</label>
						<input type="text" id="mvTtl" name="mvTtl"/>
					</div>
					<div class="create-group">
						<label for="engTtl">영화영어제목</label>
						<input type="text" id="engTtl" name="engTtl"/>
					</div>
					<div class="create-group">
						<label for="scrnStt">상영상태</label>
						<select id="scrnStt" name="scrnStt">
							<option>선택</option>
							<option value="상영중">상영중</option>
							<option value="개봉예정">개봉예정</option>
							<option value="상영종료">상영종료</option>
						</select>
					</div>
					<div class="create-group">
						<label for="scrnTm">상영시간(분)</label>
						<input type="number" id="scrnTm" name="scrnTm" value="0"/>
					</div>
					<div class="create-group">
						<label for="opngDt">개봉일</label>
						<input type="date" id="opngDt" name="opngDt"/>
					</div>
					<div class="create-group">
						<label for="wtcGrd">상영상태</label>
						<select id="wtcGrd" name="wtcGrd">
							<option>선택</option>
							<option value="상영중">전체관람가</option>
							<option value="12세이상관람가">12세이상관람가</option>
							<option value="15세이상관람가">15세이상관람가</option>
							<option value="청소년관람불가">청소년관람불가</option>
						</select>
					</div>
					<div class="create-group">
						<label for="smr">줄거리</label>
						<textarea id="smr" name="smr"></textarea>
					</div>
					<div class="create-group">
						<label for="useYn">게시여부</label>
						<input type="checkbox" id="useYn" name="useYn" value= "Y" checked/>
					</div>
					<div class="create-group">
						<label for="btn-add-gnr">장르</label>
						<div>
							<button id="btn-add-gnr" class="btn-add">+</button>
							<div class="items">
							</div>
						</div>
					</div>
					<div class="create-group">
						<label for="btn-add-director">감독</label>
						<div>
							<button id="btn-add-director" class="btn-add mvppl">+</button>
							<div class="items">
							</div>
						</div>
					</div>
					<div class="create-group">
						<label for="btn-add-scriptor">각본</label>
						<div>
							<button id="btn-add-scriptor" class="btn-add mvppl">+</button>
							<div class="items">
							</div>
						</div>
					</div>
					<div class="create-group">
						<label for="btn-add-producer">연출</label>
						<div>
							<button id="btn-add-producer" class="btn-add mvppl">+</button>
							<div class="items">
							</div>
						</div>
					</div>
					<div class="create-group">
						<label for="">주연</label>
						<div>
							<button id="btn-add-mainActor" class="btn-add mvppl">+</button>
							<div class="items">
							</div>
						</div>
					</div>
					<div class="create-group">
						<label for="btn-add-SupportingActor">조연</label>
						<div>
							<button id="btn-add-SupportingActor" class="btn-add mvppl">+</button>
							<div class="items">
							</div>
						</div>
					</div>
					<div class="create-group">
						<label for="btn-add-Extra">기타</label>
						<div>
							<button id="btn-add-Extra" class="btn-add mvppl">+</button>
							<div class="items">
							</div>
						</div>
					</div>
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