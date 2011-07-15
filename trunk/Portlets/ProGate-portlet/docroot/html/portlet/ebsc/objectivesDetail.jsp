<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="tabs-menu-1">		
	<c:choose>
		<c:when test="${bean.tabAction == bean.TA_1_2}">
			<div class="tabs-state-1 tabs-state-active-1">
			<a><fmt:message key="button.edit"/></a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="tabs-state-1 tabs-state-default-1">
				<portlet:renderURL var="editOrgURL">
				    <portlet:param name="action"  
				                   value="showingOrgainzationDetails" />					    
				    <portlet:param name="<%=Request.ORG_ID %>"
				                   value="${bean.org.orgId}" />
                   	<portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
	                			   value="${bean.objectiveSet.orgObjectListId}" />
				    <portlet:param name="<%=Request.TA %>"
				                   value="<%=Request.TA_1_2 %>" />
			  	</portlet:renderURL>
				<a  href='<c:out value="${editOrgURL}"/>'><fmt:message key="button.edit"/></a>
			</div>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${bean.tabAction == bean.TA_1_3}">
			<div class="tabs-state-1 tabs-state-active-1">
			<a><fmt:message key="button.view"/></a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="tabs-state-1 tabs-state-default-1">
				<portlet:renderURL var="viewOrgURL">
				    <portlet:param name="action"
				                   value="showingOrgainzationDetails" />
				    <portlet:param name="<%=Request.ORG_ID %>"
				                   value="${bean.org.orgId}" />
				    <portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
	                			   value="${bean.objectiveSet.orgObjectListId}" />
				    <portlet:param name="<%=Request.TA %>"
				                   value="<%=Request.TA_1_3 %>" />
			  	</portlet:renderURL>
				<a  href='<c:out value="${viewOrgURL}"/>'><fmt:message key="button.view"/></a>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<div>
<c:choose>
	<c:when test="${bean.tabAction == bean.TA_1_2}">
		<jsp:include page="objectivesEdit.jsp"></jsp:include>
	</c:when>
	
	<c:when test="${bean.tabAction == bean.TA_1_3}">
		<jsp:include page="objectivesView.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
	
	</c:otherwise>
</c:choose>
</div>
	
