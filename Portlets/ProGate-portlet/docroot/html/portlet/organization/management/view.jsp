<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div style="width: 170px; margin: 0 auto; text-align: center;">
<div>
	<a href="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
	         <portlet:param name='struts_action' value='/organization_management/org_management'/>
	         </portlet:renderURL>"
			style="text-decoration:none">
	<img alt="<fmt:message key="title.organization.management" />"
		 src="<%=request.getContextPath() %>/images/organization_management.png"
		 title='<fmt:message key="title.organization.management" />'>
	</a>
</div>
<div style="padding-top: 7px;">
<a href="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
         <portlet:param name='struts_action' value='/organization_management/org_management'/>
         </portlet:renderURL>"
			style="text-decoration:none">
	<font color="blue"><fmt:message key="title.organization.management" /></font>
</a>
</div>
</div>
