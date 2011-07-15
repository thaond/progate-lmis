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
 * <a href="LmisWorkingCalendarSessionsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingCalendarSessionsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisWorkingCalendarSessions lmisWorkingCalendarSessions) {
		getPersistence().cacheResult(lmisWorkingCalendarSessions);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> lmisWorkingCalendarSessionses) {
		getPersistence().cacheResult(lmisWorkingCalendarSessionses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions create(
		java.lang.Integer lmisWorkingCalendarSessionID) {
		return getPersistence().create(lmisWorkingCalendarSessionID);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions remove(
		java.lang.Integer lmisWorkingCalendarSessionID)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarSessionsException {
		return getPersistence().remove(lmisWorkingCalendarSessionID);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions remove(
		larion.progate.lmis.model.LmisWorkingCalendarSessions lmisWorkingCalendarSessions)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisWorkingCalendarSessions);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions update(
		larion.progate.lmis.model.LmisWorkingCalendarSessions lmisWorkingCalendarSessions)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisWorkingCalendarSessions);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions update(
		larion.progate.lmis.model.LmisWorkingCalendarSessions lmisWorkingCalendarSessions,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisWorkingCalendarSessions, merge);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions updateImpl(
		larion.progate.lmis.model.LmisWorkingCalendarSessions lmisWorkingCalendarSessions,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisWorkingCalendarSessions, merge);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions findByPrimaryKey(
		java.lang.Integer lmisWorkingCalendarSessionID)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarSessionsException {
		return getPersistence().findByPrimaryKey(lmisWorkingCalendarSessionID);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions fetchByPrimaryKey(
		java.lang.Integer lmisWorkingCalendarSessionID)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisWorkingCalendarSessionID);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> findByWorkingCalendarSessionByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByWorkingCalendarSessionByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> findByWorkingCalendarSessionByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByWorkingCalendarSessionByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> findByWorkingCalendarSessionByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByWorkingCalendarSessionByRootId(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions findByWorkingCalendarSessionByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarSessionsException {
		return getPersistence()
				   .findByWorkingCalendarSessionByRootId_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions findByWorkingCalendarSessionByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarSessionsException {
		return getPersistence()
				   .findByWorkingCalendarSessionByRootId_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisWorkingCalendarSessions[] findByWorkingCalendarSessionByRootId_PrevAndNext(
		java.lang.Integer lmisWorkingCalendarSessionID, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingCalendarSessionsException {
		return getPersistence()
				   .findByWorkingCalendarSessionByRootId_PrevAndNext(lmisWorkingCalendarSessionID,
			rootId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisWorkingCalendarSessions> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByWorkingCalendarSessionByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByWorkingCalendarSessionByRootId(rootId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByWorkingCalendarSessionByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByWorkingCalendarSessionByRootId(rootId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisWorkingCalendarSessionsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		LmisWorkingCalendarSessionsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisWorkingCalendarSessionsPersistence _persistence;
}