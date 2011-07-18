<%@ page import="com.larion.progate.lmis.constants.LmisRequest" %>
<%@ include file="../../../../common/init.jsp" %>
<%@ include file="../../../../lmis/init-ttn.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<portlet:renderURL var="tab1">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=LmisRequest.TAB_ACTION%>" value="<%=LmisRequest.TAB_BUILDING_PERMIT_1%>" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery('input[type="checkbox"]:checked').each(function(){
	this.checked = false;
	});
});
jQuery(function() {
	<c:forEach items="${bean.rolePer}" var="rp">
	var perId = '${rp.proGatePermissionsRolesId}';
	jQuery("input[value='"+perId+"'][type='checkbox']").each(function(){
	this.checked = true;
	});
	</c:forEach>
	});
</script>

<div class="cds-container">
<div class="border-radius span-23">
	<div class="column span-6 prepend-4">
		<div class="prepend-top" style="color: orange; font-weight: bold; padding-bottom:5px;"><fmt:message key="lmis.configPermission.userGroup" /></div>
			<form style="padding-left: 20px;" action='<c:out value="${tab1}" />' method="post">
				<input id="NV" class="radio-style" <c:if test="${bean.roleId==bean.StaffRole}">checked</c:if> type="radio" name="roleId" value="${bean.StaffRole}" onchange="this.form.submit()"><label for="NV"> <fmt:message key="lmis.configPermission.employee" /></label><br>
				<input id="PM" class="radio-style" <c:if test="${bean.roleId==bean.PMRole}">checked</c:if> type="radio" name="roleId" value="${bean.PMRole}" onchange="this.form.submit()"><label for="PM"> <fmt:message key="lmis.config.email.pm" /></label><br>
				<input id="BOD" class="radio-style" <c:if test="${bean.roleId==bean.BODRole}">checked</c:if> type="radio" name="roleId" value="${bean.BODRole}" onchange="this.form.submit()"><label for="BOD"> <fmt:message key="lmis.config.email.bod" /></label>
			</form>
	</div>
	<div class="span-8">
	<div class="around-table span-8 prepend-top">
		<div style="margin-bottom: -25px; padding-bottom: 25px; margin-right: -1px;">
			<table class="table-content">
			<thead class="tbl-header" style="display:block; margin-left: -1px">
				<tr>
					<th width="20px" scope="col" height='30px' style="border: none">&nbsp</th>
					<th width="370px" scope="col" height='30px' style="border: none"><fmt:message key="lmis.configPermission.listOfFunction" /></th>
					<th width="13px" height='30px' style="border: none">&nbsp </th>
				</tr>
			</thead>
			<tbody  style="display: block; overflow: auto; height: 263px;">
			<c:forEach items="${bean.fullPer}" var="fp" varStatus="count">
				<c:choose>
					<c:when test="${count.count %2 !=0}">
						<tr class="oddrow">
					</c:when>
					<c:otherwise>
						<tr class="evenrow">
					</c:otherwise>
				</c:choose>
						<td width="20px" style="text-align: center">
							<input type="checkbox" name="checkList" value="${fp.proGatePermissionsId}" disabled="disabled" />
						</td>
						<td width="390px" style="padding-left:10px">
							${fp.description}<br />
						</td>
					</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
		</div>

	</div>
	</div>
	<div align="center"
		style="padding-top: 10px; padding-bottom: 2px; clear: both">
		<input class="button-disable" id="save" type="button" value='<fmt:message key="button.save" />' disabled="disabled" />
		<input	class="button-disable" id="cancel" type="button" value='<fmt:message key="button.cancel" />' disabled="disabled" />
	</div>
</div>