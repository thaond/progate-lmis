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

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="LmisViewRegistrationOvertimeaApprovalLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeaApprovalLocalServiceClp
	implements LmisViewRegistrationOvertimeaApprovalLocalService {
	public LmisViewRegistrationOvertimeaApprovalLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval addLmisViewRegistrationOvertimeaApproval(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisViewRegistrationOvertimeaApproval);

		if (lmisViewRegistrationOvertimeaApproval == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addLmisViewRegistrationOvertimeaApproval",
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

		return (larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval createLmisViewRegistrationOvertimeaApproval(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId) {
		Object paramObj0 = ClpSerializer.translateInput(lmisViewRegistrationOvertimeaApprovalId);

		if (lmisViewRegistrationOvertimeaApprovalId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createLmisViewRegistrationOvertimeaApproval",
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

		return (larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLmisViewRegistrationOvertimeaApproval(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisViewRegistrationOvertimeaApprovalId);

		if (lmisViewRegistrationOvertimeaApprovalId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisViewRegistrationOvertimeaApproval",
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

	public void deleteLmisViewRegistrationOvertimeaApproval(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisViewRegistrationOvertimeaApproval);

		if (lmisViewRegistrationOvertimeaApproval == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisViewRegistrationOvertimeaApproval",
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

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval getLmisViewRegistrationOvertimeaApproval(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisViewRegistrationOvertimeaApprovalId);

		if (lmisViewRegistrationOvertimeaApprovalId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisViewRegistrationOvertimeaApproval",
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

		return (larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> getLmisViewRegistrationOvertimeaApprovals(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisViewRegistrationOvertimeaApprovals",
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

		return (java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLmisViewRegistrationOvertimeaApprovalsCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisViewRegistrationOvertimeaApprovalsCount",
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

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval updateLmisViewRegistrationOvertimeaApproval(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisViewRegistrationOvertimeaApproval);

		if (lmisViewRegistrationOvertimeaApproval == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisViewRegistrationOvertimeaApproval",
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

		return (larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval updateLmisViewRegistrationOvertimeaApproval(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisViewRegistrationOvertimeaApproval);

		if (lmisViewRegistrationOvertimeaApproval == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisViewRegistrationOvertimeaApproval",
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

		return (larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.ArrayList<Integer> getListOverTimeApproval(int rootId,
		int approvedBy) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(approvedBy);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListOverTimeApproval",
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

		return (java.util.ArrayList<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> getListApproval(
		int rootId, int approvedBy) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(approvedBy);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListApproval",
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

		return (java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval>)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}