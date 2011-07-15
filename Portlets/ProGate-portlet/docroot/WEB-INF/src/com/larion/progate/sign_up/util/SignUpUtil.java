package com.larion.progate.sign_up.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;

import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.ProGateUserApplicationsLocalServiceUtil;

public class SignUpUtil {
	/*
	 * method: addUser parameters: long creatorUserId, boolean autoPassword,
	 * java.lang.String password1, java.lang.String password2, boolean
	 * autoScreenName, java.lang.String screenName, java.lang.String
	 * emailAddress, java.lang.String openId, java.util.Locale locale,
	 * java.lang.String firstName, java.lang.String middleName, java.lang.String
	 * lastName, int prefixId, int suffixId, boolean male, int birthdayMonth,
	 * int birthdayDay, int birthdayYear, java.lang.String jobTitle, long[]
	 * groupIds, long[] organizationIds, long[] roleIds, long[] userGroupIds,
	 * boolean sendEmail, com.liferay.portal.service.ServiceContext
	 * serviceContext)
	 */
	public static String addUser(HashMap hm, ActionRequest req) {
		try {
			System.out.println("call function addUser start");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					User.class.getName(), req);

			ThemeDisplay themeDisplay = (ThemeDisplay) req
					.getAttribute(WebKeys.THEME_DISPLAY);

			long companyid = themeDisplay.getCompany().getCompanyId();
			long creatorUserId = UserLocalServiceUtil
					.getDefaultUserId(companyid);
			long groupId = GroupLocalServiceUtil.getGroup(companyid, "Guest")
					.getGroupId();
			long roleId = RoleLocalServiceUtil.getRole(companyid, "Guest")
					.getRoleId();
			long[] groupIds = new long[] { groupId };
			long[] roleIds = new long[] { roleId };

			System.out.println("UserLocalServiceUtil.addUser");

			User user = UserLocalServiceUtil.addUser(creatorUserId, companyid,
					false, (String) hm.get("password"),
					(String) hm.get("password"), false,
					(String) hm.get("username"), (String) hm.get("useremail"),
					"", Locale.getDefault(), (String) hm.get("firstname"), "",
					(String) hm.get("lastname"), 10, 48,
					Boolean.valueOf((String) hm.get("sex")),
					Integer.valueOf((String) hm.get("birthday_month")) - 1,
					Integer.valueOf((String) hm.get("birthday_day")),
					Integer.valueOf((String) hm.get("birthday_year")), "",
					groupIds, new long[] {}, roleIds, new long[] {}, true,
					serviceContext);
			long userId = user.getPrimaryKey();
			System.out.println("user.getPrimaryKey(): " + userId);

			UserLocalServiceUtil.updateActive(userId, false);
			return null;
		} catch (com.liferay.portal.DuplicateUserScreenNameException dup) {
			dup.printStackTrace();
			return "Tên đăng nhập hoặc Email đã được sử dụng";
		} catch (com.liferay.portal.UserScreenNameException dup) {
			dup.printStackTrace();
			return "Tên đăng nhập có chứa ký tự đặc biệt";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Có lỗi khi đăng ký.";
		}
	}

	/*
	 * 
	 */
	public static Integer activeAccount(String username, String email,
			RenderRequest req, RenderResponse res) {
		try {
			System.out.println("call function activeAccount start");

			long companyid = PortalUtil.getCompany(req).getCompanyId();
			long userId = UserLocalServiceUtil.getUserByEmailAddress(companyid,
					email).getUserId();
			System.out.println("userId: " + userId);
			Date createdate = UserLocalServiceUtil.getUserByScreenName(
					companyid, username).getCreateDate();
			Date sevendate = new Date(createdate.getTime()
					+ (1000 * 60 * 60 * 24 * 7));
			Date today = new Date();
			if (today.before(sevendate)) {
				System.out.println("Chua het han");
				User user = UserLocalServiceUtil.getUser(userId);

				System.out.println("get user: " + user.getUserId());
				boolean active = user.getActive();
				if (active) {
					return -2;
				} else {

					System.out.println("updateActive user true");
					UserLocalServiceUtil.updateActive(userId, true);

					System.out.println("createRoleMemberWithoutOrg");
					ProgateOrganizationParticipantsLocalServiceUtil
							.createRoleMemberWithoutOrg(userId);

					System.out.println("createDefaultAppForUser");
					ProGateUserApplicationsLocalServiceUtil
							.createDefaultAppForUser(userId);

					return 1;
				}
			} else {
				System.out.println("Expiration");
				UserLocalServiceUtil.deleteUser(userId);
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
