$(document).ready(function() {
			var msg = $("#msg").val();
			if (msg != null && msg != '') {
				$("#msg").val('');
				alertMsg(msg, "succeed");
				msg = '';
			}
		});
