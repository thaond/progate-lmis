<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../lmis/init-ttn.jsp" %>
<script type="text/javascript">
jQuery(function(){
	var dialogOpts = {
	    	title:'<fmt:message key="lmis.popupMessage.header" />',
	    	autoOpen: false,
		    modal: true,
		    closeOnEscape: false,
		    close:function dong() {
		    	var url = jQuery(".successful").data('url');
		    	document.listNV.action=url;
	    		document.listNV.submit();
		    },
		    overlay:{
		    	background:'#000000',
	    		opacity:'0.7'
		    },
		    buttons:{
		    	'<fmt:message key="button.close" />': function(){
		    		var url = jQuery(".successful").data('url');
		    		document.listNV.action=url;
		    		document.listNV.submit();
		    	}
		    },
		    resizable: false,
		    width: 280,
		    height: 130
	    };
	jQuery(".successful").dialog(dialogOpts);
});
</script>
<div class="successful" style="height: 220px; width: 200px; display:none; background:#FFF; z-index:51;">
	<div style="padding:10px 0 0 17px; position: relative; float: left; width: 25%">
		<img height="40" width="40" src="/ProGate-portlet/images/lmis/success.png">
	</div>
	<div id="workingTimeOK" style="font-weight: bold; margin:-23px 0 0 50px; position: relative; float: left; padding-left: 10px; width: 320px;">
		Bạn đã ủy quyền thành công!</div>
</div>
