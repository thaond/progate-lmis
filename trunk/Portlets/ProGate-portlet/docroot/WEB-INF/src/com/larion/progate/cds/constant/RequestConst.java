package com.larion.progate.cds.constant;

public interface RequestConst {
	
	public static final String TAB = "tab";
	public static final String TAB_PAGE = "page";
	public static final String HANDLE = "handle";
	public static final String TAB_PAGE_REGION = "region";
	
	//for Authentication
	public static final String APPLICATION_ID = "Quản Lý Đánh Giá";
	public static final int CATEGORY_ID = 0;
	
	public static final String USER_ROLE = "userRole";
	public static final int ROLE_PM = 5;
	public static final int ROLE_BOD = 9;
	public static final int ROLE_EMPLOYEE = 8;
	
	public static final String PERMISSION_EMPLOYEE_IN_PROJECT_APPROVAL = "pheduyetcanhantheoduan";
	public static final String PERMISSION_EMPLOYEE_IN_COMPANY_APPROVAL = "pheduyetcanhantheocongty";
	
	public static final String PERMISSION_ALL_STAFF_APPROVAL = "pheduyettoanbo";
	public static final String PERMISSION_TITLE_APPROVAL = "pheduyettitle";
	public static final String PERMISSION_CDP_EVALUATION = "khoitaocdp";
	public static final String PERMISSION_CDP_APPROVAL = "pheduyetcdp";
	public static final String PERMISSION_CONFIG_CDS_TREE = "cauhinhcautruccds";
	public static final String PERMISSION_CONFIG_MINIMUM_REQUIREMENT = "cauhinhminimumrequirement";
	public static final String PERMISSION_CONFIG_POINTS = "cauhinhthangdiem";
	public static final String PERMISSION_CONFIG_PERIODS = "cauhinhdotcds";
	public static final String PERMISSION_CONFIG_TITLE = "cauhinhtitle";
	public static final String PERMISSION_EVALUATION = "danhgiacds";
	public static final String PERMISSION_INPUT_DATA = "nhapdulieu";
	public static final String PERMISSION_ROLE_PER = "phanquyentongquat";
	public static final String PERMISSION_USER_PER = "phanquyencanhan";
	public static final String PERMISSION_SLOT_REPORT = "baocaothongkeslot";
	public static final String PERMISSION_LEVEL_MAPPING = "baocaothongkelevelmapping";
	public static final String PERMISSION_EMPLOYEE_STATE = "baocaothongketinhtrangcdsnv";
	
	// tabs for Building Permit Screen
	public static final String TAB_BUILDING_PERMIT_1 = "rolePermissions";
	public static final String TAB_BUILDING_PERMIT_2 = "userPermissions";
	
	// tabs for Evaluation screen
	public static final String TAB_EVALUATION_1= "currentResult";
	public static final String TAB_EVALUATION_2 = "prepareForEvaluation";
	public static final String TAB_EVALUATION_3 = "evaluateSlot";
	
	// tabs for Approval screen
	public static final String TAB_APPROVAL_1= "individualApproval";
	public static final String TAB_APPROVAL_2 = "allStaffApproval";
	public static final String TAB_APPROVAL_3 = "titleApproval";
	
	/*Current Result variables*/
	public static final String PERIOD_ID = "evaluationPeriodId";
	public static final String COMPETENCY_ID = "competencyId";
	public static final String SLOT_STATUS = "slotStatus";
	public static final String SLOT_ID = "slotId";
	
	/*Evaluation - evaluateSlot screen*/
	public static final String POINT_NAME = "pointName";
	public static final String POINT_VALUE = "pointValue";
	public static final String HANDLE_GET_COMMENT_LIST = "getCommentList";
	public static final String HANDLE_SAVE_POINT_RATING = "savePointRating";
	public static final String HANDLE_SAVE_COMMENT = "saveComment";
	public static final String COMMENT_TEXT = "commentText";
	
	/*Approval screen*/
	public static final String PROJECT_ID = "projectId";
	public static final String CDS_STATUS = "cdsStatus";
	public static final String RATING_STATUS = "ratingStatus";
	public static final String EMPLOYEE_ID = "employeeId";
	public static final String TAB_APPROVAL_1_PAGE_1 = "individualApprovalPage1";
	public static final String TAB_APPROVAL_1_PAGE_2 = "individualApprovalPage2";
	public static final String TAB_APPROVAL_1_PAGE_2_REGION_1 = "individualApprovalPage1Region1";
	public static final String TAB_APPROVAL_1_PAGE_2_REGION_2 = "individualApprovalPage1Region2";
	public static final String HANDLE_LOCK_CDS = "lockCDS";
	public static final String HANDLE_APPROVE_ALL_STAFF = "approveAllStaff";
	public static final String DISABLE_RATING_POINT = "disableRatingPoint";
	public static final String DISABLE_APPROVAL = "disableAprroval";
	
	/*Statistical Report - employeeStateStatisticalReport variables*/
	public static final String EMPLOYEE_NAME = "employeeName";
	public static final String EMPLOYEE_TITLE = "employeeTitle";
	public static final String EMPLOYEE_POSITION = "employeePosition";
	public static final String EMPLOYEE_PROJECT = "projectOfEmployee";
	
	/*Input Data Screen*/
	public static final String INPUT_DATA_PAGE = "page";
	public static final String INPUT_DATA_PAGE_1 = "inputData";
	public static final String INPUT_DATA_PAGE_2 = "importCds";
	public static final String INPUT_DATA_PAGE_3 = "inputMinimumRequirement";
	public static final String INPUT_DATA_PAGE_4 = "importCdp";
	public static final String FILE_SIZE_TOO_BIG = "fileSizeTooBig";
	public static final String UPLOAD_ERROR = "uploadError";
	
	/*CDP Approval Screen*/
	public static final String CDP_APPROVAL_PAGE_1 = "cdpApprovalPage1";
	public static final String CDP_APPROVAL_PAGE_2 = "cdpApprovalPage2";
}
