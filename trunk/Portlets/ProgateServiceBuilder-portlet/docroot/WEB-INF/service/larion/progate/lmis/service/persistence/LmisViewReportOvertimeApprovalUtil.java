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
 * <a href="LmisViewReportOvertimeApprovalUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimeApprovalUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval) {
		getPersistence().cacheResult(lmisViewReportOvertimeApproval);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> lmisViewReportOvertimeApprovals) {
		getPersistence().cacheResult(lmisViewReportOvertimeApprovals);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval create(
		java.lang.Integer lmisViewReportOvertimeApprovalId) {
		return getPersistence().create(lmisViewReportOvertimeApprovalId);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval remove(
		java.lang.Integer lmisViewReportOvertimeApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().remove(lmisViewReportOvertimeApprovalId);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval remove(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewReportOvertimeApproval);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval update(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewReportOvertimeApproval);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval update(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewReportOvertimeApproval, merge);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval updateImpl(
		larion.progate.lmis.model.LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewReportOvertimeApproval, merge);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence()
				   .findByPrimaryKey(lmisViewReportOvertimeApprovalId);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval fetchByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeApprovalId)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(lmisViewReportOvertimeApprovalId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewReportOvertimeApprovalId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisViewReportOvertimeApprovalId,
			orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedAt(
		java.util.Date reportedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedAt(reportedAt);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedAt(
		java.util.Date reportedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedAt(reportedAt, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedAt(
		java.util.Date reportedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedAt(reportedAt, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedAt_First(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByReportedAt_First(reportedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedAt_Last(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByReportedAt_Last(reportedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByReportedAt_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId,
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence()
				   .findByReportedAt_PrevAndNext(lmisViewReportOvertimeApprovalId,
			reportedAt, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedStatus(
		int reportedStatus) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedStatus(reportedStatus);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedStatus(
		int reportedStatus, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedStatus(reportedStatus, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedStatus(
		int reportedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByReportedStatus(reportedStatus, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedStatus_First(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByReportedStatus_First(reportedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedStatus_Last(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByReportedStatus_Last(reportedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByReportedStatus_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId, int reportedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence()
				   .findByReportedStatus_PrevAndNext(lmisViewReportOvertimeApprovalId,
			reportedStatus, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedBy(
		int reportedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedBy(reportedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedBy(
		int reportedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedBy(reportedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findByReportedBy(
		int reportedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedBy(reportedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedBy_First(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByReportedBy_First(reportedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval findByReportedBy_Last(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence().findByReportedBy_Last(reportedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertimeApproval[] findByReportedBy_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeApprovalId, int reportedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeApprovalException {
		return getPersistence()
				   .findByReportedBy_PrevAndNext(lmisViewReportOvertimeApprovalId,
			reportedBy, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertimeApproval> findAll(
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

	public static void removeByReportedAt(java.util.Date reportedAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByReportedAt(reportedAt);
	}

	public static void removeByReportedStatus(int reportedStatus)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByReportedStatus(reportedStatus);
	}

	public static void removeByReportedBy(int reportedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByReportedBy(reportedBy);
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

	public static int countByReportedAt(java.util.Date reportedAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByReportedAt(reportedAt);
	}

	public static int countByReportedStatus(int reportedStatus)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByReportedStatus(reportedStatus);
	}

	public static int countByReportedBy(int reportedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByReportedBy(reportedBy);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewReportOvertimeApprovalPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		LmisViewReportOvertimeApprovalPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewReportOvertimeApprovalPersistence _persistence;
}