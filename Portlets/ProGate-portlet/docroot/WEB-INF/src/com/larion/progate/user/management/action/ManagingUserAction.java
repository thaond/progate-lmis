package com.larion.progate.user.management.action;

import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.User;
import larion.progate.service.UserInformationViewLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.RSConstants;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.SendMailConst;
import com.larion.progate.common.utils.SendMailUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class ManagingUserAction extends ParameterizableViewAction {

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {

		String cmd = ParamUtil.getString(request, Constants.CMD);

		String filterUserTypicalMember = ParamUtil.getString(request,
				Request.FILTER_USER_TYPICAL_MEMBER, "2"); // 2: select all
		response.setRenderParameter(Request.FILTER_USER_TYPICAL_MEMBER,
				filterUserTypicalMember);

		String filterUserStatus = ParamUtil.getString(request,
				Request.FILTER_USER_STATUS, "2"); // 2: select all
		response.setRenderParameter(Request.FILTER_USER_STATUS,
				filterUserStatus);

		String searchPhrase = ParamUtil
				.getString(request, Constants.SEARCH, "");
		response.setRenderParameter(Constants.SEARCH, searchPhrase);

		int isProactive = GetterUtil.getInteger(filterUserTypicalMember);
		int status = GetterUtil.getInteger(filterUserStatus);

		PaginationObject paginationUser = new PaginationObject("User",
				UserInformationViewLocalServiceUtil.getNumberOfListUsers(
						isProactive, status, searchPhrase));

		response.setRenderParameter(
				paginationUser.getCurrentPageName(),
				ParamUtil.getString(request,
						paginationUser.getCurrentPageName(), "1"));

		response.setRenderParameter(paginationUser.getPageSizeName(), ParamUtil
				.getString(request, paginationUser.getPageSizeName(), "20"));

		int[] userIDList = ParamUtil.getIntegerValues(request, Request.USER_ID);

		if (Constants.DELETE.equals(cmd)) {

			response.setRenderParameter(Request.MESSAGE_TXT,
					"warning.user.delete.success");
		}

		if (RSConstants.TYPICAL_MEMBER.equals(cmd)) {

			boolean isSetTypicalSuccess = true;
			for (int userID : userIDList) {
				User user = UserLocalServiceUtil.getUser(userID);

				if (user.getStatus() == true) {
					user.setIsProActive(true);
					UserLocalServiceUtil.updateUser(user);

					InternetAddress[] to = { new InternetAddress(
							user.getEmailaddress(), user.getScreenname()) };

					SendMailUtil mailSender = new SendMailUtil();
					mailSender.sendMail(to, SendMailConst.TYPICAL_MEMEBER,
							new String[] {}, new String[] {}, new String[] {
									"[$UserName$]", "[$Link$]" }, new String[] {
									user.getScreenname(),
									"http://vnexpress.net/" });

				} else {
					isSetTypicalSuccess = false;
				}
			}

			if (isSetTypicalSuccess) {
				response.setRenderParameter(Request.MESSAGE_TXT,
						"warning.user.typical.choose.success");
			}
		}

		if (RSConstants.NORMAL_MEMBER.equals(cmd)) {
			for (int userID : userIDList) {
				User user = UserLocalServiceUtil.getUser(userID);
				user.setIsProActive(false);

				UserLocalServiceUtil.updateUser(user);

				InternetAddress[] to = { new InternetAddress(
						user.getEmailaddress(), user.getScreenname()) };

				SendMailUtil mailSender = new SendMailUtil();
				mailSender
						.sendMail(to, SendMailConst.NORMAL_MEMBER,
								new String[] {}, new String[] {}, new String[] {
										"[$UserName$]", "[$Link$]" },
								new String[] { user.getScreenname(),
										"http://vnexpress.net/" });
			}

			response.setRenderParameter(Request.MESSAGE_TXT,
					"warning.user.typical.remove.success");
		}

		if (RSConstants.ENABLE.equals(cmd)) {
			for (int userID : userIDList) {
				User user = UserLocalServiceUtil.getUser(userID);
				user.setStatus(true);

				UserLocalServiceUtil.updateUser(user);

				InternetAddress[] to = { new InternetAddress(
						user.getEmailaddress(), user.getScreenname()) };

				SendMailUtil mailSender = new SendMailUtil();
				mailSender
						.sendMail(to, SendMailConst.ENABLE_ACCOUNT,
								new String[] {}, new String[] {}, new String[] {
										"[$UserName$]", "[$Link$]" },
								new String[] { user.getScreenname(),
										"http://vnexpress.net/" });
			}

			response.setRenderParameter(Request.MESSAGE_TXT,
					"warning.user.enable.success");
		}

		if (RSConstants.DISABLE.equals(cmd)) {
			for (int userID : userIDList) {
				User user = UserLocalServiceUtil.getUser(userID);
				user.setStatus(false);
				user.setIsProActive(false);
				UserLocalServiceUtil.updateUser(user);

				InternetAddress[] to = { new InternetAddress(
						user.getEmailaddress(), user.getScreenname()) };

				SendMailUtil mailSender = new SendMailUtil();
				mailSender
						.sendMail(to, SendMailConst.DISABLE_ACCOUNT,
								new String[] {}, new String[] {}, new String[] {
										"[$UserName$]", "[$Link$]" },
								new String[] { user.getScreenname(),
										"http://vnexpress.net/" });
			}

			response.setRenderParameter(Request.MESSAGE_TXT,
					"warning.user.disable.success");
		}
	};

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);

			boolean isProGateAdmin = false;
			if ("progateadmin".equals(themeDisplay.getUser().getScreenName())) {
				isProGateAdmin = true;
			}
			bean.put("isProGateAdmin", isProGateAdmin);
			System.out.println("isProGateAdmin: " + isProGateAdmin);

			int isProactive = ParamUtil.getInteger(request,
					Request.FILTER_USER_TYPICAL_MEMBER, 2);
			bean.put("isProactive", isProactive);

			int status = ParamUtil.getInteger(request,
					Request.FILTER_USER_STATUS, 2);
			bean.put("status", status);

			String searchPhrase = ParamUtil.getString(request,
					Constants.SEARCH, "");
			bean.put("searchPhrase", searchPhrase);

			int countListUsers = UserInformationViewLocalServiceUtil
					.getNumberOfListUsers(isProactive, status, searchPhrase);
			bean.put("countListUsers", countListUsers);

			if (countListUsers > 0) {
				PaginationObject paginationUser = new PaginationObject("User",
						countListUsers);
				paginationUser.paging(request);
				bean.put("paginationUser", paginationUser);

				List<User> users = UserInformationViewLocalServiceUtil
						.getListUsers(isProactive, status, searchPhrase,
								paginationUser.getStartIndex(),
								paginationUser.getEndIndex());
				bean.put("users", users);
			}

			String msgTxt = ParamUtil.getString(request, Request.MESSAGE_TXT);
			bean.put(Request.MESSAGE_TXT, msgTxt);
			// users.get(0).getUserid()
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}