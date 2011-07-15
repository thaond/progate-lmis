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
 * <a href="LmisViewReportOvertimeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimeLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewReportOvertime addLmisViewReportOvertime(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewReportOvertime(lmisViewReportOvertime);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime createLmisViewReportOvertime(
		java.lang.Integer lmisViewReportOvertimeId) {
		return getService()
				   .createLmisViewReportOvertime(lmisViewReportOvertimeId);
	}

	public static void deleteLmisViewReportOvertime(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewReportOvertime(lmisViewReportOvertimeId);
	}

	public static void deleteLmisViewReportOvertime(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewReportOvertime(lmisViewReportOvertime);
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

	public static larion.progate.lmis.model.LmisViewReportOvertime getLmisViewReportOvertime(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewReportOvertime(lmisViewReportOvertimeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> getLmisViewReportOvertimes(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewReportOvertimes(start, end);
	}

	public static int getLmisViewReportOvertimesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewReportOvertimesCount();
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime updateLmisViewReportOvertime(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewReportOvertime(lmisViewReportOvertime);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime updateLmisViewReportOvertime(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewReportOvertime(lmisViewReportOvertime, merge);
	}

	public static int countReportPending(int rootId)
		throws com.liferay.portal.SystemException {
		return getService().countReportPending(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> getListOverTimeRepRoleSpec(
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeRepRoleSpec(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> getListOverTimeRepRoleSpec(
		int rootId, int orgId) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeRepRoleSpec(rootId, orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> getListOverTimeRepRolePM(
		int rootId, int reportBy) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeRepRolePM(rootId, reportBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> getListOverTimeRepRoleBOD(
		int rootId, int reportBy) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeRepRoleBOD(rootId, reportBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> getListOverTimeRepDetail(
		int orgId, int reportId) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeRepDetail(orgId, reportId);
	}

	public static int findIdRep(int rootId, int approvedBy, int reportId)
		throws com.liferay.portal.SystemException {
		return getService().findIdRep(rootId, approvedBy, reportId);
	}

	public static boolean doApprove(int rootId, int orgId, int approvedBy,
		int reportId, boolean isApproved, boolean approvedStatus,
		java.lang.String reason) throws com.liferay.portal.SystemException {
		return getService()
				   .doApprove(rootId, orgId, approvedBy, reportId, isApproved,
			approvedStatus, reason);
	}

	public static boolean doApproveIt(int rootId, int orgId, int approvedBy,
		int reportId, boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException {
		return getService()
				   .doApproveIt(rootId, orgId, approvedBy, reportId,
			isApproved, reason);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewReportOvertimeLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewReportOvertimeLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewReportOvertimeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewReportOvertimeLocalService service) {
		_service = service;
	}

	private static LmisViewReportOvertimeLocalService _service;
}