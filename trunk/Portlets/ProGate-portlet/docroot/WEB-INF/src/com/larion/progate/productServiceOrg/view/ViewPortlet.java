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

package com.larion.progate.productServiceOrg.view;

import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.ProgateRoleConst;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.orgMap.constants.OrgMap_Const;
import com.larion.progate.productServiceOrg.constants.PG_Org_Const;
import com.larion.progate.productServiceProGate.constants.PG_Const;
import com.larion.progate.video.constants.Video_Const;
import com.liferay.portal.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.StrutsPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticleView;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleViewLocalServiceUtil;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class ViewPortlet extends StrutsPortlet {

	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		try {
			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpServletRequest orgRequest = PortalUtil
					.getOriginalServletRequest(request);

			int orgId = 0;
			int viewMode = 0;
			boolean isOrgAdmin = false;
			if (orgRequest.getParameter(URLParameter_RS.ORG_ID) != null) {
				orgId = Integer.parseInt(orgRequest
						.getParameter(URLParameter_RS.ORG_ID));
			}
			
			if (orgRequest.getParameter(URLParameter_RS.VIEW_MODE) != null) {
				viewMode = Integer.parseInt(orgRequest
						.getParameter(URLParameter_RS.VIEW_MODE));
			}
			// Get User
			try{
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
			}catch(Exception e){
				
			}
			
			String articleType = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeProduct();
			List<ProGateJournalArticleView> listProGateService = ProGateJournalArticleViewLocalServiceUtil
					.getListArticleByOrgIdAndProductType(orgId, 0, articleType,
							true, 0, 3);
			
			// for (ProGateJournalArticleView ProGateJournalArticleView :
			// listProGateService) {
			// ProGateJournalArticleView.getPrimaryKey();
			// ProGateJournalArticleView.getTitle();
			// ProGateJournalArticleView.getSmallImageUrl(); // int ==> id of 1
			// Image object
			// }

			req.setAttribute(PG_Org_Const.LIST_PRODUCT_ORG, listProGateService);
			req.setAttribute(URLParameter_RS.ORG_ID, orgId);
			req.setAttribute(URLParameter_RS.VIEW_MODE, viewMode);
			req.setAttribute(PG_Org_Const.IS_ORG_ADMIN,isOrgAdmin);

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		super.doView(req, res);
	}
}
