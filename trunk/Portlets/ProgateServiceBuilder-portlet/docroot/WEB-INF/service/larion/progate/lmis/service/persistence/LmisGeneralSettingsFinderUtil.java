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
 * <a href="LmisGeneralSettingsFinderUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisGeneralSettingsFinderUtil {
	public static java.lang.String caculateTotalDayOffHavePermission(
		int userid, int month, int year, int rootid)
		throws com.liferay.portal.SystemException {
		return getFinder()
				   .caculateTotalDayOffHavePermission(userid, month, year,
			rootid);
	}

	public static java.lang.String caculateTotalDayOffDontHavePermission(
		int userid, int month, int year, int rootid)
		throws com.liferay.portal.SystemException {
		return getFinder()
				   .caculateTotalDayOffDontHavePermission(userid, month, year,
			rootid);
	}

	public static java.lang.String caculateTimeRemainTimeChangeRequest(
		int userid, int rootid) throws com.liferay.portal.SystemException {
		return getFinder().caculateTimeRemainTimeChangeRequest(userid, rootid);
	}

	public static java.util.Date getBlock(int rootId, int userId,
		java.lang.String dayStr, int sessionType, int blockType) {
		return getFinder()
				   .getBlock(rootId, userId, dayStr, sessionType, blockType);
	}

	public static java.util.List<Integer> getListBodUIDofUID(int rootId,
		int userId) {
		return getFinder().getListBodUIDofUID(rootId, userId);
	}

	public static java.lang.String getMaxTimeChangeReqEndDate(int rootId,
		int userId) throws java.lang.Exception {
		return getFinder().getMaxTimeChangeReqEndDate(rootId, userId);
	}

	public static java.lang.String updateRoleUser(int orgId, int userId,
		int oldRole, int newRole) throws com.liferay.portal.SystemException {
		return getFinder().updateRoleUser(orgId, userId, oldRole, newRole);
	}

	public static int caculateDayWillOff(int rootId, java.util.Date startDate,
		java.util.Date endDate, int startSession, int endSession) {
		return getFinder()
				   .caculateDayWillOff(rootId, startDate, endDate,
			startSession, endSession);
	}

	public static double getOtHourYesterday(int userId,
		java.util.Date requestedAt, int rootId) {
		return getFinder().getOtHourYesterday(userId, requestedAt, rootId);
	}

	public static double getTotalWorkingTimeOfUID(int rootId, int userId,
		int month, int year) {
		return getFinder().getTotalWorkingTimeOfUID(rootId, userId, month, year);
	}

	public static double getTypeAbsenceInMonthlyDetail(int rootId, int userId,
		int mon, int year, int absenceId, int type) {
		return getFinder()
				   .getTypeAbsenceInMonthlyDetail(rootId, userId, mon, year,
			absenceId, type);
	}

	public static double getTypeAbsenceInYearDetail(int rootId, int userId,
		int year, int absenceId, int type) {
		return getFinder()
				   .getTypeAbsenceInYearDetail(rootId, userId, year, absenceId,
			type);
	}

	public static double getTotalDayOffOfUID(int rootId, int userId, int month,
		int year) {
		return getFinder().getTotalDayOffOfUID(rootId, userId, month, year);
	}

	public static double getTotalTimeFinalRewardOfUID(int rootId, int userId,
		int month, int year) {
		return getFinder()
				   .getTotalTimeFinalRewardOfUID(rootId, userId, month, year);
	}

	public static double getTotalHourOverTimeOfStaffInMonth(int rootId,
		int userId, int month, int year, int otId, boolean isEff) {
		return getFinder()
				   .getTotalHourOverTimeOfStaffInMonth(rootId, userId, month,
			year, otId, isEff);
	}

	public static double getOverTimeHourFinalOfStaffInMonth(int rootId,
		int userId, int month, int year) {
		return getFinder()
				   .getOverTimeHourFinalOfStaffInMonth(rootId, userId, month,
			year);
	}

	public static double getTotalDayAbsenceCompensasion(int rootId, int userId,
		int month, int year, int type) {
		return getFinder()
				   .getTotalDayAbsenceCompensasion(rootId, userId, month, year,
			type);
	}

	public static double getDayCompensationNextMonthOfStaffInMonth(int rootId,
		int userId, int month, int year) {
		return getFinder()
				   .getDayCompensationNextMonthOfStaffInMonth(rootId, userId,
			month, year);
	}

	public static double getTotalHourOverTimeReward(int rootId, int userId,
		int month, int year) {
		return getFinder()
				   .getTotalHourOverTimeReward(rootId, userId, month, year);
	}

	public static java.util.Date getDetailSummayReportDate(int rootId,
		int userId, int year, int monStart, int monEnd, int type) {
		return getFinder()
				   .getDetailSummayReportDate(rootId, userId, year, monStart,
			monEnd, type);
	}

	public static int getDetailSummayReportInt(int rootId, int userId,
		int year, int monStart, int monEnd, int type) {
		return getFinder()
				   .getDetailSummayReportInt(rootId, userId, year, monStart,
			monEnd, type);
	}

	public static double getDetailSummayReportDouble(int rootId, int userId,
		int year, int monStart, int monEnd, int type) {
		return getFinder()
				   .getDetailSummayReportDouble(rootId, userId, year, monStart,
			monEnd, type);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> getInfoConfigFileAttendance(
		int rootId) {
		return getFinder().getInfoConfigFileAttendance(rootId);
	}

	public static boolean updateInfoConfigFileAttendance(int rootId,
		java.lang.String code, java.lang.String name, java.lang.String chkIn,
		java.lang.String chkOut) {
		return getFinder()
				   .updateInfoConfigFileAttendance(rootId, code, name, chkIn,
			chkOut);
	}

	public static double getTotalDayCompensationRemaining(int rootId,
		int userId, int mon, int year) {
		return getFinder()
				   .getTotalDayCompensationRemaining(rootId, userId, mon, year);
	}

	public static double getTotalDayAwardPrevYearRemaining(int rootId,
		int userId, int year) {
		return getFinder()
				   .getTotalDayAwardPrevYearRemaining(rootId, userId, year);
	}

	public static double getTotalDayAwardRemaining(int rootId, int userId,
		int year) {
		return getFinder().getTotalDayAwardRemaining(rootId, userId, year);
	}

	public static java.lang.String getAppName() {
		return getFinder().getAppName();
	}

	public static LmisGeneralSettingsFinder getFinder() {
		return _finder;
	}

	public void setFinder(LmisGeneralSettingsFinder finder) {
		_finder = finder;
	}

	private static LmisGeneralSettingsFinder _finder;
}