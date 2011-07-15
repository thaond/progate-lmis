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
 * <a href="LmisAbsenceRequestsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAbsenceRequestsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> lmisAbsenceRequestses);

	public void clearCache();

	public larion.progate.lmis.model.LmisAbsenceRequests create(
		java.lang.Integer lmisAbsenceRequestsId);

	public larion.progate.lmis.model.LmisAbsenceRequests remove(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests remove(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests update(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests update(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests updateImpl(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByPrimaryKey(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests fetchByPrimaryKey(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceTypeId(
		int absenceTypeId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceTypeId(
		int absenceTypeId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceTypeId(
		int absenceTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByAbsenceTypeId_First(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByAbsenceTypeId_Last(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests[] findByAbsenceTypeId_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, int absenceTypeId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceType(
		java.lang.String absenceType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceType(
		java.lang.String absenceType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceType(
		java.lang.String absenceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByAbsenceType_First(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByAbsenceType_Last(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests[] findByAbsenceType_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedStatus(
		int requestedStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedStatus(
		int requestedStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedStatus(
		int requestedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByRequestedStatus_First(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByRequestedStatus_Last(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests[] findByRequestedStatus_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDayGreater(
		java.util.Date startDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDayGreater(
		java.util.Date startDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDayGreater(
		java.util.Date startDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByDayGreater_First(
		java.util.Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByDayGreater_Last(
		java.util.Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests[] findByDayGreater_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, java.util.Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDaySmaller(
		java.util.Date endDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDaySmaller(
		java.util.Date endDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDaySmaller(
		java.util.Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByDaySmaller_First(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests findByDaySmaller_Last(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public larion.progate.lmis.model.LmisAbsenceRequests[] findByDaySmaller_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public void removeByAbsenceTypeId(int absenceTypeId)
		throws com.liferay.portal.SystemException;

	public void removeByAbsenceType(java.lang.String absenceType)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException;

	public void removeByDayGreater(java.util.Date startDate)
		throws com.liferay.portal.SystemException;

	public void removeByDaySmaller(java.util.Date endDate)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public int countByAbsenceTypeId(int absenceTypeId)
		throws com.liferay.portal.SystemException;

	public int countByAbsenceType(java.lang.String absenceType)
		throws com.liferay.portal.SystemException;

	public int countByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException;

	public int countByDayGreater(java.util.Date startDate)
		throws com.liferay.portal.SystemException;

	public int countByDaySmaller(java.util.Date endDate)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> getLmisAbsenceApprovalses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> getLmisAbsenceApprovalses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> getLmisAbsenceApprovalses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisAbsenceApprovalsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisAbsenceApprovals(java.lang.Integer pk,
		java.lang.Integer lmisAbsenceApprovalsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisAbsenceApprovalses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}