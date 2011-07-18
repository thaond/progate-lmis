<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${bean.hasPermissionInputData == false}">
	<div class="cds-container">
		<div class="left padding-top padding-bottom" style="font-size: 1.1em; color: #E46C0A">
			<img class="absmiddle" src="/ProGate-portlet/images/cds/import_big.png"
				width="40px" height="40px" />
			<strong>Nhập dữ liệu</strong>
		</div>
		<div class="clear"></div>
		<div class="border-radius" style="min-height: 495px; margin-bottom: 20px;">
			<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>
	</div>
</c:when>
<c:otherwise>
<div class="cds-container">
	<c:choose>
			<c:when test="${bean.lockInput == true}">
			<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
				<img class="absmiddle" src="/ProGate-portlet/images/cds/import_big.png"
					width="40px" height="40px" />
				<strong>Nhập dữ liệu</strong>
			</div>
			<div class="clear"></div>
			<div class="border-radius" style="min-height: 495px; margin-bottom: 20px; margin-top:10px;">
				<div class="cds-notification">Hiện tại đã có đợt CDS. Bạn không thể nhập dữ liệu.<br/>
					Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
				</div>
			</div>
			</c:when>
			
			<c:when test="${bean.activedPage == bean.INPUT_DATA_PAGE_1}">
				<jsp:include page="/html/portlet/cds/inputData/inputData.jsp"></jsp:include>
			</c:when>

			<c:when test="${bean.activedPage == bean.INPUT_DATA_PAGE_2}">
				<jsp:include page="/html/portlet/cds/inputData/importCds.jsp"></jsp:include>
			</c:when>
			
			<c:when test="${bean.activedPage == bean.INPUT_DATA_PAGE_3}">
				<jsp:include page="/html/portlet/cds/inputData/inputMinimumRequirement.jsp"></jsp:include>
			</c:when>
			
			<c:when test="${bean.activedPage == bean.INPUT_DATA_PAGE_4}">
				<jsp:include page="/html/portlet/cds/inputData/importCdp.jsp"></jsp:include>
			</c:when>
	</c:choose>
</div>
</c:otherwise>
</c:choose>