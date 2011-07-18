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
 * <a href="LmisWorkingTimesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingTimesLocalServiceUtil {
	public static larion.progate.lmis.model.LmisWorkingTimes addLmisWorkingTimes(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes)
		throws com.liferay.portal.SystemException {
		return getService().addLmisWorkingTimes(lmisWorkingTimes);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes createLmisWorkingTimes(
		java.lang.Integer lmisWorkingTimeId) {
		return getService().createLmisWorkingTimes(lmisWorkingTimeId);
	}

	public static void deleteLmisWorkingTimes(
		java.lang.Integer lmisWorkingTimeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisWorkingTimes(lmisWorkingTimeId);
	}

	public static void deleteLmisWorkingTimes(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisWorkingTimes(lmisWorkingTimes);
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

	public static larion.progate.lmis.model.LmisWorkingTimes getLmisWorkingTimes(
		java.lang.Integer lmisWorkingTimeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisWorkingTimes(lmisWorkingTimeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> getLmisWorkingTimeses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisWorkingTimeses(start, end);
	}

	public static int getLmisWorkingTimesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisWorkingTimesesCount();
	}

	public static larion.progate.lmis.model.LmisWorkingTimes updateLmisWorkingTimes(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisWorkingTimes(lmisWorkingTimes);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes updateLmisWorkingTimes(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisWorkingTimes(lmisWorkingTimes, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findByWorkingTimeOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getService().findByWorkingTimeOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findBySession(
		java.lang.String sessionName) throws com.liferay.portal.SystemException {
		return getService().findBySession(sessionName);
	}

	public static boolean editLmisWorkingTimes(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTime) {
		return getService().editLmisWorkingTimes(lmisWorkingTime);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisWorkingTimesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisWorkingTimesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisWorkingTimesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisWorkingTimesLocalService service) {
		_service = service;
	}

	private static LmisWorkingTimesLocalService _service;
}