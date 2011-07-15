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

package larion.progate.lmis.service.persistence;

/**
 * <a href="LmisViewOrgUserRolesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOrgUserRolesUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewOrgUserRoles lmisViewOrgUserRoles) {
		getPersistence().cacheResult(lmisViewOrgUserRoles);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> lmisViewOrgUserRoleses) {
		getPersistence().cacheResult(lmisViewOrgUserRoleses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles create(
		java.lang.Integer lmisViewOrgUserRolesId) {
		return getPersistence().create(lmisViewOrgUserRolesId);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles remove(
		java.lang.Integer lmisViewOrgUserRolesId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence().remove(lmisViewOrgUserRolesId);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles remove(
		larion.progate.lmis.model.LmisViewOrgUserRoles lmisViewOrgUserRoles)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewOrgUserRoles);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles update(
		larion.progate.lmis.model.LmisViewOrgUserRoles lmisViewOrgUserRoles)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewOrgUserRoles);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles update(
		larion.progate.lmis.model.LmisViewOrgUserRoles lmisViewOrgUserRoles,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewOrgUserRoles, merge);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles updateImpl(
		larion.progate.lmis.model.LmisViewOrgUserRoles lmisViewOrgUserRoles,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewOrgUserRoles, merge);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles findByPrimaryKey(
		java.lang.Integer lmisViewOrgUserRolesId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence().findByPrimaryKey(lmisViewOrgUserRolesId);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles fetchByPrimaryKey(
		java.lang.Integer lmisViewOrgUserRolesId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewOrgUserRolesId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewOrgUserRolesId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewOrgUserRolesId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findByUserID(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence().findByUserID_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence().findByUserID_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles[] findByUserID_PrevAndNext(
		java.lang.Integer lmisViewOrgUserRolesId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence()
				   .findByUserID_PrevAndNext(lmisViewOrgUserRolesId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOrgUserRoles[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewOrgUserRolesId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOrgUserRolesException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisViewOrgUserRolesId, orgId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOrgUserRoles> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByUserID(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserID(userId);
	}

	public static void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgID(orgId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByUserID(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserID(userId);
	}

	public static int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgID(orgId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewOrgUserRolesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewOrgUserRolesPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewOrgUserRolesPersistence _persistence;
}