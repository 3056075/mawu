<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<c:forEach var="message" items="${messages}" >
${message}<br/>
</c:forEach>
</body>
</html>