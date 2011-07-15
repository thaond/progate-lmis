<%@page import="larion.progate.model.OrgObjectObjective"%>
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
	
	// Handle add objective/ edit perspective
	jQuery(".objectiveAdd").click(function(){
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		addObjective(perspectiveID);
	});
	
	jQuery(".perspectiveEdit").click(function(){
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		var perspectiveName = jQuery(this).parent().find(".perspectiveName").val();
		
		editPerspective(perspectiveID, perspectiveName);
	});
	
	jQuery(".objectiveAdd a").click(function(event){
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		addObjective(perspectiveID);
		event.preventDefault();
	});
	
	jQuery(".perspectiveEdit a").click(function(event){
		var perspectiveID = jQuery(this).parent().parent().find("perspectiveID").val();
		var perspectiveName = jQuery(this).parent().parent().find(".perspectiveName").val();
		
		editPerspective(perspectiveID, perspectiveName);
		event.preventDefault();
	});
	
	function addObjective(perspectiveID) {
		
		document.frmAddObjective.<%=Perspectives_RS.PER_ID %>.value = perspectiveID;
		
		jQuery("#dialogAddObjective").css("display", "block");
		jQuery("#dialogAddObjective").dialog("open");
	}
	
	function editPerspective(perspectiveID, perspectiveName) {
		
		document.frmEditPerspective.<%=Perspectives_RS.PER_ID %>.value = perspectiveID;
		document.frmEditPerspective.<%=Perspectives_RS.PER_NAME %>.value = perspectiveName;
		
		jQuery("#dialogEditPerspective").css("display", "block");
		jQuery("#dialogEditPerspective").dialog("open");
	}
	// End handle add/delete objective
	
	
	// Handle add measure/ edit and delete objective
	jQuery(".measureAdd").click(function(){
		var objectiveID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		
		addMeasure(objectiveID, perspectiveID);
	});
	
	jQuery(".objectiveEdit").click(function(){
		var objectiveName = jQuery(this).parent().parent().find(".objectiveName").val();
		var objectiveID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		
		editObjective(objectiveID, objectiveName, perspectiveID);
	});
	
	jQuery(".objectiveDelete").click(function(){
		var objectiveID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		
		deleteObjective(objectiveID, perspectiveID);
	});
	
	jQuery(".measureAdd a").click(function(event){
		var objectiveID = jQuery(this).parent().parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().parent().find(".perspectiveID").val();
		
		addMeasure(objectiveID, perspectiveID);
		
		event.preventDefault();
	});
	
	jQuery(".objectiveEdit a").click(function(){
		var objectiveName = jQuery(this).parent().parent().find(".objectiveName").val();
		var objectiveID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		
		editObjective(objectiveID, objectiveName, perspectiveID);
		
		event.preventDefault();
	});
	
	jQuery(".objectiveDelete a").click(function(event){
		var objectiveID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		
		deleteObjective(objectiveID, perspectiveID);
		
		event.preventDefault();
	});
	
	function addMeasure(objectiveID, perspectiveID) {
		
		document.frmAddMeasure.<%=Perspectives_RS.PER_ID %>.value = perspectiveID;
		document.frmAddMeasure.<%=Objectives_RS.OBJ_ID %>.value = objectiveID;
		
		jQuery("#dialogAddMeasure").css("display", "block");
		jQuery("#dialogAddMeasure").dialog("open");
	}
	
	function editObjective(objectiveID, objectiveName, perspectiveID) {
		document.frmEditObjective.<%=Perspectives_RS.PER_ID %>.value = perspectiveID;
		document.frmEditObjective.<%=Objectives_RS.OBJ_ID %>.value = objectiveID;
		document.frmEditObjective.<%=Objectives_RS.OBJ_NAME %>.value = objectiveName;
		
		jQuery("#dialogEditObjective").css("display", "block");
		jQuery("#dialogEditObjective").dialog("open");
	}
	
	function deleteObjective(objectiveID) {
		//alert(objectiveID);
	}
	// Handle add measure/ edit and delete objective
		
	// Handle add target/ edit and delete measure
	jQuery(".targetAdd").click(function(){
		var targetID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		
		addTarget(targetID, perspectiveID);
	});
	
	jQuery(".measureEdit").click(function(){
		var targetID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		
		editMeasure(targetID, perspectiveID);
	});
	
	jQuery(".measureDelete").click(function(){
		var targetID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().find(".perspectiveID").val();
		
		deleteMeasure(targetID, perspectiveID);
	});
	
	jQuery(".targetAdd a").click(function(event){
		var measureID = jQuery(this).parent().parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().parent().find(".perspectiveID").val();
		
		addTarget(measureID, perspectiveID);
		event.preventDefault();
	});
	
	jQuery(".measureEdit a").click(function(event){
		var targetID = jQuery(this).parent().parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().parent().find(".perspectiveID").val();
		
		editMeasure(targetID, perspectiveID);
		event.preventDefault();
	});
	
	jQuery(".measureDelete a").click(function(){
		var targetID = jQuery(this).parent().parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().parent().find(".perspectiveID").val();
		
		deleteMeasure(targetID, perspectiveID);
		event.preventDefault();
	});
	
	function addTarget(measureID, perspectiveID) {
		document.frmAddTarget.<%=Perspectives_RS.PER_ID %>.value = perspectiveID;
		document.frmAddTarget.<%=Measures_RS.MEA_ID %>.value = measureID;
		
		jQuery("#dialogAddTarget").css("display", "block");
		jQuery("#dialogAddTarget").dialog("open");
	}
	
	function editMeasure(measureID, perspectiveID) {
		document.frmEditMeasure.<%=Perspectives_RS.PER_ID %>.value = perspectiveID;
		document.frmEditMeasure.<%=Measures_RS.MEA_ID %>.value = measureID;
		
		jQuery("#dialogEditMeasure").css("display", "block");
		jQuery("#dialogEditMeasure").dialog("open");
	}
	
	function deleteMeasure(targetID, perspectiveID) {
		//alert(targetID);
	}
	// Handle add measure/ edit and delete objective
	
	
	// Handle edit/delete target
	jQuery(".targetEdit").click(function(){
		var targetID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().parent().find(".perspectiveID").val();
		
		editTarget(targetID, perspectiveID);
		event.preventDefault();
	});
	
	jQuery(".targetDelete").click(function(event){
		var targetID = jQuery(this).parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().parent().find(".perspectiveID").val();
		
		deleteTarget(targetID, perspectiveID);
		event.preventDefault();
	});
	
	jQuery(".targetEdit a").click(function(){
		var targetID = jQuery(this).parent().parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().parent().find(".perspectiveID").val();
		
		editTarget(targetID, perspectiveID);
		event.preventDefault();
	});
	
	jQuery(".targetDelete a").click(function(event){
		var targetID = jQuery(this).parent().parent().find("input:first").val();
		var perspectiveID = jQuery(this).parent().parent().find(".perspectiveID").val();
		
		deleteTarget(targetID, perspectiveID);
		event.preventDefault();
	});
	
	function editTarget(targetID, perspectiveID) {
		document.frmEditTarget.<%=Perspectives_RS.PER_ID %>.value = perspectiveID;
		document.frmEditTarget.<%=Targets_RS.TARGET_ID %>.value = targetID;
		
		jQuery("#dialogAddTarget").css("display", "block");
		jQuery("#dialogAddTarget").dialog("open");
	}
	
	function deleteTarget(targetID, perspectiveID) {
		document.frmDeleteTarget.<%=Perspectives_RS.PER_ID %>.value = perspectiveID;
		document.frmDeleteTarget.<%=Targets_RS.TARGET_ID %>.value = targetID;
		
		jQuery("#dialogDeleteTarget").css("display", "block");
		jQuery("#dialogDeleteTarget").dialog("open");
	}
	// End handle add/delete target
	
	
	// Handle progressbar
	var percentInput = jQuery("#percent_input").val();
	var percentComplete = jQuery("#percent_complete").val();
	
	var progressOpts = {
		width: 200
	};
	
	//alert(percentInput);
	jQuery("#progressbar-1").reportprogress(percentInput);
	
	jQuery("#progressbar-2").reportprogress(240);
	// End handle progressbar
});
</script>

