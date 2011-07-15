<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="scripts/product_scripts.jsp" %>

<form action="" method="post" name="frmProduct">
<div class="org-profile-layout-column-21">

<jsp:include page="include/searchProduct.jsp" />

<div class="tnt-product-list">
	<!-- List of new products -->
	<div class="tnt-row">
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-row-left">
			<span class="tnt-product-title">
				<c:choose>
					<c:when test='${bean._productType == 1}'>
						<c:choose>
							<c:when test='${bean.categoryType == "1" || bean.categoryType == "0"}'>
								<fmt:message key="title.product.new" />
							</c:when>
							<c:when test='${bean.categoryType == "2"}'>
								<fmt:message key="title.course.new" />
							</c:when>
							<c:otherwise>
								<fmt:message key="title.exam.new" />
							</c:otherwise>
						</c:choose>
					</c:when>
					
					<c:when test='${bean._productType == 2}'>
						<c:choose>
							<c:when test='${bean.categoryType == "1" || bean.categoryType == "0"}'>
								<fmt:message key="title.product.best.seller" />
							</c:when>
							<c:when test='${bean.categoryType == "2"}'>
								<fmt:message key="title.course.best.seller" />
							</c:when>
							<c:otherwise>
								<fmt:message key="title.exam.best.seller" />
							</c:otherwise>
						</c:choose>
					</c:when>
					
					<c:when test='${bean._productType == 3}'>
						<c:choose>
							<c:when test='${bean.categoryType == "1" || bean.categoryType == "0"}'>
								<fmt:message key="title.product.promote" />
							</c:when>
							<c:when test='${bean.categoryType == "2"}'>
								<fmt:message key="title.course.promote" />
							</c:when>
							<c:otherwise>
								<fmt:message key="title.exam.promote" />
							</c:otherwise>
						</c:choose>
					</c:when>
				</c:choose>
			</span>
			</div>
		</div>
		
		<div class="tnt-row">
			<c:forEach items="${bean.productList}" var="product" varStatus="count" >
				<c:choose>
					<c:when test="${count.count < bean.lastIndexProductList}">
					<div class="tnt-row-hover tnt-border-bottom">
					</c:when>
					
					<c:otherwise>
					<div class="tnt-row-hover">
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test='${bean._productType == 3}'>
					    <%@ include file="include/showingPromoteProductDetails.jsp" %>
					</div>
					</c:when>
					
					<c:otherwise>
					    <%@ include file="include/showingNewProductDetails.jsp" %>
					</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>
</div>

<div class="tnt-row" id="productPaging">
	<c:set value="${bean.paginationProduct}" var="paging"></c:set>
	<%@ include file="../../common/pagination.jsp" %>
</div>
</div>
</form>
