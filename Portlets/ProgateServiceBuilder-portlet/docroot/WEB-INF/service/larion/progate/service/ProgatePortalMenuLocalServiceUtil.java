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
 * <a href="ProgatePortalMenuLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgatePortalMenuLocalServiceUtil {
	public static larion.progate.model.ProgatePortalMenu addProgatePortalMenu(
		larion.progate.model.ProgatePortalMenu progatePortalMenu)
		throws com.liferay.portal.SystemException {
		return getService().addProgatePortalMenu(progatePortalMenu);
	}

	public static larion.progate.model.ProgatePortalMenu createProgatePortalMenu(
		java.lang.Integer portalMenuId) {
		return getService().createProgatePortalMenu(portalMenuId);
	}

	public static void deleteProgatePortalMenu(java.lang.Integer portalMenuId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProgatePortalMenu(portalMenuId);
	}

	public static void deleteProgatePortalMenu(
		larion.progate.model.ProgatePortalMenu progatePortalMenu)
		throws com.liferay.portal.SystemException {
		getService().deleteProgatePortalMenu(progatePortalMenu);
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

	public static larion.progate.model.ProgatePortalMenu getProgatePortalMenu(
		java.lang.Integer portalMenuId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProgatePortalMenu(portalMenuId);
	}

	public static java.util.List<larion.progate.model.ProgatePortalMenu> getProgatePortalMenus(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProgatePortalMenus(start, end);
	}

	public static int getProgatePortalMenusCount()
		throws com.liferay.portal.SystemException {
		return getService().getProgatePortalMenusCount();
	}

	public static larion.progate.model.ProgatePortalMenu updateProgatePortalMenu(
		larion.progate.model.ProgatePortalMenu progatePortalMenu)
		throws com.liferay.portal.SystemException {
		return getService().updateProgatePortalMenu(progatePortalMenu);
	}

	public static larion.progate.model.ProgatePortalMenu updateProgatePortalMenu(
		larion.progate.model.ProgatePortalMenu progatePortalMenu, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateProgatePortalMenu(progatePortalMenu, merge);
	}

	public static java.util.List<larion.progate.model.ProgatePortalMenu> getProgatePortalMenus(
		int orgId, int roleId, int start, int end) {
		return getService().getProgatePortalMenus(orgId, roleId, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProgatePortalMenuLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProgatePortalMenuLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProgatePortalMenuLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProgatePortalMenuLocalService service) {
		_service = service;
	}

	private static ProgatePortalMenuLocalService _service;
}