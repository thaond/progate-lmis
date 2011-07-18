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

package larion.progate.cds.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="CdsSlotStatisticalReportLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsSlotStatisticalReportLocalServiceUtil {
	public static larion.progate.cds.model.CdsSlotStatisticalReport addCdsSlotStatisticalReport(
		larion.progate.cds.model.CdsSlotStatisticalReport cdsSlotStatisticalReport)
		throws com.liferay.portal.SystemException {
		return getService().addCdsSlotStatisticalReport(cdsSlotStatisticalReport);
	}

	public static larion.progate.cds.model.CdsSlotStatisticalReport createCdsSlotStatisticalReport(
		java.lang.Integer slotId) {
		return getService().createCdsSlotStatisticalReport(slotId);
	}

	public static void deleteCdsSlotStatisticalReport(java.lang.Integer slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsSlotStatisticalReport(slotId);
	}

	public static void deleteCdsSlotStatisticalReport(
		larion.progate.cds.model.CdsSlotStatisticalReport cdsSlotStatisticalReport)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsSlotStatisticalReport(cdsSlotStatisticalReport);
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

	public static larion.progate.cds.model.CdsSlotStatisticalReport getCdsSlotStatisticalReport(
		java.lang.Integer slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsSlotStatisticalReport(slotId);
	}

	public static java.util.List<larion.progate.cds.model.CdsSlotStatisticalReport> getCdsSlotStatisticalReports(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsSlotStatisticalReports(start, end);
	}

	public static int getCdsSlotStatisticalReportsCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsSlotStatisticalReportsCount();
	}

	public static larion.progate.cds.model.CdsSlotStatisticalReport updateCdsSlotStatisticalReport(
		larion.progate.cds.model.CdsSlotStatisticalReport cdsSlotStatisticalReport)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsSlotStatisticalReport(cdsSlotStatisticalReport);
	}

	public static larion.progate.cds.model.CdsSlotStatisticalReport updateCdsSlotStatisticalReport(
		larion.progate.cds.model.CdsSlotStatisticalReport cdsSlotStatisticalReport,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsSlotStatisticalReport(cdsSlotStatisticalReport,
			merge);
	}

	public static java.util.List<larion.progate.cds.model.CdsSlotStatisticalReport> getCdsSlotStatisticalReportList(
		int rootId, int userId, int periodId, int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsSlotStatisticalReportList(rootId, userId, periodId,
			levelId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsSlotStatisticalReportLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsSlotStatisticalReportLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsSlotStatisticalReportLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsSlotStatisticalReportLocalService service) {
		_service = service;
	}

	private static CdsSlotStatisticalReportLocalService _service;
}