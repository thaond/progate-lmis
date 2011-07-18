<%@page import="larion.progate.lmis.service.utils.LmisConst"%>
<%@ page import="com.larion.progate.lmis.constants.LmisRequest" %>
<%@ include file="../../../../common/init.jsp" %>
<%@ include file="../../../../lmis/init-ttn.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
jQuery(document).ready(function(){
	var url='<portlet:renderURL >
		<portlet:param name="action" value="commonController" />
		<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
		</portlet:renderURL>';
	if(${bean.cmd==bean.goBack}){
		document.frmRequestOTList.action=url;
		document.frmRequestOTList.submit();
	}
	jQuery('.view').click(function(){
		mySelect();
	});
	
}); 
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
		jQuery('.frmRequestOTList').submit(); 
	}
	
	jQuery(document).ready(function() {
			jQuery('.viewDetail').click(function(e)
			{
				e.preventDefault();
				var reportId=e.currentTarget.parentNode.getElementsByTagName("input")[0].value;
				var subOrgId=e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
				var approveStatus= e.currentTarget.parentNode.getElementsByTagName("input")[2].value;
				viewDetail(reportId, approveStatus, subOrgId);
			});

			jQuery('.approveIcon').bind('click',function(e){
				e.preventDefault();
				var reportId=e.currentTarget.parentNode.getElementsByTagName("input")[0].value;
				var subOrgId=e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
				approve(reportId, subOrgId);
			});
		});
		function viewDetail(reportId, approveStatus, subOrgId){
			var url='<portlet:renderURL >
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				<portlet:param name="<%=LmisRequest.REPORT_ID%>" value="rpid" />
				<portlet:param name="<%=LmisRequest.SUB_ORG_ID%>" value="sbid" />
				<portlet:param name="<%=LmisRequest.APPROVE_STATUS%>" value="appstate" />
				</portlet:renderURL>';
				url = url.replace("rpid",reportId);
				url = url.replace("appstate",approveStatus);
				url = url.replace("sbid",subOrgId);
			document.frmRequestOTList.action=url;
			document.frmRequestOTList.submit();
		}

		function approve(reportId, subOrgId){
			var url='<portlet:renderURL >
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.APPROVE%>" />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
					<portlet:param name="<%=LmisRequest.REPORT_ID%>" value="rpid" />
					<portlet:param name="<%=LmisRequest.SUB_ORG_ID%>" value="sbid" />
					</portlet:renderURL>';
					url= url.replace("rpid",reportId);
					url = url.replace("sbid",subOrgId);
			document.frmRequestOTList.action=url;
			document.frmRequestOTList.submit();
		}
		
		function mySelect(){
			var url='<portlet:renderURL >
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				</portlet:renderURL>';
		document.frmRequestOTList.action=url;
		document.frmRequestOTList.submit();
		}
		
		jQuery(document).ready(function(){
			/*var pending = jQuery('#pending').val();
			var accepted = jQuery('#accepted').val();
			var notAccepted = jQuery('#notAccepted').val();*/
			if(${bean.selectedStatus== -1}){
				jQuery('#allStatus').attr('selected','selected');
			}
			if(${bean.selectedStatus== 1}){
				jQuery('#pending').attr('selected','selected');
			}
			if(${bean.selectedStatus== 2}){
				jQuery('#accepted').attr('selected','selected');
			}
			if(${bean.selectedStatus== 3}){
				jQuery('#notAccepted').attr('selected','selected');
			}
		});
</script>

