<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		// Init edit perspective dialog
		var addMeasureSubmit = function() {
			var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />					    
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.ADD_MEASURE_ACT %>" />
									</portlet:renderURL>';
						
			document.frmAddMeasure.action = portletActionURL;
	        document.frmAddMeasure.submit();
			}
		
		var closeAddMeasure = function() {
			jQuery("#dialogAddMeasure").dialog("close");
		}
		
		var dialogAddMeasureOpts = {
	    	title:'<fmt:message key="title.add.measure" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.save" />': addMeasureSubmit, 
		    	'<fmt:message key="button.cancel" />': closeAddMeasure
		    },
		    resizable: false,
		    width: 330,
		    height: 270
	    };
				
	    jQuery("#dialogAddMeasure").dialog(dialogAddMeasureOpts);
	 	// End init edit perspective dialog
	});
</script>

<div id="dialogAddMeasure">
	<form action="" method="post" name="frmAddMeasure">
	<div style="width: 318px;" >
		<div>
			<span style="color: red;"><fmt:message key="title.required.field"></fmt:message></span>
		</div>
		
		<div style="margin-top: 3px;">
		<div>
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.name.measure"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right" >
				<input type="text" name="<%=Measures_RS.MEA_NAME %>"/> 
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.reuired.weight"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=Measures_RS.MEA_WEIGHT_PERCENT %>"/>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.result"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=Measures_RS.MEA_RESULT %>"/>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.formula.measure"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=Measures_RS.MEA_FOMULAR %>"/>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" >
				<span><fmt:message key="title.note"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=Measures_RS.MEA_DESCRIPTION %>"/>
				</div>
			</div>
		</div>
		</div>
		
		<input type="hidden" name="<%=Perspectives_RS.PER_ID %>" value=""/>
		<input type="hidden" name="<%=Objectives_RS.OBJ_ID %>" value=""/>
	</div>
	</form>
</div>