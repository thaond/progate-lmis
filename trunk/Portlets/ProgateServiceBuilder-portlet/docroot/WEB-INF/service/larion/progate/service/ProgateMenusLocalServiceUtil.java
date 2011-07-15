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
 * <a href="ProgateMenusLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateMenusLocalServiceUtil {
	public static larion.progate.model.ProgateMenus addProgateMenus(
		larion.progate.model.ProgateMenus progateMenus)
		throws com.liferay.portal.SystemException {
		return getService().addProgateMenus(progateMenus);
	}

	public static larion.progate.model.ProgateMenus createProgateMenus(
		int ProgateMenusId) {
		return getService().createProgateMenus(ProgateMenusId);
	}

	public static void deleteProgateMenus(int ProgateMenusId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProgateMenus(ProgateMenusId);
	}

	public static void deleteProgateMenus(
		larion.progate.model.ProgateMenus progateMenus)
		throws com.liferay.portal.SystemException {
		getService().deleteProgateMenus(progateMenus);
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

	public static larion.progate.model.ProgateMenus getProgateMenus(
		int ProgateMenusId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProgateMenus(ProgateMenusId);
	}

	public static java.util.List<larion.progate.model.ProgateMenus> getProgateMenuses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProgateMenuses(start, end);
	}

	public static int getProgateMenusesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProgateMenusesCount();
	}

	public static larion.progate.model.ProgateMenus updateProgateMenus(
		larion.progate.model.ProgateMenus progateMenus)
		throws com.liferay.portal.SystemException {
		return getService().updateProgateMenus(progateMenus);
	}

	public static larion.progate.model.ProgateMenus updateProgateMenus(
		larion.progate.model.ProgateMenus progateMenus, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateProgateMenus(progateMenus, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProgateMenusLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProgateMenusLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProgateMenusLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProgateMenusLocalService service) {
		_service = service;
	}

	private static ProgateMenusLocalService _service;
}