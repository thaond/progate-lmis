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
 * <a href="ProGateRolesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateRolesLocalServiceUtil {
	public static larion.progate.model.ProGateRoles addProGateRoles(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException {
		return getService().addProGateRoles(proGateRoles);
	}

	public static larion.progate.model.ProGateRoles createProGateRoles(
		java.lang.Integer roleId) {
		return getService().createProGateRoles(roleId);
	}

	public static void deleteProGateRoles(java.lang.Integer roleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProGateRoles(roleId);
	}

	public static void deleteProGateRoles(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException {
		getService().deleteProGateRoles(proGateRoles);
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

	public static larion.progate.model.ProGateRoles getProGateRoles(
		java.lang.Integer roleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProGateRoles(roleId);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> getProGateRoleses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateRoleses(start, end);
	}

	public static int getProGateRolesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateRolesesCount();
	}

	public static larion.progate.model.ProGateRoles updateProGateRoles(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException {
		return getService().updateProGateRoles(proGateRoles);
	}

	public static larion.progate.model.ProGateRoles updateProGateRoles(
		larion.progate.model.ProGateRoles proGateRoles, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateProGateRoles(proGateRoles, merge);
	}

	public static java.lang.String getRoleOfUserInOrg(int userId, int orgId) {
		return getService().getRoleOfUserInOrg(userId, orgId);
	}

	public static int getProGateAdminRoleId() {
		return getService().getProGateAdminRoleId();
	}

	public static int getProGateUserRoleId() {
		return getService().getProGateUserRoleId();
	}

	public static int getOrgMemberRoleId() {
		return getService().getOrgMemberRoleId();
	}

	public static int getOrgAdminRoleId() {
		return getService().getOrgAdminRoleId();
	}

	public static int getGuestRoleId() {
		return getService().getGuestRoleId();
	}

	public static int getManagerRoleId() {
		return getService().getManagerRoleId();
	}

	public static int getBodRoleId() {
		return getService().getBodRoleId();
	}

	public static int getStaffOfRoleId() {
		return getService().getStaffOfRoleId();
	}

	public static int getMemberOfRoleId() {
		return getService().getMemberOfRoleId();
	}

	public static int getOwnerRoleId() {
		return getService().getOwnerRoleId();
	}

	public static java.util.List<larion.progate.model.ProGateRoles> getListRoles(
		int type) {
		return getService().getListRoles(type);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> getListRolesOfChildOrg() {
		return getService().getListRolesOfChildOrg();
	}

	public static java.util.List<larion.progate.model.ProGateRoles> getListRolesOfRootOrg() {
		return getService().getListRolesOfRootOrg();
	}

	public static java.util.List<larion.progate.model.ProGateRoles> getListRolesByOrgId(
		int orgId) {
		return getService().getListRolesByOrgId(orgId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateRolesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateRolesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateRolesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateRolesLocalService service) {
		_service = service;
	}

	private static ProGateRolesLocalService _service;
}