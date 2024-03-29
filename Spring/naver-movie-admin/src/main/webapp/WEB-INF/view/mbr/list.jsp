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
			$("#mbrId").val(data.mbrid);
			$("#mbrNm").val(data.mbrnm);
			$("#crtDt").val(data.crtdt);
			//$("#useYn").val(data.useyn);
			$("#ltstLgnDt").val(data.ltstlgndt);
			$("#ltstLgnIp").val(data.ltstlgnip);
			$("#lgnTryCnt").val(data.lgntrycnt);
			//$("#lgnBlockYn").val(data.lgnblockyn);
			$("#ltstLgnFailDt").val(data.ltstlgnfaildt);
			$("#ltstPwdChngDt").val(data.ltstpwdchngdt);
			//$("#admYn").val(data.admYn);
			
			console.log($("#useYn").val())
			console.log($("#lgnBlockYn").val())
			console.log($("#admYn").val())
			
			
			$("#useYn").prop("checked",data.useyn =="Y");
			$("#lgnBlockYn").prop("checked",data.lgnblockyn=="Y");
			$("#admYn").prop("checked",data.admyn=="Y");
			
			
			
		});
		
		$("#new_btn").click(function(){
			$(".grid > table > tbody > tr").siblings().css("backgroundColor","");
			$(this).hide();
			$("#isModify").val("false"); //등록모드
			$("#mbrId").val("");
			$("#mbrNm").val("");
			$("#crtDt").val("");
			//$("#useYn").val(data.useyn);
			$("#ltstLgnDt").val("");
			$("#ltstLgnIp").val("");
			$("#lgnTryCnt").val("");
			//$("#lgnBlockYn").val(data.lgnblockyn);
			$("#ltstLgnFailDt").val("");
			$("#ltstPwdChngDt").val("");
			//$("#admYn").val(data.admYn);
			
			$("#useYn").prop("checked",false);
			$("#lgnBlockYn").prop("checked",false);
			$("#admYn").prop("checked",false);
			
		});
		
		
		$("#delete_btn").click(function(){
			$(".grid > table > tbody > tr").siblings().css("backgroundColor","");
			var mbrId = $("#mbrId").val();
			if(mbrId==""){
				alert("선택된 관리자가 없습니다.");
				return;
			}
			if(!confirm("정말 삭제하시겠습니까?")){
				return;
			}
			$.get("${context}/api/mbr/delete/" +mbrId, function(response){
				if(response.status =="200 OK"){
					location.reload(); //새로고침	
				}
				else{
					alert(response.errorCode + "/" + response.message);
				}
			})
		});
		$("#mbrId").keyup(function(){
			var that = this;
			var value = $(that).val();
			value = $.trim(value);
			
			if(value == ""){
				return;
			} else{
				$.get("${context}/api/mbr/dup/" + value,function(response){
					if(response.status == "200 OK"){
						$(that).css("backgroundColor","#8bfc91");
					} else if(response.status == "500"){
						$(that).css("backgroundColor","#f00c");
					}
				});
			}
		})
		
		$("#save_btn").click(function(){
			$("#new_btn").show();
			console.log($("#mbrNm").val())
			if( $("#isModify").val() =="false"){
				var bgColor=$("#mbrId").css("backgroundColor");
				console.log(bgColor);
				if(bgColor != "rgb(139, 252, 145)"){
					alert("이미 사용중인 ID입니다.");
					return;
				}
				$.post("${context}/api/mbr/create", $("#detail_form").serialize(),function(response){
					if(response.status =="200 OK"){
						location.reload(); //새로고침	
					}
					else{
						alert(response.errorCode + "/" + response.message);
					}
				});
			}
			else{
				$.post("${context}/api/mbr/update", $("#detail_form").serialize(),function(response){
					if(response.status =="200 OK"){
						location.reload(); //새로고침	
					}
					else{
						alert(response.errorCode + "/" + response.message);
					}
				});
			}
			
			
			

		});

	});
