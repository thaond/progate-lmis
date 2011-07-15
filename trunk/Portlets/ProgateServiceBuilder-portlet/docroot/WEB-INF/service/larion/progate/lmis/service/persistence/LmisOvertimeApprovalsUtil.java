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
 * <a href="LmisOvertimeApprovalsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeApprovalsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals) {
		getPersistence().cacheResult(lmisOvertimeApprovals);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> lmisOvertimeApprovalses) {
		getPersistence().cacheResult(lmisOvertimeApprovalses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals create(
		java.lang.Integer lmisOvertimeApprovalsId) {
		return getPersistence().create(lmisOvertimeApprovalsId);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals remove(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().remove(lmisOvertimeApprovalsId);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals remove(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisOvertimeApprovals);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals update(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeApprovals);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals update(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeApprovals, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals updateImpl(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisOvertimeApprovals, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByPrimaryKey(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByPrimaryKey(lmisOvertimeApprovalsId);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisOvertimeApprovalsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByOvertimeApprovalsOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOvertimeApprovalsOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByOvertimeApprovalsOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOvertimeApprovalsOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByOvertimeApprovalsOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByOvertimeApprovalsOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByOvertimeApprovalsOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByOvertimeApprovalsOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByOvertimeApprovalsOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByOvertimeApprovalsOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals[] findByOvertimeApprovalsOf_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence()
				   .findByOvertimeApprovalsOf_PrevAndNext(lmisOvertimeApprovalsId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByRequestID(
		int requestId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestID(requestId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByRequestID(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestID(requestId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByRequestID(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestID(requestId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByRequestID_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByRequestID_First(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByRequestID_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByRequestID_Last(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals[] findByRequestID_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence()
				   .findByRequestID_PrevAndNext(lmisOvertimeApprovalsId,
			requestId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportIDGreater(
		int reportId) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportIDGreater(reportId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportIDGreater(
		int reportId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportIDGreater(reportId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportIDGreater(
		int reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportIDGreater(reportId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByReportIDGreater_First(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByReportIDGreater_First(reportId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByReportIDGreater_Last(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByReportIDGreater_Last(reportId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals[] findByReportIDGreater_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int reportId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence()
				   .findByReportIDGreater_PrevAndNext(lmisOvertimeApprovalsId,
			reportId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByApprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByApprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByApprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByApprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByApprovedBy_First(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByApprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByApprovedBy_Last(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals[] findByApprovedBy_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence()
				   .findByApprovedBy_PrevAndNext(lmisOvertimeApprovalsId,
			approvedBy, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportID(
		int reportId) throws com.liferay.portal.SystemException {
		return getPersistence().findByReportID(reportId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportID(
		int reportId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportID(reportId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportID(
		int reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByReportID(reportId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByReportID_First(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByReportID_First(reportId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals findByReportID_Last(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence().findByReportID_Last(reportId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeApprovals[] findByReportID_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int reportId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException {
		return getPersistence()
				   .findByReportID_PrevAndNext(lmisOvertimeApprovalsId,
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

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOvertimeApprovalsOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOvertimeApprovalsOf(rootId);
	}

	public static void removeByRequestID(int requestId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestID(requestId);
	}

	public static void removeByReportIDGreater(int reportId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByReportIDGreater(reportId);
	}

	public static void removeByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByApprovedBy(approvedBy);
	}

	public static void removeByReportID(int reportId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByReportID(reportId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOvertimeApprovalsOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOvertimeApprovalsOf(rootId);
	}

	public static int countByRequestID(int requestId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestID(requestId);
	}

	public static int countByReportIDGreater(int reportId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByReportIDGreater(reportId);
	}

	public static int countByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByApprovedBy(approvedBy);
	}

	public static int countByReportID(int reportId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByReportID(reportId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisOvertimeApprovalsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisOvertimeApprovalsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisOvertimeApprovalsPersistence _persistence;
}