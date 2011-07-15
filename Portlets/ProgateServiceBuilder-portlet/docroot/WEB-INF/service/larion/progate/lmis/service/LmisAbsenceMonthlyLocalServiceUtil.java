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
 * <a href="LmisAbsenceMonthlyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceMonthlyLocalServiceUtil {
	public static larion.progate.lmis.model.LmisAbsenceMonthly addLmisAbsenceMonthly(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly)
		throws com.liferay.portal.SystemException {
		return getService().addLmisAbsenceMonthly(lmisAbsenceMonthly);
	}

	public static larion.progate.lmis.model.LmisAbsenceMonthly createLmisAbsenceMonthly(
		java.lang.Integer lmisAbsenceMonthlyId) {
		return getService().createLmisAbsenceMonthly(lmisAbsenceMonthlyId);
	}

	public static void deleteLmisAbsenceMonthly(
		java.lang.Integer lmisAbsenceMonthlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisAbsenceMonthly(lmisAbsenceMonthlyId);
	}

	public static void deleteLmisAbsenceMonthly(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisAbsenceMonthly(lmisAbsenceMonthly);
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

	public static larion.progate.lmis.model.LmisAbsenceMonthly getLmisAbsenceMonthly(
		java.lang.Integer lmisAbsenceMonthlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisAbsenceMonthly(lmisAbsenceMonthlyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> getLmisAbsenceMonthlies(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisAbsenceMonthlies(start, end);
	}

	public static int getLmisAbsenceMonthliesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisAbsenceMonthliesCount();
	}

	public static larion.progate.lmis.model.LmisAbsenceMonthly updateLmisAbsenceMonthly(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisAbsenceMonthly(lmisAbsenceMonthly);
	}

	public static larion.progate.lmis.model.LmisAbsenceMonthly updateLmisAbsenceMonthly(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisAbsenceMonthly(lmisAbsenceMonthly, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> getStatisticTypeDayOff(
		int userId, int month, int year, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getStatisticTypeDayOff(userId, month, year, rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisAbsenceMonthlyLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisAbsenceMonthlyLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisAbsenceMonthlyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisAbsenceMonthlyLocalService service) {
		_service = service;
	}

	private static LmisAbsenceMonthlyLocalService _service;
}