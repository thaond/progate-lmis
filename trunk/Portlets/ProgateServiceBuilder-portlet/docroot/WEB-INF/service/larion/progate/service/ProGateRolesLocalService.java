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
 * <a href="ProGateRolesLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProGateRolesLocalService {
	public larion.progate.model.ProGateRoles addProGateRoles(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles createProGateRoles(
		java.lang.Integer roleId);

	public void deleteProGateRoles(java.lang.Integer roleId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteProGateRoles(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProGateRoles getProGateRoles(
		java.lang.Integer roleId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateRoles> getProGateRoleses(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProGateRolesesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles updateProGateRoles(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles updateProGateRoles(
		larion.progate.model.ProGateRoles proGateRoles, boolean merge)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getRoleOfUserInOrg(int userId, int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProGateAdminRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProGateUserRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOrgMemberRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOrgAdminRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGuestRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getManagerRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBodRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStaffOfRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMemberOfRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOwnerRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateRoles> getListRoles(
		int type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateRoles> getListRolesOfChildOrg();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateRoles> getListRolesOfRootOrg();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateRoles> getListRolesByOrgId(
		int orgId);
}