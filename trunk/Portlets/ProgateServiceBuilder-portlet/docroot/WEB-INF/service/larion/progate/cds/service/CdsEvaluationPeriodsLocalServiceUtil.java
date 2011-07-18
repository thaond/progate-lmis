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
 * <a href="CdsEvaluationPeriodsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsEvaluationPeriodsLocalServiceUtil {
	public static larion.progate.cds.model.CdsEvaluationPeriods addCdsEvaluationPeriods(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods)
		throws com.liferay.portal.SystemException {
		return getService().addCdsEvaluationPeriods(cdsEvaluationPeriods);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods createCdsEvaluationPeriods(
		java.lang.Integer CdsEvaluationPeriodsId) {
		return getService().createCdsEvaluationPeriods(CdsEvaluationPeriodsId);
	}

	public static void deleteCdsEvaluationPeriods(
		java.lang.Integer CdsEvaluationPeriodsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsEvaluationPeriods(CdsEvaluationPeriodsId);
	}

	public static void deleteCdsEvaluationPeriods(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsEvaluationPeriods(cdsEvaluationPeriods);
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

	public static larion.progate.cds.model.CdsEvaluationPeriods getCdsEvaluationPeriods(
		java.lang.Integer CdsEvaluationPeriodsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsEvaluationPeriods(CdsEvaluationPeriodsId);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> getCdsEvaluationPeriodses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsEvaluationPeriodses(start, end);
	}

	public static int getCdsEvaluationPeriodsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsEvaluationPeriodsesCount();
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods updateCdsEvaluationPeriods(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsEvaluationPeriods(cdsEvaluationPeriods);
	}

	public static larion.progate.cds.model.CdsEvaluationPeriods updateCdsEvaluationPeriods(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsEvaluationPeriods(cdsEvaluationPeriods, merge);
	}

	public static int addCdsPeriod(int rootId, java.lang.String name,
		java.util.Date fromDate, java.util.Date toDate,
		java.util.Date startDate, java.util.Date endDate, int status,
		int createdBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addCdsPeriod(rootId, name, fromDate, toDate, startDate,
			endDate, status, createdBy);
	}

	public static boolean updateCdsPeriod(int id, java.lang.String name,
		java.util.Date fromDate, java.util.Date toDate,
		java.util.Date startDate, java.util.Date endDate, int status,
		int updatedBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .updateCdsPeriod(id, name, fromDate, toDate, startDate,
			endDate, status, updatedBy);
	}

	public static boolean testBeforeDeleteCdsPeriod(int id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().testBeforeDeleteCdsPeriod(id);
	}

	public static boolean deleteCdsPeriod(int id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().deleteCdsPeriod(id);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> loadCdsPeriods(
		int status, int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().loadCdsPeriods(status, rootId);
	}

	public static int checkPeriod(int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().checkPeriod(rootId);
	}

	public static int addCdsPeriodImport(int rootId, int createdBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().addCdsPeriodImport(rootId, createdBy);
	}

	public static boolean updateCdsPeriodImport(int id, int status)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().updateCdsPeriodImport(id, status);
	}

	public static java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> getPeriodByRootId(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getPeriodByRootId(rootId);
	}

	public static boolean checkOpenOrClosePeriod(int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().checkOpenOrClosePeriod(rootId);
	}

	public static int getImportedEvaluation()
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getImportedEvaluation();
	}

	public static java.util.Date getToDateOfPreviousPeriod(int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getToDateOfPreviousPeriod(periodId);
	}

	public static java.util.Date getFromDateOfNextPeriod(int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getFromDateOfNextPeriod(periodId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsEvaluationPeriodsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsEvaluationPeriodsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsEvaluationPeriodsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsEvaluationPeriodsLocalService service) {
		_service = service;
	}

	private static CdsEvaluationPeriodsLocalService _service;
}