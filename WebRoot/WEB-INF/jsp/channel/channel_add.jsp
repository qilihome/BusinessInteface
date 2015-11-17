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
			<span class="location_bg">添加频道</span>
			<span class="location_r"></span>
		</div>
		<form  name="addForm" id="addForm" action="channelAction_add.action" method="post">
			<input name="customerId" value="${customerId }" type="hidden" />
			<div class="content_frame">
				<div class="frame_area" id="frame_area">
					<p>
						<label>频道名称：</label>
						<input class="input_01" name="channelForm.name" id="channelName" title="频道名称" type="text" maxlength="20"/>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>频道访问指令：</label>
						<input class="input_01" name="channelForm.accesscmd" id="channelAccesscmd" title="频道访问指令" type="text" maxlength="10"/>
						<span class="unit"><span class="rd">*</span>用户通过微信上行访问指令内容</span>
					</p>
					<p>
						<label>频道类型：</label>
						<select name="channelForm.type" class="input_01">
							<option value="1" selected="selected">自定义频道</option>
							<option value="2">抽奖类频道</option>
							<option value="3">投票类频道</option>
							<option value="4">像册类频道</option>
						</select>
						<span class="unit"><span class="rd">*</span></span>
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
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/boss/channel/channel_add.js"></script>
	</body>
</html>
