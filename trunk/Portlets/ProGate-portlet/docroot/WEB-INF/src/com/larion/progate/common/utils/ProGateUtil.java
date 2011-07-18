package com.larion.progate.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import larion.progate.model.Organization;
import larion.progate.model.ProGateRoles;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateRolesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;

import com.larion.progate.common.constants.ProgateRoleConst;
import com.larion.progate.common.constants.RSConstants;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.URLParameter_RS;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.ImageServletTokenUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;

public class ProGateUtil {

	public static String getImagePath(HttpServletRequest request) {
		String path = "";
		path = request.getContextPath() + "/images";
		return path;
	}

	/*
	 * 
	 * Author : HungPK Description : Generate public URL from a id
	 * (iGImageObject.getImageId(), iGImageObject.getSmallImageId())
	 */

	public static String getImageURL(long imageId, HttpServletRequest request) {

		ThemeDisplay td = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String url = td.getPathImage() + "/image_gallery?img_id=" + imageId
				+ "&t=" + ImageServletTokenUtil.getToken(imageId);

		return url;
	}

	public static String getConfigValue(PortletRequest request, String param,
			String defaultValue) throws Exception {

		PortletPreferences preferences = request.getPreferences();
		String portletResource = ParamUtil
				.getString(request, "portletResource");

		if (Validator.isNotNull(portletResource)) {
			preferences = PortletPreferencesFactoryUtil.getPortletSetup(
					request, portletResource);
		}

		return preferences.getValue(param, defaultValue);
	}

	public static String getConfigValue(PortletRequest request, String param)
			throws Exception {

		return getConfigValue(request, param, "");
	}

	public static void redirectToPageWithParams(ActionRequest request,
			ActionResponse response, String url, String[] params,
			String[] values) throws Exception {
		response.sendRedirect(buildRedirectUrl(request, url, params, values));
	}

	public static String buildParametersUrl(Layout layout,
			PortletRequest request) throws Exception {

		String description = layout.getTypeSettingsProperties().get(
				"meta-description_en_US");

		if (description == null || "".equals(description)) {
			return "";
		}

		String[] paramemters = null;
		if (description.contains("params")) {
			paramemters = description.substring("params".length() + 1).split(
					",");
		}

		return buildParametersUrl(request, paramemters);
	}

	public static String buildRedirectUrl(PortletRequest request, String url,
			String[] params, String[] values) throws Exception {

		String redirectURL = ProGateUtil.getConfigValue(request, url);

		if ("".equals(redirectURL)) {
			redirectURL = url;
		}

		return buildUrl(PortalUtil.getPortalURL(request) + StringPool.SLASH
				+ redirectURL, params, values);
	}

	public static String buildParametersUrl(PortletRequest request,
			String[] params) throws Exception {

		HttpServletRequest httpSR = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest origReq = PortalUtil
				.getOriginalServletRequest(httpSR);

		HttpSession session = origReq.getSession();

		StringBuilder stringBuilder = new StringBuilder();

		if (Validator.isNotNull(params)) {
			if (params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					if (i == 0) {
						stringBuilder.append(StringPool.QUESTION);
					} else {
						stringBuilder.append(StringPool.AMPERSAND);
					}

					String value = ParamUtil.getString(origReq, params[i], "0");

					if ("0".equals(value)) {

						if (session.getAttribute(params[i]) != null) {
							value = GetterUtil.getString(
									session.getAttribute(params[i]).toString(),
									"0");
						}
					}

					stringBuilder.append(params[i] + StringPool.EQUAL + value);
				}
			}
		}

