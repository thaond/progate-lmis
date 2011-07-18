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
 * <a href="LmisAttMonthlyUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttMonthlyUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly) {
		getPersistence().cacheResult(lmisAttMonthly);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAttMonthly> lmisAttMonthlies) {
		getPersistence().cacheResult(lmisAttMonthlies);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisAttMonthly create(
		java.lang.Integer lmisAttMonthlysId) {
		return getPersistence().create(lmisAttMonthlysId);
	}

	public static larion.progate.lmis.model.LmisAttMonthly remove(
		java.lang.Integer lmisAttMonthlysId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().remove(lmisAttMonthlysId);
	}

	public static larion.progate.lmis.model.LmisAttMonthly remove(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisAttMonthly);
	}

	public static larion.progate.lmis.model.LmisAttMonthly update(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAttMonthly);
	}

	public static larion.progate.lmis.model.LmisAttMonthly update(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAttMonthly, merge);
	}

	public static larion.progate.lmis.model.LmisAttMonthly updateImpl(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisAttMonthly, merge);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByPrimaryKey(
		java.lang.Integer lmisAttMonthlysId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByPrimaryKey(lmisAttMonthlysId);
	}

	public static larion.progate.lmis.model.LmisAttMonthly fetchByPrimaryKey(
		java.lang.Integer lmisAttMonthlysId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisAttMonthlysId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly[] findByRootId_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence()
				   .findByRootId_PrevAndNext(lmisAttMonthlysId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByNumDayAward(
		double numDayAward) throws com.liferay.portal.SystemException {
		return getPersistence().findByNumDayAward(numDayAward);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByNumDayAward(
		double numDayAward, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByNumDayAward(numDayAward, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByNumDayAward(
		double numDayAward, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByNumDayAward(numDayAward, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByNumDayAward_First(
		double numDayAward, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByNumDayAward_First(numDayAward, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByNumDayAward_Last(
		double numDayAward, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByNumDayAward_Last(numDayAward, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly[] findByNumDayAward_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, double numDayAward,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence()
				   .findByNumDayAward_PrevAndNext(lmisAttMonthlysId,
			numDayAward, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly[] findByUserId_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence()
				   .findByUserId_PrevAndNext(lmisAttMonthlysId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByMonthValue(
		int monthValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByMonthValue(monthValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByMonthValue(
		int monthValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByMonthValue(monthValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByMonthValue(
		int monthValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByMonthValue(monthValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByMonthValue_First(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByMonthValue_First(monthValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByMonthValue_Last(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByMonthValue_Last(monthValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly[] findByMonthValue_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, int monthValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence()
				   .findByMonthValue_PrevAndNext(lmisAttMonthlysId, monthValue,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByYearValue_First(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence().findByYearValue_Last(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttMonthly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException {
		return getPersistence()
				   .findByYearValue_PrevAndNext(lmisAttMonthlysId, yearValue,
			obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttMonthly> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeByNumDayAward(double numDayAward)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByNumDayAward(numDayAward);
	}

	public static void removeByUserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(userId);
	}

	public static void removeByMonthValue(int monthValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByMonthValue(monthValue);
	}

	public static void removeByYearValue(int yearValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByYearValue(yearValue);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countByNumDayAward(double numDayAward)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByNumDayAward(numDayAward);
	}

	public static int countByUserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(userId);
	}

	public static int countByMonthValue(int monthValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByMonthValue(monthValue);
	}

	public static int countByYearValue(int yearValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByYearValue(yearValue);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisAttMonthlyPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisAttMonthlyPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisAttMonthlyPersistence _persistence;
}