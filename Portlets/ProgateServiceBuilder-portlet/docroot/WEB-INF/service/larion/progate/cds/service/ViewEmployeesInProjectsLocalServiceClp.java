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

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="ViewEmployeesInProjectsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesInProjectsLocalServiceClp
	implements ViewEmployeesInProjectsLocalService {
	public ViewEmployeesInProjectsLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.cds.model.ViewEmployeesInProjects addViewEmployeesInProjects(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewEmployeesInProjects);

		if (viewEmployeesInProjects == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.ViewEmployeesInProjects");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addViewEmployeesInProjects",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.cds.model.ViewEmployeesInProjects)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.ViewEmployeesInProjects createViewEmployeesInProjects(
		java.lang.String id) {
		Object paramObj0 = ClpSerializer.translateInput(id);

		if (id == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createViewEmployeesInProjects",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.cds.model.ViewEmployeesInProjects)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteViewEmployeesInProjects(java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(id);

		if (id == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		try {
			_classLoaderProxy.invoke("deleteViewEmployeesInProjects",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteViewEmployeesInProjects(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewEmployeesInProjects);

		if (viewEmployeesInProjects == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.ViewEmployeesInProjects");
		}

		try {
			_classLoaderProxy.invoke("deleteViewEmployeesInProjects",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object paramObj1 = new IntegerWrapper(start);

		Object paramObj2 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.ViewEmployeesInProjects getViewEmployeesInProjects(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(id);

		if (id == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getViewEmployeesInProjects",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.cds.model.ViewEmployeesInProjects)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getViewEmployeesInProjectses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getViewEmployeesInProjectses",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.cds.model.ViewEmployeesInProjects>)ClpSerializer.translateOutput(returnObj);
	}

	public int getViewEmployeesInProjectsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getViewEmployeesInProjectsesCount",
					new Object[0]);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public larion.progate.cds.model.ViewEmployeesInProjects updateViewEmployeesInProjects(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewEmployeesInProjects);

		if (viewEmployeesInProjects == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.ViewEmployeesInProjects");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateViewEmployeesInProjects",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.cds.model.ViewEmployeesInProjects)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.ViewEmployeesInProjects updateViewEmployeesInProjects(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewEmployeesInProjects);

		if (viewEmployeesInProjects == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.ViewEmployeesInProjects");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateViewEmployeesInProjects",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.cds.model.ViewEmployeesInProjects)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployees(
		int periodId, int orgId, int ratingStatusPm, int pmUid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(periodId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(ratingStatusPm);

		Object paramObj3 = new IntegerWrapper(pmUid);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployees",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.cds.model.ViewEmployeesInProjects>)ClpSerializer.translateOutput(returnObj);
	}

	public int checkEmployee(int periodId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(periodId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("checkEmployee",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeesBOD(
		int periodId, int orgId, int ratingStatusBod, int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(periodId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(ratingStatusBod);

		Object paramObj3 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployeesBOD",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.cds.model.ViewEmployeesInProjects>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getAllEmplApprovalBOD(
		int periodId, int orgId, int ratingStatusBod, int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(periodId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(ratingStatusBod);

		Object paramObj3 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getAllEmplApprovalBOD",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.cds.model.ViewEmployeesInProjects>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeeReportDetails(
		int rootId, int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(periodId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployeeReportDetails",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.cds.model.ViewEmployeesInProjects>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeeDetailsCDP(
		int rootId, int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(periodId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployeeDetailsCDP",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.cds.model.ViewEmployeesInProjects>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeeStateReport(
		int userType, int rootId, int orgId, int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userType);

		Object paramObj1 = new IntegerWrapper(rootId);

		Object paramObj2 = new IntegerWrapper(orgId);

		Object paramObj3 = new IntegerWrapper(userId);

		Object paramObj4 = new IntegerWrapper(periodId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployeeStateReport",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.cds.model.ViewEmployeesInProjects>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeesCdp(
		int periodId, int orgId, int pmUid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(periodId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(pmUid);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployeesCdp",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.cds.model.ViewEmployeesInProjects>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> getEmployeesCdpBOD(
		int periodId, int orgId, int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(periodId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployeesCdpBOD",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.cds.model.ViewEmployeesInProjects>)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}