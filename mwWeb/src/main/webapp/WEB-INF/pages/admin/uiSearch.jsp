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

<style type="text/css">
.custom-dialog {
	border: none;
	-webkit-box-shadow: none;
	box-shadow: none;
}

.custom-dialog .bui-stdmod-header, .custom-dialog .bui-stdmod-footer {
	display: none;
}
</style>
</head>
<body>
	<div class="wrap">
		<form id="searchForm" class="form-horizontal" tabindex="0" method="post" action="${_ctxPath}/admin/uiSearch.htm"
			style="outline: none;">
			<input type="hidden" name="limit" value="${page.limit}"/>
			<div class="row">
				<div class="control-group span6">
					<label class="control-label">分类：</label>
					<div class="controls">
						<select name="params['uiCategoryId']" class="span3"><option/>							
							<c:forEach var="uiCategory" items="${uiCategorys}">
								<option value="${uiCategory.uiCategoryId}"
									<c:if test="${uiCategory.uiCategoryId==page.params['uiCategoryId']}">selected="selected"</c:if>								
								>${uiCategory.name}</option>
							</c:forEach>
						</select>	
					</div>
				</div>
				<div class="control-group span6">
					<label class="control-label">系统：</label>
					<div class="controls">
						<select name="params['system']" class="span3"><option/>
							<c:forEach var="system" items="${systems}">
								<option value="${system}"
									<c:if test="${system==page.params['system']}">selected="selected"</c:if>								
								><spring:message code="Ui.system.${system}"/></option>
							</c:forEach>
						</select>	
					</div>
				</div>
				<div class="control-group span6">
					<label class="control-label">状态：</label>
					<div class="controls">
						<select name="params['status']" class="span3"><option value=""/>
							<c:forEach var="status" items="${statuss}">
								<option value="${status}"
									<c:if test="${status==page.params['status']}">selected="selected"</c:if>								
								><spring:message code="Ui.status.${status}"/></option>
							</c:forEach>
						</select>	
					</div>
				</div>
				<div class="control-group span6">
					<label class="control-label">来源：</label>
					<div class="controls">
						<select name="params['source']" class="span3"><option/>
							<c:forEach var="source" items="${sources}">
								<option value="${source}"
									<c:if test="${source==page.params['source']}">selected="selected"</c:if>								
								><spring:message code="Ui.source.${source}"/></option>
							</c:forEach>
						</select>	
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">关键词：</label>
					<div class="controls">
						<input type="text" name="params['searchWord']"  value="${page.params['searchWord']}" class="control-text">
					</div>
				</div>
				<div class="control-group span3">
					<label class="control-label"></label>
					<div class="controls">
						<button id="btnSearch" type="submit" class="button button-primary">搜索</button>
					</div>
				</div>
			</div>
		</form>
		<hr/>
		<div class="span24 doc-content">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>账号</th>
							<th>产品名称</th>
							<th>功能分类</th>
							<th>页面名称</th>
							<th>关键词</th>
							<th>系统</th>
							<th>收藏次数</th>
							<th>状态</th>
							<th>来源</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ui" items="${page.result}" varStatus="stat">
							<tr>
								<td>${ui.user.username}</td>
								<td><a href="javascript:void(0);" class="img" title="${ui.imgUrl}">${ui.productName}</a></td>
								<td>${ui.uiCategory.name}</td>
								<td>${ui.pageName}</td>
								<td>${ui.keywords}</td>
								<td><spring:message code="Ui.system.${ui.system}"/></td>
								<td>${fn:length(ui.favorites)}</td>
								<td><spring:message code="Ui.status.${ui.status}"/></td>
								<td><spring:message code="Ui.source.${ui.source}"/></td>
								<td><a href="javascript:void(0);" class="edit" title="${ui.uiId}">编辑</a>　
									<a href="javascript:void(0);" class="delete" title="${ui.uiId}">删除</a></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			<mw:commPageSize page="${page}"></mw:commPageSize>
			<mw:commPage page="${page}"></mw:commPage>
		</div>
	</div>
</body>
<script type="text/javascript">
$(".delete").click(function(){
	var r=confirm("确认删除此内容？");
	var uiId = $(this).attr("title");
	if(r){
		$.get('${_ctxPath}/admin/uiDelete.htm',{'uiId':uiId},function(data){
			if(data.code=='true'){
				window.location.href=window.location.href;
			}else if(data.code=='false'){
				alert(data.message);
			}
		});
	}
});


$(".edit").click(function(){	
	var uiId = $(this).attr("title");
	var config = {
			title : '编辑内容',
			id:'uiEdit',
			href : '${_ctxPath}/admin/uiEdit.htm?uiId='+uiId,
		};
	 var moduleId = window.parent.pageUtil._getCurrentModuleId();
	 var module = window.parent.pageUtil._getModule(moduleId);
	 module.tab.addTab(config,true);
	
});

$(".img").click(function(){	
	var imgUrl = $(this).attr("title");
	 BUI.use('bui/overlay',function(Overlay){
		 var dialog = new Overlay.Dialog({
			 align: {
				//node : '#t1',//对齐的节点
				points: ['tl','tl'], //对齐参考：http://dxq613.github.io/#positon
				offset: [10,10] //偏移
				},
					elCls : 'custom-dialog',
		 			bodyContent:'<img src="/'+_ctxPath+imgUrl+'" />',
					 buttons : []
		 });
		 dialog.show();		
	 });
});

</script>	
</html>
