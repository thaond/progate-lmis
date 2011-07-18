package com.larion.progate.changepassword.action;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.URLParameter_RS;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.pwd.PwdEncryptor;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ChangePasswordAction extends ParameterizableViewAction {

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);

			String returnToFullPageURL = ParamUtil.getString(request,
					URLParameter_RS.RETURN_TO_FULL_PAGE_URL, "");

			String oldPassword = ParamUtil.getString(request,
					Request.OLD_PASSWORD, "");

			String newPassword = ParamUtil.getString(request,
					Request.NEW_PASSWORD, "");

			String newPasswordAgain = ParamUtil.getString(request,
					Request.NEW_PASSWORD_AGAIN, "");

			boolean isCorrectPassword = false;
			boolean isChangePasswordSuccessful = false;

			if ((!"".equals(oldPassword)) && (!"".equals(newPassword))) {

				User user = themeDisplay.getUser();

				if (user.getPassword()
						.equals(PwdEncryptor.encrypt(oldPassword))) {

					UserLocalServiceUtil.updatePassword(user.getUserId(),
							newPassword, newPassword, false);

					oldPassword = "";
					newPassword = "";
					newPasswordAgain = "";
					isCorrectPassword = true;
					isChangePasswordSuccessful = true;
				}

			}

			response.setRenderParameter(
					URLParameter_RS.RETURN_TO_FULL_PAGE_URL,
					returnToFullPageURL);
			response.setRenderParameter(Request.OLD_PASSWORD, oldPassword);
			response.setRenderParameter(Request.NEW_PASSWORD, newPassword);
			response.setRenderParameter(Request.NEW_PASSWORD_AGAIN,
					newPasswordAgain);
			response.setRenderParameter("isCorrectPassword",
					String.valueOf(isCorrectPassword));
			response.setRenderParameter("isChangePasswordSuccessful",
					String.valueOf(isChangePasswordSuccessful));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		String returnToFullPageURL = ParamUtil.getString(request,
				URLParameter_RS.RETURN_TO_FULL_PAGE_URL, "");

		if ("".equals(returnToFullPageURL)) {

			HttpServletRequest httpSR = PortalUtil
					.getHttpServletRequest(request);
			HttpServletRequest origReq = PortalUtil
					.getOriginalServletRequest(httpSR);
			returnToFullPageURL = origReq.getHeader("referer");
		}

		bean.put(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, returnToFullPageURL);

		String oldPassword = ParamUtil.getString(request, Request.OLD_PASSWORD,
				"");
		bean.put(Request.OLD_PASSWORD, oldPassword);

		String newPassword = ParamUtil.getString(request, Request.NEW_PASSWORD,
				"");
		bean.put(Request.NEW_PASSWORD, newPassword);

		String newPasswordAgain = ParamUtil.getString(request,
				Request.NEW_PASSWORD_AGAIN, "");
		bean.put(Request.NEW_PASSWORD_AGAIN, newPasswordAgain);

		String isChangePasswordSuccessful = ParamUtil.getString(request,
				"isChangePasswordSuccessful", "");
		String isCorrectPassword = ParamUtil.getString(request,
				"isCorrectPassword", "");

		bean.put("isCorrectPassword", isCorrectPassword);
		bean.put("isChangePasswordSuccessful", isChangePasswordSuccessful);

		System.out.println("isChangePasswordSuccessful "
				+ isChangePasswordSuccessful);

	}
}
