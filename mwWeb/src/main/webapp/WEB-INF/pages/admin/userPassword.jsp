<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="../inc/cssjslibs.jsp"%>
</head>
<body>
	<div class="wrap">
		<%@include file="../inc/message.jsp"%>
		<form class="form-horizontal well" id="editForm"
			action="${_ctxPath}/admin/userPassword.htm" method="post">
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">原密码：</label>
					<div class="controls">
						<input name="oldpass" data-rules="{required:true}" type="password" value="${param.oldpass}"/>						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">新密码：</label>
					<div class="controls">
						<input name="newpass" data-rules="{required:true}" type="password" value="${param.newpass}"/>						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">确认信密码：</label>
					<div class="controls">
						<input name="repnewpass" data-rules="{required:true}" type="password" value="${param.repnewpass}"/>						
					</div>
				</div>
			</div>			
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">　</label>
					<div class="controls">
						<input type="submit" value="确定" class="button button-primary"/>						
					</div>
				</div>
			</div>
		</form>
	</div>


</body>
<script type="text/javascript">
	BUI.use('form', function(Form) {
		new Form.Form({
			srcNode : '#editForm'
		}).render();
	});
</script>
</html>
