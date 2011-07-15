
<fmt:message key="add.question" bundle="${msg}" var="add" />
 <fmt:message key="delete.question" bundle="${msg}" var="delete" />
 <fmt:message key="repair.question" bundle="${msg}" var="repair" />
  <fmt:message key="save.question" bundle="${msg}" var="save" />
 
<fmt:message key="error.action" bundle="${msg}" var="addErrorMessage">
    <fmt:param value="${add}"/> 
</fmt:message>
 
 <fmt:message key="error.action" bundle="${msg}" var="repairErrorMessage">
    <fmt:param value="${repair}"/> 
</fmt:message>

<fmt:message key="error.action" bundle="${msg}" var="deleteErrorMessage">
    <fmt:param value="${delete}"/> 
</fmt:message>

<fmt:message key="error.action" bundle="${msg}" var="saveErrorMessage">
    <fmt:param value="${save}"/> 
</fmt:message>
<%
   
    	String addError = (String)request.getAttribute("ADD_ERROR");
		if (addError !=null){
			renderRequest.setAttribute("addError", addError);
		}	
        String deleteError = (String)request.getAttribute("DELETE_ERROR");
        if (deleteError !=null){
			renderRequest.setAttribute("deleteError", deleteError);
		}	
        String repairError = (String)request.getAttribute("REPAIR_ERROR");
	    if (repairError !=null){
			renderRequest.setAttribute("repairError", repairError);
		}	
%>

<div id="error" class='warning_message' style="display:none;">
	   <c:if test="${addError != null || deleteError != null || repairError != null}">
			 <script type="text/javascript">
				jQuery(document).ready(function(){	
					jQuery("#error").css("display","block");	
				});
			</script>
		</c:if>		
		
		<c:choose>
			<c:when test="${addError != null}">				
				${addErrorMessage}	   	
			</c:when>	
			<c:when test="${deleteError != null}">				
				${deleteErrorMessage}	   	
			</c:when>	
			<c:when test="${repairError != null}">				
				${repairErrorMessage}	   	
			</c:when>
			<c:otherwise>
				${saveErrorMessage}
			</c:otherwise>	
		</c:choose>
		
		<img id="sucess_close" onmouseover="this.style.opacity=1;this.filters.alpha.opacity=100" 
		  onmouseout="this.style.opacity=0.4;this.filters.alpha.opacity=40" 
		  style="opacity:0.4;filter:alpha(opacity=40);float:right;" 
		  src="<%=request.getContextPath()%>/images/news_org/delete2.png" width="15" height="15" />
</div>


<script type="text/javascript">
	jQuery(document).ready(function(){			
		jQuery('img').click(function(){
			jQuery("#error").css("display","none");
		});
	});
</script>
