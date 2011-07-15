	<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.larion.progate.video.constants.Video_Const"%>
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


<%@ include file="/html/portlet/video/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int orgId = 0;
	int mode = 0;
	String videoURL = "";
	int addSuccess = 0;
	int editSuccess = 0;
	String urlReplace = "";
	boolean isOrgAdmin = false;
	int viewMode = 0;
	String currentUrl = "";
	
	String homeUrl= PortalUtil.getPortalURL(request);
	//String homeUrl= PortalUtil.getHomeURL(request);
	//System.out.println("homeUrl" + homeUrl);
	
	if(request.getAttribute(URLParameter_RS.ORG_ID) != null){
		orgId = (Integer)(request.getAttribute(URLParameter_RS.ORG_ID));
	}
	String orgIdString = Integer.toString(orgId);
	if(request.getAttribute(URLParameter_RS.VIEW_MODE) != null){
		viewMode = (Integer)(request.getAttribute(URLParameter_RS.VIEW_MODE));
	}
	
	//if(request.getAttribute(Video_Const.MODE) != null){
	//	mode = (Integer)(request.getAttribute(Video_Const.MODE));
	//}
	if(request.getAttribute(Video_Const.VIDEO_URL) != null){
		videoURL = (String)request.getAttribute(Video_Const.VIDEO_URL);
		//urlReplace = videoURL.replaceAll("480","300").replaceAll("385","250").replaceAll("640","300").replaceAll("390","250");
	}
	
	if(request.getAttribute(Video_Const.ADDED_SUCCESS) != null){
		addSuccess = (Integer)(request.getAttribute(Video_Const.ADDED_SUCCESS));
	}
	
	if(request.getAttribute(Video_Const.EDITED_SUCCESS) != null){
		editSuccess = (Integer)(request.getAttribute(Video_Const.EDITED_SUCCESS));
	}
	
	if(request.getAttribute(Video_Const.IS_ORG_ADMIN) != null){
		isOrgAdmin = (Boolean)(request.getAttribute(Video_Const.IS_ORG_ADMIN));
	}
	
	if(request.getAttribute(Video_Const.CURRENT_URL) != null){
		currentUrl = (String)request.getAttribute(Video_Const.CURRENT_URL);
	}
	
	//String urlAddVideo = homeUrl + "/" + Video_Const.VIDEO_PAGE + "?" + URLParameter_RS.ORG_ID + "=" + orgId + "&" + Video_Const.MODE + "=" + 1 ;
	//String urlEditVideo = homeUrl + "/" + Video_Const.VIDEO_PAGE + "?" + URLParameter_RS.ORG_ID + "=" + orgId + "&" + Video_Const.MODE + "=" + 2 ;
	
	//System.out.println("videoURL===" + videoURL+ "GGGGGGGGGGGGGGGGGGGGGGGGG");
%>

<div class="org-profile-layout-column-22">

<% 	
	
	if(videoURL.isEmpty()){
			if(viewMode == 1){
%>
			<div class="video-common-layout">
				<div class="bodyContent">
					<span class="videoContent">
						Bạn hãy thêm video giới thiệu về công ty / tổ chức để người dùng có cái nhìn rõ hơn về công ty / tổ chức của mình.
						
					</span>
				</div>
				<%
				if(isOrgAdmin){
				%>
					<div>
						<a href="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
						         <portlet:param name='struts_action' value='/video/add'>
						         </portlet:param>
						         <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= orgIdString %>'>
						         </portlet:param>
						         <portlet:param name='<%=Video_Const.CURRENT_URL  %>' value='<%= currentUrl %>'>
						         </portlet:param>
						         </portlet:renderURL>" style="text-decoration: none"  class="linkContent">
							<span class="videoContentLink"> + Thêm</span>
						</a>
					</div>
			<% } %>
			</div>
			<% }
		}else{  
			if(viewMode == 1){
			%>
					<div class="video-common-layout-noborder">
						<div class="bodyContent-url">
							<%= videoURL %>
						</div>
						<%
						if(isOrgAdmin){
						%>
							<div>
								<a href="<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
							         <portlet:param name='struts_action' value='/video/edit'>
							         </portlet:param>
							         <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= orgIdString %>'>
							         </portlet:param>
							         <portlet:param name='<%=Video_Const.CURRENT_URL  %>' value='<%= currentUrl %>'>
						         	 </portlet:param>
						         	 <portlet:param name='<%=Video_Const.VIDEO_URL  %>' value='<%= videoURL %>'>
						         	 </portlet:param>
							         </portlet:renderURL>" style="text-decoration: none"  class="linkContent">
									<span class="videoContentLink"> Chỉnh Sửa </span>
								</a>
							</div>
						<%
			}
						%>
					 
					</div>
<%
		}else{   %>
		<div class="video-common-layout-noborder">
			<div class="bodyContent-url">
				<%= videoURL %>
			</div>
		</div>
		
<%		}

	}
%>
</div>