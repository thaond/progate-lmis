<%@page import="com.larion.progate.lmis.constants.LmisRequest"%>
<%@ include file="../../../../common/init.jsp"%>
<%@ include file="../../../../lmis/init-ttn.jsp" %>
<jsp:include page="../../../dialog/dialog-editOTReportOk.jsp" />
<jsp:include page="../../../dialog/dialog-createOTReportOk.jsp" />
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<form action="" name="frmRequestOTDetail" method="post">
	<div class="createChange"  style="margin-top:-30px">
			<input type="image" src="/ProGate-portlet/images/lmis/edit.png" href="#" id="editOvertimeReport" class="mode-edit-active">
		   	<a id="edit" style="vertical-align: 9px; font-weight: bold" href="#"><fmt:message key="button.edit"/></a>
	    <input id="ctl-back" type="image" src="/ProGate-portlet/images/lmis/undo.png" width="24" height="24"
		href="#" class="mode-edit-active">
	   	<a id="goBack" href="#" style="vertical-align: 9px; font-weight: bold;"><fmt:message key="lmis.common.back"/></a>
    </div>
	<div class="cls-ot">
		<div class="title-center"><fmt:message key="title.product.detail"/></div>
		<div class="req-field" style="display:none;"><fmt:message key="title.required.field"/></div>
		<div style="height:20px;width:100%"></div>
		<div class="content-left">
			<table width="100%" id="tbl-field">
				<thead>
					<tr>
						<th width="80px" scope="col" style="border: none;"></th>
						<th style="border:none;"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<fmt:message key="lmis.ot.reg.regday"/>
						</td>
						<td>
							<input class="date-req" type="text" name="today" value="<fmt:formatDate value='${bean.ls.createdAt}' pattern="dd/MM/yyyy"/>" readonly="readonly" disabled="disabled"/>
						</td>
					</tr>
					<tr>
						<td class="cls-org">
							<fmt:message key="lmis.ot.nameorg" />
						</td>
						<td>
							<input class="subOrg" style="margin-top:9px; margin-bottom: -4px;" type="text" name="slt-org" value="${bean.ls.orgName}" disabled="disabled" />
							<input id="subOrgId" type="hidden" value="${bean.ls.orgId}" />
						</td>
					</tr>
					<tr class="cls-reason">
						<td>
							<fmt:message key="lmis.ot.reg.reason"/>
						</td>
						<td>
							<textarea id="txt-reason" style="margin-top: 15px; height:90px; width: 350px" name="txt-reason"  disabled="disabled">
										${bean.ls.requestedReason}
							</textarea>
							<br>
							<label class="cls-error"><fmt:message key="lmis.ot.reg.errreason" /></label>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="content-right">
			<div class="date-ot">
				<span style="padding-right:5px"><fmt:message key="lmis.overtimeReport.reportDayLower"/></span><input class="reportDate" type="text" name="reportDate" value="${bean.currDate}" style="width:342px" disabled="disabled"/>
			</div>
			<div class="flt-right align-right" style="height:25px;"><label class="cls-error"><fmt:message key="lmis.ot.reg.errdate" /></label></div>
			<div class="clear-right"></div>
			<div class="feedback">
				<fieldset class="fbk-field">
					<legend><fmt:message key="lmis.ot.reg.feedback"/></legend>
					<textarea name="txt-fbk" style="width: 410px; height: 94px;" disabled="disabled" >${bean.feedback}</textarea>
				</fieldset>
				<label class="cls-error"><fmt:message key="lmis.ot.reg.errNook" /></label>
			</div>
		</div>
		<div class="clear"></div>
		<div class="tbl-title">
			<div class="mbr-join"><fmt:message key="lmis.ot.reg.mbr"/></div>
			<div class="err-special"></div>
		</div>
		<div class="clear"></div>
		<div class="tbl-mbr">
			<table id="tbl" class="viewDetail">
				<thead >
					<tr>
					<c:choose>
						<c:when test="${bean.cmd==bean.createReport}">
	 						<th scope="row" width="5%"><input name="checkAll" checked="checked" type="checkbox" disabled="disabled"/></th> 
	 					</c:when>
 					</c:choose>	
						<th scope="row" width="25%"><fmt:message key="lmis.commom.fullname.employee"/></th>
						<th scope="row" width="10%"><span title="<fmt:message key='lmis.overtimeReport.reqTime.toolTip'/>" ><fmt:message key="lmis.attendanceInfo.registeredStartTime"/></span></th>
						<th scope="row" width="7%"><span title="<fmt:message key='lmis.overtimeReport.regHours.toolTip'/>" ><fmt:message key="lmis.overtimeReport.regHours"/></span></th>
						<th scope="row" width="10%"><span title="<fmt:message key='lmis.overtimeReport.realStartTime.toolTip'/>" ><fmt:message key="lmis.overtimeReport.realStartTime"/></span></th>
						<th scope="row" width="6%"><span title="<fmt:message key='lmis.overtimeReport.realHours.toolTip'/>" ><fmt:message key="lmis.overtimeReport.realHours"/></span></th>
						<th scope="row" ><fmt:message key="lmis.overtimeReport.reason"/></th>
					</tr>
				</thead>
				<tbody id="viewAndEdit">
				<c:choose>
					<c:when test="${bean.cmd==bean.createReport}">
						<c:forEach items="${bean.listAll}" var="item" varStatus='i'>
							<c:choose>
								<c:when test="${i.count%2!=0 }">
									<tr class="oddrow">
								</c:when>
								<c:otherwise>
									<tr class="evenrow">
								</c:otherwise>
							</c:choose>
										<td style="text-align: center;"><input class="chk-item" type="checkbox" name="chk-item" checked="checked" value="${item.userId}" disabled="disabled" /></td>
										<td class="text-indent">${item.fullName }</td>
										<td class="cls-ctr txt">
											<input class="regTimeH time-align" name="regTimeH" type="text" value="${functions:getHour(item.startTime)}" maxlength="2" disabled="disabled"/> : 
											<input class="regTimeM time-align" name="regTimeM" type="text" value="${functions:getMin(item.startTime)}" maxlength="2" disabled="disabled" /> 
										</td>
										<td class="hour">
											<input class="regHour hour-align" name="regHour" type="text" value="${item.requestedHour}" maxlength="2" disabled="disabled">
										</td>
										<td class="cls-ctr txt" >
											<input class="realTimeH time-align" name="realTimeH" type="text" value="${functions:getHour(item.startTime)}" maxlength="2" /> : 
											<input class="realTimeM time-align" name="realTimeM" type="text" value="${functions:getMin(item.startTime)}" maxlength="2"/>
											<!-- hidden field to store default value -->
											<input id="defaultRealTimeH" type="hidden" value="${functions:getHour(item.startTime)}" maxlength="2" />
											<input id="defaultRealTimeM" type="hidden" value="${functions:getMin(item.startTime)}" maxlength="2"/>
										</td>
										<td class="hour">
											<input class="realHour hour-align" name="realHour" type="text" value="${item.requestedHour}" maxlength="3" />
											<input id="defaultRealHour" type="hidden" value="${item.requestedHour}" maxlength="2" />
										</td>
										<td class="tdreason"><input id="tdreason" name="tdreason" type="text" value="${item.reasonDetail}" disabled="disabled"/></td>
									</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="lmisViewReportOvertimeDetail" items="${bean.lmisViewReportOvertimeDetails}" varStatus="itemCount">
								<c:choose>
									<c:when test="${itemCount.count%2 !=0}">
										<tr class="oddrow">
									</c:when>
									<c:otherwise>
										<tr class="evenrow">
									</c:otherwise>	
								</c:choose>				
									<td class="text-indent">${lmisViewReportOvertimeDetail.fullName}<input class="chk-item" type="hidden" checked="checked"  name="chk-item" value="${lmisViewReportOvertimeDetail.userId}" /></td>
									<td align="center">
										<input id="reqHour" class="time-align" type="text"  value='<fmt:formatDate  value="${lmisViewReportOvertimeDetail.reqStartTime}" pattern="HH" />' disabled="disabled"/> : 
										<input class="time-align" id="reqMinute" type="text"  value='<fmt:formatDate  value="${lmisViewReportOvertimeDetail.reqStartTime}" pattern="mm" />' disabled="disabled"/> 
									</td>
									<td align="center" class="hour">
										<input class="hour-align" id="reqTotalHour" type="text" value="${lmisViewReportOvertimeDetail.reqRequestedHour}" disabled="disabled"/>
									</td>
									<td align="center">
										<input type="text" name="startTimeHour" class="startTimeHour time-align" value="${functions:getHour(lmisViewReportOvertimeDetail.startTime)}" disabled="disabled" maxlength="2"/> : 
										<input type="text" name="startTimeMinute" class="startTimeMinute time-align" value="${functions:getMin(lmisViewReportOvertimeDetail.startTime)}" disabled="disabled" maxlength="2"/>
										<input id="defaultRealTimeH" type="hidden" value="${functions:getHour(lmisViewReportOvertimeDetail.startTime)}" />
										<input id="defaultRealTimeM" type="hidden" value="${functions:getMin(lmisViewReportOvertimeDetail.startTime)}" /> 
									</td>
									<td align="center" class="hour">
										<input class="realHour hour-align" name="realHour" type="text" value="${lmisViewReportOvertimeDetail.totalHour}" disabled="disabled" maxlength="3"/>
										<input id="defaulRealHour" type="hidden" value="${lmisViewReportOvertimeDetail.totalHour}" />
									</td>
									<td class="tdreason"><input id="tdreason" type="text" value="${lmisViewReportOvertimeDetail.reportedReason}" disabled="disabled"/></td>
								</tr>
							</c:forEach>
					</c:otherwise>
				</c:choose>		
				</tbody>
			</table>
			
			<!-- enable this table when click edit or command equal "edit" -->
		</div>
	</div>
		<div class="align-right" style="padding-right:5px;">
