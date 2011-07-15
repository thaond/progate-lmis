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

package larion.progate.cds.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="CdsCdpLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsCdpLocalServiceUtil {
	public static larion.progate.cds.model.CdsCdp addCdsCdp(
		larion.progate.cds.model.CdsCdp cdsCdp)
		throws com.liferay.portal.SystemException {
		return getService().addCdsCdp(cdsCdp);
	}

	public static larion.progate.cds.model.CdsCdp createCdsCdp(
		java.lang.Integer CdsCdpId) {
		return getService().createCdsCdp(CdsCdpId);
	}

	public static void deleteCdsCdp(java.lang.Integer CdsCdpId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCdsCdp(CdsCdpId);
	}

	public static void deleteCdsCdp(larion.progate.cds.model.CdsCdp cdsCdp)
		throws com.liferay.portal.SystemException {
		getService().deleteCdsCdp(cdsCdp);
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

	public static larion.progate.cds.model.CdsCdp getCdsCdp(
		java.lang.Integer CdsCdpId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdsCdp(CdsCdpId);
	}

	public static java.util.List<larion.progate.cds.model.CdsCdp> getCdsCdps(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCdsCdps(start, end);
	}

	public static int getCdsCdpsCount()
		throws com.liferay.portal.SystemException {
		return getService().getCdsCdpsCount();
	}

	public static larion.progate.cds.model.CdsCdp updateCdsCdp(
		larion.progate.cds.model.CdsCdp cdsCdp)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsCdp(cdsCdp);
	}

	public static larion.progate.cds.model.CdsCdp updateCdsCdp(
		larion.progate.cds.model.CdsCdp cdsCdp, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateCdsCdp(cdsCdp, merge);
	}

	public static boolean addCdp(int rootId, int periodId, int userId,
		int writtenBy, java.lang.String writtenContent)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addCdp(rootId, periodId, userId, writtenBy, writtenContent);
	}

	public static java.util.List<larion.progate.cds.model.CdsCdp> getCdp(
		int rootId, int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCdp(rootId, userId, periodId);
	}

	public static boolean checkCdp(int rootId, int userId, int periodId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().checkCdp(rootId, userId, periodId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CdsCdpLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CdsCdpLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CdsCdpLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CdsCdpLocalService service) {
		_service = service;
	}

	private static CdsCdpLocalService _service;
}