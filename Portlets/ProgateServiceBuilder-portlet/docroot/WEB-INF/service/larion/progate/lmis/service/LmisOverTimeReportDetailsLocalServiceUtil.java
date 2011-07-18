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
 * <a href="LmisOverTimeReportDetailsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportDetailsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisOverTimeReportDetails addLmisOverTimeReportDetails(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addLmisOverTimeReportDetails(lmisOverTimeReportDetails);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportDetails createLmisOverTimeReportDetails(
		java.lang.Integer lmisOverTimeReportDetailsId) {
		return getService()
				   .createLmisOverTimeReportDetails(lmisOverTimeReportDetailsId);
	}

	public static void deleteLmisOverTimeReportDetails(
		java.lang.Integer lmisOverTimeReportDetailsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeReportDetails(lmisOverTimeReportDetailsId);
	}

	public static void deleteLmisOverTimeReportDetails(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeReportDetails(lmisOverTimeReportDetails);
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

	public static larion.progate.lmis.model.LmisOverTimeReportDetails getLmisOverTimeReportDetails(
		java.lang.Integer lmisOverTimeReportDetailsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getLmisOverTimeReportDetails(lmisOverTimeReportDetailsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeReportDetailses(start, end);
	}

	public static int getLmisOverTimeReportDetailsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeReportDetailsesCount();
	}

	public static larion.progate.lmis.model.LmisOverTimeReportDetails updateLmisOverTimeReportDetails(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisOverTimeReportDetails(lmisOverTimeReportDetails);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportDetails updateLmisOverTimeReportDetails(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisOverTimeReportDetails(lmisOverTimeReportDetails,
			merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisOverTimeReportDetailsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisOverTimeReportDetailsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisOverTimeReportDetailsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisOverTimeReportDetailsLocalService service) {
		_service = service;
	}

	private static LmisOverTimeReportDetailsLocalService _service;
}