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
 * <a href="LmisTimeChangeRequestsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeRequestsLocalServiceClp
	implements LmisTimeChangeRequestsLocalService {
	public LmisTimeChangeRequestsLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.lmis.model.LmisTimeChangeRequests addLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisTimeChangeRequests);

		if (lmisTimeChangeRequests == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisTimeChangeRequests");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addLmisTimeChangeRequests",
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

		return (larion.progate.lmis.model.LmisTimeChangeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisTimeChangeRequests createLmisTimeChangeRequests(
		java.lang.Integer lmisTimeChangeRequestId) {
		Object paramObj0 = ClpSerializer.translateInput(lmisTimeChangeRequestId);

		if (lmisTimeChangeRequestId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createLmisTimeChangeRequests",
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

		return (larion.progate.lmis.model.LmisTimeChangeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLmisTimeChangeRequests(
		java.lang.Integer lmisTimeChangeRequestId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisTimeChangeRequestId);

		if (lmisTimeChangeRequestId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisTimeChangeRequests",
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

	public void deleteLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisTimeChangeRequests);

		if (lmisTimeChangeRequests == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisTimeChangeRequests");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisTimeChangeRequests",
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

	public larion.progate.lmis.model.LmisTimeChangeRequests getLmisTimeChangeRequests(
		java.lang.Integer lmisTimeChangeRequestId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisTimeChangeRequestId);

		if (lmisTimeChangeRequestId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisTimeChangeRequests",
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

		return (larion.progate.lmis.model.LmisTimeChangeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> getLmisTimeChangeRequestses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisTimeChangeRequestses",
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

		return (java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLmisTimeChangeRequestsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisTimeChangeRequestsesCount",
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

	public larion.progate.lmis.model.LmisTimeChangeRequests updateLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisTimeChangeRequests);

		if (lmisTimeChangeRequests == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisTimeChangeRequests");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisTimeChangeRequests",
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

		return (larion.progate.lmis.model.LmisTimeChangeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisTimeChangeRequests updateLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisTimeChangeRequests);

		if (lmisTimeChangeRequests == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisTimeChangeRequests");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisTimeChangeRequests",
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

		return (larion.progate.lmis.model.LmisTimeChangeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> getListRequestTimeChangeOf(
		int rootId, int userId) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListRequestTimeChangeOf",
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

		return (java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests>)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisTimeChangeRequests getDetailRequestTimeChange(
		int rootId, int requestId) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(requestId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getDetailRequestTimeChange",
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

		return (larion.progate.lmis.model.LmisTimeChangeRequests)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getContentApprovals(int rootId, int requestId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(requestId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getContentApprovals",
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public boolean editRequestTimeChange(int rootId, int requestId,
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date monStartTime, java.util.Date monEndTime,
		java.util.Date tueStartDate, java.util.Date tueEndTime,
		java.util.Date wedStartTime, java.util.Date wedEndTime,
		java.util.Date thuStartTime, java.util.Date thuEndTime,
		java.util.Date friStartTime, java.util.Date friEndTime,
		java.util.Date satStartTime, java.util.Date satEndTime,
		java.lang.String requestReason)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(requestId);

		Object paramObj2 = ClpSerializer.translateInput(startDate);

		if (startDate == null) {
			paramObj2 = new NullWrapper("java.util.Date");
		}

		Object paramObj3 = ClpSerializer.translateInput(endDate);

		if (endDate == null) {
			paramObj3 = new NullWrapper("java.util.Date");
		}

		Object paramObj4 = ClpSerializer.translateInput(monStartTime);

		if (monStartTime == null) {
			paramObj4 = new NullWrapper("java.util.Date");
		}

		Object paramObj5 = ClpSerializer.translateInput(monEndTime);

		if (monEndTime == null) {
			paramObj5 = new NullWrapper("java.util.Date");
		}

		Object paramObj6 = ClpSerializer.translateInput(tueStartDate);

		if (tueStartDate == null) {
			paramObj6 = new NullWrapper("java.util.Date");
		}

		Object paramObj7 = ClpSerializer.translateInput(tueEndTime);

		if (tueEndTime == null) {
			paramObj7 = new NullWrapper("java.util.Date");
		}

		Object paramObj8 = ClpSerializer.translateInput(wedStartTime);

		if (wedStartTime == null) {
			paramObj8 = new NullWrapper("java.util.Date");
		}

		Object paramObj9 = ClpSerializer.translateInput(wedEndTime);

		if (wedEndTime == null) {
			paramObj9 = new NullWrapper("java.util.Date");
		}

		Object paramObj10 = ClpSerializer.translateInput(thuStartTime);

		if (thuStartTime == null) {
			paramObj10 = new NullWrapper("java.util.Date");
		}

		Object paramObj11 = ClpSerializer.translateInput(thuEndTime);

		if (thuEndTime == null) {
			paramObj11 = new NullWrapper("java.util.Date");
		}

		Object paramObj12 = ClpSerializer.translateInput(friStartTime);

		if (friStartTime == null) {
			paramObj12 = new NullWrapper("java.util.Date");
		}

		Object paramObj13 = ClpSerializer.translateInput(friEndTime);

		if (friEndTime == null) {
			paramObj13 = new NullWrapper("java.util.Date");
		}

		Object paramObj14 = ClpSerializer.translateInput(satStartTime);

		if (satStartTime == null) {
			paramObj14 = new NullWrapper("java.util.Date");
		}

		Object paramObj15 = ClpSerializer.translateInput(satEndTime);

		if (satEndTime == null) {
			paramObj15 = new NullWrapper("java.util.Date");
		}

		Object paramObj16 = ClpSerializer.translateInput(requestReason);

		if (requestReason == null) {
			paramObj16 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("editRequestTimeChange",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
						paramObj10, paramObj11, paramObj12, paramObj13,
						paramObj14, paramObj15, paramObj16
					});
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

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean addRequestTimeChange(int rootId, int userId,
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date monStartTime, java.util.Date monEndTime,
		java.util.Date tueStartTime, java.util.Date tueEndTime,
		java.util.Date wedStartTime, java.util.Date wedEndTime,
		java.util.Date thuStartTime, java.util.Date thuEndTime,
		java.util.Date friStartTime, java.util.Date friEndTime,
		java.util.Date satStartTime, java.util.Date satEndTime,
		java.lang.String requestReason)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = ClpSerializer.translateInput(startDate);

		if (startDate == null) {
			paramObj2 = new NullWrapper("java.util.Date");
		}

		Object paramObj3 = ClpSerializer.translateInput(endDate);

		if (endDate == null) {
			paramObj3 = new NullWrapper("java.util.Date");
		}

		Object paramObj4 = ClpSerializer.translateInput(monStartTime);

		if (monStartTime == null) {
			paramObj4 = new NullWrapper("java.util.Date");
		}

		Object paramObj5 = ClpSerializer.translateInput(monEndTime);

		if (monEndTime == null) {
			paramObj5 = new NullWrapper("java.util.Date");
		}

		Object paramObj6 = ClpSerializer.translateInput(tueStartTime);

		if (tueStartTime == null) {
			paramObj6 = new NullWrapper("java.util.Date");
		}

		Object paramObj7 = ClpSerializer.translateInput(tueEndTime);

		if (tueEndTime == null) {
			paramObj7 = new NullWrapper("java.util.Date");
		}

		Object paramObj8 = ClpSerializer.translateInput(wedStartTime);

		if (wedStartTime == null) {
			paramObj8 = new NullWrapper("java.util.Date");
		}

		Object paramObj9 = ClpSerializer.translateInput(wedEndTime);

		if (wedEndTime == null) {
			paramObj9 = new NullWrapper("java.util.Date");
		}

		Object paramObj10 = ClpSerializer.translateInput(thuStartTime);

		if (thuStartTime == null) {
			paramObj10 = new NullWrapper("java.util.Date");
		}

		Object paramObj11 = ClpSerializer.translateInput(thuEndTime);

		if (thuEndTime == null) {
			paramObj11 = new NullWrapper("java.util.Date");
		}

		Object paramObj12 = ClpSerializer.translateInput(friStartTime);

		if (friStartTime == null) {
			paramObj12 = new NullWrapper("java.util.Date");
		}

		Object paramObj13 = ClpSerializer.translateInput(friEndTime);

		if (friEndTime == null) {
			paramObj13 = new NullWrapper("java.util.Date");
		}

		Object paramObj14 = ClpSerializer.translateInput(satStartTime);

		if (satStartTime == null) {
			paramObj14 = new NullWrapper("java.util.Date");
		}

		Object paramObj15 = ClpSerializer.translateInput(satEndTime);

		if (satEndTime == null) {
			paramObj15 = new NullWrapper("java.util.Date");
		}

		Object paramObj16 = ClpSerializer.translateInput(requestReason);

		if (requestReason == null) {
			paramObj16 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addRequestTimeChange",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
						paramObj10, paramObj11, paramObj12, paramObj13,
						paramObj14, paramObj15, paramObj16
					});
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

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean doApproveIt(int rootId, int approvedBy, int requestId,
		boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(approvedBy);

		Object paramObj2 = new IntegerWrapper(requestId);

		Object paramObj3 = new BooleanWrapper(isApproved);

		Object paramObj4 = ClpSerializer.translateInput(reason);

		if (reason == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("doApproveIt",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
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

		return ((Boolean)returnObj).booleanValue();
	}

	public int deleteChangeTimeReq(int rootId, int userId, int reqId)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(reqId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("deleteChangeTimeReq",
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

		return ((Integer)returnObj).intValue();
	}

	public int countTimeChangeReqs(int rootId, int userId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countTimeChangeReqs",
					new Object[] { paramObj0, paramObj1 });
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

	public java.lang.String getMaxTimeChangeReqEndDate(int rootId, int userId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getMaxTimeChangeReqEndDate",
					new Object[] { paramObj0, paramObj1 });
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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}