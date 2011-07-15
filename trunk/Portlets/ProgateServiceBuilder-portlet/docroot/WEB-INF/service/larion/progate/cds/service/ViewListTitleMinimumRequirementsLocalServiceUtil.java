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
 * <a href="ViewListTitleMinimumRequirementsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewListTitleMinimumRequirementsLocalServiceUtil {
	public static larion.progate.cds.model.ViewListTitleMinimumRequirements addViewListTitleMinimumRequirements(
		larion.progate.cds.model.ViewListTitleMinimumRequirements viewListTitleMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addViewListTitleMinimumRequirements(viewListTitleMinimumRequirements);
	}

	public static larion.progate.cds.model.ViewListTitleMinimumRequirements createViewListTitleMinimumRequirements(
		java.lang.String id) {
		return getService().createViewListTitleMinimumRequirements(id);
	}

	public static void deleteViewListTitleMinimumRequirements(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewListTitleMinimumRequirements(id);
	}

	public static void deleteViewListTitleMinimumRequirements(
		larion.progate.cds.model.ViewListTitleMinimumRequirements viewListTitleMinimumRequirements)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteViewListTitleMinimumRequirements(viewListTitleMinimumRequirements);
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

	public static larion.progate.cds.model.ViewListTitleMinimumRequirements getViewListTitleMinimumRequirements(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewListTitleMinimumRequirements(id);
	}

	public static java.util.List<larion.progate.cds.model.ViewListTitleMinimumRequirements> getViewListTitleMinimumRequirementses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewListTitleMinimumRequirementses(start, end);
	}

	public static int getViewListTitleMinimumRequirementsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewListTitleMinimumRequirementsesCount();
	}

	public static larion.progate.cds.model.ViewListTitleMinimumRequirements updateViewListTitleMinimumRequirements(
		larion.progate.cds.model.ViewListTitleMinimumRequirements viewListTitleMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewListTitleMinimumRequirements(viewListTitleMinimumRequirements);
	}

	public static larion.progate.cds.model.ViewListTitleMinimumRequirements updateViewListTitleMinimumRequirements(
		larion.progate.cds.model.ViewListTitleMinimumRequirements viewListTitleMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewListTitleMinimumRequirements(viewListTitleMinimumRequirements,
			merge);
	}

	public static java.util.List<larion.progate.cds.model.ViewListTitleMinimumRequirements> loadListTitleMinimumRequirements(
		int titleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().loadListTitleMinimumRequirements(titleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewListTitleMinimumRequirementsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewListTitleMinimumRequirementsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewListTitleMinimumRequirementsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewListTitleMinimumRequirementsLocalService service) {
		_service = service;
	}

	private static ViewListTitleMinimumRequirementsLocalService _service;
}