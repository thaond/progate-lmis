<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${bean.hasPermissionOnTab1 == false}">
		<div class="border-radius" style="min-height: 495px; margin-bottom: 20px;">
			<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>	
</c:when>
<c:otherwise>
<portlet:renderURL var="tab1">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_BUILDING_PERMIT_1%>" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<div class="cds-container">
	<div class="border-radius span-23" style="padding-bottom:10px;">
		<div class="column span-6 prepend-1">
			<div class="prepend-top" style="color: orange; font-weight: bold; padding-bottom:5px;">Nhóm người dùng</div>
				<form style="padding-left: 20px;" action='<c:out value="${tab1}"/>' method="post">
					<input <c:if test="${bean.roleId==8}">checked</c:if> type="radio" name="roleId" value="8" onchange="this.form.submit()"> Nhân Viên<br>
					<input <c:if test="${bean.roleId==5}">checked</c:if> type="radio" name="roleId" value="5" onchange="this.form.submit()"> PM<br>
					<input <c:if test="${bean.roleId==9}">checked</c:if> type="radio" name="roleId" value="9" onchange="this.form.submit()"> BOD
				</form>
		</div>
		<div class="span-8">
		<div class="scroll border-radius span-10 prepend-top">
			<div style="padding: 1px;">
				<table>
				<thead>
					<tr style="color:white; background: #30A1BE;">
							<th colspan="2" style="text-align: center;">Danh Sách Chức Năng</th>
					</tr>
				</thead>
				<tbody class="scroll-y" style="height:315px">
					<c:forEach items="${bean.fullPer}" var="fp" varStatus="count">
						<tr>
							<td style="width:15px">
								<input disabled style="margin-left:8px" type="checkbox" value="${fp.proGatePermissionsId}"/>
							</td>
							<td style="padding-left:10px">
								${fp.description}<br />
							</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</div>
			</div>
			
		</div>
		<div class="column span-6 prepend-10" style="padding-top:10px">
			<input disabled="disabled" type="submit" value='<fmt:message key="button.save" />' class="cds-btn-yes" style="background:#CFCEC9; color: #7E7E7E;"/> 
			<input disabled="disabled" type="submit" value='<fmt:message key="button.default" />' class="cds-btn-no" style="background:#CFCEC9; color: #7E7E7E;"/>
		</div>
	</div>
</div>
</c:otherwise>
</c:choose>

<script>
jQuery(document).ready(function() {
	jQuery('input[type="checkbox"]:checked').each(function(){
		this.checked = false;
	});
	<c:forEach items="${bean.rolePer}" var="rp">
	var perId = '${rp.proGatePermissionsRolesId}';
	jQuery("input[value='"+perId+"'][type='checkbox']").each(function(){
		this.checked = true;
	});
	</c:forEach>
});
</script>