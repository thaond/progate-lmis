package com.larion.progate.lmis.action;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.utils.Functions;

import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.mozilla.javascript.Function;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateUtils;

import larion.progate.lmis.model.LmisAbsenceMonthly;
import larion.progate.lmis.model.LmisAttendanceDaily;
import larion.progate.lmis.service.LmisAbsenceMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttYearlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttendanceDailyLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisUtils;

public class PersonalStatisticalReportAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		//get rootId
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Calendar toDay = Calendar.getInstance();
		int yearCa = toDay.get(Calendar.YEAR);
		int year = ParamUtil.getInteger(request, "year",yearCa);
		System.out.println("--------------------------------------------------: "+year);
		bean.put("year", year);
		int lastYear = year - 1;
		int monthCa = toDay.get(Calendar.MONTH);
		int month = ParamUtil.getInteger(request, "month",monthCa);
		System.out.println("--------------------------------------------------: "+month);
		bean.put("month", month);
		int lastMonth = month - 1;
		String dayStr ="01"+"/"+ month + "/"+ year ;
		
		Date day = df.parse(dayStr) ;
		System.out.println("ngay :   "+day);
	
		try{
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			System.out.println(userId);
			
			String userName = LmisUtils.getFullNameByUID(userId);
			bean.put("userName", userName);
			
			int orgId=ParamUtil.getInteger(orgReq, "orgId");
			bean.put("orgId",orgId);
			System.out.println("-------------------------------orgId: "+orgId);
			if(orgId == 0){
				orgId=ParamUtil.getInteger(request, Request.ORG_ID);
				System.out.println("---------action orgId: "+ orgId);
				bean.put("orgId",orgId);
			}
			
			//gio bat dau lam viec trug binh trong thang
			Date monthStartTimeAvg = LmisAttMonthlyLocalServiceUtil.getMonthStartTimeAvg(userId, month, year, orgId);
			System.out.println("gio bat dau lam viec trung binh trong thang: "+monthStartTimeAvg);
			bean.put("monthStartTimeAvg",monthStartTimeAvg);
			
			//gio bat dau lam viec trug binh trong nam
			Date yearStartTimeAvg = LmisAttYearlyLocalServiceUtil.getYearStartTimeAvg(userId, year, orgId);
			System.out.println("gio bat dau lam viec trong nam: "+yearStartTimeAvg);
			bean.put("yearStartTimeAvg",yearStartTimeAvg);
			
			//gio ket thuc lam viec trug binh trong thang
			Date monthEndTimeAvg = LmisAttMonthlyLocalServiceUtil.getMonthEndTimeAvg(userId, month, year, orgId);
			System.out.println("gio ket thuc trug binh cua thang: "+monthEndTimeAvg);
			bean.put("monthEndTimeAvg",monthEndTimeAvg);
			
			//gio ket thuc lam viec trung binh trong nam
			Date yearEndTimeAvg = LmisAttYearlyLocalServiceUtil.getYearEndTimeAvg(userId, year, orgId);
			System.out.println("gio ket thuc trung binh trong nam: "+  yearEndTimeAvg);
			bean.put("yearEndTimeAvg",yearEndTimeAvg);
			
			//tong thoi gian lam viec (ngay)
			int totalWorkDay = LmisAttYearlyLocalServiceUtil.getYearTotalWorkingDate(userId, year, orgId);
			System.out.println("tong thoi gian lam viec: "+totalWorkDay);
			bean.put("totalWorkDay",totalWorkDay);
 
			//so phut di tre trong thang
			int monthLate = LmisAttMonthlyLocalServiceUtil.getTotalStartTimeLately(userId, month, year, orgId);
			System.out.println("so phut di tre trong thag: "+monthLate);
			bean.put("monthLate",monthLate);
		
			//so phut di tre bi phat chua nhan he so
			int monthLatePer = LmisAttMonthlyLocalServiceUtil.getTotalStartTimeLatePernalty(userId, month, year, orgId);
			System.out.println("so phut di tre bi phat chua nhan he so: "+monthLatePer);
			bean.put("monthLatePer",monthLatePer);
			
			//so phut di tre bi phat da nhan he so
			double monthLateFinalDou = LmisAttMonthlyLocalServiceUtil.getTotalStartTimeLateFinal(userId, month, year, orgId);
			System.out.println("so phut di tre bi phat da nhan he so: "+monthLateFinalDou);
			monthLateFinalDou = Functions.roundNumber(monthLateFinalDou, 0);
			int monthLateFinal = (int)monthLateFinalDou;
			bean.put("monthLateFinal",monthLateFinal);
			
			//so phut ve som trong thang
			int monthEarly = LmisAttMonthlyLocalServiceUtil.getTotalEndTimeEarly(userId, month, year, orgId);
			System.out.println("So phut ve som trong thang: "+monthEarly);
			bean.put("monthEarly",monthEarly);
			
			//So phut ve som bi phat chua nhan he so
			int monthEarlyPer = LmisAttMonthlyLocalServiceUtil.getTotalEndTimeEarlyPernalty(userId, month, year, orgId);
			System.out.println("So phut ve som chua nhan he so: "+monthEarlyPer);
			bean.put("monthEarlyPer",monthEarlyPer);
			
			//so phut ve som bi phat da nhan he so
			double monthEarlyFinalDou = LmisAttMonthlyLocalServiceUtil.getTotalEndTimeEarlyFinal(userId, month, year, orgId);
			System.out.println("so phut di tre da nhan he so: "+monthEarlyFinalDou);
			monthEarlyFinalDou = Functions.roundNumber(monthEarlyFinalDou, 0);
			int monthEarlyFinal = (int)monthEarlyFinalDou;
			bean.put("monthEarlyFinal",monthEarlyFinal);
			
			//tong so thoi gian tang ca trong thang
			double monthOT = LmisAttMonthlyLocalServiceUtil.getTotalOverTime(userId, month, year, orgId);
			System.out.println("thoi gian tang ca trong thang: "+ monthOT);
			bean.put("monthOT",monthOT);
			
			//tong so thoi gian tang ca da nhan he so
			double monthOTFinal = LmisAttMonthlyLocalServiceUtil.getTotalOverTimeFinal(userId, month, year, orgId);
			System.out.println("Tong so thoi gian tang ca da nhan he so: "+monthOTFinal);
			bean.put("monthOTFinal",monthOTFinal);
			
			//So ngay nghi bu tag ca tog cog trog thag
			double monthDayComp = LmisAttMonthlyLocalServiceUtil.getTotalDayCompensation(userId, lastMonth, year, orgId);
			System.out.println("so ngay nghi bu tang ca tog cog trog thag: "+monthDayComp);
			bean.put("monthDayComp",monthDayComp);
			
			//so ngay nghi bu tang ca da nghi trog thag
			double monthDayOffComp = LmisAttMonthlyLocalServiceUtil.getTotalDayOffCompensation(userId, month, year, orgId);
			System.out.println("so ngay nghi bu tag ca da nghi: "+ monthDayOffComp);
			bean.put("monthDayOffComp",monthDayOffComp);
			
			//so ngay nghi bu tag ca con lai trog thag -------------------------------------------------------chu y thang hien tai hay thang truoc
			double monthDayCompRemain = LmisAttMonthlyLocalServiceUtil.getTotalDayCompensationRemain(userId, month, year, orgId);
			System.out.println("so ngay nghi bu tang ca con lai trong thang: "+monthDayCompRemain );
			bean.put("monthDayCompRemain",monthDayCompRemain);
			
			//so ngay gnhi bu tag ca cho thag sau
			double nextMonthDayComp = LmisAttMonthlyLocalServiceUtil.getTotalDayCompensationNextMOnth(userId, month, year, orgId);
			System.out.println("so ngay nghi bu tang ca cho thag sau: "+ nextMonthDayComp );
			bean.put("nextMonthDayComp",nextMonthDayComp);
			
			//so gio thuong/so gio phat
			double timeFinalDou= LmisAttMonthlyLocalServiceUtil.getTotalTimeFinal(userId, month, year, orgId);
			System.out.println("So gio thuong: "+timeFinalDou );
			timeFinalDou = Functions.roundNumber(timeFinalDou, 0);
			int timeFinal = (int)timeFinalDou;
			bean.put("timeFinal",timeFinal);
			
			//tong so ngay da nghi
			double monthDayOff = LmisAttMonthlyLocalServiceUtil.getTotalDayOffInMonth(userId, month, year, orgId);
			System.out.println("tong so ngay da nghi: "+monthDayOff);
			bean.put("monthDayOff",monthDayOff);
			
			//so ngay nghi co phep
			double monthDayOffPer =Double.parseDouble(LmisGeneralSettingsLocalServiceUtil.caculateTotalDayOffHavePermission(userId, month, year, orgId));
			System.out.println("so ngay nghi co phep: "+monthDayOffPer);
			bean.put("monthDayOffPer",monthDayOffPer);
			
			//so ngay nghi ko phep
			double monthDayOffNotPer = Double.parseDouble(LmisGeneralSettingsLocalServiceUtil.caculateTotalDayOffDontHavePermission(userId, month, year, orgId));
			System.out.println("so ngay nghi ko phep: "+monthDayOffNotPer);
			bean.put("monthDayOffNotPer",monthDayOffNotPer);
			
			// chi tiet ngay nghi
			List<LmisAttendanceDaily> detailDayOff = LmisAttendanceDailyLocalServiceUtil.getListDetailsDayOff(orgId, userId, day);
			System.out.println("chi tiet ngay nghi"+detailDayOff);
			bean.put("detailDayOff",detailDayOff);
			
			//thong ke cac loai ngay nghi
			List<LmisAbsenceMonthly> typeDayOff = LmisAbsenceMonthlyLocalServiceUtil.getStatisticTypeDayOff(userId, month, year, orgId);
			System.out.println("thong ke cac loai ngay nghi: "+typeDayOff );
			bean.put("typeDayOff",typeDayOff);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}