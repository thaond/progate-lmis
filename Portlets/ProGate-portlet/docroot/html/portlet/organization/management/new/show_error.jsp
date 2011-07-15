<fmt:message key="repair.action" bundle="${msg}" var="repair" />

 <fmt:message key="error.action" bundle="${msg}" var="repairErrorMessage">
    <fmt:param value="${repair}"/> 
</fmt:message>



<div id="error" class='new-manage-org-warning_message' style="display:none;">
	   <span>${repairErrorMessage}</span>		
		
		<img id="error_close" onmouseover="this.style.opacity=1;this.filters.alpha.opacity=100" 
		  onmouseout="this.style.opacity=0.4;this.filters.alpha.opacity=40" 
		  style="opacity:0.4;filter:alpha(opacity=40);float:right;" 
		  src="<%=request.getContextPath()%>/images/news_org/delete2.png" width="15" height="15" />
</div>


<script type="text/javascript">
	jQuery(document).ready(function(){			
		jQuery('#error_close').click(function(){
			jQuery("#error").css("display","none");
		});
	});
</script>
