<%@page import="com.larion.progate.organization.product.constants.JournalArticle_RS"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.larion.progate.productServiceOrg.constants.PG_Org_Const"%>
<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
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
<%@ include file="/html/portlet/product_service_org/init.jsp" %>

<%@ page import="com.larion.progate.productServiceOrg.constants.PG_Org_Const"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<%
	int orgId = 0;
	int viewMode = 0;
	boolean isOrgAdmin = false;
	List<ProGateJournalArticleView> listProGateService = null;
	if(request.getAttribute(PG_Org_Const.LIST_PRODUCT_ORG) != null){
		listProGateService = (List<ProGateJournalArticleView>)request.getAttribute(PG_Org_Const.LIST_PRODUCT_ORG);
	}
	
	if (listProGateService == null) {
		listProGateService = new ArrayList<ProGateJournalArticleView>();
	}
	
	if(request.getAttribute(URLParameter_RS.ORG_ID) != null){
		orgId = (Integer)(request.getAttribute(URLParameter_RS.ORG_ID));
	}
	String orgIdString = Integer.toString(orgId);
	if(request.getAttribute(URLParameter_RS.VIEW_MODE) != null){
		viewMode = (Integer)(request.getAttribute(URLParameter_RS.VIEW_MODE));
	}
	
	if(request.getAttribute(PG_Org_Const.IS_ORG_ADMIN) != null){
		isOrgAdmin = (Boolean)(request.getAttribute(PG_Org_Const.IS_ORG_ADMIN));
	}
	
	// Redirect to customer page
	String homeUrl= PortalUtil.getPortalURL(request);
	
	String urlProduct = homeUrl + "/tochuc/sanpham?" + PG_Org_Const.ORG_ID + "=" + orgId 
						+ "&" + PG_Org_Const.VIEW_MODE + "=" + viewMode;
	
	//String urlViewProduct = homeUrl + "/tochuc/sanpham?" + PG_Org_Const.ORG_ID + "=" + orgId 
	//						+ "&" + PG_Org_Const.VIEW_MODE + "=0"
	//						+ "&" + PG_Org_Const.PRODUCT_ID + "=";
	
	//String urlEditProduct = homeUrl + "/tochuc/sanpham?" + PG_Org_Const.ORG_ID + "=" + orgId 
	//						+ "&" + PG_Org_Const.VIEW_MODE + "=1"
	//						+ "&" + PG_Org_Const.PRODUCT_ID + "=";
	
	//String urlAddProduct = homeUrl + "/tochuc/sanpham?" + PG_Org_Const.ORG_ID + "=" + orgId 
	//						+ "&" + PG_Org_Const.VIEW_MODE + "=1"
	//						+ "&" + Constants.CMD + "=" + Constants.ADD;
	
	
	
	String addressPortletURL = PortalUtil.getPortalURL(request) + StringPool.SLASH + "tochuc/sanpham";
	
	// Build addProductURL
	LiferayPortletURL portletURL = PortletURLFactoryUtil
	.create(request, "ProGate_ProductService_WAR_ProGateportlet",
	0, PortletRequest.RENDER_PHASE);
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("action", "handleProduct");
	portletURL.setParameter(URLParameter_RS.ORG_ID, String.valueOf(orgId));
	portletURL.setParameter(URLParameter_RS.VIEW_MODE, String.valueOf(viewMode));
	portletURL.setParameter(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, PortalUtil.getCurrentURL(renderRequest));
	portletURL.setParameter(Constants.CMD, Constants.ADD);

	int pos = portletURL.toString().indexOf(StringPool.QUESTION);
	String addPortletURL = portletURL.toString().substring(pos);
	String addProductUrl = addressPortletURL + addPortletURL;

	
	
	String title = "" ;
	String imageUrl = "";
	int productId = 0;
	
	String trClass = "org-tr-content-border" ;	
%>

