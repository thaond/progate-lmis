<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		// Init add objective dialog
		var addObjectiveSubmit = function() {
			var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />					    
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.ADD_OBJECTIVE_ACT %>" />
									</portlet:renderURL>';
						
			document.frmAddObjective.action = portletActionURL;
	        document.frmAddObjective.submit();
			}
		
		var closebjective = function() {
			jQuery("#dialogAddObjective").dialog("close");
			}
		
		var dialogOpts = {
	    	title:'<fmt:message key="title.add.objective" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.save" />': addObjectiveSubmit, 
		    	'<fmt:message key="button.cancel" />': closebjective
		    },
		    resizable: false,
		    width: 260,
		    height: 200
	    };
				
	    jQuery("#dialogAddObjective").dialog(dialogOpts);
	 	// End init add objective dialog
	});
</script>

<div id="dialogAddObjective">
	<form action="" method="post" name="frmAddObjective">
		<div>
			<span style="color: red;"><fmt:message key="title.required.field"></fmt:message></span>
		</div>
		
		<div>
		<div>
			<div>
				<div>
				<span><fmt:message key="title.required.objective.name"></fmt:message></span>
				</div>
				
				<div>
				<input type="text" name="<%=Objectives_RS.OBJ_NAME %>"/> 
				</div>
			</div>
			
			<div>
				<div>
				<span><fmt:message key="title.reuired.weight"></fmt:message></span>
				</div>
				
				<div>
				<input type="text" name="<%=Objectives_RS.OBJ_NAME %>"/>
				</div>
			</div>
			
			<div>
				<div>
				<span><fmt:message key="title.note"></fmt:message></span>
				</div>
				
				<div>
				<input type="text" name="<%=Objectives_RS.OBJ_DESCRIPTION %>"/>
				</div>
			</div>
		</div>
		</div>
		
		<input type="hidden" name="<%=Perspectives_RS.PER_ID %>" value=""/>
	</form>
</div>