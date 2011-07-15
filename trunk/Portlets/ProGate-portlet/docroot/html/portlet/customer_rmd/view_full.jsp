<%--

--%>

<style type="text/css">
   <%@ include file="/css/customer_talk/full_view.css" %>
</style>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/customer_rmd/init.jsp" %>

<%
	// renderRequest and portletConfig are objects which, accoring to the
	// portlet spec, are required to be in context. So they should just be 
	// there for you to use.
	//Locale locale = renderRequest.getLocale();
	ResourceBundle bundle = portletConfig.getResourceBundle(locale);
	
	// Get data
	customerRmdList = CustomerRmdUtils.getListCustomerRmd(Integer.parseInt(orgId), paging);
	
	System.out.println("countCustomerRmdLoaded = " + customerRmdList.size());
%>

<div class="org-profile-layout-column-21" style="float: left;">
	<div class="customerRmd-header-full">
		<div class="customerRmd-header-icon-full">
			<img alt="" src="<%= request.getContextPath() %>/images/customer_talk.png" width="32px" height="32px" />
		</div>
		
		<div class="customerRmd-header-title-full">			
			<span class="customerRmd-title-content-full"><%= bundle.getString("title.customerRmd.header") %></span>
		</div>
	</div>
	<div class="customerRmd-body-full">
		<div class="customerRmd-content-full">
			<c:set value="<%= customerRmdList.size() %>" var="totalRrd"/>
			<c:forEach var="customerRmd"  varStatus="customerRmdSts" items="<%= customerRmdList %>">
				<div class="customerRmd-content-row">
					<div class="customerRmd-row-image">	
						<div class="customerRmd-image-logo">
							<a href="${customerRmd.customerWebsite}">
								<img alt="" src="${customerRmd.customerLogo}" onLoad='scaleImg(this, 120, 80)' style="display: none;"/>
							</a>
						</div>
					</div>
					<div class="customerRmd-row-text">
						<%
							if (("1".equals(viewMode)) && (isOrgAdmin)) {
						%>
							<c:if test="${customerRmd.customerType < 2}">
								<a href="<%= urlEditCustomer %>${customerRmd.customerId}" style="color: #30A1BE;">
									<span class="customerRmd-btn-edit">							
										<%= bundle.getString("title.action.edit") %>
									</span>
								</a>
							</c:if>
							<c:if test="${customerRmd.customerType == 2}">
								<a href="<%= urlEditPartner %>${customerRmd.customerId}" style="color: #30A1BE;">
									<span class="customerRmd-btn-edit">							
										<%= bundle.getString("title.action.edit") %>
									</span>
								</a>
							</c:if>
						<%	}
						%>
						
						<c:if test="${customerRmd.customerType < 2}">
							<a href="<%= urlViewCustomer %>${customerRmd.customerId}">
								<span class="customerRmd-text-recommendation">							
									<i>"${customerRmd.recommenderDescription}"</i>
								</span>
								<br />
							</a>
						</c:if>
						<c:if test="${customerRmd.customerType == 2}">
							<a href="<%= urlViewPartner %>${customerRmd.customerId}">
								<span class="customerRmd-text-recommendation">							
									<i>"${customerRmd.recommenderDescription}"</i>
								</span>
								<br />
							</a>
						</c:if>
						
						<span class="customerRmd-text-recommender">							
							<b>${customerRmd.recommenderName}</b> <br />
							${customerRmd.recommenderRole}, ${customerRmd.customerName} 
						</span>
					</div>
				</div>
				
				<c:if test="${customerRmdSts.count < totalRrd}">
					<div class="customerRmd-row-line">
					</div>
				</c:if>				
			</c:forEach>
		</div>
	</div>
	
	<%-- Paging --%>
	<div class="customerRmd-footer-full">
		<%@ include file="/html/portlet/paging/paging.jsp" %>
	</div>	
</div>
