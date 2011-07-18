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
 * <a href="LmisEmailSettingDetailsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingDetailsLocalServiceClp
	implements LmisEmailSettingDetailsLocalService {
	public LmisEmailSettingDetailsLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.lmis.model.LmisEmailSettingDetails addLmisEmailSettingDetails(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisEmailSettingDetails);

		if (lmisEmailSettingDetails == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisEmailSettingDetails");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addLmisEmailSettingDetails",
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

		return (larion.progate.lmis.model.LmisEmailSettingDetails)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisEmailSettingDetails createLmisEmailSettingDetails(
		java.lang.Integer lmisEmailSettingDetailId) {
		Object paramObj0 = ClpSerializer.translateInput(lmisEmailSettingDetailId);

		if (lmisEmailSettingDetailId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createLmisEmailSettingDetails",
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

		return (larion.progate.lmis.model.LmisEmailSettingDetails)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLmisEmailSettingDetails(
		java.lang.Integer lmisEmailSettingDetailId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisEmailSettingDetailId);

		if (lmisEmailSettingDetailId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisEmailSettingDetails",
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

	public void deleteLmisEmailSettingDetails(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisEmailSettingDetails);

		if (lmisEmailSettingDetails == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisEmailSettingDetails");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisEmailSettingDetails",
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

	public larion.progate.lmis.model.LmisEmailSettingDetails getLmisEmailSettingDetails(
		java.lang.Integer lmisEmailSettingDetailId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisEmailSettingDetailId);

		if (lmisEmailSettingDetailId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisEmailSettingDetails",
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

		return (larion.progate.lmis.model.LmisEmailSettingDetails)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisEmailSettingDetailses",
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

		return (java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLmisEmailSettingDetailsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisEmailSettingDetailsesCount",
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

	public larion.progate.lmis.model.LmisEmailSettingDetails updateLmisEmailSettingDetails(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisEmailSettingDetails);

		if (lmisEmailSettingDetails == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisEmailSettingDetails");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisEmailSettingDetails",
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

		return (larion.progate.lmis.model.LmisEmailSettingDetails)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisEmailSettingDetails updateLmisEmailSettingDetails(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisEmailSettingDetails);

		if (lmisEmailSettingDetails == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisEmailSettingDetails");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisEmailSettingDetails",
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

		return (larion.progate.lmis.model.LmisEmailSettingDetails)ClpSerializer.translateOutput(returnObj);
	}

	public boolean updateEmailSettingDetail(int rootId, int emailId,
		java.util.ArrayList<Integer> orgid, java.util.ArrayList<Integer> userid) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(emailId);

		Object paramObj2 = ClpSerializer.translateInput(orgid);

		if (orgid == null) {
			paramObj2 = new NullWrapper("java.util.ArrayList");
		}

		Object paramObj3 = ClpSerializer.translateInput(userid);

		if (userid == null) {
			paramObj3 = new NullWrapper("java.util.ArrayList");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateEmailSettingDetail",
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