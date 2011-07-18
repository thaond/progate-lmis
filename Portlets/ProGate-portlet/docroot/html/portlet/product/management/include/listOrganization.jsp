<%@ include file="../../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="tnt-control">
	<div class="tnt-row-left">
		<div class="tnt-control-title">
			<label><fmt:message key="title.organization.list"/></label>
		</div>	
	</div>
	
	<div class="tnt-row-right">
		<div class="tnt-search-action">
		<label><fmt:message key="title.search"/></label>
		
		<input class="txt-search"
			   maxLength="100" type="text" 
			   value='${bean.searchOrgName}'
			   name="<%=Constants.SEARCH %>" />
		
		<span class="bt-search">&nbsp;</span>
		</div>		
	</div>
</div>

<div>
<table class="tnt-table">
<tbody>
	<tr class="tnt-table-header">
		<td width="35"><fmt:message key="title.no"/></td>
		<td width="400"><fmt:message key="title.organization.name"/></td>
		<td width="120"><fmt:message key="title.product.count"/></td>
	</tr>
	<c:forEach items="${bean.paginationOrganization.listObject}" var="org" varStatus="count">
	
	<c:choose>
		<c:when test="${count.count % 2 != 0}">
			<c:choose>
			<c:when test="${bean.selectedOrgId == org.orgId}">
			<tr class="tnt-table-row-0 tnt-table-row-selected tnt-table-row-current">	
			</c:when>
			
			<c:otherwise>
			<tr class="tnt-table-row-0 tnt-table-row-selected">
			</c:otherwise>
			</c:choose>
		</c:when>
		
		<c:otherwise>
			<c:choose>
			<c:when test="${bean.selectedOrgId == org.orgId}">
			<tr class="tnt-table-row-1 tnt-table-row-selected tnt-table-row-current">
			</c:when>
			
			<c:otherwise>
			<tr class="tnt-table-row-1 tnt-table-row-selected">
			</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
		<input type="hidden" class="selectedOrgId" value="${org.orgId }"/>
		<td class="tnt-number-cell">
		<c:out value="${count.count + ( bean.paginationOrganization.currentPage - 1 ) * bean.paginationOrganization.pageSize}"/>
		</td>
		<td class="tnt-text-cell"><c:out value="${org.orgName}"/></td>
		<td class="tnt-number-cell"><c:out value="${org.countProduct}"/></td>
	</tr>
	</c:forEach>
</tbody>
</table>
</div>

<div class="tnt-row">
	<c:set value="${bean.paginationOrganization}" var="paging"></c:set>
	<%@ include file="../../../common/pagination.jsp" %>
</div>