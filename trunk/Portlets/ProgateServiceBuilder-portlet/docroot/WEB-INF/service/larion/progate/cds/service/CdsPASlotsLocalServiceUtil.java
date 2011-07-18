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
 * <a href="CdsPASlotsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPASlotsLocalServiceUtil {
	public static larion.progate.cds.model.CdsPASlots addCdsPASlots(
		larion.progate.cds.model.CdsPASlots cdsPASlots)
		throws com.liferay.portal.SystemException {
		return getService().addCdsPASlots(cdsPASlots);
	}

	public static larion.progate.cds.model.CdsPASlots createCdsPASlots(
		java.lang.Integer CdsPASlotsId) {
		return getService().createCdsPASlots(CdsPASlotsId);
	}

	public static void deleteCdsPASlots(java.lang.Integer CdsPASlotsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsPASlots(CdsPASlotsId);
	}

	public static void deleteCdsPASlots(
		larion.progate.cds.model.CdsPASlots cdsPASlots)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsPASlots(cdsPASlots);
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

	public static larion.progate.cds.model.CdsPASlots getCdsPASlots(
		java.lang.Integer CdsPASlotsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsPASlots(CdsPASlotsId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPASlots> getCdsPASlotses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsPASlotses(start, end);
	}

	public static int getCdsPASlotsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsPASlotsesCount();
	}

	public static larion.progate.cds.model.CdsPASlots updateCdsPASlots(
		larion.progate.cds.model.CdsPASlots cdsPASlots)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsPASlots(cdsPASlots);
	}

	public static larion.progate.cds.model.CdsPASlots updateCdsPASlots(
		larion.progate.cds.model.CdsPASlots cdsPASlots, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsPASlots(cdsPASlots, merge);
	}

	public static java.util.List<larion.progate.cds.model.CdsPASlots> getCdsPASlotsList(
		int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsPASlotsList(userId, periodId);
	}

	public static boolean addPASlots(int rootId, int userId, int periodId,
		java.util.List<Integer> CompetenciesList,
		java.util.List<Integer> LevelsList,
		java.util.List<larion.progate.cds.model.ViewFinalSlots> SlotsList)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addPASlots(rootId, userId, periodId, CompetenciesList,
			LevelsList, SlotsList);
	}

	public static int countSlotPreEvaluate(int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().countSlotPreEvaluate(userId, periodId);
	}

	public static int countSlotEvaluateByUser(int userId, int periodId,
		int ratingStatus)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .countSlotEvaluateByUser(userId, periodId, ratingStatus);
	}

	public static boolean updatePASlotsImport(int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().updatePASlotsImport(userId, periodId);
	}

	public static boolean addPASlotsImport(int rootId, int userId,
		int periodId, java.util.List<Integer> CompetenciesList,
		java.util.List<Integer> LevelsList,
		java.util.List<larion.progate.cds.model.ViewFinalSlots> SlotsList)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addPASlotsImport(rootId, userId, periodId,
			CompetenciesList, LevelsList, SlotsList);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsPASlotsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsPASlotsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsPASlotsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsPASlotsLocalService service) {
		_service = service;
	}

	private static CdsPASlotsLocalService _service;
}