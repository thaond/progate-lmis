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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.util.PropsValues" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="larion.progate.model.Organization"%>
<%@ page import="larion.progate.service.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<div class="pg-common-layout">
	<div class="pg-common-header">
			<div class="pg-td-header-information-org">
				<span class="pg-header-content">
				    <%=res.getString("title")%>
				  </span>
				</div>
			</div>
			<div>				
				<table width="100%"  class="content-information-org" style="margin-top:0px; border-collapse: separate;border-spacing: 15px;">
					<tr>
						<td>
							Bạn hãy mô tả vài thông tin về công ty / tổ chức của bạn.
						</td>
					</tr>
					<% 
					boolean isOrgAdmin = (Boolean)renderRequest.getAttribute("isOrgAdmin");
					if (isOrgAdmin){
					%>
					<tr>
						<td  colspan="2" class="repair">					
							<a href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
							         	<portlet:param name="action" value="detailInformation" />
							         	<portlet:param name="orgId" value="${orgId}" />
							         </portlet:renderURL>'>
						        <%= res.getString("repair")%>
							</a>
						</td>						
					</tr>	
					<%}%>						
				</table>
			</div>			
		</div>  
</div>
  

	
