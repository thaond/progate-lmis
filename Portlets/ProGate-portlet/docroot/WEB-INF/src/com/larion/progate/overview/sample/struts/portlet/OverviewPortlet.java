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

package com.larion.progate.overview.sample.struts.portlet;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.constants.ProgateRoleConst;
import com.larion.progate.orgMap.constants.OrgMap_Const;
import com.larion.progate.overview.constants.Overview_Const;
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
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticleView;
import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class OverviewPortlet extends StrutsPortlet {

	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		int orgId = 0;
		String introOverall = "";
		String visionOverall = "";
		String missionOverall = "";
		String coreValueOverall = "";
		boolean emptyOverall = false;
		boolean isOrgAdmin = false;
		boolean isHome = false;
		int viewMode = 0;
		try {
			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpServletRequest orgRequest = PortalUtil.getOriginalServletRequest(request);
			String viewURL = PortalUtil.getCurrentURL(req);
			if((viewURL.indexOf(Overview_Const.URL_HOME)) != -1){
				isHome = true;
			}
			

			if (orgRequest.getParameter(URLParameter_RS.ORG_ID) != null) {
				orgId = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.ORG_ID));
			}
			if (orgRequest.getParameter(URLParameter_RS.VIEW_MODE) != null) {
				viewMode = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.VIEW_MODE));
			}

			String intro = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeOrgOverallIntro();
			String vision = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeOrgOverallVision();
			String mission = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeOrgOverallMission();
			String coreValue = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeOrgOverallCoreValue();

			
			int end = ProGateJournalArticleLocalServiceUtil.countArticleByType(orgId, intro, "");
			
			// Intro
			List<ProGateJournalArticle> listIntro = ProGateJournalArticleLocalServiceUtil
					.getListProGateArticles(orgId, intro, "", 0, end);

			
			if((listIntro != null) && (listIntro.size() != 0)){
				introOverall = listIntro.get(0).getContent();
			}
			
			// Vision
			List<ProGateJournalArticle> listVision = ProGateJournalArticleLocalServiceUtil
					.getListProGateArticles(orgId, vision, "", 0, end);
			
			if((listVision != null) && (listVision.size() != 0)){
				visionOverall = listVision.get(0).getContent();
				
			}
			
			// Mission
			List<ProGateJournalArticle> listMission = ProGateJournalArticleLocalServiceUtil
					.getListProGateArticles(orgId, mission, "", 0, end);
			
			if((listMission != null) && (listMission.size() != 0)){
				missionOverall = listMission.get(0).getContent();
			}
			
			// CoreValue
			List<ProGateJournalArticle> listCoreValue = ProGateJournalArticleLocalServiceUtil
					.getListProGateArticles(orgId, coreValue, "", 0, end);
			
			if((listCoreValue != null) && (listCoreValue.size() != 0)){
				coreValueOverall = listCoreValue.get(0).getContent();
				
			}
			
			if((introOverall.isEmpty()) && (visionOverall.isEmpty()) && (missionOverall.isEmpty()) && (coreValueOverall.isEmpty())){
				emptyOverall = true;
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
			String viewURLPage = PortalUtil.getCurrentURL(req);
			String page ="";
			if(viewURLPage.indexOf(StringPool.QUESTION) != -1){
				//String[] s = viewURL.split(StringPool.QUESTION);
				String[] s = Pattern.compile("\\?").split(viewURLPage);
				page = s[0];
			}
			String currentUrl = homeUrl + page + StringPool.QUESTION + URLParameter_RS.ORG_ID + StringPool.EQUAL+ orgId + StringPool.AMPERSAND + URLParameter_RS.VIEW_MODE + StringPool.EQUAL+ viewMode;
			
			
			req.setAttribute(URLParameter_RS.VIEW_MODE, viewMode);
			req.setAttribute(Overview_Const.IS_HOME, isHome);
			req.setAttribute(URLParameter_RS.ORG_ID, orgId);
			req.setAttribute(Overview_Const.EMPTY_OVERALL, emptyOverall);
			req.setAttribute(Overview_Const.IS_ADMIN_ROLE, isOrgAdmin);
			req.setAttribute(Overview_Const.INTRO, introOverall);
			req.setAttribute(Overview_Const.VISION, visionOverall);
			req.setAttribute(Overview_Const.MISSION, missionOverall);
			req.setAttribute(Overview_Const.CORE_VALUE, coreValueOverall);
			req.setAttribute(Overview_Const.CURRENT_URL, currentUrl);

		} catch (Exception e) {
			System.out.println("Fail");
		}

		super.doView(req, res);
	}
}
