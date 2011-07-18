<%@page import="java.util.Arrays"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ include file="../common/init.jsp" %>
<%@ page isELIgnored="false" %>

<%
	//Get list of display style. Read from portal-ext.properties 
	PortletPreferences preferences = renderRequest.getPreferences();

	String portletResource = ParamUtil.getString(request,
			"portletResource");

	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(
				request, portletResource);
	}

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"beans.xml");

	String[] beanDefinitionNames = context.getBeanDefinitionNames();

	String portletID = preferences.getValue(ConfigParams_RS.PORTLET_ID,
			null);

	String name = preferences.getValue(ConfigParams_RS.NAME, null);

	String image = preferences.getValue(ConfigParams_RS.IMAGE, null);

	String icon = preferences.getValue(ConfigParams_RS.ICON, null);

	String curDisplayStyle = preferences.getValue(
			ConfigParams_RS.DISPLAY_STYLE, null);

	String[] productTypes = new String[] { "All", "New", "Best", "Promote" };
	String curProductType = preferences.getValue(
			URLParameter_RS.PRODUCT_TYPE, "0");
	curProductType = productTypes[Integer.parseInt(curProductType)];
	
	String[] categoryTypes = new String[] { "None", "Product", "Course", "Exam" };
	String curCategoryType = preferences.getValue(
			URLParameter_RS.PRODUCT_CATEGORY_TYPE, "0");
	curCategoryType = categoryTypes[Integer.parseInt(curCategoryType)];

	String numOfItem = preferences.getValue(
			ConfigParams_RS.NUM_OF_ITEM, "5");

	String redirectURL = preferences.getValue(
			ConfigParams_RS.REDIRECT_URL, null);

	String productDetailURL = preferences.getValue(
			ConfigParams_RS.PRODUCT_DETAIL_PAGE_URL, null);
%>

<form action="<liferay-portlet:actionURL portletConfiguration='true'/>" method="post" name="frmConfig">

<div>

	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.portletid" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>		
		<input type="text" name="<%=ConfigParams_RS.PORTLET_ID%>" value="<%=portletID%>"/>
		</span>
		</div>
	</div>

	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.name" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>		
		<input type="text" name="<%=ConfigParams_RS.NAME%>" value="<%=name%>"/>
		</span>
		</div>
	</div>

	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.icon" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>		
		<input type="text" name="<%=ConfigParams_RS.ICON%>" value="<%=icon%>"/>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.image" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>		
		<input type="text" name="<%=ConfigParams_RS.IMAGE%>" value="<%=image%>"/>
		</span>
		</div>
	</div>

	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.display.style" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>
		<select name="<%=ConfigParams_RS.DISPLAY_STYLE%>">
		<%
			for (String displayStyle : beanDefinitionNames) {
		%>
			<option <%=displayStyle.equals(curDisplayStyle) ? "selected"
						: ""%> value="<%=displayStyle%>">
				<%=displayStyle%>
			</option>
		<%
			}
		%>
		</select>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.product.type" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>
		<select name="<%=URLParameter_RS.PRODUCT_TYPE%>">
		<c:set var="_curProductType" value="<%=curProductType %>"></c:set>
		<c:forEach var="productType" items="<%= productTypes %>" varStatus="count">						
			<option value="${count.count - 1}"
				<c:if test="${productType == _curProductType}"> selected </c:if>
				> ${productType}
			</option>
		</c:forEach>		
		</select>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.category.type" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>
		<select name="<%=URLParameter_RS.PRODUCT_CATEGORY_TYPE%>">
		<c:set var="_curCategoryType" value="<%=curCategoryType %>"></c:set>
		<c:forEach var="categoryType" items="<%= categoryTypes %>" varStatus="count">
			<option value="${count.count - 1}"
				<c:if test="${categoryType == _curCategoryType}"> selected </c:if>
				> ${categoryType}
			</option>
		</c:forEach>		
		</select>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.num.of.item" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>
		<input type="text" name="<%=ConfigParams_RS.NUM_OF_ITEM%>" value="<%=numOfItem%>"/>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.redirect.url" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>
		<%
			String homeURL = PortalUtil.getPortalURL(request);
		%>
		<span><%=homeURL%>/</span>
		<input type="text" name="<%=ConfigParams_RS.REDIRECT_URL%>" value="<%=redirectURL%>"/>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.product.detail.page.url" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>		
		
		<span><%=homeURL%>/</span>
		<input type="text" name="<%=ConfigParams_RS.PRODUCT_DETAIL_PAGE_URL%>" value="<%=productDetailURL%>"/>
		</span>
		</div>
	</div>	
	
	<div>
	<input type="submit" id="butSubmit" name="butSubmit" value="Save"/>
	</div>
</div>
</form>