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
 * <a href="LmisViewAttdanceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttdanceUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance) {
		getPersistence().cacheResult(lmisViewAttdance);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewAttdance> lmisViewAttdances) {
		getPersistence().cacheResult(lmisViewAttdances);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewAttdance create(
		java.lang.Integer lmisViewAttDailyId) {
		return getPersistence().create(lmisViewAttDailyId);
	}

	public static larion.progate.lmis.model.LmisViewAttdance remove(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().remove(lmisViewAttDailyId);
	}

	public static larion.progate.lmis.model.LmisViewAttdance remove(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewAttdance);
	}

	public static larion.progate.lmis.model.LmisViewAttdance update(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewAttdance);
	}

	public static larion.progate.lmis.model.LmisViewAttdance update(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewAttdance, merge);
	}

	public static larion.progate.lmis.model.LmisViewAttdance updateImpl(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewAttdance, merge);
	}

	public static larion.progate.lmis.model.LmisViewAttdance findByPrimaryKey(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().findByPrimaryKey(lmisViewAttDailyId);
	}

	public static larion.progate.lmis.model.LmisViewAttdance fetchByPrimaryKey(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewAttDailyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance[] findByRootId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence()
				   .findByRootId_PrevAndNext(lmisViewAttDailyId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance[] findByUserId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence()
				   .findByUserId_PrevAndNext(lmisViewAttDailyId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().findByDayValue_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().findByDayValue_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence()
				   .findByDayValue_PrevAndNext(lmisViewAttDailyId, dayValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByFullName(
		java.lang.String fullName) throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByFullName(
		java.lang.String fullName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByFullName(
		java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance findByFullName_First(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().findByFullName_First(fullName, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance findByFullName_Last(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence().findByFullName_Last(fullName, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttdance[] findByFullName_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException {
		return getPersistence()
				   .findByFullName_PrevAndNext(lmisViewAttDailyId, fullName, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttdance> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeByUserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(userId);
	}

	public static void removeByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayValue(dayValue);
	}

	public static void removeByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByFullName(fullName);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countByUserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(userId);
	}

	public static int countByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayValue(dayValue);
	}

	public static int countByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByFullName(fullName);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewAttdancePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewAttdancePersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewAttdancePersistence _persistence;
}