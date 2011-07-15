<%@page import="larion.progate.model.Organization"%>
<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%
	//Build URL
	String homeUrl= PortalUtil.getPortalURL(request);
	String detailSubOrgUrl = homeUrl + "/tochuc/to-chuc-con" + StringPool.QUESTION + URLParameter_RS.VIEW_MODE + StringPool.EQUAL + "0" + StringPool.AMPERSAND + URLParameter_RS.ORG_ID + StringPool.EQUAL;
	String subOrgUrl =  PortalUtil.getCurrentURL(request);
	
	
	List<Organization> listPathOrg = null;
	if(request.getAttribute(URLParameter_RS.LIST_PATH_ORG) != null){
		listPathOrg = (List<Organization>) request.getAttribute(URLParameter_RS.LIST_PATH_ORG);
	}
	int listSize = listPathOrg.size();
	
%>
<script type="text/javascript">

	
	
</script>
<style type="text/css">
   <%@ include file="/css/sub_org/style.css" %>
</style>


<c:set var="listPathOrg" value="<%= listPathOrg %>" />
<c:set var="detailSubOrg" value="<%= detailSubOrgUrl %>" />
<c:set var="listSize" value="<%= listSize %>" />
<div style="width: 90%; float: left;padding-left: 10px;padding-top: 10px; padding-bottom: 10px;">
	<c:forEach items="${listPathOrg}" var="org" varStatus="count">
		<a href="${detailSubOrg}" style="text-decoration: none;color: black;">
			<span style="color: #1F497D;font-size: 15px; font-weight: bold;">
				${org.name}
			</span>
			</a>
		<c:if test="${count.count != listSize }">
			<c:out value=">"></c:out>
		</c:if> 
	</c:forEach>
</div>