<div class="org-profile-layout-column-22">
<% if(listProGateService.size() > 0){
%>
<div class="org-common-layout">
	<div class="org-common-header">
		<div class="org-td-header">
			<a href="<%= urlProduct %>">
				<span class="org-header-content">Sản Phẩm / Dịch Vụ Nổi Bật</span>
			</a>
		</div>
	</div>
	<div class="org-common-body">
	
	<%
		
			for(int i = 0; i < listProGateService.size(); i ++){
				if(i == (listProGateService.size()-1)){
					trClass = "org-tr-content";
				}
				title = listProGateService.get(i).getTitle();
				imageUrl = listProGateService.get(i).getSmallImageUrl();
				productId = listProGateService.get(i).getPrimaryKey();
				
				// Build editProductURL
				LiferayPortletURL portletURLEdit = PortletURLFactoryUtil
				.create(request, "ProGate_ProductService_WAR_ProGateportlet",
				0, PortletRequest.RENDER_PHASE);
				portletURLEdit.setWindowState(WindowState.MAXIMIZED);
				portletURLEdit.setParameter("action", "handleProduct");
				portletURLEdit.setParameter(URLParameter_RS.ORG_ID, String.valueOf(orgId));
				portletURLEdit.setParameter(URLParameter_RS.VIEW_MODE, String.valueOf(viewMode));
				portletURLEdit.setParameter(JournalArticle_RS.JA_ID, String.valueOf(productId));
				portletURLEdit.setParameter(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, PortalUtil.getCurrentURL(renderRequest));
				portletURLEdit.setParameter(Constants.CMD, Constants.UPDATE);
				
				int index = portletURLEdit.toString().indexOf(StringPool.QUESTION);
				String editPortletURL = portletURLEdit.toString().substring(index);
				String editProductUrl = addressPortletURL + editPortletURL;
			
				
				// Build viewProductURL
				LiferayPortletURL portletURLView = PortletURLFactoryUtil
				.create(request, "ProGate_ProductService_WAR_ProGateportlet",
				0, PortletRequest.RENDER_PHASE);
				portletURLView.setWindowState(WindowState.MAXIMIZED);
				portletURLView.setParameter("action", "viewProduct");
				portletURLView.setParameter(URLParameter_RS.ORG_ID, String.valueOf(orgId));
				portletURLView.setParameter(URLParameter_RS.VIEW_MODE, String.valueOf(0));
				portletURLView.setParameter(JournalArticle_RS.JA_ID, String.valueOf(productId));
				portletURLView.setParameter(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, PortalUtil.getCurrentURL(renderRequest));
				
				int in = portletURLView.toString().indexOf(StringPool.QUESTION);
				String viewPortletURL = portletURLView.toString().substring(in);
				String viewProductUrl = addressPortletURL + viewPortletURL;
				viewProductUrl = urlProduct + "&" + URLParameter_RS.PRODUCT_ID + "=" + productId;
		%>
		
		<div class="<%= trClass %>">
			<div class="org-image-content" align="center">
				<a href="<%= viewProductUrl %>">
					<img alt="" src="<%= imageUrl %>" onLoad='scaleImg(this, 70, 70)' style="display: none;"/>
				</a>
			</div>
			<div class="org-td-content">
			<% 	if(isOrgAdmin && (viewMode == 1)){ %>
			<img src="/ProGate-portlet/images/write.png" alt="Sửa" width="20px" height="15px">
			<a href="<%= editProductUrl %>" style="text-decoration: none">
				<span class="tg-content-blue">Sửa</span>
			</a>
			<% } %>		
				<span class="org-normal-content">
					<a class="org-content-link" href="<%= viewProductUrl %>">
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
<% }else{
			if(isOrgAdmin && (viewMode == 1)){
%>	
		<div class="org-common-layout">
			<div class="org-common-header">
				<div class="org-td-header">
					<a href="<%= urlProduct %>">
						<span class="org-header-content">Sản Phẩm / Dịch Vụ Nổi Bật</span>
					</a>
				</div>
			</div>
			<div class="org-common-body">
				<div class="bodyContent">
					<span class="videoContent">
						Bạn hãy thêm vài sản phẩm / dịch vụ nổi bật mà công ty / tổ chức của bạn sản xuất / cung cấp.
					</span>
				</div>	
				<br>
				<div>
					<a href="<%=addProductUrl %>" class="linkContent">
						<span class="videoContentLink"> + Thêm</span>
					</a>
				</div>	
			</div>
		</div>		
<% }
}%>

</div>