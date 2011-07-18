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
 * <a href="ViewListTitleCompetenciesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleCompetenciesLocalServiceUtil {
	public static larion.progate.cds.model.ViewListTitleCompetencies addViewListTitleCompetencies(
		larion.progate.cds.model.ViewListTitleCompetencies viewListTitleCompetencies)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addViewListTitleCompetencies(viewListTitleCompetencies);
	}

	public static larion.progate.cds.model.ViewListTitleCompetencies createViewListTitleCompetencies(
		java.lang.String id) {
		return getService().createViewListTitleCompetencies(id);
	}

	public static void deleteViewListTitleCompetencies(java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewListTitleCompetencies(id);
	}

	public static void deleteViewListTitleCompetencies(
		larion.progate.cds.model.ViewListTitleCompetencies viewListTitleCompetencies)
		throws com.liferay.portal.SystemException {
		getService().deleteViewListTitleCompetencies(viewListTitleCompetencies);
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

	public static larion.progate.cds.model.ViewListTitleCompetencies getViewListTitleCompetencies(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewListTitleCompetencies(id);
	}

	public static java.util.List<larion.progate.cds.model.ViewListTitleCompetencies> getViewListTitleCompetencieses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewListTitleCompetencieses(start, end);
	}

	public static int getViewListTitleCompetenciesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewListTitleCompetenciesesCount();
	}

	public static larion.progate.cds.model.ViewListTitleCompetencies updateViewListTitleCompetencies(
		larion.progate.cds.model.ViewListTitleCompetencies viewListTitleCompetencies)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewListTitleCompetencies(viewListTitleCompetencies);
	}

	public static larion.progate.cds.model.ViewListTitleCompetencies updateViewListTitleCompetencies(
		larion.progate.cds.model.ViewListTitleCompetencies viewListTitleCompetencies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewListTitleCompetencies(viewListTitleCompetencies,
			merge);
	}

	public static java.util.List<larion.progate.cds.model.ViewListTitleCompetencies> loadListTitleCompetencies(
		int titleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().loadListTitleCompetencies(titleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewListTitleCompetenciesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewListTitleCompetenciesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewListTitleCompetenciesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewListTitleCompetenciesLocalService service) {
		_service = service;
	}

	private static ViewListTitleCompetenciesLocalService _service;
}