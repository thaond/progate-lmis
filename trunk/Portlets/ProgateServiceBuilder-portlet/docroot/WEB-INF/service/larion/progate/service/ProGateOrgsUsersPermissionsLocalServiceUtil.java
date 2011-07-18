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
 * <a href="ProGateOrgsUsersPermissionsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgsUsersPermissionsLocalServiceUtil {
	public static larion.progate.model.ProGateOrgsUsersPermissions addProGateOrgsUsersPermissions(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addProGateOrgsUsersPermissions(proGateOrgsUsersPermissions);
	}

	public static larion.progate.model.ProGateOrgsUsersPermissions createProGateOrgsUsersPermissions(
		java.lang.Integer ProGateOrgsUsersPermissionsId) {
		return getService()
				   .createProGateOrgsUsersPermissions(ProGateOrgsUsersPermissionsId);
	}

	public static void deleteProGateOrgsUsersPermissions(
		java.lang.Integer ProGateOrgsUsersPermissionsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteProGateOrgsUsersPermissions(ProGateOrgsUsersPermissionsId);
	}

	public static void deleteProGateOrgsUsersPermissions(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteProGateOrgsUsersPermissions(proGateOrgsUsersPermissions);
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

	public static larion.progate.model.ProGateOrgsUsersPermissions getProGateOrgsUsersPermissions(
		java.lang.Integer ProGateOrgsUsersPermissionsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getProGateOrgsUsersPermissions(ProGateOrgsUsersPermissionsId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> getProGateOrgsUsersPermissionses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateOrgsUsersPermissionses(start, end);
	}

	public static int getProGateOrgsUsersPermissionsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateOrgsUsersPermissionsesCount();
	}

	public static larion.progate.model.ProGateOrgsUsersPermissions updateProGateOrgsUsersPermissions(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateOrgsUsersPermissions(proGateOrgsUsersPermissions);
	}

	public static larion.progate.model.ProGateOrgsUsersPermissions updateProGateOrgsUsersPermissions(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateOrgsUsersPermissions(proGateOrgsUsersPermissions,
			merge);
	}

	public static java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findGrantPermissions(
		int appId, int category, int orgId, int userId, java.lang.String perid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .findGrantPermissions(appId, category, orgId, userId, perid);
	}

	public static java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> getListGrantPermissions(
		int appId, int category, int orgId, int userId, int pmId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getListGrantPermissions(appId, category, orgId, userId, pmId);
	}

	public static boolean editGrantPermission(int appId, int category,
		int orgId, int userId,
		java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> userPermissions,
		int value, boolean isGrant, int pmId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .editGrantPermission(appId, category, orgId, userId,
			userPermissions, value, isGrant, pmId);
	}

	public static boolean addProGateOrgsUsersPermission(
		java.lang.String appName, int category, int orgId, int userId,
		java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> userPermissions,
		int value, boolean isGrant)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addProGateOrgsUsersPermission(appName, category, orgId,
			userId, userPermissions, value, isGrant);
	}

	public static boolean deleteProGateOrgsUsersPermission(
		java.lang.String appName, int category, int orgId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .deleteProGateOrgsUsersPermission(appName, category, orgId,
			userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateOrgsUsersPermissionsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateOrgsUsersPermissionsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateOrgsUsersPermissionsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateOrgsUsersPermissionsLocalService service) {
		_service = service;
	}

	private static ProGateOrgsUsersPermissionsLocalService _service;
}