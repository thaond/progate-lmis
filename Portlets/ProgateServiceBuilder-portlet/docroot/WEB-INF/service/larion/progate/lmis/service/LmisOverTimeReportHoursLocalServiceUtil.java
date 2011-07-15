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

package larion.progate.lmis.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="LmisOverTimeReportHoursLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportHoursLocalServiceUtil {
	public static larion.progate.lmis.model.LmisOverTimeReportHours addLmisOverTimeReportHours(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours)
		throws com.liferay.portal.SystemException {
		return getService().addLmisOverTimeReportHours(lmisOverTimeReportHours);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours createLmisOverTimeReportHours(
		java.lang.Integer lmisOverTimeReportHoursId) {
		return getService()
				   .createLmisOverTimeReportHours(lmisOverTimeReportHoursId);
	}

	public static void deleteLmisOverTimeReportHours(
		java.lang.Integer lmisOverTimeReportHoursId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeReportHours(lmisOverTimeReportHoursId);
	}

	public static void deleteLmisOverTimeReportHours(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeReportHours(lmisOverTimeReportHours);
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

	public static larion.progate.lmis.model.LmisOverTimeReportHours getLmisOverTimeReportHours(
		java.lang.Integer lmisOverTimeReportHoursId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisOverTimeReportHours(lmisOverTimeReportHoursId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeReportHourses(start, end);
	}

	public static int getLmisOverTimeReportHoursesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeReportHoursesCount();
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours updateLmisOverTimeReportHours(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisOverTimeReportHours(lmisOverTimeReportHours);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours updateLmisOverTimeReportHours(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisOverTimeReportHours(lmisOverTimeReportHours, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisOverTimeReportHoursLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisOverTimeReportHoursLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisOverTimeReportHoursLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisOverTimeReportHoursLocalService service) {
		_service = service;
	}

	private static LmisOverTimeReportHoursLocalService _service;
}