<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:renderURL var="tab1">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_BUILDING_PERMIT_1%>" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<portlet:renderURL var="tab2">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_BUILDING_PERMIT_2%>" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<ul class="tabs ">
	<c:if test="${bean.hasPermissionOnTab1 == true}">
	<c:choose>
		<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_1}">
			<li><a href='${tab1}' class='actived'>Phân quyền tổng quát</a></li>	
		</c:when>
		<c:otherwise>
			<li><a href='${tab1}'>Phân quyền tổng quát</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab1 == false}">
		<li><a style="background-color: rgb(220, 219, 218); color: gray; cursor:default; border: 1px solid lightgray; border-bottom: none;">Phân quyền tổng quát</a></li>
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab2 == true}">
	<c:choose>
		<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_2}">
			<li><a href='${tab2}' class='actived'>Phân quyền đặc biệt</a></li>	
		</c:when>
		<c:otherwise>
			<li><a href='${tab2}'>Phân quyền đặc biệt</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab2 == false}">
		<li><a style="background-color: rgb(220, 219, 218); color: gray; cursor:default; border: 1px solid lightgray; border-bottom: none;">Phân quyền đặc biệt</a></li>
	</c:if>
</ul>
