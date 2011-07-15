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
 * <a href="LmisOverTimeReportsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports) {
		getPersistence().cacheResult(lmisOverTimeReports);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOverTimeReports> lmisOverTimeReportses) {
		getPersistence().cacheResult(lmisOverTimeReportses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisOverTimeReports create(
		java.lang.Integer lmisOverTimeReportsId) {
		return getPersistence().create(lmisOverTimeReportsId);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports remove(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence().remove(lmisOverTimeReportsId);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports remove(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisOverTimeReports);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports update(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOverTimeReports);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports update(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOverTimeReports, merge);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports updateImpl(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisOverTimeReports, merge);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports findByPrimaryKey(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence().findByPrimaryKey(lmisOverTimeReportsId);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports fetchByPrimaryKey(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisOverTimeReportsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByOverTimeReportOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeReportOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByOverTimeReportOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeReportOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByOverTimeReportOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeReportOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports findByOverTimeReportOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence().findByOverTimeReportOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports findByOverTimeReportOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence().findByOverTimeReportOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports[] findByOverTimeReportOf_PrevAndNext(
		java.lang.Integer lmisOverTimeReportsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence()
				   .findByOverTimeReportOf_PrevAndNext(lmisOverTimeReportsId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByrequestID(
		int requestId) throws com.liferay.portal.SystemException {
		return getPersistence().findByrequestID(requestId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByrequestID(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrequestID(requestId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByrequestID(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrequestID(requestId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports findByrequestID_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence().findByrequestID_First(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports findByrequestID_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence().findByrequestID_Last(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports[] findByrequestID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportsId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence()
				   .findByrequestID_PrevAndNext(lmisOverTimeReportsId,
			requestId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByorgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByorgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByorgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports findByorgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence().findByorgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports findByorgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence().findByorgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReports[] findByorgID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException {
		return getPersistence()
				   .findByorgID_PrevAndNext(lmisOverTimeReportsId, orgId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOverTimeReportOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOverTimeReportOf(rootId);
	}

	public static void removeByrequestID(int requestId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByrequestID(requestId);
	}

	public static void removeByorgID(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgID(orgId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOverTimeReportOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOverTimeReportOf(rootId);
	}

	public static int countByrequestID(int requestId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByrequestID(requestId);
	}

	public static int countByorgID(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgID(orgId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportDetailses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportDetailses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .getLmisOverTimeReportDetailses(pk, start, end, obc);
	}

	public static int getLmisOverTimeReportDetailsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportDetailsesSize(pk);
	}

	public static boolean containsLmisOverTimeReportDetails(
		java.lang.Integer pk, java.lang.Integer lmisOverTimeReportDetailsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisOverTimeReportDetails(pk,
			lmisOverTimeReportDetailsPK);
	}

	public static boolean containsLmisOverTimeReportDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisOverTimeReportDetailses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOvertimeApprovalses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOvertimeApprovalses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOvertimeApprovalses(pk, start, end, obc);
	}

	public static int getLmisOvertimeApprovalsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOvertimeApprovalsesSize(pk);
	}

	public static boolean containsLmisOvertimeApprovals(java.lang.Integer pk,
		java.lang.Integer lmisOvertimeApprovalsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisOvertimeApprovals(pk, lmisOvertimeApprovalsPK);
	}

	public static boolean containsLmisOvertimeApprovalses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisOvertimeApprovalses(pk);
	}

	public static LmisOverTimeReportsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisOverTimeReportsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisOverTimeReportsPersistence _persistence;
}