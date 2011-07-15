<%@ include file="../common/init.jsp" %>
<%@ include file="slide_show_scripts.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<form action="" method="post" name="frmSlideShowProduct" enctype="multipart/form-data">
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
	</div>
	
	<div class="tnt-row tnt-border-bottom">
		<div class="tnt-row-right">
			<span class="tnt-bt-up">
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
			&nbsp;
			<c:if test='${bean.cmd == "update"}'>
			<span class="tnt-bt-delete">
			<a href="javascript:deleteSlideShowProduct()" class="tnt-link">
			<fmt:message key="button.delete" />
			</a>
			</span>
			</c:if>
		</div>
	</div>
	
	<div class="tnt-row" id="tnt-global-message">			
		<span>
		
		</span>			
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="warning.product.image" />
		</span>
		</div>
	</div>
	
	<c:forEach items="${bean.slideShowList}" var="slideShow" varStatus="count">
	<div class="tnt-row tnt-border-bottom">
		<div class="tnt-row-left">
			<div class="tnt-row">
				<div class="tnt-row-left">
				<div style="padding-left: 20px; padding-top: 70px;">
				<input type="checkbox" name="<%=Request.CHILD_CKB %>"
						class="cb_slide_show" value="${slideShow.primaryKey }"/>
				</div>
				</div>
				
				<div class="tnt-row-right" style="padding-left: 30px;">
				<span>
				<img alt="" src="<c:out value="${slideShow.imageUrl}"></c:out>" 
					class="image-preview" />
				</span>
				</div>
			</div>
		</div>
		
		<div class="tnt-row-right sixty" >
			<div class="tnt-row">
			<span>
			<input type="file" name="<%=SlideShowProduct_RS.SSP_IMAGE_URL%>-${count.count}" size="77"
					class="file-target" id="file-target-${count.count}"/>
			</span>
			
			<span class="tnt-error-message" id="error_slide_show_image-${count.count}"></span>
			</div>
			
			<div class="tnt-row">
				<div class="tnt-row-left">
				<span>
				<fmt:message key="title.slideshow.product" />
				</span>
				</div>
				
				<div class="tnt-row-right seventy">
					<span>
					<input type="text" name="<%=SlideShowProduct_RS.SSP_TITLE%>-${count.count}" 
						value="${slideShow.title}" class="slideShowTitle" 
						id="slideShowTitle-${count.count}"
						maxlength="20"/>
					</span>
					
					<span class="error_title_slideshow tnt-error-message" 
						id="error_title_slideshow-${count.count}"></span>
				</div>
			</div>
			
			<div class="tnt-row">
				<div class="tnt-row-left">
				<span>
				<fmt:message key="title.slideshow.product.corresponding" />
				</span>
				</div>
				
				<div class="tnt-row-right seventy">
					<span>
					<select style="width: 392px;" name="<%=SlideShowProduct_RS.SSP_PRODUCT_ID%>-${count.count}">
					<c:forEach items="${bean.productList}" var="product">
					<c:choose>
					<c:when test="${product.primaryKey == slideShow.productId}">
					<option value="${product.primaryKey}" selected="selected">${product.title }</option>
					</c:when>						
					<c:otherwise>
						<option value="${product.primaryKey}" >${product.title }</option>	
					</c:otherwise>
					</c:choose>	
					</c:forEach>
					</select>
					</span>
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
			<input type="button" class="bt-form" onclick="add_validate_and_submit()"
				value='<fmt:message key="button.save" />'/>
			</c:when>
			
			<c:otherwise>
			<input type="button" class="bt-form" onclick="update_validate_and_submit()"
				value='<fmt:message key="button.save" />'/>
			</c:otherwise>
		</c:choose>
		</span>
		
		<span>
		<input type="button" class="bt-form"
				onclick="cancel('<%=PortalUtil.getPortalURL(request) %>/
							<%=ProGateUtil.getConfigValue(renderRequest, ConfigParams_RS.REDIRECT_URL)%>?
							<%=URLParameter_RS.ORG_ID %>=${bean.orgId}&
							<%=URLParameter_RS.VIEW_MODE %>=${bean.viewMode}')"
				value='<fmt:message key="button.cancel" />'/>
		</span>
	</div>
	</div>
</div>
</form>

<form name="frmMsg">
	<input type="hidden" name="<%=Request.MESSAGE_TXT %>" id="MsgTxt" value="${bean.MsgTxt}">
</form>