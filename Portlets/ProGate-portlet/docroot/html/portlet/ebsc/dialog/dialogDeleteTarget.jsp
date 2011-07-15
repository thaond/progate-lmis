<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		
		var deleteObjectiveSubmit = function() {
			var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />					    
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.DELETE_TARGET_ACT %>" />
									</portlet:renderURL>';
						
			document.frmDeleteTarget.action = portletActionURL;
	        document.frmDeleteTarget.submit();
			}
		
		var closeDeleteTarget = function() {
			jQuery("#dialogAddObjective").dialog("close");
			}
		
		var dialogDeleteTargetOpts = {
	    	title:'<fmt:message key="title.delete.target" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.yes" />': deleteObjectiveSubmit, 
		    	'<fmt:message key="button.no" />': closeDeleteTarget
		    },
		    resizable: false,
		    width: 300,
		    height: 110
	    };
				
	    jQuery("#dialogDeleteTarget").dialog(dialogDeleteTargetOpts);
	 	
	});
</script>

<div id="dialogDeleteTarget">
	<form action="" method="post" name="frmDeleteTarget">
		<div>
			<span style="color: red;"><fmt:message key="warning.delete.target"></fmt:message></span>
		</div>
		
		<input type="hidden" name="<%=Perspectives_RS.PER_ID %>" value=""/>
		<input type="hidden" name="<%=Targets_RS.TARGET_ID %>" value=""/>
	</form>
</div>