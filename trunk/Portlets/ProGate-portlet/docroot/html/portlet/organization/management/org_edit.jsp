<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">
   <%@ include file="/css/organization_information.css" %>   
</style>

<style type="text/css">

table {
 border-collapse: separate;
 border-spacing: 1px;
}
</style>

<script type="text/javascript">

	// Show message when form on load
	window.onload = function () {
	if (document.frmMsg.MsgTxt.value != '')
    {			
		var ok = jAlert('<fmt:message key="message_edit_org_successful"/>', 
			'<fmt:message key="org_management"/>');
		
		jQuery("#popup_ok").click(function(){
			var portletActionURL = 
				'<portlet:actionURL>
					<portlet:param name="struts_action" value="/organization_management/org_list"></portlet:param>
				</portlet:actionURL>';
			document.frmOrgEdit.action = portletActionURL;
	        document.frmOrgEdit.submit();
		});			
    }
    document.frmMsg.MsgTxt.value = '';
	}
	
	// Perform form submit
	function submit() {
		if ( valid_organization_name == true &&
			 valid_organization_abbre == true &&
			 valid_organization_state == true &&
			 valid_organization_address1 == true &&				 
			 valid_expired_date == true &&
			 valid_organization_type == true &&
			 valid_organization_phone == true) {
			//jQuery("#organization_submit").removeAttr('disabled');
			var portletActionURL = 
				'<portlet:actionURL>
					<portlet:param name="struts_action" value="/org_management/org_edit_action"/>
				</portlet:actionURL>';
			
			document.frmOrgEdit.action = portletActionURL;
	        document.frmOrgEdit.submit();
		} else {
			//jQuery("#organization_submit").attr('disabled', 'disabled');
		}
	}
	
	function validate_and_submit() {
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
			}
		}
		
		// Validate organization abbreviation
		var org_abbre_val = jQuery.trim(jQuery("#organization_abbreviation").val());		
		if (!checkSpecialCharacters(org_abbre_val) && org_abbre_val != "") {
			jQuery("#sp_org_abbre").text('<fmt:message key="message_require_name_no_special_characters"/>');
			valid_organization_abbre = false;
		} else {
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
		
		
		// Validate organization address
		if(jQuery("#organization_address1").val() == "") {
			jQuery("#sp_address1").text('<fmt:message key="message_require_input_information"/>');			
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
				jQuery("#sp_phone").text('<fmt:message key="message_invalid_phone"/>');				
				valid_organization_phone = false;
			}  else {
				jQuery("#sp_phone").text('');
				valid_organization_phone = true;			
			}
		}	
		
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
		
		// Validate organization type
		
		var org_stype_val = jQuery("#organization_org_type").val();
		if(org_stype_val == "" || org_stype_val == "0"){
			jQuery("#sp_org_type").text('<fmt:message key="message_require_input_information"/>');
			valid_organization_type = false;	
		}else{
			jQuery("#sp_org_type").text('');
			valid_organization_type = true;
		}
		/* Submit */
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
				buttonImage: "<%=request.getContextPath() %>/images/calendar.gif",
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
	    	title:'<fmt:message key="help"/>',
	    	autoOpen: false,
		    modal: true,
		    buttons: {		        
		        '<fmt:message key="close"/>': close
		    },		    
		    width: 600,
		    height: 400
	    };
	    
	    jQuery("#password-help").dialog(dialogOpts);
	    jQuery("#help").click(function(){
	    	jQuery("#password-help").dialog("open");
	    	//jQuery("#password-help").width(575);
	    });	    
	 	// End Show help password
	    
	    // Handle textbox Organization Name
	 	jQuery("#organization_name").focus();
	 	jQuery("#organization_name").blur(function(){
	 		var message_fail = '<fmt:message key="org.error.orgName.exist"/>';
	 		var message_success = '';
	 		var ori_orgName = jQuery("#ori_orgName").val();
	 		var orgName = jQuery("#organization_name").val();
	 		if (ori_orgName != orgName) {
	 			checkOrgExist(message_success, message_fail);	
	 		} else {
	 			jQuery("#sp_org_name").text(message_success);			
				valid_organization_name_exist = true;
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
				'<portlet:renderURL>
					<portlet:param name="struts_action" value="/organization_management/org_list"></portlet:param>
				</portlet:renderURL>';
				
			document.frmOrgEdit.action = portletActionURL;
	        document.frmOrgEdit.submit();

	        e.preventDefault();
		});		
	});
