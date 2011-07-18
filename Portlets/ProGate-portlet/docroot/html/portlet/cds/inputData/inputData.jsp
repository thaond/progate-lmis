<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="left padding-top padding-bottom" style="font-size: 1.1em; color: #E46C0A">
	<img class="absmiddle" src="/ProGate-portlet/images/cds/import_big.png"
		width="40px" height="40px" />
	<strong>Nhập dữ liệu</strong>
</div>

<div class="clear"></div>

<div class="content-has-table border-radius">
	<portlet:renderURL var="url">
		<portlet:param name="action" value="commonController" />
		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_1%>" />
	</portlet:renderURL>
	<form id="filterForm" method="post" action="${url}">
		<div class="filter-area span-21">
			<div class="span-8" style="padding-top:5px">
				<label style="float: left; margin-right: 10px; width: 65px;">Dự án</label>
				<select class="span-5 last" onchange="" id="periodId" name="<%=RequestConst.PROJECT_ID%>">
					<c:forEach items="${bean.orgs}" var="org">
						<option <c:if test="${org.orgId == bean.selectedProjectId}">selected="selected"</c:if> value="${org.orgId}">
							${org.name}
						</option>	
					</c:forEach>
				</select>
			</div>
			<div class="span-9" style="padding-top:5px">
				<label style="float: left; margin-left: 10px; margin-right: 10px; width: 92px;">Tên Nhân Viên</label>
				<select class="span-5 last">
					<option>Chọn tên nhân viên</option>
				</select>
			</div>
			
			<div class="span-3"><a id="search" href="#"><img class="absmiddle" src="/ProGate-portlet/images/cds/search.png" height="25" width="25"><span style="color:#E46C0A">Tìm kiếm</span></a></div>
			
		</div>
	</form>
	<div class="clear"></div>
	<table>
		<thead>
			<tr>
				<th class="span-1">STT</th>
				<th class="span-6">Tên Nhân Viên</th>
				<th class="span-4">Chức Vụ</th>
				<th class="span-5">Dự án</th>
				<th class="span-2">Import CDS</th>
				<th class="span-3">Nhập Kỹ Năng & Kinh Nghiệm</th>
				<th class="span-2 last">Import CDP</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bean.employees}" var="employee" varStatus="count">
				<portlet:renderURL var="importCdsUrl">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
					<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_2%>" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${employee.userId}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_NAME%>" value="${functions:getUserFullnameByUserId(employee.userId)}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_POSITION%>" value="${employee.position}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_PROJECT%>" value="${functions:getProjectNameByProjectId(employee.orgId)}" />
					<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.selectedProjectId}" />
				</portlet:renderURL>
				<portlet:renderURL var="inputMRUrl">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
					<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_3%>" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${employee.userId}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_NAME%>" value="${functions:getUserFullnameByUserId(employee.userId)}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_POSITION%>" value="${employee.position}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_PROJECT%>" value="${functions:getProjectNameByProjectId(employee.orgId)}" />
					<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.selectedProjectId}" />
				</portlet:renderURL>
				<portlet:renderURL var="importCdpUrl">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
					<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_4%>" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${employee.userId}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_NAME%>" value="${functions:getUserFullnameByUserId(employee.userId)}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_POSITION%>" value="${employee.position}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_PROJECT%>" value="${functions:getProjectNameByProjectId(employee.orgId)}" />
					<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.selectedProjectId}" />
				</portlet:renderURL>
				<tr <c:if test="${employee.userId == bean.importUserId}">style="background:#FFFF66"</c:if>>
					<td class="span-1 td-align-center">${count.count}</td>
					<td class="span-6">${functions:getUserFullnameByUserId(employee.userId)}</td>
					<td class="span-4">${employee.position}</td>
					<td class="span-5">${functions:getProjectNameByProjectId(employee.orgId)}</td>
					<td class="span-2 td-align-center">
						<c:set var='imageURL' value='/ProGate-portlet/images/cds/import-nodata.png'  scope="page" />
						<c:set var='imageTitle' value='Chưa có dữ liệu'  scope="page" />
						<c:if test="${functions:checkImportedOrNot(bean.orgId, employee.userId)}">
							<c:set var='imageURL' value='/ProGate-portlet/images/cds/import-data.png'  scope="page" />
							<c:set var='imageTitle' value='Đã có dữ liệu'  scope="page" />
						</c:if>
						<a href="${importCdsUrl}" class="importCds">
							<img class="absmiddle" title="${imageTitle}" src="${imageURL}" 
								width="18px" height="18px"/>
						</a> 
					</td>
					<td class="span-3 td-align-center">
						<a href="${inputMRUrl}" class="inputMR">
							<img class="absmiddle" src="/ProGate-portlet/images/cds/import_MRs.png" 
								width="18px" height="18px"/>
						</a> 
					</td>
					<td class="span-2 last td-align-center">
						<a href="${importCdpUrl}" class="importCdp">
							<img class="absmiddle" title="Chưa có dữ liệu" src="/ProGate-portlet/images/cds/import-nodata.png" 
								width="18px" height="18px"/>
						</a> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
jQuery(document).ready(function(){
	jQuery("#search").click(function(e){
		jQuery("#filterForm").submit();	
	});
});
</script>