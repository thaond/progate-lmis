package com.larion.progate.lmis.controllers;

import com.larion.progate.common.constants.Request;

import com.liferay.ibm.icu.text.DateFormat;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisAbsenceRequests;
import larion.progate.lmis.model.LmisAbsenceSettings;
import larion.progate.lmis.service.LmisAbsenceRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisAttMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class ManagerDayOffInfoController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Map<String,Object>bean = new HashMap<String,Object>();
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yy");
		Date date = new Date();
		
		try{
			bean.put("date", date);
			String tabAction=ParamUtil.getString(request, Request.TAB_ACTION);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);

			String cmd=ParamUtil.getString(request, Constants.CMD);
			System.out.println("hander---- "+cmd);
			bean.put("cmd", cmd);
			
			int selectedId = ParamUtil.getInteger(request, Request.SELECTED_ID);
			System.out.println("----------id dc chon: "+ selectedId);
			bean.put("selectedId",selectedId);
			
			String currentHander = ParamUtil.getString(request, "currentHander");
			System.out.println("hander hientai dang la: "+ currentHander);
			bean.put("currentHander", currentHander);

			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			System.out.println(userId);
			String userName= LmisUtils.getFullNameByUID(userId);
			System.out.println(userName);
			bean.put("userName", userName);
			
			int orgId=ParamUtil.getInteger(request, Request.ORG_ID);
			bean.put("orgId",orgId);
			System.out.println("orgId-------------"+ orgId);
			
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
			
			List<LmisAbsenceSettings> lsAbType = LmisAbsenceRequestsLocalServiceUtil.getListAbsenceTypeOfRoot(orgId);
			System.out.println("---------Loai ngay nghi: "+ lsAbType);
			bean.put("lsAbType", lsAbType);
			System.out.println("--orgId: "+orgId);
			if(cmd.equals(Constants.VIEW) || cmd.equals(Constants.EDIT) || cmd.equals(Request.REVIEW)){
				LmisAbsenceRequests absenceDetail = LmisAbsenceRequestsLocalServiceUtil.getLmisAbsenceRequests(selectedId);
				bean.put("absenceDetail", absenceDetail);
				Date dayOff = absenceDetail.getStartDate();
				int month=dayOff.getMonth();
				int year = dayOff.getYear();
				double monthDayOff = LmisAttMonthlyLocalServiceUtil.getTotalDayOffInMonth(absenceDetail.getRequestedBy(), month, year, orgId); 
				bean.put("countDayOff", monthDayOff);
				String appr = LmisAbsenceRequestsLocalServiceUtil.getContentApprove(selectedId);
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^debug: "+appr);
				bean.put("appReason", appr);
			}
			else if(cmd.equals(Constants.SAVE)){
				String absenceBeginStr= ParamUtil.getString(request, "absenceBegin");
				Date absenceBegin = df.parse(absenceBeginStr);
				String absenceEndStr = ParamUtil.getString(request, "absenceEnd");
				Date absenceEnd=df.parse(absenceEndStr);
				String absenceReason = ParamUtil.getString(request, "absenceReason");
				int sessionBegin = ParamUtil.getInteger(request, "sessionBegin");
				int sessionEnd = ParamUtil.getInteger(request, "sessionEnd");
				System.out.println("---------$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+sessionEnd);
				int absenceTypeId = ParamUtil.getInteger(request, "absenceTypeId");
				String absenceName = LmisAbsenceRequestsLocalServiceUtil.funcNameAbsence(absenceTypeId);
				if(currentHander.equals(Constants.ADD)){
					LmisAbsenceRequestsLocalServiceUtil.addAbsenceReq(orgId, userId, absenceBegin, absenceEnd, sessionBegin,
										sessionEnd, absenceReason, absenceName, absenceTypeId);
				}else if (currentHander.equals(Constants.EDIT) || currentHander.equals(Constants.VIEW)){
					LmisAbsenceRequestsLocalServiceUtil.editAbsenceReq(selectedId, absenceBegin, absenceEnd, sessionBegin, sessionEnd, 
							absenceReason, absenceName, absenceTypeId);
				}
			}else if (cmd.equals(Constants.DELETE)){
				boolean bl=LmisAbsenceRequestsLocalServiceUtil.deleteAbsenceReq(orgId, userId, selectedId);
				if(bl== true){
					bean.put("isSuccess","yes");
				}else{
					bean.put("isSuccess", "no");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		bean.put("CMD", Constants.CMD);
		bean.put("EDIT", Constants.EDIT);
		bean.put("TAB_PERSONAL", Request.TAB_PERSONAL);
		bean.put("TAB_MANAGER", Request.TAB_MANAGER);
		bean.put("TAB_OTHER", Request.TAB_OTHER);
		bean.put("VIEW", Constants.VIEW);
		bean.put("REVIEW", Request.REVIEW);
		bean.put("UNDO",Request.UNDO_HANDER);
		bean.put("ADD", Constants.ADD);
		bean.put("DELETE", Constants.DELETE);
		return new ModelAndView (this.getViewName(),"bean",bean);
	}
}








