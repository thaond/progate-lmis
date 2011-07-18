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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;

/**
 * <a href="ProgateOrganizationParticipantsLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProgateOrganizationParticipantsLocalService {
	public larion.progate.model.ProgateOrganizationParticipants addProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants createProgateOrganizationParticipants(
		java.lang.Integer ProgateOrganizationParticipantsId);

	public void deleteProgateOrganizationParticipants(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProgateOrganizationParticipants getProgateOrganizationParticipants(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> getProgateOrganizationParticipantses(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProgateOrganizationParticipantsesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants updateProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants updateProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants,
		boolean merge) throws com.liferay.portal.SystemException;

	public boolean sendRequestToJoin(int userId, int requestUserId, int orgId,
		java.lang.String reason);

	public boolean deleteMemberFromOrganization(int userId, int requestUserId,
		int approveUserId, int orgId, java.lang.String reason);

	public boolean inviteUserToJoin(int userId, int requestUserId, int orgId,
		java.lang.String reason);

	public boolean deleteUserFromInvitedUsers(int userId, int requestUserId,
		int approveUserId, int orgId, java.lang.String reason);

	public boolean acceptTheRequest(int userId, int approveUserId, int orgId,
		java.lang.String reason);

	public boolean rejectTheRequest(int userId, int approveUserId, int orgId,
		java.lang.String reason);

	public boolean leaveOrganization(int userId, int requestUserId,
		int approveUserId, int orgId, java.lang.String reason);

	public larion.progate.model.ProgateOrganizationParticipants addParticipant(
		int userId, int requestUserId, java.util.Date requestDate,
		int approveUserId, java.util.Date approveDate, int orgId, int roleId,
		int status, java.lang.String reason) throws java.lang.Exception;

	public void addToStaff(int userId, int orgId, int participantId)
		throws java.lang.Exception;

	public void changeStatusCurrentParticipants(int userId, int orgId,
		boolean isCurrent) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProgateOrganizationParticipants getCurrentParticipant(
		int userId, int orgId) throws java.lang.Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateRoles> getRolesOfUserInOrg(
		int userId, int orgId);

	public boolean decentralizeRoleOfUserInOrg(int userId, int orgId, int roleId);

	public boolean setRoleOfUserInOrg(int userId, int orgId, int roleId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.User> getUsersWithSpecificRoleInOrganization(
		int roleId, int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.User getOwnerOfOrganizaton(int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.User getManagerOfOrganizaton(int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.User getAdminOfOrganizaton(int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isAdminOfOrganization(int userId, int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProgateOrganizationParticipants getProgateOrganizationParticipantsObjectByUserIdAndOrgId(
		int userId, int orgId);

	public larion.progate.model.ProgateOrganizationParticipants joinOrganization(
		long userId, int orgId, long requestBy, java.lang.String reason,
		int status);

	public boolean appoveRejectJoinOrgRequest(int userId, int orgId,
		long approvedBy, int status, java.lang.String reason);

	public boolean deleteJoinOrgRequest(int userId);

	public void leaveOrganization(long userId, int orgId, long approvedtBy,
		java.lang.String reason);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isPendingRequest(long userId, int orgId);

	public void removeParticipantsFromOrganization(long userId, int orgId,
		int memberStatus);

	public void deleteParticipantsFromOrganization(int userId, int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<String> getUserRoles(long userId, int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<String> getUserRoles(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateRoles> getUserRolesId(
		long userId, int orgId);

	public larion.progate.model.ProgateOrganizationParticipants createRoleMemberWithoutOrg(
		long userId);
}