package com.larion.progate.lmis.constants;

import com.larion.progate.common.constants.RSConstants;

public interface Configuration_RS extends RSConstants {

	//Configure Email variables
	public static final String SELECT_EMAIL_TYPE = "selectEmailType";
	public static final String LIST_USER_EMAIL ="listUserEmail";
	public static final String LIST_ORG_EMAIL ="listOrgEmail";

	//Configure working time variables
	public static final String SESSION_NAME ="sessionName";
	public static final String START_TIME_HOUR = "startTimeHour";
	public static final String START_TIME_MINUTE = "startTimeMinute";
	public static final String MAX_LATE = "maxLate";
	public static final String MAX_EARLY ="maxEarly";
	public static final String END_TIME_HOUR = "endTimeHour";
	public static final String END_TIME_MINUTE = "endTimeMinute";
	public static final String LIMIT_LATE ="limitLate";
	public static final String LIMIT_EARLY = "limitEarly";
	public static final String COEFFICIENT_EARLY = "coefficientEarly";
	public static final String COEFFICIENT_LATE = "coefficientLate";

	//Configure working calendar
	public static final String SELECT_MONTH ="selectMonth";
	public static final String SELECT_YEAR = "selectYear";
	public static final String SELECT_HOLIDAY = "selectHoliday";
	public static final String CALENDAR_ID = "lmisWorkingCalendarId";
	public static final String DATE_TIME = "dateTime";
	public static final String DESCRIPTION = "description";
	//Configure attendance code

	// Configure coefficient overtime
	public static final String COEFFICIENT_TYPE1= "coeffientType1";
	public static final String COEFFICIENT_TYPE2= "coeffientType2";
	public static final String COEFFICIENT_TYPE3= "coeffientType3";
	public static final String NOTE_TYPE1= "noteType1";
	public static final String NOTE_TYPE2= "noteType2";
	public static final String NOTE_TYPE3= "noteType3";
	public static final String DAY_TYPE = "dayType";

	//Create overtime reports
	public static final String VIEW_OT_REPORT = "viewOTReport";
	public static final String VIEW_OT_REPORT_DETAIL = "viewOTReportInDetail";
	public static final String GO_BACK = "goBack";

}