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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import larion.progate.lmis.model.LmisAbsenceApprovalsClp;
import larion.progate.lmis.model.LmisAbsenceMonthlyClp;
import larion.progate.lmis.model.LmisAbsenceRequestsClp;
import larion.progate.lmis.model.LmisAbsenceSettingsClp;
import larion.progate.lmis.model.LmisAbsenceYearlyClp;
import larion.progate.lmis.model.LmisAttMonthlyClp;
import larion.progate.lmis.model.LmisAttYearlyClp;
import larion.progate.lmis.model.LmisAttendanceDailyClp;
import larion.progate.lmis.model.LmisDataImportDetailsClp;
import larion.progate.lmis.model.LmisDataImportsClp;
import larion.progate.lmis.model.LmisDataInputsClp;
import larion.progate.lmis.model.LmisDayTypesClp;
import larion.progate.lmis.model.LmisEmailSettingDetailsClp;
import larion.progate.lmis.model.LmisEmailSettingsClp;
import larion.progate.lmis.model.LmisGeneralSettingsClp;
import larion.progate.lmis.model.LmisOverTimeReportDetailsClp;
import larion.progate.lmis.model.LmisOverTimeReportHoursClp;
import larion.progate.lmis.model.LmisOverTimeReportsClp;
import larion.progate.lmis.model.LmisOverTimeSettingsClp;
import larion.progate.lmis.model.LmisOverTimeTypesClp;
import larion.progate.lmis.model.LmisOvertimeApprovalsClp;
import larion.progate.lmis.model.LmisOvertimeMonthlyClp;
import larion.progate.lmis.model.LmisOvertimeRequestDetailsClp;
import larion.progate.lmis.model.LmisOvertimeRequestsClp;
import larion.progate.lmis.model.LmisOvertimeYearlyClp;
import larion.progate.lmis.model.LmisTimeChangeApprovalsClp;
import larion.progate.lmis.model.LmisTimeChangeRequestsClp;
import larion.progate.lmis.model.LmisViewAttDailyClp;
import larion.progate.lmis.model.LmisViewAttInfoClp;
import larion.progate.lmis.model.LmisViewAttdanceClp;
import larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingTypeClp;
import larion.progate.lmis.model.LmisViewDayValueMaxClp;
import larion.progate.lmis.model.LmisViewEmailSettingDetailOrgClp;
import larion.progate.lmis.model.LmisViewEmailSettingDetailUserClp;
import larion.progate.lmis.model.LmisViewOTAppClp;
import larion.progate.lmis.model.LmisViewOrgUserRolesClp;
import larion.progate.lmis.model.LmisViewOvertimeReportClp;
import larion.progate.lmis.model.LmisViewOvertimeReportDetailClp;
import larion.progate.lmis.model.LmisViewRegistrationOvertimeClp;
import larion.progate.lmis.model.LmisViewRegistrationOvertimeaApprovalClp;
import larion.progate.lmis.model.LmisViewReportOvertimeApprovalClp;
import larion.progate.lmis.model.LmisViewReportOvertimeClp;
import larion.progate.lmis.model.LmisViewStaffMappingClp;
import larion.progate.lmis.model.LmisViewStaffMappingPmClp;
import larion.progate.lmis.model.LmisViewStaffRootOrgClp;
import larion.progate.lmis.model.LmisViewStaffRootOrgFNClp;
import larion.progate.lmis.model.LmisViewStaffRootOrgOrderedClp;
import larion.progate.lmis.model.LmisViewTimeChangeReqsClp;
import larion.progate.lmis.model.LmisViewWorkingCalendarClp;
import larion.progate.lmis.model.LmisWorkingCalendarSessionsClp;
import larion.progate.lmis.model.LmisWorkingCalendarsClp;
import larion.progate.lmis.model.LmisWorkingTimesClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ClpSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "ProgateServiceBuilder-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(LmisEmailSettingsClp.class.getName())) {
			LmisEmailSettingsClp oldCplModel = (LmisEmailSettingsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisEmailSettingsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisEmailSettingId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisEmailSettingId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setEmailName",
							new Class[] { String.class });

					String value2 = oldCplModel.getEmailName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setEmailDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getEmailDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setEmailTemplate",
							new Class[] { String.class });

					String value4 = oldCplModel.getEmailTemplate();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setEmailType",
							new Class[] { String.class });

					String value5 = oldCplModel.getEmailType();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCategory",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getCategory());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setToSender",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getToSender());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setToPm",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getToPm());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setToBod",
							new Class[] { Boolean.TYPE });

					Boolean value9 = new Boolean(oldCplModel.getToBod());

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisEmailSettingDetailsClp.class.getName())) {
			LmisEmailSettingDetailsClp oldCplModel = (LmisEmailSettingDetailsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisEmailSettingDetailsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisEmailSettingDetailId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisEmailSettingDetailId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setEmailSettingId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getEmailSettingId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgRelatedId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOrgRelatedId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserRelatedId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserRelatedId());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisTimeChangeApprovalsClp.class.getName())) {
			LmisTimeChangeApprovalsClp oldCplModel = (LmisTimeChangeApprovalsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisTimeChangeApprovalsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisTimeChangeApprovalId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisTimeChangeApprovalId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRequestId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setApprovedBy",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getApprovedBy());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setApprovedAt",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getApprovedAt();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIsApproved",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getIsApproved());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setApprovedStatus",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getApprovedStatus());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setReason",
							new Class[] { String.class });

					String value7 = oldCplModel.getReason();

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisTimeChangeRequestsClp.class.getName())) {
			LmisTimeChangeRequestsClp oldCplModel = (LmisTimeChangeRequestsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisTimeChangeRequestsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisTimeChangeRequestId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisTimeChangeRequestId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestedBy",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRequestedBy());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setStartDate",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getStartDate();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setEndDate",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getEndDate();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setMonSelected",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getMonSelected());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setMonStartTime",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getMonStartTime();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setMonEndTime",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getMonEndTime();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setTueSelected",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getTueSelected());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setTueStartTime",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getTueStartTime();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setTueEndTime",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getTueEndTime();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setWedSelected",
							new Class[] { Boolean.TYPE });

					Boolean value11 = new Boolean(oldCplModel.getWedSelected());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setWedStartTime",
							new Class[] { Date.class });

					Date value12 = oldCplModel.getWedStartTime();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setWedEndTime",
							new Class[] { Date.class });

					Date value13 = oldCplModel.getWedEndTime();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setThuSelected",
							new Class[] { Boolean.TYPE });

					Boolean value14 = new Boolean(oldCplModel.getThuSelected());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setThuStartTime",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getThuStartTime();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setThuEndTime",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getThuEndTime();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setFriSelected",
							new Class[] { Boolean.TYPE });

					Boolean value17 = new Boolean(oldCplModel.getFriSelected());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setFriStartTime",
							new Class[] { Date.class });

					Date value18 = oldCplModel.getFriStartTime();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setFriEndTime",
							new Class[] { Date.class });

					Date value19 = oldCplModel.getFriEndTime();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setSatSelected",
							new Class[] { Boolean.TYPE });

					Boolean value20 = new Boolean(oldCplModel.getSatSelected());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setSatStartTime",
							new Class[] { Date.class });

					Date value21 = oldCplModel.getSatStartTime();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setSatEndTime",
							new Class[] { Date.class });

					Date value22 = oldCplModel.getSatEndTime();

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setRequestedReason",
							new Class[] { String.class });

					String value23 = oldCplModel.getRequestedReason();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setRequestedStatus",
							new Class[] { Integer.TYPE });

					Integer value24 = new Integer(oldCplModel.getRequestedStatus());

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value25 = oldCplModel.getCreatedAt();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value26 = oldCplModel.getUpdatedAt();

					method26.invoke(newModel, value26);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisWorkingTimesClp.class.getName())) {
			LmisWorkingTimesClp oldCplModel = (LmisWorkingTimesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisWorkingTimesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisWorkingTimeId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisWorkingTimeId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setSessionName",
							new Class[] { String.class });

					String value2 = oldCplModel.getSessionName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setStartTime",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getStartTime();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getEndTime();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setLimitLate",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getLimitLate());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setMaxLate",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getMaxLate());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCoefficientLate",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getCoefficientLate());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setLimitEarly",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getLimitEarly());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setMaxEarly",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getMaxEarly());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setCoefficientEarly",
							new Class[] { Double.TYPE });

					Double value10 = new Double(oldCplModel.getCoefficientEarly());

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisDayTypesClp.class.getName())) {
			LmisDayTypesClp oldCplModel = (LmisDayTypesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisDayTypesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisDayTypeId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisDayTypeId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDayType",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getDayType());

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisWorkingCalendarsClp.class.getName())) {
			LmisWorkingCalendarsClp oldCplModel = (LmisWorkingCalendarsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisWorkingCalendarsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisWorkingCalendarId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisWorkingCalendarId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDayValue",
							new Class[] { Date.class });

					Date value2 = oldCplModel.getDayValue();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDayType",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getDayType());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIsModified",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getIsModified());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setTotalWorkingTime",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getTotalWorkingTime());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setIsRelatedSession",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getIsRelatedSession());

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisWorkingCalendarSessionsClp.class.getName())) {
			LmisWorkingCalendarSessionsClp oldCplModel = (LmisWorkingCalendarSessionsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisWorkingCalendarSessionID",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisWorkingCalendarSessionID();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCalendarId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getCalendarId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setSessionId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getSessionId());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisGeneralSettingsClp.class.getName())) {
			LmisGeneralSettingsClp oldCplModel = (LmisGeneralSettingsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisGeneralSettingsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisGeneralSettingId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisGeneralSettingId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setConfType",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getConfType());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setConfValue",
							new Class[] { Double.TYPE });

					Double value5 = new Double(oldCplModel.getConfValue());

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewStaffMappingClp.class.getName())) {
			LmisViewStaffMappingClp oldCplModel = (LmisViewStaffMappingClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewStaffMappingImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewStaffMappingId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewStaffMappingId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrgId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setBodId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getBodId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setStaffUID",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getStaffUID());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setPmUID",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getPmUID());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setBodUID",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getBodUID());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewStaffRootOrgClp.class.getName())) {
			LmisViewStaffRootOrgClp oldCplModel = (LmisViewStaffRootOrgClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewStaffRootOrgImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUser_id",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getUser_id();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOrgId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setBodId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getBodId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setScreenName",
							new Class[] { String.class });

					String value4 = oldCplModel.getScreenName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setEmailAddress",
							new Class[] { String.class });

					String value5 = oldCplModel.getEmailAddress();

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewStaffRootOrgFNClp.class.getName())) {
			LmisViewStaffRootOrgFNClp oldCplModel = (LmisViewStaffRootOrgFNClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewStaffRootOrgFNImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewStaffRootOrgFNId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewStaffRootOrgFNId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getUserId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getOrgId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setBodId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getBodId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setStaffCode",
							new Class[] { String.class });

					String value5 = oldCplModel.getStaffCode();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setScannerCode",
							new Class[] { String.class });

					String value6 = oldCplModel.getScannerCode();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setScreenName",
							new Class[] { String.class });

					String value7 = oldCplModel.getScreenName();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value8 = oldCplModel.getFullName();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setEmailAddress",
							new Class[] { String.class });

					String value9 = oldCplModel.getEmailAddress();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisViewStaffRootOrgOrderedClp.class.getName())) {
			LmisViewStaffRootOrgOrderedClp oldCplModel = (LmisViewStaffRootOrgOrderedClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewStaffRootOrgOrderedImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewStaffRootOrgOrderedId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewStaffRootOrgOrderedId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getUserId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getOrgId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setBodId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getBodId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setStaffCode",
							new Class[] { String.class });

					String value5 = oldCplModel.getStaffCode();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setScannerCode",
							new Class[] { String.class });

					String value6 = oldCplModel.getScannerCode();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setScreenName",
							new Class[] { String.class });

					String value7 = oldCplModel.getScreenName();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setFirstName",
							new Class[] { String.class });

					String value8 = oldCplModel.getFirstName();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setLastName",
							new Class[] { String.class });

					String value9 = oldCplModel.getLastName();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value10 = oldCplModel.getFullName();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setEmailAddress",
							new Class[] { String.class });

					String value11 = oldCplModel.getEmailAddress();

					method11.invoke(newModel, value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewTimeChangeReqsClp.class.getName())) {
			LmisViewTimeChangeReqsClp oldCplModel = (LmisViewTimeChangeReqsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewTimeChangeReqsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewTimeChangeReqId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewTimeChangeReqId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestedBy",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRequestedBy());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setFirstName",
							new Class[] { String.class });

					String value3 = oldCplModel.getFirstName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setLastName",
							new Class[] { String.class });

					String value4 = oldCplModel.getLastName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value5 = oldCplModel.getFullName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setStartDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getStartDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setEndDate",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getEndDate();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setMonStartTime",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getMonStartTime();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setMonEndTime",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getMonEndTime();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setTueStartTime",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getTueStartTime();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setTueEndTime",
							new Class[] { Date.class });

					Date value11 = oldCplModel.getTueEndTime();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setWedStartTime",
							new Class[] { Date.class });

					Date value12 = oldCplModel.getWedStartTime();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setWedEndTime",
							new Class[] { Date.class });

					Date value13 = oldCplModel.getWedEndTime();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setThuStartTime",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getThuStartTime();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setThuEndTime",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getThuEndTime();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setFriStartTime",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getFriStartTime();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setFriEndTime",
							new Class[] { Date.class });

					Date value17 = oldCplModel.getFriEndTime();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setSatStartTime",
							new Class[] { Date.class });

					Date value18 = oldCplModel.getSatStartTime();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setSatEndTime",
							new Class[] { Date.class });

					Date value19 = oldCplModel.getSatEndTime();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setRequestedReason",
							new Class[] { String.class });

					String value20 = oldCplModel.getRequestedReason();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setRequestedStatus",
							new Class[] { Integer.TYPE });

					Integer value21 = new Integer(oldCplModel.getRequestedStatus());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value22 = oldCplModel.getCreatedAt();

					method22.invoke(newModel, value22);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisViewEmailSettingDetailOrgClp.class.getName())) {
			LmisViewEmailSettingDetailOrgClp oldCplModel = (LmisViewEmailSettingDetailOrgClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewEmailSettingDetailOrgImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgRelatedId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getOrgRelatedId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setId_",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getId_());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCategory",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getCategory());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setToSender",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getToSender());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setToPm",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getToPm());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setToBod",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getToBod());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setEmailType",
							new Class[] { String.class });

					String value8 = oldCplModel.getEmailType();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setEmailOrg",
							new Class[] { String.class });

					String value9 = oldCplModel.getEmailOrg();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisViewEmailSettingDetailUserClp.class.getName())) {
			LmisViewEmailSettingDetailUserClp oldCplModel = (LmisViewEmailSettingDetailUserClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewEmailSettingDetailUserImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUserRelatedId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getUserRelatedId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setId_",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getId_());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCategory",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getCategory());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setToSender",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getToSender());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setToPm",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getToPm());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setToBod",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getToBod());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setEmailType",
							new Class[] { String.class });

					String value8 = oldCplModel.getEmailType();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setEmailUser",
							new Class[] { String.class });

					String value9 = oldCplModel.getEmailUser();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewWorkingCalendarClp.class.getName())) {
			LmisViewWorkingCalendarClp oldCplModel = (LmisViewWorkingCalendarClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewWorkingCalendarImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewWorkingCalendarId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewWorkingCalendarId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDayValue",
							new Class[] { Date.class });

					Date value2 = oldCplModel.getDayValue();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDayType",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getDayType());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setIsModified",
							new Class[] { Boolean.TYPE });

					Boolean value4 = new Boolean(oldCplModel.getIsModified());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setTotalWorkingTime",
							new Class[] { Double.TYPE });

					Double value5 = new Double(oldCplModel.getTotalWorkingTime());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setIsRelatedSession",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getIsRelatedSession());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value7 = oldCplModel.getName();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value8 = oldCplModel.getDescription();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisOverTimeSettingsClp.class.getName())) {
			LmisOverTimeSettingsClp oldCplModel = (LmisOverTimeSettingsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOverTimeSettingsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOverTimeSettingsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOverTimeSettingsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOtId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOtId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDayType",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getDayType());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCoEfficient",
							new Class[] { Double.TYPE });

					Double value4 = new Double(oldCplModel.getCoEfficient());

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisOverTimeTypesClp.class.getName())) {
			LmisOverTimeTypesClp oldCplModel = (LmisOverTimeTypesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOverTimeTypesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOverTimeTypesId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOverTimeTypesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisDataInputsClp.class.getName())) {
			LmisDataInputsClp oldCplModel = (LmisDataInputsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisDataInputsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisDataInputsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisDataInputsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDayValue",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getDayValue();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setStartTime",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getStartTime();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getEndTime();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setInputBy",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getInputBy());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setInputAt",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getInputAt();

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisAttendanceDailyClp.class.getName())) {
			LmisAttendanceDailyClp oldCplModel = (LmisAttendanceDailyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisAttendanceDailyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisAttendanceDailyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisAttendanceDailyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setDayValue",
							new Class[] { Date.class });

					Date value1 = oldCplModel.getDayValue();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setAbsenceValue",
							new Class[] { Double.TYPE });

					Double value4 = new Double(oldCplModel.getAbsenceValue());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIsPermissive",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getIsPermissive());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAbsenceReason",
							new Class[] { String.class });

					String value6 = oldCplModel.getAbsenceReason();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setAbsenceReasonId",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getAbsenceReasonId());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPlanStartTime",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getPlanStartTime();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setRealStartTime",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getRealStartTime();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setTimeLate",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getTimeLate());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setTimeLatePenalty",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getTimeLatePenalty());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setTimeLateFinal",
							new Class[] { Double.TYPE });

					Double value12 = new Double(oldCplModel.getTimeLateFinal());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setPlanEndTime",
							new Class[] { Date.class });

					Date value13 = oldCplModel.getPlanEndTime();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setRealEndTime",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getRealEndTime();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setTimeEarly",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getTimeEarly());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setTimeEarlyPenalty",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getTimeEarlyPenalty());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setTimeEarlyFinal",
							new Class[] { Double.TYPE });

					Double value17 = new Double(oldCplModel.getTimeEarlyFinal());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setOvertimeValue",
							new Class[] { String.class });

					String value18 = oldCplModel.getOvertimeValue();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setTotalWorkingTime",
							new Class[] { Double.TYPE });

					Double value19 = new Double(oldCplModel.getTotalWorkingTime());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setTotalOvertime",
							new Class[] { Double.TYPE });

					Double value20 = new Double(oldCplModel.getTotalOvertime());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setTotalOvertimeFinal",
							new Class[] { Double.TYPE });

					Double value21 = new Double(oldCplModel.getTotalOvertimeFinal());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setTotalTimeFinal",
							new Class[] { Double.TYPE });

					Double value22 = new Double(oldCplModel.getTotalTimeFinal());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setComMent",
							new Class[] { String.class });

					String value23 = oldCplModel.getComMent();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value24 = oldCplModel.getCreatedAt();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value25 = new Integer(oldCplModel.getCreatedBy());

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value26 = oldCplModel.getUpdatedAt();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setUpdated_by",
							new Class[] { Integer.TYPE });

					Integer value27 = new Integer(oldCplModel.getUpdated_by());

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setTotalOvertimeRequested",
							new Class[] { Double.TYPE });

					Double value28 = new Double(oldCplModel.getTotalOvertimeRequested());

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setAbsence_",
							new Class[] { Integer.TYPE });

					Integer value29 = new Integer(oldCplModel.getAbsence_());

					method29.invoke(newModel, value29);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisOvertimeRequestsClp.class.getName())) {
			LmisOvertimeRequestsClp oldCplModel = (LmisOvertimeRequestsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOvertimeRequestsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOvertimeRequestsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOvertimeRequestsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestedBy",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRequestedBy());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRequestedAt",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getRequestedAt();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRequestedReason",
							new Class[] { String.class });

					String value4 = oldCplModel.getRequestedReason();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setRequestedStatus",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getRequestedStatus());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreatedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getUpdatedAt();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getOrgId());

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisOvertimeRequestDetailsClp.class.getName())) {
			LmisOvertimeRequestDetailsClp oldCplModel = (LmisOvertimeRequestDetailsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOvertimeRequestDetailsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOvertimeRequestDetailsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRequestId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setStartTime",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getStartTime();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getEndTime();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setRequestedReason",
							new Class[] { String.class });

					String value6 = oldCplModel.getRequestedReason();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setRequestedHour",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getRequestedHour());

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisOvertimeApprovalsClp.class.getName())) {
			LmisOvertimeApprovalsClp oldCplModel = (LmisOvertimeApprovalsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOvertimeApprovalsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOvertimeApprovalsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOvertimeApprovalsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRequestId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setReportId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getReportId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setApprovedBy",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getApprovedBy());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setApprovedAt",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getApprovedAt();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setIsApproved",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getIsApproved());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setApprovedStatus",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getApprovedStatus());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setReaSon",
							new Class[] { String.class });

					String value8 = oldCplModel.getReaSon();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisOvertimeMonthlyClp.class.getName())) {
			LmisOvertimeMonthlyClp oldCplModel = (LmisOvertimeMonthlyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOvertimeMonthlyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOvertimeMonthlyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOvertimeMonthlyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setMonthValue",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getMonthValue());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setYearValue",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getYearValue());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRootId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setOtType",
							new Class[] { String.class });

					String value5 = oldCplModel.getOtType();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setOtId",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getOtId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setTotalHour",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getTotalHour());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setTotalHourFinal",
							new Class[] { Double.TYPE });

					Double value8 = new Double(oldCplModel.getTotalHourFinal());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getOrgId());

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisDataImportsClp.class.getName())) {
			LmisDataImportsClp oldCplModel = (LmisDataImportsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisDataImportsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisDataImportsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisDataImportsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDateValue",
							new Class[] { Date.class });

					Date value2 = oldCplModel.getDateValue();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setImportType",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getImportType());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setImportBy",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getImportBy());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setImportAt",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getImportAt();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setSessionId",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getSessionId());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisDataImportDetailsClp.class.getName())) {
			LmisDataImportDetailsClp oldCplModel = (LmisDataImportDetailsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisDataImportDetailsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisDataImportDetailsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisDataImportDetailsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setImportId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getImportId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setStartTime",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getStartTime();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getEndTime();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setScannerId",
							new Class[] { String.class });

					String value5 = oldCplModel.getScannerId();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAbSence",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getAbSence());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setStaffName",
							new Class[] { String.class });

					String value7 = oldCplModel.getStaffName();

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisOverTimeReportHoursClp.class.getName())) {
			LmisOverTimeReportHoursClp oldCplModel = (LmisOverTimeReportHoursClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOverTimeReportHoursImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOverTimeReportHoursId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOverTimeReportHoursId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setDetailId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getDetailId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOtType",
							new Class[] { String.class });

					String value2 = oldCplModel.getOtType();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOtHour",
							new Class[] { Double.TYPE });

					Double value3 = new Double(oldCplModel.getOtHour());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setOtCoefficient",
							new Class[] { Double.TYPE });

					Double value4 = new Double(oldCplModel.getOtCoefficient());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setOtId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getOtId());

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisOverTimeReportDetailsClp.class.getName())) {
			LmisOverTimeReportDetailsClp oldCplModel = (LmisOverTimeReportDetailsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOverTimeReportDetailsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOverTimeReportDetailsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOverTimeReportDetailsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setReportId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getReportId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setStartTime",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getStartTime();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getEndTime();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setTotalHour",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getTotalHour());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisOverTimeReportsClp.class.getName())) {
			LmisOverTimeReportsClp oldCplModel = (LmisOverTimeReportsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOverTimeReportsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOverTimeReportsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOverTimeReportsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setReportedBy",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getReportedBy());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setReportedAt",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getReportedAt();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setReportedReason",
							new Class[] { String.class });

					String value4 = oldCplModel.getReportedReason();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setReportedStatus",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getReportedStatus());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreatedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getUpdatedAt();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getRequestId());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getOrgId());

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisOvertimeYearlyClp.class.getName())) {
			LmisOvertimeYearlyClp oldCplModel = (LmisOvertimeYearlyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisOvertimeYearlyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisOvertimeYearlyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisOvertimeYearlyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setYearValue",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getYearValue());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setOtType",
							new Class[] { String.class });

					String value4 = oldCplModel.getOtType();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setOtId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getOtId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setTotalHour",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getTotalHour());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setTotalHourFinal",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getTotalHourFinal());

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisAbsenceYearlyClp.class.getName())) {
			LmisAbsenceYearlyClp oldCplModel = (LmisAbsenceYearlyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisAbsenceYearlyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisAbsenceYearlyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisAbsenceYearlyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setYearValue",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getYearValue());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setAbsenceType",
							new Class[] { String.class });

					String value4 = oldCplModel.getAbsenceType();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setAbsenceTypeId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getAbsenceTypeId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setTotalDay",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getTotalDay());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisAbsenceMonthlyClp.class.getName())) {
			LmisAbsenceMonthlyClp oldCplModel = (LmisAbsenceMonthlyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisAbsenceMonthlyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisAbsenceMonthlyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisAbsenceMonthlyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setMonthValue",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getMonthValue());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setYearValue",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getYearValue());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setAbsenceType",
							new Class[] { String.class });

					String value5 = oldCplModel.getAbsenceType();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAbsenceTypeId",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getAbsenceTypeId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setTotalDay",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getTotalDay());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setTotalDayRequested",
							new Class[] { Double.TYPE });

					Double value8 = new Double(oldCplModel.getTotalDayRequested());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setTotalDayApproved",
							new Class[] { Double.TYPE });

					Double value9 = new Double(oldCplModel.getTotalDayApproved());

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisAbsenceSettingsClp.class.getName())) {
			LmisAbsenceSettingsClp oldCplModel = (LmisAbsenceSettingsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisAbsenceSettingsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisAbsenceSettingsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisAbsenceSettingsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName_",
							new Class[] { String.class });

					String value2 = oldCplModel.getName_();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDesCription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDesCription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setIsSubtract",
							new Class[] { Boolean.TYPE });

					Boolean value4 = new Boolean(oldCplModel.getIsSubtract());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIsModified",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getIsModified());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAbsencePermissive",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getAbsencePermissive());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisAbsenceApprovalsClp.class.getName())) {
			LmisAbsenceApprovalsClp oldCplModel = (LmisAbsenceApprovalsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisAbsenceApprovalsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisAbsenceApprovalsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisAbsenceApprovalsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRequestId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setApprovedBy",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getApprovedBy());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setApprovedAt",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getApprovedAt();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIsApproved",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getIsApproved());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setApprovedStatus",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getApprovedStatus());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setReasonApproval",
							new Class[] { String.class });

					String value7 = oldCplModel.getReasonApproval();

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisAbsenceRequestsClp.class.getName())) {
			LmisAbsenceRequestsClp oldCplModel = (LmisAbsenceRequestsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisAbsenceRequestsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisAbsenceRequestsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisAbsenceRequestsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestedBy",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRequestedBy());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setStartDate",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getStartDate();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setEndDate",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getEndDate();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setStartSession",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getStartSession());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setEndSession",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getEndSession());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setRequestedReason",
							new Class[] { String.class });

					String value7 = oldCplModel.getRequestedReason();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setAbsenceType",
							new Class[] { String.class });

					String value8 = oldCplModel.getAbsenceType();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setAbsenceTypeId",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getAbsenceTypeId());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setRequestedStatus",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getRequestedStatus());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value11 = oldCplModel.getCreatedAt();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value12 = oldCplModel.getUpdatedAt();

					method12.invoke(newModel, value12);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisViewDayTypeOverTimeSettingTypeClp.class.getName())) {
			LmisViewDayTypeOverTimeSettingTypeClp oldCplModel = (LmisViewDayTypeOverTimeSettingTypeClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewDayTypeOverTimeSettingTypeImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewDayTypeOverTimeSettingTypeId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewDayTypeOverTimeSettingTypeId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOtTypeId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOtTypeId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDayType",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getDayType());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setOtId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getOtId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCoefficient",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getCoefficient());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setNameOvertimeType",
							new Class[] { String.class });

					String value7 = oldCplModel.getNameOvertimeType();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value8 = oldCplModel.getDescription();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisViewRegistrationOvertimeClp.class.getName())) {
			LmisViewRegistrationOvertimeClp oldCplModel = (LmisViewRegistrationOvertimeClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewRegistrationOvertimeImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewRegistrationOvertimeId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewRegistrationOvertimeId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOtReqsId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOtReqsId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRequestedBy",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRequestedBy());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRequestedAt",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getRequestedAt();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setRequestedReason",
							new Class[] { String.class });

					String value5 = oldCplModel.getRequestedReason();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setRequestedStatus",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getRequestedStatus());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getCreatedAt();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getUpdatedAt();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getOrgId());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getRequestId());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getUserId());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setStartTime",
							new Class[] { Date.class });

					Date value12 = oldCplModel.getStartTime();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value13 = oldCplModel.getEndTime();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setReasonDetail",
							new Class[] { String.class });

					String value14 = oldCplModel.getReasonDetail();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setRequestedHour",
							new Class[] { Double.TYPE });

					Double value15 = new Double(oldCplModel.getRequestedHour());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setApprovedBy",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getApprovedBy());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setApprovedAt",
							new Class[] { Date.class });

					Date value17 = oldCplModel.getApprovedAt();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setIsApproved",
							new Class[] { Boolean.TYPE });

					Boolean value18 = new Boolean(oldCplModel.getIsApproved());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setApprovedStatus",
							new Class[] { Boolean.TYPE });

					Boolean value19 = new Boolean(oldCplModel.getApprovedStatus());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setReaSon",
							new Class[] { String.class });

					String value20 = oldCplModel.getReaSon();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setOrgName",
							new Class[] { String.class });

					String value21 = oldCplModel.getOrgName();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value22 = oldCplModel.getFullName();

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setFirstName",
							new Class[] { String.class });

					String value23 = oldCplModel.getFirstName();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setMiddleName",
							new Class[] { String.class });

					String value24 = oldCplModel.getMiddleName();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setLastName",
							new Class[] { String.class });

					String value25 = oldCplModel.getLastName();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setReqFirstName",
							new Class[] { String.class });

					String value26 = oldCplModel.getReqFirstName();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setReqMiddleName",
							new Class[] { String.class });

					String value27 = oldCplModel.getReqMiddleName();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setReqLastName",
							new Class[] { String.class });

					String value28 = oldCplModel.getReqLastName();

					method28.invoke(newModel, value28);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisViewRegistrationOvertimeaApprovalClp.class.getName())) {
			LmisViewRegistrationOvertimeaApprovalClp oldCplModel = (LmisViewRegistrationOvertimeaApprovalClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewRegistrationOvertimeaApprovalImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewRegistrationOvertimeaApprovalId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewRegistrationOvertimeaApprovalId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRequestedBy",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRequestedBy());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRequestedAt",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getRequestedAt();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRequestedReason",
							new Class[] { String.class });

					String value4 = oldCplModel.getRequestedReason();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setRequestedStatus",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getRequestedStatus());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreatedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getUpdatedAt();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getOrgId());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value9 = oldCplModel.getName();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value10 = oldCplModel.getFullName();

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewOTAppClp.class.getName())) {
			LmisViewOTAppClp oldCplModel = (LmisViewOTAppClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewOTAppImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewOTAppId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewOTAppId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOrgId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRequestedBy",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRequestedBy());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRequestedAt",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getRequestedAt();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setRequestedReason",
							new Class[] { String.class });

					String value5 = oldCplModel.getRequestedReason();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setRequestedStatus",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getRequestedStatus());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getCreatedAt();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getUpdatedAt();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setApprovedBy",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getApprovedBy());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setApprovedAt",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getApprovedAt();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setIsApproved",
							new Class[] { Boolean.TYPE });

					Boolean value11 = new Boolean(oldCplModel.getIsApproved());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setApprovedStatus",
							new Class[] { Boolean.TYPE });

					Boolean value12 = new Boolean(oldCplModel.getApprovedStatus());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setApprovedReason",
							new Class[] { String.class });

					String value13 = oldCplModel.getApprovedReason();

					method13.invoke(newModel, value13);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewReportOvertimeClp.class.getName())) {
			LmisViewReportOvertimeClp oldCplModel = (LmisViewReportOvertimeClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewReportOvertimeImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewReportOvertimeId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewReportOvertimeId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOtRepId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOtRepId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getOrgId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getRequestId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setReportedBy",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getReportedBy());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setReportedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getReportedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setReportedReason",
							new Class[] { String.class });

					String value7 = oldCplModel.getReportedReason();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setReportedStatus",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getReportedStatus());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getCreatedAt();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getUpdatedAt();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setReportId",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getReportId());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getUserId());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setTotalHour",
							new Class[] { Double.TYPE });

					Double value13 = new Double(oldCplModel.getTotalHour());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setStartTime",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getStartTime();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getEndTime();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setDetailId",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getDetailId());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setOtType",
							new Class[] { String.class });

					String value17 = oldCplModel.getOtType();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setOtHour",
							new Class[] { Double.TYPE });

					Double value18 = new Double(oldCplModel.getOtHour());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setOtCoefficient",
							new Class[] { Double.TYPE });

					Double value19 = new Double(oldCplModel.getOtCoefficient());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setOtId",
							new Class[] { Integer.TYPE });

					Integer value20 = new Integer(oldCplModel.getOtId());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setOrgName",
							new Class[] { String.class });

					String value21 = oldCplModel.getOrgName();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value22 = oldCplModel.getFullName();

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setFirstName",
							new Class[] { String.class });

					String value23 = oldCplModel.getFirstName();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setMiddleName",
							new Class[] { String.class });

					String value24 = oldCplModel.getMiddleName();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setLastName",
							new Class[] { String.class });

					String value25 = oldCplModel.getLastName();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setRepFirstName",
							new Class[] { String.class });

					String value26 = oldCplModel.getRepFirstName();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setRepLastName",
							new Class[] { String.class });

					String value27 = oldCplModel.getRepLastName();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setRepMiddleName",
							new Class[] { String.class });

					String value28 = oldCplModel.getRepMiddleName();

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setRegRequestedHour",
							new Class[] { Double.TYPE });

					Double value29 = new Double(oldCplModel.getRegRequestedHour());

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setRegStartTime",
							new Class[] { Date.class });

					Date value30 = oldCplModel.getRegStartTime();

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setRegEndTime",
							new Class[] { Date.class });

					Date value31 = oldCplModel.getRegEndTime();

					method31.invoke(newModel, value31);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewAttDailyClp.class.getName())) {
			LmisViewAttDailyClp oldCplModel = (LmisViewAttDailyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewAttDailyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewAttDailyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewAttDailyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setDayValue",
							new Class[] { Date.class });

					Date value1 = oldCplModel.getDayValue();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setAbsenceValue",
							new Class[] { Double.TYPE });

					Double value4 = new Double(oldCplModel.getAbsenceValue());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIsPermissive",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getIsPermissive());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getOrgId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setAbsenceType",
							new Class[] { String.class });

					String value7 = oldCplModel.getAbsenceType();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setAbsenceTypeId",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getAbsenceTypeId());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setPlanStartTime",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getPlanStartTime();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setRealStartTime",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getRealStartTime();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setTimeLate",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getTimeLate());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setTimeLatePenalty",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getTimeLatePenalty());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setTimeLateFinal",
							new Class[] { Double.TYPE });

					Double value13 = new Double(oldCplModel.getTimeLateFinal());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setPlanEndTime",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getPlanEndTime();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setRealEndTime",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getRealEndTime();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setTimeEarly",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getTimeEarly());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setTimeEarlyPenalty",
							new Class[] { Integer.TYPE });

					Integer value17 = new Integer(oldCplModel.getTimeEarlyPenalty());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setTimeEarlyFinal",
							new Class[] { Double.TYPE });

					Double value18 = new Double(oldCplModel.getTimeEarlyFinal());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setOverTimeValue",
							new Class[] { String.class });

					String value19 = oldCplModel.getOverTimeValue();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setTotalWorkingTime",
							new Class[] { Double.TYPE });

					Double value20 = new Double(oldCplModel.getTotalWorkingTime());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setTotalOverTime",
							new Class[] { Double.TYPE });

					Double value21 = new Double(oldCplModel.getTotalOverTime());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setTotalOverTimeFinal",
							new Class[] { Double.TYPE });

					Double value22 = new Double(oldCplModel.getTotalOverTimeFinal());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setTotalTimeFinal",
							new Class[] { Double.TYPE });

					Double value23 = new Double(oldCplModel.getTotalTimeFinal());

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value24 = oldCplModel.getCreatedAt();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value25 = new Integer(oldCplModel.getCreatedBy());

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value26 = oldCplModel.getUpdatedAt();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value27 = new Integer(oldCplModel.getUpdatedBy());

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setTotalOverTimeRequested",
							new Class[] { Double.TYPE });

					Double value28 = new Double(oldCplModel.getTotalOverTimeRequested());

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setAbSence",
							new Class[] { Integer.TYPE });

					Integer value29 = new Integer(oldCplModel.getAbSence());

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value30 = oldCplModel.getFullName();

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setStaffCode",
							new Class[] { String.class });

					String value31 = oldCplModel.getStaffCode();

					method31.invoke(newModel, value31);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisViewReportOvertimeApprovalClp.class.getName())) {
			LmisViewReportOvertimeApprovalClp oldCplModel = (LmisViewReportOvertimeApprovalClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewReportOvertimeApprovalImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewReportOvertimeApprovalId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewReportOvertimeApprovalId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOrgId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRequestId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setReportedBy",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getReportedBy());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setReportedAt",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getReportedAt();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setReportedReason",
							new Class[] { String.class });

					String value6 = oldCplModel.getReportedReason();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setReportedStatus",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getReportedStatus());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getCreatedAt();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getUpdatedAt();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setOrgName",
							new Class[] { String.class });

					String value10 = oldCplModel.getOrgName();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value11 = oldCplModel.getFullName();

					method11.invoke(newModel, value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewDayValueMaxClp.class.getName())) {
			LmisViewDayValueMaxClp oldCplModel = (LmisViewDayValueMaxClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewDayValueMaxImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewDayValueMaxId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewDayValueMaxId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setDayValue",
							new Class[] { Date.class });

					Date value1 = oldCplModel.getDayValue();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewOrgUserRolesClp.class.getName())) {
			LmisViewOrgUserRolesClp oldCplModel = (LmisViewOrgUserRolesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewOrgUserRolesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewOrgUserRolesId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewOrgUserRolesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOrgId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRoleId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getRoleId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setOrgName",
							new Class[] { String.class });

					String value5 = oldCplModel.getOrgName();

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewAttInfoClp.class.getName())) {
			LmisViewAttInfoClp oldCplModel = (LmisViewAttInfoClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewAttInfoImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewAttInfoId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewAttInfoId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setStaffUID",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getStaffUID());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setPmUID",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getPmUID());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDayValue",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getDayValue();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getRootId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getUserId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAbsenceValue",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getAbsenceValue());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setIsPermissive",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getIsPermissive());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setAbsenceType",
							new Class[] { String.class });

					String value8 = oldCplModel.getAbsenceType();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setAbsenceTypeId",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getAbsenceTypeId());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setPlanStartTime",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getPlanStartTime();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setRealStartTime",
							new Class[] { Date.class });

					Date value11 = oldCplModel.getRealStartTime();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setTimeLate",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getTimeLate());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setTimeLatePenalty",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getTimeLatePenalty());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setTimeLateFinal",
							new Class[] { Double.TYPE });

					Double value14 = new Double(oldCplModel.getTimeLateFinal());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setPlanEndTime",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getPlanEndTime();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setRealEndTime",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getRealEndTime();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setTimeEarly",
							new Class[] { Integer.TYPE });

					Integer value17 = new Integer(oldCplModel.getTimeEarly());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setTimeEarlyPenalty",
							new Class[] { Integer.TYPE });

					Integer value18 = new Integer(oldCplModel.getTimeEarlyPenalty());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setTimeEarlyFinal",
							new Class[] { Double.TYPE });

					Double value19 = new Double(oldCplModel.getTimeEarlyFinal());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setOverTimeValue",
							new Class[] { String.class });

					String value20 = oldCplModel.getOverTimeValue();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setTotalWorkingTime",
							new Class[] { Double.TYPE });

					Double value21 = new Double(oldCplModel.getTotalWorkingTime());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setTotalOverTime",
							new Class[] { Double.TYPE });

					Double value22 = new Double(oldCplModel.getTotalOverTime());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setTotalOverTimeFinal",
							new Class[] { Double.TYPE });

					Double value23 = new Double(oldCplModel.getTotalOverTimeFinal());

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setTotalTimeFinal",
							new Class[] { Double.TYPE });

					Double value24 = new Double(oldCplModel.getTotalTimeFinal());

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value25 = oldCplModel.getCreatedAt();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value26 = new Integer(oldCplModel.getCreatedBy());

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value27 = oldCplModel.getUpdatedAt();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value28 = new Integer(oldCplModel.getUpdatedBy());

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setTotalOverTimeRequested",
							new Class[] { Double.TYPE });

					Double value29 = new Double(oldCplModel.getTotalOverTimeRequested());

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setAbSence",
							new Class[] { Integer.TYPE });

					Integer value30 = new Integer(oldCplModel.getAbSence());

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value31 = oldCplModel.getFullName();

					method31.invoke(newModel, value31);

					Method method32 = newModelClass.getMethod("setStaffCode",
							new Class[] { String.class });

					String value32 = oldCplModel.getStaffCode();

					method32.invoke(newModel, value32);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewStaffMappingPmClp.class.getName())) {
			LmisViewStaffMappingPmClp oldCplModel = (LmisViewStaffMappingPmClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewStaffMappingPmImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewStaffMappingPmId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewStaffMappingPmId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrgId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setBodId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getBodId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setStaffUID",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getStaffUID());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setPmUID",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getPmUID());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setStaffCode",
							new Class[] { String.class });

					String value6 = oldCplModel.getStaffCode();

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewAttdanceClp.class.getName())) {
			LmisViewAttdanceClp oldCplModel = (LmisViewAttdanceClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewAttdanceImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewAttDailyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewAttDailyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setDayValue",
							new Class[] { Date.class });

					Date value1 = oldCplModel.getDayValue();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setAbsenceValue",
							new Class[] { Double.TYPE });

					Double value4 = new Double(oldCplModel.getAbsenceValue());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIsPermissive",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getIsPermissive());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAbsenceType",
							new Class[] { String.class });

					String value6 = oldCplModel.getAbsenceType();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setAbsenceTypeId",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getAbsenceTypeId());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPlanStartTime",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getPlanStartTime();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setRealStartTime",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getRealStartTime();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setTimeLate",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getTimeLate());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setTimeLatePenalty",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getTimeLatePenalty());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setTimeLateFinal",
							new Class[] { Double.TYPE });

					Double value12 = new Double(oldCplModel.getTimeLateFinal());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setPlanEndTime",
							new Class[] { Date.class });

					Date value13 = oldCplModel.getPlanEndTime();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setRealEndTime",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getRealEndTime();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setTimeEarly",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getTimeEarly());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setTimeEarlyPenalty",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getTimeEarlyPenalty());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setTimeEarlyFinal",
							new Class[] { Double.TYPE });

					Double value17 = new Double(oldCplModel.getTimeEarlyFinal());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setOverTimeValue",
							new Class[] { String.class });

					String value18 = oldCplModel.getOverTimeValue();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setTotalWorkingTime",
							new Class[] { Double.TYPE });

					Double value19 = new Double(oldCplModel.getTotalWorkingTime());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setTotalOverTime",
							new Class[] { Double.TYPE });

					Double value20 = new Double(oldCplModel.getTotalOverTime());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setTotalOverTimeFinal",
							new Class[] { Double.TYPE });

					Double value21 = new Double(oldCplModel.getTotalOverTimeFinal());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setTotalTimeFinal",
							new Class[] { Double.TYPE });

					Double value22 = new Double(oldCplModel.getTotalTimeFinal());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value23 = oldCplModel.getCreatedAt();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value24 = new Integer(oldCplModel.getCreatedBy());

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value25 = oldCplModel.getUpdatedAt();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value26 = new Integer(oldCplModel.getUpdatedBy());

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setTotalOverTimeRequested",
							new Class[] { Double.TYPE });

					Double value27 = new Double(oldCplModel.getTotalOverTimeRequested());

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setAbSence",
							new Class[] { Integer.TYPE });

					Integer value28 = new Integer(oldCplModel.getAbSence());

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value29 = oldCplModel.getFullName();

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setStaffCode",
							new Class[] { String.class });

					String value30 = oldCplModel.getStaffCode();

					method30.invoke(newModel, value30);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisViewOvertimeReportClp.class.getName())) {
			LmisViewOvertimeReportClp oldCplModel = (LmisViewOvertimeReportClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewOvertimeReportImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewOvertimeReportId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewOvertimeReportId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOrgId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRequestId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setReportedBy",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getReportedBy());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setReportedAt",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getReportedAt();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setReportedReason",
							new Class[] { String.class });

					String value6 = oldCplModel.getReportedReason();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setReportedStatus",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getReportedStatus());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getCreatedAt();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getUpdatedAt();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setOrgName",
							new Class[] { String.class });

					String value10 = oldCplModel.getOrgName();

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					LmisViewOvertimeReportDetailClp.class.getName())) {
			LmisViewOvertimeReportDetailClp oldCplModel = (LmisViewOvertimeReportDetailClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisViewOvertimeReportDetailImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisViewReportOvertimeId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisViewReportOvertimeId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOtRepId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOtRepId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getOrgId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRequestId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getRequestId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setReportedBy",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getReportedBy());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setReportedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getReportedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setReportedReason",
							new Class[] { String.class });

					String value7 = oldCplModel.getReportedReason();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setReportedStatus",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getReportedStatus());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getCreatedAt();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getUpdatedAt();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getUserId());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setTotalHour",
							new Class[] { Double.TYPE });

					Double value12 = new Double(oldCplModel.getTotalHour());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setStartTime",
							new Class[] { Date.class });

					Date value13 = oldCplModel.getStartTime();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getEndTime();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setFullName",
							new Class[] { String.class });

					String value15 = oldCplModel.getFullName();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setReqRequestedHour",
							new Class[] { Double.TYPE });

					Double value16 = new Double(oldCplModel.getReqRequestedHour());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setReqStartTime",
							new Class[] { Date.class });

					Date value17 = oldCplModel.getReqStartTime();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setReqEndTime",
							new Class[] { Date.class });

					Date value18 = oldCplModel.getReqEndTime();

					method18.invoke(newModel, value18);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisAttMonthlyClp.class.getName())) {
			LmisAttMonthlyClp oldCplModel = (LmisAttMonthlyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisAttMonthlyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisAttMonthlysId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisAttMonthlysId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setYearValue",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getYearValue());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setMonthValue",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getMonthValue());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRootId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setTotalWorkingDay",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getTotalWorkingDay());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setNumDayAward",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getNumDayAward());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setTotalDayOff",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getTotalDayOff());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setTotalDayCompensation",
							new Class[] { Double.TYPE });

					Double value8 = new Double(oldCplModel.getTotalDayCompensation());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setTotalDayOffCompensation",
							new Class[] { Double.TYPE });

					Double value9 = new Double(oldCplModel.getTotalDayOffCompensation());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setStartTimeAverage",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getStartTimeAverage();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setEndTimeAverage",
							new Class[] { Date.class });

					Date value11 = oldCplModel.getEndTimeAverage();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setTotalTimeLate",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getTotalTimeLate());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setTotalTimeLatePenalty",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getTotalTimeLatePenalty());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setTotalTimeEarly",
							new Class[] { Integer.TYPE });

					Integer value14 = new Integer(oldCplModel.getTotalTimeEarly());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setTotalTimeEarlyPenalty",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getTotalTimeEarlyPenalty());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setTotalDayOvertime",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getTotalDayOvertime());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setTotalTimeLateFinal",
							new Class[] { Double.TYPE });

					Double value17 = new Double(oldCplModel.getTotalTimeLateFinal());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setTotalTimeEarlyFinal",
							new Class[] { Double.TYPE });

					Double value18 = new Double(oldCplModel.getTotalTimeEarlyFinal());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setTotalWorkingTime",
							new Class[] { Double.TYPE });

					Double value19 = new Double(oldCplModel.getTotalWorkingTime());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setTotalOvertime",
							new Class[] { Double.TYPE });

					Double value20 = new Double(oldCplModel.getTotalOvertime());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setTotalOvertimeFinal",
							new Class[] { Double.TYPE });

					Double value21 = new Double(oldCplModel.getTotalOvertimeFinal());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setTotalDayCompensationNextMonth",
							new Class[] { Double.TYPE });

					Double value22 = new Double(oldCplModel.getTotalDayCompensationNextMonth());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setTotalTimeFinal",
							new Class[] { Double.TYPE });

					Double value23 = new Double(oldCplModel.getTotalTimeFinal());

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setTotalOvertimeRequested",
							new Class[] { Double.TYPE });

					Double value24 = new Double(oldCplModel.getTotalOvertimeRequested());

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setTotalDayoffPermissive",
							new Class[] { Double.TYPE });

					Double value25 = new Double(oldCplModel.getTotalDayoffPermissive());

					method25.invoke(newModel, value25);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LmisAttYearlyClp.class.getName())) {
			LmisAttYearlyClp oldCplModel = (LmisAttYearlyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.lmis.model.impl.LmisAttYearlyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLmisAttYearlyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLmisAttYearlyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setYearValue",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getYearValue());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setTotalWorkingDay",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getTotalWorkingDay());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setTotalDayAwardPrevYear",
							new Class[] { Double.TYPE });

					Double value5 = new Double(oldCplModel.getTotalDayAwardPrevYear());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setTotalDayOff",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getTotalDayOff());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setTotalDayAward",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getTotalDayAward());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setTotalDayRemaining",
							new Class[] { Double.TYPE });

					Double value8 = new Double(oldCplModel.getTotalDayRemaining());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setStartTimeAverage",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getStartTimeAverage();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setEndTimeAverage",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getEndTimeAverage();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setTotalTimeLate",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getTotalTimeLate());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setTotalTimeLatePenalty",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getTotalTimeLatePenalty());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setTotalTimeEarly",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getTotalTimeEarly());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setTotalTimeEarlyPenalty",
							new Class[] { Integer.TYPE });

					Integer value14 = new Integer(oldCplModel.getTotalTimeEarlyPenalty());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setTotalDayOvertime",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getTotalDayOvertime());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setTotalTimeLateFinal",
							new Class[] { Double.TYPE });

					Double value16 = new Double(oldCplModel.getTotalTimeLateFinal());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setTotalTimeEarlyFinal",
							new Class[] { Double.TYPE });

					Double value17 = new Double(oldCplModel.getTotalTimeEarlyFinal());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setTotalWorkingTime",
							new Class[] { Double.TYPE });

					Double value18 = new Double(oldCplModel.getTotalWorkingTime());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setTotalOvertime",
							new Class[] { Double.TYPE });

					Double value19 = new Double(oldCplModel.getTotalOvertime());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setTotalOvertimeFinal",
							new Class[] { Double.TYPE });

					Double value20 = new Double(oldCplModel.getTotalOvertimeFinal());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setTotalTimeFinal",
							new Class[] { Double.TYPE });

					Double value21 = new Double(oldCplModel.getTotalTimeFinal());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setTotalOvertimeRequested",
							new Class[] { Double.TYPE });

					Double value22 = new Double(oldCplModel.getTotalOvertimeRequested());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setTotalDayoffPermissive",
							new Class[] { Double.TYPE });

					Double value23 = new Double(oldCplModel.getTotalDayoffPermissive());

					method23.invoke(newModel, value23);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateInput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisEmailSettingsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisEmailSettingsClp newModel = new LmisEmailSettingsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisEmailSettingId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisEmailSettingId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getEmailName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setEmailName(value2);

					Method method3 = oldModelClass.getMethod(
							"getEmailDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setEmailDescription(value3);

					Method method4 = oldModelClass.getMethod("getEmailTemplate");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setEmailTemplate(value4);

					Method method5 = oldModelClass.getMethod("getEmailType");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setEmailType(value5);

					Method method6 = oldModelClass.getMethod("getCategory");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setCategory(value6.intValue());

					Method method7 = oldModelClass.getMethod("getToSender");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setToSender(value7.booleanValue());

					Method method8 = oldModelClass.getMethod("getToPm");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setToPm(value8.booleanValue());

					Method method9 = oldModelClass.getMethod("getToBod");

					Boolean value9 = (Boolean)method9.invoke(oldModel,
							(Object[])null);

					newModel.setToBod(value9.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisEmailSettingDetailsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisEmailSettingDetailsClp newModel = new LmisEmailSettingDetailsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisEmailSettingDetailId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisEmailSettingDetailId(value0);

					Method method1 = oldModelClass.getMethod(
							"getEmailSettingId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setEmailSettingId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOrgRelatedId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgRelatedId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserRelatedId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserRelatedId(value3.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisTimeChangeApprovalsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisTimeChangeApprovalsClp newModel = new LmisTimeChangeApprovalsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisTimeChangeApprovalId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisTimeChangeApprovalId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRequestId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getApprovedBy");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedBy(value3.intValue());

					Method method4 = oldModelClass.getMethod("getApprovedAt");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setApprovedAt(value4);

					Method method5 = oldModelClass.getMethod("getIsApproved");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIsApproved(value5.booleanValue());

					Method method6 = oldModelClass.getMethod(
							"getApprovedStatus");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedStatus(value6.booleanValue());

					Method method7 = oldModelClass.getMethod("getReason");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setReason(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisTimeChangeRequestsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisTimeChangeRequestsClp newModel = new LmisTimeChangeRequestsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisTimeChangeRequestId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisTimeChangeRequestId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRequestedBy");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedBy(value2.intValue());

					Method method3 = oldModelClass.getMethod("getStartDate");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setStartDate(value3);

					Method method4 = oldModelClass.getMethod("getEndDate");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setEndDate(value4);

					Method method5 = oldModelClass.getMethod("getMonSelected");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setMonSelected(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getMonStartTime");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setMonStartTime(value6);

					Method method7 = oldModelClass.getMethod("getMonEndTime");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setMonEndTime(value7);

					Method method8 = oldModelClass.getMethod("getTueSelected");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setTueSelected(value8.booleanValue());

					Method method9 = oldModelClass.getMethod("getTueStartTime");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setTueStartTime(value9);

					Method method10 = oldModelClass.getMethod("getTueEndTime");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setTueEndTime(value10);

					Method method11 = oldModelClass.getMethod("getWedSelected");

					Boolean value11 = (Boolean)method11.invoke(oldModel,
							(Object[])null);

					newModel.setWedSelected(value11.booleanValue());

					Method method12 = oldModelClass.getMethod("getWedStartTime");

					Date value12 = (Date)method12.invoke(oldModel,
							(Object[])null);

					newModel.setWedStartTime(value12);

					Method method13 = oldModelClass.getMethod("getWedEndTime");

					Date value13 = (Date)method13.invoke(oldModel,
							(Object[])null);

					newModel.setWedEndTime(value13);

					Method method14 = oldModelClass.getMethod("getThuSelected");

					Boolean value14 = (Boolean)method14.invoke(oldModel,
							(Object[])null);

					newModel.setThuSelected(value14.booleanValue());

					Method method15 = oldModelClass.getMethod("getThuStartTime");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setThuStartTime(value15);

					Method method16 = oldModelClass.getMethod("getThuEndTime");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setThuEndTime(value16);

					Method method17 = oldModelClass.getMethod("getFriSelected");

					Boolean value17 = (Boolean)method17.invoke(oldModel,
							(Object[])null);

					newModel.setFriSelected(value17.booleanValue());

					Method method18 = oldModelClass.getMethod("getFriStartTime");

					Date value18 = (Date)method18.invoke(oldModel,
							(Object[])null);

					newModel.setFriStartTime(value18);

					Method method19 = oldModelClass.getMethod("getFriEndTime");

					Date value19 = (Date)method19.invoke(oldModel,
							(Object[])null);

					newModel.setFriEndTime(value19);

					Method method20 = oldModelClass.getMethod("getSatSelected");

					Boolean value20 = (Boolean)method20.invoke(oldModel,
							(Object[])null);

					newModel.setSatSelected(value20.booleanValue());

					Method method21 = oldModelClass.getMethod("getSatStartTime");

					Date value21 = (Date)method21.invoke(oldModel,
							(Object[])null);

					newModel.setSatStartTime(value21);

					Method method22 = oldModelClass.getMethod("getSatEndTime");

					Date value22 = (Date)method22.invoke(oldModel,
							(Object[])null);

					newModel.setSatEndTime(value22);

					Method method23 = oldModelClass.getMethod(
							"getRequestedReason");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedReason(value23);

					Method method24 = oldModelClass.getMethod(
							"getRequestedStatus");

					Integer value24 = (Integer)method24.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedStatus(value24.intValue());

					Method method25 = oldModelClass.getMethod("getCreatedAt");

					Date value25 = (Date)method25.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value25);

					Method method26 = oldModelClass.getMethod("getUpdatedAt");

					Date value26 = (Date)method26.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value26);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisWorkingTimesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisWorkingTimesClp newModel = new LmisWorkingTimesClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisWorkingTimeId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisWorkingTimeId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getSessionName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setSessionName(value2);

					Method method3 = oldModelClass.getMethod("getStartTime");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setStartTime(value3);

					Method method4 = oldModelClass.getMethod("getEndTime");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setEndTime(value4);

					Method method5 = oldModelClass.getMethod("getLimitLate");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setLimitLate(value5.intValue());

					Method method6 = oldModelClass.getMethod("getMaxLate");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setMaxLate(value6.intValue());

					Method method7 = oldModelClass.getMethod(
							"getCoefficientLate");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setCoefficientLate(value7.doubleValue());

					Method method8 = oldModelClass.getMethod("getLimitEarly");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setLimitEarly(value8.intValue());

					Method method9 = oldModelClass.getMethod("getMaxEarly");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setMaxEarly(value9.intValue());

					Method method10 = oldModelClass.getMethod(
							"getCoefficientEarly");

					Double value10 = (Double)method10.invoke(oldModel,
							(Object[])null);

					newModel.setCoefficientEarly(value10.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisDayTypesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisDayTypesClp newModel = new LmisDayTypesClp();

					Method method0 = oldModelClass.getMethod("getLmisDayTypeId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisDayTypeId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getDayType");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDayType(value4.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisWorkingCalendarsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisWorkingCalendarsClp newModel = new LmisWorkingCalendarsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisWorkingCalendarId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisWorkingCalendarId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getDayValue");

					Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

					newModel.setDayValue(value2);

					Method method3 = oldModelClass.getMethod("getDayType");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDayType(value3.intValue());

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					Method method5 = oldModelClass.getMethod("getIsModified");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIsModified(value5.booleanValue());

					Method method6 = oldModelClass.getMethod(
							"getTotalWorkingTime");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingTime(value6.doubleValue());

					Method method7 = oldModelClass.getMethod(
							"getIsRelatedSession");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setIsRelatedSession(value7.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisWorkingCalendarSessionsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisWorkingCalendarSessionsClp newModel = new LmisWorkingCalendarSessionsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisWorkingCalendarSessionID");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisWorkingCalendarSessionID(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getCalendarId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setCalendarId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getSessionId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setSessionId(value3.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisGeneralSettingsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisGeneralSettingsClp newModel = new LmisGeneralSettingsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisGeneralSettingId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisGeneralSettingId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getConfType");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setConfType(value4.intValue());

					Method method5 = oldModelClass.getMethod("getConfValue");

					Double value5 = (Double)method5.invoke(oldModel,
							(Object[])null);

					newModel.setConfValue(value5.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewStaffMappingImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewStaffMappingClp newModel = new LmisViewStaffMappingClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewStaffMappingId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewStaffMappingId(value0);

					Method method1 = oldModelClass.getMethod("getOrgId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getBodId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setBodId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getStaffUID");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setStaffUID(value4.intValue());

					Method method5 = oldModelClass.getMethod("getPmUID");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setPmUID(value5.intValue());

					Method method6 = oldModelClass.getMethod("getBodUID");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setBodUID(value6.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewStaffRootOrgImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewStaffRootOrgClp newModel = new LmisViewStaffRootOrgClp();

					Method method0 = oldModelClass.getMethod("getUser_id");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setUser_id(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOrgId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getBodId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setBodId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getScreenName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setScreenName(value4);

					Method method5 = oldModelClass.getMethod("getEmailAddress");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setEmailAddress(value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewStaffRootOrgFNImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewStaffRootOrgFNClp newModel = new LmisViewStaffRootOrgFNClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewStaffRootOrgFNId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewStaffRootOrgFNId(value0);

					Method method1 = oldModelClass.getMethod("getUserId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getOrgId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getBodId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setBodId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getStaffCode");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setStaffCode(value5);

					Method method6 = oldModelClass.getMethod("getScannerCode");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setScannerCode(value6);

					Method method7 = oldModelClass.getMethod("getScreenName");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setScreenName(value7);

					Method method8 = oldModelClass.getMethod("getFullName");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value8);

					Method method9 = oldModelClass.getMethod("getEmailAddress");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setEmailAddress(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewStaffRootOrgOrderedImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewStaffRootOrgOrderedClp newModel = new LmisViewStaffRootOrgOrderedClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewStaffRootOrgOrderedId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewStaffRootOrgOrderedId(value0);

					Method method1 = oldModelClass.getMethod("getUserId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getOrgId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getBodId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setBodId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getStaffCode");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setStaffCode(value5);

					Method method6 = oldModelClass.getMethod("getScannerCode");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setScannerCode(value6);

					Method method7 = oldModelClass.getMethod("getScreenName");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setScreenName(value7);

					Method method8 = oldModelClass.getMethod("getFirstName");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setFirstName(value8);

					Method method9 = oldModelClass.getMethod("getLastName");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setLastName(value9);

					Method method10 = oldModelClass.getMethod("getFullName");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value10);

					Method method11 = oldModelClass.getMethod("getEmailAddress");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setEmailAddress(value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewTimeChangeReqsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewTimeChangeReqsClp newModel = new LmisViewTimeChangeReqsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewTimeChangeReqId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewTimeChangeReqId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRequestedBy");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedBy(value2.intValue());

					Method method3 = oldModelClass.getMethod("getFirstName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setFirstName(value3);

					Method method4 = oldModelClass.getMethod("getLastName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setLastName(value4);

					Method method5 = oldModelClass.getMethod("getFullName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value5);

					Method method6 = oldModelClass.getMethod("getStartDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setStartDate(value6);

					Method method7 = oldModelClass.getMethod("getEndDate");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setEndDate(value7);

					Method method8 = oldModelClass.getMethod("getMonStartTime");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setMonStartTime(value8);

					Method method9 = oldModelClass.getMethod("getMonEndTime");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setMonEndTime(value9);

					Method method10 = oldModelClass.getMethod("getTueStartTime");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setTueStartTime(value10);

					Method method11 = oldModelClass.getMethod("getTueEndTime");

					Date value11 = (Date)method11.invoke(oldModel,
							(Object[])null);

					newModel.setTueEndTime(value11);

					Method method12 = oldModelClass.getMethod("getWedStartTime");

					Date value12 = (Date)method12.invoke(oldModel,
							(Object[])null);

					newModel.setWedStartTime(value12);

					Method method13 = oldModelClass.getMethod("getWedEndTime");

					Date value13 = (Date)method13.invoke(oldModel,
							(Object[])null);

					newModel.setWedEndTime(value13);

					Method method14 = oldModelClass.getMethod("getThuStartTime");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setThuStartTime(value14);

					Method method15 = oldModelClass.getMethod("getThuEndTime");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setThuEndTime(value15);

					Method method16 = oldModelClass.getMethod("getFriStartTime");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setFriStartTime(value16);

					Method method17 = oldModelClass.getMethod("getFriEndTime");

					Date value17 = (Date)method17.invoke(oldModel,
							(Object[])null);

					newModel.setFriEndTime(value17);

					Method method18 = oldModelClass.getMethod("getSatStartTime");

					Date value18 = (Date)method18.invoke(oldModel,
							(Object[])null);

					newModel.setSatStartTime(value18);

					Method method19 = oldModelClass.getMethod("getSatEndTime");

					Date value19 = (Date)method19.invoke(oldModel,
							(Object[])null);

					newModel.setSatEndTime(value19);

					Method method20 = oldModelClass.getMethod(
							"getRequestedReason");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedReason(value20);

					Method method21 = oldModelClass.getMethod(
							"getRequestedStatus");

					Integer value21 = (Integer)method21.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedStatus(value21.intValue());

					Method method22 = oldModelClass.getMethod("getCreatedAt");

					Date value22 = (Date)method22.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value22);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewEmailSettingDetailOrgImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewEmailSettingDetailOrgClp newModel = new LmisViewEmailSettingDetailOrgClp();

					Method method0 = oldModelClass.getMethod("getOrgRelatedId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgRelatedId(value0);

					Method method1 = oldModelClass.getMethod("getId_");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setId_(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getCategory");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setCategory(value4.intValue());

					Method method5 = oldModelClass.getMethod("getToSender");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setToSender(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getToPm");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setToPm(value6.booleanValue());

					Method method7 = oldModelClass.getMethod("getToBod");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setToBod(value7.booleanValue());

					Method method8 = oldModelClass.getMethod("getEmailType");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setEmailType(value8);

					Method method9 = oldModelClass.getMethod("getEmailOrg");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setEmailOrg(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewEmailSettingDetailUserImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewEmailSettingDetailUserClp newModel = new LmisViewEmailSettingDetailUserClp();

					Method method0 = oldModelClass.getMethod("getUserRelatedId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setUserRelatedId(value0);

					Method method1 = oldModelClass.getMethod("getId_");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setId_(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getCategory");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setCategory(value4.intValue());

					Method method5 = oldModelClass.getMethod("getToSender");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setToSender(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getToPm");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setToPm(value6.booleanValue());

					Method method7 = oldModelClass.getMethod("getToBod");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setToBod(value7.booleanValue());

					Method method8 = oldModelClass.getMethod("getEmailType");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setEmailType(value8);

					Method method9 = oldModelClass.getMethod("getEmailUser");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setEmailUser(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewWorkingCalendarImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewWorkingCalendarClp newModel = new LmisViewWorkingCalendarClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewWorkingCalendarId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewWorkingCalendarId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getDayValue");

					Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

					newModel.setDayValue(value2);

					Method method3 = oldModelClass.getMethod("getDayType");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDayType(value3.intValue());

					Method method4 = oldModelClass.getMethod("getIsModified");

					Boolean value4 = (Boolean)method4.invoke(oldModel,
							(Object[])null);

					newModel.setIsModified(value4.booleanValue());

					Method method5 = oldModelClass.getMethod(
							"getTotalWorkingTime");

					Double value5 = (Double)method5.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingTime(value5.doubleValue());

					Method method6 = oldModelClass.getMethod(
							"getIsRelatedSession");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setIsRelatedSession(value6.booleanValue());

					Method method7 = oldModelClass.getMethod("getName");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setName(value7);

					Method method8 = oldModelClass.getMethod("getDescription");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOverTimeSettingsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOverTimeSettingsClp newModel = new LmisOverTimeSettingsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOverTimeSettingsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOverTimeSettingsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOtId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOtId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getDayType");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDayType(value3.intValue());

					Method method4 = oldModelClass.getMethod("getCoEfficient");

					Double value4 = (Double)method4.invoke(oldModel,
							(Object[])null);

					newModel.setCoEfficient(value4.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOverTimeTypesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOverTimeTypesClp newModel = new LmisOverTimeTypesClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOverTimeTypesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOverTimeTypesId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisDataInputsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisDataInputsClp newModel = new LmisDataInputsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisDataInputsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisDataInputsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getUserId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getDayValue");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setDayValue(value3);

					Method method4 = oldModelClass.getMethod("getStartTime");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setStartTime(value4);

					Method method5 = oldModelClass.getMethod("getEndTime");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setEndTime(value5);

					Method method6 = oldModelClass.getMethod("getInputBy");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setInputBy(value6.intValue());

					Method method7 = oldModelClass.getMethod("getInputAt");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setInputAt(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisAttendanceDailyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisAttendanceDailyClp newModel = new LmisAttendanceDailyClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisAttendanceDailyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisAttendanceDailyId(value0);

					Method method1 = oldModelClass.getMethod("getDayValue");

					Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

					newModel.setDayValue(value1);

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getAbsenceValue");

					Double value4 = (Double)method4.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceValue(value4.doubleValue());

					Method method5 = oldModelClass.getMethod("getIsPermissive");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIsPermissive(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getAbsenceReason");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceReason(value6);

					Method method7 = oldModelClass.getMethod(
							"getAbsenceReasonId");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceReasonId(value7.intValue());

					Method method8 = oldModelClass.getMethod("getPlanStartTime");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setPlanStartTime(value8);

					Method method9 = oldModelClass.getMethod("getRealStartTime");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setRealStartTime(value9);

					Method method10 = oldModelClass.getMethod("getTimeLate");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLate(value10.intValue());

					Method method11 = oldModelClass.getMethod(
							"getTimeLatePenalty");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLatePenalty(value11.intValue());

					Method method12 = oldModelClass.getMethod(
							"getTimeLateFinal");

					Double value12 = (Double)method12.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLateFinal(value12.doubleValue());

					Method method13 = oldModelClass.getMethod("getPlanEndTime");

					Date value13 = (Date)method13.invoke(oldModel,
							(Object[])null);

					newModel.setPlanEndTime(value13);

					Method method14 = oldModelClass.getMethod("getRealEndTime");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setRealEndTime(value14);

					Method method15 = oldModelClass.getMethod("getTimeEarly");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarly(value15.intValue());

					Method method16 = oldModelClass.getMethod(
							"getTimeEarlyPenalty");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarlyPenalty(value16.intValue());

					Method method17 = oldModelClass.getMethod(
							"getTimeEarlyFinal");

					Double value17 = (Double)method17.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarlyFinal(value17.doubleValue());

					Method method18 = oldModelClass.getMethod(
							"getOvertimeValue");

					String value18 = (String)method18.invoke(oldModel,
							(Object[])null);

					newModel.setOvertimeValue(value18);

					Method method19 = oldModelClass.getMethod(
							"getTotalWorkingTime");

					Double value19 = (Double)method19.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingTime(value19.doubleValue());

					Method method20 = oldModelClass.getMethod(
							"getTotalOvertime");

					Double value20 = (Double)method20.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOvertime(value20.doubleValue());

					Method method21 = oldModelClass.getMethod(
							"getTotalOvertimeFinal");

					Double value21 = (Double)method21.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOvertimeFinal(value21.doubleValue());

					Method method22 = oldModelClass.getMethod(
							"getTotalTimeFinal");

					Double value22 = (Double)method22.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeFinal(value22.doubleValue());

					Method method23 = oldModelClass.getMethod("getComMent");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setComMent(value23);

					Method method24 = oldModelClass.getMethod("getCreatedAt");

					Date value24 = (Date)method24.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value24);

					Method method25 = oldModelClass.getMethod("getCreatedBy");

					Integer value25 = (Integer)method25.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value25.intValue());

					Method method26 = oldModelClass.getMethod("getUpdatedAt");

					Date value26 = (Date)method26.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value26);

					Method method27 = oldModelClass.getMethod("getUpdated_by");

					Integer value27 = (Integer)method27.invoke(oldModel,
							(Object[])null);

					newModel.setUpdated_by(value27.intValue());

					Method method28 = oldModelClass.getMethod(
							"getTotalOvertimeRequested");

					Double value28 = (Double)method28.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOvertimeRequested(value28.doubleValue());

					Method method29 = oldModelClass.getMethod("getAbsence_");

					Integer value29 = (Integer)method29.invoke(oldModel,
							(Object[])null);

					newModel.setAbsence_(value29.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOvertimeRequestsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOvertimeRequestsClp newModel = new LmisOvertimeRequestsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOvertimeRequestsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOvertimeRequestsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRequestedBy");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedBy(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRequestedAt");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setRequestedAt(value3);

					Method method4 = oldModelClass.getMethod(
							"getRequestedReason");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedReason(value4);

					Method method5 = oldModelClass.getMethod(
							"getRequestedStatus");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedStatus(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCreatedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value6);

					Method method7 = oldModelClass.getMethod("getUpdatedAt");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value7);

					Method method8 = oldModelClass.getMethod("getOrgId");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value8.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOvertimeRequestDetailsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOvertimeRequestDetailsClp newModel = new LmisOvertimeRequestDetailsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOvertimeRequestDetailsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOvertimeRequestDetailsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRequestId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getStartTime");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setStartTime(value4);

					Method method5 = oldModelClass.getMethod("getEndTime");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setEndTime(value5);

					Method method6 = oldModelClass.getMethod(
							"getRequestedReason");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedReason(value6);

					Method method7 = oldModelClass.getMethod("getRequestedHour");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedHour(value7.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOvertimeApprovalsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOvertimeApprovalsClp newModel = new LmisOvertimeApprovalsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOvertimeApprovalsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOvertimeApprovalsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRequestId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getReportId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setReportId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getApprovedBy");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedBy(value4.intValue());

					Method method5 = oldModelClass.getMethod("getApprovedAt");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setApprovedAt(value5);

					Method method6 = oldModelClass.getMethod("getIsApproved");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setIsApproved(value6.booleanValue());

					Method method7 = oldModelClass.getMethod(
							"getApprovedStatus");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedStatus(value7.booleanValue());

					Method method8 = oldModelClass.getMethod("getReaSon");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setReaSon(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOvertimeMonthlyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOvertimeMonthlyClp newModel = new LmisOvertimeMonthlyClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOvertimeMonthlyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOvertimeMonthlyId(value0);

					Method method1 = oldModelClass.getMethod("getMonthValue");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setMonthValue(value1.intValue());

					Method method2 = oldModelClass.getMethod("getYearValue");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setYearValue(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRootId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getOtType");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setOtType(value5);

					Method method6 = oldModelClass.getMethod("getOtId");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setOtId(value6.intValue());

					Method method7 = oldModelClass.getMethod("getTotalHour");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setTotalHour(value7.doubleValue());

					Method method8 = oldModelClass.getMethod(
							"getTotalHourFinal");

					Double value8 = (Double)method8.invoke(oldModel,
							(Object[])null);

					newModel.setTotalHourFinal(value8.doubleValue());

					Method method9 = oldModelClass.getMethod("getOrgId");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value9.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisDataImportsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisDataImportsClp newModel = new LmisDataImportsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisDataImportsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisDataImportsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getDateValue");

					Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

					newModel.setDateValue(value2);

					Method method3 = oldModelClass.getMethod("getImportType");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setImportType(value3.intValue());

					Method method4 = oldModelClass.getMethod("getImportBy");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setImportBy(value4.intValue());

					Method method5 = oldModelClass.getMethod("getImportAt");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setImportAt(value5);

					Method method6 = oldModelClass.getMethod("getSessionId");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setSessionId(value6.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisDataImportDetailsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisDataImportDetailsClp newModel = new LmisDataImportDetailsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisDataImportDetailsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisDataImportDetailsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getImportId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setImportId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getStartTime");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setStartTime(value3);

					Method method4 = oldModelClass.getMethod("getEndTime");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setEndTime(value4);

					Method method5 = oldModelClass.getMethod("getScannerId");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setScannerId(value5);

					Method method6 = oldModelClass.getMethod("getAbSence");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAbSence(value6.intValue());

					Method method7 = oldModelClass.getMethod("getStaffName");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setStaffName(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOverTimeReportHoursImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOverTimeReportHoursClp newModel = new LmisOverTimeReportHoursClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOverTimeReportHoursId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOverTimeReportHoursId(value0);

					Method method1 = oldModelClass.getMethod("getDetailId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setDetailId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOtType");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOtType(value2);

					Method method3 = oldModelClass.getMethod("getOtHour");

					Double value3 = (Double)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOtHour(value3.doubleValue());

					Method method4 = oldModelClass.getMethod("getOtCoefficient");

					Double value4 = (Double)method4.invoke(oldModel,
							(Object[])null);

					newModel.setOtCoefficient(value4.doubleValue());

					Method method5 = oldModelClass.getMethod("getOtId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setOtId(value5.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOverTimeReportDetailsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOverTimeReportDetailsClp newModel = new LmisOverTimeReportDetailsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOverTimeReportDetailsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOverTimeReportDetailsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getReportId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setReportId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getStartTime");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setStartTime(value4);

					Method method5 = oldModelClass.getMethod("getEndTime");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setEndTime(value5);

					Method method6 = oldModelClass.getMethod("getTotalHour");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setTotalHour(value6.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOverTimeReportsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOverTimeReportsClp newModel = new LmisOverTimeReportsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOverTimeReportsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOverTimeReportsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getReportedBy");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setReportedBy(value2.intValue());

					Method method3 = oldModelClass.getMethod("getReportedAt");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setReportedAt(value3);

					Method method4 = oldModelClass.getMethod(
							"getReportedReason");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setReportedReason(value4);

					Method method5 = oldModelClass.getMethod(
							"getReportedStatus");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setReportedStatus(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCreatedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value6);

					Method method7 = oldModelClass.getMethod("getUpdatedAt");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value7);

					Method method8 = oldModelClass.getMethod("getRequestId");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value8.intValue());

					Method method9 = oldModelClass.getMethod("getOrgId");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value9.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisOvertimeYearlyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisOvertimeYearlyClp newModel = new LmisOvertimeYearlyClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisOvertimeYearlyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisOvertimeYearlyId(value0);

					Method method1 = oldModelClass.getMethod("getYearValue");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setYearValue(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getOtType");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setOtType(value4);

					Method method5 = oldModelClass.getMethod("getOtId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setOtId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getTotalHour");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setTotalHour(value6.doubleValue());

					Method method7 = oldModelClass.getMethod(
							"getTotalHourFinal");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setTotalHourFinal(value7.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisAbsenceYearlyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisAbsenceYearlyClp newModel = new LmisAbsenceYearlyClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisAbsenceYearlyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisAbsenceYearlyId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getYearValue");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setYearValue(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getAbsenceType");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceType(value4);

					Method method5 = oldModelClass.getMethod("getAbsenceTypeId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceTypeId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getTotalDay");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDay(value6.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisAbsenceMonthlyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisAbsenceMonthlyClp newModel = new LmisAbsenceMonthlyClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisAbsenceMonthlyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisAbsenceMonthlyId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getMonthValue");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setMonthValue(value2.intValue());

					Method method3 = oldModelClass.getMethod("getYearValue");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setYearValue(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getAbsenceType");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceType(value5);

					Method method6 = oldModelClass.getMethod("getAbsenceTypeId");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceTypeId(value6.intValue());

					Method method7 = oldModelClass.getMethod("getTotalDay");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDay(value7.doubleValue());

					Method method8 = oldModelClass.getMethod(
							"getTotalDayRequested");

					Double value8 = (Double)method8.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayRequested(value8.doubleValue());

					Method method9 = oldModelClass.getMethod(
							"getTotalDayApproved");

					Double value9 = (Double)method9.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayApproved(value9.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisAbsenceSettingsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisAbsenceSettingsClp newModel = new LmisAbsenceSettingsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisAbsenceSettingsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisAbsenceSettingsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName_");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName_(value2);

					Method method3 = oldModelClass.getMethod("getDesCription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDesCription(value3);

					Method method4 = oldModelClass.getMethod("getIsSubtract");

					Boolean value4 = (Boolean)method4.invoke(oldModel,
							(Object[])null);

					newModel.setIsSubtract(value4.booleanValue());

					Method method5 = oldModelClass.getMethod("getIsModified");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIsModified(value5.booleanValue());

					Method method6 = oldModelClass.getMethod(
							"getAbsencePermissive");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAbsencePermissive(value6.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisAbsenceApprovalsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisAbsenceApprovalsClp newModel = new LmisAbsenceApprovalsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisAbsenceApprovalsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisAbsenceApprovalsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRequestId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getApprovedBy");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedBy(value3.intValue());

					Method method4 = oldModelClass.getMethod("getApprovedAt");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setApprovedAt(value4);

					Method method5 = oldModelClass.getMethod("getIsApproved");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIsApproved(value5.booleanValue());

					Method method6 = oldModelClass.getMethod(
							"getApprovedStatus");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedStatus(value6.booleanValue());

					Method method7 = oldModelClass.getMethod(
							"getReasonApproval");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setReasonApproval(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisAbsenceRequestsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisAbsenceRequestsClp newModel = new LmisAbsenceRequestsClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisAbsenceRequestsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisAbsenceRequestsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRequestedBy");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedBy(value2.intValue());

					Method method3 = oldModelClass.getMethod("getStartDate");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setStartDate(value3);

					Method method4 = oldModelClass.getMethod("getEndDate");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setEndDate(value4);

					Method method5 = oldModelClass.getMethod("getStartSession");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setStartSession(value5.intValue());

					Method method6 = oldModelClass.getMethod("getEndSession");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setEndSession(value6.intValue());

					Method method7 = oldModelClass.getMethod(
							"getRequestedReason");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedReason(value7);

					Method method8 = oldModelClass.getMethod("getAbsenceType");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceType(value8);

					Method method9 = oldModelClass.getMethod("getAbsenceTypeId");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceTypeId(value9.intValue());

					Method method10 = oldModelClass.getMethod(
							"getRequestedStatus");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedStatus(value10.intValue());

					Method method11 = oldModelClass.getMethod("getCreatedAt");

					Date value11 = (Date)method11.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value11);

					Method method12 = oldModelClass.getMethod("getUpdatedAt");

					Date value12 = (Date)method12.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value12);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewDayTypeOverTimeSettingTypeImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewDayTypeOverTimeSettingTypeClp newModel = new LmisViewDayTypeOverTimeSettingTypeClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewDayTypeOverTimeSettingTypeId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewDayTypeOverTimeSettingTypeId(value0);

					Method method1 = oldModelClass.getMethod("getOtTypeId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOtTypeId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getDayType");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDayType(value4.intValue());

					Method method5 = oldModelClass.getMethod("getOtId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setOtId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCoefficient");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setCoefficient(value6.doubleValue());

					Method method7 = oldModelClass.getMethod(
							"getNameOvertimeType");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setNameOvertimeType(value7);

					Method method8 = oldModelClass.getMethod("getDescription");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewRegistrationOvertimeImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewRegistrationOvertimeClp newModel = new LmisViewRegistrationOvertimeClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewRegistrationOvertimeId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewRegistrationOvertimeId(value0);

					Method method1 = oldModelClass.getMethod("getOtReqsId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOtReqsId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRequestedBy");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedBy(value3.intValue());

					Method method4 = oldModelClass.getMethod("getRequestedAt");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setRequestedAt(value4);

					Method method5 = oldModelClass.getMethod(
							"getRequestedReason");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedReason(value5);

					Method method6 = oldModelClass.getMethod(
							"getRequestedStatus");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedStatus(value6.intValue());

					Method method7 = oldModelClass.getMethod("getCreatedAt");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value7);

					Method method8 = oldModelClass.getMethod("getUpdatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value8);

					Method method9 = oldModelClass.getMethod("getOrgId");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value9.intValue());

					Method method10 = oldModelClass.getMethod("getRequestId");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value10.intValue());

					Method method11 = oldModelClass.getMethod("getUserId");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value11.intValue());

					Method method12 = oldModelClass.getMethod("getStartTime");

					Date value12 = (Date)method12.invoke(oldModel,
							(Object[])null);

					newModel.setStartTime(value12);

					Method method13 = oldModelClass.getMethod("getEndTime");

					Date value13 = (Date)method13.invoke(oldModel,
							(Object[])null);

					newModel.setEndTime(value13);

					Method method14 = oldModelClass.getMethod("getReasonDetail");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setReasonDetail(value14);

					Method method15 = oldModelClass.getMethod(
							"getRequestedHour");

					Double value15 = (Double)method15.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedHour(value15.doubleValue());

					Method method16 = oldModelClass.getMethod("getApprovedBy");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedBy(value16.intValue());

					Method method17 = oldModelClass.getMethod("getApprovedAt");

					Date value17 = (Date)method17.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedAt(value17);

					Method method18 = oldModelClass.getMethod("getIsApproved");

					Boolean value18 = (Boolean)method18.invoke(oldModel,
							(Object[])null);

					newModel.setIsApproved(value18.booleanValue());

					Method method19 = oldModelClass.getMethod(
							"getApprovedStatus");

					Boolean value19 = (Boolean)method19.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedStatus(value19.booleanValue());

					Method method20 = oldModelClass.getMethod("getReaSon");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setReaSon(value20);

					Method method21 = oldModelClass.getMethod("getOrgName");

					String value21 = (String)method21.invoke(oldModel,
							(Object[])null);

					newModel.setOrgName(value21);

					Method method22 = oldModelClass.getMethod("getFullName");

					String value22 = (String)method22.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value22);

					Method method23 = oldModelClass.getMethod("getFirstName");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setFirstName(value23);

					Method method24 = oldModelClass.getMethod("getMiddleName");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setMiddleName(value24);

					Method method25 = oldModelClass.getMethod("getLastName");

					String value25 = (String)method25.invoke(oldModel,
							(Object[])null);

					newModel.setLastName(value25);

					Method method26 = oldModelClass.getMethod("getReqFirstName");

					String value26 = (String)method26.invoke(oldModel,
							(Object[])null);

					newModel.setReqFirstName(value26);

					Method method27 = oldModelClass.getMethod(
							"getReqMiddleName");

					String value27 = (String)method27.invoke(oldModel,
							(Object[])null);

					newModel.setReqMiddleName(value27);

					Method method28 = oldModelClass.getMethod("getReqLastName");

					String value28 = (String)method28.invoke(oldModel,
							(Object[])null);

					newModel.setReqLastName(value28);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewRegistrationOvertimeaApprovalImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewRegistrationOvertimeaApprovalClp newModel = new LmisViewRegistrationOvertimeaApprovalClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewRegistrationOvertimeaApprovalId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewRegistrationOvertimeaApprovalId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRequestedBy");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedBy(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRequestedAt");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setRequestedAt(value3);

					Method method4 = oldModelClass.getMethod(
							"getRequestedReason");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedReason(value4);

					Method method5 = oldModelClass.getMethod(
							"getRequestedStatus");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedStatus(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCreatedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value6);

					Method method7 = oldModelClass.getMethod("getUpdatedAt");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value7);

					Method method8 = oldModelClass.getMethod("getOrgId");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value8.intValue());

					Method method9 = oldModelClass.getMethod("getName");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setName(value9);

					Method method10 = oldModelClass.getMethod("getFullName");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewOTAppImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewOTAppClp newModel = new LmisViewOTAppClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewOTAppId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewOTAppId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOrgId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRequestedBy");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedBy(value3.intValue());

					Method method4 = oldModelClass.getMethod("getRequestedAt");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setRequestedAt(value4);

					Method method5 = oldModelClass.getMethod(
							"getRequestedReason");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedReason(value5);

					Method method6 = oldModelClass.getMethod(
							"getRequestedStatus");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedStatus(value6.intValue());

					Method method7 = oldModelClass.getMethod("getCreatedAt");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value7);

					Method method8 = oldModelClass.getMethod("getUpdatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value8);

					Method method9 = oldModelClass.getMethod("getApprovedBy");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedBy(value9.intValue());

					Method method10 = oldModelClass.getMethod("getApprovedAt");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedAt(value10);

					Method method11 = oldModelClass.getMethod("getIsApproved");

					Boolean value11 = (Boolean)method11.invoke(oldModel,
							(Object[])null);

					newModel.setIsApproved(value11.booleanValue());

					Method method12 = oldModelClass.getMethod(
							"getApprovedStatus");

					Boolean value12 = (Boolean)method12.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedStatus(value12.booleanValue());

					Method method13 = oldModelClass.getMethod(
							"getApprovedReason");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedReason(value13);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewReportOvertimeImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewReportOvertimeClp newModel = new LmisViewReportOvertimeClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewReportOvertimeId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewReportOvertimeId(value0);

					Method method1 = oldModelClass.getMethod("getOtRepId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOtRepId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getOrgId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getRequestId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getReportedBy");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setReportedBy(value5.intValue());

					Method method6 = oldModelClass.getMethod("getReportedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setReportedAt(value6);

					Method method7 = oldModelClass.getMethod(
							"getReportedReason");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setReportedReason(value7);

					Method method8 = oldModelClass.getMethod(
							"getReportedStatus");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setReportedStatus(value8.intValue());

					Method method9 = oldModelClass.getMethod("getCreatedAt");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value9);

					Method method10 = oldModelClass.getMethod("getUpdatedAt");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value10);

					Method method11 = oldModelClass.getMethod("getReportId");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setReportId(value11.intValue());

					Method method12 = oldModelClass.getMethod("getUserId");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value12.intValue());

					Method method13 = oldModelClass.getMethod("getTotalHour");

					Double value13 = (Double)method13.invoke(oldModel,
							(Object[])null);

					newModel.setTotalHour(value13.doubleValue());

					Method method14 = oldModelClass.getMethod("getStartTime");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setStartTime(value14);

					Method method15 = oldModelClass.getMethod("getEndTime");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setEndTime(value15);

					Method method16 = oldModelClass.getMethod("getDetailId");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setDetailId(value16.intValue());

					Method method17 = oldModelClass.getMethod("getOtType");

					String value17 = (String)method17.invoke(oldModel,
							(Object[])null);

					newModel.setOtType(value17);

					Method method18 = oldModelClass.getMethod("getOtHour");

					Double value18 = (Double)method18.invoke(oldModel,
							(Object[])null);

					newModel.setOtHour(value18.doubleValue());

					Method method19 = oldModelClass.getMethod(
							"getOtCoefficient");

					Double value19 = (Double)method19.invoke(oldModel,
							(Object[])null);

					newModel.setOtCoefficient(value19.doubleValue());

					Method method20 = oldModelClass.getMethod("getOtId");

					Integer value20 = (Integer)method20.invoke(oldModel,
							(Object[])null);

					newModel.setOtId(value20.intValue());

					Method method21 = oldModelClass.getMethod("getOrgName");

					String value21 = (String)method21.invoke(oldModel,
							(Object[])null);

					newModel.setOrgName(value21);

					Method method22 = oldModelClass.getMethod("getFullName");

					String value22 = (String)method22.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value22);

					Method method23 = oldModelClass.getMethod("getFirstName");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setFirstName(value23);

					Method method24 = oldModelClass.getMethod("getMiddleName");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setMiddleName(value24);

					Method method25 = oldModelClass.getMethod("getLastName");

					String value25 = (String)method25.invoke(oldModel,
							(Object[])null);

					newModel.setLastName(value25);

					Method method26 = oldModelClass.getMethod("getRepFirstName");

					String value26 = (String)method26.invoke(oldModel,
							(Object[])null);

					newModel.setRepFirstName(value26);

					Method method27 = oldModelClass.getMethod("getRepLastName");

					String value27 = (String)method27.invoke(oldModel,
							(Object[])null);

					newModel.setRepLastName(value27);

					Method method28 = oldModelClass.getMethod(
							"getRepMiddleName");

					String value28 = (String)method28.invoke(oldModel,
							(Object[])null);

					newModel.setRepMiddleName(value28);

					Method method29 = oldModelClass.getMethod(
							"getRegRequestedHour");

					Double value29 = (Double)method29.invoke(oldModel,
							(Object[])null);

					newModel.setRegRequestedHour(value29.doubleValue());

					Method method30 = oldModelClass.getMethod("getRegStartTime");

					Date value30 = (Date)method30.invoke(oldModel,
							(Object[])null);

					newModel.setRegStartTime(value30);

					Method method31 = oldModelClass.getMethod("getRegEndTime");

					Date value31 = (Date)method31.invoke(oldModel,
							(Object[])null);

					newModel.setRegEndTime(value31);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewAttDailyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewAttDailyClp newModel = new LmisViewAttDailyClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewAttDailyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewAttDailyId(value0);

					Method method1 = oldModelClass.getMethod("getDayValue");

					Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

					newModel.setDayValue(value1);

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getAbsenceValue");

					Double value4 = (Double)method4.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceValue(value4.doubleValue());

					Method method5 = oldModelClass.getMethod("getIsPermissive");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIsPermissive(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getOrgId");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value6.intValue());

					Method method7 = oldModelClass.getMethod("getAbsenceType");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceType(value7);

					Method method8 = oldModelClass.getMethod("getAbsenceTypeId");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceTypeId(value8.intValue());

					Method method9 = oldModelClass.getMethod("getPlanStartTime");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setPlanStartTime(value9);

					Method method10 = oldModelClass.getMethod(
							"getRealStartTime");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setRealStartTime(value10);

					Method method11 = oldModelClass.getMethod("getTimeLate");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLate(value11.intValue());

					Method method12 = oldModelClass.getMethod(
							"getTimeLatePenalty");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLatePenalty(value12.intValue());

					Method method13 = oldModelClass.getMethod(
							"getTimeLateFinal");

					Double value13 = (Double)method13.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLateFinal(value13.doubleValue());

					Method method14 = oldModelClass.getMethod("getPlanEndTime");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setPlanEndTime(value14);

					Method method15 = oldModelClass.getMethod("getRealEndTime");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setRealEndTime(value15);

					Method method16 = oldModelClass.getMethod("getTimeEarly");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarly(value16.intValue());

					Method method17 = oldModelClass.getMethod(
							"getTimeEarlyPenalty");

					Integer value17 = (Integer)method17.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarlyPenalty(value17.intValue());

					Method method18 = oldModelClass.getMethod(
							"getTimeEarlyFinal");

					Double value18 = (Double)method18.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarlyFinal(value18.doubleValue());

					Method method19 = oldModelClass.getMethod(
							"getOverTimeValue");

					String value19 = (String)method19.invoke(oldModel,
							(Object[])null);

					newModel.setOverTimeValue(value19);

					Method method20 = oldModelClass.getMethod(
							"getTotalWorkingTime");

					Double value20 = (Double)method20.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingTime(value20.doubleValue());

					Method method21 = oldModelClass.getMethod(
							"getTotalOverTime");

					Double value21 = (Double)method21.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOverTime(value21.doubleValue());

					Method method22 = oldModelClass.getMethod(
							"getTotalOverTimeFinal");

					Double value22 = (Double)method22.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOverTimeFinal(value22.doubleValue());

					Method method23 = oldModelClass.getMethod(
							"getTotalTimeFinal");

					Double value23 = (Double)method23.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeFinal(value23.doubleValue());

					Method method24 = oldModelClass.getMethod("getCreatedAt");

					Date value24 = (Date)method24.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value24);

					Method method25 = oldModelClass.getMethod("getCreatedBy");

					Integer value25 = (Integer)method25.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value25.intValue());

					Method method26 = oldModelClass.getMethod("getUpdatedAt");

					Date value26 = (Date)method26.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value26);

					Method method27 = oldModelClass.getMethod("getUpdatedBy");

					Integer value27 = (Integer)method27.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value27.intValue());

					Method method28 = oldModelClass.getMethod(
							"getTotalOverTimeRequested");

					Double value28 = (Double)method28.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOverTimeRequested(value28.doubleValue());

					Method method29 = oldModelClass.getMethod("getAbSence");

					Integer value29 = (Integer)method29.invoke(oldModel,
							(Object[])null);

					newModel.setAbSence(value29.intValue());

					Method method30 = oldModelClass.getMethod("getFullName");

					String value30 = (String)method30.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value30);

					Method method31 = oldModelClass.getMethod("getStaffCode");

					String value31 = (String)method31.invoke(oldModel,
							(Object[])null);

					newModel.setStaffCode(value31);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewReportOvertimeApprovalImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewReportOvertimeApprovalClp newModel = new LmisViewReportOvertimeApprovalClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewReportOvertimeApprovalId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewReportOvertimeApprovalId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOrgId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRequestId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getReportedBy");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setReportedBy(value4.intValue());

					Method method5 = oldModelClass.getMethod("getReportedAt");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setReportedAt(value5);

					Method method6 = oldModelClass.getMethod(
							"getReportedReason");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setReportedReason(value6);

					Method method7 = oldModelClass.getMethod(
							"getReportedStatus");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setReportedStatus(value7.intValue());

					Method method8 = oldModelClass.getMethod("getCreatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value8);

					Method method9 = oldModelClass.getMethod("getUpdatedAt");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value9);

					Method method10 = oldModelClass.getMethod("getOrgName");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setOrgName(value10);

					Method method11 = oldModelClass.getMethod("getFullName");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewDayValueMaxImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewDayValueMaxClp newModel = new LmisViewDayValueMaxClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewDayValueMaxId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewDayValueMaxId(value0);

					Method method1 = oldModelClass.getMethod("getDayValue");

					Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

					newModel.setDayValue(value1);

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewOrgUserRolesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewOrgUserRolesClp newModel = new LmisViewOrgUserRolesClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewOrgUserRolesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewOrgUserRolesId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOrgId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getRoleId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRoleId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getOrgName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setOrgName(value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewAttInfoImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewAttInfoClp newModel = new LmisViewAttInfoClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewAttInfoId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewAttInfoId(value0);

					Method method1 = oldModelClass.getMethod("getStaffUID");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setStaffUID(value1.intValue());

					Method method2 = oldModelClass.getMethod("getPmUID");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setPmUID(value2.intValue());

					Method method3 = oldModelClass.getMethod("getDayValue");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setDayValue(value3);

					Method method4 = oldModelClass.getMethod("getRootId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getUserId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getAbsenceValue");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceValue(value6.doubleValue());

					Method method7 = oldModelClass.getMethod("getIsPermissive");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setIsPermissive(value7.booleanValue());

					Method method8 = oldModelClass.getMethod("getAbsenceType");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceType(value8);

					Method method9 = oldModelClass.getMethod("getAbsenceTypeId");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceTypeId(value9.intValue());

					Method method10 = oldModelClass.getMethod(
							"getPlanStartTime");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setPlanStartTime(value10);

					Method method11 = oldModelClass.getMethod(
							"getRealStartTime");

					Date value11 = (Date)method11.invoke(oldModel,
							(Object[])null);

					newModel.setRealStartTime(value11);

					Method method12 = oldModelClass.getMethod("getTimeLate");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLate(value12.intValue());

					Method method13 = oldModelClass.getMethod(
							"getTimeLatePenalty");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLatePenalty(value13.intValue());

					Method method14 = oldModelClass.getMethod(
							"getTimeLateFinal");

					Double value14 = (Double)method14.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLateFinal(value14.doubleValue());

					Method method15 = oldModelClass.getMethod("getPlanEndTime");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setPlanEndTime(value15);

					Method method16 = oldModelClass.getMethod("getRealEndTime");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setRealEndTime(value16);

					Method method17 = oldModelClass.getMethod("getTimeEarly");

					Integer value17 = (Integer)method17.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarly(value17.intValue());

					Method method18 = oldModelClass.getMethod(
							"getTimeEarlyPenalty");

					Integer value18 = (Integer)method18.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarlyPenalty(value18.intValue());

					Method method19 = oldModelClass.getMethod(
							"getTimeEarlyFinal");

					Double value19 = (Double)method19.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarlyFinal(value19.doubleValue());

					Method method20 = oldModelClass.getMethod(
							"getOverTimeValue");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setOverTimeValue(value20);

					Method method21 = oldModelClass.getMethod(
							"getTotalWorkingTime");

					Double value21 = (Double)method21.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingTime(value21.doubleValue());

					Method method22 = oldModelClass.getMethod(
							"getTotalOverTime");

					Double value22 = (Double)method22.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOverTime(value22.doubleValue());

					Method method23 = oldModelClass.getMethod(
							"getTotalOverTimeFinal");

					Double value23 = (Double)method23.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOverTimeFinal(value23.doubleValue());

					Method method24 = oldModelClass.getMethod(
							"getTotalTimeFinal");

					Double value24 = (Double)method24.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeFinal(value24.doubleValue());

					Method method25 = oldModelClass.getMethod("getCreatedAt");

					Date value25 = (Date)method25.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value25);

					Method method26 = oldModelClass.getMethod("getCreatedBy");

					Integer value26 = (Integer)method26.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value26.intValue());

					Method method27 = oldModelClass.getMethod("getUpdatedAt");

					Date value27 = (Date)method27.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value27);

					Method method28 = oldModelClass.getMethod("getUpdatedBy");

					Integer value28 = (Integer)method28.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value28.intValue());

					Method method29 = oldModelClass.getMethod(
							"getTotalOverTimeRequested");

					Double value29 = (Double)method29.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOverTimeRequested(value29.doubleValue());

					Method method30 = oldModelClass.getMethod("getAbSence");

					Integer value30 = (Integer)method30.invoke(oldModel,
							(Object[])null);

					newModel.setAbSence(value30.intValue());

					Method method31 = oldModelClass.getMethod("getFullName");

					String value31 = (String)method31.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value31);

					Method method32 = oldModelClass.getMethod("getStaffCode");

					String value32 = (String)method32.invoke(oldModel,
							(Object[])null);

					newModel.setStaffCode(value32);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewStaffMappingPmImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewStaffMappingPmClp newModel = new LmisViewStaffMappingPmClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewStaffMappingPmId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewStaffMappingPmId(value0);

					Method method1 = oldModelClass.getMethod("getOrgId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getBodId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setBodId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getStaffUID");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setStaffUID(value4.intValue());

					Method method5 = oldModelClass.getMethod("getPmUID");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setPmUID(value5.intValue());

					Method method6 = oldModelClass.getMethod("getStaffCode");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setStaffCode(value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewAttdanceImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewAttdanceClp newModel = new LmisViewAttdanceClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewAttDailyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewAttDailyId(value0);

					Method method1 = oldModelClass.getMethod("getDayValue");

					Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

					newModel.setDayValue(value1);

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getAbsenceValue");

					Double value4 = (Double)method4.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceValue(value4.doubleValue());

					Method method5 = oldModelClass.getMethod("getIsPermissive");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIsPermissive(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getAbsenceType");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceType(value6);

					Method method7 = oldModelClass.getMethod("getAbsenceTypeId");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setAbsenceTypeId(value7.intValue());

					Method method8 = oldModelClass.getMethod("getPlanStartTime");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setPlanStartTime(value8);

					Method method9 = oldModelClass.getMethod("getRealStartTime");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setRealStartTime(value9);

					Method method10 = oldModelClass.getMethod("getTimeLate");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLate(value10.intValue());

					Method method11 = oldModelClass.getMethod(
							"getTimeLatePenalty");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLatePenalty(value11.intValue());

					Method method12 = oldModelClass.getMethod(
							"getTimeLateFinal");

					Double value12 = (Double)method12.invoke(oldModel,
							(Object[])null);

					newModel.setTimeLateFinal(value12.doubleValue());

					Method method13 = oldModelClass.getMethod("getPlanEndTime");

					Date value13 = (Date)method13.invoke(oldModel,
							(Object[])null);

					newModel.setPlanEndTime(value13);

					Method method14 = oldModelClass.getMethod("getRealEndTime");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setRealEndTime(value14);

					Method method15 = oldModelClass.getMethod("getTimeEarly");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarly(value15.intValue());

					Method method16 = oldModelClass.getMethod(
							"getTimeEarlyPenalty");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarlyPenalty(value16.intValue());

					Method method17 = oldModelClass.getMethod(
							"getTimeEarlyFinal");

					Double value17 = (Double)method17.invoke(oldModel,
							(Object[])null);

					newModel.setTimeEarlyFinal(value17.doubleValue());

					Method method18 = oldModelClass.getMethod(
							"getOverTimeValue");

					String value18 = (String)method18.invoke(oldModel,
							(Object[])null);

					newModel.setOverTimeValue(value18);

					Method method19 = oldModelClass.getMethod(
							"getTotalWorkingTime");

					Double value19 = (Double)method19.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingTime(value19.doubleValue());

					Method method20 = oldModelClass.getMethod(
							"getTotalOverTime");

					Double value20 = (Double)method20.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOverTime(value20.doubleValue());

					Method method21 = oldModelClass.getMethod(
							"getTotalOverTimeFinal");

					Double value21 = (Double)method21.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOverTimeFinal(value21.doubleValue());

					Method method22 = oldModelClass.getMethod(
							"getTotalTimeFinal");

					Double value22 = (Double)method22.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeFinal(value22.doubleValue());

					Method method23 = oldModelClass.getMethod("getCreatedAt");

					Date value23 = (Date)method23.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value23);

					Method method24 = oldModelClass.getMethod("getCreatedBy");

					Integer value24 = (Integer)method24.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value24.intValue());

					Method method25 = oldModelClass.getMethod("getUpdatedAt");

					Date value25 = (Date)method25.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value25);

					Method method26 = oldModelClass.getMethod("getUpdatedBy");

					Integer value26 = (Integer)method26.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value26.intValue());

					Method method27 = oldModelClass.getMethod(
							"getTotalOverTimeRequested");

					Double value27 = (Double)method27.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOverTimeRequested(value27.doubleValue());

					Method method28 = oldModelClass.getMethod("getAbSence");

					Integer value28 = (Integer)method28.invoke(oldModel,
							(Object[])null);

					newModel.setAbSence(value28.intValue());

					Method method29 = oldModelClass.getMethod("getFullName");

					String value29 = (String)method29.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value29);

					Method method30 = oldModelClass.getMethod("getStaffCode");

					String value30 = (String)method30.invoke(oldModel,
							(Object[])null);

					newModel.setStaffCode(value30);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewOvertimeReportImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewOvertimeReportClp newModel = new LmisViewOvertimeReportClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewOvertimeReportId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewOvertimeReportId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOrgId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRequestId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getReportedBy");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setReportedBy(value4.intValue());

					Method method5 = oldModelClass.getMethod("getReportedAt");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setReportedAt(value5);

					Method method6 = oldModelClass.getMethod(
							"getReportedReason");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setReportedReason(value6);

					Method method7 = oldModelClass.getMethod(
							"getReportedStatus");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setReportedStatus(value7.intValue());

					Method method8 = oldModelClass.getMethod("getCreatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value8);

					Method method9 = oldModelClass.getMethod("getUpdatedAt");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value9);

					Method method10 = oldModelClass.getMethod("getOrgName");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setOrgName(value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisViewOvertimeReportDetailImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisViewOvertimeReportDetailClp newModel = new LmisViewOvertimeReportDetailClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisViewReportOvertimeId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisViewReportOvertimeId(value0);

					Method method1 = oldModelClass.getMethod("getOtRepId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOtRepId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getOrgId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getRequestId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRequestId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getReportedBy");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setReportedBy(value5.intValue());

					Method method6 = oldModelClass.getMethod("getReportedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setReportedAt(value6);

					Method method7 = oldModelClass.getMethod(
							"getReportedReason");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setReportedReason(value7);

					Method method8 = oldModelClass.getMethod(
							"getReportedStatus");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setReportedStatus(value8.intValue());

					Method method9 = oldModelClass.getMethod("getCreatedAt");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value9);

					Method method10 = oldModelClass.getMethod("getUpdatedAt");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value10);

					Method method11 = oldModelClass.getMethod("getUserId");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value11.intValue());

					Method method12 = oldModelClass.getMethod("getTotalHour");

					Double value12 = (Double)method12.invoke(oldModel,
							(Object[])null);

					newModel.setTotalHour(value12.doubleValue());

					Method method13 = oldModelClass.getMethod("getStartTime");

					Date value13 = (Date)method13.invoke(oldModel,
							(Object[])null);

					newModel.setStartTime(value13);

					Method method14 = oldModelClass.getMethod("getEndTime");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setEndTime(value14);

					Method method15 = oldModelClass.getMethod("getFullName");

					String value15 = (String)method15.invoke(oldModel,
							(Object[])null);

					newModel.setFullName(value15);

					Method method16 = oldModelClass.getMethod(
							"getReqRequestedHour");

					Double value16 = (Double)method16.invoke(oldModel,
							(Object[])null);

					newModel.setReqRequestedHour(value16.doubleValue());

					Method method17 = oldModelClass.getMethod("getReqStartTime");

					Date value17 = (Date)method17.invoke(oldModel,
							(Object[])null);

					newModel.setReqStartTime(value17);

					Method method18 = oldModelClass.getMethod("getReqEndTime");

					Date value18 = (Date)method18.invoke(oldModel,
							(Object[])null);

					newModel.setReqEndTime(value18);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisAttMonthlyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisAttMonthlyClp newModel = new LmisAttMonthlyClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisAttMonthlysId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisAttMonthlysId(value0);

					Method method1 = oldModelClass.getMethod("getYearValue");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setYearValue(value1.intValue());

					Method method2 = oldModelClass.getMethod("getMonthValue");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setMonthValue(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRootId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod(
							"getTotalWorkingDay");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingDay(value5.intValue());

					Method method6 = oldModelClass.getMethod("getNumDayAward");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setNumDayAward(value6.doubleValue());

					Method method7 = oldModelClass.getMethod("getTotalDayOff");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayOff(value7.doubleValue());

					Method method8 = oldModelClass.getMethod(
							"getTotalDayCompensation");

					Double value8 = (Double)method8.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayCompensation(value8.doubleValue());

					Method method9 = oldModelClass.getMethod(
							"getTotalDayOffCompensation");

					Double value9 = (Double)method9.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayOffCompensation(value9.doubleValue());

					Method method10 = oldModelClass.getMethod(
							"getStartTimeAverage");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setStartTimeAverage(value10);

					Method method11 = oldModelClass.getMethod(
							"getEndTimeAverage");

					Date value11 = (Date)method11.invoke(oldModel,
							(Object[])null);

					newModel.setEndTimeAverage(value11);

					Method method12 = oldModelClass.getMethod(
							"getTotalTimeLate");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeLate(value12.intValue());

					Method method13 = oldModelClass.getMethod(
							"getTotalTimeLatePenalty");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeLatePenalty(value13.intValue());

					Method method14 = oldModelClass.getMethod(
							"getTotalTimeEarly");

					Integer value14 = (Integer)method14.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeEarly(value14.intValue());

					Method method15 = oldModelClass.getMethod(
							"getTotalTimeEarlyPenalty");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeEarlyPenalty(value15.intValue());

					Method method16 = oldModelClass.getMethod(
							"getTotalDayOvertime");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayOvertime(value16.intValue());

					Method method17 = oldModelClass.getMethod(
							"getTotalTimeLateFinal");

					Double value17 = (Double)method17.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeLateFinal(value17.doubleValue());

					Method method18 = oldModelClass.getMethod(
							"getTotalTimeEarlyFinal");

					Double value18 = (Double)method18.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeEarlyFinal(value18.doubleValue());

					Method method19 = oldModelClass.getMethod(
							"getTotalWorkingTime");

					Double value19 = (Double)method19.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingTime(value19.doubleValue());

					Method method20 = oldModelClass.getMethod(
							"getTotalOvertime");

					Double value20 = (Double)method20.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOvertime(value20.doubleValue());

					Method method21 = oldModelClass.getMethod(
							"getTotalOvertimeFinal");

					Double value21 = (Double)method21.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOvertimeFinal(value21.doubleValue());

					Method method22 = oldModelClass.getMethod(
							"getTotalDayCompensationNextMonth");

					Double value22 = (Double)method22.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayCompensationNextMonth(value22.doubleValue());

					Method method23 = oldModelClass.getMethod(
							"getTotalTimeFinal");

					Double value23 = (Double)method23.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeFinal(value23.doubleValue());

					Method method24 = oldModelClass.getMethod(
							"getTotalOvertimeRequested");

					Double value24 = (Double)method24.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOvertimeRequested(value24.doubleValue());

					Method method25 = oldModelClass.getMethod(
							"getTotalDayoffPermissive");

					Double value25 = (Double)method25.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayoffPermissive(value25.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.lmis.model.impl.LmisAttYearlyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LmisAttYearlyClp newModel = new LmisAttYearlyClp();

					Method method0 = oldModelClass.getMethod(
							"getLmisAttYearlyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLmisAttYearlyId(value0);

					Method method1 = oldModelClass.getMethod("getYearValue");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setYearValue(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod(
							"getTotalWorkingDay");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingDay(value4.intValue());

					Method method5 = oldModelClass.getMethod(
							"getTotalDayAwardPrevYear");

					Double value5 = (Double)method5.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayAwardPrevYear(value5.doubleValue());

					Method method6 = oldModelClass.getMethod("getTotalDayOff");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayOff(value6.doubleValue());

					Method method7 = oldModelClass.getMethod("getTotalDayAward");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayAward(value7.doubleValue());

					Method method8 = oldModelClass.getMethod(
							"getTotalDayRemaining");

					Double value8 = (Double)method8.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayRemaining(value8.doubleValue());

					Method method9 = oldModelClass.getMethod(
							"getStartTimeAverage");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setStartTimeAverage(value9);

					Method method10 = oldModelClass.getMethod(
							"getEndTimeAverage");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setEndTimeAverage(value10);

					Method method11 = oldModelClass.getMethod(
							"getTotalTimeLate");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeLate(value11.intValue());

					Method method12 = oldModelClass.getMethod(
							"getTotalTimeLatePenalty");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeLatePenalty(value12.intValue());

					Method method13 = oldModelClass.getMethod(
							"getTotalTimeEarly");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeEarly(value13.intValue());

					Method method14 = oldModelClass.getMethod(
							"getTotalTimeEarlyPenalty");

					Integer value14 = (Integer)method14.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeEarlyPenalty(value14.intValue());

					Method method15 = oldModelClass.getMethod(
							"getTotalDayOvertime");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayOvertime(value15.intValue());

					Method method16 = oldModelClass.getMethod(
							"getTotalTimeLateFinal");

					Double value16 = (Double)method16.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeLateFinal(value16.doubleValue());

					Method method17 = oldModelClass.getMethod(
							"getTotalTimeEarlyFinal");

					Double value17 = (Double)method17.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeEarlyFinal(value17.doubleValue());

					Method method18 = oldModelClass.getMethod(
							"getTotalWorkingTime");

					Double value18 = (Double)method18.invoke(oldModel,
							(Object[])null);

					newModel.setTotalWorkingTime(value18.doubleValue());

					Method method19 = oldModelClass.getMethod(
							"getTotalOvertime");

					Double value19 = (Double)method19.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOvertime(value19.doubleValue());

					Method method20 = oldModelClass.getMethod(
							"getTotalOvertimeFinal");

					Double value20 = (Double)method20.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOvertimeFinal(value20.doubleValue());

					Method method21 = oldModelClass.getMethod(
							"getTotalTimeFinal");

					Double value21 = (Double)method21.invoke(oldModel,
							(Object[])null);

					newModel.setTotalTimeFinal(value21.doubleValue());

					Method method22 = oldModelClass.getMethod(
							"getTotalOvertimeRequested");

					Double value22 = (Double)method22.invoke(oldModel,
							(Object[])null);

					newModel.setTotalOvertimeRequested(value22.doubleValue());

					Method method23 = oldModelClass.getMethod(
							"getTotalDayoffPermissive");

					Double value23 = (Double)method23.invoke(oldModel,
							(Object[])null);

					newModel.setTotalDayoffPermissive(value23.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateOutput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}