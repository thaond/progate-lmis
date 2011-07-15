<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${bean.hasPermission == true }">
	<script>
	function pagingSubmit() {
		jQuery('#frmCdpApprovalPage1').submit();
	}
	
	var hrefLockCDS = '<portlet:actionURL>
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
					<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.selectedPeriodId}" />
				</portlet:actionURL>';
	
	jQuery(document).ready(function(){
		jQuery("#search").click(function(e){
			jQuery("#frmCdpApprovalPage1").submit();	
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
	<portlet:renderURL var="page1Render">
		<portlet:param name="action" value="commonController" />
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
		<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.CDP_APPROVAL_PAGE_1%>" />
	</portlet:renderURL>
	
	<c:choose>
		<c:when test="${bean.errorHaveNotAnyClosePeriod == true}">
			<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
				<div class="cds-notification">Không có đợt CDS nào ở trạng thái "Đóng".</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="border-radius" style="min-height: 485px;">
				<form id="frmCdpApprovalPage1" name="frmCdpApprovalPage1" action="${page1Render}" method="post">
					<div style="padding-top: 10px; padding-left: 10px; background-color: #DBEEF4">
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
						
						<div class="span-9" style="margin-left:50px">
							<label style="float: left; margin-right: 10px; width: 50px;">Dự án</label>
							<select class="span-7 last" onchange="" id="periodId" name="<%=RequestConst.PROJECT_ID%>">
								<option value="0">Xem tất cả</option>
								<c:forEach items="${bean.orgs}" var="org">
									<option <c:if test="${org.orgId == bean.selectedProjectId}">selected="selected"</c:if> value="${org.orgId}">
										${org.name}
									</option>	
								</c:forEach>
							</select>
						</div>
						
						<div class="span-3 right"><a id="search" href="#"><img style="margin-top:-2px" class="absmiddle" src="/ProGate-portlet/images/cds/search.png" height="25" width="25"><span style="color:#E46C0A">Tìm kiếm</span></a></div>
						
						<div class="clear"></div>
					</div>
					<c:if test="${bean.sizeOfEmployees > 0}">
					<div style="min-height:410px">
					<table>
						<thead>
							<tr>
								<th class="span-1">STT</th>
								<th class="span-5">Tên Nhân Viên</th>
								<th class="span-3">Chức Vụ</th>
				
								<th class="span-3">Title</th>
								<th class="span-3">Dự Án</th>
							</tr>
				
						</thead>
						
						<tbody>
							<c:set var="numberOrder" value="1" />
							<c:forEach items="${bean.employees}" var="employee">
								<portlet:renderURL var="page2Render">
									<portlet:param name="action" value="commonController" />
									<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
									<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.CDP_APPROVAL_PAGE_2%>" />
									<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${employee.userId}" />
									<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId)}" />
									<portlet:param name="projectIdForReturnButton" value="${bean.selectedProjectId}" />
									<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${employee.periodId}" />
								</portlet:renderURL>
								
								<%-- <c:if test="${(bean.userRole == bean.ROLE_PM) || (bean.userRole == bean.ROLE_BOD && functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) == employee.orgId)}"> --%>
								<%-- <c:if test="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) != employee.orgId}">style="color:gray"</c:if> --%>
								<tr>
									<td class="td-align-center">
										<c:out value="${numberOrder}"/>
										<c:set var="numberOrder" value="${numberOrder + 1}" />
									</td>
									<td class="td-align-left">
										<%-- <c:if test="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) != employee.orgId}">style="color:gray"</c:if> --%>
										<a href="${page2Render}">
											${functions:getUserFullnameByUserId(employee.userId)}
										</a>
									</td>
									<td class="td-align-left">${employee.position}</td>
									<td class="td-align-left">
										<c:choose>
											<c:when test="${empty employee.titleAbbreviation}">N/A</c:when>
											<c:otherwise>${employee.titleAbbreviation}</c:otherwise>
										</c:choose>
									</td>
									<td class="td-align-left">${employee.orgList}</td>
								</tr>
								<%-- </c:if> --%>
							</c:forEach>		
						</tbody>
					</table>
					</div>
					<c:if test="${bean.sizeOfEmployees > 10}">
						<div class="cds-paging">
							<c:set value="${bean.pagination}" var="paging"></c:set>
							<%@ include file="/html/portlet/common/pagination.jsp" %>
						</div>
					</c:if>
					</c:if>
					<c:if test="${bean.sizeOfEmployees == 0}">
						<table>
							<thead>
								<tr>
									<th class="span-1">STT</th>
									<th class="span-5">Tên Nhân Viên</th>
									<th class="span-3">Chức Vụ</th>
					
									<th class="span-3">Title</th>
									<th class="span-3">Dự Án</th>
								</tr>
					
							</thead>
							
							<tbody>
							</tbody>
						</table>
						<div style="text-align: center; color: red; margin-top: 10px; margin-bottom: 10px">Không có dữ liệu</div>
					</c:if>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
</c:if>