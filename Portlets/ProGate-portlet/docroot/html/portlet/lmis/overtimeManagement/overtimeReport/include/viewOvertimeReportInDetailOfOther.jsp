<%@page import="com.larion.progate.lmis.constants.LmisRequest"%>
<%@ include file="../../../../common/init.jsp"%>
<%@ include file="../../../../lmis/init-ttn.jsp" %>
<%-- <%@ include file="../../../../lmis/dialog/dialog-message.jsp" %> --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery('#ctl-back, #goBack').click(function(){
		var url='<portlet:renderURL>
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_OTHER%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.GO_BACK%>" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:renderURL>';
			
			document.frmViewRequestOTDetail.action=url;
			document.frmViewRequestOTDetail.submit();
	});
});

</script>

<form action="" name="frmViewRequestOTDetail" method="post">
	<div class="createChange"  style="margin-top:-30px">
	    <input id="ctl-back" type="image" src="/ProGate-portlet/images/lmis/undo.png" width="24" height="24" class="mode-edit-active">
	   	<a id="goBack" href="#" style="vertical-align: 9px"><fmt:message key="lmis.common.back"/></a>
    </div>
	<div class="cls-ot">
		<div class="title-center"><fmt:message key="title.product.detail"/></div>
		<div class="req-field" style="display:none;"><fmt:message key="title.required.field"/></div>
		<div style="height:20px;width:100%"></div>
		<div class="content-left">
			<table id="tbl-field">
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
							<input class="date-req" type="text" name="overtimeDate" value="<fmt:formatDate  value='${bean.lmisViewReportOvertimeDetail.createdAt}' pattern="dd/MM/yyyy"/>" readonly="readonly" disabled="disabled"/>
						</td>
					</tr>
					<tr>
						<td class="cls-org">
							<fmt:message key="lmis.ot.nameorg" />
						</td>
						<td>
							<input class="subOrg" style="margin-top:10px; margin-bottom: -4px;" type="text" name="slt-org" value="${functions:getOrgNameByOrgId(bean.lmisViewReportOvertimeDetail.orgId)}" disabled="disabled" />
						</td>
					</tr>
					<tr class="cls-reason">
						<td>
							<fmt:message key="lmis.ot.reg.reason"/>
						</td>
						<td>
							<textarea id="txt-reason" style="margin-top: 15px; height:94px; width: 350px;" name="txt-reason" disabled="disabled">${bean.lmisViewReportOvertimeDetail.reportedReason}</textarea>
							<br>
							<label class="cls-error"><fmt:message key="lmis.ot.reg.errreason" /></label>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="content-right">
			<div class="date-ot">
				<span style="padding-right:5px"><fmt:message key="lmis.overtimeReport.reportDayLower"/></span> <input class="date-input-ot" type="text" name="date-ot" width="456px" disabled="disabled" value="<fmt:formatDate  value='${bean.lmisViewReportOvertimeDetail.reportedAt}' pattern="dd/MM/yyyy"/>"/>
			</div>
			<div class="flt-right align-right" style="height:25px;"></div>
			<div class="clear-right"></div>
			<div class="feedback">
				<fieldset class="fbk-field">
					<legend><fmt:message key="lmis.ot.reg.feedback"/></legend>
					<textarea name="txt-fbk" style="width: 410px; height: 99px"  disabled="disabled" >${bean.feedback}</textarea>
				</fieldset>
				<label class="cls-error"><fmt:message key="lmis.ot.reg.errNook" /></label>
			</div>
		</div>
		<div class="clear"></div>
		<div class="tbl-title">
			<div class="mbr-join"><fmt:message key="lmis.ot.reg.mbr"/></div>
		</div>
		<div class="clear"></div>
		<div class="tbl-mbr">
			<table>
				<thead >
					<tr>
						<th scope="row" width="25%"> <fmt:message key="lmis.commom.fullname.employee"/></th>
						<th scope="row" width="11%"><span title="<fmt:message key='lmis.overtimeReport.reqTime.toolTip'/>" ><fmt:message key="lmis.attendanceInfo.registeredStartTime"/></span></th>
						<th scope="row" width="7%"><span title="<fmt:message key='lmis.overtimeReport.regHours.toolTip'/>" ><fmt:message key="lmis.overtimeReport.regHours"/></span></th>
						<th scope="row" width="11%"><span title="<fmt:message key='lmis.overtimeReport.realStartTime.toolTip'/>" ><fmt:message key="lmis.overtimeReport.realStartTime"/></span></th>
						<th scope="row" width="7%"><span title="<fmt:message key='lmis.overtimeReport.realHours.toolTip'/>" ><fmt:message key="lmis.overtimeReport.realHours"/></span></th>
						<th scope="row" ><fmt:message key="lmis.overtimeReport.reason"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lmisViewReportOvertimeDetail" items="${bean.lmisViewReportOvertimeDetails}" varStatus="itemCount" >
						<c:choose>
							<c:when test="${itemCount.count %2 !=0 }">
								<tr class="oddrow">	
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
						</c:choose>
						<td class="text-indent">${lmisViewReportOvertimeDetail.fullName}</td>
						<td align="center" class="txt" ><input class="time-align" type="text" value='<fmt:formatDate  value="${lmisViewReportOvertimeDetail.reqStartTime}" pattern="HH" />' disabled="disabled"/> : <input class="time-align" type="text" value='<fmt:formatDate  value="${lmisViewReportOvertimeDetail.reqStartTime}" pattern="mm" />' disabled="disabled"/> </td>
						<td align="center" class="hour"><input class="hour-align" type="text" value="${lmisViewReportOvertimeDetail.reqRequestedHour}" disabled="disabled"/></td>
						<td align="center"><input class="time-align" type="text" value="<fmt:formatDate  value='${lmisViewReportOvertimeDetail.startTime}' pattern="HH"/>" disabled="disabled"/> : <input class="time-align" type="text" value='<fmt:formatDate  value="${lmisViewReportOvertimeDetail.startTime}" pattern="mm"/>' disabled="disabled"/> </td>
						<td align="center" class="hour"><input class="hour-align" type="text" value="${lmisViewReportOvertimeDetail.totalHour}" disabled="disabled"/></td>
						<td align="center" class="tdreason"><input id="tdreason" type="text" value="${lmisViewReportOvertimeDetail.reportedReason}" disabled="disabled"/></td>
					</tr>				
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</form>
