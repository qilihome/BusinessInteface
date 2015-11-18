<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>添加投票选项</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
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
    <form action="" id="forwadForm" method="post">
    	<input type="hidden" name="voteOptionForm.voteid" value="${voteId }">
	    <div class="container">
	    	<div class="div-signin">
	           <legend><h1>添加投票选项</h1></legend>   
	           <div class="input-prepend input-append">
	             <span class="add-on">投票选项名称：</span>
	             <input id="name_voteOption" name="voteOptionForm.name" maxlength="20" class="input-xlarge" id="prependedInput" type="text" title="请输入投票选项名称" placeholder="请输入投票选项名称">
	             <span class="add-on text-error">*</span>
	           </div>    
	           <div class="input-prepend">
	             <span class="add-on">初始投票数量：</span>
	             <input id="votes_voteOption" name="voteOptionForm.votes" value="0" maxlength="20" class="input-xlarge" id="prependedInput" type="text" title="请输入初始投票数量" placeholder="请输入初始投票数量">
	           </div>
	        </div>
	        <div class="div-signin">
	            <button type="button" id="btn_upload_submit" class="btn btn-primary btn-large btn-block">添加投票选项</button>
	            <button type="button" id="btn_upload_goback" class="btn btn-success btn-large btn-block">返回投票选项列表</button>
	        </div> 
	    </div>
	</form>
     
	<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/artDialog/artDialog.js?skin=default"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/vote/option/voteoption_add.js"></script>
  </body>
</html>