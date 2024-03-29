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
		
		$(".grid > table > tbody > tr").click(function(){
			$(this).siblings().css("backgroundColor","");
			$(this).css("backgroundColor","#8bfc91");
			$("#new_btn").show();
			$("#isModify").val("true"); //수정모드
			
			var data =$(this).data(); 
			$("#cmpnyId").val(data.cmpnyid);
			$("#cmpnyNm").val(data.cmpnynm);
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

			$("#cmpnyId").val("");
			$("#cmpnyNm").val("");
			$("#crtDt").val("");
			$("#crtr").val("");
			$("#mdfyDt").val("");
			$("#mdfyr").val("");
			
			$("#useYn").prop("checked",false);
		});
		
		
		$("#delete_btn").click(function(){
			$(".grid > table > tbody > tr").siblings().css("backgroundColor","");
			var cmpnyId = $("#cmpnyId").val();
			if(cmpnyId==""){
				alert("선택된 회사가 없습니다.");
				return;
			}
			if(!confirm("정말 삭제하시겠습니까?")){
				return;
			}
			$.get("${context}/api/cmpny/delete/" +cmpnyId, function(response){
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
				$.post("${context}/api/cmpny/create", $("#detail_form").serialize(),function(response){
					if(response.status =="200 OK"){
						location.reload(); //새로고침	
					}
					else{
						alert(response.errorCode + "/" + response.message);
					}
				});
			}
			else{
				$.post("${context}/api/cmpny/update",{cmpnyId:$('#cmpnyId').val()
													,cmpnyNm:$('#cmpnyNm').val()
													,useYn:$('#useYn:checked').val()},function(response){
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

		$("#all_check").change(function(){
			$(".check_idx").prop("checked",$(this).prop("checked"));
		});
		
		$(".check_idx").change(function(){
			var cnt = $(".check_idx").length;
			var checkCnt = $(".check_idx:checked").length;
			$("#all_check").prop("checked",cnt==checkCnt)
		});
		
		$("#delete_btns").click(function(){
			var checked = $(".check_idx:checked");
			var checkLen = checked.length;
			if(checkLen==0){
				alert("삭제할 회사가 없습니다.");
			}
			
			var form = $("<form></form>");
			checked.each(function(){
				form.append("<input type='hidden' name='cmpnyIdList' value= '"+$(this).val()+"'>");
			})
			$.post("${context}/api/cmpny/delete",form.serialize(),function(response){
				if(response.status == "200 OK"){
					location.reload();
				} else{
					alert(response.errorCode + "/" + response.message);
				}
			})
		});
	});
	function movePage(pageNo) {
		var cmpnyNm= $("#search-keyword").val();
		location.href = "${context}/cmpny/list?cmpnyNm=" + cmpnyNm + "&pageNo=" + pageNo;
	}
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
				<div class="path"> 영화 > 회사관리</div>
				<div class="search-group">
					<label for="search-keyword">회사명</label>
					<input type="text"
						   id="search-keyword" 
						   class="search-input"
						   value="${cmpnyVO.cmpnyNm}"/>
					<button class="btn-search" id="search-btn">검색</button>
				</div>
				<div class="grid">
					<div class="grid-count align-right">
						총 ${cmpnyList.size() > 0 ? cmpnyList.get(0).totalCount : 0}건
					</div>
					
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" id="all_check" /></th>
								<th>순번</th>
								<th>회사ID</th>
								<th>회사명</th>
								<th>등록일</th>
								<th>등록자</th>
								<th>수정일</th>
								<th>수정자</th>
								<th>사용여부</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty cmpnyList}">
									<c:forEach items="${cmpnyList}"
											   var="cmpny">
										<tr data-cmpnyid="${cmpny.cmpnyId}"
											data-cmpnynm="${cmpny.cmpnyNm}"
											data-crtdt="${cmpny.crtDt}"
											data-crtr="${cmpny.crtr}"
											data-mdfydt="${cmpny.mdfyDt}"
											data-mdfyr="${cmpny.mdfyr}"
											data-useyn="${cmpny.useYn}">
											<td>
												<input type="checkbox" class="check_idx" value="${cmpny.cmpnyId}" />
											</td>
											<td>순번</td>
											<td>${cmpny.cmpnyId}</td>
											<td>${cmpny.cmpnyNm}</td>
											<td>${cmpny.crtDt}</td>
											<td>${cmpny.crtr}(${cmpny.crtMbr.mbrNm})</td>
											<td>${cmpny.mdfyDt}</td>
											<td>${cmpny.mdfyr}(${cmpny.mdfyMbr.mbrNm})</td>
											<td>${cmpny.useYn}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="9" class="no-items">
											등록된 회사가 없습니다.
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					
					<div class="align-right">
						<button id="delete_btns" class="btn-delete">삭제</button>
					</div>
					
					<c:import url="../include/pagenate.jsp">
						<c:param name="pageNo" value="${pageNo}"/>
						<c:param name="pageCnt" value="${pageCnt}"/>
						<c:param name="lastPage" value="${lastPage}"/>
						<c:param name="path" value="${context}/cmpny"/>
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
							<label for="cmpnyId" style=" width:180px;">회사 ID</label>
							<input type="text" id="cmpnyId" readonly value=""/>
						</div>
						<div class="input-group inline">
							<label for="cmpnyNm" style=" width:180px;">회사명</label>
							<input type="text" id="cmpnyNm"  name="cmpnyNm" value=""/>
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