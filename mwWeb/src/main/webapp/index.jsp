<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@include file="./WEB-INF/pages/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>

<head>
</head>
<body>

<% 
String host = request.getServerName();
if("m.meiui.me".equals(host)){
	response.sendRedirect("/admin/index.htm");
}else{
	response.sendRedirect("/index.htm");
}
 %>
</body>

</html>