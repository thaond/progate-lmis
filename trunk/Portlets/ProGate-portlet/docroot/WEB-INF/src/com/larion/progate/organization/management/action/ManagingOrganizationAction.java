package com.larion.progate.organization.management.action;

import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.RSConstants;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

public class ManagingOrganizationAction extends ParameterizableViewAction {
	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {
        System.out.println("ManagingOrganizationAction handleActionRequestInternal");
		String cmd = ParamUtil.getString(request, Constants.CMD);

		if (!cmd.equals("") && cmd != null) {
			String[] orgsIDFromCheckobx = request
					.getParameterValues(Request.CHILD_CKB);

			if (cmd.equals(Request.ENABLE)) { // Enable Organization
				for (int i = 0; i < orgsIDFromCheckobx.length; i++) {

					Organization org = OrganizationLocalServiceUtil
							.getOrganization(Integer
									.parseInt(orgsIDFromCheckobx[i].trim()));

					org.setOrgStatus(true);
					OrganizationLocalServiceUtil.updateOrganization(org);
				}
			} else if (cmd.equals(Request.DISABLE)) { // Disable Organization
				for (int i = 0; i < orgsIDFromCheckobx.length; i++) {

					Organization org = OrganizationLocalServiceUtil
							.getOrganization(Integer
									.parseInt(orgsIDFromCheckobx[i].trim()));

					org.setOrgStatus(false);
					OrganizationLocalServiceUtil.updateOrganization(org);
				}
			} else if (cmd.equals(Constants.DELETE)) { // Delete Organization
				try {
					for (int i = 0; i < orgsIDFromCheckobx.length; i++) {
						OrganizationLocalServiceUtil.deleteOrganization(Integer
								.parseInt(orgsIDFromCheckobx[i].trim()));
					}
				} catch (Exception e) {
				}
			}
		}

		bean.put(RSConstants.ACTION, "manageOrganization");
	}

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
		System.out.println("ManagingOrganizationAction handleRenderRequestInternal");
		PaginationObject paginationOrganization = new PaginationObject(
				"Organization",
				OrganizationLocalServiceUtil.getOrganizationsCount());
		paginationOrganization.paging(request);
		bean.put("paginationOrganization", paginationOrganization);

		List<Organization> organizationList = OrganizationLocalServiceUtil
				.getOrganizations(paginationOrganization.getStartIndex(),
						paginationOrganization.getEndIndex());
		bean.put("organizationList", organizationList);
	}
}