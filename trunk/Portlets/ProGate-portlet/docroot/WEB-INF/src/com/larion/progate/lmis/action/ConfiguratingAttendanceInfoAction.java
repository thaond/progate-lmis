package com.larion.progate.lmis.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.compass.core.util.backport.java.util.Arrays;

import larion.progate.lmis.model.LmisEmailSettings;
import larion.progate.lmis.model.LmisGeneralSettings;
import larion.progate.lmis.model.LmisViewEmailSettingDetailOrg;
import larion.progate.lmis.model.LmisViewEmailSettingDetailUser;
import larion.progate.lmis.model.LmisViewStaffRootOrgFN;
import larion.progate.lmis.model.LmisViewStaffRootOrgOrdered;
import larion.progate.lmis.model.LmisViewWorkingCalendar;
import larion.progate.lmis.model.LmisWorkingTimes;
import larion.progate.model.Organization;
import larion.progate.lmis.service.LmisEmailSettingDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisEmailSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailOrgLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailUserLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgFNLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgOrderedLocalServiceUtil;
import larion.progate.lmis.service.LmisViewWorkingCalendarLocalServiceUtil;
import larion.progate.lmis.service.LmisWorkingCalendarsLocalServiceUtil;
import larion.progate.lmis.service.LmisWorkingTimesLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;
import com.larion.progate.lmis.constants.Configuration_RS;
import com.larion.progate.lmis.constants.LmisRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
	
public class ConfiguratingAttendanceInfoAction extends ParameterizableViewAction  {
		
