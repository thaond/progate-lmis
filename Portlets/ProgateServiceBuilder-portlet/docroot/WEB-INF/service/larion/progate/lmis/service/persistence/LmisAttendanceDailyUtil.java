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
 * <a href="LmisAttendanceDailyUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttendanceDailyUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily) {
		getPersistence().cacheResult(lmisAttendanceDaily);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> lmisAttendanceDailies) {
		getPersistence().cacheResult(lmisAttendanceDailies);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily create(
		java.lang.Integer lmisAttendanceDailyId) {
		return getPersistence().create(lmisAttendanceDailyId);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily remove(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().remove(lmisAttendanceDailyId);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily remove(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisAttendanceDaily);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily update(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAttendanceDaily);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily update(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAttendanceDaily, merge);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily updateImpl(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisAttendanceDaily, merge);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByPrimaryKey(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByPrimaryKey(lmisAttendanceDailyId);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily fetchByPrimaryKey(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisAttendanceDailyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByLmisAttendanceDailyOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByLmisAttendanceDailyOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByLmisAttendanceDailyOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByLmisAttendanceDailyOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByLmisAttendanceDailyOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByLmisAttendanceDailyOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByLmisAttendanceDailyOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByLmisAttendanceDailyOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByLmisAttendanceDailyOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByLmisAttendanceDailyOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily[] findByLmisAttendanceDailyOf_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence()
				   .findByLmisAttendanceDailyOf_PrevAndNext(lmisAttendanceDailyId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByDayValue_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByDayValue_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence()
				   .findByDayValue_PrevAndNext(lmisAttendanceDailyId, dayValue,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByUserID(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByUserID_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByUserID_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily[] findByUserID_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence()
				   .findByUserID_PrevAndNext(lmisAttendanceDailyId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisAttendanceDailyId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByabsenceValueGreater(
		double absenceValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByabsenceValueGreater(absenceValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByabsenceValueGreater(
		double absenceValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByabsenceValueGreater(absenceValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByabsenceValueGreater(
		double absenceValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByabsenceValueGreater(absenceValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByabsenceValueGreater_First(
		double absenceValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence()
				   .findByabsenceValueGreater_First(absenceValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByabsenceValueGreater_Last(
		double absenceValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByabsenceValueGreater_Last(absenceValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily[] findByabsenceValueGreater_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, double absenceValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence()
				   .findByabsenceValueGreater_PrevAndNext(lmisAttendanceDailyId,
			absenceValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayGreater(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayGreater(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayGreater(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByDayGreater_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByDayGreater_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByDayGreater_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByDayGreater_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily[] findByDayGreater_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence()
				   .findByDayGreater_PrevAndNext(lmisAttendanceDailyId,
			dayValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDaySmaller(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDaySmaller(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDaySmaller(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByDaySmaller_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByDaySmaller_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily findByDaySmaller_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence().findByDaySmaller_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttendanceDaily[] findByDaySmaller_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException {
		return getPersistence()
				   .findByDaySmaller_PrevAndNext(lmisAttendanceDailyId,
			dayValue, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByLmisAttendanceDailyOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByLmisAttendanceDailyOf(rootId);
	}

	public static void removeByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayValue(dayValue);
	}

	public static void removeByUserID(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserID(userId);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByabsenceValueGreater(double absenceValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByabsenceValueGreater(absenceValue);
	}

	public static void removeByDayGreater(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayGreater(dayValue);
	}

	public static void removeByDaySmaller(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDaySmaller(dayValue);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByLmisAttendanceDailyOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByLmisAttendanceDailyOf(rootId);
	}

	public static int countByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayValue(dayValue);
	}

	public static int countByUserID(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserID(userId);
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByabsenceValueGreater(double absenceValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByabsenceValueGreater(absenceValue);
	}

	public static int countByDayGreater(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayGreater(dayValue);
	}

	public static int countByDaySmaller(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDaySmaller(dayValue);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisAttendanceDailyPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisAttendanceDailyPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisAttendanceDailyPersistence _persistence;
}