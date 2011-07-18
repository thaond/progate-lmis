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
 * <a href="LmisOvertimeMonthlyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeMonthlyLocalServiceUtil {
	public static larion.progate.lmis.model.LmisOvertimeMonthly addLmisOvertimeMonthly(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly)
		throws com.liferay.portal.SystemException {
		return getService().addLmisOvertimeMonthly(lmisOvertimeMonthly);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly createLmisOvertimeMonthly(
		java.lang.Integer lmisOvertimeMonthlyId) {
		return getService().createLmisOvertimeMonthly(lmisOvertimeMonthlyId);
	}

	public static void deleteLmisOvertimeMonthly(
		java.lang.Integer lmisOvertimeMonthlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisOvertimeMonthly(lmisOvertimeMonthlyId);
	}

	public static void deleteLmisOvertimeMonthly(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisOvertimeMonthly(lmisOvertimeMonthly);
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

	public static larion.progate.lmis.model.LmisOvertimeMonthly getLmisOvertimeMonthly(
		java.lang.Integer lmisOvertimeMonthlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisOvertimeMonthly(lmisOvertimeMonthlyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> getLmisOvertimeMonthlies(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisOvertimeMonthlies(start, end);
	}

	public static int getLmisOvertimeMonthliesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisOvertimeMonthliesCount();
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly updateLmisOvertimeMonthly(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisOvertimeMonthly(lmisOvertimeMonthly);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly updateLmisOvertimeMonthly(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisOvertimeMonthly(lmisOvertimeMonthly, merge);
	}

	public static double countTotalOverTime(int rootId, int orgId,
		int monthValue, int yearValue)
		throws com.liferay.portal.SystemException {
		return getService()
				   .countTotalOverTime(rootId, orgId, monthValue, yearValue);
	}

	public static double getTotalOverTimeBefore21h(int rootId, int userId,
		int monthValue, int yearValue)
		throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalOverTimeBefore21h(rootId, userId, monthValue,
			yearValue);
	}

	public static double getTotalOverTimeAfter21h(int rootId, int userId,
		int monthValue, int yearValue)
		throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalOverTimeAfter21h(rootId, userId, monthValue,
			yearValue);
	}

	public static double getTotalOverTimeAfter24h(int rootId, int userId,
		int monthValue, int yearValue)
		throws com.liferay.portal.SystemException {
		return getService()
				   .getTotalOverTimeAfter24h(rootId, userId, monthValue,
			yearValue);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisOvertimeMonthlyLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisOvertimeMonthlyLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisOvertimeMonthlyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisOvertimeMonthlyLocalService service) {
		_service = service;
	}

	private static LmisOvertimeMonthlyLocalService _service;
}