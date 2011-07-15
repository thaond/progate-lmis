<%@ include file="../../../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	
	function submit(url) {
		if (jQuery(".txt-search").val() == '<fmt:message key="title.keyword"/>') {
			jQuery(".txt-search").val('');
		}
		
		if (url == '' || url == null) {
			var url = '<portlet:renderURL>
						    <portlet:param name="action" value="commonController" />
						</portlet:renderURL>';
		}
		
		document.frmUser.action = url;
		document.frmUser.submit();
	}

	jQuery(function() {
		/*  Load warning message when form on load */
		//document.frmMsg.msgStatus.value
		var smgStatusVal = jQuery("#msgStatus").val();
		if ( smgStatusVal != 0) {
			if ( smgStatusVal == 1 ) {				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text(jQuery("#successMsg").val());				
			} else {
				jQuery("#tnt-global-message").removeClass("tnt-global-success-message");
				jQuery("#tnt-global-message").addClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text(jQuery("#failMsg").val());
			}
		}
		
		/* Handle checkbox */
		jQuery(".cbkSelectAll").click(function(){
			if(jQuery(this).attr("checked") == true) {
				jQuery(".cbkChild").attr("checked",true);
		    }
		    else {
		    	jQuery(".cbkChild").attr("checked",false);
		    }
		});
		
		jQuery(".cbkChild").click(function(){
			if(jQuery(this).attr("checked") == false) {
				jQuery(".cbkSelectAll").attr("checked", false);
			}
		});
		
		jQuery("#selectedOrgId").change(function(){
			submit();
		});
		
		/* Handle search */
		jQuery(".txt-search").focus();
		jQuery(".txt-search").focus(function(){
			if (jQuery(this).val() == '<fmt:message key="title.keyword"/>') {
				jQuery(this).val('');
			}
		});
		jQuery(".txt-search").blur(function(){
			if (jQuery(this).val() == "") {
				jQuery(this).val('<fmt:message key="title.keyword"/>');
			}
		});
		
		jQuery(".txt-search").bind('keydown', function(e){
	        if (e.which == 13) {
	        	search();
	        }
	    });
		
		jQuery(".tnt-bt-search").click(function(){
			search();
		});
		
		jQuery("input[name='btApplyFilter']").click(function(){
			applyFilter();
		});
		
		jQuery("body").click(function(){
			jQuery(".tnt-action").css("display", "none");
		});
		
		jQuery(".tnt-show-actions").click(function(event){
			event.stopPropagation();
			jQuery(".tnt-action").css("display", "none");
			
			var left = 833 + Math.round((jQuery(window).width() - 960)/2) ;
			
			jQuery(this).parent().find(".tnt-action").css("left", left);
			jQuery(this).parent().find(".tnt-action").css("display", "block");
			
			event.preventDefault();
		});
	});
</script>