<%--

--%>

<style type="text/css">
   <%@ include file="/css/partner_view/normal_view.css" %>
</style>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/partner_view/init.jsp" %>

<%
	// renderRequest and portletConfig are objects which, accoring to the
	// portlet spec, are required to be in context. So they should just be 
	// there for you to use.
	//Locale locale = renderRequest.getLocale();
	ResourceBundle bundle = portletConfig.getResourceBundle(locale);	
	
   	PortletURL portletURL = PortletURLFactoryUtil
									.create(request, "Customer_Org_WAR_ProGateportlet",
									0, PortletRequest.RENDER_PHASE);
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("struts_action", "/customer/add");
	portletURL.setParameter(RequestConst.ORG_ID, orgId);
	portletURL.setParameter(RequestConst.VIEW_MODE, viewMode);
	portletURL.setParameter("flag", "2");
	
	int index = portletURL.toString().indexOf(StringPool.QUESTION);
	String urlAddPartner = urlAddPartnerPrefix + portletURL.toString().substring(index);
	
	// Get data
	partnerList = PartnerViewUtils.getListPartner(Integer.parseInt(orgId), 0, (Integer)paging.get(RequestConst.TOTAL_RECORD));
	
	//System.out.println("countPartnerLoaded = " + partnerList.size());
%>

<div class="org-profile-layout-column-21" style="float: left; padding-bottom: 6px;">
	<div class="partnerView-header">
		<div class="partnerView-header-title">
			<a href="<%= urlFullView %>">
				<span class="partnerView-header-content"><%= bundle.getString("title.partner.header") %></span>
			</a>
		</div>
		
		<%
			if (("1".equals(viewMode)) && (isOrgAdmin)) {
				if (countPartner > 0) {
		%>	
				<div id="edit_partner" class="certmgmt-header-action">
					<a href="<%= urlFullView %>">
						<span class="certmgmt-header-text"><%= bundle.getString("title.action.modify") %></span>
					</a>
				</div>
		<%	} else {
		%>
				<div id="add_partner" class="certmgmt-header-action">
					<a href="<%= urlAddPartner %>">
						<span class="certmgmt-header-text"><%= bundle.getString("title.action.add") %></span>
					</a>
				</div>
		<%		}
			}
		%>
	</div>
	<%-- Paging >> Begin --%>
	<style type="text/css">
	   <%@ include file="/css/paging.css" %>
	</style>
	<%@ include file="/html/portlet/partner_view/paging_scripts.jsp" %>
	<c:if test="${totalPages > 1}">
		<div class="partnerView-paging">
			<div id="paging_summary" class="partnerView-paging-text">
				<fmt:message bundle="${msg}" key="title.paging.name2">
					<fmt:param>${currentPage}</fmt:param>
					<fmt:param>${totalPages}</fmt:param>
				</fmt:message>
			</div>		
		</div>
	</c:if>
	<%-- Paging >> End --%>
	<div class="partnerView-body">
		<div id="partnerView" class="partnerView-content">
			<%
				if (countPartner > 0) {
			%>
			<div class="partnerView-go-previous">
				<img id="previous_page" src="<%= request.getContextPath() %>/images/go_previous.png" width="36px" height="72px" onclick="prevPage()" style="padding-left: 4px; 
					<% if (currPage > 1) { %>cursor:pointer; <% } else { %>opacity: 0.6; <% } %>" />				
			</div>
			<div id="partner_content">
			<% 	for (int iCur = 0; iCur < countPage; iCur++) { %>
			<c:set value="<%= iCur * numOfItem %>" var="startIndex"/>
			<c:set value="<%= (iCur + 1) * numOfItem - 1 %>" var="endIndex"/>			
			<div id="partner_list<%= iCur + 1 %>" class="partnerView-content-row" <% if ((iCur + 1) != currPage) { %>style="display: none;" <% } %> >
				<c:forEach var="partner"  varStatus="partnerSts" items="<%= partnerList %>" begin="${startIndex}" end="${endIndex}">				
					<div class="partnerView-row-image" title="${partner.customerName}">	
						<div class="partnerView-image-logo">
							<a href="<%= urlViewPartner %>${partner.primaryKey}">							
								<img alt="" src="${partner.logo}" onLoad='scaleImg(this, 120, 80)'  style="display: none;"/>
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
			<%	} %>
			</div>
			<div class="partnerView-go-next ">
				<img id="next_page" src="<%= request.getContextPath() %>/images/go_next.png" width="36px" height="72px" onclick="nextPage()" style="padding-right: 14px; 
					<% if (currPage < countPage) { %>cursor:pointer; <% } else { %>opacity: 0.6; <% } %>" />				
			</div>			
			<%
				} else {
			%>
			<div class="partnerView-content-empty">
				<span class="partnerView-content-text-empty"><%= bundle.getString("title.partner.empty") %></span>
			</div>
			<%
				}
			%>
		</div>
	</div>
</div>
