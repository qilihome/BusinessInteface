// * 该公共脚本中包含的方法有：
// * 检查必填项 function verifyInputField( fieldIds)
// * 检查必选项 function verifySelectField( fieldIds)
// * 判断复选框是否有选择 function verifyCheckboxField( fieldName, fieldTitle)
// * 检查输入值的长度 function verifyInputLength( fieldIds, minLength,
// maxLength)
// * 验证两个值是否相同 function verifyValueEqual( fieldId1, fieldId2)
// * 验证正则表达式 function checkExp(re, s)
// * 验证是否是数字 function IsNumber(strValue)
// * 验证是否是浮点数 function IsFloat(StrValue)
// * 验证是否是指定前缀的11位手机号 function IsMsisdn11( fieldId)
// * 居中弹出提示窗 function alertMsgAndFocus(header, message)
// * 在元素正上方弹出提示窗 function alertMsgAndFocus2(message, header, sender)
// * 得到字符串的真实长度 function strLen(value)
// * 截取字符 function interceptChatContent(content, maxlen)
// * 控制输入 function controlInput(obj, maxlen)
// * 只能是字母，数字，下划线 function alphanumeric( fieldId)
// * 验证邮件地址是否合法 function email( fieldId)
// * 检查数字 function verifyIsNumber( fieldIds)
// * 检查浮点数 function verifyIsFloat( fieldIds)
// * 只能是字母与数字 function verifyLettersOrNumbers( fieldId)
// * 只能是字母与中文 function verifyLettersOrChinese( fieldId)
// * 验证电话号码 function isTel( fieldId)
// * 验证联系电话（手机号或座机）function isPhone( fieldIds)
// * 元素样式切换 function toggleElemClass(targetElemId, removeClassName,
// addClassName)
// * 动态计算元素相对高度 function calcEleHeight(totalHeight, targetId, minusTargetIds,
// addTargetIds, adjustValue)
// * 动态计算元素相对宽度 function calcEleWidth(totalWidth, targetId, minusTargetIds,
// addTargetIds, adjustValue)

/**
 * 去掉所有空格，包括半角与全角空格
 * 
 * @param {}
 *            Str
 * @return {}
 */
function trimAllSpace(Str) {
	return $.trim(trimChSpace($.trim(Str)));
}
function showLoading() {
	var list = art.dialog.list;
	for (var i in list) {
		list[i].close();
	};
	return art.dialog({
				esc : true,
				lock : true,
				title : false,
				fixed : true,
				drag : false
			});
}
// 弹出窗式的提示信息
function alertMsg(message) {
	var list = art.dialog.list;
	for (var i in list) {
		list[i].close();
	};
	art.dialog({
				icon : 'warning',
				esc : true,
				content : message,
				lock : true,
				fixed : true,
				drag : false,
				ok : true
			}).time(2);
}
// 弹出窗式的提示信息
function alertMsg(message, icon) {
	var list = art.dialog.list;
	for (var i in list) {
		list[i].close();
	};
	art.dialog({
				icon : icon,
				esc : true,
				content : message,
				lock : true,
				fixed : true,
				drag : false,
				ok : true
			}).time(2);
}

//弹出窗式的提示信息以及焦点定位
function alertMsgAndFocus(message, jqId) {
	var list = art.dialog.list;
	for (var i in list) {
	    list[i].close();
	};
	art.dialog({
		icon:'warning', 
		esc:true, 
		content:message, 
		lock:true, 
		fixed:true, 
		drag:false, 
		ok:true,
		button:[
			{name: '确定', focus: true, callback: function () {$(jqId).focus();return true;}}]
		}).time(2);
}

// 检查必填项
function verifyInputField(fieldIds) {
	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		var val = trimAllSpace(($(jqId).val()));
		$(jqId).val(val);
		if (!val) {
			alertMsgAndFocus($(jqId).attr("title"), jqId);
			return false;
		}
	}
	return true;
}

// 检查必选项
function verifySelectField(fieldIds) {
	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		if ($(jqId).val() == "" || $(jqId).val() <= 0) {
			alertMsgAndFocus("请选择" + $(jqId).attr("title"), jqId);
			return false;
		}
	}
	return true;
}

