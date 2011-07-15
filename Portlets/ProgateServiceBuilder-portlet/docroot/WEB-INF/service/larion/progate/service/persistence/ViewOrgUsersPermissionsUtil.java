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
 * <a href="ViewOrgUsersPermissionsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewOrgUsersPermissionsUtil {
	public static void cacheResult(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions) {
		getPersistence().cacheResult(viewOrgUsersPermissions);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ViewOrgUsersPermissions> viewOrgUsersPermissionses) {
		getPersistence().cacheResult(viewOrgUsersPermissionses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ViewOrgUsersPermissions create(
		java.lang.String id) {
		return getPersistence().create(id);
	}

	public static larion.progate.model.ViewOrgUsersPermissions remove(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException {
		return getPersistence().remove(id);
	}

	public static larion.progate.model.ViewOrgUsersPermissions remove(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(viewOrgUsersPermissions);
	}

	public static larion.progate.model.ViewOrgUsersPermissions update(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(viewOrgUsersPermissions);
	}

	public static larion.progate.model.ViewOrgUsersPermissions update(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(viewOrgUsersPermissions, merge);
	}

	public static larion.progate.model.ViewOrgUsersPermissions updateImpl(
		larion.progate.model.ViewOrgUsersPermissions viewOrgUsersPermissions,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(viewOrgUsersPermissions, merge);
	}

	public static larion.progate.model.ViewOrgUsersPermissions findByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException {
		return getPersistence().findByPrimaryKey(id);
	}

	public static larion.progate.model.ViewOrgUsersPermissions fetchByPrimaryKey(
		java.lang.String id) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.model.ViewOrgUsersPermissions findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.model.ViewOrgUsersPermissions findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.model.ViewOrgUsersPermissions[] findByUserId_PrevAndNext(
		java.lang.String id, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException {
		return getPersistence().findByUserId_PrevAndNext(id, userId, obc);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.model.ViewOrgUsersPermissions findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.model.ViewOrgUsersPermissions findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.model.ViewOrgUsersPermissions[] findByRootId_PrevAndNext(
		java.lang.String id, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewOrgUsersPermissionsException {
		return getPersistence().findByRootId_PrevAndNext(id, rootId, obc);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ViewOrgUsersPermissions> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByUserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(userId);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByUserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(userId);
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ViewOrgUsersPermissionsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ViewOrgUsersPermissionsPersistence persistence) {
		_persistence = persistence;
	}

	private static ViewOrgUsersPermissionsPersistence _persistence;
}