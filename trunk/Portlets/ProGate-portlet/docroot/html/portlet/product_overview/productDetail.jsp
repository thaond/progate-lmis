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
	<!-- Detail of product -->
	<jsp:include page="include/showProductDetail.jsp"></jsp:include>
	
	<div class="tnt-row">
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-left">
			<span class="tnt-product-title">
				<fmt:message key="title.product.detail" />
			</span>
			</div>
		</div>
		
		<div class="tnt-row" style="text-align: justify;">			
			<c:out value="${bean.currentProduct.content}" escapeXml="false"></c:out>			
		</div>		
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-left">
			<span class="tnt-product-title">
				<c:choose>
					<c:when test="${bean.displayStyle == bean.courseView}">
						<fmt:message key="title.course.related" />
					</c:when>
					<c:when test="${bean.displayStyle == bean.examView}">
						<fmt:message key="title.exam.related" />
					</c:when>				
					<c:otherwise>
						<fmt:message key="title.product.relate" />
					</c:otherwise>
				</c:choose>
			</span>
			</div>
		</div>
		
		<div class="tnt-row">			
			<jsp:include page="include/showRelatedProducts.jsp"></jsp:include>
		</div>		
	</div>
</div>
</div>
</form>