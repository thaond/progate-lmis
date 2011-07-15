<%@ include file="../../../common/init.jsp"%>
<%@ include file="../../../lmis/initOfConfig.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


<div class="wrapper">
	<!-- Header -->
	<div class="header">
		<div class="header-left"></div>
		<div class="header-right"></div>

		<div class="header-center">

			<label id="header-title"><fmt:message key="lmis.config.title" />
			</label>
		</div>

		<div class="clear-both"></div>
	</div>
	<!-- End Header -->
	<div class="mainContent">
		<c:choose>
			<c:when test="${bean.permission != 0}">
			<!-- Tabbed -->
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
	
					<li><portlet:renderURL var="coefficientOvertime">
							<portlet:param name="action" value="configuration" />
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.COEFFICIENTOVERTIME_TAB%>" />
							<portlet:param name="orgId" value="${bean.orgId}" />
						</portlet:renderURL> 
						<c:choose>
								<c:when test="${bean.tabAction==bean.coefficientOvertimeTab}">
									<a class='actived' href='#'><fmt:message
											key="lmis.config.coefficientOvertime.title" /> </a>
								</c:when>
								<c:otherwise>
								<a href='<c:out value="${coefficientOvertime}" />'><fmt:message
											key="lmis.config.coefficientOvertime.title" /> </a>
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
				<c:when test="${bean.tabAction==bean.coefficientOvertimeTab}">
					<jsp:include page="include/coefficientOvertime.jsp"></jsp:include>
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
