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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;

/**
 * <a href="ProGateOrgCustomerLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProGateOrgCustomerLocalService {
	public larion.progate.model.ProGateOrgCustomer addProGateOrgCustomer(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer createProGateOrgCustomer(
		java.lang.Integer ProGateOrgCustomerId);

	public void deleteProGateOrgCustomer(java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteProGateOrgCustomer(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProGateOrgCustomer getProGateOrgCustomer(
		java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProGateOrgCustomersCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer updateProGateOrgCustomer(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer updateProGateOrgCustomer(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer createCustomerOrgProfile(
		java.lang.String customerName, java.lang.String description,
		int customerType, java.lang.String logo, java.lang.String website,
		boolean orgMap, java.lang.String orgMapUrl, int orgId)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCusts(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgPartners(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public int countProGateOrgCusts(int orgId)
		throws com.liferay.portal.SystemException;

	public int countProGateOrgPartners(int orgId)
		throws com.liferay.portal.SystemException;

	public int countProGateOrgCustomers(int orgId)
		throws com.liferay.portal.SystemException;

	public boolean validateCustName(java.lang.String customerName, int orgId)
		throws com.liferay.portal.SystemException;

	public boolean deleteProGateOrgCustomer(int cusId);

	public void testErrors();
}