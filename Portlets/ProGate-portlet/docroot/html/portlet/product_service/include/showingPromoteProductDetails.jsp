<div style="padding: 5px">
	<div class="tnt-row">
		<div class="tnt-row-left">
		<img alt="" src='<c:out value="${product.smallImageUrl}"></c:out>'>
		</div>
		
		<div class="tnt-row-right" style="width: 73%;">
			<div>
				<c:if test="${bean.isOrgAdmin == true }">
				<span class="tnt-bt-edit">
				<portlet:renderURL var="editproductURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
				    <portlet:param name="action" value="updateProduct" />
				    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" value='${bean.orgId}'/>
					<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value='${bean.viewMode}'/>
				    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" value='${product.journalArticleId}'/>
				    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" value='<%=PortalUtil.getCurrentURL(renderRequest) %>'/>
				</portlet:renderURL>
				<a href='<c:out value="${editproductURL}"></c:out>' class="tnt-link" >
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
			
			<div style="height: 105px;">
			<span><c:out value="${product.description}" escapeXml="false"></c:out></span>	
			</div>
			
			<div class="tnt-row tnt-promote-price">
				<div class="tnt-promote-price-left">
					<div style="margin-top: 10px;">
					<span class="tnt-text color-type1">
						<fmt:message key="title.product.decrease.price" />
					</span>
					<span class="tnt-text color-type1 tnt-text-bold tnt-text-size-18">
						<fmt:formatNumber type="number" pattern="###"
							value="${product.discount}" /> %
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
							value="${product.price - product.price * product.discount / 100}" />							
					</span>
					<span><c:out value="${product.currencyCode}"></c:out></span>
					</div>
				</div>
				
				<div class="tnt-promote-price-right ">
					<span class="tnt-text color-type3" style="text-decoration: line-through;">
						<fmt:message key="title.product.original.price" />
						<fmt:formatNumber type="currency" currencySymbol=""
								value="${product.price}" />
						
						<c:out value="${product.currencyCode}"></c:out>
					</span>
					<br>
					<span class="tnt-text color-type3">
						<fmt:message key="title.product.save.price" />							
					</span>
					<span class="tnt-text color-type3 tnt-text-bold tnt-text-size-18">							
						<fmt:formatNumber type="currency" currencySymbol=""
								value="${product.price * product.discount / 100}" />			 				
					</span>
					<span class="tnt-text color-type3 ">							
						<c:out value="${product.currencyCode}"></c:out>
					</span>
				</div>
			</div>
		</div>
	</div>
	
	<div class="tnt-row" style="padding: 10px 0;">
	<div class="tnt-row-right">					
		<input type="button" name="" value='<fmt:message key="button.detail" />'
				class="bt-form" style="margin-right: 5px;"
				onclick="viewProduct('<%=PortalUtil.getPortalURL(request) %>/${bean.productDetailPageUrl}?
							<%=URLParameter_RS.ORG_ID %>=${bean.orgId}&
							<%=URLParameter_RS.VIEW_MODE %>=${bean.viewMode}&
							<%=URLParameter_RS.PRODUCT_ID %>=${product.journalArticleId}')"/>
		
		<input type="button" name="" value='<fmt:message key="button.order" />'
				class="bt-form" />
	</div>
	</div>
</div>