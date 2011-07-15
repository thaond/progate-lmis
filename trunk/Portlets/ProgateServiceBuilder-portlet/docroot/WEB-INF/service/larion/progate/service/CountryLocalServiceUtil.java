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
 * <a href="CountryLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CountryLocalServiceUtil {
	public static larion.progate.model.Country addCountry(
		larion.progate.model.Country country)
		throws com.liferay.portal.SystemException {
		return getService().addCountry(country);
	}

	public static larion.progate.model.Country createCountry(
		java.lang.Integer countryId) {
		return getService().createCountry(countryId);
	}

	public static void deleteCountry(java.lang.Integer countryId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCountry(countryId);
	}

	public static void deleteCountry(larion.progate.model.Country country)
		throws com.liferay.portal.SystemException {
		getService().deleteCountry(country);
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

	public static larion.progate.model.Country getCountry(
		java.lang.Integer countryId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCountry(countryId);
	}

	public static java.util.List<larion.progate.model.Country> getCountries(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCountries(start, end);
	}

	public static int getCountriesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCountriesCount();
	}

	public static larion.progate.model.Country updateCountry(
		larion.progate.model.Country country)
		throws com.liferay.portal.SystemException {
		return getService().updateCountry(country);
	}

	public static larion.progate.model.Country updateCountry(
		larion.progate.model.Country country, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateCountry(country, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static CountryLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CountryLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CountryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CountryLocalService service) {
		_service = service;
	}

	private static CountryLocalService _service;
}