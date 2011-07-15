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

package com.larion.progate.customer.view;


import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.customer.constants.Customer_Const;
import com.larion.progate.paging.constants.PagingConst;
import com.larion.progate.orgMap.constants.OrgMap_Const;
import com.larion.progate.common.constants.ProgateRoleConst;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.StrutsPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;


import larion.progate.model.Organization;
import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import larion.progate.model.ProGateOrgCustomer;
import larion.progate.service.ProGateOrgCustomerLocalServiceUtil;



/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class CustomerPortlet extends StrutsPortlet {

	@Override
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		int orgId = 0;
		boolean isOrgAdmin = false;
		int viewMode = 0;
		int flag = 0;
		int objectId = 0;
		
		try {
			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpServletRequest orgRequest = PortalUtil.getOriginalServletRequest(request);
			
			if (orgRequest.getParameter(URLParameter_RS.ORG_ID) != null) {
				orgId = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.ORG_ID));
			} else if (request.getParameter(URLParameter_RS.ORG_ID) != null) {
				orgId = Integer.parseInt(request.getParameter(URLParameter_RS.ORG_ID));
			}
			
			if (orgRequest.getParameter(URLParameter_RS.VIEW_MODE) != null) {
				viewMode = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.VIEW_MODE));
			} else if (request.getParameter(URLParameter_RS.VIEW_MODE) != null) {
				viewMode = Integer.parseInt(request.getParameter(URLParameter_RS.VIEW_MODE));
			}
			
			if (orgRequest.getParameter(Customer_Const.OBJECT_ID) != null) {				
				objectId = Integer.parseInt(orgRequest.getParameter(Customer_Const.OBJECT_ID));
			} else if (request.getParameter(Customer_Const.OBJECT_ID) != null) {
				objectId = Integer.parseInt(request.getParameter(Customer_Const.OBJECT_ID));
			}
			
			//System.out.println("objectId = " + req.getAttribute(Customer_Const.OBJECT_ID));
			
			// Build URL
			String homeUrl= PortalUtil.getPortalURL(request);
			String viewURL = PortalUtil.getCurrentURL(req);
			String page ="";
			if(viewURL.indexOf(StringPool.QUESTION) != -1){
				String[] s = Pattern.compile("\\?").split(viewURL);
				page = s[0];
			}
			String url = homeUrl + page + StringPool.QUESTION + URLParameter_RS.ORG_ID + StringPool.EQUAL+ orgId + StringPool.AMPERSAND + URLParameter_RS.VIEW_MODE + StringPool.EQUAL+ viewMode;
			
			
			int type = 0;
			if(viewURL.indexOf(Customer_Const.CUSTOMER_PAGE) != -1){
				flag = 1 ;
				type = 0; // Customer
			}
			
			if(viewURL.indexOf(Customer_Const.PARTNER_PAGE) != -1){
				flag = 2 ; 
				type = 2; // partner
			}
			
			List<ProGateOrgCustomer> listObject = null; 
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
			if (type == 0) {
				numRecords = ProGateOrgCustomerLocalServiceUtil.countProGateOrgCusts(orgId);
			} else {
				numRecords = ProGateOrgCustomerLocalServiceUtil.countProGateOrgPartners(orgId);
			}
			//System.out.println("numRecords = " + numRecords);
			
			// Get INCREMENT_CONST
			int increment = PagingConst.INCREMENT_CONST;
			
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
			
			int startIndex = (currentPage - 1) * increment;
			int endIndex = currentPage * increment;
			if (type == 0) {
				listObject = ProGateOrgCustomerLocalServiceUtil.getProGateOrgCusts(orgId, startIndex, endIndex);
			}else {
				listObject = ProGateOrgCustomerLocalServiceUtil.getProGateOrgPartners(orgId, startIndex, endIndex);
			}
			
			if (listObject == null) {
				listObject = new ArrayList<ProGateOrgCustomer>();
			}
			
			paging.put(PagingConst.URL_TO_REDIRECT, url);
			paging.put(PagingConst.CURRENT_PAGE, currentPage);			
			paging.put(PagingConst.TOTAL_RECORD, numRecords);
			paging.put(PagingConst.INCREMENT, increment);
			
			/*
			int end = ProGateOrgCustomerLocalServiceUtil.countProGateOrgCusts(orgId);
			List<ProGateOrgCustomer> listObject = null; 
			
			if (type == 0) {
				listObject = ProGateOrgCustomerLocalServiceUtil.getProGateOrgCusts(orgId, 0, end);
			}else {
				listObject = ProGateOrgCustomerLocalServiceUtil.getProGateOrgPartners(orgId, 0, end);
			}
			*/
			
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
			
			// Show Image
			
			//UploadPortletRequest uploadPortlet = PortalUtil.getUploadPortletRequest(request);
			//String smallImagePath = Functions.getPathOfUploadImage(request, response, uploadRequest, fileUpload)(req, res, uploadPortlet, "ten_input_co_type_file");
			String detailCusUrl = homeUrl + page + StringPool.QUESTION + Customer_Const.OBJECT_ID + StringPool.EQUAL;
			
			
			req.setAttribute(URLParameter_RS.VIEW_MODE, viewMode);
			req.setAttribute(URLParameter_RS.ORG_ID, orgId);
			req.setAttribute(Customer_Const.IS_ADMIN_ROLE, isOrgAdmin);
			req.setAttribute(Customer_Const.URL, url);
			req.setAttribute(Customer_Const.FLAG, flag);
			req.setAttribute(Customer_Const.LIST_OBJECT,listObject);
			req.setAttribute(Customer_Const.DETAIL_CUS_URL,detailCusUrl);
			req.setAttribute(Customer_Const.OBJECT_ID,objectId);
			req.setAttribute(PagingConst.PAGING, paging);
			
			/*
			if (objectId > 0) {
				PortletURL renderURL = res.createActionURL();
				renderURL.setParameter(URLParameter_RS.ORG_ID, Integer.toString(orgId));
				renderURL.setParameter(URLParameter_RS.VIEW_MODE, Integer.toString(viewMode));
				renderURL.setParameter(Customer_Const.OBJECT_ID, Integer.toString(objectId));
				renderURL.setWindowState(WindowState.MAXIMIZED);
				
				System.out.println("setWindowState: renderURL = " + renderURL.toString());
			}
			*/
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail");
		}

		super.doView(req, res);
	}
}
