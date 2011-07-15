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
 * <a href="LmisViewRegistrationOvertimeaApprovalUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeaApprovalUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval) {
		getPersistence().cacheResult(lmisViewRegistrationOvertimeaApproval);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> lmisViewRegistrationOvertimeaApprovals) {
		getPersistence().cacheResult(lmisViewRegistrationOvertimeaApprovals);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval create(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId) {
		return getPersistence().create(lmisViewRegistrationOvertimeaApprovalId);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval remove(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().remove(lmisViewRegistrationOvertimeaApprovalId);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval remove(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewRegistrationOvertimeaApproval);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval update(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewRegistrationOvertimeaApproval);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval update(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence()
				   .update(lmisViewRegistrationOvertimeaApproval, merge);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval updateImpl(
		larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence()
				   .updateImpl(lmisViewRegistrationOvertimeaApproval, merge);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByPrimaryKey(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence()
				   .findByPrimaryKey(lmisViewRegistrationOvertimeaApprovalId);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval fetchByPrimaryKey(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(lmisViewRegistrationOvertimeaApprovalId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewRegistrationOvertimeaApprovalId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisViewRegistrationOvertimeaApprovalId,
			orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedAt(
		java.util.Date requestedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedAt(requestedAt);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedAt(
		java.util.Date requestedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedAt(requestedAt, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedAt(
		java.util.Date requestedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedAt(requestedAt, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedAt_First(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByRequestedAt_First(requestedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedAt_Last(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByRequestedAt_Last(requestedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByRequestedAt_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId,
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence()
				   .findByRequestedAt_PrevAndNext(lmisViewRegistrationOvertimeaApprovalId,
			requestedAt, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedStatus(
		int requestedStatus) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedStatus(requestedStatus);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedStatus(
		int requestedStatus, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByRequestedStatus(requestedStatus, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedStatus(
		int requestedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByRequestedStatus(requestedStatus, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedStatus_First(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByRequestedStatus_First(requestedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedStatus_Last(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByRequestedStatus_Last(requestedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByRequestedStatus_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId,
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence()
				   .findByRequestedStatus_PrevAndNext(lmisViewRegistrationOvertimeaApprovalId,
			requestedStatus, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByRequestedBy_First(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence().findByRequestedBy_Last(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisViewRegistrationOvertimeaApprovalId,
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewRegistrationOvertimeaApprovalException {
		return getPersistence()
				   .findByRequestedBy_PrevAndNext(lmisViewRegistrationOvertimeaApprovalId,
			requestedBy, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
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

	public static void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedBy(requestedBy);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
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

	public static int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedBy(requestedBy);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewRegistrationOvertimeaApprovalPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		LmisViewRegistrationOvertimeaApprovalPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewRegistrationOvertimeaApprovalPersistence _persistence;
}