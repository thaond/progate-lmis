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
 * <a href="ProgateOrganizationsStaffsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationsStaffsLocalServiceUtil {
	public static larion.progate.model.ProgateOrganizationsStaffs addProgateOrganizationsStaffs(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addProgateOrganizationsStaffs(progateOrganizationsStaffs);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs createProgateOrganizationsStaffs(
		java.lang.Integer ProgateOrganizationsStaffsId) {
		return getService()
				   .createProgateOrganizationsStaffs(ProgateOrganizationsStaffsId);
	}

	public static void deleteProgateOrganizationsStaffs(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteProgateOrganizationsStaffs(ProgateOrganizationsStaffsId);
	}

	public static void deleteProgateOrganizationsStaffs(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException {
		getService().deleteProgateOrganizationsStaffs(progateOrganizationsStaffs);
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

	public static larion.progate.model.ProgateOrganizationsStaffs getProgateOrganizationsStaffs(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getProgateOrganizationsStaffs(ProgateOrganizationsStaffsId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> getProgateOrganizationsStaffses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProgateOrganizationsStaffses(start, end);
	}

	public static int getProgateOrganizationsStaffsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProgateOrganizationsStaffsesCount();
	}

	public static larion.progate.model.ProgateOrganizationsStaffs updateProgateOrganizationsStaffs(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateProgateOrganizationsStaffs(progateOrganizationsStaffs);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs updateProgateOrganizationsStaffs(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateProgateOrganizationsStaffs(progateOrganizationsStaffs,
			merge);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs createStaffs(
		int orgId, int userId, int participantId, java.util.Date beginDate,
		java.util.Date endDate, java.lang.String staffCode,
		java.lang.String scanCode) throws java.lang.Exception {
		return getService()
				   .createStaffs(orgId, userId, participantId, beginDate,
			endDate, staffCode, scanCode);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs getStaffDetails(
		int orgId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getStaffDetails(orgId, userId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> getEmployeeInformations(
		int rootId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getEmployeeInformations(rootId, userId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> getEmployeesInCompany(
		int rootId, int orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getEmployeesInCompany(rootId, orgId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> getEmployeesInPermissions(
		int rootId, int orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getEmployeesInPermissions(rootId, orgId);
	}

	public static java.util.List<Integer> getBODInCompany(int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getBODInCompany(rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProgateOrganizationsStaffsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProgateOrganizationsStaffsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProgateOrganizationsStaffsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProgateOrganizationsStaffsLocalService service) {
		_service = service;
	}

	private static ProgateOrganizationsStaffsLocalService _service;
}