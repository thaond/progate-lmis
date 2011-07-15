
<div id="success" class='new-manage-org-success_message' style="display:none;">	 
	<img id="success_close" onmouseover="this.style.opacity=1;this.filters.alpha.opacity=100" 
		  onmouseout="this.style.opacity=0.4;this.filters.alpha.opacity=40" 
		  style="opacity:0.4;filter:alpha(opacity=40);float:right;" 
		  src="<%=request.getContextPath()%>/images/news_org/delete2.png" width="15" height="15" /> 
</div>

	

<script type="text/javascript">
	jQuery(document).ready(function(){			
		jQuery('#success_close').click(function(){
			jQuery("#success").css("display","none");
		});
	});
</script>
