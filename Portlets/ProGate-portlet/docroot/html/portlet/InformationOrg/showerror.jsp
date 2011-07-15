


<%	if (request.getAttribute("MESSAGE_ERROR")!=null){%>
		<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("#error").css("display","block");
			});
		</script>
<%  } %>
<div id="error" class='warning_message' style="display:none;">
    <%=res.getString("repair.informationOrg.error")%>
	<img id="sucess_close" onmouseover="this.style.opacity=1;this.filters.alpha.opacity=100" onmouseout="this.style.opacity=0.4;this.filters.alpha.opacity=40" style="opacity:0.4;filter:alpha(opacity=40);float:right;" src="<%=request.getContextPath()%>/images/delete2.png" width="15" height="15" />
</div>
<script type="text/javascript">
	jQuery(document).ready(function(){			
		jQuery('img').click(function(){
			jQuery("#success").css("display","none");
		});
	});
</script>

