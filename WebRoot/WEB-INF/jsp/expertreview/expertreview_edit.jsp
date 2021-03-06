<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>修改专家点评</title>
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
    	<input type="hidden" name="expertReviewForm.id" value="${expertReview.id }">
	    <div class="container">
	    	<div class="div-signin">
	           <legend><h1>修改专家点评</h1></legend>   
	           <div class="input-prepend input-append">
	             <span class="add-on">专家名称：</span>
	             <input id="name_expertReview" name="expertReviewForm.name" value="${expertReview.name }" maxlength="20" class="input-xlarge" id="prependedInput" type="text" title="请输入专家名称" placeholder="请输入专家名称">
	             <span class="add-on text-error">*</span>
	           </div>  
	           <div class="input-prepend input-append">
	             <span class="add-on">专家头衔：</span>
	             <input id="title_expertReview" name="expertReviewForm.title" value="${expertReview.title }" maxlength="100" class="input-xlarge" id="prependedInput" type="text" title="请输入专家头衔" placeholder="请输入专家头衔">
	             <span class="add-on text-error">*</span>
	           </div>  
	           <div class="input-prepend input-append">
	             <span class="add-on">专家荣誉：</span>
	             <textarea id="honor_expertReview" name="expertReviewForm.honor" class="input-xlarge" rows="3" placeholder="请输入专家荣誉">${expertReview.honor }</textarea>
	             <span class="add-on text-error">*</span>
	           </div>  
	           <div class="input-prepend input-append">
	             <span class="add-on">上传专家头像：</span>
	             <input type="hidden" id="content_headsculpture" name="expertReviewForm.headsculpture" value="${expertReview.headsculpture }" title="请上传专家头像" />
	      		 <input type="file" id="file_upload_headsculpture" name="headsculpture_cover_upload" />
	             <span class="add-on text-error">*</span>
	           </div>  
	           <div id="custom-queue_headsculpture"></div>
	           <c:choose>
					<c:when test="${not empty expertReview.headsculpture}">
	           			<img class="img-polaroid" src="<%=request.getContextPath()%>/${expertReview.headsculpture }" id="content_preview_headsculpture"/>
	           		</c:when>
	           		<c:otherwise>
	           			<img class="img-polaroid" src="<%=request.getContextPath()%>/images/icon/edit_img.gif" id="content_preview_headsculpture"/>
	           		</c:otherwise>
	           </c:choose>
	        </div>
	        <div class="div-signin">
	           <div class="input-prepend input-append">
	             <span class="add-on">点评主题：</span>
	             <input id="reviewsubject_expertReview" name="expertReviewForm.reviewsubject" value="${expertReview.reviewsubject }" maxlength="200" class="input-xlarge" id="prependedInput" type="text" title="请输入点评主题" placeholder="请输入点评主题">
	             <span class="add-on text-error">*</span>
	           </div>  
	           <div class="input-prepend input-append">
	             <span class="add-on">点评内容：</span>
	             <textarea id="reviewcontent_expertReview" name="expertReviewForm.reviewcontent" class="input-xlarge" rows="3" placeholder="请输入点评内容">${expertReview.reviewcontent }</textarea>
	             <span class="add-on text-error">*</span>
	           </div>  
	        </div>
	        <div class="div-signin">
	            <button type="button" id="btn_upload_submit" class="btn btn-primary btn-large btn-block">修改专家点评</button>
	            <button type="button" id="btn_upload_goback" class="btn btn-success btn-large btn-block">返回专家点评列表</button>
	        </div> 
	    </div>
	</form>
     
	<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/artDialog/artDialog.js?skin=default"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/swfobject.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/jquery.uploadify.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/expertreview/expertreview_edit.js"></script>
    <script type="text/javascript">
    	loadUploadPlugin("headsculpture", 'headsculpture', '<%=request.getContextPath()%>', ${applicationScope.pic_upload_size}, '${applicationScope.pic_upload_types}', '${applicationScope.pic_upload_exts}', '${applicationScope.server_domain_url}', 'upload_pitcure.png');
    </script>  
  </body>
</html>