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
 * <a href="ProGateMenuViewLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateMenuViewLocalServiceUtil {
	public static larion.progate.model.ProGateMenuView addProGateMenuView(
		larion.progate.model.ProGateMenuView proGateMenuView)
		throws com.liferay.portal.SystemException {
		return getService().addProGateMenuView(proGateMenuView);
	}

	public static larion.progate.model.ProGateMenuView createProGateMenuView(
		java.lang.String name) {
		return getService().createProGateMenuView(name);
	}

	public static void deleteProGateMenuView(java.lang.String name)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProGateMenuView(name);
	}

	public static void deleteProGateMenuView(
		larion.progate.model.ProGateMenuView proGateMenuView)
		throws com.liferay.portal.SystemException {
		getService().deleteProGateMenuView(proGateMenuView);
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

	public static larion.progate.model.ProGateMenuView getProGateMenuView(
		java.lang.String name)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProGateMenuView(name);
	}

	public static java.util.List<larion.progate.model.ProGateMenuView> getProGateMenuViews(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateMenuViews(start, end);
	}

	public static int getProGateMenuViewsCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateMenuViewsCount();
	}

	public static larion.progate.model.ProGateMenuView updateProGateMenuView(
		larion.progate.model.ProGateMenuView proGateMenuView)
		throws com.liferay.portal.SystemException {
		return getService().updateProGateMenuView(proGateMenuView);
	}

	public static larion.progate.model.ProGateMenuView updateProGateMenuView(
		larion.progate.model.ProGateMenuView proGateMenuView, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateProGateMenuView(proGateMenuView, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateMenuViewLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateMenuViewLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateMenuViewLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateMenuViewLocalService service) {
		_service = service;
	}

	private static ProGateMenuViewLocalService _service;
}