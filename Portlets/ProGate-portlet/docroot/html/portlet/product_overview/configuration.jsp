<%@ include file="../common/init.jsp" %>

<%@ page isELIgnored="false" %>

<style type="text/css">
   .config-frm-row {
		float: left;
		padding-top: 6px;
    	width: 100%;
	}
	
	.config-frm-row-left {
		float: left;
    	text-align: left;
    	width: 32%;
	}
	
	.config-frm-row-right {
		float: left;
    	text-align: left;
	}
	
	.config-frm-row-center {
		text-align: center;
		padding-top: 8px;
	}
</style>

<script type="text/javascript">
	function onStyleSelect(focus) {
		//alert("focus = " + focus);
		
		var x = document.getElementById("<%= RequestConst.DISPLAY_SUB_STYLE %>");
		x.options[0].selected = true;
		
		jQuery("#productRedirect").css('display', 'block');
	}

	function onSubStyleSelect(focus) {
		//alert("focus = " + focus);
		
		if (focus == '<%= RequestConst.ALL_PRODUCT_LIST %>') {
			jQuery("#productRedirect").css('display', 'block');
		} else {
			jQuery("#productRedirect").css('display', 'none');
		}
	}	
</script>

<%
	//Get list of display style. Read from portal-ext.properties 
	PortletPreferences preferences = renderRequest.getPreferences();		
	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	String curDisplayStyle = preferences.getValue(RequestConst.DISPLAY_STYLE, RequestConst.PRODUCT_LIST);
	String curDisplaySubStyle = preferences.getValue(RequestConst.DISPLAY_SUB_STYLE, RequestConst.ALL_PRODUCT_LIST);
	String numOfItem = preferences.getValue(RequestConst.NUM_OF_ITEM, Integer.toString(RequestConst.INCREMENT_CONST));
	String maxItems = preferences.getValue(RequestConst.MAX_ITEM_TO_SHOW, Integer.toString(RequestConst.MAX_ITEMS_CONST));
	String friendlyUrl = preferences.getValue(RequestConst.FRIENDLY_URL, ProductOverviewConst.FRIENDLY_URL);
	String newProductUrl = preferences.getValue(RequestConst.NEW_PRODUCT_URL, ProductOverviewConst.NEW_PRODUCT_FRIENDLY_URL);
	String sellingProductUrl = preferences.getValue(RequestConst.SELLING_PRODUCT_URL, ProductOverviewConst.SELLING_PRODUCT_FRIENDLY_URL);
	String discountProductUrl = preferences.getValue(RequestConst.DISCOUNT_PRODUCT_URL, ProductOverviewConst.DISCOUNT_PRODUCT_FRIENDLY_URL);
%>

<fmt:setBundle basename="content.ProductOverview_vn" var="msg"></fmt:setBundle>

<form action="<liferay-portlet:actionURL portletConfiguration='true'/>" method="post" name="frmConfig">
	<div style="width: 50%;">
		<div class="config-frm-row">
			<div class="config-frm-row-left">
				<span><fmt:message bundle="${msg}" key="title.config.display" /></span>
			</div>
			<div class="config-frm-row-right">
				<c:set value="<%= curDisplayStyle %>" var="currentDisplayStyle"/>				
				<select id="<%=RequestConst.DISPLAY_STYLE %>" name="<%=RequestConst.DISPLAY_STYLE %>" onchange="onStyleSelect(this.value)" style="width: 146px;">
					<c:forEach var="displayStyle" items="<%= RequestConst.DISPLAY_STYLE_ARRAY %>">						
						<option value="${displayStyle}"
							<c:if test="${displayStyle == currentDisplayStyle}"> selected </c:if>
							> ${displayStyle}
						</option>
					</c:forEach>
				</select>
			</div>	
		</div>
		<div class="config-frm-row">
			<div class="config-frm-row-left">
				<br />
			</div>
			<div class="config-frm-row-right">
				<c:set value="<%= curDisplaySubStyle %>" var="currentDisplaySubStyle"/>				
				<select id="<%= RequestConst.DISPLAY_SUB_STYLE %>" name="<%= RequestConst.DISPLAY_SUB_STYLE %>" onchange="onSubStyleSelect(this.value)" style="width: 146px;">
					<c:forEach var="displaySubStyle" items="<%= RequestConst.DISPLAY_SUB_STYLE_ARRAY %>">						
						<option value="${displaySubStyle}"
							<c:if test="${displaySubStyle == currentDisplaySubStyle}"> selected </c:if>
							> ${displaySubStyle}
						</option>
					</c:forEach>
				</select>
			</div>		
		</div>
		
		<div class="config-frm-row">
			<div class="config-frm-row-left">
				<span><fmt:message bundle="${msg}" key="title.config.friendlyUrl" /></span>
			</div>
			
			<div class="config-frm-row-right">
				<span><input type="text" name="<%= RequestConst.FRIENDLY_URL %>" value="<%= friendlyUrl %>"/></span>
			</div>
		</div>
		
		<div id="productRedirect" 
			<% if (curDisplaySubStyle.equals(RequestConst.ALL_PRODUCT_LIST)) { %> 
				style="display: block;"
			<% } else { %>
				style="display: none;"
			<% } %>>
			<div class="config-frm-row">
				<div class="config-frm-row-left">
					<span><fmt:message bundle="${msg}" key="title.config.newProduct" /></span>
				</div>
				
				<div class="config-frm-row-right">
					<span><input type="text" name="<%= RequestConst.NEW_PRODUCT_URL %>" value="<%= newProductUrl %>"/></span>
				</div>
			</div>
			<div class="config-frm-row">
				<div class="config-frm-row-left">
					<span><fmt:message bundle="${msg}" key="title.config.sellingProduct" /></span>
				</div>
				
				<div class="config-frm-row-right">
					<span><input type="text" name="<%= RequestConst.SELLING_PRODUCT_URL %>" value="<%= sellingProductUrl %>"/></span>
				</div>
			</div>			
			<div class="config-frm-row">
				<div class="config-frm-row-left">
					<span><fmt:message bundle="${msg}" key="title.config.promotionProduct" /></span>
				</div>
				
				<div class="config-frm-row-right">
					<span><input type="text" name="<%= RequestConst.DISCOUNT_PRODUCT_URL %>" value="<%= discountProductUrl %>"/></span>
				</div>
			</div>
		</div>
		
		<div class="config-frm-row">
			<div class="config-frm-row-left">
				<span><fmt:message bundle="${msg}" key="title.config.maxItems" /></span>
			</div>			
			<div class="config-frm-row-right">
				<span><input type="text" name="<%= RequestConst.NUM_OF_ITEM %>" value="<%= numOfItem %>" maxlength="3"/></span>
			</div>
		</div>
		
		<div class="config-frm-row">
			<div class="config-frm-row-left">
				<span><fmt:message bundle="${msg}" key="title.config.maxItemsToShow" /></span>
			</div>			
			<div class="config-frm-row-right">
				<span><input type="text" name="<%= RequestConst.MAX_ITEM_TO_SHOW %>" value="<%= maxItems %>" maxlength="3"/></span>
			</div>
		</div>
		
		<div class="config-frm-row">
			<div class="config-frm-row-center">
				<input type="submit" id="butSubmit" name="butSubmit" value="Save"/>
			</div>
		</div>
	</div>
</form>
