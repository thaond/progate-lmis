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
 * <a href="CdsMinimumRequirementLevelsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsMinimumRequirementLevelsLocalServiceUtil {
	public static larion.progate.cds.model.CdsMinimumRequirementLevels addCdsMinimumRequirementLevels(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addCdsMinimumRequirementLevels(cdsMinimumRequirementLevels);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels createCdsMinimumRequirementLevels(
		java.lang.Integer minimumRequirementLevelId) {
		return getService()
				   .createCdsMinimumRequirementLevels(minimumRequirementLevelId);
	}

	public static void deleteCdsMinimumRequirementLevels(
		java.lang.Integer minimumRequirementLevelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsMinimumRequirementLevels(minimumRequirementLevelId);
	}

	public static void deleteCdsMinimumRequirementLevels(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteCdsMinimumRequirementLevels(cdsMinimumRequirementLevels);
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

	public static larion.progate.cds.model.CdsMinimumRequirementLevels getCdsMinimumRequirementLevels(
		java.lang.Integer minimumRequirementLevelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsMinimumRequirementLevels(minimumRequirementLevelId);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMinimumRequirementLevelses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsMinimumRequirementLevelses(start, end);
	}

	public static int getCdsMinimumRequirementLevelsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsMinimumRequirementLevelsesCount();
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels updateCdsMinimumRequirementLevels(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsMinimumRequirementLevels(cdsMinimumRequirementLevels);
	}

	public static larion.progate.cds.model.CdsMinimumRequirementLevels updateCdsMinimumRequirementLevels(
		larion.progate.cds.model.CdsMinimumRequirementLevels cdsMinimumRequirementLevels,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsMinimumRequirementLevels(cdsMinimumRequirementLevels,
			merge);
	}

	public static boolean deleteCdsMinimumRequirementLevel(
		int minimumRequirementLevelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .deleteCdsMinimumRequirementLevel(minimumRequirementLevelId);
	}

	public static boolean addCdsMinimumRequirementLevel(
		int minimumRequirementId, java.lang.String name, int numberOrder,
		int createdBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addCdsMinimumRequirementLevel(minimumRequirementId, name,
			numberOrder, createdBy);
	}

	public static boolean updateCdsMinimumRequirementLevel(
		int minimumRequirementLevelId, java.lang.String name, int numberOrder,
		int updateBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .updateCdsMinimumRequirementLevel(minimumRequirementLevelId,
			name, numberOrder, updateBy);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirementLevels> getCdsMRLevelListByMinimumRequirementId(
		int minimumRequirementId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getCdsMRLevelListByMinimumRequirementId(minimumRequirementId);
	}

	public static boolean checkMinimumRequirementLevelName(
		int minimumRequirementId, java.lang.String minimumRequirementLevelName)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .checkMinimumRequirementLevelName(minimumRequirementId,
			minimumRequirementLevelName);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsMinimumRequirementLevelsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsMinimumRequirementLevelsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsMinimumRequirementLevelsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsMinimumRequirementLevelsLocalService service) {
		_service = service;
	}

	private static CdsMinimumRequirementLevelsLocalService _service;
}