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
 * <a href="LmisOverTimeReportDetailsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisOverTimeReportDetailsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> lmisOverTimeReportDetailses);

	public void clearCache();

	public larion.progate.lmis.model.LmisOverTimeReportDetails create(
		java.lang.Integer lmisOverTimeReportDetailsId);

	public larion.progate.lmis.model.LmisOverTimeReportDetails remove(
		java.lang.Integer lmisOverTimeReportDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails remove(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails update(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails update(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails updateImpl(
		larion.progate.lmis.model.LmisOverTimeReportDetails lmisOverTimeReportDetails,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails findByPrimaryKey(
		java.lang.Integer lmisOverTimeReportDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails fetchByPrimaryKey(
		java.lang.Integer lmisOverTimeReportDetailsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findByOverTimeReportDetailsOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findByOverTimeReportDetailsOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findByOverTimeReportDetailsOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails findByOverTimeReportDetailsOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails findByOverTimeReportDetailsOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails[] findByOverTimeReportDetailsOf_PrevAndNext(
		java.lang.Integer lmisOverTimeReportDetailsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findByreportID(
		int reportId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findByreportID(
		int reportId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findByreportID(
		int reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails findByreportID_First(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails findByreportID_Last(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails[] findByreportID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportDetailsId, int reportId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findByuserID(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findByuserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findByuserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails findByuserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails findByuserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public larion.progate.lmis.model.LmisOverTimeReportDetails[] findByuserID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportDetailsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportDetailsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOverTimeReportDetailsOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByreportID(int reportId)
		throws com.liferay.portal.SystemException;

	public void removeByuserID(int userId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOverTimeReportDetailsOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByreportID(int reportId)
		throws com.liferay.portal.SystemException;

	public int countByuserID(int userId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisOverTimeReportHoursesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeReportHours(java.lang.Integer pk,
		java.lang.Integer lmisOverTimeReportHoursPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeReportHourses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}