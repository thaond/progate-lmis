<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
jQuery(document).ready(function(){
	
	// Handle collapse/fold
	jQuery(".current_msg_head-left:not(:first)").addClass("fold");
	
	//hide the all of the element with class msg_body	
	jQuery(".msg_body:not(:first)").hide();
	
	//toggle the componenet with class msg_body
	jQuery(".current_msg_head-left").click(function(){
		jQuery(this).parent(".msg_head_parent").next(".msg_body").toggle();
		
		if (jQuery(this).hasClass("fold").toString() == 'true') {		
			jQuery(this).removeClass("fold");
			jQuery(this).addClass("collapse");
		} else {
			jQuery(this).removeClass("collapse");
			jQuery(this).addClass("fold");
		}
	}); // End handle collapse/fold
	
	// Handle progressbar
	var percentInput = jQuery("#percent_input").val();
	var percentComplete = jQuery("#percent_complete").val();
	
	// show values in right bottom
	//jQuery.("input[name='Obj_List_Current_Total_Cost']").value();
	//jQuery.("input[name='Obj_List_Next_Total_Cost']").value();
	//jQuery.("input[name='Obj_List_Expected_Completion']").value();
	
	var progressOpts = {
		width: 200
	};

	// handle input cost
	jQuery(".bt-new").click(function(event){
		var listCTC = jQuery(this).parent().find(".objCurrentTotalCost").val();
		var listNTC = jQuery(this).parent().find(".objNextTotalCost").val();
		var listEC = jQuery(this).parent().find(".objExpectedCompletion").val();
		var listCF = jQuery(this).parent().find(".objFCurrentCost").val();
		var listCC = jQuery(this).parent().find(".objCCurrentCost").val();
		var listCP = jQuery(this).parent().find(".objPCurrentCost").val();
		var listCG = jQuery(this).parent().find(".objGCurrentCost").val();
		
		inputCost(listCTC, listNTC, listEC, listCF, listCC, listCP, listCG);
		event.preventDefault();
	});

	jQuery(".bt-new a").click(function(event){
		var listCTC = jQuery(this).parent().parent().find(".objCurrentTotalCost").val();
		var listNTC = jQuery(this).parent().parent().find(".objNextTotalCost").val();
		var listEC = jQuery(this).parent().parent().find(".objExpectedCompletion").val();
		var listCF = jQuery(this).parent().parent().find(".objFCurrentCost").val();
		var listCC = jQuery(this).parent().parent().find(".objCCurrentCost").val();
		var listCP = jQuery(this).parent().parent().find(".objPCurrentCost").val();
		var listCG = jQuery(this).parent().parent().find(".objGCurrentCost").val();
		
		inputCost(listCTC, listNTC, listEC, listCF, listCC, listCP, listCG);
		event.preventDefault();
	});
	
	// handle calculate cost
	jQuery(".bt-edit").click(function(event){
		
		var listCTC = jQuery(this).parent().find(".objCurrentTotalCost").val();
		var listNTC = jQuery(this).parent().find(".objNextTotalCost").val();
		var listEC = jQuery(this).parent().find(".objExpectedCompletion").val();
		var listCF = jQuery(this).parent().find(".objFCurrentCost").val();
		var listCC = jQuery(this).parent().find(".objCCurrentCost").val();
		var listCP = jQuery(this).parent().find(".objPCurrentCost").val();
		var listCG = jQuery(this).parent().find(".objGCurrentCost").val();
		
		calcCost(listCTC, listNTC, listEC, listCF, listCC, listCP, listCG);
		event.preventDefault();
	});

	jQuery(".bt-edit a").click(function(event){
		var listCTC = jQuery(this).parent().parent().find(".objCurrentTotalCost").val();
		var listNTC = jQuery(this).parent().parent().find(".objNextTotalCost").val();
		var listEC = jQuery(this).parent().parent().find(".objExpectedCompletion").val();
		var listCF = jQuery(this).parent().parent().find(".objFCurrentCost").val();
		var listCC = jQuery(this).parent().parent().find(".objCCurrentCost").val();
		var listCP = jQuery(this).parent().parent().find(".objPCurrentCost").val();
		var listCG = jQuery(this).parent().parent().find(".objGCurrentCost").val();
		
		calcCost(listCTC, listNTC, listEC, listCF, listCC, listCP, listCG);
		event.preventDefault();
	});
		
	function calcCost(listCTC, listNTC, listEC, listCF, listCC, listCP, listCG){
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_CURRENT_TOTAL_COST %>.value = listCTC;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_NEXT_TOTAL_COST %>.value = listNTC;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_EXPECTED_COMPLETION %>.value = listEC;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_F_CURRENT_COST %>.value = listCF;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_C_CURRENT_COST %>.value = listCC;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_P_CURRENT_COST %>.value = listCP;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_G_CURRENT_COST %>.value = listCG;
		
		jQuery("#dialogCalcCost").css("display", "block");
		jQuery("#dialogCalcCost").dialog("open");
	}
	function inputCost(listCTC, listNTC, listEC, listCF, listCC, listCP, listCG){
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_CURRENT_TOTAL_COST %>.value = listCTC;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_NEXT_TOTAL_COST %>.value = listNTC;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_EXPECTED_COMPLETION %>.value = listEC;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_F_CURRENT_COST %>.value = listCF;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_C_CURRENT_COST %>.value = listCC;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_P_CURRENT_COST %>.value = listCP;
		document.frmInputCost.<%=ObjectivesList_RS.OBJ_LIST_G_CURRENT_COST %>.value = listCG;
		
		jQuery("#dialogInputCost").css("display", "block");
		jQuery("#dialogInputCost").dialog("open");
	}

	
	//alert(percentInput);
	jQuery("#progressbar-1").reportprogress(percentInput);
	jQuery("#progressbar-2").reportprogress(percentComplete);
	// End handle progressbar
});
</script>

