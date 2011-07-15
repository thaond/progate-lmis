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
 * <a href="LmisViewAttdanceLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttdanceLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewAttdance addLmisViewAttdance(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewAttdance(lmisViewAttdance);
	}

	public static larion.progate.lmis.model.LmisViewAttdance createLmisViewAttdance(
		java.lang.Integer lmisViewAttDailyId) {
		return getService().createLmisViewAttdance(lmisViewAttDailyId);
	}

	public static void deleteLmisViewAttdance(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewAttdance(lmisViewAttDailyId);
	}

	public static void deleteLmisViewAttdance(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewAttdance(lmisViewAttdance);
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

	public static larion.progate.lmis.model.LmisViewAttdance getLmisViewAttdance(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewAttdance(lmisViewAttDailyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> getLmisViewAttdances(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewAttdances(start, end);
	}

	public static int getLmisViewAttdancesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewAttdancesCount();
	}

	public static larion.progate.lmis.model.LmisViewAttdance updateLmisViewAttdance(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewAttdance(lmisViewAttdance);
	}

	public static larion.progate.lmis.model.LmisViewAttdance updateLmisViewAttdance(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisViewAttdance(lmisViewAttdance, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> getListAttByRootAndDay(
		int rootId, java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getService().getListAttByRootAndDay(rootId, dayValue);
	}

	public static larion.progate.lmis.model.LmisViewAttdance getAttDetail(
		int id) throws com.liferay.portal.SystemException {
		return getService().getAttDetail(id);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> getListAttDailyByUserId(
		int userId, int rootId) throws com.liferay.portal.SystemException {
		return getService().getListAttDailyByUserId(userId, rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> getListAttDailyFilterTabPersonal(
		int rootId, int userId, java.util.Date date, int status, int absence)
		throws com.liferay.portal.SystemException {
		return getService()
				   .getListAttDailyFilterTabPersonal(rootId, userId, date,
			status, absence);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> getListAttDailyFilterTabOther(
		int rootId, java.util.Date date, java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getService().getListAttDailyFilterTabOther(rootId, date, name);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewAttdanceLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewAttdanceLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewAttdanceLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewAttdanceLocalService service) {
		_service = service;
	}

	private static LmisViewAttdanceLocalService _service;
}