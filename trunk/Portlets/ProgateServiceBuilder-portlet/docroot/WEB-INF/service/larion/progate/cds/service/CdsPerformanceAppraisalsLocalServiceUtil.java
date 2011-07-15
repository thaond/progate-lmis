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
 * <a href="CdsPerformanceAppraisalsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalsLocalServiceUtil {
	public static larion.progate.cds.model.CdsPerformanceAppraisals addCdsPerformanceAppraisals(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals)
		throws com.liferay.portal.SystemException {
		return getService().addCdsPerformanceAppraisals(cdsPerformanceAppraisals);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals createCdsPerformanceAppraisals(
		java.lang.Integer cdsPerformanceAppraisalsId) {
		return getService()
				   .createCdsPerformanceAppraisals(cdsPerformanceAppraisalsId);
	}

	public static void deleteCdsPerformanceAppraisals(
		java.lang.Integer cdsPerformanceAppraisalsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsPerformanceAppraisals(cdsPerformanceAppraisalsId);
	}

	public static void deleteCdsPerformanceAppraisals(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsPerformanceAppraisals(cdsPerformanceAppraisals);
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

	public static larion.progate.cds.model.CdsPerformanceAppraisals getCdsPerformanceAppraisals(
		java.lang.Integer cdsPerformanceAppraisalsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsPerformanceAppraisals(cdsPerformanceAppraisalsId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisals> getCdsPerformanceAppraisalses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsPerformanceAppraisalses(start, end);
	}

	public static int getCdsPerformanceAppraisalsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsPerformanceAppraisalsesCount();
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals updateCdsPerformanceAppraisals(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsPerformanceAppraisals(cdsPerformanceAppraisals);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals updateCdsPerformanceAppraisals(
		larion.progate.cds.model.CdsPerformanceAppraisals cdsPerformanceAppraisals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsPerformanceAppraisals(cdsPerformanceAppraisals,
			merge);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisals getCdsPerformanceAppraisals(
		int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsPerformanceAppraisals(userId, periodId);
	}

	public static boolean lockedCds(int periodId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().lockedCds(periodId, userId);
	}

	public static boolean checkInImportedPeriod(int rootId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().checkInImportedPeriod(rootId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsPerformanceAppraisalsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsPerformanceAppraisalsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsPerformanceAppraisalsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsPerformanceAppraisalsLocalService service) {
		_service = service;
	}

	private static CdsPerformanceAppraisalsLocalService _service;
}