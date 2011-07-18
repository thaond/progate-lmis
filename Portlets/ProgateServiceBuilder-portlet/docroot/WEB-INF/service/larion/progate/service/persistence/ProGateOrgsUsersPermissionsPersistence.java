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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="ProGateOrgsUsersPermissionsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateOrgsUsersPermissionsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> proGateOrgsUsersPermissionses);

	public void clearCache();

	public larion.progate.model.ProGateOrgsUsersPermissions create(
		java.lang.Integer ProGateOrgsUsersPermissionsId);

	public larion.progate.model.ProGateOrgsUsersPermissions remove(
		java.lang.Integer ProGateOrgsUsersPermissionsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgsUsersPermissionsException;

	public larion.progate.model.ProGateOrgsUsersPermissions remove(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgsUsersPermissions update(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgsUsersPermissions update(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgsUsersPermissions updateImpl(
		larion.progate.model.ProGateOrgsUsersPermissions proGateOrgsUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgsUsersPermissions findByPrimaryKey(
		java.lang.Integer ProGateOrgsUsersPermissionsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgsUsersPermissionsException;

	public larion.progate.model.ProGateOrgsUsersPermissions fetchByPrimaryKey(
		java.lang.Integer ProGateOrgsUsersPermissionsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findByOrgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findByOrgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findByOrgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgsUsersPermissions findByOrgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgsUsersPermissionsException;

	public larion.progate.model.ProGateOrgsUsersPermissions findByOrgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgsUsersPermissionsException;

	public larion.progate.model.ProGateOrgsUsersPermissions[] findByOrgId_PrevAndNext(
		java.lang.Integer ProGateOrgsUsersPermissionsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgsUsersPermissionsException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findByUserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgsUsersPermissions findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgsUsersPermissionsException;

	public larion.progate.model.ProGateOrgsUsersPermissions findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgsUsersPermissionsException;

	public larion.progate.model.ProGateOrgsUsersPermissions[] findByUserId_PrevAndNext(
		java.lang.Integer ProGateOrgsUsersPermissionsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgsUsersPermissionsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgsUsersPermissions> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOrgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOrgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}