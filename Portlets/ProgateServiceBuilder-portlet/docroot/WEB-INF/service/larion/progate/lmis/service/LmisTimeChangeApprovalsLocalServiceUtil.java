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
 * <a href="LmisTimeChangeApprovalsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeApprovalsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisTimeChangeApprovals addLmisTimeChangeApprovals(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws com.liferay.portal.SystemException {
		return getService().addLmisTimeChangeApprovals(lmisTimeChangeApprovals);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals createLmisTimeChangeApprovals(
		java.lang.Integer lmisTimeChangeApprovalId) {
		return getService()
				   .createLmisTimeChangeApprovals(lmisTimeChangeApprovalId);
	}

	public static void deleteLmisTimeChangeApprovals(
		java.lang.Integer lmisTimeChangeApprovalId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisTimeChangeApprovals(lmisTimeChangeApprovalId);
	}

	public static void deleteLmisTimeChangeApprovals(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisTimeChangeApprovals(lmisTimeChangeApprovals);
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

	public static larion.progate.lmis.model.LmisTimeChangeApprovals getLmisTimeChangeApprovals(
		java.lang.Integer lmisTimeChangeApprovalId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisTimeChangeApprovals(lmisTimeChangeApprovalId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> getLmisTimeChangeApprovalses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisTimeChangeApprovalses(start, end);
	}

	public static int getLmisTimeChangeApprovalsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisTimeChangeApprovalsesCount();
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals updateLmisTimeChangeApprovals(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisTimeChangeApprovals(lmisTimeChangeApprovals);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals updateLmisTimeChangeApprovals(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisTimeChangeApprovals(lmisTimeChangeApprovals, merge);
	}

	public static int findIdReq(int rootId, int approvedBy, int requestId)
		throws com.liferay.portal.SystemException {
		return getService().findIdReq(rootId, approvedBy, requestId);
	}

	public static boolean doApprove(int rootId, int approvedBy, int requestId,
		boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException {
		return getService()
				   .doApprove(rootId, approvedBy, requestId, isApproved, reason);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> getListApprovalByReqId(
		int rootId, int requestId) throws com.liferay.portal.SystemException {
		return getService().getListApprovalByReqId(rootId, requestId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisTimeChangeApprovalsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisTimeChangeApprovalsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisTimeChangeApprovalsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisTimeChangeApprovalsLocalService service) {
		_service = service;
	}

	private static LmisTimeChangeApprovalsLocalService _service;
}