<%@ include file="../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">

jQuery(function(){
	var dialogOpts = {
	    	title:'<fmt:message key="lmis.popupMessage.header" />',
	    	autoOpen: false,
		    modal: true,
		    closeOnEscape: false,
		    close:function dong() {
		    	var url = jQuery("#editSuccess").data('url');
				document.frmRequestOTDetail.action=url;
				document.frmRequestOTDetail.submit(); 
		    },
		    overlay:{
		    	background:'#000000',
	    		opacity:'0.7'
		    },
		    buttons:{
		    	'<fmt:message key="button.close" />': function(){
		    		var url = jQuery("#editSuccess").data('url');
		    		document.frmRequestOTDetail.action=url;
		    		document.frmRequestOTDetail.submit(); 
		    	}
		    },
		    resizable: false,
		    width: 300,
		    height: 150
	    };
	jQuery("#editSuccess").dialog(dialogOpts);
});
</script>

<div id="editSuccess">
	<div style="padding:10px 0 0 17px"><img height="40" width="40" src="/ProGate-portlet/images/lmis/success.png">
		<div style="font-weight: bold;margin:-23px 0 0 50px">Bạn đã cập nhật đơn tăng ca thành công</div>
	</div>
</div>








