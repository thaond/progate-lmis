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
 * <a href="LmisOvertimeApprovalsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeApprovalsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisOvertimeApprovals addLmisOvertimeApprovals(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException {
		return getService().addLmisOvertimeApprovals(lmisOvertimeApprovals);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals createLmisOvertimeApprovals(
		java.lang.Integer lmisOvertimeApprovalsId) {
		return getService().createLmisOvertimeApprovals(lmisOvertimeApprovalsId);
	}

	public static void deleteLmisOvertimeApprovals(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisOvertimeApprovals(lmisOvertimeApprovalsId);
	}

	public static void deleteLmisOvertimeApprovals(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisOvertimeApprovals(lmisOvertimeApprovals);
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

	public static larion.progate.lmis.model.LmisOvertimeApprovals getLmisOvertimeApprovals(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisOvertimeApprovals(lmisOvertimeApprovalsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisOvertimeApprovalses(start, end);
	}

	public static int getLmisOvertimeApprovalsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisOvertimeApprovalsesCount();
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals updateLmisOvertimeApprovals(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisOvertimeApprovals(lmisOvertimeApprovals);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals updateLmisOvertimeApprovals(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisOvertimeApprovals(lmisOvertimeApprovals, merge);
	}

	public static java.lang.String getApprovalFeedback(int reportId, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getApprovalFeedback(reportId, rootId);
	}

	public static boolean updateOTapp(int rootId, int reportId, int requestId,
		int PmId, java.lang.String reason) {
		return getService()
				   .updateOTapp(rootId, reportId, requestId, PmId, reason);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisOvertimeApprovalsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisOvertimeApprovalsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisOvertimeApprovalsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisOvertimeApprovalsLocalService service) {
		_service = service;
	}

	private static LmisOvertimeApprovalsLocalService _service;
}