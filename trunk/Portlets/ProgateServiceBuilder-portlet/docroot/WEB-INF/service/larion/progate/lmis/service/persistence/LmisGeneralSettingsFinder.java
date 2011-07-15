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
 * <a href="LmisGeneralSettingsFinder.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisGeneralSettingsFinder {
	public java.lang.String caculateTotalDayOffHavePermission(int userid,
		int month, int year, int rootid)
		throws com.liferay.portal.SystemException;

	public java.lang.String caculateTotalDayOffDontHavePermission(int userid,
		int month, int year, int rootid)
		throws com.liferay.portal.SystemException;

	public java.lang.String caculateTimeRemainTimeChangeRequest(int userid,
		int rootid) throws com.liferay.portal.SystemException;

	public java.util.Date getBlock(int rootId, int userId,
		java.lang.String dayStr, int sessionType, int blockType);

	public java.util.List<Integer> getListBodUIDofUID(int rootId, int userId);

	public java.lang.String getMaxTimeChangeReqEndDate(int rootId, int userId)
		throws java.lang.Exception;

	public java.lang.String updateRoleUser(int orgId, int userId, int oldRole,
		int newRole) throws com.liferay.portal.SystemException;

	public int caculateDayWillOff(int rootId, java.util.Date startDate,
		java.util.Date endDate, int startSession, int endSession);

	public double getTotalWorkingTimeOfUID(int rootId, int userId, int month,
		int year);

	public double getTypeAbsenceInMonthlyDetail(int rootId, int userId,
		int mon, int year, int absenceId, int type);

	public double getTypeAbsenceInYearDetail(int rootId, int userId, int year,
		int absenceId, int type);

	public double getTotalDayOffOfUID(int rootId, int userId, int month,
		int year);

	public double getTotalTimeFinalRewardOfUID(int rootId, int userId,
		int month, int year);

	public double getTotalHourOverTimeOfStaffInMonth(int rootId, int userId,
		int month, int year, int otId, boolean isEff);

	public double getOverTimeHourFinalOfStaffInMonth(int rootId, int userId,
		int month, int year);

	public double getTotalDayAbsenceCompensasion(int rootId, int userId,
		int month, int year, int type);

	public double getDayCompensationNextMonthOfStaffInMonth(int rootId,
		int userId, int month, int year);

	public double getTotalHourOverTimeReward(int rootId, int userId, int month,
		int year);

	public java.util.Date getDetailSummayReportDate(int rootId, int userId,
		int year, int monStart, int monEnd, int type);

	public int getDetailSummayReportInt(int rootId, int userId, int year,
		int monStart, int monEnd, int type);

	public double getDetailSummayReportDouble(int rootId, int userId, int year,
		int monStart, int monEnd, int type);

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> getInfoConfigFileAttendance(
		int rootId);

	public boolean updateInfoConfigFileAttendance(int rootId,
		java.lang.String code, java.lang.String name, java.lang.String chkIn,
		java.lang.String chkOut);

	public double getTotalDayCompensationRemaining(int rootId, int userId,
		int mon, int year);

	public double getTotalDayAwardPrevYearRemaining(int rootId, int userId,
		int year);

	public double getTotalDayAwardRemaining(int rootId, int userId, int year);

	public java.lang.String getAppName();
}