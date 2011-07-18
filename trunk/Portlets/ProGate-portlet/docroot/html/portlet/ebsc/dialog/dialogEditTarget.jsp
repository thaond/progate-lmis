<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		// Init edit perspective dialog
		var editTargetSubmit = function() {
			var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />					    
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.EDIT_TARGET_ACT %>" />
									</portlet:renderURL>';
			
			document.frmEditTarget.action = portletActionURL;
	        document.frmEditTarget.submit();
			}
		
		var closeEditTarget = function() {
			jQuery("#dialogEditTarget").dialog("close");
		}
		
		var dialogEditTargetOpts = {
	    	title:'<fmt:message key="title.Edit.target" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.save" />': editTargetSubmit, 
		    	'<fmt:message key="button.cancel" />': closeEditTarget
		    },
		    resizable: false,
		    width: 330,
		    height: 170
	    };
				
	    jQuery("#dialogEditTarget").dialog(dialogEditTargetOpts);
	 	// End init edit perspective dialog
	});
</script>

<div id="dialogEditTarget" >
	<form action="" method="post" name="frmEditTarget">
	<div style="width: 318px;" >
		<div>
			<span style="color: red;"><fmt:message key="title.required.field"></fmt:message></span>
		</div>
		
		<div style="margin-top: 3px;">
		<div>
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.required.value.target"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right" >
				<input type="text" name="<%=Targets_RS.TARGET_NAME %>"/> 
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.note"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=Targets_RS.TARGET_DESCRIPTION %>"/>
				</div>
			</div>
		</div>
		</div>
		
		<input type="hidden" name="<%=Perspectives_RS.PER_ID %>" value=""/>
		<input type="hidden" name="<%=Targets_RS.TARGET_ID %>" value=""/>
	</div>
	</form>
</div>