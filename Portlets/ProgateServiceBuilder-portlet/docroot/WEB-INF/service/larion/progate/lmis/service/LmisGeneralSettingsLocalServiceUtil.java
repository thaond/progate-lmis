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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="LmisGeneralSettingsLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisGeneralSettingsLocalServiceUtil {
	public static larion.progate.lmis.model.LmisGeneralSettings addLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException {
		return getService().addLmisGeneralSettings(lmisGeneralSettings);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings createLmisGeneralSettings(
		java.lang.Integer lmisGeneralSettingId) {
		return getService().createLmisGeneralSettings(lmisGeneralSettingId);
	}

	public static void deleteLmisGeneralSettings(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLmisGeneralSettings(lmisGeneralSettingId);
	}

	public static void deleteLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException {
		getService().deleteLmisGeneralSettings(lmisGeneralSettings);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings getLmisGeneralSettings(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLmisGeneralSettings(lmisGeneralSettingId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> getLmisGeneralSettingses(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLmisGeneralSettingses(start, end);
	}

	public static int getLmisGeneralSettingsesCount()
		throws com.liferay.portal.SystemException {
		return getService().getLmisGeneralSettingsesCount();
	}

	public static larion.progate.lmis.model.LmisGeneralSettings updateLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException {
		return getService().updateLmisGeneralSettings(lmisGeneralSettings);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings updateLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateLmisGeneralSettings(lmisGeneralSettings, merge);
	}

	public static java.util.Set<Integer> getArrayListPmUID(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> ls,
		int userId) {
		return getService().getArrayListPmUID(ls, userId);
	}

	public static java.util.List<Integer> getListBodUIDofUID(int rootId,
		int userId) {
		return getService().getListBodUIDofUID(rootId, userId);
	}

	public static java.util.List<Integer> getListPmIdOrBodIdByUserId(
		int rootId, int userId) {
		return getService().getListPmIdOrBodIdByUserId(rootId, userId);
	}

	public static java.util.Set<Integer> getArrayListBodUID(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> ls,
		int userId) {
		return getService().getArrayListBodUID(ls, userId);
	}

	public static java.lang.String getUserRoleByUID(int userId, int orgId) {
		return getService().getUserRoleByUID(userId, orgId);
	}

	public static java.util.List<Integer> getListPmAndBodOfUser(int rootId,
		int userId) {
		return getService().getListPmAndBodOfUser(rootId, userId);
	}

	public static java.util.Date GetToday()
		throws com.liferay.portal.SystemException {
		return getService().GetToday();
	}

	public static java.util.Date GetYesterdayDate()
		throws com.liferay.portal.SystemException {
		return getService().GetYesterdayDate();
	}

	public static long getTimeDiff(java.util.Date hour1, java.util.Date hour2) {
		return getService().getTimeDiff(hour1, hour2);
	}

	public static java.lang.String getEmailUser(int userId, int rootId) {
		return getService().getEmailUser(userId, rootId);
	}

	public static java.lang.String getEmailOrg(int orgId) {
		return getService().getEmailOrg(orgId);
	}

	public static java.util.List<larion.progate.model.Organization> getOrganizationByRootId(
		int rootId) {
		return getService().getOrganizationByRootId(rootId);
	}

	public static java.util.ArrayList<Integer> getListBodUIDbyRootId(int rootId) {
		return getService().getListBodUIDbyRootId(rootId);
	}

	public static java.util.ArrayList<Integer> getListUserMangeByPM(
		int rootId, int pmId) throws com.liferay.portal.SystemException {
		return getService().getListUserMangeByPM(rootId, pmId);
	}

	public static java.util.Date getBlock(int rootId, int userId,
		java.lang.String dayStr, int sessiontype, int blocktype) {
		return getService()
				   .getBlock(rootId, userId, dayStr, sessiontype, blocktype);
	}

	public static java.lang.String getBlockStr(int rootId, int userId,
		java.lang.String dayStr, int sessiontype, int blocktype) {
		return getService()
				   .getBlockStr(rootId, userId, dayStr, sessiontype, blocktype);
	}

	public static java.util.Date getRangeGoHomeEarly(int rootId,
		java.lang.String sessionName) {
		return getService().getRangeGoHomeEarly(rootId, sessionName);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> loadListProGateOrgStaff(
		int orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().loadListProGateOrgStaff(orgId);
	}

	public static java.lang.String caculateTotalDayOffHavePermission(
		int userid, int month, int year, int rootid)
		throws com.liferay.portal.SystemException {
		return getService()
				   .caculateTotalDayOffHavePermission(userid, month, year,
			rootid);
	}

	public static java.lang.String caculateTotalDayOffDontHavePermission(
		int userid, int month, int year, int rootid)
		throws com.liferay.portal.SystemException {
		return getService()
				   .caculateTotalDayOffDontHavePermission(userid, month, year,
			rootid);
	}

	public static java.lang.String caculateTimeRemainTimeChangeRequest(
		int userid, int rootid) throws com.liferay.portal.SystemException {
		return getService().caculateTimeRemainTimeChangeRequest(userid, rootid);
	}

	public static java.util.List<String> getListEmailByEmailType(int rootId,
		int userId, int emailType) {
		return getService().getListEmailByEmailType(rootId, userId, emailType);
	}

	public static java.util.List<String> getListEmail(
		java.util.List<Integer> user_Ids, int userId, int rootId, int id) {
		return getService().getListEmail(user_Ids, userId, rootId, id);
	}

	public static long DateDiff(java.util.Date dMax, java.util.Date dMin) {
		return getService().DateDiff(dMax, dMin);
	}

	public static double getTotalDayAwardPrevYear(int rootid, int userId,
		int year) {
		return getService().getTotalDayAwardPrevYear(rootid, userId, year);
	}

	public static double getTotalDayAward(int rootid, int userId, int year) {
		return getService().getTotalDayAward(rootid, userId, year);
	}

	public static double getTotalDayCompensation(int rootid, int userId,
		int year, int month) {
		return getService().getTotalDayCompensation(rootid, userId, year, month);
	}

	public static double getTotalWorkingTimeOfUID(int rootId, int userId,
		int month, int year) {
		return getService().getTotalWorkingTimeOfUID(rootId, userId, month, year);
	}

	public static double getTypeAbsenceInMonthlyDetail(int rootId, int userId,
		int mon, int year, int absenceId, int type) {
		return getService()
				   .getTypeAbsenceInMonthlyDetail(rootId, userId, mon, year,
			absenceId, type);
	}

	public static double getTypeAbsenceInYearDetail(int rootId, int userId,
		int year, int absenceId, int type) {
		return getService()
				   .getTypeAbsenceInYearDetail(rootId, userId, year, absenceId,
			type);
	}

	public static double getTotalDayOffOfUID(int rootId, int userId, int month,
		int year) {
		return getService().getTotalDayOffOfUID(rootId, userId, month, year);
	}

	public static double getTotalTimeFinalRewardOfUID(int rootId, int userId,
		int month, int year) {
		return getService()
				   .getTotalTimeFinalRewardOfUID(rootId, userId, month, year);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> getListOverTimeTypeOfRootId(
		int rootId) {
		return getService().getListOverTimeTypeOfRootId(rootId);
	}

	public static double getTotalHourOverTimeOfStaffInMonth(int rootId,
		int userId, int month, int year, int otId, boolean Eff) {
		return getService()
				   .getTotalHourOverTimeOfStaffInMonth(rootId, userId, month,
			year, otId, Eff);
	}

	public static double getOverTimeHourFinalOfStaffInMonth(int rootId,
		int userId, int month, int year) {
		return getService()
				   .getOverTimeHourFinalOfStaffInMonth(rootId, userId, month,
			year);
	}

	public static double getTotalDayAbsenceCompensasion(int rootId, int userId,
		int month, int year, int type) {
		return getService()
				   .getTotalDayAbsenceCompensasion(rootId, userId, month, year,
			type);
	}

	public static double getDayCompensationNextMonthOfStaffInMonth(int rootId,
		int userId, int month, int year) {
		return getService()
				   .getDayCompensationNextMonthOfStaffInMonth(rootId, userId,
			month, year);
	}

	public static double getTotalHourOverTimeReward(int rootId, int userId,
		int month, int year) {
		return getService()
				   .getTotalHourOverTimeReward(rootId, userId, month, year);
	}

	public static java.util.Date getDetailSummayReportDate(int rootId,
		int userId, int year, int monStart, int monEnd, int type) {
		return getService()
				   .getDetailSummayReportDate(rootId, userId, year, monStart,
			monEnd, type);
	}

	public static int getDetailSummayReportInt(int rootId, int userId,
		int year, int monStart, int monEnd, int type) {
		return getService()
				   .getDetailSummayReportInt(rootId, userId, year, monStart,
			monEnd, type);
	}

	public static double getDetailSummayReportDouble(int rootId, int userId,
		int year, int monStart, int monEnd, int type) {
		return getService()
				   .getDetailSummayReportDouble(rootId, userId, year, monStart,
			monEnd, type);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> getInfoConfigFileAttendance(
		int rootId) {
		return getService().getInfoConfigFileAttendance(rootId);
	}

	public static boolean updateInfoConfigFileAttendance(int rootId,
		java.lang.String code, java.lang.String name, java.lang.String chkIn,
		java.lang.String chkOut) {
		return getService()
				   .updateInfoConfigFileAttendance(rootId, code, name, chkIn,
			chkOut);
	}

	public static double getTotalDayAwardRemaining(int rootId, int userId,
		int year) {
		return getService().getTotalDayAwardRemaining(rootId, userId, year);
	}

	public static double getTotalDayAwardPrevYearRemaining(int rootId,
		int userId, int year) {
		return getService()
				   .getTotalDayAwardPrevYearRemaining(rootId, userId, year);
	}

	public static double getTotalDayCompensationRemaining(int rootId,
		int userId, int mon, int year) {
		return getService()
				   .getTotalDayCompensationRemaining(rootId, userId, mon, year);
	}

	public static java.lang.String getAppName() {
		return getService().getAppName();
	}

	public static java.lang.String getStaffCodeByUID(int rootId, int userId) {
		return getService().getStaffCodeByUID(rootId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LmisGeneralSettingsLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LmisGeneralSettingsLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LmisGeneralSettingsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LmisGeneralSettingsLocalService service) {
		_service = service;
	}

	private static LmisGeneralSettingsLocalService _service;
}