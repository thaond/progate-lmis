<%@ page import="com.larion.progate.lmis.constants.LmisRequest" %>
<%@ include file="../../../../common/init.jsp" %>
<%@ include file="../../../../lmis/init-ttn.jsp" %>
<jsp:include page="../../../dialog/dialog-approveOTReportOk.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
	jQuery(document).ready(function(){
		if(${bean.hideApprove==true}){
			jQuery('#approve, #aproveReport').css('display','none');
			jQuery("textarea[name='feedback']").removeAttr('disabled');
			jQuery("#agreeReport").removeAttr("disabled");
			jQuery("#notAgreeReport").removeAttr("disabled");
			jQuery("#agreeReport").removeClass('default-button-disable').addClass('default-button-enable');
			jQuery("#notAgreeReport").removeClass('not-agree-disable').addClass('not-agree-enable');
		}
		if(${bean.hideApproveOfView == true}){
			jQuery('#approve, #aproveReport').css('display','none');
		}
		
		jQuery('#ctl-back, #goBack').click(function(){
			goBack();
		});

		jQuery('#approve, #aproveReport').bind('click',function(e){
			e.preventDefault();
			jQuery('#approve').attr('disabled',true);
			jQuery('#aproveReport').attr('disabled',true);
			jQuery('#aproveReport').css('color','gray');
			jQuery('#approve').attr('src','/ProGate-portlet/images/lmis/overtimeManagement/Pheduyet_Disable.png');
			jQuery("textarea[name='feedback']").removeAttr('disabled');
			jQuery("#agreeReport").removeAttr("disabled");
			jQuery("#notAgreeReport").removeAttr("disabled");
			jQuery("#agreeReport").removeClass('default-button-disable').addClass('default-button-enable');
			jQuery("#notAgreeReport").removeClass('not-agree-disable').addClass('not-agree-enable');
		});

		/* agree or do not agree */
		jQuery("#agreeReport").bind('click', function(){
			approveOverTimeReport(true);
		});
		jQuery("#notAgreeReport").bind('click', function(){
			approveOverTimeReport(false);
		});
});
	
	function approveOverTimeReport(status){
		if(status==true){
		var url='<portlet:renderURL >
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.APPROVED%>" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:renderURL>';
		}
		else{
			var url='<portlet:renderURL >
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
				<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.NOT_APPROVED%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				</portlet:renderURL>';
		}
		var reportId = ${bean.lmisViewReportOvertimeDetail.otRepId};
		var subOrgId = ${bean.lmisViewReportOvertimeDetail.orgId};
			jQuery.ajax({
				type : "POST",
				url : url,
				data : {
					"reportId": reportId,
					"subOrgId": subOrgId
				},
				success: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.GO_BACK%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".successful").css("display", "block");
				    	jQuery(".successful").data('url',href).data('close',close).dialog("open");
				},
				error: function(){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.GO_BACK%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".successful").css("display", "block");
				    jQuery(".successful").data('url',href).data('close',close).dialog("open");
				}
			});
	}
	
	function goBack(){
		var url='<portlet:renderURL >
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.GO_BACK%>" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:renderURL>';
		document.frmRequestOTDetail.action=url;
		document.frmRequestOTDetail.submit(); 
	}
</script>

