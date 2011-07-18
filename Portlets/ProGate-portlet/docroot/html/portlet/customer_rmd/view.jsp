<%--

--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/customer_rmd/init.jsp" %>

<%@ page import="java.util.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap" %>
<%@page import="com.larion.progate.paging.constants.PagingConst"%>

<%@ page import="com.larion.progate.customerRmd.utils.CustomerRmd"%>

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
	if (request.getAttribute(PagingConst.PAGING) != null) {
		paging = (Map<String, Object>)(request.getAttribute(PagingConst.PAGING));
	}
	
	int countCustomerRmd = (Integer) paging.get(PagingConst.TOTAL_RECORD);
	
	List<CustomerRmd> customerRmdList = new ArrayList<CustomerRmd>();
	
	//System.out.println("countCustomerRmd = " + countCustomerRmd);	
	//System.out.println("isOrgAdmin = " + isOrgAdmin);
	
	PortletPreferences preferences = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	String friendlyUrl = preferences.getValue(RequestConst.FRIENDLY_URL, CustomerRmdConst.FRIENDLY_URL);
	
	String homeUrl= PortalUtil.getPortalURL(request);
	//System.out.println("homeUrl = " + homeUrl);
	
	String urlFullView = homeUrl + "/" + friendlyUrl + "?" + RequestConst.ORG_ID + "=" + orgId 
							+ "&" + RequestConst.VIEW_MODE + "=" + viewMode;
							
	//System.out.println("urlFullView = " + urlFullView);
	
	// Redirect to customer page
	String urlViewCustomer = homeUrl + "/tochuc/gioithieu/khachhang?" + RequestConst.ORG_ID + "=" + orgId 
							+ "&" + RequestConst.VIEW_MODE + "=" + viewMode
							+ "&" + RequestConst.OBJECT_ID + "=";
		
	String urlViewPartner = homeUrl + "/tochuc/gioithieu/doitac?" + RequestConst.ORG_ID + "=" + orgId 
							+ "&" + RequestConst.VIEW_MODE + "=" + viewMode
							+ "&" + RequestConst.OBJECT_ID + "=";
			
	PortletURL portletURL = PortletURLFactoryUtil
									.create(request, "Customer_Org_WAR_ProGateportlet",
									0, PortletRequest.RENDER_PHASE);
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("struts_action", "/customer/edit");
	portletURL.setParameter(RequestConst.ORG_ID, orgId);
	portletURL.setParameter(RequestConst.VIEW_MODE, viewMode);
	portletURL.setParameter(RequestConst.OBJECT_ID, "0");
	
	int index = portletURL.toString().indexOf(StringPool.QUESTION);
	String urlEditCustomer = homeUrl + "/tochuc/gioithieu/khachhang" + portletURL.toString().substring(index);
	String urlEditPartner = homeUrl + "/tochuc/gioithieu/doitac" + portletURL.toString().substring(index);
%>


<% 
	if ((RequestConst.FULL_VIEW).equals(displayStyle)) { // Full view
		//System.out.println("Show full_view");		
%>
		<%@ include file="/html/portlet/customer_rmd/view_full.jsp" %>
<% 
	} else { // Custom view
		//System.out.println("Show normal_view");
		if (("1".equals(viewMode)) || (countCustomerRmd > 0)) {
%>
			<%@ include file="/html/portlet/customer_rmd/view_short.jsp" %>	
<% 	
		}
	}
%>

