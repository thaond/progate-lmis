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
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="UserInformationViewLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserInformationViewLocalServiceClp
	implements UserInformationViewLocalService {
	public UserInformationViewLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.model.UserInformationView addUserInformationView(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(userInformationView);

		if (userInformationView == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.UserInformationView");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addUserInformationView",
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

		return (larion.progate.model.UserInformationView)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.UserInformationView createUserInformationView(
		java.lang.String UserInformationViewId) {
		Object paramObj0 = ClpSerializer.translateInput(UserInformationViewId);

		if (UserInformationViewId == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createUserInformationView",
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

		return (larion.progate.model.UserInformationView)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteUserInformationView(
		java.lang.String UserInformationViewId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(UserInformationViewId);

		if (UserInformationViewId == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		try {
			_classLoaderProxy.invoke("deleteUserInformationView",
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

	public void deleteUserInformationView(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(userInformationView);

		if (userInformationView == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.UserInformationView");
		}

		try {
			_classLoaderProxy.invoke("deleteUserInformationView",
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

	public larion.progate.model.UserInformationView getUserInformationView(
		java.lang.String UserInformationViewId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(UserInformationViewId);

		if (UserInformationViewId == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getUserInformationView",
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

		return (larion.progate.model.UserInformationView)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.UserInformationView> getUserInformationViews(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getUserInformationViews",
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	public int getUserInformationViewsCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getUserInformationViewsCount",
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

	public larion.progate.model.UserInformationView updateUserInformationView(
		larion.progate.model.UserInformationView userInformationView)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(userInformationView);

		if (userInformationView == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.UserInformationView");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateUserInformationView",
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

		return (larion.progate.model.UserInformationView)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.UserInformationView updateUserInformationView(
		larion.progate.model.UserInformationView userInformationView,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(userInformationView);

		if (userInformationView == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.UserInformationView");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateUserInformationView",
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

		return (larion.progate.model.UserInformationView)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.UserInformationView> getMembersOfOrganization(
		int orgId, int roleId, java.lang.String searchPhrase, int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(start);

		Object paramObj4 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getMembersOfOrganization",
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	public int getNumberOfMembersOfOrganization(int orgId, int roleId,
		java.lang.String searchPhrase) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getNumberOfMembersOfOrganization",
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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<larion.progate.model.User> getUsersToInvite(
		int orgId, java.lang.String searchPhrase, int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new IntegerWrapper(start);

		Object paramObj3 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getUsersToInvite",
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

		return (java.util.List<larion.progate.model.User>)ClpSerializer.translateOutput(returnObj);
	}

	public int getNumberOfUsersToInvite(int orgId, java.lang.String searchPhrase) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getNumberOfUsersToInvite",
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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<larion.progate.model.UserInformationView> getInvitedUsers(
		int orgId, java.lang.String searchPhrase, int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new IntegerWrapper(start);

		Object paramObj3 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getInvitedUsers",
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	public int getNumberOfInvitedUsers(int orgId, java.lang.String searchPhrase) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getNumberOfInvitedUsers",
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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<larion.progate.model.UserInformationView> getWaitingUsers(
		int orgId, int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(start);

		Object paramObj2 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getWaitingUsers",
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	public int getNumberOfWaitingUsers(int orgId) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getNumberOfWaitingUsers",
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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<larion.progate.model.UserInformationView> getOldMembers(
		int orgId, int roleId, java.lang.String searchPhrase, int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(start);

		Object paramObj4 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getOldMembers",
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	public int getNumberOfOldMembers(int orgId, int roleId,
		java.lang.String searchPhrase) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getNumberOfOldMembers",
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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<larion.progate.model.UserInformationView> getListUsersByFilter(
		int orgId, int roleId, int joiningStatus,
		java.lang.String searchPhrase, int start, int end) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = new IntegerWrapper(joiningStatus);

		Object paramObj3 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = new IntegerWrapper(start);

		Object paramObj5 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListUsersByFilter",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.UserInformationView> getListUsersByFilter(
		int orgId, int roleId, int joiningStatus, java.lang.String searchPhrase) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = new IntegerWrapper(joiningStatus);

		Object paramObj3 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListUsersByFilter",
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.UserInformationView> getListUsersByFilter(
		int orgId, int roleId, int joiningStatus, java.lang.Boolean isCurrent,
		java.lang.String searchPhrase) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = new IntegerWrapper(joiningStatus);

		Object paramObj3 = ClpSerializer.translateInput(isCurrent);

		if (isCurrent == null) {
			paramObj3 = new NullWrapper("java.lang.Boolean");
		}

		Object paramObj4 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListUsersByFilter",
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.User> getListUsers(
		int isProactive, int status, java.lang.String searchPhrase, int start,
		int end) {
		Object paramObj0 = new IntegerWrapper(isProactive);

		Object paramObj1 = new IntegerWrapper(status);

		Object paramObj2 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(start);

		Object paramObj4 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListUsers",
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

		return (java.util.List<larion.progate.model.User>)ClpSerializer.translateOutput(returnObj);
	}

	public int getNumberOfListUsers(int isProactive, int status,
		java.lang.String searchPhrase) {
		Object paramObj0 = new IntegerWrapper(isProactive);

		Object paramObj1 = new IntegerWrapper(status);

		Object paramObj2 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getNumberOfListUsers",
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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<larion.progate.model.UserInformationView> getDetailInformationUser(
		int userId, int roleId, java.lang.String searchPhrase, int start,
		int end) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(start);

		Object paramObj4 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getDetailInformationUser",
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	public int getNumberOfDetailInformationUser(int userId, int roleId,
		java.lang.String searchPhrase) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getNumberOfDetailInformationUser",
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

		return ((Integer)returnObj).intValue();
	}

	public boolean updateUserRole(int userId, int orgId, int oldRoleId,
		int newRoleId) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(oldRoleId);

		Object paramObj3 = new IntegerWrapper(newRoleId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateUserRole",
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

	public java.util.List<larion.progate.model.UserInformationView> getRootOrgsOfUser(
		int userId, int roleId, java.lang.String searchPhrase, int start,
		int end) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = ClpSerializer.translateInput(searchPhrase);

		if (searchPhrase == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(start);

		Object paramObj4 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getRootOrgsOfUser",
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

		return (java.util.List<larion.progate.model.UserInformationView>)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}