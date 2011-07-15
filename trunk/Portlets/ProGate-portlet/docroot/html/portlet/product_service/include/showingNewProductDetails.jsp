<div style="padding: 5px">
	<div class="tnt-row">
		<div class="tnt-row-left">
		<img alt="" src='<c:out value="${product.smallImageUrl}"></c:out>'>
		</div>
		
		<div class="tnt-row-right" style="width: 73%;">
			<div style="height: 108px;">
				<div>
					<c:if test="${bean.isOrgAdmin == true }">
					<span class="tnt-bt-edit">							
						<portlet:renderURL var="editProductURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
						    <portlet:param name="action" value="updateProduct" />
						    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" value='${bean.orgId}'/>
					    	<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value='${bean.viewMode}'/>
						    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" value='${product.journalArticleId}'/>
						    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" value='<%=PortalUtil.getCurrentURL(renderRequest) %>'/>
						</portlet:renderURL>
						<a href='<c:out value="${editProductURL}"></c:out>' class="tnt-link" >
							<fmt:message key="button.edit" />
						</a>
					</span>
					&nbsp;
					</c:if>
					
					<span class="tnt-article-title">
						<portlet:renderURL var="viewProductURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
						    <portlet:param name="action" value="viewProduct" />
						    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" value='${bean.orgId}'/>
					    	<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value='${bean.viewMode}'/>
						    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" value='${product.journalArticleId}'/>
						</portlet:renderURL>
						<a href="<%=PortalUtil.getPortalURL(request) %>/${bean.productDetailPageUrl}?
							<%=URLParameter_RS.ORG_ID %>=${bean.orgId}&
							<%=URLParameter_RS.VIEW_MODE %>=${bean.viewMode}&
							<%=URLParameter_RS.PRODUCT_ID %>=${product.journalArticleId}">
							<c:out value="${product.title}"></c:out>
						</a>
					</span>
				</div>
				
				<div class="tnt-text">
				<span><c:out value="${product.description}" escapeXml="false"></c:out></span>	
				</div>
			</div>
			
			<div class="tnt-product-price">
				<span>
					<fmt:message key="title.product.original.price" />
				</span>
				<span class="tnt-text-bold" >
					<fmt:formatNumber type="currency" currencySymbol=""
						value="${product.price}" />
				</span>
				<span>
					<c:out value="${product.currencyCode}"></c:out>
				</span>
			</div>
		</div>
	</div>
	
	<div class="tnt-row" style="padding: 10px 0;">
		<div class="tnt-row-right">					
			<input type="button" name="" value='<fmt:message key="button.detail" />'
					class="bt-form" style="padding-right: 5px;" 
					onclick="viewProduct('<%=PortalUtil.getPortalURL(request) %>/${bean.productDetailPageUrl}?
							<%=URLParameter_RS.ORG_ID %>=${bean.orgId}&
							<%=URLParameter_RS.VIEW_MODE %>=${bean.viewMode}&
							<%=URLParameter_RS.PRODUCT_ID %>=${product.journalArticleId}')" />
			
			<input type="button" name="" value='<fmt:message key="button.order" />'
					class="bt-form" onclick="" />					
		</div>
	</div>
</div>
