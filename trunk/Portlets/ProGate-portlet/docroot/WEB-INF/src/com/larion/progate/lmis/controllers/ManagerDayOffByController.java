package com.larion.progate.lmis.controllers;

import com.larion.progate.common.constants.Request;

import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.lmis.model.LmisAbsenceRequests;
import larion.progate.lmis.model.LmisAbsenceSettings;
import larion.progate.lmis.model.LmisAttendanceDaily;
import larion.progate.lmis.service.LmisAbsenceApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class ManagerDayOffByController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		res.setCharacterEncoding("UTF-8");
		PrintWriter output = res.getWriter();
		Map<String,Object>bean = new HashMap<String,Object>();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try{
			String tabAction=ParamUtil.getString(request, Request.TAB_ACTION);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);

			String cmd=ParamUtil.getString(request, Constants.CMD,"null");
			System.out.println("hander---- "+cmd);
			bean.put("cmd", cmd);
			
			Date date = new Date();
			String dateStr = df.format(date);
			String dateValue = ParamUtil.getString(request, "dateDayOff",dateStr);
			
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			System.out.println(userId);
			String userName= LmisUtils.getFullNameByUID(userId);
			System.out.println(userName);
			bean.put("userName", userName);
			
			int selectedId = ParamUtil.getInteger(request, Request.SELECTED_ID);
			System.out.println("----------id dc chon: "+ selectedId);
			bean.put("selectedId",selectedId);

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
			
			int countPending = LmisAbsenceRequestsLocalServiceUtil.countRequestPending(orgId, userId);
			System.out.println("so don chua phe duyet: "+ countPending);
			bean.put("countPending",countPending);
			
			String statistic = ParamUtil.getString(request, "statistic");
			if(statistic.equals("statistic")){
				StringBuffer xml = new StringBuffer();
				Date dayValue = df.parse(dateValue);
				List<LmisAttendanceDaily> lsCal = LmisAbsenceRequestsLocalServiceUtil.getStatisticForms(orgId, dayValue);
				int countForm = lsCal.size();
				String dayStr = df.format(dayValue);
				System.out.println("list thong ke don: "+ lsCal.size());
				xml.append("<?xml version=\"1.0\"?>\n");
				xml.append("<Statistic>\n");
				
				xml.append("<dayValue>");
				xml.append(dayStr);
				xml.append("</dayValue>\n");
				
				xml.append("<countForm>");
				xml.append(countForm);
				xml.append("</countForm>\n");
				
				xml.append("</Statistic>\n");
				output.print(xml.toString());
			}
			
			if(cmd.equals("null") || cmd.equals(Request.UNDO_HANDER) || cmd.equals("viewFilter")){
				//List<LmisAbsenceRequests> listAbsence = LmisAbsenceRequestsLocalServiceUtil.getListAbsenceReqRolePmOrBod(orgId, userId);
				List<LmisAbsenceRequests> listAbsence = new ArrayList<LmisAbsenceRequests>();
				if(selectedStatus == -1 && absenceType == -1 ){
					listAbsence = LmisAbsenceRequestsLocalServiceUtil.getListRequestApprovedBy(orgId, userId);
				}
				else{
					listAbsence = LmisAbsenceRequestsLocalServiceUtil.filterTabManager(orgId, userId, absenceType, selectedStatus);
				}
				System.out.println("--list nghi phep quan luy boi "+ listAbsence);		
				com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAbsence.size());
				pagination.paging(request); listAbsence = listAbsence.subList(pagination.getStartIndex(), pagination.getEndIndex());
				bean.put("pagination", pagination);
				bean.put("listAbsence", listAbsence);
				bean.put("size", listAbsence.size());
			}
		
			if(cmd.equals(Request.AGREE)){
				String reasonApprove = ParamUtil.getString(request, "reviewReason");
				int reqId = ParamUtil.getInteger(request, "selectedId");
				LmisAbsenceRequestsLocalServiceUtil.doApprove(userId, reqId, true, reasonApprove);
				System.out.println("Ban da doong y don nay");
			}else if(cmd.equals(Request.NOT_AGREE)){
				String reasonApprove = ParamUtil.getString(request, "reviewReason");
				int reqId =ParamUtil.getInteger(request, "selectedId");
				LmisAbsenceRequestsLocalServiceUtil.doApprove(userId, reqId, false, reasonApprove);
				System.out.println("Ban khong dong u don nay");
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
		bean.put("UNDO",Request.UNDO_HANDER);
		bean.put("REVIEW", Request.REVIEW);
		return new ModelAndView(this.getViewName(),"bean",bean);
	}

}