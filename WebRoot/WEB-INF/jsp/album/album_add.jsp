<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>创建相集</title>
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
    <form action="" id="forwadForm" method="post">
	    <div class="container">
	    	<div class="div-signin">
	           <legend><h1>创建相集</h1></legend>   
	           <div class="input-prepend input-append">
	             <span class="add-on">相集名称：</span>
	             <input id="name_album" name="customerAlbum.albumname" maxlength="20" class="input-xlarge" id="prependedInput" type="text" title="请输入相集名称" placeholder="请输入相集名称">
	             <span class="add-on text-error">*</span>
	           </div>  
	           <div class="input-prepend">
	             <span class="add-on">英文名称：</span>
	             <input id="backup1_album" name="customerAlbum.backup1" maxlength="100" class="input-xlarge" id="prependedInput" type="text" title="请输入英文名称" placeholder="请输入英文名称">
	           </div>  
	           <div class="input-prepend">
	             <span class="add-on">相集备注：</span>
		      	<textarea name="customerAlbum.albumsummary" class="input-xlarge" rows="3" placeholder="请输入相集备注"></textarea>
	           </div>  
	           <div class="input-prepend input-append">
	             <span class="add-on">上传相集封面图片：</span>
	             <input type="hidden" id="content_album" name="customerAlbum.savepath" title="请上传相集封面图片" />
	      		 <input type="file" id="file_upload_album" name="album_cover_upload" />
	             <span class="add-on text-error">*</span>
	           </div>  
	           <div id="custom-queue_album"></div>   
	           <img class="img-polaroid" src="<%=request.getContextPath()%>/images/icon/edit_img.gif" id="content_preview_album"/>
	        </div>
	        <div class="div-signin">
	            <button type="button" id="btn_upload_submit" class="btn btn-primary btn-large btn-block">创建相集</button>
	            <button type="button" id="btn_upload_goback" class="btn btn-success btn-large btn-block">返回相集列表</button>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/album/album_add.js"></script>
    <script type="text/javascript">
    	loadUploadPlugin("album", 'cover', '<%=request.getContextPath()%>', ${applicationScope.pic_upload_size}, '${applicationScope.pic_upload_types}', '${applicationScope.pic_upload_exts}', '${applicationScope.server_domain_url}', 'upload_pitcure.png');
    </script>  
  </body>
</html>