<%-- 		<input class="default-button-disable" id="cancelSendReport" type="button" value="<fmt:message key="lmis.overtimeReport.reinput" />" disabled="disabled" /> --%>
		<input class="not-agree-disable" id="sendReport" type="submit" value="<fmt:message key="lmis.overtimeReport.sendReport" />" disabled="disabled"/>
	</div>
</form>
<div id="backgroundLoading" >
	<div id="imgLoad">
	<img  src="/ProGate-portlet/images/lmis/loader.gif" />
	</div>
</div>

<script type="text/javascript">

jQuery(document).ready(function() {
	//process showing data of users who worked overtime
	if(${bean.cmd==bean.EDIT}){
		jQuery('.date-req').val("<fmt:formatDate value='${bean.lmisViewReportOvertimeDetail.createdAt}' pattern='dd/MM/yyyy'/>");
		jQuery('.subOrg').val("${functions:getOrgNameByOrgId(bean.lmisViewReportOvertimeDetail.orgId)}");
		jQuery('#txt-reason').val("${bean.lmisViewReportOvertimeDetail.reportedReason}");
		jQuery('.reportDate').val("<fmt:formatDate  value='${bean.lmisViewReportOvertimeDetail.reportedAt}' pattern='dd/MM/yyyy'/>");
		jQuery('.startTimeHour, .startTimeMinute, .realHour').removeAttr("disabled");
		jQuery('#cancelSendReport').removeAttr('disabled');
		
		if(${bean.hideEdit==true}){
			jQuery('#editOvertimeReport, #edit').hide();
			jQuery('#sendReport').removeAttr('disabled');
			jQuery('#cancelSendReport').removeAttr('disabled');
			jQuery('#sendReport').removeClass('not-agree-disable').addClass('not-agree-enable');
			jQuery('#cancelSendReport').removeClass('default-button-disable').addClass('default-button-enable');
		}	
	}
	if(${bean.cmd==bean.createReport}){
		jQuery('#editOvertimeReport, #edit').css('display','none');
		jQuery('.realTimeH, .realTimeM, .realHour').removeAttr("disabled");
		jQuery('#sendReport').removeAttr("disabled");
		jQuery('#cancelSendReport').removeAttr('disabled');
		jQuery('#sendReport').removeClass('not-agree-disable').addClass('not-agree-enable');
		jQuery('#cancelSendReport').removeClass('default-button-disable').addClass('default-button-enable');
			
	}
	//display table  for edit
	if(${bean.cmd==bean.VIEW}){
		jQuery('.date-req').val("<fmt:formatDate value='${bean.lmisViewReportOvertimeDetail.createdAt}' pattern='dd/MM/yyyy'/>");
		jQuery('.subOrg').val("${functions:getOrgNameByOrgId(bean.lmisViewReportOvertimeDetail.orgId)}");
		jQuery('#txt-reason').val("${bean.lmisViewReportOvertimeDetail.reportedReason}");
		jQuery('.reportDate').val("<fmt:formatDate  value='${bean.lmisViewReportOvertimeDetail.reportedAt}' pattern='dd/MM/yyyy'/>");
		
		if(${bean.hideEditIcon==true}){
			jQuery('#editOvertimeReport, #edit').hide();
			jQuery('#sendReport').hide();
			jQuery('#cancelSendReport').hide();
		}	
	}
	
	//go back to previous page
	jQuery('#ctl-back, #goBack').click(function(e){
		goBack();
	});
});

