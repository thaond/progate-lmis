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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="LmisWorkingCalendarsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisWorkingCalendarsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> lmisWorkingCalendarses);

	public void clearCache();

	public larion.progate.lmis.model.LmisWorkingCalendars create(
		java.lang.Integer lmisWorkingCalendarId);

	public larion.progate.lmis.model.LmisWorkingCalendars remove(
		java.lang.Integer lmisWorkingCalendarId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars remove(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingCalendars update(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingCalendars update(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingCalendars updateImpl(
		larion.progate.lmis.model.LmisWorkingCalendars lmisWorkingCalendars,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByPrimaryKey(
		java.lang.Integer lmisWorkingCalendarId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars fetchByPrimaryKey(
		java.lang.Integer lmisWorkingCalendarId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByWorkingCalendarOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByWorkingCalendarOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByWorkingCalendarOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByWorkingCalendarOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByWorkingCalendarOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars[] findByWorkingCalendarOf_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayGreater(
		java.util.Date dayValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayGreater(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayGreater(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByDayGreater_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByDayGreater_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars[] findByDayGreater_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDaySmaller(
		java.util.Date dayValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDaySmaller(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDaySmaller(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByDaySmaller_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByDaySmaller_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars[] findByDaySmaller_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayType(
		int dayType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayType(
		int dayType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayType(
		int dayType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByDayType_First(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByDayType_Last(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars[] findByDayType_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, int dayType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public larion.progate.lmis.model.LmisWorkingCalendars[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByWorkingCalendarOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByDayGreater(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public void removeByDaySmaller(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public void removeByDayType(int dayType)
		throws com.liferay.portal.SystemException;

	public void removeByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByWorkingCalendarOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByDayGreater(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public int countByDaySmaller(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public int countByDayType(int dayType)
		throws com.liferay.portal.SystemException;

	public int countByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> getLmisWorkingCalendarSessionses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisWorkingCalendarSessionsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisWorkingCalendarSessions(java.lang.Integer pk,
		java.lang.Integer lmisWorkingCalendarSessionsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisWorkingCalendarSessionses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}