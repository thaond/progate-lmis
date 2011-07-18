<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">			
	jQuery(function(){
		// Show create objective set dialog
		var calcCostSubmit = function() {
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
		
		var closeCalcCostDialog = function() {
			jQuery("#dialogCalcCost").dialog("close");
	  	}
		
		var dialogCalcCostOpts = {
	    	title:'<fmt:message key="title.popup.input" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		         
		    	'<fmt:message key="button.close" />': closeCalcCostDialog
		    },
		    resizable: false,
		    width: 325,
		    height: 400
	    };
	    
	    jQuery("#dialogCalcCost").dialog(dialogCalcCostOpts);
	});
</script>

<div id="dialogCalcCost">
	<form action="" method="post" name="frmCalcCost">
		<div style="width: 325px;" >
		
		<div style="margin-top: 3px; width=325px;">
		<div>
			<div class="tdl-row">
				<div class="tdl-row-left" style="width: 190px;">
				<span style="width: 160px;"><fmt:message key="title.p1.total.cost"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right" style="width: 120px;">
				<input type="text" name="<%=ObjectivesList_RS.OBJ_LIST_CURRENT_TOTAL_COST %>"
				value="${bean.objectiveSet.current_total_cost}" 
				style="width: 108px; text-align: right;" readonly="readonly" /></div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left"  style="width: 190px;" >
				<span style="width: 160px;"><fmt:message key="title.p3.next.total.cost"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right" style="width: 120px;">
				<input type="text" name="<%=ObjectivesList_RS.OBJ_LIST_NEXT_TOTAL_COST %>"
				value="${bean.objectiveSet.next_total_cost}" 
				style="width: 108px; text-align: right;" readonly="readonly" /></div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left"  style="width: 190px;" >
				<span style="width: 160px;"><fmt:message key="title.p3.expected.completion"></fmt:message></span>
				</div>
				
				<div class="tdl-row-right" style="width: 120px;">
				<input type="text" name="<%=ObjectivesList_RS.OBJ_LIST_EXPECTED_COMPLETION %>"
				value="${bean.objectiveSet.expected_completion * 100}" 
				style="width: 108px; text-align: right;" readonly="readonly" /></div>
			</div>
			
			<div class="tdl-row">
				<span style="padding-left: 45px;"> <c:out value="F"></c:out> </span>
				
				<span style="padding-left: 65px;"> <c:out value="C"></c:out> </span>
				
				<span style="padding-left: 65px;"> <c:out value="P"></c:out> </span>
				
				<span style="padding-left: 65px;"> <c:out value="G"></c:out> </span>
			</div>
			<div class="tdl-row">
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value="${bean.perspectiveList[0].current_cost * bean.objectiveSet.current_total_cost}" />
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value="${bean.perspectiveList[1].current_cost * bean.objectiveSet.current_total_cost}" />
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value="${bean.perspectiveList[2].current_cost * bean.objectiveSet.current_total_cost}" />
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value="${bean.perspectiveList[3].current_cost * bean.objectiveSet.current_total_cost}" />
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" style="width: 250px;">
				<span  style="width: 300px;"><fmt:message key="title.p2.alg"></fmt:message></span>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
				value="${bean.perspectiveList[0].next_cost  * bean.objectiveSet.next_total_cost}"></fmt:formatNumber> '/>
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
				value="${bean.perspectiveList[1].next_cost  * bean.objectiveSet.next_total_cost}"></fmt:formatNumber> ' />
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
				value="${bean.perspectiveList[2].next_cost  * bean.objectiveSet.next_total_cost}"></fmt:formatNumber> ' />
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
				value="${bean.perspectiveList[3].next_cost  * bean.objectiveSet.next_total_cost}"></fmt:formatNumber> ' />
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-left" style="width: 250px;">
				<span  style="width: 300px;"><fmt:message key="title.p3.alg"></fmt:message></span>
				</div>
			</div>
			
			<div class="tdl-row">
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
				value="${bean.perspectiveList[0].next_cost2  * bean.objectiveSet.next_total_cost}"></fmt:formatNumber> '/>
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
				value="${bean.perspectiveList[1].next_cost2  * bean.objectiveSet.next_total_cost}"></fmt:formatNumber> ' />
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
				value="${bean.perspectiveList[2].next_cost2  * bean.objectiveSet.next_total_cost}"></fmt:formatNumber> ' />
				</div>
				
				<div class="tdl-row-right">
				<input  style="text-align: right; width: 69px; padding-right: 0px;" type="text" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
				value="${bean.perspectiveList[3].next_cost2  * bean.objectiveSet.next_total_cost}"></fmt:formatNumber> ' />
				</div>
			</div>
			
					
		</div>
		</div>
		
	</div>
	</form>
</div>