</script>

<form name="frmOrgEdit" method="post" action="">

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
		<td class="title-user-mng tbl-top-dot" width="50%">
			<fmt:message key="title_edit_org"/> "<c:out value='${org.name}'/>"</td>
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
			<td align="left" class="td-name" style="color: black;"></td>
			</TR>
		
			<TR>
			<!--Left table for organization information -->
			
			<TD class="td-content-edit" vAlign="top" width="50%">
			<TABLE cellSpacing="1" cellPadding="0" width="98%">
			<TBODY>
				<TR class="tbl-content-row-1">
					<TD width="30%">
					<LABEL class="label-field" for="organization_name">
						<fmt:message key="organization_name"/> (<span style="color: red">*</span>)
					</LABEL>
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
					<SELECT id="organization_org_type" class="select-field width_select_edit"
						tabIndex="2" name="<%=Request.ORG_TYPE %>">
						<c:forEach items="${orgTypes}" var="orgType" varStatus="count">
						<c:choose>
						<c:when test="${orgType.orgTypeValue == orgTypeCurrent}">
							<option value="${orgType.orgTypeValue}" selected="selected">
								<fmt:message key="${orgType.orgTypeName}"/> 
							</option>
						</c:when>
						<c:otherwise>
							<option value="${orgType.orgTypeValue}" >
								<fmt:message key="${orgType.orgTypeName}"/> 
							</option>
						</c:otherwise>
						</c:choose>
						</c:forEach>
					</SELECT>
					<span class="sp_" id="sp_org_type"></span>
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
						<fmt:message key="country"/> (<span style="color: red">*</span>)</LABEL>
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
						<fmt:message key="state_province"/> (<span style="color: red">*</span>)</LABEL>
					</TD>
					
					<TD>
						<select id="organization_state" tabIndex="6" 
							name="<%=Request.ORG_CITY %>" class="select-field width_select_edit">
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
						<fmt:message key="address_line_1"/> (<span style="color: red">*</span>)</LABEL>
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
						<INPUT id="organization_address1" class="txt-field" tabIndex="8" 
							value='<c:out value="${org.address2}"/>' 
							maxLength="100" type="text" 
							name="<%=Request.ORG_ADDRESS_2 %>"/>
						<SPAN id="sp_address1" class="sp_"></SPAN>
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
						<fmt:message key="max_no_of_users"/></LABEL>
					</TD>
					
					<TD>
					<SELECT id="organization_max_user_count" class="select-field width_select_edit" tabIndex="10" 
						name="<%=Request.ORG_MAX_USER_COUNT %>">
						<c:forEach items="${orgMaxNoOfUsers}" var="orgMaxNoOfUser" varStatus="count">
						<c:choose>
						<c:when test="${orgMaxNoOfUser.orgMaxNoOfUserValue == orgMaxNoOfUserCurrent}">
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
							value="${org.expiredDate}" />'
							style="width: 90%" readonly="readonly"/>
						<SPAN id="sp_expiration_date" class="sp_"></SPAN>
					</TD>
				</TR>
				
				
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_org_status">
						<fmt:message key="status"/></LABEL>
					</TD>
					
					<TD style="PADDING-BOTTOM: 1px; MARGIN: 0px; PADDING-LEFT: 1px; PADDING-RIGHT: 1px; PADDING-TOP: 1px">
						<SPAN style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; FLOAT: left; PADDING-TOP: 0px">
							<c:choose>
								<c:when test="${org.orgStatus == true}">
								<INPUT id="organization_org_status_true" value="0" tabIndex="12"
									type=radio name="<%=Request.ORG_STATUS %>" checked="checked"/> 							
								</c:when>
								<c:otherwise>
								<INPUT id="organization_org_status_true" value="0" tabIndex="13"
									type=radio name="<%=Request.ORG_STATUS %>" /> 							
								</c:otherwise>
							</c:choose>							
							<LABEL class=lbl-for-radio for=organization_org_status_true>
								Enabled</LABEL>
						</SPAN>
						
						<SPAN style="PADDING-RIGHT: 40%; FLOAT: right">
							<c:choose>
								<c:when test="${org.orgStatus == false}">
								<INPUT id="organization_org_status_false" value="1" tabIndex="14" 
									type="radio" name="<%=Request.ORG_STATUS %>" checked="checked"> 
								</c:when>
								<c:otherwise>
								<INPUT id="organization_org_status_false" value="1" tabIndex="14" 
									type="radio" name="<%=Request.ORG_STATUS %>" > 							
								</c:otherwise>
							</c:choose>
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
			<TD style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 5px; PADDING-TOP: 0px"
				vAlign="top">
			<TABLE cellSpacing="1" cellPadding="0" width="100%">
			<TBODY>
				<TR class="tbl-content-row-1">
					<TD rowSpan="3" width="115">
					<LABEL class="label-field" for="organization_org_show_logo">
						<fmt:message key="org_logo"/></LABEL>
					</TD>
					
					<TD style="PADDING-LEFT: 1px" align=left>
					<IMG id=org_img src="<%=request.getContextPath() %>/images/no_image.gif" 
						width="90" height="90">
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
				<TD align="left">
					<INPUT value="0" type="hidden"
						name="<%=Request.ORG_SHOW_LOGO %>" />
					<INPUT id="organization_show_logo" tabIndex="15" value="1" 
						type="checkbox" name="<%=Request.ORG_SHOW_LOGO %>"/>
					<LABEL class="lbl-for-radio" for="organization_show_logo">
						<fmt:message key="show_logo"/></LABEL>
				</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
				<TD style="PADDING-LEFT: 5px" align=left>
				<A href="javascript:void(0);" tabIndex="16">
					<fmt:message key="change_logo"/></A>
				</TD>
				</TR>
				
				<TR>
				<TD style="BACKGROUND: none transparent scroll repeat 0% 0%; FONT-WEIGHT: bold; PADDING-TOP: 20px"
					colSpan="2" align="left">
					<fmt:message key="list_of_admin_users"/></TD>
				</TR>
				
				<TR>
				<TD colSpan=2>
				<DIV id="scroll_box">
				<TABLE class="tbl-list-org-admin" cellSpacing="1" cellPadding="0"
					width="100%">
				<TBODY>
					<TR class="tbl-user-mng-content-header">
						<TD width=30>No.</TD>
						<TD>Email Address</TD>
					</TR>
					
					<TR class="tbl-content-row-0">
						<TD align="right">1</TD>
						<TD style="PADDING-LEFT: 5px" align=left>
						<A href="javascript:void(0);">admin@progate.com</A></TD>
					</TR>
				</TBODY>
				</TABLE>
				</DIV>
				</TD>
				</TR>
				
				<TR>
				<TD	style="BACKGROUND: none transparent scroll repeat 0% 0%; FONT-SIZE: 0px"
					height="10" colSpan="2">&nbsp;
				</TD>
				</TR>
				</TBODY>
				</TABLE>
				</TD>
				<!--End of right table for organization admin information -->
			</TR>
			
			<tr>
			<td style="border-spacing: 0px; float: right;padding-right: 7px; padding-top: 40px">
				<input class="bt-form" id="organization_submit" name="commit" style="width: 100px;"
					tabindex="16" value='<fmt:message key="ok"/>' type="submit" /> &nbsp; 				
			</td>
			<td style="padding-top: 40px">
				<input class="bt-form" tabindex="17" value='<fmt:message key="cancel"/>'
					style="width: 100px;" id="cancel" type="button" />
			</td>
			</tr>
		</TBODY>
		</TABLE>						
	</TD>
	</TR>
	
	<TR>
	<TD style="PADDING-TOP: 0px" vAlign=top>
	<TABLE cellSpacing="0" cellPadding="0" width="100%">
	<TBODY>
	<TR>
		<TD></TD>
		<TD>&nbsp;</TD>
		<TD></TD>
	</TR>
	</TBODY>
	</TABLE>
	</TD>
	</TR>
</TBODY>
</TABLE>

<DIV
	style="Z-INDEX: 1; POSITION: absolute; WIDTH: 465px; VISIBILITY: hidden"
	id="div_upload_logo">
</DIV>

<input type="hidden" name="<%=Request.ORG_ID %>" value='<c:out value="${org.orgId}"/>'/>
<input type="hidden" id="ori_orgName" value='<c:out value="${org.name}"/>'/>
</DIV>
</FORM>

<FORM NAME="frmMsg">
	<INPUT TYPE="hidden" NAME="MsgTxt" Value="${cobsMsgTxt}">
</FORM>
