<!-- List of new products -->
<div class="tnt-row">
	<div class="tnt-row tnt-border-bottom">
		<div class="tnt-row-left">
		<span class="tnt-product-title">
			<a href="javascript:void();">
				<c:choose>
					<c:when test="${bean.displayStyle == bean.courseView}">
						<fmt:message key="title.course.new" var="titleNew"/>
						<fmt:message key="title.course.best.seller" var="titleSelling"/>
						<fmt:message key="title.course.promote" var="titleDiscount"/>
					</c:when>
					<c:when test="${bean.displayStyle == bean.examView}">
						<fmt:message key="title.exam.new" var="titleNew"/>
						<fmt:message key="title.exam.best.seller" var="titleSelling"/>
						<fmt:message key="title.exam.promote" var="titleDiscount"/>
					</c:when>				
					<c:otherwise>
						<fmt:message key="title.product.new" var="titleNew"/>
						<fmt:message key="title.product.best.seller" var="titleSelling"/>
						<fmt:message key="title.product.promote" var="titleDiscount"/>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${bean.productType == 1}">
						${titleNew}
					</c:when>						
					<c:when test="${bean.productType == 2}">
						${titleSelling}
					</c:when>						
					<c:otherwise>
						${titleDiscount}
					</c:otherwise>
				</c:choose>
			</a>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<c:forEach items="${bean.productList}" var="product">
			<c:choose>
				<c:when test="${count.count < bean.lastIndexProductList}">
					<div class="tnt-row-hover tnt-border-bottom">
				</c:when>
				
				<c:otherwise>
					<div class="tnt-row-hover">
				</c:otherwise>
			</c:choose>			
			<c:choose>
				<c:when test="${bean.productType == 3}">
				<%@ include file="include/showDiscountProductDetail.jsp" %>
				</c:when>
				
				<c:otherwise>
				<%@ include file="include/showNewProductDetail.jsp" %>
				</c:otherwise>
			</c:choose>
			</div>
		</c:forEach>
	</div>
</div>

<%-- Paging --%>
<div id="product_paging" class="productView-paging">
	<%-- 
	<%
		Map<String, Object> paging = new HashMap<String, Object>();
		if (request.getAttribute(PagingConst.PAGING) != null) {
			paging = (Map<String, Object>)(request.getAttribute(PagingConst.PAGING));
		}
	%>
	
	<%@ include file="/html/portlet/paging/paging.jsp" %>
	--%>
	<c:set value="${bean.productPaging}" var="paging"></c:set>
	<c:if test="${paging.totalRecord > bean.numOfRecords}">
		<%@ include file="../common/pagination.jsp" %>
	</c:if>
</div>
