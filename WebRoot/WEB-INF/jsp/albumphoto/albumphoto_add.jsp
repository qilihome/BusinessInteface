<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="utf-8">
  <head>
    <title>上传相片</title>
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
    <div class="container">
    	<div class="div-signin">
           <legend><h1>相集：${album.albumname }</h1></legend>   
           <div class="input-prepend">
           	 <h5>多图上传,选择相片时同时按住"Ctrl"或"Shift"</h5>
             <span class="add-on">请：</span>
             <input type="hidden" id="content_album" name="customerAlbum.savepath" title="请上传相片" />
      		 <input type="file" id="file_upload_album" name="album_cover_upload" />
           </div>  
           <div id="custom-queue_album"></div>   
        </div>
        <form action="" id="forwadForm" method="post">
 			<input type="hidden" name="albumId" value="${album.id }">
 			<input type="hidden" id="uploadcount" name="uploadcount" value="0">
         	<div id="div_album_photo">
         		
         	</div>
        </form>
        <div class="div-signin">
            <button type="button" id="btn_upload_submit" class="btn btn-primary btn-large btn-block">保存相片</button>
            <button type="button" id="btn_upload_goback" class="btn btn-success btn-large btn-block">返回相片列表</button>
        </div> 
    </div>
	
    <div id="gen_album_photo_config_template" style="display: none;">
	    <div class="div-signin">
	    	<input type="hidden" name="photosrc_#uploadcount#" value="#photo_photosrc_src_save#">
	 		<div>
	 			<img class="img-polaroid" src="#photo_photosrc_src#" />
	 		</div>
	 		<div class="input-prepend">
		      <span class="add-on">相片尺寸：</span>
		      <input name="photosize_#uploadcount#" value="#photo_photosrc_size_save#" readonly="readonly" maxlength="50" class="input-xlarge" id="prependedInput" type="text" placeholder="请输入相片尺寸">
		    </div>   
	 		<div class="input-prepend">
		      <span class="add-on">相片名称：</span>
		      <input name="photoname_#uploadcount#" maxlength="50" class="input-xlarge" id="prependedInput" type="text" placeholder="请输入相片名称">
		    </div>   
		    <div class="input-prepend">
		      <span class="add-on">相片备注：</span>
		      <textarea name="photosummary_#uploadcount#" class="input-xlarge" rows="3" placeholder="请输入相片备注"></textarea>
		    </div>   
		</div>
    </div>
	<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>">
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/artDialog/artDialog.js?skin=default"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/swfobject.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/jquery.uploadify.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/album/albumphoto_add.js"></script>
    <script type="text/javascript">
    	loadUploadPlugin("album", '${album.id }', '<%=request.getContextPath()%>', ${applicationScope.pic_upload_size}, '${applicationScope.pic_upload_types}', '${applicationScope.pic_upload_exts}', '${applicationScope.server_domain_url}', 'upload_pitcure.png');
    </script>  
  </body>
</html>