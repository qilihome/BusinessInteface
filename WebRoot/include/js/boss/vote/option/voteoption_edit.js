$(function() {
	$("#btn_upload_submit").click(function(){
		if(!verifyInputField("name_voteOption"))
			return;
		$("#forwadForm").attr("action", "voteOptionAction_edit.action");
		$("#forwadForm").submit();
	});
		
	$("#btn_upload_goback").click(function() {
			$("#forwadForm").attr("action", "voteOptionAction_list.action");
			$("#forwadForm").submit();
		});
});
