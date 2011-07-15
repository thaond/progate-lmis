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
 * <a href="ProGateApplicationsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateApplicationsLocalServiceUtil {
	public static larion.progate.model.ProGateApplications addProGateApplications(
		larion.progate.model.ProGateApplications proGateApplications)
		throws com.liferay.portal.SystemException {
		return getService().addProGateApplications(proGateApplications);
	}

	public static larion.progate.model.ProGateApplications createProGateApplications(
		java.lang.Integer ProGateApplicationsId) {
		return getService().createProGateApplications(ProGateApplicationsId);
	}

	public static void deleteProGateApplications(
		java.lang.Integer ProGateApplicationsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProGateApplications(ProGateApplicationsId);
	}

	public static void deleteProGateApplications(
		larion.progate.model.ProGateApplications proGateApplications)
		throws com.liferay.portal.SystemException {
		getService().deleteProGateApplications(proGateApplications);
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

	public static larion.progate.model.ProGateApplications getProGateApplications(
		java.lang.Integer ProGateApplicationsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProGateApplications(ProGateApplicationsId);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> getProGateApplicationses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateApplicationses(start, end);
	}

	public static int getProGateApplicationsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateApplicationsesCount();
	}

	public static larion.progate.model.ProGateApplications updateProGateApplications(
		larion.progate.model.ProGateApplications proGateApplications)
		throws com.liferay.portal.SystemException {
		return getService().updateProGateApplications(proGateApplications);
	}

	public static larion.progate.model.ProGateApplications updateProGateApplications(
		larion.progate.model.ProGateApplications proGateApplications,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateProGateApplications(proGateApplications, merge);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> getListApplicationBaseOnUserId(
		int userId, int start, int end) {
		return getService().getListApplicationBaseOnUserId(userId, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateApplicationsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateApplicationsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateApplicationsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateApplicationsLocalService service) {
		_service = service;
	}

	private static ProGateApplicationsLocalService _service;
}