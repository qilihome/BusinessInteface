$(document).ready(function() {
	$("#btn_add").click(function() {
				$("#forwadForm").attr("action",
						"expertReviewAction_addInit.action");
				$("#forwadForm").submit();
			});

	$("#btn_del").click(function() {
		var ids = '';
		$("input[name='keyIds']:checked").each(function() {
					ids = ids + this.value + ','
				});
		if (ids == '') {
			alertMsg('请选择要删除的专家点评！');
			return;
		}
		if (confirm('确认要删除选择的专家点评吗？')) {
			$("#ids").val(ids);
			$("#forwadForm").attr("action",
					"expertReviewAction_batchDelete.action");
			$("#forwadForm").submit();
		}
	});
});

function edit(id) {
	$("#reviewId").val(id);
	$("#forwadForm").attr("action", "expertReviewAction_editInit.action");
	$("#forwadForm").submit();

}
