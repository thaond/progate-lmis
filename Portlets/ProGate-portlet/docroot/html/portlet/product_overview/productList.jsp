<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
	function viewProduct(url) {
		window.location = url;
	}
</script>

<form action="" method="post" name="frmProduct">
<div class="productView-layout">
	<div class="tnt-product-list">
		<!-- List of new products -->
		<div class="tnt-row">
			<div class="tnt-row tnt-border-bottom">
				<div class="tnt-row-left">
					<span class="tnt-product-title">
						<c:set value="<%= URLParameter_RS.PRODUCT_TYPE %>" var="productType" />
						<c:set value="<%= PortalUtil.getPortalURL(request) %>" var="redirectUrl" />
						<c:set value="${redirectUrl}/${bean.newProductUrl}" var="redirectUrl" />
						<c:if test="${bean.newProductUrl == bean.friendlyUrl}" >
							<c:set value="${redirectUrl}?${productType}=1" var="redirectUrl" />
						</c:if>
						<a href="${redirectUrl}">
							<c:choose>
								<c:when test="${bean.displayStyle == bean.courseView}">
									<fmt:message key="title.course.new" />
								</c:when>
								<c:when test="${bean.displayStyle == bean.examView}">
									<fmt:message key="title.exam.new" />
								</c:when>				
								<c:otherwise>
									<fmt:message key="title.product.new" />
								</c:otherwise>
							</c:choose>							
						</a>
					</span>
				</div>
			</div>

			<div class="tnt-row">
				<c:forEach items="${bean.newProductList}" var="product" varStatus="count" >
					<c:choose>
						<c:when test="${count.count < bean.lastIndexNewProductList}">
							<div class="tnt-row-hover tnt-border-bottom">
						</c:when>				
						<c:otherwise>
							<div class="tnt-row-hover">
						</c:otherwise>
					</c:choose>
					
					<%@ include file="include/showNewProductDetail.jsp" %>
					</div>
				</c:forEach>
			</div>		
		</div>
		
		<!-- List of best seller products -->
		<div class="tnt-row">
			<div class="tnt-row tnt-border-bottom">
				<div class="tnt-row-left">
				<span class="tnt-product-title">
					<c:set value="<%= URLParameter_RS.PRODUCT_TYPE %>" var="productType" />
					<c:set value="<%= PortalUtil.getPortalURL(request) %>" var="redirectUrl" />
					<c:set value="${redirectUrl}/${bean.sellingProductUrl}" var="redirectUrl" />
					<c:if test="${bean.sellingProductUrl == bean.friendlyUrl}" >
						<c:set value="${redirectUrl}?${productType}=2" var="redirectUrl" />
					</c:if>
					<a href="${redirectUrl}">
						<c:choose>
							<c:when test="${bean.displayStyle == bean.courseView}">
								<fmt:message key="title.course.best.seller" />
							</c:when>
							<c:when test="${bean.displayStyle == bean.examView}">
								<fmt:message key="title.exam.best.seller" />
							</c:when>				
							<c:otherwise>
								<fmt:message key="title.product.best.seller" />
							</c:otherwise>
						</c:choose>
					</a>
				</span>
				</div>
			</div>
			
			<div class="tnt-row">			
				<c:forEach items="${bean.bestSellProductList}" var="product" varStatus="count" >
					<c:choose>
						<c:when test="${count.count < bean.lastIndexBestSellProductList}">
							<div class="tnt-row-hover tnt-border-bottom">
						</c:when>
						
						<c:otherwise>
							<div class="tnt-row-hover">
						</c:otherwise>
					</c:choose>
					
					<%@ include file="include/showNewProductDetail.jsp" %>
					</div>
				</c:forEach>
			</div>		
		</div>

		<!-- List of promote product -->
		<div class="tnt-row">
			<div class="tnt-row tnt-border-bottom">
				<div class="tnt-row-left">
				<span class="tnt-product-title">
					<c:set value="<%= URLParameter_RS.PRODUCT_TYPE %>" var="productType" />
					<c:set value="<%= PortalUtil.getPortalURL(request) %>" var="redirectUrl" />
					<c:set value="${redirectUrl}/${bean.discountProductUrl}" var="redirectUrl" />
					<c:if test="${bean.discountProductUrl == bean.friendlyUrl}" >
						<c:set value="${redirectUrl}?${productType}=3" var="redirectUrl" />
					</c:if>
					<a href="${redirectUrl}">
						<c:choose>
							<c:when test="${bean.displayStyle == bean.courseView}">
								<fmt:message key="title.course.promote" />
							</c:when>
							<c:when test="${bean.displayStyle == bean.examView}">
								<fmt:message key="title.exam.promote" />
							</c:when>				
							<c:otherwise>
								<fmt:message key="title.product.promote" />
							</c:otherwise>
						</c:choose>
					</a>
				</span>
				</div>
			</div>
			
			<div class="tnt-row">
				<c:forEach items="${bean.promoteProductList}" var="product" varStatus="count" >
					<c:choose>
						<c:when test="${count.count < bean.lastIndexPromoteProductList}">
							<div class="tnt-row-hover tnt-border-bottom">
						</c:when>
						
						<c:otherwise>
							<div class="tnt-row-hover">
						</c:otherwise>
					</c:choose>
					
					<%@ include file="include/showDiscountProductDetail.jsp" %>
					</div>
				</c:forEach>
			</div>		
		</div>

	</div>
</div>
</form>