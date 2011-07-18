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
 * <a href="LmisViewOvertimeReportPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewOvertimeReportPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> lmisViewOvertimeReports);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewOvertimeReport create(
		java.lang.Integer lmisViewOvertimeReportId);

	public larion.progate.lmis.model.LmisViewOvertimeReport remove(
		java.lang.Integer lmisViewOvertimeReportId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport remove(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReport update(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReport update(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReport updateImpl(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByPrimaryKey(
		java.lang.Integer lmisViewOvertimeReportId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport fetchByPrimaryKey(
		java.lang.Integer lmisViewOvertimeReportId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedAt(
		java.util.Date reportedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedAt(
		java.util.Date reportedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedAt(
		java.util.Date reportedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByReportedAt_First(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByReportedAt_Last(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport[] findByReportedAt_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByreportedStatus(
		int reportedStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByreportedStatus(
		int reportedStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByreportedStatus(
		int reportedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByreportedStatus_First(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByreportedStatus_Last(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport[] findByreportedStatus_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, int reportedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedBy(
		int reportedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedBy(
		int reportedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedBy(
		int reportedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByReportedBy_First(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport findByReportedBy_Last(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public larion.progate.lmis.model.LmisViewOvertimeReport[] findByReportedBy_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, int reportedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findAll(
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

	public int countAll() throws com.liferay.portal.SystemException;
}