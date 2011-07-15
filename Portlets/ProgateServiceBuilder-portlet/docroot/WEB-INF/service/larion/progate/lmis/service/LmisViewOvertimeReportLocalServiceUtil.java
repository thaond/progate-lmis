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
 * <a href="LmisViewOvertimeReportLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewOvertimeReport addLmisViewOvertimeReport(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewOvertimeReport(lmisViewOvertimeReport);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport createLmisViewOvertimeReport(
		java.lang.Integer lmisViewOvertimeReportId) {
		return getService()
				   .createLmisViewOvertimeReport(lmisViewOvertimeReportId);
	}

	public static void deleteLmisViewOvertimeReport(
		java.lang.Integer lmisViewOvertimeReportId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewOvertimeReport(lmisViewOvertimeReportId);
	}

	public static void deleteLmisViewOvertimeReport(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewOvertimeReport(lmisViewOvertimeReport);
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

	public static larion.progate.lmis.model.LmisViewOvertimeReport getLmisViewOvertimeReport(
		java.lang.Integer lmisViewOvertimeReportId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewOvertimeReport(lmisViewOvertimeReportId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> getLmisViewOvertimeReports(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewOvertimeReports(start, end);
	}

	public static int getLmisViewOvertimeReportsCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewOvertimeReportsCount();
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport updateLmisViewOvertimeReport(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewOvertimeReport(lmisViewOvertimeReport);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport updateLmisViewOvertimeReport(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewOvertimeReport(lmisViewOvertimeReport, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> getListOverTimeRepRolePM(
		int rootId, int reportBy) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeRepRolePM(rootId, reportBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> getListOverTimeRepRoleBOD(
		int rootId, int reportBy) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeRepRoleBOD(rootId, reportBy);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewOvertimeReportLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewOvertimeReportLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewOvertimeReportLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewOvertimeReportLocalService service) {
		_service = service;
	}

	private static LmisViewOvertimeReportLocalService _service;
}