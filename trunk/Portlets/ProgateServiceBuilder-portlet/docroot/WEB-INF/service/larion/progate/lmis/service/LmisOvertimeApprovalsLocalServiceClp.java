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
 * <a href="LmisOvertimeApprovalsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeApprovalsLocalServiceClp
	implements LmisOvertimeApprovalsLocalService {
	public LmisOvertimeApprovalsLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.lmis.model.LmisOvertimeApprovals addLmisOvertimeApprovals(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeApprovals);

		if (lmisOvertimeApprovals == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOvertimeApprovals");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addLmisOvertimeApprovals",
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

		return (larion.progate.lmis.model.LmisOvertimeApprovals)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisOvertimeApprovals createLmisOvertimeApprovals(
		java.lang.Integer lmisOvertimeApprovalsId) {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeApprovalsId);

		if (lmisOvertimeApprovalsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createLmisOvertimeApprovals",
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

		return (larion.progate.lmis.model.LmisOvertimeApprovals)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLmisOvertimeApprovals(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeApprovalsId);

		if (lmisOvertimeApprovalsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisOvertimeApprovals",
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

	public void deleteLmisOvertimeApprovals(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeApprovals);

		if (lmisOvertimeApprovals == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOvertimeApprovals");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisOvertimeApprovals",
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

	public larion.progate.lmis.model.LmisOvertimeApprovals getLmisOvertimeApprovals(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeApprovalsId);

		if (lmisOvertimeApprovalsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisOvertimeApprovals",
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

		return (larion.progate.lmis.model.LmisOvertimeApprovals)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisOvertimeApprovalses",
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

		return (java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLmisOvertimeApprovalsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisOvertimeApprovalsesCount",
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

	public larion.progate.lmis.model.LmisOvertimeApprovals updateLmisOvertimeApprovals(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeApprovals);

		if (lmisOvertimeApprovals == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOvertimeApprovals");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisOvertimeApprovals",
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

		return (larion.progate.lmis.model.LmisOvertimeApprovals)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisOvertimeApprovals updateLmisOvertimeApprovals(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeApprovals);

		if (lmisOvertimeApprovals == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOvertimeApprovals");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisOvertimeApprovals",
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

		return (larion.progate.lmis.model.LmisOvertimeApprovals)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getApprovalFeedback(int reportId, int rootId)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(reportId);

		Object paramObj1 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getApprovalFeedback",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public boolean updateOTapp(int rootId, int reportId, int requestId,
		int PmId, java.lang.String reason) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(reportId);

		Object paramObj2 = new IntegerWrapper(requestId);

		Object paramObj3 = new IntegerWrapper(PmId);

		Object paramObj4 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateOTapp",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
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

		return ((Boolean)returnObj).booleanValue();
	}

	private ClassLoaderProxy _classLoaderProxy;
}