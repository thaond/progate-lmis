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
 * <a href="LmisAttendanceDailyLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LmisAttendanceDailyLocalService {
	public larion.progate.lmis.model.LmisAttendanceDaily addLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily createLmisAttendanceDaily(
		java.lang.Integer lmisAttendanceDailyId);

	public void deleteLmisAttendanceDaily(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.lmis.model.LmisAttendanceDaily getLmisAttendanceDaily(
		java.lang.Integer lmisAttendanceDailyId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLmisAttendanceDailiesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily updateLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttendanceDaily updateLmisAttendanceDaily(
		larion.progate.lmis.model.LmisAttendanceDaily lmisAttendanceDaily,
		boolean merge) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Date getStartTimeToday(int userId,
		java.util.Date dayValue, int rootId)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getStartTimeLateToday(int userId, java.util.Date dayValue,
		int rootId) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Date getEndTimeYesterday(int userId,
		java.util.Date dayValue, int rootId)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getEndTimeEarlyYesterDay(int userId, java.util.Date dayValue,
		int rootId) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getListDetailsDayOff(
		int rootId, int userId, java.util.Date cur);

	public double caculateTotalDayOffDontHavePermission_(int userId, int rootId)
		throws com.liferay.portal.SystemException;

	public double caculateTotalDayOffHavePermission_(int userId, int rootId)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalDayOffInMonth_(int userId, int rootId)
		throws com.liferay.portal.SystemException;
}