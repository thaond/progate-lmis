<%@page import="java.text.MessageFormat"%>
<%@page import="org.apache.struts.util.MessageResources"%>
<%
/**
 * Copyright (c) [Year] [Organiation] All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="ui" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="com.larion.progate.common.constants.Request" %>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="javax.portlet.WindowState" %>

<portlet:defineObjects />

<%
 // renderRequest and portletConfig are objects which, accoring to the
 // portlet spec, are required to be in context. So they should just be 
 // there for you to use.
 Locale locale = renderRequest.getLocale();
 ResourceBundle res = portletConfig.getResourceBundle(locale);
%>

<style type="text/css">
   <%@ include file="/css/org_management/organizations.css" %>
   <%@ include file="/css/org_management/org_mnt_packaged.css" %>
   <%@ include file="/css/org_management/common_packaged.css" %>
   <%@ include file="/css/org_management/jquery.alerts.css" %>  
   <%@ include file="/css/org_management/organization_information.css" %>
   <%@ include file="/css/org_management/customize_ui.css" %>
</style>

<link rel="stylesheet" type="text/css" href="/Progate_ManageOrg-portlet/css/themes/flora/flora.all-none.css"/>
<link rel="stylesheet" type="text/css" href="/Progate_ManageOrg-portlet/css/themes/default/ui.all-none.css"/>
<script type="text/javascript" src="/Progate_ManageOrg-portlet/js/jquery.alerts.js"></script>
<script type="text/javascript" src="/Progate_ManageOrg-portlet/js/util.js"></script>