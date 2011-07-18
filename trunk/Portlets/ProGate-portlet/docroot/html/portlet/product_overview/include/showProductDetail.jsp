<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style type="text/css">
   <%@ include file="/css/course_view/product_view.css" %>
</style>

<c:choose>
	<c:when test="${bean.currentProduct.currencyCode == 'VND'}">
		<c:set value="0" var="maxFraction" />
	</c:when>
	<c:otherwise>
		<c:set value="2" var="maxFraction" />
	</c:otherwise>
</c:choose>
<!-- Detail of product -->
<div class="tnt-row-hover tnt-border-bottom" style="background-color: #DDF0F8;">
	<c:choose>
		<c:when test="${bean.currentProduct.productType == 3 }">
			<div style="float: left; width: 100%;">
				<div class="tnt-row">
					<div class="tnt-row-left" style="padding-left: 6px;">
						<img alt="" style="padding: 2px;" src='<c:out value="${bean.currentProduct.smallImageUrl}"></c:out>'>
					</div>
					
					<div class="tnt-row-right" style="padding-right: 6px; width: 73%;">
						<div>
							<span class="tnt-article-title">
								<a href="<%=PortalUtil.getPortalURL(request) %>/${bean.friendlyUrl}?
										<%=URLParameter_RS.PRODUCT_ID %>=${bean.currentProduct.journalArticleId}">
									<c:out value="${bean.currentProduct.title}"></c:out>
								</a>
							</span>
						</div>
						
						<div style="height: 105px;">
							<span><c:out value="${bean.currentProduct.description}" escapeXml="false"></c:out></span>
						</div>
						
						<div class="tnt-row tnt-promote-price">
							<div class="tnt-promote-price-left" style="background: url('/ProGate-portlet/images/saleoff_small.png') no-repeat scroll center top transparent; height: 60px; width: 220px;">
								<div>
									<span class="tnt-text color-type1">
										<fmt:message key="title.product.decrease.price" />
									</span>
									<span class="tnt-text color-type1 tnt-text-bold tnt-text-size-18">
										<fmt:formatNumber type="number" pattern="###" value="${bean.currentProduct.discount}" />%
									</span>
								</div>
								
								<div style="margin-top: 5px;">
									<span class="tnt-text color-type2">
										<fmt:message key="title.product.left.price" />							
									</span>
									<span class="tnt-text color-type2 tnt-text-bold tnt-text-size-18">
										<fmt:formatNumber value="${bean.currentProduct.price - bean.currentProduct.price * bean.currentProduct.discount / 100}" 
										maxFractionDigits="${maxFraction}" minFractionDigits="${maxFraction}"/>
									</span>
									<span><c:out value="${bean.currentProduct.currencyCode}"></c:out></span>
								</div>
							</div>
							
							<div class="tnt-promote-price-right" style="float: left; padding-left: 24px; padding-top: 16px;">
								<span class="tnt-text color-type3" style="text-decoration: line-through;">
									<fmt:message key="title.product.original.price" />
									<fmt:formatNumber value="${bean.currentProduct.price}" maxFractionDigits="${maxFraction}" minFractionDigits="${maxFraction}"/>
									<c:out value="${bean.currentProduct.currencyCode}"></c:out>
								</span>
								<br>
								<span class="tnt-text color-type3">
									<fmt:message key="title.product.save.price" />							
								</span>
								<span class="tnt-text color-type3 tnt-text-bold tnt-text-size-18">							
									<fmt:formatNumber value="${bean.currentProduct.price * bean.currentProduct.discount / 100}" 
									maxFractionDigits="${maxFraction}" minFractionDigits="${maxFraction}"/>
								</span>
								<span class="tnt-text color-type3 ">							
									<c:out value="${bean.currentProduct.currencyCode}"></c:out>
								</span>
							</div>
						</div>
					</div>
				</div>
			
				<div class="tnt-row" style="float: right; padding: 4px 8px 4px 0;">
					<div class="tnt-row-right">					
						<input type="button" name="" value='<fmt:message key="button.order" />'	class="bt-form" />
					</div>
				</div>
			</div>	
		</c:when>

		<c:otherwise>			
			<div style="float: left; width: 100%;">
			<div class="tnt-row">
				<div class="tnt-row-left" style="padding-left: 6px;">
					<img alt="" style="padding: 2px;" src='<c:out value="${bean.currentProduct.smallImageUrl}"></c:out>'>
				</div>
				
				<div class="tnt-row-right" style="padding-right: 6px; width: 73%;">
					<div style="height: 108px;">
						<div>
							<span class="tnt-article-title">
								<portlet:renderURL var="viewProductURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
								    <portlet:param name="action" value="productDetail" />
								    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" value='${bean.currentProduct.journalArticleId}'/>
								</portlet:renderURL>
								<a href="<%=PortalUtil.getPortalURL(request) %>/${bean.friendlyUrl}?
									<%=URLParameter_RS.PRODUCT_ID %>=${bean.currentProduct.journalArticleId}">
									<c:out value="${bean.currentProduct.title}"></c:out>
								</a>
							</span>
						</div>
						
						<div class="tnt-text">
							<span><c:out value="${bean.currentProduct.description}" escapeXml="false"></c:out></span>	
						</div>
					</div>
					
					<div class="tnt-product-price">
						<span>
							<fmt:message key="title.product.original.price" />
						</span>
						<span class="tnt-text-bold" >
							<fmt:formatNumber value="${bean.currentProduct.price}" maxFractionDigits="${maxFraction}" minFractionDigits="${maxFraction}"/>
						</span>
						<span>
							<c:out value="${bean.currentProduct.currencyCode}"></c:out>
						</span>
					</div>
				</div>
			</div>
			
			<div class="tnt-row" style="float: right; padding: 4px 8px 4px 0;">
				<div class="tnt-row-right">					
					<input type="button" name="" value='<fmt:message key="button.order" />' class="bt-form" onclick="" />					
				</div>
			</div>
		</div>
		</c:otherwise>	
	</c:choose>
</div>
		
