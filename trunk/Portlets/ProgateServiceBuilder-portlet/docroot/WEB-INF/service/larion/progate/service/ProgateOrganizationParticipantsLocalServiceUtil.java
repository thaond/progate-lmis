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
 * <a href="ProgateOrganizationParticipantsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationParticipantsLocalServiceUtil {
	public static larion.progate.model.ProgateOrganizationParticipants addProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addProgateOrganizationParticipants(progateOrganizationParticipants);
	}

	public static larion.progate.model.ProgateOrganizationParticipants createProgateOrganizationParticipants(
		java.lang.Integer ProgateOrganizationParticipantsId) {
		return getService()
				   .createProgateOrganizationParticipants(ProgateOrganizationParticipantsId);
	}

	public static void deleteProgateOrganizationParticipants(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteProgateOrganizationParticipants(ProgateOrganizationParticipantsId);
	}

	public static void deleteProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteProgateOrganizationParticipants(progateOrganizationParticipants);
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

	public static larion.progate.model.ProgateOrganizationParticipants getProgateOrganizationParticipants(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getProgateOrganizationParticipants(ProgateOrganizationParticipantsId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> getProgateOrganizationParticipantses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProgateOrganizationParticipantses(start, end);
	}

	public static int getProgateOrganizationParticipantsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProgateOrganizationParticipantsesCount();
	}

	public static larion.progate.model.ProgateOrganizationParticipants updateProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateProgateOrganizationParticipants(progateOrganizationParticipants);
	}

	public static larion.progate.model.ProgateOrganizationParticipants updateProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateProgateOrganizationParticipants(progateOrganizationParticipants,
			merge);
	}

	public static boolean sendRequestToJoin(int userId, int requestUserId,
		int orgId, java.lang.String reason) {
		return getService()
				   .sendRequestToJoin(userId, requestUserId, orgId, reason);
	}

	public static boolean deleteMemberFromOrganization(int userId,
		int requestUserId, int approveUserId, int orgId, java.lang.String reason) {
		return getService()
				   .deleteMemberFromOrganization(userId, requestUserId,
			approveUserId, orgId, reason);
	}

	public static boolean inviteUserToJoin(int userId, int requestUserId,
		int orgId, java.lang.String reason) {
		return getService()
				   .inviteUserToJoin(userId, requestUserId, orgId, reason);
	}

	public static boolean deleteUserFromInvitedUsers(int userId,
		int requestUserId, int approveUserId, int orgId, java.lang.String reason) {
		return getService()
				   .deleteUserFromInvitedUsers(userId, requestUserId,
			approveUserId, orgId, reason);
	}

	public static boolean acceptTheRequest(int userId, int approveUserId,
		int orgId, java.lang.String reason) {
		return getService()
				   .acceptTheRequest(userId, approveUserId, orgId, reason);
	}

	public static boolean rejectTheRequest(int userId, int approveUserId,
		int orgId, java.lang.String reason) {
		return getService()
				   .rejectTheRequest(userId, approveUserId, orgId, reason);
	}

	public static boolean leaveOrganization(int userId, int requestUserId,
		int approveUserId, int orgId, java.lang.String reason) {
		return getService()
				   .leaveOrganization(userId, requestUserId, approveUserId,
			orgId, reason);
	}

	public static larion.progate.model.ProgateOrganizationParticipants addParticipant(
		int userId, int requestUserId, java.util.Date requestDate,
		int approveUserId, java.util.Date approveDate, int orgId, int roleId,
		int status, java.lang.String reason) throws java.lang.Exception {
		return getService()
				   .addParticipant(userId, requestUserId, requestDate,
			approveUserId, approveDate, orgId, roleId, status, reason);
	}

	public static void addToStaff(int userId, int orgId, int participantId)
		throws java.lang.Exception {
		getService().addToStaff(userId, orgId, participantId);
	}

	public static void changeStatusCurrentParticipants(int userId, int orgId,
		boolean isCurrent) throws java.lang.Exception {
		getService().changeStatusCurrentParticipants(userId, orgId, isCurrent);
	}

	public static larion.progate.model.ProgateOrganizationParticipants getCurrentParticipant(
		int userId, int orgId) throws java.lang.Exception {
		return getService().getCurrentParticipant(userId, orgId);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> getRolesOfUserInOrg(
		int userId, int orgId) {
		return getService().getRolesOfUserInOrg(userId, orgId);
	}

	public static boolean decentralizeRoleOfUserInOrg(int userId, int orgId,
		int roleId) {
		return getService().decentralizeRoleOfUserInOrg(userId, orgId, roleId);
	}

	public static boolean setRoleOfUserInOrg(int userId, int orgId, int roleId) {
		return getService().setRoleOfUserInOrg(userId, orgId, roleId);
	}

	public static java.util.List<larion.progate.model.User> getUsersWithSpecificRoleInOrganization(
		int roleId, int orgId) {
		return getService().getUsersWithSpecificRoleInOrganization(roleId, orgId);
	}

	public static larion.progate.model.User getOwnerOfOrganizaton(int orgId) {
		return getService().getOwnerOfOrganizaton(orgId);
	}

	public static larion.progate.model.User getManagerOfOrganizaton(int orgId) {
		return getService().getManagerOfOrganizaton(orgId);
	}

	public static larion.progate.model.User getAdminOfOrganizaton(int orgId) {
		return getService().getAdminOfOrganizaton(orgId);
	}

	public static boolean isAdminOfOrganization(int userId, int orgId) {
		return getService().isAdminOfOrganization(userId, orgId);
	}

	public static larion.progate.model.ProgateOrganizationParticipants getProgateOrganizationParticipantsObjectByUserIdAndOrgId(
		int userId, int orgId) {
		return getService()
				   .getProgateOrganizationParticipantsObjectByUserIdAndOrgId(userId,
			orgId);
	}

	public static larion.progate.model.ProgateOrganizationParticipants joinOrganization(
		long userId, int orgId, long requestBy, java.lang.String reason,
		int status) {
		return getService()
				   .joinOrganization(userId, orgId, requestBy, reason, status);
	}

	public static boolean appoveRejectJoinOrgRequest(int userId, int orgId,
		long approvedBy, int status, java.lang.String reason) {
		return getService()
				   .appoveRejectJoinOrgRequest(userId, orgId, approvedBy,
			status, reason);
	}

	public static boolean deleteJoinOrgRequest(int userId) {
		return getService().deleteJoinOrgRequest(userId);
	}

	public static void leaveOrganization(long userId, int orgId,
		long approvedtBy, java.lang.String reason) {
		getService().leaveOrganization(userId, orgId, approvedtBy, reason);
	}

	public static boolean isPendingRequest(long userId, int orgId) {
		return getService().isPendingRequest(userId, orgId);
	}

	public static void removeParticipantsFromOrganization(long userId,
		int orgId, int memberStatus) {
		getService()
			.removeParticipantsFromOrganization(userId, orgId, memberStatus);
	}

	public static void deleteParticipantsFromOrganization(int userId, int orgId) {
		getService().deleteParticipantsFromOrganization(userId, orgId);
	}

	public static java.util.List<String> getUserRoles(long userId, int orgId) {
		return getService().getUserRoles(userId, orgId);
	}

	public static java.util.List<String> getUserRoles(long userId) {
		return getService().getUserRoles(userId);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> getUserRolesId(
		long userId, int orgId) {
		return getService().getUserRolesId(userId, orgId);
	}

	public static larion.progate.model.ProgateOrganizationParticipants createRoleMemberWithoutOrg(
		long userId) {
		return getService().createRoleMemberWithoutOrg(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProgateOrganizationParticipantsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProgateOrganizationParticipantsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProgateOrganizationParticipantsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProgateOrganizationParticipantsLocalService service) {
		_service = service;
	}

	private static ProgateOrganizationParticipantsLocalService _service;
}