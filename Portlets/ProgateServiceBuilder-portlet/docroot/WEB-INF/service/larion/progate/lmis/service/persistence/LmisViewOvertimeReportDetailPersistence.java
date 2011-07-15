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
 * <a href="LmisViewOvertimeReportDetailPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewOvertimeReportDetailPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewOvertimeReportDetail lmisViewOvertimeReportDetail);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> lmisViewOvertimeReportDetails);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail create(
		java.lang.Integer lmisViewReportOvertimeId);

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail remove(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail remove(
		larion.progate.lmis.model.LmisViewOvertimeReportDetail lmisViewOvertimeReportDetail)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail update(
		larion.progate.lmis.model.LmisViewOvertimeReportDetail lmisViewOvertimeReportDetail)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail update(
		larion.progate.lmis.model.LmisViewOvertimeReportDetail lmisViewOvertimeReportDetail,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail updateImpl(
		larion.progate.lmis.model.LmisViewOvertimeReportDetail lmisViewOvertimeReportDetail,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail fetchByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByOTRepId(
		int otRepId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByOTRepId(
		int otRepId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByOTRepId(
		int otRepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByOTRepId_First(
		int otRepId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByOTRepId_Last(
		int otRepId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail[] findByOTRepId_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int otRepId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByReportedAt(
		java.util.Date reportedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByReportedAt(
		java.util.Date reportedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByReportedAt(
		java.util.Date reportedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByReportedAt_First(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByReportedAt_Last(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail[] findByReportedAt_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByreportedStatus(
		int reportedStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByreportedStatus(
		int reportedStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByreportedStatus(
		int reportedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByreportedStatus_First(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByreportedStatus_Last(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail[] findByreportedStatus_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int reportedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByReportedBy(
		int reportedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByReportedBy(
		int reportedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findByReportedBy(
		int reportedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByReportedBy_First(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail findByReportedBy_Last(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public larion.progate.lmis.model.LmisViewOvertimeReportDetail[] findByReportedBy_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int reportedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportDetailException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOvertimeReportDetail> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByOTRepId(int otRepId)
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

	public int countByOTRepId(int otRepId)
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