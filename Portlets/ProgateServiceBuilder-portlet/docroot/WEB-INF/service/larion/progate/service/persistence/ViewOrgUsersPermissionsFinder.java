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

package larion.progate.service.persistence;

/**
 * <a href="ViewOrgUsersPermissionsFinder.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ViewOrgUsersPermissionsFinder {
	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findOrgPermissions(
		int rootId, int roleId, int appId, int category)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findUsersPermissions(
		int rootId, int userId, int appId, int category, int priority,
		boolean delegate)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGatePermissions> findProGatePermissions(
		int appId, int category)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewProGatePermissionsRoles> findProGatePermissionsRoles(
		int appId, int category, int roleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> getListPermissions(
		int appId, int category, int rootId, int orgId, int userId,
		boolean isRoot)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean checkPermissions(int appId, int category, int rootId,
		int orgId, int userId, boolean isRoot, java.lang.String perId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findRoleByUserId(
		int appId, int category, int rootId, int orgId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;
}