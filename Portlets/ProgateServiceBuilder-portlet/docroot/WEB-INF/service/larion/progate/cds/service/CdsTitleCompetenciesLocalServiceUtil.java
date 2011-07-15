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
 * <a href="CdsTitleCompetenciesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleCompetenciesLocalServiceUtil {
	public static larion.progate.cds.model.CdsTitleCompetencies addCdsTitleCompetencies(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies)
		throws com.liferay.portal.SystemException {
		return getService().addCdsTitleCompetencies(cdsTitleCompetencies);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies createCdsTitleCompetencies(
		java.lang.Integer CdsTitleCompetenciesId) {
		return getService().createCdsTitleCompetencies(CdsTitleCompetenciesId);
	}

	public static void deleteCdsTitleCompetencies(
		java.lang.Integer CdsTitleCompetenciesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsTitleCompetencies(CdsTitleCompetenciesId);
	}

	public static void deleteCdsTitleCompetencies(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsTitleCompetencies(cdsTitleCompetencies);
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

	public static larion.progate.cds.model.CdsTitleCompetencies getCdsTitleCompetencies(
		java.lang.Integer CdsTitleCompetenciesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsTitleCompetencies(CdsTitleCompetenciesId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetencieses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsTitleCompetencieses(start, end);
	}

	public static int getCdsTitleCompetenciesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsTitleCompetenciesesCount();
	}

	public static larion.progate.cds.model.CdsTitleCompetencies updateCdsTitleCompetencies(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsTitleCompetencies(cdsTitleCompetencies);
	}

	public static larion.progate.cds.model.CdsTitleCompetencies updateCdsTitleCompetencies(
		larion.progate.cds.model.CdsTitleCompetencies cdsTitleCompetencies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsTitleCompetencies(cdsTitleCompetencies, merge);
	}

	public static boolean addTitleCompetencies(int titleId, int competencyId,
		int pointHash, java.lang.String pointValue)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addTitleCompetencies(titleId, competencyId, pointHash,
			pointValue);
	}

	public static boolean updateTitleCompetencies(int id, int pointHash,
		java.lang.String pointValue)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().updateTitleCompetencies(id, pointHash, pointValue);
	}

	public static boolean deleteTitleCompetencies(int titleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().deleteTitleCompetencies(titleId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> loadListTitleCompetencies(
		int titleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().loadListTitleCompetencies(titleId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleCompetencies> getCdsTitleCompetenciesListByCompetencyId(
		int competencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsTitleCompetenciesListByCompetencyId(competencyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsTitleCompetenciesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsTitleCompetenciesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsTitleCompetenciesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsTitleCompetenciesLocalService service) {
		_service = service;
	}

	private static CdsTitleCompetenciesLocalService _service;
}