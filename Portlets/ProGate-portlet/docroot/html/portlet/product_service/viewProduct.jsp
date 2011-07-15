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
	<!-- Detail of product -->
	<jsp:include page="include/showingProductDetails.jsp"></jsp:include>
	
	<div class="tnt-row">
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-left">
			<span class="tnt-product-title">
				<fmt:message key="title.product.detail" />
			</span>
			</div>
		</div>
		
		<div class="tnt-row" style="text-align: justify;">			
			<c:out value="${bean.curProduct.content}" escapeXml="false"></c:out>			
		</div>		
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-left">
			<span class="tnt-product-title">
				<fmt:message key="title.product.relate" />
			</span>
			</div>
		</div>
		
		<div class="tnt-row">			
			<jsp:include page="include/showRelateProducts.jsp"></jsp:include>
		</div>		
	</div>
</div>
</div>
</form>