function goBack(){
	var url='<portlet:renderURL>
		<portlet:param name="action" value="commonController"/>
		<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
		<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.GO_BACK%>"/>
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
	</portlet:renderURL>';
	document.frmRequestOTDetail.action=url;
	document.frmRequestOTDetail.submit();
}
jQuery(document).ready(function() {				
		jQuery('#editOvertimeReport, #edit').bind('click',function(e){
			e.preventDefault();
			jQuery('#editOvertimeReport').attr('disabled',true);
			jQuery('#edit').attr('disabled',true);
			jQuery('#edit').css('color','gray');
			jQuery('#editOvertimeReport').attr('src','/ProGate-portlet/images/lmis/Edit_disable.png');
			jQuery('#sendReport').removeAttr('disabled');
			jQuery('tbody#viewAndEdit input').not('#tdreason, #reqHour, #reqMinute, #reqTotalHour').removeAttr('disabled');
			jQuery('#cancelSendReport').removeAttr('disabled');
			jQuery('#sendReport').removeClass('not-agree-disable').addClass('not-agree-enable');
			jQuery('#cancelSendReport').removeClass('default-button-disable').addClass('default-button-enable');
		});
			
		jQuery('.chk-item').bind('click', function(e){
			if(this.checked==true){
				var tr= jQuery(this).parent().parent();
				jQuery(tr).find('.startTimeHour').removeAttr('disabled');
				jQuery(tr).find('.startTimeMinute').removeAttr('disabled');
				jQuery(tr).find('.realTimeH').removeAttr('disabled');
				jQuery(tr).find('.realTimeM').removeAttr('disabled');
				jQuery(tr).find('.realHour').removeAttr('disabled');
			}
			if(this.checked==false){
				var tr= jQuery(this).parent().parent();
				jQuery(tr).find('.realTimeH').attr('disabled', true);
				jQuery(tr).find('.realTimeM').attr('disabled', true);
				jQuery(tr).find('.realHour').attr('disabled', true);
				jQuery(tr).find('.startTimeHour').attr('disabled', true);
				jQuery(tr).find('.startTimeMinute').attr('disabled', true);
			}
		});
		
		//checkall
		jQuery('input[name=checkAll][type=checkbox]').bind('click', function(){
			if(this.checked==true){
				jQuery('input[name=chk-item][type=checkbox]').each(function(){
					this.checked=true;
					var tr= jQuery(this).parent().parent();
					jQuery(tr).find('.realTimeH').removeAttr('disabled', true);
					jQuery(tr).find('.realTimeM').removeAttr('disabled', true);
					jQuery(tr).find('.realHour').removeAttr('disabled', true);
		
				});		
			}
			else{
				jQuery('input[name=chk-item][type=checkbox]').each(function(){
					this.checked=false;	
					var tr= jQuery(this).parent().parent();
					jQuery(tr).find('.realTimeH').attr('disabled', true);
					jQuery(tr).find('.realTimeM').attr('disabled', true);
					jQuery(tr).find('.realHour').attr('disabled', true);
					jQuery(tr).find('#tdreason').attr('disabled', true);
				});
			}
		});
		
});

