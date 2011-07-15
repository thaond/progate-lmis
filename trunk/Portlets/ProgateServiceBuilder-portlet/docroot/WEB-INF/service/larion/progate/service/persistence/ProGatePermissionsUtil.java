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
 * <a href="ProGatePermissionsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGatePermissionsUtil {
	public static void cacheResult(
		larion.progate.model.ProGatePermissions proGatePermissions) {
		getPersistence().cacheResult(proGatePermissions);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGatePermissions> proGatePermissionses) {
		getPersistence().cacheResult(proGatePermissionses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGatePermissions create(
		java.lang.String ProGatePermissionsId) {
		return getPersistence().create(ProGatePermissionsId);
	}

	public static larion.progate.model.ProGatePermissions remove(
		java.lang.String ProGatePermissionsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException {
		return getPersistence().remove(ProGatePermissionsId);
	}

	public static larion.progate.model.ProGatePermissions remove(
		larion.progate.model.ProGatePermissions proGatePermissions)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGatePermissions);
	}

	public static larion.progate.model.ProGatePermissions update(
		larion.progate.model.ProGatePermissions proGatePermissions)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGatePermissions);
	}

	public static larion.progate.model.ProGatePermissions update(
		larion.progate.model.ProGatePermissions proGatePermissions,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGatePermissions, merge);
	}

	public static larion.progate.model.ProGatePermissions updateImpl(
		larion.progate.model.ProGatePermissions proGatePermissions,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGatePermissions, merge);
	}

	public static larion.progate.model.ProGatePermissions findByPrimaryKey(
		java.lang.String ProGatePermissionsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException {
		return getPersistence().findByPrimaryKey(ProGatePermissionsId);
	}

	public static larion.progate.model.ProGatePermissions fetchByPrimaryKey(
		java.lang.String ProGatePermissionsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(ProGatePermissionsId);
	}

	public static java.util.List<larion.progate.model.ProGatePermissions> findByApplicationId(
		int applicationId) throws com.liferay.portal.SystemException {
		return getPersistence().findByApplicationId(applicationId);
	}

	public static java.util.List<larion.progate.model.ProGatePermissions> findByApplicationId(
		int applicationId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApplicationId(applicationId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGatePermissions> findByApplicationId(
		int applicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByApplicationId(applicationId, start, end, obc);
	}

	public static larion.progate.model.ProGatePermissions findByApplicationId_First(
		int applicationId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException {
		return getPersistence().findByApplicationId_First(applicationId, obc);
	}

	public static larion.progate.model.ProGatePermissions findByApplicationId_Last(
		int applicationId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException {
		return getPersistence().findByApplicationId_Last(applicationId, obc);
	}

	public static larion.progate.model.ProGatePermissions[] findByApplicationId_PrevAndNext(
		java.lang.String ProGatePermissionsId, int applicationId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGatePermissionsException {
		return getPersistence()
				   .findByApplicationId_PrevAndNext(ProGatePermissionsId,
			applicationId, obc);
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

	public static java.util.List<larion.progate.model.ProGatePermissions> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGatePermissions> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGatePermissions> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByApplicationId(int applicationId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByApplicationId(applicationId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByApplicationId(int applicationId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByApplicationId(applicationId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProGatePermissionsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGatePermissionsPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGatePermissionsPersistence _persistence;
}