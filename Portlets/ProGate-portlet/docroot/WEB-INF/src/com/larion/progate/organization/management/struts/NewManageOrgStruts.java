package com.larion.progate.organization.management.struts;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;
import com.larion.progate.common.constants.ProgateRoleConst;
import com.larion.progate.common.constants.URLParameter_RS;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.StrutsPortlet;

public class NewManageOrgStruts extends StrutsPortlet {
	@Override
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		String targetPage = "";
		boolean turnDirection = false;

		HttpServletRequest httpSr = PortalUtil.getHttpServletRequest(req);
		HttpServletRequest origReq = PortalUtil
				.getOriginalServletRequest(httpSr);
		try {
			int orgParentId = 0;
			if (origReq.getParameter(URLParameter_RS.ORG_PARENT_ID) != null) {
				orgParentId = Integer.parseInt(origReq
						.getParameter(URLParameter_RS.ORG_PARENT_ID));
				Organization parentOrg = null;
				
				parentOrg = OrganizationLocalServiceUtil
						.getOrganization(orgParentId);
				if (parentOrg != null) {
					
					httpSr.setAttribute("defaultCity", parentOrg.getCity());
					httpSr.setAttribute("defaultAddress",
							parentOrg.getAddress1());
					httpSr.setAttribute("defaultOrgType",
							parentOrg.getOrgType());
					System.out.println(parentOrg.getCity());
					System.out.println(parentOrg.getAddress1());
					System.out.println(parentOrg.getOrgType());
				}
			}
			req.setAttribute(URLParameter_RS.ORG_PARENT_ID, orgParentId);

			int orgRootId = 0;
			if (origReq.getParameter(URLParameter_RS.ORG_ROOT_ID) != null) {
				orgRootId = Integer.parseInt(origReq
						.getParameter(URLParameter_RS.ORG_ROOT_ID));
			}
			req.setAttribute(URLParameter_RS.ORG_ROOT_ID, orgRootId);

			int viewMode = 0;
			if (origReq.getParameter(URLParameter_RS.VIEW_MODE) != null) {
				viewMode = Integer.parseInt(origReq
						.getParameter(URLParameter_RS.VIEW_MODE));
			}
			req.setAttribute(URLParameter_RS.VIEW_MODE, viewMode);

			int userType = -1;
			if (origReq.getParameter("userType") != null) {
				userType = Integer.valueOf(origReq.getParameter("userType"));
			}
			req.setAttribute("userType", userType);

			String currentURL = PortalUtil.getCurrentURL(req);
			int indexCurrentPage = currentURL.indexOf("&currentPage");
			if (indexCurrentPage != -1) {
				currentURL = currentURL.substring(0, indexCurrentPage);
			} else {
				indexCurrentPage = currentURL.indexOf("?currentPage");
				if (indexCurrentPage != -1)
					currentURL = currentURL.substring(0, indexCurrentPage);
			}
			req.setAttribute("currentURL", currentURL);

			String pageURL = currentURL;
			int indexPage = pageURL.indexOf("?");
			if (indexPage != -1) {
				pageURL = pageURL.substring(0, indexPage);
			}
			req.setAttribute("pageURL", pageURL);

			String keyWords = origReq.getParameter("keyWords");
			if (keyWords != null) {
				req.setAttribute("keyWords", keyWords);
			}

			String cmd = origReq.getParameter("cmd");
			targetPage = "/html/portlet/organization/management/new/org_list.jsp";

			if (cmd != null) {
				turnDirection = true;
				targetPage = "/html/portlet/organization/management/new/org_create.jsp";
				req.setAttribute("cmd", cmd);
			}

			boolean isProGateAdmin = false;

			int pageSize = 10;
			if (origReq.getParameter("pageSize") != null)
				pageSize = Integer.valueOf(origReq.getParameter("pageSize"));
			req.setAttribute("pageSize", pageSize);

			int currentPage = 1;
			if (origReq.getParameter("currentPage") != null)
				currentPage = Integer.valueOf(origReq
						.getParameter("currentPage"));
			req.setAttribute("currentPage", currentPage);

			// Get User
			com.liferay.portal.service.ServiceContext sc = ServiceContextFactory
					.getInstance(this.getClass().getName(), req);
			com.liferay.portal.model.User user = com.liferay.portal.service.UserLocalServiceUtil
					.getUser(sc.getUserId());
			long userId = user.getUserId();
			req.setAttribute("userId", (int) userId);

			List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil
					.getUserRoles(userId);
			for (String role : listRole) {
				if (ProgateRoleConst.PROGATE_ADMIN.equals(role)) {
					isProGateAdmin = true;
				}
			}
			req.setAttribute("isProGateAdmin", isProGateAdmin);

			String orgId = origReq.getParameter("orgId");
			if (orgId != null)
				req.setAttribute("orgId", orgId);

		} catch (Exception e) {
			// TODO: handle exception
		}

		String struts_action = req.getParameter("struts_action");
		if (struts_action != null) {
			turnDirection = false;
		}

		if (turnDirection) {
			PortletRequestDispatcher prd = getPortletContext()
					.getRequestDispatcher(targetPage);
			prd.include(req, res);
		} else {
			super.doView(req, res);
		}
	}
}
