<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.larion.progate.organization.management.business.OrgMaxNoOfUser"%>
<%@page import="com.larion.progate.organization.management.business.OrgCity"%>
<%@ page import="larion.progate.service.ProGateOrgTypeLocalServiceUtil"%>
<%@ page import="larion.progate.model.ProGateOrgType"%>

<%@ page import="java.util.*" %>
<%
	// Get Viet Nam province/city
	OrgCity orgCity = new OrgCity();
	List<OrgCity> orgCities = orgCity.getOrgCities();
	
	// Get Organization Type
	//OrgType orgType = new OrgType();
	//List<OrgType> orgTypes = orgType.getOrgTypes();
	
	// Get max_no_of_users
	OrgMaxNoOfUser orgMaxNoOfUser = new OrgMaxNoOfUser();
	List<OrgMaxNoOfUser> orgMaxNoOfUsers = orgMaxNoOfUser.getOrgMaxNoOfUsers();
	
	List<ProGateOrgType> a = ProGateOrgTypeLocalServiceUtil.getProGateOrgTypes(0, 100); 
		
	for (ProGateOrgType proGateOrgType : a) {
		System.out.println(proGateOrgType.getName());
	}
	
	request.setAttribute("orgCities", orgCities);
	
	//request.setAttribute("orgTypes", orgTypes);
	
	request.setAttribute("orgMaxNoOfUsers", orgMaxNoOfUsers);
%>

<style type="text/css">

table {
 border-collapse: separate;
 border-spacing: 1px;
}
</style>

