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
 * <a href="LmisAbsenceRequestsLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LmisAbsenceRequestsLocalService {
	public larion.progate.lmis.model.LmisAbsenceRequests addLmisAbsenceRequests(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests createLmisAbsenceRequests(
		java.lang.Integer lmisAbsenceRequestsId);

	public void deleteLmisAbsenceRequests(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteLmisAbsenceRequests(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.lmis.model.LmisAbsenceRequests getLmisAbsenceRequests(
		java.lang.Integer lmisAbsenceRequestsId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLmisAbsenceRequestsesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests updateLmisAbsenceRequests(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceRequests updateLmisAbsenceRequests(
		larion.progate.lmis.model.LmisAbsenceRequests lmisAbsenceRequests,
		boolean merge) throws com.liferay.portal.SystemException;

	public java.lang.String funcNameAbsence(int absenceId)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getListAbsenceReqUser(
		int rootId, int userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getListAbsenceReqRolePmOrBod(
		int rootId, int userId);

	public int countRequestPending(int rootId, int userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getListAbsenceReqRoleSpec(
		int rootId);

	public int addAbsenceReq(int rootId, int userId, java.util.Date startDate,
		java.util.Date endDate, int startSession, int endSession,
		java.lang.String requestReason, java.lang.String absenceType,
		int absenceId) throws com.liferay.portal.SystemException;

	public int editAbsenceReq(int reqId, java.util.Date startDate,
		java.util.Date endDate, int startSession, int endSession,
		java.lang.String requestReason, java.lang.String absenceType,
		int absenceId) throws com.liferay.portal.SystemException;

	public boolean deleteAbsenceReq(int rootId, int userId, int absenceId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean doApprove(int userId, int reqId, boolean isApprove,
		java.lang.String reasonApprove)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.lmis.model.LmisAbsenceRequests getDetailAbsenceReq(
		int rootId, int userId, int absenceId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> getListAbsenceTypeOfRoot(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getContentApprove(int absenceId)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getListRequestApprovedBy(
		int rootId, int userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getStatisticForms(
		int rootId, java.util.Date dayValue);

	public int checkAbsenceTypeSpec(int rootId, int absenceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> getListAbsenceOfRootId(
		int rootId);

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> filterTabManager(
		int rootId, int userId, int absType, int status);

	public boolean addUnexpectedAbsenceReq(int rootId, int attendanceId,
		int session, java.lang.String requestReason);
}