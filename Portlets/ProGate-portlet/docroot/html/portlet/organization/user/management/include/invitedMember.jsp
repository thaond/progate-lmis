<%@ include file="../../../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">

	function pagingSubmit() {
		search();
	}
	
	function search() {
		var url = '<portlet:renderURL>
		    <portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.ROOT_ORG_ID %>" value="${bean.rootOrgId}" />
			<portlet:param name="<%=Request.TAB %>" value="<%=Request.INVITED_MEMBER_TAB %>" />
		</portlet:renderURL>';

		submit(url);
	}
	
	jQuery(function() {
		jQuery(".tnt-bt-delete").click(function(){
			if(jQuery("input[name='userId']:checked").length == 0) {
				alert('<fmt:message key="warning.user.none.choose"/>');
			} else {
				var url = '<portlet:actionURL>
							    <portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Request.ROOT_ORG_ID %>" value="${bean.rootOrgId}" />
								<portlet:param name="<%=Request.TAB %>" value="<%=Request.INVITED_MEMBER_TAB %>" />
								<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.DELETE %>"/>
							</portlet:actionURL>';
				
				var str = '<fmt:message key="warning.user.delete.from.invited.members.confirm"/>';
				
				var answer = confirm(str);
				
				if (answer) {
					str = '<fmt:message key="warning.user.delete.from.invited.members.success"/>';
					
					jQuery("#successMsg").val(str);
					
					submit(url);
				}
			}
		});
	});
</script>

<div class="tnt-row">
	<div class="tnt-control">
		<div class="tnt-row-left">
			<div style="padding-left: 5px;">
				<input class="txt-search"
					   maxLength="100" type="text" 
					   value="${bean.searchPhrase}"
					   name="<%=Constants.SEARCH %>" />
				
				<a class="tnt-bt-search" href="javascript:void()"></a>
			</div>
		</div>
		
		<div class="tnt-row-right">
			<div class="tnt-control-action">
				<a class="tnt-bt-delete" href="javascript:void()">
					<fmt:message key="title.user.delete.from.invited.memebers"/>
				</a>
			</div>
		</div>
	</div>
	
	<div>
	<table class="tnt-table">
	<tbody>
		<tr class="tnt-table-header">
			<td width="40"><fmt:message key="title.no"/></td>
			<td width="40"><input class="cbkSelectAll" type="checkbox" /></td>
			<td width="200"><fmt:message key="title.user.login.name"/></td>
			<td width="300"><fmt:message key="title.user.full.name"/></td>
			<td width="300"><fmt:message key="title.user.field.interested.in"/></td>
			<td width="300"><fmt:message key="title.user.invited.date"/></td>
		</tr>
		
		<c:choose>
			<c:when test="${bean.countListUsers == 0}">
			<tr>
			<td colspan="6" class="tnt-warning-message">
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
				
				<td class="tnt-number-cell">
					<input type="checkbox" name="<%=Request.USER_ID %>"
							value='<c:out value="${user.userId}"/>'
							class="cbkChild">
				</td>
				
				<td class="tnt-text-cell"><c:out value="${user.screenName}"/></td>
				<td class="tnt-text-cell"><c:out value="${user.firstName} ${user.lastName}"/></td>
				<td class="tnt-text-cell"><c:out value=""/></td>
				<td class="tnt-text-cell"><fmt:formatDate pattern="dd/MM/yyyy" value="${user.requestAt}"/></td>
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