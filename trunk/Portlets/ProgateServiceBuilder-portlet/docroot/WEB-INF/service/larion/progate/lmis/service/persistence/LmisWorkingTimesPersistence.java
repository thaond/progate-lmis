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
 * <a href="LmisWorkingTimesPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisWorkingTimesPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisWorkingTimes> lmisWorkingTimeses);

	public void clearCache();

	public larion.progate.lmis.model.LmisWorkingTimes create(
		java.lang.Integer lmisWorkingTimeId);

	public larion.progate.lmis.model.LmisWorkingTimes remove(
		java.lang.Integer lmisWorkingTimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException;

	public larion.progate.lmis.model.LmisWorkingTimes remove(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingTimes update(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingTimes update(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingTimes updateImpl(
		larion.progate.lmis.model.LmisWorkingTimes lmisWorkingTimes,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingTimes findByPrimaryKey(
		java.lang.Integer lmisWorkingTimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException;

	public larion.progate.lmis.model.LmisWorkingTimes fetchByPrimaryKey(
		java.lang.Integer lmisWorkingTimeId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findByWorkingTimeOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findByWorkingTimeOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findByWorkingTimeOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingTimes findByWorkingTimeOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException;

	public larion.progate.lmis.model.LmisWorkingTimes findByWorkingTimeOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException;

	public larion.progate.lmis.model.LmisWorkingTimes[] findByWorkingTimeOf_PrevAndNext(
		java.lang.Integer lmisWorkingTimeId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findBySession(
		java.lang.String sessionName) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findBySession(
		java.lang.String sessionName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findBySession(
		java.lang.String sessionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisWorkingTimes findBySession_First(
		java.lang.String sessionName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException;

	public larion.progate.lmis.model.LmisWorkingTimes findBySession_Last(
		java.lang.String sessionName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException;

	public larion.progate.lmis.model.LmisWorkingTimes[] findBySession_PrevAndNext(
		java.lang.Integer lmisWorkingTimeId, java.lang.String sessionName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisWorkingTimesException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByWorkingTimeOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeBySession(java.lang.String sessionName)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByWorkingTimeOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countBySession(java.lang.String sessionName)
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

	public java.util.List<larion.progate.lmis.model.LmisDataImports> getLmisDataImportses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> getLmisDataImportses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> getLmisDataImportses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisDataImportsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisDataImports(java.lang.Integer pk,
		java.lang.Integer lmisDataImportsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisDataImportses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}