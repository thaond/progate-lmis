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
 * <a href="LmisOvertimeYearlyUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeYearlyUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly) {
		getPersistence().cacheResult(lmisOvertimeYearly);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> lmisOvertimeYearlies) {
		getPersistence().cacheResult(lmisOvertimeYearlies);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly create(
		java.lang.Integer lmisOvertimeYearlyId) {
		return getPersistence().create(lmisOvertimeYearlyId);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly remove(
		java.lang.Integer lmisOvertimeYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence().remove(lmisOvertimeYearlyId);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly remove(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisOvertimeYearly);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly update(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeYearly);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly update(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeYearly, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly updateImpl(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisOvertimeYearly, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly findByPrimaryKey(
		java.lang.Integer lmisOvertimeYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence().findByPrimaryKey(lmisOvertimeYearlyId);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeYearlyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisOvertimeYearlyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByOvertimeYearOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOvertimeYearOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByOvertimeYearOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOvertimeYearOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByOvertimeYearOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOvertimeYearOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly findByOvertimeYearOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence().findByOvertimeYearOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly findByOvertimeYearOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence().findByOvertimeYearOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly[] findByOvertimeYearOf_PrevAndNext(
		java.lang.Integer lmisOvertimeYearlyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence()
				   .findByOvertimeYearOf_PrevAndNext(lmisOvertimeYearlyId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByUserID(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence().findByUserID_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence().findByUserID_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly[] findByUserID_PrevAndNext(
		java.lang.Integer lmisOvertimeYearlyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence()
				   .findByUserID_PrevAndNext(lmisOvertimeYearlyId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence().findByYearValue_First(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence().findByYearValue_Last(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeYearly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisOvertimeYearlyId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException {
		return getPersistence()
				   .findByYearValue_PrevAndNext(lmisOvertimeYearlyId,
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

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOvertimeYearOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOvertimeYearOf(rootId);
	}

	public static void removeByUserID(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserID(userId);
	}

	public static void removeByYearValue(int yearValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByYearValue(yearValue);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOvertimeYearOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOvertimeYearOf(rootId);
	}

	public static int countByUserID(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserID(userId);
	}

	public static int countByYearValue(int yearValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByYearValue(yearValue);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisOvertimeYearlyPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisOvertimeYearlyPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisOvertimeYearlyPersistence _persistence;
}