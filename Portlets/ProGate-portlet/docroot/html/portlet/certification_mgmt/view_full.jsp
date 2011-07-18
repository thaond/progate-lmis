<%--

--%>

<style type="text/css">
   <%@ include file="/css/cert_mgmt/full_view.css" %>
</style>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/certification_mgmt/init.jsp" %>

<%
	// renderRequest and portletConfig are objects which, accoring to the
	// portlet spec, are required to be in context. So they should just be 
	// there for you to use.
	//Locale locale = renderRequest.getLocale();
	ResourceBundle bundle = portletConfig.getResourceBundle(locale);
	
	// Get data
	certList = CertificationUtils.getListCertifiedArticles(Integer.parseInt(orgId), paging);
%>

<div class="org-profile-layout-column-21" style="float: left;">
	<div class="certmgmt-header-full">
		<div class="certmgmt-header-icon-full">
			<img alt="" src="<%= request.getContextPath() %>/images/certified.jpg" width="32px" height="32px" />
		</div>
		
		<div class="certmgmt-header-title-full">			
			<span class="certmgmt-title-content-full"><%= bundle.getString("title.certified.header") %></span>
		</div>
		<%
			if (("1".equals(viewMode)) && (isOrgAdmin)) {
		%>
		<div id="add_certified" class="certmgmt-header-action-full" style="display:block;">
			<a href="<%= urlFullView + "&" + RequestConst.ACTION + "=" + RequestConst.ADD_CERT %>">
				<span class="certmgmt-header-text-full"><%= bundle.getString("title.action.add") %></span>
			</a>
		</div>
		<%
			}
		%>
	</div>
	<div class="certmgmt-body-full">
		<div class="certmgmt-content-full">
			<c:forEach var="cert"  varStatus="certSts" items="<%= certList %>">
				<div class="certmgmt-content-cell-full">
					<%
						if (("1".equals(viewMode)) && (isOrgAdmin)) {
					%>
					<div class="certmgmt-content-text-full">
						<a href='<%= urlFullView + "&" + RequestConst.ACTION + "=" + RequestConst.EDIT_CERT + "&" + RequestConst.CERT_ID + "=" %>${cert.journalArticleId}' >
							<span class="certmgmt-btn-edit">							
								<%= bundle.getString("title.action.edit") %>
							</span>
						</a>
					</div>
					<%
						}
					%>
					<div class="certmgmt-content-image-full" title="${cert.title}, ${fn:substring(cert.addInfo, 14, 24)}">									
						<img alt="" src="${cert.smallImageUrl}" onLoad='scaleImg(this, 140, 100)' style="display: none;"/>					
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<%-- Paging --%>
	<div class="certmgmt-footer-full">
		<%@ include file="/html/portlet/paging/paging.jsp" %>
	</div>	
</div>
