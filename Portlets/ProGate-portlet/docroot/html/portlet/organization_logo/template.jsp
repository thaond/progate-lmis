<%@ include file="/html/portlet/organization_logo/init.jsp" %>
<tiles:useAttribute id="tilesPortletContent" name="portlet_content" classname="java.lang.String" ignore="true" />
<jsp:include page='<%= "/html" + tilesPortletContent %>' flush="true" />

