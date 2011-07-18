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
 * <a href="CdsPACompetenciesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPACompetenciesLocalServiceUtil {
	public static larion.progate.cds.model.CdsPACompetencies addCdsPACompetencies(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies)
		throws com.liferay.portal.SystemException {
		return getService().addCdsPACompetencies(cdsPACompetencies);
	}

	public static larion.progate.cds.model.CdsPACompetencies createCdsPACompetencies(
		java.lang.Integer CdsPACompetenciesId) {
		return getService().createCdsPACompetencies(CdsPACompetenciesId);
	}

	public static void deleteCdsPACompetencies(
		java.lang.Integer CdsPACompetenciesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsPACompetencies(CdsPACompetenciesId);
	}

	public static void deleteCdsPACompetencies(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsPACompetencies(cdsPACompetencies);
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

	public static larion.progate.cds.model.CdsPACompetencies getCdsPACompetencies(
		java.lang.Integer CdsPACompetenciesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsPACompetencies(CdsPACompetenciesId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPACompetencies> getCdsPACompetencieses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsPACompetencieses(start, end);
	}

	public static int getCdsPACompetenciesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsPACompetenciesesCount();
	}

	public static larion.progate.cds.model.CdsPACompetencies updateCdsPACompetencies(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsPACompetencies(cdsPACompetencies);
	}

	public static larion.progate.cds.model.CdsPACompetencies updateCdsPACompetencies(
		larion.progate.cds.model.CdsPACompetencies cdsPACompetencies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateCdsPACompetencies(cdsPACompetencies, merge);
	}

	public static java.util.List<larion.progate.cds.model.CdsPACompetencies> getCdsPACompetencies(
		int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsPACompetencies(userId, periodId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsPACompetenciesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsPACompetenciesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsPACompetenciesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsPACompetenciesLocalService service) {
		_service = service;
	}

	private static CdsPACompetenciesLocalService _service;
}