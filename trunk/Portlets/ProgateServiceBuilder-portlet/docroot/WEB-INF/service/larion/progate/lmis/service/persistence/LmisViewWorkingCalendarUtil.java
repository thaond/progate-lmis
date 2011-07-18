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
 * <a href="LmisViewWorkingCalendarUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewWorkingCalendarUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewWorkingCalendar lmisViewWorkingCalendar) {
		getPersistence().cacheResult(lmisViewWorkingCalendar);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> lmisViewWorkingCalendars) {
		getPersistence().cacheResult(lmisViewWorkingCalendars);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar create(
		java.lang.Integer lmisViewWorkingCalendarId) {
		return getPersistence().create(lmisViewWorkingCalendarId);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar remove(
		java.lang.Integer lmisViewWorkingCalendarId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().remove(lmisViewWorkingCalendarId);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar remove(
		larion.progate.lmis.model.LmisViewWorkingCalendar lmisViewWorkingCalendar)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewWorkingCalendar);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar update(
		larion.progate.lmis.model.LmisViewWorkingCalendar lmisViewWorkingCalendar)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewWorkingCalendar);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar update(
		larion.progate.lmis.model.LmisViewWorkingCalendar lmisViewWorkingCalendar,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewWorkingCalendar, merge);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar updateImpl(
		larion.progate.lmis.model.LmisViewWorkingCalendar lmisViewWorkingCalendar,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewWorkingCalendar, merge);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByPrimaryKey(
		java.lang.Integer lmisViewWorkingCalendarId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByPrimaryKey(lmisViewWorkingCalendarId);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar fetchByPrimaryKey(
		java.lang.Integer lmisViewWorkingCalendarId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewWorkingCalendarId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewWorkingCalendarId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewWorkingCalendarId, rootId,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDayGreater(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDayGreater(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDayGreater(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByDayGreater_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByDayGreater_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByDayGreater_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByDayGreater_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar[] findByDayGreater_PrevAndNext(
		java.lang.Integer lmisViewWorkingCalendarId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence()
				   .findByDayGreater_PrevAndNext(lmisViewWorkingCalendarId,
			dayValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDaySmaller(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDaySmaller(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDaySmaller(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByDaySmaller_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByDaySmaller_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByDaySmaller_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByDaySmaller_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar[] findByDaySmaller_PrevAndNext(
		java.lang.Integer lmisViewWorkingCalendarId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence()
				   .findByDaySmaller_PrevAndNext(lmisViewWorkingCalendarId,
			dayValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDayType(
		int dayType) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayType(dayType);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDayType(
		int dayType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayType(dayType, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDayType(
		int dayType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayType(dayType, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByDayType_First(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByDayType_First(dayType, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByDayType_Last(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByDayType_Last(dayType, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar[] findByDayType_PrevAndNext(
		java.lang.Integer lmisViewWorkingCalendarId, int dayType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence()
				   .findByDayType_PrevAndNext(lmisViewWorkingCalendarId,
			dayType, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByDayValue_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence().findByDayValue_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewWorkingCalendar[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisViewWorkingCalendarId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewWorkingCalendarException {
		return getPersistence()
				   .findByDayValue_PrevAndNext(lmisViewWorkingCalendarId,
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

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewWorkingCalendar> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByDayGreater(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayGreater(dayValue);
	}

	public static void removeByDaySmaller(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDaySmaller(dayValue);
	}

	public static void removeByDayType(int dayType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayType(dayType);
	}

	public static void removeByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayValue(dayValue);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByDayGreater(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayGreater(dayValue);
	}

	public static int countByDaySmaller(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDaySmaller(dayValue);
	}

	public static int countByDayType(int dayType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayType(dayType);
	}

	public static int countByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayValue(dayValue);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewWorkingCalendarPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewWorkingCalendarPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewWorkingCalendarPersistence _persistence;
}