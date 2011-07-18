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
<%@ page import="java.io.IOException"%>


<style>
table {
 border-collapse: separate;
 border-spacing: 1px;
}

</style>
<div class="org-profile-layout-column-22">
	<div class="layout-information-org">
		<div class="header-information-org">
				<div class="td-header-information-org">
					<span class="header-content-information-org"> <%=res.getString("title")%></span>
				</div>
		</div>
				<div>
					<table class="content-information-org" style="margin-top: 0px;">
						<%
							larion.progate.model.Organization org = (larion.progate.model.Organization)renderRequest.getAttribute("org");					
							boolean isOrgAdmin = false;
							
							try {
								isOrgAdmin = (Boolean)renderRequest.getAttribute("isOrgAdmin");
			                } catch (Exception e) {
			                    // TODO: handle exception
			                }
			                
							
							
					        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
							Date date = org.getOrgFounded();
							if (date != null && !date.equals("")){
								String dateFormate = (String)sdf.format(org.getOrgFounded().getTime());							
						%>
								<tr>
									<td width="40%" style="padding-left: 10px;padding-top: 20px;padding-bottom: 10px;"><%=res.getString("establishDate")%></td>
									<td style="padding-top: 20px;padding-bottom: 10px;">: <%= dateFormate%></td>
								</tr>
						
						<%
							}
							String orgType = org.getOrgType();
							if (orgType != null && !orgType.equals("")){
								if (orgType.length() > 25){
									orgType = orgType.substring(0, 22) + "...";
								}
						%>
								<tr>
									<td class="odd_column"><%=res.getString("typeOfActivity")%></td>
									<td class="even_column">: <%= orgType%></td>
								</tr>
								<%  } %>
						
						<%
							String orgSize = String.valueOf(org.getOrgSize());
							if (orgSize != null && !orgSize.equals("0")){
								%>
								<tr>
									<td class="odd_column"><%=res.getString("quantityOfMembers")%></td>
									<td class="even_column">: <%= orgSize%></td>
								</tr>
								<% } %>
						<%
							String founder = org.getFounderList();
							if (founder != null && !founder.equals("")){	
								if (founder.length() > 25){
									founder = founder.substring(0, 22) + "...";
								}					
						%>
						<tr>
							<td class="odd_column"><%=res.getString("founder")%></td>
							<td class="even_column">: <%= founder%></td>
						</tr>
						<% } %>
						
						<%
							String website = org.getWebsite();
							if (website != null && !website.equals("")){
								String url = website;
								if (url.startsWith("http://", 0)){
								}else{
									url = "http://".concat(url);
								}
								if (website.length() > 25){
									website = website.substring(0, 22) + "...";
								}
								 
						%>
						<tr>
							<td class="odd_column"><%=res.getString("website")%></td>
							<td class="even_column">:<a href="<%=url%>" target="_blank"> <%= website%></a></td>
						</tr>
						<% } 
						
							if (isOrgAdmin){
						%>
					
						
						<tr>
							<td  colspan="2" class="repair">					
								<a href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
								         	<portlet:param name="action" value="detailInformation" />
								         	<portlet:param name="orgId" value="${orgId}" />
								         	<portlet:param name="viewMode" value="${viewMode}" />
								         </portlet:renderURL>'>
							        <%= res.getString("repair")%>
								</a>
							</td>						
						</tr>	
							<% }%>	
					</table>
				</div>			
			</div>  
	</div>
</div>
	
