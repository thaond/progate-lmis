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
 * <a href="ProgateLayoutsMenusLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateLayoutsMenusLocalServiceUtil {
	public static larion.progate.model.ProgateLayoutsMenus addProgateLayoutsMenus(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus)
		throws com.liferay.portal.SystemException {
		return getService().addProgateLayoutsMenus(progateLayoutsMenus);
	}

	public static larion.progate.model.ProgateLayoutsMenus createProgateLayoutsMenus(
		int ProgateLayoutsMenusId) {
		return getService().createProgateLayoutsMenus(ProgateLayoutsMenusId);
	}

	public static void deleteProgateLayoutsMenus(int ProgateLayoutsMenusId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProgateLayoutsMenus(ProgateLayoutsMenusId);
	}

	public static void deleteProgateLayoutsMenus(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus)
		throws com.liferay.portal.SystemException {
		getService().deleteProgateLayoutsMenus(progateLayoutsMenus);
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

	public static larion.progate.model.ProgateLayoutsMenus getProgateLayoutsMenus(
		int ProgateLayoutsMenusId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProgateLayoutsMenus(ProgateLayoutsMenusId);
	}

	public static java.util.List<larion.progate.model.ProgateLayoutsMenus> getProgateLayoutsMenuses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProgateLayoutsMenuses(start, end);
	}

	public static int getProgateLayoutsMenusesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProgateLayoutsMenusesCount();
	}

	public static larion.progate.model.ProgateLayoutsMenus updateProgateLayoutsMenus(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus)
		throws com.liferay.portal.SystemException {
		return getService().updateProgateLayoutsMenus(progateLayoutsMenus);
	}

	public static larion.progate.model.ProgateLayoutsMenus updateProgateLayoutsMenus(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateProgateLayoutsMenus(progateLayoutsMenus, merge);
	}

	public static java.util.List<String> getMenuNamesByLayoutId(int layoutId)
		throws com.liferay.portal.SystemException {
		return getService().getMenuNamesByLayoutId(layoutId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProgateLayoutsMenusLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProgateLayoutsMenusLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProgateLayoutsMenusLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProgateLayoutsMenusLocalService service) {
		_service = service;
	}

	private static ProgateLayoutsMenusLocalService _service;
}