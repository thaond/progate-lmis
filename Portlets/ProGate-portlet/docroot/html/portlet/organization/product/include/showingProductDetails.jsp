<%@ include file="../../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<fmt:setLocale value="vi_VN" />
<c:choose>
	<c:when test="${bean.curProduct.currencyCode == 'VND'}">
		<c:set value="0" var="maxFraction" />
	</c:when>
	<c:otherwise>
		<c:set value="2" var="maxFraction" />
	</c:otherwise>
</c:choose>

<!-- Detail of product -->
<div class="tnt-row-hover" style="background-color: #DDF0F8;">
	<c:choose>
		<c:when test="${bean.curProduct.productType == 3 }">
			<div style="padding: 5px">
				<div class="tnt-row">
					<div class="tnt-row-left">
						<div style="position: relative;" class="tnt-img-left">
							<div class="tnt-promote-price">
								<span><fmt:formatNumber type="number" pattern="###"
										value="${bean.curProduct.discount}" /> % </span>
							</div>
							   <img alt="" src='<c:out value="${bean.curProduct.smallImageUrl}"></c:out>'
							    	onLoad='scaleImg(this, 80, 80)' style="display: none;">
						</div>
					</div>

					<div class="tnt-row-right eighty-half">
						<div class="tnt-product-description">
							<div>
								<c:if test="${bean.isOrgAdmin == true }">
									<span class="tnt-bt-edit"> <portlet:renderURL
											var="editProductURL"
											windowState="<%=WindowState.MAXIMIZED.toString() %>">
											<portlet:param name="action" value="handleProduct" />
											<portlet:param name="<%=URLParameter_RS.ORG_ID %>"
												value='${bean.orgId}' />
											<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>"
												value='${bean.viewMode}' />
											<portlet:param name="<%=JournalArticle_RS.JA_ID %>"
												value='${bean.curProduct.journalArticleId}' />
											<portlet:param
												name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
												value='<%=PortalUtil.getCurrentURL(renderRequest) %>' />
											<portlet:param name="<%=Constants.CMD%>"
												value="<%=Constants.UPDATE%>" />
										</portlet:renderURL> <a href='<c:out value="${editProductURL}"></c:out>'
										class="tnt-link"> <fmt:message key="button.edit" /> </a> </span>
					                   &nbsp;
					            </c:if>
								<span class="tnt-article-title"> <c:out
										value="${bean.curProduct.title}"></c:out> </span>
							</div>

							<c:if test="${bean.isOrgProfilePage == true }">
								<div style="padding-top: 1px;">
									<a href="${bean.orgProfileLink}${bean.curProduct.orgId}"
										class="tnt-link"> <c:out
											value="${bean.curProduct.orgName}"></c:out> </a>
								</div>
							</c:if>

							<div class="tnt-text" style="padding-top: 3px;">
								<span><c:out value="${bean.curProduct.description}"
										escapeXml="false"></c:out> </span><br />
								<div style="padding-top: 3px;">
									<span><fmt:message key="title.product.amount" /> </span> <span><span>
											: </span> <c:out value="${bean.curProduct.amount}"></c:out> </span> <span
										style="margin-left: 200px;">&nbsp;</span> <span><fmt:message
											key="title.have" /> </span> <span><span> : </span> <c:out
											value="0   "></c:out> <fmt:message key="title.buy.successful" />
									</span><br /> <span><fmt:message
											key="title.product.expiredDate" /> </span> <span><span>
											: </span> <fmt:formatDate pattern="dd/MM/yyyy"
											value="${bean.curProduct.expiredDate }" /> </span>
								</div>
							</div>

						</div>

						<div class="tnt-product-price">
							<div class="tnt-row-left">
								<span> <fmt:message key="title.product.price" /> </span> <span
									class="tnt-text-bold"> <fmt:formatNumber
										value="${bean.curProduct.price - bean.curProduct.price * bean.curProduct.discount / 100}"
										maxFractionDigits="${maxFraction}"
										minFractionDigits="${maxFraction}" /> </span> <span> <c:out
										value="${bean.curProduct.currencyCode}"></c:out> </span> &nbsp; <span
									style="text-decoration: line-through; color: black;"> <fmt:formatNumber
										value="${bean.curProduct.price}"
										maxFractionDigits="${maxFraction}"
										minFractionDigits="${maxFraction}" /> <c:out
										value="${bean.curProduct.currencyCode}"></c:out> </span>
							</div>

							<div class="tnt-row-right">
								<c:choose>
									<c:when
										test="${bean.curProduct.amount >0 and bean.isExpiredDate ==false}">
										<input type="button" name="" disabled="disabled"
											value='<fmt:message key="button.order"/>' class="bt-form"
											onclick="" />
									</c:when>
									<c:otherwise>
										<input type="button" disabled="disabled" name=""
											value='<fmt:message key="button.order"/>' class="bt-form" />
									</c:otherwise>
								</c:choose>
							</div>

						</div>
					</div>


				</div>
			</div>
		</c:when>

		<c:otherwise>
			<div style="padding: 5px">
				<div class="tnt-row">
					<div class="tnt-row-left tnt-img-left">
						<div class="img-border" align="center">    
							   <img alt="" src='<c:out value="${bean.curProduct.smallImageUrl}"></c:out>'
							    	onLoad='scaleImg(this, 80, 80)' style="display: none;">
						</div>
					</div>

					<div class="tnt-row-right eighty-half">
						<div class="tnt-product-description">
							<div>
								<c:if test="${bean.isOrgAdmin == true }">
									<span class="tnt-bt-edit"> <portlet:renderURL
											var="editProductURL"
											windowState="<%=WindowState.MAXIMIZED.toString() %>">
											<portlet:param name="action" value="handleProduct" />
											<portlet:param name="<%=URLParameter_RS.ORG_ID %>"
												value='${bean.orgId}' />
											<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>"
												value='${bean.viewMode}' />
											<portlet:param name="<%=JournalArticle_RS.JA_ID %>"
												value='${bean.curProduct.journalArticleId}' />
											<portlet:param
												name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
												value='<%=PortalUtil.getCurrentURL(renderRequest) %>' />
											<portlet:param name="<%=Constants.CMD%>"
												value="<%=Constants.UPDATE%>" />
										</portlet:renderURL> <a href='<c:out value="${editProductURL}"></c:out>'
										class="tnt-link"> <fmt:message key="button.edit" /> </a> </span>
							   &nbsp;
					        </c:if>
								<span class="tnt-article-title"> <c:out
										value="${bean.curProduct.title}"></c:out> </span>
							</div>

							<c:if test="${bean.isOrgProfilePage == true }">
								<div style="padding-top: 1px;">
									<a href="${bean.orgProfileLink}${bean.curProduct.orgId}"
										class="tnt-link"> <c:out
											value="${bean.curProduct.orgName}"></c:out> </a>
								</div>
							</c:if>
							<div class="tnt-text" style="padding-top: 3px;">

								<span><c:out value="${bean.curProduct.description}"
										escapeXml="false"></c:out> </span><br />
								<div style="padding-top: 3px;">
									<span><fmt:message key="title.product.amount" /> </span> <span><span>
											: </span> <c:out value="${bean.curProduct.amount}"></c:out> </span> <span
										style="margin-left: 200px;">&nbsp;</span> 
										
									<span><fmt:message
											key="title.have" /> </span> <span><span> : </span> <c:out
											value="0  "></c:out> <fmt:message key="title.buy.successful" />
									</span> 
									<br /> <span><fmt:message
											key="title.product.expiredDate" /> </span> <span><span>
											: </span> <fmt:formatDate pattern="dd/MM/yyyy"
											value="${bean.curProduct.expiredDate }" /> </span>
								</div>
							</div>

						</div>


						<div class="tnt-product-price">
							<div class="tnt-row-left">
								<span> <fmt:message key="title.product.original.price" />
								</span> <span class="tnt-text-bold"> <fmt:formatNumber
										value="${bean.curProduct.price}"
										maxFractionDigits="${maxFraction}"
										minFractionDigits="${maxFraction}" /> </span> <span> <c:out
										value="${bean.curProduct.currencyCode}"></c:out> </span>
							</div>

							<div class="tnt-row-right" id="btn-order">							    
								<c:choose>
									<c:when
										test="${bean.curProduct.amount >0 and bean.isExpiredDate == false}">
										<input type="button" name="" disabled="disabled" 
											value='<fmt:message key="button.order"/>' class="bt-form"
											onclick="" />
									</c:when>
									<c:otherwise>
										<input type="button" disabled="disabled" name=""
											value='<fmt:message key="button.order"/>' class="bt-form" />
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>
