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
 * <a href="RegionLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class RegionLocalServiceUtil {
	public static larion.progate.model.Region addRegion(
		larion.progate.model.Region region)
		throws com.liferay.portal.SystemException {
		return getService().addRegion(region);
	}

	public static larion.progate.model.Region createRegion(
		java.lang.Integer regionId) {
		return getService().createRegion(regionId);
	}

	public static void deleteRegion(java.lang.Integer regionId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteRegion(regionId);
	}

	public static void deleteRegion(larion.progate.model.Region region)
		throws com.liferay.portal.SystemException {
		getService().deleteRegion(region);
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

	public static larion.progate.model.Region getRegion(
		java.lang.Integer regionId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getRegion(regionId);
	}

	public static java.util.List<larion.progate.model.Region> getRegions(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getRegions(start, end);
	}

	public static int getRegionsCount()
		throws com.liferay.portal.SystemException {
		return getService().getRegionsCount();
	}

	public static larion.progate.model.Region updateRegion(
		larion.progate.model.Region region)
		throws com.liferay.portal.SystemException {
		return getService().updateRegion(region);
	}

	public static larion.progate.model.Region updateRegion(
		larion.progate.model.Region region, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateRegion(region, merge);
	}

	public static java.util.List<larion.progate.model.Region> getListRegionByCountryCode(
		java.lang.String contryCode) {
		return getService().getListRegionByCountryCode(contryCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static RegionLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					RegionLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new RegionLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(RegionLocalService service) {
		_service = service;
	}

	private static RegionLocalService _service;
}