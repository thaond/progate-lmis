<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap" %>
<%@page import="com.larion.progate.paging.constants.PagingConst"%>

<script type="text/javascript">
	function viewProduct(url) {
		window.location = url;
	}

	function submit(){
		var selectPageSelector = jQuery("#product_paging").find(".page-selector select");			
		var currentPageNum = selectPageSelector.val();
		
		var selectPageSizeSelector = jQuery("#product_paging").find(".delta-selector select");			
		var currentPageSize = selectPageSizeSelector.val();
		
		var portletActionURL = '<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
								<portlet:param name="action" value="productListPaging" />
								<portlet:param name="<%= PagingConst.GOTO_PAGE %>" value="currentPageNum"></portlet:param>
								<portlet:param name="<%= PagingConst.PAGE_SIZE %>" value="currentPageSize"></portlet:param>
							</portlet:actionURL>';
		
		portletActionURL = portletActionURL.replace("currentPageNum", currentPageNum);
		portletActionURL = portletActionURL.replace("currentPageSize", currentPageSize);
		
		//alert("portletActionURL = " + portletActionURL);
		
		var loadUrl = "/ProGate-portlet/html/portlet/product_overview/productListPaging.jsp" + 
						"?<%= URLParameter_RS.PRODUCT_TYPE %>=${bean.productType}" + 
						"&<%= PagingConst.GOTO_PAGE %>=" + currentPageNum + 
						"&<%= PagingConst.PAGE_SIZE %>=" + currentPageSize + 
						"&displayStyle=${bean.displayStyle}" + 
						"&displaySubStyle=${bean.displaySubStyle}" + 
						"&<%= RequestConst.FRIENDLY_URL %>=${bean.friendlyUrl}" + 
						"&<%= RequestConst.NEW_PRODUCT_URL %>=${bean.newProductUrl}" + 
						"&<%= RequestConst.SELLING_PRODUCT_URL %>=${bean.sellingProductUrl}" + 
						"&<%= RequestConst.DISCOUNT_PRODUCT_URL %>=${bean.discountProductUrl}" + 
						"&numOfRecords=${bean.numOfRecords}";
		
		jQuery.post(portletActionURL,
					null,
					function(data, status, response) {
						//alert("data = " + data);
						//jQuery("#productView").load(loadUrl);
					}, null);
	}
</script>

<div class="productView-layout">
	<div id="productView" class="tnt-product-list">		
		<%@ include file="productListContainer.jsp" %>
	</div>
</div>
