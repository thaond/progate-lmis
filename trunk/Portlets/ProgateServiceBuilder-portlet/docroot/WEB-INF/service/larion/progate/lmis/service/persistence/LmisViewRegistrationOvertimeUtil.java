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
 * <a href="LmisViewRegistrationOvertimeUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime) {
		getPersistence().cacheResult(lmisViewRegistrationOvertime);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> lmisViewRegistrationOvertimes) {
		getPersistence().cacheResult(lmisViewRegistrationOvertimes);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime create(
		java.lang.Integer lmisViewRegistrationOvertimeId) {
		return getPersistence().create(lmisViewRegistrationOvertimeId);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime remove(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().remove(lmisViewRegistrationOvertimeId);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime remove(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewRegistrationOvertime);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime update(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewRegistrationOvertime);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime update(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewRegistrationOvertime, merge);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime updateImpl(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewRegistrationOvertime, merge);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByPrimaryKey(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByPrimaryKey(lmisViewRegistrationOvertimeId);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime fetchByPrimaryKey(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewRegistrationOvertimeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewRegistrationOvertimeId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestID(
		int requestId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestID(requestId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestID(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestID(requestId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestID(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestID(requestId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestID_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRequestID_First(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestID_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRequestID_Last(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRequestID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence()
				   .findByRequestID_PrevAndNext(lmisViewRegistrationOvertimeId,
			requestId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisViewRegistrationOvertimeId,
			orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedAt(
		java.util.Date requestedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedAt(requestedAt);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedAt(
		java.util.Date requestedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedAt(requestedAt, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedAt(
		java.util.Date requestedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedAt(requestedAt, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedAt_First(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRequestedAt_First(requestedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedAt_Last(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRequestedAt_Last(requestedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRequestedAt_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId,
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence()
				   .findByRequestedAt_PrevAndNext(lmisViewRegistrationOvertimeId,
			requestedAt, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedStatus(
		int requestedStatus) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedStatus(requestedStatus);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedStatus(
		int requestedStatus, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByRequestedStatus(requestedStatus, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedStatus(
		int requestedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByRequestedStatus(requestedStatus, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedStatus_First(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRequestedStatus_First(requestedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedStatus_Last(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRequestedStatus_Last(requestedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRequestedStatus_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence()
				   .findByRequestedStatus_PrevAndNext(lmisViewRegistrationOvertimeId,
			requestedStatus, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByuserID(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByuserID(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByuserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserID(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByuserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserID(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByuserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByuserID_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByuserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByuserID_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByuserID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence()
				   .findByuserID_PrevAndNext(lmisViewRegistrationOvertimeId,
			userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRequestedBy_First(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByRequestedBy_Last(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence()
				   .findByRequestedBy_PrevAndNext(lmisViewRegistrationOvertimeId,
			requestedBy, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByApprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByApprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findByApprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByApprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByApprovedBy_First(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime findByApprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence().findByApprovedBy_Last(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertime[] findByApprovedBy_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeException {
		return getPersistence()
				   .findByApprovedBy_PrevAndNext(lmisViewRegistrationOvertimeId,
			approvedBy, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByRequestID(int requestId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestID(requestId);
	}

	public static void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgID(orgId);
	}

	public static void removeByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedAt(requestedAt);
	}

	public static void removeByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedStatus(requestedStatus);
	}

	public static void removeByuserID(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByuserID(userId);
	}

	public static void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedBy(requestedBy);
	}

	public static void removeByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByApprovedBy(approvedBy);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByRequestID(int requestId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestID(requestId);
	}

	public static int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgID(orgId);
	}

	public static int countByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedAt(requestedAt);
	}

	public static int countByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedStatus(requestedStatus);
	}

	public static int countByuserID(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByuserID(userId);
	}

	public static int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedBy(requestedBy);
	}

	public static int countByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByApprovedBy(approvedBy);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewRegistrationOvertimePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		LmisViewRegistrationOvertimePersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewRegistrationOvertimePersistence _persistence;
}