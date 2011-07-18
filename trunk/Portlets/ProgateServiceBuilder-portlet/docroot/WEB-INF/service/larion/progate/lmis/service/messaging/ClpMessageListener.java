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

package larion.progate.lmis.service.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import larion.progate.lmis.service.ClpSerializer;
import larion.progate.lmis.service.LmisAbsenceApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceApprovalsServiceUtil;
import larion.progate.lmis.service.LmisAbsenceMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceMonthlyServiceUtil;
import larion.progate.lmis.service.LmisAbsenceRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceRequestsServiceUtil;
import larion.progate.lmis.service.LmisAbsenceSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceSettingsServiceUtil;
import larion.progate.lmis.service.LmisAbsenceYearlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceYearlyServiceUtil;
import larion.progate.lmis.service.LmisAttMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttYearlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttendanceDailyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttendanceDailyServiceUtil;
import larion.progate.lmis.service.LmisDataImportDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisDataImportDetailsServiceUtil;
import larion.progate.lmis.service.LmisDataImportsLocalServiceUtil;
import larion.progate.lmis.service.LmisDataImportsServiceUtil;
import larion.progate.lmis.service.LmisDataInputsLocalServiceUtil;
import larion.progate.lmis.service.LmisDataInputsServiceUtil;
import larion.progate.lmis.service.LmisDayTypesLocalServiceUtil;
import larion.progate.lmis.service.LmisDayTypesServiceUtil;
import larion.progate.lmis.service.LmisEmailSettingDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisEmailSettingDetailsServiceUtil;
import larion.progate.lmis.service.LmisEmailSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisEmailSettingsServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsServiceUtil;
import larion.progate.lmis.service.LmisOverTimeReportDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeReportDetailsServiceUtil;
import larion.progate.lmis.service.LmisOverTimeReportHoursLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeReportHoursServiceUtil;
import larion.progate.lmis.service.LmisOverTimeReportsLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeReportsServiceUtil;
import larion.progate.lmis.service.LmisOverTimeSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeSettingsServiceUtil;
import larion.progate.lmis.service.LmisOverTimeTypesLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeTypesServiceUtil;
import larion.progate.lmis.service.LmisOvertimeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeApprovalsServiceUtil;
import larion.progate.lmis.service.LmisOvertimeMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeMonthlyServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestDetailsServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestsServiceUtil;
import larion.progate.lmis.service.LmisOvertimeYearlyLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeYearlyServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeApprovalsServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeRequestsServiceUtil;
import larion.progate.lmis.service.LmisViewAttDailyLocalServiceUtil;
import larion.progate.lmis.service.LmisViewAttInfoLocalServiceUtil;
import larion.progate.lmis.service.LmisViewAttdanceLocalServiceUtil;
import larion.progate.lmis.service.LmisViewDayTypeOverTimeSettingTypeLocalServiceUtil;
import larion.progate.lmis.service.LmisViewDayTypeOverTimeSettingTypeServiceUtil;
import larion.progate.lmis.service.LmisViewDayValueMaxLocalServiceUtil;
import larion.progate.lmis.service.LmisViewDayValueMaxServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailOrgLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailOrgServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailUserLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailUserServiceUtil;
import larion.progate.lmis.service.LmisViewOTAppLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOTAppServiceUtil;
import larion.progate.lmis.service.LmisViewOrgUserRolesLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOrgUserRolesServiceUtil;
import larion.progate.lmis.service.LmisViewOvertimeReportDetailLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOvertimeReportDetailServiceUtil;
import larion.progate.lmis.service.LmisViewOvertimeReportLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOvertimeReportServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeaApprovalLocalServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeaApprovalServiceUtil;
import larion.progate.lmis.service.LmisViewReportOvertimeApprovalLocalServiceUtil;
import larion.progate.lmis.service.LmisViewReportOvertimeApprovalServiceUtil;
import larion.progate.lmis.service.LmisViewReportOvertimeLocalServiceUtil;
import larion.progate.lmis.service.LmisViewReportOvertimeServiceUtil;
import larion.progate.lmis.service.LmisViewStaffMappingLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffMappingPmLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffMappingPmServiceUtil;
import larion.progate.lmis.service.LmisViewStaffMappingServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgFNLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgFNServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgOrderedLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgOrderedServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgServiceUtil;
import larion.progate.lmis.service.LmisViewTimeChangeReqsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewTimeChangeReqsServiceUtil;
import larion.progate.lmis.service.LmisViewWorkingCalendarLocalServiceUtil;
import larion.progate.lmis.service.LmisViewWorkingCalendarServiceUtil;
import larion.progate.lmis.service.LmisWorkingCalendarSessionsLocalServiceUtil;
import larion.progate.lmis.service.LmisWorkingCalendarSessionsServiceUtil;
import larion.progate.lmis.service.LmisWorkingCalendarsLocalServiceUtil;
import larion.progate.lmis.service.LmisWorkingCalendarsServiceUtil;
import larion.progate.lmis.service.LmisWorkingTimesLocalServiceUtil;
import larion.progate.lmis.service.LmisWorkingTimesServiceUtil;

