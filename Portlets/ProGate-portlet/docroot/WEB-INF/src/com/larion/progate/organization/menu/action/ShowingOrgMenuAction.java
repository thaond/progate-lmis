package com.larion.progate.organization.menu.action;

import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;

public class ShowingOrgMenuAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		HttpServletRequest orgRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));

		String orgID = ParamUtil.getString(orgRequest, URLParameter_RS.ORG_ID);
		String viewMode = ParamUtil.getString(orgRequest,
				URLParameter_RS.VIEW_MODE);

		String viewURL = PortalUtil.getCurrentURL(request);

		request.setAttribute(URLParameter_RS.ORG_ID, orgID);
		request.setAttribute(URLParameter_RS.VIEW_MODE, viewMode);
		
		bean.put(URLParameter_RS.VIEW_MODE, viewMode);

		bean.put("isAdminOfOrg",
				ProGateUtil.isAdminOfOrg(request, Integer.parseInt(orgID)));

		String viewModeUrl = viewURL.replaceAll(URLParameter_RS.VIEW_MODE
				+ StringPool.EQUAL + viewMode, URLParameter_RS.VIEW_MODE
				+ StringPool.EQUAL + 0);
		bean.put("viewModeUrl", viewModeUrl);

		String editModeUrl = viewURL.replaceAll(URLParameter_RS.VIEW_MODE
				+ StringPool.EQUAL + viewMode, URLParameter_RS.VIEW_MODE
				+ StringPool.EQUAL + 1);
		bean.put("editModeUrl", editModeUrl);

		String configModeUrl = viewURL.replaceAll(URLParameter_RS.VIEW_MODE
				+ StringPool.EQUAL + viewMode, URLParameter_RS.VIEW_MODE
				+ StringPool.EQUAL + 2);
		bean.put("configModeUrl", configModeUrl);
	}
}