<script type="text/javascript">

	/*
	 * Show error when organization exist
	 */
	window.onload = function () {
		if (document.frmMsg.MsgTxt.value == 'org.error.orgName.exist')
	    {
			//jQuery("#sp_org_name").text('<fmt:message key="org.error.orgName.exist" />');
			//valid_organization_name_exist = false;
	    }
	    document.frmMsg.MsgTxt.value = '';
	}

	/*
	 * Perform form submit
	 */	
	function submit() {
		if ( valid_organization_name == true &&
			 valid_organization_name_exist == true &&	
			 valid_organization_abbre == true &&
			 valid_organization_state == true &&
			 valid_organization_address1 == true &&	
			 valid_organization_address2 == true &&
			 valid_user_account == true &&
			 valid_user_password == true &&
			 valid_user_password_confirmation == true &&
			 valid_user_first_name == true &&
			 valid_user_last_name == true &&
			 valid_user_email == true && 
			 valid_expired_date == true &&
			 valid_organization_type == true &&
			 valid_birthday == true) {
			//jQuery("#organization_submit").removeAttr('disabled');
			var portletActionURL = 
				'<portlet:actionURL>
					<portlet:param name="struts_action" value="/organization_management/org_management"/>
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
				</portlet:actionURL>';
			
			document.frmOrgNew.action = portletActionURL;
	        document.frmOrgNew.submit();
		} else {
			//jQuery("#organization_submit").attr('disabled', 'disabled');
		}
	}
	
	function validate_and_submit() {
		// Validate organization name
		var org_name_val = jQuery.trim(jQuery("#organization_name").val());		
		
		// Validate organization name
			var org_name_val = jQuery.trim(jQuery("#organization_name").val());			
			if(org_name_val == "") {
				jQuery("#sp_org_name").text('<fmt:message key="message_require_input_information"/>');			
				valid_organization_name = false;
			} else {
				if (org_name_val.length < 6) {
					jQuery("#sp_org_name").text('<fmt:message key="message_require_name_length_minimum"/>');
					valid_organization_name = false;
				} else if (!checkSpecialCharacters(org_name_val)) {
					jQuery("#sp_org_name").text('<fmt:message key="message_require_name_no_special_characters"/>');
					valid_organization_name = false;
				} else {
					jQuery("#sp_org_name").text('');
					valid_organization_name = true;
					var message_fail = '<fmt:message key="org.error.orgName.exist"/>';
			 		var message_success = '';
			 		checkOrgExist(message_success, message_fail);
				}
			}	 		
		
		// Validate organization abbreviation
		var org_abbre_val = jQuery.trim(jQuery("#organization_abbreviation").val());		
		if (!checkSpecialCharacters(org_abbre_val) && org_abbre_val != "") {
			jQuery("#sp_org_abbre").text('<fmt:message key="message_require_name_no_special_characters"/>');
			valid_organization_abbre = false;
		}else{
			jQuery("#sp_org_abbre").text('');
			valid_organization_abbre = true;
		}
		
		// Validate organization province/city
		var org_state_val = jQuery("#organization_state").val();
		if(org_state_val == "" || org_state_val == "0") {
			jQuery("#sp_city").text('<fmt:message key="message_require_input_information"/>');
			valid_organization_state = false;			
		} else {
			jQuery("#sp_city").text('');
			valid_organization_state = true;
		}		
		
		// Validate organization type		
		var org_stype_val = jQuery("#organization_org_type").val();
		if(org_stype_val == "" || org_stype_val == "0"){
			jQuery("#sp_org_type").text('<fmt:message key="message_require_input_information"/>');
			valid_organization_type = false;	
		}else{
			jQuery("#sp_org_type").text('');
			valid_organization_type = true;
		}
		
		// Validate organization address1
		var org_address1 = jQuery("#organization_address1").val();
		if(org_address1 == "") {
			jQuery("#sp_address1").text('<fmt:message key="message_require_input_information"/>');			
			valid_organization_address1 = false;			
		}else if(!checkAddress(org_address1)){
			jQuery("#sp_address1").text('<fmt:message key="message_require_address_no_special_characters"/>');			
			valid_organization_address1 = false;
		}else {
			jQuery("#sp_address1").text('');
			valid_organization_address1 = true;	
		}
		
		// Validate organization address2
		var org_address2 = jQuery("#organization_address2").val();
		if(!checkAddress(org_address2)){
			jQuery("#sp_address2").text('<fmt:message key="message_require_address_no_special_characters"/>');			
			valid_organization_address2 = false;
		}else {
			jQuery("#sp_address2").text('');
			valid_organization_address2 = true;	
		}
		
		// Validate organization phone
		if(jQuery("#organization_phone").val() != "") {
		
			var phone_number = jQuery.trim(jQuery("#organization_phone").val());
			var integer = /^\d+$/;
			if (!integer.test(phone_number)) {
				jQuery("#sp_phone").text('<fmt:message key="message_invalid_phone"/>');				
				valid_organization_phone = false;
			}  else {
				jQuery("#sp_phone").text('');
				valid_organization_phone = true;			
			}
		}	
		
		// Validate user account
		var user_account = jQuery("#user_account").val();
		if(user_account == "") {
			jQuery("#account_validity").text('<fmt:message key="message_require_input_information"/>');			
			valid_user_account = false;			
		}else if(!checkSpecialCharacters(user_account)){
			jQuery("#account_validity").text('<fmt:message key="message_require_username_no_special_characters"/>');			
			valid_user_account = false;	
		}else {
			jQuery("#account_validity").text('');
			valid_user_account = true;			
		}
		
		// Validate password
		var user_password_val = jQuery("#user_password").val();
		if(user_password_val == "") {
			jQuery("#pass_msg").text('<fmt:message key="message_require_input_information"/>');			
			valid_user_password = false;			
		} else {
			if (user_password_val.length < 6) {
				jQuery("#pass_msg").text('<fmt:message key="message_require_password_length_minimum"/>');			
				valid_user_password = false;	
			}
			else {
				jQuery("#pass_msg").text('');
				valid_user_password = true;
			}
		}
	
		if(jQuery("#user_password_confirmation").val() == "") {
			jQuery("#confirmed_pass_msg").text('<fmt:message key="message_require_input_information"/>');			
			valid_user_password_confirmation = false;			
		} else {
			if (jQuery("#user_password_confirmation").val() != jQuery("#user_password").val()) {
				jQuery("#confirmed_pass_msg").text('<fmt:message key="message_password_not_match"/>');				
				valid_user_password_confirmation = false;				
			} else {
				jQuery("#confirmed_pass_msg").text('');
				valid_user_password_confirmation = true;				
			}
		}
		
		// Validate user first name
		var user_first_name = jQuery("#user_first_name").val();
		if(user_first_name == "") {
			jQuery("#fname_msg").text('<fmt:message key="message_require_input_information"/>');			
			valid_user_first_name = false;			
		}else if(!checkSpecialCharacters(user_first_name)){
			jQuery("#fname_msg").text('<fmt:message key="message_require_firstname_no_special_characters"/>');			
			valid_user_first_name = false;
		}else {
			jQuery("#fname_msg").text('');
			valid_user_first_name = true;			
		}
	
	    // Validate user last name
	    var user_last_name = jQuery("#user_last_name").val();
		if(user_last_name == "") {
			jQuery("#lname_msg").text('<fmt:message key="message_require_input_information"/>');			
			valid_user_last_name = false;				
		}else if(!checkSpecialCharacters(user_last_name)){
			jQuery("#lname_msg").text('<fmt:message key="message_require_username_no_special_characters"/>');			
			valid_user_last_name = false;	
		}else {
			jQuery("#lname_msg").text('');
			valid_user_last_name = true;				
		}
		
		// Validate email
		var user_email = jQuery("#user_email").val();
		if(user_email == "") {
			jQuery("#mail_validity").text('<fmt:message key="message_require_input_information"/>');			
			valid_user_email = false;			
		}else {
		    if (checkEmail(user_email)){
		    	jQuery("#mail_validity").text('');
				valid_user_email = true;	
		    }else{
		    	jQuery("#mail_validity").text('<fmt:message key="message_invalid_email"/>');
				valid_user_email = false;
		    }
		}
		
		
		// Validate Expired Date
		checkExpiredDate();
		//end
		
		// Validate birthday		
		var birthday_user = jQuery("#user_date").val();
		if (birthday_user == "")
		{
			jQuery("#sp_birthday").text('<fmt:message key="message_require_birthday"/>');
			valid_birthday = false;
		}else {
			if (checkDate(birthday_user)){
				jQuery("#sp_birthday").text('');
			    valid_birthday = true;
			}else{				
				jQuery("#sp_birthday").text('<fmt:message key="message_validate_birthday"/>');
				valid_birthday = false;
			}				
		}
		submit();
	}
	
	/*
	 * jQuery ready
	 */
	jQuery(function(){
		jQuery(".portlet-borderless-bar").html('');
		// Calendar
		var pickerOpts = {
				showOn: "both",
				yearRange: "-0:+20",
				buttonImage: "<%=request.getContextPath() %>/images/calendar.gif",
				buttonText: "Open datepicker",
				buttonImageOnly: true,
				dateFormat:"dd/mm/yy",
				onClose: function() {
					document.getElementById("dum_expired_on").focus();
			    }
		    };
		    
		var birthdayOpts = {												        
				yearRange: "-80:+0",
				showOn: "both",
				buttonImage: "<%=request.getContextPath() %>/images/calendar.gif",
				buttonText: "Open datepicker",
				buttonImageOnly: true,
				dateFormat:"dd/mm/yy",
				onClose: function() {
					document.getElementById("user_date").focus();
			    }
		    };
		    
		jQuery("#dum_expired_on").datepicker(pickerOpts); 
		jQuery("#user_date").datepicker(birthdayOpts);
		
		// End Calendar
		
		// Show help password
		var close = function() {
			jQuery("#password-help").dialog("close");
	    }
	    var dialogOpts = {
	    	title:'<fmt:message key="help"/>',
	    	autoOpen: false,
		    modal: true,
		    buttons: {		        
		        '<fmt:message key="close"/>': close
		    },
		    resizable: false,
		    width:588,
		    height: 400
	    };
	    
	    jQuery("#password-help").dialog(dialogOpts);
	    jQuery("#help").click(function(){	    	
	    	jQuery("#password-help").css("display","block");
	    	jQuery("#password-help").dialog("open");
	    	//jQuery("#password-help").width(575);
	    });	    
	 	// End Show help password
	    
	    // Handle textbox Organization Name
	 	jQuery("#organization_name").focus();
	 	jQuery("#organization_name").blur(function(){
	 		// Validate organization name
			var org_name_val = jQuery.trim(jQuery("#organization_name").val());			
			if(org_name_val == "") {
				jQuery("#sp_org_name").text('<fmt:message key="message_require_input_information"/>');			
				valid_organization_name = false;
			} else {
				if (org_name_val.length < 6) {
					jQuery("#sp_org_name").text('<fmt:message key="message_require_name_length_minimum"/>');
					valid_organization_name = false;
				} else if (!checkSpecialCharacters(org_name_val)) {
					jQuery("#sp_org_name").text('<fmt:message key="message_require_name_no_special_characters"/>');
					valid_organization_name = false;
				} else {
					jQuery("#sp_org_name").text('');
					valid_organization_name = true;
					var message_fail = '<fmt:message key="org.error.orgName.exist"/>';
			 		var message_success = '';
			 		checkOrgExist(message_success, message_fail);
				}
			}	 		
	 	});
	 	// End 
	 	
		// Event when click submit
		jQuery("#organization_submit").click(function(e){
			validate_and_submit();
	        e.preventDefault();
		});

		jQuery("#cancel").click(function(e){
			var portletActionURL = 
				'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString()%>">
	               	<portlet:param name="struts_action" value="" />         
	             </portlet:actionURL>';
			document.frmOrgNew.action = portletActionURL;
	        document.frmOrgNew.submit();

	        e.preventDefault();
		});

		// For key up password
		jQuery('#user_password').keyup(function() {
			var input = jQuery(this).val();
			var message_strong = '<fmt:message key="message_strong"/>';
			var message_fair = '<fmt:message key="message_fair"/>';
			var message_weak = '<fmt:message key="message_weak"/>';
			checkPasswordStrength(input, message_strong, message_fair, message_weak);
	    });
	});
