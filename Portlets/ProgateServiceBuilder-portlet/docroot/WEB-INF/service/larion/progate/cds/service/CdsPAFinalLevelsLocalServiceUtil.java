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
 * <a href="CdsPAFinalLevelsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalLevelsLocalServiceUtil {
	public static larion.progate.cds.model.CdsPAFinalLevels addCdsPAFinalLevels(
		larion.progate.cds.model.CdsPAFinalLevels cdsPAFinalLevels)
		throws com.liferay.portal.SystemException {
		return getService().addCdsPAFinalLevels(cdsPAFinalLevels);
	}

	public static larion.progate.cds.model.CdsPAFinalLevels createCdsPAFinalLevels(
		java.lang.Integer CdsPAFinalLevelsId) {
		return getService().createCdsPAFinalLevels(CdsPAFinalLevelsId);
	}

	public static void deleteCdsPAFinalLevels(
		java.lang.Integer CdsPAFinalLevelsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsPAFinalLevels(CdsPAFinalLevelsId);
	}

	public static void deleteCdsPAFinalLevels(
		larion.progate.cds.model.CdsPAFinalLevels cdsPAFinalLevels)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsPAFinalLevels(cdsPAFinalLevels);
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

	public static larion.progate.cds.model.CdsPAFinalLevels getCdsPAFinalLevels(
		java.lang.Integer CdsPAFinalLevelsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsPAFinalLevels(CdsPAFinalLevelsId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalLevels> getCdsPAFinalLevelses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsPAFinalLevelses(start, end);
	}

	public static int getCdsPAFinalLevelsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsPAFinalLevelsesCount();
	}

	public static larion.progate.cds.model.CdsPAFinalLevels updateCdsPAFinalLevels(
		larion.progate.cds.model.CdsPAFinalLevels cdsPAFinalLevels)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsPAFinalLevels(cdsPAFinalLevels);
	}

	public static larion.progate.cds.model.CdsPAFinalLevels updateCdsPAFinalLevels(
		larion.progate.cds.model.CdsPAFinalLevels cdsPAFinalLevels,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateCdsPAFinalLevels(cdsPAFinalLevels, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsPAFinalLevelsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsPAFinalLevelsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsPAFinalLevelsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsPAFinalLevelsLocalService service) {
		_service = service;
	}

	private static CdsPAFinalLevelsLocalService _service;
}