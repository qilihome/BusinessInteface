var contextPath = $("#contextPath").val();
$(function() {
	$('#template_file_upload').uploadify({
		'uploader' : contextPath + '/plugin/uploadify/scripts/uploadify.swf',
		'script' : contextPath + '/templateAction_upload.action',
		'cancelImg' : contextPath + '/plugin/uploadify/cancel.png',
		'buttonImg' : contextPath + '/plugin/uploadify/upload.png',
		'sizeLimit' : 10*1024*1024,
		'multi' : false,
		'auto' : false,
		'fileExt' : '.zip',
		'fileDesc' : 'Template Files (*.zip)',
		'queueID' : 'custom-queue',
		'queueSizeLimit' : 1,
		'simUploadLimit' : 1,
		'removeCompleted' : false,
		'onSelect' : function(event, ID, fileObj) {
			},
		'onComplete' : function(event, queueId, fileObj, response, data) {
				response = eval('('+response+')');
				if(response.result ||　response.result == 'true'){
					art.dialog({icon:"succeed", esc:true, content:response.message, lock:true, fixed:true, drag:false, ok:true, close:function(){window.location.href = "templateAction_list.action";}});
				}else{
					alertMsg(response.message, "warning");
				}
			},
		'onError' : function (event, ID, fileObj, errorObj) {
				if (errorObj.type === "File Size"){
					alertMsg('超过文件上传大小限制（10240KB）！');
					return;
				}
			}
		});
		
	$("#btn_upload_submit").click(function(){
		if($("#custom-queue").html() != null && $.trim($("#custom-queue").html()) != "")
			$('#template_file_upload').uploadifyUpload();
		else
			alertMsg('请选择要上传的模板文件！');
	});
		
	$("#btn_upload_cancel").click(function(){
		$('#template_file_upload').uploadifyClearQueue();
	});
	
	$("#btn_upload_goback").click(function() {
			$("#forwadForm").attr("action", "templateAction_list.action");
			$("#forwadForm").submit();
		});
});