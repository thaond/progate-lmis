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
 * <a href="LmisAttYearlyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttYearlyLocalServiceUtil {
	public static larion.progate.lmis.model.LmisAttYearly addLmisAttYearly(
		larion.progate.lmis.model.LmisAttYearly lmisAttYearly)
		throws com.liferay.portal.SystemException {
		return getService().addLmisAttYearly(lmisAttYearly);
	}

	public static larion.progate.lmis.model.LmisAttYearly createLmisAttYearly(
		java.lang.Integer lmisAttYearlyId) {
		return getService().createLmisAttYearly(lmisAttYearlyId);
	}

	public static void deleteLmisAttYearly(java.lang.Integer lmisAttYearlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisAttYearly(lmisAttYearlyId);
	}

	public static void deleteLmisAttYearly(
		larion.progate.lmis.model.LmisAttYearly lmisAttYearly)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisAttYearly(lmisAttYearly);
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

	public static larion.progate.lmis.model.LmisAttYearly getLmisAttYearly(
		java.lang.Integer lmisAttYearlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisAttYearly(lmisAttYearlyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> getLmisAttYearlies(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisAttYearlies(start, end);
	}

	public static int getLmisAttYearliesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisAttYearliesCount();
	}

	public static larion.progate.lmis.model.LmisAttYearly updateLmisAttYearly(
		larion.progate.lmis.model.LmisAttYearly lmisAttYearly)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisAttYearly(lmisAttYearly);
	}

	public static larion.progate.lmis.model.LmisAttYearly updateLmisAttYearly(
		larion.progate.lmis.model.LmisAttYearly lmisAttYearly, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisAttYearly(lmisAttYearly, merge);
	}

	public static java.util.Date getYearStartTimeAvg(int userId, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getYearStartTimeAvg(userId, year, rootId);
	}

	public static java.util.Date getYearEndTimeAvg(int userId, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getYearEndTimeAvg(userId, year, rootId);
	}

	public static int getYearTotalWorkingDate(int userId, int year, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getYearTotalWorkingDate(userId, year, rootId);
	}

	public static double getNumDayOffEachYearRemain(int userId, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getNumDayOffEachYearRemain(userId, year, rootId);
	}

	public static double getNumDayOffEachYear(int userId, int year, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getNumDayOffEachYear(userId, year, rootId);
	}

	public static double getNumDayOffEachYearThisYear(int userId, int year,
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getNumDayOffEachYearThisYear(userId, year, rootId);
	}

	public static double getNumDayOffEachYearThisYearRemain(int userId,
		int year, int rootId) throws com.liferay.portal.SystemException {
		return getService()
				   .getNumDayOffEachYearThisYearRemain(userId, year, rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisAttYearlyLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisAttYearlyLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisAttYearlyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisAttYearlyLocalService service) {
		_service = service;
	}

	private static LmisAttYearlyLocalService _service;
}