<%@page import="larion.progate.lmis.service.utils.LmisConst"%>
<%@ page import="com.larion.progate.lmis.constants.LmisRequest" %>
<%@ include file="../../../../common/init.jsp" %>
<%@ include file="../../../../lmis/init-ttn.jsp" %>
<%-- <%@ include file="../../../../lmis/dialog/dialog-message.jsp" %> --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
jQuery(function(){
	jQuery(".table-content tbody tr").hover(
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
		jQuery('.frmViewDetailOTList').submit(); 
	}
		jQuery(document).ready(function() {
			jQuery('.viewDetail').click(function(e)
			{
				e.preventDefault();
				var reportId=e.currentTarget.parentNode.getElementsByTagName("input")[0].value;
				var subOrgId=e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
				viewDetail(reportId, subOrgId);

			});
		});
		function viewDetail(reportId, subOrgId){
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_OTHER%>" />
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				<portlet:param name="<%=LmisRequest.REPORT_ID%>" value="rpid" />
				<portlet:param name="<%=LmisRequest.SUB_ORG_ID%>" value="sbid" />
			</portlet:renderURL>';
			url= url.replace("rpid",reportId);
			url = url.replace("sbid",subOrgId);
			document.frmViewDetailOTList.action=url;
			document.frmViewDetailOTList.submit();
		}
		
		function mySelect(){
			var url='<portlet:renderURL >
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_OTHER%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				</portlet:renderURL>';
		document.frmViewDetailOTList.action=url;
		document.frmViewDetailOTList.submit();
		}
		jQuery(document).ready(function(){
			jQuery('.view').click(function(){
				mySelect();
			});
		});
</script>

<form name="frmViewDetailOTList" class="frmViewDetailOTList" id="frmConfigCalendar" action=""	method="post">
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
			<div class="search-button" style="margin-top: -3px">
				<input type="submit" class="view" style="height: 26px" value='<fmt:message key="button.view"/>' />
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
						<th scope="col" width="31%" height="0"><fmt:message	key="lmis.overtimeReport.orgName" /></th>
						<th scope="col" width="9%" height="0"><fmt:message	key="lmis.overtimeReport.overtimeDay" /></th>
						<th scope="col" width="9%" height="0"><fmt:message	key="lmis.overtimeReport.reportDay" /></th>
						<th scope="col" width="25%" height="0"><fmt:message	key="lmis.overtimeReport.reason" /></th>
						<th scope="col" width="10%" height="0"><fmt:message	key="lmis.common.status" /></th>
						<th scope="col" width="4%" height="0">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lmisViewReportOvertime" items="${bean.lmisViewReportOvertimes}" varStatus="itemCount">
					<c:choose>
					<c:when test="${lmisViewReportOvertime.reportedStatus!= 4}">
						<c:choose>
							<c:when test="${itemCount.count % 2 !=0}">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
						</c:choose>
									<td align="center"><c:out value="${itemCount.count}" /></td>
									<td align="left" class="text-indent">${lmisViewReportOvertime.orgName}</td>
									<td align="center"><fmt:formatDate value="${lmisViewReportOvertime.createdAt}" pattern="dd/MM/yyyy" /></td>
									<td align="center"><fmt:formatDate value="${lmisViewReportOvertime.reportedAt}" pattern="dd/MM/yyyy" /></td>
									<td class="text-indent"><c:out value='${lmisViewReportOvertime.reportedReason}'/></td>
									<td class="text-indent">
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
											<c:when test="${lmisViewReportOvertime.reportedStatus== bean.disableStatus}">
												<fmt:message key="lmis.overtimeReport.status.disable"></fmt:message>
											</c:when>
										</c:choose>
									</td>
								<td align="center">
								<input type="hidden" value="${lmisViewReportOvertime.otRepId}" />
								<input type="hidden" value="${lmisViewReportOvertime.orgId}" />
								<input class="viewDetail" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="lmis.viewDetail" />' />
								</td>
						</tr>
						</c:when>
						</c:choose>
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