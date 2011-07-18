<fmt:setLocale value="vi_VN"/>
<c:choose>
	<c:when test="${product.currencyCode == 'VND'}">
		<c:set value="0" var="maxFraction" />
	</c:when>
	<c:otherwise>
		<c:set value="2" var="maxFraction" />
	</c:otherwise>
</c:choose>

<div style="padding: 5px">
	<div class="tnt-row">
		<div class="tnt-row-left">
		<div style="position: relative;" class="tnt-img-left">
			<div class="tnt-promote-price">
				<span><fmt:formatNumber type="number" pattern="###"	value="${product.discount}" /> % </span>
			</div>    
			<img alt="" src='<c:out value="${product.smallImageUrl}"></c:out>'
				 onLoad='scaleImg(this, 80, 80)' style="display: none;">
		</div>
		</div>
		 
		<div class="tnt-row-right eighty-half">
			<div class="tnt-product-description">
				<div>
					<c:if test="${bean.isOrgAdmin == true }">
					<span class="tnt-bt-edit">
					<portlet:renderURL var="editproductURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
					    <portlet:param name="action" value="handleProduct" />
					    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" value='${bean.orgId}'/>
						<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value='${bean.viewMode}'/>
					    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" value='${product.journalArticleId}'/>
					    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" value='<%=PortalUtil.getCurrentURL(renderRequest) %>'/>
					    <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"/>
					</portlet:renderURL>
					<a href='<c:out value="${editproductURL}"></c:out>' class="tnt-link" >
						<fmt:message key="button.edit" />
					</a>
					</span>
					&nbsp;
					</c:if>
					
					<span class="tnt-article-title">
						<a href="${bean.productDetailLink}${product.journalArticleId}">
								<c:out value="${product.title}"></c:out>
						</a>
					</span>
				</div>
				
				<c:if test="${bean.isOrgProfilePage == true }">
				<div style="padding-top: 1px;">
					<a href="${bean.orgProfileLink}${product.orgId}" class="tnt-link">
						<c:out value="${product.orgName}"></c:out>
					</a>
				</div>
				</c:if>
				
				<div class="tnt-text" style="padding-top: 3px;">
				<span><c:out value="${product.description}" escapeXml="false"></c:out></span>	
				</div>
			</div>
			
			<div class="tnt-product-price">
				<div class="tnt-row-left">
					<span>
						<fmt:message key="title.product.price" />
					</span>
					<span class="tnt-text-bold" >					
						<fmt:formatNumber
							value="${product.price - product.price * product.discount / 100}" 
							maxFractionDigits="${maxFraction}" minFractionDigits="${maxFraction}"/>
					</span>
					<span>
						<c:out value="${product.currencyCode}"></c:out>
					</span>
					&nbsp;
					<span style="text-decoration: line-through; color: black;">						
						<fmt:formatNumber value="${product.price}" maxFractionDigits="${maxFraction}" minFractionDigits="${maxFraction}"/>
						
						<c:out value="${product.currencyCode}"></c:out>
					</span>
				</div>
				
				<div class="tnt-row-right">
					<input type="button" name="" value='<fmt:message key="button.detail" />'
							class="bt-form" style="padding-right: 5px;"
							onclick="viewProduct('${bean.productDetailLink}${product.journalArticleId}')"/>
							
					<c:choose>
						<c:when test="${product.amount >0 and bean.isExpiredDate ==false}">
							<input disabled="disabled" type="button" name="" value='<fmt:message key="button.order" />'
							class="bt-form" /> 
						</c:when>
						<c:otherwise>
							<input disabled="disabled" type="button" name="" value='<fmt:message key="button.order" />'
							class="bt-form" /> 
						</c:otherwise>
				   </c:choose>
				    
				</div>
			</div>
		</div>
	</div>
</div>