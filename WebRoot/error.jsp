<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>出错啦！</title>
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
   			<div class="div-signin">
   				<legend><h4>出错啦！</h4></legend>
   				<p class="text-error">亲，出错啦，不好意思哟！</p>
      				<p class="text-success">您可以休息一下再试 或 联系系统管理员！</p>
   			</div>
        	<div class="div-signin">
        		<a onclick="javascript: history.go(-1)" href="#" class="btn  btn-success btn-large btn-block">返回</a>
	        </div>
	    </div>
      </div>
    </div>
  </body>
</html>