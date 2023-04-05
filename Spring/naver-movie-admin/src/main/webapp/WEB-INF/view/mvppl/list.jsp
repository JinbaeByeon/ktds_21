<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<c:set var="uploadPath" value="C:/naver-movie-admin/files/profiles" />
<c:set var="date" value="<%= new Random().nextInt() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../include/stylescript.jsp"/>
<script type="text/javascript">
	$().ready(function(){
		
		var ajaxUtil = new AjaxUtil();
		
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
			$("#crtr").val(data.crtr+"("+data.crtrnm+")");
			$("#mdfyDt").val(data.mdfydt);
			$("#mdfyr").val(data.mdfyr+"("+data.mdfyrnm+")");
			
			if(data.prflpctr == null || data.prflpctr == ""){
				data.prflpctr = "base_profile.png";
			}
			$('#prflThmbnl').attr("src","${context}/mvppl/prfl/"+data.prflpctr+"/");
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
				alert("선택된 영화인이 없습니다.");
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
			
			function fnCallback(response){
				if(response.status =="200 OK"){
					location.reload(); //새로고침	
				}
				else{
					alert(response.errorCode + "/" + response.message);
				}
			};
			
			if( $("#isModify").val() =="false"){
				ajaxUtil.upload("#detail_form","${context}/api/mvppl/create",fnCallback,{"prflPctr":"filePrflPctr"});
			}
			else{
				ajaxUtil.upload("#detail_form","${context}/api/mvppl/update",fnCallback,{"prflPctr":"filePrflPctr"});
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
				alert("삭제할 영화인이 없습니다.");
			}
			
			var form = $("<form></form>");
			checked.each(function(){
				form.append("<input type='hidden' name='mvPplIdList' value= '"+$(this).val()+"'>");
			})
			$.post("${context}/api/mvppl/delete",form.serialize(),function(response){
				if(response.status == "200 OK"){
					location.reload();
				} else{
					alert(response.errorCode + "/" + response.message);
				}
			})
		});
		
		$("#prflThmbnl").click(function(){
			$("#prflPctr").click();
		});
		
		$("#prflPctr").change(function(){
			var file = $(this)[0].files;

			var fileReader = new FileReader();
			console.log(file);
			if(file.length > 0 && file[0].size > 0){
				fileReader.onload = function(data){
					$('#prflThmbnl').attr("src",data.target.result);
				}
				fileReader.readAsDataURL(file[0]);
			} else{
				$('#prflThmbnl').attr("src","${context}/img/base_profile.png");
			}
		});
		$("#del_pctr").click(function(e){
			e.preventDefault();
			$("#isDeletePctr").val("Y");
			$('#prflThmbnl').attr("src","${context}/img/base_profile.png");
			$("#prflPctr").val("");
		})
	});
	function movePage(pageNo) {
		var nm= $("#search-keyword-nm").val();
		var rlNm= $("#search-keyword-rlNm").val();
		var startDt= $("#search-keyword-startDt").val();
		var endDt= $("#search-keyword-endDt").val();
		
		var iStartDt = startDt.split("-").join("");
		var iEndDt = endDt.split("-").join("");
		if(iStartDt > iEndDt){
			alert("시작일자는 종료일자보다 이전이어야만 합니다.");
		}
		
		var queryStr = "nm=" + nm
					 + "&rlNm=" + rlNm
					 +"&startDt=" + startDt
					 +"&endDt=" + endDt
					 +"&pageNo=" + pageNo;
		location.href = "${context}/mvppl/list?" + queryStr;
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
				<div class="path"> 영화 > 영화인관리</div>
				<div class="search-row-group">
					<div class="search-group">
						<label for="search-keyword-rlNm">본명</label>
						<input type="text"
							   id="search-keyword-rlNm" 
							   class="search-input"
							   value="${mvPplVO.rlNm}"/>
						<label for="search-keyword-nm">영화인명</label>
						<input type="text"
							   id="search-keyword-nm"
							   class="search-input"
							   value="${mvPplVO.nm}"/>
					</div>
					<div class="search-group">
						<label for="search-keyword-startDt">조회기간</label>
						<input type="date" id="search-keyword-startDt"
							   class="search-input" value="${mvPplVO.startDt}">
						<input type="date" id="search-keyword-endDt"
							   class="search-input" value="${mvPplVO.endDt}">
						<button class="btn-search" id="search-btn">검색</button>
					</div>
				</div>
				<div class="grid">
					<div class="grid-count align-right">
						총 ${mvPplList.size() > 0 ? mvPplList.get(0).totalCount : 0}건
					</div>
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" id="all_check" /></th>
								<th>영화인ID</th>
								<th>프로필사진</th>
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
											data-prflpctr="${mvPpl.prflPctr}"
											data-nm="${mvPpl.nm}"
											data-rlnm="${mvPpl.rlNm}"
											data-crtdt="${mvPpl.crtDt}"
											data-crtr="${mvPpl.crtr}"
											data-crtrnm="${mvPpl.crtMbr.mbrNm}"
											data-mdfydt="${mvPpl.mdfyDt}"
											data-mdfyr="${mvPpl.mdfyr}"
											data-mdfyrnm="${mvPpl.mdfyMbr.mbrNm}"
											data-useyn="${mvPpl.useYn}">
											<td>
												<input type="checkbox" class="check_idx" value="${mvPpl.mvPplId}" />
											</td>
											<td>${mvPpl.mvPplId}</td>
											<td>${mvPpl.prflPctr}</td>
											<td>${mvPpl.nm}</td>
											<td>${mvPpl.rlNm}</td>
											<td>${mvPpl.crtDt}</td>
											<td>${mvPpl.crtr}(${mvPpl.crtMbr.mbrNm})</td>
											<td>${mvPpl.mdfyDt}</td>
											<td>${mvPpl.mdfyr}(${mvPpl.mdfyMbr.mbrNm})</td>
											<td>${mvPpl.useYn}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="11" class="no-items">
											등록된 영화인이 없습니다.
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
						<c:param name="path" value="${context}/mvppl"/>
					</c:import>
				</div>
				
				<div class="grid-detail" >
					<form id="detail_form" enctype="multipart/form-data">
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
							<div style="position: relative">
								<label for="prflPctr" style=" width:180px;">프로필사진</label>
								<input type="file" id="prflPctr" name="prflPctr" value=""/>
								<img src="${context}/img/base_profile.png" id="prflThmbnl" class="profile"/>
								<button id="del_pctr" style="position:absolute; right: 0; bottom: 0">X</button>
								<input type="hidden" id="isDeletePctr" name="isDeletePctr" value="N" />
							</div>
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