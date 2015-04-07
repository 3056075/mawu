
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
		<form id="searchForm" class="form-horizontal" tabindex="0" method="post" action="${_ctxPath}/admin/searchWordsSearch.htm"
			style="outline: none;">
			<input type="hidden" name="limit" value="${page.limit}"/>
			<div class="row">
				<div class="control-group span7">
					<label class="control-label">关键词：</label>
					<div class="controls">
						<input type="text" name="params['word']"  value="${page.params['word']}" class="control-text span3">
					</div>
				</div>
				<div class="control-group span5">
					<label class="control-label">最小次数：</label>
					<div class="controls">
						<input type="text" name="params['minCount']"  value="${page.params['minCount']}" class="control-text span1">
					</div>
				</div>
				<div class="control-group span5">
					<label class="control-label">最大次数：</label>
					<div class="controls">
						<input type="text" name="params['maxCount']"  value="${page.params['maxCount']}" class="control-text span1">
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
		<div class="span12 doc-content">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>搜索次数</th>
							<th>关键词</th>
							<th>分类</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sw" items="${page.result}" varStatus="stat">
							<tr>
								<td>${sw.times}</td>
								<td>${sw.word}</td>
								<td>${sw.uiCategory.name}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			<mw:commPageSize page="${page}"></mw:commPageSize>
			<mw:commPage page="${page}"></mw:commPage>
		</div>
	</div>
</body>
</html>
