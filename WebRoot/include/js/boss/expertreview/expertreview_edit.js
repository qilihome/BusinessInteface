$(function() {
	$("#btn_upload_submit").click(function(){
		if(!verifyInputField("name_expertReview,title_expertReview,content_headsculpture,reviewsubject_expertReview"))
			return;
		$("#forwadForm").attr("action", "expertReviewAction_edit.action");
		$("#forwadForm").submit();
	});
		
	$("#btn_upload_goback").click(function() {
			$("#forwadForm").attr("action", "expertReviewAction_list.action");
			$("#forwadForm").submit();
		});
});

// 加载各位区域对应的上传组件
function loadUploadPlugin(areaId, areaName, contextPath, picLimitSize, picTypes, picFileExt, serverDomain, upload_pitcure){
	$('#file_upload_' + areaId) .uploadify({
		'uploader' : contextPath + '/plugin/uploadify/scripts/uploadify.swf',
		'script' : contextPath + '/fileUploadAction_upload.action?areaName='+areaName,
		'cancelImg' : contextPath + '/plugin/uploadify/cancel.png',
		'buttonImg' : contextPath + '/plugin/uploadify/' + upload_pitcure,
		'sizeLimit' : picLimitSize*1024,
		'multi' : false,
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
						$("#content_" + areaId).val(response.path);
						$("#content_preview_" + areaId)[0].src = contextPath + '/' + response.path + "?t=" + Math.random();
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