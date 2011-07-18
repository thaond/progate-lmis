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
 * <a href="CdsTitleMinimumRequirementsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitleMinimumRequirementsLocalServiceUtil {
	public static larion.progate.cds.model.CdsTitleMinimumRequirements addCdsTitleMinimumRequirements(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addCdsTitleMinimumRequirements(cdsTitleMinimumRequirements);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements createCdsTitleMinimumRequirements(
		java.lang.Integer CdsTitleMinimumRequirementsId) {
		return getService()
				   .createCdsTitleMinimumRequirements(CdsTitleMinimumRequirementsId);
	}

	public static void deleteCdsTitleMinimumRequirements(
		java.lang.Integer CdsTitleMinimumRequirementsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteCdsTitleMinimumRequirements(CdsTitleMinimumRequirementsId);
	}

	public static void deleteCdsTitleMinimumRequirements(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteCdsTitleMinimumRequirements(cdsTitleMinimumRequirements);
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

	public static larion.progate.cds.model.CdsTitleMinimumRequirements getCdsTitleMinimumRequirements(
		java.lang.Integer CdsTitleMinimumRequirementsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsTitleMinimumRequirements(CdsTitleMinimumRequirementsId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsTitleMinimumRequirementses(start, end);
	}

	public static int getCdsTitleMinimumRequirementsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsTitleMinimumRequirementsesCount();
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements updateCdsTitleMinimumRequirements(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsTitleMinimumRequirements(cdsTitleMinimumRequirements);
	}

	public static larion.progate.cds.model.CdsTitleMinimumRequirements updateCdsTitleMinimumRequirements(
		larion.progate.cds.model.CdsTitleMinimumRequirements cdsTitleMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsTitleMinimumRequirements(cdsTitleMinimumRequirements,
			merge);
	}

	public static boolean addTitleMinimumRequirements(int titleId,
		int minimumRequirementId, int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addTitleMinimumRequirements(titleId, minimumRequirementId,
			levelId);
	}

	public static boolean updateTitleMinimumRequirements(int id,
		int minimumRequirementId, int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .updateTitleMinimumRequirements(id, minimumRequirementId,
			levelId);
	}

	public static boolean deleteTitleMinimumRequirements(int titleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().deleteTitleMinimumRequirements(titleId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementsListByMinimumRequirementId(
		int minimumRequirementId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsTitleMinimumRequirementsListByMinimumRequirementId(minimumRequirementId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementsListByMinimumRequirementLevelId(
		int minimumRequirementLevelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsTitleMinimumRequirementsListByMinimumRequirementLevelId(minimumRequirementLevelId);
	}

	public static java.util.List<larion.progate.cds.model.CdsTitleMinimumRequirements> loadListTitleMinimumRequirements(
		int titleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().loadListTitleMinimumRequirements(titleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsTitleMinimumRequirementsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsTitleMinimumRequirementsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsTitleMinimumRequirementsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsTitleMinimumRequirementsLocalService service) {
		_service = service;
	}

	private static CdsTitleMinimumRequirementsLocalService _service;
}