<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.ResourceURL" %>
<%@ page import="javax.portlet.UnavailableException" %>
<%@ page import="javax.portlet.ValidatorException" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ page isELIgnored ="false" %> 

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.util.PropsValues" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.larion.progate.supportorgprofile.constants.PathSupportOrgConst"%>

<portlet:defineObjects />


<%@ page import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ page import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>
<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page import="java.util.List"%>

<%
 // renderRequest and portletConfig are objects which, accoring to the
 // portlet spec, are required to be in context. So they should just be 
 // there for you to use.
 	Locale locale = renderRequest.getLocale();
 	ResourceBundle res = portletConfig.getResourceBundle(locale);
 	
%>

<style type="text/css">
   <%@ include file="/css/support_org_profile/chatonline.css" %>
   <%@ include file="/css/support_org_profile/guilde.css" %>
   <%@ include file="/css/support_org_profile/library.css" %>
   <%@ include file="/css/support_org_profile/question.css" %>
    <%@ include file="/css/support_org_profile/homeview.css" %>
</style>
<script type="text/javascript" src='http://download.skype.com/share/skypebuttons/js/skypeCheck.js'>
</script> 

<fmt:setBundle basename="content.SupportOrgProfile_vn" var="msg"></fmt:setBundle>