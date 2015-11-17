var titlePre = "title_";
var contentPre = "content_";
$(document).ready(function() {
			$("#btn_save_config_submit").click(function() {
						// 判断所有必填项是否已经填写或上传了相应的资源
						for (var i = 0; i < areaArray.length; i++) {
							var eachAreaId = areaArray[i];
							if(!verifyInputField(titlePre + eachAreaId+","+contentPre + eachAreaId))
								return false;
						}
						$("#areaIds").val(areaArray.join());
						$("#configForm").submit();
					});

			$("#btn_reset_config").click(function() {
						$("#configForm").reset();
					});
		});

var areaArray = [];
var areaPluginMap = new Map();
var loadingDialog;
// 异步加载对应的插件
function loadTemplatePlugin(cid, areaId, type) {
	loadingDialog = showLoading();
	areaArray.push(areaId);
	$.ajax({
				type : "POST",
				url : "templateAreaAction_loadTemplatePlugin.action",
				data : {
					areaId : cid,
					type : type
				},
				beforeSend : function(XMLHttpRequest) {
					hasLoadTask = true;
				},
				success : function(data) {
					areaPluginMap.put(areaId, data);
					appendTemplatePluginToDocument();
					// $("#div_config_plugin_list").append(data);
				}
			});
}

// 将插件追加到配置页面
function appendTemplatePluginToDocument() {
	if (areaArray.length == areaPluginMap.size()) {
		for (var i = 0; i < areaArray.length; i++) {
			$("#div_config_plugin_list")
					.append(areaPluginMap.get(areaArray[i]));
		}
		// 清除数据
		areaPluginMap.clear();
		loadingDialog.close();
	}
}

// 加载各位区域对应的上传组件
function loadUploadPlugin(areaId, areaName, contextPath, picLimitSize, picTypes, picFileExt, serverDomain, upload_pitcure, multi){
	$('#area_file_upload_' + areaId) .uploadify({
		'uploader' : contextPath + '/plugin/uploadify/scripts/uploadify.swf',
		'script' : contextPath + '/fileUploadAction_upload.action?areaName='+areaName,
		'cancelImg' : contextPath + '/plugin/uploadify/cancel.png',
		'buttonImg' : contextPath + '/plugin/uploadify/' + upload_pitcure,
		'sizeLimit' : picLimitSize*1024,
		'multi' : multi,
		'auto' : true,
		'fileExt' : picTypes,
		'fileDesc' : 'Template Files ('+picFileExt+')',
		'queueID' : 'custom-queue_'+areaId,
		'queueSizeLimit' : 1,
		'simUploadLimit' : 1,
		'removeCompleted' : false,
		'onSelect' : function(event, ID, fileObj) {
			},
		'onComplete' : function(event, queueId, fileObj, response, data) {
				response = eval('('+response+')');
				if(response.result ||　response.result == 'true'){
					if(multi){
						var exsitContent = $("#content_" + areaId).val();
						if(exsitContent){
							$("#content_" + areaId).val(exsitContent + "," + response.path);
						}else{
							$("#content_" + areaId).val(response.path);
						}
					}else{
						$("#content_" + areaId).val(response.path);
						$("#content_preview_" + areaId)[0].src = contextPath + '/' + response.path + "?t=" + Math.random();
					}
				}else{
					alertMsg("资源上传失败，请重试", "warning");
				}
			},
		'onError' : function (event, ID, fileObj, errorObj) {
				if (errorObj.type === "File Size"){
					alertMsg('超过资源上传大小限制（'+picLimitSize+'KB）！');
					return;
				}
			}
		});
}

// 解析地图中的各种参数:size=279*75&center=114.711910,22.791015&zoom=10&markers=114.711910,22.791015,1
function parserMapParameters(areaId, areaContent) {
	if (areaContent) {
		var ps = areaContent.split("&");
		var size = ps[0];
		if (size) {
			var sizeWH = size.split("=");
			if (sizeWH && sizeWH.length == 2) {
				$("#sizeW_" + areaId).val(sizeWH[1].split("*")[0]);
				$("#sizeH_" + areaId).val(sizeWH[1].split("*")[1]);
			}
		}
		var center = ps[1];
		if (center) {
			var centerXY = center.split("=");
			if (centerXY && centerXY.length == 2) {
				$("#centerX_" + areaId).val(centerXY[1].split(",")[0]);
				$("#centerY_" + areaId).val(centerXY[1].split(",")[1]);
			}
		}
		var zoom = ps[2];
		if (zoom) {
			$("#zoom_" + areaId).val(zoom.split("=")[1]);
		}
	}
}

// 组装地图参数，同时加载地图所生成的图片:size=279*75&center=114.711910,22.791015&zoom=10&markers=114.711910,22.791015,1
function assembleMapParameters(areaId) {
	var sizeW = $("#sizeW_" + areaId).val();
	var sizeH = $("#sizeH_" + areaId).val();
	var centerX = $("#centerX_" + areaId).val();
	var centerY = $("#centerY_" + areaId).val();
	var zoom = $("#zoom_" + areaId).val();
	if (sizeW && sizeH && centerX && centerY && zoom) {
		var paramters = "size=" + sizeW + "*" + sizeH + "&center=" + centerX
				+ "," + centerY + "&zoom=" + zoom + "&markers=" + centerX + ","
				+ centerY + ",1";
		$("#content_" + areaId).val(paramters);
		// 加载地图
		$("#content_preview_" + areaId)[0].src = 'http://st.map.soso.com/api?'
				+ paramters;
	}
}
//---------------------------------------------相集模板相关脚本开始---------------------------------------------
//组装相集选择的内容
function assembleAlbum(areaId){
	var chooseAlbum = [];
	$("input[name=album_"+areaId+"]:checkbox:checked").each(function(){
		chooseAlbum.push($(this).val());
	});
	$("#content_" + areaId).val(chooseAlbum.join());
}
//将原来选择的相集选中
function checkAlreadyChooseAlbum(areaId, chooseAlbumIds){
	if(chooseAlbumIds){
		var albumIds = chooseAlbumIds.split(",");
		for(var i=0; i < albumIds.length; i++){
			$("input[name='album_"+areaId+"'][value='"+albumIds[i]+"']").attr("checked", true);
		}
	}
}

//---------------------------------------------投票模板相关脚本开始---------------------------------------------
//切换投票的选择ID
function assembleVote(areaId){
	$("#content_" + areaId).val($("input[name=vote_"+areaId+"]:radio:checked").val());
}

//将原来选择的投票选中
function checkAlreadyChooseVote(areaId, chooseVoteId){
	if(chooseVoteId){
		$("input[name='vote_"+areaId+"'][value='"+chooseVoteId+"']").attr("checked", true);
	}
}

//---------------------------------------------专家点评模板相关脚本开始---------------------------------------------
//组装专家点评选择的内容
function assembleReview(areaId){
	var chooseAlbum = [];
	$("input[name=review_"+areaId+"]:checkbox:checked").each(function(){
		chooseAlbum.push($(this).val());
	});
	$("#content_" + areaId).val(chooseAlbum.join());
}
//将原来选择的专家点评选中
function checkAlreadyChooseReview(areaId, chooseReviewIds){
	if(chooseReviewIds){
		var reviewIds = chooseReviewIds.split(",");
		for(var i=0; i < reviewIds.length; i++){
			$("input[name='review_"+areaId+"'][value='"+reviewIds[i]+"']").attr("checked", true);
		}
	}
}