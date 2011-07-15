<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	
	function pagingSubmit() {
		var url = '<portlet:renderURL portletMode="view" windowState="<%=WindowState.NORMAL.toString() %>"/>';
		
		document.frmOrgManagement.action = url;
        document.frmOrgManagement.submit();
	}
	
	jQuery(function(){		
		// Handle focus and blur event of search texbox
		jQuery("#search_txt").focus();
		jQuery("#search_txt").focus(function() {
			if (jQuery(this).val() == '<fmt:message key="title.org.name.input.search"/>') {
				jQuery(this).val('');
			}
		});
		jQuery("#search_txt").blur(function(){
			if (jQuery(this).val() == "") {
				jQuery(this).val('<fmt:message key="title.org.name.input.search"/>');
			}
		});
		// End Focus to search texbox
	});
</script>

<form action="" name="frmOrgManagement" method="post">
<div class="pg-right-panel">
	<div class="tnt-control">
		<div class="tnt-row-right">
			<div style="padding-right: 5px;">
			<label style="color: white;"><fmt:message key="title.search"/></label>
			
			<input class="txt-search"
				   maxLength="100" type="text"
				   value='<fmt:message key="title.organization.name.input"/>'
				   name="<%=Constants.SEARCH %>" />
			
			<span class="bt-search">&nbsp;</span>
			</div>
		</div>
	</div>

	<div>
	<table class="tnt-table">
	<tbody>
		<tr class="tnt-table-header">
			<td width="35"><fmt:message key="title.no" /></td>
			<td width="300"><fmt:message key="title.org.name" /></td>
			<td width="66"><fmt:message key="title.num.of.user" /></td>
			<td width="35"><fmt:message key="title.create.date" /></td>
			<td width="35"><fmt:message key="title.expire.date" /></td>
			<td width="35"><fmt:message key="title.status" /></td>
		</tr>
		<c:forEach items="${bean.organizationList}" var="org" varStatus="count">
		<c:choose>
			<c:when test="${count.count % 2 != 0}">
			<c:choose>
				<c:when test="${org.orgStatus == true}">
					<tr class="tbl-content-row-0">
				</c:when>
				<c:otherwise>
					<tr class="tbl-content-row-0 disabled">
				</c:otherwise>
			</c:choose>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${org.orgStatus == true}">
						<tr class="tbl-content-row-1">
					</c:when>
					<c:otherwise>
						<tr class="tbl-content-row-1 disabled">
					</c:otherwise>
				</c:choose>
			</c:otherwise>
			</c:choose>
					<td class="number-cell">
					<c:out value="${count.count + ( bean.paginationOrganization.currentPage - 1 ) * bean.paginationOrganization.pageSize}"/>
					</td>
					
					<td class="text-cell">
						<portlet:renderURL var="detailOrgURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
						    <portlet:param name="action"
						                   value="showingOrgainzationDetails" />
						    <portlet:param name="<%=Request.TA %>"
						                   value="<%=Request.TA_1 %>" />
		                   	<portlet:param name="<%=Request.ORG_ID %>"
		                   				  value='${org.orgId}'/>
					  	</portlet:renderURL>
						<a href='<c:out value="${detailOrgURL}"/>' style="color: blue;">
							<c:out value="${org.name}"/>
						</a>
					</td>
					
					<td class="number-cell">
					<c:out value="${org.maxUserCount}"/>
					</td>
					
					<td class="number-cell" >
					<fmt:formatDate pattern="dd/MM/yyyy" value="${org.createdAt}" />
					</td>
					
					<td class="number-cell">
					<fmt:formatDate pattern="dd/MM/yyyy" value="${org.expiredDate}" />
					</td>
					
					<td class="number-cell">
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
	<%@ include file="../common/pagination.jsp" %>
	</div>
</div>
</form>

<FORM NAME="frmMsg">
	<INPUT TYPE="hidden" NAME="MsgTxt" Value="${cobsMsgTxt}">
</FORM>