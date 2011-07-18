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
 * <a href="CdsPAFinalCompeteniesLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalCompeteniesLocalServiceClp
	implements CdsPAFinalCompeteniesLocalService {
	public CdsPAFinalCompeteniesLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.cds.model.CdsPAFinalCompetenies addCdsPAFinalCompetenies(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPAFinalCompetenies);

		if (cdsPAFinalCompetenies == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.CdsPAFinalCompetenies");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addCdsPAFinalCompetenies",
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

		return (larion.progate.cds.model.CdsPAFinalCompetenies)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.CdsPAFinalCompetenies createCdsPAFinalCompetenies(
		java.lang.Integer cdsPAFinalCompeteniesId) {
		Object paramObj0 = ClpSerializer.translateInput(cdsPAFinalCompeteniesId);

		if (cdsPAFinalCompeteniesId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createCdsPAFinalCompetenies",
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

		return (larion.progate.cds.model.CdsPAFinalCompetenies)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteCdsPAFinalCompetenies(
		java.lang.Integer cdsPAFinalCompeteniesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPAFinalCompeteniesId);

		if (cdsPAFinalCompeteniesId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteCdsPAFinalCompetenies",
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

	public void deleteCdsPAFinalCompetenies(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPAFinalCompetenies);

		if (cdsPAFinalCompetenies == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.CdsPAFinalCompetenies");
		}

		try {
			_classLoaderProxy.invoke("deleteCdsPAFinalCompetenies",
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

	public larion.progate.cds.model.CdsPAFinalCompetenies getCdsPAFinalCompetenies(
		java.lang.Integer cdsPAFinalCompeteniesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPAFinalCompeteniesId);

		if (cdsPAFinalCompeteniesId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPAFinalCompetenies",
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

		return (larion.progate.cds.model.CdsPAFinalCompetenies)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> getCdsPAFinalCompetenieses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPAFinalCompetenieses",
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

		return (java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCdsPAFinalCompeteniesesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCdsPAFinalCompeteniesesCount",
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

	public larion.progate.cds.model.CdsPAFinalCompetenies updateCdsPAFinalCompetenies(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPAFinalCompetenies);

		if (cdsPAFinalCompetenies == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.CdsPAFinalCompetenies");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCdsPAFinalCompetenies",
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

		return (larion.progate.cds.model.CdsPAFinalCompetenies)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.cds.model.CdsPAFinalCompetenies updateCdsPAFinalCompetenies(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(cdsPAFinalCompetenies);

		if (cdsPAFinalCompetenies == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.cds.model.CdsPAFinalCompetenies");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCdsPAFinalCompetenies",
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

		return (larion.progate.cds.model.CdsPAFinalCompetenies)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}