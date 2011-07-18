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
 * <a href="LmisAttMonthlyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttMonthlyLocalServiceUtil {
	public static larion.progate.lmis.model.LmisAttMonthly addLmisAttMonthly(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly)
		throws com.liferay.portal.SystemException {
		return getService().addLmisAttMonthly(lmisAttMonthly);
	}

	public static larion.progate.lmis.model.LmisAttMonthly createLmisAttMonthly(
		java.lang.Integer lmisAttMonthlysId) {
		return getService().createLmisAttMonthly(lmisAttMonthlysId);
	}

	public static void deleteLmisAttMonthly(java.lang.Integer lmisAttMonthlysId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisAttMonthly(lmisAttMonthlysId);
	}

	public static void deleteLmisAttMonthly(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisAttMonthly(lmisAttMonthly);
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

	public static larion.progate.lmis.model.LmisAttMonthly getLmisAttMonthly(
		java.lang.Integer lmisAttMonthlysId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisAttMonthly(lmisAttMonthlysId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> getLmisAttMonthlies(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisAttMonthlies(start, end);
	}

	public static int getLmisAttMonthliesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisAttMonthliesCount();
	}

	public static larion.progate.lmis.model.LmisAttMonthly updateLmisAttMonthly(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisAttMonthly(lmisAttMonthly);
	}

	public static larion.progate.lmis.model.LmisAttMonthly updateLmisAttMonthly(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisAttMonthly(lmisAttMonthly, merge);
	}

	public static int getTotalEndTimeEarly(int userId, int month, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getTotalEndTimeEarly(userId, month, year, rootId);
	}

	public static int getTotalStartTimeLately(int userId, int month, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getTotalStartTimeLately(userId, month, year, rootId);
	}

	public static java.util.Date getMonthStartTimeAvg(int userId, int month,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService().getMonthStartTimeAvg(userId, month, year, rootId);
	}

	public static java.util.Date getMonthEndTimeAvg(int userId, int month,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService().getMonthEndTimeAvg(userId, month, year, rootId);
	}

	public static int getTotalStartTimeLatePernalty(int userId, int month,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalStartTimeLatePernalty(userId, month, year, rootId);
	}

	public static double getTotalStartTimeLateFinal(int userId, int month,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalStartTimeLateFinal(userId, month, year, rootId);
	}

	public static int getTotalEndTimeEarlyPernalty(int userId, int month,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalEndTimeEarlyPernalty(userId, month, year, rootId);
	}

	public static double getTotalEndTimeEarlyFinal(int userId, int month,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalEndTimeEarlyFinal(userId, month, year, rootId);
	}

	public static double getTotalOverTime(int userId, int month, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getTotalOverTime(userId, month, year, rootId);
	}

	public static double getTotalOverTimeFinal(int userId, int month, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getTotalOverTimeFinal(userId, month, year, rootId);
	}

	public static double getTotalDayCompensation(int userId, int month,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService().getTotalDayCompensation(userId, month, year, rootId);
	}

	public static double getTotalDayOffCompensation(int userId, int month,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalDayOffCompensation(userId, month, year, rootId);
	}

	public static double getTotalDayCompensationRemain(int userId, int month,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalDayCompensationRemain(userId, month, year, rootId);
	}

	public static double getTotalDayCompensationNextMOnth(int userId,
		int month, int year, int rootId)
		throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalDayCompensationNextMOnth(userId, month, year, rootId);
	}

	public static double getTotalTimeFinal(int userId, int month, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getTotalTimeFinal(userId, month, year, rootId);
	}

	public static double getNumDayAward(int userId, int month, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getNumDayAward(userId, month, year, rootId);
	}

	public static double getTotalDayOffInMonth(int userId, int month, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getTotalDayOffInMonth(userId, month, year, rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisAttMonthlyLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisAttMonthlyLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisAttMonthlyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisAttMonthlyLocalService service) {
		_service = service;
	}

	private static LmisAttMonthlyLocalService _service;
}