jQuery(document).ready(function(){
	jQuery('.realTimeH, .realTimeM, .startTimeHour, .startTimeMinute,').keydown(function(e){
		if ( e.keyCode == 46 || e.keyCode == 8) {
    		// let it happen, don't do anything
    	}
    	else {
    		// Ensure that it is a number and stop the keypress
    		if (e.keyCode < 48 || e.keyCode > 57 ) {
    			e.preventDefault();
    		}
    	}
	});
	jQuery('.realHour').keydown(function(e){
		if ( e.keyCode == 46 || e.keyCode == 8 || e.keyCode==190 || e.keyCode==9 || keyCode==37 || keyCode==38 || keyCode==39 || keyCode==40) {
    		// let it happen, don't do anything
    	}
    	else {
    		// Ensure that it is a number and stop the keypress
    		if (e.keyCode < 48 || e.keyCode > 57 ) {
    			e.preventDefault();
    		}
    	}
	});
	//get the default value when value of textbox equal zero startTimeHour
	jQuery('.startTimeHour').blur(function(){
		var value= jQuery(this).val();
		if(value==0 || value==""){
			jQuery(this).val(jQuery('#defaultRealTimeH').val());
		}
	});
	jQuery('.startTimeMinute').blur(function(){
		var value= jQuery(this).val();
		if(value==0 || value==""){
			jQuery(this).val(jQuery('#defaultRealTimeM').val());
		}
	});
	jQuery('.realHour').blur(function(){
		var value= jQuery(this).val();
		if(value==0 || value==""){
			jQuery(this).val(jQuery('#defaulRealHour').val());
		}
	});
	
	jQuery('.realTimeH').blur(function(){
		var value= jQuery(this).val();
		if(value==0 || value==""){
			jQuery(this).val(jQuery('#defaultRealTimeH').val());
		}
	});
	jQuery('.realTimeM').blur(function(){
		var value= jQuery(this).val();
		if(value==0 || value==""){
			jQuery(this).val(jQuery('#defaultRealTimeM').val());
		}
	});
	
	jQuery("#sendReport").bind('click', function(e){	
		e.preventDefault();
		if(${bean.cmd == bean.createReport}){
			var pass= true;
			jQuery('input[@name="chk-item"][checked]').each(function(){
				var tr = jQuery(this).parent().parent();
				if(jQuery(tr).find('.realHour').val() > 10){
					jQuery('div.err-special').text("<fmt:message key='lmis.overtimeReport.hourError'/>");
					pass= false;
					return false;
				}
			});
			if(pass==true){
				loadBackground();
				createReport();
			}
		}
		else{// edit overtime report
			var pass= true;
			jQuery('input[@name="chk-item"]').each(function(){
				var tr = jQuery(this).parent().parent();
				if(jQuery(tr).find('.realHour').val() >10){
					jQuery('div.err-special').text("<fmt:message key='lmis.overtimeReport.hourError'/>");
					pass= false;
					return false;
				}
			});
			if(pass==true){
				loadBackground();
				editReport();
			}
			
		}
	});
	//cancel sending report
	jQuery('#cancelSendReport').bind('click', function(){
		location.reload(true);
	});
});

