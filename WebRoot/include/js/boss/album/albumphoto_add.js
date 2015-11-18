$(function() {
	$("#btn_upload_submit").click(function(){
		if(photoArray && photoArray.length > 0){
			$("#forwadForm").attr("action", "albumphotoAction_add.action");
			$("#uploadcount").val(photoArray.length);
			$("#forwadForm").submit();
		}else{
			alertMsg("请上传相片");
		}
	});
		
	$("#btn_upload_goback").click(function() {
			$("#forwadForm").attr("action", "albumphotoAction_list.action");
			$("#forwadForm").submit();
		});
});

var photoArray = [];
var configPluginTemplate = $("#gen_album_photo_config_template").html();
function genPhotoConfiPlugin(photoSavefile, photoSize, contextPath){
	photoArray.push(photoSavefile);
	var eachPhotoEditHtml = configPluginTemplate.replaceAll("#photo_photosrc_src#", contextPath + "/" + photoSavefile);
	eachPhotoEditHtml = eachPhotoEditHtml.replaceAll("#photo_photosrc_src_save#", photoSavefile);
	eachPhotoEditHtml = eachPhotoEditHtml.replaceAll("#photo_photosrc_size_save#", photoSize);
	eachPhotoEditHtml = eachPhotoEditHtml.replaceAll("#uploadcount#", photoArray.length);
	$("#div_album_photo").append(eachPhotoEditHtml);
}

// 加载上传组件
function loadUploadPlugin(areaId, areaName, contextPath, picLimitSize, picTypes, picFileExt, serverDomain, upload_pitcure){
	$('#file_upload_' + areaId) .uploadify({
		'uploader' : contextPath + '/plugin/uploadify/scripts/uploadify.swf',
		'script' : contextPath + '/fileUploadAction_upload.action?areaName='+areaName,
		'cancelImg' : contextPath + '/plugin/uploadify/cancel.png',
		'buttonImg' : contextPath + '/plugin/uploadify/' + upload_pitcure,
		'sizeLimit' : picLimitSize*1024,
		'multi' : true,
		'auto' : true,
		'fileExt' : picTypes,
		'fileDesc' : 'Template Files ('+picFileExt+')',
		'queueID' : 'custom-queue_'+areaId,
		'removeCompleted' : false,
		'onSelect' : function(event, ID, fileObj) {
			},
		'onComplete' : function(event, queueId, fileObj, response, data) {
				response = eval('('+response+')');
				if(response.result ||　response.result == 'true'){
					genPhotoConfiPlugin(response.path, response.size, contextPath);
						//$("#content_" + areaId).val(response.path);
						//$("#content_preview_" + areaId)[0].src = contextPath + '/' + response.path + "?t=" + Math.random();
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