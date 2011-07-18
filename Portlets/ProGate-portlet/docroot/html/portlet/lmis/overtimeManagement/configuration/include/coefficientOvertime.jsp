<%@page import="com.larion.progate.lmis.constants.Configuration_RS"%>
<%@ include file="../../../../common/init.jsp"%>
<%@ include file="../../../../lmis/initOfConfig.jsp"%>
<jsp:include page="../../../dialog/dialog-configCoefficientOk.jsp" />
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

jQuery(document).ready(function(){
	jQuery('#coefficientType1, #coefficientType2, #coefficientType3').keydown(function(e){
		if (  e.keyCode == 46 || e.keyCode == 8 || e.keyCode==190 || e.keyCode==9 || keyCode==37 || keyCode==38 || keyCode==39 || keyCode==40) {
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
	function mySelect()
	{
		var url='<portlet:renderURL >
			<portlet:param name="action" value="configuration" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.COEFFICIENTOVERTIME_TAB%>" />
			<portlet:param name="orgId" value="${bean.orgId}" />
			</portlet:renderURL>';
			
			document.frmConfigCoefficientOvertime.action=url;
			document.frmConfigCoefficientOvertime.submit();
	}
	
	function saveOvertimeSetting()
	{		
		var url='<portlet:renderURL >
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.COEFFICIENTOVERTIME_TAB%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>" />
			<portlet:param name="orgId" value="${bean.orgId}" />
			</portlet:renderURL>';
			
			var coefficientType1 = jQuery('#coefficientType1').val();
			var coefficientType2 = jQuery('#coefficientType2').val();
			var coefficientType3 = jQuery('#coefficientType3').val();
			var settingId1 = ${bean.lmisViewDayTypeOverTimeSettingTypeId1};
			var settingId2 = ${bean.lmisViewDayTypeOverTimeSettingTypeId2};
			var settingId3 = ${bean.lmisViewDayTypeOverTimeSettingTypeId3};
			var dayId1 =  ${bean.OvertimeTypeDayId1};
			var dayId2 =  ${bean.OvertimeTypeDayId2};
			var dayId3 =  ${bean.OvertimeTypeDayId3};
			var otId1 =  ${bean.OvertimeTypeOtId1};
			var otId2 =  ${bean.OvertimeTypeOtId2};
			var otId3 =  ${bean.OvertimeTypeOtId3};
			var noteType1 = jQuery('#noteType1').val();
			var noteType2 = jQuery('#noteType2').val();
			var noteType3 = jQuery('#noteType3').val();
			jQuery.ajax({
				type: "POST",
				url: url,
				data: {
					"settingId1": settingId1,
					"settingId2": settingId2,
					"settingId3": settingId3,
					"dayId1": dayId1 ,
					"dayId2": dayId2,
					"dayId3": dayId3,
					"otId1": otId1,
					"otId2": otId2,
					"otId3": otId3,
					"coefficientType1": coefficientType1,
					"coefficientType2": coefficientType2,
					"coefficientType3": coefficientType3,
					"noteType1": noteType1,
					"noteType2": noteType1,
					"noteType3": noteType1
				},
				success: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.COEFFICIENTOVERTIME_TAB%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".successful").css("display", "block");
				    jQuery(".successful").data('url',href).data('close',close).dialog("open");
				},
				error: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.COEFFICIENTOVERTIME_TAB%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".successful").css("display", "block");
				    jQuery(".successful").data('url',href).data('close',close).dialog("open");
				}
			});	
	}
	
	jQuery(document).ready(function(){
			jQuery('.mode-edit').bind('click',function(){
				jQuery(this).attr('disabled', true);
				jQuery("#mode-edit-active").css('color','gray');
				jQuery("#image-edit").attr('src','/ProGate-portlet/images/lmis/configAttendanceInfo/Edit_disable.png')
				jQuery('#coefficientType1').removeAttr('disabled');
				jQuery('#coefficientType2').removeAttr('disabled');
				jQuery('#coefficientType3').removeAttr('disabled');
				jQuery('#noteType1').removeAttr('disabled');
				jQuery('#noteType2').removeAttr('disabled');
				jQuery('#noteType3').removeAttr('disabled');
				jQuery('#saveCoefficientOvertime').removeAttr('disabled');
				jQuery('#cancelCoefficientOvertime').removeAttr('disabled');
				jQuery('#saveCoefficientOvertime').removeClass('button-disable').addClass('button-enable');
				jQuery('#cancelCoefficientOvertime').removeClass('button-disable').addClass('button-enable');
		
		});
			
		jQuery('#saveCoefficientOvertime').click(function(){
			var pass1 = true;
			var pass2 = true;
			var pass3 = true;
			if(jQuery('#coefficientType1').val()==""){
				jQuery('#coefficientType1_errorloc').text("Bạn chưa nhập hệ số tăng ca loại 1");
				pass1=false;
			}else{
				jQuery('#coefficientType1_errorloc').text("");
			}
			
			if(jQuery('#coefficientType2').val()==""){
					jQuery('#coefficientType2_errorloc').text("Bạn chưa nhập hệ số tăng ca loại 2");
				pass2=false;
			}else{
				jQuery('#coefficientType2_errorloc').text("");
			}
			
			if(jQuery('#coefficientType3').val()==""){
				jQuery('#coefficientType3_errorloc').text("Bạn chưa nhập hệ số tăng ca loại 3");
				pass3=false;
			}else{
				jQuery('#coefficientType3_errorloc').text("");
			}
			
			if(pass1==true && pass2==true && pass3==true){
				saveOvertimeSetting();
			}
		});	
		jQuery('#cancelCoefficientOvertime').click(function(){
			mySelect();
	});
});
	/// Enable all field to edit	
</script>

<div class="mode-edit">
	<input id="image-edit" type="image"
		src="/ProGate-portlet/images/lmis/configAttendanceInfo/edit.png" /> <a
		href="#" id="mode-edit-active"><fmt:message key="button.edit" />
	</a>
</div>
<!-- end edit button -->
<div class="clear-both"></div>
<form name="frmConfigCoefficientOvertime" class="frmConfigCoefficientOvertime" action="" method="post">
	<div class="contentConfigCoefficientOvertime">
		<div id="lblRequireField">
			<fmt:message key="lmis.common.requiredField" />
		</div>
		<div>
			<table width="100%" cellpadding="10" cellspacing="0">
				<tr>
					<td><fmt:message
							key="lmis.common.dayTypeLower" /></td>
					<td><select name="<%=Configuration_RS.DAY_TYPE%>" id="dayType" style="width: 153px" onchange="mySelect()">
							<c:forEach items="${bean.lmisDayTypes}"	var="lmisDayType">
								<c:choose>
									<c:when	test='${lmisDayType.dayType == bean.dayType}'>
										<option value='${lmisDayType.dayType}' selected="selected">
											<c:out value='${lmisDayType.name}' />
										</option>
									</c:when>

									<c:otherwise>
										<option value='${lmisDayType.dayType}'>
											<c:out value='${lmisDayType.name}' />
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
	
					<td width="160px"><fmt:message key="lmis.config.coefficientOvertime.type1" /></td>
					<td width="200px"><input type="text" class="input-style" id="coefficientType1" name="coefficientType1" 	value='${bean.OvertimeTypeCoefficient1}' disabled="disabled" />
					<div id="coefficientType1_errorloc" class="error_strings"></div>
					</td>
					<td>&nbsp;</td>
					<td width="100px"><fmt:message key="lmis.config.coefficientOvertime.note1" /></td>
					<td><input id="noteType1" class="input-style" name="noteType1" type="text"	value="${bean.OvertimeTypeDayDescription1}" disabled="disabled"	/>
						<input type="hidden" name='dayId1' value='${bean.OvertimeTypeDayId1}' />
						<input type="hidden" name='otId1' value='${bean.OvertimeTypeOtId1}' />
						<input type="hidden" name='settingId1' value='${bean.lmisViewDayTypeOverTimeSettingTypeId1}' /></td>
				</tr>
			
				<tr height="33px">
	
					<td width="160px"><fmt:message key="lmis.config.coefficientOvertime.type2" /></td>
					<td width="200px"><input type="text" class="input-style" id="coefficientType2" name="coefficientType2" value='${bean.OvertimeTypeCoefficient2}' disabled="disabled" />
					<div id="coefficientType2_errorloc" class="error_strings"></div>
					</td>
					<td>&nbsp;</td>
					<td width="100px"><fmt:message key="lmis.config.coefficientOvertime.note2" /></td>
					<td><input id="noteType2" class="input-style" name="noteType2" type="text"	value="${bean.OvertimeTypeDayDescription2}" disabled="disabled"	/>
						<input type="hidden" name='dayId2' value='${bean.OvertimeTypeDayId2}' />
						<input type="hidden" name='otId2' value='${bean.OvertimeTypeOtId2}' />
						<input type="hidden" name='settingId2' value='${bean.lmisViewDayTypeOverTimeSettingTypeId2}' />
					</td>
				</tr>
				<tr height="33px">
	
					<td width="160px"><fmt:message key="lmis.config.coefficientOvertime.type3" /></td>
					<td width="200px"><input type="text" class="input-style" id="coefficientType3" name="coefficientType3" value='${bean.OvertimeTypeCoefficient3}' disabled="disabled" />
					<div id="coefficientType3_errorloc" class="error_strings"></div>
					</td>
					<td>&nbsp;</td>
					<td width="100px" ><fmt:message key="lmis.config.coefficientOvertime.note3" /></td>
					<td><input id="noteType3" class="input-style" name="noteType3" type="text"	value="${bean.OvertimeTypeDayDescription3}" disabled="disabled"	 />
						<input type="hidden" name='dayId3' value='${bean.OvertimeTypeDayId3}' />
						<input type="hidden" name='otId3' value='${bean.OvertimeTypeOtId3}' />	
						<input type="hidden" name='settingId3' value='${bean.lmisViewDayTypeOverTimeSettingTypeId3}' />
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div align="center"	style="padding-top: 10px; padding-bottom: 3px; clear: both">
		<input class="button-disable" id="saveCoefficientOvertime" type="button" value='<fmt:message key="button.save"/>' disabled="disabled" /> 
		<input class="button-disable" id="cancelCoefficientOvertime" type="button"	value='<fmt:message key="button.cancel" />' disabled="disabled" />
	</div>
</form>
