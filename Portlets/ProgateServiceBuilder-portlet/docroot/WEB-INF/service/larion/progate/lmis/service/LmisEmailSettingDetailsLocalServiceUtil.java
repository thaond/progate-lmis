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
 * <a href="LmisEmailSettingDetailsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingDetailsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisEmailSettingDetails addLmisEmailSettingDetails(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails)
		throws com.liferay.portal.SystemException {
		return getService().addLmisEmailSettingDetails(lmisEmailSettingDetails);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails createLmisEmailSettingDetails(
		java.lang.Integer lmisEmailSettingDetailId) {
		return getService()
				   .createLmisEmailSettingDetails(lmisEmailSettingDetailId);
	}

	public static void deleteLmisEmailSettingDetails(
		java.lang.Integer lmisEmailSettingDetailId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisEmailSettingDetails(lmisEmailSettingDetailId);
	}

	public static void deleteLmisEmailSettingDetails(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisEmailSettingDetails(lmisEmailSettingDetails);
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

	public static larion.progate.lmis.model.LmisEmailSettingDetails getLmisEmailSettingDetails(
		java.lang.Integer lmisEmailSettingDetailId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisEmailSettingDetails(lmisEmailSettingDetailId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisEmailSettingDetailses(start, end);
	}

	public static int getLmisEmailSettingDetailsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisEmailSettingDetailsesCount();
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails updateLmisEmailSettingDetails(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisEmailSettingDetails(lmisEmailSettingDetails);
	}

	public static larion.progate.lmis.model.LmisEmailSettingDetails updateLmisEmailSettingDetails(
		larion.progate.lmis.model.LmisEmailSettingDetails lmisEmailSettingDetails,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisEmailSettingDetails(lmisEmailSettingDetails, merge);
	}

	public static boolean updateEmailSettingDetail(int rootId, int emailId,
		java.util.ArrayList<Integer> orgid, java.util.ArrayList<Integer> userid) {
		return getService()
				   .updateEmailSettingDetail(rootId, emailId, orgid, userid);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisEmailSettingDetailsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisEmailSettingDetailsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisEmailSettingDetailsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisEmailSettingDetailsLocalService service) {
		_service = service;
	}

	private static LmisEmailSettingDetailsLocalService _service;
}