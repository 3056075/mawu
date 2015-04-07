<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../inc/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title><spring:message code="title.mawuKey"/>管理系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <%@include file="../inc/cssjslibs.jsp"%>
   <link href="${_ctxPath}/css/main-min.css" rel="stylesheet">
 </head>
 <body>
   <div class="content">
    <div class="dl-main-nav">
      <div style="float:right;width:300px;color:white;margin-top:10px;">
     		 欢迎您，@<sec:authentication property="principal.name"/>(<sec:authentication property="principal.username" />)
    		<a href="${_ctxPath}/z_logout.htm" title="退出系统" class="dl-log-quit">[退出]</a>
    		<a href="${_ctxPath}/admin/facedebug.htm" target="_blank">debug</a>      
      </div>
      <ul id="J_Nav"  class="nav-list ks-clear">
        <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">
        	<spring:message code="title.mawuKey"/>管理
        </div></li>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>
  <script>
    var pageUtil ;
    BUI.use('common/main',function(){
      var config = [{
          id:'menu', 
          homePage : 'uiCategory',
          menu:[{
              text:'分类管理',
              items:[
                {id:'uiCategory',text:'分类查看',href:'${_ctxPath}/admin/uiCategorySearch.htm'},
                {id:'uiCategoryEdit',text:'添加分类',href:'${_ctxPath}/admin/uiCategoryEdit.htm'}
              ]
            },{
              text:'用户管理',
              items:[
                {id:'user',text:'用户查看',href:'${_ctxPath}/admin/userSearch.htm'}
              ]
            },{
              text:'内容管理',
              items:[
                {id:'ui',text:'内容查看',href:'${_ctxPath}/admin/uiSearch.htm'},
                {id:'uiEdit',text:'添加内容',href:'${_ctxPath}/admin/uiEdit.htm'}  
              ]
            },{
                text:'搜索管理',
                items:[
                  {id:'searchWords',text:'搜索查看',href:'${_ctxPath}/admin/searchWordsSearch.htm'}
                ]
            },{
                text:'意见管理',
                items:[
                  {id:'suggestion',text:'意见查看',href:'${_ctxPath}/admin/suggestionSearch.htm'}
                ]
            },{
                text:'密码管理',
                items:[
                  {id:'password',text:'修改密码',href:'${_ctxPath}/admin/userPassword.htm'}
                ]
            }]
          }];
      pageUtil= new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
 </body>
</html>
