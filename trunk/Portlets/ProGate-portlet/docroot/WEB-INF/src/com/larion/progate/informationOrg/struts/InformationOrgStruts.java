package com.larion.progate.informationOrg.struts;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.constants.ProgateRoleConst;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.StrutsPortlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.Organization;

/**
 * @Sample Struts Portlet controller
 * 
 * @author Jeff Robinson
 * 
 */
public class InformationOrgStruts extends StrutsPortlet {

	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {

		
		Organization org = null;
		String targetPage = "";
		boolean turnDirection = false;
		try {
			HttpServletRequest httpSr = PortalUtil.getHttpServletRequest(req);
			HttpServletRequest origReq = PortalUtil
					.getOriginalServletRequest(httpSr);
			String orgId = origReq.getParameter(URLParameter_RS.ORG_ID);
			String viewMode = origReq.getParameter(URLParameter_RS.VIEW_MODE);
			if (viewMode != null) req.setAttribute("viewMode", viewMode);
			boolean isViewMode = false;
			if (viewMode != null && "1".equals(viewMode) ) {
				isViewMode = true;
			}
			if (orgId != null) {
				req.setAttribute("orgId", orgId);

				boolean isOrgAdmin = false;
				// Get User
				com.liferay.portal.service.ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
				com.liferay.portal.model.User user = UserLocalServiceUtil.getUser(sc.getUserId());
				long userId = user.getUserId();
				
				List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil.getUserRoles(userId, Integer.parseInt(orgId));
				
				for(String role : listRole){
					// khi nao review code thi chuyen cai bien nay thanh hang so trong file const
					if((ProgateRoleConst.PROGATE_ADMIN.equals(role) 
						|| ProgateRoleConst.ORG_ADMIN.equals(role)
						|| ProgateRoleConst.ORG_OWNER.equals(role)) 
						&& isViewMode){
						isOrgAdmin = true;
					}
				}

				// Quann comment
				org = larion.progate.service.OrganizationLocalServiceUtil
						.getOrgObjectFromOrgId(Integer.parseInt(orgId));
				// end Quann comment
				// check if organization has empty information
				Date orgFounded = org.getOrgFounded();
				String founderList = org.getFounderList();
				String orgType = org.getOrgType();
				String orgSize = String.valueOf(org.getOrgSize());
				String website = org.getWebsite();
//				String city = org.getCity();
//				String address = org.getAddress1();
//				String phone = org.getPhone();
				if ((orgFounded == null || orgFounded.equals(""))
						&& (orgType == null || orgType.equals(""))
						&& (orgSize == null || orgSize.equals("0"))
						&& (founderList == null || founderList.equals(""))
						&& (website == null || website.equals(""))) {
					turnDirection = true;
					targetPage = "/html/portlet/InformationOrg/emptyInformation.jsp";
				} else {
					req.setAttribute("org", org);
					req.setAttribute("isOrgAdmin", isOrgAdmin);
					turnDirection = true;
					targetPage = "/html/portlet/InformationOrg/view.jsp";
				}
			} else {
				turnDirection = true;
				targetPage = "/html/portlet/InformationOrg/plainPage.jsp";
			}
		} catch (Exception e) {
			// TODO: handle exception
			turnDirection = true;
			targetPage = "/html/portlet/InformationOrg/plainPage.jsp";
			System.out.println(e.toString());
			System.out.println("fail");
		}

		String action = req.getParameter("action");
		if (action != null && action.equals("detailInformation")) {
			req.setAttribute("orgId", req.getParameter("orgId"));
			turnDirection = true;
			targetPage = "/html/portlet/InformationOrg/detailInformation.jsp";
		} else if (action != null && action.equals("saveInformation")) {
			turnDirection = false;
		}
		if (turnDirection) {
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher(targetPage);
			prd.include(req, res);
		} else {
			super.doView(req, res);
		}
	}

	public void doConfig(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {
		super.doConfig(req, res);
	}

}
