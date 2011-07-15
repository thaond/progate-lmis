package com.larion.progate.organization.management.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.text.ParseException;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.model.Organization;
import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.ActionRequestImpl;
import com.larion.progate.common.constants.ProgateRoleConst;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.constants.SendMailConst;
import com.larion.progate.common.utils.SendMailUtil;

public class NewManagingOrgAction extends PortletAction {

	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {

		SendMailUtil mailSender = new SendMailUtil();
		boolean isProGateAdmin = false;
		long userId = 0;
		String userEmail = "";
		String nameUser = "";
		try {
			// Get User
			com.liferay.portal.service.ServiceContext sc = ServiceContextFactory
					.getInstance(this.getClass().getName(), req);
			com.liferay.portal.model.User user = com.liferay.portal.service.UserLocalServiceUtil
					.getUser(sc.getUserId());
			userId = user.getUserId();
			userEmail = user.getEmailAddress();
			nameUser = user.getFirstName() + " " + user.getLastName();

			List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil
					.getUserRoles(userId);
			for (String role : listRole) {
				if (ProgateRoleConst.PROGATE_ADMIN.equals(role)) {
					isProGateAdmin = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");

		int orgParentId = 0;
		if (request.getParameter(URLParameter_RS.ORG_PARENT_ID) != null) {
			orgParentId = Integer.parseInt(request
					.getParameter(URLParameter_RS.ORG_PARENT_ID));
		}
		int orgRootId = 0;
		if (request.getParameter(URLParameter_RS.ORG_ROOT_ID) != null) {
			orgRootId = Integer.parseInt(request
					.getParameter(URLParameter_RS.ORG_ROOT_ID));
		}

		String orgName = (String) request.getParameter("orgName");
		if (orgName != null & orgName != "")
			orgName = orgName.trim();

		String orgType = (String) request.getParameter("orgType");
		int orgTypeOf = 0;

		if (orgRootId != 0) {
			orgTypeOf = 2;
		} else {
			orgTypeOf = ParamUtil.getInteger(request, "orgTypeOf");
		}
		String city = (String) request.getParameter("city");
		String email = (String) request.getParameter("email");
		String telephone = (String) request.getParameter("phone");
		if (telephone != null & telephone != "")
			telephone = telephone.trim();

		// System.out.println("email = " + email);

		String address = (String) request.getParameter("address");
		if (address != null & address != "")
			address = address.trim();

		String description = (String) request.getParameter("description");
		if (description != null & description != "")
			description = description.trim();

		// System.out.println("description = " + description);

		String maxUser = (String) request.getParameter("orgSize");
		String expiredDate = (String) request.getParameter("expiredDate");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date expirationDate = new Date();
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		ServletOutputStream output = response.getOutputStream();

		try {
			if (expiredDate != null)
				expirationDate = df.parse(expiredDate);
		} catch (ParseException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		String status = (String) request.getParameter("status");

		if (!isProGateAdmin) {
			Calendar newExpiredDate = Calendar.getInstance();
			newExpiredDate.add(Calendar.YEAR, 1);
			expirationDate = newExpiredDate.getTime();
			maxUser = "100";
		}

		try {
			String action = (String) request.getParameter("action");
			System.out.println("action = " + action);

			if (action.equals("create")) {
				Organization organization = null;
				System.out.println("create");
				if (orgParentId > 0) {
					organization = OrganizationLocalServiceUtil
							.createSubOrganization(orgParentId, userId,
									orgName, "", "", orgType, "VN", city,
									telephone, address,
									Integer.valueOf(maxUser), expirationDate,
									Boolean.valueOf(status), orgTypeOf, email);

				} else {
					organization = OrganizationLocalServiceUtil
							.createOrganization(userId, orgName, "", "",
									orgType, "VN", city, telephone, address,
									Integer.valueOf(maxUser), expirationDate,
									Boolean.valueOf(status), orgTypeOf, email);
				}

				if (organization != null) {
					// organization.setLevelSharing(orgTypeOf);
					// OrganizationLocalServiceUtil.updateOrganization(organization);

					String orgId = String.valueOf(organization.getPrimaryKey());
					String introType = ProGateJournalArticleTypesLocalServiceUtil
							.getArticleTypeOrgOverallIntro();

					ProGateJournalArticle introArticle = ProGateJournalArticleLocalServiceUtil
							.createNewArticle(orgId,
									Integer.valueOf(String.valueOf(userId)),
									"Introduction", introType, "", description,
									"", "", "");

					output.print("SUCCESS" + ";"
							+ String.valueOf(organization.getPrimaryKey()));
					output.flush();
					output.close();

					request.setAttribute("orgId",
							String.valueOf(organization.getPrimaryKey()));

					request.setAttribute("orgId",
							String.valueOf(organization.getPrimaryKey()));
					setForward(req, "portlet.NewManageOrg.org_create");
					return;
				} else {
					output.print("ERROR");
					output.flush();
					output.close();

					setForward(req, "portlet.NewManageOrg.org_create");
					return;
				}
			}
			if (action.equals("update")) {
				String orgId = (String) request.getParameter("orgId");
				Organization organization = OrganizationLocalServiceUtil
						.getOrganization(Integer.valueOf(orgId));

				organization.setName(orgName);
				organization.setOrgType(orgType);
				organization.setCity(city);
				organization.setPhone(telephone);
				organization.setAddress1(address);
				organization.setOrgStatus(Boolean.valueOf(status));
				organization.setLevelSharing(orgTypeOf);
				organization.setEmail(email);
				organization.setMaxUserCount(Integer.valueOf(maxUser));
				organization.setExpiredDate(expirationDate);

				// update phan gioi thieu org
				String introType = ProGateJournalArticleTypesLocalServiceUtil
						.getArticleTypeOrgOverallIntro();
				// Intro
				boolean isUpdateIntro = false;
				List<ProGateJournalArticle> listIntro = ProGateJournalArticleLocalServiceUtil
						.getListProGateArticles(Integer.valueOf(orgId),
								introType, "", 0, 2);
				if (listIntro != null) {
					if (listIntro.size() > 0) {
						isUpdateIntro = true;

						ProGateJournalArticle introArticle = listIntro.get(0);
						introArticle.setContent(description);

						ProGateJournalArticleLocalServiceUtil
								.updateProGateJournalArticle(introArticle, true);
					}
				}

				if (!isUpdateIntro) {
					ProGateJournalArticleLocalServiceUtil.createNewArticle(
							orgId, Integer.valueOf(String.valueOf(userId)),
							"Introduction", introType, "", description, "", "",
							"");
				}

				OrganizationLocalServiceUtil.updateOrganization(organization);

				output.print("SUCCESS" + ";"
						+ String.valueOf(organization.getPrimaryKey()));
				output.flush();
				output.close();

				request.setAttribute("orgId",
						String.valueOf(organization.getPrimaryKey()));

				setForward(req, "portlet.NewManageOrg.org_create");
				return;
			}

			if (action.equals("active")) {
				String orgId = (String) request.getParameter("orgId");
				Organization organization = OrganizationLocalServiceUtil
						.getOrganization(Integer.valueOf(orgId));
				organization.setIsProactive(true);
				OrganizationLocalServiceUtil.updateOrganization(organization);
				return;
			}

			if (action.equals("inactive")) {
				String orgId = (String) request.getParameter("orgId");
				Organization organization = OrganizationLocalServiceUtil
						.getOrganization(Integer.valueOf(orgId));
				organization.setIsProactive(false);
				OrganizationLocalServiceUtil.updateOrganization(organization);
				return;
			}

			if (action.equals("delete")) {
				String orgId = (String) request.getParameter("orgId");
				OrganizationLocalServiceUtil.deleteOrganization(Integer
						.valueOf(orgId));
				return;
			}
			if (action.equals("deleteManyOrg")) {
				String orgIds = (String) request.getParameter("orgIds");
				String[] ids = orgIds.split(";");
				for (String orgId : ids) {
					OrganizationLocalServiceUtil.deleteOrganization(Integer
							.valueOf(orgId));
				}
				return;
			}
			if (action.equals("disable")) {
				String orgId = (String) request.getParameter("orgId");
				Organization organization = OrganizationLocalServiceUtil
						.getOrganization(Integer.valueOf(orgId));
				organization.setOrgStatus(false);
				OrganizationLocalServiceUtil.updateOrganization(organization);
				return;
			}
			if (action.equals("enable")) {
				String orgId = (String) request.getParameter("orgId");
				Organization organization = OrganizationLocalServiceUtil
						.getOrganization(Integer.valueOf(orgId));
				organization.setOrgStatus(true);
				organization = OrganizationLocalServiceUtil
						.updateOrganization(organization);
				return;
			}

			if (action.equals("join")) {
				// System.out.println("join");
				String orgId = (String) request.getParameter("orgId");
				String reasonJoin = (String) request
						.getParameter("typeOfRequest");
				int typeOfRequest = 1;
				if (reasonJoin != null) {
					typeOfRequest = Integer.valueOf(reasonJoin);
				}

				Organization organization = OrganizationLocalServiceUtil
						.getOrganization(Integer.valueOf(orgId));
				String orgAdminEmail = organization.getEmail();
				String orgAdminName = "Org Admin";

				int levelSharing = organization.getLevelSharing();
				InternetAddress[] to = { new InternetAddress(orgAdminEmail,
						orgAdminName) };

				System.out.println("typeOfRequest: " + typeOfRequest);

				if (typeOfRequest == 1) {

					System.out.println("Request To Join with userId: " + userId
							+ " - orgId: " + Integer.valueOf(orgId));

					boolean isSuccess = ProgateOrganizationParticipantsLocalServiceUtil
							.sendRequestToJoin((int) userId, (int) userId,
									Integer.valueOf(orgId), "Request To Join");

					if (isSuccess) {
						if (levelSharing == 0) {

							mailSender.sendMail(to, SendMailConst.FREE_JOIN,
									new String[] { "[$OrgName$]" },
									new String[] { organization.getName() },
									new String[] { "[$OrgName$]",
											"[$UserName$]", "[$OrgName$]" },
									new String[] { organization.getName(),
											nameUser, organization.getName() });

						} else if (levelSharing == 1) {
							mailSender.sendMail(to,
									SendMailConst.REQUEST_TO_JOIN,
									new String[] { "[$UserName$]",
											"[$OrgName$]" }, new String[] {
											nameUser, organization.getName() },
									new String[] { "[$OrgName$]",
											"[$UserName$]", "[$OrgName$]" },
									new String[] { organization.getName(),
											nameUser, organization.getName() });
						}
					}
				} else if (typeOfRequest == 3) {

					System.out.println("Accept to join");

					boolean isSuccess = ProgateOrganizationParticipantsLocalServiceUtil
							.acceptTheRequest((int) userId, (int) userId,
									Integer.valueOf(orgId), "Accept To Join");

					if (isSuccess) {
						mailSender
								.sendMail(
										to,
										SendMailConst.INVITE_TO_JOIN_ACCEPTED,
										new String[] { "[$UserName$]",
												"[$OrgName$]" },
										new String[] { nameUser,
												organization.getName() },
										new String[] { "[$OrgName$]",
												"[$UserName$]", "[$OrgName$]" },
										new String[] { organization.getName(),
												nameUser,
												organization.getName() });
					}
				} else if (typeOfRequest == 4) {

					System.out.println("Reject To Join");

					boolean isSuccess = ProgateOrganizationParticipantsLocalServiceUtil
							.rejectTheRequest((int) userId, (int) userId,
									Integer.valueOf(orgId), "Reject To Join");

					if (isSuccess) {
						mailSender
								.sendMail(
										to,
										SendMailConst.INVITE_TO_JOIN_REJECTED,
										new String[] { "[$UserName$]",
												"[$OrgName$]" },
										new String[] { nameUser,
												organization.getName() },
										new String[] { "[$OrgName$]",
												"[$UserName$]", "[$OrgName$]" },
										new String[] { organization.getName(),
												nameUser,
												organization.getName() });
					}
				}

				return;
			}

			if (action.equals("leave")) {
				String orgId = (String) request.getParameter("orgId");
				Organization organization = OrganizationLocalServiceUtil
						.getOrganization(Integer.valueOf(orgId));
				String orgAdminEmail = organization.getEmail();
				String orgAdminName = "Org Admin";

				String reason = (String) request.getParameter("typeOfRequest");

				InternetAddress[] to = { new InternetAddress(orgAdminEmail,
						orgAdminName) };

				// 0: for Leave
				// 4: for Cancel Request
				if ("0".equals(reason)) {
					boolean isSuccess = ProgateOrganizationParticipantsLocalServiceUtil
							.leaveOrganization((int) userId, (int) userId,
									(int) userId, Integer.valueOf(orgId),
									"Leave org");

					if (isSuccess) {
						mailSender
								.sendMail(
										to,
										SendMailConst.FREE_LEAVE,
										new String[] { "[$UserName$]",
												"[$OrgName$]" },
										new String[] { nameUser,
												organization.getName() },
										new String[] { "[$OrgName$]",
												"[$UserName$]", "[$OrgName$]" },
										new String[] { organization.getName(),
												nameUser,
												organization.getName() });
					}
				} else if ("4".equals(reason)) {
					boolean isSuccess = ProgateOrganizationParticipantsLocalServiceUtil
							.rejectTheRequest((int) userId, (int) userId,
									Integer.valueOf(orgId), "Cancel To Join");

					if (isSuccess) {
						mailSender
								.sendMail(
										to,
										SendMailConst.REQUEST_TO_JOIN_CANCELED,
										new String[] { "[$UserName$]",
												"[$OrgName$]" },
										new String[] { nameUser,
												organization.getName() },
										new String[] { "[$OrgName$]",
												"[$UserName$]", "[$OrgName$]" },
										new String[] { organization.getName(),
												nameUser,
												organization.getName() });
					}
				}

				return;
			}

			if (action.equals("validateOrgName")) {
				String validateName = (String) request
						.getParameter("validateName");
				boolean isOrgNameExist = false;

				List<Organization> orgs = OrganizationLocalServiceUtil
						.getOrganizations(0, OrganizationLocalServiceUtil
								.getOrganizationsCount());
				if (orgs != null) {
					for (Organization organization : orgs) {
						if (validateName.equals(organization.getName())) {
							isOrgNameExist = true;
							break;
						}
					}
					if (isOrgNameExist) {
						output.print("ERROR");
						output.flush();
						output.close();
					} else {
						output.print("SUCCESS");
						output.flush();
						output.close();
					}
				}

				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			output.print("ERROR");
			output.flush();
			output.close();
			setForward(req, "portlet.NewManageOrg.org_create");
			return;
		}

	}
}
