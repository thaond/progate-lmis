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
 * <a href="LmisOvertimeRequestsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeRequestsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisOvertimeRequests addLmisOvertimeRequests(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException {
		return getService().addLmisOvertimeRequests(lmisOvertimeRequests);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests createLmisOvertimeRequests(
		java.lang.Integer lmisOvertimeRequestsId) {
		return getService().createLmisOvertimeRequests(lmisOvertimeRequestsId);
	}

	public static void deleteLmisOvertimeRequests(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisOvertimeRequests(lmisOvertimeRequestsId);
	}

	public static void deleteLmisOvertimeRequests(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisOvertimeRequests(lmisOvertimeRequests);
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

	public static larion.progate.lmis.model.LmisOvertimeRequests getLmisOvertimeRequests(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisOvertimeRequests(lmisOvertimeRequestsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> getLmisOvertimeRequestses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisOvertimeRequestses(start, end);
	}

	public static int getLmisOvertimeRequestsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisOvertimeRequestsesCount();
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests updateLmisOvertimeRequests(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisOvertimeRequests(lmisOvertimeRequests);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests updateLmisOvertimeRequests(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisOvertimeRequests(lmisOvertimeRequests, merge);
	}

	public static int addOtRequest(int rootId, int orgId, int userId,
		java.lang.String otReason, java.util.Date regDate,
		java.util.Date reqDate, int[] arrUID, java.util.List arrReason,
		double[] arrTotal, java.util.List arrHM, java.util.List arrEndTime) {
		return getService()
				   .addOtRequest(rootId, orgId, userId, otReason, regDate,
			reqDate, arrUID, arrReason, arrTotal, arrHM, arrEndTime);
	}

	public static int editOtRequest(int rootId, int reqId,
		java.lang.String otReason, java.util.Date reqDate, int[] arrUID,
		java.util.List arrReason, double[] arrTotal, java.util.List arrHM,
		java.util.List arrEndTime) {
		return getService()
				   .editOtRequest(rootId, reqId, otReason, reqDate, arrUID,
			arrReason, arrTotal, arrHM, arrEndTime);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> filterTabManager(
		int rootId, int orgId, int userId, int status) {
		return getService().filterTabManager(rootId, orgId, userId, status);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterTabOther(
		int rootId, int orgId, int status) {
		return getService().filterTabOther(rootId, orgId, status);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterAll(
		int rootId, java.util.Date day, int userId, int status) {
		return getService().filterAll(rootId, day, userId, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisOvertimeRequestsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisOvertimeRequestsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisOvertimeRequestsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisOvertimeRequestsLocalService service) {
		_service = service;
	}

	private static LmisOvertimeRequestsLocalService _service;
}