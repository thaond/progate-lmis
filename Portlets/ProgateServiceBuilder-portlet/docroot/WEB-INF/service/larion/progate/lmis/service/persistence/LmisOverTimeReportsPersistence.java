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
 * <a href="LmisOverTimeReportsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisOverTimeReportsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOverTimeReports> lmisOverTimeReportses);

	public void clearCache();

	public larion.progate.lmis.model.LmisOverTimeReports create(
		java.lang.Integer lmisOverTimeReportsId);

	public larion.progate.lmis.model.LmisOverTimeReports remove(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public larion.progate.lmis.model.LmisOverTimeReports remove(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReports update(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReports update(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReports updateImpl(
		larion.progate.lmis.model.LmisOverTimeReports lmisOverTimeReports,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReports findByPrimaryKey(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public larion.progate.lmis.model.LmisOverTimeReports fetchByPrimaryKey(
		java.lang.Integer lmisOverTimeReportsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByOverTimeReportOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByOverTimeReportOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByOverTimeReportOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReports findByOverTimeReportOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public larion.progate.lmis.model.LmisOverTimeReports findByOverTimeReportOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public larion.progate.lmis.model.LmisOverTimeReports[] findByOverTimeReportOf_PrevAndNext(
		java.lang.Integer lmisOverTimeReportsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByrequestID(
		int requestId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByrequestID(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByrequestID(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReports findByrequestID_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public larion.progate.lmis.model.LmisOverTimeReports findByrequestID_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public larion.progate.lmis.model.LmisOverTimeReports[] findByrequestID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportsId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByorgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByorgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findByorgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReports findByorgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public larion.progate.lmis.model.LmisOverTimeReports findByorgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public larion.progate.lmis.model.LmisOverTimeReports[] findByorgID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReports> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOverTimeReportOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByrequestID(int requestId)
		throws com.liferay.portal.SystemException;

	public void removeByorgID(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOverTimeReportOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByrequestID(int requestId)
		throws com.liferay.portal.SystemException;

	public int countByorgID(int orgId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportDetails> getLmisOverTimeReportDetailses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisOverTimeReportDetailsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeReportDetails(java.lang.Integer pk,
		java.lang.Integer lmisOverTimeReportDetailsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeReportDetailses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getLmisOvertimeApprovalses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisOvertimeApprovalsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOvertimeApprovals(java.lang.Integer pk,
		java.lang.Integer lmisOvertimeApprovalsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOvertimeApprovalses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}