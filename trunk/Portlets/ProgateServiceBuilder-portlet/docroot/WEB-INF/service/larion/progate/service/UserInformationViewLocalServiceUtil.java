/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package larion.progate.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="UserInformationViewLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserInformationViewLocalServiceUtil {
	public static larion.progate.model.UserInformationView addUserInformationView(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException {
		return getService().addUserInformationView(userInformationView);
	}

	public static larion.progate.model.UserInformationView createUserInformationView(
		java.lang.String UserInformationViewId) {
		return getService().createUserInformationView(UserInformationViewId);
	}

	public static void deleteUserInformationView(
		java.lang.String UserInformationViewId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteUserInformationView(UserInformationViewId);
	}

	public static void deleteUserInformationView(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException {
		getService().deleteUserInformationView(userInformationView);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static larion.progate.model.UserInformationView getUserInformationView(
		java.lang.String UserInformationViewId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getUserInformationView(UserInformationViewId);
	}

	public static java.util.List<larion.progate.model.UserInformationView> getUserInformationViews(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getUserInformationViews(start, end);
	}

	public static int getUserInformationViewsCount()
		throws com.liferay.portal.SystemException {
		return getService().getUserInformationViewsCount();
	}

	public static larion.progate.model.UserInformationView updateUserInformationView(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException {
		return getService().updateUserInformationView(userInformationView);
	}

	public static larion.progate.model.UserInformationView updateUserInformationView(
		larion.progate.model.UserInformationView userInformationView,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateUserInformationView(userInformationView, merge);
	}

	public static java.util.List<larion.progate.model.UserInformationView> getMembersOfOrganization(
		int orgId, int roleId, java.lang.String searchPhrase, int start, int end) {
		return getService()
				   .getMembersOfOrganization(orgId, roleId, searchPhrase,
			start, end);
	}

	public static int getNumberOfMembersOfOrganization(int orgId, int roleId,
		java.lang.String searchPhrase) {
		return getService()
				   .getNumberOfMembersOfOrganization(orgId, roleId, searchPhrase);
	}

	public static java.util.List<larion.progate.model.User> getUsersToInvite(
		int orgId, java.lang.String searchPhrase, int start, int end) {
		return getService().getUsersToInvite(orgId, searchPhrase, start, end);
	}

	public static int getNumberOfUsersToInvite(int orgId,
		java.lang.String searchPhrase) {
		return getService().getNumberOfUsersToInvite(orgId, searchPhrase);
	}

	public static java.util.List<larion.progate.model.UserInformationView> getInvitedUsers(
		int orgId, java.lang.String searchPhrase, int start, int end) {
		return getService().getInvitedUsers(orgId, searchPhrase, start, end);
	}

	public static int getNumberOfInvitedUsers(int orgId,
		java.lang.String searchPhrase) {
		return getService().getNumberOfInvitedUsers(orgId, searchPhrase);
	}

	public static java.util.List<larion.progate.model.UserInformationView> getWaitingUsers(
		int orgId, int start, int end) {
		return getService().getWaitingUsers(orgId, start, end);
	}

	public static int getNumberOfWaitingUsers(int orgId) {
		return getService().getNumberOfWaitingUsers(orgId);
	}

	public static java.util.List<larion.progate.model.UserInformationView> getOldMembers(
		int orgId, int roleId, java.lang.String searchPhrase, int start, int end) {
		return getService()
				   .getOldMembers(orgId, roleId, searchPhrase, start, end);
	}

	public static int getNumberOfOldMembers(int orgId, int roleId,
		java.lang.String searchPhrase) {
		return getService().getNumberOfOldMembers(orgId, roleId, searchPhrase);
	}

	public static java.util.List<larion.progate.model.UserInformationView> getListUsersByFilter(
		int orgId, int roleId, int joiningStatus,
		java.lang.String searchPhrase, int start, int end) {
		return getService()
				   .getListUsersByFilter(orgId, roleId, joiningStatus,
			searchPhrase, start, end);
	}

	public static java.util.List<larion.progate.model.UserInformationView> getListUsersByFilter(
		int orgId, int roleId, int joiningStatus, java.lang.String searchPhrase) {
		return getService()
				   .getListUsersByFilter(orgId, roleId, joiningStatus,
			searchPhrase);
	}

	public static java.util.List<larion.progate.model.UserInformationView> getListUsersByFilter(
		int orgId, int roleId, int joiningStatus, java.lang.Boolean isCurrent,
		java.lang.String searchPhrase) {
		return getService()
				   .getListUsersByFilter(orgId, roleId, joiningStatus,
			isCurrent, searchPhrase);
	}

	public static java.util.List<larion.progate.model.User> getListUsers(
		int isProactive, int status, java.lang.String searchPhrase, int start,
		int end) {
		return getService()
				   .getListUsers(isProactive, status, searchPhrase, start, end);
	}

	public static int getNumberOfListUsers(int isProactive, int status,
		java.lang.String searchPhrase) {
		return getService()
				   .getNumberOfListUsers(isProactive, status, searchPhrase);
	}

	public static java.util.List<larion.progate.model.UserInformationView> getDetailInformationUser(
		int userId, int roleId, java.lang.String searchPhrase, int start,
		int end) {
		return getService()
				   .getDetailInformationUser(userId, roleId, searchPhrase,
			start, end);
	}

	public static int getNumberOfDetailInformationUser(int userId, int roleId,
		java.lang.String searchPhrase) {
		return getService()
				   .getNumberOfDetailInformationUser(userId, roleId,
			searchPhrase);
	}

	public static boolean updateUserRole(int userId, int orgId, int oldRoleId,
		int newRoleId) {
		return getService().updateUserRole(userId, orgId, oldRoleId, newRoleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserInformationViewLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					UserInformationViewLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new UserInformationViewLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(UserInformationViewLocalService service) {
		_service = service;
	}

	private static UserInformationViewLocalService _service;
}