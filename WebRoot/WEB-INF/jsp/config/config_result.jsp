<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>内容配置结果</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/include/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen">
    <link href="<%=request.getContextPath()%>/include/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" media="screen"><script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/bootstrap.min.js"></script>
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;   
        background-color: #f5f5f5;     
      }

      .div-signin {
        max-width: 500px;
      	float:none;
        padding: 5px 29px 5px;
        margin: 0 auto 10px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
    </style>
  </head>
  <body>
    <div class="container-fluid">
      <div class="row-fluid">
       	<div class="span12">
       		<div>
       			<div class="div-signin">
       				<legend><h4>配置结果</h4></legend>
       				<c:choose>
       					<c:when test="${not empty staticHtmlPath}">
       						<p class="text-error">模板配置成功：静态页面已生成</p>
       						<p class="text-success">静态页面路径：${staticHtmlPath }</p>
       					</c:when>
       					<c:otherwise>
       						<h3>由于网络原因模板配置失败，请重新配置</h3>
       					</c:otherwise>
       				</c:choose>
       			</div>
       		</div>
       		<c:choose>
	       		<c:when test="${not empty staticHtmlPath}">
		        	<div class="div-signin">
		        		<a target="_blank" href="${staticHtmlPath }" class="btn  btn-success btn-large btn-block">点击访问页面</a>
			        </div>
		        </c:when>
      			<c:otherwise>
      				<a target="_blank" href="configAction_configInit.action" class="btn  btn-success btn-large btn-block">重新配置</a>
      			</c:otherwise>
	        </c:choose>
	    </div>
      </div>
    </div>
  </body>
</html>