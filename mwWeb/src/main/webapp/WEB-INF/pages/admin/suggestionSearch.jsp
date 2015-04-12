
<%@page import="com.zm.mw.entity.Suggestion"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="../inc/cssjslibs.jsp"%>
<%
request.setAttribute("readeds", Suggestion.READEDS);
%>
</head>
<body>
	<div class="wrap">
		<form id="searchForm" class="form-horizontal" tabindex="0" method="post" action="${_ctxPath}/admin/suggestionSearch.htm"
			style="outline: none;">
			<input type="hidden" name="limit" value="${page.limit}"/>
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">起：</label>
					<div class="controls">
						<input type="text" class="calendar calendar-time" name="params['from']" value="${page.params['from']}"/>						
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">止：</label>
					<div class="controls">
						<input type="text" class="calendar calendar-time" name="params['to']" value="${page.params['to']}"/>
					</div>
				</div>
			</div>	
			<div class="row">	
				<div class="control-group span5">
					<label class="control-label">已读：</label>
					<div class="controls">
						<select name="params['readed']" class="span2"><option/>
							<c:forEach var="readed" items="${readeds}">
								<option value="${readed}"
									<c:if test="${readed==page.params['readed']}">selected="selected"</c:if>								
								><spring:message code="Suggestion.readed.${readed}"/></option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">关键词：</label>
					<div class="controls">
						<input type="text"  name="params['word']" value="${page.params['word']}"/>
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
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>反馈账号</th>
							<th>问题和意见</th>
							<th>是否已读</th>
							<th>反馈时间</th>
							<th>操作</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="s" items="${page.result}" varStatus="stat">
							<tr>
								<td>
									<c:forEach var="oauth" items="${s.user.oauths}">
										<span style="color:red"><spring:message code="Oauth.type.${oauth.type}"/></span>
									</c:forEach>
								${s.user.name}</td>
								<td>${s.contents}</td>
								<td><spring:message code="Suggestion.readed.${s.readed}"/></td>
								<td><fmt:formatDate value="${s.createTime}" pattern="yyyy-MM-dd"/> </td>
								<td><a href="javascript:void(0);" class="img" title="${s.imgUrls}" id="${s.suggestionId}">查看</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			<mw:commPageSize page="${page}"></mw:commPageSize>
			<mw:commPage page="${page}"></mw:commPage>
		</div>
	</div>
	<script type="text/javascript">
		BUI.use('bui/calendar', function(Calendar) {
			var datepicker = new Calendar.DatePicker({
				trigger : '.calendar-time',
				showTime : true,
				autoRender : true
			});
		});
		
		
		$(".img").click(function(){	
			var suggestionId = $(this).attr("id");
			$.get('${_ctxPath}/admin/suggestionRead.htm?suggestionId='+suggestionId,{},function(data){
				
			});			
			//
			var imgUrls = $(this).attr("title");
			var bodyContent="问题和意见:"+ $(this).parent().prev().prev().prev().text() +"<br/>";
			bodyContent=bodyContent+"图片:";
			var imgUrlsArr = imgUrls.split(',');
			for (var i=0;i<imgUrlsArr.length;i++)
			{
				bodyContent = bodyContent+ '<img src="/'+ _ctxPath + imgUrlsArr[i] + '" /> ';
			}
			
			 BUI.use('bui/overlay',function(Overlay){
				 var dialog = new Overlay.Dialog({
					 align: {
						//node : '#t1',//对齐的节点
						points: ['tl','tl'], //对齐参考：http://dxq613.github.io/#positon
						offset: [10,10] //偏移
						},
							elCls : 'custom-dialog',
				 			bodyContent:bodyContent,
							buttons : []
				 });
				 dialog.show();		
			 });
		});
	</script>
</body>
</html>
