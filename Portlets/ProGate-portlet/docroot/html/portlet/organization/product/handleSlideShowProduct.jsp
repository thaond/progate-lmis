<%@ include file="../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="scripts/slide_show_scripts.jsp"%>

<c:choose>
<c:when test="${ bean.productListCount == 0 }">
  <div class="tnt-row tnt-row-center" id="tnt-global-message">
	<span style="background: url('/ProGate-portlet/images/info.png') no-repeat scroll left top transparent">&nbsp;&nbsp;&nbsp;&nbsp;</span>
	<span><fmt:message key="warning.slideshow.product.no.product.corresponding" /> </span>
  </div>
</c:when>
<c:otherwise>
<form action="" method="post" name="frmSlideShowProduct"
	enctype="multipart/form-data">
	<div class="tnt-content" style="margin: 10px;">
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-row-left">
				<span class="tnt-title"> 
				<c:choose>
						<c:when test='${bean.cmd == "add"}'>
							<fmt:message key="title.slideshow.product.add" />
						</c:when>

						<c:otherwise>
							<fmt:message key="title.slideshow.product.update" />
						</c:otherwise>
				</c:choose> 
				</span>
			</div>

			<div class="tnt-row-right">
				<!-- <span class="tnt-bt-up">
			<a href="" class="tnt-link">
			<fmt:message key="button.up" />
			</a>
			</span>
			&nbsp;
			<span class="tnt-bt-down">
			<a href="" class="tnt-link">
			<fmt:message key="button.down" />
			</a>
			</span>
			&nbsp; -->
				<c:if test='${bean.cmd == "update"}'>
					<a href="javascript:deleteSlideShowProduct()" class="tnt-link">
						<span class="tnt-bt-delete"> 
						<fmt:message key="button.delete" /> 
						</span> 
					</a>
				</c:if>
			</div>
		</div>

		<div class="tnt-row" id="tnt-global-message">
			<span> </span>
		</div>

		<div class="tnt-row">
			<div class="tnt-row-left">
				<span> <fmt:message key="warning.slideshow.product.image" /> </span>
			</div>
		</div>

		<c:forEach items="${bean.slideShowList}" var="slideShow"
			varStatus="count">
			<div class="tnt-row tnt-border-bottom">
				<div class="tnt-row-left">
					<div class="tnt-row">
						<div class="tnt-row-left">
							<div class="cb_slide_show">
								<input type="checkbox" name="<%=Request.CHILD_CKB%>"
									value="${slideShow.primaryKey }" />
							</div>
						</div>

						<div class="tnt-row-right img_slide_show">
							<c:choose>
								<c:when
									test="${slideShow.imageUrl!=null && slideShow.imageUrl!=''}">
									<span> <img style="border: 2px double #E0EDF4;" alt=""
										src="<c:out value="${slideShow.imageUrl}"></c:out>"
										class="image-preview" id="image-preview-${count.count}" /> </span>
								</c:when>
								<c:otherwise>
									<span> <img style="border: 2px double #E0EDF4;" alt=""
										src="<%=request.getContextPath()%>/images/news_org/small_noImage.gif"
										class="image-preview" id="image-preview-${count.count}" /> </span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<div class="tnt-row-right" style="width: 728px;">
					<div style="padding-left: 10px;">
						<div class="tnt-row">
							<span> <input type="file"
								name="<%=SlideShowProduct_RS.SSP_IMAGE_URL%>-${count.count}"
								size="103" class="file-target" id="file-target-${count.count}" />
							</span> <span class="tnt-error-message"
								id="error_slide_show_image-${count.count}"></span>
						</div>
						<div class="tnt-row">
							<div class="tnt-row-left">
								<span> <fmt:message key="title.slideshow.product" /> </span>
							</div>

							<div class="tnt-row-right eighty">
								<span> <input type="text"
									name="<%=SlideShowProduct_RS.SSP_TITLE%>-${count.count}"
									value="${slideShow.title}" class="slideShowTitle"
									id="slideShowTitle-${count.count}" maxlength="50" /> </span> <span
									class="error_title_slideshow tnt-error-message"
									id="error_title_slideshow-${count.count}"></span>
							</div>
						</div>
						<div class="tnt-row">
							<div class="tnt-row-left">
								<span> <fmt:message
										key="title.slideshow.product.corresponding" /> </span>
							</div>

							<div class="tnt-row-right eighty">
								<span> <select class="slide_show_product"
									name="<%=SlideShowProduct_RS.SSP_PRODUCT_ID%>-${count.count}">
										<c:forEach items="${bean.productList}" var="product">
											<c:choose>
												<c:when test="${product.primaryKey == slideShow.productId}">
													<option value="${product.primaryKey}" selected="selected">${product.title
														}</option>
												</c:when>
												<c:otherwise>
													<option value="${product.primaryKey}">${product.title
														}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select> </span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

		<div class="tnt-row">
			<div class="tnt-row-center" style="padding-top: 30px; height: 70px;">
				<span> 
				      <c:choose>
						<c:when test='${bean.cmd == "add"}'>
							<input type="button" class="bt-form"
								onclick="add_validate_and_submit()"
								value='<fmt:message key="button.save" />' />
						</c:when>
						<c:otherwise>
							<input type="button" class="bt-form"
								onclick="update_validate_and_submit()"
								value='<fmt:message key="button.save" />' />
						</c:otherwise>
					</c:choose> 
			  </span> 
			  <span> 
				<input type="button" class="bt-form"
					   onclick="cancel('<c:out value='${bean.returnToFullPageURL }'/>')"
					   value='<fmt:message key="button.cancel" />' />
			</span>
			</div>
		</div>
	</div>
	<input type="hidden" name="<%=URLParameter_RS.ORG_ID%>" value="${bean.orgId}" /> 
	<input type="hidden" name="<%=URLParameter_RS.VIEW_MODE%>" value="${bean.viewMode}" /> 
	<input type="hidden" name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL%>" value="${bean.returnToFullPageURL}" />
</form>
<form name="frmMsg">
	<input type="hidden" name="<%=Request.MESSAGE_TXT%>" id="MsgTxt"
		value="${bean.MsgTxt}">
</form>
</c:otherwise>
</c:choose>
