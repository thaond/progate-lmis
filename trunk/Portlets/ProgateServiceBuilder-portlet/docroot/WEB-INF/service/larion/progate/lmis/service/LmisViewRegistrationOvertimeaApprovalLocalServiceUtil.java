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
 * <a href="LmisViewRegistrationOvertimeaApprovalLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeaApprovalLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval addLmisViewRegistrationOvertimeaApproval(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addLmisViewRegistrationOvertimeaApproval(lmisViewRegistrationOvertimeaApproval);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval createLmisViewRegistrationOvertimeaApproval(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId) {
		return getService()
				   .createLmisViewRegistrationOvertimeaApproval(lmisViewRegistrationOvertimeaApprovalId);
	}

	public static void deleteLmisViewRegistrationOvertimeaApproval(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewRegistrationOvertimeaApproval(lmisViewRegistrationOvertimeaApprovalId);
	}

	public static void deleteLmisViewRegistrationOvertimeaApproval(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewRegistrationOvertimeaApproval(lmisViewRegistrationOvertimeaApproval);
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

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval getLmisViewRegistrationOvertimeaApproval(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getLmisViewRegistrationOvertimeaApproval(lmisViewRegistrationOvertimeaApprovalId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> getLmisViewRegistrationOvertimeaApprovals(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewRegistrationOvertimeaApprovals(start, end);
	}

	public static int getLmisViewRegistrationOvertimeaApprovalsCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewRegistrationOvertimeaApprovalsCount();
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval updateLmisViewRegistrationOvertimeaApproval(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewRegistrationOvertimeaApproval(lmisViewRegistrationOvertimeaApproval);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval updateLmisViewRegistrationOvertimeaApproval(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewRegistrationOvertimeaApproval(lmisViewRegistrationOvertimeaApproval,
			merge);
	}

	public static java.util.ArrayList<Integer> getListOverTimeApproval(
		int rootId, int approvedBy) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeApproval(rootId, approvedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> getListApproval(
		int rootId, int approvedBy) throws com.liferay.portal.SystemException {
		return getService().getListApproval(rootId, approvedBy);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewRegistrationOvertimeaApprovalLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewRegistrationOvertimeaApprovalLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewRegistrationOvertimeaApprovalLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(
		LmisViewRegistrationOvertimeaApprovalLocalService service) {
		_service = service;
	}

	private static LmisViewRegistrationOvertimeaApprovalLocalService _service;
}