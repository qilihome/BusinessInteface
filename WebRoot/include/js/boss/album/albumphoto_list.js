$(document).ready(function() {
	$(".glmb").fancybox();
	
	$("#btn_add").click(function() {
				$("#forwadForm").attr("action", "albumphotoAction_addInit.action");
				$("#forwadForm").submit();
			});

	$("#btn_del").click(function() {
		var ids = '';
		$("input[name='keyIds']:checked").each(function() {
					ids = ids + this.value + ','
				});
		if (ids == '') {
			alertMsg('请选择要删除的相片！');
			return;
		}
		if (confirm('确认要删除选择的相片吗？')) {
			$("#ids").val(ids);
			$("#forwadForm").attr("action", "albumphotoAction_batchDelete.action");
			$("#forwadForm").submit();
		}
	});
	
	$("#btn_goback").click(function() {
			$("#forwadForm").attr("action", "albumAction_list.action");
			$("#forwadForm").submit();
		});
});

function previewImg(imgUrl) {
	if (imgUrl) {
		previewImgArea(imgUrl);
	} 
}