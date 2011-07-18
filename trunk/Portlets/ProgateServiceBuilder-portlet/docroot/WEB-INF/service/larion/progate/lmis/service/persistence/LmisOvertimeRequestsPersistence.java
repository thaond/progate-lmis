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
 * <a href="LmisOvertimeRequestsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisOvertimeRequestsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> lmisOvertimeRequestses);

	public void clearCache();

	public larion.progate.lmis.model.LmisOvertimeRequests create(
		java.lang.Integer lmisOvertimeRequestsId);

	public larion.progate.lmis.model.LmisOvertimeRequests remove(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public larion.progate.lmis.model.LmisOvertimeRequests remove(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequests update(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequests update(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequests updateImpl(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequests findByPrimaryKey(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public larion.progate.lmis.model.LmisOvertimeRequests fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequests findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public larion.progate.lmis.model.LmisOvertimeRequests findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public larion.progate.lmis.model.LmisOvertimeRequests[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestsId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequests findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public larion.progate.lmis.model.LmisOvertimeRequests findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public larion.progate.lmis.model.LmisOvertimeRequests[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOverTimeRequetOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOverTimeRequetOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOverTimeRequetOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequests findByOverTimeRequetOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public larion.progate.lmis.model.LmisOvertimeRequests findByOverTimeRequetOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public larion.progate.lmis.model.LmisOvertimeRequests[] findByOverTimeRequetOf_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByOverTimeRequetOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByOverTimeRequetOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> getLmisOvertimeRequestDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> getLmisOvertimeRequestDetailses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> getLmisOvertimeRequestDetailses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisOvertimeRequestDetailsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOvertimeRequestDetails(java.lang.Integer pk,
		java.lang.Integer lmisOvertimeRequestDetailsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOvertimeRequestDetailses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisOvertimeApprovalsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOvertimeApprovals(java.lang.Integer pk,
		java.lang.Integer lmisOvertimeApprovalsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOvertimeApprovalses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisOverTimeReportsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeReports(java.lang.Integer pk,
		java.lang.Integer lmisOverTimeReportsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeReportses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}