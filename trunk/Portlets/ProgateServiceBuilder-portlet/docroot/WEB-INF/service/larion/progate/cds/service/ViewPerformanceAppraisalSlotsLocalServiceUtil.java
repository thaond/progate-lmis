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
 * <a href="ViewPerformanceAppraisalSlotsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewPerformanceAppraisalSlotsLocalServiceUtil {
	public static larion.progate.cds.model.ViewPerformanceAppraisalSlots addViewPerformanceAppraisalSlots(
		larion.progate.cds.model.ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addViewPerformanceAppraisalSlots(viewPerformanceAppraisalSlots);
	}

	public static larion.progate.cds.model.ViewPerformanceAppraisalSlots createViewPerformanceAppraisalSlots(
		java.lang.String id) {
		return getService().createViewPerformanceAppraisalSlots(id);
	}

	public static void deleteViewPerformanceAppraisalSlots(java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewPerformanceAppraisalSlots(id);
	}

	public static void deleteViewPerformanceAppraisalSlots(
		larion.progate.cds.model.ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteViewPerformanceAppraisalSlots(viewPerformanceAppraisalSlots);
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

	public static larion.progate.cds.model.ViewPerformanceAppraisalSlots getViewPerformanceAppraisalSlots(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewPerformanceAppraisalSlots(id);
	}

	public static java.util.List<larion.progate.cds.model.ViewPerformanceAppraisalSlots> getViewPerformanceAppraisalSlotses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewPerformanceAppraisalSlotses(start, end);
	}

	public static int getViewPerformanceAppraisalSlotsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewPerformanceAppraisalSlotsesCount();
	}

	public static larion.progate.cds.model.ViewPerformanceAppraisalSlots updateViewPerformanceAppraisalSlots(
		larion.progate.cds.model.ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewPerformanceAppraisalSlots(viewPerformanceAppraisalSlots);
	}

	public static larion.progate.cds.model.ViewPerformanceAppraisalSlots updateViewPerformanceAppraisalSlots(
		larion.progate.cds.model.ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewPerformanceAppraisalSlots(viewPerformanceAppraisalSlots,
			merge);
	}

	public static java.util.List<larion.progate.cds.model.ViewPerformanceAppraisalSlots> getCdsPASlots(
		int userId, int periodId, int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsPASlots(userId, periodId, levelId);
	}

	public static larion.progate.cds.model.ViewPerformanceAppraisalSlots getPASlotDetail(
		int userId, int periodId, int slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getPASlotDetail(userId, periodId, slotId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewPerformanceAppraisalSlotsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewPerformanceAppraisalSlotsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewPerformanceAppraisalSlotsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewPerformanceAppraisalSlotsLocalService service) {
		_service = service;
	}

	private static ViewPerformanceAppraisalSlotsLocalService _service;
}