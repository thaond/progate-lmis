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

package larion.progate.lmis.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import larion.progate.lmis.service.LmisAbsenceApprovalsLocalService;
import larion.progate.lmis.service.LmisAbsenceApprovalsService;
import larion.progate.lmis.service.LmisAbsenceMonthlyLocalService;
import larion.progate.lmis.service.LmisAbsenceMonthlyService;
import larion.progate.lmis.service.LmisAbsenceRequestsLocalService;
import larion.progate.lmis.service.LmisAbsenceRequestsService;
import larion.progate.lmis.service.LmisAbsenceSettingsLocalService;
import larion.progate.lmis.service.LmisAbsenceSettingsService;
import larion.progate.lmis.service.LmisAbsenceYearlyLocalService;
import larion.progate.lmis.service.LmisAbsenceYearlyService;
import larion.progate.lmis.service.LmisAttMonthlyLocalService;
import larion.progate.lmis.service.LmisAttYearlyLocalService;
import larion.progate.lmis.service.LmisAttendanceDailyLocalService;
import larion.progate.lmis.service.LmisAttendanceDailyService;
import larion.progate.lmis.service.LmisDataImportDetailsLocalService;
import larion.progate.lmis.service.LmisDataImportDetailsService;
import larion.progate.lmis.service.LmisDataImportsLocalService;
import larion.progate.lmis.service.LmisDataImportsService;
import larion.progate.lmis.service.LmisDataInputsLocalService;
import larion.progate.lmis.service.LmisDataInputsService;
import larion.progate.lmis.service.LmisDayTypesLocalService;
import larion.progate.lmis.service.LmisDayTypesService;
import larion.progate.lmis.service.LmisEmailSettingDetailsLocalService;
import larion.progate.lmis.service.LmisEmailSettingDetailsService;
import larion.progate.lmis.service.LmisEmailSettingsLocalService;
import larion.progate.lmis.service.LmisEmailSettingsService;
import larion.progate.lmis.service.LmisGeneralSettingsLocalService;
import larion.progate.lmis.service.LmisGeneralSettingsService;
import larion.progate.lmis.service.LmisOverTimeReportDetailsLocalService;
import larion.progate.lmis.service.LmisOverTimeReportDetailsService;
import larion.progate.lmis.service.LmisOverTimeReportHoursLocalService;
import larion.progate.lmis.service.LmisOverTimeReportHoursService;
import larion.progate.lmis.service.LmisOverTimeReportsLocalService;
import larion.progate.lmis.service.LmisOverTimeReportsService;
import larion.progate.lmis.service.LmisOverTimeSettingsLocalService;
import larion.progate.lmis.service.LmisOverTimeSettingsService;
import larion.progate.lmis.service.LmisOverTimeTypesLocalService;
import larion.progate.lmis.service.LmisOverTimeTypesService;
import larion.progate.lmis.service.LmisOvertimeApprovalsLocalService;
import larion.progate.lmis.service.LmisOvertimeApprovalsService;
import larion.progate.lmis.service.LmisOvertimeMonthlyLocalService;
import larion.progate.lmis.service.LmisOvertimeMonthlyService;
import larion.progate.lmis.service.LmisOvertimeRequestDetailsLocalService;
import larion.progate.lmis.service.LmisOvertimeRequestDetailsService;
import larion.progate.lmis.service.LmisOvertimeRequestsLocalService;
import larion.progate.lmis.service.LmisOvertimeRequestsService;
import larion.progate.lmis.service.LmisOvertimeYearlyLocalService;
import larion.progate.lmis.service.LmisOvertimeYearlyService;
import larion.progate.lmis.service.LmisTimeChangeApprovalsLocalService;
import larion.progate.lmis.service.LmisTimeChangeApprovalsService;
import larion.progate.lmis.service.LmisTimeChangeRequestsLocalService;
import larion.progate.lmis.service.LmisTimeChangeRequestsService;
import larion.progate.lmis.service.LmisViewAttDailyLocalService;
import larion.progate.lmis.service.LmisViewAttInfoLocalService;
import larion.progate.lmis.service.LmisViewAttdanceLocalService;
import larion.progate.lmis.service.LmisViewDayTypeOverTimeSettingTypeLocalService;
import larion.progate.lmis.service.LmisViewDayTypeOverTimeSettingTypeService;
import larion.progate.lmis.service.LmisViewDayValueMaxLocalService;
import larion.progate.lmis.service.LmisViewDayValueMaxService;
import larion.progate.lmis.service.LmisViewEmailSettingDetailOrgLocalService;
import larion.progate.lmis.service.LmisViewEmailSettingDetailOrgService;
import larion.progate.lmis.service.LmisViewEmailSettingDetailUserLocalService;
import larion.progate.lmis.service.LmisViewEmailSettingDetailUserService;
import larion.progate.lmis.service.LmisViewOTAppLocalService;
import larion.progate.lmis.service.LmisViewOTAppService;
import larion.progate.lmis.service.LmisViewOrgUserRolesLocalService;
import larion.progate.lmis.service.LmisViewOrgUserRolesService;
import larion.progate.lmis.service.LmisViewOvertimeReportDetailLocalService;
import larion.progate.lmis.service.LmisViewOvertimeReportDetailService;
import larion.progate.lmis.service.LmisViewOvertimeReportLocalService;
import larion.progate.lmis.service.LmisViewOvertimeReportService;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalService;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeService;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeaApprovalLocalService;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeaApprovalService;
import larion.progate.lmis.service.LmisViewReportOvertimeApprovalLocalService;
import larion.progate.lmis.service.LmisViewReportOvertimeApprovalService;
import larion.progate.lmis.service.LmisViewReportOvertimeLocalService;
import larion.progate.lmis.service.LmisViewReportOvertimeService;
import larion.progate.lmis.service.LmisViewStaffMappingLocalService;
import larion.progate.lmis.service.LmisViewStaffMappingPmLocalService;
import larion.progate.lmis.service.LmisViewStaffMappingPmService;
import larion.progate.lmis.service.LmisViewStaffMappingService;
import larion.progate.lmis.service.LmisViewStaffRootOrgFNLocalService;
import larion.progate.lmis.service.LmisViewStaffRootOrgFNService;
import larion.progate.lmis.service.LmisViewStaffRootOrgLocalService;
import larion.progate.lmis.service.LmisViewStaffRootOrgOrderedLocalService;
import larion.progate.lmis.service.LmisViewStaffRootOrgOrderedService;
import larion.progate.lmis.service.LmisViewStaffRootOrgService;
import larion.progate.lmis.service.LmisViewTimeChangeReqsLocalService;
import larion.progate.lmis.service.LmisViewTimeChangeReqsService;
import larion.progate.lmis.service.LmisViewWorkingCalendarLocalService;
import larion.progate.lmis.service.LmisViewWorkingCalendarService;
import larion.progate.lmis.service.LmisWorkingCalendarSessionsLocalService;
import larion.progate.lmis.service.LmisWorkingCalendarSessionsService;
import larion.progate.lmis.service.LmisWorkingCalendarsLocalService;
import larion.progate.lmis.service.LmisWorkingCalendarsService;
import larion.progate.lmis.service.LmisWorkingTimesLocalService;
import larion.progate.lmis.service.LmisWorkingTimesService;
import larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistence;
import larion.progate.lmis.service.persistence.LmisAbsenceMonthlyPersistence;
import larion.progate.lmis.service.persistence.LmisAbsenceRequestsFinder;
import larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistence;
import larion.progate.lmis.service.persistence.LmisAbsenceSettingsPersistence;
import larion.progate.lmis.service.persistence.LmisAbsenceYearlyFinder;
import larion.progate.lmis.service.persistence.LmisAbsenceYearlyPersistence;
import larion.progate.lmis.service.persistence.LmisAttMonthlyPersistence;
import larion.progate.lmis.service.persistence.LmisAttYearlyPersistence;
import larion.progate.lmis.service.persistence.LmisAttendanceDailyFinder;
import larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistence;
import larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistence;
import larion.progate.lmis.service.persistence.LmisDataImportsPersistence;
import larion.progate.lmis.service.persistence.LmisDataInputsPersistence;
import larion.progate.lmis.service.persistence.LmisDayTypesPersistence;
import larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistence;
import larion.progate.lmis.service.persistence.LmisEmailSettingsPersistence;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsFinder;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsPersistence;
import larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistence;
import larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistence;
import larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistence;
import larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistence;
import larion.progate.lmis.service.persistence.LmisOverTimeTypesPersistence;
import larion.progate.lmis.service.persistence.LmisOvertimeApprovalsFinder;
import larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistence;
import larion.progate.lmis.service.persistence.LmisOvertimeMonthlyPersistence;
import larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistence;
import larion.progate.lmis.service.persistence.LmisOvertimeRequestsPersistence;
import larion.progate.lmis.service.persistence.LmisOvertimeYearlyPersistence;
import larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistence;
import larion.progate.lmis.service.persistence.LmisTimeChangeRequestsPersistence;
import larion.progate.lmis.service.persistence.LmisViewAttDailyFinder;
import larion.progate.lmis.service.persistence.LmisViewAttDailyPersistence;
import larion.progate.lmis.service.persistence.LmisViewAttInfoFinder;
import larion.progate.lmis.service.persistence.LmisViewAttInfoPersistence;
import larion.progate.lmis.service.persistence.LmisViewAttdanceFinder;
import larion.progate.lmis.service.persistence.LmisViewAttdancePersistence;
import larion.progate.lmis.service.persistence.LmisViewDayTypeOverTimeSettingTypePersistence;
import larion.progate.lmis.service.persistence.LmisViewDayValueMaxPersistence;
import larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailOrgPersistence;
import larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserPersistence;
import larion.progate.lmis.service.persistence.LmisViewOTAppPersistence;
import larion.progate.lmis.service.persistence.LmisViewOrgUserRolesPersistence;
import larion.progate.lmis.service.persistence.LmisViewOvertimeReportDetailPersistence;
import larion.progate.lmis.service.persistence.LmisViewOvertimeReportPersistence;
import larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeFinder;
import larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimePersistence;
import larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeaApprovalPersistence;
import larion.progate.lmis.service.persistence.LmisViewReportOvertimeApprovalPersistence;
import larion.progate.lmis.service.persistence.LmisViewReportOvertimeFinder;
import larion.progate.lmis.service.persistence.LmisViewReportOvertimePersistence;
import larion.progate.lmis.service.persistence.LmisViewStaffMappingPersistence;
import larion.progate.lmis.service.persistence.LmisViewStaffMappingPmPersistence;
import larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNFinder;
import larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNPersistence;
import larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedFinder;
import larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedPersistence;
import larion.progate.lmis.service.persistence.LmisViewStaffRootOrgPersistence;
import larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsPersistence;
import larion.progate.lmis.service.persistence.LmisViewWorkingCalendarPersistence;
import larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistence;
import larion.progate.lmis.service.persistence.LmisWorkingCalendarsFinder;
import larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistence;
import larion.progate.lmis.service.persistence.LmisWorkingTimesPersistence;

