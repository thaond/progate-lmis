package com.larion.progate.organization.logo.action;

import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletResponse;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.URLParameter_RS;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

public class UpdateSloganAction extends PortletAction {
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		Integer orgId = ParamUtil.getInteger(actionRequest,
				URLParameter_RS.ORG_ID);
		String slogan = ParamUtil.getString(actionRequest, "slogan");
		String orgName = ParamUtil.getString(actionRequest, "name");
		String ret = "";
		Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
		
		if (Validator.isNotNull(slogan)) {
			org.setSlogan(slogan.trim());
			ret = slogan;
		}

		if (Validator.isNotNull(orgName)) {
			org.setName(orgName.trim());
			ret = orgName;
		}

		OrganizationLocalServiceUtil.updateOrganization(org);
		HttpServletResponse servletResponse = PortalUtil
				.getHttpServletResponse(actionResponse);
		PrintWriter writer = servletResponse.getWriter();

		writer.print(ret);
		writer.flush();
	}
}
