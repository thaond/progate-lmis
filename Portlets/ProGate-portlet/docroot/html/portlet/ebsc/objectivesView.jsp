<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
jQuery(document).ready(function(){
	
	// Handle collapse/fold
	jQuery(".msg_head-left").addClass("fold");
	
	//hide the all of the element with class msg_body	
	jQuery(".msg_body").hide();
	
	//toggle the componenet with class msg_body
	jQuery(".msg_head-left").click(function(){
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
	
	var progressOpts = {
		width: 200
	};
	
	//alert(percentInput);
	jQuery("#progressbar-1").reportprogress(percentInput);
	jQuery("#progressbar-2").reportprogress(percentComplete);
	// End handle progressbar
});
</script>

<form>
<div class="tabs-content-1">
	<div class="tabs-content-left">
		<div class="title-msg">
			<fmt:message key="titile.objective.system"/> <c:out value="${bean.objectiveSet.year}"/>
		</div>
			
		<div style="padding: 10px; float: left;">
		<div style="float: left; background-color: white; width: 680px;">
		<c:forEach items="${bean.perspectiveList}" var="perspective" varStatus="count">
		<div class="msg_content msg_border">
			<div class="msg_head_parent">
			<div class="msg_head-left">
			<span>
				<c:out value="${perspective.name}"></c:out>
			</span>
			</div>
			
			<div class="msg_head-right">
			<span>
				<fmt:message key="title.weight"/> <fmt:formatNumber type="number" pattern="#" 
					 		value="${perspective.weight_percent}"></fmt:formatNumber>%
			</span>
			</div>
			</div>
		
			<div class="msg_body">
			<c:forEach items="${bean.objectiveList}" var="_objective" varStatus="count">
			<c:if test="${perspective.orgObjectPerspectiveId == _objective.orgObjectPerspectiveId}">
				<div class="msg_content">
					<div class="msg_head_parent">
					<div class="msg_head-left" style="width: 350px;">
					<span>
						<fmt:message key="title.no.objective" /><c:out value="${countObjective.count}"></c:out>: <c:out value="${_objective.name}"></c:out>
					</span>					 
					</div>
					
					<div class="msg_head-right">
					<span>
						<fmt:formatNumber type="number" pattern="#" 
					 		value="${_objective.weight_percent}"></fmt:formatNumber>% 
					</span>
					</div>
				</div>
				
				<div class="msg_body">
				<c:forEach items="${bean.measureList}" var="_measure" varStatus="count">
				<c:if test="${_objective.orgObjectObjectiveId == _measure.orgObjectObjectiveId}">
				<div class="msg_content">
					<div class="msg_head_parent">
						<div class="msg_head-left" style="width: 180px;">
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
						<span style="margin-right: 100px;">
						<fmt:formatNumber type="number" pattern="#" 
					 		value="${_measure.result}"></fmt:formatNumber>%
						</span>
						
						<span>
						<fmt:formatNumber type="number" pattern="#" 
					 		value="${_measure.weight_percent}"></fmt:formatNumber>%
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
