<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		// Init add objective dialog
		var editObjectiveSubmit = function() {
			var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />					    
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.EDIT_OBJECTIVE_ACT %>" />
									</portlet:renderURL>';
						
			document.frmEditObjective.action = portletActionURL;
	        document.frmEditObjective.submit();
			}
		
		var closeEditObjective = function() {
			jQuery("#dialogEditObjective").dialog("close");
			}
		
		var dialogEditObjectiveOpts = {
	    	title:'<fmt:message key="title.edit.objective" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.save" />': editObjectiveSubmit, 
		    	'<fmt:message key="button.cancel" />': closeEditObjective
		    },
		    resizable: false,
		    width: 330,
		    height: 210
	    };
				
	    jQuery("#dialogEditObjective").dialog(dialogEditObjectiveOpts);
	 	// End init add objective dialog
	});
</script>

<div id="dialogEditObjective" >
	<form action="" method="post" name="frmEditObjective">
	<div style="width: 318px;" >
		<div>
			<span style="color: red;"><fmt:message key="title.required.field"></fmt:message></span>
		</div>
		
		<div style="margin-top: 3px;">
		<div>
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.required.objective.name"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right" >
				<input type="text" name="<%=Objectives_RS.OBJ_NAME %>"/> 
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.reuired.weight"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=Objectives_RS.OBJ_WEIGHT_PERCENT %>"/>
				</div>
			</div>
			
			<div class="tdl-row" >
				<div class="tdl-row-left" >
				<span><fmt:message key="title.note"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right" >
				<input type="text" name="<%=Objectives_RS.OBJ_DESCRIPTION %>"/>
				</div>
			</div>
		</div>
		</div>
		
		<input type="hidden" name="<%=Perspectives_RS.PER_ID %>" value=""/>
		<input type="hidden" name="<%=Objectives_RS.OBJ_ID %>" value=""/>
	</div>
	</form>
</div>