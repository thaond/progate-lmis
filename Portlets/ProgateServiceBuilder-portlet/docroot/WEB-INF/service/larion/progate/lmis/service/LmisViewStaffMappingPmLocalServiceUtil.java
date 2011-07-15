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
 * <a href="LmisViewStaffMappingPmLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingPmLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewStaffMappingPm addLmisViewStaffMappingPm(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewStaffMappingPm(lmisViewStaffMappingPm);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm createLmisViewStaffMappingPm(
		java.lang.Integer lmisViewStaffMappingPmId) {
		return getService()
				   .createLmisViewStaffMappingPm(lmisViewStaffMappingPmId);
	}

	public static void deleteLmisViewStaffMappingPm(
		java.lang.Integer lmisViewStaffMappingPmId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewStaffMappingPm(lmisViewStaffMappingPmId);
	}

	public static void deleteLmisViewStaffMappingPm(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewStaffMappingPm(lmisViewStaffMappingPm);
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

	public static larion.progate.lmis.model.LmisViewStaffMappingPm getLmisViewStaffMappingPm(
		java.lang.Integer lmisViewStaffMappingPmId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewStaffMappingPm(lmisViewStaffMappingPmId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> getLmisViewStaffMappingPms(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewStaffMappingPms(start, end);
	}

	public static int getLmisViewStaffMappingPmsCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewStaffMappingPmsCount();
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm updateLmisViewStaffMappingPm(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewStaffMappingPm(lmisViewStaffMappingPm);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm updateLmisViewStaffMappingPm(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewStaffMappingPm(lmisViewStaffMappingPm, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewStaffMappingPmLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewStaffMappingPmLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewStaffMappingPmLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewStaffMappingPmLocalService service) {
		_service = service;
	}

	private static LmisViewStaffMappingPmLocalService _service;
}