$(document).ready(function() {
	$("#btn_add").click(function() {
				$("#forwadForm").attr("action", "voteAction_addInit.action");
				$("#forwadForm").submit();
			});

	$("#btn_del").click(function() {
				var ids = '';
				$("input[name='keyIds']:checked").each(function() {
							ids = ids + this.value + ','
						});
				if (ids == '') {
					alertMsg('请选择要删除的投票活动！');
					return;
				}
				if (confirm('确认要删除选择的投票活动吗？')) {
					$("#ids").val(ids);
					$("#forwadForm").attr("action",
							"voteAction_batchDelete.action");
					$("#forwadForm").submit();
				}
			});
});

function edit(id) {
	$("#voteId").val(id);
	$("#forwadForm").attr("action", "voteAction_editInit.action");
	$("#forwadForm").submit();
}

function optionManage(id) {
	$("#manageVoteId").val(id);
	$("#forwadForm").attr("action", "voteOptionAction_list.action");
	$("#forwadForm").submit();
}
