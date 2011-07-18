package com.larion.progate.ebsc.action;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;

public class ShowingOrganizationListAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

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