<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="../inc/cssjslibs.jsp"%>
<link href="${_ctxPath}/css/main-min.css" rel="stylesheet">
</head>
<body>
	<div class="wrap">
		<div class="tips tips-small tips-info">
			<span class="x-icon x-icon-small x-icon-info"><i
				class="icon icon-white icon-info"></i></span>
			<div class="tips-content">全部分类：${fn:length(uiCategorys)}</div>
		</div>
		<div class="row">
			<div class="span12 doc-content">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>排序</th>
							<th>分类名称</th>
							<th>图片数量</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="uiCategory" items="${uiCategorys}" varStatus="stat">
							<tr>
								<td>
									<c:if test="${!stat.first}"><span class="up">▲</span></c:if>
									<c:if test="${stat.first}">&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
									&nbsp;&nbsp;
									<c:if test="${!stat.last}"><span class="down">▼</span></c:if>
								</td>
								<td>${uiCategory.name}</td>
								<td>${fn:length(uiCategory.uis)}</td>
								<td><a href="javascript:void(0);" class="edit" title="${uiCategory.uiCategoryId}">编辑</a> 
								    <a href="javascript:void(0);" class="delete" title="${uiCategory.uiCategoryId}">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

<script type="text/javascript">
$(".delete").click(function(){
	var r=confirm("确认删除此分类？");
	var uiCategoryId = $(this).attr("title");
	if(r){
		$.get('${_ctxPath}/admin/uiCategoryDelete.htm',{'uiCategoryId':uiCategoryId},function(data){
			if(data.code=='true'){
				window.location.href=window.location.href;
			}else if(data.code=='false'){
				alert(data.message);
			}
		});
	}
});

$(".up").click(function(){exchange($(this).parent().parent().find(".delete").attr("title"),'false')});
$(".down").click(function(){exchange($(this).parent().parent().find(".delete").attr("title"),'true')});
var exchange=function exchange(uiCategoryId,isnext){
	$.get('${_ctxPath}/admin/uiCategoryExchange.htm',{'uiCategoryId':uiCategoryId,'isNext':isnext},function(data){
		if(data.code=='true'){
			window.location.href=window.location.href;
		}else if(data.code=='false'){
			alert(data.message);
		}
	});
}

$(".edit").click(function(){	
	var uiCategoryId = $(this).attr("title");
	var config = {
			title : '编辑分类',
			id:'uiCategoryEdit',
			href : '${_ctxPath}/admin/uiCategoryEdit.htm?uiCategoryId='+uiCategoryId,
		};
	 var moduleId = window.parent.pageUtil._getCurrentModuleId();
	 var module = window.parent.pageUtil._getModule(moduleId);
	 module.tab.addTab(config,true);
	
	
});

</script>	
</body>
</html>
