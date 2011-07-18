package com.larion.progate.lmis.controllers;

import com.larion.progate.common.constants.Request;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisAbsenceRequests;
import larion.progate.lmis.model.LmisAbsenceSettings;
import larion.progate.lmis.service.LmisAbsenceRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class OtherDayOffController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Map<String,Object>bean = new HashMap<String,Object>();
		try{
			String tabAction=ParamUtil.getString(request, Request.TAB_ACTION);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);

			String cmd=ParamUtil.getString(request, Constants.CMD,"null");
			System.out.println("hander---- "+cmd);
			bean.put("cmd", cmd);

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
			System.out.println("--orgId: "+orgId);
			
			List<LmisAbsenceSettings> lsAbType = LmisAbsenceRequestsLocalServiceUtil.getListAbsenceTypeOfRoot(orgId);
			System.out.println("---------Loai ngay nghi: "+ lsAbType);
			bean.put("lsAbType", lsAbType);
			
			int selectedStatus = ParamUtil.getInteger(request, "selectedStatus",-1);
			bean.put("selectedStatus", selectedStatus);
			System.out.println("trang thai duoc chon: "+ selectedStatus);
			
			int absenceType = ParamUtil.getInteger(request, "absenceType",-1);
			bean.put("absenceType",absenceType);
			System.out.println("loai ngay nghi dc chon: "+absenceType);
			
			//check if user is permited or not
			int appId = LmisConst.App_Id;
			String appName =  LmisConst.App_Name;
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
			
			List<LmisAbsenceRequests> listAbsence = new ArrayList<LmisAbsenceRequests>();
			if(selectedStatus == -1 && absenceType == -1){
				listAbsence = LmisAbsenceRequestsLocalServiceUtil.getListAbsenceReqRoleSpec(orgId);
			}else{
				listAbsence = LmisAbsenceRequestsLocalServiceUtil.filterTabManager(orgId, -1, absenceType, selectedStatus);
			}
			System.out.println("-------list nghi phep dc quan ly boi BOD "+listAbsence);		
			com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAbsence.size());
			pagination.paging(request); listAbsence = listAbsence.subList(pagination.getStartIndex(), pagination.getEndIndex());
			bean.put("pagination", pagination);
			bean.put("listAbsence",listAbsence);
			bean.put("size", listAbsence.size());
		}catch(Exception e){
			e.printStackTrace();
		}

		bean.put("TAB_OTHER", Request.TAB_OTHER);
		bean.put("VIEW", Constants.VIEW);
		bean.put("UNDO",Request.UNDO_HANDER);

		return new ModelAndView(this.getViewName(),"bean",bean);
	}
}