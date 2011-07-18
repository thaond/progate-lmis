<%@ include file="../../../common/init.jsp"%>
<%@ include file="../../../lmis/initOfConfig.jsp" %>
<jsp:include page="../../dialog/configEmailSuccessPage.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.larion.progate.lmis.constants.Configuration_RS"%>

<script type="text/javascript">

var isEditable =false;
var arrayOrgId = new Array();
var arrayUserId = new Array();
var arrayOrgEmailString = new Array();
var arrayUserEmailString = new Array();

/* get all email address of checked emails*/

function mySelect(check)
	{
		var value;
		if(check==false){
			 value = check;
			 }
			else{
					value = jQuery(".mode-edit").attr("disabled");
				}	
		var url='<portlet:renderURL>
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.EMAIL_TAB%>" />
			<portlet:param name="orgId" value="${bean.orgId}" />
			<portlet:param name="disable" value="disabled" />
			</portlet:renderURL>';		
			url=url.replace("disabled",value);
			document.frmConfigEmail.action=url;
			document.frmConfigEmail.submit();
}

function saveConfigEmail()
	{	
		var href='<portlet:renderURL>
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.EMAIL_TAB%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>" />
			<portlet:param name="orgId" value="${bean.orgId}" />
			</portlet:renderURL>';

			jQuery.ajax({
				type: "POST",
				url : href,
				data : {
					"emailSettingId": ${bean.emailTypeId},
					"listUserId" : arrayUserId,
					"listOrgId"	 : arrayOrgId
				},
				success: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
						<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.EMAIL_TAB%>" />
						<portlet:param name="orgId" value="${bean.orgId}" />
						</portlet:renderURL>';
					jQuery(".successful").css("display", "block");
				    jQuery(".successful").data('url',href).data('close',close).dialog("open");
				},
				error: function(){
					alert("Có lỗi xảy ra khi lưu cấu hình Email!");
				}
			});
	}
	
function cancelSaveEmail()
	{
		var url='<portlet:renderURL>
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.EMAIL_TAB%>" />
			<portlet:param name="orgId" value="${bean.orgId}" />
			</portlet:renderURL>';
			
			document.frmConfigEmail.action=url;
			document.frmConfigEmail.submit();
	}
	
	jQuery(document).ready(function(){
		
		showEmailString();
		
		if(${bean.disable==true}){
			isEditable=true;
			jQuery('.mode-edit').attr('disabled', true);
			jQuery("#mode-edit-active").css('color','gray');
			jQuery("#image-edit").attr('src','/ProGate-portlet/images/lmis/configAttendanceInfo/Edit_disable.png');
			jQuery("#btnAddOrg, #btnAddUser").attr('src','/ProGate-portlet/images/lmis/configAttendanceInfo/config-symbol-add.png');
			jQuery("#btnAddOrg").removeAttr('disabled');
			jQuery("#btnAddUser").removeAttr('disabled');
			jQuery('#addUserLabel').addClass('addLabelEnable');
			jQuery('#addOrgLabel').addClass('addLabelEnable');
			jQuery('#save').removeAttr('disabled');
			jQuery('#cancel').removeAttr('disabled');
			jQuery('#save').removeClass('button-disable').addClass('button-enable');
			jQuery('#cancel').removeClass('button-disable').addClass('button-enable');
		}
		
		jQuery('.mode-edit').bind('click',function(){
				isEditable=true;
				jQuery(this).attr('disabled', true);
				jQuery("#mode-edit-active").css('color','gray');
				jQuery("#image-edit").attr('src','/ProGate-portlet/images/lmis/configAttendanceInfo/Edit_disable.png');
				jQuery("#btnAddOrg, #btnAddUser").attr('src','/ProGate-portlet/images/lmis/configAttendanceInfo/config-symbol-add.png');
				jQuery("#btnAddOrg").removeAttr('disabled');
				jQuery("#btnAddUser").removeAttr('disabled');
				jQuery('#addUserLabel').addClass('addLabelEnable');
				jQuery('#addOrgLabel').addClass('addLabelEnable');
				jQuery('#save').removeAttr('disabled');
				jQuery('#cancel').removeAttr('disabled');
				jQuery('#save').removeClass('button-disable').addClass('button-enable');
				jQuery('#cancel').removeClass('button-disable').addClass('button-enable');
		
		});
			/// Enable all field to edit
			//save configured emails
		jQuery('#save').click(function(){
			saveConfigEmail();
		});	
			//cancel configured emails
		jQuery('#cancel').click(function(){
			cancelSaveEmail();
	});
		
});
	
//show email strings to textarea when load page at first	
function showEmailString(){
	var emailOrgString="";
	var emailUserString="";
	<c:forEach items="${bean.lmisViewEmailSettingDetailOrgs}" var="orgEmail">
		emailOrgString += "${orgEmail.emailOrg}"+"; ";
	</c:forEach>
		<c:forEach items="${bean.lmisViewEmailSettingDetailUsers}" var="userEmail">
		emailUserString += "${userEmail.emailUser}" +"; ";
	</c:forEach>
	jQuery("textarea#txtaddOrg").val(emailOrgString);	
	jQuery("textarea#txtaddUser").val(emailUserString);	
}	
//show email strings to texarea
function showEmailStringOfPopup(){
	var emailOrgString="";
	var emailUserString="";
	for( i=0; i<arrayUserId.length; i++){
		emailUserString += arrayUserEmailString[i]+ "; ";
	}
	for( j=0; j<arrayOrgId.length; j++){
		emailOrgString += arrayOrgEmailString[j]+ "; ";
	}
	jQuery("textarea#txtaddOrg").val(emailOrgString);	
	jQuery("textarea#txtaddUser").val(emailUserString);
}
		
