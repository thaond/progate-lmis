package com.larion.progate.user.application;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.ProGateApplications;
import larion.progate.service.ProGateApplicationsLocalServiceUtil;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

public class ListingUserApplicationAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		List<ProGateApplications> applications = ProGateApplicationsLocalServiceUtil
				.getListApplicationBaseOnUserId((int) user.getUserId(), 0, 9);
		// ProGateApplications p;p.getDescription()
		bean.put("applications", applications);
	}
}