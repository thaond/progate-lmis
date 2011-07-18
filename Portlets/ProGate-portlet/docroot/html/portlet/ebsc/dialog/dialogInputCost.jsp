<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">			
	jQuery(function(){
		// Show create objective set dialog
		var inputCostSubmit = function() {
			var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />					    
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.INPUT_COST_ACT %>" />
									</portlet:renderURL>';
						
			jQuery("form[name='frmInputCost']").attr("action", portletActionURL);			
			jQuery("form[name='frmInputCost']").submit();
	  	}
		
		var closeInputCostDialog = function() {
			jQuery("#dialogInputCost").dialog("close");
	  	}
		
		var dialogInputCostOpts = {
	    	title:'<fmt:message key="title.popup.input" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.save" />': inputCostSubmit, 
		    	'<fmt:message key="button.cancel" />': closeInputCostDialog
		    },
		    resizable: false,
		    width: 325,
		    height: 350
	    };
	    
	    jQuery("#dialogInputCost").dialog(dialogInputCostOpts);
	});
</script>

<div id="dialogInputCost">
	<form action="" method="post" name="frmInputCost">
		<div style="width: 325px;" >
		<div>
			<span style="color: red;"><fmt:message key="title.required.field"></fmt:message></span>
		</div>
		
		<div style="margin-top: 3px; width=325px;">
		<div>
			<div class="tdl-row">
				<div class="tdl-row-left" style="width: 150px;">
				<span style="width: 142px;"><fmt:message key="title.p1.total.cost"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right" >
				<input type="text" name="<%=ObjectivesList_RS.OBJ_LIST_CURRENT_TOTAL_COST %>" style="text-align: right;"/>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left"  style="width: 150px;" >
				<span style="width: 142px;"><fmt:message key="title.p3.next.total.cost"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=ObjectivesList_RS.OBJ_LIST_NEXT_TOTAL_COST %>" style="text-align: right;"/>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left"  style="width: 150px;" >
				<span style="width: 142px;"><fmt:message key="title.p3.expected.completion"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=ObjectivesList_RS.OBJ_LIST_EXPECTED_COMPLETION %>" style="text-align: right;"/>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" style="width: 150px;">
				<span  style="width: 142px;"><fmt:message key="title.F"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right;" type="text" name="<%=ObjectivesList_RS.OBJ_LIST_F_CURRENT_COST %>"/>
				</div>
			</div>

			<div class="tdl-row">
				<div class="tdl-row-left" style="width: 150px;">
				<span  style="width: 142px;"><fmt:message key="title.C"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right;" type="text" name="<%=ObjectivesList_RS.OBJ_LIST_C_CURRENT_COST %>"/>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" style="width: 150px;">
				<span  style="width: 142px;"><fmt:message key="title.P"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right;" type="text" name="<%=ObjectivesList_RS.OBJ_LIST_P_CURRENT_COST %>"/>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" style="width: 150px;">
				<span  style="width: 142px;"><fmt:message key="title.G"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right;" type="text" name="<%=ObjectivesList_RS.OBJ_LIST_G_CURRENT_COST %>"/>
				</div>
			</div>
						
		</div>
		</div>
		
	</div>
	</form>
</div>