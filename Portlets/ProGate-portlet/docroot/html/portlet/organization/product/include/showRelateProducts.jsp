<%@ include file="../../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!-- List of relate products -->
<div class="tnt-body-row">
	<!-- List of relate products -->
	<div class="tnt-body-row">
		<c:forEach items="${bean.relateProductList}" var="product"
			varStatus="count">
			<c:if test="${bean.curProduct.primaryKey != product.primaryKey}">
				<c:choose>
					<c:when test="${count.count < bean.lastIndexRelateProductList-1}">
						<div class="tnt-row-hover tnt-border-bottom">
					</c:when>
					<c:otherwise>
						<div class="tnt-row-hover">
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${bean.curProduct.productType == 3 }">
						<%@ include file="showingPromoteProductDetails.jsp"%>
					</c:when>

					<c:otherwise>
						<%@ include file="showingNewProductDetails.jsp"%>
					</c:otherwise>
				</c:choose>
	</div>
	</c:if>
	</c:forEach>
</div>
</div>
