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
 * <a href="LmisViewTimeChangeReqsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewTimeChangeReqsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisViewTimeChangeReqs addLmisViewTimeChangeReqs(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs)
		throws com.liferay.portal.SystemException {
		return getService().addLmisViewTimeChangeReqs(lmisViewTimeChangeReqs);
	}

	public static larion.progate.lmis.model.LmisViewTimeChangeReqs createLmisViewTimeChangeReqs(
		java.lang.Integer lmisViewTimeChangeReqId) {
		return getService().createLmisViewTimeChangeReqs(lmisViewTimeChangeReqId);
	}

	public static void deleteLmisViewTimeChangeReqs(
		java.lang.Integer lmisViewTimeChangeReqId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisViewTimeChangeReqs(lmisViewTimeChangeReqId);
	}

	public static void deleteLmisViewTimeChangeReqs(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisViewTimeChangeReqs(lmisViewTimeChangeReqs);
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

	public static larion.progate.lmis.model.LmisViewTimeChangeReqs getLmisViewTimeChangeReqs(
		java.lang.Integer lmisViewTimeChangeReqId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisViewTimeChangeReqs(lmisViewTimeChangeReqId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> getLmisViewTimeChangeReqses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisViewTimeChangeReqses(start, end);
	}

	public static int getLmisViewTimeChangeReqsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisViewTimeChangeReqsesCount();
	}

	public static larion.progate.lmis.model.LmisViewTimeChangeReqs updateLmisViewTimeChangeReqs(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisViewTimeChangeReqs(lmisViewTimeChangeReqs);
	}

	public static larion.progate.lmis.model.LmisViewTimeChangeReqs updateLmisViewTimeChangeReqs(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateLmisViewTimeChangeReqs(lmisViewTimeChangeReqs, merge);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> getListReqsByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getService().getListReqsByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> getListTimeChangeReqs(
		int rootId, int approvalBy) throws com.liferay.portal.SystemException {
		return getService().getListTimeChangeReqs(rootId, approvalBy);
	}

	public static larion.progate.lmis.model.LmisViewTimeChangeReqs getDetailViewReqTimeChange(
		int rootId, int requestId) throws com.liferay.portal.SystemException {
		return getService().getDetailViewReqTimeChange(rootId, requestId);
	}

	public static int countRequestOfUID(int rootId, int userId)
		throws com.liferay.portal.SystemException {
		return getService().countRequestOfUID(rootId, userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> filterByStatusTabManager(
		int rootId, int userId, int status) {
		return getService().filterByStatusTabManager(rootId, userId, status);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> filterByStatusTabOther(
		int rootId, int status) {
		return getService().filterByStatusTabOther(rootId, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisViewTimeChangeReqsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisViewTimeChangeReqsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisViewTimeChangeReqsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisViewTimeChangeReqsLocalService service) {
		_service = service;
	}

	private static LmisViewTimeChangeReqsLocalService _service;
}