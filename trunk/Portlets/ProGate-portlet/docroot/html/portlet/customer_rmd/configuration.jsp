<%@ include file="/html/portlet/customer_rmd/init.jsp" %>

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

<%
	//Get list of display style. Read from portal-ext.properties 
	PortletPreferences preferences = renderRequest.getPreferences();		
	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	String curDisplayStyle = preferences.getValue(RequestConst.DISPLAY_STYLE, null);
	String numOfItem = preferences.getValue(RequestConst.NUM_OF_ITEM, Integer.toString(RequestConst.INCREMENT_CONST));
	String friendlyUrl = preferences.getValue(RequestConst.FRIENDLY_URL, CustomerRmdConst.FRIENDLY_URL);
%>

<fmt:setBundle basename="content.CustomerRmd_vn" var="msg"></fmt:setBundle>

<form action="<liferay-portlet:actionURL portletConfiguration='true'/>" method="post" name="frmConfig">
	<div style="width: 40%;">
		<div class="config-frm-row">
			<div class="config-frm-row-left">
				<span><fmt:message bundle="${msg}" key="title.config.display"/></span>
			</div>
			<div class="config-frm-row-right">
				<c:set value="<%= curDisplayStyle %>" var="currentDisplayStyle"/>				
				<select name="<%=RequestConst.DISPLAY_STYLE %>">
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
				<span><fmt:message bundle="${msg}" key="title.config.friendlyUrl" /></span>
			</div>
			
			<div class="config-frm-row-right">
				<span><input type="text" name="<%= RequestConst.FRIENDLY_URL %>" value="<%= friendlyUrl %>"/></span>
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
			<div class="config-frm-row-center">
				<input type="submit" id="butSubmit" name="butSubmit" value="Save"/>
			</div>
		</div>
	</div>
</form>