</script>

<form name="frmOrgNew" method="post" action="">
<%@ include file="password_help.jsp" %>
<div class="innertube" style="padding-top: 5px;">
<table class="border-table" style="margin-top: 1px;border-collapse: separate; " width="100%" 
	cellpadding="0" cellspacing="0">
<tbody>
	<tr>
	<td>
	<table class="tbl-user-mng-menu" width="100%" style="border-spacing: 0px;">
	<tbody>
	<tr>		
		<td class="title-user-mng tbl-top-dot" width="50%"><fmt:message key="title_create_org" /></td>
		<td class="title-user-mng tbl-top-dot"></td>
	</tr>
	</tbody>
	</table>
	</td>
	</tr>
	
	<TR>
	<TD>					
		<TABLE cellSpacing="0" cellPadding="0" width="100%">
		<TBODY>
			<TR>
			<TD class="td-error-org" colSpan="2"></TD>
			</TR>
			
			<TR class="note">
				<TD class="td-note-org"><fmt:message key="message_require_fields"/></TD>
				
				<td align="left" class="td-name" style="color: black;font-weight: bold;">
					<fmt:message key="title_administrator_information"/>
				</td>
			</TR>			
		
			<TR>
			<!--Left table for organization information -->
			
			<TD class="td-content-edit" vAlign="top" width="50%">
			<TABLE cellSpacing="1" cellPadding="0" width="98%">
			<TBODY>
				<TR class="tbl-content-row-1">
					<TD width="30%">
					<LABEL class="label-field" for="organization_name">
						<fmt:message key="organization_name"/> (<span style="color: red">*</span>)</LABEL>
					</TD>
					
					<TD>
						<INPUT id="organization_name" size="70" maxlength="70" class="txt-field"
							tabIndex="1" value='<c:out value="${org.name}"/>'
							type="text" name="<%=Request.ORG_NAME %>" />
						<SPAN id="sp_org_name" class="sp_"></SPAN>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_org_type">
						<fmt:message key="org_type"/>(<span style="color: red">*</span>)</LABEL>
					</TD>
					
					<TD>
					<SELECT id="organization_org_type" class="select-field width_select"
						tabIndex="2" name="<%=Request.ORG_TYPE %>">
						<option value="0">	Vui lòng chọn 	</option>
						
						<% 
							List<ProGateOrgType> orgTypes = ProGateOrgTypeLocalServiceUtil.getProGateOrgTypes(0, 100); 
		
							for (ProGateOrgType proGateOrgType : orgTypes) {
						%>
						
						<option value="<%=proGateOrgType.getName()%>">	
							<%=proGateOrgType.getName()%> 	
						</option>
						
						<%	} %>					
					</SELECT>
					<SPAN id="sp_org_type" class="sp_"></SPAN>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_abbreviation">
						<fmt:message key="organization_abbreviation"/></LABEL>
					</TD>
					
					<TD>
						<INPUT id="organization_abbreviation" class="txt-field" tabIndex="3"
							value='<c:out value="${org.abbreviation}"/>' maxLength="6" size="6" type="text"
							name="<%=Request.ORG_ABBREVIATION %>"> 
						<SPAN id="sp_org_abbre" class="sp_"></SPAN>
					</TD>
				</TR>

				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_description">
						<fmt:message key="organization_description"/></LABEL>
					</TD>
					
					<TD>
						<INPUT id="organization_description" class="txt-field" tabIndex="4"
							value='<c:out value="${org.description}"/>' maxLength="255" 
							type="text" name="<%=Request.ORG_DESCRIPTION %>"/> 
						<SPAN id="sp_org_desc" class="sp_"></SPAN>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_country">
						<fmt:message key="country"/> (<span style="color: red">*</span>)
					</LABEL>
					</TD>
					
					<TD>
					<INPUT id="organization_country" class="txt-field" tabIndex="5"
							value="Việt Nam" type="text" name="<%=Request.ORG_COUNTRY %>"
							readonly="readonly"/> 
					</TD>
				</TR>

				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_state">
						<fmt:message key="state_province"/> (<span style="color: red">*</span>)
					</LABEL>
					</TD>
					
					<TD>
						<select id="organization_state" tabIndex="6" 
							name="<%=Request.ORG_CITY %>" class="select-field width_select">
						<c:forEach items="${orgCities}" var="orgCity" varStatus="count">
						<c:choose>
						<c:when test="${orgCity.orgCityValue == orgCityCurrent}">
							<option value="${orgCity.orgCityValue}" selected="selected">
								<fmt:message key="${orgCity.orgCityName}"/> 
							</option>
						</c:when>
						<c:otherwise>
							<option value="${orgCity.orgCityValue}">
								<fmt:message key="${orgCity.orgCityName}"/> 
							</option>
						</c:otherwise>
						</c:choose>
						</c:forEach>					
						</select> 
						<SPAN id="sp_city" class="sp_"></SPAN>
					</TD>
				</TR>
								
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class=label-field for="organization_address1">
						<fmt:message key="address_line_1"/> (<span style="color: red">*</span>)
					</LABEL>
					</TD>
					
					<TD>
						<INPUT id="organization_address1" class="txt-field" tabIndex="7" 
							value='<c:out value="${org.address1}"/>' 
							maxLength="100" type="text" 
							name="<%=Request.ORG_ADDRESS_1 %>"/>
						<SPAN id="sp_address1" class="sp_"></SPAN>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class=label-field for="organization_address2">
						<fmt:message key="address_line_2"/> </LABEL>
					</TD>
					
					<TD>
						<INPUT id="organization_address2" class="txt-field" tabIndex="8" 
							value='<c:out value="${org.address2}"/>' 
							maxLength="100" type="text" 
							name="<%=Request.ORG_ADDRESS_2 %>"/>
						<SPAN id="sp_address2" class="sp_"></SPAN>
					</TD>
				</TR>
				
				<TR class=tbl-content-row-1>
					<TD>
					<LABEL class="label-field" for="organization_phone">
						<fmt:message key="phone"/></LABEL>
					</TD>
					
					<TD>
						<INPUT id="organization_phone" class="txt-field" tabIndex="9" 
							value='<c:out value="${org.phone}"/>' maxLength="20"
							type="text" name="<%=Request.ORG_PHONE %>" 
							onkeypress="return isNumberKey(event)" /> 
						<SPAN id="sp_phone" class="sp_"></SPAN>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_max_users_count">
						<fmt:message key="max_no_of_users"/>
					</LABEL>
					</TD>
					
					<TD>
					<SELECT id="organization_max_user_count" class="select-field width_select" tabIndex="10" 
						name="<%=Request.ORG_MAX_USER_COUNT %>" >
						<c:forEach items="${orgMaxNoOfUsers}" var="orgMaxNoOfUser" varStatus="count">
						<c:choose>
						<c:when test="${orgMaxNoOfUser.orgMaxNoOfUserValue == 1000}">
							<option value="${orgMaxNoOfUser.orgMaxNoOfUserValue}" selected="selected">
								<c:out value="${orgMaxNoOfUser.orgMaxNoOfUserName}"></c:out>								 
							</option>
						</c:when>
						<c:otherwise>
							<option value="${orgMaxNoOfUser.orgMaxNoOfUserValue}">
								<c:out value="${orgMaxNoOfUser.orgMaxNoOfUserName}"></c:out>								 
							</option>
						</c:otherwise>
						</c:choose>
						</c:forEach>
					</SELECT>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_expired_on">
						<fmt:message key="subscription_expriration_date"/> </LABEL>
					</TD>
					
					<TD>
						<INPUT id="dum_expired_on" class="date-field" type="text"
							name="<%=Request.ORG_EXPIRED_ON %>" tabindex="11"
							value='<fmt:formatDate pattern="dd/MM/yyyy" 
							value="<%=Functions.getDefaultDate() %>"/>'
							style="width: 90%" readonly="readonly"/>
						<SPAN id="sp_expiration_date" class="sp_" style="float:left;"></SPAN>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_org_status">
						<fmt:message key="status"/></LABEL>
					</TD>
					
					<TD style="PADDING-BOTTOM: 1px; MARGIN: 0px; PADDING-LEFT: 1px; PADDING-RIGHT: 1px; PADDING-TOP: 1px">
						<SPAN style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; FLOAT: left; PADDING-TOP: 0px">
						<INPUT id="organization_org_status_true" value="0" CHECKED tabIndex="12"
							type=radio name="<%=Request.ORG_STATUS %>" /> 
							<LABEL class=lbl-for-radio for=organization_org_status_true>
								Enabled</LABEL>
						</SPAN>
						
						<SPAN style="PADDING-RIGHT: 40%; FLOAT: right">
							<INPUT id="organization_org_status_false" value="1" tabIndex="12" 
								type="radio" name="<%=Request.ORG_STATUS %>"> 
							<LABEL class="lbl-for-radio" for="organization_org_status_false">
								Disabled</LABEL>
						</SPAN>
					</TD>
				</TR>
			</TBODY>
			</TABLE>
			</TD>
			<!--End of left table for organization information -->

			<!--Right table for organization admin information -->
			<td style="padding-right: 5px;" valign="top">
				
			<table width="100%" cellpadding="0" cellspacing="1" style="border-collapse: separate;">
			<tbody>				
				<tr class="tbl-content-row-1" >
				<td style="width: 30%" colspan="2">
				<div>
					<div style="float:left; width:138px;">						 
						<input checked="checked" class="radio-btn" id="new_manager_account"
							name="manager_account" tabindex="13" value="0" type="radio"
							style="margin-left: 5px">
						<label class="lbl-for-radio" for="new_manager_account">
							<fmt:message key="create_new_account"/></label>					
					</div>
					
					<div>					
						<input class="radio-btn" id="choose_existing_account" disabled="disabled"
							name="manager_account" value="1" type="radio" tabindex="13">
						<label class="lbl-for-radio" for="choose_existing_account">
							<fmt:message key="choose_from_list"/></label> 					
					</div>
				</div>	
				</td>				
				</tr>
				
				<tr class="tbl-content-row-1">
					<td style="width: 30%;">
					<label class="label-field" for="account">
						<fmt:message key="login_name"/> (<span style="color: red">*</span>)</LABEL>
					</td>
					
					<td>
						<input style="width: 96%;" class="txt-field-right" id="user_account"
							name="<%=Request.USER_ACCOUNT%>" size="30" type="text" tabindex="14">
						<span id="account_validity" class="sp_"></span> 						
					</td>
				</tr>
		
				<tr class="tbl-content-row-1">
					<td>
					<label class="label-field" for="user_password" style="margin-top:-25px;">
						<fmt:message key="password"/> (<span style="color: red">*</span>)</label>
					</td>
					
					<td>
						<input  style="width: 96%;" class="txt-field-right" id="user_password"
							maxlength="32" name="<%=Request.USER_PASSWORD%>" tabindex="15"
							size="32" type="password">
						<span id="pass_msg" class="sp_"></span>
						
						<div id="pw_msg_level" style="padding-left: 2px; text-align: left;">
							<fmt:message key="password_strength"/>
				
							<span id="sptxtPassword"></span>
						</div>
						<div id="meter">
						<table style="padding: 0px;" width="177px" cellpadding="0" cellspacing="0">
						<tbody>
						<tr title="Để đảm bảo mật khẩu an toàn hơn, nên sử dụng kết hợp giữa: Chữ in, chữ thường, chữ số và các kí tự đặc biệt.">
							<td style="padding: 0px; border: 0px none;">
							<div id="meter1"></div>
							</td>
						
							<td style="padding: 0px; border: 0px none;">
							<div id="meter2"></div>
							</td>
							
							<td style="padding: 0px; border: 0px none;">
							<div id="meter3"></div>
							</td>
							
							<td style="padding: 0px; border: 0px none;">
							<div id="meter4"></div>
							</td>								
							<td style="padding: 0px; margin-right: -5px; border: 0px none;"
								width="17px;" align="right">
								<img src="<%=request.getContextPath() %>/images/help_icon.gif" id="help"									
									style="cursor: pointer;" width="16" height="16" tabindex="16">								
							</td>
						</tr>
						</tbody>
						</table>
						</div>
					</td>
				</tr>
				
				<tr class="tbl-content-row-1">
					<td>
					<label class="label-field" for="user_password_confirmation">
						<fmt:message key="password_confirm"/> (<span style="color: red">*</span>)</label>						
					</td>
					
					<td>
					<input style="width: 96%;"  class="txt-field-right"
						id="user_password_confirmation" maxlength="32"  type="password"
						name="<%=Request.USER_PASSWORD_CONFIRM%>" size="32" tabindex="17"> 
					<span id="confirmed_pass_msg" class="sp_"></span>
					</td>
				</tr>
				
				<tr class="tbl-content-row-1">
					<td>
					<label class="label-field" for="user_first_name">
						<fmt:message key="first_name"/> (<span style="color: red">*</span>)</label>
					</td>
					<td>
					<input style="width: 96%;" class="txt-field-right" id="user_first_name"
						maxlength="32" name="<%=Request.USER_FIRST_NAME%>"
						size="32" type="text" tabindex="18"> 
					<span id="fname_msg" class="sp_"></span>
					</td>
				</tr>
				
				<tr class="tbl-content-row-1">
					<td>
					<label class="label-field" for="user_last_name">
						<fmt:message key="last_name"/> (<span style="color: red">*</span>)</label>
					<td>
					<input  style="width: 96%;" class="txt-field-right" id="user_last_name"
						maxlength="32" name="<%=Request.USER_LAST_NAME%>"
						size="32" tabindex="19" type="text"> 
					<span id="lname_msg" class="sp_"></span>
					</td>
				</tr>
				
				<tr class="tbl-content-row-1">
					<td>
					<label class="label-field" for="user_last_name">
						<fmt:message key="email"/> (<span style="color: red">*</span>)</label>
					</td>
					
					<td>
					<input  style="width: 96%;" class="txt-field-right" id="user_email"
						name="<%=Request.USER_MAIL%>" size="30"
						tabindex="20" type="text" />
					<input id="user_id" name="<%=Request.USER_ID%>" type="hidden" /> 
					<span id="mail_validity" class="sp_"></span> 					
				</tr>
		
				<tr class="tbl-content-row-1">
					<td>
					<label class="label-field" for="organization_org_status">
						<fmt:message key="sex"/></label>
					</td>
					<td>
					<span style="float: left; margin: 1px; padding: 0px;">
						<input checked="checked" class="radio-btn" id="sex_male"
							name="<%=Request.USER_SEX%>" tabindex="21" value="0" type="radio"/> 
						<label class="lbl-for-radio" for="sex_male">
							<fmt:message key="sex_male"/></label> 
					</span> 
					<span style="float: right; padding-right: 60%;"> 
						<input class="radio-btn" id="sex_famale" tabindex="22"							
							value="1" type="radio" name="<%=Request.USER_SEX%>"/> 
						<label class="lbl-for-radio" for="sex_famale" >
							<fmt:message key="sex_female"/></label>
					</span>
					</td>
				</tr>
				
				<TR class="tbl-content-row-1">
					<td>
					<label class="label-field" for="organization_expired_on">
						<fmt:message key="birthday"/> (<span style="color: red">*</span>)</label>
					</td>
					
					<TD>
						<INPUT id="user_date" class="date-field" type="text"
								name="<%=Request.USER_DATE%>" tabindex="23"
								style="width: 90%" readonly="readonly"/>
						<span id="sp_birthday" class="sp_" style="float:left;"></span>
					</TD>
				</TR>						
			</tbody>
			</table>
			</td>
			<!--End of right table for organization admin information -->
			</tr>
			
			<tr>
			<td style="border-spacing: 0px; float: right;padding-right: 7px; padding-top: 40px;">
				<input class="bt-form" id="organization_submit" name="commit" 
					style="width: 100px; float: right;"
					tabindex="23" value='<fmt:message key="ok"/>' type="submit" /> &nbsp; 				
			</td>
			<td style="padding-top: 40px">
				<input class="bt-form" tabindex="24" value='<fmt:message key="cancel"/>'
					style="width: 100px;float: left;" id="cancel" type="button" />
			</td>
			</tr>
		</tbody>
		</table>
	</td>
	</tr>

	<tr>
	<td style="padding-top: 0px;" valign="top">
	<table width="100%" cellpadding="0" cellspacing="0">
	<tbody>
	<tr>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	</tbody>
	</table>
	</td>
	</tr>
