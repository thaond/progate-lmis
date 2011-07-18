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
 * <a href="ViewOrgUsersPermissionsLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ViewOrgUsersPermissionsLocalService {
	public larion.progate.model.ViewOrgUsersPermissions addViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ViewOrgUsersPermissions createViewOrgUsersPermissions(
		java.lang.String id);

	public void deleteViewOrgUsersPermissions(java.lang.String id)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.ViewOrgUsersPermissions getViewOrgUsersPermissions(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> getViewOrgUsersPermissionses(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getViewOrgUsersPermissionsesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ViewOrgUsersPermissions updateViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ViewOrgUsersPermissions updateViewOrgUsersPermissions(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findOrgPermissions(
		int rootId, int roleId, java.lang.String appName, int category)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findUsersPermissions(
		int rootId, int userId, java.lang.String appName, int category,
		int priority, boolean delegate)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRoleIdByUserId(java.lang.String appName, int category,
		int rootId, int orgId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<Integer> getListRoleIdByUserId(
		java.lang.String appName, int category, int rootId, int orgId,
		int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> getListPermissions(
		java.lang.String appName, int category, int rootId, int orgId,
		int userId, boolean isRoot)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean checkPermissions(java.lang.String appName, int category,
		int rootId, int orgId, int userId, boolean isRoot,
		java.lang.String perId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public int checkUserSpecialPermission(java.lang.String appName,
		int category, int rootId, int userId, java.lang.String perId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;
}