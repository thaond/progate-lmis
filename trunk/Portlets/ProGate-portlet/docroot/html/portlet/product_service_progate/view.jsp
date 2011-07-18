<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@page import="com.larion.progate.productServiceProGate.constants.PG_Const"%>
<%@page import="java.util.ArrayList"%>
<%@page import="larion.progate.model.ProGateJournalArticleView"%>
<%@page import="java.util.List"%>
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
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/product_service_progate/init.jsp" %>

<%
	int orgId = 0;
	int viewMode = 0;
	boolean isOrgAdmin = false;
	List<ProGateJournalArticleView> listProGateService = new ArrayList<ProGateJournalArticleView>();
	if(request.getAttribute(PG_Const.LIST_PRODUCT_PROGATE) != null){
		listProGateService = (List<ProGateJournalArticleView>)request.getAttribute(PG_Const.LIST_PRODUCT_PROGATE);
	}
	
	
	if(request.getAttribute(URLParameter_RS.ORG_ID) != null){
		orgId = (Integer)(request.getAttribute(URLParameter_RS.ORG_ID));
	}
	String orgIdString = Integer.toString(orgId);
	if(request.getAttribute(URLParameter_RS.VIEW_MODE) != null){
		viewMode = (Integer)(request.getAttribute(URLParameter_RS.VIEW_MODE));
	}
	
	if(request.getAttribute(PG_Const.IS_ORG_ADMIN) != null){
		isOrgAdmin = (Boolean)(request.getAttribute(PG_Const.IS_ORG_ADMIN));
	}
	
	if(!(!isOrgAdmin && (viewMode == 1))){
%>
<div class="org-profile-layout-column-22">
<div class="pg-common-layout">
	<div class="pg-common-header">
			<div class="pg-logo-header">
				<img alt="" src="/ProGate-portlet/images/LifeRay_icon.png" width="25px" height="25px">
			</div>
			<div class="pg-td-header">
				<span class="pg-header-content">Sản Phẩm / Dịch Vụ Của ProGate</span>
			</div>
	</div>
	<div class="pg-common-body">
		<%
		String productId="";
		String title = "" ;
		String imageUrl = "";
		String trClass = "pg-tr-content-border" ;
		
		for(int i = 0; i < listProGateService.size(); i ++){
			if(i == (listProGateService.size()-1)){
				trClass = "pg-tr-content";
			}
			title = listProGateService.get(i).getTitle();
			imageUrl = listProGateService.get(i).getBigImageUrl();
			productId=Integer.toString(listProGateService.get(i).getJournalArticleId());
			%>
		
		<div class="<%= trClass %>">
			<div class="pg-image-content">
				<a href="sanpham?orgId=<%=orgId %>&viewMode=<%=viewMode %>&productId=<%=productId%>">
					<img alt="" src="<%= imageUrl %>" onLoad='scaleImg(this, 70, 70)' style="display: none;"/>
				</a>
			</div>
			<div class="pg-td-content">	
				<span class="pg-normal-content">
					<a class="pg-content-link" href="sanpham?orgId=<%=orgId %>&viewMode=<%=viewMode %>&productId=<%=productId%>">
						<%= title %>
					</a>
				</span>
			</div>
		</div>
		
		<%
		}
		%>
		
	</div>
	
</div>		
	<%
	}
	%>		
</div>