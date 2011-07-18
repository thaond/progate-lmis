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

package larion.progate.lmis.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="LmisViewDayTypeOverTimeSettingTypeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewDayTypeOverTimeSettingTypeLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType addLmisViewDayTypeOverTimeSettingType(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addLmisViewDayTypeOverTimeSettingType(lmisViewDayTypeOverTimeSettingType);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType createLmisViewDayTypeOverTimeSettingType(
		java.lang.Integer lmisViewDayTypeOverTimeSettingTypeId) {
		return getService()
				   .createLmisViewDayTypeOverTimeSettingType(lmisViewDayTypeOverTimeSettingTypeId);
	}

	public static void deleteLmisViewDayTypeOverTimeSettingType(
		java.lang.Integer lmisViewDayTypeOverTimeSettingTypeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewDayTypeOverTimeSettingType(lmisViewDayTypeOverTimeSettingTypeId);
	}

	public static void deleteLmisViewDayTypeOverTimeSettingType(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewDayTypeOverTimeSettingType(lmisViewDayTypeOverTimeSettingType);
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

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType getLmisViewDayTypeOverTimeSettingType(
		java.lang.Integer lmisViewDayTypeOverTimeSettingTypeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getLmisViewDayTypeOverTimeSettingType(lmisViewDayTypeOverTimeSettingTypeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> getLmisViewDayTypeOverTimeSettingTypes(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewDayTypeOverTimeSettingTypes(start, end);
	}

	public static int getLmisViewDayTypeOverTimeSettingTypesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewDayTypeOverTimeSettingTypesCount();
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType updateLmisViewDayTypeOverTimeSettingType(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewDayTypeOverTimeSettingType(lmisViewDayTypeOverTimeSettingType);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType updateLmisViewDayTypeOverTimeSettingType(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewDayTypeOverTimeSettingType(lmisViewDayTypeOverTimeSettingType,
			merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> getCoeffieient(
		int rootId, int dayType) {
		return getService().getCoeffieient(rootId, dayType);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewDayTypeOverTimeSettingTypeLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewDayTypeOverTimeSettingTypeLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewDayTypeOverTimeSettingTypeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(
		LmisViewDayTypeOverTimeSettingTypeLocalService service) {
		_service = service;
	}

	private static LmisViewDayTypeOverTimeSettingTypeLocalService _service;
}