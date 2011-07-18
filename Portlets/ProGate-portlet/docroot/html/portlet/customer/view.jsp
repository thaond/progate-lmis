<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap" %>
<%@page import="com.larion.progate.paging.constants.PagingConst"%>

<%@page import="larion.progate.model.ProGateOrgCustomer"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.larion.progate.customer.util.CustomerUtil"%>
<%--
/**
 * Copyright (c) [Year] [Organization] All rights reserved.
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
--%>

<%@ include file="/html/portlet/customer/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@page import="com.larion.progate.paging.constants.PagingConst"%>

<%
	int orgId = 0;
	int objectId = 0;
	boolean isRole = false;
	int viewMode = 0;
	String url ="";
	int flag = 0;
	String type = "";
	String detailCusUrl = "";
	List<ProGateOrgCustomer> listObject = new ArrayList<ProGateOrgCustomer>();
	
	if(request.getAttribute(URLParameter_RS.ORG_ID) != null){
		orgId = (Integer)request.getAttribute(URLParameter_RS.ORG_ID);
	}
	String orgIdString = Integer.toString(orgId);
	
	if (request.getAttribute(Customer_Const.OBJECT_ID) != null) {
		objectId = (Integer)request.getAttribute(Customer_Const.OBJECT_ID);
	}
	
	//System.out.println("getAttribute: objectId = " + objectId);	
	
	if (request.getParameter(Customer_Const.OBJECT_ID) != null) {
		objectId = Integer.parseInt(request.getParameter(Customer_Const.OBJECT_ID));
	}
	
	//System.out.println("getParameter: objectId = " + objectId);
	
	if(request.getAttribute(Customer_Const.IS_ADMIN_ROLE) != null){
		isRole = (Boolean)(request.getAttribute(Customer_Const.IS_ADMIN_ROLE));
	}
	
	if(request.getAttribute(URLParameter_RS.VIEW_MODE) != null){
		viewMode = (Integer)request.getAttribute(URLParameter_RS.VIEW_MODE);
	}
	
	if(request.getAttribute(Customer_Const.URL) != null){
		url = (String)request.getAttribute(Customer_Const.URL);
	}
	if(request.getAttribute(Customer_Const.DETAIL_CUS_URL) != null){
		detailCusUrl = (String)request.getAttribute(Customer_Const.DETAIL_CUS_URL);
	}
	
	if(request.getAttribute(Customer_Const.FLAG) != null){
		flag = (Integer)(request.getAttribute(Customer_Const.FLAG));
	}
	if(request.getAttribute(Customer_Const.LIST_OBJECT) != null){
		listObject = (List<ProGateOrgCustomer>)(request.getAttribute(Customer_Const.LIST_OBJECT));
	}

	Map<String, Object> paging = new HashMap<String, Object>();
	if (request.getAttribute(PagingConst.PAGING) != null) {
		paging = (Map<String, Object>)(request.getAttribute(PagingConst.PAGING));
	}
	
	String detailURL = url + StringPool.AMPERSAND + Customer_Const.OBJECT_ID + StringPool.EQUAL;
	
%>
<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery(".customerDescription img").each(function(){
			scaleImg(this, 430, 350);
	});
});	
</script>	
<%
	if(objectId == 0){
%>
<div class="org-profile-layout-column-21">
<div class="tq-layout-common">
	<div class="tq-header-layout">
		<div class="tq-header-left">
			<%if(flag == 1){ %>
				<div class="tg-header-td-img-left">
					<img src="/ProGate-portlet/images/khachhang.png" alt="Khách Hàng" width="25px" height="20px">
				</div>
				<div class="tg-header-td-left">
					<span class="tg-content-orange">Khách Hàng</span>
				</div>
			<%}else{ %>
				<div class="tg-header-td-img-left">
					<img src="/ProGate-portlet/images/doitac.png" alt="Đối Tác" width="25px" height="20px">
				</div>
				<div class="tg-header-td-left">
					<span class="tg-content-orange">Đối Tác</span>
				</div>
			<% } %>	
		</div>
		<div class="tq-header-right">
			<%
			if(isRole && (viewMode == 1)){
			%>
				<div class="tg-header-td-right">
					<a href="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
						         <portlet:param name='struts_action' value='/customer/add'></portlet:param>
						         <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= orgIdString %>'></portlet:param>
						         <portlet:param name='<%=Customer_Const.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'></portlet:param>
						         <portlet:param name='<%=Customer_Const.FLAG  %>' value='<%= Integer.toString(flag) %>'></portlet:param>
					         </portlet:renderURL>" style="text-decoration: none">
						<span class="tg-content-blue"> + Thêm</span>
					</a>
				</div>
			
			<%	
			}
			%>
		</div>
	</div>
	<br>
	<br>
	
	<%
		if(listObject.size() > 0){
			for(int i = 0; i < listObject.size(); i ++){
				ProGateOrgCustomer cusObject = listObject.get(i);
	%>
			<c:set value="<%= cusObject.getDescription() %>" var="description" />			
			<c:choose>
				<c:when test="${fn:length(description) > 500}">
					<c:set value="${fn:substring(description, 480, 500)}" var="strTemp" />
					<c:set value="${fn:indexOf(strTemp, ' ')}" var="iTemp" />
					<c:set value="${fn:substring(description, 0, 480 + iTemp)}..." var="descTruncate" />
				</c:when>				
				<c:otherwise>
					<c:set value="${description}" var="descTruncate" />
				</c:otherwise>
			</c:choose>
			<div class="cus-tr-content">
				<div class="cus-image">
					<a href="<%= detailURL + cusObject.getPrimaryKey() %>">
						<img alt="" src="<%=cusObject.getLogo()  %>" onLoad='scaleImg(this, 145, 100)' style="display: none;"/>
					</a>
				</div>
				<div class="cus-content-des">	
					<div style="padding-left: 5px">
						<% 	
							if(isRole && (viewMode == 1)) { 
						%>
						<img src="/ProGate-portlet/images/write.png" alt="Sửa" width="23px" height="18px">
						<a href="<portlet:renderURL windowState='<%=WindowState.MAXIMIZED.toString() %>'>
							         <portlet:param name='struts_action' value='/customer/edit'></portlet:param>
									 <portlet:param name='<%= URLParameter_RS.ORG_ID %>' value='<%= orgIdString %>'></portlet:param>
							         <portlet:param name='<%= Customer_Const.VIEW_MODE %>' value='<%= Integer.toString(viewMode) %>'></portlet:param>
							         <portlet:param name='<%= Customer_Const.OBJECT_ID %>' value='<%= Integer.toString(cusObject.getPrimaryKey()) %>'></portlet:param>
						         </portlet:renderURL>" style="text-decoration: none">
							<span class="tg-content-blue">Sửa</span>
						</a>
						<% 
							} 
						%>
							<a class="pg-content-link" href="<%= detailURL + cusObject.getPrimaryKey() %>">
								<span class="cus-content-title"">
									<%= cusObject.getCustomerName() %>
								</span>
							</a>
					</div>	
					<div style="padding-left: 5px">
							<a class="pg-content-link" href="">
								<span class="cus-content-normal">
									<%= cusObject.getWebsite() %>
								</span>
							</a>
					</div>
					<div style="padding-left: 5px; float: left; width: 460px;">
						<span class="pg-normal-content customerDescription">
							<c:out value="${descTruncate}" escapeXml="false"></c:out>
						</span>
					</div>
					<div style="width: 460px; float: left;">
					 	<a href="<%= detailURL + cusObject.getPrimaryKey() %>" style="text-decoration: none">
							<span class="tg-content-blue" style="float: right;">Xem Thêm >></span>
						</a>
					</div>
				</div>
			</div>
			<%
				}
			%>
			<%-- Paging --%>
			<div class="customer-paging">
				<%@ include file="/html/portlet/paging/paging.jsp" %>
			</div>
		<%
		} 
		%>	
</div>
</div>

<% } else { 		
%>
	<%@ include file="/html/portlet/customer/detailCustomer.jsp" %>	
<%
	}
%>