</script>
</head>
<body>
	<div class="main-layout">
		<c:import url="../include/header.jsp">
			<c:param name="username" value="${user.mbrNm}"></c:param>
		</c:import>
		<div>
			<jsp:include page="../include/sysMgmtSidemenu.jsp"/>
			<jsp:include page="../include/content.jsp"/>
				<div class="path"> 시스템관리 > 관리자관리 > 관리자목록</div>
				
				<div class="grid">
					<div class="grid-count align-right">
						총 ${mbrList.size()}건
					</div>
					<table>
						<thead>
							<tr>
								<th>순번</th>
								<th>ID</th>
								<th>이름</th>
								<th>가입일</th>
								<th>사용여부</th>
								<th>최근 로그인 날짜</th>
								<th>최근 로그인 IP</th>
								<th>로그인 제한 여부</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty mbrList}">
									<c:forEach items="${mbrList}"
											   var="mbr"
											   varStatus="index">
										<tr data-mbrId="${mbr.mbrId}" 
										    data-mbrNm="${mbr.mbrNm}" 
										    data-crtDt="${mbr.rgstDt}"
										    data-useYn="${mbr.useYn}" 
										    data-ltstLgnDt="${mbr.ltstLgnDt}" 
										    data-ltstLgnIp="${mbr.ltstLgnIp}" 
										    data-lgnTryCnt="${mbr.lgnTryCnt}" 
										    data-lgnBlockYn="${mbr.lgnBlockYn}"
										    data-ltstLgnFailDt="${mbr.ltstLgnFailDt}"
										    data-ltstPwdChngDt ="${mbr.ltstPwdChngDt}"
											data-admYn="${mbr.admYn}">
											<td>${index.index}</td>
											<td>${mbr.mbrId}</td>
											<td>${mbr.mbrNm}</td>
											<td>${mbr.rgstDt}</td>
											<td>${mbr.useYn}</td>
											<td>${mbr.ltstLgnDt}</td>
											<td>${mbr.ltstLgnIp}</td>
											<td>${mbr.lgnBlockYn}</td>
											
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="8" class="no-items">
										등록자 관리자가 없습니다.
										</td>
									
									</tr>
								</c:otherwise>
							</c:choose>
						
						</tbody>
					</table>
					
				</div>
				
				<div class="grid-detail" >
					<form id="detail_form" >
						<!-- 
						isModify ==true => 수정(update)
						isModify == false => 등록(insert)
						 -->
						<input type="hidden" id="isModify" value="false" />
						<div class="input-group inline">
							<label for="mbrId" style=" width:180px;">ID</label>
							<input type="text" id="mbrId" name="mbrId" value=""/>
						</div>	
						
						<div class="input-group inline">
							<label for="mbrNm" style=" width:180px;">이름</label>
							<input type="text" id="mbrNm"  name="mbrNm" value=""/>
						</div>	
						
						<div class="input-group inline">
							<label for="crtDt" style=" width:180px;">등록일</label>
							<input type="text" id="crtDt" disabled value=""/>
						</div>	
						
						<div class="input-group inline">
							<label for="useYn" style=" width:180px;">사용여부</label>
							<input type="checkbox" id="useYn" name="useYn" value="Y"/>
						</div>
						
						<div class="input-group inline">
							<label for="ltstLgnDt" style=" width:180px;">로그인 날짜 </label>
							<input type="text" id="ltstLgnDt"  disabled value=""/>
						</div>
						
						<div class="input-group inline">
							<label for="ltstLgnIp" style=" width:180px;">로그인 IP </label>
							<input type="text" id="ltstLgnIp" disabled value=""/>
						</div>
						
						<div class="input-group inline">
							<label for="lgnTryCnt" style=" width:180px;">로그인 실패 횟수</label>
							<input type="text" id="lgnTryCnt" name="ltstLgnFailDt" value=""/>
						</div>
						
						<div class="input-group inline">
							<label for="lgnBlockYn" style=" width:180px;">접속 제한 여부</label>
							<input type="checkbox" id="lgnBlockYn" name="lgnBlockYn" value="Y"/>
						</div>
						
						<div class="input-group inline">
							<label for="ltstLgnFailDt" style=" width:180px;">로그인 실패날짜</label>
							<input type="text" id="ltstLgnFailDt" disabled value=""/>
						</div>
						
						<div class="input-group inline">
							<label for="ltstPwdChngDt" style=" width:180px;">비밀번호 변경날짜</label>
							<input type="text" id="ltstPwdChngDt" disabled value=""/>
						</div>
						
						<div class="input-group inline">
							<label for="admYn" style=" width:180px;">관리자 여부</label>
							<input type="checkbox" id="admYn" name="admYn" value="Y"/>
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