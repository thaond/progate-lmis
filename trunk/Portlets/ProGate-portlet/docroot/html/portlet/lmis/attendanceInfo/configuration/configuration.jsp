<%@ include file="../../../common/init.jsp"%>
<%@ include file="../../../lmis/initOfConfig.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


<div class="wrapper">
	<!-- Header -->
	<div class="header">
		<div class="header-center">
			<b><fmt:message key="lmis.config.title" /> </b>
		</div>
<!-- 		<div class="clear-both"></div> -->
	</div>
	<!-- End Header -->
	<div class="mainContent">
		<!-- Tabbed -->
		<c:choose>
			<c:when test="${bean.permission!=0}">
				
				<div class="wrap-tabbed">
					<ul class="nav-tabs">
						<li><portlet:renderURL var="configEmail">
								<portlet:param name="action" value="configuration" />
								<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.EMAIL_TAB%>" />
								<portlet:param name="orgId" value="${bean.orgId}" />
							</portlet:renderURL> 
							<c:choose>
								<c:when test="${bean.tabAction==bean.emailTab}">
									<a class='actived' href='#' ><fmt:message key="lmis.config.email.title" /> </a>
								</c:when>
								<c:otherwise>
								<a href='<c:out value="${configEmail}" />'><fmt:message	key="lmis.config.email.title" /> </a>
								</c:otherwise>						
							</c:choose>
						</li>
		
						<li><portlet:renderURL var="configWorkingTime">
								<portlet:param name="action" value="configuration" />
								<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.WORKINGTIME_TAB%>" />
								<portlet:param name="orgId" value="${bean.orgId}" />
							</portlet:renderURL> 
							<c:choose>
									<c:when test="${bean.tabAction==bean.workingTimeTab}">
										<a class='actived' href='#'><fmt:message
												key="lmis.config.workingTime.title" /> </a>
									</c:when>
									<c:otherwise>
									<a href='<c:out value="${configWorkingTime}" />'><fmt:message
												key="lmis.config.workingTime.title" /> </a>
									</c:otherwise>
									
							</c:choose>
						</li>
		
						<li><portlet:renderURL var="configCalendar">
								<portlet:param name="action" value="configuration" />
								<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.CALENDAR_TAB%>" />
								<portlet:param name="orgId" value="${bean.orgId}" />
							</portlet:renderURL> 
								<c:choose>
									<c:when test="${bean.tabAction==bean.calendarTab}">
										<a class='actived' href='#'><fmt:message
												key="lmis.config.calendar.title" /> </a>
									</c:when>
									<c:otherwise>
									<a href='<c:out value="${configCalendar}" />'><fmt:message
												key="lmis.config.calendar.title" /> </a>
									</c:otherwise>
									
								</c:choose>
						</li>
						
						<li><portlet:renderURL var="configAttendanceCode">
								<portlet:param name="action" value="configuration" />
								<portlet:param name="<%= Request.TAB_ACTION%>" value="<%= Request.ATTENDANCECODE_TAB%>" />
								<portlet:param name="orgId" value="${bean.orgId}" />
							</portlet:renderURL> 
								<c:choose>
									<c:when test="${bean.tabAction==bean.attendanceCodeTab}">
										<a class='actived' href='#'><fmt:message
												key="lmis.config.attendanceCode.title" /> </a>
									</c:when>
									<c:otherwise>
									<a href='<c:out value="${configAttendanceCode}" />'><fmt:message
												key="lmis.config.attendanceCode.title" /> </a>
									</c:otherwise>
									
								</c:choose>
						</li>
						<li><portlet:renderURL var="configAttendanceInfoFile">
								<portlet:param name="action" value="configuration" />
								<portlet:param name="<%= Request.TAB_ACTION%>" value="<%= Request.ATTENDANCE_INFO_FILE_TAB%>" />
								<portlet:param name="orgId" value="${bean.orgId}" />
							</portlet:renderURL> 
								<c:choose>
									<c:when test="${bean.tabAction==bean.attendanceInfoFileTab}">
										<a class='actived' href='#'><fmt:message
												key="lmis.config.file.title" /> </a>
									</c:when>
									<c:otherwise>
									<a href='<c:out value="${configAttendanceInfoFile}" />'><fmt:message
												key="lmis.config.file.title" /> </a>
									</c:otherwise>
									
								</c:choose>
						</li>
					</ul>
					
					<div class="boder-bottom-tab"></div>
				</div>
				<!-- End Tabbed -->
		
				<c:choose>
					<c:when test="${bean.tabAction==bean.emailTab}">
						<jsp:include page="include/configEmail.jsp"></jsp:include>
					</c:when>
					<c:when test="${bean.tabAction==bean.workingTimeTab}">
						<jsp:include page="include/configWorkingTime.jsp"></jsp:include>
					</c:when>
					<c:when test="${bean.tabAction==bean.calendarTab}">
						<jsp:include page="include/configCalendar.jsp"></jsp:include>
					</c:when>
					<c:when test="${bean.tabAction==bean.attendanceCodeTab}">
						<jsp:include page="include/configAttendanceCode.jsp" ></jsp:include>
					</c:when>
					<c:when test="${bean.tabAction==bean.attendanceInfoFileTab}">
						<jsp:include page="include/configAttendanceInfoFile.jsp" ></jsp:include>
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
