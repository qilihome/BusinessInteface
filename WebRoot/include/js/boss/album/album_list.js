$(document).ready(function() {
	$(".glmb").fancybox();
	
	$("#btn_add").click(function() {
				$("#forwadForm").attr("action", "albumAction_addInit.action");
				$("#forwadForm").submit();
			});

	$("#btn_del").click(function() {
		var ids = '';
		$("input[name='keyIds']:checked").each(function() {
					ids = ids + this.value + ','
				});
		if (ids == '') {
			alertMsg('请选择要删除的相集！');
			return;
		}
		if (confirm('确认要删除选择的相集吗？同时会将相集下所有的相片全部删除掉！请谨慎操作！')) {
			$("#ids").val(ids);
			$("#forwadForm").attr("action", "albumAction_batchDelete.action");
			$("#forwadForm").submit();
		}
	});
});

function photoManage(albumId) {
	$("#forwadForm").attr("action", "albumphotoAction_list.action");
	$("#albumId").val(albumId);
	$("#forwadForm").submit();
}

function previewImg(imgUrl) {
	if (imgUrl) {
		previewImgArea(imgUrl);
	} else {
		alertMsg("该相集未上传效果图片！");
	}
}