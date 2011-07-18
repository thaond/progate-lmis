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
 * <a href="LmisViewReportOvertimeApprovalLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimeApprovalLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval addLmisViewReportOvertimeApproval(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addLmisViewReportOvertimeApproval(lmisViewReportOvertimeApproval);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval createLmisViewReportOvertimeApproval(
		java.lang.Integer lmisViewReportOvertimeApprovalId) {
		return getService()
				   .createLmisViewReportOvertimeApproval(lmisViewReportOvertimeApprovalId);
	}

	public static void deleteLmisViewReportOvertimeApproval(
		java.lang.Integer lmisViewReportOvertimeApprovalId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewReportOvertimeApproval(lmisViewReportOvertimeApprovalId);
	}

	public static void deleteLmisViewReportOvertimeApproval(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewReportOvertimeApproval(lmisViewReportOvertimeApproval);
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

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval getLmisViewReportOvertimeApproval(
		java.lang.Integer lmisViewReportOvertimeApprovalId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getLmisViewReportOvertimeApproval(lmisViewReportOvertimeApprovalId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> getLmisViewReportOvertimeApprovals(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewReportOvertimeApprovals(start, end);
	}

	public static int getLmisViewReportOvertimeApprovalsCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewReportOvertimeApprovalsCount();
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval updateLmisViewReportOvertimeApproval(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewReportOvertimeApproval(lmisViewReportOvertimeApproval);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval updateLmisViewReportOvertimeApproval(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewReportOvertimeApproval(lmisViewReportOvertimeApproval,
			merge);
	}

	public static int countReportPending(int rootId)
		throws com.liferay.portal.SystemException {
		return getService().countReportPending(rootId);
	}

	public static java.util.ArrayList<Integer> getListOverTimeApproval(
		int rootId, int approvedBy) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeApproval(rootId, approvedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> getListApproval(
		int rootId, int approvedBy) throws com.liferay.portal.SystemException {
		return getService().getListApproval(rootId, approvedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> getListApprovalForBOD(
		int rootId, int approvedBy, int orgId, int status)
		throws com.liferay.portal.SystemException {
		return getService()
				   .getListApprovalForBOD(rootId, approvedBy, orgId, status);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> getListApprovalForPM(
		int rootId, int approvedBy, int status)
		throws com.liferay.portal.SystemException {
		return getService().getListApprovalForPM(rootId, approvedBy, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewReportOvertimeApprovalLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewReportOvertimeApprovalLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewReportOvertimeApprovalLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewReportOvertimeApprovalLocalService service) {
		_service = service;
	}

	private static LmisViewReportOvertimeApprovalLocalService _service;
}