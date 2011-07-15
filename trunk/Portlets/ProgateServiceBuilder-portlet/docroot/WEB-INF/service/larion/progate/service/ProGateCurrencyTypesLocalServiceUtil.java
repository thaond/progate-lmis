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
 * <a href="ProGateCurrencyTypesLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateCurrencyTypesLocalServiceUtil {
	public static larion.progate.model.ProGateCurrencyTypes addProGateCurrencyTypes(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes)
		throws com.liferay.portal.SystemException {
		return getService().addProGateCurrencyTypes(proGateCurrencyTypes);
	}

	public static larion.progate.model.ProGateCurrencyTypes createProGateCurrencyTypes(
		java.lang.Integer currencyId) {
		return getService().createProGateCurrencyTypes(currencyId);
	}

	public static void deleteProGateCurrencyTypes(java.lang.Integer currencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProGateCurrencyTypes(currencyId);
	}

	public static void deleteProGateCurrencyTypes(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes)
		throws com.liferay.portal.SystemException {
		getService().deleteProGateCurrencyTypes(proGateCurrencyTypes);
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

	public static larion.progate.model.ProGateCurrencyTypes getProGateCurrencyTypes(
		java.lang.Integer currencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProGateCurrencyTypes(currencyId);
	}

	public static java.util.List<larion.progate.model.ProGateCurrencyTypes> getProGateCurrencyTypeses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateCurrencyTypeses(start, end);
	}

	public static int getProGateCurrencyTypesesCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateCurrencyTypesesCount();
	}

	public static larion.progate.model.ProGateCurrencyTypes updateProGateCurrencyTypes(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes)
		throws com.liferay.portal.SystemException {
		return getService().updateProGateCurrencyTypes(proGateCurrencyTypes);
	}

	public static larion.progate.model.ProGateCurrencyTypes updateProGateCurrencyTypes(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateCurrencyTypes(proGateCurrencyTypes, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateCurrencyTypesLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateCurrencyTypesLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateCurrencyTypesLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateCurrencyTypesLocalService service) {
		_service = service;
	}

	private static ProGateCurrencyTypesLocalService _service;
}