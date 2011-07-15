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
 * <a href="ProGateUserApplicationsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateUserApplicationsUtil {
	public static void cacheResult(
		larion.progate.model.ProGateUserApplications proGateUserApplications) {
		getPersistence().cacheResult(proGateUserApplications);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateUserApplications> proGateUserApplicationses) {
		getPersistence().cacheResult(proGateUserApplicationses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateUserApplications create(
		java.lang.Integer ProGateUserApplicationsId) {
		return getPersistence().create(ProGateUserApplicationsId);
	}

	public static larion.progate.model.ProGateUserApplications remove(
		java.lang.Integer ProGateUserApplicationsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().remove(ProGateUserApplicationsId);
	}

	public static larion.progate.model.ProGateUserApplications remove(
		larion.progate.model.ProGateUserApplications proGateUserApplications)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateUserApplications);
	}

	public static larion.progate.model.ProGateUserApplications update(
		larion.progate.model.ProGateUserApplications proGateUserApplications)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateUserApplications);
	}

	public static larion.progate.model.ProGateUserApplications update(
		larion.progate.model.ProGateUserApplications proGateUserApplications,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateUserApplications, merge);
	}

	public static larion.progate.model.ProGateUserApplications updateImpl(
		larion.progate.model.ProGateUserApplications proGateUserApplications,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateUserApplications, merge);
	}

	public static larion.progate.model.ProGateUserApplications findByPrimaryKey(
		java.lang.Integer ProGateUserApplicationsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByPrimaryKey(ProGateUserApplicationsId);
	}

	public static larion.progate.model.ProGateUserApplications fetchByPrimaryKey(
		java.lang.Integer ProGateUserApplicationsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(ProGateUserApplicationsId);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByuserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByuserId(userId);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByuserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserId(userId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByuserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserId(userId, start, end, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByuserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByuserId_First(userId, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByuserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByuserId_Last(userId, obc);
	}

	public static larion.progate.model.ProGateUserApplications[] findByuserId_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence()
				   .findByuserId_PrevAndNext(ProGateUserApplicationsId, userId,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByorgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByorgId_First(orgId, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByorgId_Last(orgId, obc);
	}

	public static larion.progate.model.ProGateUserApplications[] findByorgId_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence()
				   .findByorgId_PrevAndNext(ProGateUserApplicationsId, orgId,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByappsId(
		int appsId) throws com.liferay.portal.SystemException {
		return getPersistence().findByappsId(appsId);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByappsId(
		int appsId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByappsId(appsId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByappsId(
		int appsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByappsId(appsId, start, end, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByappsId_First(
		int appsId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByappsId_First(appsId, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByappsId_Last(
		int appsId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByappsId_Last(appsId, obc);
	}

	public static larion.progate.model.ProGateUserApplications[] findByappsId_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int appsId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence()
				   .findByappsId_PrevAndNext(ProGateUserApplicationsId, appsId,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByindexEqual(
		int position) throws com.liferay.portal.SystemException {
		return getPersistence().findByindexEqual(position);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByindexEqual(
		int position, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByindexEqual(position, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByindexEqual(
		int position, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByindexEqual(position, start, end, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByindexEqual_First(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByindexEqual_First(position, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByindexEqual_Last(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByindexEqual_Last(position, obc);
	}

	public static larion.progate.model.ProGateUserApplications[] findByindexEqual_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int position,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence()
				   .findByindexEqual_PrevAndNext(ProGateUserApplicationsId,
			position, obc);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByindexGreater(
		int position) throws com.liferay.portal.SystemException {
		return getPersistence().findByindexGreater(position);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByindexGreater(
		int position, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByindexGreater(position, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByindexGreater(
		int position, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByindexGreater(position, start, end, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByindexGreater_First(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByindexGreater_First(position, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByindexGreater_Last(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByindexGreater_Last(position, obc);
	}

	public static larion.progate.model.ProGateUserApplications[] findByindexGreater_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int position,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence()
				   .findByindexGreater_PrevAndNext(ProGateUserApplicationsId,
			position, obc);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByindexLower(
		int position) throws com.liferay.portal.SystemException {
		return getPersistence().findByindexLower(position);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByindexLower(
		int position, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByindexLower(position, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findByindexLower(
		int position, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByindexLower(position, start, end, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByindexLower_First(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByindexLower_First(position, obc);
	}

	public static larion.progate.model.ProGateUserApplications findByindexLower_Last(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence().findByindexLower_Last(position, obc);
	}

	public static larion.progate.model.ProGateUserApplications[] findByindexLower_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int position,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException {
		return getPersistence()
				   .findByindexLower_PrevAndNext(ProGateUserApplicationsId,
			position, obc);
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

	public static java.util.List<larion.progate.model.ProGateUserApplications> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateUserApplications> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByuserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByuserId(userId);
	}

	public static void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgId(orgId);
	}

	public static void removeByappsId(int appsId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByappsId(appsId);
	}

	public static void removeByindexEqual(int position)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByindexEqual(position);
	}

	public static void removeByindexGreater(int position)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByindexGreater(position);
	}

	public static void removeByindexLower(int position)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByindexLower(position);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByuserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByuserId(userId);
	}

	public static int countByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgId(orgId);
	}

	public static int countByappsId(int appsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByappsId(appsId);
	}

	public static int countByindexEqual(int position)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByindexEqual(position);
	}

	public static int countByindexGreater(int position)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByindexGreater(position);
	}

	public static int countByindexLower(int position)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByindexLower(position);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProGateUserApplicationsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateUserApplicationsPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateUserApplicationsPersistence _persistence;
}