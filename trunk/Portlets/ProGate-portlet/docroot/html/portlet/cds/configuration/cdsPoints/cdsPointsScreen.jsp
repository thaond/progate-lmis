<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${bean.hasPermissionOnTab2 == false}">
<div class="cds-container">
	<jsp:include page="/html/portlet/cds/configuration/configScreenTabs.jsp"></jsp:include>
	<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
		<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
			Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
		</div>
	</div>	
</div>
</c:when>
<c:otherwise>
<div class="cds-container">
<jsp:include page="/html/portlet/cds/configuration/configScreenTabs.jsp"></jsp:include>

<div class="border-radius span-23" style="min-height: 460px;">
	<c:if test="${bean.size == 0}">
	<div class="prepend-top prepend-1">
		<a href='#' id='addCdsPoint'>
			<img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" 
				width="25px" height="25px"/> Thêm thang điểm
		</a>
	</div>
	</c:if>
	
	<c:if test="${bean.size > 0}">
		<div class="span-12 prepend-5">
			<div class="prepend-10" style="padding-top:8px; padding-bottom:8px;">
			<a href='#' id='editCdsPoint'>
				<img class="absmiddle" src="/ProGate-portlet/images/cds/edit.gif" 
					width="22px" height="22px"/> Sửa
			</a>
		</div>
		
		<div class="span-12" style="border: 1px solid #30A1BE;">
		<table>
			<tr style="color:white; background: #30A1BE;">
				<th colspan="3" style="text-align: center;">Cấu Hình Thang Điểm</th>
			</tr>
			<tr style="color:white; background: #30A1BE;">
				<th style="text-align: center; width: 20%;">Điểm</th>
				<th style="text-align: center; width: 30%;">Điểm bằng số</th>
				<th style="text-align: center;">Mô Tả</th>
			</tr>
			<c:forEach items="${bean.CdsPointList}" var="cdsPoint">
			<tr>
				<td class="td-align-center"><c:out value="${cdsPoint.pointName}" /></td>
				<td class="td-align-center"><c:out value="${cdsPoint.pointValue}" /></td>
				<td><c:out value="${cdsPoint.description}" /></td>
			</tr>
			</c:forEach>
		</table>
		</div>
	</div>
	</c:if>
</div>
 
<jsp:include page="/html/portlet/cds/configuration/cdsPoints/cdsPointsDialog.jsp"></jsp:include>
<jsp:include page="/html/portlet/cds/configuration/cdsPoints/cdsPointsValidation.jsp"></jsp:include>
</div>
</c:otherwise>
</c:choose>

<script>
	jQuery(function() {
		if(${bean.lockEditButton == true}){
			jQuery('#editCdsPoint').css("color", "gray");
		}
	});
</script>