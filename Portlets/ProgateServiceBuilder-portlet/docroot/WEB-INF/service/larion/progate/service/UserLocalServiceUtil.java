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

package larion.progate.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="UserLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserLocalServiceUtil {
	public static larion.progate.model.User addUser(
		larion.progate.model.User user)
		throws com.liferay.portal.SystemException {
		return getService().addUser(user);
	}

	public static larion.progate.model.User createUser(java.lang.Integer userid) {
		return getService().createUser(userid);
	}

	public static void deleteUser(java.lang.Integer userid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteUser(userid);
	}

	public static void deleteUser(larion.progate.model.User user)
		throws com.liferay.portal.SystemException {
		getService().deleteUser(user);
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

	public static larion.progate.model.User getUser(java.lang.Integer userid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getUser(userid);
	}

	public static java.util.List<larion.progate.model.User> getUsers(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getUsers(start, end);
	}

	public static int getUsersCount() throws com.liferay.portal.SystemException {
		return getService().getUsersCount();
	}

	public static larion.progate.model.User updateUser(
		larion.progate.model.User user)
		throws com.liferay.portal.SystemException {
		return getService().updateUser(user);
	}

	public static larion.progate.model.User updateUser(
		larion.progate.model.User user, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateUser(user, merge);
	}

	public static java.util.List<larion.progate.model.User> getUserInCompany(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getUserInCompany(rootId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					UserLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new UserLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(UserLocalService service) {
		_service = service;
	}

	private static UserLocalService _service;
}