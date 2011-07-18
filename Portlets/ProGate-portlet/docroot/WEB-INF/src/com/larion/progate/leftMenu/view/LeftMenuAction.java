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

package com.larion.progate.leftMenu.view;


import com.ecyrd.jspwiki.plugin.CurrentTimePlugin;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.ProgateRoleConst;
import com.larion.progate.leftMenu.constants.LeftMenu_Const;
import com.larion.progate.news_homepage.constants.News_Const;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateApplications;
import larion.progate.service.ProGateApplicationsLocalServiceUtil;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class LeftMenuAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		HttpServletRequest orgRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));
		
		int userType = -1;
		if(orgRequest.getParameter(LeftMenu_Const.USER_TYPE) != null){
			userType = Integer.parseInt(orgRequest.getParameter(LeftMenu_Const.USER_TYPE));
		}
		
		boolean isAdmin = false;
		boolean isMyHomePage = false;
		boolean isListOrgPage = false;
		String selectedPage = "";
		String homeUrl= PortalUtil.getPortalURL(request);
		String viewURL = PortalUtil.getCurrentURL(request);
		
		if(viewURL.indexOf(LeftMenu_Const.MY_HOME_PAGE) != -1){
			isMyHomePage = true;
		}
		
		if(viewURL.indexOf(LeftMenu_Const.LIST_ORG_PAGE) != -1){
			isListOrgPage = true;
		}
		
		// Get User
		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
		com.liferay.portal.model.User user = UserLocalServiceUtil.getUser(sc.getUserId());
		
		long userId = user.getUserId();
		
		List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil.getUserRoles(userId);
		for(String role : listRole){
			if (ProgateRoleConst.PROGATE_ADMIN.equals(role)){
				isAdmin = true;
			}
		}
		
		// List application user
		List<ProGateApplications> applications = ProGateApplicationsLocalServiceUtil
		.getListApplicationBaseOnUserId((int) user.getUserId(), 0, 9);
		for(ProGateApplications p : applications){
			String friendlyUrl = p.getFriendlyUrl();
			if(viewURL.indexOf(friendlyUrl) != -1){
				selectedPage = friendlyUrl;
				break;
			}
		}

		request.setAttribute(LeftMenu_Const.IS_ADMIN, isAdmin);
		request.setAttribute(LeftMenu_Const.IS_MY_HOME_PAGE, isMyHomePage);
		request.setAttribute(LeftMenu_Const.IS_LIST_ORG_PAGE, isListOrgPage);
		request.setAttribute(LeftMenu_Const.USER_TYPE, userType);
		bean.put("homeUrl", homeUrl);
		bean.put("applications", applications);
		bean.put("selectedPage", selectedPage);
		bean.put("isListOrgPage", isListOrgPage);		
	}
}
