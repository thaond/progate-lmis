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
 * <a href="LmisViewRegistrationOvertimeaApprovalPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewRegistrationOvertimeaApprovalPersistence
	extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> lmisViewRegistrationOvertimeaApprovals);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval create(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId);

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval remove(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval remove(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval update(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval update(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval updateImpl(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByPrimaryKey(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval fetchByPrimaryKey(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedAt(
		java.util.Date requestedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedAt(
		java.util.Date requestedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedAt(
		java.util.Date requestedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedAt_First(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedAt_Last(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByRequestedAt_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId,
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedStatus(
		int requestedStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedStatus(
		int requestedStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedStatus(
		int requestedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedStatus_First(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedStatus_Last(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByRequestedStatus_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId,
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId,
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException;

	public int countByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException;

	public int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}