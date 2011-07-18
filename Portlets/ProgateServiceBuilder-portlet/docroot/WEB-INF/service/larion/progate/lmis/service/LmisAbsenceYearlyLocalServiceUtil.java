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
 * <a href="LmisAbsenceYearlyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceYearlyLocalServiceUtil {
	public static larion.progate.lmis.model.LmisAbsenceYearly addLmisAbsenceYearly(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly)
		throws com.liferay.portal.SystemException {
		return getService().addLmisAbsenceYearly(lmisAbsenceYearly);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly createLmisAbsenceYearly(
		java.lang.Integer lmisAbsenceYearlyId) {
		return getService().createLmisAbsenceYearly(lmisAbsenceYearlyId);
	}

	public static void deleteLmisAbsenceYearly(
		java.lang.Integer lmisAbsenceYearlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisAbsenceYearly(lmisAbsenceYearlyId);
	}

	public static void deleteLmisAbsenceYearly(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisAbsenceYearly(lmisAbsenceYearly);
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

	public static larion.progate.lmis.model.LmisAbsenceYearly getLmisAbsenceYearly(
		java.lang.Integer lmisAbsenceYearlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisAbsenceYearly(lmisAbsenceYearlyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> getLmisAbsenceYearlies(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisAbsenceYearlies(start, end);
	}

	public static int getLmisAbsenceYearliesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisAbsenceYearliesCount();
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly updateLmisAbsenceYearly(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisAbsenceYearly(lmisAbsenceYearly);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly updateLmisAbsenceYearly(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisAbsenceYearly(lmisAbsenceYearly, merge);
	}

	public static double getNumDayOff(int userId, int year, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getNumDayOff(userId, year, rootId);
	}

	public static double getNumDayOffEachYearLastYear(int userId, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getNumDayOffEachYearLastYear(userId, year, rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisAbsenceYearlyLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisAbsenceYearlyLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisAbsenceYearlyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisAbsenceYearlyLocalService service) {
		_service = service;
	}

	private static LmisAbsenceYearlyLocalService _service;
}