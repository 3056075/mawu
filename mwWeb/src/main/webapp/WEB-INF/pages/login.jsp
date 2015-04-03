<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./inc/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title><spring:message code="title.mawuKey"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="./inc/cssjslibs.jsp"%>
</head>
<body>
<form id="loginForm" action="${_ctxPath}/z_login_check.htm" method="post" >
<div style="margin: auto;width: 500px;padding-top: 100px;line-height: 20px;">
	<p><h1><spring:message code="title.mawuKey"/></h1></p>
	<c:if test="${not empty param.error}">
	<p>
		<div class="tips tips-small tips-warning" style="width:200px;">
			<span class="x-icon x-icon-small x-icon-error"><i class="icon icon-white icon-bell"></i></span>
			<div class="tips-content"><spring:message code="login.error.${param.error}"/></div>
		</div>
	</p>
	</c:if>		
	<p>
	<label>用户名：</label><input name="z_username" data-rules="{required:true}" type="text"/>
	</p>
	<p>
	<label>密　码：</label><input name="z_password" data-rules="{required:true}" type="password"/>
	</p>
	<p><input type="submit" value="登录" style="margin-left: 50px;" class="button button-primary"/> </p>
</div>
 </form>
</body>
<script type="text/javascript">
BUI.use('form',function(Form){
	new Form.Form({
		srcNode : '#loginForm'
	}).render();
});

if (window != top)
	top.location.href = location.href;
</script>

</html>