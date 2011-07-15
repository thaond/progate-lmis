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
 * <a href="ProGateOrgCustomerLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerLocalServiceUtil {
	public static larion.progate.model.ProGateOrgCustomer addProGateOrgCustomer(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException {
		return getService().addProGateOrgCustomer(proGateOrgCustomer);
	}

	public static larion.progate.model.ProGateOrgCustomer createProGateOrgCustomer(
		java.lang.Integer ProGateOrgCustomerId) {
		return getService().createProGateOrgCustomer(ProGateOrgCustomerId);
	}

	public static void deleteProGateOrgCustomer(
		java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteProGateOrgCustomer(ProGateOrgCustomerId);
	}

	public static void deleteProGateOrgCustomer(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException {
		getService().deleteProGateOrgCustomer(proGateOrgCustomer);
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

	public static larion.progate.model.ProGateOrgCustomer getProGateOrgCustomer(
		java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProGateOrgCustomer(ProGateOrgCustomerId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getProGateOrgCustomers(start, end);
	}

	public static int getProGateOrgCustomersCount()
		throws com.liferay.portal.SystemException {
		return getService().getProGateOrgCustomersCount();
	}

	public static larion.progate.model.ProGateOrgCustomer updateProGateOrgCustomer(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException {
		return getService().updateProGateOrgCustomer(proGateOrgCustomer);
	}

	public static larion.progate.model.ProGateOrgCustomer updateProGateOrgCustomer(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateProGateOrgCustomer(proGateOrgCustomer, merge);
	}

	public static larion.progate.model.ProGateOrgCustomer createCustomerOrgProfile(
		java.lang.String customerName, java.lang.String description,
		int customerType, java.lang.String logo, java.lang.String website,
		boolean orgMap, java.lang.String orgMapUrl, int orgId)
		throws com.liferay.portal.SystemException {
		return getService()
				   .createCustomerOrgProfile(customerName, description,
			customerType, logo, website, orgMap, orgMapUrl, orgId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCusts(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getService().getProGateOrgCusts(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgPartners(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getService().getProGateOrgPartners(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getService().getProGateOrgCustomers(orgId, start, end);
	}

	public static int countProGateOrgCusts(int orgId)
		throws com.liferay.portal.SystemException {
		return getService().countProGateOrgCusts(orgId);
	}

	public static int countProGateOrgPartners(int orgId)
		throws com.liferay.portal.SystemException {
		return getService().countProGateOrgPartners(orgId);
	}

	public static int countProGateOrgCustomers(int orgId)
		throws com.liferay.portal.SystemException {
		return getService().countProGateOrgCustomers(orgId);
	}

	public static boolean validateCustName(java.lang.String customerName,
		int orgId) throws com.liferay.portal.SystemException {
		return getService().validateCustName(customerName, orgId);
	}

	public static boolean deleteProGateOrgCustomer(int cusId) {
		return getService().deleteProGateOrgCustomer(cusId);
	}

	public static void testErrors() {
		getService().testErrors();
	}

	public static void clearService() {
		_service = null;
	}

	public static ProGateOrgCustomerLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProGateOrgCustomerLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProGateOrgCustomerLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProGateOrgCustomerLocalService service) {
		_service = service;
	}

	private static ProGateOrgCustomerLocalService _service;
}