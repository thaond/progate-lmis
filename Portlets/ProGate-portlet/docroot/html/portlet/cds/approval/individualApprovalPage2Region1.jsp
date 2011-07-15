<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<table>
	<thead>
		<tr>
			<th rowspan="2" class="span-1">STT</th>
			<th rowspan="2" class="span-4">Slot</th>
			<th rowspan="2" class="span-10">Mô tả</th>

			<th rowspan="2" class="span-2">Phê duyệt</th>
			<th colspan="3" class="span-6">Trạng thái Slot</th>
		</tr>
		<tr>
			<th>Nhân viên đánh giá</th>
			<th>PM Phê Duyệt</th>
			<th>BOD Phê Duyệt</th>
		</tr>
	</thead>
	
	<tbody>
	
	<c:forEach items="${bean.slotList}" var="slot" varStatus="i">
		
		<portlet:renderURL var="tab1Page2Region2">
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2%>" />
				<portlet:param name="<%=RequestConst.TAB_PAGE_REGION%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_2%>" />
				<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${bean.employeeId}" />
				<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.projectId}" />
				<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.period.cdsEvaluationPeriodsId}" />
				<portlet:param name="<%=RequestConst.SLOT_ID%>" value="${slot.slotId}" />
			</portlet:renderURL>
		
		<tr>
			<td class="td-align-center">${i.count}</td>
			<td class="td-align-left">${slot.aliasName}</td>
			<td class="td-align-left">${slot.description}</td>
			<td class="span-2 td-align-center"><a href="${tab1Page2Region2}"><img src="/ProGate-portlet/images/cds/redPen.png" height="25" width="25"></a></td>
			<td class="td-align-center">
			<c:choose>
				<c:when test="${slot.ratingStatus == 0}">
					<img src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" />
				</c:when>
				<c:when test="${slot.ratingStatus == 1 || slot.ratingStatus == 2}">
					<img src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" />
				</c:when>
			</c:choose>
			</td>
			<td class="td-align-center">
			<c:choose>
				<c:when test="${slot.ratingStatusPm == 0}">
					<img src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" />
				</c:when>
				<c:when test="${slot.ratingStatusPm == 1 || slot.ratingStatusPm == 2}">
					<img src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" />
				</c:when>
			</c:choose>
			</td>
			<td class="td-align-center">
			<c:choose>
				<c:when test="${slot.ratingStatusBod == 0}">
					<img src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" />
				</c:when>
				<c:when test="${slot.ratingStatusBod == 1 || slot.ratingStatusBod == 2}">
					<img src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" />
				</c:when>
			</c:choose>
			</td>
		</tr>
	</c:forEach>
		<%-- <tr>
			<td class="td-align-center">1</td>
			<td class="td-align-left">Productivity – 1 – d</td>
			<td class="td-align-left">Consistently perform well under supervision</td>

			<td class="span-2 td-align-center"><a href="${tab1Page3}"><img src="/ProGate-portlet/images/cds/redPen.png" height="25" width="25"></a></td>
			<td class="span-2 td-align-center"><img src="/ProGate-portlet/images/cds/check-green.png" height="25" width="25"></td>
			<td class="span-2 td-align-center"><img src="/ProGate-portlet/images/cds/check-green.png" height="25" width="25"></td>
			<td class="span-2 td-align-center"><img src="/ProGate-portlet/images/cds/check-green.png" height="25" width="25"></td>
		</tr>
		<tr>
			<td class="td-align-center">2</td>
			<td class="td-align-left">Productivity – 2 – d</td>

			<td class="td-align-left">Recognized as a contributing member of the team</td>
			<td class="span-2 td-align-center"><a href="${tab1Page3}"><img src="/ProGate-portlet/images/cds/redPen.png" height="25" width="25"></a></td>
			<td class="td-align-center"><img src="/ProGate-portlet/images/cds/check-green.png" height="25" width="25"></td>
			<td class="td-align-center"><img src="/ProGate-portlet/images/cds/check-green.png" height="25" width="25"></td>
			<td class="td-align-center"><img src="/ProGate-portlet/images/cds/check-green.png" height="25" width="25"></td>
		</tr>
		<tr>
			<td class="td-align-center">3</td>

			<td class="td-align-left">Productivity – 3 – d</td>
			<td class="td-align-left">Recognized as a contributing member of the team.</td>
			<td class="span-2 td-align-center"><a href="${tab1Page3}"><img src="/ProGate-portlet/images/cds/redPen.png" height="25" width="25"></a></td>
			<td class="td-align-center"><img src="/ProGate-portlet/images/cds/check-green.png" height="25" width="25"></td>
			<td class="td-align-center"><img src="/ProGate-portlet/images/cds/check-green.png" height="25" width="25"></td>
			<td class="td-align-center"><img src="/ProGate-portlet/images/cds/check-green.png" height="25" width="25"></td>
			</tr>	 --%>				
	</tbody>

</table>