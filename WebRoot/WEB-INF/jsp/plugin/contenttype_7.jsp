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
    <div class="input-p repend">
      <span class="add-on">备注：</span>
      <textarea id="summary_${customerTemplateContent.templateAreaId }" name="summary_${customerTemplateContent.templateAreaId }" class="input-xlarge" rows="3" placeholder="请输入备注">${customerTemplateContent.summary }</textarea>
    </div>   
    <input type="hidden" id="content_${customerTemplateContent.templateAreaId }" name="content_${customerTemplateContent.templateAreaId }" value="${customerTemplateContent.content }" title="请选择区域[${customerTemplateContent.templateAreaName }]的投票活动" />
    <h5>选择投票活动：</h5>
    <c:if test="${empty voteList}">
    	<p class="text-warning">您暂无投票活动，请先添加投票活动</p>
    </c:if>
    <c:if test="${not empty voteList}">
    	<c:forEach items="${voteList}" var="e" varStatus="v">
    		<h6 class="text-info"><label><input onclick="javascript: assembleVote(${customerTemplateContent.templateAreaId });" type="radio" value="${e.id }" name="vote_${customerTemplateContent.templateAreaId }" />&nbsp;${e.name }</label></h6>
    	</c:forEach>
    </c:if>
    <a href="<%=request.getContextPath()%>/voteAction_list.action?cId=${sessionScope.cId }&tId=${customerTemplateContent.templateId }" class="btn btn-warning btn-small">投票活动管理</a>
    <script type="text/javascript">
    	checkAlreadyChooseVote(${customerTemplateContent.templateAreaId }, '${customerTemplateContent.content }');
    </script> 
</div>