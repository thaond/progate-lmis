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
 * <a href="LmisViewStaffMappingLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewStaffMapping addLmisViewStaffMapping(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewStaffMapping(lmisViewStaffMapping);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping createLmisViewStaffMapping(
		java.lang.Integer lmisViewStaffMappingId) {
		return getService().createLmisViewStaffMapping(lmisViewStaffMappingId);
	}

	public static void deleteLmisViewStaffMapping(
		java.lang.Integer lmisViewStaffMappingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewStaffMapping(lmisViewStaffMappingId);
	}

	public static void deleteLmisViewStaffMapping(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewStaffMapping(lmisViewStaffMapping);
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

	public static larion.progate.lmis.model.LmisViewStaffMapping getLmisViewStaffMapping(
		java.lang.Integer lmisViewStaffMappingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewStaffMapping(lmisViewStaffMappingId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> getLmisViewStaffMappings(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewStaffMappings(start, end);
	}

	public static int getLmisViewStaffMappingsCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewStaffMappingsCount();
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping updateLmisViewStaffMapping(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewStaffMapping(lmisViewStaffMapping);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping updateLmisViewStaffMapping(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewStaffMapping(lmisViewStaffMapping, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> getPmIdOfUser(
		int userId) {
		return getService().getPmIdOfUser(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewStaffMappingLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewStaffMappingLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewStaffMappingLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewStaffMappingLocalService service) {
		_service = service;
	}

	private static LmisViewStaffMappingLocalService _service;
}