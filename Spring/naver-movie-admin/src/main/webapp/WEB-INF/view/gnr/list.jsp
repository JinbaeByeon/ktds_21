<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			$("#gnrId").val(data.gnrid);
			$("#gnrNm").val(data.gnrnm);
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

			$("#gnrId").val("");
			$("#gnrNm").val("");
			$("#crtDt").val("");
			$("#crtr").val("");
			$("#mdfyDt").val("");
			$("#mdfyr").val("");
			
			$("#useYn").prop("checked",false);
			
		});
		
		
		$("#delete_btn").click(function(){
			var gnrId = $("#gnrId").val();
			if(gnrId==""){
				alret("선택된 장르가 없습니다.");
				return;
			}
			if(!confirm("정말 삭제하시겠습니까?")){
				return;
			}
			$.get("${context}/api/gnr/delete/" +gnrId, function(response){
				$(".grid > table > tbody > tr").siblings().css("backgroundColor","");
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
				$.post("${context}/api/gnr/create", {gnrNm: $("#gnrNm").val(), useYn: $("#useYn:checked").val()},function(response){
					if(response.status =="200 OK"){
						location.reload(); //새로고침	
					}
					else{
						alert(response.errorCode + "/" + response.message);
					}
				});
			}
			else{
				$.post("${context}/api/gnr/update", {gnrId: $('#gnrId').val(),gnrNm: $("#gnrNm").val(), useYn: $("#useYn:checked").val()},function(response){
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
				alert("삭제할 장르가 없습니다.");
			}
			
			var form = $("<form></form>");
			checked.each(function(){
				form.append("<input type='hidden' name='gnrIdList' value= '"+$(this).val()+"'>");
			})
			$.post("${context}/api/gnr/delete",form.serialize(),function(response){
				if(response.status == "200 OK"){
					location.reload();
				} else{
					alert(response.errorCode + "/" + response.message);
				}
			})
		})
	});
	function movePage(pageNo) {
		var gnrNm= $("#search-keyword").val();
		location.href = "${context}/gnr/list?gnrNm=" + gnrNm + "&pageNo=" + pageNo;
	}
</script>
</head>
<body>
	<div class="main-layout">
		<jsp:include page="../include/header.jsp"/>
		<div>
			<jsp:include page="../include/mvMgmtSidemenu.jsp"/>
			<jsp:include page="../include/content.jsp"/>
				<div class="path"> 영화 > 장르관리</div>
				<div class="search-group">
					<label for="search-keyword">장르명</label>
					<input type="text"
						   id="search-keyword" 
						   class="search-input"
						   value="${gnrNm}"/>
					<button class="btn-search" id="search-btn">검색</button>
				</div>
				<div class="grid">
					<div class="grid-count align-right">
						총 ${gnrList.size() > 0 ? gnrList.get(0).totalCount : 0}건
					</div>
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" id="all_check" /></th>
								<th>순번</th>
								<th>장르ID</th>
								<th>장르명</th>
								<th>등록일</th>
								<th>등록자</th>
								<th>수정일</th>
								<th>수정자</th>
								<th>사용여부</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty gnrList}">
									<c:forEach items="${gnrList}"
											   var="gnr">
										<tr data-gnrid="${gnr.gnrId}"
											data-gnrnm="${gnr.gnrNm}"
											data-crtdt="${gnr.crtDt}"
											data-crtr="${gnr.crtr}"
											data-mdfydt="${gnr.mdfyDt}"
											data-mdfyr="${gnr.mdfyr}"
											data-useyn="${gnr.useYn}">
											<td>
												<input type="checkbox" class="check_idx" value="${gnr.gnrId}" />
											</td>
											<td>순번</td>
											<td>${gnr.gnrId}</td>
											<td>${gnr.gnrNm}</td>
											<td>${gnr.crtDt}</td>
											<td>${gnr.crtr}</td>
											<td>${gnr.mdfyDt}</td>
											<td>${gnr.mdfyr}</td>
											<td>${gnr.useYn}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="9" class="no-items">
											등록된 장르가 없습니다.
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
						<c:param name="lastPage" value="${gnrVO.lastPage}"/>
						<c:param name="path" value="${context}/gnr"/>
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
							<label for="gnrId" style=" width:180px;">장르 ID</label>
							<input type="text" id="gnrId" readonly value=""/>
						</div>
						<div class="input-group inline">
							<label for="gnrNm" style=" width:180px;">장르명</label>
							<input type="text" id="gnrNm"  name="gnrNm" value=""/>
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