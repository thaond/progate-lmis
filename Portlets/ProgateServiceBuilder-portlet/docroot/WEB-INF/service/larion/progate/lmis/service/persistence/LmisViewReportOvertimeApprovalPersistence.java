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
 * <a href="LmisViewReportOvertimeApprovalPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewReportOvertimeApprovalPersistence
	extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> lmisViewReportOvertimeApprovals);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval create(
		java.lang.Integer lmisViewReportOvertimeApprovalId);

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval remove(
		java.lang.Integer lmisViewReportOvertimeApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval remove(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval update(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval update(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval updateImpl(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval fetchByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeApprovalId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedAt(
		java.util.Date reportedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedAt(
		java.util.Date reportedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedAt(
		java.util.Date reportedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedAt_First(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedAt_Last(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByReportedAt_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId,
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedStatus(
		int reportedStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedStatus(
		int reportedStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedStatus(
		int reportedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedStatus_First(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedStatus_Last(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByReportedStatus_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId, int reportedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedBy(
		int reportedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedBy(
		int reportedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedBy(
		int reportedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedBy_First(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedBy_Last(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByReportedBy_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId, int reportedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByReportedAt(java.util.Date reportedAt)
		throws com.liferay.portal.SystemException;

	public void removeByReportedStatus(int reportedStatus)
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

	public int countByReportedStatus(int reportedStatus)
		throws com.liferay.portal.SystemException;

	public int countByReportedBy(int reportedBy)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}