// 检查输入值的长度
function verifyInputLength(fieldIds, minLength, maxLength) {
	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		var value = trimAllSpace($(jqId).val());
		$(jqId).val(value);
		var reallen = value.length;
		if (reallen < minLength) {
			alertMsgAndFocus($(jqId).attr("title") + "长度不能少于" + minLength
							+ "个字符，您已输入" + reallen + "个字符！", jqId);
			return false;
		}
		if (reallen > maxLength) {
			alertMsgAndFocus($(jqId).attr("title") + "长度不能超过" + maxLength
							+ "个字符，您已输入" + reallen + "个字符！", jqId);
			return false;
		}
	}
	return true;
}

// 验证两个值是否相同
function verifyValueEqual(fieldId1, fieldId2) {
	var jqId1 = "#" + fieldId1;
	var jqId2 = "#" + fieldId2;
	if ($(jqId1).val() != $(jqId2).val()) {
		alertMsgAndFocus($(jqId2).attr("title") + "与" + $(jqId1).attr("title")
						+ "值不一致", jqId2);
		$(jqId2)[0].select();
		return false;
	}
	return true;
}

// 判断复选框是否有选择
function verifyCheckboxField(fieldName, fieldTitle) {
	var ch = $("input[name=" + fieldName + "]:checked").size();
	if (ch > 0) {
		return true;
	} else {
		alertMsg("请选择" + fieldTitle);
		return false;
	}
}

// 检查是否是正整数
function verifyIsNumber(fieldIds) {
	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		if ($(jqId).val()) {
			if (!IsNumber($(jqId).val()) || Number($(jqId).val()) <= 0) {
				alertMsgAndFocus($(jqId).attr("title") + "必须是大于0的正整数！", jqId);
				return false;
			}
		}
	}
	return true;
}

// 检查是否是浮点数
function verifyIsFloat(fieldIds) {
	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		if ($(jqId).val()) {
			if (!IsFloat($(jqId).val()) || Number($(jqId).val()) <= 0) {
				alertMsgAndFocus($(jqId).attr("title") + "必须是大于0的数值！", jqId);
				return false;
			}
		}
	}
	return true;
}

// 检查用户名
function chkUsername(fieldId) {
	var jqId = "#" + fieldId;
	var username = trimAllSpace($(jqId).val());
	$(jqId).val(username);
	var title = $(jqId).attr("title");
	if (/^\d.*$/.test(username)) {
		// 用户名不能以数字开头
		alertMsgAndFocus(title + "不能以数字开头", jqId);
		$(jqId)[0].select();
		return false;
	} else if (fLen(username) < 5) {
		// 用户名长度小于6个字符
		alertMsgAndFocus(title + "长度不能小于5个字符", jqId);
		$(jqId)[0].select();
		return false;
	} else if (!/^\w+$/.test(username)) {
		// 用户名只能包含_,英文字母，数字
		alertMsgAndFocus(title + "只能输入字母、数字和下划线", jqId);
		$(jqId)[0].select();
		return false;
	} else if (!/^([a-z]|[A-Z])[0-9a-zA-Z_]+$/.test(username)) {
		// 用户名只能英文字母开头
		alertMsgAndFocus(title + "只能以字母开头", jqId);
		$(jqId)[0].select();
		return false;
	} else if (!(/[0-9a-zA-Z]+$/.test(username))) {
		// 用户名只能英文字母或数字结尾
		alertMsgAndFocus(title + "只能以英文字母或数字结尾", jqId);
		$(jqId)[0].select();
		return false;
	}
	return true;
}

// 计算字符数，一个中文2个字符
function fLen(Obj) {
	var nCNLenth = 0;
	var nLenth = Obj.length;
	for (var i = 0; i < nLenth; i++) {
		if (Obj.charCodeAt(i) > 255) {
			nCNLenth += 2;
		} else {
			nCNLenth++;
		}
	}
	return nCNLenth;
}

// 用于判断业务管理时，业务添加与修改时的各种指令是否相同的判断与提示
function checkCommandEqual(fieldIds) {
	var commands = new Array()
	var fieldId = new Array()

	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		var command = $.trim($(jqId).val());

		var currentLength = commands.length;
		var valueIndex = $.inArray(command, commands)
		if (valueIndex < 0) {
			commands[currentLength] = command;
			fieldId[currentLength] = jqId;
		} else {
			var exsitId = fieldId[valueIndex];
			var tip = $(jqId).attr("title") + "不能和" + $(exsitId).attr("title")
					+ "相同";
			alertMsgAndFocus(tip, jqId);
			return false;
		}
	}
	return true;
}

