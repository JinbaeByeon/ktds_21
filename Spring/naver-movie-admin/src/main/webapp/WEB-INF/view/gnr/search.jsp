<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장르 검색</title>
<jsp:include page="../include/stylescript.jsp"/>
<script type="text/javascript">
	$().ready(function() {

		$("#all_check").change(function(){
			$(".check_idx").prop("checked",$(this).prop("checked"));
		});
		
		$(".check_idx").change(function(){
			var cnt = $(".check_idx").length;
			var checkCnt = $(".check_idx:checked").length;
			$("#all_check").prop("checked",cnt==checkCnt)
		});
		
		$("#cancel_btn").click(function(){
			window.close();
		})
	});
</script>

</head>
<body>
	<div class="search-popup content" style="margin-top:10px">
		<h1>장르검색</h1>
			<form>
		<div class="search-group">
				<label for="gnrNm">장르명</label>
				<input type="text"
					   id="gnrNm"
					   name="gnrNm"
					   value="${gnrNm}"
					   class="search-input grow-1 mr-10"/>
				<button class="btn-search">검색</button>
		</div>
			</form>
		<div class="grid">
			<div class="grid-count align-right">
				총 ${gnrList.size() > 0 ? gnrList.size() : 0}건
			</div>
			<table>
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="all_check"/>
						</th>
						<th>장르ID</th>
						<th>장르명</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty gnrList}">
							<c:forEach items="${gnrList}" var="gnr">
								<tr>
									<td>
										<input type="checkbox" class="check_idx" value="${gnr.gnrId}" />
									</td>
									<td>${gnr.gnrId}</td>
									<td>${gnr.gnrNm}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3">검색된 장르가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<div class="align-right">
					<button id="regist_btn" class="btn-primary">등록</button>
					<button id="cancel_btn" class="btn-delete">취소</button>
			</div>
		</div>
	</div>
</body>
</html>