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

package larion.progate.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="OrganizationViewLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationViewLocalServiceUtil {
	public static larion.progate.model.OrganizationView addOrganizationView(
		larion.progate.model.OrganizationView organizationView)
		throws com.liferay.portal.SystemException {
		return getService().addOrganizationView(organizationView);
	}

	public static larion.progate.model.OrganizationView createOrganizationView(
		int orgId) {
		return getService().createOrganizationView(orgId);
	}

	public static void deleteOrganizationView(int orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteOrganizationView(orgId);
	}

	public static void deleteOrganizationView(
		larion.progate.model.OrganizationView organizationView)
		throws com.liferay.portal.SystemException {
		getService().deleteOrganizationView(organizationView);
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

	public static larion.progate.model.OrganizationView getOrganizationView(
		int orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getOrganizationView(orgId);
	}

	public static java.util.List<larion.progate.model.OrganizationView> getOrganizationViews(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getOrganizationViews(start, end);
	}

	public static int getOrganizationViewsCount()
		throws com.liferay.portal.SystemException {
		return getService().getOrganizationViewsCount();
	}

	public static larion.progate.model.OrganizationView updateOrganizationView(
		larion.progate.model.OrganizationView organizationView)
		throws com.liferay.portal.SystemException {
		return getService().updateOrganizationView(organizationView);
	}

	public static larion.progate.model.OrganizationView updateOrganizationView(
		larion.progate.model.OrganizationView organizationView, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateOrganizationView(organizationView, merge);
	}

	public static java.util.List<larion.progate.model.OrganizationView> searchOrgName(
		java.lang.String orgName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getService().searchOrgName(orgName, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static OrganizationViewLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					OrganizationViewLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new OrganizationViewLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(OrganizationViewLocalService service) {
		_service = service;
	}

	private static OrganizationViewLocalService _service;
}