/**
 * <a href="LmisViewOrgUserRolesServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class LmisViewOrgUserRolesServiceBaseImpl extends PrincipalBean
	implements LmisViewOrgUserRolesService {
	public LmisEmailSettingsLocalService getLmisEmailSettingsLocalService() {
		return lmisEmailSettingsLocalService;
	}

	public void setLmisEmailSettingsLocalService(
		LmisEmailSettingsLocalService lmisEmailSettingsLocalService) {
		this.lmisEmailSettingsLocalService = lmisEmailSettingsLocalService;
	}

	public LmisEmailSettingsService getLmisEmailSettingsService() {
		return lmisEmailSettingsService;
	}

	public void setLmisEmailSettingsService(
		LmisEmailSettingsService lmisEmailSettingsService) {
		this.lmisEmailSettingsService = lmisEmailSettingsService;
	}

	public LmisEmailSettingsPersistence getLmisEmailSettingsPersistence() {
		return lmisEmailSettingsPersistence;
	}

	public void setLmisEmailSettingsPersistence(
		LmisEmailSettingsPersistence lmisEmailSettingsPersistence) {
		this.lmisEmailSettingsPersistence = lmisEmailSettingsPersistence;
	}

	public LmisEmailSettingDetailsLocalService getLmisEmailSettingDetailsLocalService() {
		return lmisEmailSettingDetailsLocalService;
	}

	public void setLmisEmailSettingDetailsLocalService(
		LmisEmailSettingDetailsLocalService lmisEmailSettingDetailsLocalService) {
		this.lmisEmailSettingDetailsLocalService = lmisEmailSettingDetailsLocalService;
	}

	public LmisEmailSettingDetailsService getLmisEmailSettingDetailsService() {
		return lmisEmailSettingDetailsService;
	}

	public void setLmisEmailSettingDetailsService(
		LmisEmailSettingDetailsService lmisEmailSettingDetailsService) {
		this.lmisEmailSettingDetailsService = lmisEmailSettingDetailsService;
	}

	public LmisEmailSettingDetailsPersistence getLmisEmailSettingDetailsPersistence() {
		return lmisEmailSettingDetailsPersistence;
	}

	public void setLmisEmailSettingDetailsPersistence(
		LmisEmailSettingDetailsPersistence lmisEmailSettingDetailsPersistence) {
		this.lmisEmailSettingDetailsPersistence = lmisEmailSettingDetailsPersistence;
	}

	public LmisTimeChangeApprovalsLocalService getLmisTimeChangeApprovalsLocalService() {
		return lmisTimeChangeApprovalsLocalService;
	}

	public void setLmisTimeChangeApprovalsLocalService(
		LmisTimeChangeApprovalsLocalService lmisTimeChangeApprovalsLocalService) {
		this.lmisTimeChangeApprovalsLocalService = lmisTimeChangeApprovalsLocalService;
	}

	public LmisTimeChangeApprovalsService getLmisTimeChangeApprovalsService() {
		return lmisTimeChangeApprovalsService;
	}

	public void setLmisTimeChangeApprovalsService(
		LmisTimeChangeApprovalsService lmisTimeChangeApprovalsService) {
		this.lmisTimeChangeApprovalsService = lmisTimeChangeApprovalsService;
	}

	public LmisTimeChangeApprovalsPersistence getLmisTimeChangeApprovalsPersistence() {
		return lmisTimeChangeApprovalsPersistence;
	}

	public void setLmisTimeChangeApprovalsPersistence(
		LmisTimeChangeApprovalsPersistence lmisTimeChangeApprovalsPersistence) {
		this.lmisTimeChangeApprovalsPersistence = lmisTimeChangeApprovalsPersistence;
	}

	public LmisTimeChangeRequestsLocalService getLmisTimeChangeRequestsLocalService() {
		return lmisTimeChangeRequestsLocalService;
	}

	public void setLmisTimeChangeRequestsLocalService(
		LmisTimeChangeRequestsLocalService lmisTimeChangeRequestsLocalService) {
		this.lmisTimeChangeRequestsLocalService = lmisTimeChangeRequestsLocalService;
	}

	public LmisTimeChangeRequestsService getLmisTimeChangeRequestsService() {
		return lmisTimeChangeRequestsService;
	}

	public void setLmisTimeChangeRequestsService(
		LmisTimeChangeRequestsService lmisTimeChangeRequestsService) {
		this.lmisTimeChangeRequestsService = lmisTimeChangeRequestsService;
	}

	public LmisTimeChangeRequestsPersistence getLmisTimeChangeRequestsPersistence() {
		return lmisTimeChangeRequestsPersistence;
	}

	public void setLmisTimeChangeRequestsPersistence(
		LmisTimeChangeRequestsPersistence lmisTimeChangeRequestsPersistence) {
		this.lmisTimeChangeRequestsPersistence = lmisTimeChangeRequestsPersistence;
	}

	public LmisWorkingTimesLocalService getLmisWorkingTimesLocalService() {
		return lmisWorkingTimesLocalService;
	}

	public void setLmisWorkingTimesLocalService(
		LmisWorkingTimesLocalService lmisWorkingTimesLocalService) {
		this.lmisWorkingTimesLocalService = lmisWorkingTimesLocalService;
	}

	public LmisWorkingTimesService getLmisWorkingTimesService() {
		return lmisWorkingTimesService;
	}

	public void setLmisWorkingTimesService(
		LmisWorkingTimesService lmisWorkingTimesService) {
		this.lmisWorkingTimesService = lmisWorkingTimesService;
	}

	public LmisWorkingTimesPersistence getLmisWorkingTimesPersistence() {
		return lmisWorkingTimesPersistence;
	}

	public void setLmisWorkingTimesPersistence(
		LmisWorkingTimesPersistence lmisWorkingTimesPersistence) {
		this.lmisWorkingTimesPersistence = lmisWorkingTimesPersistence;
	}

	public LmisDayTypesLocalService getLmisDayTypesLocalService() {
		return lmisDayTypesLocalService;
	}

	public void setLmisDayTypesLocalService(
		LmisDayTypesLocalService lmisDayTypesLocalService) {
		this.lmisDayTypesLocalService = lmisDayTypesLocalService;
	}

	public LmisDayTypesService getLmisDayTypesService() {
		return lmisDayTypesService;
	}

	public void setLmisDayTypesService(LmisDayTypesService lmisDayTypesService) {
		this.lmisDayTypesService = lmisDayTypesService;
	}

	public LmisDayTypesPersistence getLmisDayTypesPersistence() {
		return lmisDayTypesPersistence;
	}

	public void setLmisDayTypesPersistence(
		LmisDayTypesPersistence lmisDayTypesPersistence) {
		this.lmisDayTypesPersistence = lmisDayTypesPersistence;
	}

	public LmisWorkingCalendarsLocalService getLmisWorkingCalendarsLocalService() {
		return lmisWorkingCalendarsLocalService;
	}

	public void setLmisWorkingCalendarsLocalService(
		LmisWorkingCalendarsLocalService lmisWorkingCalendarsLocalService) {
		this.lmisWorkingCalendarsLocalService = lmisWorkingCalendarsLocalService;
	}

	public LmisWorkingCalendarsService getLmisWorkingCalendarsService() {
		return lmisWorkingCalendarsService;
	}

	public void setLmisWorkingCalendarsService(
		LmisWorkingCalendarsService lmisWorkingCalendarsService) {
		this.lmisWorkingCalendarsService = lmisWorkingCalendarsService;
	}

	public LmisWorkingCalendarsPersistence getLmisWorkingCalendarsPersistence() {
		return lmisWorkingCalendarsPersistence;
	}

	public void setLmisWorkingCalendarsPersistence(
		LmisWorkingCalendarsPersistence lmisWorkingCalendarsPersistence) {
		this.lmisWorkingCalendarsPersistence = lmisWorkingCalendarsPersistence;
	}

	public LmisWorkingCalendarsFinder getLmisWorkingCalendarsFinder() {
		return lmisWorkingCalendarsFinder;
	}

	public void setLmisWorkingCalendarsFinder(
		LmisWorkingCalendarsFinder lmisWorkingCalendarsFinder) {
		this.lmisWorkingCalendarsFinder = lmisWorkingCalendarsFinder;
	}

	public LmisWorkingCalendarSessionsLocalService getLmisWorkingCalendarSessionsLocalService() {
		return lmisWorkingCalendarSessionsLocalService;
	}

	public void setLmisWorkingCalendarSessionsLocalService(
		LmisWorkingCalendarSessionsLocalService lmisWorkingCalendarSessionsLocalService) {
		this.lmisWorkingCalendarSessionsLocalService = lmisWorkingCalendarSessionsLocalService;
	}

	public LmisWorkingCalendarSessionsService getLmisWorkingCalendarSessionsService() {
		return lmisWorkingCalendarSessionsService;
	}

	public void setLmisWorkingCalendarSessionsService(
		LmisWorkingCalendarSessionsService lmisWorkingCalendarSessionsService) {
		this.lmisWorkingCalendarSessionsService = lmisWorkingCalendarSessionsService;
	}

	public LmisWorkingCalendarSessionsPersistence getLmisWorkingCalendarSessionsPersistence() {
		return lmisWorkingCalendarSessionsPersistence;
	}

	public void setLmisWorkingCalendarSessionsPersistence(
		LmisWorkingCalendarSessionsPersistence lmisWorkingCalendarSessionsPersistence) {
		this.lmisWorkingCalendarSessionsPersistence = lmisWorkingCalendarSessionsPersistence;
	}

	public LmisGeneralSettingsLocalService getLmisGeneralSettingsLocalService() {
		return lmisGeneralSettingsLocalService;
	}

	public void setLmisGeneralSettingsLocalService(
		LmisGeneralSettingsLocalService lmisGeneralSettingsLocalService) {
		this.lmisGeneralSettingsLocalService = lmisGeneralSettingsLocalService;
	}

	public LmisGeneralSettingsService getLmisGeneralSettingsService() {
		return lmisGeneralSettingsService;
	}

	public void setLmisGeneralSettingsService(
		LmisGeneralSettingsService lmisGeneralSettingsService) {
		this.lmisGeneralSettingsService = lmisGeneralSettingsService;
	}

	public LmisGeneralSettingsPersistence getLmisGeneralSettingsPersistence() {
		return lmisGeneralSettingsPersistence;
	}

	public void setLmisGeneralSettingsPersistence(
		LmisGeneralSettingsPersistence lmisGeneralSettingsPersistence) {
		this.lmisGeneralSettingsPersistence = lmisGeneralSettingsPersistence;
	}

	public LmisGeneralSettingsFinder getLmisGeneralSettingsFinder() {
		return lmisGeneralSettingsFinder;
	}

	public void setLmisGeneralSettingsFinder(
		LmisGeneralSettingsFinder lmisGeneralSettingsFinder) {
		this.lmisGeneralSettingsFinder = lmisGeneralSettingsFinder;
	}

	public LmisViewStaffMappingLocalService getLmisViewStaffMappingLocalService() {
		return lmisViewStaffMappingLocalService;
	}

	public void setLmisViewStaffMappingLocalService(
		LmisViewStaffMappingLocalService lmisViewStaffMappingLocalService) {
		this.lmisViewStaffMappingLocalService = lmisViewStaffMappingLocalService;
	}

	public LmisViewStaffMappingService getLmisViewStaffMappingService() {
		return lmisViewStaffMappingService;
	}

	public void setLmisViewStaffMappingService(
		LmisViewStaffMappingService lmisViewStaffMappingService) {
		this.lmisViewStaffMappingService = lmisViewStaffMappingService;
	}

	public LmisViewStaffMappingPersistence getLmisViewStaffMappingPersistence() {
		return lmisViewStaffMappingPersistence;
	}

	public void setLmisViewStaffMappingPersistence(
		LmisViewStaffMappingPersistence lmisViewStaffMappingPersistence) {
		this.lmisViewStaffMappingPersistence = lmisViewStaffMappingPersistence;
	}

	public LmisViewStaffRootOrgLocalService getLmisViewStaffRootOrgLocalService() {
		return lmisViewStaffRootOrgLocalService;
	}

	public void setLmisViewStaffRootOrgLocalService(
		LmisViewStaffRootOrgLocalService lmisViewStaffRootOrgLocalService) {
		this.lmisViewStaffRootOrgLocalService = lmisViewStaffRootOrgLocalService;
	}

	public LmisViewStaffRootOrgService getLmisViewStaffRootOrgService() {
		return lmisViewStaffRootOrgService;
	}

	public void setLmisViewStaffRootOrgService(
		LmisViewStaffRootOrgService lmisViewStaffRootOrgService) {
		this.lmisViewStaffRootOrgService = lmisViewStaffRootOrgService;
	}

	public LmisViewStaffRootOrgPersistence getLmisViewStaffRootOrgPersistence() {
		return lmisViewStaffRootOrgPersistence;
	}

	public void setLmisViewStaffRootOrgPersistence(
		LmisViewStaffRootOrgPersistence lmisViewStaffRootOrgPersistence) {
		this.lmisViewStaffRootOrgPersistence = lmisViewStaffRootOrgPersistence;
	}

	public LmisViewStaffRootOrgFNLocalService getLmisViewStaffRootOrgFNLocalService() {
		return lmisViewStaffRootOrgFNLocalService;
	}

	public void setLmisViewStaffRootOrgFNLocalService(
		LmisViewStaffRootOrgFNLocalService lmisViewStaffRootOrgFNLocalService) {
		this.lmisViewStaffRootOrgFNLocalService = lmisViewStaffRootOrgFNLocalService;
	}

	public LmisViewStaffRootOrgFNService getLmisViewStaffRootOrgFNService() {
		return lmisViewStaffRootOrgFNService;
	}

	public void setLmisViewStaffRootOrgFNService(
		LmisViewStaffRootOrgFNService lmisViewStaffRootOrgFNService) {
		this.lmisViewStaffRootOrgFNService = lmisViewStaffRootOrgFNService;
	}

	public LmisViewStaffRootOrgFNPersistence getLmisViewStaffRootOrgFNPersistence() {
		return lmisViewStaffRootOrgFNPersistence;
	}

	public void setLmisViewStaffRootOrgFNPersistence(
		LmisViewStaffRootOrgFNPersistence lmisViewStaffRootOrgFNPersistence) {
		this.lmisViewStaffRootOrgFNPersistence = lmisViewStaffRootOrgFNPersistence;
	}

	public LmisViewStaffRootOrgFNFinder getLmisViewStaffRootOrgFNFinder() {
		return lmisViewStaffRootOrgFNFinder;
	}

	public void setLmisViewStaffRootOrgFNFinder(
		LmisViewStaffRootOrgFNFinder lmisViewStaffRootOrgFNFinder) {
		this.lmisViewStaffRootOrgFNFinder = lmisViewStaffRootOrgFNFinder;
	}

	public LmisViewStaffRootOrgOrderedLocalService getLmisViewStaffRootOrgOrderedLocalService() {
		return lmisViewStaffRootOrgOrderedLocalService;
	}

	public void setLmisViewStaffRootOrgOrderedLocalService(
		LmisViewStaffRootOrgOrderedLocalService lmisViewStaffRootOrgOrderedLocalService) {
		this.lmisViewStaffRootOrgOrderedLocalService = lmisViewStaffRootOrgOrderedLocalService;
	}

	public LmisViewStaffRootOrgOrderedService getLmisViewStaffRootOrgOrderedService() {
		return lmisViewStaffRootOrgOrderedService;
	}

	public void setLmisViewStaffRootOrgOrderedService(
		LmisViewStaffRootOrgOrderedService lmisViewStaffRootOrgOrderedService) {
		this.lmisViewStaffRootOrgOrderedService = lmisViewStaffRootOrgOrderedService;
	}

	public LmisViewStaffRootOrgOrderedPersistence getLmisViewStaffRootOrgOrderedPersistence() {
		return lmisViewStaffRootOrgOrderedPersistence;
	}

	public void setLmisViewStaffRootOrgOrderedPersistence(
		LmisViewStaffRootOrgOrderedPersistence lmisViewStaffRootOrgOrderedPersistence) {
		this.lmisViewStaffRootOrgOrderedPersistence = lmisViewStaffRootOrgOrderedPersistence;
	}

	public LmisViewStaffRootOrgOrderedFinder getLmisViewStaffRootOrgOrderedFinder() {
		return lmisViewStaffRootOrgOrderedFinder;
	}

	public void setLmisViewStaffRootOrgOrderedFinder(
		LmisViewStaffRootOrgOrderedFinder lmisViewStaffRootOrgOrderedFinder) {
		this.lmisViewStaffRootOrgOrderedFinder = lmisViewStaffRootOrgOrderedFinder;
	}

	public LmisViewTimeChangeReqsLocalService getLmisViewTimeChangeReqsLocalService() {
		return lmisViewTimeChangeReqsLocalService;
	}

	public void setLmisViewTimeChangeReqsLocalService(
		LmisViewTimeChangeReqsLocalService lmisViewTimeChangeReqsLocalService) {
		this.lmisViewTimeChangeReqsLocalService = lmisViewTimeChangeReqsLocalService;
	}

	public LmisViewTimeChangeReqsService getLmisViewTimeChangeReqsService() {
		return lmisViewTimeChangeReqsService;
	}

	public void setLmisViewTimeChangeReqsService(
		LmisViewTimeChangeReqsService lmisViewTimeChangeReqsService) {
		this.lmisViewTimeChangeReqsService = lmisViewTimeChangeReqsService;
	}

	public LmisViewTimeChangeReqsPersistence getLmisViewTimeChangeReqsPersistence() {
		return lmisViewTimeChangeReqsPersistence;
	}

	public void setLmisViewTimeChangeReqsPersistence(
		LmisViewTimeChangeReqsPersistence lmisViewTimeChangeReqsPersistence) {
		this.lmisViewTimeChangeReqsPersistence = lmisViewTimeChangeReqsPersistence;
	}

	public LmisViewEmailSettingDetailOrgLocalService getLmisViewEmailSettingDetailOrgLocalService() {
		return lmisViewEmailSettingDetailOrgLocalService;
	}

	public void setLmisViewEmailSettingDetailOrgLocalService(
		LmisViewEmailSettingDetailOrgLocalService lmisViewEmailSettingDetailOrgLocalService) {
		this.lmisViewEmailSettingDetailOrgLocalService = lmisViewEmailSettingDetailOrgLocalService;
	}

	public LmisViewEmailSettingDetailOrgService getLmisViewEmailSettingDetailOrgService() {
		return lmisViewEmailSettingDetailOrgService;
	}

	public void setLmisViewEmailSettingDetailOrgService(
		LmisViewEmailSettingDetailOrgService lmisViewEmailSettingDetailOrgService) {
		this.lmisViewEmailSettingDetailOrgService = lmisViewEmailSettingDetailOrgService;
	}

	public LmisViewEmailSettingDetailOrgPersistence getLmisViewEmailSettingDetailOrgPersistence() {
		return lmisViewEmailSettingDetailOrgPersistence;
	}

	public void setLmisViewEmailSettingDetailOrgPersistence(
		LmisViewEmailSettingDetailOrgPersistence lmisViewEmailSettingDetailOrgPersistence) {
		this.lmisViewEmailSettingDetailOrgPersistence = lmisViewEmailSettingDetailOrgPersistence;
	}

	public LmisViewEmailSettingDetailUserLocalService getLmisViewEmailSettingDetailUserLocalService() {
		return lmisViewEmailSettingDetailUserLocalService;
	}

	public void setLmisViewEmailSettingDetailUserLocalService(
		LmisViewEmailSettingDetailUserLocalService lmisViewEmailSettingDetailUserLocalService) {
		this.lmisViewEmailSettingDetailUserLocalService = lmisViewEmailSettingDetailUserLocalService;
	}

	public LmisViewEmailSettingDetailUserService getLmisViewEmailSettingDetailUserService() {
		return lmisViewEmailSettingDetailUserService;
	}

	public void setLmisViewEmailSettingDetailUserService(
		LmisViewEmailSettingDetailUserService lmisViewEmailSettingDetailUserService) {
		this.lmisViewEmailSettingDetailUserService = lmisViewEmailSettingDetailUserService;
	}

	public LmisViewEmailSettingDetailUserPersistence getLmisViewEmailSettingDetailUserPersistence() {
		return lmisViewEmailSettingDetailUserPersistence;
	}

	public void setLmisViewEmailSettingDetailUserPersistence(
		LmisViewEmailSettingDetailUserPersistence lmisViewEmailSettingDetailUserPersistence) {
		this.lmisViewEmailSettingDetailUserPersistence = lmisViewEmailSettingDetailUserPersistence;
	}

	public LmisViewWorkingCalendarLocalService getLmisViewWorkingCalendarLocalService() {
		return lmisViewWorkingCalendarLocalService;
	}

	public void setLmisViewWorkingCalendarLocalService(
		LmisViewWorkingCalendarLocalService lmisViewWorkingCalendarLocalService) {
		this.lmisViewWorkingCalendarLocalService = lmisViewWorkingCalendarLocalService;
	}

	public LmisViewWorkingCalendarService getLmisViewWorkingCalendarService() {
		return lmisViewWorkingCalendarService;
	}

	public void setLmisViewWorkingCalendarService(
		LmisViewWorkingCalendarService lmisViewWorkingCalendarService) {
		this.lmisViewWorkingCalendarService = lmisViewWorkingCalendarService;
	}

	public LmisViewWorkingCalendarPersistence getLmisViewWorkingCalendarPersistence() {
		return lmisViewWorkingCalendarPersistence;
	}

	public void setLmisViewWorkingCalendarPersistence(
		LmisViewWorkingCalendarPersistence lmisViewWorkingCalendarPersistence) {
		this.lmisViewWorkingCalendarPersistence = lmisViewWorkingCalendarPersistence;
	}

	public LmisOverTimeSettingsLocalService getLmisOverTimeSettingsLocalService() {
		return lmisOverTimeSettingsLocalService;
	}

	public void setLmisOverTimeSettingsLocalService(
		LmisOverTimeSettingsLocalService lmisOverTimeSettingsLocalService) {
		this.lmisOverTimeSettingsLocalService = lmisOverTimeSettingsLocalService;
	}

	public LmisOverTimeSettingsService getLmisOverTimeSettingsService() {
		return lmisOverTimeSettingsService;
	}

	public void setLmisOverTimeSettingsService(
		LmisOverTimeSettingsService lmisOverTimeSettingsService) {
		this.lmisOverTimeSettingsService = lmisOverTimeSettingsService;
	}

	public LmisOverTimeSettingsPersistence getLmisOverTimeSettingsPersistence() {
		return lmisOverTimeSettingsPersistence;
	}

	public void setLmisOverTimeSettingsPersistence(
		LmisOverTimeSettingsPersistence lmisOverTimeSettingsPersistence) {
		this.lmisOverTimeSettingsPersistence = lmisOverTimeSettingsPersistence;
	}

	public LmisOverTimeTypesLocalService getLmisOverTimeTypesLocalService() {
		return lmisOverTimeTypesLocalService;
	}

	public void setLmisOverTimeTypesLocalService(
		LmisOverTimeTypesLocalService lmisOverTimeTypesLocalService) {
		this.lmisOverTimeTypesLocalService = lmisOverTimeTypesLocalService;
	}

	public LmisOverTimeTypesService getLmisOverTimeTypesService() {
		return lmisOverTimeTypesService;
	}

	public void setLmisOverTimeTypesService(
		LmisOverTimeTypesService lmisOverTimeTypesService) {
		this.lmisOverTimeTypesService = lmisOverTimeTypesService;
	}

	public LmisOverTimeTypesPersistence getLmisOverTimeTypesPersistence() {
		return lmisOverTimeTypesPersistence;
	}

	public void setLmisOverTimeTypesPersistence(
		LmisOverTimeTypesPersistence lmisOverTimeTypesPersistence) {
		this.lmisOverTimeTypesPersistence = lmisOverTimeTypesPersistence;
	}

	public LmisDataInputsLocalService getLmisDataInputsLocalService() {
		return lmisDataInputsLocalService;
	}

	public void setLmisDataInputsLocalService(
		LmisDataInputsLocalService lmisDataInputsLocalService) {
		this.lmisDataInputsLocalService = lmisDataInputsLocalService;
	}

	public LmisDataInputsService getLmisDataInputsService() {
		return lmisDataInputsService;
	}

	public void setLmisDataInputsService(
		LmisDataInputsService lmisDataInputsService) {
		this.lmisDataInputsService = lmisDataInputsService;
	}

	public LmisDataInputsPersistence getLmisDataInputsPersistence() {
		return lmisDataInputsPersistence;
	}

	public void setLmisDataInputsPersistence(
		LmisDataInputsPersistence lmisDataInputsPersistence) {
		this.lmisDataInputsPersistence = lmisDataInputsPersistence;
	}

	public LmisAttendanceDailyLocalService getLmisAttendanceDailyLocalService() {
		return lmisAttendanceDailyLocalService;
	}

	public void setLmisAttendanceDailyLocalService(
		LmisAttendanceDailyLocalService lmisAttendanceDailyLocalService) {
		this.lmisAttendanceDailyLocalService = lmisAttendanceDailyLocalService;
	}

	public LmisAttendanceDailyService getLmisAttendanceDailyService() {
		return lmisAttendanceDailyService;
	}

	public void setLmisAttendanceDailyService(
		LmisAttendanceDailyService lmisAttendanceDailyService) {
		this.lmisAttendanceDailyService = lmisAttendanceDailyService;
	}

	public LmisAttendanceDailyPersistence getLmisAttendanceDailyPersistence() {
		return lmisAttendanceDailyPersistence;
	}

	public void setLmisAttendanceDailyPersistence(
		LmisAttendanceDailyPersistence lmisAttendanceDailyPersistence) {
		this.lmisAttendanceDailyPersistence = lmisAttendanceDailyPersistence;
	}

	public LmisAttendanceDailyFinder getLmisAttendanceDailyFinder() {
		return lmisAttendanceDailyFinder;
	}

	public void setLmisAttendanceDailyFinder(
		LmisAttendanceDailyFinder lmisAttendanceDailyFinder) {
		this.lmisAttendanceDailyFinder = lmisAttendanceDailyFinder;
	}

	public LmisOvertimeRequestsLocalService getLmisOvertimeRequestsLocalService() {
		return lmisOvertimeRequestsLocalService;
	}

	public void setLmisOvertimeRequestsLocalService(
		LmisOvertimeRequestsLocalService lmisOvertimeRequestsLocalService) {
		this.lmisOvertimeRequestsLocalService = lmisOvertimeRequestsLocalService;
	}

	public LmisOvertimeRequestsService getLmisOvertimeRequestsService() {
		return lmisOvertimeRequestsService;
	}

	public void setLmisOvertimeRequestsService(
		LmisOvertimeRequestsService lmisOvertimeRequestsService) {
		this.lmisOvertimeRequestsService = lmisOvertimeRequestsService;
	}

	public LmisOvertimeRequestsPersistence getLmisOvertimeRequestsPersistence() {
		return lmisOvertimeRequestsPersistence;
	}

	public void setLmisOvertimeRequestsPersistence(
		LmisOvertimeRequestsPersistence lmisOvertimeRequestsPersistence) {
		this.lmisOvertimeRequestsPersistence = lmisOvertimeRequestsPersistence;
	}

	public LmisOvertimeRequestDetailsLocalService getLmisOvertimeRequestDetailsLocalService() {
		return lmisOvertimeRequestDetailsLocalService;
	}

	public void setLmisOvertimeRequestDetailsLocalService(
		LmisOvertimeRequestDetailsLocalService lmisOvertimeRequestDetailsLocalService) {
		this.lmisOvertimeRequestDetailsLocalService = lmisOvertimeRequestDetailsLocalService;
	}

	public LmisOvertimeRequestDetailsService getLmisOvertimeRequestDetailsService() {
		return lmisOvertimeRequestDetailsService;
	}

	public void setLmisOvertimeRequestDetailsService(
		LmisOvertimeRequestDetailsService lmisOvertimeRequestDetailsService) {
		this.lmisOvertimeRequestDetailsService = lmisOvertimeRequestDetailsService;
	}

	public LmisOvertimeRequestDetailsPersistence getLmisOvertimeRequestDetailsPersistence() {
		return lmisOvertimeRequestDetailsPersistence;
	}

	public void setLmisOvertimeRequestDetailsPersistence(
		LmisOvertimeRequestDetailsPersistence lmisOvertimeRequestDetailsPersistence) {
		this.lmisOvertimeRequestDetailsPersistence = lmisOvertimeRequestDetailsPersistence;
	}

	public LmisOvertimeApprovalsLocalService getLmisOvertimeApprovalsLocalService() {
		return lmisOvertimeApprovalsLocalService;
	}

	public void setLmisOvertimeApprovalsLocalService(
		LmisOvertimeApprovalsLocalService lmisOvertimeApprovalsLocalService) {
		this.lmisOvertimeApprovalsLocalService = lmisOvertimeApprovalsLocalService;
	}

	public LmisOvertimeApprovalsService getLmisOvertimeApprovalsService() {
		return lmisOvertimeApprovalsService;
	}

	public void setLmisOvertimeApprovalsService(
		LmisOvertimeApprovalsService lmisOvertimeApprovalsService) {
		this.lmisOvertimeApprovalsService = lmisOvertimeApprovalsService;
	}

	public LmisOvertimeApprovalsPersistence getLmisOvertimeApprovalsPersistence() {
		return lmisOvertimeApprovalsPersistence;
	}

	public void setLmisOvertimeApprovalsPersistence(
		LmisOvertimeApprovalsPersistence lmisOvertimeApprovalsPersistence) {
		this.lmisOvertimeApprovalsPersistence = lmisOvertimeApprovalsPersistence;
	}

	public LmisOvertimeApprovalsFinder getLmisOvertimeApprovalsFinder() {
		return lmisOvertimeApprovalsFinder;
	}

	public void setLmisOvertimeApprovalsFinder(
		LmisOvertimeApprovalsFinder lmisOvertimeApprovalsFinder) {
		this.lmisOvertimeApprovalsFinder = lmisOvertimeApprovalsFinder;
	}

	public LmisOvertimeMonthlyLocalService getLmisOvertimeMonthlyLocalService() {
		return lmisOvertimeMonthlyLocalService;
	}

	public void setLmisOvertimeMonthlyLocalService(
		LmisOvertimeMonthlyLocalService lmisOvertimeMonthlyLocalService) {
		this.lmisOvertimeMonthlyLocalService = lmisOvertimeMonthlyLocalService;
	}

	public LmisOvertimeMonthlyService getLmisOvertimeMonthlyService() {
		return lmisOvertimeMonthlyService;
	}

	public void setLmisOvertimeMonthlyService(
		LmisOvertimeMonthlyService lmisOvertimeMonthlyService) {
		this.lmisOvertimeMonthlyService = lmisOvertimeMonthlyService;
	}

	public LmisOvertimeMonthlyPersistence getLmisOvertimeMonthlyPersistence() {
		return lmisOvertimeMonthlyPersistence;
	}

	public void setLmisOvertimeMonthlyPersistence(
		LmisOvertimeMonthlyPersistence lmisOvertimeMonthlyPersistence) {
		this.lmisOvertimeMonthlyPersistence = lmisOvertimeMonthlyPersistence;
	}

	public LmisDataImportsLocalService getLmisDataImportsLocalService() {
		return lmisDataImportsLocalService;
	}

	public void setLmisDataImportsLocalService(
		LmisDataImportsLocalService lmisDataImportsLocalService) {
		this.lmisDataImportsLocalService = lmisDataImportsLocalService;
	}

	public LmisDataImportsService getLmisDataImportsService() {
		return lmisDataImportsService;
	}

	public void setLmisDataImportsService(
		LmisDataImportsService lmisDataImportsService) {
		this.lmisDataImportsService = lmisDataImportsService;
	}

	public LmisDataImportsPersistence getLmisDataImportsPersistence() {
		return lmisDataImportsPersistence;
	}

	public void setLmisDataImportsPersistence(
		LmisDataImportsPersistence lmisDataImportsPersistence) {
		this.lmisDataImportsPersistence = lmisDataImportsPersistence;
	}

	public LmisDataImportDetailsLocalService getLmisDataImportDetailsLocalService() {
		return lmisDataImportDetailsLocalService;
	}

	public void setLmisDataImportDetailsLocalService(
		LmisDataImportDetailsLocalService lmisDataImportDetailsLocalService) {
		this.lmisDataImportDetailsLocalService = lmisDataImportDetailsLocalService;
	}

	public LmisDataImportDetailsService getLmisDataImportDetailsService() {
		return lmisDataImportDetailsService;
	}

	public void setLmisDataImportDetailsService(
		LmisDataImportDetailsService lmisDataImportDetailsService) {
		this.lmisDataImportDetailsService = lmisDataImportDetailsService;
	}

	public LmisDataImportDetailsPersistence getLmisDataImportDetailsPersistence() {
		return lmisDataImportDetailsPersistence;
	}

	public void setLmisDataImportDetailsPersistence(
		LmisDataImportDetailsPersistence lmisDataImportDetailsPersistence) {
		this.lmisDataImportDetailsPersistence = lmisDataImportDetailsPersistence;
	}

	public LmisOverTimeReportHoursLocalService getLmisOverTimeReportHoursLocalService() {
		return lmisOverTimeReportHoursLocalService;
	}

	public void setLmisOverTimeReportHoursLocalService(
		LmisOverTimeReportHoursLocalService lmisOverTimeReportHoursLocalService) {
		this.lmisOverTimeReportHoursLocalService = lmisOverTimeReportHoursLocalService;
	}

	public LmisOverTimeReportHoursService getLmisOverTimeReportHoursService() {
		return lmisOverTimeReportHoursService;
	}

	public void setLmisOverTimeReportHoursService(
		LmisOverTimeReportHoursService lmisOverTimeReportHoursService) {
		this.lmisOverTimeReportHoursService = lmisOverTimeReportHoursService;
	}

	public LmisOverTimeReportHoursPersistence getLmisOverTimeReportHoursPersistence() {
		return lmisOverTimeReportHoursPersistence;
	}

	public void setLmisOverTimeReportHoursPersistence(
		LmisOverTimeReportHoursPersistence lmisOverTimeReportHoursPersistence) {
		this.lmisOverTimeReportHoursPersistence = lmisOverTimeReportHoursPersistence;
	}

	public LmisOverTimeReportDetailsLocalService getLmisOverTimeReportDetailsLocalService() {
		return lmisOverTimeReportDetailsLocalService;
	}

	public void setLmisOverTimeReportDetailsLocalService(
		LmisOverTimeReportDetailsLocalService lmisOverTimeReportDetailsLocalService) {
		this.lmisOverTimeReportDetailsLocalService = lmisOverTimeReportDetailsLocalService;
	}

	public LmisOverTimeReportDetailsService getLmisOverTimeReportDetailsService() {
		return lmisOverTimeReportDetailsService;
	}

	public void setLmisOverTimeReportDetailsService(
		LmisOverTimeReportDetailsService lmisOverTimeReportDetailsService) {
		this.lmisOverTimeReportDetailsService = lmisOverTimeReportDetailsService;
	}

	public LmisOverTimeReportDetailsPersistence getLmisOverTimeReportDetailsPersistence() {
		return lmisOverTimeReportDetailsPersistence;
	}

	public void setLmisOverTimeReportDetailsPersistence(
		LmisOverTimeReportDetailsPersistence lmisOverTimeReportDetailsPersistence) {
		this.lmisOverTimeReportDetailsPersistence = lmisOverTimeReportDetailsPersistence;
	}

	public LmisOverTimeReportsLocalService getLmisOverTimeReportsLocalService() {
		return lmisOverTimeReportsLocalService;
	}

	public void setLmisOverTimeReportsLocalService(
		LmisOverTimeReportsLocalService lmisOverTimeReportsLocalService) {
		this.lmisOverTimeReportsLocalService = lmisOverTimeReportsLocalService;
	}

	public LmisOverTimeReportsService getLmisOverTimeReportsService() {
		return lmisOverTimeReportsService;
	}

	public void setLmisOverTimeReportsService(
		LmisOverTimeReportsService lmisOverTimeReportsService) {
		this.lmisOverTimeReportsService = lmisOverTimeReportsService;
	}

	public LmisOverTimeReportsPersistence getLmisOverTimeReportsPersistence() {
		return lmisOverTimeReportsPersistence;
	}

	public void setLmisOverTimeReportsPersistence(
		LmisOverTimeReportsPersistence lmisOverTimeReportsPersistence) {
		this.lmisOverTimeReportsPersistence = lmisOverTimeReportsPersistence;
	}

	public LmisOvertimeYearlyLocalService getLmisOvertimeYearlyLocalService() {
		return lmisOvertimeYearlyLocalService;
	}

	public void setLmisOvertimeYearlyLocalService(
		LmisOvertimeYearlyLocalService lmisOvertimeYearlyLocalService) {
		this.lmisOvertimeYearlyLocalService = lmisOvertimeYearlyLocalService;
	}

	public LmisOvertimeYearlyService getLmisOvertimeYearlyService() {
		return lmisOvertimeYearlyService;
	}

	public void setLmisOvertimeYearlyService(
		LmisOvertimeYearlyService lmisOvertimeYearlyService) {
		this.lmisOvertimeYearlyService = lmisOvertimeYearlyService;
	}

	public LmisOvertimeYearlyPersistence getLmisOvertimeYearlyPersistence() {
		return lmisOvertimeYearlyPersistence;
	}

	public void setLmisOvertimeYearlyPersistence(
		LmisOvertimeYearlyPersistence lmisOvertimeYearlyPersistence) {
		this.lmisOvertimeYearlyPersistence = lmisOvertimeYearlyPersistence;
	}

	public LmisAbsenceYearlyLocalService getLmisAbsenceYearlyLocalService() {
		return lmisAbsenceYearlyLocalService;
	}

	public void setLmisAbsenceYearlyLocalService(
		LmisAbsenceYearlyLocalService lmisAbsenceYearlyLocalService) {
		this.lmisAbsenceYearlyLocalService = lmisAbsenceYearlyLocalService;
	}

	public LmisAbsenceYearlyService getLmisAbsenceYearlyService() {
		return lmisAbsenceYearlyService;
	}

	public void setLmisAbsenceYearlyService(
		LmisAbsenceYearlyService lmisAbsenceYearlyService) {
		this.lmisAbsenceYearlyService = lmisAbsenceYearlyService;
	}

	public LmisAbsenceYearlyPersistence getLmisAbsenceYearlyPersistence() {
		return lmisAbsenceYearlyPersistence;
	}

	public void setLmisAbsenceYearlyPersistence(
		LmisAbsenceYearlyPersistence lmisAbsenceYearlyPersistence) {
		this.lmisAbsenceYearlyPersistence = lmisAbsenceYearlyPersistence;
	}

	public LmisAbsenceYearlyFinder getLmisAbsenceYearlyFinder() {
		return lmisAbsenceYearlyFinder;
	}

	public void setLmisAbsenceYearlyFinder(
		LmisAbsenceYearlyFinder lmisAbsenceYearlyFinder) {
		this.lmisAbsenceYearlyFinder = lmisAbsenceYearlyFinder;
	}

	public LmisAbsenceMonthlyLocalService getLmisAbsenceMonthlyLocalService() {
		return lmisAbsenceMonthlyLocalService;
	}

	public void setLmisAbsenceMonthlyLocalService(
		LmisAbsenceMonthlyLocalService lmisAbsenceMonthlyLocalService) {
		this.lmisAbsenceMonthlyLocalService = lmisAbsenceMonthlyLocalService;
	}

	public LmisAbsenceMonthlyService getLmisAbsenceMonthlyService() {
		return lmisAbsenceMonthlyService;
	}

	public void setLmisAbsenceMonthlyService(
		LmisAbsenceMonthlyService lmisAbsenceMonthlyService) {
		this.lmisAbsenceMonthlyService = lmisAbsenceMonthlyService;
	}

	public LmisAbsenceMonthlyPersistence getLmisAbsenceMonthlyPersistence() {
		return lmisAbsenceMonthlyPersistence;
	}

	public void setLmisAbsenceMonthlyPersistence(
		LmisAbsenceMonthlyPersistence lmisAbsenceMonthlyPersistence) {
		this.lmisAbsenceMonthlyPersistence = lmisAbsenceMonthlyPersistence;
	}

	public LmisAbsenceSettingsLocalService getLmisAbsenceSettingsLocalService() {
		return lmisAbsenceSettingsLocalService;
	}

	public void setLmisAbsenceSettingsLocalService(
		LmisAbsenceSettingsLocalService lmisAbsenceSettingsLocalService) {
		this.lmisAbsenceSettingsLocalService = lmisAbsenceSettingsLocalService;
	}

	public LmisAbsenceSettingsService getLmisAbsenceSettingsService() {
		return lmisAbsenceSettingsService;
	}

	public void setLmisAbsenceSettingsService(
		LmisAbsenceSettingsService lmisAbsenceSettingsService) {
		this.lmisAbsenceSettingsService = lmisAbsenceSettingsService;
	}

	public LmisAbsenceSettingsPersistence getLmisAbsenceSettingsPersistence() {
		return lmisAbsenceSettingsPersistence;
	}

	public void setLmisAbsenceSettingsPersistence(
		LmisAbsenceSettingsPersistence lmisAbsenceSettingsPersistence) {
		this.lmisAbsenceSettingsPersistence = lmisAbsenceSettingsPersistence;
	}

	public LmisAbsenceApprovalsLocalService getLmisAbsenceApprovalsLocalService() {
		return lmisAbsenceApprovalsLocalService;
	}

	public void setLmisAbsenceApprovalsLocalService(
		LmisAbsenceApprovalsLocalService lmisAbsenceApprovalsLocalService) {
		this.lmisAbsenceApprovalsLocalService = lmisAbsenceApprovalsLocalService;
	}

	public LmisAbsenceApprovalsService getLmisAbsenceApprovalsService() {
		return lmisAbsenceApprovalsService;
	}

	public void setLmisAbsenceApprovalsService(
		LmisAbsenceApprovalsService lmisAbsenceApprovalsService) {
		this.lmisAbsenceApprovalsService = lmisAbsenceApprovalsService;
	}

	public LmisAbsenceApprovalsPersistence getLmisAbsenceApprovalsPersistence() {
		return lmisAbsenceApprovalsPersistence;
	}

	public void setLmisAbsenceApprovalsPersistence(
		LmisAbsenceApprovalsPersistence lmisAbsenceApprovalsPersistence) {
		this.lmisAbsenceApprovalsPersistence = lmisAbsenceApprovalsPersistence;
	}

	public LmisAbsenceRequestsLocalService getLmisAbsenceRequestsLocalService() {
		return lmisAbsenceRequestsLocalService;
	}

	public void setLmisAbsenceRequestsLocalService(
		LmisAbsenceRequestsLocalService lmisAbsenceRequestsLocalService) {
		this.lmisAbsenceRequestsLocalService = lmisAbsenceRequestsLocalService;
	}

	public LmisAbsenceRequestsService getLmisAbsenceRequestsService() {
		return lmisAbsenceRequestsService;
	}

	public void setLmisAbsenceRequestsService(
		LmisAbsenceRequestsService lmisAbsenceRequestsService) {
		this.lmisAbsenceRequestsService = lmisAbsenceRequestsService;
	}

	public LmisAbsenceRequestsPersistence getLmisAbsenceRequestsPersistence() {
		return lmisAbsenceRequestsPersistence;
	}

	public void setLmisAbsenceRequestsPersistence(
		LmisAbsenceRequestsPersistence lmisAbsenceRequestsPersistence) {
		this.lmisAbsenceRequestsPersistence = lmisAbsenceRequestsPersistence;
	}

	public LmisAbsenceRequestsFinder getLmisAbsenceRequestsFinder() {
		return lmisAbsenceRequestsFinder;
	}

	public void setLmisAbsenceRequestsFinder(
		LmisAbsenceRequestsFinder lmisAbsenceRequestsFinder) {
		this.lmisAbsenceRequestsFinder = lmisAbsenceRequestsFinder;
	}

	public LmisViewDayTypeOverTimeSettingTypeLocalService getLmisViewDayTypeOverTimeSettingTypeLocalService() {
		return lmisViewDayTypeOverTimeSettingTypeLocalService;
	}

	public void setLmisViewDayTypeOverTimeSettingTypeLocalService(
		LmisViewDayTypeOverTimeSettingTypeLocalService lmisViewDayTypeOverTimeSettingTypeLocalService) {
		this.lmisViewDayTypeOverTimeSettingTypeLocalService = lmisViewDayTypeOverTimeSettingTypeLocalService;
	}

	public LmisViewDayTypeOverTimeSettingTypeService getLmisViewDayTypeOverTimeSettingTypeService() {
		return lmisViewDayTypeOverTimeSettingTypeService;
	}

	public void setLmisViewDayTypeOverTimeSettingTypeService(
		LmisViewDayTypeOverTimeSettingTypeService lmisViewDayTypeOverTimeSettingTypeService) {
		this.lmisViewDayTypeOverTimeSettingTypeService = lmisViewDayTypeOverTimeSettingTypeService;
	}

	public LmisViewDayTypeOverTimeSettingTypePersistence getLmisViewDayTypeOverTimeSettingTypePersistence() {
		return lmisViewDayTypeOverTimeSettingTypePersistence;
	}

	public void setLmisViewDayTypeOverTimeSettingTypePersistence(
		LmisViewDayTypeOverTimeSettingTypePersistence lmisViewDayTypeOverTimeSettingTypePersistence) {
		this.lmisViewDayTypeOverTimeSettingTypePersistence = lmisViewDayTypeOverTimeSettingTypePersistence;
	}

	public LmisViewRegistrationOvertimeLocalService getLmisViewRegistrationOvertimeLocalService() {
		return lmisViewRegistrationOvertimeLocalService;
	}

	public void setLmisViewRegistrationOvertimeLocalService(
		LmisViewRegistrationOvertimeLocalService lmisViewRegistrationOvertimeLocalService) {
		this.lmisViewRegistrationOvertimeLocalService = lmisViewRegistrationOvertimeLocalService;
	}

	public LmisViewRegistrationOvertimeService getLmisViewRegistrationOvertimeService() {
		return lmisViewRegistrationOvertimeService;
	}

	public void setLmisViewRegistrationOvertimeService(
		LmisViewRegistrationOvertimeService lmisViewRegistrationOvertimeService) {
		this.lmisViewRegistrationOvertimeService = lmisViewRegistrationOvertimeService;
	}

	public LmisViewRegistrationOvertimePersistence getLmisViewRegistrationOvertimePersistence() {
		return lmisViewRegistrationOvertimePersistence;
	}

	public void setLmisViewRegistrationOvertimePersistence(
		LmisViewRegistrationOvertimePersistence lmisViewRegistrationOvertimePersistence) {
		this.lmisViewRegistrationOvertimePersistence = lmisViewRegistrationOvertimePersistence;
	}

	public LmisViewRegistrationOvertimeFinder getLmisViewRegistrationOvertimeFinder() {
		return lmisViewRegistrationOvertimeFinder;
	}

	public void setLmisViewRegistrationOvertimeFinder(
		LmisViewRegistrationOvertimeFinder lmisViewRegistrationOvertimeFinder) {
		this.lmisViewRegistrationOvertimeFinder = lmisViewRegistrationOvertimeFinder;
	}

	public LmisViewRegistrationOvertimeaApprovalLocalService getLmisViewRegistrationOvertimeaApprovalLocalService() {
		return lmisViewRegistrationOvertimeaApprovalLocalService;
	}

	public void setLmisViewRegistrationOvertimeaApprovalLocalService(
		LmisViewRegistrationOvertimeaApprovalLocalService lmisViewRegistrationOvertimeaApprovalLocalService) {
		this.lmisViewRegistrationOvertimeaApprovalLocalService = lmisViewRegistrationOvertimeaApprovalLocalService;
	}

	public LmisViewRegistrationOvertimeaApprovalService getLmisViewRegistrationOvertimeaApprovalService() {
		return lmisViewRegistrationOvertimeaApprovalService;
	}

	public void setLmisViewRegistrationOvertimeaApprovalService(
		LmisViewRegistrationOvertimeaApprovalService lmisViewRegistrationOvertimeaApprovalService) {
		this.lmisViewRegistrationOvertimeaApprovalService = lmisViewRegistrationOvertimeaApprovalService;
	}

	public LmisViewRegistrationOvertimeaApprovalPersistence getLmisViewRegistrationOvertimeaApprovalPersistence() {
		return lmisViewRegistrationOvertimeaApprovalPersistence;
	}

	public void setLmisViewRegistrationOvertimeaApprovalPersistence(
		LmisViewRegistrationOvertimeaApprovalPersistence lmisViewRegistrationOvertimeaApprovalPersistence) {
		this.lmisViewRegistrationOvertimeaApprovalPersistence = lmisViewRegistrationOvertimeaApprovalPersistence;
	}

	public LmisViewOTAppLocalService getLmisViewOTAppLocalService() {
		return lmisViewOTAppLocalService;
	}

	public void setLmisViewOTAppLocalService(
		LmisViewOTAppLocalService lmisViewOTAppLocalService) {
		this.lmisViewOTAppLocalService = lmisViewOTAppLocalService;
	}

	public LmisViewOTAppService getLmisViewOTAppService() {
		return lmisViewOTAppService;
	}

	public void setLmisViewOTAppService(
		LmisViewOTAppService lmisViewOTAppService) {
		this.lmisViewOTAppService = lmisViewOTAppService;
	}

	public LmisViewOTAppPersistence getLmisViewOTAppPersistence() {
		return lmisViewOTAppPersistence;
	}

	public void setLmisViewOTAppPersistence(
		LmisViewOTAppPersistence lmisViewOTAppPersistence) {
		this.lmisViewOTAppPersistence = lmisViewOTAppPersistence;
	}

	public LmisViewReportOvertimeLocalService getLmisViewReportOvertimeLocalService() {
		return lmisViewReportOvertimeLocalService;
	}

	public void setLmisViewReportOvertimeLocalService(
		LmisViewReportOvertimeLocalService lmisViewReportOvertimeLocalService) {
		this.lmisViewReportOvertimeLocalService = lmisViewReportOvertimeLocalService;
	}

	public LmisViewReportOvertimeService getLmisViewReportOvertimeService() {
		return lmisViewReportOvertimeService;
	}

	public void setLmisViewReportOvertimeService(
		LmisViewReportOvertimeService lmisViewReportOvertimeService) {
		this.lmisViewReportOvertimeService = lmisViewReportOvertimeService;
	}

	public LmisViewReportOvertimePersistence getLmisViewReportOvertimePersistence() {
		return lmisViewReportOvertimePersistence;
	}

	public void setLmisViewReportOvertimePersistence(
		LmisViewReportOvertimePersistence lmisViewReportOvertimePersistence) {
		this.lmisViewReportOvertimePersistence = lmisViewReportOvertimePersistence;
	}

	public LmisViewReportOvertimeFinder getLmisViewReportOvertimeFinder() {
		return lmisViewReportOvertimeFinder;
	}

	public void setLmisViewReportOvertimeFinder(
		LmisViewReportOvertimeFinder lmisViewReportOvertimeFinder) {
		this.lmisViewReportOvertimeFinder = lmisViewReportOvertimeFinder;
	}

	public LmisViewAttDailyLocalService getLmisViewAttDailyLocalService() {
		return lmisViewAttDailyLocalService;
	}

	public void setLmisViewAttDailyLocalService(
		LmisViewAttDailyLocalService lmisViewAttDailyLocalService) {
		this.lmisViewAttDailyLocalService = lmisViewAttDailyLocalService;
	}

	public LmisViewAttDailyPersistence getLmisViewAttDailyPersistence() {
		return lmisViewAttDailyPersistence;
	}

	public void setLmisViewAttDailyPersistence(
		LmisViewAttDailyPersistence lmisViewAttDailyPersistence) {
		this.lmisViewAttDailyPersistence = lmisViewAttDailyPersistence;
	}

	public LmisViewAttDailyFinder getLmisViewAttDailyFinder() {
		return lmisViewAttDailyFinder;
	}

	public void setLmisViewAttDailyFinder(
		LmisViewAttDailyFinder lmisViewAttDailyFinder) {
		this.lmisViewAttDailyFinder = lmisViewAttDailyFinder;
	}

	public LmisViewReportOvertimeApprovalLocalService getLmisViewReportOvertimeApprovalLocalService() {
		return lmisViewReportOvertimeApprovalLocalService;
	}

	public void setLmisViewReportOvertimeApprovalLocalService(
		LmisViewReportOvertimeApprovalLocalService lmisViewReportOvertimeApprovalLocalService) {
		this.lmisViewReportOvertimeApprovalLocalService = lmisViewReportOvertimeApprovalLocalService;
	}

	public LmisViewReportOvertimeApprovalService getLmisViewReportOvertimeApprovalService() {
		return lmisViewReportOvertimeApprovalService;
	}

	public void setLmisViewReportOvertimeApprovalService(
		LmisViewReportOvertimeApprovalService lmisViewReportOvertimeApprovalService) {
		this.lmisViewReportOvertimeApprovalService = lmisViewReportOvertimeApprovalService;
	}

	public LmisViewReportOvertimeApprovalPersistence getLmisViewReportOvertimeApprovalPersistence() {
		return lmisViewReportOvertimeApprovalPersistence;
	}

	public void setLmisViewReportOvertimeApprovalPersistence(
		LmisViewReportOvertimeApprovalPersistence lmisViewReportOvertimeApprovalPersistence) {
		this.lmisViewReportOvertimeApprovalPersistence = lmisViewReportOvertimeApprovalPersistence;
	}

	public LmisViewDayValueMaxLocalService getLmisViewDayValueMaxLocalService() {
		return lmisViewDayValueMaxLocalService;
	}

	public void setLmisViewDayValueMaxLocalService(
		LmisViewDayValueMaxLocalService lmisViewDayValueMaxLocalService) {
		this.lmisViewDayValueMaxLocalService = lmisViewDayValueMaxLocalService;
	}

	public LmisViewDayValueMaxService getLmisViewDayValueMaxService() {
		return lmisViewDayValueMaxService;
	}

	public void setLmisViewDayValueMaxService(
		LmisViewDayValueMaxService lmisViewDayValueMaxService) {
		this.lmisViewDayValueMaxService = lmisViewDayValueMaxService;
	}

	public LmisViewDayValueMaxPersistence getLmisViewDayValueMaxPersistence() {
		return lmisViewDayValueMaxPersistence;
	}

	public void setLmisViewDayValueMaxPersistence(
		LmisViewDayValueMaxPersistence lmisViewDayValueMaxPersistence) {
		this.lmisViewDayValueMaxPersistence = lmisViewDayValueMaxPersistence;
	}

	public LmisViewOrgUserRolesLocalService getLmisViewOrgUserRolesLocalService() {
		return lmisViewOrgUserRolesLocalService;
	}

	public void setLmisViewOrgUserRolesLocalService(
		LmisViewOrgUserRolesLocalService lmisViewOrgUserRolesLocalService) {
		this.lmisViewOrgUserRolesLocalService = lmisViewOrgUserRolesLocalService;
	}

	public LmisViewOrgUserRolesService getLmisViewOrgUserRolesService() {
		return lmisViewOrgUserRolesService;
	}

	public void setLmisViewOrgUserRolesService(
		LmisViewOrgUserRolesService lmisViewOrgUserRolesService) {
		this.lmisViewOrgUserRolesService = lmisViewOrgUserRolesService;
	}

	public LmisViewOrgUserRolesPersistence getLmisViewOrgUserRolesPersistence() {
		return lmisViewOrgUserRolesPersistence;
	}

	public void setLmisViewOrgUserRolesPersistence(
		LmisViewOrgUserRolesPersistence lmisViewOrgUserRolesPersistence) {
		this.lmisViewOrgUserRolesPersistence = lmisViewOrgUserRolesPersistence;
	}

	public LmisViewAttInfoLocalService getLmisViewAttInfoLocalService() {
		return lmisViewAttInfoLocalService;
	}

	public void setLmisViewAttInfoLocalService(
		LmisViewAttInfoLocalService lmisViewAttInfoLocalService) {
		this.lmisViewAttInfoLocalService = lmisViewAttInfoLocalService;
	}

	public LmisViewAttInfoPersistence getLmisViewAttInfoPersistence() {
		return lmisViewAttInfoPersistence;
	}

	public void setLmisViewAttInfoPersistence(
		LmisViewAttInfoPersistence lmisViewAttInfoPersistence) {
		this.lmisViewAttInfoPersistence = lmisViewAttInfoPersistence;
	}

	public LmisViewAttInfoFinder getLmisViewAttInfoFinder() {
		return lmisViewAttInfoFinder;
	}

	public void setLmisViewAttInfoFinder(
		LmisViewAttInfoFinder lmisViewAttInfoFinder) {
		this.lmisViewAttInfoFinder = lmisViewAttInfoFinder;
	}

	public LmisViewStaffMappingPmLocalService getLmisViewStaffMappingPmLocalService() {
		return lmisViewStaffMappingPmLocalService;
	}

	public void setLmisViewStaffMappingPmLocalService(
		LmisViewStaffMappingPmLocalService lmisViewStaffMappingPmLocalService) {
		this.lmisViewStaffMappingPmLocalService = lmisViewStaffMappingPmLocalService;
	}

	public LmisViewStaffMappingPmService getLmisViewStaffMappingPmService() {
		return lmisViewStaffMappingPmService;
	}

	public void setLmisViewStaffMappingPmService(
		LmisViewStaffMappingPmService lmisViewStaffMappingPmService) {
		this.lmisViewStaffMappingPmService = lmisViewStaffMappingPmService;
	}

	public LmisViewStaffMappingPmPersistence getLmisViewStaffMappingPmPersistence() {
		return lmisViewStaffMappingPmPersistence;
	}

	public void setLmisViewStaffMappingPmPersistence(
		LmisViewStaffMappingPmPersistence lmisViewStaffMappingPmPersistence) {
		this.lmisViewStaffMappingPmPersistence = lmisViewStaffMappingPmPersistence;
	}

	public LmisViewAttdanceLocalService getLmisViewAttdanceLocalService() {
		return lmisViewAttdanceLocalService;
	}

	public void setLmisViewAttdanceLocalService(
		LmisViewAttdanceLocalService lmisViewAttdanceLocalService) {
		this.lmisViewAttdanceLocalService = lmisViewAttdanceLocalService;
	}

	public LmisViewAttdancePersistence getLmisViewAttdancePersistence() {
		return lmisViewAttdancePersistence;
	}

	public void setLmisViewAttdancePersistence(
		LmisViewAttdancePersistence lmisViewAttdancePersistence) {
		this.lmisViewAttdancePersistence = lmisViewAttdancePersistence;
	}

	public LmisViewAttdanceFinder getLmisViewAttdanceFinder() {
		return lmisViewAttdanceFinder;
	}

	public void setLmisViewAttdanceFinder(
		LmisViewAttdanceFinder lmisViewAttdanceFinder) {
		this.lmisViewAttdanceFinder = lmisViewAttdanceFinder;
	}

	public LmisViewOvertimeReportLocalService getLmisViewOvertimeReportLocalService() {
		return lmisViewOvertimeReportLocalService;
	}

	public void setLmisViewOvertimeReportLocalService(
		LmisViewOvertimeReportLocalService lmisViewOvertimeReportLocalService) {
		this.lmisViewOvertimeReportLocalService = lmisViewOvertimeReportLocalService;
	}

	public LmisViewOvertimeReportService getLmisViewOvertimeReportService() {
		return lmisViewOvertimeReportService;
	}

	public void setLmisViewOvertimeReportService(
		LmisViewOvertimeReportService lmisViewOvertimeReportService) {
		this.lmisViewOvertimeReportService = lmisViewOvertimeReportService;
	}

	public LmisViewOvertimeReportPersistence getLmisViewOvertimeReportPersistence() {
		return lmisViewOvertimeReportPersistence;
	}

	public void setLmisViewOvertimeReportPersistence(
		LmisViewOvertimeReportPersistence lmisViewOvertimeReportPersistence) {
		this.lmisViewOvertimeReportPersistence = lmisViewOvertimeReportPersistence;
	}

	public LmisViewOvertimeReportDetailLocalService getLmisViewOvertimeReportDetailLocalService() {
		return lmisViewOvertimeReportDetailLocalService;
	}

	public void setLmisViewOvertimeReportDetailLocalService(
		LmisViewOvertimeReportDetailLocalService lmisViewOvertimeReportDetailLocalService) {
		this.lmisViewOvertimeReportDetailLocalService = lmisViewOvertimeReportDetailLocalService;
	}

	public LmisViewOvertimeReportDetailService getLmisViewOvertimeReportDetailService() {
		return lmisViewOvertimeReportDetailService;
	}

	public void setLmisViewOvertimeReportDetailService(
		LmisViewOvertimeReportDetailService lmisViewOvertimeReportDetailService) {
		this.lmisViewOvertimeReportDetailService = lmisViewOvertimeReportDetailService;
	}

	public LmisViewOvertimeReportDetailPersistence getLmisViewOvertimeReportDetailPersistence() {
		return lmisViewOvertimeReportDetailPersistence;
	}

	public void setLmisViewOvertimeReportDetailPersistence(
		LmisViewOvertimeReportDetailPersistence lmisViewOvertimeReportDetailPersistence) {
		this.lmisViewOvertimeReportDetailPersistence = lmisViewOvertimeReportDetailPersistence;
	}

	public LmisAttMonthlyLocalService getLmisAttMonthlyLocalService() {
		return lmisAttMonthlyLocalService;
	}

	public void setLmisAttMonthlyLocalService(
		LmisAttMonthlyLocalService lmisAttMonthlyLocalService) {
		this.lmisAttMonthlyLocalService = lmisAttMonthlyLocalService;
	}

	public LmisAttMonthlyPersistence getLmisAttMonthlyPersistence() {
		return lmisAttMonthlyPersistence;
	}

	public void setLmisAttMonthlyPersistence(
		LmisAttMonthlyPersistence lmisAttMonthlyPersistence) {
		this.lmisAttMonthlyPersistence = lmisAttMonthlyPersistence;
	}

	public LmisAttYearlyLocalService getLmisAttYearlyLocalService() {
		return lmisAttYearlyLocalService;
	}

	public void setLmisAttYearlyLocalService(
		LmisAttYearlyLocalService lmisAttYearlyLocalService) {
		this.lmisAttYearlyLocalService = lmisAttYearlyLocalService;
	}

	public LmisAttYearlyPersistence getLmisAttYearlyPersistence() {
		return lmisAttYearlyPersistence;
	}

	public void setLmisAttYearlyPersistence(
		LmisAttYearlyPersistence lmisAttYearlyPersistence) {
		this.lmisAttYearlyPersistence = lmisAttYearlyPersistence;
	}

	protected void runSQL(String sql) throws SystemException {
		try {
			PortalUtil.runSQL(sql);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(name = "larion.progate.lmis.service.LmisEmailSettingsLocalService.impl")
	protected LmisEmailSettingsLocalService lmisEmailSettingsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisEmailSettingsService.impl")
	protected LmisEmailSettingsService lmisEmailSettingsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisEmailSettingsPersistence.impl")
	protected LmisEmailSettingsPersistence lmisEmailSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisEmailSettingDetailsLocalService.impl")
	protected LmisEmailSettingDetailsLocalService lmisEmailSettingDetailsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisEmailSettingDetailsService.impl")
	protected LmisEmailSettingDetailsService lmisEmailSettingDetailsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisEmailSettingDetailsPersistence.impl")
	protected LmisEmailSettingDetailsPersistence lmisEmailSettingDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisTimeChangeApprovalsLocalService.impl")
	protected LmisTimeChangeApprovalsLocalService lmisTimeChangeApprovalsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisTimeChangeApprovalsService.impl")
	protected LmisTimeChangeApprovalsService lmisTimeChangeApprovalsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsPersistence.impl")
	protected LmisTimeChangeApprovalsPersistence lmisTimeChangeApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisTimeChangeRequestsLocalService.impl")
	protected LmisTimeChangeRequestsLocalService lmisTimeChangeRequestsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisTimeChangeRequestsService.impl")
	protected LmisTimeChangeRequestsService lmisTimeChangeRequestsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisTimeChangeRequestsPersistence.impl")
	protected LmisTimeChangeRequestsPersistence lmisTimeChangeRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisWorkingTimesLocalService.impl")
	protected LmisWorkingTimesLocalService lmisWorkingTimesLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisWorkingTimesService.impl")
	protected LmisWorkingTimesService lmisWorkingTimesService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingTimesPersistence.impl")
	protected LmisWorkingTimesPersistence lmisWorkingTimesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisDayTypesLocalService.impl")
	protected LmisDayTypesLocalService lmisDayTypesLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisDayTypesService.impl")
	protected LmisDayTypesService lmisDayTypesService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDayTypesPersistence.impl")
	protected LmisDayTypesPersistence lmisDayTypesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisWorkingCalendarsLocalService.impl")
	protected LmisWorkingCalendarsLocalService lmisWorkingCalendarsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisWorkingCalendarsService.impl")
	protected LmisWorkingCalendarsService lmisWorkingCalendarsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingCalendarsPersistence.impl")
	protected LmisWorkingCalendarsPersistence lmisWorkingCalendarsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingCalendarsFinder.impl")
	protected LmisWorkingCalendarsFinder lmisWorkingCalendarsFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisWorkingCalendarSessionsLocalService.impl")
	protected LmisWorkingCalendarSessionsLocalService lmisWorkingCalendarSessionsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisWorkingCalendarSessionsService.impl")
	protected LmisWorkingCalendarSessionsService lmisWorkingCalendarSessionsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisWorkingCalendarSessionsPersistence.impl")
	protected LmisWorkingCalendarSessionsPersistence lmisWorkingCalendarSessionsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisGeneralSettingsLocalService.impl")
	protected LmisGeneralSettingsLocalService lmisGeneralSettingsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisGeneralSettingsService.impl")
	protected LmisGeneralSettingsService lmisGeneralSettingsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisGeneralSettingsPersistence.impl")
	protected LmisGeneralSettingsPersistence lmisGeneralSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisGeneralSettingsFinder.impl")
	protected LmisGeneralSettingsFinder lmisGeneralSettingsFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffMappingLocalService.impl")
	protected LmisViewStaffMappingLocalService lmisViewStaffMappingLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffMappingService.impl")
	protected LmisViewStaffMappingService lmisViewStaffMappingService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffMappingPersistence.impl")
	protected LmisViewStaffMappingPersistence lmisViewStaffMappingPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffRootOrgLocalService.impl")
	protected LmisViewStaffRootOrgLocalService lmisViewStaffRootOrgLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffRootOrgService.impl")
	protected LmisViewStaffRootOrgService lmisViewStaffRootOrgService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgPersistence.impl")
	protected LmisViewStaffRootOrgPersistence lmisViewStaffRootOrgPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffRootOrgFNLocalService.impl")
	protected LmisViewStaffRootOrgFNLocalService lmisViewStaffRootOrgFNLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffRootOrgFNService.impl")
	protected LmisViewStaffRootOrgFNService lmisViewStaffRootOrgFNService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNPersistence.impl")
	protected LmisViewStaffRootOrgFNPersistence lmisViewStaffRootOrgFNPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNFinder.impl")
	protected LmisViewStaffRootOrgFNFinder lmisViewStaffRootOrgFNFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffRootOrgOrderedLocalService.impl")
	protected LmisViewStaffRootOrgOrderedLocalService lmisViewStaffRootOrgOrderedLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffRootOrgOrderedService.impl")
	protected LmisViewStaffRootOrgOrderedService lmisViewStaffRootOrgOrderedService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedPersistence.impl")
	protected LmisViewStaffRootOrgOrderedPersistence lmisViewStaffRootOrgOrderedPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffRootOrgOrderedFinder.impl")
	protected LmisViewStaffRootOrgOrderedFinder lmisViewStaffRootOrgOrderedFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewTimeChangeReqsLocalService.impl")
	protected LmisViewTimeChangeReqsLocalService lmisViewTimeChangeReqsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewTimeChangeReqsService.impl")
	protected LmisViewTimeChangeReqsService lmisViewTimeChangeReqsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsPersistence.impl")
	protected LmisViewTimeChangeReqsPersistence lmisViewTimeChangeReqsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewEmailSettingDetailOrgLocalService.impl")
	protected LmisViewEmailSettingDetailOrgLocalService lmisViewEmailSettingDetailOrgLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewEmailSettingDetailOrgService.impl")
	protected LmisViewEmailSettingDetailOrgService lmisViewEmailSettingDetailOrgService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailOrgPersistence.impl")
	protected LmisViewEmailSettingDetailOrgPersistence lmisViewEmailSettingDetailOrgPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewEmailSettingDetailUserLocalService.impl")
	protected LmisViewEmailSettingDetailUserLocalService lmisViewEmailSettingDetailUserLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewEmailSettingDetailUserService.impl")
	protected LmisViewEmailSettingDetailUserService lmisViewEmailSettingDetailUserService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserPersistence.impl")
	protected LmisViewEmailSettingDetailUserPersistence lmisViewEmailSettingDetailUserPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewWorkingCalendarLocalService.impl")
	protected LmisViewWorkingCalendarLocalService lmisViewWorkingCalendarLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewWorkingCalendarService.impl")
	protected LmisViewWorkingCalendarService lmisViewWorkingCalendarService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewWorkingCalendarPersistence.impl")
	protected LmisViewWorkingCalendarPersistence lmisViewWorkingCalendarPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeSettingsLocalService.impl")
	protected LmisOverTimeSettingsLocalService lmisOverTimeSettingsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeSettingsService.impl")
	protected LmisOverTimeSettingsService lmisOverTimeSettingsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeSettingsPersistence.impl")
	protected LmisOverTimeSettingsPersistence lmisOverTimeSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeTypesLocalService.impl")
	protected LmisOverTimeTypesLocalService lmisOverTimeTypesLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeTypesService.impl")
	protected LmisOverTimeTypesService lmisOverTimeTypesService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeTypesPersistence.impl")
	protected LmisOverTimeTypesPersistence lmisOverTimeTypesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisDataInputsLocalService.impl")
	protected LmisDataInputsLocalService lmisDataInputsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisDataInputsService.impl")
	protected LmisDataInputsService lmisDataInputsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataInputsPersistence.impl")
	protected LmisDataInputsPersistence lmisDataInputsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisAttendanceDailyLocalService.impl")
	protected LmisAttendanceDailyLocalService lmisAttendanceDailyLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisAttendanceDailyService.impl")
	protected LmisAttendanceDailyService lmisAttendanceDailyService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttendanceDailyPersistence.impl")
	protected LmisAttendanceDailyPersistence lmisAttendanceDailyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttendanceDailyFinder.impl")
	protected LmisAttendanceDailyFinder lmisAttendanceDailyFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeRequestsLocalService.impl")
	protected LmisOvertimeRequestsLocalService lmisOvertimeRequestsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeRequestsService.impl")
	protected LmisOvertimeRequestsService lmisOvertimeRequestsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeRequestsPersistence.impl")
	protected LmisOvertimeRequestsPersistence lmisOvertimeRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeRequestDetailsLocalService.impl")
	protected LmisOvertimeRequestDetailsLocalService lmisOvertimeRequestDetailsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeRequestDetailsService.impl")
	protected LmisOvertimeRequestDetailsService lmisOvertimeRequestDetailsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsPersistence.impl")
	protected LmisOvertimeRequestDetailsPersistence lmisOvertimeRequestDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeApprovalsLocalService.impl")
	protected LmisOvertimeApprovalsLocalService lmisOvertimeApprovalsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeApprovalsService.impl")
	protected LmisOvertimeApprovalsService lmisOvertimeApprovalsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeApprovalsPersistence.impl")
	protected LmisOvertimeApprovalsPersistence lmisOvertimeApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeApprovalsFinder.impl")
	protected LmisOvertimeApprovalsFinder lmisOvertimeApprovalsFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeMonthlyLocalService.impl")
	protected LmisOvertimeMonthlyLocalService lmisOvertimeMonthlyLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeMonthlyService.impl")
	protected LmisOvertimeMonthlyService lmisOvertimeMonthlyService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeMonthlyPersistence.impl")
	protected LmisOvertimeMonthlyPersistence lmisOvertimeMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisDataImportsLocalService.impl")
	protected LmisDataImportsLocalService lmisDataImportsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisDataImportsService.impl")
	protected LmisDataImportsService lmisDataImportsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataImportsPersistence.impl")
	protected LmisDataImportsPersistence lmisDataImportsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisDataImportDetailsLocalService.impl")
	protected LmisDataImportDetailsLocalService lmisDataImportDetailsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisDataImportDetailsService.impl")
	protected LmisDataImportDetailsService lmisDataImportDetailsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisDataImportDetailsPersistence.impl")
	protected LmisDataImportDetailsPersistence lmisDataImportDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeReportHoursLocalService.impl")
	protected LmisOverTimeReportHoursLocalService lmisOverTimeReportHoursLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeReportHoursService.impl")
	protected LmisOverTimeReportHoursService lmisOverTimeReportHoursService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportHoursPersistence.impl")
	protected LmisOverTimeReportHoursPersistence lmisOverTimeReportHoursPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeReportDetailsLocalService.impl")
	protected LmisOverTimeReportDetailsLocalService lmisOverTimeReportDetailsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeReportDetailsService.impl")
	protected LmisOverTimeReportDetailsService lmisOverTimeReportDetailsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsPersistence.impl")
	protected LmisOverTimeReportDetailsPersistence lmisOverTimeReportDetailsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeReportsLocalService.impl")
	protected LmisOverTimeReportsLocalService lmisOverTimeReportsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOverTimeReportsService.impl")
	protected LmisOverTimeReportsService lmisOverTimeReportsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOverTimeReportsPersistence.impl")
	protected LmisOverTimeReportsPersistence lmisOverTimeReportsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeYearlyLocalService.impl")
	protected LmisOvertimeYearlyLocalService lmisOvertimeYearlyLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisOvertimeYearlyService.impl")
	protected LmisOvertimeYearlyService lmisOvertimeYearlyService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisOvertimeYearlyPersistence.impl")
	protected LmisOvertimeYearlyPersistence lmisOvertimeYearlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceYearlyLocalService.impl")
	protected LmisAbsenceYearlyLocalService lmisAbsenceYearlyLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceYearlyService.impl")
	protected LmisAbsenceYearlyService lmisAbsenceYearlyService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceYearlyPersistence.impl")
	protected LmisAbsenceYearlyPersistence lmisAbsenceYearlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceYearlyFinder.impl")
	protected LmisAbsenceYearlyFinder lmisAbsenceYearlyFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceMonthlyLocalService.impl")
	protected LmisAbsenceMonthlyLocalService lmisAbsenceMonthlyLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceMonthlyService.impl")
	protected LmisAbsenceMonthlyService lmisAbsenceMonthlyService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceMonthlyPersistence.impl")
	protected LmisAbsenceMonthlyPersistence lmisAbsenceMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceSettingsLocalService.impl")
	protected LmisAbsenceSettingsLocalService lmisAbsenceSettingsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceSettingsService.impl")
	protected LmisAbsenceSettingsService lmisAbsenceSettingsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceSettingsPersistence.impl")
	protected LmisAbsenceSettingsPersistence lmisAbsenceSettingsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceApprovalsLocalService.impl")
	protected LmisAbsenceApprovalsLocalService lmisAbsenceApprovalsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceApprovalsService.impl")
	protected LmisAbsenceApprovalsService lmisAbsenceApprovalsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceApprovalsPersistence.impl")
	protected LmisAbsenceApprovalsPersistence lmisAbsenceApprovalsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceRequestsLocalService.impl")
	protected LmisAbsenceRequestsLocalService lmisAbsenceRequestsLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisAbsenceRequestsService.impl")
	protected LmisAbsenceRequestsService lmisAbsenceRequestsService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceRequestsPersistence.impl")
	protected LmisAbsenceRequestsPersistence lmisAbsenceRequestsPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAbsenceRequestsFinder.impl")
	protected LmisAbsenceRequestsFinder lmisAbsenceRequestsFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewDayTypeOverTimeSettingTypeLocalService.impl")
	protected LmisViewDayTypeOverTimeSettingTypeLocalService lmisViewDayTypeOverTimeSettingTypeLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewDayTypeOverTimeSettingTypeService.impl")
	protected LmisViewDayTypeOverTimeSettingTypeService lmisViewDayTypeOverTimeSettingTypeService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewDayTypeOverTimeSettingTypePersistence.impl")
	protected LmisViewDayTypeOverTimeSettingTypePersistence lmisViewDayTypeOverTimeSettingTypePersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalService.impl")
	protected LmisViewRegistrationOvertimeLocalService lmisViewRegistrationOvertimeLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewRegistrationOvertimeService.impl")
	protected LmisViewRegistrationOvertimeService lmisViewRegistrationOvertimeService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimePersistence.impl")
	protected LmisViewRegistrationOvertimePersistence lmisViewRegistrationOvertimePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeFinder.impl")
	protected LmisViewRegistrationOvertimeFinder lmisViewRegistrationOvertimeFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewRegistrationOvertimeaApprovalLocalService.impl")
	protected LmisViewRegistrationOvertimeaApprovalLocalService lmisViewRegistrationOvertimeaApprovalLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewRegistrationOvertimeaApprovalService.impl")
	protected LmisViewRegistrationOvertimeaApprovalService lmisViewRegistrationOvertimeaApprovalService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeaApprovalPersistence.impl")
	protected LmisViewRegistrationOvertimeaApprovalPersistence lmisViewRegistrationOvertimeaApprovalPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewOTAppLocalService.impl")
	protected LmisViewOTAppLocalService lmisViewOTAppLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewOTAppService.impl")
	protected LmisViewOTAppService lmisViewOTAppService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOTAppPersistence.impl")
	protected LmisViewOTAppPersistence lmisViewOTAppPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewReportOvertimeLocalService.impl")
	protected LmisViewReportOvertimeLocalService lmisViewReportOvertimeLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewReportOvertimeService.impl")
	protected LmisViewReportOvertimeService lmisViewReportOvertimeService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewReportOvertimePersistence.impl")
	protected LmisViewReportOvertimePersistence lmisViewReportOvertimePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewReportOvertimeFinder.impl")
	protected LmisViewReportOvertimeFinder lmisViewReportOvertimeFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewAttDailyLocalService.impl")
	protected LmisViewAttDailyLocalService lmisViewAttDailyLocalService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttDailyPersistence.impl")
	protected LmisViewAttDailyPersistence lmisViewAttDailyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttDailyFinder.impl")
	protected LmisViewAttDailyFinder lmisViewAttDailyFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewReportOvertimeApprovalLocalService.impl")
	protected LmisViewReportOvertimeApprovalLocalService lmisViewReportOvertimeApprovalLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewReportOvertimeApprovalService.impl")
	protected LmisViewReportOvertimeApprovalService lmisViewReportOvertimeApprovalService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewReportOvertimeApprovalPersistence.impl")
	protected LmisViewReportOvertimeApprovalPersistence lmisViewReportOvertimeApprovalPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewDayValueMaxLocalService.impl")
	protected LmisViewDayValueMaxLocalService lmisViewDayValueMaxLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewDayValueMaxService.impl")
	protected LmisViewDayValueMaxService lmisViewDayValueMaxService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewDayValueMaxPersistence.impl")
	protected LmisViewDayValueMaxPersistence lmisViewDayValueMaxPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewOrgUserRolesLocalService.impl")
	protected LmisViewOrgUserRolesLocalService lmisViewOrgUserRolesLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewOrgUserRolesService.impl")
	protected LmisViewOrgUserRolesService lmisViewOrgUserRolesService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOrgUserRolesPersistence.impl")
	protected LmisViewOrgUserRolesPersistence lmisViewOrgUserRolesPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewAttInfoLocalService.impl")
	protected LmisViewAttInfoLocalService lmisViewAttInfoLocalService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttInfoPersistence.impl")
	protected LmisViewAttInfoPersistence lmisViewAttInfoPersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttInfoFinder.impl")
	protected LmisViewAttInfoFinder lmisViewAttInfoFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffMappingPmLocalService.impl")
	protected LmisViewStaffMappingPmLocalService lmisViewStaffMappingPmLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewStaffMappingPmService.impl")
	protected LmisViewStaffMappingPmService lmisViewStaffMappingPmService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewStaffMappingPmPersistence.impl")
	protected LmisViewStaffMappingPmPersistence lmisViewStaffMappingPmPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewAttdanceLocalService.impl")
	protected LmisViewAttdanceLocalService lmisViewAttdanceLocalService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttdancePersistence.impl")
	protected LmisViewAttdancePersistence lmisViewAttdancePersistence;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewAttdanceFinder.impl")
	protected LmisViewAttdanceFinder lmisViewAttdanceFinder;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewOvertimeReportLocalService.impl")
	protected LmisViewOvertimeReportLocalService lmisViewOvertimeReportLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewOvertimeReportService.impl")
	protected LmisViewOvertimeReportService lmisViewOvertimeReportService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOvertimeReportPersistence.impl")
	protected LmisViewOvertimeReportPersistence lmisViewOvertimeReportPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewOvertimeReportDetailLocalService.impl")
	protected LmisViewOvertimeReportDetailLocalService lmisViewOvertimeReportDetailLocalService;
	@BeanReference(name = "larion.progate.lmis.service.LmisViewOvertimeReportDetailService.impl")
	protected LmisViewOvertimeReportDetailService lmisViewOvertimeReportDetailService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisViewOvertimeReportDetailPersistence.impl")
	protected LmisViewOvertimeReportDetailPersistence lmisViewOvertimeReportDetailPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisAttMonthlyLocalService.impl")
	protected LmisAttMonthlyLocalService lmisAttMonthlyLocalService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttMonthlyPersistence.impl")
	protected LmisAttMonthlyPersistence lmisAttMonthlyPersistence;
	@BeanReference(name = "larion.progate.lmis.service.LmisAttYearlyLocalService.impl")
	protected LmisAttYearlyLocalService lmisAttYearlyLocalService;
	@BeanReference(name = "larion.progate.lmis.service.persistence.LmisAttYearlyPersistence.impl")
	protected LmisAttYearlyPersistence lmisAttYearlyPersistence;
}