		return stringBuilder.toString();
	}

	public static String buildUrl(String url, String[] params, String[] values)
			throws Exception {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(url);

		if (Validator.isNotNull(params)) {
			if (params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					if (i == 0) {
						stringBuilder.append(StringPool.QUESTION);
					} else {
						stringBuilder.append(StringPool.AMPERSAND);
					}
					stringBuilder.append(params[i] + StringPool.EQUAL
							+ values[i]);
				}
			}
		}

		return stringBuilder.toString();
	}

	public static void setConfigParamsToBean(PortletRequest request,
			Map<String, Object> bean) throws Exception {

		PortletPreferences preferences = request.getPreferences();
		String portletResource = ParamUtil
				.getString(request, "portletResource");

		if (Validator.isNotNull(portletResource)) {
			preferences = PortletPreferencesFactoryUtil.getPortletSetup(
					request, portletResource);
		}

		Enumeration<String> names = preferences.getNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = preferences.getValue(name, "");
			// System.out.println("Name: " + name + " - Value: " + value);
			bean.put(name, value);
		}
	}

	public static boolean checkActionPermission(PortletRequest request,
			int orgId, int viewMode) throws Exception {

		if (isAdminOfOrg(request, orgId)) {
			if (viewMode == RSConstants.EDIT_MODE) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public static boolean isAdminOfOrg(PortletRequest request, int orgId)
			throws Exception {
		// Get User
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();
		List<String> listRole = ProgateOrganizationParticipantsLocalServiceUtil
				.getUserRoles(userId, orgId);

		for (String role : listRole) {
			if (ProgateRoleConst.PROGATE_ADMIN.equals(role)
					|| ProgateRoleConst.ORG_ADMIN.equals(role)
					|| ProgateRoleConst.ORG_OWNER.equals(role)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isEditable(long userId, int orgId) throws Exception {

		List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil
				.getUserRoles(userId, orgId);

		for (String role : listRole) {
			if (ProgateRoleConst.PROGATE_ADMIN.equals(role)
					|| ProgateRoleConst.ORG_ADMIN.equals(role)
					|| ProgateRoleConst.ORG_OWNER.equals(role)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Author : HungPK Description : Check if current mode is Organization's
	 * EditMode Created Date: Jan 25, 2011
	 */
	public static boolean isEditMode(HttpServletRequest servletRequest)
			throws Exception {

		String viewMode = servletRequest
				.getParameter(URLParameter_RS.VIEW_MODE);
		boolean ret = false;
		if (viewMode != null) {
			ret = viewMode.equals(String.valueOf(URLParameter_RS.EDIT_MODE));
		}

		return ret;
	}

	/*
	 * Author : HungPK Description : Check if current mode is Organization's
	 * EditMode Created Date: Jan 25, 2011
	 */
	public static Organization getOrganization(HttpServletRequest servletRequest)
			throws Exception {
		String orgId = servletRequest.getParameter(URLParameter_RS.ORG_ID);
		Organization org = OrganizationLocalServiceUtil.getOrganization(Integer
				.valueOf(orgId));
		return org;
	}

	public static void servletPrint(ActionResponse response, String content)
			throws IOException {
		HttpServletResponse servletResponse = PortalUtil
				.getHttpServletResponse(response);
		PrintWriter writer = servletResponse.getWriter();
		writer.print(content);
		writer.flush();
	}

	/*
	 * Author : HungPK Description : Check if current mode is Organization's
	 * EditMode Created Date: Jan 25, 2011
	 */
	public static int getOrganizationId(HttpServletRequest httpServletRequest)
			throws Exception {

		int orgId = ParamUtil.getInteger(httpServletRequest,
				URLParameter_RS.ORG_ID, 0);

		if (orgId == 0) {

			HttpSession session = httpServletRequest.getSession();

			if (session.getAttribute(URLParameter_RS.ORG_ID) != null) {
				orgId = GetterUtil
						.getInteger(session
								.getAttribute(URLParameter_RS.ORG_ID)
								.toString(), 0);
			}
		}
		return orgId;
	}

	public static void setMessageStatus(HttpServletRequest request,
			ActionResponse response, int status) {

		response.setRenderParameter(Request.MESSAGE_STATUS,
				String.valueOf(status));

		response.setRenderParameter(Request.SUCCESS_MESSAGE,
				ParamUtil.getString(request, Request.SUCCESS_MESSAGE, ""));

		response.setRenderParameter(Request.FAIL_MESSAGE,
				ParamUtil.getString(request, Request.FAIL_MESSAGE, ""));
	}

	public static void setMessageStatus(ActionRequest request,
			ActionResponse response, int status) {

		response.setRenderParameter(Request.MESSAGE_STATUS,
				String.valueOf(status));

		response.setRenderParameter(Request.SUCCESS_MESSAGE,
				ParamUtil.getString(request, Request.SUCCESS_MESSAGE, ""));

		response.setRenderParameter(Request.FAIL_MESSAGE,
				ParamUtil.getString(request, Request.FAIL_MESSAGE, ""));
	}

	public static void setMessageToBean(PortletRequest request,
			Map<String, Object> bean) {

		bean.put(Request.MESSAGE_STATUS,
				ParamUtil.getInteger(request, Request.MESSAGE_STATUS, 0));

		bean.put(Request.SUCCESS_MESSAGE,
				ParamUtil.getString(request, Request.SUCCESS_MESSAGE, ""));

		bean.put(Request.FAIL_MESSAGE,
				ParamUtil.getString(request, Request.FAIL_MESSAGE, ""));
	}

	public static void setRolesToBean(int loginUserId, int rootOrgId,
			int selectedOrgId, Map<String, Object> bean) throws Exception {
		List<ProGateRoles> rolesofUserInSelectedOrg = ProgateOrganizationParticipantsLocalServiceUtil
				.getRolesOfUserInOrg(loginUserId, selectedOrgId);

		boolean isOrgManager = false;
		boolean isOrgAdmin = false;
		boolean isOrgStaff = false;

		for (ProGateRoles proGateRoles : rolesofUserInSelectedOrg) {

			System.out.println("role of user: " + proGateRoles.getRoleId());

			if (proGateRoles.getRoleId() == ProGateRolesLocalServiceUtil
					.getManagerRoleId()
					|| proGateRoles.getRoleId() == ProGateRolesLocalServiceUtil
							.getBodRoleId()) {

				isOrgManager = true;
			}

			if (proGateRoles.getRoleId() == ProGateRolesLocalServiceUtil
					.getOrgAdminRoleId()) {

				isOrgAdmin = true;
			}

			if (proGateRoles.getRoleId() == ProGateRolesLocalServiceUtil
					.getStaffOfRoleId()) {

				isOrgStaff = true;
			}
		}

		bean.put("isOrgManager", isOrgManager);
		bean.put("isOrgAdmin", isOrgAdmin);
		bean.put("isOrgStaff", isOrgStaff);

		List<ProGateRoles> rolesofUserInRootOrg = ProgateOrganizationParticipantsLocalServiceUtil
				.getRolesOfUserInOrg(loginUserId, rootOrgId);

		boolean isRootOrgOwner = false;
		boolean isRootOrgAdmin = false;
		boolean isRootOrgMember = false;

		for (ProGateRoles proGateRoles : rolesofUserInRootOrg) {

			if (proGateRoles.getRoleId() == ProGateRolesLocalServiceUtil
					.getOwnerRoleId()) {

				isRootOrgOwner = true;
			}

			if (proGateRoles.getRoleId() == ProGateRolesLocalServiceUtil
					.getOrgAdminRoleId()) {

				isRootOrgAdmin = true;
			}

			if (proGateRoles.getRoleId() == ProGateRolesLocalServiceUtil
					.getOrgMemberRoleId()) {

				isRootOrgMember = true;
			}

		}

		bean.put("isRootOrgOwner", isRootOrgOwner);
		bean.put("isRootOrgAdmin", isRootOrgAdmin);
		bean.put("isRootOrgMember", isRootOrgMember);
	}

	public static boolean hasAncestor(Layout currentLayout, long ancestorLayoutId)
			throws PortalException, SystemException {

		boolean result = false;

		long parentLayoutId = currentLayout.getParentLayoutId();

		while (parentLayoutId != 0) {
			if (parentLayoutId == ancestorLayoutId) {
				result = true;
				break;
			} else {
				Layout parentLayout = LayoutLocalServiceUtil.getLayout(
						currentLayout.getGroupId(),
						currentLayout.isPrivateLayout(), parentLayoutId);

				parentLayoutId = parentLayout.getParentLayoutId();
			}
		}

		return result;
	}
}
