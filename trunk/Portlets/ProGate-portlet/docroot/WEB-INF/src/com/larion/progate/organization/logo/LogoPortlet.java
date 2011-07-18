package com.larion.progate.organization.logo;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;

import com.larion.progate.common.constants.URLParameter_RS;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.StrutsPortlet;

public class LogoPortlet extends StrutsPortlet {
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {
		
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(req);
		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(servletRequest);
		String orgId = originalRequest.getParameter(URLParameter_RS.ORG_ID);
		if(!Validator.isDigit(orgId)){
			orgId = req.getParameter(URLParameter_RS.ORG_ID);
		}
		
		Organization  org = null;
		if(Validator.isDigit(orgId)){
			try {
				org = OrganizationLocalServiceUtil.getOrganization(Integer.valueOf(orgId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		OrganizationImage orgLogo = new OrganizationImage(org, OrganizationImage.LOGO);
		OrganizationImage orgBanner = new OrganizationImage(org, OrganizationImage.BANNER);
		
		req.setAttribute("orgLogo", orgLogo);
		req.setAttribute("orgBanner", orgBanner);
		req.setAttribute(URLParameter_RS.ORG_ID, orgId);
		super.doView(req, res);
	}
}