String.prototype.endWith = function(s) {
	if (s == null || s == "" || this.length == 0 || s.length > this.length)
		return false;
	if (this.substring(this.length - s.length) == s)
		return true;
	else
		return false;
	return true;
}
String.prototype.startWith = function(s) {
	if (s == null || s == "" || this.length == 0 || s.length > this.length)
		return false;
	if (this.substr(0, s.length) == s)
		return true;
	else
		return false;
	return true;
}

// 验证正则表达式
function checkExp(re, s) {
	return re.test(s);
}

// 验证是否是数字
function IsNumber(strValue) {
	return checkExp(/^\d*$/g, strValue);
}

function IsNumbers(fieldIds) {
	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		if (!IsNumber($(jqId).val()) || Number($(jqId).val()) <= 0) {
			alertMsgAndFocus($(jqId).attr("title") + "只能是大于0的整数", jqId);
			return false;
		}
	}
	return true;
}

// 验证是否是浮点数
function IsFloat(StrValue) {
	if (IsNumber(StrValue))
		return true;
	return checkExp(/^\d+(.\d+)$/g, StrValue);
}

// 验证是否是指定前缀的11位手机号
function IsMsisdn11(fieldId) {
	var jqId = "#" + fieldId;
	var value = $(jqId).val();
	if (value == '' || value.length != 11) {
		alertMsgAndFocus($(jqId).attr("title") + "不合法", jqId);
		$(jqId)[0].select();
		return false;
	}

	var reg = /^\d*$/g;
	var flg = reg.test(value);
	if (!flg) {
		alertMsgAndFocus($(jqId).attr("title") + "不合法", jqId);
		$(jqId)[0].select();
		return false;
	}

	var prefix = value.substring(0, 1);
	if ("1" != prefix) {
		alertMsgAndFocus($(jqId).attr("title") + "不合法", jqId);
		$(jqId)[0].select();
		return false;
	}
	return true;
}

// 得到字符串的真实长度
function strLen(value) {// 得到字符串的真实长度（双字节换算为两个单字节）
	var strlen = value.replace(/[^\x00-\xff]/g, "xx").length;
	return strlen;
}

// 截取字符 content : 需要截取的字符串
function interceptChatContent(content, maxlen) {
	var len = content.length;
	var count = 0;
	var newcontent = "";
	for (var i = 0; i < len; i++) {
		var charCode = content.charCodeAt(i);
		if (charCode < 255 && charCode > 0) {
			count++;
		} else {
			count += 2;
		}
		if (count > maxlen) {
			break;
		} else {
			newcontent += String.fromCharCode(charCode);
		}
	}
	return newcontent;
}

// 控制输入
function controlInput(obj, maxlen) {
	var value = $("#" + obj).val();
	var reallen = strLen(value);
	if (reallen >= maxlen) {

		var content = interceptChatContent(value, maxlen);
		$("#" + obj).val(content);
	}
}

// 只能是字母，数字，下划线 Letters, numbers or underscores only please
function alphanumeric(fieldId) {
	var jqId = "#" + fieldId;
	var value = $(jqId).val();
	if (/^[A-Za-z0-9_-]+$/g.test(value)) {
		return true;
	} else {
		alertMsgAndFocus($(jqId).attr("title") + "不合法！", jqId);
		$(jqId)[0].select();
		return false;
	}
}

// 只能是字母与数字 Letters or numbers only please
function verifyLettersOrNumbers(fieldId) {
	var jqId = "#" + fieldId;
	var value = $(jqId).val();
	if (/^[A-Za-z0-9]+$/i.test(value)) {
		return true;
	} else {
		alertMsgAndFocus($(jqId).attr("title") + "不合法！", jqId);
		$(jqId)[0].select();
		return false;
	}
}

// 只能是字母与中文 Letters or Chinese only please
function verifyLettersOrChinese(fieldId) {
	var reg = new RegExp("^[a-zA-Z\u4e00-\u9fa5]+$");
	var jqId = "#" + fieldId;
	var value = $(jqId).val();
	if (!reg.test(value)) {
		alertMsgAndFocus($(jqId).attr("title") + "不合法！", jqId);
		$(jqId)[0].select();
		return false;
	} else {
		return true;
	}
}

// 验证邮件地址是否合法
function email(fieldId) {
	return isEmail(fieldId);
}

/**
 * 验证邮件地址是否合法
 * 
 * @param {}
 *            operationName
 * @param {}
 *            fieldId
 * @return {Boolean}
 */
