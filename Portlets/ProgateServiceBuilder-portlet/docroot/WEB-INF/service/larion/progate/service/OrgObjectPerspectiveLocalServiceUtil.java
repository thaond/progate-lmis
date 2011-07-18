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
 * <a href="OrgObjectPerspectiveLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectPerspectiveLocalServiceUtil {
	public static larion.progate.model.OrgObjectPerspective addOrgObjectPerspective(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective)
		throws com.liferay.portal.SystemException {
		return getService().addOrgObjectPerspective(orgObjectPerspective);
	}

	public static larion.progate.model.OrgObjectPerspective createOrgObjectPerspective(
		java.lang.Integer orgObjectPerspectiveId) {
		return getService().createOrgObjectPerspective(orgObjectPerspectiveId);
	}

	public static void deleteOrgObjectPerspective(
		java.lang.Integer orgObjectPerspectiveId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteOrgObjectPerspective(orgObjectPerspectiveId);
	}

	public static void deleteOrgObjectPerspective(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective)
		throws com.liferay.portal.SystemException {
		getService().deleteOrgObjectPerspective(orgObjectPerspective);
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

	public static larion.progate.model.OrgObjectPerspective getOrgObjectPerspective(
		java.lang.Integer orgObjectPerspectiveId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getOrgObjectPerspective(orgObjectPerspectiveId);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getOrgObjectPerspectives(start, end);
	}

	public static int getOrgObjectPerspectivesCount()
		throws com.liferay.portal.SystemException {
		return getService().getOrgObjectPerspectivesCount();
	}

	public static larion.progate.model.OrgObjectPerspective updateOrgObjectPerspective(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective)
		throws com.liferay.portal.SystemException {
		return getService().updateOrgObjectPerspective(orgObjectPerspective);
	}

	public static larion.progate.model.OrgObjectPerspective updateOrgObjectPerspective(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateOrgObjectPerspective(orgObjectPerspective, merge);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> getListSetPers(
		int setId) {
		return getService().getListSetPers(setId);
	}

	public static boolean editSetPer(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective) {
		return getService().editSetPer(orgObjectPerspective);
	}

	public static void clearService() {
		_service = null;
	}

	public static OrgObjectPerspectiveLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					OrgObjectPerspectiveLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new OrgObjectPerspectiveLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(OrgObjectPerspectiveLocalService service) {
		_service = service;
	}

	private static OrgObjectPerspectiveLocalService _service;
}