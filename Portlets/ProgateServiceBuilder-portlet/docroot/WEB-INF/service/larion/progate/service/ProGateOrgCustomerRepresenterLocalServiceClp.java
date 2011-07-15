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
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="ProGateOrgCustomerRepresenterLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerRepresenterLocalServiceClp
	implements ProGateOrgCustomerRepresenterLocalService {
	public ProGateOrgCustomerRepresenterLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.model.ProGateOrgCustomerRepresenter addProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateOrgCustomerRepresenter);

		if (proGateOrgCustomerRepresenter == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateOrgCustomerRepresenter");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addProGateOrgCustomerRepresenter",
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

		return (larion.progate.model.ProGateOrgCustomerRepresenter)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateOrgCustomerRepresenter createProGateOrgCustomerRepresenter(
		java.lang.Integer ProGateOrgCustomerRepresenterId) {
		Object paramObj0 = ClpSerializer.translateInput(ProGateOrgCustomerRepresenterId);

		if (ProGateOrgCustomerRepresenterId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createProGateOrgCustomerRepresenter",
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

		return (larion.progate.model.ProGateOrgCustomerRepresenter)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteProGateOrgCustomerRepresenter(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(ProGateOrgCustomerRepresenterId);

		if (ProGateOrgCustomerRepresenterId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteProGateOrgCustomerRepresenter",
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

	public void deleteProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateOrgCustomerRepresenter);

		if (proGateOrgCustomerRepresenter == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateOrgCustomerRepresenter");
		}

		try {
			_classLoaderProxy.invoke("deleteProGateOrgCustomerRepresenter",
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

	public larion.progate.model.ProGateOrgCustomerRepresenter getProGateOrgCustomerRepresenter(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(ProGateOrgCustomerRepresenterId);

		if (ProGateOrgCustomerRepresenterId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateOrgCustomerRepresenter",
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

		return (larion.progate.model.ProGateOrgCustomerRepresenter)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateOrgCustomerRepresenters",
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

		return (java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter>)ClpSerializer.translateOutput(returnObj);
	}

	public int getProGateOrgCustomerRepresentersCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getProGateOrgCustomerRepresentersCount",
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

	public larion.progate.model.ProGateOrgCustomerRepresenter updateProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateOrgCustomerRepresenter);

		if (proGateOrgCustomerRepresenter == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateOrgCustomerRepresenter");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateOrgCustomerRepresenter",
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

		return (larion.progate.model.ProGateOrgCustomerRepresenter)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateOrgCustomerRepresenter updateProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(proGateOrgCustomerRepresenter);

		if (proGateOrgCustomerRepresenter == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.model.ProGateOrgCustomerRepresenter");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateProGateOrgCustomerRepresenter",
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

		return (larion.progate.model.ProGateOrgCustomerRepresenter)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.model.ProGateOrgCustomerRepresenter createCustRepresenter(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String role, java.lang.String description, int customerId,
		int orgId) {
		Object paramObj0 = ClpSerializer.translateInput(firstName);

		if (firstName == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = ClpSerializer.translateInput(lastName);

		if (lastName == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = ClpSerializer.translateInput(role);

		if (role == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = ClpSerializer.translateInput(description);

		if (description == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = new IntegerWrapper(customerId);

		Object paramObj5 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createCustRepresenter",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
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

		return (larion.progate.model.ProGateOrgCustomerRepresenter)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getListCustRepresenterByOrgId(
		int orgId, int start, int end, boolean hasDescription) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new IntegerWrapper(start);

		Object paramObj2 = new IntegerWrapper(end);

		Object paramObj3 = new BooleanWrapper(hasDescription);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListCustRepresenterByOrgId",
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

		return (java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getListCustRepresenterByCustId(
		int custId, int start, int end, boolean hasDescription) {
		Object paramObj0 = new IntegerWrapper(custId);

		Object paramObj1 = new IntegerWrapper(start);

		Object paramObj2 = new IntegerWrapper(end);

		Object paramObj3 = new BooleanWrapper(hasDescription);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListCustRepresenterByCustId",
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

		return (java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter>)ClpSerializer.translateOutput(returnObj);
	}

	public int cListCustRepresenterByCustId(int custId, boolean hasDescription) {
		Object paramObj0 = new IntegerWrapper(custId);

		Object paramObj1 = new BooleanWrapper(hasDescription);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("cListCustRepresenterByCustId",
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

	public int countListCustRepresenterByOrgId(int orgId, boolean hasDescription) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object paramObj1 = new BooleanWrapper(hasDescription);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countListCustRepresenterByOrgId",
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

	public int countListCustRepresenterByCustId(int customerId) {
		Object paramObj0 = new IntegerWrapper(customerId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("countListCustRepresenterByCustId",
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

		return ((Integer)returnObj).intValue();
	}

	private ClassLoaderProxy _classLoaderProxy;
}