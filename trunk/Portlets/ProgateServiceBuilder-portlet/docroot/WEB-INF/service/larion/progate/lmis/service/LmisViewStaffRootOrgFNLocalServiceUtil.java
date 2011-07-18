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
 * <a href="LmisViewStaffRootOrgFNLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgFNLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewStaffRootOrgFN addLmisViewStaffRootOrgFN(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewStaffRootOrgFN(lmisViewStaffRootOrgFN);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgFN createLmisViewStaffRootOrgFN(
		java.lang.Integer lmisViewStaffRootOrgFNId) {
		return getService()
				   .createLmisViewStaffRootOrgFN(lmisViewStaffRootOrgFNId);
	}

	public static void deleteLmisViewStaffRootOrgFN(
		java.lang.Integer lmisViewStaffRootOrgFNId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewStaffRootOrgFN(lmisViewStaffRootOrgFNId);
	}

	public static void deleteLmisViewStaffRootOrgFN(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewStaffRootOrgFN(lmisViewStaffRootOrgFN);
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

	public static larion.progate.lmis.model.LmisViewStaffRootOrgFN getLmisViewStaffRootOrgFN(
		java.lang.Integer lmisViewStaffRootOrgFNId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewStaffRootOrgFN(lmisViewStaffRootOrgFNId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> getLmisViewStaffRootOrgFNs(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewStaffRootOrgFNs(start, end);
	}

	public static int getLmisViewStaffRootOrgFNsCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewStaffRootOrgFNsCount();
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgFN updateLmisViewStaffRootOrgFN(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewStaffRootOrgFN(lmisViewStaffRootOrgFN);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgFN updateLmisViewStaffRootOrgFN(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewStaffRootOrgFN(lmisViewStaffRootOrgFN, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getService().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getService().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findstaff(
		int rootid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().findstaff(rootid);
	}

	public static int editScanncerCode(int rootId, int userId,
		java.lang.String newcode)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().editScanncerCode(rootId, userId, newcode);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewStaffRootOrgFNLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewStaffRootOrgFNLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewStaffRootOrgFNLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewStaffRootOrgFNLocalService service) {
		_service = service;
	}

	private static LmisViewStaffRootOrgFNLocalService _service;
}