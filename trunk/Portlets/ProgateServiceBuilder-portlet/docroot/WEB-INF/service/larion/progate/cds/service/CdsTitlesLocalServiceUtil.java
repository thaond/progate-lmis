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
 * <a href="CdsTitlesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitlesLocalServiceUtil {
	public static larion.progate.cds.model.CdsTitles addCdsTitles(
		larion.progate.cds.model.CdsTitles cdsTitles)
		throws com.liferay.portal.SystemException {
		return getService().addCdsTitles(cdsTitles);
	}

	public static larion.progate.cds.model.CdsTitles createCdsTitles(
		java.lang.Integer cdsTitleId) {
		return getService().createCdsTitles(cdsTitleId);
	}

	public static void deleteCdsTitles(java.lang.Integer cdsTitleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsTitles(cdsTitleId);
	}

	public static void deleteCdsTitles(
		larion.progate.cds.model.CdsTitles cdsTitles)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsTitles(cdsTitles);
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

	public static larion.progate.cds.model.CdsTitles getCdsTitles(
		java.lang.Integer cdsTitleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsTitles(cdsTitleId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> getCdsTitleses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsTitleses(start, end);
	}

	public static int getCdsTitlesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsTitlesesCount();
	}

	public static larion.progate.cds.model.CdsTitles updateCdsTitles(
		larion.progate.cds.model.CdsTitles cdsTitles)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsTitles(cdsTitles);
	}

	public static larion.progate.cds.model.CdsTitles updateCdsTitles(
		larion.progate.cds.model.CdsTitles cdsTitles, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsTitles(cdsTitles, merge);
	}

	public static boolean addCdsTitle(int rootId, java.lang.String name,
		java.lang.String abbreviation, int numberOrder, int createdBy,
		java.util.List titleCompetencies,
		java.util.List titleMinimumRequirements)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addCdsTitle(rootId, name, abbreviation, numberOrder,
			createdBy, titleCompetencies, titleMinimumRequirements);
	}

	public static boolean updateCdsTitle(int titleId, java.lang.String name,
		java.lang.String abbreviation, int numberOrder, int updatedBy,
		java.util.List titleCompetencies,
		java.util.List titleMinimumRequirements)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .updateCdsTitle(titleId, name, abbreviation, numberOrder,
			updatedBy, titleCompetencies, titleMinimumRequirements);
	}

	public static boolean deleteCdsTitle(int titleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().deleteCdsTitle(titleId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitles> loadListTitles(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().loadListTitles(rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsTitlesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsTitlesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsTitlesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsTitlesLocalService service) {
		_service = service;
	}

	private static CdsTitlesLocalService _service;
}