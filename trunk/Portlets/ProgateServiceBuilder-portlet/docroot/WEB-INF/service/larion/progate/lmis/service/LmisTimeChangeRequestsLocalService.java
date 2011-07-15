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
 * <a href="LmisTimeChangeRequestsLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LmisTimeChangeRequestsLocalService {
	public larion.progate.lmis.model.LmisTimeChangeRequests addLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisTimeChangeRequests createLmisTimeChangeRequests(
		java.lang.Integer lmisTimeChangeRequestId);

	public void deleteLmisTimeChangeRequests(
		java.lang.Integer lmisTimeChangeRequestId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.lmis.model.LmisTimeChangeRequests getLmisTimeChangeRequests(
		java.lang.Integer lmisTimeChangeRequestId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> getLmisTimeChangeRequestses(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLmisTimeChangeRequestsesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisTimeChangeRequests updateLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisTimeChangeRequests updateLmisTimeChangeRequests(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests,
		boolean merge) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> getListRequestTimeChangeOf(
		int rootId, int userId) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.lmis.model.LmisTimeChangeRequests getDetailRequestTimeChange(
		int rootId, int requestId) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getContentApprovals(int rootId, int requestId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean editRequestTimeChange(int rootId, int requestId,
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date monStartTime, java.util.Date monEndTime,
		java.util.Date tueStartDate, java.util.Date tueEndTime,
		java.util.Date wedStartTime, java.util.Date wedEndTime,
		java.util.Date thuStartTime, java.util.Date thuEndTime,
		java.util.Date friStartTime, java.util.Date friEndTime,
		java.util.Date satStartTime, java.util.Date satEndTime,
		java.lang.String requestReason)
		throws com.liferay.portal.SystemException;

	public boolean addRequestTimeChange(int rootId, int userId,
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date monStartTime, java.util.Date monEndTime,
		java.util.Date tueStartTime, java.util.Date tueEndTime,
		java.util.Date wedStartTime, java.util.Date wedEndTime,
		java.util.Date thuStartTime, java.util.Date thuEndTime,
		java.util.Date friStartTime, java.util.Date friEndTime,
		java.util.Date satStartTime, java.util.Date satEndTime,
		java.lang.String requestReason)
		throws com.liferay.portal.SystemException;

	public boolean doApproveIt(int rootId, int approvedBy, int requestId,
		boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException;

	public int deleteChangeTimeReq(int rootId, int userId, int reqId)
		throws com.liferay.portal.SystemException;

	public int countTimeChangeReqs(int rootId, int userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getMaxTimeChangeReqEndDate(int rootId, int userId);
}