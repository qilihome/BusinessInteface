$(document).ready(function() {
	$(".glmb").fancybox();
	
	$("#btn_upload").click(function() {
				$("#forwadForm").attr("action",
						"templateAction_uploadInit.action");
				$("#forwadForm").submit();
			});

	$("#btn_del").click(function() {
		var ids = '';
		$("input[name='keyIds']:checked").each(function() {
					ids = ids + this.value + ','
				});
		if (ids == '') {
			alertMsg('请选择要删除的模板！');
			return;
		}
		if (confirm('确认要删除选择的模板吗？同时会将模板区域数据，客户配置的模板内容数据全部删除掉！请谨慎操作！')) {
			$("#ids").val(ids);
			$("#forwadForm")
					.attr("action", "templateAction_batchDelete.action");
			$("#forwadForm").submit();
		}
	});
	
	$("#btn_copy").zclip({
            path : "plugin/zclip/ZeroClipboard.swf",
            copy : "aaa",
            afterCopy : function() {
                alert('复制成功！')
            }
        });
});

function copyurl(text){
	$("#btn_copy").trigger("mousedown");
}

function previewImg(imgUrl) {
	if (imgUrl) {
		previewImgArea(imgUrl);
	} else {
		alertMsg("该模板未上传效果图片！");
	}
}