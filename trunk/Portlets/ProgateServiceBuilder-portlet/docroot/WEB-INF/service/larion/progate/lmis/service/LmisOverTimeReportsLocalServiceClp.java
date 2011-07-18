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
 * <a href="LmisOverTimeReportsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportsLocalServiceClp
	implements LmisOverTimeReportsLocalService {
	public LmisOverTimeReportsLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.lmis.model.LmisOverTimeReports addLmisOverTimeReports(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOverTimeReports);

		if (lmisOverTimeReports == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOverTimeReports");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addLmisOverTimeReports",
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

		return (larion.progate.lmis.model.LmisOverTimeReports)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisOverTimeReports createLmisOverTimeReports(
		java.lang.Integer lmisOverTimeReportsId) {
		Object paramObj0 = ClpSerializer.translateInput(lmisOverTimeReportsId);

		if (lmisOverTimeReportsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createLmisOverTimeReports",
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

		return (larion.progate.lmis.model.LmisOverTimeReports)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLmisOverTimeReports(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOverTimeReportsId);

		if (lmisOverTimeReportsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisOverTimeReports",
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

	public void deleteLmisOverTimeReports(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOverTimeReports);

		if (lmisOverTimeReports == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOverTimeReports");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisOverTimeReports",
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

	public larion.progate.lmis.model.LmisOverTimeReports getLmisOverTimeReports(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOverTimeReportsId);

		if (lmisOverTimeReportsId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisOverTimeReports",
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

		return (larion.progate.lmis.model.LmisOverTimeReports)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisOverTimeReportses",
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

		return (java.util.List<larion.progate.lmis.model.LmisOverTimeReports>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLmisOverTimeReportsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisOverTimeReportsesCount",
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

	public larion.progate.lmis.model.LmisOverTimeReports updateLmisOverTimeReports(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOverTimeReports);

		if (lmisOverTimeReports == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOverTimeReports");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisOverTimeReports",
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

		return (larion.progate.lmis.model.LmisOverTimeReports)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisOverTimeReports updateLmisOverTimeReports(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisOverTimeReports);

		if (lmisOverTimeReports == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisOverTimeReports");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisOverTimeReports",
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

		return (larion.progate.lmis.model.LmisOverTimeReports)ClpSerializer.translateOutput(returnObj);
	}

	public int addOtReport(int reportId, int rootId, int orgId, int userId,
		java.lang.String otReason, java.util.Date regDate,
		java.util.Date repDate, int[] arrUID, double[] arrTotal,
		java.util.List arrHM, java.util.List arrEndTime) {
		Object paramObj0 = new IntegerWrapper(reportId);

		Object paramObj1 = new IntegerWrapper(rootId);

		Object paramObj2 = new IntegerWrapper(orgId);

		Object paramObj3 = new IntegerWrapper(userId);

		Object paramObj4 = ClpSerializer.translateInput(otReason);

		if (otReason == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object paramObj5 = ClpSerializer.translateInput(regDate);

		if (regDate == null) {
			paramObj5 = new NullWrapper("java.util.Date");
		}

		Object paramObj6 = ClpSerializer.translateInput(repDate);

		if (repDate == null) {
			paramObj6 = new NullWrapper("java.util.Date");
		}

		Object paramObj7 = ClpSerializer.translateInput(arrUID);

		if (arrUID == null) {
			paramObj7 = new NullWrapper("[I");
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
			returnObj = _classLoaderProxy.invoke("addOtReport",
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

	public int editOtReport(int rootId, int reportId,
		java.lang.String otReason, java.util.Date repDate, int[] arrUID,
		double[] arrTotal, java.util.List arrHM, java.util.List arrEndTime) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(reportId);

		Object paramObj2 = ClpSerializer.translateInput(otReason);

		if (otReason == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = ClpSerializer.translateInput(repDate);

		if (repDate == null) {
			paramObj3 = new NullWrapper("java.util.Date");
		}

		Object paramObj4 = ClpSerializer.translateInput(arrUID);

		if (arrUID == null) {
			paramObj4 = new NullWrapper("[I");
		}

		Object paramObj5 = ClpSerializer.translateInput(arrTotal);

		if (arrTotal == null) {
			paramObj5 = new NullWrapper("[D");
		}

		Object paramObj6 = ClpSerializer.translateInput(arrHM);

		if (arrHM == null) {
			paramObj6 = new NullWrapper("java.util.List");
		}

		Object paramObj7 = ClpSerializer.translateInput(arrEndTime);

		if (arrEndTime == null) {
			paramObj7 = new NullWrapper("java.util.List");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("editOtReport",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7
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

	private ClassLoaderProxy _classLoaderProxy;
}