package com.larion.progate.organization.user.management.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.Organization;
import larion.progate.model.ProGateRoles;
import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.model.User;
import larion.progate.model.UserInformationView;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateRolesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.UserInformationViewLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.SendMailConst;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.larion.progate.common.utils.SendMailUtil;
import com.larion.progate.organization.user.management.business.SubOrg;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ManagingUserAction extends ParameterizableViewAction {

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		int loginUserId = (int) themeDisplay.getUserId();

		String tab = ParamUtil.getString(request, Request.TAB,
				Request.MEMBER_TAB);
		response.setRenderParameter(Request.TAB, tab);

		String cmd = ParamUtil.getString(request, Constants.CMD);

		int rootOrgId = ParamUtil.getInteger(request, Request.ROOT_ORG_ID, 0);
		response.setRenderParameter(Request.ROOT_ORG_ID,
				String.valueOf(rootOrgId));

		int selectedOrgId = ParamUtil.getInteger(request,
				Request.SELECTED_ORG_ID, 0);
		response.setRenderParameter(Request.SELECTED_ORG_ID,
				String.valueOf(selectedOrgId));

		String searchPhrase = ParamUtil
				.getString(request, Constants.SEARCH, "");
		response.setRenderParameter(Constants.SEARCH, searchPhrase);

		int filterRole = ParamUtil.getInteger(request,
				Request.FILTER_USER_ROLE, 0);
		response.setRenderParameter(Request.FILTER_USER_ROLE,
				String.valueOf(filterRole));

		int[] userIdList = ParamUtil.getIntegerValues(request, Request.USER_ID);

		if (Request.MEMBER_TAB.equals(tab)) {
			if (Constants.ADD.equals(cmd)) {
				int addedOrgId = ParamUtil.getInteger(request,
						Request.ADDED_ORG_ID, 0);

				for (int userId : userIdList) {

					ProgateOrganizationParticipants participant = ProgateOrganizationParticipantsLocalServiceUtil
							.addParticipant(
									userId,
									loginUserId,
									new Date(),
									loginUserId,
									new Date(),
									addedOrgId,
									ProGateRolesLocalServiceUtil
											.getStaffOfRoleId(),
									larion.progate.service.utils.Constants.ORG_USER_STATUS_USER_JOIN_ORG,
									"Add user to organization");

					if (participant != null) {
						User user = UserLocalServiceUtil.getUser(userId);
						String adminName = themeDisplay.getUser()
								.getScreenName();
						Organization rootOrg = OrganizationLocalServiceUtil
								.getOrganization(rootOrgId);
						Organization selectedOrg = OrganizationLocalServiceUtil
								.getOrganization(selectedOrgId);

						InternetAddress[] to = { new InternetAddress(
								user.getEmailaddress(), user.getScreenname()) };

						SendMailUtil mailSender = new SendMailUtil();
						mailSender.sendMail(
								to,
								SendMailConst.ADD_USER_TO_CHILD_ORG,
								new String[] { "[$OrgName$]" },
								new String[] { rootOrg.getName() },
								new String[] { "[$UserName$]", "[$Admin$]",
										"[$OrgName$]", "[$UserName$]",
										"[$OrgName$]", "[$Link$]" },
								new String[] { user.getScreenname(), adminName,
										rootOrg.getName(),
										user.getScreenname(),
										selectedOrg.getName(),
										PortalUtil.getPortalURL(request) });
					}
				}

				PaginationObject paginationUser = new PaginationObject(
						"User",
						UserInformationViewLocalServiceUtil
								.getNumberOfMembersOfOrganization(
										selectedOrgId, filterRole, searchPhrase));

				response.setRenderParameter(
						paginationUser.getCurrentPageName(),
						ParamUtil.getString(request,
								paginationUser.getCurrentPageName(), "1"));

				response.setRenderParameter(
						paginationUser.getPageSizeName(),
						ParamUtil.getString(request,
								paginationUser.getPageSizeName(), "20"));

				ProGateUtil.setMessageStatus(request, response,
						Request.MESSAGE_STATUS_SUCCESS);

			}

			if (Constants.DELETE.equals(cmd)) {
				for (int userId : userIdList) {

					ProgateOrganizationParticipantsLocalServiceUtil
							.deleteMemberFromOrganization(userId, loginUserId,
									loginUserId, selectedOrgId,
									"Delete User From Organization");

				}
				ProGateUtil.setMessageStatus(request, response,
						Request.MESSAGE_STATUS_SUCCESS);
			}
		}

		if (Request.INVITE_MEMBER_TAB.equals(tab)) {
			if (Constants.SUBSCRIBE.equals(cmd)) {

				Organization selectedOrg = OrganizationLocalServiceUtil
						.getOrganization(selectedOrgId);

				for (int userId : userIdList) {
					System.out.println("userId to invite: " + userId);
					boolean isSuccess = ProgateOrganizationParticipantsLocalServiceUtil
							.inviteUserToJoin(userId, loginUserId,
									selectedOrgId, "Invite User To Join");

					if (isSuccess) {
						User user = UserLocalServiceUtil.getUser(userId);
						InternetAddress[] to = { new InternetAddress(
								user.getEmailaddress(), user.getScreenname()) };

						SendMailUtil mailSender = new SendMailUtil();
						mailSender.sendMail(
								to,
								SendMailConst.INVITE_TO_JOIN,
								new String[] { "[$OrgName$]" },
								new String[] { selectedOrg.getName() },
								new String[] { "[$UserName$]", "[$OrgName$]",
										"[$Link$]" },
								new String[] { user.getScreenname(),
										selectedOrg.getName(),
										themeDisplay.getURLPortal() });
					}
				}

				ProGateUtil.setMessageStatus(request, response,
						Request.MESSAGE_STATUS_SUCCESS);
			}
		}

		if (Request.INVITED_MEMBER_TAB.equals(tab)) {
			if (Constants.DELETE.equals(cmd)) {
				for (int userId : userIdList) {
					boolean isSuccess = ProgateOrganizationParticipantsLocalServiceUtil
							.deleteUserFromInvitedUsers(userId, loginUserId,
									loginUserId, selectedOrgId,
									"Delete User From Invited Users");

					if (isSuccess) {
						User user = UserLocalServiceUtil.getUser(userId);
						Organization selectedOrg = OrganizationLocalServiceUtil
								.getOrganization(selectedOrgId);

						InternetAddress[] to = { new InternetAddress(
								user.getEmailaddress(), user.getScreenname()) };

						SendMailUtil mailSender = new SendMailUtil();
						mailSender
								.sendMail(
										to,
										SendMailConst.DELETE_USER_INVITATION_TO_JOIN_ORG,
										new String[] { "[$OrgName$]" },
										new String[] { selectedOrg.getName() },
										new String[] { "[$UserName$]",
												"[$Admin$]", "[$OrgName$]",
												"[$Admin$]" }, new String[] {
												user.getScreenname(),
												themeDisplay.getUser()
														.getScreenName(),
												selectedOrg.getName(),
												themeDisplay.getUser()
														.getScreenName() });
					}
				}

				ProGateUtil.setMessageStatus(request, response,
						Request.MESSAGE_STATUS_SUCCESS);
			}
		}

		if (Request.WAITING_MEMBER_TAB.equals(tab)) {
			if (Constants.APPROVE.equals(cmd)) {
				for (int userId : userIdList) {
					boolean isSuccess = ProgateOrganizationParticipantsLocalServiceUtil
							.acceptTheRequest(userId, loginUserId,
									selectedOrgId,
									"Approve the joining request of user");

					if (isSuccess) {
						User user = UserLocalServiceUtil.getUser(userId);
						Organization selectedOrg = OrganizationLocalServiceUtil
								.getOrganization(selectedOrgId);

						InternetAddress[] to = { new InternetAddress(
								user.getEmailaddress(), user.getScreenname()) };

						SendMailUtil mailSender = new SendMailUtil();
						mailSender
								.sendMail(to,
										SendMailConst.ORG_ACCEPT_REQUEST_JOIN,
										new String[] { "[$OrgName$]" },
										new String[] { selectedOrg.getName() },
										new String[] { "[$UserName$]",
												"[$OrgName$]", "[$Admin$]",
												"[$Admin$]" }, new String[] {
												user.getScreenname(),
												selectedOrg.getName(),
												themeDisplay.getUser()
														.getScreenName(),
												themeDisplay.getUser()
														.getScreenName() });
					}
				}

				ProGateUtil.setMessageStatus(request, response,
						Request.MESSAGE_STATUS_SUCCESS);
			}

			if (Constants.REJECT.equals(cmd)) {
				for (int userId : userIdList) {

					boolean isSuccess = ProgateOrganizationParticipantsLocalServiceUtil
							.rejectTheRequest(userId, loginUserId,
									selectedOrgId,
									"Reject the joining request of user");

					if (isSuccess) {
						User user = UserLocalServiceUtil.getUser(userId);
						Organization selectedOrg = OrganizationLocalServiceUtil
								.getOrganization(selectedOrgId);

						InternetAddress[] to = { new InternetAddress(
								user.getEmailaddress(), user.getScreenname()) };

						SendMailUtil mailSender = new SendMailUtil();
						mailSender
								.sendMail(to, SendMailConst.ORG_REFUSE_JOIN,
										new String[] { "[$OrgName$]" },
										new String[] { selectedOrg.getName() },
										new String[] { "[$UserName$]",
												"[$Admin$]", "[$OrgName$]",
												"[$Admin$]" }, new String[] {
												user.getScreenname(),
												themeDisplay.getUser()
														.getScreenName(),
												selectedOrg.getName(),
												themeDisplay.getUser()
														.getScreenName() });
					}
				}

				ProGateUtil.setMessageStatus(request, response,
						Request.MESSAGE_STATUS_SUCCESS);
			}
		}

		if (Request.OLD_MEMBER_TAB.equals(tab)) {

		}
	};

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
		try {

			int rootOrgId = ParamUtil.getInteger(request, Request.ROOT_ORG_ID,
					0);

			if (rootOrgId == 0) {
				HttpServletRequest httpSR = PortalUtil
						.getHttpServletRequest(request);
				HttpServletRequest origReq = PortalUtil
						.getOriginalServletRequest(httpSR);
				rootOrgId = ParamUtil.getInteger(origReq,
						URLParameter_RS.ORG_ID, 0);
			}
			if (rootOrgId != 0) {
				Organization org = OrganizationLocalServiceUtil
						.getOrganization(rootOrgId);
				bean.put("orgName", org.getName());
			}
			bean.put("rootOrgId", rootOrgId);

			int selectedOrgId = ParamUtil.getInteger(request,
					Request.SELECTED_ORG_ID, 0);

			if (selectedOrgId == 0) {
				selectedOrgId = rootOrgId;
			}
			bean.put(Request.SELECTED_ORG_ID, selectedOrgId);

			boolean isRootOrg = (rootOrgId == selectedOrgId) ? true : false;
			bean.put("isRootOrg", isRootOrg);

			String tab = ParamUtil.getString(request, Request.TAB,
					Request.MEMBER_TAB);

			if (!isRootOrg
					&& (!Request.MEMBER_TAB.equals(tab) && !Request.OLD_MEMBER_TAB
							.equals(tab))) {
				tab = Request.MEMBER_TAB;
			}
			bean.put("tab", tab);

			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);

			int loginUserId = (int) themeDisplay.getUserId();

			ProGateUtil.setRolesToBean(loginUserId, rootOrgId, selectedOrgId,
					bean);

			List<HashMap<Integer, String>> subOrgsOfRootOrgList = OrganizationLocalServiceUtil
					.getListSubOrgsOfRootOrg(selectedOrgId);

			List<SubOrg> subOrgList = new ArrayList<SubOrg>();
			for (HashMap<Integer, String> subOrgsOfRootOrg : subOrgsOfRootOrgList) {
				for (Integer key : subOrgsOfRootOrg.keySet()) {
					SubOrg subOrg = new SubOrg(key, subOrgsOfRootOrg.get(key));
					subOrgList.add(subOrg);
				}
			}
			bean.put("subOrgList", subOrgList);

			String searchPhrase = ParamUtil.getString(request,
					Constants.SEARCH, "");
			bean.put("searchPhrase", searchPhrase);

			int filterRole = ParamUtil.getInteger(request,
					Request.FILTER_USER_ROLE, 0);
			bean.put("filterRole", filterRole);

			// 1: role of Organization; 0: role of ProGate
			List<ProGateRoles> roles = ProGateRolesLocalServiceUtil
					.getListRolesByOrgId(selectedOrgId);
			bean.put("roles", roles);

			int countListUsers = 0;

			List<UserInformationView> users = null;

			if (Request.MEMBER_TAB.equals(tab)) {
				countListUsers = UserInformationViewLocalServiceUtil
						.getNumberOfMembersOfOrganization(selectedOrgId,
								filterRole, searchPhrase);

				if (countListUsers > 0) {
					PaginationObject paginationUser = new PaginationObject(
							"User", countListUsers);
					paginationUser.paging(request);
					bean.put("paginationUser", paginationUser);

					users = UserInformationViewLocalServiceUtil
							.getMembersOfOrganization(selectedOrgId,
									filterRole, searchPhrase,
									paginationUser.getStartIndex(),
									paginationUser.getEndIndex());

					System.out.println("users MEMBER_TAB: " + users.size());
				}
			}

			if (Request.INVITE_MEMBER_TAB.equals(tab)) {

				countListUsers = UserInformationViewLocalServiceUtil
						.getNumberOfUsersToInvite(selectedOrgId, searchPhrase);

				if (countListUsers > 0) {
					PaginationObject paginationUser = new PaginationObject(
							"User", countListUsers);
					paginationUser.paging(request);
					bean.put("paginationUser", paginationUser);

					List<User> userList = UserInformationViewLocalServiceUtil
							.getUsersToInvite(selectedOrgId, searchPhrase,
									paginationUser.getStartIndex(),
									paginationUser.getEndIndex());

					bean.put("userList", userList);
					System.out.println("users INVITE_MEMBER_TAB: "
							+ userList.size());
				}
			}

			if (Request.INVITED_MEMBER_TAB.equals(tab)) {

				countListUsers = UserInformationViewLocalServiceUtil
						.getNumberOfInvitedUsers(selectedOrgId, searchPhrase);

				if (countListUsers > 0) {
					PaginationObject paginationUser = new PaginationObject(
							"User", countListUsers);
					paginationUser.paging(request);
					bean.put("paginationUser", paginationUser);

					users = UserInformationViewLocalServiceUtil
							.getInvitedUsers(selectedOrgId, searchPhrase,
									paginationUser.getStartIndex(),
									paginationUser.getEndIndex());

					System.out.println("users INVITED_MEMBER_TAB: "
							+ users.size());
				}
			}

			if (Request.WAITING_MEMBER_TAB.equals(tab)) {

				countListUsers = UserInformationViewLocalServiceUtil
						.getNumberOfWaitingUsers(selectedOrgId);

				if (countListUsers > 0) {
					PaginationObject paginationUser = new PaginationObject(
							"User", countListUsers);
					paginationUser.paging(request);
					bean.put("paginationUser", paginationUser);

					users = UserInformationViewLocalServiceUtil
							.getWaitingUsers(selectedOrgId,
									paginationUser.getStartIndex(),
									paginationUser.getEndIndex());

					System.out.println("users WAITING_MEMBER_TAB: "
							+ users.size());
				}
			}

			if (Request.OLD_MEMBER_TAB.equals(tab)) {

				countListUsers = UserInformationViewLocalServiceUtil
						.getNumberOfOldMembers(selectedOrgId, filterRole,
								searchPhrase);

				if (countListUsers > 0) {
					PaginationObject paginationUser = new PaginationObject(
							"User", countListUsers);
					paginationUser.paging(request);
					bean.put("paginationUser", paginationUser);

					users = UserInformationViewLocalServiceUtil.getOldMembers(
							selectedOrgId, filterRole, searchPhrase,
							paginationUser.getStartIndex(),
							paginationUser.getEndIndex());

					System.out.println("users OLD_MEMBER_TAB: " + users.size());
				}
			}

			bean.put("countListUsers", countListUsers);
			bean.put("users", users);

			ProGateUtil.setMessageToBean(request, bean);

			bean.put("MEMBER_TAB", Request.MEMBER_TAB);
			bean.put("INVITE_MEMBER_TAB", Request.INVITE_MEMBER_TAB);
			bean.put("INVITED_MEMBER_TAB", Request.INVITED_MEMBER_TAB);
			bean.put("WAITING_MEMBER_TAB", Request.WAITING_MEMBER_TAB);
			bean.put("OLD_MEMBER_TAB", Request.OLD_MEMBER_TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}