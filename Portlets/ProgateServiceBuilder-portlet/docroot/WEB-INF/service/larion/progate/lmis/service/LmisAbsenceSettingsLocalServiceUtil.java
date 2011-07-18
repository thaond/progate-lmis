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
 * <a href="LmisAbsenceSettingsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceSettingsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisAbsenceSettings addLmisAbsenceSettings(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings)
		throws com.liferay.portal.SystemException {
		return getService().addLmisAbsenceSettings(lmisAbsenceSettings);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings createLmisAbsenceSettings(
		java.lang.Integer lmisAbsenceSettingsId) {
		return getService().createLmisAbsenceSettings(lmisAbsenceSettingsId);
	}

	public static void deleteLmisAbsenceSettings(
		java.lang.Integer lmisAbsenceSettingsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisAbsenceSettings(lmisAbsenceSettingsId);
	}

	public static void deleteLmisAbsenceSettings(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisAbsenceSettings(lmisAbsenceSettings);
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

	public static larion.progate.lmis.model.LmisAbsenceSettings getLmisAbsenceSettings(
		java.lang.Integer lmisAbsenceSettingsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisAbsenceSettings(lmisAbsenceSettingsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> getLmisAbsenceSettingses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisAbsenceSettingses(start, end);
	}

	public static int getLmisAbsenceSettingsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisAbsenceSettingsesCount();
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings updateLmisAbsenceSettings(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisAbsenceSettings(lmisAbsenceSettings);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings updateLmisAbsenceSettings(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisAbsenceSettings(lmisAbsenceSettings, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisAbsenceSettingsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisAbsenceSettingsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisAbsenceSettingsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisAbsenceSettingsLocalService service) {
		_service = service;
	}

	private static LmisAbsenceSettingsLocalService _service;
}