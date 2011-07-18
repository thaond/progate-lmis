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
 * <a href="LmisOvertimeRequestsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeRequestsLocalServiceClp
	implements LmisOvertimeRequestsLocalService {
	public LmisOvertimeRequestsLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.lmis.model.LmisOvertimeRequests addLmisOvertimeRequests(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeRequests);

		if (lmisOvertimeRequests == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOvertimeRequests");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addLmisOvertimeRequests",
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

		return (larion.progate.lmis.model.LmisOvertimeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisOvertimeRequests createLmisOvertimeRequests(
		java.lang.Integer lmisOvertimeRequestsId) {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeRequestsId);

		if (lmisOvertimeRequestsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createLmisOvertimeRequests",
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

		return (larion.progate.lmis.model.LmisOvertimeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLmisOvertimeRequests(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeRequestsId);

		if (lmisOvertimeRequestsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisOvertimeRequests",
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

	public void deleteLmisOvertimeRequests(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeRequests);

		if (lmisOvertimeRequests == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOvertimeRequests");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisOvertimeRequests",
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

	public larion.progate.lmis.model.LmisOvertimeRequests getLmisOvertimeRequests(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeRequestsId);

		if (lmisOvertimeRequestsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisOvertimeRequests",
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

		return (larion.progate.lmis.model.LmisOvertimeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> getLmisOvertimeRequestses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisOvertimeRequestses",
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

		return (java.util.List<larion.progate.lmis.model.LmisOvertimeRequests>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLmisOvertimeRequestsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisOvertimeRequestsesCount",
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

	public larion.progate.lmis.model.LmisOvertimeRequests updateLmisOvertimeRequests(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeRequests);

		if (lmisOvertimeRequests == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOvertimeRequests");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisOvertimeRequests",
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

		return (larion.progate.lmis.model.LmisOvertimeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisOvertimeRequests updateLmisOvertimeRequests(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOvertimeRequests);

		if (lmisOvertimeRequests == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOvertimeRequests");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisOvertimeRequests",
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

		return (larion.progate.lmis.model.LmisOvertimeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public int addOtRequest(int rootId, int orgId, int userId,
		java.lang.String otReason, java.util.Date regDate,
		java.util.Date reqDate, int[] arrUID, java.util.List arrReason,
		double[] arrTotal, java.util.List arrHM, java.util.List arrEndTime) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(userId);

		Object paramObj3 = ClpSerializer.translateInput(otReason);

		if (otReason == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = ClpSerializer.translateInput(regDate);

		if (regDate == null) {
			paramObj4 = new NullWrapper("java.util.Date");
		}

		Object paramObj5 = ClpSerializer.translateInput(reqDate);

		if (reqDate == null) {
			paramObj5 = new NullWrapper("java.util.Date");
		}

		Object paramObj6 = ClpSerializer.translateInput(arrUID);

		if (arrUID == null) {
			paramObj6 = new NullWrapper("[I");
		}

		Object paramObj7 = ClpSerializer.translateInput(arrReason);

		if (arrReason == null) {
			paramObj7 = new NullWrapper("java.util.List");
		}

		Object paramObj8 = ClpSerializer.translateInput(arrTotal);

		if (arrTotal == null) {
			paramObj8 = new NullWrapper("[D");
		}

		Object paramObj9 = ClpSerializer.translateInput(arrHM);

		if (arrHM == null) {
			paramObj9 = new NullWrapper("java.util.List");
		}

		Object paramObj10 = ClpSerializer.translateInput(arrEndTime);

		if (arrEndTime == null) {
			paramObj10 = new NullWrapper("java.util.List");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addOtRequest",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
						paramObj10
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

		return ((Integer)returnObj).intValue();
	}

	public int editOtRequest(int rootId, int reqId, java.lang.String otReason,
		java.util.Date reqDate, int[] arrUID, java.util.List arrReason,
		double[] arrTotal, java.util.List arrHM, java.util.List arrEndTime) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(reqId);

		Object paramObj2 = ClpSerializer.translateInput(otReason);

		if (otReason == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = ClpSerializer.translateInput(reqDate);

		if (reqDate == null) {
			paramObj3 = new NullWrapper("java.util.Date");
		}

		Object paramObj4 = ClpSerializer.translateInput(arrUID);

		if (arrUID == null) {
			paramObj4 = new NullWrapper("[I");
		}

		Object paramObj5 = ClpSerializer.translateInput(arrReason);

		if (arrReason == null) {
			paramObj5 = new NullWrapper("java.util.List");
		}

		Object paramObj6 = ClpSerializer.translateInput(arrTotal);

		if (arrTotal == null) {
			paramObj6 = new NullWrapper("[D");
		}

		Object paramObj7 = ClpSerializer.translateInput(arrHM);

		if (arrHM == null) {
			paramObj7 = new NullWrapper("java.util.List");
		}

		Object paramObj8 = ClpSerializer.translateInput(arrEndTime);

		if (arrEndTime == null) {
			paramObj8 = new NullWrapper("java.util.List");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("editOtRequest",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8
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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterTabManager(
		int rootId, int orgId, int userId, int status) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(userId);

		Object paramObj3 = new IntegerWrapper(status);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("filterTabManager",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
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

		return (java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterTabOther(
		int rootId, int orgId, int status) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object paramObj2 = new IntegerWrapper(status);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("filterTabOther",
					new Object[] { paramObj0, paramObj1, paramObj2 });
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

		return (java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterAll(
		int rootId, java.util.Date day, int userId, int status) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = ClpSerializer.translateInput(day);

		if (day == null) {
			paramObj1 = new NullWrapper("java.util.Date");
		}

		Object paramObj2 = new IntegerWrapper(userId);

		Object paramObj3 = new IntegerWrapper(status);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("filterAll",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
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

		return (java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime>)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}