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

package com.larion.progate.customerRmd.render;

import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.StrutsPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.compass.core.util.backport.java.util.Collections;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.larion.progate.customerRmd.constants.CustomerRmdConst;
import com.larion.progate.customerRmd.constants.RequestConst;
import com.larion.progate.paging.constants.PagingConst;
import com.larion.progate.common.constants.ProgateRoleConst;

import larion.progate.service.ProGateOrgCustomerRepresenterLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;

import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class CustomerRmdPortlet extends StrutsPortlet {

	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		try {
			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpServletRequest orgRequest = PortalUtil.getOriginalServletRequest(request);
	
			PortletPreferences preferences = req.getPreferences();
			String portletResource = ParamUtil.getString(request, "portletResource");
			//System.out.println("portletResource = " + portletResource);

			if (Validator.isNotNull(portletResource)) {
				preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
			}
			
			int orgId = 0;
			String orgIdStr = "0";
			if (orgRequest.getParameter(RequestConst.ORG_ID) != null) {
				orgIdStr = orgRequest.getParameter(RequestConst.ORG_ID);
				orgId = Integer.parseInt(orgIdStr);
			} else if (request.getParameter(RequestConst.ORG_ID) != null) {
				orgIdStr = request.getParameter(RequestConst.ORG_ID);
				orgId = Integer.parseInt(orgIdStr);
			}

			String viewMode = "";
			if (orgRequest.getParameter(RequestConst.VIEW_MODE) != null) {
				viewMode = orgRequest.getParameter(RequestConst.VIEW_MODE);
			} else if (request.getParameter(RequestConst.VIEW_MODE) != null) {
				viewMode = request.getParameter(RequestConst.VIEW_MODE);
			}
			
			Map<String, Object> paging = new HashMap<String, Object>();
			
			// Current page
			int currentPage = 0;
			if (orgRequest.getParameter(PagingConst.GOTO_PAGE) != null) {			
				currentPage = Integer.parseInt(orgRequest.getParameter(PagingConst.GOTO_PAGE));
			} else if (request.getParameter(PagingConst.GOTO_PAGE) != null) {			
				currentPage = Integer.parseInt(request.getParameter(PagingConst.GOTO_PAGE));
			}
						
			// Get total records
			int numRecords = 0;
			try {					
				numRecords = ProGateOrgCustomerRepresenterLocalServiceUtil.countListCustRepresenterByOrgId(orgId, true);
			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("countListCustomerRmd(" + orgId + ") ==> Null data");
				e.printStackTrace();
				numRecords = 0;
			}
			
			// Get INCREMENT_CONST
			String incrementStr = preferences.getValue(RequestConst.NUM_OF_ITEM, Integer.toString(RequestConst.INCREMENT_CONST));
			int increment = 0;
			if (incrementStr.length() > 0) {
				increment = Integer.parseInt(incrementStr);
				
				//System.out.println("increment = " + increment);
			}			
			if (increment <  1) {
				increment = RequestConst.INCREMENT_CONST;
				
				//System.out.println("Default: increment = " + increment);
			}			
			
			int maxPages = 0;
			if (numRecords % increment == 0) {
				maxPages = numRecords / increment;
			} else {
				maxPages = numRecords / increment + 1;
			}			
			
			if (currentPage < 1) {
				currentPage = 1;
			} else if (currentPage > maxPages) {
				currentPage = maxPages;
			}
			
			String friendlyUrl = preferences.getValue(RequestConst.FRIENDLY_URL, CustomerRmdConst.FRIENDLY_URL);
			String urlToRedirect = PortalUtil.getPortalURL(request) + "/" + friendlyUrl
									+ "?" + RequestConst.ORG_ID + "=" + orgId 
									+ "&" + RequestConst.VIEW_MODE + "=" + viewMode;
			
			paging.put(PagingConst.URL_TO_REDIRECT, urlToRedirect);
			paging.put(PagingConst.CURRENT_PAGE, currentPage);			
			paging.put(PagingConst.TOTAL_RECORD, numRecords);
			paging.put(PagingConst.INCREMENT, increment);

			// Get display mode
			String displayStyle = preferences.getValue(RequestConst.DISPLAY_STYLE, RequestConst.SHORT_VIEW);
			//System.out.println("displayStyle = " + displayStyle);

			// Check user role
			boolean isOrgAdmin = false;
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			long userId = user.getUserId();

			List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil
					.getUserRoles(userId, orgId);

			for (String role : listRole) {
				//System.out.println("Role = " + role);

				if (ProgateRoleConst.PROGATE_ADMIN.equals(role) 
					|| ProgateRoleConst.ORG_ADMIN.equals(role)
					|| ProgateRoleConst.ORG_OWNER.equals(role)) {
					isOrgAdmin = true;
				}
			}
									
			//System.out.println("displayStyle = " + displayStyle);
			//System.out.println("orgId = " + orgIdStr);
			//System.out.println("viewMode = " + viewMode);
			//System.out.println("isOrgAdmin = " + isOrgAdmin);
			//System.out.println("currentPage = " + currentPage);
			//System.out.println("numRecords = " + numRecords);

			req.setAttribute(RequestConst.ORG_ID, orgIdStr);
			req.setAttribute(RequestConst.VIEW_MODE, viewMode);
			req.setAttribute(RequestConst.DISPLAY_MODE, displayStyle);
			req.setAttribute(RequestConst.IS_ORG_ADMIN, isOrgAdmin);
			req.setAttribute(PagingConst.PAGING, paging);
			
		} catch (Exception e) {
			System.out.println("Customer talk: Error in processing doView()");
			e.printStackTrace();
		}

		super.doView(req, res);
	}
}
