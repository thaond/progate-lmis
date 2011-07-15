

 
 <fmt:message key="add.guilde" bundle="${msg}" var="add" />
 <fmt:message key="delete.guilde" bundle="${msg}" var="delete" />
 <fmt:message key="repair.guilde" bundle="${msg}" var="repair" />
 
<fmt:message key="success.action" bundle="${msg}" var="addSuccessMessage">
    <fmt:param value="${add}"/> 
</fmt:message>
 
 <fmt:message key="success.action" bundle="${msg}" var="repairSuccessMessage">
    <fmt:param value="${repair}"/> 
</fmt:message>

<fmt:message key="success.action" bundle="${msg}" var="deleteSuccessMessage">
    <fmt:param value="${delete}"/> 
</fmt:message>

<%
   
    	String addSuccess = (String)request.getAttribute("ADD_SUCCESS");
		if (addSuccess !=null){
			renderRequest.setAttribute("addSuccess", addSuccess);
		}	
        String deleteSuccess = (String)request.getAttribute("DELETE_SUCCESS");
        if (deleteSuccess !=null){
			renderRequest.setAttribute("deleteSuccess", deleteSuccess);
		}	
        String repairSuccess = (String)request.getAttribute("REPAIR_SUCCESS");
	    if (repairSuccess !=null){
			renderRequest.setAttribute("repairSuccess", repairSuccess);
		}	
%>
 
<div id="success" class='success_message' style="display:none;">
		<c:if test="${addSuccess != null || deleteSuccess != null || repairSuccess != null}">
			 <script type="text/javascript">
				jQuery(document).ready(function(){	
					jQuery("#success").css("display","block");	
				});
			</script>
		</c:if>
		
		
		<c:choose>
			<c:when test="${addSuccess != null}">				
				${addSuccessMessage}	   	
			</c:when>	
			<c:when test="${deleteSuccess != null}">				
				${deleteSuccessMessage}	   	
			</c:when>	
			<c:when test="${repairSuccess != null}">				
				${repairSuccessMessage}	   	
			</c:when>	
		</c:choose>
	
	<img id="sucess_close" onmouseover="this.style.opacity=1;this.filters.alpha.opacity=100" 
		  onmouseout="this.style.opacity=0.4;this.filters.alpha.opacity=40" 
		  style="opacity:0.4;filter:alpha(opacity=40);float:right;" 
		  src="<%=request.getContextPath()%>/images/support_org_profile/delete2.png" width="15" height="15" />
</div>
<script type="text/javascript">
	jQuery(document).ready(function(){			
		jQuery('img').click(function(){
			jQuery("#success").css("display","none");
		});
	});
</script>
