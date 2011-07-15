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
 * <a href="LmisViewOvertimeReportUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport) {
		getPersistence().cacheResult(lmisViewOvertimeReport);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> lmisViewOvertimeReports) {
		getPersistence().cacheResult(lmisViewOvertimeReports);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport create(
		java.lang.Integer lmisViewOvertimeReportId) {
		return getPersistence().create(lmisViewOvertimeReportId);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport remove(
		java.lang.Integer lmisViewOvertimeReportId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().remove(lmisViewOvertimeReportId);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport remove(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewOvertimeReport);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport update(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewOvertimeReport);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport update(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewOvertimeReport, merge);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport updateImpl(
		larion.progate.lmis.model.LmisViewOvertimeReport lmisViewOvertimeReport,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewOvertimeReport, merge);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByPrimaryKey(
		java.lang.Integer lmisViewOvertimeReportId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByPrimaryKey(lmisViewOvertimeReportId);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport fetchByPrimaryKey(
		java.lang.Integer lmisViewOvertimeReportId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewOvertimeReportId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewOvertimeReportId, rootId,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisViewOvertimeReportId, orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedAt(
		java.util.Date reportedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedAt(reportedAt);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedAt(
		java.util.Date reportedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedAt(reportedAt, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedAt(
		java.util.Date reportedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedAt(reportedAt, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByReportedAt_First(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByReportedAt_First(reportedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByReportedAt_Last(
		java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByReportedAt_Last(reportedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport[] findByReportedAt_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, java.util.Date reportedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence()
				   .findByReportedAt_PrevAndNext(lmisViewOvertimeReportId,
			reportedAt, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByreportedStatus(
		int reportedStatus) throws com.liferay.portal.SystemException {
		return getPersistence().findByreportedStatus(reportedStatus);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByreportedStatus(
		int reportedStatus, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByreportedStatus(reportedStatus, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByreportedStatus(
		int reportedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByreportedStatus(reportedStatus, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByreportedStatus_First(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByreportedStatus_First(reportedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByreportedStatus_Last(
		int reportedStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByreportedStatus_Last(reportedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport[] findByreportedStatus_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, int reportedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence()
				   .findByreportedStatus_PrevAndNext(lmisViewOvertimeReportId,
			reportedStatus, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedBy(
		int reportedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedBy(reportedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedBy(
		int reportedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedBy(reportedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findByReportedBy(
		int reportedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportedBy(reportedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByReportedBy_First(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByReportedBy_First(reportedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport findByReportedBy_Last(
		int reportedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence().findByReportedBy_Last(reportedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewOvertimeReport[] findByReportedBy_PrevAndNext(
		java.lang.Integer lmisViewOvertimeReportId, int reportedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOvertimeReportException {
		return getPersistence()
				   .findByReportedBy_PrevAndNext(lmisViewOvertimeReportId,
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

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOvertimeReport> findAll(
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

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewOvertimeReportPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewOvertimeReportPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewOvertimeReportPersistence _persistence;
}