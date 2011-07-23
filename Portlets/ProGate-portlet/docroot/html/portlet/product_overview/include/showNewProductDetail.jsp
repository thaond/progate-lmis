<style type="text/css">
   <%@ include file="/css/course_view/product_view.css" %>
</style>

<c:choose>
	<c:when test="${product.currencyCode == 'VND'}">
		<c:set value="0" var="maxFraction" />
	</c:when>
	<c:otherwise>
		<c:set value="2" var="maxFraction" />
	</c:otherwise>
</c:choose>
<div style="float: left; width: 100%;">
	<div class="tnt-row" style="padding: 0px;">
		<div class="tnt-row-left" style="padding-left: 6px;">
			<img alt="" style="padding: 2px;" src='<c:out value="${product.smallImageUrl}"></c:out>'>
		</div>
		
		<div class="tnt-row-right" style="padding-right: 6px; width: 73%;">
			<div style="height: 108px;">
				<div>					
					<span class="tnt-article-title">
						<a href="<%=PortalUtil.getPortalURL(request) %>/${bean.friendlyUrl}?
							<%=URLParameter_RS.PRODUCT_ID %>=${product.journalArticleId}">
							<c:out value="${product.title}"></c:out>
						</a>
					</span>
				</div>
				
				<div class="tnt-text">
					<span>
						<c:out value="${product.description}" escapeXml="false"></c:out>
					</span>	
				</div>
			</div>
			
			<div class="tnt-product-price">
				<span>
					<fmt:message key="title.product.original.price" />
				</span>
				<span class="tnt-text-bold" >
					<fmt:formatNumber value="${product.price}" maxFractionDigits="${maxFraction}" minFractionDigits="${maxFraction}"/>
				</span>
				<span>
					<c:out value="${product.currencyCode}"></c:out>
				</span>
			</div>
		</div>
	</div>
	
	<div class="tnt-row" style="float: right; padding: 4px 8px 4px 0;">
		<div class="tnt-row-right">					
			<input type="button" name="" value='<fmt:message key="button.detail" />'
					class="bt-form" style="padding-right: 5px;" 
					onclick="viewProduct('<%=PortalUtil.getPortalURL(request) %>/${bean.friendlyUrl}?
							<%=URLParameter_RS.PRODUCT_ID %>=${product.journalArticleId}')" />
			
			<input type="button" name="" value='<fmt:message key="button.order" />' class="bt-form" onclick="" />					
		</div>
	</div>
</div>