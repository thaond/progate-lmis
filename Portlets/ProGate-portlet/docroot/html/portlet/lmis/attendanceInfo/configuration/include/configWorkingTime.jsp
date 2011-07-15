<%@page import="com.larion.progate.lmis.constants.Configuration_RS"%>
<%@ include file="../../../../common/init.jsp"%>
<%@ include file="../../../../lmis/initOfConfig.jsp" %>
<jsp:include page="../../../dialog/dialog-configWorkingTimeOk.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="mode-edit">
	<input id="image-edit" type="image" src="/ProGate-portlet/images/lmis/configAttendanceInfo/edit.png" /> <a
		href="#" id="mode-edit-active"><fmt:message key="button.edit" />
	</a>
</div>
<!-- end edit button -->
<div class="clear-both"></div>
<form name="frmConfigWorkingTime" class="frmConfigWorkingTime" action=""
	method="post">
	<div class="contentConfigWorkingTime">
		<div id="lblRequireField">
			<fmt:message key="lmis.common.requiredField" />
		</div>
		<div>
			<table width="100%" cellpadding="10" cellspacing="0">
				<tr>
					<td width="160px"><fmt:message
							key="lmis.config.workingTime.workingTimetSesion" /></td>
					<td><select id="sessionName" name="<%=Configuration_RS.SESSION_NAME%>" id="sessionName" style="width: 155px" onchange="mySelect(true)">
							<c:forEach items="${bean.lmisWorkingTimesList}"	var="lmisWorkingTime">
								<c:choose>
									<c:when
										test='${lmisWorkingTime.lmisWorkingTimeId == bean.lmisWorkingTimeID}'>
										<option value='${lmisWorkingTime.lmisWorkingTimeId}' selected="selected">
											<c:out value='${lmisWorkingTime.sessionName}' />
										</option>
									</c:when>

									<c:otherwise>
										<option value='${lmisWorkingTime.lmisWorkingTimeId}'>
											<c:out value='${lmisWorkingTime.sessionName}' />
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr height="33px">

					<td width="160px"><fmt:message key="lmis.config.workingTime.startTime" /></td>
					<td width="200px">
						<input class="input-style" type="text" id="startTimeHour" name="<%=Configuration_RS.START_TIME_HOUR %>" style="width: 69px; text-align: right" value='<fmt:formatDate  value="${bean.lmisWorkingTimes.startTime}" pattern="HH" />' disabled="disabled" maxlength="2" /> : 
						<input class="input-style" type="text" id="startTimeMinute"	name="<%=Configuration_RS.START_TIME_MINUTE%>" style="width: 69px;text-align: right" value='<fmt:formatDate  value="${bean.lmisWorkingTimes.startTime}" pattern="mm" />'	disabled="disabled" maxlength="2"/>
						<div id="frmConfigWorkingTime_startTimeHour_errorloc" class="error_strings"></div>
						</td>
					<td>&nbsp;</td>
					<td width="185px"><fmt:message key="lmis.config.workingTime.maxLate" /></td>
					<td><input class="input-style" id="maxLate" name="<%=Configuration_RS.MAX_LATE%>" type="text"	value="${bean.lmisWorkingTimes.maxLate}" disabled="disabled"
						style="width: 150px; text-align: right">
					</td>
				</tr>
				<tr height="33px">
					<td width="160px"><fmt:message key="lmis.config.workingTime.endTime"/></td>
					<td width="200px"><input class="input-style" id="endTimeHour" name="<%=Configuration_RS.END_TIME_HOUR%>" type="text"	value='<fmt:formatDate  value="${bean.lmisWorkingTimes.endTime}" pattern="HH" />'
						disabled="disabled" style="width: 69px; text-align: right" maxlength="2"/> : 
						<input class="input-style" id="endTimeMinute" name="<%=Configuration_RS.END_TIME_MINUTE%>" type="text"	value='<fmt:formatDate  value="${bean.lmisWorkingTimes.endTime}" pattern="mm" />'
						disabled="disabled" style="width: 69px; text-align: right" maxlength="2"/>
						<div id="frmConfigWorkingTime_endTimeHour_errorloc" class="error_strings"></div>
					</td>
					<td>&nbsp;</td>
					<td width="185px"><fmt:message key="lmis.config.workingTime.maxEarly" /></td>
					<td><input class="input-style" type="text" id="maxEarly" name="<%=Configuration_RS.MAX_EARLY%>"	disabled="disabled" value="${bean.lmisWorkingTimes.maxEarly }"
						style="width: 150px; text-align: right"></td>
				</tr>
				<tr height="33px">
					<td width="160px"><fmt:message key="lmis.config.workingTime.limitLate" /></td>
					<td width="200px"><input class="input-style" id="limitLate" name="<%=Configuration_RS.LIMIT_LATE%>" type="text"
						disabled="disabled" value="${bean.lmisWorkingTimes.limitLate}"	style="width: 152px; text-align: right">
					</td>
					<td>&nbsp;</td>
					<td width="185px"><fmt:message key="lmis.config.workingTime.coefficientLate" />
					</td>
					<td><input class="input-style" id="coefficientLate" name="<%=Configuration_RS.COEFFICIENT_LATE%>"
						type="text" disabled="disabled"
						value="${bean.lmisWorkingTimes.coefficientLate}"
						style="width: 150px; text-align: right">
					</td>
				</tr>
				<tr height="33px">
					<td width="160px"><fmt:message key="lmis.config.workingTime.limitEarly" /></td>
					<td width="200px"><input class="input-style" type="text" id="limitEarly" name="<%=Configuration_RS.LIMIT_EARLY%>" disabled="disabled" value="${bean.lmisWorkingTimes.limitEarly}"
						style="width: 152px; text-align: right" />	</td>
					<td>&nbsp;</td>
					<td width="185px"><fmt:message key="lmis.config.workingTime.coefficientEarly" />
					</td>
					<td><input class="input-style" type="text" id="coefficientEarly" name="<%=Configuration_RS.COEFFICIENT_EARLY%>" disabled="disabled"
						value="${bean.lmisWorkingTimes.coefficientEarly}" style="width: 150px;text-align: right">
					</td>
				</tr>

			</table>
		</div>
	</div>
	<div align="center"	style="padding-top: 10px; padding-bottom: 0px; clear: both">
		<input class="button-disable" id="save" type="button" value='<fmt:message key="button.save"/>' disabled="disabled" /> 
		<input class="button-disable" id="cancel" type="button"	value='<fmt:message key="button.cancel" />' disabled="disabled" />
	</div>
