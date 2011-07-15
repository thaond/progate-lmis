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
 * <a href="ProGateOrgCustomerRepresenterLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProGateOrgCustomerRepresenterLocalService {
	public larion.progate.model.ProGateOrgCustomerRepresenter addProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter createProGateOrgCustomerRepresenter(
		java.lang.Integer ProGateOrgCustomerRepresenterId);

	public void deleteProGateOrgCustomerRepresenter(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProGateOrgCustomerRepresenter getProGateOrgCustomerRepresenter(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProGateOrgCustomerRepresentersCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter updateProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter updateProGateOrgCustomerRepresenter(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter createCustRepresenter(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String role, java.lang.String description, int customerId,
		int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getListCustRepresenterByOrgId(
		int orgId, int start, int end, boolean hasDescription);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getListCustRepresenterByCustId(
		int custId, int start, int end, boolean hasDescription);

	public int cListCustRepresenterByCustId(int custId, boolean hasDescription);

	public int countListCustRepresenterByOrgId(int orgId, boolean hasDescription);

	public int countListCustRepresenterByCustId(int customerId);
}