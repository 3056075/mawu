<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/taglibs.jsp"%>
<%if (request.getMethod().equals("POST")) {%>
<div class="tips tips-small tips-info">
<span class="x-icon x-icon-small x-icon-info"><i class="icon icon-white icon-info"></i></span>
<div class="tips-content">{message}</div>
</div>
<%}%>