/* Variables to validate */
var valid_organization_name = false;
var valid_organization_name_exist = true;
var valid_organization_abbre = true;
var valid_organization_state = false;
var valid_organization_address1 = false;	
var valid_organization_address2 = false;
var valid_expired_date = true;
var valid_organization_phone = true;
var valid_user_account = false;
var valid_user_password = false;
var valid_user_password_confirmation = false;
var valid_user_first_name = false;
var valid_user_last_name = false;
var valid_user_email = false
var valid_birthday = false;
var valid_organization_type = false;

/*
 * Function to check if this is number key
 */
function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode
	
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;
	
	return true;
}

/*
 * Function to check if this is decimal number
 */
function isDecimal(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode
	
	if (charCode == 46) {
		return true;
	}		
			
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;
	
	return true;
}

/*
 * Function to format Currency
 */
function formatCurrency(strValue)
{
	strValue = strValue.toString().replace(/\$|\,/g,'');
	dblValue = parseFloat(strValue);

	blnSign = (dblValue == (dblValue = Math.abs(dblValue)));
	dblValue = Math.floor(dblValue*100+0.50000000001);
	intCents = dblValue%100;
	strCents = intCents.toString();
	dblValue = Math.floor(dblValue/100).toString();
	if(intCents<10)
		strCents = "0" + strCents;
	for (var i = 0; i < Math.floor((dblValue.length-(1+i))/3); i++)
		dblValue = dblValue.substring(0,dblValue.length-(4*i+3))+','+
		dblValue.substring(dblValue.length-(4*i+3));
	return (((blnSign)?'':'-') + '$' + dblValue + '.' + strCents);
}


/*
 * Check no special characters
 */ 
function checkSpecialCharacters(data) {
	var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?~_`"; 
	   for (var i = 0; i < data.length; i++) {
	  	if (iChars.indexOf(data.charAt(i)) != -1) {
	  	  // alert ("Your string has special characters. \nThese are not
			// allowed.");
	  	return false;
	  	}
	  }
	return true;   
}


/*
 * Check the existence of organization
 */
function checkOrgExist(message_success, message_fail) {
	jQuery.ajax({
		type:"POST",
		data:"Org_Name="+jQuery('#organization_name').val(),
		url:"/Progate_ManageOrg-portlet/servlet/ValidateOrgServlet",
		success: function(data){										
			if(data == "inValid"){
				jQuery("#sp_org_name").text(message_fail);
				valid_organization_name_exist = false;
			}else {
				jQuery("#sp_org_name").text(message_success);			
				valid_organization_name_exist = true;
			}
		}
	});
}

/*
 * Function to check password strength
 */	
function checkPasswordStrength(input, message_strong, message_fair, message_weak) {
	// jQuery("#hint_password").css("display","none");
	// var input = jQuery(this).val();//jQuery('#user_password').val();
	var strongRegex = new RegExp("^(?=.*[^a-zA-Z0-9_])(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$", "g");
	var meter3Regex = new RegExp("^(((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9_]))|((?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_]))|((?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_]))).*$", "g");
	var enoughRegex = new RegExp("^(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[^a-zA-Z0-9_]))|((?=.*[A-Z])(?=.*[^a-zA-Z0-9_]))|((?=.*[0-9])(?=.*[^a-zA-Z0-9_]))).*", "g");		
    
	if (strongRegex.test(input)){
			jQuery('#meter1').css("background-color","lightgreen");
			jQuery('#meter2').css("background-color","lightgreen");
			jQuery('#meter3').css("background-color","lightgreen");
			jQuery('#meter4').css("background-color","lightgreen");
			jQuery('#sptxtPassword').text(message_strong);
	}else{
		if(meter3Regex.test(input)){
			jQuery('#meter1').css("background-color","lightgreen");
			jQuery('#meter2').css("background-color","lightgreen");
			jQuery('#meter3').css("background-color","lightgreen");
			jQuery('#meter4').css("background-color","white");
			jQuery('#sptxtPassword').text(message_fair);
		}else{
			if (enoughRegex.test(input)){
				jQuery('#meter1').css("background-color","lightgreen");
				jQuery('#meter2').css("background-color","lightgreen");
				jQuery('#meter3').css("background-color","white");
				jQuery('#meter4').css("background-color","white");
				jQuery('#sptxtPassword').text(message_weak);
				}
			else{
				jQuery('#meter1').css("background-color","lightgreen");
				jQuery('#meter2').css("background-color","white");
				jQuery('#meter3').css("background-color","white");
				jQuery('#meter4').css("background-color","white");
				jQuery('#sptxtPassword').text(message_weak);
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
