package com.larion.progate.lmis.action;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.utils.ProGateUtil;

import com.liferay.ibm.icu.text.DateFormat;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisViewStaffRootOrg;
import larion.progate.lmis.model.LmisViewStaffRootOrgOrdered;
import larion.progate.lmis.service.LmisAbsenceMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceYearlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttYearlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttendanceDailyLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgOrderedLocalServiceUtil;
import larion.progate.lmis.service.persistence.LmisAttendanceDailyFinderUtil;

public class StatisticAction extends ParameterizableViewAction{
	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		
		Calendar toDay = Calendar.getInstance();
		System.out.println("ngay hien tai la: "+toDay);
		int year = toDay.get(Calendar.YEAR);
		System.out.println("nam hien tai: "+year);
		int lastYear = year - 1;
		System.out.println("Nam truoc: "+lastYear);
		int month = (toDay.get(Calendar.MONTH)+1);
		System.out.println("Thang hien tai: "+ month);
		int lastMonth = month - 1;
		System.out.println("Thang truoc: "+ lastMonth);
		try {
			System.out.println("TESTTttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
			List<LmisViewStaffRootOrgOrdered> ls = LmisViewStaffRootOrgOrderedLocalServiceUtil.findAttCode(1501);
			System.out.println(ls.toString());
		} catch (Exception e) {
			System.out.println("Error in test");
		}
		try{
			Integer orgId=ParamUtil.getInteger(orgReq, "orgId",0);
			bean.put("orgId",orgId);
			if(orgId== 0){
				HttpServletRequest httpSR = PortalUtil
				.getHttpServletRequest(request);
				HttpServletRequest origReq = PortalUtil
				.getOriginalServletRequest(httpSR);

				orgId = ProGateUtil.getOrganizationId(origReq);
			}
			System.out.println("--orgId: "+orgId);
			
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			
			Date dayValue = LmisGeneralSettingsLocalServiceUtil.GetToday();
			Date dayYesterday =LmisGeneralSettingsLocalServiceUtil.GetYesterdayDate();
			//gio vao lam ngay hom nay
			Date realStartTime= LmisAttendanceDailyLocalServiceUtil.getStartTimeToday(userId,dayValue,orgId);
			System.out.println("---------------------------------------gio vao lam: "+realStartTime);
			bean.put("realStartTime", realStartTime);
			
			//lay so phut vao tre cua ngay hien tai
			int lateStartTime =(int) LmisAttendanceDailyLocalServiceUtil.getStartTimeLateToday(userId, dayValue, orgId);
			System.out.println("------------------so Phut di tre hom nay: "+lateStartTime);
			bean.put("lateStartTime",lateStartTime);
			
			//lay gio ve hom qua
			Date realEndTime = LmisAttendanceDailyLocalServiceUtil.getEndTimeYesterday(userId, dayYesterday, orgId);
			System.out.println("-----------------Gio ra ve hom qua: "+realEndTime );
			bean.put("realEndTime",realEndTime);
			
			//lay so phut ve som hom qua
			int earlyEndTime = (int) LmisAttendanceDailyLocalServiceUtil.getEndTimeEarlyYesterDay(userId, dayYesterday, orgId);
			System.out.println("---------------so Phut ve som hom qua: "+ earlyEndTime );
			bean.put("earlyEndTime",earlyEndTime);
			
			//tong so ngay da nghi 
			double totalDayOff = LmisAttendanceDailyLocalServiceUtil.getTotalDayOffInMonth_(userId, orgId);
			System.out.println("-----------tong so ngay da nghi: "+totalDayOff );
			bean.put("totalDayOff",totalDayOff);
			
			//tong so ngay nghi co phep
			String totalDayOffPermissionStr = LmisGeneralSettingsLocalServiceUtil.caculateTotalDayOffHavePermission(userId, month, year, orgId);
			double totalDayOffPermission = Double.parseDouble(totalDayOffPermissionStr);
			System.out.println("----------------tong so ngay nghi co phep: "+totalDayOffPermission);
			bean.put("totalDayOffPermission",totalDayOffPermission);
			
			//tong so ngay nghi ko phep
			double totalDayOffNotPermission = LmisAttendanceDailyLocalServiceUtil.caculateTotalDayOffDontHavePermission_(userId, orgId);
			System.out.println("---------------tong so ngay nghi ko phep: "+totalDayOffNotPermission);
			bean.put("totalDayOffNotPermission", totalDayOffNotPermission);
			
			///so gio tang ca hom qua
			double yesterdayOT = LmisViewRegistrationOvertimeLocalServiceUtil.getOtHourYesterday(userId, dayYesterday,orgId);
			System.out.println("-------------so gio tang ca hom qua: "+yesterdayOT);
			bean.put("yesterdayOT",yesterdayOT);
			
			//so gio ve som trong thang
			double earlyMonthEndTime = LmisAttMonthlyLocalServiceUtil.getTotalEndTimeEarly(userId, month, year, orgId)/60;
			System.out.println("-----------------so gio ve som trong thang: "+ earlyMonthEndTime );
			bean.put("earlyMonthEndTime",earlyMonthEndTime);
			
			//so gio di tre trong thang
			double lateMonthStartTime = LmisAttMonthlyLocalServiceUtil.getTotalStartTimeLately(userId, month, year, orgId)/60;
			System.out.println("-----------------so gio di tre trong thang: "+ lateMonthStartTime );
			bean.put("lateMonthStartTime", lateMonthStartTime);
			
			//nghi phep thuong nien nam truoc con lai
				//total loai "nghi phep thuong nien nam truoc"  co
			double dayOffLastYear = LmisGeneralSettingsLocalServiceUtil.getTotalDayAwardPrevYear(orgId, userId, year);
			bean.put("dayOffLastYear", dayOffLastYear);
				//loai "nghi phep thuong nien nam truoc" con lai 
			double dayOffLastYearRemain = LmisGeneralSettingsLocalServiceUtil.getTotalDayAwardPrevYearRemaining(orgId, userId, year);
			bean.put("dayOffLastYearRemain", dayOffLastYearRemain);
				//% nghi phep thuong nien nam nay da nghi/ con lai 
			if(dayOffLastYearRemain < 0){
				dayOffLastYearRemain =0;
			}
			bean.put("dayOffLastYearRemain",dayOffLastYearRemain);
			double percendayOffLastYear=0;
			if(dayOffLastYear != 0 ){
				percendayOffLastYear = (dayOffLastYearRemain/dayOffLastYear)*100;
			}
			bean.put("percendayOffLastYear", percendayOffLastYear);
			
			//tong so ngay gnhi bu tang ca co trong thang nay 
			double dayOffOT = LmisGeneralSettingsLocalServiceUtil.getTotalDayCompensation(orgId, userId, year, month);
			bean.put("dayOffOT",dayOffOT);
			//so gnay nghi bu tang ca con lai
			double dayOffOTRemain = LmisGeneralSettingsLocalServiceUtil.getTotalDayCompensationRemaining(orgId, userId, month, year);
			if(dayOffOTRemain < 0){
				dayOffOTRemain =0;
			}
			bean.put("dayOffOTRemain", dayOffOTRemain);
			double percenDayOffOT = 0;
			if(dayOffOT !=0){
				percenDayOffOT = dayOffOTRemain/dayOffOT *100;
			}
			bean.put("percenDayOffOT", percenDayOffOT);
			
			//tong so ngay nghi phep thuong nien nam nay
			int dayOffYear =(int) LmisGeneralSettingsLocalServiceUtil.getTotalDayAward(orgId, userId, year);
			bean.put("dayOffYear", dayOffYear);
			//nghi phep thuong nien con lai
			double dayOffYearRemain = LmisGeneralSettingsLocalServiceUtil.getTotalDayAwardRemaining(orgId, userId, year);
			if(dayOffYearRemain < 0){
				dayOffYearRemain = 0;
			}
			bean.put("dayOffYearRemain", dayOffYearRemain);
			double percenDayOffYear = 0;
			if(dayOffYear !=0){
				percenDayOffYear = dayOffYearRemain/dayOffYear *100;
			}
			bean.put("percenDayOffYear", percenDayOffYear);
			
			//lay ngay thay doi thoi gian lam viec (gan het han)
			String dayMax= LmisTimeChangeRequestsLocalServiceUtil.getMaxTimeChangeReqEndDate(orgId, userId);
			System.out.println("-------------------ngay max: "+dayMax);
			try{
				String [] day = dayMax.split("-");
				dayMax = day[2] + "/" + day[1] + "/" + day[0];
			}
			catch (NullPointerException e) {
				// TODO: handle exception
			}
			bean.put("dayMax", dayMax);
		}
		catch(SystemException e)
		{
			e.printStackTrace();
		}
	}
}