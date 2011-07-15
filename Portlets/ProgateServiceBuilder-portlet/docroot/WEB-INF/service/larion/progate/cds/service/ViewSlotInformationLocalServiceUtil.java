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
 * <a href="ViewSlotInformationLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewSlotInformationLocalServiceUtil {
	public static larion.progate.cds.model.ViewSlotInformation addViewSlotInformation(
		larion.progate.cds.model.ViewSlotInformation viewSlotInformation)
		throws com.liferay.portal.SystemException {
		return getService().addViewSlotInformation(viewSlotInformation);
	}

	public static larion.progate.cds.model.ViewSlotInformation createViewSlotInformation(
		java.lang.Integer viewSlotInformationId) {
		return getService().createViewSlotInformation(viewSlotInformationId);
	}

	public static void deleteViewSlotInformation(
		java.lang.Integer viewSlotInformationId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteViewSlotInformation(viewSlotInformationId);
	}

	public static void deleteViewSlotInformation(
		larion.progate.cds.model.ViewSlotInformation viewSlotInformation)
		throws com.liferay.portal.SystemException {
		getService().deleteViewSlotInformation(viewSlotInformation);
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

	public static larion.progate.cds.model.ViewSlotInformation getViewSlotInformation(
		java.lang.Integer viewSlotInformationId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getViewSlotInformation(viewSlotInformationId);
	}

	public static java.util.List<larion.progate.cds.model.ViewSlotInformation> getViewSlotInformations(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getViewSlotInformations(start, end);
	}

	public static int getViewSlotInformationsCount()
		throws com.liferay.portal.SystemException {
		return getService().getViewSlotInformationsCount();
	}

	public static larion.progate.cds.model.ViewSlotInformation updateViewSlotInformation(
		larion.progate.cds.model.ViewSlotInformation viewSlotInformation)
		throws com.liferay.portal.SystemException {
		return getService().updateViewSlotInformation(viewSlotInformation);
	}

	public static larion.progate.cds.model.ViewSlotInformation updateViewSlotInformation(
		larion.progate.cds.model.ViewSlotInformation viewSlotInformation,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateViewSlotInformation(viewSlotInformation, merge);
	}

	public static java.util.List<larion.progate.cds.model.ViewSlotInformation> getSlotInformationListBySlotIdAndUserId(
		int slotId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getSlotInformationListBySlotIdAndUserId(slotId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewSlotInformationLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ViewSlotInformationLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ViewSlotInformationLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ViewSlotInformationLocalService service) {
		_service = service;
	}

	private static ViewSlotInformationLocalService _service;
}