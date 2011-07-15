<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){

		var applyWPSubmit = function() {
			var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.APPLY_WEIGHT_PERCENT_ACT %>" />
									</portlet:renderURL>';

			document.frmApplyWeightPercent.action = portletActionURL;
	        document.frmApplyWeightPercent.submit();
			}

		var closeApplyWeightPercent = function() {
			jQuery("#dialogApplyWeightPercent").dialog("close");
			}

		var dialogApplyWeightPercentOpts = {
	    	title:'<fmt:message key="title.apply.weight.percent" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {
		    	'<fmt:message key="button.yes" />': applyWPSubmit,
		    	'<fmt:message key="button.no" />': closeApplyWeightPercent
		    },
		    resizable: false,
		    width: 300,
		    height: 110
	    };

	    jQuery("#dialogApplyWeightPercent").dialog(dialogApplyWeightPercentOpts);

	});
</script>

<div id="dialogApplyWeightPercent">
	<form action="" method="post" name="frmApplyWeightPercent">
		<div>
			<span style="color: black;"><fmt:message key="message.apply.weight.percent"></fmt:message></span>
		</div>

		<input type="hidden" name="<%=ObjectivesList_RS.OBJ_LIST_ID %>" value="" />
	</form>
</div>