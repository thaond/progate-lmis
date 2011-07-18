


	// Show message when form on load
	window.onload = function () {
	if (document.frmMsg.MsgTxt.value != '')
    {			
		var ok = jAlert('<%=res.getString("message_create_org_successful")%>', 
			'<%=res.getString("org_management")%>');
		
		jQuery("#popup_ok").click(function(){
			var portletActionURL = '<portlet:actionURL><portlet:param name="struts_action" value="/org_management/org_management"></portlet:param></portlet:actionURL>';
			document.frmOrgNew.action = portletActionURL;
	        document.frmOrgNew.submit();
		});			
    }
    document.frmMsg.MsgTxt.value = '';
	}
	
	// Allow only number in Textbox
	function onlyNumbers(evt)
	{
		var e = event || evt; // for trans-browser compatibility
		var charCode = e.which || e.keyCode;
				
		if (charCode > 31 && (charCode < 48 || charCode > 57)) {
			return false;
		}
		return true;

	}
	
	// Variables to validate
	var valid_organization_name = false;
	var valid_organization_abbre = true;
	var valid_organization_state = false;
	var valid_organization_address1 = false;	
	var valid_user_account = false;
	var valid_user_password = false;
	var valid_user_password_confirmation = false;
	var valid_user_first_name = false;
	var valid_user_last_name = false;
	var valid_user_email = false
	var valid_expired_date = true;
	var valid_organization_phone = true;
	var valid_birthday = false;
	
	
	// Perform from submit
	function submit() {
		if ( valid_organization_name == true &&
			 valid_organization_abbre == true &&
			 valid_organization_state == true &&
			 valid_organization_address1 == true &&	
			 valid_user_account == true &&
			 valid_user_password == true &&
			 valid_user_password_confirmation == true &&
			 valid_user_first_name == true &&
			 valid_user_last_name == true &&
			 valid_user_email == true && 
			 valid_expired_date == true &&
			 valid_birthday == true) {
			//jQuery("#organization_submit").removeAttr('disabled');
			var portletActionURL = '<portlet:actionURL><portlet:param name="struts_action" value="/org_management/org_management"/><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" /></portlet:actionURL>';
			
			document.frmOrgNew.action = portletActionURL;
	        document.frmOrgNew.submit();
		} else {
			//jQuery("#organization_submit").attr('disabled', 'disabled');
		}
	}
	
	function validate_and_submit() {
		// Validate organization name
		var org_name_val = jQuery.trim(jQuery("#organization_name").val());
		var noSpecialCharacters = /^[a-z0-9\_]+$/i;
		if(org_name_val == "") {
			jQuery("#sp_org_name").text('<%=res.getString("message_require_input_information")%>');			
			valid_organization_name = false;
		} else {
			if (org_name_val.length < 6) {
				jQuery("#sp_org_name").text('<%=res.getString("message_require_name_length_minimum")%>');
				valid_organization_name = false;
			} else if (!noSpecialCharacters.test(org_name_val)) {
				jQuery("#sp_org_name").text('<%=res.getString("message_require_name_no_special_characters")%>');
				valid_organization_name = false;
			} else {
				jQuery("#sp_org_name").text('');
				valid_organization_name = true;
			}
		}
		
		// Validate organization abbreviation
		var org_abbre_val = jQuery.trim(jQuery("#organization_abbreviation").val());		
		if (!noSpecialCharacters.test(org_abbre_val) && org_abbre_val != "") {
			jQuery("#sp_org_abbre").text('<%=res.getString("message_require_name_no_special_characters")%>');
			valid_organization_abbre = false;
		}
		
		// Validate organization state/city
		if(jQuery("#organization_state").val() == "") {
			jQuery("#sp_city").text('<%=res.getString("message_require_input_information")%>');
			
			valid_organization_state = false;
			
		} else {
			jQuery("#sp_city").text('');
			valid_organization_state = true;
			
		}
		
		
		// Validate organization address
		if(jQuery("#organization_address1").val() == "") {
			jQuery("#sp_address1").text('<%=res.getString("message_require_input_information")%>');			
			valid_organization_address1 = false;
			
		} else {
			jQuery("#sp_address1").text('');
			valid_organization_address1 = true;
			
		}	
		
		// Validate organization phone
		if(jQuery("#organization_phone").val() != "") {
		
			var phone_number = jQuery.trim(jQuery("#organization_phone").val());
			var integer = /^\d+$/;
			if (!integer.test(phone_number)) {
				jQuery("#sp_phone").text('<%=res.getString("message_invalid_phone")%>');				
				valid_organization_phone = false;
			}  else {
				jQuery("#sp_phone").text('');
				valid_organization_phone = true;			
			}
		}	
		
		// Validate user account
		if(jQuery("#user_account").val() == "") {
			jQuery("#account_validity").text('<%=res.getString("message_require_input_information")%>');
			
			valid_user_account = false;
			
		} else {
			jQuery("#account_validity").text('');
			valid_user_account = true;
			
		}
		
		// Validate password
		var user_password_val = jQuery("#user_password").val();
		if(user_password_val == "") {
			jQuery("#pass_msg").text('<%=res.getString("message_require_input_information")%>');			
			valid_user_password = false;
			
		} else {
			if (user_password_val.length < 6) {
				jQuery("#pass_msg").text('<%=res.getString("message_require_password_length_minimum")%>');			
				valid_user_password = false;	
			}
			else {
				jQuery("#pass_msg").text('');
				valid_user_password = true;
			}
		}
	
		if(jQuery("#user_password_confirmation").val() == "") {
			jQuery("#confirmed_pass_msg").text('<%=res.getString("message_require_input_information")%>');
			
			valid_user_password_confirmation = false;
			
		} else {
			if (jQuery("#user_password_confirmation").val() != jQuery("#user_password").val()) {
				jQuery("#confirmed_pass_msg").text('<%=res.getString("message_password_not_match")%>');
				
				valid_user_password_confirmation = false;
				
			} else {
				jQuery("#confirmed_pass_msg").text('');
				valid_user_password_confirmation = true;
				
			}
		}
		
		// Validate user name
		if(jQuery("#user_first_name").val() == "") {
			jQuery("#fname_msg").text('<%=res.getString("message_require_input_information")%>');
			
			valid_user_first_name = false;
			
		} else {
			jQuery("#fname_msg").text('');
			valid_user_first_name = true;
			
		}
	
		if(jQuery("#user_last_name").val() == "") {
			jQuery("#lname_msg").text('<%=res.getString("message_require_input_information")%>');
			
			valid_user_last_name = false;				
		} else {
			jQuery("#lname_msg").text('');
			valid_user_last_name = true;				
		}
		
		// Validate email
		if(jQuery("#user_email").val() == "") {
			jQuery("#mail_validity").text('<%=res.getString("message_require_input_information")%>');
			
			valid_user_email = false;			
		} else {
			var filter = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/;		
			if (!filter.test(jQuery("#user_email").val())) {			
				jQuery("#mail_validity").text('<%=res.getString("message_invalid_email")%>');
				valid_user_email = false;
			
			} else {
				jQuery("#mail_validity").text('');
				valid_user_email = true;				
			}
		}
		
		// Validate expired date -- Should use help library
		var sExpireDate = jQuery("#dum_expired_on").val();
		if(sExpireDate != "") {
			var dt1  = sExpireDate.substring(0,2);
	        var mon1 = sExpireDate.substring(3,5);
	        var yr1  = sExpireDate.substring(6,10);
	        var today = new Date();
	        temp1 = dt1 +"/"+ mon1 +"/"+ yr1;
	        var cfd = Date.parse(temp1);
	       	
	        var expiredDate = new Date(cfd); 
	        var sToday = new Date();

	        if (expiredDate < sToday) {
	        	jQuery("#sp_expiration_date").text('<%=res.getString("message_expired_day_larger_now")%>');	
				valid_expired_date = false;	        	
			} else {
				jQuery("#sp_expiration_date").text('');	
				valid_expired_date = true;				
			}			
		}
		
		// Validate birthday
		var day = jQuery("#day").val();
		var month = jQuery("#month").val();
		var year = jQuery("#year").val();
		
		if (day == "None" || month == "None" || year == "None") {
			jQuery("#sp_birthday").text('<%=res.getString("message_require_birthday")%>');
			valid_birthday = false;
		} else {
			jQuery("#sp_birthday").text('');
			valid_birthday = true;
		}
		
		submit();
	}
	
	jQuery(function(){
		
		// Calendar
		var pickerOpts = {
				showOn: "both",
				buttonImage: "/Progate_ManageOrg-portlet/images/calendar.gif",
				buttonText: "Open datepicker",
				buttonImageOnly: true,
				dateFormat:"dd/mm/yy"
		    };
		    
		jQuery("#dum_expired_on").datepicker(pickerOpts);
		// End Calendar
		
		// Show help password
		var close = function() {
			jQuery("#password-help").dialog("close");
	    }
	    var dialogOpts = {
	    	title: '<%=res.getString("help")%>',
		    autoOpen: false,
		    modal: true,
		    buttons: {		        
		        '<%=res.getString("close")%>': close
		    },		    
		    width: 600,
		    height: 400
	    };
	    
	    jQuery("#password-help").dialog(dialogOpts);
	    //jQuery("#help").click(function(){
	    	//jQuery("#password-help").dialog("open");
	    	//jQuery("#password-help").width(575);
	    //});	    
	 	// End Show help password
	    
	    // Foucs to textbox Organization Name
	 	jQuery("#organization_name").focus();
	    // End Foucs to textbox Organization Name
	    
		// Event when click submit
		jQuery("#organization_submit").click(function(e){
			validate_and_submit();
	        e.preventDefault();
		});

		jQuery("#cancel").click(function(e){
			var portletActionURL = '<portlet:renderURL><portlet:param name="struts_action" value="/org_management/org_management"></portlet:param></portlet:renderURL>';
			document.frmOrgNew.action = portletActionURL;
	        document.frmOrgNew.submit();

	        e.preventDefault();
		});

		// For key up password
		jQuery('#user_password').keyup(function() {
			var input = jQuery(this).val();
			checkPasswordStrength(input);
	    });
	});
	
	function checkPasswordStrength(input) {
		//jQuery("#hint_password").css("display","none");
		//var input = jQuery(this).val();//jQuery('#user_password').val();
		var strongRegex = new RegExp("^(?=.*[^a-zA-Z0-9_])(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$", "g");
		var meter3Regex = new RegExp("^(((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9_]))|((?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_]))|((?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_]))).*$", "g");
		var enoughRegex = new RegExp("^(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[^a-zA-Z0-9_]))|((?=.*[A-Z])(?=.*[^a-zA-Z0-9_]))|((?=.*[0-9])(?=.*[^a-zA-Z0-9_]))).*", "g");		
	    
		if (strongRegex.test(input)){
				jQuery('#meter1').css("background-color","lightgreen");
				jQuery('#meter2').css("background-color","lightgreen");
				jQuery('#meter3').css("background-color","lightgreen");
				jQuery('#meter4').css("background-color","lightgreen");
				jQuery('#sptxtPassword').text('<%=res.getString("message_strong")%>');
		}else{
			if(meter3Regex.test(input)){
				jQuery('#meter1').css("background-color","lightgreen");
				jQuery('#meter2').css("background-color","lightgreen");
				jQuery('#meter3').css("background-color","lightgreen");
				jQuery('#meter4').css("background-color","white");
				jQuery('#sptxtPassword').text('<%=res.getString("message_fair")%>');
			}else{
				if (enoughRegex.test(input)){
					jQuery('#meter1').css("background-color","lightgreen");
					jQuery('#meter2').css("background-color","lightgreen");
					jQuery('#meter3').css("background-color","white");
					jQuery('#meter4').css("background-color","white");
					jQuery('#sptxtPassword').text('<%=res.getString("message_weak")%>');
					}
				else{
					jQuery('#meter1').css("background-color","lightgreen");
					jQuery('#meter2').css("background-color","white");
					jQuery('#meter3').css("background-color","white");
					jQuery('#meter4').css("background-color","white");
					jQuery('#sptxtPassword').text('<%=res.getString("message_weak")%>');
				}
			}
		}

		if(input == ""){
			jQuery('#meter1').css("background-color","white");
			jQuery('#meter2').css("background-color","white");
			jQuery('#meter3').css("background-color","white");
			jQuery('#meter4').css("background-color","white");	
		}
	}

