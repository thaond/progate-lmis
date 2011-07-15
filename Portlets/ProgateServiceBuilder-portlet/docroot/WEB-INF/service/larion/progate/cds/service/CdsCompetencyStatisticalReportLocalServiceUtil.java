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
 * <a href="CdsCompetencyStatisticalReportLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsCompetencyStatisticalReportLocalServiceUtil {
	public static larion.progate.cds.model.CdsCompetencyStatisticalReport addCdsCompetencyStatisticalReport(
		larion.progate.cds.model.CdsCompetencyStatisticalReport cdsCompetencyStatisticalReport)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addCdsCompetencyStatisticalReport(cdsCompetencyStatisticalReport);
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport createCdsCompetencyStatisticalReport(
		java.lang.Integer competencyId) {
		return getService().createCdsCompetencyStatisticalReport(competencyId);
	}

	public static void deleteCdsCompetencyStatisticalReport(
		java.lang.Integer competencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsCompetencyStatisticalReport(competencyId);
	}

	public static void deleteCdsCompetencyStatisticalReport(
		larion.progate.cds.model.CdsCompetencyStatisticalReport cdsCompetencyStatisticalReport)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteCdsCompetencyStatisticalReport(cdsCompetencyStatisticalReport);
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

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport getCdsCompetencyStatisticalReport(
		java.lang.Integer competencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsCompetencyStatisticalReport(competencyId);
	}

	public static java.util.List<larion.progate.cds.model.CdsCompetencyStatisticalReport> getCdsCompetencyStatisticalReports(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsCompetencyStatisticalReports(start, end);
	}

	public static int getCdsCompetencyStatisticalReportsCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsCompetencyStatisticalReportsCount();
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport updateCdsCompetencyStatisticalReport(
		larion.progate.cds.model.CdsCompetencyStatisticalReport cdsCompetencyStatisticalReport)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsCompetencyStatisticalReport(cdsCompetencyStatisticalReport);
	}

	public static larion.progate.cds.model.CdsCompetencyStatisticalReport updateCdsCompetencyStatisticalReport(
		larion.progate.cds.model.CdsCompetencyStatisticalReport cdsCompetencyStatisticalReport,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsCompetencyStatisticalReport(cdsCompetencyStatisticalReport,
			merge);
	}

	public static java.util.List<larion.progate.cds.model.CdsCompetencyStatisticalReport> getCdsCompetencyStatisticalReportList(
		int rootId, int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsCompetencyStatisticalReportList(rootId, userId,
			periodId);
	}

	public static java.lang.String getLevelRankingValue(int rootId, int userId,
		int periodId, int competencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getLevelRankingValue(rootId, userId, periodId, competencyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsCompetencyStatisticalReportLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsCompetencyStatisticalReportLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsCompetencyStatisticalReportLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsCompetencyStatisticalReportLocalService service) {
		_service = service;
	}

	private static CdsCompetencyStatisticalReportLocalService _service;
}