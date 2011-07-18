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
 * <a href="LmisViewAttInfoLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttInfoLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewAttInfo addLmisViewAttInfo(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewAttInfo(lmisViewAttInfo);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo createLmisViewAttInfo(
		java.lang.Integer lmisViewAttInfoId) {
		return getService().createLmisViewAttInfo(lmisViewAttInfoId);
	}

	public static void deleteLmisViewAttInfo(
		java.lang.Integer lmisViewAttInfoId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewAttInfo(lmisViewAttInfoId);
	}

	public static void deleteLmisViewAttInfo(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewAttInfo(lmisViewAttInfo);
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

	public static larion.progate.lmis.model.LmisViewAttInfo getLmisViewAttInfo(
		java.lang.Integer lmisViewAttInfoId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewAttInfo(lmisViewAttInfoId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> getLmisViewAttInfos(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewAttInfos(start, end);
	}

	public static int getLmisViewAttInfosCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewAttInfosCount();
	}

	public static larion.progate.lmis.model.LmisViewAttInfo updateLmisViewAttInfo(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewAttInfo(lmisViewAttInfo);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo updateLmisViewAttInfo(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewAttInfo(lmisViewAttInfo, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> getListAttManageByPM(
		int rootId, int pmId, java.util.Date dayValue, java.lang.String name)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getListAttManageByPM(rootId, pmId, dayValue, name);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> getListAttManageByBOD(
		int rootId, int bodId, java.util.Date dayValue, java.lang.String name)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getListAttManageByBOD(rootId, bodId, dayValue, name);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewAttInfoLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewAttInfoLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewAttInfoLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewAttInfoLocalService service) {
		_service = service;
	}

	private static LmisViewAttInfoLocalService _service;
}