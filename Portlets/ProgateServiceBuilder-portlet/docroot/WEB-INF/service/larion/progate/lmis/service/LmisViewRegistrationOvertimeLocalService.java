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

package larion.progate.lmis.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;

/**
 * <a href="LmisViewRegistrationOvertimeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LmisViewRegistrationOvertimeLocalService {
	public larion.progate.lmis.model.LmisViewRegistrationOvertime addLmisViewRegistrationOvertime(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime createLmisViewRegistrationOvertime(
		java.lang.Integer lmisViewRegistrationOvertimeId);

	public void deleteLmisViewRegistrationOvertime(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteLmisViewRegistrationOvertime(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.lmis.model.LmisViewRegistrationOvertime getLmisViewRegistrationOvertime(
		java.lang.Integer lmisViewRegistrationOvertimeId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getLmisViewRegistrationOvertimes(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLmisViewRegistrationOvertimesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime updateLmisViewRegistrationOvertime(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewRegistrationOvertime updateLmisViewRegistrationOvertime(
		larion.progate.lmis.model.LmisViewRegistrationOvertime lmisViewRegistrationOvertime,
		boolean merge) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getOtHourYesterday(int userId, java.util.Date requestedAt,
		int rootId) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqsByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public int countRequestOfUID(int rootId, int userId)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqsByOrgId(
		java.util.Date date, int orgId)
		throws com.liferay.portal.SystemException;

	public int countRequestPending(int rootId, int userId)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqRoleUser(
		int userId, int rootId) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqRoleSpec(
		int rootId) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqDetail(
		int rootId, int requestId) throws com.liferay.portal.SystemException;

	public boolean editOverTimeRequest(int rootId, int requestId,
		int requestBy, java.util.Date requestedAt,
		java.lang.String requestReason, int orgId, int requestDetailId,
		int userId, java.util.Date startTime, java.util.Date endTime,
		java.lang.String reasonDetail, double requestHour)
		throws com.liferay.portal.SystemException;

	public boolean addOverTimeRequest(int rootId, int requestId, int requestBy,
		java.util.Date requestedAt, java.lang.String requestReason,
		java.util.Date createdAt, int orgId, int userId,
		java.util.Date startTime, java.util.Date endTime,
		java.lang.String reasonDetail, double requestHour)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisOvertimeApprovals> getListApprovalByReqId(
		int rootId, int requestId) throws com.liferay.portal.SystemException;

	public int findIdReq(int rootId, int approvedBy, int requestId)
		throws com.liferay.portal.SystemException;

	public boolean doApprove(int rootId, int orgId, int approvedBy,
		int requestId, boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException;

	public boolean doApproveIt(int rootId, int orgId, int approvedBy,
		int requestId, boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.ArrayList<Integer> getListOverTimeReqDetails(int rootId,
		int userId) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOverTimeReqRoleManager(
		int rootId, int requestBy) throws com.liferay.portal.SystemException;

	public boolean deleteOverTimeReq(int rootId, int reqId);
}