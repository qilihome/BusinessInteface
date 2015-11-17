<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title></title>
		<link href="<%=request.getContextPath()%>/include/css/boss/master.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="location" id="location">
			<span class="location_l"></span>
			<span class="location_bg">栏目管理</span>
			<span class="location_r"></span>
		</div>
		<form id="forwadForm" action="" method="post">
			<input id="customerId" name="customerId" value="${customerId }" type="hidden" />
			<input id="channelId" name="channelId" value="${channelId }" type="hidden" />
			<input id="moduleId" name="moduleId" value="${moduleId }" type="hidden" />
			<input id="ids" name="ids" value="" type="hidden" />
		</form>
		<div class="operate" id="operate">
			<span class="action01" onmouseover="this.className='action01_on'" onmouseout="this.className='action01'"> <a id="btn_del" href="#" class="icon_del">删除</a></span>
			<span class="action01" onmouseover="this.className='action01_on'" onmouseout="this.className='action01'"> <a id="btn_add" href="#" class="icon_add">添加</a></span>
			<span class="action01" onmouseover="this.className='action01_on'" onmouseout="this.className='action01'"> <a id="btn_back" href="#" class="icon_up">返回</a></span>
		</div>
		<div class="tb_title_bg" id="tb_title_bg">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tb_title">
				<tr>
					<td class="t1">
						<input type="checkbox" value="" title="全选/取消" onclick="selectAll(this.checked)" />
					</td>
					<td class="t2">栏目名称</td>
					<td class="t4">显示顺序</td>
					<td class="t6">栏目描述</td>
					<td class="t6">栏目简介</td>
					<td class="t6">栏目类型</td>
					<td class="t6">栏目内容</td>
					<td class="t6">栏目LOGO</td>
					<td class="t2">创建时间</td>
					<td class="t8">修改</td>
					<td class="t7"></td>
				</tr>
			</table>
		</div>
		<div class="tb_cont_box" id="tb_cont_box">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tb_cont">
				<c:choose>
					<c:when test="${empty columnList}">
						<tr onmouseover="this.className='tr_on'" onmouseout="this.className=''">
							<td colspan="10" class="t9">未查询到栏目信息，请添加栏目！</td>
							<td class="t7"></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${columnList}" var="item">
							<tr onmouseover="this.className='tr_on'" onmouseout="this.className=''">
								<td class="t1">
									<input name="keyIds" type="checkbox" value="${item.id }" />
								</td>
								<td class="t2">${item.name }</td>
								<td class="t4">${item.sequence }</td>
								<td class="t6">${item.summary }</td>
								<td class="t6">${item.detail }</td>
								<td class="t6">${item.type }</td>
								<td class="t6">${item.content }</td>
								<td class="t6">${item.logo }</td>
								<td class="t2">${item.createtime }</td>
								<td class="t8">
									<a onclick="javascript: edit(${item.id });" href="#"><img src="<%=request.getContextPath()%>/images/icon/icon_15_1.gif" alt="修改" border="0" align="absmiddle" /></a>
								</td>
								<td class="t7"></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<input type="hidden" id="msg" value="${message}"/>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/artDialog/artDialog.js?skin=default"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/pngfix.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/message.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/column/column_list.js" ></script>
	</body>
</html>