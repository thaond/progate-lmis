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
 * <a href="LmisEmailSettingsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisEmailSettings addLmisEmailSettings(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings)
		throws com.liferay.portal.SystemException {
		return getService().addLmisEmailSettings(lmisEmailSettings);
	}

	public static larion.progate.lmis.model.LmisEmailSettings createLmisEmailSettings(
		java.lang.Integer lmisEmailSettingId) {
		return getService().createLmisEmailSettings(lmisEmailSettingId);
	}

	public static void deleteLmisEmailSettings(
		java.lang.Integer lmisEmailSettingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisEmailSettings(lmisEmailSettingId);
	}

	public static void deleteLmisEmailSettings(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisEmailSettings(lmisEmailSettings);
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

	public static larion.progate.lmis.model.LmisEmailSettings getLmisEmailSettings(
		java.lang.Integer lmisEmailSettingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisEmailSettings(lmisEmailSettingId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> getLmisEmailSettingses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisEmailSettingses(start, end);
	}

	public static int getLmisEmailSettingsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisEmailSettingsesCount();
	}

	public static larion.progate.lmis.model.LmisEmailSettings updateLmisEmailSettings(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisEmailSettings(lmisEmailSettings);
	}

	public static larion.progate.lmis.model.LmisEmailSettings updateLmisEmailSettings(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisEmailSettings(lmisEmailSettings, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettings> getListEmailSetting(
		int rootId, int categoryId) {
		return getService().getListEmailSetting(rootId, categoryId);
	}

	public static int getListEmailSettingDefault(int rootId, int categoryId,
		java.lang.String emailType) {
		return getService()
				   .getListEmailSettingDefault(rootId, categoryId, emailType);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisEmailSettingsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisEmailSettingsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisEmailSettingsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisEmailSettingsLocalService service) {
		_service = service;
	}

	private static LmisEmailSettingsLocalService _service;
}