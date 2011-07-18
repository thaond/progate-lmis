<%--

--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/achievement_mgmt/init.jsp" %>

<%@ page import="java.util.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap" %>
<%@page import="com.larion.progate.paging.constants.PagingConst"%>

<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page import="larion.progate.service.ProGateJournalArticleLocalServiceUtil" %>
<%@ page import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil" %>
<%@ page import="larion.progate.service.persistence.ProGateJournalArticleUtil" %>

<%
	// renderRequest and portletConfig are objects which, accoring to the
	// portlet spec, are required to be in context. So they should just be 
	// there for you to use.
	//Locale locale = renderRequest.getLocale();
	//ResourceBundle bundle = portletConfig.getResourceBundle(locale);
%>

<%
	String orgId = "";
	String viewMode = "0";
	String displayStyle = "";
	boolean isOrgAdmin = false;
	String actMode = "";
	String achieId = "";
	
	if (request.getAttribute(RequestConst.ORG_ID) != null) {
		orgId = (String)request.getAttribute(RequestConst.ORG_ID);
	}
	
	if (request.getAttribute(RequestConst.VIEW_MODE) != null) {
		viewMode = (String)request.getAttribute(RequestConst.VIEW_MODE);
	}
	
	if (request.getAttribute(RequestConst.DISPLAY_MODE) != null) {
		displayStyle = (String)request.getAttribute(RequestConst.DISPLAY_MODE);
	}
	
	if (request.getAttribute(RequestConst.ACTION) != null) {
		actMode = (String)request.getAttribute(RequestConst.ACTION);
	}
	
	if (request.getAttribute(RequestConst.ACHIE_ID) != null) {
		achieId = (String)request.getAttribute(RequestConst.ACHIE_ID);
	}
	
	if (request.getAttribute(RequestConst.IS_ORG_ADMIN) != null) {
		isOrgAdmin = (Boolean)(request.getAttribute(RequestConst.IS_ORG_ADMIN));
	}
	
	Map<String, Object> paging = new HashMap<String, Object>();
	if (request.getAttribute(PagingConst.PAGING) != null) {
		paging = (Map<String, Object>)(request.getAttribute(PagingConst.PAGING));
	}
	
	int countAchie = (Integer) paging.get(PagingConst.TOTAL_RECORD);
	
	List<ProGateJournalArticle> achieList = null;
	ProGateJournalArticle achieItem = null;	
	
	//System.out.println("countAchie = " + countAchie);	
	//System.out.println("isOrgAdmin = " + isOrgAdmin);
	//System.out.println("actMode = " + actMode);
	
	PortletPreferences preferences = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	String friendlyUrl = preferences.getValue(RequestConst.FRIENDLY_URL, AchievementConst.FRIENDLY_URL);
	
	String homeUrl= PortalUtil.getPortalURL(request);
	//System.out.println("homeUrl = " + homeUrl);
	
	String urlFullView = homeUrl + "/" + friendlyUrl + "?" + RequestConst.ORG_ID + "=" + orgId 
							+ "&" + RequestConst.VIEW_MODE + "=" + viewMode;
	
	String urlFullAdd = urlFullView + "&" + RequestConst.ACTION + "=" + RequestConst.ADD_ACHIE;
	
	//System.out.println("urlFullView = " + urlFullView);
%>


<% 
	if ((RequestConst.FULL_VIEW).equals(displayStyle)) { // Full view
		//System.out.println("Show full_view");
		if ((isOrgAdmin) 
			&& (((RequestConst.ADD_ACHIE).equals(actMode)) 
				|| ((RequestConst.EDIT_ACHIE).equals(actMode)))) { // Add achievement or Edit achievement
%>
			<%@ include file="/html/portlet/achievement_mgmt/achievementForm.jsp" %>
		<% } else {
		%>
			<%@ include file="/html/portlet/achievement_mgmt/view_full.jsp" %>
<% }} else { // Custom view
		//System.out.println("Show normal_view");
		if (("1".equals(viewMode)) || (countAchie > 0)) {
%>
			<%@ include file="/html/portlet/achievement_mgmt/view_short.jsp" %>
	
<% 	
		}
	}
%>

