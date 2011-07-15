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
 * <a href="LmisViewAttDailyUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttDailyUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily) {
		getPersistence().cacheResult(lmisViewAttDaily);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewAttDaily> lmisViewAttDailies) {
		getPersistence().cacheResult(lmisViewAttDailies);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewAttDaily create(
		java.lang.Integer lmisViewAttDailyId) {
		return getPersistence().create(lmisViewAttDailyId);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily remove(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().remove(lmisViewAttDailyId);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily remove(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewAttDaily);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily update(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewAttDaily);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily update(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewAttDaily, merge);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily updateImpl(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewAttDaily, merge);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByPrimaryKey(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByPrimaryKey(lmisViewAttDailyId);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily fetchByPrimaryKey(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewAttDailyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily[] findByRootId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence()
				   .findByRootId_PrevAndNext(lmisViewAttDailyId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByOrgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgId(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByOrgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByOrgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgId(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByOrgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByOrgId_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByOrgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByOrgId_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily[] findByOrgId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence()
				   .findByOrgId_PrevAndNext(lmisViewAttDailyId, orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily[] findByUserId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence()
				   .findByUserId_PrevAndNext(lmisViewAttDailyId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByDayValue_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByDayValue_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence()
				   .findByDayValue_PrevAndNext(lmisViewAttDailyId, dayValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByFullName(
		java.lang.String fullName) throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByFullName(
		java.lang.String fullName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByFullName(
		java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByFullName_First(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByFullName_First(fullName, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily findByFullName_Last(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
		return getPersistence().findByFullName_Last(fullName, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttDaily[] findByFullName_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException {
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

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeByOrgId(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgId(orgId);
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

	public static int countByOrgId(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgId(orgId);
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

	public static LmisViewAttDailyPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewAttDailyPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewAttDailyPersistence _persistence;
}