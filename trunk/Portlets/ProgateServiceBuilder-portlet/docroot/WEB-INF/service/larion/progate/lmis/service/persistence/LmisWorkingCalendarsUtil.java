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
 * <a href="LmisWorkingCalendarsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingCalendarsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars) {
		getPersistence().cacheResult(lmisWorkingCalendars);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> lmisWorkingCalendarses) {
		getPersistence().cacheResult(lmisWorkingCalendarses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars create(
		java.lang.Integer lmisWorkingCalendarId) {
		return getPersistence().create(lmisWorkingCalendarId);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars remove(
		java.lang.Integer lmisWorkingCalendarId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().remove(lmisWorkingCalendarId);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars remove(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisWorkingCalendars);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars update(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisWorkingCalendars);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars update(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisWorkingCalendars, merge);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars updateImpl(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisWorkingCalendars, merge);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByPrimaryKey(
		java.lang.Integer lmisWorkingCalendarId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByPrimaryKey(lmisWorkingCalendarId);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars fetchByPrimaryKey(
		java.lang.Integer lmisWorkingCalendarId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisWorkingCalendarId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByWorkingCalendarOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByWorkingCalendarOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByWorkingCalendarOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByWorkingCalendarOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByWorkingCalendarOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByWorkingCalendarOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByWorkingCalendarOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByWorkingCalendarOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByWorkingCalendarOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByWorkingCalendarOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars[] findByWorkingCalendarOf_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence()
				   .findByWorkingCalendarOf_PrevAndNext(lmisWorkingCalendarId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayGreater(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayGreater(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayGreater(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByDayGreater_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByDayGreater_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByDayGreater_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByDayGreater_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars[] findByDayGreater_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence()
				   .findByDayGreater_PrevAndNext(lmisWorkingCalendarId,
			dayValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDaySmaller(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDaySmaller(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDaySmaller(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByDaySmaller_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByDaySmaller_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByDaySmaller_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByDaySmaller_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars[] findByDaySmaller_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence()
				   .findByDaySmaller_PrevAndNext(lmisWorkingCalendarId,
			dayValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayType(
		int dayType) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayType(dayType);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayType(
		int dayType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayType(dayType, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayType(
		int dayType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayType(dayType, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByDayType_First(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByDayType_First(dayType, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByDayType_Last(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByDayType_Last(dayType, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars[] findByDayType_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, int dayType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence()
				   .findByDayType_PrevAndNext(lmisWorkingCalendarId, dayType,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByDayValue_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence().findByDayValue_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendars[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException {
		return getPersistence()
				   .findByDayValue_PrevAndNext(lmisWorkingCalendarId, dayValue,
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

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByWorkingCalendarOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByWorkingCalendarOf(rootId);
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

	public static int countByWorkingCalendarOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByWorkingCalendarOf(rootId);
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

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisWorkingCalendarSessionses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisWorkingCalendarSessionses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .getLmisWorkingCalendarSessionses(pk, start, end, obc);
	}

	public static int getLmisWorkingCalendarSessionsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisWorkingCalendarSessionsesSize(pk);
	}

	public static boolean containsLmisWorkingCalendarSessions(
		java.lang.Integer pk, java.lang.Integer lmisWorkingCalendarSessionsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisWorkingCalendarSessions(pk,
			lmisWorkingCalendarSessionsPK);
	}

	public static boolean containsLmisWorkingCalendarSessionses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisWorkingCalendarSessionses(pk);
	}

	public static LmisWorkingCalendarsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisWorkingCalendarsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisWorkingCalendarsPersistence _persistence;
}