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
 * <a href="LmisOverTimeTypesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeTypesLocalServiceUtil {
	public static larion.progate.lmis.model.LmisOverTimeTypes addLmisOverTimeTypes(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes)
		throws com.liferay.portal.SystemException {
		return getService().addLmisOverTimeTypes(lmisOverTimeTypes);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes createLmisOverTimeTypes(
		java.lang.Integer lmisOverTimeTypesId) {
		return getService().createLmisOverTimeTypes(lmisOverTimeTypesId);
	}

	public static void deleteLmisOverTimeTypes(
		java.lang.Integer lmisOverTimeTypesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeTypes(lmisOverTimeTypesId);
	}

	public static void deleteLmisOverTimeTypes(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisOverTimeTypes(lmisOverTimeTypes);
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

	public static larion.progate.lmis.model.LmisOverTimeTypes getLmisOverTimeTypes(
		java.lang.Integer lmisOverTimeTypesId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisOverTimeTypes(lmisOverTimeTypesId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> getLmisOverTimeTypeses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeTypeses(start, end);
	}

	public static int getLmisOverTimeTypesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisOverTimeTypesesCount();
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes updateLmisOverTimeTypes(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisOverTimeTypes(lmisOverTimeTypes);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes updateLmisOverTimeTypes(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisOverTimeTypes(lmisOverTimeTypes, merge);
	}

	public static boolean updateOverTimeTypes(int rootId, int settingId,
		int dayId, int otId, double coEfficient, java.lang.String name,
		java.lang.String desciption) throws com.liferay.portal.SystemException {
		return getService()
				   .updateOverTimeTypes(rootId, settingId, dayId, otId,
			coEfficient, name, desciption);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisOverTimeTypesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisOverTimeTypesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisOverTimeTypesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisOverTimeTypesLocalService service) {
		_service = service;
	}

	private static LmisOverTimeTypesLocalService _service;
}