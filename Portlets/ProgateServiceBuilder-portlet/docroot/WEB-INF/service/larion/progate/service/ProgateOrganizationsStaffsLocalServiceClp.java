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

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="ProgateOrganizationsStaffsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationsStaffsLocalServiceClp
	implements ProgateOrganizationsStaffsLocalService {
	public ProgateOrganizationsStaffsLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.model.ProgateOrganizationsStaffs addProgateOrganizationsStaffs(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(progateOrganizationsStaffs);

		if (progateOrganizationsStaffs == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProgateOrganizationsStaffs");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addProgateOrganizationsStaffs",
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

		return (larion.progate.model.ProgateOrganizationsStaffs)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationsStaffs createProgateOrganizationsStaffs(
		java.lang.Integer ProgateOrganizationsStaffsId) {
		Object paramObj0 = ClpSerializer.translateInput(ProgateOrganizationsStaffsId);

		if (ProgateOrganizationsStaffsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createProgateOrganizationsStaffs",
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

		return (larion.progate.model.ProgateOrganizationsStaffs)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteProgateOrganizationsStaffs(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(ProgateOrganizationsStaffsId);

		if (ProgateOrganizationsStaffsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteProgateOrganizationsStaffs",
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

	public void deleteProgateOrganizationsStaffs(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(progateOrganizationsStaffs);

		if (progateOrganizationsStaffs == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProgateOrganizationsStaffs");
		}

		try {
			_classLoaderProxy.invoke("deleteProgateOrganizationsStaffs",
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

	public larion.progate.model.ProgateOrganizationsStaffs getProgateOrganizationsStaffs(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(ProgateOrganizationsStaffsId);

		if (ProgateOrganizationsStaffsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProgateOrganizationsStaffs",
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

		return (larion.progate.model.ProgateOrganizationsStaffs)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> getProgateOrganizationsStaffses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProgateOrganizationsStaffses",
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

		return (java.util.List<larion.progate.model.ProgateOrganizationsStaffs>)ClpSerializer.translateOutput(returnObj);
	}

	public int getProgateOrganizationsStaffsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProgateOrganizationsStaffsesCount",
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

	public larion.progate.model.ProgateOrganizationsStaffs updateProgateOrganizationsStaffs(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(progateOrganizationsStaffs);

		if (progateOrganizationsStaffs == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProgateOrganizationsStaffs");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProgateOrganizationsStaffs",
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

		return (larion.progate.model.ProgateOrganizationsStaffs)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationsStaffs updateProgateOrganizationsStaffs(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(progateOrganizationsStaffs);

		if (progateOrganizationsStaffs == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProgateOrganizationsStaffs");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProgateOrganizationsStaffs",
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

		return (larion.progate.model.ProgateOrganizationsStaffs)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationsStaffs createStaffs(
		int orgId, int userId, int participantId, java.util.Date beginDate,
		java.util.Date endDate, java.lang.String staffCode,
		java.lang.String scanCode) throws java.lang.Exception {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(participantId);

		Object paramObj3 = ClpSerializer.translateInput(beginDate);

		if (beginDate == null) {
			paramObj3 = new NullWrapper("java.util.Date");
		}

		Object paramObj4 = ClpSerializer.translateInput(endDate);

		if (endDate == null) {
			paramObj4 = new NullWrapper("java.util.Date");
		}

		Object paramObj5 = ClpSerializer.translateInput(staffCode);

		if (staffCode == null) {
			paramObj5 = new NullWrapper("java.lang.String");
		}

		Object paramObj6 = ClpSerializer.translateInput(scanCode);

		if (scanCode == null) {
			paramObj6 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createStaffs",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6
					});
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.model.ProgateOrganizationsStaffs)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProgateOrganizationsStaffs getStaffDetails(
		int orgId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getStaffDetails",
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

		return (larion.progate.model.ProgateOrganizationsStaffs)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> getEmployeeInformations(
		int rootId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployeeInformations",
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

		return (java.util.List<larion.progate.model.ProgateOrganizationsStaffs>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> getEmployeesInCompany(
		int rootId, int orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployeesInCompany",
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

		return (java.util.List<larion.progate.model.ProgateOrganizationsStaffs>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> getEmployeesInPermissions(
		int rootId, int orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmployeesInPermissions",
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

		return (java.util.List<larion.progate.model.ProgateOrganizationsStaffs>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<Integer> getBODInCompany(int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getBODInCompany",
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

		return (java.util.List<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}