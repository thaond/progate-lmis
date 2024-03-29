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
 * <a href="CdsPointsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPointsLocalServiceClp implements CdsPointsLocalService {
	public CdsPointsLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.cds.model.CdsPoints addCdsPoints(
		larion.progate.cds.model.CdsPoints cdsPoints)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPoints);

		if (cdsPoints == null) {
			paramObj0 = new NullWrapper("larion.progate.cds.model.CdsPoints");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addCdsPoints",
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

		return (larion.progate.cds.model.CdsPoints)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.CdsPoints createCdsPoints(
		java.lang.Integer pointId) {
		Object paramObj0 = ClpSerializer.translateInput(pointId);

		if (pointId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createCdsPoints",
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

		return (larion.progate.cds.model.CdsPoints)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteCdsPoints(java.lang.Integer pointId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(pointId);

		if (pointId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteCdsPoints",
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

	public void deleteCdsPoints(larion.progate.cds.model.CdsPoints cdsPoints)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPoints);

		if (cdsPoints == null) {
			paramObj0 = new NullWrapper("larion.progate.cds.model.CdsPoints");
		}

		try {
			_classLoaderProxy.invoke("deleteCdsPoints",
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

	public larion.progate.cds.model.CdsPoints getCdsPoints(
		java.lang.Integer pointId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(pointId);

		if (pointId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPoints",
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

		return (larion.progate.cds.model.CdsPoints)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.CdsPoints> getCdsPointses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPointses",
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

		return (java.util.List<larion.progate.cds.model.CdsPoints>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCdsPointsesCount() throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPointsesCount",
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

	public larion.progate.cds.model.CdsPoints updateCdsPoints(
		larion.progate.cds.model.CdsPoints cdsPoints)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPoints);

		if (cdsPoints == null) {
			paramObj0 = new NullWrapper("larion.progate.cds.model.CdsPoints");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCdsPoints",
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

		return (larion.progate.cds.model.CdsPoints)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.CdsPoints updateCdsPoints(
		larion.progate.cds.model.CdsPoints cdsPoints, boolean merge)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPoints);

		if (cdsPoints == null) {
			paramObj0 = new NullWrapper("larion.progate.cds.model.CdsPoints");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCdsPoints",
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

		return (larion.progate.cds.model.CdsPoints)ClpSerializer.translateOutput(returnObj);
	}

	public boolean addCdsPoint(int rootId, java.lang.String name, int value,
		java.lang.String des, int createBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = ClpSerializer.translateInput(name);

		if (name == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new IntegerWrapper(value);

		Object paramObj3 = ClpSerializer.translateInput(des);

		if (des == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = new IntegerWrapper(createBy);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addCdsPoint",
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

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean updateCdsPoint(int pointId, int rootId,
		java.lang.String name, int value, java.lang.String des, int updateBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(pointId);

		Object paramObj1 = new IntegerWrapper(rootId);

		Object paramObj2 = ClpSerializer.translateInput(name);

		if (name == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(value);

		Object paramObj4 = ClpSerializer.translateInput(des);

		if (des == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object paramObj5 = new IntegerWrapper(updateBy);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCdsPoint",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
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

	public java.util.List<larion.progate.cds.model.CdsPoints> getCdsPointListByRootId(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPointListByRootId",
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

		return (java.util.List<larion.progate.cds.model.CdsPoints>)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.CdsPoints getCdsPointMax(int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPointMax",
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

		return (larion.progate.cds.model.CdsPoints)ClpSerializer.translateOutput(returnObj);
	}

	public int getPointValueByPointName(java.lang.String pointName)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(pointName);

		if (pointName == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getPointValueByPointName",
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

		return ((Integer)returnObj).intValue();
	}

	private ClassLoaderProxy _classLoaderProxy;
}