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
			<span class="location_bg">添加模块</span>
			<span class="location_r"></span>
		</div>
		<form  name="addForm" id="addForm" action="moduleAction_add.action" method="post">
			<input name="customerId" value="${customerId }" type="hidden" />
			<input name="channelId" value="${channelId }" type="hidden" />
			<div class="content_frame">
				<div class="frame_area" id="frame_area">
					<p>
						<label>模块名称：</label>
						<input class="input_01" name="moduleForm.name" id="moduleName" title="模块名称" type="text" maxlength="20" />
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>是否在页面显示模块名称：</label>
						<input type="radio" name="moduleForm.showname" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="moduleForm.showname" value="2" />否
					</p>
					<p>
						<label>模块简介：</label>
						<input class="input_01" name="moduleForm.summary" id="moduleSummary" title="模块简介" type="text" maxlength="100"/>
					</p>
					<p>
						<label>是否在页面显示模块简介：</label>
						<input type="radio" name="moduleForm.showsummary" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="moduleForm.showsummary" value="2" />否
					</p>
					<p>
						<label>模块在页面显示顺序：</label>
						<select name="moduleForm.sequence" class="input_01">
							<c:forEach begin="1" end="20" step="1" var="e">
								<option value="${e }">${e }</option>
							</c:forEach>
						</select>
						<span class="unit"><span class="rd">*</span>值越小显示越靠前</span>
					</p>
				</div>
			</div>
			<div class="btn_bar_bg" id="btn_bar_bg">
				<input name="确定" type="button" onclick="javascript: add()" class="btn_01" onmouseover="this.className='btn_01_on'" onmouseout="this.className='btn_01'" value=" 确 定 " />
				<input name="取消" type="button" onclick="javascript: historyGo()" class="btn_01" onmouseover="this.className='btn_01_on'" onmouseout="this.className='btn_01'" value=" 取 消 " />
			</div>
		</form>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/pngfix.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/module/module_add.js" ></script>
	</body>
</html>
