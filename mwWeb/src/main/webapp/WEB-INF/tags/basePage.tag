<%@ tag pageEncoding="UTF-8" import="com.zm.common.pagination.BasePagination"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ attribute name="page" required="true" type="com.zm.common.pagination.BasePagination" description="分页类对象"%>
<%@ attribute name="urlStart" required="true" type="java.lang.String" description="翻页url开始"%>
<%@ attribute name="urlEnd" required="true" type="java.lang.String" description="翻页url结束"%>

<c:if test="${not empty page.displayIndexs}">
 

<ul>  
	<li <c:if test="${empty page.beforePage}">class="disabled"</c:if>>
		<a href="${urlStart}${page.beforePage}${urlEnd}">«</a>
	</li>    
	    
	<c:if test="${page.displayIndexs[0]>0}">
		<li><a href="${urlStart}0${urlEnd}">1</a></li>
	</c:if>
	<c:if test="${page.displayIndexs[0]>1}">
		<li><span>...</span></li>
	</c:if>
	<c:forEach items="${page.displayIndexs }" var="index">
		<li <c:if test="${(page.currentPage) == index }">class="active"</c:if>><a href="${urlStart}${index}${urlEnd}">${index+1}</a></li>
	</c:forEach>	
	<c:if test="${page.displayIndexs[page.displayIndexsLen-1]<page.totalPage-2}">
		<li><span>...</span></li>
	</c:if>	
	<c:if test="${page.displayIndexs[page.displayIndexsLen-1]<page.totalPage-1}">
		<li><a href="${urlStart}${page.totalPage - 1}${urlEnd}" class="fy_page">${page.totalPage}</a></li>
	</c:if>
	<li <c:if test="${empty page.nextPage}">class="disabled"</c:if>>
		<a href="${urlStart}${page.nextPage}${urlEnd}">»</a>
	</li>  
	<li><span>共<i style="font-weight:bolder;color:black"> ${page.total} </i> 条</span></li>  
</ul>	   
</c:if>
