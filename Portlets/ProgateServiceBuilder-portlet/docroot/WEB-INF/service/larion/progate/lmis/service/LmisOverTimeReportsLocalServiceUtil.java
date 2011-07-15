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
 * <a href="LmisOverTimeReportsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisOverTimeReports addLmisOverTimeReports(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException {
		return getService().addLmisOverTimeReports(lmisOverTimeReports);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports createLmisOverTimeReports(
		java.lang.Integer lmisOverTimeReportsId) {
		return getService().createLmisOverTimeReports(lmisOverTimeReportsId);
	}

	public static void deleteLmisOverTimeReports(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeReports(lmisOverTimeReportsId);
	}

	public static void deleteLmisOverTimeReports(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeReports(lmisOverTimeReports);
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

	public static larion.progate.lmis.model.LmisOverTimeReports getLmisOverTimeReports(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisOverTimeReports(lmisOverTimeReportsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeReportses(start, end);
	}

	public static int getLmisOverTimeReportsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeReportsesCount();
	}

	public static larion.progate.lmis.model.LmisOverTimeReports updateLmisOverTimeReports(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisOverTimeReports(lmisOverTimeReports);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports updateLmisOverTimeReports(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisOverTimeReports(lmisOverTimeReports, merge);
	}

	public static int addOtReport(int reportId, int rootId, int orgId,
		int userId, java.lang.String otReason, java.util.Date regDate,
		java.util.Date repDate, int[] arrUID, double[] arrTotal,
		java.util.List arrHM, java.util.List arrEndTime) {
		return getService()
				   .addOtReport(reportId, rootId, orgId, userId, otReason,
			regDate, repDate, arrUID, arrTotal, arrHM, arrEndTime);
	}

	public static int editOtReport(int rootId, int reportId,
		java.lang.String otReason, java.util.Date repDate, int[] arrUID,
		double[] arrTotal, java.util.List arrHM, java.util.List arrEndTime) {
		return getService()
				   .editOtReport(rootId, reportId, otReason, repDate, arrUID,
			arrTotal, arrHM, arrEndTime);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisOverTimeReportsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisOverTimeReportsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisOverTimeReportsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisOverTimeReportsLocalService service) {
		_service = service;
	}

	private static LmisOverTimeReportsLocalService _service;
}