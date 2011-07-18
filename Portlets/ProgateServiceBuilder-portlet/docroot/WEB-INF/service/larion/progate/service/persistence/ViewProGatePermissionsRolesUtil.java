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
 * <a href="ViewProGatePermissionsRolesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewProGatePermissionsRolesUtil {
	public static void cacheResult(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles) {
		getPersistence().cacheResult(viewProGatePermissionsRoles);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ViewProGatePermissionsRoles> viewProGatePermissionsRoleses) {
		getPersistence().cacheResult(viewProGatePermissionsRoleses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ViewProGatePermissionsRoles create(
		java.lang.String ProGatePermissionsRolesId) {
		return getPersistence().create(ProGatePermissionsRolesId);
	}

	public static larion.progate.model.ViewProGatePermissionsRoles remove(
		java.lang.String ProGatePermissionsRolesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewProGatePermissionsRolesException {
		return getPersistence().remove(ProGatePermissionsRolesId);
	}

	public static larion.progate.model.ViewProGatePermissionsRoles remove(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(viewProGatePermissionsRoles);
	}

	public static larion.progate.model.ViewProGatePermissionsRoles update(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(viewProGatePermissionsRoles);
	}

	public static larion.progate.model.ViewProGatePermissionsRoles update(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(viewProGatePermissionsRoles, merge);
	}

	public static larion.progate.model.ViewProGatePermissionsRoles updateImpl(
		larion.progate.model.ViewProGatePermissionsRoles viewProGatePermissionsRoles,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(viewProGatePermissionsRoles, merge);
	}

	public static larion.progate.model.ViewProGatePermissionsRoles findByPrimaryKey(
		java.lang.String ProGatePermissionsRolesId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchViewProGatePermissionsRolesException {
		return getPersistence().findByPrimaryKey(ProGatePermissionsRolesId);
	}

	public static larion.progate.model.ViewProGatePermissionsRoles fetchByPrimaryKey(
		java.lang.String ProGatePermissionsRolesId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(ProGatePermissionsRolesId);
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

	public static java.util.List<larion.progate.model.ViewProGatePermissionsRoles> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ViewProGatePermissionsRoles> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ViewProGatePermissionsRoles> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ViewProGatePermissionsRolesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		ViewProGatePermissionsRolesPersistence persistence) {
		_persistence = persistence;
	}

	private static ViewProGatePermissionsRolesPersistence _persistence;
}