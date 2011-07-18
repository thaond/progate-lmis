<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		// Init edit perspective dialog
		var editPerspectiveSubmit = function() {
			var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />					    
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.EDIT_PERSPECTIVE_ACT %>" />
									</portlet:renderURL>';
						
			document.frmEditPerspective.action = portletActionURL;
	        document.frmEditPerspective.submit();
			}
		
		var closeEditPerspective = function() {
			jQuery("#dialogEditPerspective").dialog("close");
		}
		
		var dialogEditPerspectiveOpts = {
	    	title:'<fmt:message key="title.edit.perspective" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.save" />': editPerspectiveSubmit, 
		    	'<fmt:message key="button.cancel" />': closeEditPerspective
		    },
		    resizable: false,
		    width: 330,
		    height: 170
	    };
				
	    jQuery("#dialogEditPerspective").dialog(dialogEditPerspectiveOpts);
	 	// End init edit perspective dialog
	});
</script>

<div id="dialogEditPerspective">
	<form action="" method="post" name="frmEditPerspective">
	<div style="width: 318px;" >
		<div>
			<span style="color: red;"><fmt:message key="title.required.field"></fmt:message></span>
		</div>
		
		<div style="margin-top: 3px;">
		<div>
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.perspective"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right" >
				<input type="text" name="<%=Perspectives_RS.PER_NAME %>" readonly="readonly"/> 
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.reuired.weight"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=Perspectives_RS.PER_WEIGHT_PERCENT %>"/>
				</div>
			</div>			
		</div>
		</div>
		
		<input type="hidden" name="<%=Perspectives_RS.PER_ID %>" value=""/>
	</div>
	</form>
</div>