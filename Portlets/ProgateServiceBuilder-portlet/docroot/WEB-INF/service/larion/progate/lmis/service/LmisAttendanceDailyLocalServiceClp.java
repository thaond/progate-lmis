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
 * <a href="LmisAttendanceDailyLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttendanceDailyLocalServiceClp
	implements LmisAttendanceDailyLocalService {
	public LmisAttendanceDailyLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.lmis.model.LmisAttendanceDaily addLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisAttendanceDaily);

		if (lmisAttendanceDaily == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisAttendanceDaily");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addLmisAttendanceDaily",
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

		return (larion.progate.lmis.model.LmisAttendanceDaily)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisAttendanceDaily createLmisAttendanceDaily(
		java.lang.Integer lmisAttendanceDailyId) {
		Object paramObj0 = ClpSerializer.translateInput(lmisAttendanceDailyId);

		if (lmisAttendanceDailyId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createLmisAttendanceDaily",
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

		return (larion.progate.lmis.model.LmisAttendanceDaily)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLmisAttendanceDaily(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisAttendanceDailyId);

		if (lmisAttendanceDailyId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisAttendanceDaily",
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

	public void deleteLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisAttendanceDaily);

		if (lmisAttendanceDaily == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisAttendanceDaily");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisAttendanceDaily",
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

	public larion.progate.lmis.model.LmisAttendanceDaily getLmisAttendanceDaily(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisAttendanceDailyId);

		if (lmisAttendanceDailyId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisAttendanceDaily",
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

		return (larion.progate.lmis.model.LmisAttendanceDaily)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisAttendanceDailies",
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

		return (java.util.List<larion.progate.lmis.model.LmisAttendanceDaily>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLmisAttendanceDailiesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisAttendanceDailiesCount",
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

	public larion.progate.lmis.model.LmisAttendanceDaily updateLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisAttendanceDaily);

		if (lmisAttendanceDaily == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisAttendanceDaily");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisAttendanceDaily",
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

		return (larion.progate.lmis.model.LmisAttendanceDaily)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisAttendanceDaily updateLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisAttendanceDaily);

		if (lmisAttendanceDaily == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisAttendanceDaily");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisAttendanceDaily",
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

		return (larion.progate.lmis.model.LmisAttendanceDaily)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.Date getStartTimeToday(int userId,
		java.util.Date dayValue, int rootId)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = ClpSerializer.translateInput(dayValue);

		if (dayValue == null) {
			paramObj1 = new NullWrapper("java.util.Date");
		}

		Object paramObj2 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getStartTimeToday",
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

		return (java.util.Date)ClpSerializer.translateOutput(returnObj);
	}

	public long getStartTimeLateToday(int userId, java.util.Date dayValue,
		int rootId) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = ClpSerializer.translateInput(dayValue);

		if (dayValue == null) {
			paramObj1 = new NullWrapper("java.util.Date");
		}

		Object paramObj2 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getStartTimeLateToday",
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

		return ((Long)returnObj).longValue();
	}

	public java.util.Date getEndTimeYesterday(int userId,
		java.util.Date dayValue, int rootId)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = ClpSerializer.translateInput(dayValue);

		if (dayValue == null) {
			paramObj1 = new NullWrapper("java.util.Date");
		}

		Object paramObj2 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEndTimeYesterday",
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

		return (java.util.Date)ClpSerializer.translateOutput(returnObj);
	}

	public long getEndTimeEarlyYesterDay(int userId, java.util.Date dayValue,
		int rootId) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = ClpSerializer.translateInput(dayValue);

		if (dayValue == null) {
			paramObj1 = new NullWrapper("java.util.Date");
		}

		Object paramObj2 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEndTimeEarlyYesterDay",
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

		return ((Long)returnObj).longValue();
	}

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getListDetailsDayOff(
		int rootId, int userId, java.util.Date cur) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = ClpSerializer.translateInput(cur);

		if (cur == null) {
			paramObj2 = new NullWrapper("java.util.Date");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListDetailsDayOff",
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

		return (java.util.List<larion.progate.lmis.model.LmisAttendanceDaily>)ClpSerializer.translateOutput(returnObj);
	}

	public double caculateTotalDayOffDontHavePermission_(int userId, int rootId)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("caculateTotalDayOffDontHavePermission_",
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

		return ((Double)returnObj).doubleValue();
	}

	public double caculateTotalDayOffHavePermission_(int userId, int rootId)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("caculateTotalDayOffHavePermission_",
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

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalDayOffInMonth_(int userId, int rootId)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalDayOffInMonth_",
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

		return ((Double)returnObj).doubleValue();
	}

	private ClassLoaderProxy _classLoaderProxy;
}