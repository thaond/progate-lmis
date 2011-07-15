<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		// Init edit perspective dialog
		var editMeasureSubmit = function() {
			var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />					    
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.EDIT_MEASURE_ACT %>" />
									</portlet:renderURL>';
						
			document.frmEditMeasure.action = portletActionURL;
	        document.frmEditMeasure.submit();
			}
		
		var closeEditMeasure = function() {
			jQuery("#dialogEditMeasure").dialog("close");
		}
		
		var dialogEditMeasureOpts = {
	    	title:'<fmt:message key="title.add.measure" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.save" />': editMeasureSubmit, 
		    	'<fmt:message key="button.cancel" />': closeEditMeasure
		    },
		    resizable: false,
		    width: 330,
		    height: 290
	    };
				
	    jQuery("#dialogEditMeasure").dialog(dialogEditMeasureOpts);
	 	// End init edit perspective dialog
	});
</script>

<div id="dialogEditMeasure" >
	<form action="" method="post" name="frmEditMeasure">
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
		<input type="hidden" name="<%=Measures_RS.MEA_ID %>" value=""/>
	</div>
	</form>
</div>