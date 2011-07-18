<%@ include file="../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="scripts/product_scripts.jsp"%>

<form action="" method="post" name="frmProduct">
	<div class="org-profile-layout-column-21">

		<jsp:include page="include/searchProduct.jsp" />

		<div class="tnt-product-list">
			<div>
				<div class="tnt-row-right">
					<c:if test="${bean.isOrgAdmin == true }">
						<span> <portlet:renderURL
								windowState="<%=WindowState.MAXIMIZED.toString() %>"
								var="addProductURL">
								<portlet:param name="action" value="handleProduct" />
								<portlet:param name="<%=URLParameter_RS.ORG_ID %>"
									value='${bean.orgId}' />
								<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>"
									value='${bean.viewMode}' />
								<portlet:param
									name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
									value='<%=PortalUtil.getCurrentURL(renderRequest) %>' />
								<portlet:param name="<%=Constants.CMD%>"
									value="<%=Constants.ADD%>" />
							</portlet:renderURL> <a href="${addProductURL}" class="tnt-link"> + <fmt:message
									key="button.add" /> </a> </span>
					</c:if>
				</div>
			</div>

			<!-- List of new products -->
			<div class="tnt-row">
				<div class="tnt-row tnt-border-bottom">
					<div class="tnt-row-left">
						<span class="tnt-product-title"> <a
							href="${bean.productByTypeLink}1"> <c:choose>
									<c:when
										test='${bean.categoryType == "1" || bean.categoryType == "0" }'>
										<fmt:message key="title.product.new" />
									</c:when>
									<c:when test='${bean.categoryType == "2"}'>
										<fmt:message key="title.course.new" />
									</c:when>
									<c:otherwise>
										<fmt:message key="title.exam.new" />
									</c:otherwise>
								</c:choose> </a> </span>
					</div>
				</div>

				<div class="tnt-row">
					<c:forEach items="${bean.newProductList}" var="product"
						varStatus="count">
						<c:choose>
							<c:when test="${count.count < bean.lastIndexNewProductList}">
								<div class="tnt-row-hover tnt-border-bottom">
							</c:when>

							<c:otherwise>
								<div class="tnt-row-hover">
							</c:otherwise>
						</c:choose>
						<%@ include file="include/showingNewProductDetails.jsp"%>
				</div>
				</c:forEach>
			</div>
		</div>

		<!-- List of best seller products -->
		<div class="tnt-row">
			<div class="tnt-row tnt-border-bottom">
				<div class="tnt-row-left">
					<span class="tnt-product-title"> <a
						href="${bean.productByTypeLink}2"> <c:choose>
								<c:when
									test='${bean.categoryType == "1" || bean.categoryType == "0"}'>
									<fmt:message key="title.product.best.seller" />
								</c:when>
								<c:when test='${bean.categoryType == "2"}'>
									<fmt:message key="title.course.best.seller" />
								</c:when>
								<c:otherwise>
									<fmt:message key="title.exam.best.seller" />
								</c:otherwise>
							</c:choose> </a> </span>
				</div>
			</div>

			<div class="tnt-row">
				<c:forEach items="${bean.bestSellProductList}" var="product"
					varStatus="count">
					<c:choose>
						<c:when test="${count.count < bean.lastIndexBestSellProductList}">
							<div class="tnt-row-hover tnt-border-bottom">
						</c:when>

						<c:otherwise>
							<div class="tnt-row-hover">
						</c:otherwise>
					</c:choose>
					<%@ include file="include/showingNewProductDetails.jsp"%>
			</div>
			</c:forEach>
		</div>
	</div>

	<!-- List of promote product -->
	<div class="tnt-row">
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-row-left">
				<span class="tnt-product-title"> <a
					href="${bean.productByTypeLink}3"> <c:choose>
							<c:when
								test='${bean.categoryType == "1" || bean.categoryType == "0"}'>
								<fmt:message key="title.product.promote" />
							</c:when>
							<c:when test='${bean.categoryType == "2"}'>
								<fmt:message key="title.course.promote" />
							</c:when>
							<c:otherwise>
								<fmt:message key="title.exam.promote" />
							</c:otherwise>
						</c:choose> </a> </span>
			</div>
		</div>

		<div class="tnt-row">
			<c:forEach items="${bean.promoteProductList}" var="product"
				varStatus="count">
				<c:choose>
					<c:when test="${count.count < bean.lastIndexPromoteProductList}">
						<div class="tnt-row-hover tnt-border-bottom">
					</c:when>

					<c:otherwise>
						<div class="tnt-row-hover">
					</c:otherwise>
				</c:choose>
				<%@ include file="include/showingPromoteProductDetails.jsp"%>
		</div>
		</c:forEach>
	</div>
	</div>
	</div>
	</div>
</form>