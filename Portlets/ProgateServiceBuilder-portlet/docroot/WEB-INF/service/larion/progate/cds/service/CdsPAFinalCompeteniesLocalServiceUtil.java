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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="CdsPAFinalCompeteniesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalCompeteniesLocalServiceUtil {
	public static larion.progate.cds.model.CdsPAFinalCompetenies addCdsPAFinalCompetenies(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies)
		throws com.liferay.portal.SystemException {
		return getService().addCdsPAFinalCompetenies(cdsPAFinalCompetenies);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies createCdsPAFinalCompetenies(
		java.lang.Integer cdsPAFinalCompeteniesId) {
		return getService().createCdsPAFinalCompetenies(cdsPAFinalCompeteniesId);
	}

	public static void deleteCdsPAFinalCompetenies(
		java.lang.Integer cdsPAFinalCompeteniesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsPAFinalCompetenies(cdsPAFinalCompeteniesId);
	}

	public static void deleteCdsPAFinalCompetenies(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsPAFinalCompetenies(cdsPAFinalCompetenies);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies getCdsPAFinalCompetenies(
		java.lang.Integer cdsPAFinalCompeteniesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsPAFinalCompetenies(cdsPAFinalCompeteniesId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> getCdsPAFinalCompetenieses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsPAFinalCompetenieses(start, end);
	}

	public static int getCdsPAFinalCompeteniesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsPAFinalCompeteniesesCount();
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies updateCdsPAFinalCompetenies(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsPAFinalCompetenies(cdsPAFinalCompetenies);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies updateCdsPAFinalCompetenies(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsPAFinalCompetenies(cdsPAFinalCompetenies, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsPAFinalCompeteniesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsPAFinalCompeteniesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsPAFinalCompeteniesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsPAFinalCompeteniesLocalService service) {
		_service = service;
	}

	private static CdsPAFinalCompeteniesLocalService _service;
}