/**
 * <a href="ClpMessageListener.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ClpMessageListener implements MessageListener {
	public static final String SERVLET_CONTEXT_NAME = ClpSerializer.SERVLET_CONTEXT_NAME;

	public void receive(Message message) {
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(SERVLET_CONTEXT_NAME)) {
			LmisEmailSettingsLocalServiceUtil.clearService();

			LmisEmailSettingsServiceUtil.clearService();
			LmisEmailSettingDetailsLocalServiceUtil.clearService();

			LmisEmailSettingDetailsServiceUtil.clearService();
			LmisTimeChangeApprovalsLocalServiceUtil.clearService();

			LmisTimeChangeApprovalsServiceUtil.clearService();
			LmisTimeChangeRequestsLocalServiceUtil.clearService();

			LmisTimeChangeRequestsServiceUtil.clearService();
			LmisWorkingTimesLocalServiceUtil.clearService();

			LmisWorkingTimesServiceUtil.clearService();
			LmisDayTypesLocalServiceUtil.clearService();

			LmisDayTypesServiceUtil.clearService();
			LmisWorkingCalendarsLocalServiceUtil.clearService();

			LmisWorkingCalendarsServiceUtil.clearService();
			LmisWorkingCalendarSessionsLocalServiceUtil.clearService();

			LmisWorkingCalendarSessionsServiceUtil.clearService();
			LmisGeneralSettingsLocalServiceUtil.clearService();

			LmisGeneralSettingsServiceUtil.clearService();
			LmisViewStaffMappingLocalServiceUtil.clearService();

			LmisViewStaffMappingServiceUtil.clearService();
			LmisViewStaffRootOrgLocalServiceUtil.clearService();

			LmisViewStaffRootOrgServiceUtil.clearService();
			LmisViewStaffRootOrgFNLocalServiceUtil.clearService();

			LmisViewStaffRootOrgFNServiceUtil.clearService();
			LmisViewStaffRootOrgOrderedLocalServiceUtil.clearService();

			LmisViewStaffRootOrgOrderedServiceUtil.clearService();
			LmisViewTimeChangeReqsLocalServiceUtil.clearService();

			LmisViewTimeChangeReqsServiceUtil.clearService();
			LmisViewEmailSettingDetailOrgLocalServiceUtil.clearService();

			LmisViewEmailSettingDetailOrgServiceUtil.clearService();
			LmisViewEmailSettingDetailUserLocalServiceUtil.clearService();

			LmisViewEmailSettingDetailUserServiceUtil.clearService();
			LmisViewWorkingCalendarLocalServiceUtil.clearService();

			LmisViewWorkingCalendarServiceUtil.clearService();
			LmisOverTimeSettingsLocalServiceUtil.clearService();

			LmisOverTimeSettingsServiceUtil.clearService();
			LmisOverTimeTypesLocalServiceUtil.clearService();

			LmisOverTimeTypesServiceUtil.clearService();
			LmisDataInputsLocalServiceUtil.clearService();

			LmisDataInputsServiceUtil.clearService();
			LmisAttendanceDailyLocalServiceUtil.clearService();

			LmisAttendanceDailyServiceUtil.clearService();
			LmisOvertimeRequestsLocalServiceUtil.clearService();

			LmisOvertimeRequestsServiceUtil.clearService();
			LmisOvertimeRequestDetailsLocalServiceUtil.clearService();

			LmisOvertimeRequestDetailsServiceUtil.clearService();
			LmisOvertimeApprovalsLocalServiceUtil.clearService();

			LmisOvertimeApprovalsServiceUtil.clearService();
			LmisOvertimeMonthlyLocalServiceUtil.clearService();

			LmisOvertimeMonthlyServiceUtil.clearService();
			LmisDataImportsLocalServiceUtil.clearService();

			LmisDataImportsServiceUtil.clearService();
			LmisDataImportDetailsLocalServiceUtil.clearService();

			LmisDataImportDetailsServiceUtil.clearService();
			LmisOverTimeReportHoursLocalServiceUtil.clearService();

			LmisOverTimeReportHoursServiceUtil.clearService();
			LmisOverTimeReportDetailsLocalServiceUtil.clearService();

			LmisOverTimeReportDetailsServiceUtil.clearService();
			LmisOverTimeReportsLocalServiceUtil.clearService();

			LmisOverTimeReportsServiceUtil.clearService();
			LmisOvertimeYearlyLocalServiceUtil.clearService();

			LmisOvertimeYearlyServiceUtil.clearService();
			LmisAbsenceYearlyLocalServiceUtil.clearService();

			LmisAbsenceYearlyServiceUtil.clearService();
			LmisAbsenceMonthlyLocalServiceUtil.clearService();

			LmisAbsenceMonthlyServiceUtil.clearService();
			LmisAbsenceSettingsLocalServiceUtil.clearService();

			LmisAbsenceSettingsServiceUtil.clearService();
			LmisAbsenceApprovalsLocalServiceUtil.clearService();

			LmisAbsenceApprovalsServiceUtil.clearService();
			LmisAbsenceRequestsLocalServiceUtil.clearService();

			LmisAbsenceRequestsServiceUtil.clearService();
			LmisViewDayTypeOverTimeSettingTypeLocalServiceUtil.clearService();

			LmisViewDayTypeOverTimeSettingTypeServiceUtil.clearService();
			LmisViewRegistrationOvertimeLocalServiceUtil.clearService();

			LmisViewRegistrationOvertimeServiceUtil.clearService();
			LmisViewRegistrationOvertimeaApprovalLocalServiceUtil.clearService();

			LmisViewRegistrationOvertimeaApprovalServiceUtil.clearService();
			LmisViewOTAppLocalServiceUtil.clearService();

			LmisViewOTAppServiceUtil.clearService();
			LmisViewReportOvertimeLocalServiceUtil.clearService();

			LmisViewReportOvertimeServiceUtil.clearService();
			LmisViewAttDailyLocalServiceUtil.clearService();

			LmisViewReportOvertimeApprovalLocalServiceUtil.clearService();

			LmisViewReportOvertimeApprovalServiceUtil.clearService();
			LmisViewDayValueMaxLocalServiceUtil.clearService();

			LmisViewDayValueMaxServiceUtil.clearService();
			LmisViewOrgUserRolesLocalServiceUtil.clearService();

			LmisViewOrgUserRolesServiceUtil.clearService();
			LmisViewAttInfoLocalServiceUtil.clearService();

			LmisViewStaffMappingPmLocalServiceUtil.clearService();

			LmisViewStaffMappingPmServiceUtil.clearService();
			LmisViewAttdanceLocalServiceUtil.clearService();

			LmisViewOvertimeReportLocalServiceUtil.clearService();

			LmisViewOvertimeReportServiceUtil.clearService();
			LmisViewOvertimeReportDetailLocalServiceUtil.clearService();

			LmisViewOvertimeReportDetailServiceUtil.clearService();
			LmisAttMonthlyLocalServiceUtil.clearService();

			LmisAttYearlyLocalServiceUtil.clearService();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpMessageListener.class);
}