<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>模板上传</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/plugin/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="<%=request.getContextPath()%>/include/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen">
    <link href="<%=request.getContextPath()%>/include/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" media="screen">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;   
        background-color: #f5f5f5;     
      }

      .div-signin {
        max-width: 400px;
      	float:none;
        padding: 5px 29px 5px;
        margin: 0 auto 20px;
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
    <form action="" id="forwadForm"></form>
    <div class="container">
    	<div class="div-signin">
           <legend><h1>模板上传</h1></legend>   
           <div class="input-prepend">
             <span class="add-on">选择模板文件：</span>
             <input type="file" id="template_file_upload" name="template_file_upload" />
           </div>  
            <div id="custom-queue"></div>   
        </div>
        <div class="div-signin">
        	<span class="help-block">一组模板应包括example.ftl、example.js、emample.jpg三个文件，将这三个文件压缩打包成example.zip</span>
        </div>
        <div class="div-signin">
            <button type="button" id="btn_upload_submit" class="btn btn-primary btn-large btn-block">确认上传</button>
            <button type="button" id="btn_upload_cancel" class="btn btn-warning btn-large btn-block">取消上传</button>
            <button type="button" id="btn_upload_goback" class="btn btn-success btn-large btn-block">返回模板列表</button>
        </div>
    </div>
     
	<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/artDialog/artDialog.js?skin=default"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/swfobject.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/jquery.uploadify.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/template/template_upload.js"></script>
  </body>
</html>