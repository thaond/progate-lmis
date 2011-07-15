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
 * <a href="LmisOvertimeYearlyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeYearlyLocalServiceUtil {
	public static larion.progate.lmis.model.LmisOvertimeYearly addLmisOvertimeYearly(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly)
		throws com.liferay.portal.SystemException {
		return getService().addLmisOvertimeYearly(lmisOvertimeYearly);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly createLmisOvertimeYearly(
		java.lang.Integer lmisOvertimeYearlyId) {
		return getService().createLmisOvertimeYearly(lmisOvertimeYearlyId);
	}

	public static void deleteLmisOvertimeYearly(
		java.lang.Integer lmisOvertimeYearlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisOvertimeYearly(lmisOvertimeYearlyId);
	}

	public static void deleteLmisOvertimeYearly(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisOvertimeYearly(lmisOvertimeYearly);
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

	public static larion.progate.lmis.model.LmisOvertimeYearly getLmisOvertimeYearly(
		java.lang.Integer lmisOvertimeYearlyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisOvertimeYearly(lmisOvertimeYearlyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> getLmisOvertimeYearlies(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisOvertimeYearlies(start, end);
	}

	public static int getLmisOvertimeYearliesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisOvertimeYearliesCount();
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly updateLmisOvertimeYearly(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisOvertimeYearly(lmisOvertimeYearly);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly updateLmisOvertimeYearly(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisOvertimeYearly(lmisOvertimeYearly, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisOvertimeYearlyLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisOvertimeYearlyLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisOvertimeYearlyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisOvertimeYearlyLocalService service) {
		_service = service;
	}

	private static LmisOvertimeYearlyLocalService _service;
}