function createReport(){
	var regDate = '${bean.ls.createdAt}';
	var otReason = '${bean.ls.requestedReason}';
	var repDate = '${bean.currDate}';
	var subOrgId = jQuery('#subOrgId').val();
	var reportId = '${bean.reportId}';
	var arrUID = new Array();
	var arrTotal = new Array();
	var arrHM = new Array();
	var arrEndTime= new Array();	
	jQuery('tbody#viewAndEdit input[@name=chk-item]:checked').each(function(i){
		var p = jQuery(this).parent().parent();
			arrUID.push(jQuery(p).find('input[@name=chk-item]').val());
			var total =jQuery(p).find('input[@name=realHour]').val();
			arrTotal.push(total);
			var H =jQuery(p).find('input[@name=realTimeH]').val();
			var M =jQuery(p).find('input[@name=realTimeM]').val();
			arrHM.push(H+"/"+M);
			iH = parseInt(H) + parseInt(total);
			arrEndTime.push(iH+"/"+M);
	});
		var href='<portlet:renderURL >
			<portlet:param name="action" value="commonController"/>
		<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
		<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.SEND_REPORT%>"/>
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
		<portlet:param name="mode" value="create" />
		</portlet:renderURL>';
			
			
		jQuery.ajax({
			type : "POST",
			url : href,
			data : {
				"subOrgId": subOrgId,
				"reportId" : reportId,
				"otReason" : otReason,
				"regDate": regDate,
				"repDate": repDate,
				"arrUserId": arrUID,
				"arrTotalHour": arrTotal,
				"arrHM": arrHM,
				"arrEndTime": arrEndTime
				},
				success: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".successful").css("display", "block");
				    	jQuery(".successful").data('url',href).data('close',close).dialog("open");
				},
				error: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".successful").css("display", "block");
				   	jQuery(".successful").data('url',href).data('close',close).dialog("open");
				}
		});
}

