<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
<script type="text/javascript" src="/ProGate_ManageOrgInfo-portlet/js/ui.core.js"></script>
<script type="text/javascript" src="/ProGate_ManageOrgInfo-portlet/js/ui.progressbar.js"></script>-->

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
	
	jQuery(".applyWeightPercent").click(function(event){
		var orgSetID = jQuery(this).parent().find(".objectiveSetID").val();		
		applyWP(orgSetID);
		event.preventDefault();
	});

	jQuery(".applyWeightPercent a").click(function(event){
		var orgSetID = jQuery(this).parent().parent().find(".objectiveSetID").val();
		applyWP(orgSetID);
		event.preventDefault();
	});
	
	function applyWP(orgSetID) {
		document.frmApplyWeightPercent.<%=ObjectivesList_RS.OBJ_LIST_ID %>.value = orgSetID;
		jQuery("#dialogApplyWeightPercent").css("display", "block");
		jQuery("#dialogApplyWeightPercent").dialog("open");
	}
	
	jQuery(".ahpCalculate").click(function(event){
		calculateWeightPercent();
		event.preventDefault();
	});

	jQuery(".ahpCalculate a").click(function(event){
		calculateWeightPercent();
		event.preventDefault();
	});
	
	
	function calculateWeightPercent(){
		//var inputAhpFile = document.getElementById("inputAhpFileID").value;
		var portletActionURL = '<portlet:renderURL>
									    <portlet:param name="action"  value="showingOrgainzationDetails" />					    
									    <portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
								    	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
								     			   value="${bean.objectiveSet.orgObjectListId}" />
									    <portlet:param name="<%=Request.TA %>" value="<%=Request.AHP_ALGORITHM_ACT %>" />
									</portlet:renderURL>';
		jQuery("form[name='frmAhpAlgorithm']").attr("action", portletActionURL);			
		jQuery("form[name='frmAhpAlgorithm']").submit();
	}
	
	
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

	//alert(percentInput);
	jQuery("#progressbar-1").reportprogress(percentInput);
	jQuery("#progressbar-2").reportprogress(percentComplete);
	// End handle progressbar
});
</script>

<jsp:include page="dialog/applyWeightPercent.jsp"></jsp:include>

