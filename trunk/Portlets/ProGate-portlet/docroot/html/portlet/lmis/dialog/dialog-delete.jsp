<%@ include file="../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
jQuery(function(){
	var close = function() {
		jQuery("#deleteComfirm").dialog("close");
		}
	var yes = function(){
		var url = jQuery("#deleteComfirm").data('url');	
		jQuery.ajax({
			type:'POST',
			url:url,
			data:{
				"event":'Xoa',
			},
			success:function(){
				jQuery("#deleteComfirm").dialog("close");			
				jQuery("#message").css("display", "block");
		    	jQuery("#message").dialog("open");
			},
			error: function(){
				alert('Có lỗi xảy ra, cần báo cho Quản trị viên ProGate');
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
<jsp:include page="../dialog/dialog-message.jsp"></jsp:include>
<div id="deleteComfirm">
	<form name="frmDeleteComfirm" action="" method="post">
		<div class="messageConfirm"><img height="40" width="40" src="/ProGate-portlet/images/lmis/Warning.png">
			<label>Bạn có chắc muốn hủy đơn này không ? </label></div>
	</form>
</div>