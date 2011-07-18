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
 * <a href="LmisOvertimeMonthlyUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeMonthlyUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly) {
		getPersistence().cacheResult(lmisOvertimeMonthly);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> lmisOvertimeMonthlies) {
		getPersistence().cacheResult(lmisOvertimeMonthlies);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly create(
		java.lang.Integer lmisOvertimeMonthlyId) {
		return getPersistence().create(lmisOvertimeMonthlyId);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly remove(
		java.lang.Integer lmisOvertimeMonthlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().remove(lmisOvertimeMonthlyId);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly remove(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisOvertimeMonthly);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly update(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeMonthly);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly update(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeMonthly, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly updateImpl(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisOvertimeMonthly, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByPrimaryKey(
		java.lang.Integer lmisOvertimeMonthlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByPrimaryKey(lmisOvertimeMonthlyId);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeMonthlyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisOvertimeMonthlyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOvertimeMonthlyOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOvertimeMonthlyOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOvertimeMonthlyOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOvertimeMonthlyOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOvertimeMonthlyOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOvertimeMonthlyOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByOvertimeMonthlyOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByOvertimeMonthlyOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByOvertimeMonthlyOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByOvertimeMonthlyOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly[] findByOvertimeMonthlyOf_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence()
				   .findByOvertimeMonthlyOf_PrevAndNext(lmisOvertimeMonthlyId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByUserID(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByUserID_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByUserID_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly[] findByUserID_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence()
				   .findByUserID_PrevAndNext(lmisOvertimeMonthlyId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisOvertimeMonthlyId, orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOtID(
		int otId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOtID(otId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOtID(
		int otId, int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findByOtID(otId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOtID(
		int otId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOtID(otId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByOtID_First(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByOtID_First(otId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByOtID_Last(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByOtID_Last(otId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly[] findByOtID_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int otId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence()
				   .findByOtID_PrevAndNext(lmisOvertimeMonthlyId, otId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByMonthValue(
		int monthValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByMonthValue(monthValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByMonthValue(
		int monthValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByMonthValue(monthValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByMonthValue(
		int monthValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByMonthValue(monthValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByMonthValue_First(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByMonthValue_First(monthValue, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByMonthValue_Last(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByMonthValue_Last(monthValue, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly[] findByMonthValue_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int monthValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence()
				   .findByMonthValue_PrevAndNext(lmisOvertimeMonthlyId,
			monthValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByYearValue_First(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence().findByYearValue_Last(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeMonthly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException {
		return getPersistence()
				   .findByYearValue_PrevAndNext(lmisOvertimeMonthlyId,
			yearValue, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOvertimeMonthlyOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOvertimeMonthlyOf(rootId);
	}

	public static void removeByUserID(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserID(userId);
	}

	public static void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgID(orgId);
	}

	public static void removeByOtID(int otId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOtID(otId);
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

	public static int countByOvertimeMonthlyOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOvertimeMonthlyOf(rootId);
	}

	public static int countByUserID(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserID(userId);
	}

	public static int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgID(orgId);
	}

	public static int countByOtID(int otId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOtID(otId);
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

	public static LmisOvertimeMonthlyPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisOvertimeMonthlyPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisOvertimeMonthlyPersistence _persistence;
}