<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		// Show delete objective set warning dialog
		var closeDialog = function() {
			jQuery("#deleteObjectiveSetWarning").dialog("close");
	  	}

		var showDialogOpts = {
	    	title:'<fmt:message key="title.delete.objective.set" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {
		    	'<fmt:message key="button.agree" />': closeDialog,
		    	'<fmt:message key="button.cancel" />': closeDialog
		    },
		    resizable: false,
		    width: 300,
		    height: 110
	    };

	    jQuery("#deleteObjectiveSetWarning").dialog(showDialogOpts);
	});
</script>

<div id="deleteObjectiveSetWarning">
	<form action="" method="" name="frmDeleteObjectiveSetWarning">
		<div>
			<span style="color: black;"><fmt:message key="message.delete.objective.set.warning"></fmt:message></span>
		</div>
	</form>
</div>