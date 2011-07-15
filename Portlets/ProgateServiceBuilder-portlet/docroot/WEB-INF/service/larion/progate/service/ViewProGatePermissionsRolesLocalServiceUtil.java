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
 * <a href="ViewProGatePermissionsRolesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewProGatePermissionsRolesLocalServiceUtil {
	public static larion.progate.model.ViewProGatePermissionsRoles addViewProGatePermissionsRoles(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addViewProGatePermissionsRoles(viewProGatePermissionsRoles);
	}

	public static larion.progate.model.ViewProGatePermissionsRoles createViewProGatePermissionsRoles(
		java.lang.String ProGatePermissionsRolesId) {
		return getService()
				   .createViewProGatePermissionsRoles(ProGatePermissionsRolesId);
	}

	public static void deleteViewProGatePermissionsRoles(
		java.lang.String ProGatePermissionsRolesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewProGatePermissionsRoles(ProGatePermissionsRolesId);
	}

	public static void deleteViewProGatePermissionsRoles(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteViewProGatePermissionsRoles(viewProGatePermissionsRoles);
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

	public static larion.progate.model.ViewProGatePermissionsRoles getViewProGatePermissionsRoles(
		java.lang.String ProGatePermissionsRolesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getViewProGatePermissionsRoles(ProGatePermissionsRolesId);
	}

	public static java.util.List<larion.progate.model.ViewProGatePermissionsRoles> getViewProGatePermissionsRoleses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewProGatePermissionsRoleses(start, end);
	}

	public static int getViewProGatePermissionsRolesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewProGatePermissionsRolesesCount();
	}

	public static larion.progate.model.ViewProGatePermissionsRoles updateViewProGatePermissionsRoles(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewProGatePermissionsRoles(viewProGatePermissionsRoles);
	}

	public static larion.progate.model.ViewProGatePermissionsRoles updateViewProGatePermissionsRoles(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewProGatePermissionsRoles(viewProGatePermissionsRoles,
			merge);
	}

	public static java.util.List<larion.progate.model.ViewProGatePermissionsRoles> findProGatePermissionsRoles(
		java.lang.String appName, int category, int roleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .findProGatePermissionsRoles(appName, category, roleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewProGatePermissionsRolesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewProGatePermissionsRolesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewProGatePermissionsRolesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewProGatePermissionsRolesLocalService service) {
		_service = service;
	}

	private static ViewProGatePermissionsRolesLocalService _service;
}