		@Override
		public void handleActionRequestInternal(ActionRequest request, ActionResponse response, Map<String, Object> bean) throws Exception {
		
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Integer orgId=ParamUtil.getInteger(orgReq, "orgId");
		if(orgId==0){
			orgId= ParamUtil.getInteger(request, "orgId");
		}
		bean.put("orgId", orgId);
		//response data when use AJAX
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		res.setCharacterEncoding("UTF-8");
		PrintWriter output = res.getWriter();
		
		int emailCategory = 1;
		int defaultEmailType = LmisEmailSettingsLocalServiceUtil.getListEmailSettingDefault(orgId, emailCategory, "1");
		int emailTypeId = ParamUtil.get(request, Configuration_RS.SELECT_EMAIL_TYPE ,defaultEmailType );
		
		//get and show all granted emails of org
		try{
			List<LmisViewEmailSettingDetailOrg> lmisViewEmailSettingDetailOrgs = LmisViewEmailSettingDetailOrgLocalServiceUtil.getListEmailOrgRelated(orgId, emailTypeId);		
			bean.put("lmisViewEmailSettingDetailOrgs", lmisViewEmailSettingDetailOrgs);
			StringBuffer xmlOrg = new StringBuffer();
			xmlOrg.append("<?xml version=\"1.0\"?>\n");
			xmlOrg.append("<LmisOrgEmail>\n");
			
			for(LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : lmisViewEmailSettingDetailOrgs){
				xmlOrg.append("<OrgRelatedId>");
				xmlOrg.append(lmisViewEmailSettingDetailOrg.getOrgRelatedId());
				xmlOrg.append("</OrgRelatedId>\n");
			}
			for(LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : lmisViewEmailSettingDetailOrgs){
				xmlOrg.append("<OrgRelatedEmail>");
				xmlOrg.append(lmisViewEmailSettingDetailOrg.getEmailOrg());
				xmlOrg.append("</OrgRelatedEmail>\n");
			}
			xmlOrg.append("</LmisOrgEmail>\n");
			output.print(xmlOrg.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		// get and show all granted emails of user
		try{
			List<LmisViewEmailSettingDetailUser> lmisViewEmailSettingDetailUsers = LmisViewEmailSettingDetailUserLocalServiceUtil.getListEmailUserRelated(orgId, emailTypeId);
			bean.put("lmisViewEmailSettingDetailUsers", lmisViewEmailSettingDetailUsers);
			
			StringBuffer xmlUser = new StringBuffer();
			
			xmlUser.append("<?xml version=\"1.0\"?>\n");
			xmlUser.append("<LmisUserEmail>\n");
			
			for(LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : lmisViewEmailSettingDetailUsers ){
				xmlUser.append("<UserId>");
				xmlUser.append(lmisViewEmailSettingDetailUser.getUserRelatedId());
				xmlUser.append("</UserId>\n");
			}
			for(LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : lmisViewEmailSettingDetailUsers ){
				xmlUser.append("<UserEmail>");
				xmlUser.append(lmisViewEmailSettingDetailUser.getEmailUser());
				xmlUser.append("</UserEmail>\n");
			}
			xmlUser.append("</LmisUserEmail>\n");
			output.print(xmlUser.toString());
			}
			catch(Exception e){
				e.printStackTrace();
		}
	}
	@Override
	public void handleRenderRequestInternal(RenderRequest request, RenderResponse response, Map<String, Object> bean) throws Exception {
		/*********************/
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		res.setCharacterEncoding("UTF-8");
		PrintWriter output = res.getWriter();
		/*********************/
		
		
		//get rootId
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Integer orgId=ParamUtil.getInteger(orgReq, "orgId");
		if(orgId==0){
			orgId= ParamUtil.getInteger(request, "orgId");
		}
		bean.put("orgId", orgId);
		
		String tabAction = ParamUtil.getString(request, Request.TAB_ACTION, Request.EMAIL_TAB);
		bean.put("tabAction", tabAction);
			
		int appId =LmisConst.App_Id;
		String appName = LmisConst.App_Name;
		Integer userId=0;
		int category =LmisConst.Pers_Att;
		String perId = LmisConst.Config_Att;
		String cmd=ParamUtil.getString(request, Constants.CMD);
		bean.put("cmd",cmd);
		
		String role=null;
		try{
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			userId = userIdTemp.intValue();
			role =  LmisUtils.getUserRoleByUID(userId,orgId);//get role of user by user id, org id
			bean.put("role", role);
			String userName=LmisUtils.getFullNameByUID(userId);
			bean.put("userName",userName );
		}catch (Exception e){
			e.printStackTrace();
		}
		int permission = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, category, orgId, userId,  perId);
		System.out.println("-------------------------DEBUG PERMISSION....");
		System.out.println(permission);
		System.out.println("-------------------------DEBUG PERMISSION....");
		bean.put("permission", permission);
		// check all fields is enable or disable
		boolean disable = ParamUtil.getBoolean(request, "disable", false);
		bean.put("disable", disable);
		
		int emailCategory = 1;
		int defaultEmailType = LmisEmailSettingsLocalServiceUtil.getListEmailSettingDefault(orgId, emailCategory, "1");
//*********************************************************************************************************************
	try{
		// process for Email Tab
		if (Request.EMAIL_TAB.equals(tabAction)) {
			// update config email
			if(Constants.UPDATE.equals(cmd)){
				int emailSettingId = ParamUtil.getInteger(request, "emailSettingId");
				
				int [] arrUserId = ParamUtil.getIntegerValues(request, "listUserId");
				int [] arrOrgId =	ParamUtil.getIntegerValues(request, "listOrgId");
				
				Integer[] myOrgId = new Integer[arrOrgId.length];		
				int i = 0;
				for(int val : arrOrgId) myOrgId[i++] = val;	
				
				Integer[] myUserId = new Integer[arrUserId.length];
				int j = 0;
				for(int val : arrUserId) myUserId[j++] = val;		
				
				ArrayList<Integer> arrayUserId = new ArrayList<Integer> (Arrays.asList(myUserId));
				ArrayList<Integer> arrayOrgId = new ArrayList<Integer> (Arrays.asList(myOrgId));
			
				try{
					LmisEmailSettingDetailsLocalServiceUtil.updateEmailSettingDetail(orgId, emailSettingId, arrayOrgId, arrayUserId);
				}
				catch(Exception e){
					e.printStackTrace();
				}			
			}
					
			List<LmisEmailSettings> lmisEmailSettings =LmisEmailSettingsLocalServiceUtil.getListEmailSetting(orgId, emailCategory);//get all email type name of attendance info
			bean.put("lmisEmailSettings", lmisEmailSettings);
					
			//get all list granted email of org with relevant email type                                           
			int emailTypeId = ParamUtil.get(request, Configuration_RS.SELECT_EMAIL_TYPE ,defaultEmailType );
			bean.put("emailTypeId", emailTypeId);
			
			//get and show all granted emails of org
			List<LmisViewEmailSettingDetailOrg> lmisViewEmailSettingDetailOrgs = LmisViewEmailSettingDetailOrgLocalServiceUtil.getListEmailOrgRelated(orgId, emailTypeId);
			bean.put("lmisViewEmailSettingDetailOrgs", lmisViewEmailSettingDetailOrgs);
			System.out.println("-------------------DEBUG GRANTED EMAILS OF ORG");
			System.out.println(lmisViewEmailSettingDetailOrgs.toString());
			System.out.println("-------------------DEBUG GRANTED EMAILS OF ORG");
			//get and show all granted emails of user
			List<LmisViewEmailSettingDetailUser> lmisViewEmailSettingDetailUsers = LmisViewEmailSettingDetailUserLocalServiceUtil.getListEmailUserRelated(orgId, emailTypeId);
			bean.put("lmisViewEmailSettingDetailUsers", lmisViewEmailSettingDetailUsers);
			System.out.println("-------------------DEBUG GRANTED EMAILS OF USER");
			System.out.println(lmisViewEmailSettingDetailUsers.toString());
			System.out.println("-------------------DEBUG GRANTED EMAILS OF USER");

			//get list emails of organization
			List<Organization> organizations = LmisUtils.getOrganizationByRootId(orgId);
			bean.put("organizations", organizations);

			// get list emails of staff
			List<LmisViewStaffRootOrgFN> lmisViewStaffRootOrgFNs = LmisViewStaffRootOrgFNLocalServiceUtil.findstaff(orgId);
			bean.put("lmisViewStaffRootOrgFNs",lmisViewStaffRootOrgFNs);
			
			int countUser = lmisViewStaffRootOrgFNs.size();
			int countOrg = organizations.size();
			bean.put("countUser", countUser);
			bean.put("countOrg", countOrg);
							
		}
//*********************************************************************************************************************
		// process for Working Time Tab
		if (Request.WORKINGTIME_TAB.equals(tabAction)) {
				int lmisWorkingTimeID = ParamUtil.get(request, Configuration_RS.SESSION_NAME , -1);
				List<LmisWorkingTimes> lmisWorkingTimesList = LmisWorkingTimesLocalServiceUtil.findByWorkingTimeOf(orgId);
				LmisWorkingTimes lmisWorkingTimes = null;
				
				if (lmisWorkingTimeID == -1) {
					lmisWorkingTimes = lmisWorkingTimesList.get(0);
				} else {
					for (LmisWorkingTimes _lmisWorkingTimes : lmisWorkingTimesList) {
						if (_lmisWorkingTimes.getLmisWorkingTimeId() == lmisWorkingTimeID) {
							lmisWorkingTimes = _lmisWorkingTimes;
							break;
						}
					}
				}
			// process update data for working time
			if(Constants.SAVE.equals(cmd)){
				saveWorkingTime(request, bean, lmisWorkingTimes, cmd);
			}
			bean.put("lmisWorkingTimeID", lmisWorkingTimeID);
			bean.put("lmisWorkingTimes", lmisWorkingTimes);
			bean.put("lmisWorkingTimesList", lmisWorkingTimesList);

		}
//*********************************************************************************************************************
		// process for Calendar Tab
		if (Request.CALENDAR_TAB.equals(tabAction)) {
			
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			//add a holiday 
			if(Constants.ADD.equals(cmd)){
				Date holidayDate = ParamUtil.getDate(request, Configuration_RS.DATE_TIME,formatter);
				System.out.println("-------------------DEBUG CALENDAR------------------------------");
				String description = ParamUtil.getString(request, Configuration_RS.DESCRIPTION );
				int dayType = ParamUtil.getInteger(request, Configuration_RS.SELECT_HOLIDAY);
				System.out.println("ngay nghi "+holidayDate);
				System.out.println("day type "+ dayType);
				System.out.println("description " + description);
				System.out.println("orgId "+ orgId);
				System.out.println("-------------------DEBUG CALENDAR------------------------------");
				LmisWorkingCalendarsLocalServiceUtil.addWorkingCalendar(orgId, holidayDate, dayType, description);
		
			}
			//delete a holiday			
			if(Constants.DELETE.equals(cmd)){
				int lmisWorkingCalendarId =  ParamUtil.getInteger(request,Configuration_RS.CALENDAR_ID);
				try{
				LmisWorkingCalendarsLocalServiceUtil.deleteWorkingCalendar(orgId,lmisWorkingCalendarId);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			// get data from database to table
			Calendar calendar = Calendar.getInstance();
			int currentYear = calendar.get(Calendar.YEAR);
			int selectedMonth = ParamUtil.getInteger(request, Configuration_RS.SELECT_MONTH,	calendar.get(Calendar.MONTH)+1);
			int currentYearSelected = ParamUtil.getInteger(request, Configuration_RS.SELECT_YEAR,	currentYear);
			System.out.println("---------------------DEBUG VIEW CALENDAR-----------------------");
			
			System.out.println("selected year "+ currentYearSelected);
			System.out.println("---------------------DEBUG VIEW CALENDAR-----------------------");
			String lmisCalendarDate = "02/" + selectedMonth + "/" + currentYearSelected;
			
			bean.put("selectedMonth", selectedMonth);
			bean.put("currentYearSelected", currentYearSelected);
			List<LmisViewWorkingCalendar> lmisViewWorkingCalendar = LmisViewWorkingCalendarLocalServiceUtil.getListWorkingCalendar(orgId, formatter.parse(lmisCalendarDate));
			PaginationObject pagination = new PaginationObject("lmisAbsence",lmisViewWorkingCalendar.size());
			pagination.paging(request);
			bean.put("pagination", pagination);
			lmisViewWorkingCalendar = lmisViewWorkingCalendar.subList(pagination.getStartIndex(), pagination.getEndIndex());
			bean.put("lmisViewWorkingCalendar", lmisViewWorkingCalendar);
				
		}
		
//********************************************************************************************************
		// process for Attendance Code Tab
		if (Request.ATTENDANCECODE_TAB.equals(tabAction)) {
			int UserId = ParamUtil.getInteger(request, "UserId", -1);
			String Code = ParamUtil.getString(request, "code", null);
			System.out.println("------------------------------DEBUG ATTCODE-------------------");
			System.out.println(UserId);
			System.out.println(Code);
			System.out.println("------------------------------DEBUG ATTCODE-------------------");
			System.out.println("Dzo Process Code Tab");
			String cancel = ParamUtil.getString(request, Constants.CMD, "-1");
			if (orgId == -1) {

			} else {
				System.out.println("dzo if");
				if (cancel.equals("-1") || cancel.equals(Constants.CANCEL)) {
					try {
						List<LmisViewStaffRootOrgOrdered> lsResult = LmisViewStaffRootOrgOrderedLocalServiceUtil.findAttCode(orgId);
						PaginationObject pagination = new PaginationObject("lmisAbsence",lsResult.size());
						pagination.paging(request);
						bean.put("pagination", pagination);
						lsResult = lsResult.subList(pagination.getStartIndex(), pagination.getEndIndex());
						bean.put("lsResult", lsResult);
						bean.put("orgId", orgId);
						bean.put("tabAction", tabAction);
					} catch (Exception e) {
						System.out.println("Error ConfiguratingAction.handleRenderRequestInternal"
										+ e.toString());
						e.printStackTrace();
					}
				} if(cancel.equals(Constants.EDIT)) {
					int errCode = LmisViewStaffRootOrgFNLocalServiceUtil.editScanncerCode(orgId, UserId, Code);
					try{
						StringBuffer ok = new StringBuffer();
						ok.append("<?xml version=\"1.0\"?>\n");
						ok.append("<success>\n");
						ok.append(errCode);
						ok.append("</success>\n");
						output.print(ok.toString());
					}
					catch(Exception e){
						e.printStackTrace();
					}
					bean.put("errCode", errCode);
					List<LmisViewStaffRootOrgOrdered> lsResult = LmisViewStaffRootOrgOrderedLocalServiceUtil.findAttCode(orgId);
					PaginationObject pagination = new PaginationObject("lmisAbsence",lsResult.size());
					pagination.paging(request);
					bean.put("pagination", pagination);
					lsResult = lsResult.subList(pagination.getStartIndex(), pagination.getEndIndex());
					bean.put("lsResult", lsResult);
					bean.put("lsResult", lsResult);
					bean.put("tabAction", tabAction);
					bean.put("orgId", orgId);
					System.out.println("Dzo Process Code Tab 2");
				}
			}
		}
		if (Request.ATTENDANCE_INFO_FILE_TAB.equals(tabAction)) {	
			if(Constants.SAVE.equals(cmd)){
				String attCode = ParamUtil.getString(request, "attCode");
				String staffName = ParamUtil.getString(request, "staffName");
				String checkIn = ParamUtil.getString(request, "checkIn");
				String checkOut = ParamUtil.getString(request, "checkOut");
				LmisGeneralSettingsLocalServiceUtil.updateInfoConfigFileAttendance(orgId, attCode, staffName, checkIn, checkOut);
			}
			List<LmisGeneralSettings> listName = LmisGeneralSettingsLocalServiceUtil.getInfoConfigFileAttendance(orgId);
			if(listName!= null){
				bean.put("attCode", listName.get(0).getName());
				bean.put("staffName", listName.get(1).getName());
				bean.put("checkIn", listName.get(2).getName());
				bean.put("checkOut", listName.get(3).getName());
			}
			
		}
	}catch(Exception e){
		e.printStackTrace();
	}
		bean.put("emailTab", Request.EMAIL_TAB);
		bean.put("workingTimeTab", Request.WORKINGTIME_TAB);
		bean.put("calendarTab", Request.CALENDAR_TAB);
		bean.put("attendanceCodeTab", Request.ATTENDANCECODE_TAB);
		bean.put("attendanceInfoFileTab", Request.ATTENDANCE_INFO_FILE_TAB);
		
		bean.put("PER_BOD", LmisRequest.PER_BOD);
		bean.put("PER_PM", LmisRequest.PER_PM);
		bean.put("PER_STAFF", LmisRequest.PER_STAFF);
	}

	//****************************************************************************

// process for saving Working Time
	
 /**
 * @param request
 * @param bean
 * @param lmisWorkingTimes
 * @param cmd
 * @throws ParseException
 */
public void saveWorkingTime(RenderRequest request,	Map<String, Object> bean, LmisWorkingTimes lmisWorkingTimes,
			String cmd) throws ParseException {
		if (Constants.SAVE.equals(cmd)) {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			String startTime = ParamUtil.getString(request,
					Configuration_RS.START_TIME_HOUR)
					+ ":"
					+ ParamUtil.getString(request,
							Configuration_RS.START_TIME_MINUTE);

			String endTime = ParamUtil.getString(request,
					Configuration_RS.END_TIME_HOUR)
					+ ":"
					+ ParamUtil.getString(request,
							Configuration_RS.END_TIME_MINUTE);

			lmisWorkingTimes.setStartTime(df.parse(startTime));
			lmisWorkingTimes.setEndTime(df.parse(endTime));
			lmisWorkingTimes.setLimitEarly(ParamUtil.get(request, Configuration_RS.LIMIT_EARLY,	lmisWorkingTimes.getLimitEarly()));
			lmisWorkingTimes.setLimitLate(ParamUtil.get(request, Configuration_RS.LIMIT_LATE, lmisWorkingTimes.getLimitLate()));
			lmisWorkingTimes.setMaxEarly(ParamUtil.get(request, Configuration_RS.MAX_EARLY,	lmisWorkingTimes.getMaxEarly()));
			lmisWorkingTimes.setMaxLate(ParamUtil.get(request, Configuration_RS.MAX_LATE, lmisWorkingTimes.getMaxLate()));
			lmisWorkingTimes.setCoefficientEarly(ParamUtil.get(request,	Configuration_RS.COEFFICIENT_EARLY,	lmisWorkingTimes.getCoefficientEarly()));
			lmisWorkingTimes.setCoefficientLate(ParamUtil.get(request, Configuration_RS.COEFFICIENT_LATE, lmisWorkingTimes.getCoefficientLate()));

			LmisWorkingTimesLocalServiceUtil.editLmisWorkingTimes(lmisWorkingTimes);
		}
	}
}
