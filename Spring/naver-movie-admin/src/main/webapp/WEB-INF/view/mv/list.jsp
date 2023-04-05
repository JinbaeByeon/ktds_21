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
			$("#mvId").val(data.mvid);
			
			
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

			$("#mvId").val("");

			
			
			$("#crtDt").val("");
			$("#crtr").val("");
			$("#mdfyDt").val("");
			$("#mdfyr").val("");
			
			$("#useYn").prop("checked",false);
			
		});
		
		
		$("#delete_btn").click(function(){
			var mvId = $("#mvId").val();
			if(mvId==""){
				alert("선택된 영화가 없습니다.");
				return;
			}
			if(!confirm("정말 삭제하시겠습니까?")){
				return;
			}
			$.get("${context}/api/mv/delete/" +mvId, function(response){
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
				$.post("${context}/api/mv/create", {mvTtl: $("#mvTtl").val(), useYn: $("#useYn:checked").val()},function(response){
					if(response.status =="200 OK"){
						location.reload(); //새로고침	
					}
					else{
						alert(response.errorCode + "/" + response.message);
					}
				});
			}
			else{
				$.post("${context}/api/mv/update", {mvId: $('#mvId').val(),mvTtl: $("#mvTtl").val(), useYn: $("#useYn:checked").val()},function(response){
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
				form.append("<input type='hidden' name='mvIdList' value= '"+$(this).val()+"'>");
			})
			$.post("${context}/api/mv/delete",form.serialize(),function(response){
				if(response.status == "200 OK"){
					location.reload();
				} else{
					alert(response.errorCode + "/" + response.message);
				}
			})
		});
	});
	function movePage(pageNo) {
		var mvTtl= $("#search-keyword").val();
		location.href = "${context}/mv/list?mvTtl=" + mvTtl + "&pageNo=" + pageNo;
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
						   value="${mvTtl}"/>
					<button class="btn-search" id="search-btn">검색</button>
				</div>
				<div class="grid">
					<div class="grid-count align-right">
						총 ${not empty mvVO ? mvVO.totalCount : 0}건
					</div>
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" id="all_check" /></th>
								<th>순번</th>
								<th>영화ID</th>
								<th>영화제목</th>
								<th>영어제목</th>
								<th>상영상태</th>
								<th>상영시간</th>
								<th>개봉일</th>
								<th>관람등급</th>
								<th>포스터</th>
								<th>줄거리</th>
								<th>등록일</th>
								<th>등록자</th>
								<th>수정일</th>
								<th>수정자</th>
								<th>사용여부</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty mvList}">
									<c:forEach items="${mvList}"
											   var="mv">
										<tr data-mvid="${mv.mvId}"
											data-mvttl="${mv.mvTtl}"
											data-engttl="${mv.engTtl}"
											data-scrnstt="${mv.scrnStt}"
											data-scrntm="${mv.scrnTm}"
											data-opngdt="${mv.opngDt}"
											data-wtcgrd="${mv.wtcGrd}"
											data-pstr="${mv.pstr}"
											data-smr="${mv.smr}"
											data-crtdt="${mv.crtDt}"
											data-crtr="${mv.crtr}"
											data-mdfydt="${mv.mdfyDt}"
											data-mdfyr="${mv.mdfyr}"
											data-useyn="${mv.useYn}">
											<td>
												<input type="checkbox" class="check_idx" value="${mv.mvId}" />
											</td>
											<td>순번</td>
											<td>${mv.mvId}</td>
											<td>${mv.mvTtl}</td>
											<td>${mv.engTtl}</td>
											<td>${mv.scrnStt}</td>
											<td>${mv.scrnTm}</td>
											<td>${mv.opngDt}</td>
											<td>${mv.wtcGrd}</td>
											<td>${mv.pstr}</td>
											<td>${mv.smr}</td>
											<td>${mv.crtDt}</td>
											<td>${mv.crtr}</td>
											<td>${mv.mdfyDt}</td>
											<td>${mv.mdfyr}</td>
											<td>${mv.useYn}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="16" class="no-items">
											등록된 영화가 없습니다.
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
						<c:param name="lastPage" value="${mvVO.lastPage}"/>
						<c:param name="path" value="${context}/mv"/>
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
							<label for="mvId" style=" width:180px;">영화ID</label>
							<input type="text" id="mvId" readonly value=""/>
						</div>
						<div class="input-group inline">
							<label for="mvTtl" style=" width:180px;">영화제목</label>
							<input type="text" id="mvTtl"  name="mvTtl" value=""/>
						</div>
						<div class="input-group inline">
							<label for="mvTtl" style=" width:180px;">영어제목</label>
							<input type="text" id="mvTtl"  name="mvTtl" value=""/>
						</div>
						<div class="input-group inline">
							<label for="mvTtl" style=" width:180px;">상영상태</label>
							<input type="text" id="mvTtl"  name="mvTtl" value=""/>
						</div>
						<div class="input-group inline">
							<label for="mvTtl" style=" width:180px;">상영시간</label>
							<input type="text" id="mvTtl"  name="mvTtl" value=""/>
						</div>
						<div class="input-group inline">
							<label for="mvTtl" style=" width:180px;">개봉일</label>
							<input type="text" id="mvTtl"  name="mvTtl" value=""/>
						</div>
						<div class="input-group inline">
							<label for="mvTtl" style=" width:180px;">관람등급</label>
							<input type="text" id="mvTtl"  name="mvTtl" value=""/>
						</div>
						<div class="input-group inline">
							<label for="mvTtl" style=" width:180px;">포스터</label>
							<input type="text" id="mvTtl"  name="mvTtl" value=""/>
						</div>
						<div class="input-group inline">
							<label for="mvTtl" style=" width:180px;">줄거리</label>
							<input type="text" id="mvTtl"  name="mvTtl" value=""/>
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