$(document).ready(function() {
	$("#btn_add").click(function() {
				$("#forwadForm").attr("action",
						"voteOptionAction_addInit.action");
				$("#forwadForm").submit();
			});

	$("#btn_del").click(function() {
		var ids = '';
		$("input[name='keyIds']:checked").each(function() {
					ids = ids + this.value + ','
				});
		if (ids == '') {
			alertMsg('请选择要删除的投票选项！');
			return;
		}
		if (confirm('确认要删除选择的投票选项吗？')) {
			$("#ids").val(ids);
			$("#forwadForm").attr("action",
					"voteOptionAction_batchDelete.action");
			$("#forwadForm").submit();
		}
	});
});

function edit(id) {
	$("#voteOptionId").val(id);
	$("#forwadForm").attr("action", "voteOptionAction_editInit.action");
	$("#forwadForm").submit();
}

function optionManage(id) {
	$("#managevoteOptionId").val(id);
	$("#forwadForm").attr("action", "voteOptionOptionAction_list.action");
	$("#forwadForm").submit();
}