</tbody>
</table>
</div>
</form>

<FORM NAME="frmMsg">
	<INPUT TYPE="hidden" NAME="MsgTxt" Value="${cobsMsgTxt}">
</FORM>
<script type="text/javascript">
	    // Handle textbox Organization Abbreviation
	 	jQuery("#organization_abbreviation").blur(function(){
	 		var org_abbre_val = jQuery.trim(jQuery("#organization_abbreviation").val());		
			if (!checkSpecialCharacters(org_abbre_val) && org_abbre_val != "") {
				jQuery("#sp_org_abbre").text('<fmt:message key="message_require_name_no_special_characters"/>');
				valid_organization_abbre = false;
			}else{
				jQuery("#sp_org_abbre").text('');
				valid_organization_abbre = true;
			}
	 	});
	 	// End 
	 	
	 	
	 	// Handle textbox Organization Address1
	 	jQuery("#organization_address1").blur(function(){
	 		var org_address1 = jQuery("#organization_address1").val();
			if(org_address1 == "") {
				jQuery("#sp_address1").text('<fmt:message key="message_require_input_information"/>');			
				valid_organization_address1 = false;			
			}else if(!checkAddress(org_address1)){
				jQuery("#sp_address1").text('<fmt:message key="message_require_address_no_special_characters"/>');			
				valid_organization_address1 = false;
			}else {
				jQuery("#sp_address1").text('');
				valid_organization_address1 = true;	
			}
	 	});
	 	// End 
	 	
	 	// Handle textbox Organization org_type
	 	jQuery("#organization_org_type").blur(function(){
	 		// Validate organization type		
			var org_stype_val = jQuery("#organization_org_type").val();
			if(org_stype_val == "0"){
				jQuery("#sp_org_type").text('<fmt:message key="message_require_input_information"/>');
				valid_organization_type = false;	
			}else{
				jQuery("#sp_org_type").text('');
				valid_organization_type = true;
			}
	 	});
	 	
	 	// Handle textbox Organization Address2
	 	jQuery("#organization_address2").blur(function(){
	 		var org_address2 = jQuery("#organization_address2").val();
			if(!checkAddress(org_address2)){
				jQuery("#sp_address2").text('<fmt:message key="message_require_address_no_special_characters"/>');			
				valid_organization_address2 = false;
			}else {
				jQuery("#sp_address2").text('');
				valid_organization_address2 = true;	
			}
	 	});
	 	// End
	 	 
	 	// Handle textbox expired date
	 	jQuery("#dum_expired_on").blur(function(){
	 		checkExpiredDate();
	 	});
	 	//End
	 	
	 	// Handle textbox organization state
	 	jQuery("#organization_state").blur(function(){
	 		var org_state_val = jQuery("#organization_state").val();
			if(org_state_val == "" || org_state_val == "0") {
				jQuery("#sp_city").text('<fmt:message key="message_require_input_information"/>');
				valid_organization_state = false;			
			} else {
				jQuery("#sp_city").text('');
				valid_organization_state = true;
			}	
	 	});
	 	// End
	 	
	 	// Handle textbox user_account
	 	jQuery("#user_account").blur(function(){
	 		// Validate user account
			var user_account = jQuery("#user_account").val();
			if(user_account == "") {
				jQuery("#account_validity").text('<fmt:message key="message_require_input_information"/>');			
				valid_user_account = false;			
			}else if(!checkSpecialCharacters(user_account)){
				jQuery("#account_validity").text('<fmt:message key="message_require_username_no_special_characters"/>');			
				valid_user_account = false;	
			}else {
				jQuery("#account_validity").text('');
				valid_user_account = true;			
			}
	 	});
	 	//End
	 	
	 	//Handle textbox user_password
	 	jQuery("#user_password").blur(function(){
	 		// Validate password
			var user_password_val = jQuery("#user_password").val();
			if(user_password_val == "") {
				jQuery("#pass_msg").text('<fmt:message key="message_require_input_information"/>');			
				valid_user_password = false;				
			} else {
				if (user_password_val.length < 6) {
					jQuery("#pass_msg").text('<fmt:message key="message_require_password_length_minimum"/>');			
					valid_user_password = false;	
				}
				else {
					jQuery("#pass_msg").text('');
					valid_user_password = true;
				}
			}
	 	});
	 	//End
	 	
	 	//Handle textbox user_password_confirmation	 	
	 	jQuery("#user_password_confirmation").blur(function(){
	 		if(jQuery("#user_password_confirmation").val() == "") {
				jQuery("#confirmed_pass_msg").text('<fmt:message key="message_require_input_information"/>');			
				valid_user_password_confirmation = false;			
			} else {
				if (jQuery("#user_password_confirmation").val() != jQuery("#user_password").val()) {
					jQuery("#confirmed_pass_msg").text('<fmt:message key="message_password_not_match"/>');				
					valid_user_password_confirmation = false;				
				} else {
					jQuery("#confirmed_pass_msg").text('');
					valid_user_password_confirmation = true;				
				}
			}
	 	});
	 	//End
	 	
	 	//Handle textbox user_first_name
	 	jQuery("#user_first_name").blur(function(){
		 	// Validate user first name
			var user_first_name = jQuery("#user_first_name").val();
			if(user_first_name == "") {
				jQuery("#fname_msg").text('<fmt:message key="message_require_input_information"/>');			
				valid_user_first_name = false;			
			}else if(!checkSpecialCharacters(user_first_name)){
				jQuery("#fname_msg").text('<fmt:message key="message_require_firstname_no_special_characters"/>');			
				valid_user_first_name = false;
			}else {
				jQuery("#fname_msg").text('');
				valid_user_first_name = true;			
			}
	 	});
	 	//End
	 	
	 	//Handle textbox user_last_name
	 	jQuery("#user_last_name").blur(function(){
		 	 // Validate user last name
		    var user_last_name = jQuery("#user_last_name").val();
			if(user_last_name == "") {
				jQuery("#lname_msg").text('<fmt:message key="message_require_input_information"/>');			
				valid_user_last_name = false;				
			}else if(!checkSpecialCharacters(user_last_name)){
				jQuery("#lname_msg").text('<fmt:message key="message_require_username_no_special_characters"/>');			
				valid_user_last_name = false;	
			}else {
				jQuery("#lname_msg").text('');
				valid_user_last_name = true;				
			}
	 	});
	 	//End
	 	
	 	//Handle textbox user_email
	 	jQuery("#user_email").blur(function(){
	 		// Validate email
			var user_email = jQuery("#user_email").val();
			if(user_email == "") {
				jQuery("#mail_validity").text('<fmt:message key="message_require_input_information"/>');			
				valid_user_email = false;			
			}else {
			    if (checkEmail(user_email)){
			    	jQuery("#mail_validity").text('');
					valid_user_email = true;	
			    }else{
			    	jQuery("#mail_validity").text('<fmt:message key="message_invalid_email"/>');
					valid_user_email = false;
			    }
			}
	 	});
	 	//End
	 	
	 	//Handle user_date
	 	jQuery("#user_date").blur(function(){
	 		// Validate birthday		
			var birthday_user = jQuery("#user_date").val();
			if (birthday_user == "")
			{
				jQuery("#sp_birthday").text('<fmt:message key="message_require_birthday"/>');
				valid_birthday = false;
			}else {
				if (checkDate(birthday_user)){
					jQuery("#sp_birthday").text('');
				    valid_birthday = true;
				}else{				
					jQuery("#sp_birthday").text('<fmt:message key="message_validate_birthday"/>');
					valid_birthday = false;
				}				
			}
	 	});
	 	//End
	 	
