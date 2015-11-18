<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="div-signin">
    <legend><h5>区域：${customerTemplateContent.templateAreaName }，内容类型：${contentTypeName }</h5></legend>
    <input type="hidden" name="arearid_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.templateAreaId }">
    <input type="hidden" name="arearname_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.templateAreaName }">
    <input type="hidden" name="contenttype_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.contenttype }">
    <div class="input-prepend input-append">
      <span class="add-on">标题：</span>
      <input id="title_${customerTemplateContent.templateAreaId }" name="title_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.title }" maxlength="20" class="input-xlarge" id="prependedInput" type="text" title="请输入区域[${customerTemplateContent.templateAreaName }]的标题" placeholder="请输入标题">
      <span class="add-on text-error">*</span>
    </div>
    <div class="input-prepend">
      <span class="add-on">英文名称：</span>
      <input value="${customerTemplateContent.backup1 }" name="backup1_${customerTemplateContent.templateAreaId }" maxlength="100" class="input-xlarge" id="prependedInput" type="text" title="请输入英文名称" placeholder="请输入英文名称">
    </div>     
    <div class="input-prepend">
      <span class="add-on">备注：</span>
      <textarea id="summary_${customerTemplateContent.templateAreaId }" name="summary_${customerTemplateContent.templateAreaId }" class="input-xlarge" rows="3" placeholder="请输入备注">${customerTemplateContent.summary }</textarea>
    </div>      
    <div class="input-prepend input-append">
      <span class="add-on">图片[多图上传,选择图片时同时按住"Ctrl"或"Shift"]：</span>
      <input type="hidden" id="content_${customerTemplateContent.templateAreaId }" name="content_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.content }" title="请上传区域[${customerTemplateContent.templateAreaName }]的图片" />
      <input type="file" id="area_file_upload_${customerTemplateContent.templateAreaId }" name="area_file_upload_${customerTemplateContent.templateAreaId }" />
      <span class="add-on text-error">*</span>
    </div>
    <div id="custom-queue_${customerTemplateContent.templateAreaId }"></div>
    <script type="text/javascript">
    	loadUploadPlugin(${customerTemplateContent.templateAreaId }, '${customerTemplateContent.templateAreaName }', '<%=request.getContextPath()%>', ${applicationScope.pic_upload_size}, '${applicationScope.pic_upload_types}', '${applicationScope.pic_upload_exts}', '${applicationScope.server_domain_url}', 'upload_pitcure.png', true);
    </script>                       
</div>