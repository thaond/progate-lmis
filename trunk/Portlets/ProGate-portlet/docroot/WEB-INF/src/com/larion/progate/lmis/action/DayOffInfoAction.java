package com.larion.progate.lmis.action;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;

import com.larion.progate.common.bean.PaginationObject;

import com.liferay.portal.kernel.util.Constants;
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

import larion.progate.lmis.model.LmisAbsenceRequests;
import larion.progate.lmis.service.LmisAbsenceMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceYearlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttYearlyLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

public class DayOffInfoAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Calendar toDay = Calendar.getInstance();
		int year = toDay.get(Calendar.YEAR);
		System.out.println("nam hien tai: "+year);
		int lastYear = year - 1;
		System.out.println("Nam truoc: "+lastYear);
		int month = (toDay.get(Calendar.MONTH)+1);
		System.out.println("Thang hien tai: "+ month);
		int lastMonth = month - 1;
		System.out.println("Thang truoc: "+ lastMonth);
		
		try{
			String tabAction = ParamUtil.getString(request, Request.TAB_ACTION,Request.TAB_PERSONAL);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);
			String cmd=ParamUtil.getString(request, Constants.CMD,"null");
			bean.put("cmd", cmd);
			
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			System.out.println(userId);
			String userName=LmisUtils.getFullNameByUID(userId);
			bean.put("userName",userName );

			Integer orgId=ParamUtil.getInteger(orgReq, "orgId");
			bean.put("orgId",orgId);
			System.out.println("--orgId: "+orgId);
			
			if (orgId==0){
				orgId=ParamUtil.getInteger(request, Request.ORG_ID);
				bean.put("orgId", orgId);
				System.out.println("---tabpersion orgId: "+orgId);
			}
			

			//check if user is permited or not
			int appId = LmisConst.App_Id;
			String appName = LmisConst.App_Name;
			int categoryId =  LmisConst.Pers_Absence;
			String viewPersionId = LmisConst.Manage_DayOff_Request; //tab persion
			String approveById = LmisConst.View_Staff_DayOff_Request; //tab manager
			String viewOrgId = LmisConst.View_Org_Dayoff_Request; //tab other
			int tabPersion = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, categoryId, orgId, userId, viewPersionId);
			int tabManager = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, categoryId, orgId, userId, approveById);
			int tabOther = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, categoryId, orgId, userId, viewOrgId);
			System.out.println("----------------------debug---Quyen------------------------");
			System.out.println("tab ca nhan: "+ tabPersion);
			System.out.println("tab quan ly: "+ tabManager);
			System.out.println("tab khac: "+ tabOther);
			System.out.println("---------------------end debug--------------------------------");
			bean.put("tabPersion", tabPersion);
			bean.put("tabManager", tabManager);
			bean.put("tabOther", tabOther);
			
			//tong so ngay nghi phep thuong nien nam nay
			int dayOffYear = (int)LmisGeneralSettingsLocalServiceUtil.getTotalDayAward(orgId, userId, year);
			bean.put("dayOffYear", dayOffYear);
			//nghi phep thuong nien con lai
			double dayOffYearRemain = LmisGeneralSettingsLocalServiceUtil.getTotalDayAwardRemaining(orgId, userId, year);
			if(dayOffYearRemain <0){
				dayOffYearRemain=0;
			}
			bean.put("dayOffYearRemain", dayOffYearRemain);
			double percenDayOffYear = 0;
			if(dayOffYear !=0){
				percenDayOffYear = dayOffYearRemain/dayOffYear *100;
			}
			bean.put("percenDayOffYear", percenDayOffYear);
			
			//nghi phep thuong nien nam truoc
				//total loai "nghi phep thuong nien nam truoc"  co
			double dayOffLastYear = LmisGeneralSettingsLocalServiceUtil.getTotalDayAwardPrevYear(orgId, userId, year);
			bean.put("dayOffLastYear", dayOffLastYear);
			
			//% nghi phep thuong nien nam nay da nghi/ con lai 
			//loai "nghi phep thuong nien nam truoc" con lai 
			double dayOffLastYearRemain = LmisGeneralSettingsLocalServiceUtil.getTotalDayAwardPrevYearRemaining(orgId, userId, year);
			bean.put("dayOffLastYearRemain", dayOffLastYearRemain);
			if(dayOffLastYearRemain < 0){
				dayOffLastYearRemain =0;
			}
			bean.put("dayOffLastYearRemain",dayOffLastYearRemain);
			double percendayOffLastYear=0;
			if(dayOffLastYearRemain != 0 ){
				percendayOffLastYear = (dayOffLastYearRemain/dayOffLastYear)*100;
			}
			bean.put("percenDayOffLastYear", percendayOffLastYear);
			
			
			
			//tong so ngay nghi bu tang ca co trong thang nay lay tu cot next month trong thang truoc
			double dayOffOT = LmisGeneralSettingsLocalServiceUtil.getTotalDayCompensation(orgId, userId, year, month);
			bean.put("dayOffOT",dayOffOT);
			
			//so gnay nghi bu tang ca con lai
			double dayOffOTRemain = LmisGeneralSettingsLocalServiceUtil.getTotalDayCompensationRemaining(orgId, userId, month, year);
			if(dayOffOTRemain < 0){
				dayOffOTRemain = 0;
			}
			bean.put("dayOffOTRemain", dayOffOTRemain);
			double percenDayOffOT = 0;
			if(dayOffOT !=0){
				percenDayOffOT = dayOffOTRemain/dayOffOT *100;
			}
			bean.put("percenDayOffOT", percenDayOffOT);
			
			
			List<LmisAbsenceRequests> listAbsence = LmisAbsenceRequestsLocalServiceUtil.getListAbsenceReqUser(orgId, userId);
			System.out.println("---------list nghi phep: "+ listAbsence);
			PaginationObject pagination = new PaginationObject("lmis",listAbsence.size());
			pagination.paging(request); 
			listAbsence = listAbsence.subList(pagination.getStartIndex(), pagination.getEndIndex());
			bean.put("pagination", pagination);
			bean.put("listAbsence",listAbsence);
			bean.put("size", listAbsence.size());
			System.out.println("---------$$$$$$$$$$$$$$$$$$$list nghi phep da cat: "+ listAbsence);
			
		}catch (Exception e){
			e.printStackTrace();
		}
		bean.put("TAB_PERSONAL", Request.TAB_PERSONAL);
		bean.put("TAB_MANAGER", Request.TAB_MANAGER);
		
		bean.put("UNDO", Request.UNDO_HANDER);
	}
}