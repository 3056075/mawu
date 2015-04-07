<%@ tag pageEncoding="UTF-8" import="com.zm.common.pagination.BasePagination"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="wms" tagdir="/WEB-INF/tags"%>

<%@ attribute name="page" required="true" type="com.zm.common.pagination.BasePagination" description="分页类对象"%>
<%@ attribute name="actionUrl" required="false" type="java.lang.String" description="查询Action路径"%>
<c:if test="${not empty page}">
	<c:url var="url" value="?">
		<c:forEach items="${page.params }" var="map">	    
		    <c:param name="params['${map.key}']">${map.value}</c:param>			
		</c:forEach>
	</c:url>
	<c:set var="url"
		value="${url}total=${page.total}&limit=${page.limit}&sort=${page.sort}&dir=${page.dir}&currentPage="
		scope="page" />
	<c:if test="${not empty actionUrl}">
		<c:set var="url" value="${actionUrl}${url}"/>
	</c:if>

	<div class="pagination">	
		<wms:basePage urlEnd="" urlStart="${url}" page="${page}"></wms:basePage>		
	</div>
</c:if>
