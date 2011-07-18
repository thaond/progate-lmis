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
 * <a href="LmisAbsenceRequestsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceRequestsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisAbsenceRequests addLmisAbsenceRequests(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException {
		return getService().addLmisAbsenceRequests(lmisAbsenceRequests);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests createLmisAbsenceRequests(
		java.lang.Integer lmisAbsenceRequestsId) {
		return getService().createLmisAbsenceRequests(lmisAbsenceRequestsId);
	}

	public static void deleteLmisAbsenceRequests(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisAbsenceRequests(lmisAbsenceRequestsId);
	}

	public static void deleteLmisAbsenceRequests(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisAbsenceRequests(lmisAbsenceRequests);
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

	public static larion.progate.lmis.model.LmisAbsenceRequests getLmisAbsenceRequests(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisAbsenceRequests(lmisAbsenceRequestsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisAbsenceRequestses(start, end);
	}

	public static int getLmisAbsenceRequestsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisAbsenceRequestsesCount();
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests updateLmisAbsenceRequests(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisAbsenceRequests(lmisAbsenceRequests);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests updateLmisAbsenceRequests(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisAbsenceRequests(lmisAbsenceRequests, merge);
	}

	public static java.lang.String funcNameAbsence(int absenceId)
		throws com.liferay.portal.SystemException {
		return getService().funcNameAbsence(absenceId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getListAbsenceReqUser(
		int rootId, int userId) {
		return getService().getListAbsenceReqUser(rootId, userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getListAbsenceReqRolePmOrBod(
		int rootId, int userId) {
		return getService().getListAbsenceReqRolePmOrBod(rootId, userId);
	}

	public static int countRequestPending(int rootId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().countRequestPending(rootId, userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getListAbsenceReqRoleSpec(
		int rootId) {
		return getService().getListAbsenceReqRoleSpec(rootId);
	}

	public static int addAbsenceReq(int rootId, int userId,
		java.util.Date startDate, java.util.Date endDate, int startSession,
		int endSession, java.lang.String requestReason,
		java.lang.String absenceType, int absenceId)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addAbsenceReq(rootId, userId, startDate, endDate,
			startSession, endSession, requestReason, absenceType, absenceId);
	}

	public static int editAbsenceReq(int reqId, java.util.Date startDate,
		java.util.Date endDate, int startSession, int endSession,
		java.lang.String requestReason, java.lang.String absenceType,
		int absenceId) throws com.liferay.portal.SystemException {
		return getService()
				   .editAbsenceReq(reqId, startDate, endDate, startSession,
			endSession, requestReason, absenceType, absenceId);
	}

	public static boolean deleteAbsenceReq(int rootId, int userId, int absenceId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().deleteAbsenceReq(rootId, userId, absenceId);
	}

	public static boolean doApprove(int userId, int reqId, boolean isApprove,
		java.lang.String reasonApprove)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().doApprove(userId, reqId, isApprove, reasonApprove);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests getDetailAbsenceReq(
		int rootId, int userId, int absenceId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getDetailAbsenceReq(rootId, userId, absenceId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> getListAbsenceTypeOfRoot(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getListAbsenceTypeOfRoot(rootId);
	}

	public static java.lang.String getContentApprove(int absenceId)
		throws com.liferay.portal.SystemException {
		return getService().getContentApprove(absenceId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getListRequestApprovedBy(
		int rootId, int userId) {
		return getService().getListRequestApprovedBy(rootId, userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getStatisticForms(
		int rootId, java.util.Date dayValue) {
		return getService().getStatisticForms(rootId, dayValue);
	}

	public static int checkAbsenceTypeSpec(int rootId, int absenceId) {
		return getService().checkAbsenceTypeSpec(rootId, absenceId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> getListAbsenceOfRootId(
		int rootId) {
		return getService().getListAbsenceOfRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> filterTabManager(
		int rootId, int userId, int absType, int status) {
		return getService().filterTabManager(rootId, userId, absType, status);
	}

	public static boolean addUnexpectedAbsenceReq(int rootId, int attendanceId,
		int session, java.lang.String requestReason) {
		return getService()
				   .addUnexpectedAbsenceReq(rootId, attendanceId, session,
			requestReason);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisAbsenceRequestsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisAbsenceRequestsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisAbsenceRequestsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisAbsenceRequestsLocalService service) {
		_service = service;
	}

	private static LmisAbsenceRequestsLocalService _service;
}