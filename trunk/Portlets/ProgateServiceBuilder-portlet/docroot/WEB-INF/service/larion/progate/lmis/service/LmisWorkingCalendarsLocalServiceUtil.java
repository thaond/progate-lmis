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
 * <a href="LmisWorkingCalendarsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingCalendarsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisWorkingCalendars addLmisWorkingCalendars(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars)
		throws com.liferay.portal.SystemException {
		return getService().addLmisWorkingCalendars(lmisWorkingCalendars);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars createLmisWorkingCalendars(
		java.lang.Integer lmisWorkingCalendarId) {
		return getService().createLmisWorkingCalendars(lmisWorkingCalendarId);
	}

	public static void deleteLmisWorkingCalendars(
		java.lang.Integer lmisWorkingCalendarId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisWorkingCalendars(lmisWorkingCalendarId);
	}

	public static void deleteLmisWorkingCalendars(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisWorkingCalendars(lmisWorkingCalendars);
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

	public static larion.progate.lmis.model.LmisWorkingCalendars getLmisWorkingCalendars(
		java.lang.Integer lmisWorkingCalendarId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisWorkingCalendars(lmisWorkingCalendarId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> getLmisWorkingCalendarses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisWorkingCalendarses(start, end);
	}

	public static int getLmisWorkingCalendarsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisWorkingCalendarsesCount();
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars updateLmisWorkingCalendars(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisWorkingCalendars(lmisWorkingCalendars);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars updateLmisWorkingCalendars(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisWorkingCalendars(lmisWorkingCalendars, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> workingcalendar(
		int rootid, int year, int month)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().workingcalendar(rootid, year, month);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByWorkingCalendarOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getService().findByWorkingCalendarOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> getListWorkingCalendar(
		int rootId, java.util.Date date) {
		return getService().getListWorkingCalendar(rootId, date);
	}

	public static boolean deleteWorkingCalendar(int rootid, int calendarId) {
		return getService().deleteWorkingCalendar(rootid, calendarId);
	}

	public static boolean addWorkingCalendar(int rootId, java.util.Date date,
		int dayType, java.lang.String description)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addWorkingCalendar(rootId, date, dayType, description);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisWorkingCalendarsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisWorkingCalendarsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisWorkingCalendarsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisWorkingCalendarsLocalService service) {
		_service = service;
	}

	private static LmisWorkingCalendarsLocalService _service;
}