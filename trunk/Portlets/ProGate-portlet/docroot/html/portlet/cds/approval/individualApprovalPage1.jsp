<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
	<c:when test="${bean.errorHaveNotAnyOpenPeriod == true}">
		<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
			<div style="text-align: center; margin-top: 10px; margin-bottom: 10px">
				Hiện không có đợt CDS nào đang tồn tại ở trạng thái “Mở”.<br />
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<script>
			function pagingSubmit() {
				jQuery('#frmIndividualApprovalPage1').submit();
			}
				
			var hrefLockCDS = '<portlet:actionURL>
							<portlet:param name="action" value="commonController" />
							<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
							<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.selectedPeriodId}" />
						</portlet:actionURL>';
			
			jQuery(document).ready(function(){
				jQuery("#search").click(function(e){
					jQuery("#frmIndividualApprovalPage1").submit();	
				});
				
				jQuery(".lockCDS").each(function(i){
					jQuery(this).click(function(){
						var status = jQuery(this).attr("status");
						var employeeId = jQuery(this).attr("employeeId");
						
						if (status == "lock"){
							jQuery(this).attr('src', '/ProGate-portlet/images/cds/unlock.png');	
							jQuery(this).attr("status","unlock");
							jQuery(this).attr("title","CDS đang mở");
						}
						if (status == "unlock"){
							jQuery(this).attr('src', '/ProGate-portlet/images/cds/lock.png');
							jQuery(this).attr("status","lock");
							jQuery(this).attr("title","CDS đã khóa");
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
								//alert("Co loi xay ra khi dung ajax");
							}
						});
					});	  
				});
			});
			</script>
			<portlet:renderURL var="tab1Page1">
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_1%>" />
			</portlet:renderURL>
			
			<div class="border-radius" 
				<c:if test="${bean.userRole == bean.ROLE_PM}">style="min-height: 495px;"</c:if>
				<c:if test="${bean.userRole == bean.ROLE_BOD}">style="min-height: 475px;"</c:if>
			>
				<form id="frmIndividualApprovalPage1" name="frmIndividualApprovalPage1" action="${tab1Page1}" method="post">
					<div class="" style="padding: 10px; background-color: rgb(219, 238, 244); -moz-border-radius-topleft: 5px; -moz-border-radius-topright: 5px; -moz-border-radius-bottomright: 5px; -moz-border-radius-bottomleft: 5px;">
					<%-- <form id="filterForm" method="post" action="${tab1Page1}"> --%>
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
						
						<div class="span-10 last padding-bottom">
							<label style="float: left; margin-left: 10px; margin-right: 10px; width: 92px;">Tên Nhân Viên</label>
							<select class="span-7 last">
								<option>Chọn tên nhân viên</option>
							</select>
						</div>
				
						
						<div class="span-3 right" style="margin-top: 15px;"><a id="search" href="#"><img class="absmiddle" src="/ProGate-portlet/images/cds/search.png" height="25" width="25"><span style="color:#E46C0A">Tìm kiếm</span></a></div>
						
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
				
						
						<div class="span-10 last">
							<label style="float: left; margin-left: 10px; margin-right: 10px; width: 92px;">Trạng Thái</label>
							<select onchange="" class="span-7 last" name="<%=RequestConst.CDS_STATUS%>">
								<option value="3" <c:if test="${bean.selectedCdsStatus == 3}">selected="selected"</c:if>>Xem tất cả</option>
								<option value="0" <c:if test="${bean.selectedCdsStatus == 0}">selected="selected"</c:if>>Chưa phê duyệt</option>
								<option value="1" <c:if test="${bean.selectedCdsStatus == 1}">selected="selected"</c:if>>Đang phê duyệt</option>
								<option value="2" <c:if test="${bean.selectedCdsStatus == 2}">selected="selected"</c:if>>Đã phê duyệt</option>
							</select>
						</div>
					<!-- </form> -->
						<div class="clear"></div>
				
					</div>

					<c:if test="${bean.sizeOfEmployees > 0}">
					<div 
						<c:if test="${bean.userRole == bean.ROLE_PM}">style="min-height: 400px;"</c:if>
						<c:if test="${bean.userRole == bean.ROLE_BOD}">style="min-height: 375px;"</c:if>
					>
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
								<portlet:renderURL var="tab1Page2">
									<portlet:param name="action" value="commonController" />
									<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
									<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
									<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2%>" />
									<portlet:param name="<%=RequestConst.TAB_PAGE_REGION%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_1%>" />
									<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${employee.userId}" />
									<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId)}" />
									<portlet:param name="projectIdForReturnButton" value="${bean.selectedProjectId}" />
									<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${employee.periodId}" />
									<portlet:param name="<%=RequestConst.DISABLE_APPROVAL%>" value="${(functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) != employee.orgId) || (employee.isRemoved == true)}" />
								</portlet:renderURL>
								
								<%-- Du an truoc sau
								<c:if test="${(bean.userRole == bean.ROLE_PM) || (bean.userRole == bean.ROLE_BOD && functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) == employee.orgId)}"> --%>
								<tr <c:if test="${(functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) != employee.orgId) || (employee.isRemoved == true)}">style="color:gray"</c:if>>
									<td class="td-align-center">
										<c:out value="${numberOrder}"/>
										<c:set var="numberOrder" value="${numberOrder + 1}" />
									</td>
									<td class="td-align-left">
										<a href="${tab1Page2}" <c:if test="${(functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) != employee.orgId) || (employee.isRemoved == true)}">style="color:gray"</c:if>>
											${functions:getUserFullnameByUserId(employee.userId)}
										</a>
										<%-- Test:PeriodID(${bean.selectedPeriodId}), employeeId(${employee.userId}), ProjectIdOfEmployeeByPeriod(${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) }), employee.orgId(${employee.orgId}) --%>
									</td>
									<td class="td-align-left">${employee.position}</td>
									<td class="td-align-left">
										<c:choose>
											<c:when test="${empty employee.titleAbbreviation}">N/A</c:when>
											<c:otherwise>${employee.titleAbbreviation}</c:otherwise>
										</c:choose>
									</td>
									<td class="td-align-left">${employee.orgList}</td>
									<td class="td-align-left">
										${employee.periodName} - <fmt:formatDate pattern="MM/yyyy" value="${employee.fromDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${employee.toDate}" />
									</td>
									<td class="td-align-center">
									<c:if test="${bean.userRole == bean.ROLE_PM}">
										<c:choose>
											<c:when test="${employee.ratingStatusPm == 0}">
												<img class="absmiddle" title="Chưa phê duyệt" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" /> 
											</c:when>
											<c:when test="${employee.ratingStatusPm == 1}">
												<img class="absmiddle" title="Đang phê duyệt" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" /> 
											</c:when>
											<c:when test="${employee.ratingStatusPm == 2}">
												<img class="absmiddle" title="Đã phê duyệt" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" /> 
											</c:when>
										</c:choose>
									</c:if>
									<c:if test="${bean.userRole == bean.ROLE_BOD}">
										<c:choose>
											<c:when test="${employee.ratingStatusBod == 0}">
												<img class="absmiddle" title="Chưa phê duyệt" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" /> 
											</c:when>
											<c:when test="${employee.ratingStatusBod == 1}">
												<img class="absmiddle" title="Đang phê duyệt" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" /> 
											</c:when>
											<c:when test="${employee.ratingStatusBod == 2}">
												<img class="absmiddle" title="Đã phê duyệt" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" /> 
											</c:when>
										</c:choose>
									</c:if>
									</td>
									<td class="td-align-center">
										<c:if test="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) == employee.orgId}">
											<c:choose>
												<c:when test="${employee.isLocked}"><img employeeId="${employee.userId}" class="lockCDS" status="lock" title="CDS đã khóa" src="/ProGate-portlet/images/cds/lock.png" height="25" width="25" style="cursor:pointer"></c:when>
												<c:otherwise><img class="lockCDS" employeeId="${employee.userId}" status="unlock" title="CDS đang mở" src="/ProGate-portlet/images/cds/unlock.png" height="25" width="25" style="cursor:pointer"></c:otherwise>
											</c:choose>
										</c:if>
										<c:if test="${functions:getProjectIdOfEmployeeByPeriod(bean.selectedPeriodId, employee.userId) != employee.orgId}">
											<c:choose>
												<c:when test="${employee.isLocked}"><img src="/ProGate-portlet/images/cds/lock-dis.png" title="CDS đã khóa" height="25" width="25"></c:when>
												<c:otherwise><img src="/ProGate-portlet/images/cds/unlock-dis.png" title="CDS đang mở" height="25" width="25"></c:otherwise>
											</c:choose>
										</c:if>
									</td>
								</tr>
								<%-- </c:if> --%>
							</c:forEach>
						</tbody>
					</table>
					</div>
						<c:if test="${bean.sizeOfEmployees >= 10}">
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
								<th class="span-2">Chức Vụ</th>
				
								<th class="span-2">Title</th>
								<th class="span-3">Dự Án</th>
								<th class="span-4">Đợt CDS</th>
								<th class="span-2">Trạng Thái Phê Duyệt</th>
								<th class="span-2">Khóa CDS</th>
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