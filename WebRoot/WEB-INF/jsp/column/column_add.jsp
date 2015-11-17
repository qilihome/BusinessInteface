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
			<span class="location_bg">添加栏目</span>
			<span class="location_r"></span>
		</div>
		<form  name="addForm" id="addForm" action="columnAction_add.action" method="post">
			<input name="customerId" value="${customerId }" type="hidden" />
			<input name="channelId" value="${channelId }" type="hidden" />
			<input name="columnId" value="${columnId }" type="hidden" />
			<div class="content_frame">
				<div class="frame_area" id="frame_area">
					<p>
						<label>栏目名称：</label>
						<input class="input_01" name="columnForm.name" id="columnName" title="栏目名称" type="text" maxlength="20"/>
					</p>
					<p>
						<label>是否在页面显示栏目名称：</label>
						<input type="radio" name="columnForm.showname" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="columnForm.showname" value="2" checked="checked" />否
					</p>
					<p>
						<label>栏目备注：</label>
						<input class="input_01" name="columnForm.summary" id="columnSummary" title="栏目简介" type="text" maxlength="100"/>
					</p>
					<p>
						<label>是否在页面显示栏目备注：</label>
						<input type="radio" name="columnForm.showsummary" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="columnForm.showsummary" value="2" checked="checked" />否
					</p>
					<p>
						<label>栏目简介：</label>
						<input class="input_01" name="columnForm.detail" id="columnDetail" title="栏目简介" type="text" maxlength="100"/>
					</p>
					<p>
						<label>是否在页面显示栏目简介：</label>
						<input type="radio" name="columnForm.showdetail" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="columnForm.showdetail" value="2" checked="checked" />否
					</p>
					<p>
						<label>栏目在页面显示顺序：</label>
						<select name="columnForm.sequence" class="input_01">
							<c:forEach begin="1" end="40" step="1" var="e">
								<option value="${e }">${e }</option>
							</c:forEach>
						</select>
						<span class="unit"><span class="rd">*</span>值越小显示越靠前</span>
					</p>
					<p>
						<label>栏目类型：</label>
						<select id="columnType" name="columnForm.type" class="input_01">
							<option value="0" selected="selected">--请选择--</option>
							<option value="1">文本</option>
							<option value="2">单张图片</option>
							<option value="3">多张图片</option>
							<option value="4">视频</option>
							<option value="5">音频</option>
							<option value="6">文本与图片</option>
							<option value="7">文本与视频</option>
							<option value="8">文本与音频</option>
							<option value="9">地图导航</option>
						</select>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p id="columnType_1">
						<label>文本内容：</label>
						<textarea id="columnTextContent" title="文本内容" rows="10" cols="66"></textarea>
					</p>
					<p id="columnType_2">
						<label>单张图片：</label>
						<input id="custom_file_upload" type="file" name="fileData" />
					</p>
					<p id="columnType_3">
						<label>多张图片：</label>
						<input id="custom_file_upload" type="file" name="fileData" />
						<span class="unit"><span class="rd">*</span>支持同时选择多张图片上传，选择图片时同时按住"Ctrl"键或"Shift"键</span>
					</p>
					<p id="columnType_4">
						<label>视频：</label>
						<input id="custom_file_upload" type="file" name="fileData" />
					</p>
					<p id="columnType_5">
						<label>音频：</label>
						<input id="custom_file_upload" type="file" name="fileData" />
					</p>
					<p id="columnType_9">
						<label>地图导航：</label>
						<textarea id="columnTextContent" title="文本内容" rows="10" cols="66"></textarea>
					</p>
				</div>
			</div>
			<div class="btn_bar_bg" id="btn_bar_bg">
				<input name="确定" type="button" onclick="javascript: add()" class="btn_01" onmouseover="this.className='btn_01_on'" onmouseout="this.className='btn_01'" value=" 确 定 " />
				<input name="取消" type="button" onclick="javascript: historyGo()" class="btn_01" onmouseover="this.className='btn_01_on'" onmouseout="this.className='btn_01'" value=" 取 消 " />
			</div>
		</form>
		<input type="hidden" id="msg" value="${message}"/>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/artDialog/artDialog.js?skin=default"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/pngfix.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/message.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/column/column_add.js" ></script>
	</body>
</html>
