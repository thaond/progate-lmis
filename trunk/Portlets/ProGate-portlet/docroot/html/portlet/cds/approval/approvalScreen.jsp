<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/validate.js" %>
</script>

<c:if test="${bean.userRole == bean.ROLE_PM}">
<portlet:renderURL var="tab1Page1">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
	<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_1%>" />
	<portlet:param name="<%=RequestConst.TAB_PAGE_REGION%>" value="" />
	<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.period.cdsEvaluationPeriodsId}" />
	<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.projectIdForReturnButton}" />
</portlet:renderURL>
<c:if test="${bean.region == bean.TAB_APPROVAL_1_PAGE_2_REGION_1}">
	<div class="right prepend-top padding-top" style="margin-right: 30px"><a href="${tab1Page1}"><img class="absmiddle" src="/ProGate-portlet/images/cds/back.png"/> Quay lại</a></div>
</c:if>
</c:if>

<div class="cds-container">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/Approval.png"
			width="40px" height="40px" />
		<strong>Phê duyệt</strong>
	</div>
	<div class="clear"></div>
	
	<jsp:include page="/html/portlet/cds/approval/approvalTabs.jsp"></jsp:include>

	<c:choose>
			<c:when test="${bean.activedTab == bean.TAB_APPROVAL_1}">
				<jsp:include page="/html/portlet/cds/approval/individualApproval.jsp"></jsp:include>
			</c:when>

			<c:when test="${bean.activedTab == bean.TAB_APPROVAL_2}">
				<jsp:include page="/html/portlet/cds/approval/allStaffApproval.jsp"></jsp:include>
			</c:when>
			
			<c:when test="${bean.activedTab == bean.TAB_APPROVAL_3}">
				<jsp:include page="/html/portlet/cds/approval/titleApproval.jsp"></jsp:include>
			</c:when>
	</c:choose>
</div>