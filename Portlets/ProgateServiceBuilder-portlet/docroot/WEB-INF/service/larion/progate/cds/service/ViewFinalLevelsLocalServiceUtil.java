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
 * <a href="ViewFinalLevelsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewFinalLevelsLocalServiceUtil {
	public static larion.progate.cds.model.ViewFinalLevels addViewFinalLevels(
		larion.progate.cds.model.ViewFinalLevels viewFinalLevels)
		throws com.liferay.portal.SystemException {
		return getService().addViewFinalLevels(viewFinalLevels);
	}

	public static larion.progate.cds.model.ViewFinalLevels createViewFinalLevels(
		java.lang.Integer levelId) {
		return getService().createViewFinalLevels(levelId);
	}

	public static void deleteViewFinalLevels(java.lang.Integer levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewFinalLevels(levelId);
	}

	public static void deleteViewFinalLevels(
		larion.progate.cds.model.ViewFinalLevels viewFinalLevels)
		throws com.liferay.portal.SystemException {
		getService().deleteViewFinalLevels(viewFinalLevels);
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

	public static larion.progate.cds.model.ViewFinalLevels getViewFinalLevels(
		java.lang.Integer levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewFinalLevels(levelId);
	}

	public static java.util.List<larion.progate.cds.model.ViewFinalLevels> getViewFinalLevelses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewFinalLevelses(start, end);
	}

	public static int getViewFinalLevelsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewFinalLevelsesCount();
	}

	public static larion.progate.cds.model.ViewFinalLevels updateViewFinalLevels(
		larion.progate.cds.model.ViewFinalLevels viewFinalLevels)
		throws com.liferay.portal.SystemException {
		return getService().updateViewFinalLevels(viewFinalLevels);
	}

	public static larion.progate.cds.model.ViewFinalLevels updateViewFinalLevels(
		larion.progate.cds.model.ViewFinalLevels viewFinalLevels, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateViewFinalLevels(viewFinalLevels, merge);
	}

	public static java.util.List<larion.progate.cds.model.ViewFinalLevels> getFinalLevelsList(
		int rootId, int userId, int competencyId, int statusOfSlot)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getFinalLevelsList(rootId, userId, competencyId,
			statusOfSlot);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewFinalLevelsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewFinalLevelsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewFinalLevelsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewFinalLevelsLocalService service) {
		_service = service;
	}

	private static ViewFinalLevelsLocalService _service;
}