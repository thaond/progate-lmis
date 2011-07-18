<%@ include file="../../../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../dialog/dialogAddUserToOrganization.jsp" %>

<style type="text/css">
#dialogAddUserToOrganization {
	display: none;
}
</style>

<script type="text/javascript">
	
	function pagingSubmit() {
		applyFilter();
	}
	
	function search() {
		applyFilter();
	}
	
	function applyFilter() {
		var url = '<portlet:renderURL>
					    <portlet:param name="action" value="commonController" />
						<portlet:param name="<%=Request.ROOT_ORG_ID %>" value="${bean.rootOrgId}" />
						<portlet:param name="<%=Request.TAB %>" value="<%=Request.OLD_MEMBER_TAB %>" />
					</portlet:renderURL>';

		submit(url);
	}	
</script>

<div class="tnt-row">
	<div class="tnt-row-left">
		<fieldset>
			<legend><fmt:message key="title.filter"/></legend>
			<label><fmt:message key="title.user.role"/></label>
			<select name="<%=Request.FILTER_USER_ROLE %>" style="width: 230px;">
					<c:choose>
						<c:when test="${bean.filterRole == 0}">
							<option value="0" selected="selected">
								<fmt:message key="title.all"/>
							</option>
						</c:when>
						
						<c:otherwise>
							<option value="0">
								<fmt:message key="title.all"/>
							</option>
						</c:otherwise>
					</c:choose>
					
					<c:forEach items="${bean.roles}" var="role">
						<c:choose>
							<c:when test="${role.roleId == bean.filterRole}">
								<option value="${role.roleId}" selected="selected">
									<c:out value="${role.name}"/>
								</option>
							</c:when>
							
							<c:otherwise>
								<option value="${role.roleId}">
									<c:out value="${role.name}"/>
								</option>
							</c:otherwise>
						</c:choose>						
					</c:forEach>
				</select>
		</fieldset>
	</div>
	
	<div class="tnt-row-right">
		<div style="padding-top: 23px;">
			<input class="txt-search"
				   maxLength="100" type="text" 
				   value="${bean.searchPhrase}" style="width: 310px;"
				   name="<%=Constants.SEARCH %>" />
			
			<input type="button" name="btApplyFilter" 
						value='<fmt:message key="title.view"/>'>
		</div>
	</div>
</div>

<div class="tnt-row">
	<div>
	<table class="tnt-table">
	<tbody>
		<tr class="tnt-table-header">
			<td width="40"><fmt:message key="title.no"/></td>			
			<td width="200"><fmt:message key="title.user.login.name"/></td>
			<td width="300"><fmt:message key="title.user.full.name"/></td>
			<td width="300"><fmt:message key="title.user.email.address"/></td>
			<td width="100"><fmt:message key="title.user.join.date"/></td>
			<td width="50"><fmt:message key="title.user.role"/></td>					
			<td width="40"></td>
		</tr>
		
			<c:choose>
			<c:when test="${bean.countListUsers == 0}">
			<tr>
			<td colspan="7" class="tnt-warning-message">
			<fmt:message key="warning.search.no.results"/>					
			</td>							
			</tr>
			</c:when>
			
			<c:otherwise>
			<c:forEach items="${bean.users}" var="user" varStatus="count">		
			<c:choose>
				<c:when test="${count.count % 2 != 0}">
					<tr class="tnt-table-row-0">
				</c:when>
				
				<c:otherwise>
					<tr class="tnt-table-row-1">
				</c:otherwise>
			</c:choose>
				<td class="tnt-number-cell">
				<c:out value="${count.count + ( bean.paginationUser.currentPage - 1 ) * bean.paginationUser.pageSize}"/>
				</td>
				
				<td class="tnt-text-cell"><c:out value="${user.screenName}"/></td>
				<td class="tnt-text-cell"><c:out value="${user.firstName} ${user.lastName}"/></td>
				<td class="tnt-text-cell"><c:out value="${user.emailAddress}"/></td>
				<td class="tnt-datetime-cell">
					<fmt:formatDate pattern="dd/MM/yyyy" value="${user.createDate}"/>
				</td>
				
				<td class="tnt-text-cell"><c:out value="${user.rolename}"/></td>
				
				<td class="tnt-status-cell">
					<div>
					<div class="tnt-action lfr-component lfr-menu-list">
						<ul>
							<li>
								<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>" var="history">
								    <portlet:param name="action" value="showUserHistory" />
								    <portlet:param name="<%=Request.USER_ID %>" value='${user.userId}'/>						
									<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.WRITE%>"/>
								</portlet:renderURL>
								
								<a href="${history}">
									<fmt:message key="title.user.join.history"/>
								</a>
							</li>						
						</ul>
					</div>
					
					<a href="#" class="tnt-show-actions">
					<img alt="" src="/ProGate-portlet/images/button/action.png">
					</a>					
					</div>
				</td>
			</tr>
			</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
	</table>
	</div>
	
	<c:if test="${bean.countListUsers > 0}">
	<div class="tnt-row">
		<c:set value="${bean.paginationUser}" var="paging"></c:set>
		<%@ include file="../../../../common/pagination.jsp" %>
	</div>
	</c:if>
</div>

