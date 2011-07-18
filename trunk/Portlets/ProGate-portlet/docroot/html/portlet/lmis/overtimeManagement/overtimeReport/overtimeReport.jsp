<%@ include file="../../../common/init.jsp" %>
<%@ include file="../../../lmis/initOfConfig.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="wrapper">
	<!-- Header -->
	<div class="header">
		<div class="header-center">

			<label id="header-title"><fmt:message key="lmis.overtimeReport.title" />
			</label>
		</div>

		<div class="clear-both"></div>
	</div>
	<!-- End Header -->
	<div class="mainContent">
		<c:choose>
			<c:when test="${bean.manageOTReportPer!=0 || bean.approveOTReportPer !=0 || bean.viewOTReportPer!=0}">
				<!-- Tabbed -->
				<div class="wrap-tabbed">
					<ul class="nav-tabs">
						<c:choose>
							<c:when test="${bean.manageOTReportPer!=0}">
								<li><portlet:renderURL var="overtimeReportOfPerson">
										<portlet:param name="action" value="commonController" />
										<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>" />
										<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
									</portlet:renderURL>
									<c:choose>
										<c:when test="${bean.tabAction==bean.TAB_PERSONAL}">
											<a class='actived' href='#' ><fmt:message key="lmis.common.of" /><span>&nbsp</span>${bean.userName}</a>
										</c:when>
										<c:otherwise>
											<a href='<c:out value="${overtimeReportOfPerson}" />'><fmt:message key="lmis.common.of" /><span>&nbsp</span>${bean.userName}</a>
										</c:otherwise>
									</c:choose>
								</li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${bean.approveOTReportPer !=0}">
								<li><portlet:renderURL var="overtimeManagement">
										<portlet:param name="action" value="commonController" />
										<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>" />
										<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
									</portlet:renderURL>
									<c:choose>
											<c:when test="${bean.tabAction==bean.TAB_MANAGER}">
												<a class='actived' href='#'><fmt:message key="lmis.common.managerby" /><span>&nbsp</span>${bean.userName }</a>
											</c:when>
											<c:otherwise>
											<a href='<c:out value="${overtimeManagement}" />'><fmt:message key="lmis.ot.approved" /><span>&nbsp</span>${bean.userName }</a>
											</c:otherwise>
				
									</c:choose>
								</li>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${bean.viewOTReportPer!=0}">
								<li><portlet:renderURL var="other">
										<portlet:param name="action" value="commonController" />
										<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_OTHER%>" />
										<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
									</portlet:renderURL>
									<c:choose>
											<c:when test="${bean.tabAction==bean.TAB_OTHER}">
												<a class='actived' href='#'><fmt:message key="lmis.common.all" /></a>
											</c:when>
											<c:otherwise>
												<a href='<c:out value="${other}" />'><fmt:message key="lmis.common.all" /></a>
											</c:otherwise>
				
									</c:choose>
								</li>
							</c:when>
						</c:choose>
					</ul>
		
					<div class="boder-bottom-tab"></div>
				</div>
				<!-- End Tabbed -->
		<!-- select tab content -->
				<c:choose>
					<c:when test="${bean.tabAction==bean.TAB_PERSONAL}">
						<c:choose>
							<c:when test="${bean.cmd=='' || bean.cmd== bean.goBack}">
								<jsp:include page="include/viewOvertimeReport.jsp"></jsp:include>
							</c:when>
							<c:when test="${bean.cmd== bean.VIEW || bean.cmd == bean.EDIT || bean.cmd == bean.createReport }">
								<jsp:include page="include/viewAndEditOvertimeReportInDetail.jsp"></jsp:include>
							</c:when>
						</c:choose>
		
					</c:when>
					<c:when test="${bean.tabAction==bean.TAB_MANAGER}">
						<c:choose>
							<c:when test="${bean.cmd==''|| bean.cmd == bean.goBack}">
								<jsp:include page="include/viewOfManager.jsp"></jsp:include>
							</c:when>
							<c:when test="${bean.cmd==bean.approve || bean.cmd==bean.VIEW}">
								<jsp:include page="include/approveByManager.jsp"></jsp:include>
							</c:when>
						</c:choose>
					</c:when>
					<c:when test="${bean.tabAction==bean.TAB_OTHER}">
						<c:choose>
							<c:when test="${bean.cmd=='' || bean.cmd==bean.goBack}">
								<jsp:include page="include/other.jsp"></jsp:include>
							</c:when>
							<c:when test="${bean.cmd==bean.VIEW}">
								<jsp:include page="include/viewOvertimeReportInDetailOfOther.jsp"></jsp:include>
							</c:when>
						</c:choose>
					</c:when>
		
				</c:choose>
			</c:when>
			<c:otherwise>
				<jsp:include page="../../noPermission.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div id="backgroundPopup"></div>