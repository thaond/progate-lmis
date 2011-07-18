<%@ include file="../../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

	function submit(url) {
		if (jQuery(".txt-search").val() == '<fmt:message key="title.keyword"/>') {
			jQuery(".txt-search").val('');
		}
		
		if (url == '' || url == null) {
			url = '<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString()%>" >
						<portlet:param name="action" value="commonController" />
					</portlet:actionURL>';
		}
		
		document.frmUser.action = url;
		document.frmUser.submit();
	}
	
	function pagingSubmit(url) {
		var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString()%>">
					</portlet:renderURL>';		
		
		submit(url);
	}
	
	function validate_and_submit(cmd) {
		if(jQuery("input[name='userId']:checked").length == 0) {
			alert('<fmt:message key="warning.user.none.choose"/>');
		}
		else {			
			var url = '';
			var answer = false;
			
			switch(cmd) {
				case 1:
					url = '<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>" />
							</portlet:actionURL>';
					
					answer = confirm('<fmt:message key="warning.user.delete.confirm"/>');
				break;
				case 2:
					url = '<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Constants.CMD%>" value="<%=RSConstants.TYPICAL_MEMBER%>" />
							</portlet:actionURL>';
							
					answer = confirm('<fmt:message key="warning.user.typical.choose.confirm"/>');
							
				break;
				case 3:
					url = '<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Constants.CMD%>" value="<%=RSConstants.NORMAL_MEMBER%>" />
							</portlet:actionURL>';
					
					answer = confirm('<fmt:message key="warning.user.typical.remove.confirm"/>');
				break;
				case 4:
					url = '<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Constants.CMD%>" value="<%=RSConstants.ENABLE%>" />
							</portlet:actionURL>';
					
					answer = confirm('<fmt:message key="warning.user.enable.confirm"/>');
				break;
				case 5:
					url = '<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Constants.CMD%>" value="<%=RSConstants.DISABLE%>" />
							</portlet:actionURL>';
					
					answer = confirm('<fmt:message key="warning.user.disable.confirm"/>');
				break;
				default:
					url = '<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Constants.CMD%>" value="<%=RSConstants.EXPORT_EXCEL%>" />
							</portlet:actionURL>';
					
					answer = confirm('<fmt:message key="warning.user.disable.confirm"/>');
			}
			
			if (answer) {
				submit(url);
			}			
		}
	}
	
	function search() {
		var url = '<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString()%>">
						<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.SEARCH%>" />
					</portlet:actionURL>';

		submit(url);
	}

	jQuery(function() {
		
		/*  Load warning message when form on load */
		if ( document.frmMsg.MsgTxt.value != '') {			
			if ( document.frmMsg.MsgTxt.value == 'warning.user.delete.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.user.delete.success" />');
				
			} else if ( document.frmMsg.MsgTxt.value == 'warning.user.typical.choose.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.user.typical.choose.success" />');
				
			} else if ( document.frmMsg.MsgTxt.value == 'warning.user.typical.remove.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.user.typical.remove.success" />');
				
			} else if ( document.frmMsg.MsgTxt.value == 'warning.user.enable.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.user.enable.success" />');
				
			} else if ( document.frmMsg.MsgTxt.value == 'warning.user.disable.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.user.disable.success" />');
				
			}
		}
		
		/* Handle save/delete */
		jQuery("#userAll").click(function(){
			if(jQuery(this).attr("checked") == true) {
				jQuery("input[name='userId']").attr("checked", true);
		    }
		    else{	    	
		    	jQuery("input[name='userId']").attr("checked", false);
		    }
		});
		
		jQuery('input[name="userId"]').click(function(){
			if(jQuery(this).attr("checked") == false) {
				jQuery("#userAll").attr("checked", false);
			}
		});
		
		jQuery(".tnt-bt-delete").click(function(){
			//validate_and_submit(1);
		});
		
		jQuery(".tnt-bt-typical-member").click(function(){
			validate_and_submit(2);
		});
		
		jQuery(".tnt-bt-normal-member").click(function(){
			validate_and_submit(3);
		});
		
		jQuery(".tnt-bt-enable").click(function(){
			validate_and_submit(4);
		});
		
		jQuery(".tnt-bt-disable").click(function(){
			validate_and_submit(5);
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
		
		jQuery("input[name='btApplyFilter']").click(function(){
			submit();
		});
		
		jQuery("body").click(function(){			
			jQuery(".tnt-action").css("display", "none");
		});
		
		jQuery(".tnt-show-actions").click(function(event){
			event.stopPropagation();
			jQuery(".tnt-action").css("display", "none");
			
			var left = 823 + Math.round((jQuery(window).width() - 960)/2) ;
			
			jQuery(this).parent().find(".tnt-action").css("left", left);
			jQuery(this).parent().find(".tnt-action").css("display", "block");
			
			event.preventDefault();
		});		
	});

</script>