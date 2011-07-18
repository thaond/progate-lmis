package com.larion.progate.common.constants;

/**
 * Constants
 */
public interface Request {

	/* Organization variables */
	public static final String ORG_CLASS_NAME = "Org";
	public static final String ORG_ID = "orgId";
	public static final String ROOT_ORG_ID = "rootOrgId";
	public static final String ADDED_ORG_ID = "addedOrgId";
	public static final String ORG_NAME = "orgName";
	public static final String ORG_ABBREVIATION = "orgAbbreviation";
	public static final String ORG_DESCRIPTION = "orgDescription";
	public static final String ORG_COUNTRY = "orgCountry";
	public static final String ORG_CITY = "orgCity";
	public static final String ORG_STATE = "orgState";
	public static final String ORG_ADDRESS_1 = "orgAddress_1";
	public static final String ORG_ADDRESS_2 = "orgAddress_2";
	public static final String ORG_PHONE = "orgPhone";
	public static final String ORG_MAX_USER_COUNT = "orgMaxUserCount";
	public static final String ORG_EXPIRED_ON = "orgExpiredOn";
	public static final String ORG_TYPE = "orgType";
	public static final String ORG_STATUS = "orgStatus";
	public static final String ORG_PROFILE = "orgProfile";
	public static final String ORG_SHOW_LOGO = "orgShowLoGo";

	public static final String SELECTED_ORG_ID = "selectedOrgId";
	public static final String CURRENT_ORG_ID = "currentOrgId";
	public static final String ROLE = "role";

	/* User variables */
	public static final String USER_ACCOUNT = "userAccount";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_PASSWORD_CONFIRM = "userPasswordConfirm";
	public static final String USER_FIRST_NAME = "userFirstName";
	public static final String USER_LAST_NAME = "userLastName";
	public static final String USER_MAIL = "userMail";
	public static final String USER_ID = "userId";
	public static final String USER_SEX = "userSex";
	public static final String USER_DATE = "userDate";
	public static final String USER_MONTH = "userMonth";
	public static final String USER_YEAR = "userYear";
	public static final String USER_PHONE = "userPhone";
	public static final String USER_ROLE_ID = "userRoleId";

	/* Product variables */
	public static final String PRODUCT_TYPE = "productType";
	public static final String PRODUCT_ID = "productId";

	/* Journal variables */
	public static final String JOURNAL_ARTICLES = "Journal_Articles";
	public static final String JOURNAL_CONTENT = "Journal_Content";

	/* Search criteria variables */
	public static final String SEARCH_CRITERIA = "searchCriteria";

	/* Form variables */
	public static final String CHILD_CKB = "child_ckb";
	public static final String OBJ_ALLOCATE_LEVEL = "Obj_Allocate_Level";
	public static final String OBJ_YEAR = "Obj_Year";
	public static final String DISPLAY_STYLE = "Display_Style";
	public static final String NUM_OF_ITEM = "Num_Of_Item";
	public static final String FRIENDLY_URL = "Friendly_Url";
	public static final String MESSAGE_TXT = "MsgTxt";
	public static final String SUCCESS_MESSAGE = "successMsg";
	public static final String FAIL_MESSAGE = "failMsg";
	public static final String MESSAGE_STATUS = "msgStatus";
	public static final int MESSAGE_STATUS_SUCCESS = 1;
	public static final int MESSAGE_STATUS_FAIL = 2;

	/* Actions */
	public static final String ENABLE = "Enable";
	public static final String DISABLE = "Disable";
	public static final String SETTING = "Setting";
	public static final String NEW_ORG = "New_Org";

	/* EBSC Tab Actions */
	public static final String TA = "TabActions";
	public static final String TA_1 = "ObjManageACT";
	public static final String TA_1_1 = "ObjManageListACT";
	public static final String TA_1_2 = "ObjManageEditACT";
	public static final String TA_1_3 = "ObjManageViewACT";
	public static final String TA_2 = "OrgStructureManageACT";
	public static final String TA_3 = "OfficeManageACT";
	public static final String TA_4 = "CostCalculateACT";
	public static final String TA_5 = "AhpACT";

	public static final String AHP_CALCULATE = "AhpCalculate";

	public static final String ADD_OBJECTIVE_SET_ACT = "AddObjectiveSetACT";
	public static final String DELETE_OBJECTIVE_SET_ACT = "DeleteObjectiveSetACT";

