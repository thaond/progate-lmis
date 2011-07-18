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

package larion.progate.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="ProGateOrgCustomerRepresenterLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerRepresenterLocalServiceUtil {
	public static larion.progate.model.ProGateOrgCustomerRepresenter addProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addProGateOrgCustomerRepresenter(proGateOrgCustomerRepresenter);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter createProGateOrgCustomerRepresenter(
		java.lang.Integer ProGateOrgCustomerRepresenterId) {
		return getService()
				   .createProGateOrgCustomerRepresenter(ProGateOrgCustomerRepresenterId);
	}

	public static void deleteProGateOrgCustomerRepresenter(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService()
			.deleteProGateOrgCustomerRepresenter(ProGateOrgCustomerRepresenterId);
	}

	public static void deleteProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException {
		getService()
			.deleteProGateOrgCustomerRepresenter(proGateOrgCustomerRepresenter);
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

	public static larion.progate.model.ProGateOrgCustomerRepresenter getProGateOrgCustomerRepresenter(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .getProGateOrgCustomerRepresenter(ProGateOrgCustomerRepresenterId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateOrgCustomerRepresenters(start, end);
	}

	public static int getProGateOrgCustomerRepresentersCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateOrgCustomerRepresentersCount();
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter updateProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateOrgCustomerRepresenter(proGateOrgCustomerRepresenter);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter updateProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService()
				   .updateProGateOrgCustomerRepresenter(proGateOrgCustomerRepresenter,
			merge);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter createCustRepresenter(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String role, java.lang.String description, int customerId,
		int orgId) {
		return getService()
				   .createCustRepresenter(firstName, lastName, role,
			description, customerId, orgId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getListCustRepresenterByOrgId(
		int orgId, int start, int end, boolean hasDescription) {
		return getService()
				   .getListCustRepresenterByOrgId(orgId, start, end,
			hasDescription);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getListCustRepresenterByCustId(
		int custId, int start, int end, boolean hasDescription) {
		return getService()
				   .getListCustRepresenterByCustId(custId, start, end,
			hasDescription);
	}

	public static int cListCustRepresenterByCustId(int custId,
		boolean hasDescription) {
		return getService().cListCustRepresenterByCustId(custId, hasDescription);
	}

	public static int countListCustRepresenterByOrgId(int orgId,
		boolean hasDescription) {
		return getService()
				   .countListCustRepresenterByOrgId(orgId, hasDescription);
	}

	public static int countListCustRepresenterByCustId(int customerId) {
		return getService().countListCustRepresenterByCustId(customerId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateOrgCustomerRepresenterLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateOrgCustomerRepresenterLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateOrgCustomerRepresenterLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateOrgCustomerRepresenterLocalService service) {
		_service = service;
	}

	private static ProGateOrgCustomerRepresenterLocalService _service;
}