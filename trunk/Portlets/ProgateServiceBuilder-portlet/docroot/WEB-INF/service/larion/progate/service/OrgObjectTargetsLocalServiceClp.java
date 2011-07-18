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
import com.liferay.portal.kernel.util.DoubleWrapper;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="OrgObjectTargetsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectTargetsLocalServiceClp
	implements OrgObjectTargetsLocalService {
	public OrgObjectTargetsLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.model.OrgObjectTargets addOrgObjectTargets(
		larion.progate.model.OrgObjectTargets orgObjectTargets)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(orgObjectTargets);

		if (orgObjectTargets == null) {
			paramObj0 = new NullWrapper("larion.progate.model.OrgObjectTargets");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addOrgObjectTargets",
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

		return (larion.progate.model.OrgObjectTargets)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.OrgObjectTargets createOrgObjectTargets(
		java.lang.Integer orgObjectTargetId) {
		Object paramObj0 = ClpSerializer.translateInput(orgObjectTargetId);

		if (orgObjectTargetId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createOrgObjectTargets",
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

		return (larion.progate.model.OrgObjectTargets)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteOrgObjectTargets(java.lang.Integer orgObjectTargetId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(orgObjectTargetId);

		if (orgObjectTargetId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteOrgObjectTargets",
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

	public void deleteOrgObjectTargets(
		larion.progate.model.OrgObjectTargets orgObjectTargets)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(orgObjectTargets);

		if (orgObjectTargets == null) {
			paramObj0 = new NullWrapper("larion.progate.model.OrgObjectTargets");
		}

		try {
			_classLoaderProxy.invoke("deleteOrgObjectTargets",
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

	public larion.progate.model.OrgObjectTargets getOrgObjectTargets(
		java.lang.Integer orgObjectTargetId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(orgObjectTargetId);

		if (orgObjectTargetId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getOrgObjectTargets",
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

		return (larion.progate.model.OrgObjectTargets)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.OrgObjectTargets> getOrgObjectTargetses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getOrgObjectTargetses",
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

		return (java.util.List<larion.progate.model.OrgObjectTargets>)ClpSerializer.translateOutput(returnObj);
	}

	public int getOrgObjectTargetsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getOrgObjectTargetsesCount",
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

	public larion.progate.model.OrgObjectTargets updateOrgObjectTargets(
		larion.progate.model.OrgObjectTargets orgObjectTargets)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(orgObjectTargets);

		if (orgObjectTargets == null) {
			paramObj0 = new NullWrapper("larion.progate.model.OrgObjectTargets");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateOrgObjectTargets",
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

		return (larion.progate.model.OrgObjectTargets)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.OrgObjectTargets updateOrgObjectTargets(
		larion.progate.model.OrgObjectTargets orgObjectTargets, boolean merge)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(orgObjectTargets);

		if (orgObjectTargets == null) {
			paramObj0 = new NullWrapper("larion.progate.model.OrgObjectTargets");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateOrgObjectTargets",
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

		return (larion.progate.model.OrgObjectTargets)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.OrgObjectTargets> getListMsrTars(
		int msrId) {
		Object paramObj0 = new IntegerWrapper(msrId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListMsrTars",
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

		return (java.util.List<larion.progate.model.OrgObjectTargets>)ClpSerializer.translateOutput(returnObj);
	}

	public boolean editMsrTar(
		larion.progate.model.OrgObjectTargets orgObjectTargets) {
		Object paramObj0 = ClpSerializer.translateInput(orgObjectTargets);

		if (orgObjectTargets == null) {
			paramObj0 = new NullWrapper("larion.progate.model.OrgObjectTargets");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("editMsrTar",
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

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean createMsrTar(int msrId, java.lang.String name,
		double tarValue, java.lang.String description) {
		Object paramObj0 = new IntegerWrapper(msrId);

		Object paramObj1 = ClpSerializer.translateInput(name);

		if (name == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new DoubleWrapper(tarValue);

		Object paramObj3 = ClpSerializer.translateInput(description);

		if (description == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createMsrTar",
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

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean deleteMsrTar(int tarId) {
		Object paramObj0 = new IntegerWrapper(tarId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("deleteMsrTar",
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

		return ((Boolean)returnObj).booleanValue();
	}

	public boolean createMsrTar(int arg0, java.lang.String arg1, int arg2,
		java.lang.String arg3) {
		Object paramObj0 = new IntegerWrapper(arg0);

		Object paramObj1 = ClpSerializer.translateInput(arg1);

		if (arg1 == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = new IntegerWrapper(arg2);

		Object paramObj3 = ClpSerializer.translateInput(arg3);

		if (arg3 == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createMsrTar",
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

		return ((Boolean)returnObj).booleanValue();
	}

	private ClassLoaderProxy _classLoaderProxy;
}