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
 * <a href="LmisViewRegistrationOvertimeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewRegistrationOvertime addLmisViewRegistrationOvertime(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addLmisViewRegistrationOvertime(lmisViewRegistrationOvertime);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime createLmisViewRegistrationOvertime(
		java.lang.Integer lmisViewRegistrationOvertimeId) {
		return getService()
				   .createLmisViewRegistrationOvertime(lmisViewRegistrationOvertimeId);
	}

	public static void deleteLmisViewRegistrationOvertime(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewRegistrationOvertime(lmisViewRegistrationOvertimeId);
	}

	public static void deleteLmisViewRegistrationOvertime(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteLmisViewRegistrationOvertime(lmisViewRegistrationOvertime);
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

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime getLmisViewRegistrationOvertime(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getLmisViewRegistrationOvertime(lmisViewRegistrationOvertimeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getLmisViewRegistrationOvertimes(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewRegistrationOvertimes(start, end);
	}

	public static int getLmisViewRegistrationOvertimesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewRegistrationOvertimesCount();
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime updateLmisViewRegistrationOvertime(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewRegistrationOvertime(lmisViewRegistrationOvertime);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime updateLmisViewRegistrationOvertime(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewRegistrationOvertime(lmisViewRegistrationOvertime,
			merge);
	}

	public static double getOtHourYesterday(int userId,
		java.util.Date requestedAt, int rootId)
		throws com.liferay.portal.SystemException {
		return getService().getOtHourYesterday(userId, requestedAt, rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqsByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeReqsByRootId(rootId);
	}

	public static int countRequestOfUID(int rootId, int userId)
		throws com.liferay.portal.SystemException {
		return getService().countRequestOfUID(rootId, userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqsByOrgId(
		java.util.Date date, int orgId)
		throws com.liferay.portal.SystemException {
		return getService().getListOverTimeReqsByOrgId(date, orgId);
	}

	public static int countRequestPending(int rootId, int userId)
		throws com.liferay.portal.SystemException {
		return getService().countRequestPending(rootId, userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqRoleUser(
		int userId, int rootId) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeReqRoleUser(userId, rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqRoleSpec(
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeReqRoleSpec(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqDetail(
		int rootId, int requestId) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeReqDetail(rootId, requestId);
	}

	public static boolean editOverTimeRequest(int rootId, int requestId,
		int requestBy, java.util.Date requestedAt,
		java.lang.String requestReason, int orgId, int requestDetailId,
		int userId, java.util.Date startTime, java.util.Date endTime,
		java.lang.String reasonDetail, double requestHour)
		throws com.liferay.portal.SystemException {
		return getService()
				   .editOverTimeRequest(rootId, requestId, requestBy,
			requestedAt, requestReason, orgId, requestDetailId, userId,
			startTime, endTime, reasonDetail, requestHour);
	}

	public static boolean addOverTimeRequest(int rootId, int requestId,
		int requestBy, java.util.Date requestedAt,
		java.lang.String requestReason, java.util.Date createdAt, int orgId,
		int userId, java.util.Date startTime, java.util.Date endTime,
		java.lang.String reasonDetail, double requestHour)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addOverTimeRequest(rootId, requestId, requestBy,
			requestedAt, requestReason, createdAt, orgId, userId, startTime,
			endTime, reasonDetail, requestHour);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getListApprovalByReqId(
		int rootId, int requestId) throws com.liferay.portal.SystemException {
		return getService().getListApprovalByReqId(rootId, requestId);
	}

	public static int findIdReq(int rootId, int approvedBy, int requestId)
		throws com.liferay.portal.SystemException {
		return getService().findIdReq(rootId, approvedBy, requestId);
	}

	public static boolean doApprove(int rootId, int orgId, int approvedBy,
		int requestId, boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException {
		return getService()
				   .doApprove(rootId, orgId, approvedBy, requestId, isApproved,
			reason);
	}

	public static boolean doApproveIt(int rootId, int orgId, int approvedBy,
		int requestId, boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException {
		return getService()
				   .doApproveIt(rootId, orgId, approvedBy, requestId,
			isApproved, reason);
	}

	public static java.util.ArrayList<Integer> getListOverTimeReqDetails(
		int rootId, int userId) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeReqDetails(rootId, userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqRoleManager(
		int rootId, int requestBy) throws com.liferay.portal.SystemException {
		return getService().getListOverTimeReqRoleManager(rootId, requestBy);
	}

	public static boolean deleteOverTimeReq(int rootId, int reqId) {
		return getService().deleteOverTimeReq(rootId, reqId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewRegistrationOvertimeLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewRegistrationOvertimeLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewRegistrationOvertimeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewRegistrationOvertimeLocalService service) {
		_service = service;
	}

	private static LmisViewRegistrationOvertimeLocalService _service;
}