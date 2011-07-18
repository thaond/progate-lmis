<%@page import="larion.progate.lmis.service.utils.LmisConst"%>
<%@ page import="com.larion.progate.lmis.constants.LmisRequest" %>
<%@ page import="com.larion.progate.lmis.constants.Configuration_RS" %>
<%@ include file="../../../../common/init.jsp" %>
<%@ include file="../../../../lmis/init-ttn.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
jQuery(function(){
	jQuery(".table-content tbody tr").not(".header_table").hover(
		function(){
			jQuery(this).addClass("highlight");
		},
		function(){
			jQuery(this).removeClass("highlight");
		}
	)
}
)
function pagingSubmit(){ 
	url='<portlet:renderURL >
		<portlet:param name="action" value="commonController" />
		<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
		</portlet:renderURL>';
		document.frmConfigViewOverTimeReport.action=url;
		document.frmConfigViewOverTimeReport.submit();
	//jQuery('.frmConfigViewOverTimeReport').submit(); 
}
jQuery(document).ready(function(){
	jQuery('.viewDetail').bind('click',function(e){
			e.preventDefault();
			var reportId=e.currentTarget.parentNode.getElementsByTagName("input")[0].value;
			var subOrgId=e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
			var status=e.currentTarget.parentNode.getElementsByTagName("input")[2].value;
			//jQuery(document).empty().html('<img src="../../../../images/lmis/ajax-loader.gif"/>')
			mySelect(reportId,subOrgId, status);
		});
	jQuery('.editChange').bind('click',function(e){
		e.preventDefault();
		var reportId=e.currentTarget.parentNode.getElementsByTagName("input")[0].value;
		var subOrgId=e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
		
		editOvertimeReport(reportId,subOrgId);
	});
});
function mySelect(reportId, subOrgId, status)
{
	var url
	if(status==3 || status==1){
	
		url='<portlet:renderURL >
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			<portlet:param name="<%=LmisRequest.REPORT_ID%>" value="rpid" />
			<portlet:param name="<%=LmisRequest.SUB_ORG_ID%>" value="sbid" />
			<portlet:param name="hideEditIcon" value="false" />
			</portlet:renderURL>';
	}
	else{
		url='<portlet:renderURL >
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			<portlet:param name="<%=LmisRequest.REPORT_ID%>" value="rpid" />
			<portlet:param name="<%=LmisRequest.SUB_ORG_ID%>" value="sbid" />
			<portlet:param name="hideEditIcon" value="true" />
			</portlet:renderURL>';
	}
	url = url.replace("rpid",reportId);
	url = url.replace("sbid",subOrgId);
	document.frmConfigViewOverTimeReport.action=url;
	document.frmConfigViewOverTimeReport.submit();
}

