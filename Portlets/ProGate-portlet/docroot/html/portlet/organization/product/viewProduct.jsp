<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="scripts/product_scripts.jsp" %>


<form action="" method="post" name="frmProduct">
<div class="org-profile-layout-column-21">

<jsp:include page="include/searchProduct.jsp" />

<div class="tnt-product-list">
	<!-- Detail of product -->
	<jsp:include page="include/showingProductDetails.jsp"></jsp:include>
	
	<div class="tnt-row productContent">
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-left">
			<span class="tnt-product-title">
				<fmt:message key="title.product.detail" />
			</span>
			</div>
		</div>
		
		<div class="tnt-row tnt-text">			
			<c:out value="${bean.curProduct.content}" escapeXml="false"></c:out>			
		</div>		
	</div>
	
	<div class="tnt-row ">
		<c:if test="${bean.relateProductListSize > 0 }">
			<div class="tnt-row tnt-border-bottom">
				<div class="tnt-left">
				<span class="tnt-product-title">
					<c:choose>
						<c:when test='${bean.categoryType == "1" || bean.categoryType == "0"}'>
							<fmt:message key="title.product.related" />
						</c:when>
						<c:when test='${bean.categoryType == "2"}'>
							<fmt:message key="title.course.related" />
						</c:when>
						<c:otherwise>
							<fmt:message key="title.exam.related" />
						</c:otherwise>
					</c:choose>
				</span>
				</div>
			</div>
			
			<div class="tnt-row">
				<jsp:include page="include/showRelateProducts.jsp"></jsp:include>
			</div>
			
			<div class="tnt-row" id="productPaging">
				<c:set value="${bean.paginationRelatedProduct}" var="paging"></c:set>
				<%@ include file="../../common/pagination.jsp" %>	
			</div>
		</c:if>
	</div>
</div>
</div>
</form>