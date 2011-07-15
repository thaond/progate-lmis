package com.larion.progate.lmis.constants;

import com.larion.progate.common.constants.RSConstants;

public interface LmisRequest extends RSConstants {
	public static final String TAB_ACTION = "tabAction";
	public static final String TAB_BUILDING_PERMIT_1 = "rolePermissions";
	public static final String TAB_BUILDING_PERMIT_2 = "userPermissions";
	public static final String TAB_BUILDING_PERMIT_3 = "delegate";
	public static final String GO_BACK = "goBack";
	public static final String SEND_REPORT = "sendReport";
	public static final String APPROVED = "approved";
	public static final String NOT_APPROVED = "notApproved";
	public static final String APPROVE = "approve";
	public static final String GRANT = "grant";

	public static final String REQUEST_ID = "requestId";
	public static final String REPORT_ID = "reportId";
	public static final String SUB_ORG_ID = "subOrgId";
	public static final String APPROVE_ID = "approveId";
	public static final String APPROVE_STATUS = "approveStatus";
	public static final String FEEDBACK = "feedback";
	public static final String CREATE_REPORT = "createReport";

	public static final int PER_STAFF = 1;
	public static final int PER_PM = 2;
	public static final int PER_BOD = 3;
	public static final int PER_NONE= 0;
}