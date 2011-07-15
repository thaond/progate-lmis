<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${bean.hasPermissionOnTab1 == false}">
		<div class="border-radius" style="min-height: 495pt; margin-bottom: 20px;">
			<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>	
</c:when>
<c:otherwise>
	<c:if test="${bean.page == bean.TAB_APPROVAL_1_PAGE_1}">
		<jsp:include page="/html/portlet/cds/approval/individualApprovalPage1.jsp"></jsp:include>
	</c:if>
	<c:if test="${bean.page == bean.TAB_APPROVAL_1_PAGE_2}">
		<jsp:include page="/html/portlet/cds/approval/individualApprovalPage2.jsp"></jsp:include>
	</c:if>
</c:otherwise>
</c:choose>