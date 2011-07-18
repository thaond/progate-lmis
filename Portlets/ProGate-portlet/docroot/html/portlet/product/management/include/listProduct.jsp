<%@ include file="../../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="tnt-control">
	<div class="tnt-row-left">
		<div class="tnt-control-title">
			<label>
				<fmt:message key="title.product.add.to.progate"/>
			</label>
		</div>
	</div>
</div>

<div>
<table class="tnt-table">
<tbody>
	<tr class="tnt-table-header">
		<td width="35"><fmt:message key="title.no"/></td>
		<td width="30">
			<input id="productAll" type="checkbox" />
		</td>
		<td width="400"><fmt:message key="title.product.name"/></td>
		<td width="100"><fmt:message key="title.product.type"/></td>
		<td width="80"><fmt:message key="title.product.status"/></td>
	</tr>
	<c:forEach items="${bean.paginationProduct.listObject}" var="product" varStatus="count">
	
	<c:choose>
	<c:when test="${count.count % 2 != 0}">
	<tr class="tnt-table-row-0">
	</c:when>
	<c:otherwise>
	<tr class="tnt-table-row-1">
	</c:otherwise>
	
	</c:choose>
		<td class="tnt-number-cell">
		<c:out value="${count.count + ( bean.paginationProduct.currentPage - 1 ) * bean.paginationProduct.pageSize}"/>
		</td>
		
		<td class="tnt-image-cell">
			<input type="checkbox" name="<%=Request.PRODUCT_ID %>"
					value='<c:out value="${product.primaryKey}"/>' class="productChild">
		</td>
		
		<td class="tnt-text-cell"><c:out value="${product.title}"/></td>
		
		<td class="tnt-number-cell">
		<c:choose>
			<c:when test="${product.progateCategory == 1}">
				<fmt:message key="title.product.type.1"/>
			</c:when>
			
			<c:when test="${product.progateCategory == 2}">
				<fmt:message key="title.product.type.2"/>
			</c:when>
			
			<c:when test="${product.progateCategory == 3}">
				<fmt:message key="title.product.type.3"/>
			</c:when>
		</c:choose>
		</td>
		
		<td class="tnt-number-cell">
		<c:choose>
			<c:when test="${product.progateCategory == 0}">
				<fmt:message key="title.product.type.0"/>
			</c:when>
			
			<c:otherwise>
				<fmt:message key="title.product.type.choosed"/>
			</c:otherwise>
		</c:choose>
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</div>
	
<div class="tnt-row">	
	<c:set value="${bean.paginationProduct}" var="paging"></c:set>
	<%@ include file="../../../common/pagination.jsp" %>	
</div>