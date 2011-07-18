<%@ include file="../common/init.jsp" %>
<%@ include file="scripts.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
	jQuery(function(){
		
	});
</script>

<form action="" method="post" name="frmProduct">
<div class="org-profile-layout-column-21">
<div class="tnt-product-list">	
	<!-- List of new products -->
	<div class="tnt-row">
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-row-left">
			<span class="tnt-product-title">
				<a href="javascript:void();">
					<c:choose>
						<c:when test="${bean.productType == 1}">
						<fmt:message key="title.product.new" />
						</c:when>
						
						<c:when test="${bean.productType == 2}">
						<fmt:message key="title.product.best.seller" />
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
			<c:forEach items="${bean.productList}" var="product" varStatus="count" >
			<c:choose>
				<c:when test="${bean.productType == 3}">
				<%@ include file="include/showingPromoteProductDetails.jsp" %>
				</c:when>
				
				<c:otherwise>
				<%@ include file="include/showingNewProductDetails.jsp" %>
				</c:otherwise>
			</c:choose>
			</c:forEach>
		</div>
	</div>
</div>
</div>
</form>