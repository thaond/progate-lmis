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
 * <a href="ViewPerformanceAppraisalSlotsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewPerformanceAppraisalSlotsLocalServiceClp
	implements ViewPerformanceAppraisalSlotsLocalService {
	public ViewPerformanceAppraisalSlotsLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.cds.model.ViewPerformanceAppraisalSlots addViewPerformanceAppraisalSlots(
		larion.progate.cds.model.ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewPerformanceAppraisalSlots);

		if (viewPerformanceAppraisalSlots == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.ViewPerformanceAppraisalSlots");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addViewPerformanceAppraisalSlots",
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

		return (larion.progate.cds.model.ViewPerformanceAppraisalSlots)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.ViewPerformanceAppraisalSlots createViewPerformanceAppraisalSlots(
		java.lang.String id) {
		Object paramObj0 = ClpSerializer.translateInput(id);

		if (id == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createViewPerformanceAppraisalSlots",
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

		return (larion.progate.cds.model.ViewPerformanceAppraisalSlots)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteViewPerformanceAppraisalSlots(java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(id);

		if (id == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		try {
			_classLoaderProxy.invoke("deleteViewPerformanceAppraisalSlots",
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

	public void deleteViewPerformanceAppraisalSlots(
		larion.progate.cds.model.ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewPerformanceAppraisalSlots);

		if (viewPerformanceAppraisalSlots == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.ViewPerformanceAppraisalSlots");
		}

		try {
			_classLoaderProxy.invoke("deleteViewPerformanceAppraisalSlots",
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

	public larion.progate.cds.model.ViewPerformanceAppraisalSlots getViewPerformanceAppraisalSlots(
		java.lang.String id)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(id);

		if (id == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getViewPerformanceAppraisalSlots",
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

		return (larion.progate.cds.model.ViewPerformanceAppraisalSlots)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewPerformanceAppraisalSlots> getViewPerformanceAppraisalSlotses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getViewPerformanceAppraisalSlotses",
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

		return (java.util.List<larion.progate.cds.model.ViewPerformanceAppraisalSlots>)ClpSerializer.translateOutput(returnObj);
	}

	public int getViewPerformanceAppraisalSlotsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getViewPerformanceAppraisalSlotsesCount",
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

	public larion.progate.cds.model.ViewPerformanceAppraisalSlots updateViewPerformanceAppraisalSlots(
		larion.progate.cds.model.ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewPerformanceAppraisalSlots);

		if (viewPerformanceAppraisalSlots == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.ViewPerformanceAppraisalSlots");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateViewPerformanceAppraisalSlots",
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

		return (larion.progate.cds.model.ViewPerformanceAppraisalSlots)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.ViewPerformanceAppraisalSlots updateViewPerformanceAppraisalSlots(
		larion.progate.cds.model.ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(viewPerformanceAppraisalSlots);

		if (viewPerformanceAppraisalSlots == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.ViewPerformanceAppraisalSlots");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateViewPerformanceAppraisalSlots",
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

		return (larion.progate.cds.model.ViewPerformanceAppraisalSlots)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.ViewPerformanceAppraisalSlots> getCdsPASlots(
		int userId, int periodId, int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(periodId);

		Object paramObj2 = new IntegerWrapper(levelId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPASlots",
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

		return (java.util.List<larion.progate.cds.model.ViewPerformanceAppraisalSlots>)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.ViewPerformanceAppraisalSlots getPASlotDetail(
		int userId, int periodId, int slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(periodId);

		Object paramObj2 = new IntegerWrapper(slotId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getPASlotDetail",
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

		return (larion.progate.cds.model.ViewPerformanceAppraisalSlots)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}