<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Detail of product -->
<div class="tnt-row-hover tnt-border-bottom" style="background-color: #DDF0F8;">
	<c:choose>
		<c:when test="${bean.curProduct.productType == 3 }">
			<div style="padding: 5px">
				<div class="tnt-row">
					<div class="tnt-row-left">
					<img alt="" src='<c:out value="${bean.curProduct.smallImageUrl}"></c:out>'>
					</div>
					
					<div class="tnt-row-right" style="width: 73%;">
						<div>
							<span class="tnt-article-title">
								<portlet:renderURL var="viewProductURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
								    <portlet:param name="action" value="viewProduct" />
								    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" value='${bean.orgId}'/>
								    <portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value='${bean.viewMode}'/>
								    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" value='${bean.curProduct.journalArticleId}'/>
								</portlet:renderURL>
								<a href="<%=PortalUtil.getPortalURL(request) %>/${bean.productDetailPageUrl}?
										<%=URLParameter_RS.ORG_ID %>=${bean.orgId}&
										<%=URLParameter_RS.VIEW_MODE %>=${bean.viewMode}&
										<%=URLParameter_RS.PRODUCT_ID %>=${bean.curProduct.journalArticleId}">
									<c:out value="${bean.curProduct.title}"></c:out>
								</a>
							</span>
						</div>
						
						<div style="height: 105px;">
						<span><c:out value="${bean.curProduct.description}" escapeXml="false"></c:out></span>
						</div>
						
						<div class="tnt-row tnt-promote-price">
							<div class="tnt-promote-price-left">
								<div style="margin-top: 10px;">
								<span class="tnt-text color-type1">
									<fmt:message key="title.product.decrease.price" />
								</span>
								<span class="tnt-text color-type1 tnt-text-bold tnt-text-size-18">
									<fmt:formatNumber type="number" pattern="###"
										value="${bean.curProduct.discount}" /> %
								</span>
								</div>
								
								<div style="margin-top: 10px;">
								<span class="tnt-text color-type2">
									<fmt:message key="title.product.left.price" />							
								</span>
								</div>
								
								<div>
								<span class="tnt-text color-type2 tnt-text-bold tnt-text-size-18">
									<fmt:formatNumber type="currency" currencySymbol=""
										value="${bean.curProduct.price - bean.curProduct.price * bean.curProduct.discount / 100}" />							
								</span>
								<span><c:out value="${bean.curProduct.currencyCode}"></c:out></span>
								</div>
							</div>
							
							<div class="tnt-promote-price-right ">
								<span class="tnt-text color-type3" style="text-decoration: line-through;">
									<fmt:message key="title.product.original.price" />
									<fmt:formatNumber type="currency" currencySymbol=""
											value="${bean.curProduct.price}" />
									
									<c:out value="${bean.curProduct.currencyCode}"></c:out>
								</span>
								<br>
								<span class="tnt-text color-type3">
									<fmt:message key="title.product.save.price" />							
								</span>
								<span class="tnt-text color-type3 tnt-text-bold tnt-text-size-18">							
									<fmt:formatNumber type="currency" currencySymbol=""
											value="${bean.curProduct.price * bean.curProduct.discount / 100}" />			 				
								</span>
								<span class="tnt-text color-type3 ">							
									<c:out value="${bean.curProduct.currencyCode}"></c:out>
								</span>
							</div>
						</div>
					</div>
				</div>
			
				<div class="tnt-row" style="padding: 10px 0;">
				<div class="tnt-row-right">					
					<input type="button" name="" value='<fmt:message key="button.order" />'
							class="bt-form" />
				</div>
				</div>
			</div>	
		</c:when>

		<c:otherwise>			
			<div style="padding: 5px">
			<div class="tnt-row">
				<div class="tnt-row-left">
				<img alt="" src='<c:out value="${bean.curProduct.smallImageUrl}"></c:out>'>
				</div>
				
				<div class="tnt-row-right" style="width: 73%;">
					<div style="height: 108px;">
						<div>
							<span class="tnt-article-title">
								<portlet:renderURL var="viewProductURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
								    <portlet:param name="action" value="viewProduct" />
								    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" value='${bean.orgId}'/>
							    	<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value='${bean.viewMode}'/>
								    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" value='${bean.curProduct.journalArticleId}'/>
								</portlet:renderURL>
								<a href="<%=PortalUtil.getPortalURL(request) %>/${bean.productDetailPageUrl}?
									<%=URLParameter_RS.ORG_ID %>=${bean.orgId}&
									<%=URLParameter_RS.VIEW_MODE %>=${bean.viewMode}&
									<%=URLParameter_RS.PRODUCT_ID %>=${bean.curProduct.journalArticleId}">
									<c:out value="${bean.curProduct.title}"></c:out>
								</a>
							</span>
						</div>
						
						<div class="tnt-text">
						<span><c:out value="${bean.curProduct.description}" escapeXml="false"></c:out></span>	
						</div>
					</div>
					
					<div class="tnt-product-price">
						<span>
							<fmt:message key="title.product.original.price" />
						</span>
						<span class="tnt-text-bold" >
							<fmt:formatNumber type="currency" currencySymbol=""
								value="${bean.curProduct.price}" />
						</span>
						<span>
							<c:out value="${bean.curProduct.currencyCode}"></c:out>
						</span>
					</div>
				</div>
			</div>
			
			<div class="tnt-row" style="padding: 10px 0;">
				<div class="tnt-row-right">					
					<input type="button" name="" value='<fmt:message key="button.order" />'
							class="bt-form" onclick="" />					
				</div>
			</div>
		</div>
		</c:otherwise>	
	</c:choose>
</div>
		