<jsp:include page="dialog/dialogs.jsp"></jsp:include>

<form action="" method="post" name="frmObjectivesEdit">
<div class="tabs-content-1">
	<div class="tabs-content-left">
		<div class="title-msg">
			<fmt:message key="titile.objective.system"/> <c:out value="${bean.objectiveSet.year}"/>
		</div>
		
		<div style="padding: 10px; float: left;">
		<div style="float: left; background-color: white; width: 680px;">
		<c:forEach items="${bean.perspectiveList}" var="perspective" varStatus="countPerspective">
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
				<portlet:param name="<%=Request.TA %>" value="<%=Request.TA_1_2 %>" />
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
				<span style="margin-right: 10px;">
					<fmt:message key="title.weight"/> <fmt:formatNumber type="number" pattern="#" 
						 		value="${perspective.weight_percent}"></fmt:formatNumber>%
				</span>
				
				<span class="bt-new objectiveAdd" style="margin-right: 14px;">
					<a href='#' >
						<fmt:message key="button.add.objective" />
					</a>
				</span>
				
				<span class="bt-edit perspectiveEdit" style="margin-right: 75px;">
					<a href='#' >
						<fmt:message key="button.edit" />
					</a>
				</span>
						
				<input type="hidden" class="perspectiveName" value="${perspective.name}"/>
				<input type="hidden" class="perspectiveID" value="${perspective.orgObjectPerspectiveId}"/>
			</div>
			</div>
			
			<c:if test="${perspective.orgObjectPerspectiveId == bean.perspectiveID}">
			<div class="msg_body">
			<c:forEach items="${bean.objectiveList}" var="_objective" varStatus="countObjective">
			<c:if test="${perspective.orgObjectPerspectiveId == _objective.orgObjectPerspectiveId}">
				<div class="msg_content">
					<div class="msg_head_parent">
					<div class="current_msg_head-left" style="width: 320px;">
					<span>
						<fmt:message key="title.no.objective" /><c:out value="${countObjective.count}"></c:out>: <c:out value="${_objective.name}"></c:out>
					</span>					 
					</div>
					
					<div class="msg_head-right">
					<span style="margin-right: 10px;">
						<fmt:formatNumber type="number" pattern="#" 
					 		value="${_objective.weight_percent}"></fmt:formatNumber>% 
					</span>
					
					<span class="bt-new measureAdd">
						<a href='#' >
							<fmt:message key="button.add.measure" />
						</a>
					</span>
					
					<span class="bt-edit objectiveEdit">
						<a href='#' >
							<fmt:message key="button.edit" />
						</a>
					</span>
					
					<span class="bt-delete objectiveDelete">
						<a href='#' >
							<fmt:message key="button.delete" />						
						</a>
					</span>
					
					<input type="hidden" class="objectiveValue" value="${_objective.orgObjectObjectiveId}"/>
					<input type="hidden" class="objectiveName" value="${_objective.name}"/>
					<input type="hidden" class="perspectiveID" value="${perspective.orgObjectPerspectiveId}"/>
					</div>
				</div>
				
				<div class="msg_body">
				<c:forEach items="${bean.measureList}" var="_measure" varStatus="countMeasure">
				<c:if test="${_objective.orgObjectObjectiveId == _measure.orgObjectObjectiveId}">
				<div class="msg_content">
					<div class="msg_head_parent">
						<div class="current_msg_head-left" style="width: 150px;" >
							<span>
							<fmt:message key="title.no.measure" /><c:out value="${countMeasure.count}"></c:out>: <c:out value="${_measure.name}"></c:out>
							</span>							
						</div>
						
						<div class="msg_head-right">
						<span style="margin-right: 10px;">
						<a href="#" style="text-decoration: none;  color: blue;" ><fmt:message key="title.fomula"/></a> 
						</span>
						
						<span style="margin-right: 2px; color: blue">
						<fmt:message key="title.result"/> 
						</span>	
						<span style="margin-right: 10px;">
						<fmt:formatNumber type="number" pattern="#" 
					 		value="${_measure.result}"></fmt:formatNumber>%
						</span>
						
						<span style="margin-right: 10px;">
						<fmt:formatNumber type="number" pattern="#" 
					 		value="${_measure.weight_percent}"></fmt:formatNumber>%
						</span>
						
						<span class="bt-new targetAdd" style="margin-right: 32px;">
						<a href='#' >
							<fmt:message key="button.add.target" />
						</a>
						</span>
						
						<span class="bt-edit measureEdit">
							<a href='#' >
								<fmt:message key="button.edit" />
							</a>
						</span>
						
						<span class="bt-delete measureDelete">
							<a href='#' >
								<fmt:message key="button.delete" />
							</a>
						</span>
												
						<input type="hidden" class="measureValue" value="${_measure.orgObjectMeasureId}"/>
						<input type="hidden" class="measureName" value="${_measure.name}"/>
						<input type="hidden" class="perspectiveID" value="${perspective.orgObjectPerspectiveId}"/>
						</div>
					</div>
					
					<div class="msg_body">
					<c:forEach items="${bean.targetList}" var="_target" varStatus="countTarget">
					<c:if test="${_measure.orgObjectMeasureId == _target.orgObjectMeasureId}">										
					<div class="msg_content">
					<div class="msg_head_parent">
						<div style="width: 180px; margin-left: 10px; float: left;" >
						- <fmt:message key="title.no.target" /><c:out value="${countTarget.count}"></c:out>: <c:out value="${_target.name}"></c:out>
						</div>
						
						<div class="msg_head-right">
							<span class="bt-edit targetEdit">
							<a href='#' >
								<fmt:message key="button.edit" />
							</a>
							</span>
							
							<span class="bt-delete targetDelete">
							<a href='#' >
								<fmt:message key="button.delete" />
							</a>
							</span>
							
							<input type="hidden" class="targetVlaue" value="${_target.orgObjectTargetId}"/>
							<input type="hidden" class="targetName" value="${_target.name}"/>
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
	</div>
</div>

<input type="hidden" id="percent_input" value='<c:out value="${bean.objectiveSet.entering_percent}"></c:out>'>
<input type="hidden" id="percent_complete" value='<c:out value="${bean.objectiveSet.completion_percent}"></c:out>'>
</form>


