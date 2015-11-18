$(document).ready(function() {
	$("#btn_del").click(function() {
		var ids = '';
		$("input[name='keyIds']:checked").each(function() {
					ids = ids + this.value + ','
				});
		if (ids == '') {
			alertMsg('请选择要删除的栏目！');
			return;
		}
		if (confirm('确认要删除选择的栏目吗？')) {
			$("#ids").val(ids);
			$("#forwadForm").attr("action", "columnAction_batchDelete.action");
			$("#forwadForm").submit();
		}
	});
	$("#btn_add").click(function() {
				$("#forwadForm").attr("action", "columnAction_addInit.action");
				$("#forwadForm").submit();
			});
	
	$("#btn_back").click(function() {
				$("#forwadForm").attr("action", "moduleAction_list.action");
				$("#forwadForm").submit();
			});
});
function edit(id) {
	$("#forwadForm").attr("action", "columnAction_editInit.action");
	$("#forwadForm").submit();
}

function view(id) {
	$("#forwadForm").attr("action", "columnAction_view.action");
	$("#forwadForm").submit();
}

function selectAll(flag) {
	$("input[name='keyIds']").each(function() {
				this.checked = flag;
			});
}