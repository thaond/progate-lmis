
	<div  id="error" class="head_error" style="display:none;">
<%	if (request.getAttribute("MESSAGE_ERROR")!=null){%>
		<script type="text/javascript">
			jQuery(document).ready(function(){ 
				jQuery("#error").css("display","block");
				jQuery("#error").html('<font color="red"><%= request.getAttribute("MESSAGE_ERROR") %></font>');
			});
		</script>
	<% }%>
	</div>
