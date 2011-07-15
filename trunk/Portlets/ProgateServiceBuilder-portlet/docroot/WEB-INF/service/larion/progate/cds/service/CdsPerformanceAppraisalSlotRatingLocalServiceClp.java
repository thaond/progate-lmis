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
 * <a href="CdsPerformanceAppraisalSlotRatingLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPerformanceAppraisalSlotRatingLocalServiceClp
	implements CdsPerformanceAppraisalSlotRatingLocalService {
	public CdsPerformanceAppraisalSlotRatingLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.cds.model.CdsPerformanceAppraisalSlotRating addCdsPerformanceAppraisalSlotRating(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPerformanceAppraisalSlotRating);

		if (cdsPerformanceAppraisalSlotRating == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.CdsPerformanceAppraisalSlotRating");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addCdsPerformanceAppraisalSlotRating",
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

		return (larion.progate.cds.model.CdsPerformanceAppraisalSlotRating)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.CdsPerformanceAppraisalSlotRating createCdsPerformanceAppraisalSlotRating(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId) {
		Object paramObj0 = ClpSerializer.translateInput(CdsPerformanceAppraisalSlotRatingId);

		if (CdsPerformanceAppraisalSlotRatingId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createCdsPerformanceAppraisalSlotRating",
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

		return (larion.progate.cds.model.CdsPerformanceAppraisalSlotRating)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteCdsPerformanceAppraisalSlotRating(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(CdsPerformanceAppraisalSlotRatingId);

		if (CdsPerformanceAppraisalSlotRatingId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteCdsPerformanceAppraisalSlotRating",
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

	public void deleteCdsPerformanceAppraisalSlotRating(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPerformanceAppraisalSlotRating);

		if (cdsPerformanceAppraisalSlotRating == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.CdsPerformanceAppraisalSlotRating");
		}

		try {
			_classLoaderProxy.invoke("deleteCdsPerformanceAppraisalSlotRating",
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

	public larion.progate.cds.model.CdsPerformanceAppraisalSlotRating getCdsPerformanceAppraisalSlotRating(
		java.lang.Integer CdsPerformanceAppraisalSlotRatingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(CdsPerformanceAppraisalSlotRatingId);

		if (CdsPerformanceAppraisalSlotRatingId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPerformanceAppraisalSlotRating",
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

		return (larion.progate.cds.model.CdsPerformanceAppraisalSlotRating)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> getCdsPerformanceAppraisalSlotRatings(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPerformanceAppraisalSlotRatings",
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

		return (java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCdsPerformanceAppraisalSlotRatingsCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPerformanceAppraisalSlotRatingsCount",
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

	public larion.progate.cds.model.CdsPerformanceAppraisalSlotRating updateCdsPerformanceAppraisalSlotRating(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPerformanceAppraisalSlotRating);

		if (cdsPerformanceAppraisalSlotRating == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.CdsPerformanceAppraisalSlotRating");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCdsPerformanceAppraisalSlotRating",
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

		return (larion.progate.cds.model.CdsPerformanceAppraisalSlotRating)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.CdsPerformanceAppraisalSlotRating updateCdsPerformanceAppraisalSlotRating(
		larion.progate.cds.model.CdsPerformanceAppraisalSlotRating cdsPerformanceAppraisalSlotRating,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPerformanceAppraisalSlotRating);

		if (cdsPerformanceAppraisalSlotRating == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.CdsPerformanceAppraisalSlotRating");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCdsPerformanceAppraisalSlotRating",
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

		return (larion.progate.cds.model.CdsPerformanceAppraisalSlotRating)ClpSerializer.translateOutput(returnObj);
	}

	public boolean addPASlotRating(int rootId, int periodId, int userId,
		int slotId, int ratingBy, boolean ratingStatus, int userType,
		java.lang.String pointName, int pointValue)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(periodId);

		Object paramObj2 = new IntegerWrapper(userId);

		Object paramObj3 = new IntegerWrapper(slotId);

		Object paramObj4 = new IntegerWrapper(ratingBy);

		Object paramObj5 = new BooleanWrapper(ratingStatus);

		Object paramObj6 = new IntegerWrapper(userType);

		Object paramObj7 = ClpSerializer.translateInput(pointName);

		if (pointName == null) {
			paramObj7 = new NullWrapper("java.lang.String");
		}

		Object paramObj8 = new IntegerWrapper(pointValue);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addPASlotRating",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8
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

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean addPASlotRatingByBOD(int[] userId, int periodId,
		int ratingByBOD, int userTypeBOD)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(userId);

		if (userId == null) {
			paramObj0 = new NullWrapper("[I");
		}

		Object paramObj1 = new IntegerWrapper(periodId);

		Object paramObj2 = new IntegerWrapper(ratingByBOD);

		Object paramObj3 = new IntegerWrapper(userTypeBOD);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addPASlotRatingByBOD",
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

		return ((Boolean)returnObj).booleanValue();
	}

	public java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating> getSlotRatingHistory(
		int rootId, int userId, int slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(slotId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getSlotRatingHistory",
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

		return (java.util.List<larion.progate.cds.model.CdsPerformanceAppraisalSlotRating>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLastRatingPointByUserType(int periodId, int userId,
		int slotId, int userType)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(periodId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(slotId);

		Object paramObj3 = new IntegerWrapper(userType);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLastRatingPointByUserType",
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

		return ((Integer)returnObj).intValue();
	}

	private ClassLoaderProxy _classLoaderProxy;
}