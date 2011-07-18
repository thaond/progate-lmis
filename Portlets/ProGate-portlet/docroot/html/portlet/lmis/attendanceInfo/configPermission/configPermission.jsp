<%@ page import="com.larion.progate.lmis.constants.LmisRequest" %>
<%@ include file="../../../common/init.jsp" %>
<%@ include file="../../../lmis/init-ttn.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="wrapper">
	<!-- Header -->
	<div class="header">
		<div class="header-center">

			<label id="header-title"><fmt:message key="lmis.configPermission.title" />
			</label>
		</div>

		<div class="clear-both"></div>
	</div>
<div class="mainContent">
				<portlet:renderURL var="tab1">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=LmisRequest.TAB_ACTION%>" value="<%=LmisRequest.TAB_BUILDING_PERMIT_1%>" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
				</portlet:renderURL>
	
				<portlet:renderURL var="tab2">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=LmisRequest.TAB_ACTION%>" value="<%=LmisRequest.TAB_BUILDING_PERMIT_2%>" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
				</portlet:renderURL>
	
				<portlet:renderURL var="tab3">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=LmisRequest.TAB_ACTION%>" value="<%=LmisRequest.TAB_BUILDING_PERMIT_3%>" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
				</portlet:renderURL>
	<c:choose>
		<c:when test="${bean.updatePermission !=0 || bean.authorizedPermission != 0}">
			<div class="wrap-tabbed">
				<ul class="nav-tabs">
					<c:choose>
						<c:when test="${bean.updatePermission != 0}">
							<c:choose>
								<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_1}">
									<li><a href='${tab1}' class='actived'><fmt:message key="lmis.configPermission.generalPermission" /></a></li>
								</c:when>
								<c:otherwise>
									<li><a href='${tab1}'><fmt:message key="lmis.configPermission.generalPermission" /></a></li>
								</c:otherwise>
							</c:choose>
						
							<c:choose>
								<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_2}">
									<li><a href='${tab2}' class='actived'><fmt:message key="lmis.configPermission.personalPermission" /></a></li>
								</c:when>
								<c:otherwise>
									<li><a href='${tab2}'><fmt:message key="lmis.configPermission.personalPermission" /></a></li>
								</c:otherwise>
							</c:choose>
						</c:when>
					</c:choose>		
					<c:choose>
						<c:when test="${bean.authorizedPermission !=0}">
							<c:choose>
								<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_3}">
									<li><a href='${tab3}' class='actived'><fmt:message key="lmis.configPermission.delegate" /></a></li>
								</c:when>
								<c:otherwise>
									<li><a href='${tab3}'><fmt:message key="lmis.configPermission.delegate" /></a></li>
								</c:otherwise>
							</c:choose>
						</c:when>
					</c:choose>
				</ul>
			</div>
				<c:choose>
					 <c:when test="${bean.updatePermission !=0 && bean.authorizedPermission !=0}">
					 	<c:choose>
							<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_1}">
								<jsp:include page="include/rolePermissions.jsp"></jsp:include>
							</c:when>
							<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_2}">
								<jsp:include page="include/userPermissions.jsp"></jsp:include>
							</c:when>
							<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_3}">
								<jsp:include page="include/delegate.jsp"></jsp:include>
							</c:when>
						</c:choose>
					 </c:when>				
					 <c:when test="${bean.updatePermission !=0}">
					 	<c:choose>
							<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_1}">
								<jsp:include page="include/rolePermissions.jsp"></jsp:include>
							</c:when>
							<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_2}">
								<jsp:include page="include/userPermissions.jsp"></jsp:include>
							</c:when>
						</c:choose>
					</c:when>
					<c:when test="${bean.authorizedPermission !=0}">
						<c:choose>
						<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_3}">
							<jsp:include page="include/delegate.jsp"></jsp:include>
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