function isEmail(fieldId) {
	var jqId = "#" + fieldId;
	var email = $(jqId).val();
	if (!validateEmail(trimAllSpace(email))) {
		alertMsgAndFocus($(jqId).attr("title") + "不合法！", jqId);
		$(jqId)[0].select();
		return false;
	} else {
		return true;
	}
}

function validateEmail(email) {
	var at = email.lastIndexOf("@");

	// Make sure the at (@) sybmol exists and
	// it is not the first or last character
	if (at < 1 || (at + 1) === email.length)
		return false;

	// Make sure there aren't multiple periods together
	if (/(\.{2,})/.test(email))
		return false;

	// Break up the local and domain portions
	var local = email.substring(0, at);
	var domain = email.substring(at + 1);

	// Check lengths
	if (local.length < 1 || local.length > 64 || domain.length < 4
			|| domain.length > 255)
		return false;

	// Make sure local and domain don't start with or end with a period
	if (/(^\.|\.$)/.test(local) || /(^\.|\.$)/.test(domain))
		return false;

	// Check for quoted-string addresses
	// Since almost anything is allowed in a quoted-string address,
	// we're just going to let them go through
	if (!/^"(.+)"$/.test(local)) {
		// It's a dot-string address...check for valid characters
		if (!/^[-a-zA-Z0-9!#$%*\/?|^{}`~&'+=_\.]*$/.test(local))
			return false;
	}

	// Make sure domain contains only valid characters and at least one period
	if (!/^[-a-zA-Z0-9\.]*$/.test(domain) || domain.indexOf(".") === -1)
		return false;

	return true;
}

// 验证电话号码
function isTel(fieldIds) {
	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		$(jqId).val(trimAllSpace($(jqId).val()));
		if ($(jqId).val()) {
			var pattern = /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
			if (!pattern.test($(jqId).val())) {
				alertMsgAndFocus($(jqId).attr("title") + "不合法！", jqId);
				$(jqId)[0].select();
				return false;
			}
		}
	}
	return true;
}

/**
 * 验证联系电话（手机号或座机）
 * 
 * @param {}
 *            operationName
 * @param {}
 *            fieldIds
 * @return {Boolean}
 */
function isPhone(fieldIds) {
	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		var value = $(jqId).val();
		if (value != null && value != '') {
			if (/^[0-9]+$/i.test(value) == false) {
				alertMsgAndFocus($(jqId).attr("title") + "不合法！", jqId);
				$(jqId)[0].select();
				return false;
			}
		}
	}
	return true;
}

/**
 * 元素样式切换
 * 
 * @param {}
 *            targetElemId
 * @param {}
 *            removeClassName
 * @param {}
 *            addClassName
 */
function toggleElemClass(targetElemId, removeClassName, addClassName) {
	$("#" + targetElemId).removeClass(removeClassName).addClass(addClassName);
}

/**
 * 动态计算元素相对高度
 * 
 * @param {}
 *            totalHeight
 * @param {}
 *            targetId
 * @param {}
 *            minusTargetIds
 * @param {}
 *            addTargetIds
 * @param {}
 *            adjustValue
 */
function calcEleHeight(totalHeight, targetId, minusTargetIds, addTargetIds,
		adjustValue) {
	if ($("#" + targetId)) {
		var minusHeight = 0;
		if ($.trim(minusTargetIds)) {
			var minusIds = minusTargetIds.split(",");
			for (var i = 0; i < minusIds.length; i++) {
				if ($("#" + minusIds[i]))
					minusHeight = minusHeight
							+ $("#" + minusIds[i]).outerHeight(true);
			}
		}

		var addHeight = 0;
		if ($.trim(addTargetIds)) {
			var addIds = addTargetIds.split(",");
			for (var i = 0; i < addIds.length; i++) {
				if ($("#" + addIds[i]))
					addHeight = addHeight
							+ $("#" + addIds[i]).outerHeight(true);
			}
		}
		var target = $("#" + targetId);
		var targetFinalHeight = totalHeight - minusHeight + addHeight
				- (target.outerHeight(false) - target.height());
		target.height(targetFinalHeight + adjustValue);
	}
}

// 通过元素的class来计算目标元素
/**
 * 通过元素的class来计算目标元素
 * 
 * @param {}
 *            _totalHeight
 * @param {}
 *            _target
 * @param {}
 *            _minusTargets
 * @param {}
 *            _addTargets
 * @param {}
 *            _adjustValue
 */
