<%@ include file="../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
jQuery(function(){
	var href='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
				</portlet:renderURL>';
	
	var close = function(){			
		jQuery("#frmChangeWorkingTimeDetail").attr("action", href);			
		jQuery("#frmChangeWorkingTimeDetail").submit();

	}
	var dialogOpts = {
	    	title:'<fmt:message key="lmis.popupMessage.header" />',
	    	autoOpen: false,
		    modal: true,
		    closeOnEscape: false,
		    close:function() {
		    	//location.load = href;
		    	jQuery("#frmChangeWorkingTimeDetail").attr("action", href);			
				jQuery("#frmChangeWorkingTimeDetail").submit(); 
		    },
		    overlay:{
		    	background:'#000000',
	    		opacity:'0.7'
		    },
		    buttons:{
		    	'<fmt:message key="button.close" />': close
		    },
		    resizable: false,
		    width: 300,
		    height: 150
	    };
	jQuery("#message,#sendSuccess").dialog(dialogOpts);
});
</script>

<div id="message">
	<div style="padding:10px 0 0 17px"><img height="40" width="40" src="/ProGate-portlet/images/lmis/success.png">
		<div style="font-weight: bold;margin:-23px 0 0 50px">Bạn đã hủy đơn thành công</div>
	</div>
</div>

<div id="sendSuccess">
	<div style="padding:10px 0 0 17px"><img height="40" width="40" src="/ProGate-portlet/images/lmis/success.png">
		<div style="font-weight: bold;margin:-23px 0 0 50px">Bạn đã gửi đơn thành công</div>
	</div>
</div>