</form>

<script type="text/javascript">
//validate config working time
jQuery(document).ready(function(){
	jQuery("input[type='text']").not('#coefficientLate').not('#coefficientEarly').keydown(function(e){
		if ( e.keyCode == 46 || e.keyCode == 8 || e.keyCode==9 || keyCode==37 || keyCode==38 || keyCode==39 || keyCode==40) {
    		// let it happen, don't do anything
    	}
    	else {
    		// Ensure that it is a number and stop the keypress
    		if (e.keyCode < 48 || e.keyCode > 57 ) {
    			e.preventDefault();
    		}
    	}
	});
	jQuery("#coefficientLate, #coefficientEarly").keydown(function(e){
		if ( e.keyCode == 46 || e.keyCode == 8 || e.keyCode==190) {
    		// let it happen, don't do anything
    	}
    	else {
    		// Ensure that it is a number and stop the keypress
    		if (e.keyCode < 48 || e.keyCode > 57 ) {
    			e.preventDefault();
    		}
    	}
	});
});

	function mySelect(check){
		var value;
		if(check==false){
			 value = check;}
			else{
					value = jQuery(".mode-edit").attr("disabled");
				}	
			
		var url='<portlet:renderURL  >
			<portlet:param name="action" value="configuration" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.WORKINGTIME_TAB%>" />
			<portlet:param name="orgId" value="${bean.orgId}" />
			<portlet:param name="disable" value="disabled" />
			</portlet:renderURL>' ;
			 
 			url=url.replace("disabled",value);
			document.frmConfigWorkingTime.action=url;
			document.frmConfigWorkingTime.submit();
}
	jQuery(document).ready(function(){
			if(${bean.disable==true}){
				jQuery('.mode-edit').attr('disabled', true);
				jQuery("#mode-edit-active").css('color','gray');
				jQuery("#image-edit").attr('src','/ProGate-portlet/images/lmis/configAttendanceInfo/Edit_disable.png');
				jQuery('#startTimeMinute').removeAttr('disabled');
				jQuery('#endTimeMinute').removeAttr('disabled');
				jQuery('#startTimeHour').removeAttr('disabled');
				jQuery('#endTimeHour').removeAttr('disabled');
				jQuery('#maxLate').removeAttr('disabled');
				jQuery('#maxEarly').removeAttr('disabled');
				jQuery('#limitLate').removeAttr('disabled');
				jQuery('#limitEarly').removeAttr('disabled');
				jQuery('#coefficientEarly').removeAttr('disabled');
				jQuery('#coefficientLate').removeAttr('disabled');
				jQuery('#save').removeAttr('disabled');
				jQuery('#cancel').removeAttr('disabled');
				jQuery('#save').removeClass('button-disable').addClass('button-enable');
				jQuery('#cancel').removeClass('button-disable').addClass('button-enable');
			}
	
});	
function saveWorkingTime()
	{
		var url='<portlet:renderURL  >
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.WORKINGTIME_TAB%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.SAVE%>" />
			<portlet:param name="orgId" value="${bean.orgId}" />
			</portlet:renderURL>';
		
		var sessionName = jQuery('#sessionName').val();
		var startTimeHour = jQuery('#startTimeHour').val();
		var startTimeMinute = jQuery('#startTimeMinute').val();
		var maxLate = jQuery('#maxLate').val();
		var endTimeHour = jQuery('#endTimeHour').val();
		var endTimeMinute = jQuery('#endTimeMinute').val();
		var maxEarly = jQuery('#maxEarly').val();
		var limitLate = jQuery('#limitLate').val();
		var coefficientLate = jQuery('#coefficientLate').val();
		var limitEarly = jQuery('#limitEarly').val();
		var coefficientEarly = jQuery('#coefficientEarly').val();
			jQuery.ajax({
				type: "POST",
				url : url,
				data : {
					'sessionName': sessionName,
					'startTimeHour': startTimeHour,
					'startTimeMinute': startTimeMinute,
					'maxLate': maxLate,
					'endTimeHour': endTimeHour,
					'endTimeMinute': endTimeMinute,
					'maxEarly': maxEarly,
					'limitLate': limitLate,
					'coefficientLate': coefficientLate,
					'limitEarly': limitEarly,
					'coefficientEarly': coefficientEarly
					
				},
				success: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.WORKINGTIME_TAB%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".successful").css("display", "block");
				    	jQuery(".successful").data('url',href).data('close',close).dialog("open");
				},
				error: function(){
					alert("Có lỗi xảy ra khi lưu cấu hình thời gian làm việc!");
				}
			});
		/* alert("Bạn đã cấu hình thời gian làm việc thành công!"); */
	}	
