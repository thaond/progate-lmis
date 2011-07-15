<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- List of relate products -->
<div class="tnt-body-row">
	<c:choose>
		<c:when test="${bean.currentProduct.productType == 3 }">
			<!-- List of relate products -->			
			<div class="tnt-body-row">
				<c:forEach items="${bean.relatedProductList}" var="product" varStatus="count" >
					<c:if test="${bean.currentProduct.primaryKey != product.primaryKey}">
						<div class="tnt-row-hover tnt-border-bottom">
							<%@ include file="showDiscountProductDetail.jsp" %>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</c:when>

		<c:otherwise>
			<div class="tnt-body-row">
				<c:forEach items="${bean.relatedProductList}" var="product" varStatus="count" >
					<c:if test="${bean.currentProduct.primaryKey != product.primaryKey}">
						<div class="tnt-row-hover tnt-border-bottom">
							<%@ include file="showNewProductDetail.jsp" %>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>
</div>
