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
 * <a href="LmisViewRegistrationOvertimePersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewRegistrationOvertimePersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> lmisViewRegistrationOvertimes);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewRegistrationOvertime create(
		java.lang.Integer lmisViewRegistrationOvertimeId);

	public larion.progate.lmis.model.LmisViewRegistrationOvertime remove(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime remove(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime update(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime update(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime updateImpl(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByPrimaryKey(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime fetchByPrimaryKey(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestID(
		int requestId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestID(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestID(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestID_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestID_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRequestID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedAt(
		java.util.Date requestedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedAt(
		java.util.Date requestedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedAt(
		java.util.Date requestedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedAt_First(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedAt_Last(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRequestedAt_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId,
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedStatus(
		int requestedStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedStatus(
		int requestedStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedStatus(
		int requestedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedStatus_First(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedStatus_Last(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRequestedStatus_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByuserID(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByuserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByuserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByuserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByuserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByuserID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByApprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByApprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByApprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByApprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime findByApprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByApprovedBy_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByRequestID(int requestId)
		throws com.liferay.portal.SystemException;

	public void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException;

	public void removeByuserID(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public void removeByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByRequestID(int requestId)
		throws com.liferay.portal.SystemException;

	public int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException;

	public int countByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException;

	public int countByuserID(int userId)
		throws com.liferay.portal.SystemException;

	public int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public int countByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}