jQuery(document).ready(function(){
			jQuery('.mode-edit').bind('click',function(){
				jQuery(this).attr('disabled', true);
				jQuery("#mode-edit-active").css('color','gray');
				jQuery("#image-edit").attr('src','/ProGate-portlet/images/lmis/configAttendanceInfo/Edit_disable.png');
				jQuery('#startTimeMinute').removeAttr('disabled');
				jQuery('#endTimeMinute').removeAttr('disabled');
				jQuery('#startTimeHour').removeAttr('disabled');
				jQuery('#endTimeHour').removeAttr('disabled');
				jQuery('#maxLate').removeAttr('disabled');
				jQuery('#maxEarly').removeAttr('disabled');
				jQuery('#limitLate').removeAttr('disabled');
				jQuery('#limitEarly').removeAttr('disabled');
				jQuery('#coefficientEarly').removeAttr('disabled');
				jQuery('#coefficientLate').removeAttr('disabled');
				jQuery('#save').removeAttr('disabled');
				jQuery('#cancel').removeAttr('disabled');
				jQuery('#save').removeClass('button-disable').addClass('button-enable');
				jQuery('#cancel').removeClass('button-disable').addClass('button-enable');
		
		});
			
		jQuery('#save').click(function(e){
			var pass1 = true;
			var pass2 = true;
			if(jQuery('#startTimeHour').val()=="" || jQuery('#startTimeMinute').val()==""){
				jQuery('#frmConfigWorkingTime_startTimeHour_errorloc').text("Bạn chưa nhập thời gian bắt đầu");
				pass1=false;
			}else{
				jQuery('#frmConfigWorkingTime_startTimeHour_errorloc').text("");
			}
			if(jQuery('#endTimeHour').val()=="" || jQuery('#endTimeMinute').val()==""){
					jQuery('#frmConfigWorkingTime_endTimeHour_errorloc').text("Bạn chưa nhập thời gian kết thúc");
				pass2=false;
			}else{
				jQuery('#frmConfigWorkingTime_endTimeHour_errorloc').text("");
			}
			if(pass1==true && pass2==true){
				saveWorkingTime();
			}
			
		});	
		jQuery('#cancel').click(function(){
			mySelect(false);
		});
});
	/// Enable all field to edit	
</script>