<%--

--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/partner_view/init.jsp" %>

<%@ page import="java.util.*"%>

<%@ page import="larion.progate.model.ProGateOrgCustomer"%>

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
	
	if (request.getAttribute(RequestConst.ORG_ID) != null) {
		orgId = (String)request.getAttribute(RequestConst.ORG_ID);
	}
	
	if (request.getAttribute(RequestConst.VIEW_MODE) != null) {
		viewMode = (String)request.getAttribute(RequestConst.VIEW_MODE);
	}
	
	if (request.getAttribute(RequestConst.DISPLAY_MODE) != null) {
		displayStyle = (String)request.getAttribute(RequestConst.DISPLAY_MODE);
	}
		
	if (request.getAttribute(RequestConst.IS_ORG_ADMIN) != null) {
		isOrgAdmin = (Boolean)(request.getAttribute(RequestConst.IS_ORG_ADMIN));
	}
	
	Map<String, Object> paging = new HashMap<String, Object>();
	if (request.getAttribute(RequestConst.PAGING) != null) {
		paging = (Map<String, Object>)(request.getAttribute(RequestConst.PAGING));
	}
	
	int countPartner = (Integer) paging.get(RequestConst.TOTAL_RECORD);
	
	List<ProGateOrgCustomer> partnerList = new ArrayList<ProGateOrgCustomer>();
	
	//System.out.println("countPartner = " + countPartner);	
	//System.out.println("isOrgAdmin = " + isOrgAdmin);
	
	PortletPreferences preferences = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	String friendlyUrl = preferences.getValue(RequestConst.FRIENDLY_URL, PartnerViewConst.FRIENDLY_URL);
	
	String homeUrl= PortalUtil.getPortalURL(request);
	//System.out.println("homeUrl = " + homeUrl);
	
	String urlFullView = homeUrl + "/" + friendlyUrl + "?" + RequestConst.ORG_ID + "=" + orgId 
							+ "&" + RequestConst.VIEW_MODE + "=" + viewMode;
							
	//System.out.println("urlFullView = " + urlFullView);
	
	// Redirect to PARTNER page
	String urlViewPartner = homeUrl + "/tochuc/gioithieu/doitac?" + RequestConst.ORG_ID + "=" + orgId 
							+ "&" + RequestConst.VIEW_MODE + "=" + viewMode
							+ "&" + RequestConst.OBJECT_ID + "=";
	
	String urlAddPartnerPrefix = homeUrl + "/tochuc/gioithieu/doitac?";
%>

<% 
	//System.out.println("Show normal_view");
	if (("1".equals(viewMode)) || (countPartner > 0)) {
%>
		<%@ include file="/html/portlet/partner_view/view_short.jsp" %>	
<% 	
	}
%>

