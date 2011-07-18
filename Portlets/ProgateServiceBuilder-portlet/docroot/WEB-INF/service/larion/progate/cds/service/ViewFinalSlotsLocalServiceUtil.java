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
 * <a href="ViewFinalSlotsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalSlotsLocalServiceUtil {
	public static larion.progate.cds.model.ViewFinalSlots addViewFinalSlots(
		larion.progate.cds.model.ViewFinalSlots viewFinalSlots)
		throws com.liferay.portal.SystemException {
		return getService().addViewFinalSlots(viewFinalSlots);
	}

	public static larion.progate.cds.model.ViewFinalSlots createViewFinalSlots(
		java.lang.Integer slotId) {
		return getService().createViewFinalSlots(slotId);
	}

	public static void deleteViewFinalSlots(java.lang.Integer slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewFinalSlots(slotId);
	}

	public static void deleteViewFinalSlots(
		larion.progate.cds.model.ViewFinalSlots viewFinalSlots)
		throws com.liferay.portal.SystemException {
		getService().deleteViewFinalSlots(viewFinalSlots);
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

	public static larion.progate.cds.model.ViewFinalSlots getViewFinalSlots(
		java.lang.Integer slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewFinalSlots(slotId);
	}

	public static java.util.List<larion.progate.cds.model.ViewFinalSlots> getViewFinalSlotses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewFinalSlotses(start, end);
	}

	public static int getViewFinalSlotsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewFinalSlotsesCount();
	}

	public static larion.progate.cds.model.ViewFinalSlots updateViewFinalSlots(
		larion.progate.cds.model.ViewFinalSlots viewFinalSlots)
		throws com.liferay.portal.SystemException {
		return getService().updateViewFinalSlots(viewFinalSlots);
	}

	public static larion.progate.cds.model.ViewFinalSlots updateViewFinalSlots(
		larion.progate.cds.model.ViewFinalSlots viewFinalSlots, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateViewFinalSlots(viewFinalSlots, merge);
	}

	public static java.util.List<larion.progate.cds.model.ViewFinalSlots> getFinalSlotsList(
		int rootId, int userId, int levelId, int statusOfSlot)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getFinalSlotsList(rootId, userId, levelId, statusOfSlot);
	}

	public static java.util.List<larion.progate.cds.model.ViewFinalSlots> getFinalSlotsListNotInCdsPerformaceAppraisalSlots(
		int rootId, int userId, int statusOfSlot, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getFinalSlotsListNotInCdsPerformaceAppraisalSlots(rootId,
			userId, statusOfSlot, periodId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewFinalSlotsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewFinalSlotsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewFinalSlotsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewFinalSlotsLocalService service) {
		_service = service;
	}

	private static ViewFinalSlotsLocalService _service;
}