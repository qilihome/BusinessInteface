function add() {
	if (!verifyInputField("moduleName")) {
		return;
	}
	$("#addForm").attr("action", "moduleAction_add.action");
	$("#addForm").submit();
}

function historyGo() {
	$("#addForm").attr("action", "moduleAction_list.action");
	$("#addForm").submit();
}