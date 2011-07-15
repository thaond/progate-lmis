<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="scripts/functions.jsp"%>
<%@ include file="notice.jsp"%>

<!--  <script type="text/javascript" src="ProGate-portlet/js/org-management.js?v1"></script>-->

<form action="" name="frmOrgManagement" method="post">

<div class="tnt-content" style="width: 920px;">
	<div class="tnt-control">
		<div class="tnt-row-right">
			<label for="search_txt"><fmt:message key="title.search"/></label>
			<input id="search_txt" class="txt-search"
				   maxLength="255" type="text"
				   name="<%=Constants.SEARCH %>" />
			<span class="tnt-bt-search">&nbsp;</span>
			
			<span class="tnt-bt-new">
				<portlet:renderURL var="orgNew">
					<portlet:param name='struts_action' value='/organization_management/org_new' />
				</portlet:renderURL>
				<a href="${orgNew }" >
					<fmt:message key="button.new"/>
				</a>
			</span>
			
			<span class="tnt-bt-delete">
				<a href="javascript:void(0);"><fmt:message key="button.delete"/></a>
			</span>
			
			<span class="tnt-bt-enable">
				<a href="javascript:void(0);"><fmt:message key="button.enable"/></a>
			</span>
			
			<span class="tnt-bt-disable">
				<a href="javascript:void(0);"><fmt:message key="button.disable"/></a>
			</span>
		</div>
	</div>

	<div>	
	<table class="tnt-table">
	<tbody>
		<tr class="tnt-table-header">
			<td width="35"><fmt:message key="title.no"/></td>
			<td width="30">
				<input id="parent_ckb" class="input_header" type="checkbox" />
			</td>
			<td width="35"><fmt:message key="button.edit"/></td>
			<td width="400"><fmt:message key="title.organization.name"/></td>
			<td width="90"><fmt:message key="title.user.count"/></td>
			<td width="90"><fmt:message key="title.user.max.no"/></td>
			<td width="90"><fmt:message key="title.organization.subscription.start.date"/></td>
			<td width="100"><fmt:message key="title.organization.subscription.expriration.date"/></td>
			<td width="80"><fmt:message key="title.settings"/></td>
			<td width="80"><fmt:message key="title.organization.status"/></td>
		</tr>
		<c:forEach items="${bean.organizationList}" var="org" varStatus="count">
		<c:choose>
		<c:when test="${count.count % 2 != 0}">
		<c:choose>
			<c:when test="${org.orgStatus == true}">
				<tr class="tnt-table-row-0">
			</c:when>
			<c:otherwise>
				<tr class="tnt-table-row-0 disabled">
			</c:otherwise>
		</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${org.orgStatus == true}">
					<tr class="tnt-table-row-1">
				</c:when>
				<c:otherwise>
					<tr class="tnt-table-row-1 disabled">
				</c:otherwise>
			</c:choose>
		</c:otherwise>
		</c:choose>
				<td class="number-cell"><c:out value="${count.count + ( bean.paginationOrganization.currentPage - 1 ) * bean.paginationOrganization.pageSize}"/></td>
				<td class="image-cell"><input type="checkbox" name="<%=Request.CHILD_CKB %>" 
					value='<c:out value="${org.orgId}"/>' >
				</td>
				<td class="image-cell">										
					<portlet:renderURL var="editOrgURL">
					    <portlet:param name="struts_action"  
					                   value="/organization_management/org_management" />
					    <portlet:param name="<%= Constants.CMD %>"
					                   value="<%= Constants.EDIT %>" />
					    <portlet:param name="<%=Request.ORG_ID %>"
					                   value='${org.orgId}' />						    
				  	</portlet:renderURL>
				  	<a href="/tochuc/trangchu?orgId=${org.orgId}&viewMode=1">
				  	<img alt="" src="ProGate-portlet/images/edit_icon.gif" />
				  	</a>				  	
				</td>
				<td><a href="/tochuc/trangchu?orgId=${org.orgId}&viewMode=0"><c:out value="${org.name}"/></a></td>
				<td class="number-cell"><fmt:formatNumber type="number" value="${org.maxUserCount}"/></td>
				<td class="number-cell"><fmt:formatNumber type="number" value="${org.maxUserCount}"/></td>
				<td class="date-cell"><fmt:formatDate pattern="dd/MM/yyyy" value="${org.createdAt}" /></td>
				<td class="date-cell"><fmt:formatDate pattern="dd/MM/yyyy" value="${org.expiredDate}" /></td>
				<td class="image-cell">
					<portlet:renderURL var="settingOrgURL">
					    <portlet:param name="struts_action"  
					                   value="/organization_management/org_edit" />
					    <portlet:param name="<%= Constants.CMD %>"
					                   value="<%= Request.SETTING %>" />
					    <portlet:param name="<%=Request.ORG_ID %>"
					                   value='${org.orgId}' />
				  	</portlet:renderURL>
					<img alt="<fmt:message key="title.organization.setting"/>" 
						src="ProGate-portlet/images/setting.gif" 
						title='<fmt:message key="title.organization.setting"/>'>					
				</td>
				<td class="status-cell">
					<c:choose>
						<c:when test="${org.orgStatus == true}">
							Enabled
						</c:when>
						<c:otherwise>
							Disabled
						</c:otherwise>
					</c:choose> 					
				</td>
			</tr>					
		</c:forEach>
	</tbody>
	</table>
	</div>
	
	<div class="tnt-row">
	<c:set value="${bean.paginationOrganization}" var="paging"></c:set>
	<%@ include file="../../common/pagination.jsp" %>
	</div>
</div>
</form>


<form name="frmMsg">
	<input type="hidden" name="MsgTxt" id="MsgTxt" value="${cobsMsgTxt}">
</form>
