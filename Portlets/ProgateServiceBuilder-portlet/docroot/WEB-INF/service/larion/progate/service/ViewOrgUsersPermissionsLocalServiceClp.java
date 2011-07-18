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
 * <a href="ViewOrgUsersPermissionsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewOrgUsersPermissionsLocalServiceClp
	implements ViewOrgUsersPermissionsLocalService {
	public ViewOrgUsersPermissionsLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.model.ViewOrgUsersPermissions addViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewOrgUsersPermissions);

		if (viewOrgUsersPermissions == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ViewOrgUsersPermissions");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addViewOrgUsersPermissions",
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

		return (larion.progate.model.ViewOrgUsersPermissions)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ViewOrgUsersPermissions createViewOrgUsersPermissions(
		java.lang.String id) {
		Object paramObj0 = ClpSerializer.translateInput(id);

		if (id == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createViewOrgUsersPermissions",
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

		return (larion.progate.model.ViewOrgUsersPermissions)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteViewOrgUsersPermissions(java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(id);

		if (id == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		try {
			_classLoaderProxy.invoke("deleteViewOrgUsersPermissions",
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

	public void deleteViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewOrgUsersPermissions);

		if (viewOrgUsersPermissions == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ViewOrgUsersPermissions");
		}

		try {
			_classLoaderProxy.invoke("deleteViewOrgUsersPermissions",
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

	public larion.progate.model.ViewOrgUsersPermissions getViewOrgUsersPermissions(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(id);

		if (id == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getViewOrgUsersPermissions",
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

		return (larion.progate.model.ViewOrgUsersPermissions)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> getViewOrgUsersPermissionses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getViewOrgUsersPermissionses",
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

		return (java.util.List<larion.progate.model.ViewOrgUsersPermissions>)ClpSerializer.translateOutput(returnObj);
	}

	public int getViewOrgUsersPermissionsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getViewOrgUsersPermissionsesCount",
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

	public larion.progate.model.ViewOrgUsersPermissions updateViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewOrgUsersPermissions);

		if (viewOrgUsersPermissions == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ViewOrgUsersPermissions");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateViewOrgUsersPermissions",
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

		return (larion.progate.model.ViewOrgUsersPermissions)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ViewOrgUsersPermissions updateViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewOrgUsersPermissions);

		if (viewOrgUsersPermissions == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ViewOrgUsersPermissions");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateViewOrgUsersPermissions",
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

		return (larion.progate.model.ViewOrgUsersPermissions)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findOrgPermissions(
		int rootId, int roleId, java.lang.String appName, int category)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(roleId);

		Object paramObj2 = ClpSerializer.translateInput(appName);

		if (appName == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(category);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("findOrgPermissions",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
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

		return (java.util.List<larion.progate.model.ViewOrgUsersPermissions>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findUsersPermissions(
		int rootId, int userId, java.lang.String appName, int category,
		int priority, boolean delegate)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = ClpSerializer.translateInput(appName);

		if (appName == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(category);

		Object paramObj4 = new IntegerWrapper(priority);

		Object paramObj5 = new BooleanWrapper(delegate);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("findUsersPermissions",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
					});
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

		return (java.util.List<larion.progate.model.ViewOrgUsersPermissions>)ClpSerializer.translateOutput(returnObj);
	}

	public int getRoleIdByUserId(java.lang.String appName, int category,
		int rootId, int orgId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(appName);

		if (appName == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = new IntegerWrapper(category);

		Object paramObj2 = new IntegerWrapper(rootId);

		Object paramObj3 = new IntegerWrapper(orgId);

		Object paramObj4 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getRoleIdByUserId",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<Integer> getListRoleIdByUserId(
		java.lang.String appName, int category, int rootId, int orgId,
		int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(appName);

		if (appName == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = new IntegerWrapper(category);

		Object paramObj2 = new IntegerWrapper(rootId);

		Object paramObj3 = new IntegerWrapper(orgId);

		Object paramObj4 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListRoleIdByUserId",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
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

		return (java.util.List<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> getListPermissions(
		java.lang.String appName, int category, int rootId, int orgId,
		int userId, boolean isRoot)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(appName);

		if (appName == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = new IntegerWrapper(category);

		Object paramObj2 = new IntegerWrapper(rootId);

		Object paramObj3 = new IntegerWrapper(orgId);

		Object paramObj4 = new IntegerWrapper(userId);

		Object paramObj5 = new BooleanWrapper(isRoot);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListPermissions",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
					});
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

		return (java.util.List<larion.progate.model.ViewOrgUsersPermissions>)ClpSerializer.translateOutput(returnObj);
	}

	public boolean checkPermissions(java.lang.String appName, int category,
		int rootId, int orgId, int userId, boolean isRoot,
		java.lang.String perId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(appName);

		if (appName == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = new IntegerWrapper(category);

		Object paramObj2 = new IntegerWrapper(rootId);

		Object paramObj3 = new IntegerWrapper(orgId);

		Object paramObj4 = new IntegerWrapper(userId);

		Object paramObj5 = new BooleanWrapper(isRoot);

		Object paramObj6 = ClpSerializer.translateInput(perId);

		if (perId == null) {
			paramObj6 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("checkPermissions",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6
					});
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

		return ((Boolean)returnObj).booleanValue();
	}

	public int checkUserSpecialPermission(java.lang.String appName,
		int category, int rootId, int userId, java.lang.String perId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(appName);

		if (appName == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = new IntegerWrapper(category);

		Object paramObj2 = new IntegerWrapper(rootId);

		Object paramObj3 = new IntegerWrapper(userId);

		Object paramObj4 = ClpSerializer.translateInput(perId);

		if (perId == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("checkUserSpecialPermission",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
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

		return ((Integer)returnObj).intValue();
	}

	private ClassLoaderProxy _classLoaderProxy;
}