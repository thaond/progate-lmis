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
 * <a href="LmisViewStaffRootOrgOrderedLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgOrderedLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered addLmisViewStaffRootOrgOrdered(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addLmisViewStaffRootOrgOrdered(lmisViewStaffRootOrgOrdered);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered createLmisViewStaffRootOrgOrdered(
		java.lang.Integer lmisViewStaffRootOrgOrderedId) {
		return getService()
				   .createLmisViewStaffRootOrgOrdered(lmisViewStaffRootOrgOrderedId);
	}

	public static void deleteLmisViewStaffRootOrgOrdered(
		java.lang.Integer lmisViewStaffRootOrgOrderedId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewStaffRootOrgOrdered(lmisViewStaffRootOrgOrderedId);
	}

	public static void deleteLmisViewStaffRootOrgOrdered(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewStaffRootOrgOrdered(lmisViewStaffRootOrgOrdered);
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

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered getLmisViewStaffRootOrgOrdered(
		java.lang.Integer lmisViewStaffRootOrgOrderedId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getLmisViewStaffRootOrgOrdered(lmisViewStaffRootOrgOrderedId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> getLmisViewStaffRootOrgOrdereds(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewStaffRootOrgOrdereds(start, end);
	}

	public static int getLmisViewStaffRootOrgOrderedsCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewStaffRootOrgOrderedsCount();
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered updateLmisViewStaffRootOrgOrdered(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewStaffRootOrgOrdered(lmisViewStaffRootOrgOrdered);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered updateLmisViewStaffRootOrgOrdered(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewStaffRootOrgOrdered(lmisViewStaffRootOrgOrdered,
			merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findAttCode(
		int rootId) {
		return getService().findAttCode(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findAttCodeOrg(
		int rootId, int orgId) {
		return getService().findAttCodeOrg(rootId, orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> getListStaffOfOrg(
		int rootId, int orgId) {
		return getService().getListStaffOfOrg(rootId, orgId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewStaffRootOrgOrderedLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewStaffRootOrgOrderedLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewStaffRootOrgOrderedLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewStaffRootOrgOrderedLocalService service) {
		_service = service;
	}

	private static LmisViewStaffRootOrgOrderedLocalService _service;
}