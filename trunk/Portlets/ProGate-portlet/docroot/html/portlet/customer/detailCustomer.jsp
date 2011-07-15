<%@page import="larion.progate.service.ProGateOrgCustomerLocalServiceUtil"%>
<%@page import="larion.progate.model.ProGateOrgCustomer"%>
<%@page import="larion.progate.model.ProGateOrgCustomerRepresenter"%>
<%@page import="larion.progate.service.ProGateOrgCustomerRepresenterLocalServiceUtil"%>
<%
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
%>

<%@ include file="/html/portlet/customer/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//int objectId = 0;
//	int flag = 0;
	//List<Organization> listObject = new ArrayList<Organization>();
	
	//if(request.getParameter(Customer_Const.OBJECT_ID) != null){
	//	objectId = Integer.parseInt(request.getParameter(Customer_Const.OBJECT_ID));
	//}
	//if(request.getParameter(Customer_Const.FLAG) != null){
	//	flag = Integer.parseInt(request.getParameter(Customer_Const.FLAG));
	//}
	
	System.out.println("Get info of OrgCustomer, id = " + objectId);
	
	ProGateOrgCustomer cusObject = ProGateOrgCustomerLocalServiceUtil.getProGateOrgCustomer(objectId);
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
		<% 	
			if(isRole && (viewMode == 1)) { 
		%>
		<div class="tg-header-td-right">
			<img src="/ProGate-portlet/images/write.png" alt="Sửa" width="23px" height="18px">
			<a href="<portlet:renderURL windowState='<%=WindowState.MAXIMIZED.toString() %>'>
				         <portlet:param name='struts_action' value='/customer/edit'></portlet:param>
						 <portlet:param name='<%= URLParameter_RS.ORG_ID %>' value='<%= orgIdString %>'></portlet:param>
				         <portlet:param name='<%= Customer_Const.VIEW_MODE %>' value='<%= Integer.toString(viewMode) %>'></portlet:param>
				         <portlet:param name='<%= Customer_Const.OBJECT_ID %>' value='<%= Integer.toString(cusObject.getPrimaryKey()) %>'></portlet:param>
			         </portlet:renderURL>" style="text-decoration: none">
				<span class="tg-content-blue">Sửa</span>
			</a>
		</div>
		<% 
			} 
		%>
	</div>
	
	<%
	if(cusObject != null){		
	%>
		<div class="cus-tr-content">
				<div class="cus-image" align="center">
					<a href="">
						<img alt="" src="<%=cusObject.getLogo()  %>" onLoad='scaleImg(this, 145, 100)' style="display: none;"/>
					</a>
				</div>
				<div class="cus-content-des">	
					<div style="padding-left: 5px">
						<a class="pg-content-link" href="">
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
				</div>
		</div>
		<% 			
		int count = ProGateOrgCustomerRepresenterLocalServiceUtil.countListCustRepresenterByCustId(cusObject.getPrimaryKey());
		List<ProGateOrgCustomerRepresenter> listOrgFounder = ProGateOrgCustomerRepresenterLocalServiceUtil.getListCustRepresenterByCustId(cusObject.getPrimaryKey(),0,count,false);	
		for(int i = 0; i < listOrgFounder.size(); i ++){
			ProGateOrgCustomerRepresenter founder = listOrgFounder.get(i);
		%>			
			<div style="padding-left: 5px; padding-bottom: 10px; float: left width: 620px;" class="cus-content-align">
				<span class="pg-normal-content">
					<span style="font-weight: bold;">Nhận xét của khách hàng</span>: "<i><%= founder.getDescription() %></i>"
				</span>
			</div>
					
			<div style="float: right; padding-bottom: 10px; padding-right: 4px; width: 620px;" class="cus-content-align">
				<span class="pg-normal-content" style="float: right;">
					(<%= founder.getFirstName() %> - <%= founder.getRole() %>)
				</span>
			</div>					
		<%
		}
		%>
					
		<div style="padding-left: 5px; float: left;" class="cus-content-align">
			<span class="pg-normal-content">
				<%= cusObject.getDescription() %>
			</span>
		</div>					
	<%
	} 
	%>	
	<br>
	<br>
</div>
	<%@ include file="/html/portlet/customer/relativeCustomer.jsp" %>
</div>
	