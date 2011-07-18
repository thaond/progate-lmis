<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/html/portlet/common/image_preview.jsp" %>
<%@ include file="scripts/product_scripts.jsp" %>
<form action="" method="post" name="frmProduct" enctype="multipart/form-data" >
<div class="tnt-content" style="margin: 10px;">
	<div class="tnt-row tnt-border-bottom">
		<c:choose>
			<c:when test='${bean.cmd == "add" }'>
			<div class="tnt-row-left">
			<span class="tnt-title-black">
				<fmt:message key="title.product.add" />
			</span>
			</div>
			</c:when>
			
			<c:otherwise>
			<div class="tnt-row-left">
			<span class="tnt-title-black">
				<fmt:message key="title.product.edit" />
			</span>
			</div>
		
			</c:otherwise>
		</c:choose>		
	</div>
	
	<div class="tnt-body">
	
	<c:if test='${bean.cmd != "add" }'>
	<div class="tnt-row-right">
			<span class="tnt-bt-delete-black">
			<a href='javascript:deleteProduct()' class="tnt-link">
			<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/support_org_profile/delete.png" 
			width="25" height="25" />
					<fmt:message key="button.delete" />
				</a>
			</span>
			</div>
			</c:if>
	
		<div class="tnt-row" id="tnt-global-message">			
			<span>
			
			</span>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span class="tnt-required-title">
			<fmt:message key="title.required.field" />
			</span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.name" />
			</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<span>
				<input type="text" name="<%= JournalArticle_RS.JA_TITLE %>" style="width: 734px;"
					value="${bean.product.title }" maxlength="40">
				</span>
				<span id="error_product_name" class="tnt-error-message"></span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.original.price" />
			</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<span>
				<input type="text" name="<%= ProductService_RS.PS_PRICE %>" maxlength="10"
					value="<fmt:formatNumber value="${bean.product.price}" 
						maxFractionDigits="${maxFraction}" 
						minFractionDigits="${maxFraction}"
						groupingUsed = "false" 
						/>"
					onkeypress="return isDecimal(event)" class="tnt-price" />
				</span>
				<br/>
				<span id="error_product_price" class="tnt-error-message"></span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.unit" />
			</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<span>
				<select name="<%=ProductService_RS.PS_CURRENCY_ID %>" style="width: 185px;">
				<c:forEach items="${bean.currencyList}" var="currency">
				<c:choose>
				<c:when test='${bean.cmd == "add" }'>
					<c:choose>
					<c:when test='${currency.code == "VND" }'>
					<option value="${currency.currencyId }" selected="selected"><c:out value="${currency.code }"></c:out>
					</option>
					</c:when>
					
					<c:otherwise >
					<option value="${currency.currencyId }" ><c:out value="${currency.code }"></c:out>
					</option>
					</c:otherwise>
				</c:choose>
				</c:when>
				
				<c:otherwise>
					<c:choose>
					<c:when test="${currency.currencyId == bean.product.currencyId }">
					<option value="${currency.currencyId }" selected="selected"><c:out value="${currency.code }"></c:out>
					</option>
					</c:when>
					
					<c:otherwise >
					<option value="${currency.currencyId }" ><c:out value="${currency.code }"></c:out>
					</option>
					</c:otherwise>
				</c:choose>
				</c:otherwise>
				</c:choose>
				</c:forEach>
				</select>
				</span>
				
				<span id="error_product_currency" class="tnt-error-message"></span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.type" />
			</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<span>
				<c:choose>
				<c:when test='${bean.cmd == "add" }'>
					<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="1" 
							checked="checked">
				</c:when>
				
				<c:otherwise>
					<c:choose>					
					<c:when test="${bean.product.productType == 1}">
					<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="1" 
							checked="checked">
					</c:when>
					
					<c:otherwise>
					<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="1" >
					</c:otherwise>
					</c:choose>
				</c:otherwise>
				</c:choose>
					<label><fmt:message key="title.product.new" /></label>
				</span>
				
				<span style="padding-left: 20px;">
				<c:choose>
					<c:when test="${bean.product.productType == 2}">					
					<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="2"
							checked="checked">
					</c:when>
					
					<c:otherwise>
					<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="2">
					</c:otherwise>
				</c:choose>
					<label><fmt:message key="title.product.best.seller" /></label>
				</span>
				
				<span style="padding-left: 20px;">
				<c:choose>
					<c:when test="${bean.product.productType == 3}">					
					<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="3" 
							checked="checked" id="rdPromotion">
					</c:when>
					
					<c:otherwise>
					<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="3" 
							id="rdPromotion" >
					</c:otherwise>
				</c:choose>
					<label><fmt:message key="title.product.promote" /></label>
				</span>
			</div>
		</div>
		
		<div class="tnt-row" id="isDisplayPromotion" style="display: none;">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.promote" />
			</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<span>
				<input type="text" name="<%=ProductService_RS.PS_DISCOUNT %>"
						value="${bean.product.discount }" class="tnt-price"
						onkeypress="return isNumberKey(event)"> %
				</span>
				<br/>
				<span id="error_product_discount" class="tnt-error-message"></span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-right eighty">
			<span>
			<c:choose>
				<c:when test="${bean.product.isHot == true}">
				<input type="checkbox" name="<%=ProductService_RS.PS_IS_HOT %>" checked="checked" value="true"/>
				</c:when>
				
				<c:otherwise>
				<input type="checkbox" name="<%=ProductService_RS.PS_IS_HOT %>" value="false"/>
				</c:otherwise>
			</c:choose>
				<label><fmt:message key="title.product.check.hot" /></label>
			</span>
			</div>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-right eighty">
			<span class="tnt-info">
				<fmt:message key="warning.product.check.logo" />
			</span>
			</div>
		</div>
		
		<div class="tnt-row">
		   <div class="tnt-row-left">
		      <span>
		         <fmt:message key="title.product.require.amount"/>
		      </span>
		   </div>
		   
		   <div class="tnt-row-right eighty" >
		      <span>
		        <input type="text" name="<%=ProductService_RS.PS_PRODUCT_AMOUNT%>" 
		          value="${bean.product.amount}" maxlength="10" onkeypress="return isDecimal(event)" 
		          class="tnt-price" />
		      </span>
		      <br/>
		      <span id="error_product_amount" class="tnt-error-message"></span>
		   </div>
		</div>
		
		<div class="tnt-row">
		    <div class="tnt-row-left">
		         <span>
		           <fmt:message key="title.product.require.expiredDate"/>
		         </span>
		    </div>
		    
		    <div class="tnt-row-right eighty">
		         <span>
		              <input id="product_expiredDate" class = "tnt-price" type="text" 
		                     name="<%=ProductService_RS.PS_PRODUCT_EXPIRED_DATE %>"
							 value='<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.product.expiredDate}" />'
						     readonly="readonly"/>
				</span>
		         <br/>
		         <span id="error_product_expiredDate" class="tnt-error-message"></span>
		    </div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.description" />
			</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<textarea rows="5" style="width: 734px;"
						name="<%=JournalArticle_RS.JA_DESCRIPTION %>"
						onkeypress="return imposeMaxLength(this, 160, event);">
				<c:out value='${bean.product.description }'></c:out>
				</textarea>
				<br/>
				<span id="error_product_description" class="tnt-error-message"></span>
			</div>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.content" />
			</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<span>
				<liferay-ui:input-editor
					name='productContentEditor'
					editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
					toolbarSet="liferay-article"
					initMethod='initEditor'
					onChangeMethod='editorContentChanged'
					height="400px"
					width="734px"				
				/>
				<input type="hidden" name='productContent'
						value="<c:out value='${bean.product.content}'></c:out>" />
				</span>
				<br/>
				<span id="error_product_content" class="tnt-error-message"></span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.image" />
			</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<div class="tnt-row-left" style="float: left; border: thin ridge #E0EDF4; height: 80px; width: 80px;">	
				<c:set var="smallImageUrl" value="${bean.product.smallImageUrl}" />
				<c:choose>
						<c:when test="${smallImageUrl == null || smallImageUrl == '' }">
							<img id="image-preview"  alt="" src="<%=request.getContextPath()%>/images/news_org/small_noImage.gif" 
							onLoad='scaleImg(this, 80, 80)' />
						</c:when>
						<c:otherwise>
							<img id="image-preview" alt="" src='<c:out value="${bean.product.smallImageUrl}"></c:out>'
								 onLoad='scaleImg(this, 80, 80)'>
						</c:otherwise>
				</c:choose>					
				</div>
				<div class="tnt-row-right eighty" style="width: 84%;">
					<span>
						<input type="file" id="smallImage" onchange="imagePreview('smallImage', 'image-preview')" name="<%=JournalArticle_RS.JA_SMALL_IMAGE_URL %>" size="81"/>
					</span>
					
					<br/>
					<span id="error_product_image" class="tnt-error-message"></span>
					
					<br/>
					<span class="tnt-info">
						<fmt:message key="warning.product.image" />
					</span>
				</div>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-center">
				<span>
				<c:choose>
					<c:when test='${bean.cmd == "add" }'>
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
						onclick="cancel('<c:out value='${bean.returnToFullPageURL }'/>')"
						value='<fmt:message key="button.cancel" />'/>
				</span>
			</div>
		</div>
	</div>
</div>

<input type="hidden" name="<%=JournalArticle_RS.JA_ID %>" value="${bean.product.journalArticleId}"/>
<input type="hidden" name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
<input type="hidden" name="<%=URLParameter_RS.VIEW_MODE %>" value="${bean.viewMode}"/>
<input type="hidden" name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" value="${bean.returnToFullPageURL}"/>
</form>

<form name="frmMsg">
	<input type="hidden" name="<%=Request.MESSAGE_TXT %>" id="MsgTxt" value="${bean.MsgTxt}">
</form>