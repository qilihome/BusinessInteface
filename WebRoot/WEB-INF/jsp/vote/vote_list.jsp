<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>投票活动列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/include/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="<%=request.getContextPath()%>/include/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <style type="text/css">
      body {
        background-color: #f5f5f5;     
      }
    </style>
  </head>
  <body>
    <div class="container">
    	<form action="" id="forwadForm">
    		<input id="ids" name="ids" value="" type="hidden" />
    		<input id="voteId" name="voteForm.id" value="0" type="hidden" />
    		<input id="manageVoteId" name="voteId" value="0" type="hidden" />
    	</form>
    	<p>
		  <button class="btn btn-large btn-primary" type="button" id="btn_add">添加投票活动</button>
		  <button class="btn btn-large btn-danger" type="button" id="btn_del">删除投票活动</button>
		  <a class="btn btn-large btn-info" type="button" id="btn_goback" href="<%=request.getContextPath()%>/configAction_configInit.action">配置投票活动模板</a>
		</p>
        <legend></legend>   
    	<table class="table table-bordered table-hover">
	      <caption><h1>投票活动列表</h1></caption>
	      <thead>
	        <tr>
	          <th><input type="checkbox" value="" title="全选/取消" onclick="selectAll(this.checked)" /></th>
	          <th>投票活动名称</th>
	          <th>操作</th>
	        </tr>
	      </thead>
	      <tbody>
	      	<c:choose>
	      		<c:when test="${not empty voteList}">
	      			<c:forEach items="${voteList}" var="e" varStatus="v">
	      				<tr <c:if test="${v.count % 2 == 1}">class="success"</c:if><c:if test="${v.count % 2 == 0}">class="info"</c:if>>
	      				  <td><input name="keyIds" type="checkbox" value="${e.id }" /></td>
	      				  <td>${e.name }</td>
				          <td><button class="btn btn-success" type="button" id="btn_edit" onclick="optionManage(${e.id });">投票选项管理</button>&nbsp;<button class="btn btn-success" type="button" id="btn_edit" onclick="edit(${e.id });">修改</button></td>
				        </tr>
	      			</c:forEach>
	      		</c:when>
	      		<c:otherwise>
	      			<td colspan="3" class="error text-center">未查询到投票活动信息，请添加投票活动！</td>
	      		</c:otherwise>
	      	</c:choose>
	      </tbody>
	    </table>
    </div>
	<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
	<input type="hidden" id="msg" value="${message}"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/artDialog/artDialog.js?skin=default"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/message.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/vote/vote_list.js"></script>
  </body>
</html>