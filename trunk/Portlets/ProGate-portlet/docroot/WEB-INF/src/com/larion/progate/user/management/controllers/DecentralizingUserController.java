package com.larion.progate.user.management.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.ProGateRoles;
import larion.progate.model.User;
import larion.progate.model.UserInformationView;
import larion.progate.service.ProGateRolesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.UserInformationViewLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.SendMailConst;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.SendMailUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class DecentralizingUserController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		Map<String, Object> bean = new HashMap<String, Object>();

		String returnToFullPageURL = ParamUtil.getString(request,
				URLParameter_RS.RETURN_TO_FULL_PAGE_URL);
		bean.put(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, returnToFullPageURL);

		int userId = ParamUtil.getInteger(request, Request.USER_ID, 0);
		bean.put("userId", userId);
		System.out.println("userId: " + userId);

		User user = UserLocalServiceUtil.getUser(userId);
		bean.put("user", user);

		int filterRole = ParamUtil.getInteger(request,
				Request.FILTER_USER_ROLE, 0);
		bean.put("filterRole", filterRole);
		System.out.println("filterRole: " + filterRole);

		String searchPhrase = ParamUtil
				.getString(request, Constants.SEARCH, "");
		bean.put("searchPhrase", searchPhrase);
		System.out.println("searchPhrase: " + searchPhrase);

		int applyRole = ParamUtil.getInteger(request, Request.APPLY_USER_ROLE,
				1);
		bean.put("applyRole", applyRole);

		String cmd = ParamUtil.getString(request, Constants.CMD);

		if (Constants.UPDATE.equals(cmd)) {
			int orgId = ParamUtil.getInteger(request, Request.ORG_ID, 0);
			bean.put("orgId", orgId);

			String roleName = ParamUtil.getString(request, "roleName", "");
			bean.put("roleName", roleName);

			String applyRoleName = ParamUtil.getString(request,
					"applyRoleName", "");
			bean.put("applyRoleName", applyRoleName);

			String orgName = ParamUtil.getString(request, "orgName", "");
			bean.put("orgName", orgName);

			int oldRoleId = ParamUtil.getInteger(request, Request.USER_ROLE_ID);

			ProgateOrganizationParticipantsLocalServiceUtil
					.decentralizeRoleOfUserInOrg(userId, orgId, applyRole);

			String msgTxt = "warning.user.decentralize.success";
			bean.put(Request.MESSAGE_TXT, msgTxt);

			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			String adminName = themeDisplay.getUser().getScreenName();

			InternetAddress[] to = { new InternetAddress(
					user.getEmailaddress(), user.getScreenname()) };

			SendMailUtil mailSender = new SendMailUtil();
			mailSender.sendMail(
					to,
					SendMailConst.DECENTRALIZE_USER,
					new String[] { "[$OrgName$]" },
					new String[] { orgName },
					new String[] { "[$UserName$]", "[$Admin$]", "[$OrgName$]",
							"[$OldRoleName$]", "[$NewRoleName$]",
							"[$OrgName$]", "[$Link$]" },
					new String[] { user.getScreenname(), adminName, orgName,
							roleName, applyRoleName, orgName,
							PortalUtil.getPortalURL(request) });

		}

		// 1: role of Organization; 0: role of ProGate
		List<ProGateRoles> roles = ProGateRolesLocalServiceUtil
				.getListRolesOfRootOrg();
		bean.put("roles", roles);

		int countDetailInformationUser = UserInformationViewLocalServiceUtil
				.getNumberOfDetailInformationUser(userId, filterRole,
						searchPhrase);

		bean.put("countDetailInformationUser", countDetailInformationUser);

		if (countDetailInformationUser > 0) {

			PaginationObject paginationUser = new PaginationObject("User",
					countDetailInformationUser);
			paginationUser.paging(request);
			bean.put("paginationUser", paginationUser);

			List<UserInformationView> users = UserInformationViewLocalServiceUtil
					.getDetailInformationUser(userId, filterRole, searchPhrase,
							paginationUser.getStartIndex(),
							paginationUser.getEndIndex());
			bean.put("users", users);

			System.out.println("users: " + users.size());
		}

		return new ModelAndView(this.getViewName(), "bean", bean);
	}
}