<form name="frmRequestOTList" class="frmRequestOTList" id="frmConfigCalendar" action=""	method="post">
	<div class="createChange"  style="margin-top:-26px">
		<span style="font-weight: bold; color: blue">
		<fmt:message key="lmis.overtimeReport.youhave">
		<fmt:param><label style="color: red">${bean.countPendingOT}</label></fmt:param>
		</fmt:message></span>
    </div>
	<div class="contentConfigCalendar">
	<div class="filter" style="height: 35px; padding-top: 10px;">
			<div class="selected-org">
				<fmt:message key="lmis.ot.nameorg"/>
				<select name="selectedOrg" style="width: 350px;">
					<option value="-1"><fmt:message key="lmis.common.all"/></option>
				<c:forEach var="subOrg" items="${bean.listSubOrg}" varStatus="countItems">
					<c:choose>
						<c:when test="${bean.selectedOrg == subOrg.orgId}">
							<option selected="selected" value="${subOrg.orgId}">${subOrg.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${subOrg.orgId}">${subOrg.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
			</div>
			<div class="selected-status">
				<fmt:message key="lmis.common.statusLower"/>
				<select name="selectedStatus" style="width: 150px;">
						<option id="allStatus" value="-1" ><fmt:message key="lmis.common.all"/></option>
						<option id="pending" value="<%=LmisConst.OverTimeReport_Status_Pending%>"><fmt:message key="lmis.overtimeReport.status.pending"/></option>
						<option id="accepted" value="<%=LmisConst.OverTimeReport_Status_Accepted%>"><fmt:message key="lmis.overtimeReport.status.accepted"/></option>
						<option id="notAccepted" value="<%=LmisConst.OverTimeReport_Status_NotAccept%>"><fmt:message key="lmis.overtimeReport.status.notAccepted"/></option>
		
				</select>
			</div>
			<div class="search-button" style="margin-top: -3px">
				<input type="submit" style="height: 26px" class="view" value='<fmt:message key="button.view"/>' />
			</div>
		</div>
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
						<th scope="col" width="28%" height="0"><fmt:message	key="lmis.overtimeReport.orgName" /></th>
						<th scope="col" width="16%" height="0"><fmt:message	key="lmis.overtimeReport.reporter" /></th>
						<th scope="col" width="9%" height="0"><fmt:message	key="lmis.overtimeReport.reportDay" /></th>
						<th scope="col" width="23%" height="0"><fmt:message	key="lmis.overtimeReport.reason" /></th>
						<th scope="col" width="10%" height="0"><fmt:message	key="lmis.common.status" /></th>
						<th scope="col" width="6%" height="0">&nbsp</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bean.lmisViewReportOvertimeApprovals}" var="lmisViewReportOvertimeApproval" varStatus="itemCount">
						<c:choose>
						<c:when test="${itemCount.count % 2 != 0 }">
							<tr class="oddrow">
						</c:when>
						<c:otherwise>
							<tr class="evenrow">
						</c:otherwise>
						</c:choose>
						<td align="center"><c:out value="${itemCount.count}" /></td>
						<td align="left" class="text-indent">${lmisViewReportOvertimeApproval.orgName}</td>
						<td align="left" class="text-indent">${lmisViewReportOvertimeApproval.fullName}</td>
						<td align="center"><fmt:formatDate value="${lmisViewReportOvertimeApproval.reportedAt}" pattern="dd/MM/yyyy" /></td>
						<td align="left" class="text-indent">${lmisViewReportOvertimeApproval.reportedReason }</td>
						<td align="left" class="text-indent">
							<c:choose>
										<c:when test="${lmisViewReportOvertimeApproval.reportedStatus== bean.pending}">
											<fmt:message key="lmis.overtimeReport.status.pending"></fmt:message>
										</c:when>
										<c:when test="${lmisViewReportOvertimeApproval.reportedStatus== bean.accepted}">
											<fmt:message key="lmis.overtimeReport.status.accepted"></fmt:message>
										</c:when>
										<c:when test="${lmisViewReportOvertimeApproval.reportedStatus== bean.notAccepted}">
											<fmt:message key="lmis.overtimeReport.status.notAccepted"></fmt:message>
										</c:when>
										<c:when test="${lmisViewReportOvertime.reportedStatus== bean.disableStatus}">
											<fmt:message key="lmis.overtimeReport.status.disable"></fmt:message>
										</c:when>
							</c:choose>
						</td>
						<td align="center">
						<input type="hidden" value="${lmisViewReportOvertimeApproval.lmisViewReportOvertimeApprovalId}" />
						<input type="hidden" value="${lmisViewReportOvertimeApproval.orgId}" />
						<input type="hidden" value="${lmisViewReportOvertimeApproval.reportedStatus}" />
						<c:choose>
							<c:when test="${lmisViewReportOvertimeApproval.reportedStatus== bean.accepted || lmisViewReportOvertimeApproval.reportedStatus== bean.notAccepted}">
								<input class="viewDetail" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="lmis.viewDetail" />' />
								<input class="approveIcon" type="image" src="/ProGate-portlet/images/lmis/overtimeManagement/Pheduyet_Disable.png" disabled="disabled"  title='<fmt:message key="lmis.review"/>'/>		
							</c:when>
							<c:otherwise>
								<input class="viewDetail" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="lmis.viewDetail" />' />
								<input class="approveIcon" type="image" src="/ProGate-portlet/images/lmis/overtimeManagement/Pheduyet.png" title='<fmt:message key="lmis.review"/>' />
							</c:otherwise>
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