function calcEleHeightByClass(_totalHeight, _target, _minusTargets,
		_addTargets, _adjustValue) {
	var target = $(_target);
	if (target.length > 0) {
		var minusHeight = 0;
		if ($.trim(_minusTargets)) {
			var minusTargets = _minusTargets.split(",");
			for (var i = 0; i < minusTargets.length; i++) {
				var eachMinusTarget = $(minusTargets[i]);
				if (eachMinusTarget.length > 0)
					minusHeight = minusHeight
							+ eachMinusTarget.outerHeight(true);
			}
		}

		var addHeight = 0;
		if ($.trim(_addTargets)) {
			var addTargets = _addTargets.split(",");
			for (var i = 0; i < addTargets.length; i++) {
				var eachAddTarget = $(addTargets[i]);
				if (eachAddTarget.length > 0)
					addHeight = addHeight + eachAddTarget.outerHeight(true);
			}
		}
		var targetFinalHeight = _totalHeight - minusHeight + addHeight
				- (target.outerHeight(false) - target.height());
		target.height(targetFinalHeight + _adjustValue);
	}
}

/**
 * 动态计算元素相对宽度
 * 
 * @param {}
 *            totalWidth
 * @param {}
 *            targetId
 * @param {}
 *            minusTargetIds
 * @param {}
 *            addTargetIds
 */
function calcEleWidth(totalWidth, targetId, minusTargetIds, addTargetIds,
		adjustValue) {
	var minusWidth = 0;
	if ($.trim(minusTargetIds)) {
		var minusIds = minusTargetIds.split(",");
		for (var i = 0; i < minusIds.length; i++) {
			minusWidth = minusWidth + $("#" + minusIds[i]).outerWidth(true);
		}
	}

	var addWidth = 0;
	if ($.trim(addTargetIds)) {
		var addIds = addTargetIds.split(",");
		for (var i = 0; i < addIds.length; i++) {
			addWidth = addWidth + $("#" + addIds[i]).outerWidth(true);
		}
	}

	var targetFinalWidth = totalWidth - minusWidth + addWidth;
	$("#" + targetId).width(targetFinalHeight + adjustValue);
}

function IsDigit() {// validate num
	return ((event.keyCode >= 48) && (event.keyCode <= 57));
}

function IsMsisdn11GroupManage(value, preAccord) {// 验证是否是指定前缀的11位手机号
	if (value == '' || value.length != 11)
		return false;

	var reg = /^\d*$/g;
	var flg = reg.test(value);
	if (!flg)
		return false;

	var prefix = value.substring(0, 3);
	// var accord = "134,135,136,137,138,139,159";
	if (preAccord.indexOf(prefix) == -1)
		return false;

	return true;
}

function IsAlphaNumeric(strValue) {// A-Z a-z 0-9
	return checkExp(/^\w*$/gi, strValue);
}

/**
 * 验证是否是数字，字母与下划线
 * 
 * @param {}
 *            strValue
 * @return {}
 */
function IsAlphaNumericAndSub(strValue) {// A-Z a-z 0-9
	// alert('test');
	// return checkExp( /^[A-Za-z0-9\-]*$/, strValue );
	return /^[A-Za-z0-9\-]*$/.test(strValue);
}

function IsCheckBoxSelect(form, boxName) {// validate isSelect by (form
	// boxName)
	if (form[boxName] == null)
		return false;

	if (typeof(form[boxName].length) == "number") {
		var len = form[boxName].length;
		for (var i = 0; i < len; i++) {
			if (form[boxName][i].checked)
				return true;
		}
		return false;
	} else {
		return form[boxName].checked;
	}

}
function ShowDialog(url, windowwidth, windowheight) {
	// windowwidth=750
	// windowheight=450
	var dleft = parseInt(screen.width - windowwidth) / 2
	var dtop = parseInt(screen.height - windowheight) / 2
	var dialogStyle = "dialogHeight:" + windowheight + "px;dialogWidth:"
			+ windowwidth + "px;dialogTop:" + dtop + ";dialogLeft:" + dleft
			+ ";status:no;scroll:no"
	var result1 = window.showModalDialog(url, '', dialogStyle)
	return result1;
}

function ShowDialogWithArgs(url, args, windowwidth, windowheight) {
	// windowwidth=750
	// windowheight=450
	var dleft = parseInt(screen.width - windowwidth) / 2
	var dtop = parseInt(screen.height - windowheight) / 2
	var dialogStyle = "dialogHeight:" + windowheight + "px;dialogWidth:"
			+ windowwidth + "px;dialogTop:" + dtop + ";dialogLeft:" + dleft
			+ ";status:no;scroll:no"
	var result1 = window.showModalDialog(url, args, dialogStyle)
	return result1;
}

