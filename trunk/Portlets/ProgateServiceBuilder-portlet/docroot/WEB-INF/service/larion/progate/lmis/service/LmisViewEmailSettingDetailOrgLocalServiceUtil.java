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
 * <a href="LmisViewEmailSettingDetailOrgLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewEmailSettingDetailOrgLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg addLmisViewEmailSettingDetailOrg(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addLmisViewEmailSettingDetailOrg(lmisViewEmailSettingDetailOrg);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg createLmisViewEmailSettingDetailOrg(
		java.lang.Integer orgRelatedId) {
		return getService().createLmisViewEmailSettingDetailOrg(orgRelatedId);
	}

	public static void deleteLmisViewEmailSettingDetailOrg(
		java.lang.Integer orgRelatedId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewEmailSettingDetailOrg(orgRelatedId);
	}

	public static void deleteLmisViewEmailSettingDetailOrg(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewEmailSettingDetailOrg(lmisViewEmailSettingDetailOrg);
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

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg getLmisViewEmailSettingDetailOrg(
		java.lang.Integer orgRelatedId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewEmailSettingDetailOrg(orgRelatedId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> getLmisViewEmailSettingDetailOrgs(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewEmailSettingDetailOrgs(start, end);
	}

	public static int getLmisViewEmailSettingDetailOrgsCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewEmailSettingDetailOrgsCount();
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg updateLmisViewEmailSettingDetailOrg(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewEmailSettingDetailOrg(lmisViewEmailSettingDetailOrg);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg updateLmisViewEmailSettingDetailOrg(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewEmailSettingDetailOrg(lmisViewEmailSettingDetailOrg,
			merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> getListEmail(
		int rootId, java.lang.String type) {
		return getService().getListEmail(rootId, type);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> getListEmailOrgRelated(
		int rootId, int id) {
		return getService().getListEmailOrgRelated(rootId, id);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewEmailSettingDetailOrgLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewEmailSettingDetailOrgLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewEmailSettingDetailOrgLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewEmailSettingDetailOrgLocalService service) {
		_service = service;
	}

	private static LmisViewEmailSettingDetailOrgLocalService _service;
}