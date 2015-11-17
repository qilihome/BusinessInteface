<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>专家点评列表</title>
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
    		<input id="reviewId" name="expertReviewForm.id" value="" type="hidden" />
    	</form>
    	<p>
		  <button class="btn btn-large btn-primary" type="button" id="btn_add">添加专家点评</button>
		  <button class="btn btn-large btn-danger" type="button" id="btn_del">删除专家点评</button>
		  <a class="btn btn-large btn-info" type="button" id="btn_goback" href="<%=request.getContextPath()%>/configAction_configInit.action">配置专家点评模板</a>
		</p>
        <legend></legend>   
    	<table class="table table-bordered table-hover">
	      <caption><h1>专家点评列表</h1></caption>
	      <thead>
	        <tr>
	          <th><input type="checkbox" value="" title="全选/取消" onclick="selectAll(this.checked)" /></th>
	          <th>专家名称</th>
	          <th>专家头像</th>
	          <th>专家头衔</th>
	          <th width="15%">专家荣誉</th>
	          <th>点评主题</th>
	          <th width="20%">点评内容</th>
	          <th>操作</th>
	        </tr>
	      </thead>
	      <tbody>
	      	<c:choose>
	      		<c:when test="${not empty reviewList}">
	      			<c:forEach items="${reviewList}" var="e" varStatus="v">
	      				<tr <c:if test="${v.count % 2 == 1}">class="success"</c:if><c:if test="${v.count % 2 == 0}">class="info"</c:if>>
	      				  <td><input name="keyIds" type="checkbox" value="${e.id }" /></td>
	      				  <td>${e.name }</td>
	      				  <td><img src="<%=request.getContextPath()%>/${e.headsculpture }" /></td>
				          <td>${e.title }</td>
				          <td>${e.honor }</td>
				          <td>${e.reviewsubject }</td>
				          <td>${e.reviewcontent }</td>
				          <td><button class="btn btn-success" type="button" id="btn_edit" onclick="edit(${e.id });">修改</button></td>
				        </tr>
	      			</c:forEach>
	      		</c:when>
	      		<c:otherwise>
	      			<td colspan="8" class="error text-center">未查询到专家点评信息，请添加专家点评！</td>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/fancybox/jquery.fancybox-1.3.4.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/expertreview/expertreview_list.js"></script>
  </body>
</html>