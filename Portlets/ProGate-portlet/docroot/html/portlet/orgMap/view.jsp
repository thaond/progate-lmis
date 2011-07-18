<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@page import="com.larion.progate.orgMap.constants.OrgMap_Const"%>
<%@page import="com.larion.progate.developHistory.constants.DevHistory_Const"%>
<%@page import="com.larion.progate.overview.constants.Overview_Const"%>
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

<%@ include file="/html/portlet/orgMap/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int orgId = 0;
	boolean emptyOrgMap = false;
	boolean isRole = false;
	String title = "";
	String imageMap = "";
	String decription = "";
	int viewMode = 0;
	
	if(request.getAttribute(URLParameter_RS.ORG_ID) != null){
		orgId = (Integer)request.getAttribute(URLParameter_RS.ORG_ID);
	}
	String orgIdString = Integer.toString(orgId);
	
	if(request.getAttribute(OrgMap_Const.EMPTY_ORG_MAP) != null){
		emptyOrgMap = (Boolean)(request.getAttribute(OrgMap_Const.EMPTY_ORG_MAP));
	}
	
	if(request.getAttribute(OrgMap_Const.IS_ADMIN_ROLE) != null){
		isRole = (Boolean)(request.getAttribute(OrgMap_Const.IS_ADMIN_ROLE));
	}
	
	if(request.getAttribute(OrgMap_Const.TITLE) != null){
		title = (String)request.getAttribute(OrgMap_Const.TITLE);
	}
	if(request.getAttribute(OrgMap_Const.IMAGE_MAP) != null){
		imageMap = (String)request.getAttribute(OrgMap_Const.IMAGE_MAP);
	}
	if(request.getAttribute(OrgMap_Const.DESCRIPTION) != null){
		decription = (String)request.getAttribute(OrgMap_Const.DESCRIPTION);
	}
	
	if(request.getAttribute(URLParameter_RS.VIEW_MODE) != null){
		viewMode = (Integer)request.getAttribute(URLParameter_RS.VIEW_MODE);
	}
	
	String currentUrl = "";
	if(request.getAttribute(OrgMap_Const.CURRENT_URL) != null){
		currentUrl = (String)request.getAttribute(OrgMap_Const.CURRENT_URL);
	}
	
%>

<script type="text/javascript">
	jQuery(function(){	
		jQuery(".org-map-decription img").each(function(){
			scaleImg(this, 500, 375);
	    });
	});
</script>	

<div class="org-profile-layout-column-21">
<div class="tq-layout-common">
	<div class="tq-header-layout">
		<div class="tq-header-left">
			<div class="tg-header-td-img-left">
				<img src="/ProGate-portlet/images/sodotochuc.png" alt="Sơ Đồ Tổ Chức" width="25px" height="20px">
			</div>
			<div class="tg-header-td-left">
				<span class="tg-content-orange">Sơ Đồ Tổ Chức</span>
			</div>
		</div>
		<div class="tq-header-right">
			<%
			if(isRole && (viewMode == 1)){
				if(emptyOrgMap){
			%>
			
				<div class="tg-header-td-right">
					<a href="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
					         <portlet:param name='struts_action' value='/orgMap/add'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= orgIdString %>'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'>
						     </portlet:param>
					         <portlet:param name='<%=OrgMap_Const.CURRENT_URL  %>' value='<%= currentUrl %>'>
					         </portlet:param>
					         </portlet:renderURL>" style="text-decoration: none">
						<span class="tg-content-blue"> + Thêm</span>
					</a>
				</div>
			
			<%	
				}else{
			
			%>
				<div class="tg-header-td-right">
					<a href="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
					         <portlet:param name='struts_action' value='/orgMap/edit'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= orgIdString %>'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'>
						     </portlet:param>
					         <portlet:param name='<%=OrgMap_Const.CURRENT_URL  %>' value='<%= currentUrl %>'>
					         </portlet:param>
					         </portlet:renderURL>" style="text-decoration: none">
						<span class="tg-content-blue">Sửa</span>
					</a>
				</div>
				<div class="tg-header-td-img-right">
					<img src="/ProGate-portlet/images/write.png" alt="Sửa" width="23px" height="18px">
				</div>
			<%
				}
			
			}
			%>
			
		</div>
	</div>
	<br>
	<br>
	<%
	if(!emptyOrgMap){
	%>
	<div class="tq-boby">
		<div class="tq-content-middle">
			<span class="tg-content-title">
				<%= title %>
			</span>
		</div>
		<div class="tq-content-middle">			          			
			<span class="tg-content">	
			<% if("".equals(imageMap)){ %>
			           <img alt="" src="<%=request.getContextPath()%>/images/news_org/small_noImage.gif">
			 <%}else{ %>   
					   <img src="<%= imageMap %>" alt="Sơ Đồ Tổ Chức" onLoad='scaleImg(this, 500, 375)' >
			   <%} %>
			</span>
		</div>
		<div class="tq-content-middle">
			<br/><span class="tg-content org-map-decription" style="text-align: justify;">
				<%= decription %>
			</span>
		</div>
		
	</div>
	<% } %>
</div>
</div>