function IsNumericInRangeLen(value, min, max) {
	if (value == '' || value.length < 1)
		return false;

	var reg = /^\d*$/g;
	var flg = reg.test(value);

	if (!flg)
		return false;
	if (value.length < min || value.length > max)
		return false;

	return true;
}

function IsNumericInRangeValue(value, min, max) {
	if (!IsNumber(value))
		return false;

	if (value < min || value > max)
		return false;

	return true;
}

function Trim(value) {// trim space
	if (value == null || typeof(value) == "undefined" || value.length < 1)
		return "";

	value = Rtrim(value);
	value = Ltrim(value);

	return value;
}

function Ltrim(value) {// trim left space
	if (value == null || typeof(value) == "undefined" || value.length < 1)
		return "";

	var v_length = value.length;
	var w_space = String.fromCharCode(32);
	var strTemp = "";
	var i = 0;

	while (i < v_length) {
		if (value.charAt(i) == w_space)
			i++;
		else {
			strTemp = value.substring(i, v_length);
			break;
		}
	}

	return strTemp;
}

function Rtrim(value) {// trim right space
	if (value == null || typeof(value) == "undefined" || value.length < 1)
		return "";

	var w_space = String.fromCharCode(32);
	var i = value.length - 1;
	var strTemp = "";

	while (i > -1) {
		if (value.charAt(i) == w_space)
			i--;
		else {
			strTemp = value.substring(0, i + 1);
			break;
		}
	}

	return strTemp;
}

// 去除字符串两边的中文空格的函数
// 参数：mystr传入的字符串
// 返回：字符串mystr
function trimChSpace(mystr) {
	if (mystr == null || typeof(mystr) == "undefined" || mystr.length < 1)
		return "";
	var chSpace = "　";
	while ((mystr.indexOf(chSpace) == 0) && (mystr.length > 1)) {
		mystr = $.trim(mystr.substring(1, mystr.length));
	}// 去除前面空格
	while ((mystr.lastIndexOf(chSpace) == mystr.length - 1)
			&& (mystr.length > 1)) {
		mystr = $.trim(mystr.substring(0, mystr.length - 1));
	}// 去除后面空格
	if (mystr == chSpace) {
		mystr = "";
	}
	return mystr;
}

function IsTime(str) {
	var a = str.match(/^(\d{2})(:)?(\d{2})\2(\d{2})$/);
	if (a == null)
		return false;

	if (a[1] > 23 || a[3] >= 60 || a[4] >= 60)
		return false

	return true;
}
function IsPhoneTxt() {// validate phone
	return (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 44));
}

function IsCheckBoxChecked(checkbox) {// validate isChecked
	var obj = document.getElementsByName(checkbox);

	if (obj == null)
		return false;

	if (typeof(obj.length) == "number") {
		var len = obj.length;
		for (var i = 0; i < len; i++)
			if (obj[i].checked)
				return true;
		return false;
	} else {
		return false;
	}
}

function IsHttpUrl(fieldIds) {
	var ids = fieldIds.split(",");
	for (var i = 0; i < ids.length; i++) {
		var jqId = "#" + ids[i];
		var str = trimAllSpace($(jqId).val());
		$(jqId).val(str);
		str = str.toLowerCase();
		var i = str.indexOf("http://");
		if (i != 0)
			i = str.indexOf("https://");

		if (i != 0) {
			alertMsgAndFocus($(jqId).attr("title") + "不合法！", jqId);
			return false;
		}
	}
	return true;
}

function previewImgArea(path) {
	$('#mypreview')[0].href = path;
	if (document.all) {
		$('#mypreview')[0].click();
	} else {
		var evt = document.createEvent("MouseEvents");
		evt.initEvent("click", true, true);
		document.getElementById("mypreview").dispatchEvent(evt);
	}
}
String.prototype.replaceAll = function(s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
}

function verifySelectNotEqValue(fieldId, initvalue) {
	var fieldValue = $("#" + fieldId).val();
	var fieldTitle = $("#" + fieldId).attr('title');
	if (fieldValue == initvalue) {
		alertMsgAndFocus("请选择" + fieldTitle, fieldId);
		$("#" + fieldId).select();
		return false;
	} else {
		return true;
	}
}

function selectAll(flag) {
	$("input[name='keyIds']").each(function() {
				this.checked = flag;
			});
}