function editOvertimeReport(reportId, subOrgId){
	var url='<portlet:renderURL >
		<portlet:param name="action" value="commonController" />
		<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
		<portlet:param name="<%=LmisRequest.REPORT_ID%>" value="rpid" />
		<portlet:param name="<%=LmisRequest.SUB_ORG_ID%>" value="sbid" />
		</portlet:renderURL>';
		url= url.replace("rpid",reportId);
		url = url.replace("sbid",subOrgId);
		document.frmConfigViewOverTimeReport.action=url;
		document.frmConfigViewOverTimeReport.submit();
}
</script>
<form name="frmConfigViewOverTimeReport" class="frmConfigViewOverTimeReport" id="frmConfigCalendar" action="" method="post">
		<div class="contentConfigCalendar">
			<c:choose>
			<c:when test="${bean.countItem ==0}">
				<div align="center" style="padding-bottom:20px; font-size: 15px"><b><fmt:message key="lmis.overtimeReport.noData"/></b></div>
			</c:when>
			<c:otherwise>
				<div class="div-of-table-content">
					<div class="table-content" style="min-height: 280px">
						<table width="100%">
							<thead class="tbl-header">
								<tr>
									<th scope="col" width="5%" height="0"><fmt:message	key="lmis.common.number" /></th>
									<th scope="col" width="31%" height="0"><fmt:message	key="lmis.overtimeReport.orgName" /></th>
									<th scope="col" width="10%" height="0"><fmt:message	key="lmis.overtimeReport.overtimeDay" /></th>
									<th scope="col" width="10%" height="0"><fmt:message	key="lmis.overtimeReport.reportDay" /></th>
									<th scope="col" width="25%" height="0"><fmt:message	key="lmis.overtimeReport.reason" /></th>
									<th scope="col" width="12%" height="0"><fmt:message	key="lmis.common.status" /></th>
									<th scope="col" width="6%" height="0">&nbsp; </th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="lmisViewReportOvertime" items="${bean.lmisViewReportOvertimes}" varStatus="itemCount">
									<c:choose>
										<c:when test="${itemCount.count % 2 !=0 }">
											<tr class="oddrow">
										</c:when>
										<c:otherwise>
											<tr class="evenrow">
										</c:otherwise>
									</c:choose>
									<td align="center"><c:out value="${itemCount.count}" /></td>
									<td align="left" style="text-indent:10px">${lmisViewReportOvertime.orgName}</td>
									<td align="center"><fmt:formatDate value="${lmisViewReportOvertime.createdAt}" pattern="dd/MM/yyyy" /></td>
									<td align="center"><fmt:formatDate value="${lmisViewReportOvertime.reportedAt}" pattern="dd/MM/yyyy" /></td>
									<td style="text-indent:10px"><c:out value='${lmisViewReportOvertime.reportedReason}'/></td>
									<td style="text-indent:10px">
									<c:choose>
										<c:when test="${lmisViewReportOvertime.reportedStatus== bean.pending}">
											<fmt:message key="lmis.overtimeReport.status.pending"></fmt:message>
										</c:when>
										<c:when test="${lmisViewReportOvertime.reportedStatus== bean.accepted}">
											<fmt:message key="lmis.overtimeReport.status.accepted"></fmt:message>
										</c:when>
										<c:when test="${lmisViewReportOvertime.reportedStatus== bean.notAccepted}">
											<fmt:message key="lmis.overtimeReport.status.notAccepted"></fmt:message>
										</c:when>
										
										<c:when test="${lmisViewReportOvertime.reportedStatus== bean.neadToCreateReport}">
													<portlet:renderURL var="createReport" >
														<portlet:param name="action" value="commonController" />
														<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
														<portlet:param name="<%=Constants.CMD%>" value="<%=LmisRequest.CREATE_REPORT%>" />
														<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
														<portlet:param name="<%=LmisRequest.REQUEST_ID%>" value="${lmisViewReportOvertime.requestId}" />
														<portlet:param name="<%=LmisRequest.REPORT_ID%>" value="${lmisViewReportOvertime.lmisViewOvertimeReportId}" />
														<portlet:param name="<%=LmisRequest.SUB_ORG_ID%>" value="${lmisViewReportOvertime.orgId}" />
													</portlet:renderURL>
											<c:choose>
												<c:when test="${functions:compareDate(lmisViewReportOvertime.createdAt,bean.now) <0 }">
													<a href='<c:out value="${createReport}"/>'><fmt:message key="lmis.overtimeReport.status.needToCreateReport" /></a>
												</c:when>
												<c:otherwise>
													<a href='#' style="text-decoration: none; color: black;"><fmt:message key="lmis.overtimeReport.status.notYet" /></a>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:when test="${lmisViewReportOvertime.reportedStatus== bean.disableStatus}">
											<fmt:message key="lmis.overtimeReport.status.disable"></fmt:message>
										</c:when>

									</c:choose>
										</td>
										<td align="center">
											<input type="hidden" value="${lmisViewReportOvertime.lmisViewOvertimeReportId}" />
											<input type="hidden" value="${lmisViewReportOvertime.orgId}" />
											<input type="hidden" value="${lmisViewReportOvertime.reportedStatus}" />
											<c:choose>
												<c:when test="${lmisViewReportOvertime.reportedStatus== bean.neadToCreateReport}">
														<input class="viewDetail" type="image" src="/ProGate-portlet/images/lmis/detail-disable.png" title='<fmt:message key="lmis.viewDetail" />' disabled="disabled" />
														<input class="editChange" type="image" src="/ProGate-portlet/images/lmis/Edit_disable.png" disabled="disabled"  title='<fmt:message key="lmis.edit" />'/>
												</c:when>
												<c:when test="${lmisViewReportOvertime.reportedStatus== bean.pending || lmisViewReportOvertime.reportedStatus== bean.notAccepted }">
														<input class="viewDetail" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="lmis.viewDetail" />'/>
														<input class="editChange" type="image" src="/ProGate-portlet/images/lmis/edit.png" title='<fmt:message key="lmis.edit" />' />
												</c:when>
												<c:when test="${lmisViewReportOvertime.reportedStatus== bean.accepted}">
														<input class="viewDetail" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="lmis.viewDetail" />'/>
														<input class="editChange" type="image" src="/ProGate-portlet/images/lmis/Edit_disable.png" disabled="disabled" title='<fmt:message key="lmis.edit" />' />
												</c:when>

											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
					</div>
					<div class="lmis-paging"> 
							<c:set value="${bean.pagination}" var="paging"></c:set> 
							<%@ include file="/html/portlet/common/pagination.jsp" %>  
					</div>
				</div>
			</c:otherwise>
			</c:choose>
			</div>
</form>