/*
* check Email
*/
function checkEmail(email){
	var atpos = email.indexOf("@");
	var stoppos = email.lastIndexOf(".");
	
	if (atpos == -1 || stoppos == -1){				
		return false;
	}
	if (stoppos < atpos){				
		return false;
	}
	if(stoppos - atpos == 1){				
		return false;
	}
	var emailexpress = new RegExp("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$", "g");
	if(!emailexpress.test(email)){
		return false;
	}
	return true;
}		 	
/*
 * Check Date
 */
function checkDate(birthday){
	var currentTime = new Date();
	var month1 = currentTime.getMonth();
	var day1 = currentTime.getDate();
	var year1 = currentTime.getFullYear();
	var now = new Date(year1, month1, day1);
	if (birthday != ""){
		var birthday_arr = birthday.split("/");
		var day2 = birthday_arr[0];
		var month2 = birthday_arr[1];
		var year2 = birthday_arr[2];
		var my_birthday = new Date(year2, month2 -1, day2);
		var DaysDiff = Math.floor((now.getTime() - my_birthday.getTime())/(1000*60*60*24));
		if(DaysDiff > 0){
			return true;
		}else{
			return false;
		}
	}
	return false;
}

/*
 * Check Expired Date
 */
function checkExpiredDate(){
	   // Validate expired date
		var now = new Date();		
		var divdate = new Date();
		/* split the text date in the div */
		var dateparts = jQuery("#dum_expired_on").val().split('/'); // Format date should be dd/mm/yyy
		//var dateparts = $(this).text().split('/');
		
		// set the properties of the Date object 
		//divdate.setDate(parseInt(dateparts[0]));
		/* months are zero indexed! */
		//divdate.setMonth((parseInt(dateparts[1])-1));
		//divdate.setYear(parseInt(dateparts[2]));
		divdate.setFullYear(parseInt(dateparts[2]), parseInt(dateparts[1])-1, parseInt(dateparts[0]));
		/* compare dates - 14 days = (14*24*60*60*1000) milliseconds */
		if (divdate < now) {
		//if (divdate.getTime() < (now.getTime() - (14*24*60*60*1000))) {
			jQuery("#sp_expiration_date").text('<fmt:message key="message_expired_day_larger_now"/>');	
			valid_expired_date = false;
		} else {
			jQuery("#sp_expiration_date").text('');
			valid_expired_date = true;	
		}
		// End Validate expired date
		
}
</script>
