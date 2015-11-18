$(function() {
	$("#btn_upload_submit").click(function(){
		if(!verifyInputField("name_vote"))
			return;
		$("#forwadForm").attr("action", "voteAction_edit.action");
		$("#forwadForm").submit();
	});
		
	$("#btn_upload_goback").click(function() {
			$("#forwadForm").attr("action", "voteAction_list.action");
			$("#forwadForm").submit();
		});
});