function editReport(){
	var regDate = '${bean.lmisViewReportOvertimeDetail.createdAt}';
	var otReason = '${bean.lmisViewReportOvertimeDetail.reportedReason}';
	var arrUID = new Array();
	var arrTotal = new Array();
	var arrHM = new Array();
	var arrEndTime= new Array();
	var reportId='${bean.lmisViewReportOvertimeDetail.otRepId}';
	jQuery('tbody#viewAndEdit input[@name=chk-item]:checked').each(function(i){
		var p = jQuery(this).parent().parent();
		arrUID.push(jQuery(p).find('input[@name=chk-item]').val());
			var total =jQuery(p).find('input[@name=realHour]').val();
			arrTotal.push(total);
			var H =jQuery(p).find('input[@name=startTimeHour]').val();
			var M =jQuery(p).find('input[@name=startTimeMinute]').val();
			arrHM.push(H+"/"+M);
			iH = parseInt(H) + parseInt(total);
			arrEndTime.push(iH+"/"+M);
	});

		var	 href='<portlet:renderURL >
				<portlet:param name="action" value="commonController"/>
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
				<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.SEND_REPORT%>"/>
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				<portlet:param name="mode" value="edit" />
				</portlet:renderURL>';	
				
		var subOrgId = '${bean.lmisViewReportOvertimeDetail.orgId}';
		var repDate = '${bean.lmisViewReportOvertimeDetail.reportedAt}';
		jQuery.ajax({
			type : "POST",
			url : href,
			data : {
				"subOrgId": subOrgId,
				"otReason" : otReason,
				"reportId" : reportId,
				"regDate": regDate,
				"repDate": repDate,
				"arrUserId": arrUID,
				"arrTotalHour": arrTotal,
				"arrHM": arrHM,
				"arrEndTime": arrEndTime
				},
				success: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".updateSuccess").css("display", "block");
				   	jQuery(".updateSuccess").data('url',href).data('close',close).dialog("open");
				},
				error: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".updateSuccess").css("display", "block");
				   	jQuery(".updateSuccess").data('url',href).data('close',close).dialog("open");
				}
		});
	
}

function loadBackground(){
	jQuery("#backgroundLoading").css({
			"opacity": "0.7"
		});
	jQuery("#backgroundLoading").fadeIn("slow");
}

</script>