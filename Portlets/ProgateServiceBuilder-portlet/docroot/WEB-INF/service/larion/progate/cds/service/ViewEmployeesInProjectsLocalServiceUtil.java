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
 * <a href="ViewEmployeesInProjectsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesInProjectsLocalServiceUtil {
	public static larion.progate.cds.model.ViewEmployeesInProjects addViewEmployeesInProjects(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException {
		return getService().addViewEmployeesInProjects(viewEmployeesInProjects);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects createViewEmployeesInProjects(
		java.lang.String id) {
		return getService().createViewEmployeesInProjects(id);
	}

	public static void deleteViewEmployeesInProjects(java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewEmployeesInProjects(id);
	}

	public static void deleteViewEmployeesInProjects(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException {
		getService().deleteViewEmployeesInProjects(viewEmployeesInProjects);
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

	public static larion.progate.cds.model.ViewEmployeesInProjects getViewEmployeesInProjects(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewEmployeesInProjects(id);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getViewEmployeesInProjectses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewEmployeesInProjectses(start, end);
	}

	public static int getViewEmployeesInProjectsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewEmployeesInProjectsesCount();
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects updateViewEmployeesInProjects(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewEmployeesInProjects(viewEmployeesInProjects);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects updateViewEmployeesInProjects(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateViewEmployeesInProjects(viewEmployeesInProjects, merge);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployees(
		int periodId, int orgId, int ratingStatusPm, int pmUid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getEmployees(periodId, orgId, ratingStatusPm, pmUid);
	}

	public static int checkEmployee(int periodId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().checkEmployee(periodId, userId);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeesBOD(
		int periodId, int orgId, int ratingStatusBod, int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getEmployeesBOD(periodId, orgId, ratingStatusBod, rootId);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getAllEmplApprovalBOD(
		int periodId, int orgId, int ratingStatusBod, int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getAllEmplApprovalBOD(periodId, orgId, ratingStatusBod,
			rootId);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeeReportDetails(
		int rootId, int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getEmployeeReportDetails(rootId, userId, periodId);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeeDetailsCDP(
		int rootId, int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getEmployeeDetailsCDP(rootId, userId, periodId);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeeStateReport(
		int userType, int rootId, int orgId, int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getEmployeeStateReport(userType, rootId, orgId, userId,
			periodId);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeesCdp(
		int periodId, int orgId, int pmUid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getEmployeesCdp(periodId, orgId, pmUid);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeesCdpBOD(
		int periodId, int orgId, int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getEmployeesCdpBOD(periodId, orgId, rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewEmployeesInProjectsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewEmployeesInProjectsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewEmployeesInProjectsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewEmployeesInProjectsLocalService service) {
		_service = service;
	}

	private static ViewEmployeesInProjectsLocalService _service;
}