<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>内容配置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/plugin/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="<%=request.getContextPath()%>/include/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen">
    <link href="<%=request.getContextPath()%>/include/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" media="screen">
    <script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/artDialog/artDialog.js?skin=default"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/swfobject.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/jquery.uploadify.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jsmap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/config/template_config.js"></script>
    <style type="text/css">
      body {
        padding-bottom: 40px;   
      }
	  .input-xlarge{
	  	display: inline;
	  }
      .div-signin {
      	float:none;
        padding: 5px 29px 5px;
        max-width: 350px;
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
  	<c:choose>
   		<c:when test="${not empty customerTemplateContentList}">
   			<c:forEach items="${customerTemplateContentList}" var="e">
   				<script type="text/javascript">loadTemplatePlugin(${e.id}, ${e.templateAreaId}, 2);</script>
   			</c:forEach>
   		</c:when>
   		<c:otherwise>
   			<c:choose>
   				<c:when test="${not empty templateAreaList}">
   					<c:forEach items="${templateAreaList}" var="e">
   						<script type="text/javascript">loadTemplatePlugin(${e.id}, ${e.id}, 1);</script>
   					</c:forEach>
   				</c:when>
   				<c:otherwise>
   				</c:otherwise>
   			</c:choose>
   		</c:otherwise>
   	</c:choose>
    <div class="container">
      <div class="">
       	<div class="" style="float: left;">
	       	<legend><h5>模板内容配置</h5></legend>
	      	<form action="configAction_config.action" id="configForm" method="post">
	      		<input type="hidden" name="cId" value="${cId }" />
	      		<input type="hidden" name="tId" value="${tId }" />
	      		<input type="hidden" id="areaIds" name="areaIds" value="" />
	       		<div id="div_config_plugin_list" >
	       			<c:if test="${empty customerTemplateContentList && empty templateAreaList}">
	       				<div class="div-signin">
	       					<legend><h5>您要配置的模板不存在，请确认</h5></legend>
	       				</div>
	       			</c:if>
	       		</div>
       		</form>
       		<c:if test="${not empty customerTemplateContentList || not empty templateAreaList}">
	        	<div class="div-signin">
		           <button id="btn_save_config_submit" type="button" class="btn btn-primary btn-large btn-block">保存配置</button>
		           <button id="btn_reset_config" type="button" class="btn btn-danger btn-large btn-block">重置配置</button>
		        </div>
	        </c:if>
	    </div>

        <div class="" style="margin-left:40px; float: left; max-width:200px;">
        	<div>
        		<c:if test="${not empty tName}">
	       			<legend><h5>模板效果预览</h5></legend>
             		<img src="<%=request.getContextPath()%>/${applicationScope.file_template_temp_path }/${tName }/${tName }.jpg" class="img-polaroid">
             	</c:if>
	        </div>
        </div>
      </div>
    </div>
  </body>
</html>