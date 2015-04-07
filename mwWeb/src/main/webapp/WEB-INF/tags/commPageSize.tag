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
	    value="${url}total=${page.total}&sort=${page.sort}&dir=${page.dir}&limit="
	    scope="page" />
	<c:if test="${not empty actionUrl}">
	    <c:set var="url" value="${actionUrl}${url}"/>
	</c:if>

	<div class="paginationSize">
	 <select id="pagesize" onchange="setPagesize();" style="width: 80px;">	   
	     <c:forEach var="i" items="5,10,20,30,50,100,150,200,500">
	         <option value="${i}"
	             <c:if test="${i==page.limit}">selected=selected</c:if>
	         >${i}</option>
	     </c:forEach>
	 </select>
	 条/页
	</div>
 </c:if>
<script type="text/javascript">
function setPagesize(){
	window.location.href = "${url}" + $("#pagesize").val();
}
</script>
