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
 * <a href="LmisViewEmailSettingDetailUserLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewEmailSettingDetailUserLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewEmailSettingDetailUser addLmisViewEmailSettingDetailUser(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addLmisViewEmailSettingDetailUser(lmisViewEmailSettingDetailUser);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailUser createLmisViewEmailSettingDetailUser(
		java.lang.Integer userRelatedId) {
		return getService().createLmisViewEmailSettingDetailUser(userRelatedId);
	}

	public static void deleteLmisViewEmailSettingDetailUser(
		java.lang.Integer userRelatedId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewEmailSettingDetailUser(userRelatedId);
	}

	public static void deleteLmisViewEmailSettingDetailUser(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewEmailSettingDetailUser(lmisViewEmailSettingDetailUser);
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

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailUser getLmisViewEmailSettingDetailUser(
		java.lang.Integer userRelatedId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewEmailSettingDetailUser(userRelatedId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> getLmisViewEmailSettingDetailUsers(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewEmailSettingDetailUsers(start, end);
	}

	public static int getLmisViewEmailSettingDetailUsersCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewEmailSettingDetailUsersCount();
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailUser updateLmisViewEmailSettingDetailUser(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewEmailSettingDetailUser(lmisViewEmailSettingDetailUser);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailUser updateLmisViewEmailSettingDetailUser(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewEmailSettingDetailUser(lmisViewEmailSettingDetailUser,
			merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> getListEmail(
		int rootid, java.lang.String type) {
		return getService().getListEmail(rootid, type);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> getListEmailUserRelated(
		int rootid, int id) {
		return getService().getListEmailUserRelated(rootid, id);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewEmailSettingDetailUserLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewEmailSettingDetailUserLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewEmailSettingDetailUserLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewEmailSettingDetailUserLocalService service) {
		_service = service;
	}

	private static LmisViewEmailSettingDetailUserLocalService _service;
}