<form action="" method="post" name="frmAhpAlgorithm">
<div class="tabs-content-1">
	<div class="tabs-content-left">
		<div>
		<span style="padding-right: 10px; padding-left: 350px; margin-right: 20px;">
				<fmt:message key="title.weight"/></span>
		<span style="margin-right: 0px; padding-right: 20px; padding-left: 10px;">
				<fmt:message key="title.main.weight.suggested"/></span>
		<span style="margin-right: 0px; padding-right: 0px; padding-left: 0px;">
				<fmt:message key="title.inconsistency.ahp"/></span>
		</div>
		
		<div class="title-msg">
			<fmt:message key="titile.objective.system"/> <c:out value="${bean.objectiveSet.year}"/>		
			<c:choose>
				<c:when test="${bean.objectiveSet.consistency_ratio < 0.1}">
					<span style="padding-left: 412px;">
						<fmt:formatNumber type="number" pattern="#"
							value="${bean.objectiveSet.consistency_ratio*100}"></fmt:formatNumber>%
					</span>
				</c:when>
				<c:otherwise>
					<span style="padding-left: 412px; color: blue;">
						<fmt:formatNumber type="number" pattern="#"
							value="${bean.objectiveSet.consistency_ratio*100}"></fmt:formatNumber>%
					</span>
				</c:otherwise>
			</c:choose>
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
				<portlet:param name="<%=Request.TA %>" value="<%=Request.TA_5 %>" />
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
			
			<div class="msg_head-right" style="padding-right: 25px;">
					<c:choose>
						<c:when test="${perspective.weight_percent_suggested < 0.1}">
							<span style="padding-right: 97px;">
								<fmt:formatNumber type="number" pattern="#"
											value="${perspective.weight_percent*100}"></fmt:formatNumber>%
							</span>
						</c:when>
						<c:when test="${perspective.weight_percent_suggested >= 0.1 && perspective.weight_percent_suggested < 1}">
							<span style="padding-right: 90px;">
								<fmt:formatNumber type="number" pattern="#"
											value="${perspective.weight_percent*100}"></fmt:formatNumber>%
							</span>
						</c:when>
						<c:otherwise>
							<span style="padding-right: 83px;">
								<fmt:formatNumber type="number" pattern="#"
											value="${perspective.weight_percent*100}"></fmt:formatNumber>%
							</span>
								</span>
						</c:otherwise>
					</c:choose>
							
					<c:choose>
						<c:when test="${perspective.consistency_ratio < 0.1}">
							<span style="padding-right: 110px;">
								<fmt:formatNumber type="number" pattern="#"
											value="${perspective.weight_percent_suggested*100}"></fmt:formatNumber>%
							</span>
						</c:when>
						<c:otherwise>
							<span style="padding-right: 103px;">
								<fmt:formatNumber type="number" pattern="#"
											value="${perspective.weight_percent_suggested*100}"></fmt:formatNumber>%
							</span>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${perspective.consistency_ratio < 0.1}">
							<span style="padding-right: 10px;">
								<fmt:formatNumber type="number" pattern="#"
									value="${perspective.consistency_ratio*100}"></fmt:formatNumber>%
							</span>
						</c:when>
						<c:otherwise>
							<span style="padding-right: 10px; color: blue;">
								<fmt:formatNumber type="number" pattern="#"
									value="${perspective.consistency_ratio*100}"></fmt:formatNumber>%
							</span>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
			<c:if test="${perspective.orgObjectPerspectiveId == bean.perspectiveID}">
			<div class="msg_body">
			<c:forEach items="${bean.objectiveList}" var="_objective" varStatus="count">
			<c:if test="${perspective.orgObjectPerspectiveId == _objective.orgObjectPerspectiveId}">
				<div class="msg_content">
					<div class="msg_head_parent">
					<div class="current_msg_head-left" style="width: 350px;">
					<span>
						<fmt:message key="title.no.objective" /><c:out value="${countObjective.count}"></c:out>: <c:out value="${_objective.name}"></c:out>
					</span>					 
					</div>
					
					<div class="msg_head-right" style="padding-right: 25px";>
						<c:choose>
							<c:when test="${_objective.weight_percent_suggested < 0.1}">
								<span style="padding-right: 97px;">
									<fmt:formatNumber type="number" pattern="#"
												value="${_objective.weight_percent*100}"></fmt:formatNumber>%
								</span>
							</c:when>
							<c:when test="${_objective.weight_percent_suggested >= 0.1 && _objective.weight_percent_suggested < 1}">
								<span style="padding-right: 90px;">
									<fmt:formatNumber type="number" pattern="#"
												value="${_objective.weight_percent*100}"></fmt:formatNumber>%
								</span>
							</c:when>
							<c:otherwise>
								<span style="padding-right: 83px;">
									<fmt:formatNumber type="number" pattern="#"
												value="${_objective.weight_percent*100}"></fmt:formatNumber>%
								</span>
									</span>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${_objective.consistency_ratio < 0.1}">
								<span style="padding-right: 110px;">
									<fmt:formatNumber type="number" pattern="#"
												value="${_objective.weight_percent_suggested*100}"></fmt:formatNumber>%
								</span>
							</c:when>
							<c:otherwise>
								<span style="padding-right: 103px;">
									<fmt:formatNumber type="number" pattern="#"
												value="${_objective.weight_percent_suggested*100}"></fmt:formatNumber>%
								</span>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${_objective.consistency_ratio < 0.1}">
								<span style="padding-right: 10px;">
									<fmt:formatNumber type="number" pattern="#"
										value="${_objective.consistency_ratio*100}"></fmt:formatNumber>%
								</span>
							</c:when>
							<c:otherwise>
								<span style="padding-right: 10px; color: blue;">
									<fmt:formatNumber type="number" pattern="#"
										value="${_objective.consistency_ratio*100}"></fmt:formatNumber>%
								</span>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				
				<div class="msg_body">
				<c:forEach items="${bean.measureList}" var="_measure" varStatus="count">
				<c:if test="${_objective.orgObjectObjectiveId == _measure.orgObjectObjectiveId}">
				<div class="msg_content">
					<div class="msg_head_parent">
						<div class="current_msg_head-left" style="width: 180px;" >
							<span>
							<fmt:message key="title.no.measure" /><c:out value="${countMeasure.count}"></c:out>: <c:out value="${_measure.name}"></c:out>
							</span>							
						</div>
						
						<div class="msg_head-right" style="padding-right: 25px";>
							<c:choose>
								<c:when test="${_measure.weight_percent_suggested < 0.1}">
									<span style="padding-right: 97px;">
										<fmt:formatNumber type="number" pattern="#"
													value="${_measure.weight_percent*100}"></fmt:formatNumber>%
									</span>
								</c:when>
								<c:when test="${_measure.weight_percent_suggested >= 0.1 && _measure.weight_percent_suggested < 1}">
									<span style="padding-right: 90px;">
										<fmt:formatNumber type="number" pattern="#"
													value="${_measure.weight_percent*100}"></fmt:formatNumber>%
									</span>
								</c:when>
								<c:otherwise>
									<span style="padding-right: 83px;">
										<fmt:formatNumber type="number" pattern="#"
													value="${_measure.weight_percent*100}"></fmt:formatNumber>%
									</span>
										</span>
								</c:otherwise>
							</c:choose>
						
							<span style="padding-right: 143px;">
							<fmt:formatNumber type="number" pattern="#"
								value="${_measure.weight_percent_suggested*100}"></fmt:formatNumber>%
							</span>
						</div>
					</div>
					
					<div class="msg_body">
					<c:forEach items="${bean.targetList}" var="_target" varStatus="count">
					<c:if test="${_measure.orgObjectMeasureId == _target.orgObjectMeasureId}">										
					<div class="msg_content">
					<div class="msg_head_parent">
						<div style="width: 180px; margin-left: 10px;" >
						- <fmt:message key="title.no.target" /><c:out value="${countTarget.count}"></c:out>: <c:out value="${_target.name}"></c:out>
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
		<div>
			<span style="color: blue">
				<fmt:message key="title.inconsistency.warning" />
			</span>
		</div>
		<div style="padding-left: 500px;">
			<span class="bt-edit applyWeightPercent" style="padding-left: 20px;">
				<a href='#' >
					<fmt:message key="button.apply.weight.percent" />
				</a>
			</span>
			<input type="hidden" class="objectiveSetID" value="${bean.objectiveSet.orgObjectListId}" /> 
		</div>
	</div>
	
	<div class="tabs-content-right">	
	<div style="padding: 10px;">
		<span><fmt:message key="title.percent.input"/></span><br/>
		<div id="progressbar-1" class="progressbar"></div><br/>		
		<span style="margin-top: 2px"><fmt:message key="title.percent.complete.result"/></span><br/>
		<div id="progressbar-2" class="progressbar"></div>
	</div>
	
	<div style="padding: 10px; margin-top: 10px; height: 200px;">
		<form action="" method="post" name="frmAhpInputFile">
			<span style="font-weight: bold; font-size: 15;"><fmt:message key="title.tab5"/></span><br/>
			<span><fmt:message key="title.inputLabel.ahp"/></span><br/>
			<span style="padding-left: 10px;"><fmt:message key="title.comparision.input.ahp"/></span><br/>
			<tr>
				<td><input name="inputAhpFileName" type="file" id="inputAhpFileID" size="15px"></td>
			</tr>
			<span style="padding-left: 10px;"><fmt:message key="title.randomIndex.input.ahp"/></span><br/>
			<tr>
				<td><input name="inputRandomIndexFileName" type="file" id="inputRandomIndexFileID" size="15px"></td>
			</tr>
			<br><br>
			<span><fmt:message key="title.calculate.ahp"/></span><br/>
			<div style="padding-left: 15px;">
				<span class="bt-edit ahpCalculate" style="padding-left: 20px;">
					<a href='#' >
						<fmt:message key="button.calculate.ahp" />
					</a>
				</span>
			</div>
		</form>
	</div>
	
	</div>
</div>

<input type="hidden" id="percent_input" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
value="${bean.objectiveSet.entering_percent * 100}"></fmt:formatNumber> ' >
<input type="hidden" id="percent_complete" value='<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="0"
value="${bean.objectiveSet.completion_percent * 100}"></fmt:formatNumber> ' >
 
</form>

