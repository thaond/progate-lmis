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
 * <a href="CdsMinimumRequirementsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsMinimumRequirementsLocalServiceUtil {
	public static larion.progate.cds.model.CdsMinimumRequirements addCdsMinimumRequirements(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getService().addCdsMinimumRequirements(cdsMinimumRequirements);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements createCdsMinimumRequirements(
		java.lang.Integer minimumRequirementId) {
		return getService().createCdsMinimumRequirements(minimumRequirementId);
	}

	public static void deleteCdsMinimumRequirements(
		java.lang.Integer minimumRequirementId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsMinimumRequirements(minimumRequirementId);
	}

	public static void deleteCdsMinimumRequirements(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsMinimumRequirements(cdsMinimumRequirements);
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

	public static larion.progate.cds.model.CdsMinimumRequirements getCdsMinimumRequirements(
		java.lang.Integer minimumRequirementId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsMinimumRequirements(minimumRequirementId);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> getCdsMinimumRequirementses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsMinimumRequirementses(start, end);
	}

	public static int getCdsMinimumRequirementsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsMinimumRequirementsesCount();
	}

	public static larion.progate.cds.model.CdsMinimumRequirements updateCdsMinimumRequirements(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsMinimumRequirements(cdsMinimumRequirements);
	}

	public static larion.progate.cds.model.CdsMinimumRequirements updateCdsMinimumRequirements(
		larion.progate.cds.model.CdsMinimumRequirements cdsMinimumRequirements,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateCdsMinimumRequirements(cdsMinimumRequirements, merge);
	}

	public static boolean deleteCdsMinimumRequirement(int minimumRequirementId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().deleteCdsMinimumRequirement(minimumRequirementId);
	}

	public static boolean addCdsMinimumRequirement(int rootId,
		java.lang.String name, int numberOrder, int createdBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addCdsMinimumRequirement(rootId, name, numberOrder,
			createdBy);
	}

	public static boolean updateCdsMinimumRequirement(
		int minimumRequirementId, java.lang.String name, int numberOrder,
		int updateBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .updateCdsMinimumRequirement(minimumRequirementId, name,
			numberOrder, updateBy);
	}

	public static java.util.List<larion.progate.cds.model.CdsMinimumRequirements> getMinimumRequirementListByRootId(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getMinimumRequirementListByRootId(rootId);
	}

	public static boolean checkMinimumRequirementName(int rootId,
		java.lang.String minimumRequirementName)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .checkMinimumRequirementName(rootId, minimumRequirementName);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsMinimumRequirementsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsMinimumRequirementsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsMinimumRequirementsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsMinimumRequirementsLocalService service) {
		_service = service;
	}

	private static CdsMinimumRequirementsLocalService _service;
}