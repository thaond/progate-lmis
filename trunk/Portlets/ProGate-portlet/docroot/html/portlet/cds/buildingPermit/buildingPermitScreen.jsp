<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/validate.js" %>
</script>

<div class="cds-container">
	<div class="left padding-top padding-bottom" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/buildingPermit.png"
			width="40px" height="40px" />
		<strong>Phân Quyền</strong>
	</div>
	<div class="clear"></div>
	
	<c:if test="${bean.hasPermissionOnTab1 == true || bean.hasPermissionOnTab2 == true}">
		<jsp:include page="/html/portlet/cds/buildingPermit/buildingPermitTabs.jsp"></jsp:include>
	</c:if>
	
	<c:choose>
			<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_1}">
				<jsp:include page="/html/portlet/cds/buildingPermit/rolePermissions.jsp"></jsp:include>
			</c:when>

			<c:when test="${bean.activedTab == bean.TAB_BUILDING_PERMIT_2}">
				<jsp:include page="/html/portlet/cds/buildingPermit/userPermissions.jsp"></jsp:include>
			</c:when>
	</c:choose>
</div>