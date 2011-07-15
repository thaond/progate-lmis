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
 * <a href="LmisAttendanceDailyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttendanceDailyLocalServiceUtil {
	public static larion.progate.lmis.model.LmisAttendanceDaily addLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException {
		return getService().addLmisAttendanceDaily(lmisAttendanceDaily);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily createLmisAttendanceDaily(
		java.lang.Integer lmisAttendanceDailyId) {
		return getService().createLmisAttendanceDaily(lmisAttendanceDailyId);
	}

	public static void deleteLmisAttendanceDaily(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisAttendanceDaily(lmisAttendanceDailyId);
	}

	public static void deleteLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisAttendanceDaily(lmisAttendanceDaily);
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

	public static larion.progate.lmis.model.LmisAttendanceDaily getLmisAttendanceDaily(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisAttendanceDaily(lmisAttendanceDailyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisAttendanceDailies(start, end);
	}

	public static int getLmisAttendanceDailiesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisAttendanceDailiesCount();
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily updateLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisAttendanceDaily(lmisAttendanceDaily);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily updateLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisAttendanceDaily(lmisAttendanceDaily, merge);
	}

	public static java.util.Date getStartTimeToday(int userId,
		java.util.Date dayValue, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getStartTimeToday(userId, dayValue, rootId);
	}

	public static long getStartTimeLateToday(int userId,
		java.util.Date dayValue, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getStartTimeLateToday(userId, dayValue, rootId);
	}

	public static java.util.Date getEndTimeYesterday(int userId,
		java.util.Date dayValue, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getEndTimeYesterday(userId, dayValue, rootId);
	}

	public static long getEndTimeEarlyYesterDay(int userId,
		java.util.Date dayValue, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getEndTimeEarlyYesterDay(userId, dayValue, rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getListDetailsDayOff(
		int rootId, int userId, java.util.Date cur) {
		return getService().getListDetailsDayOff(rootId, userId, cur);
	}

	public static double caculateTotalDayOffDontHavePermission_(int userId,
		int rootId) throws com.liferay.portal.SystemException {
		return getService()
				   .caculateTotalDayOffDontHavePermission_(userId, rootId);
	}

	public static double caculateTotalDayOffHavePermission_(int userId,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().caculateTotalDayOffHavePermission_(userId, rootId);
	}

	public static double getTotalDayOffInMonth_(int userId, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getTotalDayOffInMonth_(userId, rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisAttendanceDailyLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisAttendanceDailyLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisAttendanceDailyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisAttendanceDailyLocalService service) {
		_service = service;
	}

	private static LmisAttendanceDailyLocalService _service;
}