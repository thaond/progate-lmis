<%@ include file="/html/portlet/common/init.jsp"%>
<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${bean.userRole == bean.ROLE_BOD}">

<portlet:renderURL var="tab1Page1">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
	<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_1%>" />
	<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.period.cdsEvaluationPeriodsId}" />
	<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.projectIdForReturnButton}" />
</portlet:renderURL>
<c:if test="${bean.region == bean.TAB_APPROVAL_1_PAGE_2_REGION_1}">
	<div class="right"><a href="${tab1Page1}"><img class="absmiddle" src="/ProGate-portlet/images/cds/back.png"/> Quay lại</a></div>
</c:if>

<portlet:renderURL var="tab1">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<portlet:renderURL var="tab2">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_2%>" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
</portlet:renderURL>

<portlet:renderURL var="tab3">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_3%>" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
</portlet:renderURL>

<ul class="tabs ">
	<c:if test="${bean.hasPermissionOnTab1 == true}">
	<c:choose>
		<c:when test="${bean.activedTab == bean.TAB_APPROVAL_1}">
			<li><a href='${tab1}' class='actived'>Phê duyệt cá nhân</a></li>	
		</c:when>
		<c:otherwise>
			<li><a href='${tab1}'>Phê duyệt cá nhân</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	<c:if test="${bean.hasPermissionOnTab1 == false}">
		<li><a style="background-color: rgb(220, 219, 218); color: gray; cursor:default; border: 1px solid lightgray; border-bottom: none;">Phê duyệt cá nhân</a></li>
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab2 == true}">
	<c:choose>
		<c:when test="${bean.activedTab == bean.TAB_APPROVAL_2}">
			<li><a href='${tab2}' class='actived'>Phê duyệt toàn bộ</a></li>	
		</c:when>
		<c:otherwise>
			<li><a href='${tab2}'>Phê duyệt toàn bộ</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	<c:if test="${bean.hasPermissionOnTab2 == false}">
		<li><a style="background-color: rgb(220, 219, 218); color: gray; cursor:default; border: 1px solid lightgray; border-bottom: none;">Phê duyệt toàn bộ</a></li>
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab3 == true}">
	<c:choose>
		<c:when test="${bean.activedTab == bean.TAB_APPROVAL_3}">
			<li><a href='${tab3}' class='actived'>Phê duyệt title</a></li>	
		</c:when>
		<c:otherwise>
			<li><a href='${tab3}'>Phê duyệt title</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	<c:if test="${bean.hasPermissionOnTab3 == false}">
		<li><a style="background-color: rgb(220, 219, 218); color: gray; cursor:default; border: 1px solid lightgray; border-bottom: none;">Phê duyệt title</a></li>
	</c:if>
</ul>
</c:if>