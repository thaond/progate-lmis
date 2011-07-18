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
 * <a href="LmisViewReportOvertimeUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimeUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime) {
		getPersistence().cacheResult(lmisViewReportOvertime);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> lmisViewReportOvertimes) {
		getPersistence().cacheResult(lmisViewReportOvertimes);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime create(
		java.lang.Integer lmisViewReportOvertimeId) {
		return getPersistence().create(lmisViewReportOvertimeId);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime remove(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().remove(lmisViewReportOvertimeId);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime remove(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewReportOvertime);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime update(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewReportOvertime);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime update(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewReportOvertime, merge);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime updateImpl(
		larion.progate.lmis.model.LmisViewReportOvertime lmisViewReportOvertime,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewReportOvertime, merge);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByPrimaryKey(lmisViewReportOvertimeId);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime fetchByPrimaryKey(
		java.lang.Integer lmisViewReportOvertimeId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewReportOvertimeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewReportOvertimeId, rootId,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisViewReportOvertimeId, orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedAt(
		java.util.Date reportedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedAt(reportedAt);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedAt(
		java.util.Date reportedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedAt(reportedAt, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedAt(
		java.util.Date reportedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedAt(reportedAt, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByReportedAt_First(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByReportedAt_First(reportedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByReportedAt_Last(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByReportedAt_Last(reportedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime[] findByReportedAt_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence()
				   .findByReportedAt_PrevAndNext(lmisViewReportOvertimeId,
			reportedAt, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByreportedStatus(
		int reportedStatus) throws com.liferay.portal.SystemException {
		return getPersistence().findByreportedStatus(reportedStatus);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByreportedStatus(
		int reportedStatus, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByreportedStatus(reportedStatus, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByreportedStatus(
		int reportedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByreportedStatus(reportedStatus, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByreportedStatus_First(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByreportedStatus_First(reportedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByreportedStatus_Last(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByreportedStatus_Last(reportedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime[] findByreportedStatus_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int reportedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence()
				   .findByreportedStatus_PrevAndNext(lmisViewReportOvertimeId,
			reportedStatus, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedBy(
		int reportedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedBy(reportedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedBy(
		int reportedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedBy(reportedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportedBy(
		int reportedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedBy(reportedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByReportedBy_First(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByReportedBy_First(reportedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByReportedBy_Last(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByReportedBy_Last(reportedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime[] findByReportedBy_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int reportedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence()
				   .findByReportedBy_PrevAndNext(lmisViewReportOvertimeId,
			reportedBy, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportID(
		int reportId) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportID(reportId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportID(
		int reportId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportID(reportId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findByReportID(
		int reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportID(reportId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByReportID_First(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByReportID_First(reportId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime findByReportID_Last(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence().findByReportID_Last(reportId, obc);
	}

	public static larion.progate.lmis.model.LmisViewReportOvertime[] findByReportID_PrevAndNext(
		java.lang.Integer lmisViewReportOvertimeId, int reportId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewReportOvertimeException {
		return getPersistence()
				   .findByReportID_PrevAndNext(lmisViewReportOvertimeId,
			reportId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewReportOvertime> findAll(
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

	public static void removeByreportedStatus(int reportedStatus)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByreportedStatus(reportedStatus);
	}

	public static void removeByReportedBy(int reportedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByReportedBy(reportedBy);
	}

	public static void removeByReportID(int reportId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByReportID(reportId);
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

	public static int countByreportedStatus(int reportedStatus)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByreportedStatus(reportedStatus);
	}

	public static int countByReportedBy(int reportedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByReportedBy(reportedBy);
	}

	public static int countByReportID(int reportId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByReportID(reportId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewReportOvertimePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewReportOvertimePersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewReportOvertimePersistence _persistence;
}