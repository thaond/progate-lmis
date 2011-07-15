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

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="ProgateOrganizationParticipantsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationParticipantsLocalServiceClp
	implements ProgateOrganizationParticipantsLocalService {
	public ProgateOrganizationParticipantsLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.model.ProgateOrganizationParticipants addProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(progateOrganizationParticipants);

		if (progateOrganizationParticipants == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProgateOrganizationParticipants");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addProgateOrganizationParticipants",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationParticipants createProgateOrganizationParticipants(
		java.lang.Integer ProgateOrganizationParticipantsId) {
		Object paramObj0 = ClpSerializer.translateInput(ProgateOrganizationParticipantsId);

		if (ProgateOrganizationParticipantsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createProgateOrganizationParticipants",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteProgateOrganizationParticipants(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(ProgateOrganizationParticipantsId);

		if (ProgateOrganizationParticipantsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteProgateOrganizationParticipants",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(progateOrganizationParticipants);

		if (progateOrganizationParticipants == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProgateOrganizationParticipants");
		}

		try {
			_classLoaderProxy.invoke("deleteProgateOrganizationParticipants",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object paramObj1 = new IntegerWrapper(start);

		Object paramObj2 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationParticipants getProgateOrganizationParticipants(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(ProgateOrganizationParticipantsId);

		if (ProgateOrganizationParticipantsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProgateOrganizationParticipants",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> getProgateOrganizationParticipantses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProgateOrganizationParticipantses",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProgateOrganizationParticipants>)ClpSerializer.translateOutput(returnObj);
	}

	public int getProgateOrganizationParticipantsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProgateOrganizationParticipantsesCount",
					new Object[0]);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public larion.progate.model.ProgateOrganizationParticipants updateProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(progateOrganizationParticipants);

		if (progateOrganizationParticipants == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProgateOrganizationParticipants");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProgateOrganizationParticipants",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationParticipants updateProgateOrganizationParticipants(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(progateOrganizationParticipants);

		if (progateOrganizationParticipants == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProgateOrganizationParticipants");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProgateOrganizationParticipants",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	public boolean sendRequestToJoin(int userId, int requestUserId, int orgId,
		java.lang.String reason) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(requestUserId);

		Object paramObj2 = new IntegerWrapper(orgId);

		Object paramObj3 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("sendRequestToJoin",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean deleteMemberFromOrganization(int userId, int requestUserId,
		int approveUserId, int orgId, java.lang.String reason) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(requestUserId);

		Object paramObj2 = new IntegerWrapper(approveUserId);

		Object paramObj3 = new IntegerWrapper(orgId);

		Object paramObj4 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("deleteMemberFromOrganization",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean inviteUserToJoin(int userId, int requestUserId, int orgId,
		java.lang.String reason) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(requestUserId);

		Object paramObj2 = new IntegerWrapper(orgId);

		Object paramObj3 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("inviteUserToJoin",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean deleteUserFromInvitedUsers(int userId, int requestUserId,
		int approveUserId, int orgId, java.lang.String reason) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(requestUserId);

		Object paramObj2 = new IntegerWrapper(approveUserId);

		Object paramObj3 = new IntegerWrapper(orgId);

		Object paramObj4 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("deleteUserFromInvitedUsers",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean acceptTheRequest(int userId, int approveUserId, int orgId,
		java.lang.String reason) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(approveUserId);

		Object paramObj2 = new IntegerWrapper(orgId);

		Object paramObj3 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("acceptTheRequest",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean rejectTheRequest(int userId, int approveUserId, int orgId,
		java.lang.String reason) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(approveUserId);

		Object paramObj2 = new IntegerWrapper(orgId);

		Object paramObj3 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("rejectTheRequest",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean leaveOrganization(int userId, int requestUserId,
		int approveUserId, int orgId, java.lang.String reason) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(requestUserId);

		Object paramObj2 = new IntegerWrapper(approveUserId);

		Object paramObj3 = new IntegerWrapper(orgId);

		Object paramObj4 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("leaveOrganization",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public larion.progate.model.ProgateOrganizationParticipants addParticipant(
		int userId, int requestUserId, java.util.Date requestDate,
		int approveUserId, java.util.Date approveDate, int orgId, int roleId,
		int status, java.lang.String reason) throws java.lang.Exception {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(requestUserId);

		Object paramObj2 = ClpSerializer.translateInput(requestDate);

		if (requestDate == null) {
			paramObj2 = new NullWrapper("java.util.Date");
		}

		Object paramObj3 = new IntegerWrapper(approveUserId);

		Object paramObj4 = ClpSerializer.translateInput(approveDate);

		if (approveDate == null) {
			paramObj4 = new NullWrapper("java.util.Date");
		}

		Object paramObj5 = new IntegerWrapper(orgId);

		Object paramObj6 = new IntegerWrapper(roleId);

		Object paramObj7 = new IntegerWrapper(status);

		Object paramObj8 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj8 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addParticipant",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8
					});
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	public void addToStaff(int userId, int orgId, int participantId)
		throws java.lang.Exception {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(participantId);

		try {
			_classLoaderProxy.invoke("addToStaff",
				new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void changeStatusCurrentParticipants(int userId, int orgId,
		boolean isCurrent) throws java.lang.Exception {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new BooleanWrapper(isCurrent);

		try {
			_classLoaderProxy.invoke("changeStatusCurrentParticipants",
				new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public larion.progate.model.ProgateOrganizationParticipants getCurrentParticipant(
		int userId, int orgId) throws java.lang.Exception {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCurrentParticipant",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateRoles> getRolesOfUserInOrg(
		int userId, int orgId) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getRolesOfUserInOrg",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProGateRoles>)ClpSerializer.translateOutput(returnObj);
	}

	public boolean decentralizeRoleOfUserInOrg(int userId, int orgId, int roleId) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(roleId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("decentralizeRoleOfUserInOrg",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean setRoleOfUserInOrg(int userId, int orgId, int roleId) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(roleId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("setRoleOfUserInOrg",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public java.util.List<larion.progate.model.User> getUsersWithSpecificRoleInOrganization(
		int roleId, int orgId) {
		Object paramObj0 = new IntegerWrapper(roleId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getUsersWithSpecificRoleInOrganization",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.User>)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.User getOwnerOfOrganizaton(int orgId) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getOwnerOfOrganizaton",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.User)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.User getManagerOfOrganizaton(int orgId) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getManagerOfOrganizaton",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.User)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationParticipants getProgateOrganizationParticipantsObjectByUserIdAndOrgId(
		int userId, int orgId) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProgateOrganizationParticipantsObjectByUserIdAndOrgId",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationParticipants joinOrganization(
		long userId, int orgId, long requestBy, java.lang.String reason,
		int status) {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new LongWrapper(requestBy);

		Object paramObj3 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = new IntegerWrapper(status);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("joinOrganization",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	public boolean appoveRejectJoinOrgRequest(int userId, int orgId,
		long approvedBy, int status, java.lang.String reason) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new LongWrapper(approvedBy);

		Object paramObj3 = new IntegerWrapper(status);

		Object paramObj4 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("appoveRejectJoinOrgRequest",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean deleteJoinOrgRequest(int userId) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("deleteJoinOrgRequest",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public void leaveOrganization(long userId, int orgId, long approvedtBy,
		java.lang.String reason) {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new LongWrapper(approvedtBy);

		Object paramObj3 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		try {
			_classLoaderProxy.invoke("leaveOrganization",
				new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public boolean isPendingRequest(long userId, int orgId) {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("isPendingRequest",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public void removeParticipantsFromOrganization(long userId, int orgId,
		int memberStatus) {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(memberStatus);

		try {
			_classLoaderProxy.invoke("removeParticipantsFromOrganization",
				new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteParticipantsFromOrganization(int userId, int orgId) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		try {
			_classLoaderProxy.invoke("deleteParticipantsFromOrganization",
				new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<String> getUserRoles(long userId, int orgId) {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getUserRoles",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<String>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<String> getUserRoles(long userId) {
		Object paramObj0 = new LongWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getUserRoles",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<String>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateRoles> getUserRolesId(
		long userId, int orgId) {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getUserRolesId",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProGateRoles>)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationParticipants createRoleMemberWithoutOrg(
		long userId) {
		Object paramObj0 = new LongWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createRoleMemberWithoutOrg",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationParticipants)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}