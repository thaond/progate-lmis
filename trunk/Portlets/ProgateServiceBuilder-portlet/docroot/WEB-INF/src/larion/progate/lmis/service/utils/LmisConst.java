package larion.progate.lmis.service.utils;

public interface LmisConst {	
	
	public static int Config_Code_FALSE = 0;
	public static int Config_Code_Duplicate = 1;
	public static int Config_Code_Success = 2;
	public static int Config_Code_Null = 3;

	public static int Config_Delete_Date_Type = 0;

	public static int TimeChgReq_Delete_Fata = 0;
	public static int TimeChgReq_Delete_NotMatch = 1;
	public static int TimeChgReq_Delete_Success = 2;

	public static int TimeChgReq_Status_Pending = 1;
	public static int TimeChgReq_Status_Accepted = 2;
	public static int TimeChgReq_Status_NotAccept = 3;
	public static int View_TimeChgReq_Null =0;
	
	public static int OverTimeReq_Status_Pending = 1;
	public static int OverTimeReq_Status_Accepted = 2;
	public static int OverTimeReq_Status_NotAccept = 3;
	public static int OverTimeReq_Status_Create_Report = 4;
	public static int OverTimeReq_Status_Ban = 5;
	public static int OverTimeReq_Status_Created_Report = 6;
	
	public static int OverTimeReport_Status_PendingAppOT = 4;
	public static int OverTimeReport_Status_Pending = 1;
	public static int OverTimeReport_Status_Accepted = 2;
	public static int OverTimeReport_Status_NotAccept = 3;	
	public static int OverTimeReport_Status_Need_Create_Report = 0;
	public static int OverTimeReport_Status_Ban = 5;
	
	public static int OverTimeReport_Add_Success = 1;
	
	public static int OverTimeReq_Delete_Fata = 0;
	public static int OverTimeReq_Delete_NotMatch = 1;
	public static int OverTimeReq_Delete_Success = 2;
	public static int Imp_Type_ChkIn = 1;
	public static int Imp_Type_ChkOut = 2;
	public static int Imp_Type_ChkAll = 3;
	public static int Imp_Chk_Lt4Col = 4;
	public static int Imp_Chk_NotMatch = 5;
	public static int Imp_Err_InserDataImp=6;
	public static int Imp_Chk_IsValFile =7;
	public static int Imp_Chk_IsNotValFile =8;
	public static int Imp_Err_Parse =9;
	public static String Imp_Err_NotEnough4Col = "Tap tin cham cong cua ban khong co du 4 cot yeu cau";
	public static String Imp_Err_DefaultConstruction ="Loi khoi tao default ";
	
	public static String IS_PM ="Manager";
	public static String IS_STAFF ="Staff Of";
	public static String IS_BOD="BOD";
	
	public static int PM =5;
	public static int BOD =9;
	public static int Staff =8;

	
	public static int OverTime_Type_Before_21h = 1;
	public static int OverTime_Type_Between_21h_24h  = 2;
	public static int OverTime_Type_After_24h= 3;
	
	public static int Absence_Mor =1;
	public static int Absence_Aft =2;
	public static int Absence_All =3;
	
	public static int Absence_Stt_Pending =1;
	public static int Absence_Stt_OK =2;
	public static int Absence_Stt_NoOK =3;
	public static int Absence_Stt_Disabled =6;
	public static int Absence_No = 0;
	public static int Success =1;
	public static int Error =2;
	public static int Abs_Req_SentTo_BOD = 10;
	
	
	
	public static String Morning ="Sáng";
	public static String Afternoon ="Chiều";
	
	public static String Num_Day_Off_Each_Year =  "Nghỉ phép thường niên" ;
	public static String Num_Day_Off_OT = "Nghỉ bù tăng ca";
	public static String Num_Day_Off_Each_Year_Last_Year = "Nghỉ phép thường niên năm trước";
	public static String Num_Day_Off_Sick = "Nghỉ ốm";
	public static String  Num_Day_Off_Wedding = "Kết hôn";
	public static String Num_Day_Off_pregnant = "Khám thai" ;
	public static String Num_Day_Off_Have_Baby = "Sinh con";
	public static String Num_Day_Off_Child_Wedding ="Con kết hôn";
	public static String Num_Day_Off_funeral = "Đám tang";
	public static String Num_Day_Off_No_Payment = "Nghỉ không hưởng lương";
	public static String Num_Day_Off_Suddenly= "Nghỉ đột xuất";
	public static String Num_Day_Off_DOnt_Have_pers= "Nghỉ không phép";
	
	public static String View_Staff_Att_Info = "view_staff_att_info";
	public static String View_Personal_Att_Info = "view_personal_att_info";
	public static String Approve_TimeChange_Request = "approve_timechange_request";
	public static String View_Personal_Report = "view_personal_report";
	public static String View_Org_Att_Info = "view_org_att_info";
	public static String Authorized_Att = "authorized_att";
	public static String View_Org_TimeChange_Request = "view_org_timechange_request";
	public static String Manage_TimeChange_Request = "manage_timechange_request";
	public static String View_Staff_TimeChange_Request = "view_staff_timechange_request";
	public static String Config_Att = "config_att";
	public static String Update_Permission_Att = "update_permission_att";
	public static String View_General_Report = "view_general_report";
	public static String Update_Att_Info = "update_att_info";
	public static String View_Static_Personal = "view_static_personal";
	public static String Approve_OT_Report = "approve_ot_report";
	public static String Config_OT = "config_ot";
	public static String Manage_OT_Request = "manage_ot_request";
	public static String Manage_OT_Report = "manage_ot_report";
	public static String View_Personal_OT_Request = "view_personal_ot_request";
	public static String Approve_OT_Request = "approve_ot_request";
	public static String View_Org_OT_Request = "view_org_ot_request";
	public static String View_Org_OT_Report = "view_org_ot_report";
	public static String Update_Permission_OT = "update_permission_ot";
	public static String Authorized_OT = "authorized_ot";
	public static String Approve_Apecial_DayOff = "approve_special_ dayoff";
	public static String View_Staff_DayOff_Request = "view_staff_dayoff_request";
	public static String Manage_DayOff_Request = "manage_dayoff_request";
	public static String Config_DayOff = "config_dayoff";
	public static String Update_Permision_DayOff = "update_permision_dayoff";
	public static String View_Org_Dayoff_Request = "view_org_dayoff_request";
	public static String Approve_Vacation = "approve_vacation";
	public static String Authorized_DayOff = "authorized_dayoff";
	
	public static int Email_Time_Change_Request = 1;
	public static int Email_Confirm_Time_Change_Request = 2;
	public static int Email_Day_Off = 3;
	public static int Email_Confirm_Day_Off = 4;
	public static int Email_OT_Request = 5;
	public static int Email_Confirm_OT_request = 6;
	public static int  Email_OT_Report = 7;
	public static int Email_Confirm_OT_Report = 8;
	public static int Email_List_Of_Employee_Not_Check = 9;
	public static int  Email_Report_Aggregated_Info_Monthly = 10;
	public static int Email_Report_Aggregate_Info_Six_Months = 11;
	
	
	public static int Pers_Att =  0 ;
	public static int Pers_OverTime = 1;
	public static int Pers_Absence = 2;
	
	public static String App_Name = "Quan Ly Thoi Gian";
	public static int App_Id = 16;
	
	public static int Day_Normal = 0;
	public static int Day_Off = 1;
	public static int Day_Cele = 2;
	
	
}
