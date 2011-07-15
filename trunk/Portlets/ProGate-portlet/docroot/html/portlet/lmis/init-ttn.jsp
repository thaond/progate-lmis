<%@ taglib uri="progate-functions" prefix="functions" %>


<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>

<%@ page import="com.larion.progate.ebsc.constants.*" %>
<%@ page import="com.larion.progate.common.constants.*" %>
<%@ page import="com.larion.progate.organization.product.constants.*" %>
<%@ page import="com.larion.progate.productOverview.constants.*" %>
<%@ page import="com.larion.progate.product.constants.*" %>
<%@ page import="com.larion.progate.common.utils.*" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

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

<%@ page import="javax.servlet.http.HttpServletRequest" %>
<style type="text/css">
   <%@ include file="/css/lmis/styleOfConfig/tabbed.css" %>
   <%@ include file="/css/lmis/style-ttn.css" %>
</style>