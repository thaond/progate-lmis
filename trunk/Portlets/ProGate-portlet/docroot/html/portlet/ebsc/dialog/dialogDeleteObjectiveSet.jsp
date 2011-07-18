<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		// Show create objective set dialog
		var deleteObjectiveSet = function() {
			var portletActionURL = '<portlet:renderURL>
									<portlet:param name="action" value="showingOrgainzationDetails" />
									<portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
									<portlet:param name="<%=Request.TA %>" value="<%=Request.DELETE_OBJECTIVE_SET_ACT %>" />
									</portlet:renderURL>';

			jQuery("form[name='frmObjectiveList']").attr("action", portletActionURL);
			jQuery("form[name='frmObjectiveList']").submit();
	  	}

		var closeDialog = function() {
			jQuery("#deleteObjectiveSet").dialog("close");
	  	}

		var showDialogOpts = {
	    	title:'<fmt:message key="title.delete.objective.set" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {
		    	'<fmt:message key="button.save" />': deleteObjectiveSet,
		    	'<fmt:message key="button.cancel" />': closeDialog
		    },
		    resizable: false,
		    width: 300,
		    height: 110
	    };

	    jQuery("#deleteObjectiveSet").dialog(showDialogOpts);
	});
</script>

<div id="deleteObjectiveSet">
	<form action="" method="post" name="frmDeleteObjectiveSet">
		<div>
			<span style="color: black;"><fmt:message key="message.delete.objective.set"></fmt:message></span>
		</div>
	</form>
</div>