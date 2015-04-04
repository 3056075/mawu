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
				<table cellspacing="0" class="table table-condensed">
					<thead>
						<tr>
							<th>排序</th>
							<th>分类名称</th>
							<th>图片数量</th>							
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="uiCategory" items="${uiCategory}">
							<tr>
								<td>1</td>
								<td>${uiCategory.name}</td>
								<td>${fn:length(uiCategory.uis)}</td>
								<td>
									<button class="button button-primary">编辑</button>
									<button class="button button-danger">删除</button>
								</td>
							</tr>		
						</c:forEach>				
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>
