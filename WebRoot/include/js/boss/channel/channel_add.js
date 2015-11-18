function add() {
	if (!verifyInputField("channelName,channelAccesscmd")) {
		return;
	}
	$("#addForm").attr("action", "channelAction_add.action");
	$("#addForm").submit();
}

function historyGo() {
	$("#addForm").attr("action", "channelAction_list.action");
	$("#addForm").submit();
}