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
 * <a href="ProGateOrgsUsersPermissionsLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProGateOrgsUsersPermissionsLocalService {
	public larion.progate.model.ProGateOrgsUsersPermissions addProGateOrgsUsersPermissions(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgsUsersPermissions createProGateOrgsUsersPermissions(
		java.lang.Integer ProGateOrgsUsersPermissionsId);

	public void deleteProGateOrgsUsersPermissions(
		java.lang.Integer ProGateOrgsUsersPermissionsId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteProGateOrgsUsersPermissions(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ProGateOrgsUsersPermissions getProGateOrgsUsersPermissions(
		java.lang.Integer ProGateOrgsUsersPermissionsId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> getProGateOrgsUsersPermissionses(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProGateOrgsUsersPermissionsesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgsUsersPermissions updateProGateOrgsUsersPermissions(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgsUsersPermissions updateProGateOrgsUsersPermissions(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findGrantPermissions(
		int appId, int category, int orgId, int userId, java.lang.String perid)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> getListGrantPermissions(
		int appId, int category, int orgId, int userId, int pmId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean editGrantPermission(int appId, int category, int orgId,
		int userId,
		java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> userPermissions,
		int value, boolean isGrant, int pmId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean addProGateOrgsUsersPermission(java.lang.String appName,
		int category, int orgId, int userId,
		java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> userPermissions,
		int value, boolean isGrant)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean deleteProGateOrgsUsersPermission(java.lang.String appName,
		int category, int orgId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;
}