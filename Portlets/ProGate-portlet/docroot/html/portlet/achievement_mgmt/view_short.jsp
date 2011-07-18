<%--

--%>

<style type="text/css">
   <%@ include file="/css/achie_mgmt/normal_view.css" %>
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
	achieList = AchievementUtils.getListAchievementArticles(Integer.parseInt(orgId), 0, AchievementConst.MAX_ACHIEVEMENT_DISPLAY);
	
	//System.out.println("countAchieveLoaded = " + achieList.size());
%>

<div class="org-profile-layout-column-211" style="float: left;">
	<div class="achiemgmt-header">
		<div class="achiemgmt-header-title">
			<a href="<%= urlFullView %>">
				<span class="achiemgmt-header-content"><%= bundle.getString("title.achievement.header") %></span>
			</a>
		</div>
		<%
			if (("1".equals(viewMode)) && (isOrgAdmin) && (countAchie == 0)) {
		%>
		<div id="add_achievement" class="achiemgmt-header-action" style="display:block;">
			<a href="<%= urlFullAdd %>">
				<span class="achiemgmt-header-text"><%= bundle.getString("title.action.add") %></span>			
			</a>
		</div>
		<%
			}
		%>
	</div>
	<div class="achiemgmt-body">
		<div class="achiemgmt-content">
			<c:forEach var="achie"  varStatus="achieSts" items="<%= achieList %>">
				<div class="achiemgmt-content-cell">
					<div class="achiemgmt-content-image">						
						<img alt="" src="${achie.smallImageUrl}" onLoad='scaleImg(this, 32, 32)' style="display: none;"/>
					</div>
					<div class="achiemgmt-row-title">
						<span class="achiemgmt-row-content">${achie.title}, ${fn:substring(achie.addInfo, 19, 23)}</span>
					</div>
				</div>
			</c:forEach>
			
			<%
				if (countAchie == 0) {
			%>
			<div class="achiemgmt-content-empty">
				<span class="achiemgmt-content-text-empty"><%= bundle.getString("achievement.empty") %></span>
			</div>
			<%
				}
			%>
		</div>
		
		<div style="float:left; width:100%; padding-top:2px">
		</div>
		
		<div class="achiemgmt-content-bottom">
			<%
				if (("0".equals(viewMode)) || (!isOrgAdmin)) {
					if (countAchie > AchievementConst.MAX_ACHIEVEMENT_DISPLAY) {
			%>
			<div id="view_all" style="display:block;">
				<a href="<%= urlFullView %>">
					<span class="achiemgmt-content-text"><%= bundle.getString("title.action.viewall") %></span>
				</a>
			</div>
			
			<%		}
				} else {
					if (countAchie > 0) {
			%>
			
			<div id="modify_mode" style="display:block;">				
				<a href="<%= urlFullView %>">
					<span class="achiemgmt-content-text"><%= bundle.getString("title.action.modify") %></span>
				</a>
			</div>
			<%
					}
				}
			%>			
		</div>
	</div>
</div>
