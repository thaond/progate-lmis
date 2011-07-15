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
 * <a href="LmisWorkingTimesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingTimesUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes) {
		getPersistence().cacheResult(lmisWorkingTimes);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisWorkingTimes> lmisWorkingTimeses) {
		getPersistence().cacheResult(lmisWorkingTimeses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisWorkingTimes create(
		java.lang.Integer lmisWorkingTimeId) {
		return getPersistence().create(lmisWorkingTimeId);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes remove(
		java.lang.Integer lmisWorkingTimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException {
		return getPersistence().remove(lmisWorkingTimeId);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes remove(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisWorkingTimes);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes update(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisWorkingTimes);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes update(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisWorkingTimes, merge);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes updateImpl(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisWorkingTimes, merge);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes findByPrimaryKey(
		java.lang.Integer lmisWorkingTimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException {
		return getPersistence().findByPrimaryKey(lmisWorkingTimeId);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes fetchByPrimaryKey(
		java.lang.Integer lmisWorkingTimeId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisWorkingTimeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findByWorkingTimeOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByWorkingTimeOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findByWorkingTimeOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByWorkingTimeOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findByWorkingTimeOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByWorkingTimeOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes findByWorkingTimeOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException {
		return getPersistence().findByWorkingTimeOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes findByWorkingTimeOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException {
		return getPersistence().findByWorkingTimeOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes[] findByWorkingTimeOf_PrevAndNext(
		java.lang.Integer lmisWorkingTimeId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException {
		return getPersistence()
				   .findByWorkingTimeOf_PrevAndNext(lmisWorkingTimeId, rootId,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findBySession(
		java.lang.String sessionName) throws com.liferay.portal.SystemException {
		return getPersistence().findBySession(sessionName);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findBySession(
		java.lang.String sessionName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBySession(sessionName, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findBySession(
		java.lang.String sessionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBySession(sessionName, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes findBySession_First(
		java.lang.String sessionName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException {
		return getPersistence().findBySession_First(sessionName, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes findBySession_Last(
		java.lang.String sessionName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException {
		return getPersistence().findBySession_Last(sessionName, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingTimes[] findBySession_PrevAndNext(
		java.lang.Integer lmisWorkingTimeId, java.lang.String sessionName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException {
		return getPersistence()
				   .findBySession_PrevAndNext(lmisWorkingTimeId, sessionName,
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

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByWorkingTimeOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByWorkingTimeOf(rootId);
	}

	public static void removeBySession(java.lang.String sessionName)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBySession(sessionName);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByWorkingTimeOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByWorkingTimeOf(rootId);
	}

	public static int countBySession(java.lang.String sessionName)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBySession(sessionName);
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

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> getLmisDataImportses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisDataImportses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> getLmisDataImportses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisDataImportses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> getLmisDataImportses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisDataImportses(pk, start, end, obc);
	}

	public static int getLmisDataImportsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisDataImportsesSize(pk);
	}

	public static boolean containsLmisDataImports(java.lang.Integer pk,
		java.lang.Integer lmisDataImportsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisDataImports(pk, lmisDataImportsPK);
	}

	public static boolean containsLmisDataImportses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisDataImportses(pk);
	}

	public static LmisWorkingTimesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisWorkingTimesPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisWorkingTimesPersistence _persistence;
}