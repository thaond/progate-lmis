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
 * <a href="ViewOrgUsersPermissionsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewOrgUsersPermissionsLocalServiceUtil {
	public static larion.progate.model.ViewOrgUsersPermissions addViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException {
		return getService().addViewOrgUsersPermissions(viewOrgUsersPermissions);
	}

	public static larion.progate.model.ViewOrgUsersPermissions createViewOrgUsersPermissions(
		java.lang.String id) {
		return getService().createViewOrgUsersPermissions(id);
	}

	public static void deleteViewOrgUsersPermissions(java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewOrgUsersPermissions(id);
	}

	public static void deleteViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException {
		getService().deleteViewOrgUsersPermissions(viewOrgUsersPermissions);
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

	public static larion.progate.model.ViewOrgUsersPermissions getViewOrgUsersPermissions(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewOrgUsersPermissions(id);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> getViewOrgUsersPermissionses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewOrgUsersPermissionses(start, end);
	}

	public static int getViewOrgUsersPermissionsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewOrgUsersPermissionsesCount();
	}

	public static larion.progate.model.ViewOrgUsersPermissions updateViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewOrgUsersPermissions(viewOrgUsersPermissions);
	}

	public static larion.progate.model.ViewOrgUsersPermissions updateViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewOrgUsersPermissions(viewOrgUsersPermissions, merge);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findOrgPermissions(
		int rootId, int roleId, java.lang.String appName, int category)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().findOrgPermissions(rootId, roleId, appName, category);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findUsersPermissions(
		int rootId, int userId, java.lang.String appName, int category,
		int priority, boolean delegate)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .findUsersPermissions(rootId, userId, appName, category,
			priority, delegate);
	}

	public static int getRoleIdByUserId(java.lang.String appName, int category,
		int rootId, int orgId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getRoleIdByUserId(appName, category, rootId, orgId, userId);
	}

	public static java.util.List<Integer> getListRoleIdByUserId(
		java.lang.String appName, int category, int rootId, int orgId,
		int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getListRoleIdByUserId(appName, category, rootId, orgId,
			userId);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> getListPermissions(
		java.lang.String appName, int category, int rootId, int orgId,
		int userId, boolean isRoot)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getListPermissions(appName, category, rootId, orgId,
			userId, isRoot);
	}

	public static boolean checkPermissions(java.lang.String appName,
		int category, int rootId, int orgId, int userId, boolean isRoot,
		java.lang.String perId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .checkPermissions(appName, category, rootId, orgId, userId,
			isRoot, perId);
	}

	public static int checkUserSpecialPermission(java.lang.String appName,
		int category, int rootId, int userId, java.lang.String perId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .checkUserSpecialPermission(appName, category, rootId,
			userId, perId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewOrgUsersPermissionsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewOrgUsersPermissionsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewOrgUsersPermissionsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewOrgUsersPermissionsLocalService service) {
		_service = service;
	}

	private static ViewOrgUsersPermissionsLocalService _service;
}