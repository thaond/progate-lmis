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

package com.larion.progate.developHistory.view;


import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.developHistory.constants.DevHistory_Const;
import com.larion.progate.common.constants.ProgateRoleConst;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.StrutsPortlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class DevelopHistoryPortlet extends StrutsPortlet {

	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		int orgId = 0;
		boolean emptyHistory = false;
		boolean isOrgAdmin = false;
		int viewMode = 0;
		String history = ""; 
		
		
		try {
			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpServletRequest orgRequest = PortalUtil.getOriginalServletRequest(request);

			if (orgRequest.getParameter(URLParameter_RS.ORG_ID) != null) {
				orgId = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.ORG_ID));
			}
			if (orgRequest.getParameter(URLParameter_RS.VIEW_MODE) != null) {
				viewMode = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.VIEW_MODE));
			}
			
			String historyType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgHistory();
			int end = ProGateJournalArticleLocalServiceUtil.countArticleByType(orgId, historyType, "");
			List<ProGateJournalArticle> listHistory = ProGateJournalArticleLocalServiceUtil
					.getListProGateArticles(orgId, historyType, "", 0, end);
			
			if((listHistory != null) && (listHistory.size() != 0)){
				history = listHistory.get(0).getContent();
			}
			
			if(history.isEmpty()){
				emptyHistory = true;
			}

			// Get User
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
			com.liferay.portal.model.User user = UserLocalServiceUtil.getUser(sc.getUserId());
			long userId = user.getUserId();
			
			List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil.getUserRoles(userId, orgId);
			
			for(String role : listRole){
				if(ProgateRoleConst.PROGATE_ADMIN.equals(role) 
					|| ProgateRoleConst.ORG_ADMIN.equals(role)
					|| ProgateRoleConst.ORG_OWNER.equals(role)){
					isOrgAdmin = true;
				}
			}
			
			// Build URL
			String homeUrl= PortalUtil.getPortalURL(request);
			String viewURL = PortalUtil.getCurrentURL(req);
			String page ="";
			if(viewURL.indexOf(StringPool.QUESTION) != -1){
				String[] s = Pattern.compile("\\?").split(viewURL);
				page = s[0];
			}
			String currentUrl = homeUrl + page + StringPool.QUESTION + URLParameter_RS.ORG_ID + StringPool.EQUAL+ orgId + StringPool.AMPERSAND + URLParameter_RS.VIEW_MODE + StringPool.EQUAL+ viewMode;
			
			
			req.setAttribute(URLParameter_RS.VIEW_MODE, viewMode);
			req.setAttribute(URLParameter_RS.ORG_ID, orgId);
			req.setAttribute(DevHistory_Const.EMPTY_HISTORY, emptyHistory);
			req.setAttribute(DevHistory_Const.IS_ADMIN_ROLE, isOrgAdmin);
			req.setAttribute(DevHistory_Const.HISTORY, history);
			req.setAttribute(DevHistory_Const.CURRENT_URL, currentUrl);

		} catch (Exception e) {
			System.out.println("Fail");
		}

		super.doView(req, res);
	}
}
