<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">			
	jQuery(function(){
		// Show create objective set dialog
		var save = function() {
			var portletActionURL = '<portlet:renderURL>
									<portlet:param name="action" value="showingOrgainzationDetails" />
									<portlet:param name="<%=Request.ORG_ID %>" value="${bean.org.orgId}" />
									<portlet:param name="<%=Request.TA %>" value="<%=Request.ADD_OBJECTIVE_SET_ACT %>" />										
									</portlet:renderURL>';				
						
			jQuery("form[name='frmCreateObjectiveSet']").attr("action", portletActionURL);			
			jQuery("form[name='frmCreateObjectiveSet']").submit();
	  	}
		
		var close = function() {
			jQuery("#createObjectiveSet").dialog("close");
	  	}
		
		var dialogOpts = {
	    	title:'<fmt:message key="title.create.objective.set" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.save" />': save, 
		    	'<fmt:message key="button.cancel" />': close
		    },
		    resizable: false,
		    width: 255,
		    height: 200
	    };
	    
	    jQuery("#createObjectiveSet").dialog(dialogOpts);
	    
	    jQuery("#linkCreateObjectiveSet").click(function(){		    	
	    	jQuery("#createObjectiveSet").css("display", "block");
	    	jQuery("#createObjectiveSet").dialog("open");
	    });
		// End show create objective set dialog
	});
</script>

<div id="createObjectiveSet">
<form action="" method="post" name="frmCreateObjectiveSet">
	<div>
		<div>
		<div>
			<span><fmt:message key="title.create.objective.of.year" /></span>
			
			<select name="<%=Request.OBJ_YEAR %>">				
				<c:forEach begin="2000" end="2020" varStatus="count">
					<c:choose>
					<c:when test="${count.count == 10}">
						<option value="${2021 - count.count}" selected="selected">
						<c:out value="${2021 - count.count}"></c:out>
						</option>
					</c:when>
					
					<c:otherwise>
						<option value="${2021 - count.count}">
						<c:out value="${2021 - count.count}"></c:out>
						</option>
					</c:otherwise>						
					</c:choose>					
				</c:forEach>
			</select>
		</div>
		</div>
		
		<div style="padding-top: 5px;">
			<div><span><fmt:message key="title.objective.allocate.level" /></span></div>
			
			<div>
			<div style="background-color: #DFEFFC; padding: 6px; width: 233px;">
				<div>
					<span>
						<input id="objective_allocate_level_quarter" value="1" CHECKED
							type=radio name="<%=Request.OBJ_ALLOCATE_LEVEL %>" /> 
					
						<label class=lbl-for-radio for=objective_allocate_level_quarter>
								<fmt:message key="title.by.quarter" /></label>
					</span>
				</div>
					
				<div>
					<span>
						<input id="objective_allocate_level_month" value="2" CHECKED
							type=radio name="<%=Request.OBJ_ALLOCATE_LEVEL %>" /> 
					
						<label class=lbl-for-radio for=objective_allocate_level_month>
								<fmt:message key="title.by.month" /></label>
					</span>
				</div>
				
				<div>
					<span>
						<input id="objective_allocate_level_none" value="0" CHECKED
							type=radio name="<%=Request.OBJ_ALLOCATE_LEVEL %>" /> 
					
						<label class=lbl-for-radio for=objective_allocate_level_none>
								<fmt:message key="title.by.none" /></label>
					</span>
				</div>
			</div>
			</div>
		</div>		
	</div>
</form>
</div>