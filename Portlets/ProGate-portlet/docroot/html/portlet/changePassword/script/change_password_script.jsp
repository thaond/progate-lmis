<%@page import="javax.portlet.WindowState"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	   
	function cancel(url) {
		window.location = url;
	}

	function validateChangePassword() {
		
		var valid = true;
		
		var oldPassword = jQuery("input[name='oldPassword']").val(); 		
		if (oldPassword == "") {			
			jQuery("#checkOldPassword").html('<fmt:message key="title.password.old.missing" />');
			valid = false;			
		} else {			
			jQuery("#checkOldPassword").html('');					
		}

		var newPassword = jQuery("input[name='newPassword']").val(); 		
		if (newPassword == "") {
			jQuery("#checkNewPassword").html(
					'<fmt:message key="title.password.new.missing" />');		
			valid = false;			
		} else if ((newPassword.length < 6) || (newPassword.length > 32)) {
			jQuery("#checkNewPassword").html(
					'<fmt:message key="title.password.new.length.invalid" />');			
			valid = false;			
		} else {			
			jQuery("#checkNewPassword").html('');					
		}

		var newPasswordAgain = jQuery("input[name='newPasswordAgain']").val(); 		
		if (newPasswordAgain == "") {		
			jQuery("#checkNewPasswordAgain").html(
					'<fmt:message key="title.password.new.again.missing" />');			
			valid = false;			
		}else if (newPassword != newPasswordAgain) {			
			jQuery("#checkNewPasswordAgain").html(
			      '<fmt:message key="title.password.new.notmatch" />');			
			valid = false;			
         } else {	        
			jQuery("#checkNewPasswordAgain").html('');						
		}
		
		if(valid==true){
			jQuery("#tnt-global-message").removeClass('tnt-global-error-message');
			jQuery("#tnt-global-message").removeClass('tnt-global-success-message');
			jQuery("#tnt-global-message span").html('');	
			jQuery("#checkOldPassword").html('');	
			jQuery("#checkNewPassword").html('');	
			jQuery("#checkNewPasswordAgain").html('');	
		}else{
			jQuery("#tnt-global-message").addClass('tnt-global-error-message');
			jQuery("#tnt-global-message span").html('<fmt:message key="title.changepassword.error"/>');
		}		
	    return valid;
	}

	function submitChangePassword() {				
        if(validateChangePassword()==true){        		    
        	var portletActionURL = 
				'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>">
					<portlet:param name="action" value="commonController" />
				</portlet:actionURL>';	
				
			document.frmChangePassword.action = portletActionURL;
		    document.frmChangePassword.submit();		    
        }
	}
	
	jQuery(document).ready(function(){	
							
			var isCorrectPassword =jQuery("input[name='isCorrectPassword']").val();
			var isChangePasswordSuccessful =jQuery("input[name='isChangePasswordSuccessful']").val();
								
			if(isCorrectPassword=='false'){			
				jQuery("#checkOldPassword").html('<fmt:message key="title.password.old.wrong"/>');
				jQuery("#tnt-global-message").removeClass('tnt-global-success-message');
				jQuery("#tnt-global-message").addClass('tnt-global-error-message');
				jQuery("#tnt-global-message span").html('<fmt:message key="title.changepassword.error"/>');
				
			}else if(isChangePasswordSuccessful=='true'){	
				jQuery("#tnt-global-message").removeClass('tnt-global-error-message');
				jQuery("#tnt-global-message").addClass('tnt-global-success-message');
				jQuery("#tnt-global-message span").html('<fmt:message key="title.changepassword.successful"/>');
				jQuery("#checkOldPassword").html('');	
				jQuery("#checkNewPassword").html('');	
				jQuery("#checkNewPasswordAgain").html('');				
				}
			
	});
</script>