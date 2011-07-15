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
 * <a href="ViewFinalTitlesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalTitlesLocalServiceUtil {
	public static larion.progate.cds.model.ViewFinalTitles addViewFinalTitles(
		larion.progate.cds.model.ViewFinalTitles viewFinalTitles)
		throws com.liferay.portal.SystemException {
		return getService().addViewFinalTitles(viewFinalTitles);
	}

	public static larion.progate.cds.model.ViewFinalTitles createViewFinalTitles(
		java.lang.Integer ViewFinalTitlesId) {
		return getService().createViewFinalTitles(ViewFinalTitlesId);
	}

	public static void deleteViewFinalTitles(
		java.lang.Integer ViewFinalTitlesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewFinalTitles(ViewFinalTitlesId);
	}

	public static void deleteViewFinalTitles(
		larion.progate.cds.model.ViewFinalTitles viewFinalTitles)
		throws com.liferay.portal.SystemException {
		getService().deleteViewFinalTitles(viewFinalTitles);
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

	public static larion.progate.cds.model.ViewFinalTitles getViewFinalTitles(
		java.lang.Integer ViewFinalTitlesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewFinalTitles(ViewFinalTitlesId);
	}

	public static java.util.List<larion.progate.cds.model.ViewFinalTitles> getViewFinalTitleses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewFinalTitleses(start, end);
	}

	public static int getViewFinalTitlesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewFinalTitlesesCount();
	}

	public static larion.progate.cds.model.ViewFinalTitles updateViewFinalTitles(
		larion.progate.cds.model.ViewFinalTitles viewFinalTitles)
		throws com.liferay.portal.SystemException {
		return getService().updateViewFinalTitles(viewFinalTitles);
	}

	public static larion.progate.cds.model.ViewFinalTitles updateViewFinalTitles(
		larion.progate.cds.model.ViewFinalTitles viewFinalTitles, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateViewFinalTitles(viewFinalTitles, merge);
	}

	public static java.lang.String getTitleNameByRootIdAndUserId(int rootId,
		int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getTitleNameByRootIdAndUserId(rootId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewFinalTitlesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewFinalTitlesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewFinalTitlesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewFinalTitlesLocalService service) {
		_service = service;
	}

	private static ViewFinalTitlesLocalService _service;
}