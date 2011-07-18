<%@ include file="../common/init.jsp" %>
<%@ include file="scripts.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.Map" %>

<% 
	Map<String, Object> bean = (Map<String, Object>) request.getAttribute("bean");

	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setWindowState(WindowState.MAXIMIZED);
	renderURL.setParameter("action", "addProduct");
	renderURL.setParameter(URLParameter_RS.ORG_ID, String.valueOf(bean.get(URLParameter_RS.ORG_ID)));
	renderURL.setParameter(URLParameter_RS.VIEW_MODE, String.valueOf(bean.get(URLParameter_RS.VIEW_MODE)));	

	System.out.println("addProduct: renderURL = " + renderURL.toString());
%>

<c:set value="<%= renderRequest.getWindowState() %>" var="windowState"/>
<c:if test="${(bean.viewMode == 1) && (windowState != WindowState.MAXIMIZED)}">
	<script type="text/javascript">
		window.location.href = "<%= renderURL.toString() %>";
	</script>
</c:if>

<form action="" method="post" name="frmProduct" enctype="multipart/form-data">
<div class="tnt-content" style="margin: 10px;">
	<div class="tnt-row tnt-border-bottom">
		<div class="tnt-row-left">
		<span>
			<fmt:message key="title.product.add" />
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span class="tnt-global-error-message">
			</span>
			</div>
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
			
			<div class="tnt-row-right seventy seventy">
				<span>
				<input type="text" name="<%=JournalArticle_RS.JA_TITLE %>" style="width: 687px;">
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
			
			<div class="tnt-row-right seventy">
				<span>
				<input type="text" name="<%=ProductService_RS.PS_PRICE %>" 
					onkeypress="return isNumberKey(event)"	class="tnt-price"/>
				</span>
				
				<span id="error_product_price" class="tnt-error-message"></span>
			</div>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.unit" />
			</span>
			</div>
			
			<div class="tnt-row-right seventy">
				<span>
				<select name="<%=ProductService_RS.PS_CURRENCY_ID %>">
				<c:forEach items="${bean.currencyList}" var="currency">
				<option value="${currency.currencyId }"><c:out value="${currency.code }"></c:out></option>
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
			
			<div class="tnt-row-right seventy">
				<span>
				<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="1" checked="checked" >
				<label><fmt:message key="title.product.new" /></label>
				</span>
				
				<span>
				<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="2" >
				<label><fmt:message key="title.product.best.seller" /></label>
				</span>

				<span>
				<input type="radio" name="<%=ProductService_RS.PS_PRODUCT_TYPE %>" value="3" >
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
			
			<div class="tnt-row-right seventy">
				<span>
				<input type="text" name="<%=ProductService_RS.PS_DISCOUNT %>" 
						onkeypress="return isNumberKey(event)" class="tnt-price"> %
				</span>
				
				<span id="error_product_discount" class="tnt-error-message"></span>
			</div>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-right seventy">
			<span>
			<input type="checkbox" name="<%=ProductService_RS.PS_IS_HOT %>" value="false"/>
			<label><fmt:message key="title.product.check.hot" /></label>
			</span>
			</div>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-right seventy">
			<span class="tnt-info">
				<fmt:message key="warning.product.check.logo" />
			</span>			
			</div>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.product.require.description" />
			</span>
			</div>
			
			<div class="tnt-row-right seventy">
				<span>
				<textarea rows="5" style="width: 687px;" 
							name="<%=JournalArticle_RS.JA_DESCRIPTION %>"
							onkeypress="return imposeMaxLength(this, 350, event);"></textarea>
				</span>
				
				<span id="error_product_description" class="tnt-error-message"></span>
			</div>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="warning.product.require.content" />
			</span>
			</div>
			
			<div class="tnt-row-right seventy">
				<span>
				<liferay-ui:input-editor
					name='jaContent'
					editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
					toolbarSet="liferay-article"
					initMethod='initEditor'
					onChangeMethod='editorContentChanged'
					height="400px"
					width="687px"
				/>
				<input type="hidden" name='<%=JournalArticle_RS.JA_CONTENT %>' value="" />
				</span>
				
				<span id="error_product_content" class="tnt-error-message"></span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
			<span>
				<fmt:message key="warning.product.require.image" />
			</span>
			</div>
			
			<div class="tnt-row-right seventy">
				<span>
				<input type="file" name="<%=JournalArticle_RS.JA_SMALL_IMAGE_URL %>" size="72"/>
				</span>
				
				<span id="error_product_image" class="tnt-error-message"></span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-right seventy">
			<span class="tnt-info">
				<fmt:message key="warning.product.image" />
			</span>			
			</div>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-center">
				<span>
				<input type="button" class="bt-form" onclick="add_validate_and_submit()"
					value='<fmt:message key="button.save" />'/>
				</span>
				
				<span>
				<input type="button" class="bt-form" onclick="cancel()"
					value='<fmt:message key="button.cancel" />'/>
				</span>
			</div>
		</div>		
	</div>
</div>
</form>