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
 * <a href="LmisGeneralSettingsLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LmisGeneralSettingsLocalService {
	public larion.progate.lmis.model.LmisGeneralSettings addLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisGeneralSettings createLmisGeneralSettings(
		java.lang.Integer lmisGeneralSettingId);

	public void deleteLmisGeneralSettings(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.lmis.model.LmisGeneralSettings getLmisGeneralSettings(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> getLmisGeneralSettingses(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLmisGeneralSettingsesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisGeneralSettings updateLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisGeneralSettings updateLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings,
		boolean merge) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Set<Integer> getArrayListPmUID(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> ls,
		int userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<Integer> getListBodUIDofUID(int rootId, int userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<Integer> getListPmIdOrBodIdByUserId(int rootId,
		int userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Set<Integer> getArrayListBodUID(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> ls,
		int userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUserRoleByUID(int userId, int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<Integer> getListPmAndBodOfUser(int rootId, int userId);

	public java.util.Date GetToday() throws com.liferay.portal.SystemException;

	public java.util.Date GetYesterdayDate()
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTimeDiff(java.util.Date hour1, java.util.Date hour2);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getEmailUser(int userId, int rootId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getEmailOrg(int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getOrganizationByRootId(
		int rootId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.ArrayList<Integer> getListBodUIDbyRootId(int rootId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.ArrayList<Integer> getListUserMangeByPM(int rootId,
		int pmId) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Date getBlock(int rootId, int userId,
		java.lang.String dayStr, int sessiontype, int blocktype);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getBlockStr(int rootId, int userId,
		java.lang.String dayStr, int sessiontype, int blocktype);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Date getRangeGoHomeEarly(int rootId,
		java.lang.String sessionName);

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> loadListProGateOrgStaff(
		int orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public java.lang.String caculateTotalDayOffHavePermission(int userid,
		int month, int year, int rootid)
		throws com.liferay.portal.SystemException;

	public java.lang.String caculateTotalDayOffDontHavePermission(int userid,
		int month, int year, int rootid)
		throws com.liferay.portal.SystemException;

	public java.lang.String caculateTimeRemainTimeChangeRequest(int userid,
		int rootid) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<String> getListEmailByEmailType(int rootId,
		int userId, int emailType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<String> getListEmail(
		java.util.List<Integer> user_Ids, int userId, int rootId, int id);

	public long DateDiff(java.util.Date dMax, java.util.Date dMin);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalDayAwardPrevYear(int rootid, int userId, int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalDayAward(int rootid, int userId, int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalDayCompensation(int rootid, int userId, int year,
		int month);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalWorkingTimeOfUID(int rootId, int userId, int month,
		int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTypeAbsenceInMonthlyDetail(int rootId, int userId,
		int mon, int year, int absenceId, int type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTypeAbsenceInYearDetail(int rootId, int userId, int year,
		int absenceId, int type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalDayOffOfUID(int rootId, int userId, int month,
		int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalTimeFinalRewardOfUID(int rootId, int userId,
		int month, int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> getListOverTimeTypeOfRootId(
		int rootId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalHourOverTimeOfStaffInMonth(int rootId, int userId,
		int month, int year, int otId, boolean Eff);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getOverTimeHourFinalOfStaffInMonth(int rootId, int userId,
		int month, int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalDayAbsenceCompensasion(int rootId, int userId,
		int month, int year, int type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getDayCompensationNextMonthOfStaffInMonth(int rootId,
		int userId, int month, int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalHourOverTimeReward(int rootId, int userId, int month,
		int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Date getDetailSummayReportDate(int rootId, int userId,
		int year, int monStart, int monEnd, int type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDetailSummayReportInt(int rootId, int userId, int year,
		int monStart, int monEnd, int type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getDetailSummayReportDouble(int rootId, int userId, int year,
		int monStart, int monEnd, int type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> getInfoConfigFileAttendance(
		int rootId);

	public boolean updateInfoConfigFileAttendance(int rootId,
		java.lang.String code, java.lang.String name, java.lang.String chkIn,
		java.lang.String chkOut);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalDayAwardRemaining(int rootId, int userId, int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalDayAwardPrevYearRemaining(int rootId, int userId,
		int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalDayCompensationRemaining(int rootId, int userId,
		int mon, int year);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getAppName();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getStaffCodeByUID(int rootId, int userId);
}