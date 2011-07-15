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
 * <a href="LmisViewOrgUserRolesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOrgUserRolesLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewOrgUserRoles addLmisViewOrgUserRoles(
		larion.progate.lmis.model.LmisViewOrgUserRoles lmisViewOrgUserRoles)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewOrgUserRoles(lmisViewOrgUserRoles);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles createLmisViewOrgUserRoles(
		java.lang.Integer lmisViewOrgUserRolesId) {
		return getService().createLmisViewOrgUserRoles(lmisViewOrgUserRolesId);
	}

	public static void deleteLmisViewOrgUserRoles(
		java.lang.Integer lmisViewOrgUserRolesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewOrgUserRoles(lmisViewOrgUserRolesId);
	}

	public static void deleteLmisViewOrgUserRoles(
		larion.progate.lmis.model.LmisViewOrgUserRoles lmisViewOrgUserRoles)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewOrgUserRoles(lmisViewOrgUserRoles);
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

	public static larion.progate.lmis.model.LmisViewOrgUserRoles getLmisViewOrgUserRoles(
		java.lang.Integer lmisViewOrgUserRolesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewOrgUserRoles(lmisViewOrgUserRolesId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> getLmisViewOrgUserRoleses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewOrgUserRoleses(start, end);
	}

	public static int getLmisViewOrgUserRolesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewOrgUserRolesesCount();
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles updateLmisViewOrgUserRoles(
		larion.progate.lmis.model.LmisViewOrgUserRoles lmisViewOrgUserRoles)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewOrgUserRoles(lmisViewOrgUserRoles);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles updateLmisViewOrgUserRoles(
		larion.progate.lmis.model.LmisViewOrgUserRoles lmisViewOrgUserRoles,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewOrgUserRoles(lmisViewOrgUserRoles, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> getListOrgByUserIdPM(
		int userId, int rootId) throws com.liferay.portal.SystemException {
		return getService().getListOrgByUserIdPM(userId, rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> getListOrgByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getListOrgByRootId(rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewOrgUserRolesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewOrgUserRolesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewOrgUserRolesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewOrgUserRolesLocalService service) {
		_service = service;
	}

	private static LmisViewOrgUserRolesLocalService _service;
}