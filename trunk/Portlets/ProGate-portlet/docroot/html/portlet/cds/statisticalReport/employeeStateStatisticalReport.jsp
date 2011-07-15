<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
<c:when test="${bean.hasPermission == false}">
<div class="cds-container ">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/statisticalReport.png"
			width="40px" height="40px" />
		<strong>Báo Cáo Thống Kê Tình Trạng CDS Của Nhân Viên</strong>
	</div>
	<div class="clear"></div>
	
	<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
		<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
			Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
		</div>
	</div>	
</div>
</c:when>
<c:otherwise>
	<c:if test="${bean.page == 1}">
		<jsp:include page="/html/portlet/cds/statisticalReport/employeeStateStatisticalReportPage1.jsp"></jsp:include>
	</c:if>
	<c:if test="${bean.page == 2}">
		<jsp:include page="/html/portlet/cds/statisticalReport/employeeStateStatisticalReportPage2.jsp"></jsp:include>
	</c:if>
</c:otherwise>
</c:choose>
