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
 * <a href="ProGateRolesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateRolesUtil {
	public static void cacheResult(
		larion.progate.model.ProGateRoles proGateRoles) {
		getPersistence().cacheResult(proGateRoles);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateRoles> proGateRoleses) {
		getPersistence().cacheResult(proGateRoleses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateRoles create(
		java.lang.Integer roleId) {
		return getPersistence().create(roleId);
	}

	public static larion.progate.model.ProGateRoles remove(
		java.lang.Integer roleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().remove(roleId);
	}

	public static larion.progate.model.ProGateRoles remove(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateRoles);
	}

	public static larion.progate.model.ProGateRoles update(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateRoles);
	}

	public static larion.progate.model.ProGateRoles update(
		larion.progate.model.ProGateRoles proGateRoles, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateRoles, merge);
	}

	public static larion.progate.model.ProGateRoles updateImpl(
		larion.progate.model.ProGateRoles proGateRoles, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateRoles, merge);
	}

	public static larion.progate.model.ProGateRoles findByPrimaryKey(
		java.lang.Integer roleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findByPrimaryKey(roleId);
	}

	public static larion.progate.model.ProGateRoles fetchByPrimaryKey(
		java.lang.Integer roleId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(roleId);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findByroleType(
		int roleType) throws com.liferay.portal.SystemException {
		return getPersistence().findByroleType(roleType);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findByroleType(
		int roleType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByroleType(roleType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findByroleType(
		int roleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByroleType(roleType, start, end, obc);
	}

	public static larion.progate.model.ProGateRoles findByroleType_First(
		int roleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findByroleType_First(roleType, obc);
	}

	public static larion.progate.model.ProGateRoles findByroleType_Last(
		int roleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findByroleType_Last(roleType, obc);
	}

	public static larion.progate.model.ProGateRoles[] findByroleType_PrevAndNext(
		java.lang.Integer roleId, int roleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findByroleType_PrevAndNext(roleId, roleType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end, obc);
	}

	public static larion.progate.model.ProGateRoles findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findByname_First(name, obc);
	}

	public static larion.progate.model.ProGateRoles findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findByname_Last(name, obc);
	}

	public static larion.progate.model.ProGateRoles[] findByname_PrevAndNext(
		java.lang.Integer roleId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findByname_PrevAndNext(roleId, name, obc);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findBypriority(
		int priority) throws com.liferay.portal.SystemException {
		return getPersistence().findBypriority(priority);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findBypriority(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriority(priority, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findBypriority(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBypriority(priority, start, end, obc);
	}

	public static larion.progate.model.ProGateRoles findBypriority_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findBypriority_First(priority, obc);
	}

	public static larion.progate.model.ProGateRoles findBypriority_Last(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findBypriority_Last(priority, obc);
	}

	public static larion.progate.model.ProGateRoles[] findBypriority_PrevAndNext(
		java.lang.Integer roleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException {
		return getPersistence().findBypriority_PrevAndNext(roleId, priority, obc);
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

	public static java.util.List<larion.progate.model.ProGateRoles> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateRoles> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByroleType(int roleType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByroleType(roleType);
	}

	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByname(name);
	}

	public static void removeBypriority(int priority)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBypriority(priority);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByroleType(int roleType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByroleType(roleType);
	}

	public static int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByname(name);
	}

	public static int countBypriority(int priority)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBypriority(priority);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProGateRolesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateRolesPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateRolesPersistence _persistence;
}