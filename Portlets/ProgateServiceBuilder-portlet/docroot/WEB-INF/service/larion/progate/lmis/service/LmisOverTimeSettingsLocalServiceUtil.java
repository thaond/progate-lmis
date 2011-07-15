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
 * <a href="LmisOverTimeSettingsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeSettingsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisOverTimeSettings addLmisOverTimeSettings(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings)
		throws com.liferay.portal.SystemException {
		return getService().addLmisOverTimeSettings(lmisOverTimeSettings);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings createLmisOverTimeSettings(
		java.lang.Integer lmisOverTimeSettingsId) {
		return getService().createLmisOverTimeSettings(lmisOverTimeSettingsId);
	}

	public static void deleteLmisOverTimeSettings(
		java.lang.Integer lmisOverTimeSettingsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeSettings(lmisOverTimeSettingsId);
	}

	public static void deleteLmisOverTimeSettings(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeSettings(lmisOverTimeSettings);
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

	public static larion.progate.lmis.model.LmisOverTimeSettings getLmisOverTimeSettings(
		java.lang.Integer lmisOverTimeSettingsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisOverTimeSettings(lmisOverTimeSettingsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeSettingses(start, end);
	}

	public static int getLmisOverTimeSettingsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeSettingsesCount();
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings updateLmisOverTimeSettings(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisOverTimeSettings(lmisOverTimeSettings);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings updateLmisOverTimeSettings(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisOverTimeSettings(lmisOverTimeSettings, merge);
	}

	public static boolean updateOverTimeSettings(int rootId, int settingId,
		int dayId, int otId, double coEfficient, java.lang.String name,
		java.lang.String desciption) throws com.liferay.portal.SystemException {
		return getService()
				   .updateOverTimeSettings(rootId, settingId, dayId, otId,
			coEfficient, name, desciption);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisOverTimeSettingsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisOverTimeSettingsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisOverTimeSettingsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisOverTimeSettingsLocalService service) {
		_service = service;
	}

	private static LmisOverTimeSettingsLocalService _service;
}