<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="div-signin">
    <legend><h5>区域：${customerTemplateContent.templateAreaName }，内容类型：${contentTypeName }</h5></legend>
    <input type="hidden" name="arearid_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.templateAreaId }">
    <input type="hidden" name="arearname_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.templateAreaName }">
    <input type="hidden" name="contenttype_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.contenttype }">
    <div class="input-prepend input-append">
      <span class="add-on">地址：</span>
      <input id="title_${customerTemplateContent.templateAreaId }" name="title_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.title }" maxlength="20" class="input-xlarge" id="prependedInput" type="text" title="请输入区域[${customerTemplateContent.templateAreaName }]的地址" placeholder="请输入地址">
      <span class="add-on text-error">*</span>
    </div>   
    <div class="input-prepend">
      <span class="add-on">备注：</span>
      <textarea id="summary_${customerTemplateContent.templateAreaId }" name="summary_${customerTemplateContent.templateAreaId }" class="input-xlarge" rows="3" placeholder="请输入备注">${customerTemplateContent.summary }</textarea>
    </div>      
    <input type="hidden" id="content_${customerTemplateContent.templateAreaId }" name="content_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.content }" title="请设置区域[${customerTemplateContent.templateAreaName }]的地图" />
    <div class="input-prepend input-append">
      <span class="add-on">经度：</span>
      <input id="centerX_${customerTemplateContent.templateAreaId }" onchange="assembleMapParameters(${customerTemplateContent.templateAreaId });" value="" maxlength="20" class="input-xlarge" style="width: 160px;" id="prependedInput" type="text" placeholder="请输入经度">
      <span class="add-on text-error">值范围[73.5 , 135]*</span>
    </div>
    <div class="input-prepend input-append">
      <span class="add-on">纬度：</span>
      <input id="centerY_${customerTemplateContent.templateAreaId }" onchange="assembleMapParameters(${customerTemplateContent.templateAreaId });" value="" maxlength="20" class="input-xlarge" style="width: 160px;" id="prependedInput" type="text" placeholder="请输入纬度">
      <span class="add-on text-error">值范围[3.5 , 53]*</span>
    </div>
    <div class="input-prepend input-append">
      <span class="add-on">宽度：</span>
      <input id="sizeW_${customerTemplateContent.templateAreaId }" onchange="assembleMapParameters(${customerTemplateContent.templateAreaId });" value="" maxlength="20" class="input-xlarge" style="width: 160px;" id="prependedInput" type="text" placeholder="请输入宽度">
      <span class="add-on text-error">值范围[50 , 1680]*</span>
    </div>
    <div class="input-prepend input-append">
      <span class="add-on">高度：</span>
      <input id="sizeH_${customerTemplateContent.templateAreaId }" onchange="assembleMapParameters(${customerTemplateContent.templateAreaId });" value="" maxlength="20" class="input-xlarge" style="width: 160px;" id="prependedInput" type="text" placeholder="请输入高度">
      <span class="add-on text-error">值范围[50 , 1200]*</span>
    </div>
    <div class="input-prepend input-append">
      <span class="add-on">级别：</span>
      <input id="zoom_${customerTemplateContent.templateAreaId }" onchange="assembleMapParameters(${customerTemplateContent.templateAreaId });" value="" maxlength="20" class="input-xlarge" style="width: 160px;" id="prependedInput" type="text" placeholder="请输入缩放级别">
      <span class="add-on text-error">值范围[4 , 17]*</span>
    </div>
    <div class="input-prepend">
      <span class="add-on">跳转地址：</span>
      <input name="backup1_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.backup1 }" maxlength="200" class="input-xlarge" id="prependedInput" type="text" placeholder="请输入跳转址">
    </div>
    <div>
    	<c:choose>
    		<c:when test="${not empty customerTemplateContent.content }">
    			<img class="img-polaroid" src="http://st.map.soso.com/api?${customerTemplateContent.content }" id="content_preview_${customerTemplateContent.templateAreaId }"/>
    		</c:when>
    		<c:otherwise>
    			<img class="img-polaroid" src="<%=request.getContextPath()%>/images/icon/edit_img.gif" id="content_preview_${customerTemplateContent.templateAreaId }"/>	
    		</c:otherwise>
    	</c:choose>
    </div>
    <script type="text/javascript">
    	parserMapParameters(${customerTemplateContent.templateAreaId }, '${customerTemplateContent.content }');
    </script>   
</div>