<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>模板列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/include/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="<%=request.getContextPath()%>/include/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
	<link href="<%=request.getContextPath()%>/plugin/fancybox/jquery.fancybox-1.3.4.css" rel="stylesheet" type="text/css" />
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
    	</form>
    	<p>
		  <button class="btn btn-large btn-primary" type="button" id="btn_upload">模板上传</button>
		  <button class="btn btn-large btn-danger" type="button" id="btn_del">模板删除</button>
		</p>
        <legend></legend>   
    	<table class="table table-bordered table-hover">
	      <caption><h1>模板列表</h1></caption>
	      <thead>
	        <tr>
	          <th><input type="checkbox" value="" title="全选/取消" onclick="selectAll(this.checked)" /></th>
	          <th>编号</th>
	          <th>名称</th>
	          <th>描述</th>
	          <th>区域数量</th>
	          <th>访问路径</th>
	          <th>效果预览</th>
	        </tr>
	      </thead>
	      <tbody>
	      	<c:choose>
	      		<c:when test="${not empty templateList}">
	      			<c:forEach items="${templateList}" var="e" varStatus="v">
	      				<tr <c:if test="${v.count % 2 == 1}">class="success"</c:if><c:if test="${v.count % 2 == 0}">class="info"</c:if>>
	      				  <td><input name="keyIds" type="checkbox" value="${e.id }" /></td>
	      				  <td>${e.id }</td>
				          <td>${e.name }</td>
				          <td>${e.summary }</td>
				          <td>${e.areanum }</td>
				          <td width="10%">${applicationScope.server_domain_url}/configAction_configInit.action?tId=${e.id }&cId=$customerId&pId=$productId</td>
				          <td>
				          	<a onclick="javascript: previewImg('<%=request.getContextPath()%>/${applicationScope.file_template_temp_path }/${e.name }/${e.name }.jpg');" href="#"><button class="btn btn-success" type="button" id="btn_del">预览</button></a>
				          </td>
				        </tr>
	      			</c:forEach>
	      		</c:when>
	      		<c:otherwise>
	      			<td colspan="7" class="error text-center">未查询到模板信息，请上传模板！</td>
	      		</c:otherwise>
	      	</c:choose>
	      </tbody>
	    </table>
    </div>
		<div>
			<a id="mypreview" href="<%=request.getContextPath()%>" name="<%=request.getContextPath()%>"	class="glmb"></a>
		</div>
	<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
	<input type="hidden" id="msg" value="${message}"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/artDialog/artDialog.js?skin=default"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/message.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/fancybox/jquery.fancybox-1.3.4.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/template/template_list.js"></script>
  </body>
</html>