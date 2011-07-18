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
 * <a href="LmisAttendanceDailyPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAttendanceDailyPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> lmisAttendanceDailies);

	public void clearCache();

	public larion.progate.lmis.model.LmisAttendanceDaily create(
		java.lang.Integer lmisAttendanceDailyId);

	public larion.progate.lmis.model.LmisAttendanceDaily remove(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily remove(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily update(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily update(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily updateImpl(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByPrimaryKey(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily fetchByPrimaryKey(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByLmisAttendanceDailyOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByLmisAttendanceDailyOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByLmisAttendanceDailyOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByLmisAttendanceDailyOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByLmisAttendanceDailyOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily[] findByLmisAttendanceDailyOf_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByUserID(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily[] findByUserID_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByabsenceValueGreater(
		double absenceValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByabsenceValueGreater(
		double absenceValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByabsenceValueGreater(
		double absenceValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByabsenceValueGreater_First(
		double absenceValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByabsenceValueGreater_Last(
		double absenceValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily[] findByabsenceValueGreater_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, double absenceValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayGreater(
		java.util.Date dayValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayGreater(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDayGreater(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByDayGreater_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByDayGreater_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily[] findByDayGreater_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDaySmaller(
		java.util.Date dayValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDaySmaller(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findByDaySmaller(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByDaySmaller_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily findByDaySmaller_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public larion.progate.lmis.model.LmisAttendanceDaily[] findByDaySmaller_PrevAndNext(
		java.lang.Integer lmisAttendanceDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttendanceDailyException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByLmisAttendanceDailyOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public void removeByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByabsenceValueGreater(double absenceValue)
		throws com.liferay.portal.SystemException;

	public void removeByDayGreater(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public void removeByDaySmaller(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByLmisAttendanceDailyOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public int countByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByabsenceValueGreater(double absenceValue)
		throws com.liferay.portal.SystemException;

	public int countByDayGreater(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public int countByDaySmaller(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}