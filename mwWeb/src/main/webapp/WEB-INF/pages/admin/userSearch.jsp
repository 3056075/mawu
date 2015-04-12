
<%@page import="com.zm.mw.entity.Suggestion"%>
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
		<form id="searchForm" class="form-horizontal" tabindex="0" method="post" action="${_ctxPath}/admin/userSearch.htm"
			style="outline: none;">
			<input type="hidden" name="limit" value="${page.limit}"/>
			<div class="row">	
				<div class="control-group span5">
					<label class="control-label">账号类型：</label>
					<div class="controls">
						<select name="params['type']" class="span2"><option/>
							<c:forEach var="type" items="1,5">
								<option value="${type}"
									<c:if test="${type==page.params['type']}">selected="selected"</c:if>								
								><spring:message code="Oauth.type.${type}"/></option>
							</c:forEach>
						</select>
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
		<div class="span16 doc-content">
				<span>收藏总数：${countFav}</span>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>用户名</th>
							<th>名称</th>
							<th>昵称</th>
							<th>来源</th>
							<th>OpenId</th>
							<th>收藏数量</th>					
						</tr>
					</thead>
					<tbody>
						<c:forEach var="o" items="${page.result}" varStatus="stat">
							<tr>
								<td>${o.user.username}</td>
								<td>${o.user.name}</td>
								<td>${o.user.nickName}</td>
								<td><span style="color:red"><spring:message code="Oauth.type.${o.type}"/></span></td>
								<td>${o.openid}</td>
								<td>${userFav[o.user.userId]}</td>								
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
