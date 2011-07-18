package com.larion.progate.organization.user.management.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.Organization;
import larion.progate.model.ProGateRoles;
import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.model.User;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateRolesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.constants.ProgateRoleConst;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.SendMailConst;
import com.larion.progate.common.utils.ProGateUtil;
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
		try {
			int orgId = ParamUtil.getInteger(request, Request.SELECTED_ORG_ID,
					0);

			Organization _org = OrganizationLocalServiceUtil
					.getOrganization(orgId);

			int rootOrgId = ParamUtil.getInteger(request, Request.ROOT_ORG_ID,
					0);
			bean.put("rootOrgId", rootOrgId);

			boolean isRootOrg = false;
			if (_org.getOrgId() == _org.getRootId()) {
				isRootOrg = true;
			}
			bean.put("isRootOrg", isRootOrg);

			bean.put("org", _org);
			bean.put("orgId", orgId);

			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);

			int loginUserId = (int) themeDisplay.getUserId();
			boolean isOrgManager = false;
			boolean isOwner = false;
			boolean isOwnerOfRootOrg = false;
			boolean isAdminOfRootOrg = false;

			List<ProGateRoles> rolesOfLoginUser = ProgateOrganizationParticipantsLocalServiceUtil
					.getRolesOfUserInOrg(loginUserId, orgId);

			if (rolesOfLoginUser != null && rolesOfLoginUser.size() > 0) {
				if (rolesOfLoginUser.get(0).getName()
						.equals(ProgateRoleConst.ORG_MANAGER)) {
					isOrgManager = true;
				}

				if (rolesOfLoginUser.get(0).getName()
						.equals(ProgateRoleConst.ORG_OWNER)) {
					isOwner = true;
				}
			}

			List<ProGateRoles> rolesOfLoginUserInRootOrg = ProgateOrganizationParticipantsLocalServiceUtil
					.getRolesOfUserInOrg(loginUserId, rootOrgId);

			if (rolesOfLoginUserInRootOrg != null
					&& rolesOfLoginUserInRootOrg.size() > 0) {
				if (rolesOfLoginUserInRootOrg.get(0).getName()
						.equals(ProgateRoleConst.ORG_OWNER)) {
					isOwnerOfRootOrg = true;
				}

				if (rolesOfLoginUserInRootOrg.get(0).getName()
						.equals(ProgateRoleConst.ORG_ADMIN)) {
					isAdminOfRootOrg = true;
				}
			}

			bean.put("isOrgManager", isOrgManager);
			bean.put("isOwner", isOwner);

			int userId = ParamUtil.getInteger(request, Request.USER_ID, 0);
			bean.put("userId", userId);

			int applyRole = ParamUtil.getInteger(request,
					Request.APPLY_USER_ROLE, 1);

			// 1: role of Organization; 0: role of ProGate
			List<ProGateRoles> rolesByOrgId = ProGateRolesLocalServiceUtil
					.getListRolesByOrgId(orgId);

			List<ProGateRoles> roles = new ArrayList<ProGateRoles>();

			for (ProGateRoles proGateRoles : rolesByOrgId) {

				/*
				 * if (isOwner && isRootOrg) { if
				 * (!ProgateRoleConst.ORG_OWNER.equals(proGateRoles .getName()))
				 * { roles.add(proGateRoles); } }
				 */

				if (isOrgManager && !isRootOrg && !isOwnerOfRootOrg
						&& !isAdminOfRootOrg) {
					if (!ProgateRoleConst.ORG_MANAGER.equals(proGateRoles
							.getName())) {
						roles.add(proGateRoles);
					}
				} else {
					roles.add(proGateRoles);
				}
			}
			bean.put("roles", roles);

			User user = null;
			if (!"".equals(userId)) {
				user = UserLocalServiceUtil.getUser(userId);
			}
			bean.put("user", user);

			ProgateOrganizationParticipants participant = null;
			String oldRole = "";
			if (!"".equals(userId)) {
				participant = ProgateOrganizationParticipantsLocalServiceUtil
						.getCurrentParticipant(userId, orgId);

				oldRole = ProGateRolesLocalServiceUtil.getProGateRoles(
						participant.getRoleId()).getName();

				if ("BOD".equals(oldRole)) {
					oldRole = "Manager";
				}
				bean.put("oldRole", oldRole);
			}

			String cmd = ParamUtil.getString(request, Constants.CMD);

			if (Constants.SAVE.equals(cmd)) {

				ProgateOrganizationParticipantsLocalServiceUtil
						.decentralizeRoleOfUserInOrg(userId, orgId, applyRole);

				// Set old role of user again
				participant = ProgateOrganizationParticipantsLocalServiceUtil
						.getCurrentParticipant(userId, orgId);

				oldRole = ProGateRolesLocalServiceUtil.getProGateRoles(
						participant.getRoleId()).getName();
				bean.put("oldRole", oldRole);

				ProGateUtil.setMessageToBean(request, bean);
				bean.put(Request.MESSAGE_STATUS, Request.MESSAGE_STATUS_SUCCESS);

				String newRole = ProGateRolesLocalServiceUtil.getProGateRoles(
						applyRole).getName();

				/*
				 * Send mail here
				 */
				InternetAddress[] to = { new InternetAddress(
						user.getEmailaddress(), user.getScreenname()) };

				SendMailUtil mailSender = new SendMailUtil();
				mailSender.sendMail(
						to,
						SendMailConst.SET_PERMISSTION_CHILD_ORG,
						new String[] { "[$OrgName$]" },
						new String[] { _org.getName() },
						new String[] { "[$UserName$]", "[$Admin$]",
								"[$OrgName$]", "[$OldRoleName$]",
								"[$NewRoleName$]", "[$OrgName$]", "[$Link$]",
								"[$Admin$]" },
						new String[] { user.getScreenname(),
								themeDisplay.getUser().getScreenName(),
								_org.getName(), oldRole, newRole,
								_org.getName(),
								PortalUtil.getPortalURL(request),
								themeDisplay.getUser().getScreenName() });

			}
			bean.put("participant", participant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(this.getViewName(), "bean", bean);
	}
}