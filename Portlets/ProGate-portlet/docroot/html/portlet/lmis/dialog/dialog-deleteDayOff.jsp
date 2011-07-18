<%@ include file="../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
jQuery(function(){
	var close = function() {
		jQuery("#deleteComfirm").dialog("close");
		}
	var yes = function(){
		var url = jQuery("#deleteComfirm").data('url');	
		var href = jQuery("#deleteComfirm").data('href');
		jQuery.ajax({
			type:'POST',
			url:url,
			data:{
				"event":'Xoa',
			},
			success:function(){
				jQuery("#deleteComfirm").dialog("close");
				jQuery("#frmManagerDayOffInfo").attr("action", href);			
				jQuery("#frmManagerDayOffInfo").submit();
				/*jQuery("#message").css("display", "block");
		    	jQuery("#message").data('closeSuccess',closeSuccess).dialog("open");*/
				jQuery("#frmManagerDayOffDetail").attr("action", href);			
				jQuery("#frmManagerDayOffDetail").submit();
		    	
			}, 
			error: function(){
				alert('co loi xay ra tai ajax');
			}
		});
		//jQuery("form[name='frmDeleteComfirm']").attr("action", url);			
		//jQuery("form[name='frmDeleteComfirm']").submit();
	}
	var dialogOpts = {
	    	title:'Hủy Đơn',
	    	autoOpen: false,
		    modal: true,
		    overlay:{
		    	background:'#000000',
	    		opacity:'0.7'
		    },
		    buttons: {
		    	'<fmt:message key="button.yes" />':yes,
		    	'<fmt:message key="button.no" />': close
		    },
		    open: function(){
		    	jQuery('.ui-dialog-buttonpane').find('button:contains("<fmt:message key="button.yes" />")').css('width', '65px');
		    },	
		    resizable: false,
		    width: 350,
		    height: 150
	    };
	jQuery("#deleteComfirm").dialog(dialogOpts);
});
</script>

<div id="deleteComfirm">
	<form name="frmDeleteComfirm" action="" method="post">
		<div class="messageConfirm"><img height="40" width="40" src="/ProGate-portlet/images/lmis/Warning.png">
			<label>Bạn có chắc muốn hủy đơn này không ? </label></div>
	</form>
</div>