<jsp:include page="dialog/dialogInputCost.jsp"></jsp:include>
<jsp:include page="dialog/dialogCalcCost.jsp"></jsp:include>

<form action="" method="post" name="frmCostCalculate">
<div class="tabs-content-1">
	<div class="tabs-content-left">
		<div class="title-msg">
			<fmt:message key="titile.objective.system"/> <c:out value="${bean.objectiveSet.year}"/>
		</div>
		<div>
		<span style="padding-right: 12px; padding-left: 322px; margin-right: 99px;">
				<fmt:message key="title.weight"/></span>
		<span style="margin-right: 22px; padding-right: 19px;">
				<fmt:message key="title.main.cost"/></span>
		<span style="margin-right: 10px; padding-right: 20px;">
				<fmt:message key="title.main.completion"/></span>
		</div>
		
		<div style="padding: 10px; float: left;">
		<div style="float: left; background-color: white; width: 680px;">
		<c:forEach items="${bean.perspectiveList}" var="perspective" varStatus="count">
		<div class="msg_content msg_border">
			<div class="msg_head_parent">
			<c:choose>
			<c:when test="${perspective.orgObjectPerspectiveId == bean.perspectiveID}">
			<div class="current_msg_head-left collapse" >
			<span>
				<c:out value="${perspective.name}"></c:out>
			</span>
			</div>	
			</c:when>
			<c:otherwise>
			<portlet:renderURL var="collapsePerspectiveURL">
				<portlet:param name="action" value="showingOrgainzationDetails" />
				<portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
				<portlet:param name="<%=Request.TA %>" value="<%=Request.TA_4 %>" />
				<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>" value="${bean.objectiveSet.orgObjectListId}" />
				<portlet:param name="<%=Perspectives_RS.PER_ID %>" value="${perspective.orgObjectPerspectiveId}" />
			</portlet:renderURL>
			<div class="msg_head-left">
			<a href="${collapsePerspectiveURL}" style="text-decoration: none; color: black;">
			<span style='background: url("/ProGate-Theme-theme/images/application/panel_header_toggler_open.png") no-repeat scroll 0 0 transparent;
			      display: block; float: left; height: 22px; margin-left: -22px; margin-top: -5px; width: 22px;'>				
			</span>
			<span>
				<c:out value="${perspective.name}"></c:out>
			</span>
			</a>
			</div>
			</c:otherwise>
			</c:choose>
			
			<div class="msg_head-right">
			<c:choose>
				<c:when test="${perspective.current_cost * bean.objectiveSet.current_total_cost >= 1000}">
						<span style="margin-right: 10px; padding-right: 93px;">
							<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">
							<c:out value="${perspective.weight_percent * 100}"></c:out>
							</fmt:formatNumber>% 
						</span>
				</c:when>
				<c:when test="${perspective.current_cost * bean.objectiveSet.current_total_cost >= 100 && 
				perspective.current_cost * bean.objectiveSet.current_total_cost < 1000}">
					<span style="margin-right: 10px; padding-right: 100px;">
						<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">
						<c:out value="${perspective.weight_percent * 100}"></c:out>
						</fmt:formatNumber>% 
					</span>
				</c:when>
				<c:when test="${perspective.current_cost * bean.objectiveSet.current_total_cost < 100 && 
								perspective.current_cost * bean.objectiveSet.current_total_cost >= 10}">
					<span style="margin-right: 10px; padding-right: 107px;">
						<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">
						<c:out value="${perspective.weight_percent * 100}"></c:out>
						</fmt:formatNumber>% 
					</span>
				</c:when>
				<c:otherwise>
					<span style="margin-right: 10px; padding-right: 114px;">
						<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">
						<c:out value="${perspective.weight_percent * 100}"></c:out>
						</fmt:formatNumber>% 
					</span>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${perspective.completion_percent >= 1}">
					<span style="margin-right: 10px; padding-right: 47px;">
						<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">
						<c:out value="${perspective.current_cost * bean.objectiveSet.current_total_cost}"></c:out>
						</fmt:formatNumber> 
					</span>
				</c:when>
				<c:when test="${perspective.completion_percent < 1 && perspective.completion_percent >= 0.1}">
					<span style="margin-right: 10px; padding-right: 54px;">
						<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">
						<c:out value="${perspective.current_cost * bean.objectiveSet.current_total_cost}"></c:out>
						</fmt:formatNumber> 
					</span>
				</c:when>
				<c:otherwise>
					<span style="margin-right: 10px; padding-right: 61px;">
						<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">
						<c:out value="${perspective.current_cost * bean.objectiveSet.current_total_cost}"></c:out>
						</fmt:formatNumber> 
					</span>
				</c:otherwise>
			</c:choose>
			
			<span style="margin-right: 10px; padding-right: 30px;">
				<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">
				<c:out value="${perspective.completion_percent * 100}"></c:out>
				</fmt:formatNumber>% 
			</span>

			
			<input type="hidden" class="perspectiveName" value="${perspective.name}"/>
			<input type="hidden" class="perspectiveID" value="${perspective.orgObjectPerspectiveId}"/>
			</div>
			</div>
			
			<c:if test="${perspective.orgObjectPerspectiveId == bean.perspectiveID}">
			<div class="msg_body">
			<c:forEach items="${bean.objectiveList}" var="_objective" varStatus="count">
			<c:if test="${perspective.orgObjectPerspectiveId == _objective.orgObjectPerspectiveId}">
				<div class="msg_content">
					<div class="msg_head_parent">
					<div class="current_msg_head-left" style="width: 250px;">
					<span>
						<fmt:message key="title.no.objective" /><c:out value="${countObjective.count}"></c:out>: <c:out value="${_objective.name}"></c:out>
					</span>					 
					</div>
					
					<div class="msg_head-right">
					<span style="margin-right: 305px;">
						<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
					 		value="${_objective.weight_percent * 100}"></fmt:formatNumber>%
					</span>
			
					<input type="hidden" class="objectiveValue" value="${_objective.orgObjectObjectiveId}"/>
					<input type="hidden" class="perspectiveID" value="${perspective.orgObjectPerspectiveId}"/>
					</div>
				</div>
				
				<div class="msg_body">
				<c:forEach items="${bean.measureList}" var="_measure" varStatus="count">
				<c:if test="${_objective.orgObjectObjectiveId == _measure.orgObjectObjectiveId}">
				<div class="msg_content">
					<div class="msg_head_parent">
						<div class="current_msg_head-left" style="width: 150px;" >
							<span>
							<fmt:message key="title.no.measure" /><c:out value="${countMeasure.count}"></c:out>: <c:out value="${_measure.name}"></c:out>
							</span>							
						</div>
						
						<div class="msg_head-right">
											
						<span style="margin-right: 305px;">
						<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
					 		value="${_measure.weight_percent * 100}"></fmt:formatNumber>%
						</span>
			
						<input type="hidden" value="${_measure.orgObjectMeasureId}"/>
						<input type="hidden" class="perspectiveID" value="${perspective.orgObjectPerspectiveId}"/>
						</div>
					</div>
					
					<div class="msg_body">
					<c:forEach items="${bean.targetList}" var="_target" varStatus="count">
					<c:if test="${_measure.orgObjectMeasureId == _target.orgObjectMeasureId}">										
					<div class="msg_content">
					<div class="msg_head_parent">
						<div style="width: 180px; margin-left: 10px; float: left;" >
						- <fmt:message key="title.no.target" /><c:out value="${countTarget.count}"></c:out>: <c:out value="${_target.name}"></c:out>
						</div>
						
						<div class="msg_head-right">
							
							<input type="hidden" value="${_target.orgObjectTargetId}"/>
							<input type="hidden" class="perspectiveID" value="${perspective.orgObjectPerspectiveId}"/>							
						</div>
					</div>					
					</div>
					</c:if>
					</c:forEach>
					</div>
				</div>
				</c:if>
				</c:forEach>
				</div>
				</div>
			</c:if>							
			</c:forEach>
			</div>
			</c:if>			
		</div>
		</c:forEach>
		</div>
		</div>		
	</div>
	
	<div class="tabs-content-right">	
	<div style="padding: 10px;">
		<span><fmt:message key="title.percent.input"/></span><br/>
		<div id="progressbar-1" class="progressbar"></div><br/>		
		<span style="margin-top: 2px"><fmt:message key="title.percent.complete.result"/></span><br/>
		<div id="progressbar-2" class="progressbar"></div>
	</div>
	
	<div style="padding: 10px; margin-top: 10px; height: 300px;">
		<span style="font-weight: bold; font-size: 15;"><fmt:message key="title.tab4"/></span><br/>
		<span class="bt-new">
				<a href='#' >
					<fmt:message key="button.main.input" />
				</a>
		</span>
		<span class="bt-edit">
				<a href='#' >
					<fmt:message key="button.main.alg" />
				</a>
		</span>
		<div class="tdl-row">
				<div class="tdl-row-left" style="width: 110px;">
				<span style="width: 109px;">
				<fmt:message key="title.main.total.cost"></fmt:message></span></div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=ObjectivesList_RS.OBJ_LIST_CURRENT_TOTAL_COST %>"
				style="width: 65px; text-align: right;" readonly="readonly" 
				value="${bean.objectiveSet.current_total_cost}"/></div>
		</div>
		<div class="tdl-row">
				<div class="tdl-row-left" style="width: 110px;">
				<span style="width: 109px;">
				<fmt:message key="title.unit"></fmt:message></span></div>
				
				<div class="tdl-row-right">
				<input type="text" value="USD"
				style="width: 65px; text-align: right;" readonly="readonly" /></div>
		</div>
		<div class="tdl-row">
				<div class="tdl-row-left" style="width: 110px;">
				<span style="width: 109px; height:">
				<fmt:message key="title.p2.next.total.cost2"></fmt:message></span></div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=ObjectivesList_RS.OBJ_LIST_NEXT_TOTAL_COST %>"
				style="width: 65px; text-align: right;" readonly="readonly" 
				value="${bean.objectiveSet.next_total_cost}"/></div>
		</div>
		<div class="tdl-row">
				<div class="tdl-row-left" style="width: 110px;">
				<span style="width: 109px;">
				<fmt:message key="title.p3.expected.completion2"></fmt:message></span></div>
				
				<div class="tdl-row-right">
				<input type="text" name="<%=ObjectivesList_RS.OBJ_LIST_EXPECTED_COMPLETION %>"
				style="width: 65px; text-align: right;" readonly="readonly" 
				value="${bean.objectiveSet.expected_completion * 100}"/></div>
		</div>
		
		<input type="hidden" class="objCurrentTotalCost" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
		value="${bean.objectiveSet.current_total_cost}"></fmt:formatNumber>' >
		
		<input type="hidden" class="objNextTotalCost" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
		value="${bean.objectiveSet.next_total_cost}"></fmt:formatNumber>' >
		
		<input type="hidden" class="objExpectedCompletion" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
		value="${bean.objectiveSet.expected_completion * 100}"></fmt:formatNumber>' >
		
		<input type="hidden" class="objFCurrentCost" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
		value="${bean.perspectiveList[0].current_cost * bean.objectiveSet.current_total_cost}"></fmt:formatNumber>' >
		
		<input type="hidden" class="objCCurrentCost" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
		value="${bean.perspectiveList[1].current_cost * bean.objectiveSet.current_total_cost}"></fmt:formatNumber>' >
		
		<input type="hidden" class="objPCurrentCost" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
		value="${bean.perspectiveList[2].current_cost * bean.objectiveSet.current_total_cost}"></fmt:formatNumber>' >
		
		<input type="hidden" class="objGCurrentCost" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
		value="${bean.perspectiveList[3].current_cost * bean.objectiveSet.current_total_cost}"></fmt:formatNumber>' >
							
	</div>
	
	</div>
</div>

<input type="hidden" id="percent_input" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
value="${bean.objectiveSet.entering_percent * 100}"></fmt:formatNumber> ' >
<input type="hidden" id="percent_complete" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
value="${bean.objectiveSet.completion_percent * 100}"></fmt:formatNumber> ' >
 
</form>


