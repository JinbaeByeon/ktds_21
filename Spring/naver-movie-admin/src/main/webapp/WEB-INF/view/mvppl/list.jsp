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

		$("#all_check").click(function(){
			$(".check_idx").prop("checked",$("#all_check:checked").val()=="on");
		});
		
		$(".grid > table > tbody > tr").click(function(){
			$(this).siblings().css("backgroundColor","");
			$(this).css("backgroundColor","#8bfc91");
			$("#new_btn").show();
			$("#isModify").val("true"); //수정모드
			
			var data =$(this).data(); 
			$("#mvPplId").val(data.mvpplid);
			$("#nm").val(data.nm);
			$("#rlNm").val(data.rlnm);
			$("#crtDt").val(data.crtdt);
			$("#crtr").val(data.crtr);
			$("#mdfyDt").val(data.mdfydt);
			$("#mdfyr").val(data.mdfyr);

			$("#useYn").prop("checked",data.useyn =="Y");
		});
		
		$("#new_btn").click(function(){
			$(".grid > table > tbody > tr").siblings().css("backgroundColor","");
			$(this).hide();
			$("#isModify").val("false"); //등록모드

			$("#mvPplId").val("");
			$("#nm").val("");
			$("#rlNm").val("");
			$("#crtDt").val("");
			$("#crtr").val("");
			$("#mdfyDt").val("");
			$("#mdfyr").val("");
			
			$("#useYn").prop("checked",false);
		});
		
		
		$("#delete_btn").click(function(){
			$(".grid > table > tbody > tr").siblings().css("backgroundColor","");
			var mvPplId = $("#mvPplId").val();
			if(mvPplId==""){
				alret("선택된 영화인이 없습니다.");
				return;
			}
			if(!confirm("정말 삭제하시겠습니까?")){
				return;
			}
			$.get("${context}/api/mvppl/delete/" +mvPplId, function(response){
				if(response.status =="200 OK"){
					location.reload(); //새로고침	
				}
				else{
					alert(response.errorCode + "/" + response.message);
				}
			})
		});
		
		
		$("#save_btn").click(function(){
			$("#new_btn").show();
			
			if( $("#isModify").val() =="false"){
				console.log($("#useYn:checked").val());
				$.post("${context}/api/mvppl/create", $("#detail_form").serialize(),function(response){
					if(response.status =="200 OK"){
						location.reload(); //새로고침	
					}
					else{
						alert(response.errorCode + "/" + response.message);
					}
				});
			}
			else{
				$.post("${context}/api/mvppl/update", $("#detail_form").serialize(),function(response){
					if(response.status =="200 OK"){
						location.reload(); //새로고침	
					}
					else{
						alert(response.errorCode + "/" + response.message);
					}
				});
			}

		});

		$("#search-btn").click(function(){
			movePage(0);
		});
		
	});
	function movePage(pageNo) {
		var mvPplNm= $("#search-keyword").val();
		location.href = "${context}/mvppl/list?mvPplNm=" + mvPplNm + "&pageNo=" + pageNo;
	}
</script>
</head>
<body>
	<div class="main-layout">
		<jsp:include page="../include/header.jsp"/>
		<div>
			<jsp:include page="../include/mvMgmtSidemenu.jsp"/>
			<jsp:include page="../include/content.jsp"/>
				<div class="path"> 영화 > 영화인관리</div>
				<div class="search-group">
					<label for="search-keyword">이름</label>
					<input type="text"
						   id="search-keyword" 
						   class="search-input"
						   value="${gnrNm}"/>
					<button class="btn-search" id="search-btn">검색</button>
				</div>
				<div class="grid">
					<div class="grid-count align-right">
						총 ${mvPplList.size()}건
					</div>
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" id="all_check" /></th>
								<th>순번</th>
								<th>영화인ID</th>
								<th>영화인명</th>
								<th>본명</th>
								<th>등록일</th>
								<th>등록자</th>
								<th>수정일</th>
								<th>수정자</th>
								<th>사용여부</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty mvPplList}">
									<c:forEach items="${mvPplList}"
											   var="mvPpl">
										<tr data-mvpplid="${mvPpl.mvPplId}"
											data-nm="${mvPpl.nm}"
											data-rlnm="${mvPpl.rlNm}"
											data-crtdt="${mvPpl.crtDt}"
											data-crtr="${mvPpl.crtr}"
											data-mdfydt="${mvPpl.mdfyDt}"
											data-mdfyr="${mvPpl.mdfyr}"
											data-useyn="${mvPpl.useYn}">
											<td>
												<input type="checkbox" class="check_idx" value="${mvPpl.mvPplId}" />
											</td>
											<td>순번</td>
											<td>${mvPpl.mvPplId}</td>
											<td>${mvPpl.nm}</td>
											<td>${mvPpl.rlNm}</td>
											<td>${mvPpl.crtDt}</td>
											<td>${mvPpl.crtr}</td>
											<td>${mvPpl.mdfyDt}</td>
											<td>${mvPpl.mdfyr}</td>
											<td>${mvPpl.useYn}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="10" class="no-items">
											등록된 영화인이 없습니다.
										</td>
									
									</tr>
								</c:otherwise>
							</c:choose>
						
						</tbody>
					</table>
					
					<c:import url="../include/pagenate.jsp">
						<c:param name="pageNo" value="${pageNo}"/>
						<c:param name="pageCnt" value="${pageCnt}"/>
						<c:param name="lastPage" value="${mvPplVO.lastPage}"/>
						<c:param name="path" value="${context}/mvppl"/>
					</c:import>
				</div>
				
				<div class="grid-detail" >
					<form id="detail_form" >
						<!-- 
						isModify ==true => 수정(update)
						isModify == false => 등록(insert)
						 -->
						<input type="hidden" id="isModify" value="false" />
						<div class="input-group inline">
							<label for="mvPplId" style=" width:180px;">영화인 ID</label>
							<input type="text" id="mvPplId" readonly value=""/>
						</div>
						<div class="input-group inline">
							<label for="nm" style=" width:180px;">영화인명</label>
							<input type="text" id="nm"  name="nm" value=""/>
						</div>
						<div class="input-group inline">
							<label for="rlNm" style=" width:180px;">본명</label>
							<input type="text" id="rlNm"  name="rlNm" value=""/>
						</div>
						<div class="input-group inline">
							<label for="crtDt" style=" width:180px;">등록일</label>
							<input type="text" id="crtDt" disabled value=""/>
						</div>
						<div class="input-group inline">
							<label for="crtr" style=" width:180px;">등록자</label>
							<input type="text" id="crtr" disabled value=""/>
						</div>	
						<div class="input-group inline">
							<label for="mdfyDt" style=" width:180px;">수정일</label>
							<input type="text" id="mdfyDt" disabled value=""/>
						</div>	
						<div class="input-group inline">
							<label for="mdfyr" style=" width:180px;">수정자</label>
							<input type="text" id="mdfyr" disabled value=""/>
						</div>	
						
						<div class="input-group inline">
							<label for="useYn" style=" width:180px;">사용여부</label>
							<input type="checkbox" id="useYn" name="useYn" value="Y"/>
						</div>
							
					</form>
					
					
				</div>
				<div class="align-right">
					<button id="new_btn" class="btn-primary">신규</button>
					<button id="save_btn" class="btn-primary">저장</button>
					<button id="delete_btn" class="btn-delete">삭제</button>
				</div>
				
				
				
				
				
			<jsp:include page="../include/footer.jsp"/>
		</div>
	</div>
</body>
</html>