	/* Dialog Actions */
	public static final String EDIT_PERSPECTIVE_ACT = "EditPerspectiveACT";
	public static final String ADD_OBJECTIVE_ACT = "AddObjectiveACT";
	public static final String EDIT_OBJECTIVE_ACT = "EditObjectiveACT";
	public static final String DELETE_OBJECTIVE_ACT = "DeleteObjectiveACT";
	public static final String ADD_MEASURE_ACT = "AddMeasureACT";
	public static final String EDIT_MEASURE_ACT = "EditMeasureACT";
	public static final String DELETE_MEASURE_ACT = "DeleteMeasureACT";
	public static final String ADD_TARGET_ACT = "AddTargetACT";
	public static final String EDIT_TARGET_ACT = "EditTargetACT";
	public static final String DELETE_TARGET_ACT = "DeleteTargetACT";
	public static final String INPUT_COST_ACT = "InputCostACT";
	public static final String CALCULATE_COST_ACT = "CalculateCostACT";
	public static final String AHP_ALGORITHM_ACT = "AhpAlgorithmACT";
	public static final String APPLY_WEIGHT_PERCENT_ACT = "ApplyWeightPercent";

	/* CDS Decentralization Tab Actions */
	public static final String DECENTRALIZE_TOTAL_ACT = "decentralizingTotalAction";
	public static final String DECENTRALIZE_INDIVIDUAL_ACT = "decentralizingIndividualAction";

	/* User Management Tab */
	public static final String TAB = "tab";
	public static final String MEMBER_TAB = "memberTab";
	public static final String INVITE_MEMBER_TAB = "inviteMemberTab";
	public static final String INVITED_MEMBER_TAB = "invitedMemberTab";
	public static final String WAITING_MEMBER_TAB = "waitingMemberTab";
	public static final String OLD_MEMBER_TAB = "oldMemberTab";
	public static final String ADDITIONAL_TAB = "additionalTab";

	/* User Management variables */
	public static final String FILTER_USER_TYPICAL_MEMBER = "filterUserTypicalMember";
	public static final String FILTER_USER_STATUS = "filterUserStatus";
	public static final String FILTER_USER_ROLE = "filterUserRole";
	public static final String APPLY_USER_ROLE = "applyUserRole";

	public static final int ORG_USER_STATUS_USER_REQUEST = 1;
	public static final int ORG_USER_STATUS_ORG_ADMIN_INVITE = 2;
	public static final int ORG_USER_STATUS_USER_JOIN_ORG = 3;
	public static final int ORG_USER_STATUS_REJECT_REQUEST = 4;
	public static final int USER_NOT_HAVE_PARTICIPANT_INFO = 0;

	public static final String USERNAME = "Username";
	public static final String PASSWORD = "Password";
	
	public static final String LOGIN = "login";
	public static final String OLD_PASSWORD = "oldPassword";
	public static final String NEW_PASSWORD = "newPassword";
	public static final String NEW_PASSWORD_AGAIN = "newPasswordAgain";
	
	/*LMIS*/
	public static final String SELECTED_ID="selectTimeChangeID";
	public static final String CURRENT_CHANGE_TIME_ID="currentTimeChangID";
	public static final String CURRENT_HANDER="currentHander";
	public static final String UNDO_HANDER= "undoHander";
	public static final String REVIEW="review";
	public static final String AGREE="agree";
	public static final String NOT_AGREE="notAgree";
	public static final String ROOT_ID="orgId";
	public static final String SELECTED="selected";
	public static final String SAVE_SUCCESS="saveSuccess";
	/*Tab TVNA*/
	public static final String TAB_ACT="tabAction";
	public static final String TAB_PERSONAL="tabPersonal";
	public static final String TAB_MANAGER="tabManager";
	public static final String TAB_OTHER="tabOther";
	public static final String TAB_ATTENDANCE="tabAttendance";
	public static final String TAB_DAYOFF="tabDayOff";
	public static final String TAB_OVERTIME="tabOverTime";
	public static final String TAB_REPORT="tabReport";
	public static final String UPLOAD= "upload";
	public static final String DATEIMPORT= "dateImport";
	/*Tab OverTime*/
	public static final String TAB_OT_ACT ="tabAction";
	public static final String TAB_OT_PER ="tabPersonal";
	public static final String TAB_OT_MANAGER="tabManager";
	public static final String TAB_OT_OTHER ="tabOther";
	public static final String OrgId ="orgIdReq";
	public static final String IS_PM ="Manager";
	public static final String IS_STAFF ="Staff Of";
	public static final String IS_BOD="BOD";
	public static final String IS_Guest="Guest";

	/* tuyentn*** */
	public static final String TAB_ACTION = "tabAction";
	public static final String EMAIL_TAB = "emailTab";
	public static final String WORKINGTIME_TAB = "workingTimeTab";
	public static final String CALENDAR_TAB = "calendarTab";
	public static final String ATTENDANCECODE_TAB = "attendanceCodeTab";
	public static final String COEFFICIENTOVERTIME_TAB ="coefficientOvertimeTab";
	public static final String ATTENDANCE_INFO_FILE_TAB ="attendanceInfoFileTab";
	/* Lmis organizations variables*/
	public static final String ATTENDANCEINFO_TAB = "attendanceInfoTab";
	public static final String DAYOFF_TAB = "dayOffTab";
	public static final String OVERTIME_TAB = "overtimeTab";
	public static final String SUMMARY_TAB = "summaryTab";
	
}