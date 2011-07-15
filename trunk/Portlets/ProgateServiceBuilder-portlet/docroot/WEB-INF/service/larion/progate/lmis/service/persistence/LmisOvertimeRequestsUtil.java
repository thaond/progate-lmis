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
 * <a href="LmisOvertimeRequestsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeRequestsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests) {
		getPersistence().cacheResult(lmisOvertimeRequests);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> lmisOvertimeRequestses) {
		getPersistence().cacheResult(lmisOvertimeRequestses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests create(
		java.lang.Integer lmisOvertimeRequestsId) {
		return getPersistence().create(lmisOvertimeRequestsId);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests remove(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence().remove(lmisOvertimeRequestsId);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests remove(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisOvertimeRequests);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests update(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeRequests);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests update(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeRequests, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests updateImpl(
		larion.progate.lmis.model.LmisOvertimeRequests lmisOvertimeRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisOvertimeRequests, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests findByPrimaryKey(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence().findByPrimaryKey(lmisOvertimeRequestsId);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeRequestsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisOvertimeRequestsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence().findByRequestedBy_First(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence().findByRequestedBy_Last(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestsId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence()
				   .findByRequestedBy_PrevAndNext(lmisOvertimeRequestsId,
			requestedBy, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisOvertimeRequestsId, orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOverTimeRequetOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeRequetOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOverTimeRequetOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeRequetOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findByOverTimeRequetOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeRequetOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests findByOverTimeRequetOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence().findByOverTimeRequetOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests findByOverTimeRequetOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence().findByOverTimeRequetOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequests[] findByOverTimeRequetOf_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestsException {
		return getPersistence()
				   .findByOverTimeRequetOf_PrevAndNext(lmisOvertimeRequestsId,
			rootId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequests> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedBy(requestedBy);
	}

	public static void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgID(orgId);
	}

	public static void removeByOverTimeRequetOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOverTimeRequetOf(rootId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedBy(requestedBy);
	}

	public static int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgID(orgId);
	}

	public static int countByOverTimeRequetOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOverTimeRequetOf(rootId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> getLmisOvertimeRequestDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOvertimeRequestDetailses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> getLmisOvertimeRequestDetailses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOvertimeRequestDetailses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> getLmisOvertimeRequestDetailses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .getLmisOvertimeRequestDetailses(pk, start, end, obc);
	}

	public static int getLmisOvertimeRequestDetailsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOvertimeRequestDetailsesSize(pk);
	}

	public static boolean containsLmisOvertimeRequestDetails(
		java.lang.Integer pk, java.lang.Integer lmisOvertimeRequestDetailsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisOvertimeRequestDetails(pk,
			lmisOvertimeRequestDetailsPK);
	}

	public static boolean containsLmisOvertimeRequestDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisOvertimeRequestDetailses(pk);
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

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReports> getLmisOverTimeReportses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportses(pk, start, end, obc);
	}

	public static int getLmisOverTimeReportsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportsesSize(pk);
	}

	public static boolean containsLmisOverTimeReports(java.lang.Integer pk,
		java.lang.Integer lmisOverTimeReportsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisOverTimeReports(pk, lmisOverTimeReportsPK);
	}

	public static boolean containsLmisOverTimeReportses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisOverTimeReportses(pk);
	}

	public static LmisOvertimeRequestsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisOvertimeRequestsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisOvertimeRequestsPersistence _persistence;
}