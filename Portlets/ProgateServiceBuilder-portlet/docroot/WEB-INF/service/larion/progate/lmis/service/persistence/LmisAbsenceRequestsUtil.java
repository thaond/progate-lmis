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

/**
 * <a href="LmisAbsenceRequestsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceRequestsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests) {
		getPersistence().cacheResult(lmisAbsenceRequests);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> lmisAbsenceRequestses) {
		getPersistence().cacheResult(lmisAbsenceRequestses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests create(
		java.lang.Integer lmisAbsenceRequestsId) {
		return getPersistence().create(lmisAbsenceRequestsId);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests remove(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().remove(lmisAbsenceRequestsId);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests remove(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisAbsenceRequests);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests update(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAbsenceRequests);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests update(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAbsenceRequests, merge);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests updateImpl(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisAbsenceRequests, merge);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByPrimaryKey(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByPrimaryKey(lmisAbsenceRequestsId);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests fetchByPrimaryKey(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisAbsenceRequestsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisAbsenceRequestsId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByRequestedBy_First(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByRequestedBy_Last(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence()
				   .findByRequestedBy_PrevAndNext(lmisAbsenceRequestsId,
			requestedBy, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceTypeId(
		int absenceTypeId) throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceTypeId(absenceTypeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceTypeId(
		int absenceTypeId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceTypeId(absenceTypeId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceTypeId(
		int absenceTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByAbsenceTypeId(absenceTypeId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByAbsenceTypeId_First(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByAbsenceTypeId_First(absenceTypeId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByAbsenceTypeId_Last(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByAbsenceTypeId_Last(absenceTypeId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests[] findByAbsenceTypeId_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, int absenceTypeId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence()
				   .findByAbsenceTypeId_PrevAndNext(lmisAbsenceRequestsId,
			absenceTypeId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceType(
		java.lang.String absenceType) throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceType(absenceType);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceType(
		java.lang.String absenceType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceType(absenceType, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByAbsenceType(
		java.lang.String absenceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceType(absenceType, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByAbsenceType_First(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByAbsenceType_First(absenceType, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByAbsenceType_Last(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByAbsenceType_Last(absenceType, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests[] findByAbsenceType_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence()
				   .findByAbsenceType_PrevAndNext(lmisAbsenceRequestsId,
			absenceType, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedStatus(
		int requestedStatus) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedStatus(requestedStatus);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedStatus(
		int requestedStatus, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByRequestedStatus(requestedStatus, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByRequestedStatus(
		int requestedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByRequestedStatus(requestedStatus, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByRequestedStatus_First(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByRequestedStatus_First(requestedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByRequestedStatus_Last(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByRequestedStatus_Last(requestedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests[] findByRequestedStatus_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence()
				   .findByRequestedStatus_PrevAndNext(lmisAbsenceRequestsId,
			requestedStatus, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDayGreater(
		java.util.Date startDate) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(startDate);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDayGreater(
		java.util.Date startDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(startDate, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDayGreater(
		java.util.Date startDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayGreater(startDate, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByDayGreater_First(
		java.util.Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByDayGreater_First(startDate, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByDayGreater_Last(
		java.util.Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByDayGreater_Last(startDate, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests[] findByDayGreater_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, java.util.Date startDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence()
				   .findByDayGreater_PrevAndNext(lmisAbsenceRequestsId,
			startDate, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDaySmaller(
		java.util.Date endDate) throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(endDate);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDaySmaller(
		java.util.Date endDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(endDate, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findByDaySmaller(
		java.util.Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDaySmaller(endDate, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByDaySmaller_First(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByDaySmaller_First(endDate, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests findByDaySmaller_Last(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence().findByDaySmaller_Last(endDate, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceRequests[] findByDaySmaller_PrevAndNext(
		java.lang.Integer lmisAbsenceRequestsId, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceRequestsException {
		return getPersistence()
				   .findByDaySmaller_PrevAndNext(lmisAbsenceRequestsId,
			endDate, obc);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedBy(requestedBy);
	}

	public static void removeByAbsenceTypeId(int absenceTypeId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByAbsenceTypeId(absenceTypeId);
	}

	public static void removeByAbsenceType(java.lang.String absenceType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByAbsenceType(absenceType);
	}

	public static void removeByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedStatus(requestedStatus);
	}

	public static void removeByDayGreater(java.util.Date startDate)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayGreater(startDate);
	}

	public static void removeByDaySmaller(java.util.Date endDate)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDaySmaller(endDate);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedBy(requestedBy);
	}

	public static int countByAbsenceTypeId(int absenceTypeId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByAbsenceTypeId(absenceTypeId);
	}

	public static int countByAbsenceType(java.lang.String absenceType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByAbsenceType(absenceType);
	}

	public static int countByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedStatus(requestedStatus);
	}

	public static int countByDayGreater(java.util.Date startDate)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayGreater(startDate);
	}

	public static int countByDaySmaller(java.util.Date endDate)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDaySmaller(endDate);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> getLmisAbsenceApprovalses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAbsenceApprovalses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> getLmisAbsenceApprovalses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAbsenceApprovalses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> getLmisAbsenceApprovalses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAbsenceApprovalses(pk, start, end, obc);
	}

	public static int getLmisAbsenceApprovalsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAbsenceApprovalsesSize(pk);
	}

	public static boolean containsLmisAbsenceApprovals(java.lang.Integer pk,
		java.lang.Integer lmisAbsenceApprovalsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisAbsenceApprovals(pk, lmisAbsenceApprovalsPK);
	}

	public static boolean containsLmisAbsenceApprovalses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisAbsenceApprovalses(pk);
	}

	public static LmisAbsenceRequestsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisAbsenceRequestsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisAbsenceRequestsPersistence _persistence;
}