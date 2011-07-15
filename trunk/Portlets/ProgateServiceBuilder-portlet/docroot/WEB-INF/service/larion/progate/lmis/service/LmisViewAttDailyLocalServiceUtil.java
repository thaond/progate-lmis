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
 * <a href="LmisViewAttDailyLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttDailyLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewAttDaily addLmisViewAttDaily(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewAttDaily(lmisViewAttDaily);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily createLmisViewAttDaily(
		java.lang.Integer lmisViewAttDailyId) {
		return getService().createLmisViewAttDaily(lmisViewAttDailyId);
	}

	public static void deleteLmisViewAttDaily(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewAttDaily(lmisViewAttDailyId);
	}

	public static void deleteLmisViewAttDaily(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewAttDaily(lmisViewAttDaily);
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

	public static larion.progate.lmis.model.LmisViewAttDaily getLmisViewAttDaily(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewAttDaily(lmisViewAttDailyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> getLmisViewAttDailies(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewAttDailies(start, end);
	}

	public static int getLmisViewAttDailiesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewAttDailiesCount();
	}

	public static larion.progate.lmis.model.LmisViewAttDaily updateLmisViewAttDaily(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewAttDaily(lmisViewAttDaily);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily updateLmisViewAttDaily(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisViewAttDaily(lmisViewAttDaily, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getService().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> getListAttDailyByUserId(
		int userId, int rootId) throws com.liferay.portal.SystemException {
		return getService().getListAttDailyByUserId(userId, rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> getListAttByRootAndDay(
		int rootId, java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getService().getListAttByRootAndDay(rootId, dayValue);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily getAttDetail(
		int id) throws com.liferay.portal.SystemException {
		return getService().getAttDetail(id);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> getListAttByOrgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getService().getListAttByOrgId(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> getListAttByRootAndDayOrg(
		int rootId, java.util.Date dayValue, int subOrgId)
		throws com.liferay.portal.SystemException {
		return getService().getListAttByRootAndDayOrg(rootId, dayValue, subOrgId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewAttDailyLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewAttDailyLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewAttDailyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewAttDailyLocalService service) {
		_service = service;
	}

	private static LmisViewAttDailyLocalService _service;
}