</script>

<div class="wrapper">
	<!-- Header -->
	<div class="header">
		<div class="header-left"></div>
		<div class="header-right"></div>

		<div class="header-center">

			<label id="header-title"><fmt:message key="lmis.config.title" />
			</label>
		</div>

		<div class="clear-both"></div>
	</div>
	<!-- End Header -->
<div class="mainContent">
<c:choose>
	<c:when test="${bean.permission!=0}">
		
		<div class="wrap-tabbed">
			<ul class="nav-tabs">
				<li>
				<a class='actived' href='#' ><fmt:message key="lmis.config.email.title" /> </a>
				</li>
			</ul>
		</div>
		<!-- 		edit button -->
		<div class="mode-edit">
			<input id="image-edit" type="image"
				src="/ProGate-portlet/images/lmis/configAttendanceInfo/edit.png" /> <a
				href="#" id="mode-edit-active"><fmt:message key="button.edit" />
			</a>
		</div>
		<!-- end edit button -->
		
		<div class="clear-both"></div>
		<form name="frmConfigEmail" id="frmConfigEmail" action="" method="post">
			<div class="contentConfigEmail">
				<div class="div-seperator-small">
					<div class="col-left">
						<p style="padding-top: 5px;">
							<fmt:message key="lmis.config.email.emailType" />
						</p>
					</div>
					<div class="col-center">
						<select id="sel-email" name="<%=Configuration_RS.SELECT_EMAIL_TYPE%>" onchange="mySelect(true)">
						<c:forEach var="lmisEmailSetting" items="${bean.lmisEmailSettings}">
							<c:choose>
								<c:when test="${lmisEmailSetting.lmisEmailSettingId == bean.emailTypeId}">
									<option value="${lmisEmailSetting.lmisEmailSettingId}" selected="selected"><c:out value="${lmisEmailSetting.emailName}"/></option>
								</c:when>
								<c:otherwise>
									<option value="${lmisEmailSetting.lmisEmailSettingId}"><c:out value="${lmisEmailSetting.emailName}"/></option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						</select>
					</div>
					<div class="col-right"></div>
					<div id="clear-both"></div>
				</div>
				<div class="div-seperator-small">
					<div class="col-left">
						<p style="padding-top: 5px;">
							<fmt:message key="lmis.config.email.receiver" />
						</p>
					</div>
					<div class="col-center">
						<div class="col-center-checkbox">
							<label><input id="chkSenderStaff" name="chkSenderStaff"
								type="checkbox" checked="checked" disabled="disabled" /> <fmt:message key="lmis.config.email.sender" /> </label> <label>
								<input	id="chkSenderBOD" name="chkSenderBOD" type="checkbox" checked="checked" disabled="disabled" /> 
								<fmt:message key="lmis.config.email.bod" /> </label> 
								<label><input id="chkSenderPM" name="chkSenderPM" type="checkbox" checked="checked" disabled="disabled" /> 
								<fmt:message key="lmis.config.email.pm" /> </label>
						</div>
					</div>
					<div class="col-right"></div>
					<div id="clear-both"></div>
				</div>
		
		
				<div class="div-seperator">
					<div class="col-left">
						<p>&nbsp;</p>
						<p>
							<br />
							<fmt:message key="lmis.config.email.relatedOrg" />
						</p>
					</div>
					<div class="col-center">
						<div class="col-center-textarea">
							<textarea  id="txtaddOrg" rows="3"  disabled="disabled" ></textarea>
						</div>
					</div>
					<div class="col-right">
						<div class="div-images">
							<a id="addRelatedOrg" href="#"><input type="image" id="btnAddOrg"
								src="/ProGate-portlet/images/lmis/configAttendanceInfo/config-symbol-add-disable.png"
								border="0" align="absmiddle" width="24" height="24"  disabled="disabled"/><span	id="addOrgLabel" class="addLabelDisable">
								<fmt:message key="lmis.config.email.add" /> </span> </a>
						</div>
					</div>
					<div id="clear-both"></div>
				</div>
				<br />
				<div class="div-seperator">
					<div class="col-left">
		
						<p>
							<br />
							<fmt:message key="lmis.config.email.peopleGetInvolved" />
						</p>
					</div>
					<div class="col-center">
						<div class="col-center-textarea">
							<textarea id="txtaddUser" rows="3" wrap="soft" spellcheck='false' disabled="disabled"></textarea>
						</div>
					</div>
					<div class="col-right">
						<div class="div-images">
							<a id="addStaff" href="#"><input type="image" id="btnAddUser"
								src="/ProGate-portlet/images/lmis/configAttendanceInfo/config-symbol-add-disable.png"
								border="0" align="absmiddle" width="24" height="24" disabled="disabled" /> <span id="addUserLabel" class="addLabelDisable">
								<fmt:message key="lmis.config.email.add" /> </span> </a>
						</div>
					</div>
					<div id="clear-both"></div>
				</div>
				<br />
		
			</div>
			<div align="center"
				style="padding-top: 10px; padding-bottom: 2px; clear: both">
				<input class="button-disable" id="save" type="button" value='<fmt:message key="button.save"/>' disabled="disabled" /> 
				<input	class="button-disable" id="cancel" type="button" value='<fmt:message key="button.cancel" />' disabled="disabled" />
			</div>
		</form>
		</c:when>
			<c:otherwise>
				<jsp:include page="../../noPermission.jsp"></jsp:include>
			</c:otherwise>	
	  </c:choose>
	</div>
	<jsp:include page="popup/popupRelatedOrg.jsp" />
	<jsp:include page="popup/popupStaffEmail.jsp"/>
</div>
<div id="backgroundPopup"></div>
