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
 * <a href="LmisOvertimeApprovalsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisOvertimeApprovalsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> lmisOvertimeApprovalses);

	public void clearCache();

	public larion.progate.lmis.model.LmisOvertimeApprovals create(
		java.lang.Integer lmisOvertimeApprovalsId);

	public larion.progate.lmis.model.LmisOvertimeApprovals remove(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals remove(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeApprovals update(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeApprovals update(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeApprovals updateImpl(
		larion.progate.lmis.model.LmisOvertimeApprovals lmisOvertimeApprovals,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByPrimaryKey(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeApprovalsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByOvertimeApprovalsOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByOvertimeApprovalsOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByOvertimeApprovalsOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByOvertimeApprovalsOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByOvertimeApprovalsOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals[] findByOvertimeApprovalsOf_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByRequestID(
		int requestId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByRequestID(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByRequestID(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByRequestID_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByRequestID_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals[] findByRequestID_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportIDGreater(
		int reportId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportIDGreater(
		int reportId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportIDGreater(
		int reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByReportIDGreater_First(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByReportIDGreater_Last(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals[] findByReportIDGreater_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int reportId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByApprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByApprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByApprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByApprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByApprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals[] findByApprovedBy_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportID(
		int reportId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportID(
		int reportId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findByReportID(
		int reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByReportID_First(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals findByReportID_Last(
		int reportId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public larion.progate.lmis.model.LmisOvertimeApprovals[] findByReportID_PrevAndNext(
		java.lang.Integer lmisOvertimeApprovalsId, int reportId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeApprovalsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOvertimeApprovalsOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByRequestID(int requestId)
		throws com.liferay.portal.SystemException;

	public void removeByReportIDGreater(int reportId)
		throws com.liferay.portal.SystemException;

	public void removeByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException;

	public void removeByReportID(int reportId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOvertimeApprovalsOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByRequestID(int requestId)
		throws com.liferay.portal.SystemException;

	public int countByReportIDGreater(int reportId)
		throws com.liferay.portal.SystemException;

	public int countByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException;

	public int countByReportID(int reportId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}