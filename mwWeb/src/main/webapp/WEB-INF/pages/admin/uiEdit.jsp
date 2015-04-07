<%@page import="com.zm.mw.entity.Ui"%>
<%@page import="com.zm.mw.service.UiCategoryService"%>
<%@page import="com.zm.common.utils.SpringContextUtils"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="../inc/cssjslibs.jsp"%>
<%
UiCategoryService uiCategoryService=SpringContextUtils.getContext().getBean(UiCategoryService.class);
request.setAttribute("uiCategorys", uiCategoryService.findAllByRank()) ;
request.setAttribute("systems", Ui.SYSTEMS);
request.setAttribute("statuss", Ui.STATUSS);
request.setAttribute("sources", Ui.SOURCES);
%>


</head>
<body>
	<div class="wrap">
		<%@include file="../inc/message.jsp"%>
		<form class="form-horizontal well" id="editForm"
			action="${_ctxPath}/admin/uiEditSave.htm" method="post">
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">产品名称：</label>
					<div class="controls">
						<input name="productName" data-rules="{required:true}" type="text" value="${ui.productName}" class="control-text span-width span10" placeholder="多个名称请用空格隔开"/>						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">功能分类：</label>
					<div class="controls">
						<select name="uiCategory">
							<c:forEach var="uiCategory" items="${uiCategorys}">
								<option value="${uiCategory.uiCategoryId}"
									<c:if test="${uiCategory.uiCategoryId==ui.uiCategoryId}">selected="selected"</c:if>								
								>${uiCategory.name}</option>
							</c:forEach>
						</select>				
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">页面名称：</label>
					<div class="controls">
						<input name="pageName" data-rules="{required:true}" type="text" value="${ui.pageName}"/>						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">关键词：</label>
					<div class="controls">
						<input name="keywords" data-rules="{required:true}" type="text" value="${ui.keywords}" class="control-text span-width span10" placeholder="多个关键词请用空格隔开"/>						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">系统：</label>
					<div class="controls">
						<select name="system">
							<c:forEach var="system" items="${systems}">
								<option value="${system}"
									<c:if test="${system==ui.system}">selected="selected"</c:if>								
								><spring:message code="Ui.system.${system}"/></option>
							</c:forEach>
						</select>			
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">状态：</label>
					<div class="controls">
						<select name="status">
							<c:forEach var="status" items="${statuss}">
								<option value="${status}"
									<c:if test="${status==ui.status}">selected="selected"</c:if>								
								><spring:message code="Ui.status.${status}"/></option>
							</c:forEach>
						</select>					
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">收藏次数：</label>
					<div class="controls">
						${fn:length(favorites)}				
					</div>
				</div>
			</div>				
			<div class="row">
				<div class="control-group span16">
					<label class="control-label">来源：</label>
					<div class="controls">
						<spring:message code="Ui.source.${source}"/>			
					</div>
				</div>
			</div>		
			<div class="row">
				<div class="control-group">
					<label class="control-label">图片：</label>
					<div class="controls" style="height: auto;">						 	
						<img id="imgUrlImg" alt="" src="${_ctxPath}/${ui.imgUrl}"/>
						<input type="hidden" name="imgUrl" id="imgUrl" value="${ui.imgUrl}"/>
						<input type="file" id="imgUrl_upload" name="file" />	
					</div>
				</div>
			</div>														
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">　</label>
					<div class="controls">
						<input type="submit" value="确定" class="button button-primary"/>
						<input type="button" value="删除" class="button button-primary"/>
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
	
	$('#imgUrl_upload').uploadify({
	    'swf'    		: '${_ctxPath}/img/uploadify.swf',
	    'uploader'      : '${_ctxPath}/upload.htm', 
	    'fileObjName'	: 'file',
	    'fileTypeExts'  : '*.gif; *.jpg; *.png; *.jpeg',
	    'onUploadSuccess'  : function(file, data, response) {
	    	var result = jQuery.parseJSON(data);
	    	$('#imgUrl').val(result.message);
	        $('#imgUrlImg').attr('src','${_ctxPath}/'+result.message);
	      }
	  });
</script>
</html>
