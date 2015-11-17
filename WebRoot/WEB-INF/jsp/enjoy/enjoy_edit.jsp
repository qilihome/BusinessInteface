<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'enjoy_edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<link href="<%=request.getContextPath()%>/include/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen">
    <link href="<%=request.getContextPath()%>/include/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" media="screen">
  <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;   
        background-color: #f5f5f5;     
      }

       .div-signin {
        max-width: 450px;
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
	  	<div class="div-signin">
		    <legend>模板定义</legend>
		     <div class="input-prepend">
	      		<span class="add-on">模板名称：</span>
	      		<input maxlength="20" class="input-xlarge" id="prependedInput" type="text" title="请输入区域的标题" placeholder="请输入标题">
	      		<span class="add-on text-error">*</span>
	    	</div>   
	   		<span class="help-block">图片上传</span>
	    	<div class="input-prepend">
		   		<img src="..." class="img-polaroid">
		   	</div>
		</div>
 		<div class="div-signin">
		    <button class="btn btn-large btn-block btn-primary" type="button">添加新类别</button>
		 </div>
		 	<div class="div-signin">
		    <legend>模板定义</legend>
		     <div class="input-prepend">
	      		<span class="add-on">模板名称：</span>
	      		<input maxlength="20" class="input-xlarge" id="prependedInput" type="text" title="请输入区域的标题" placeholder="请输入标题">
	      		<span class="add-on text-error">*</span>
	    	</div>   
	   		<span class="help-block">图片上传</span>
	    	<div class="input-prepend">
		   		<img src="..." class="img-polaroid">
		   	</div>
		</div>
			<div class="div-signin">
		    <legend>模板定义</legend>
		     <div class="input-prepend">
	      		<span class="add-on">模板名称：</span>
	      		<input maxlength="20" class="input-xlarge" id="prependedInput" type="text" title="请输入区域的标题" placeholder="请输入标题">
	      		<span class="add-on text-error">*</span>
	    	</div>   
	   		<span class="help-block">图片上传</span>
	    	<div class="input-prepend">
		   		<img src="..." class="img-polaroid">
		   	</div>
		</div>
  </body>
</html>
