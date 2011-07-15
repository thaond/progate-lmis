<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="left padding-top padding-bottom" style="font-size: 1.1em; color: #E46C0A; margin-left: 30px;">
	<img class="absmiddle" src="/ProGate-portlet/images/cds/danhgiaCDP.png"
		width="40px" height="40px" />
	<strong>Phê duyệt CDP</strong>
</div>
<c:choose>
<c:when test="${bean.hasPermission == false}">
<div class="clear"></div>
<div class="cds-container">
	<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
		<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
			Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
		</div>
	</div>	
</div>
</c:when>
<c:otherwise>
	<portlet:renderURL var="page1Render">
		<portlet:param name="action" value="commonController" />
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
		<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.CDP_APPROVAL_PAGE_1%>" />
		<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.period.cdsEvaluationPeriodsId}" />
		<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.projectIdForReturnButton}" />
	</portlet:renderURL>
	<c:if test="${bean.page == bean.CDP_APPROVAL_PAGE_2}">
		<div style="margin-right: 30px;" class="right prepend-top padding-top"><a href="${page1Render}"><img class="absmiddle" src="/ProGate-portlet/images/cds/back.png"/> Quay lại</a></div>
	</c:if>
	<div class="clear"></div>
	<div class="cds-container">
	<c:if test="${bean.page == bean.CDP_APPROVAL_PAGE_1}">
		<jsp:include page="/html/portlet/cds/cdp/cdpApproval/cdpApprovalPage1.jsp"></jsp:include>
	</c:if>
	<c:if test="${bean.page == bean.CDP_APPROVAL_PAGE_2}">
		<jsp:include page="/html/portlet/cds/cdp/cdpApproval/cdpApprovalPage2.jsp"></jsp:include>
	</c:if>
	</div>
</c:otherwise>
</c:choose>