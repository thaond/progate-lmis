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
 * <a href="ProGatePermissionsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGatePermissionsLocalServiceUtil {
	public static larion.progate.model.ProGatePermissions addProGatePermissions(
		larion.progate.model.ProGatePermissions proGatePermissions)
		throws com.liferay.portal.SystemException {
		return getService().addProGatePermissions(proGatePermissions);
	}

	public static larion.progate.model.ProGatePermissions createProGatePermissions(
		java.lang.String ProGatePermissionsId) {
		return getService().createProGatePermissions(ProGatePermissionsId);
	}

	public static void deleteProGatePermissions(
		java.lang.String ProGatePermissionsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProGatePermissions(ProGatePermissionsId);
	}

	public static void deleteProGatePermissions(
		larion.progate.model.ProGatePermissions proGatePermissions)
		throws com.liferay.portal.SystemException {
		getService().deleteProGatePermissions(proGatePermissions);
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

	public static larion.progate.model.ProGatePermissions getProGatePermissions(
		java.lang.String ProGatePermissionsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProGatePermissions(ProGatePermissionsId);
	}

	public static java.util.List<larion.progate.model.ProGatePermissions> getProGatePermissionses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGatePermissionses(start, end);
	}

	public static int getProGatePermissionsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGatePermissionsesCount();
	}

	public static larion.progate.model.ProGatePermissions updateProGatePermissions(
		larion.progate.model.ProGatePermissions proGatePermissions)
		throws com.liferay.portal.SystemException {
		return getService().updateProGatePermissions(proGatePermissions);
	}

	public static larion.progate.model.ProGatePermissions updateProGatePermissions(
		larion.progate.model.ProGatePermissions proGatePermissions,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateProGatePermissions(proGatePermissions, merge);
	}

	public static java.util.List<larion.progate.model.ProGatePermissions> findProGatePermissions(
		java.lang.String appName, int category)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().findProGatePermissions(appName, category);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGatePermissionsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGatePermissionsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGatePermissionsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGatePermissionsLocalService service) {
		_service = service;
	}

	private static ProGatePermissionsLocalService _service;
}