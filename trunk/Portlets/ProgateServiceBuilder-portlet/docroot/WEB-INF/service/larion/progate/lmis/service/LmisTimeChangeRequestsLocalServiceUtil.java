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
 * <a href="LmisTimeChangeRequestsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeRequestsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisTimeChangeRequests addLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException {
		return getService().addLmisTimeChangeRequests(lmisTimeChangeRequests);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests createLmisTimeChangeRequests(
		java.lang.Integer lmisTimeChangeRequestId) {
		return getService().createLmisTimeChangeRequests(lmisTimeChangeRequestId);
	}

	public static void deleteLmisTimeChangeRequests(
		java.lang.Integer lmisTimeChangeRequestId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisTimeChangeRequests(lmisTimeChangeRequestId);
	}

	public static void deleteLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisTimeChangeRequests(lmisTimeChangeRequests);
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

	public static larion.progate.lmis.model.LmisTimeChangeRequests getLmisTimeChangeRequests(
		java.lang.Integer lmisTimeChangeRequestId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisTimeChangeRequests(lmisTimeChangeRequestId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> getLmisTimeChangeRequestses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisTimeChangeRequestses(start, end);
	}

	public static int getLmisTimeChangeRequestsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisTimeChangeRequestsesCount();
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests updateLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisTimeChangeRequests(lmisTimeChangeRequests);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests updateLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisTimeChangeRequests(lmisTimeChangeRequests, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> getListRequestTimeChangeOf(
		int rootId, int userId) throws com.liferay.portal.SystemException {
		return getService().getListRequestTimeChangeOf(rootId, userId);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests getDetailRequestTimeChange(
		int rootId, int requestId) throws com.liferay.portal.SystemException {
		return getService().getDetailRequestTimeChange(rootId, requestId);
	}

	public static java.lang.String getContentApprovals(int rootId, int requestId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getContentApprovals(rootId, requestId);
	}

	public static boolean editRequestTimeChange(int rootId, int requestId,
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date monStartTime, java.util.Date monEndTime,
		java.util.Date tueStartDate, java.util.Date tueEndTime,
		java.util.Date wedStartTime, java.util.Date wedEndTime,
		java.util.Date thuStartTime, java.util.Date thuEndTime,
		java.util.Date friStartTime, java.util.Date friEndTime,
		java.util.Date satStartTime, java.util.Date satEndTime,
		java.lang.String requestReason)
		throws com.liferay.portal.SystemException {
		return getService()
				   .editRequestTimeChange(rootId, requestId, startDate,
			endDate, monStartTime, monEndTime, tueStartDate, tueEndTime,
			wedStartTime, wedEndTime, thuStartTime, thuEndTime, friStartTime,
			friEndTime, satStartTime, satEndTime, requestReason);
	}

	public static boolean addRequestTimeChange(int rootId, int userId,
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date monStartTime, java.util.Date monEndTime,
		java.util.Date tueStartTime, java.util.Date tueEndTime,
		java.util.Date wedStartTime, java.util.Date wedEndTime,
		java.util.Date thuStartTime, java.util.Date thuEndTime,
		java.util.Date friStartTime, java.util.Date friEndTime,
		java.util.Date satStartTime, java.util.Date satEndTime,
		java.lang.String requestReason)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addRequestTimeChange(rootId, userId, startDate, endDate,
			monStartTime, monEndTime, tueStartTime, tueEndTime, wedStartTime,
			wedEndTime, thuStartTime, thuEndTime, friStartTime, friEndTime,
			satStartTime, satEndTime, requestReason);
	}

	public static boolean doApproveIt(int rootId, int approvedBy,
		int requestId, boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException {
		return getService()
				   .doApproveIt(rootId, approvedBy, requestId, isApproved,
			reason);
	}

	public static int deleteChangeTimeReq(int rootId, int userId, int reqId)
		throws com.liferay.portal.SystemException {
		return getService().deleteChangeTimeReq(rootId, userId, reqId);
	}

	public static int countTimeChangeReqs(int rootId, int userId) {
		return getService().countTimeChangeReqs(rootId, userId);
	}

	public static java.lang.String getMaxTimeChangeReqEndDate(int rootId,
		int userId) {
		return getService().getMaxTimeChangeReqEndDate(rootId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisTimeChangeRequestsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisTimeChangeRequestsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisTimeChangeRequestsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisTimeChangeRequestsLocalService service) {
		_service = service;
	}

	private static LmisTimeChangeRequestsLocalService _service;
}