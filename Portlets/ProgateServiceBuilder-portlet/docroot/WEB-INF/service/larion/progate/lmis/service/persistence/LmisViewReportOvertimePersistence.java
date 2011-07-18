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
 * <a href="LmisViewReportOvertimePersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewReportOvertimePersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> lmisViewReportOvertimes);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewReportOvertime create(
		java.lang.Integer lmisViewReportOvertimeId);

	public larion.progate.lmis.model.LmisViewReportOvertime remove(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime remove(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime update(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime update(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime updateImpl(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime fetchByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedAt(
		java.util.Date reportedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedAt(
		java.util.Date reportedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedAt(
		java.util.Date reportedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByReportedAt_First(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByReportedAt_Last(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime[] findByReportedAt_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByreportedStatus(
		int reportedStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByreportedStatus(
		int reportedStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByreportedStatus(
		int reportedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByreportedStatus_First(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByreportedStatus_Last(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime[] findByreportedStatus_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int reportedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedBy(
		int reportedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedBy(
		int reportedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedBy(
		int reportedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByReportedBy_First(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByReportedBy_Last(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime[] findByReportedBy_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int reportedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportID(
		int reportId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportID(
		int reportId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportID(
		int reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByReportID_First(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime findByReportID_Last(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public larion.progate.lmis.model.LmisViewReportOvertime[] findByReportID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int reportId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByReportedAt(java.util.Date reportedAt)
		throws com.liferay.portal.SystemException;

	public void removeByreportedStatus(int reportedStatus)
		throws com.liferay.portal.SystemException;

	public void removeByReportedBy(int reportedBy)
		throws com.liferay.portal.SystemException;

	public void removeByReportID(int reportId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByReportedAt(java.util.Date reportedAt)
		throws com.liferay.portal.SystemException;

	public int countByreportedStatus(int reportedStatus)
		throws com.liferay.portal.SystemException;

	public int countByReportedBy(int reportedBy)
		throws com.liferay.portal.SystemException;

	public int countByReportID(int reportId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}