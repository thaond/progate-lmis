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

<%@ include file="/html/portlet/pg_overview/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int orgId = 0;
	boolean emptyOverall = false;
	boolean isRole = false;
	String introOverall = "";
	String visionOverall = "";
	String misionOverall = "";
	String coreValueOverall = "";
	boolean isHome = false;
	int viewMode = 0;
	String currentUrl = "";

	if(request.getAttribute(URLParameter_RS.ORG_ID) != null){
		orgId = (Integer)request.getAttribute(URLParameter_RS.ORG_ID);
	}
	String orgIdString = Integer.toString(orgId);
	
	if(request.getAttribute(Overview_Const.EMPTY_OVERALL) != null){
		emptyOverall = (Boolean)(request.getAttribute(Overview_Const.EMPTY_OVERALL));
	}
	
	if(request.getAttribute(Overview_Const.IS_ADMIN_ROLE) != null){
		isRole = (Boolean)(request.getAttribute(Overview_Const.IS_ADMIN_ROLE));
	}
	
	if(request.getAttribute(Overview_Const.INTRO) != null){
		introOverall = (String)request.getAttribute(Overview_Const.INTRO);
	}
	if(request.getAttribute(Overview_Const.VISION) != null){
		visionOverall = (String)request.getAttribute(Overview_Const.VISION);
	}
	if(request.getAttribute(Overview_Const.MISSION) != null){
		misionOverall = (String)request.getAttribute(Overview_Const.MISSION);
	}
	if(request.getAttribute(Overview_Const.CORE_VALUE) != null){
		coreValueOverall = (String)request.getAttribute(Overview_Const.CORE_VALUE);
	}
	
	if(request.getAttribute(Overview_Const.IS_HOME) != null){
		isHome = (Boolean)(request.getAttribute(Overview_Const.IS_HOME));
	}

	if(request.getAttribute(URLParameter_RS.VIEW_MODE) != null){
		viewMode = (Integer)request.getAttribute(URLParameter_RS.VIEW_MODE);
	}
	
	if(request.getAttribute(Overview_Const.CURRENT_URL) != null){
		currentUrl = (String)request.getAttribute(Overview_Const.CURRENT_URL);
	}
	//System.out.println("currentUrl= " + currentUrl);
	%>

<div class="org-profile-layout-column-21">
<%
	if(isHome){
%>
<% 
	String layoutCommon = "";
	String display = "";
	if(emptyOverall && (viewMode == 0)){ 
		layoutCommon = "" ;
		display = "display:none;";	
	}else{
		if((introOverall.isEmpty()) && (viewMode == 0)){
			layoutCommon = "" ;
			display = "display:none;";
		}else{
			layoutCommon = "tq-layout-common-border" ;
			display = "display:block;";
		}
	}
%>
<div class="<%= layoutCommon %>" style="<%= display %>">
	<div class="tq-body-home">
		<div class="tq-tr-header-home">
			  <span class="tg-content-header">Tổng Quan</span> 
		<div class="tq-header-right">
			<%
			if(isRole && (viewMode == 1)){
				if(emptyOverall){
			%>
			
				<div class="tg-header-td-right">
					<a href="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
					         <portlet:param name='struts_action' value='/pg_overview/add'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= orgIdString %>'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'>
						     </portlet:param>
					         <portlet:param name='<%=Overview_Const.CURRENT_URL  %>' value='<%= currentUrl %>'>
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
					         <portlet:param name='struts_action' value='/pg_overview/edit'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= orgIdString %>'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'>
						     </portlet:param>
					         <portlet:param name='<%=Overview_Const.CURRENT_URL  %>' value='<%= currentUrl %>'>
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
		
		
		<%
			if(emptyOverall && (viewMode == 1)){
		%>
		<div class="tq-content-align">
			<span class="tg-content" style="color: #ACACAC">
				Bạn hãy mô tả vài thông tin về công ty / tổ chức của bạn.
			</span>
		</div>
		<% }else{ %>
		<div class="tq-content-align">
			<span class="tg-content">
				<%= introOverall %>
			</span>
		</div>
		
		<% } %>
		
		
	</div>
</div>

<%
	}else{
%>


<div class="tq-layout-common">
	<div class="tq-header-layout">
		<div class="tq-header-left">
			<div class="tg-header-td-img-left">
				<img src="/ProGate-portlet/images/tongquan.png" alt="Tổng Quan" width="25px" height="20px">
			</div>
			<div class="tg-header-td-left">
				<span class="tg-content-orange">Tổng Quan</span>
			</div>
		</div>
		<div class="tq-header-right">
			<%
			if(isRole && (viewMode == 1)){
				if(emptyOverall){
			%>
			
				<div class="tg-header-td-right">
					<a href="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
					         <portlet:param name='struts_action' value='/pg_overview/add'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= orgIdString %>'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'>
						     </portlet:param>
					         <portlet:param name='<%=Overview_Const.CURRENT_URL  %>' value='<%= currentUrl %>'>
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
					         <portlet:param name='struts_action' value='/pg_overview/edit'>
					         </portlet:param>
					         <portlet:param name='<%= URLParameter_RS.ORG_ID  %>' value='<%= orgIdString %>'>
					         </portlet:param>
					         <portlet:param name='<%=URLParameter_RS.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'>
						     </portlet:param>
					         <portlet:param name='<%=Overview_Const.CURRENT_URL  %>' value='<%= currentUrl %>'>
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
	//if(!emptyOverall){
	%>
	<div class="tq-boby-home">
		<div class="tq-content-align">
			<span class="tg-content">
				<%= introOverall %>
			</span>
		</div>
		<br>
		<%
		if(!visionOverall.isEmpty()){
		%>
		<br>
		<div>
			<span style="color: #05851A;font-size: 14px; font-weight: bold;">Tầm Nhìn</span>
		</div>
		<div class="tq-content-align">
			<span class="tg-content">
				<%= visionOverall %>
			</span>
		</div>
		<br>
		<% } %>
		<% if(!misionOverall.isEmpty()){ %>
		
		<br>
		<div>
			<span style="color: #05851A;font-size: 14px; font-weight: bold;">Sứ Mệnh</span>
		</div>
		<div class="tq-content-align">
			<span class="tg-content">
				<%= misionOverall %>
			</span>
		</div>
		<br>
		
		<% } %>
		<% if(!coreValueOverall.isEmpty()){ %>
		<br>
		<div>
			<span style="color: #05851A;font-size: 14px; font-weight: bold;">Giá Trị Cốt Lõi</span>
		</div>
		<div class="tq-content-align">
			<span class="tg-content">
				<%= coreValueOverall %>
			</span>
		</div>
		<br>
	<% 
		}
	//} %>
</div>
</div>
<%
	}
%>
</div>