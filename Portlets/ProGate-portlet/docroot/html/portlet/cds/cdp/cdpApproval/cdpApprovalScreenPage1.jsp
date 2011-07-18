<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
var hrefLockCDS = '<portlet:actionURL>
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.selectedPeriodId}" />
			</portlet:actionURL>';

jQuery(document).ready(function(){
	jQuery("#search").click(function(e){
		jQuery("#filterForm").submit();	
	});
	
	jQuery(".lockCDS").each(function(i){
		jQuery(this).click(function(){
			var status = jQuery(this).attr("status");
			var employeeId = jQuery(this).attr("employeeId");
			
			if (status == "lock"){
				jQuery(this).attr('src', '/ProGate-portlet/images/cds/unlock.png');	
				jQuery(this).attr("status","unlock");
			}
			if (status == "unlock"){
				jQuery(this).attr('src', '/ProGate-portlet/images/cds/lock.png');
				jQuery(this).attr("status","lock");
			}
			
			jQuery.ajax({
				type:'POST',
				url: hrefLockCDS,
				data: {
					'<%=RequestConst.HANDLE%>':'<%=RequestConst.HANDLE_LOCK_CDS%>',
					'<%=RequestConst.EMPLOYEE_ID%>':employeeId
				},						
				success: function(data){
					//alert("server said: "+ data);
				},
				error: function(){
					alert("Co loi xay ra khi dung ajax");
				}
			});
		});	  
	});
});
</script>
<div class="" style="padding: 10px; background-color: rgb(219, 238, 244); -moz-border-radius-topleft: 5px; -moz-border-radius-topright: 5px; -moz-border-radius-bottomright: 5px; -moz-border-radius-bottomleft: 5px;">
	<portlet:renderURL var="page1Render">
		<portlet:param name="action" value="commonController" />
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
		<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.CDP_APPROVAL_PAGE_1%>" />
	</portlet:renderURL>
	<form id="filterForm" method="post" action="${page1Render}">
		<div class="span-9 padding-bottom">
			<label style="float: left; margin-right: 10px; width: 65px;">Đợt CDS</label>
			<select class="span-7 last" onchange="" id="periodId" name="<%=RequestConst.PERIOD_ID%>">
				<c:forEach items="${bean.periods}" var="period">
					<option <c:if test="${period.cdsEvaluationPeriodsId == bean.selectedPeriodId}">selected="selected"</c:if> value="${period.cdsEvaluationPeriodsId}">
						${period.name} - <fmt:formatDate pattern="MM/yyyy" value="${period.startDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${period.endDate}" />
					</option>	
				</c:forEach>
			</select>
		</div>
		
		<div class="span-9">
			<label style="float: left; margin-right: 10px; width: 65px;">Dự án</label>
			<select class="span-7 last" onchange="" id="periodId" name="<%=RequestConst.PROJECT_ID%>">
				<option value="0">Xem tất cả</option>
				<c:forEach items="${bean.orgs}" var="org">
					<option <c:if test="${org.orgId == bean.selectedProjectId}">selected="selected"</c:if> value="${org.orgId}">
						${org.name}
					</option>	
				</c:forEach>
			</select>
		</div>
		
		<div class="span-3 right"><a id="search" href="#"><img class="absmiddle" src="/ProGate-portlet/images/cds/search.png" height="25" width="25"><span style="color:#E46C0A">Tìm kiếm</span></a></div>
		
	</form>
		<div class="clear"></div>

	</div>
	
	<table>
		<thead>
			<tr>
				<th class="span-1">STT</th>
				<th class="span-5">Tên Nhân Viên</th>
				<th class="span-2">Chức Vụ</th>

				<th class="span-2">Title</th>
				<th class="span-3">Dự Án</th>
				<th class="span-5">Đợt CDS</th>
				<th class="span-2">Trạng Thái Phê Duyệt</th>
				<th class="span-2">Khóa CDS</th>
			</tr>

		</thead>
		
		<tbody>
		<c:set var="numberOrder" value="1" />
		<c:forEach items="${bean.employees}" var="employee">
			<c:if test="${employee.ratingStatus != 0}">	
				<portlet:renderURL var="page2Render">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
					<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.CDP_APPROVAL_PAGE_2%>" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${employee.userId}" />
					<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId)}" />
					<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${employee.periodId}" />
				</portlet:renderURL>
				
				<c:if test="${(bean.userRole == bean.ROLE_PM) || (bean.userRole == bean.ROLE_BOD && functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) == employee.orgId)}">
				<tr <c:if test="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) != employee.orgId}">style="color:gray"</c:if>>
					<td class="td-align-center">
						<c:out value="${numberOrder}"/>
						<c:set var="numberOrder" value="${numberOrder + 1}" />
					</td>
					<td class="td-align-left">
						<a href="#" <c:if test="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) != employee.orgId}">style="color:gray"</c:if>>
							${functions:getUserFullnameByUserId(employee.userId)}
						</a>
					</td>
					<td class="td-align-left">${employee.position}</td>
					<td class="td-align-left">${employee.titleAbbreviation}</td>
					<td class="td-align-left">${employee.orgList}</td>
					<td class="td-align-left">
						${employee.periodName} - <fmt:formatDate pattern="MM/yyyy" value="${employee.fromDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${employee.toDate}" />
					</td>
					<td class="td-align-center">
					<c:if test="${bean.userRole == bean.ROLE_PM}">
						<c:choose>
							<c:when test="${employee.ratingStatusPm == 0}">
								<img class="absmiddle" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" /> 
							</c:when>
							<c:when test="${employee.ratingStatusPm == 1}">
								<img class="absmiddle" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" /> 
							</c:when>
							<c:when test="${employee.ratingStatusPm == 2}">
								<img class="absmiddle" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" /> 
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${bean.userRole == bean.ROLE_BOD}">
						<c:choose>
							<c:when test="${employee.ratingStatusBod == 0}">
								<img class="absmiddle" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" /> 
							</c:when>
							<c:when test="${employee.ratingStatusBod == 1}">
								<img class="absmiddle" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" /> 
							</c:when>
							<c:when test="${employee.ratingStatusBod == 2}">
								<img class="absmiddle" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" /> 
							</c:when>
						</c:choose>
					</c:if>
					</td>
					<td class="td-align-center">
						<c:if test="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) == employee.orgId}">
							<c:choose>
								<c:when test="${employee.isLocked}"><img employeeId="${employee.userId}" class="lockCDS" status="lock" src="/ProGate-portlet/images/cds/lock.png" height="25" width="25" style="cursor:pointer"></c:when>
								<c:otherwise><img class="lockCDS" employeeId="${employee.userId}" status="unlock" src="/ProGate-portlet/images/cds/unlock.png" height="25" width="25" style="cursor:pointer"></c:otherwise>
							</c:choose>
						</c:if>
						<c:if test="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) != employee.orgId}">
							<c:choose>
								<c:when test="${employee.isLocked}"><img src="/ProGate-portlet/images/cds/lock-dis.png" height="25" width="25"></c:when>
								<c:otherwise><img src="/ProGate-portlet/images/cds/unlock-dis.png" height="25" width="25"></c:otherwise>
							</c:choose>
						</c:if>
					</td>
				</tr>
				</c:if>
			</c:if>
		</c:forEach>		
		</tbody>
	</table>
