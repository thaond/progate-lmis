<%@page import="com.larion.progate.lmis.constants.Configuration_RS"%>
<%@ include file="../../../../common/init.jsp"%>
<%@ include file="../../../../lmis/initOfConfig.jsp" %>
<jsp:include page="../../../dialog/dialog-configAttFileOk.jsp" />
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="mode-edit">
	<input id="image-edit" type="image" src="/ProGate-portlet/images/lmis/configAttendanceInfo/edit.png" /> <a
		href="#" id="mode-edit-active"><fmt:message key="button.edit" />
	</a>
</div>
<!-- end edit button -->
<div class="clear-both"></div>
<form name="frmConfigFile" class="frmConfigFile" action=""	method="post">
	<div class="contentConfigFile">
		<div id="lblRequireField">
			<fmt:message key="lmis.common.requiredField" />
		</div>
		<div>
			<table width="100%" cellpadding="10" cellspacing="0">
				<tr height="33px">
					<td width="140px"><fmt:message key="lmis.config.file.attCode" /></td>
					<td width="300px">
						<input class="input-style" type="text" id="attCode" name="attCode" value="${bean.attCode}" 
						style="width: 200px; text-align: left" disabled="disabled" />
						<img id="help-icon" alt="" src="/ProGate-portlet/images/lmis/help.png" align="top" title='<fmt:message key="lmis.support.title"/>' />
						<div id="frmConfigFile_attCode_errorloc" class="error_strings"></div>
						</td>
					<td>&nbsp;</td>
				</tr>
				<tr height="33px">
					<td width="140px"><fmt:message key="lmis.config.file.staff"/></td>
					<td width="200px"><input class="input-style" id="staffName" value="${bean.staffName}" name="staffName" type="text" disabled="disabled" style="width: 200px; text-align: left"/> 
						<div id="frmConfigFile_staffName_errorloc" class="error_strings"></div>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr height="33px">
					<td width="140px"><fmt:message key="lmis.config.file.checkIn" /></td>
					<td width="200px"><input class="input-style" id="checkIn" name="checkIn" type="text" disabled="disabled" value="${bean.checkIn}" style="width: 200px; text-align: left">
						<div id="frmConfigFile_checkIn_errorloc" class="error_strings"></div>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr height="33px">
					<td width="140px"><fmt:message key="lmis.config.file.checkOut" /></td>
					<td width="200px"><input class="input-style" type="text" id="checkOut" name="checkOut" disabled="disabled" value="${bean.checkOut}" style="width: 200px; text-align: left" />
					<div id="frmConfigFile_checkOut_errorloc" class="error_strings"></div>
					</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
		<div style="padding-left: 140px; padding-top: 10px; padding-bottom: 10px;">
			<img alt="" src="/ProGate-portlet/images/lmis/big-info.png" align="absmiddle"><span style="vertical-align: -2px; padding-left: 5px;"><fmt:message key="lmis.config.file.info"/></span>
			<br>
			<p style="padding-left: 25px">Hiện tại ứng dụng "Quản lý thời gian" chỉ hỗ trợ file chấm công có tên mở rộng là csv, và kí tự phân cách là " , ".</p>
		</div>
	</div>
	<div align="center"	style="padding-top: 10px; padding-bottom: 0px; clear: both">
		<input class="button-disable" id="save" type="button" value='<fmt:message key="button.save"/>' disabled="disabled" /> 
		<input class="button-disable" id="cancel" type="button"	value='<fmt:message key="button.cancel" />' disabled="disabled" />
	</div>
</form>
<jsp:include page="../popup/help.jsp" />
<script type="text/javascript">
	
function saveConfigFile()
	{
		var url='<portlet:renderURL  >
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.ATTENDANCE_INFO_FILE_TAB%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.SAVE%>" />
			<portlet:param name="orgId" value="${bean.orgId}" />
			</portlet:renderURL>';
		var attCode = jQuery('#attCode').val();
		var staffName = jQuery('#staffName').val();
		var checkIn = jQuery('#checkIn').val();
		var checkOut = jQuery('#checkOut').val();
		jQuery.ajax({
			type : "POST",
			url : url,
			data : {
				"attCode":attCode,
				"staffName" : staffName,
				"checkIn" : checkIn,
				"checkOut" : checkOut
			},
			success: function(){
				var href='<portlet:renderURL>
					<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.ATTENDANCE_INFO_FILE_TAB%>" />
				<portlet:param name="orgId" value="${bean.orgId}" />
				</portlet:renderURL>';
				
				jQuery(".successful").css("display", "block");
			    jQuery(".successful").data('url',href).data('close',close).dialog("open");
			},
			error: function(){
				alert("Có lỗi xảy ra khi cấu hình file chấm công!")
			}
		});
	}	
jQuery(document).ready(function(){
			jQuery('.mode-edit').bind('click',function(){
				jQuery(this).attr('disabled', true);
				jQuery("#mode-edit-active").css('color','gray');
				jQuery("#image-edit").attr('src','/ProGate-portlet/images/lmis/configAttendanceInfo/Edit_disable.png');
				jQuery('#attCode').removeAttr('disabled');
				jQuery('#staffName').removeAttr('disabled');
				jQuery('#checkIn').removeAttr('disabled');
				jQuery('#checkOut').removeAttr('disabled');
				jQuery('#save').removeAttr('disabled');
				jQuery('#cancel').removeAttr('disabled');
				jQuery('#save').removeClass('button-disable').addClass('button-enable');
				jQuery('#cancel').removeClass('button-disable').addClass('button-enable');
		
		});
			
		jQuery('#save').click(function(e){
			var pass1 = true;
			var pass2 = true;
			var pass3 = true;
			var pass4 = true;
			e.preventDefault();
			if(jQuery('#attCode').val()==""){
				jQuery('#frmConfigFile_attCode_errorloc').text("Bạn chưa nhập cột mã chấm công");
				pass1=false;
			}else{
				jQuery('#frmConfigFile_attCode_errorloc').text("");
			}
			if(jQuery('#staffName').val()==""){
					jQuery('#frmConfigFile_staffName_errorloc').text("Bạn chưa nhập cột tên nhân viên");
				pass2=false;
			}else{
				jQuery('#frmConfigFile_staffName_errorloc').text("");
			}
			if(jQuery('#checkIn').val()==""){
				jQuery('#frmConfigFile_checkIn_errorloc').text("Bạn chưa nhập cột thời gian vào");
				pass2=false;
			}else{
				jQuery('#frmConfigFile_checkIn_errorloc').text("");
			}
			if(jQuery('#checkOut').val()==""){
				jQuery('#frmConfigFile_checkOut_errorloc').text("Bạn chưa nhập cột thời gian ra");
				pass2=false;
			}else{
				jQuery('#frmConfigFile_checkOut_errorloc').text("");
			}
			if(pass1==true && pass2==true && pass3==true && pass4==true){
				saveConfigFile();
			}
			
		});	
		jQuery('#cancel').click(function(){
			location.reload(true);
		});
});
	/// Enable all field to edit	
</script>