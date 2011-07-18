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
 * <a href="ViewOrgUsersPermissionsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ViewOrgUsersPermissionsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions);

	public void cacheResult(
		java.util.List<larion.progate.model.ViewOrgUsersPermissions> viewOrgUsersPermissionses);

	public void clearCache();

	public larion.progate.model.ViewOrgUsersPermissions create(
		java.lang.String id);

	public larion.progate.model.ViewOrgUsersPermissions remove(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException;

	public larion.progate.model.ViewOrgUsersPermissions remove(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ViewOrgUsersPermissions update(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ViewOrgUsersPermissions update(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ViewOrgUsersPermissions updateImpl(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ViewOrgUsersPermissions findByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException;

	public larion.progate.model.ViewOrgUsersPermissions fetchByPrimaryKey(
		java.lang.String id) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByUserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ViewOrgUsersPermissions findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException;

	public larion.progate.model.ViewOrgUsersPermissions findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException;

	public larion.progate.model.ViewOrgUsersPermissions[] findByUserId_PrevAndNext(
		java.lang.String id, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ViewOrgUsersPermissions findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException;

	public larion.progate.model.ViewOrgUsersPermissions findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException;

	public larion.progate.model.ViewOrgUsersPermissions[] findByRootId_PrevAndNext(
		java.lang.String id, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ViewOrgUsersPermissions> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}