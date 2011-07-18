<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	/*
	jQuery(document).ready(function() {
		
		var execute = function() {
	    }
	    var cancel = function() {
	    }
	    var dialogOpts = {
	      
	      modal: true
	    };
	    
	    var pickerOpts = {
			showOn: "both",
			buttonImage: "/Progate_ManageOrg-portlet/images/calendar.gif",
			buttonText: "Open datepicker",
			buttonImageOnly: true
	    };
	    
		jQuery('#date').datepicker(pickerOpts);
		jQuery('#myDialog').dialog(dialogOpts);
		
	});*/
</script>

<form name="frmOrgChangeLogo" method="post" action="">
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
						<INPUT id="organization_name" class="txt-field"
							tabIndex="1" value='<c:out value="${org.name}"/>'
							type="text" name="<%=Request.ORG_NAME %>" />
						<SPAN id="sp_org_name" class="sp_"></SPAN>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_abbreviation">
						<fmt:message key="organization_abbreviation"/></LABEL>
					</TD>
					
					<TD>
						<INPUT id="organization_abbreviation" class="txt-field" tabIndex="2"
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
						<INPUT id="organization_description" class="txt-field" tabIndex="3"
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
					<INPUT id="organization_country" class="txt-field" tabIndex="4"
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
						<select id="organization_state" tabIndex="5" 
							name="<%=Request.ORG_CITY %>" class="select-field" >
						<c:forEach items="${orgCities}" var="orgCity" varStatus="count">
						<c:choose>
						<c:when test="${orgCity.orgCityValue == orgCityCurrent}">
							<option value="${orgCity.orgCityValue}" selected="selected">
								<bean:message key="${orgCity.orgCityName}"/> 
							</option>
						</c:when>
						<c:otherwise>
							<option value="${orgCity.orgCityValue}">
								<bean:message key="${orgCity.orgCityName}"/> 
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
						<INPUT id="organization_address1" class="txt-field" tabIndex="6" 
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
						<INPUT id="organization_address1" class="txt-field" tabIndex="7" 
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
						<INPUT id="organization_phone" class="txt-field" tabIndex="8" 
							value='<c:out value="${org.phone}"/>' maxLength="20"
							type="text" name="<%=Request.ORG_PHONE %>" 
							onkeypress="return onlyNumbers(event);" /> 
						<SPAN id="sp_phone" class="sp_"></SPAN>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_max_users_count">
						<fmt:message key="max_no_of_users"/></LABEL>
					</TD>
					
					<TD>
					<SELECT id="organization_max_user_count" class="select-field" tabIndex="9" 
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
							name="<%=Request.ORG_EXPIRED_ON %>" tabindex="10"
							value='<fmt:formatDate pattern="dd/MM/yyyy" 
							value="${org.subscription_expiration_date}" />'
							style="width: 92%" />
						<SPAN id="sp_expiration_date" class="sp_"></SPAN>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_org_type">
						<fmt:message key="org_type"/></LABEL>
					</TD>
					<TD>
					<SELECT id="organization_org_type" class="select-field"
						tabIndex="10" name="<%=Request.ORG_TYPE %>">
						<c:forEach items="${orgTypes}" var="orgType" varStatus="count">
						<c:choose>
						<c:when test="${orgType.orgTypeValue == orgTypeCurrent}">
							<option value="${orgType.orgTypeValue}" selected="selected">
								<bean:message key="${orgType.orgTypeName}"/> 
							</option>
						</c:when>
						<c:otherwise>
							<option value="${orgType.orgTypeValue}" >
								<bean:message key="${orgType.orgTypeName}"/> 
							</option>
						</c:otherwise>
						</c:choose>
						</c:forEach>
					</SELECT>
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
					<TD>
					<LABEL class="label-field" for="organization_org_status">
						<fmt:message key="status"/></LABEL>
					</TD>
					
					<TD style="PADDING-BOTTOM: 1px; MARGIN: 0px; PADDING-LEFT: 1px; PADDING-RIGHT: 1px; PADDING-TOP: 1px">
						<SPAN style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; FLOAT: left; PADDING-TOP: 0px">
						<INPUT id="organization_org_status_true" value="0" CHECKED tabIndex="11"
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
					<IMG id=org_img src="/Progate_ManageOrg-portlet/images/no_image.gif" 
						width="90" height="90">
					</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
				<TD align="left">
					<INPUT value="0" type="hidden"
						name="<%=Request.ORG_SHOW_LOGO %>" />
					<INPUT id="organization_show_logo" tabIndex="13" value="1" 
						type="checkbox" name="<%=Request.ORG_SHOW_LOGO %>"/>
					<LABEL class="lbl-for-radio" for="organization_show_logo">
						<fmt:message key="show_logo"/></LABEL>
				</TD>
				</TR>
				
				<TR class="tbl-content-row-1">
				<TD style="PADDING-LEFT: 5px" align=left>
				<A onclick=show_message(); href="javascript:void(0);">
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
						<A href="">admin@progate.com</A></TD>
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
				<input class="bt-form disabled" id="organization_submit" name="commit" style="width: 100px;"
					tabindex="22" value='<fmt:message key="ok"/>' type="submit" /> &nbsp; 				
			</td>
			<td style="padding-top: 40px">
				<input class="bt-form" tabindex="23" value='<fmt:message key="cancel"/>'
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

<input type="hidden" name="<%=Request.ORG_ID %>" value='<c:out value="${org.org_id}"/>'/>
</DIV>
</FORM>

