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

package larion.progate.cds.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="ViewPerformanceAppraisalLevelsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewPerformanceAppraisalLevelsLocalServiceUtil {
	public static larion.progate.cds.model.ViewPerformanceAppraisalLevels addViewPerformanceAppraisalLevels(
		larion.progate.cds.model.ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addViewPerformanceAppraisalLevels(viewPerformanceAppraisalLevels);
	}

	public static larion.progate.cds.model.ViewPerformanceAppraisalLevels createViewPerformanceAppraisalLevels(
		java.lang.String id) {
		return getService().createViewPerformanceAppraisalLevels(id);
	}

	public static void deleteViewPerformanceAppraisalLevels(java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewPerformanceAppraisalLevels(id);
	}

	public static void deleteViewPerformanceAppraisalLevels(
		larion.progate.cds.model.ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteViewPerformanceAppraisalLevels(viewPerformanceAppraisalLevels);
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

	public static larion.progate.cds.model.ViewPerformanceAppraisalLevels getViewPerformanceAppraisalLevels(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewPerformanceAppraisalLevels(id);
	}

	public static java.util.List<larion.progate.cds.model.ViewPerformanceAppraisalLevels> getViewPerformanceAppraisalLevelses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewPerformanceAppraisalLevelses(start, end);
	}

	public static int getViewPerformanceAppraisalLevelsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewPerformanceAppraisalLevelsesCount();
	}

	public static larion.progate.cds.model.ViewPerformanceAppraisalLevels updateViewPerformanceAppraisalLevels(
		larion.progate.cds.model.ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewPerformanceAppraisalLevels(viewPerformanceAppraisalLevels);
	}

	public static larion.progate.cds.model.ViewPerformanceAppraisalLevels updateViewPerformanceAppraisalLevels(
		larion.progate.cds.model.ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewPerformanceAppraisalLevels(viewPerformanceAppraisalLevels,
			merge);
	}

	public static java.util.List<larion.progate.cds.model.ViewPerformanceAppraisalLevels> getCdsPALevels(
		int userId, int periodId, int competencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsPALevels(userId, periodId, competencyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewPerformanceAppraisalLevelsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewPerformanceAppraisalLevelsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewPerformanceAppraisalLevelsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewPerformanceAppraisalLevelsLocalService service) {
		_service = service;
	}

	private static ViewPerformanceAppraisalLevelsLocalService _service;
}