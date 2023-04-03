<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pagenate item-align-center">
	<ul>
		<!-- 1,2,3,4,5 = 0 / 6,7,8,9,10 = 5 -->
		<fmt:parseNumber var="begin" value="${param.pageCnt*Math.floor(param.pageNo/param.pageCnt)}" integerOnly="true"/>
		<c:set var="end" value="${begin + pageCnt}"/>
		${begin} - ${end}
		<li><a href="javascript:movePage(0)">처음</li>
		<c:if test="${begin > 0}">
			<li><a href="javascript:movePage(${begin-1})">이전</li>
		</c:if>
		<c:forEach begin="${begin+1}" end="${end > param.lastPage ? param.lastPage : end}" step="1" var="page">
			<li>
				<c:if test="${page-1 == param.pageNo}">
					<a href="javascript:movePage(${page-1})" class= "page-no active">${page}</a>
				</c:if>
				<c:if test="${page-1 != param.pageNo}">
					<a href="javascript:movePage(${page-1})" class= "page-no">${page}</a>
				</c:if>
			</li>
			
		</c:forEach>
		<c:if test="${end < param.lastPage}">
			<li><a href="javascript:movePage(${end})">다음</a></li>
		</c:if>
		<li><a href="javascript:movePage(${param.lastPage-1})">끝</a></li>
	</ul>
</div>
</html>