<form action="" name="frmRequestOTDetail" method="post">
	<div class="createChange"  style="margin-top:-36px">
		<input type="image" src="/ProGate-portlet/images/lmis/overtimeManagement/Pheduyet.png" href="#" id="approve" class="mode-edit-active">
		<a id="aproveReport" style="vertical-align: 7px; font-weight: bold" href="#"><fmt:message key="lmis.review" /></a>
	    <input id="ctl-back" type="image" src="/ProGate-portlet/images/lmis/undo.png" width="24" height="24"
		href="#" class="mode-edit-active">
	   	<a id="goBack" href="#" style="vertical-align: 7px; font-weight: bold"><fmt:message key="lmis.common.back" /></a>
    </div>
	<div class="cls-ot">
		<div class="title-center"><fmt:message key="title.product.detail" /></div>
		<div class="req-field" style="display:none;"><fmt:message key="title.required.field" /></div>
		<div style="height:20px;width:100%"></div>
		<div class="content-left" style="height: 120px !important;">
			<table id="tbl-field">
				<thead>
					<tr>
						<th width="150px" scope="col" style="border: none;"></th>
						<th style="border:none;"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<fmt:message key="lmis.ot.reg.regday" />
						</td>
						<td>
							<input class="date-req" type="text" name="today" value="<fmt:formatDate  value='${bean.lmisViewReportOvertimeDetail.createdAt}' pattern="dd/MM/yyyy"/>" readonly="readonly" disabled="disabled" />
						</td>
					</tr>
					<tr style="height:36px">
						<td class="cls-org" style="vertical-align: middle !important;">
							<fmt:message key="lmis.ot.nameorg" />
						</td>
						<td style="vertical-align: middle">
							<input class="subOrg" type="text" name="slt-org" value="${functions:getOrgNameByOrgId(bean.lmisViewReportOvertimeDetail.orgId)}" disabled="disabled" />
						</td>
					</tr>
					<tr >
						<td>
							<fmt:message key="lmis.overtimeReport.reportDayLower" />
						</td>
						<td>
							<input style="width: 350px; height: 20px" class="date-input-ot" type="text" name="date-ot" value="<fmt:formatDate  value='${bean.lmisViewReportOvertimeDetail.reportedAt}' pattern="dd/MM/yyyy"/>" disabled="disabled" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="content-right" style="height: 120px !important;">
			<div>
				<fieldset style="-moz-border-radius:5px">
					<legend><fmt:message key="lmis.ot.reg.reason" /></legend>
					<textarea id="txt-reason" name="txt-reason" style="height:54px; width: 412px" disabled="disabled">
						${bean.lmisViewReportOvertimeDetail.reportedReason}
					</textarea>
				</fieldset>
			</div>
		</div>
		<div class="tbl-title">
			<div class="mbr-join"><fmt:message key="lmis.ot.reg.mbr" /></div>
		</div>
		<div class="clear"></div>
		<div class="tbl-mbr">
			<table>
				<thead >
					<tr>
						<th scope="row" width="25%"> <fmt:message key="lmis.commom.fullname.employee" /></th>
						<th scope="row" width="11%"><span title="<fmt:message key='lmis.overtimeReport.reqTime.toolTip'/>" ><fmt:message key="lmis.attendanceInfo.registeredStartTime"/></span></th>
						<th scope="row" width="10%"><span title="<fmt:message key='lmis.overtimeReport.regHours.toolTip'/>" ><fmt:message key="lmis.overtimeReport.regHours"/></span></th>
						<th scope="row" width="11%"><span title="<fmt:message key='lmis.overtimeReport.realStartTime.toolTip'/>" ><fmt:message key="lmis.overtimeReport.realStartTime"/></span></th>
						<th scope="row" width="10%"><span title="<fmt:message key='lmis.overtimeReport.realHours.toolTip'/>" ><fmt:message key="lmis.overtimeReport.realHours"/></span></th>
						<th scope="row"><fmt:message key="lmis.ot.reg.reason" /></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="lmisViewReportOvertimeDetail" items="${bean.lmisViewReportOvertimeDetails}" varStatus="itemCount">
						<c:choose>
							<c:when test="${itemCount.count%2 !=0}">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>	
						</c:choose>
							<td class="text-indent">${lmisViewReportOvertimeDetail.fullName}</td>
							<td align="center"><input type="text" class="time-align" value='<fmt:formatDate  value="${lmisViewReportOvertimeDetail.reqStartTime}" pattern="HH" />' disabled="disabled"/> : <input class="time-align" type="text" value='<fmt:formatDate  value="${lmisViewReportOvertimeDetail.reqStartTime}" pattern="mm" />' disabled="disabled"/> </td>
							<td align="center" class="hour"><input class="hour-align" type="text" value="${lmisViewReportOvertimeDetail.reqRequestedHour}" disabled="disabled"/></td>
							<td align="center"><input class="time-align" type="text" value="<fmt:formatDate  value="${lmisViewReportOvertimeDetail.startTime}" pattern="HH" />" disabled="disabled"/> : <input class="time-align" type="text" value="<fmt:formatDate  value="${lmisViewReportOvertimeDetail.startTime}" pattern="mm" />" disabled="disabled"/> </td>
							<td align="center" class="hour"><input class="hour-align" type="text" value="${lmisViewReportOvertimeDetail.totalHour}" disabled="disabled"/></td>
							<td class="tdreason"><input id="tdreason" type="text" value="${lmisViewReportOvertimeDetail.reportedReason}" disabled="disabled"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="feedback" style="padding-left: 5px">
		<fieldset class="fbk-field" style="width: 900px">
			<legend><fmt:message key="lmis.ot.reg.feedback" /></legend>
			<textarea name="feedback" style="width: 899px; height: 94px" disabled="disabled">${bean.feedback}</textarea>
		</fieldset>
	</div>
	<div class="align-right" style="padding-right: 2px; padding-top: 10px;">
		<input class="default-button-disable" id="agreeReport" type="button" value="<fmt:message key="lmis.overtimeReport.agree" />" disabled="disabled"  />
		<input class="not-agree-disable" id="notAgreeReport" type="button" value="<fmt:message key="lmis.overtimeReport.notAgree" />" disabled="disabled" />
	</div>
</form>