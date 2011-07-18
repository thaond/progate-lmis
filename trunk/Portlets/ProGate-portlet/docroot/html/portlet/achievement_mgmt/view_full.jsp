<%--

--%>

<style type="text/css">
   <%@ include file="/css/achie_mgmt/full_view.css" %>
</style>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/achievement_mgmt/init.jsp" %>

<%
	// renderRequest and portletConfig are objects which, accoring to the
	// portlet spec, are required to be in context. So they should just be 
	// there for you to use.
	//Locale locale = renderRequest.getLocale();
	ResourceBundle bundle = portletConfig.getResourceBundle(locale);
	
	// Get data
	achieList = AchievementUtils.getListAchievementArticles(Integer.parseInt(orgId), paging);
%>

<div class="org-profile-layout-column-21" style="float: left;">
	<div class="achiemgmt-header-full">
		<div class="achiemgmt-header-icon-full">
			<img alt="" src="<%= request.getContextPath() %>/images/achievement.png" width="32px" height="32px" />
		</div>
		
		<div class="achiemgmt-header-title-full">			
			<span class="achiemgmt-title-content-full"><%= bundle.getString("title.achievement.header") %></span>
		</div>
		<%
			if (("1".equals(viewMode)) && (isOrgAdmin)) {
		%>
		<div id="add_achievement" class="achiemgmt-header-action-full" style="display:block;">
			<a href="<%= urlFullView + "&" + RequestConst.ACTION + "=" + RequestConst.ADD_ACHIE %>">
				<span class="achiemgmt-header-text-full"><%= bundle.getString("title.action.add") %></span>
			</a>
		</div>
		<%
			}
		%>
	</div>
	<div class="achiemgmt-body-full">
		<div class="achiemgmt-content-full">
			<c:forEach var="achie"  varStatus="achieSts" items="<%= achieList %>">
				<div class="achiemgmt-content-row-full">
					<%
						if (("1".equals(viewMode)) && (isOrgAdmin)) {
					%>
					<div class="achiemgmt-content-text-full">
						<a href='<%= urlFullView + "&" + RequestConst.ACTION + "=" + RequestConst.EDIT_ACHIE + "&" + RequestConst.ACHIE_ID + "=" %>${achie.journalArticleId}' >
							<span class="achiemgmt-btn-edit">							
								<%= bundle.getString("title.action.edit") %>
							</span>
						</a>
					</div>
					<%
						}
					%>
					<div class="achiemgmt-content-image-full">									
						<img alt="" src="${achie.smallImageUrl}" onLoad='scaleImg(this, 32, 32)' style="display: none;"/>					
					</div>
					<div class="achiemgmt-row-title-full">
						<span class="achiemgmt-row-content-full">${achie.title}, ${fn:substring(achie.addInfo, 19, 23)}</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<%-- Paging --%>
	<div class="achiemgmt-footer-full">
		<%@ include file="/html/portlet/paging/paging.jsp" %>
	</div>	
</div>
