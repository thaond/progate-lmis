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
 * <a href="LmisDayTypesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDayTypesUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisDayTypes lmisDayTypes) {
		getPersistence().cacheResult(lmisDayTypes);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisDayTypes> lmisDayTypeses) {
		getPersistence().cacheResult(lmisDayTypeses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisDayTypes create(
		java.lang.Integer LmisDayTypeId) {
		return getPersistence().create(LmisDayTypeId);
	}

	public static larion.progate.lmis.model.LmisDayTypes remove(
		java.lang.Integer LmisDayTypeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDayTypesException {
		return getPersistence().remove(LmisDayTypeId);
	}

	public static larion.progate.lmis.model.LmisDayTypes remove(
		larion.progate.lmis.model.LmisDayTypes lmisDayTypes)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisDayTypes);
	}

	public static larion.progate.lmis.model.LmisDayTypes update(
		larion.progate.lmis.model.LmisDayTypes lmisDayTypes)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisDayTypes);
	}

	public static larion.progate.lmis.model.LmisDayTypes update(
		larion.progate.lmis.model.LmisDayTypes lmisDayTypes, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisDayTypes, merge);
	}

	public static larion.progate.lmis.model.LmisDayTypes updateImpl(
		larion.progate.lmis.model.LmisDayTypes lmisDayTypes, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisDayTypes, merge);
	}

	public static larion.progate.lmis.model.LmisDayTypes findByPrimaryKey(
		java.lang.Integer LmisDayTypeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDayTypesException {
		return getPersistence().findByPrimaryKey(LmisDayTypeId);
	}

	public static larion.progate.lmis.model.LmisDayTypes fetchByPrimaryKey(
		java.lang.Integer LmisDayTypeId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(LmisDayTypeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDayTypes> findByDayTypeOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayTypeOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDayTypes> findByDayTypeOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayTypeOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDayTypes> findByDayTypeOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayTypeOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisDayTypes findByDayTypeOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDayTypesException {
		return getPersistence().findByDayTypeOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisDayTypes findByDayTypeOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDayTypesException {
		return getPersistence().findByDayTypeOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisDayTypes[] findByDayTypeOf_PrevAndNext(
		java.lang.Integer LmisDayTypeId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDayTypesException {
		return getPersistence()
				   .findByDayTypeOf_PrevAndNext(LmisDayTypeId, rootId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisDayTypes> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisDayTypes> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDayTypes> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByDayTypeOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayTypeOf(rootId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByDayTypeOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayTypeOf(rootId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> getLmisWorkingCalendarses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisWorkingCalendarses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> getLmisWorkingCalendarses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisWorkingCalendarses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendars> getLmisWorkingCalendarses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisWorkingCalendarses(pk, start, end, obc);
	}

	public static int getLmisWorkingCalendarsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisWorkingCalendarsesSize(pk);
	}

	public static boolean containsLmisWorkingCalendars(java.lang.Integer pk,
		java.lang.Integer lmisWorkingCalendarsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisWorkingCalendars(pk, lmisWorkingCalendarsPK);
	}

	public static boolean containsLmisWorkingCalendarses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisWorkingCalendarses(pk);
	}

	public static LmisDayTypesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisDayTypesPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisDayTypesPersistence _persistence;
}