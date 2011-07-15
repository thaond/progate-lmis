<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../../common/init.jsp" %>
<%@ include file="../../../lmis/init-ttn.jsp" %>
<link rel="stylesheet" href="/ProGate-portlet/css/lmis/print.css" type="text/css" media="print" />

<script type="text/javascript">

jQuery(document).ready(function(){
	jQuery("#select-year").keydown(function(e){
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
	jQuery('#print-report').bind('click', function(e){
		e.preventDefault();
		window.print();
	});
	
})
jQuery(function(){
	jQuery('input[name="btnView"]').click(function(){
		var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:renderURL>';
		document.frmReport.action=url;
		document.frmReport.submit();
	});
});
</script>
<form action="" name="frmReport" id="frmManagerAttendanceBy" method="post">
<div class="wrapper">
	<div class="header">
		<div class="header-center">
			<b><fmt:message key="lmis.personalStatisticalReport.title" /></b>
		</div>
	</div>

	<div class="main">
		<!-- mainContent -->
		<div class="content">
			<div class="filter" style="padding-top: 0px; height: 55px">
			<div class="label"><fmt:message key="lmis.common.month" /></div>
			<div class="datetime">
					<select name="month" style="height: 22px">
						<c:forEach var="i" begin="1" end="12" step="1">
							<c:choose>
								<c:when test="${i == bean.month}">
									<option value="${i}" selected="selected"><c:out value="${i}"/></option>
								</c:when>
								<c:otherwise><option value="${i}"><c:out value="${i}"/></option></c:otherwise>
							</c:choose>								
						</c:forEach>
					</select>
				</div><!-- end class datetime -->
			<div class="label"><fmt:message key="lmis.common.year" /></div>
			<div class="datetime" style="padding-top:13px">
					<input id="select-year" type="text" name="year" style="width:5em; height:22px" value="${bean.year}" />
					<input id="view" type="button" name="btnView" value="Xem" />
				</div>		
			<div class="div-print" >
					<input type="image" src="/ProGate-portlet/images/lmis/print.png" id="print-report" class="mode-edit-active">
			   		<a id="export-file" style="vertical-align: middle; font-weight: bold" href="javascript:window.print()"><fmt:message key="lmis.common.exportFile"/></a>
	    		</div>			
			</div><!-- end filter -->

			<div class="table-content-of-report">
				<div align="center" style="color: #0070C0; font-size: 13pt; font-weight: bold;">
					<p>
						<fmt:message key="lmis.personalStatisticalReport.topic" >
						<fmt:param>${bean.month}</fmt:param>
						<fmt:param>${bean.year}</fmt:param>
						<fmt:param>${bean.userName}</fmt:param>
						</fmt:message>
					</p>
				</div>
				<div style="padding-bottom: 10px; overflow: hidden">
					<div class="report-left">
						<table width="100%" class="margin-bottom-table">
							<thead>
								<tr class="header-of-table">
									<th height="33" colspan="2" align="left"><fmt:message key="lmis.personalStatisticalReport.workingHours" /></th>
								</tr>
								</thead>
								<tbody class="height-td">
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.avgStartimeMonth" /></td>
									<td class="span-right"><fmt:formatDate pattern="HH:mm" value="${bean.monthStartTimeAvg }"/></td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.avgStartimeYear" /></td>
									<td class="span-right"><fmt:formatDate pattern="HH:mm" value="${bean.yearStartTimeAvg }"/></td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.avgEndtimeMonth" /></td>
									<td class="span-right"><fmt:formatDate pattern="HH:mm" value="${bean.monthEndTimeAvg }"/></td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.avgEndtimeYear" /></td>
									<td class="span-right"><fmt:formatDate pattern="HH:mm" value="${bean.yearEndTimeAvg }"/></td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.totalWorkingTime" /></td>
									<td class="span-right">${bean.totalWorkDay }</td>
								</tr>
								</tbody>
							</table>
							<table width="100%" class="margin-bottom-table">
								<thead>
								<tr class="header-of-table">
									<th height="33" colspan="2" align="left"><fmt:message key="lmis.personalStatisticalReport.lateTimeOfMonth" /></th>
								</tr>
								</thead>
								<tbody class="height-td">
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.lateMinute" /></td>
									<td class="span-right">${bean.monthLate }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.coefficientLateMinute" /></td>
									<td class="span-right">${bean.monthLatePer }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.totalCoefficientLateMinute" /></td>
									<td class="span-right">${bean.monthLateFinal }</td>
								</tr>
								</tbody>
							</table>


							<table width="100%" class="margin-bottom-table">
								<thead>
								<tr class="header-of-table">
									<th height="33" colspan="2" align="left"><fmt:message key="lmis.personalStatisticalReport.earlyTimeOfMonth" /></th>
								</tr></thead>
								<tbody class="height-td">
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.earlyMinute" /></td>
									<td class="span-right">${bean.monthEarly }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.coefficientEarlyMinute" /></td>
									<td class="span-right">${bean.monthEarlyPer }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.totalCoefficientEarlyMinute" /></td>
									<td class="span-right">${bean.monthEarlyFinal }</td>
								</tr>
								</tbody>
							</table>
						</div>


						<div class="report-right">
							<table width="100%" class="margin-bottom-table">
								<thead>
								<tr class="header-of-table">
									<th height="33" colspan="2" align="left"><fmt:message key="lmis.personalStatisticalReport.OT" /></th>
								</tr>
								</thead>
								<tbody class="height-td">
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.totalOTMonth" /></td>
									<td class="span-right">${bean.monthOT }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.totalOT" /></td>
									<td class="span-right">${bean.monthOTFinal }</td>
								</tr>
								</tbody>
							</table>

							<table width="100%" class="margin-bottom-table">
								<thead>
								<tr class="header-of-table">
									<th height="33" colspan="2" align="left"><fmt:message key="lmis.personalStatisticalReport.OTCompensatoryLeave" /></th>
								</tr>
								</thead>
								<tbody class="height-td">
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.totalOTCompensatoryLeaveMonth" /></td>
									<td class="span-right">${bean.monthDayComp }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.OTCompensatoryLeavedMonth" /></td>
									<td class="span-right">${bean.monthDayOffComp }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.restOfOTCompensatoryLeaveMonth" /></td>
									<td class="span-right">${bean.monthDayCompRemain }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.OTCompensatoryLeaveNextMonth" /></td>
									<td class="span-right">${bean.nextMonthDayComp }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.awardedHours" /></td>
									<c:choose>
										<c:when test="${bean.timeFinal >= 0}">
											<td class="span-right">${bean.timeFinal }</td>
										</c:when>
										<c:otherwise>
											<td class="span-right">&nbsp;</td>
										</c:otherwise>
									</c:choose>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.coefficientHours" /></td>
									<c:choose>
										<c:when test="${bean.timeFinal < 0}">
											<td class="span-right">${bean.timeFinal }</td>
										</c:when>
										<c:otherwise>
											<td class="span-right">&nbsp;</td>
										</c:otherwise>
									</c:choose>
								</tr>
								</tbody>
							</table>

							<table width="100%" class="margin-bottom-table">
								<thead>
								<tr class="header-of-table">
									<th height="33" colspan="2" align="left"><fmt:message key="lmis.personalStatisticalReport.dayOffNumber" /></th>
								</tr>
								</thead>
								<tbody class="height-td">
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.totaldayOff" /></td>
									<td class="span-right">${bean.monthDayOff }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.permitedDayOff" /></td>
									<td class="span-right">${bean.monthDayOffPer }</td>
								</tr>
								<tr>
									<td class="span-left"><fmt:message key="lmis.personalStatisticalReport.notPermitedDayOff" /></td>
									<td class="span-right">${bean.monthDayOffNotPer }</td>
								</tr>
								</tbody>
							</table>
						</div>
						<div style="clear: both; border: 1px solid #ececec">
							<table width="100%">
								<tr class="header-of-table">
									<th height="33" colspan="2" align="left"><fmt:message key="lmis.personalStatisticalReport.dayOffOfMonth" /></th>
								</tr>
							</table>
							<div class="reportDayOff"><fmt:message key="lmis.personalStatisticalReport.dayOffDetail" /></div>
							<table width="100%" class="table-content-of-report" style="margin-left:5px">
								<thead>
								<tr bgcolor="#FCEADA" style="height: 30px">
									<th width="5%" scope="col" style="text-align: center"><fmt:message key="lmis.common.number" /></th>
									<th width="25%" scope="col" style="text-align: center"><fmt:message key="lmis.personalStatisticalReport.dayOff" /></th>
									<th width="35%" scope="col" style="text-align: center"><fmt:message key="lmis.personalStatisticalReport.dayOffType" /></th>
									<th width="35%" scope="col" style="text-align: center"><fmt:message key="lmis.personalStatisticalReport.holidayType" /></th>
								</tr>
								</thead>
								<tbody  class="height-td">
									<c:forEach var="items" items="${bean.detailDayOff}" varStatus="itemCount">
										<c:choose>
											<c:when test="${itemCount.count % 2 !=0 }">
												<tr class="oddrow">
											</c:when>
											<c:otherwise>
												<tr class="evenrow">
											</c:otherwise>
										</c:choose>	
													<td align="center">${itemCount.count}</td>
													<td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${items.dayValue }"/></td>
													<td class="text-indent">
														<c:choose>
															<c:when test="${items.absence_ == 3}">Nghỉ cả ngày</c:when>
															<c:when test="${items.absence_ == 1 }">Nghỉ buổi sáng</c:when>
															<c:when test="${items.absence_ == 2 }">Nghỉ buổi chiều</c:when>
														</c:choose>
													</td>
													<td class="text-indent">${items.absenceReason }</td>
												</tr>
									</c:forEach>
								</tbody>
							</table>

							<div class="reportDayOffType"><fmt:message key="lmis.personalStatisticalReport.statisticsDayOffType" /></div>
							<table width="100%" class="table-content-of-report" style="margin-left:5px">
								<thead>
								<tr bgcolor="#FCEADA" style="height: 30px">
									<th width="5%" scope="col" style="text-align: center"><fmt:message key="lmis.common.number" />
									</th>
									<th width="35%" scope="col" style="text-align: center"><fmt:message key="lmis.personalStatisticalReport.holidayType" /></th>
									<th width="20%" scope="col" style="text-align: center"><fmt:message key="lmis.personalStatisticalReport.asked" /></th>
									<th width="20%" scope="col" style="text-align: center"><fmt:message key="lmis.personalStatisticalReport.approved" /></th>
									<th width="20%" scope="col" style="text-align: center"><fmt:message key="lmis.personalStatisticalReport.leaved" /></th>
								</tr>
								</thead>
								<tbody>
									<c:forEach var="items" items="${bean.typeDayOff}" varStatus="itemCount">
										<c:choose>
											<c:when test="${itemCount.count % 2 !=0 }">
												<tr class="oddrow">
											</c:when>
											<c:otherwise>
												<tr class="evenrow">
											</c:otherwise>
										</c:choose>	
													<td align="center">${itemCount.count}</td>
													<td class="text-indent">${items.absenceType }</td>
													<td align="right" style="padding-right: 10px">${items.totalDayRequested }</td>
													<td align="right" style="padding-right: 10px">${items.totalDayApproved }</td>
													<td align="right" style="padding-right: 10px">${items.totalDay }</td>																
												</tr>
									</c:forEach>								
								</tbody>
							</table>
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
</form>
