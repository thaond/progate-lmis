<%--

--%>

<style type="text/css">
   <%@ include file="/css/cert_mgmt/normal_view.css" %>
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
	certList = CertificationUtils.getListCertifiedArticles(Integer.parseInt(orgId), 0, CertificationConst.MAX_CERTIFICATION_DISPLAY);
	
	System.out.println("countCertifiedLoaded = " + certList.size());
%>

<div class="org-profile-layout-column-212" style="float: left;">
	<div class="achiemgmt-header">
		<div class="achiemgmt-header-title">
			<a href="<%= urlFullView %>">
				<span class="achiemgmt-header-content"><%= bundle.getString("title.certified.header") %></span>
			</a>
		</div>
		<%
			if (("1".equals(viewMode)) && (isOrgAdmin) && (countCert == 0)) {
		%>
		<div id="add_certified" class="certmgmt-header-action" style="display:block;">
			<a href="<%= urlFullAdd %>">
				<span class="certmgmt-header-text"><%= bundle.getString("title.action.add") %></span>			
			</a>
		</div>
		<%
			}
		%>
	</div>
	<div class="achiemgmt-body">
		<div class="achiemgmt-content">
			<c:forEach var="cert"  varStatus="certSts" items="<%= certList %>">
				<div class="certmgmt-content-cell">
					<div class="certmgmt-content-image" title="${cert.title}, ${fn:substring(cert.addInfo, 14, 24)}">						
						<img alt="" src="${cert.smallImageUrl}" onLoad='scaleImg(this, 120, 60)' style="display: none;"/>
					</div>
				</div>
			</c:forEach>
			
			<%
				if (countCert == 0) {
			%>
			<div class="certmgmt-content-empty">
				<span class="certmgmt-content-text-empty"><%= bundle.getString("certified.empty") %></span>
			</div>
			<%
				}
			%>
		</div>
		
		<div class="achiemgmt-content-bottom" >
			<%
				if (("0".equals(viewMode)) || (!isOrgAdmin)) {
					if (countCert > CertificationConst.MAX_CERTIFICATION_DISPLAY) {
			%>
			<div id="view_all" style="display:block;">
				<a href="<%= urlFullView %>">
					<span class="certmgmt-content-text"><%= bundle.getString("title.action.viewall") %></span>
				</a>
			</div>
			
			<%		}
				} else {
					if (countCert > 0) {
			%>
			
			<div id="modify_mode" style="display:block;">				
				<a href="<%= urlFullView %>">
					<span class="certmgmt-content-text"><%= bundle.getString("title.action.modify") %></span>
				</a>
			</div>
			<%
					}
				}
			%>			
		</div>
	</div>
</div>
