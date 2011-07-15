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
 * <a href="CdsPerformanceAppraisalSlotRatingLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalSlotRatingLocalServiceUtil {
	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating addCdsPerformanceAppraisalSlotRating(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addCdsPerformanceAppraisalSlotRating(cdsPerformanceAppraisalSlotRating);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating createCdsPerformanceAppraisalSlotRating(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId) {
		return getService()
				   .createCdsPerformanceAppraisalSlotRating(CdsPerformanceAppraisalSlotRatingId);
	}

	public static void deleteCdsPerformanceAppraisalSlotRating(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteCdsPerformanceAppraisalSlotRating(CdsPerformanceAppraisalSlotRatingId);
	}

	public static void deleteCdsPerformanceAppraisalSlotRating(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteCdsPerformanceAppraisalSlotRating(cdsPerformanceAppraisalSlotRating);
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

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating getCdsPerformanceAppraisalSlotRating(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsPerformanceAppraisalSlotRating(CdsPerformanceAppraisalSlotRatingId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> getCdsPerformanceAppraisalSlotRatings(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsPerformanceAppraisalSlotRatings(start, end);
	}

	public static int getCdsPerformanceAppraisalSlotRatingsCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsPerformanceAppraisalSlotRatingsCount();
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating updateCdsPerformanceAppraisalSlotRating(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsPerformanceAppraisalSlotRating(cdsPerformanceAppraisalSlotRating);
	}

	public static larion.progate.cds.model.CdsPerformanceAppraisalSlotRating updateCdsPerformanceAppraisalSlotRating(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsPerformanceAppraisalSlotRating(cdsPerformanceAppraisalSlotRating,
			merge);
	}

	public static boolean addPASlotRating(int rootId, int periodId, int userId,
		int slotId, int ratingBy, boolean ratingStatus, int userType,
		java.lang.String pointName, int pointValue)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addPASlotRating(rootId, periodId, userId, slotId, ratingBy,
			ratingStatus, userType, pointName, pointValue);
	}

	public static boolean addPASlotRatingByBOD(int[] userId, int periodId,
		int ratingByBOD, int userTypeBOD)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addPASlotRatingByBOD(userId, periodId, ratingByBOD,
			userTypeBOD);
	}

	public static java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> getSlotRatingHistory(
		int rootId, int userId, int slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getSlotRatingHistory(rootId, userId, slotId);
	}

	public static int getLastRatingPointByUserType(int periodId, int userId,
		int slotId, int userType)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getLastRatingPointByUserType(periodId, userId, slotId,
			userType);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsPerformanceAppraisalSlotRatingLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsPerformanceAppraisalSlotRatingLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsPerformanceAppraisalSlotRatingLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(
		CdsPerformanceAppraisalSlotRatingLocalService service) {
		_service = service;
	}

	private static CdsPerformanceAppraisalSlotRatingLocalService _service;
}