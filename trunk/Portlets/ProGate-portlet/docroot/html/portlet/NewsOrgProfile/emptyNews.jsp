<%
/**
 * Copyright (c) 2009 Robisoft, Inc. All rights reserved.
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

<%@ include file="init.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored ="false" %>
<%
	String orgId = (String)renderRequest.getAttribute("orgId");
	renderRequest.setAttribute("orgId", orgId);
	String viewMode = (String)renderRequest.getAttribute("viewMode");
	renderRequest.setAttribute("viewMode", viewMode);
%>

<div class="org-profile-layout-column-212">
	
		<div class="pg-common-layout-news-org">
			
			<!-- Header -->	
			<div class="pg-common-header-news-org">
			
				<div class="pg-td-header-news-org">
					<span class="pg-header-content-news-org"><%=res.getString("title")%></span>
				</div>
				 <c:if test="${isOrgAdmin eq true}">
					<div class="add-news" style="padding: 7px 7px 7px 0;">
						<a class="pg-content-link-news-org" style="color:white ;" href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
												         	<portlet:param name="struts_action" value="/NewsOrgProfile/addNews"/>
												         	<portlet:param name="orgId" value="${orgId}"/>
												         	<portlet:param name="viewMode" value="${viewMode}"/>
												         </portlet:renderURL>' >
							<%=res.getString("addNews")%>
						</a>
					</div>
				 </c:if>
			</div>	
					    
			<!-- Content -->	
			<div class="pg-common-body-news-org">
				<div class="content-welcome">
					<span class="pg-normal-content-news-org" style="color: #A6A6A6;"><%=res.getString("welcome")%></span>		
				</div>
			</div>
		</div>
	
</div>
	
