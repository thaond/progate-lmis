package com.larion.progate.lmis.controllers;

import java.io.PrintWriter;
import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.lmis.model.LmisDataInputs;
import larion.progate.lmis.model.LmisViewAttDaily;
import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.lmis.model.LmisViewOrgUserRoles;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewAttDailyLocalServiceUtil;
import larion.progate.lmis.service.LmisViewAttdanceLocalServiceUtil;
import larion.progate.lmis.service.LmisViewDayValueMaxLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOrgUserRolesLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;
import larion.progate.lmis.service.LmisDataInputsLocalServiceUtil;

import org.apache.ecs.storage.Array;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.constants.Request;
import com.larion.progate.common.utils.Functions;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;


public class ManagerAttendanceInfoController extends ParameterizableViewController {
	
	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
			
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);	
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		res.setCharacterEncoding("UTF-8");
		PrintWriter output = res.getWriter();
		
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yy");
		Map<String,Object>bean = new HashMap<String,Object>();
		try{
			String tabAction=ParamUtil.getString(request, Request.TAB_ACTION,Request.TAB_MANAGER);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);
			
			String cmd = ParamUtil.getString(request, Constants.CMD,"-1");
			System.out.println("handle: "+ cmd);
			
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
			
			String name = ParamUtil.getString(request, Constants.SEARCH,null);
			bean.put("name", name);
			System.out.println("ten nhan vien: "+name);
			
			//check if user is permited or not
			int appId = LmisConst.App_Id;
			String appName = LmisConst.App_Name;
			int categoryId =  LmisConst.Pers_Att;
			String viewPersionId = LmisConst.View_Personal_Att_Info; //tab persion
			String approveById = LmisConst.Update_Att_Info; //tab manager
			String viewOrgId = LmisConst.View_Staff_Att_Info; //tab other
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
			
			//get id selected
			int id =ParamUtil.getInteger(request, "selectedId",-1);
			System.out.println("id duoc chon: "+id);
			List<larion.progate.model.Organization> listPart = LmisUtils.getOrganizationByRootId(orgId);
			System.out.println("list Part "+listPart);
			bean.put("listPart", listPart);
			
			if(cmd.equals("-1")|| cmd.equals(Request.UNDO_HANDER)){
				Date date =new Date();
				System.out.println("ngay: "+ date);
				bean.put("dayValue", date);				
				List<LmisViewAttdance> listAttDaily = LmisViewAttdanceLocalServiceUtil.getListAttByRootAndDay(orgId, date);
				com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAttDaily.size());
				pagination.paging(request); listAttDaily = listAttDaily.subList(pagination.getStartIndex(), pagination.getEndIndex());
				bean.put("pagination", pagination);
				bean.put("listAttDaily", listAttDaily);
				bean.put("size", listAttDaily.size());
				}
			
			if(cmd.equals(Constants.VIEW) || cmd.equals(Request.SAVE_SUCCESS) || cmd.equals(Constants.SEARCH)){								
				String dateStr = ParamUtil.getString(request, "dateAttendance");
				System.out.println("Ngay hien tai: "+dateStr);				
				Date dayValue = df.parse(dateStr);
				bean.put("dayValue", dayValue);
				List<LmisViewAttdance> listAttDaily = new ArrayList<LmisViewAttdance>();
				if(cmd.equals(Constants.SEARCH)){
					listAttDaily = LmisViewAttdanceLocalServiceUtil.getListAttDailyFilterTabOther(orgId, dayValue, name);
				}
				else{
					listAttDaily = LmisViewAttdanceLocalServiceUtil.getListAttByRootAndDay(orgId, dayValue);
				}
				System.out.println("danh sach cham cong(orgid va daylue) "+ listAttDaily);
				com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAttDaily.size());
				pagination.paging(request); listAttDaily = listAttDaily.subList(pagination.getStartIndex(), pagination.getEndIndex());
				bean.put("pagination", pagination);
				bean.put("listAttDaily", listAttDaily);
				bean.put("size", listAttDaily.size());
			}
			if(cmd.equals(Constants.SAVE)){
				int userIdSelect = ParamUtil.getInteger(request, "userId");
				String dateStr = ParamUtil.getString(request, "dateAtt");
				System.out.println("ngay cham cong: "+dateStr);
				Date dayValue = df.parse(dateStr);
				System.out.println("ngay dc parse: "+ dayValue);
				String hourBegin = ParamUtil.getString(request, "hourBegin");
				String minBegin = ParamUtil.getString(request, "minBegin");
				Date startTime = mergeHourMin(hourBegin,minBegin);
				String hourEnd = ParamUtil.getString(request, "hourEnd");
				String minEnd = ParamUtil.getString(request, "minEnd");
				Date endTime = mergeHourMin(hourEnd, minEnd);
				LmisDataInputsLocalServiceUtil.updateDataInputs(orgId, userIdSelect, startTime, endTime, dayValue, userId);
			}
			if(cmd.equals(Constants.EDIT)){
				try{
					LmisViewAttdance attDetail = LmisViewAttdanceLocalServiceUtil.getAttDetail(id);
					StringBuffer xml = new StringBuffer();
					String hourBegin = Functions.getHour(attDetail.getRealStartTime());
					String minBegin = Functions.getMin(attDetail.getRealStartTime());
					String hourEnd = Functions.getHour(attDetail.getRealEndTime());
					String minEnd = Functions.getMin(attDetail.getRealEndTime());
							
					xml.append("<?xml version=\"1.0\"?>\n");
					xml.append("<LmisViewAttDaily>\n");
					
					xml.append("<staffCode>");
					xml.append(attDetail.getStaffCode());
					xml.append("</staffCode>\n");
					
					xml.append("<fullName>");
					xml.append(attDetail.getFullName());
					xml.append("</fullName>\n");
					
					xml.append("<hourBegin>");
					xml.append(hourBegin);
					xml.append("</hourBegin>\n");
					
					xml.append("<minBegin>");
					xml.append(minBegin);
					xml.append("</minBegin>\n");
					
					xml.append("<hourEnd>");
					xml.append(hourEnd);
					xml.append("</hourEnd>\n");
					
					xml.append("<minEnd>");
					xml.append(minEnd);
					xml.append("</minEnd>\n");
					
					xml.append("<userId>");
					xml.append(attDetail.getUserId());
					xml.append("</userId>\n");
					
					xml.append("<dateAtt>");
					xml.append(attDetail.getDayValue());
					xml.append("</dateAtt>\n");
					
					xml.append("</LmisViewAttDaily>\n");
					output.print(xml.toString());
				}catch (Exception e){
					System.out.println(e.toString());
				}
			}
			output.flush();
			if(cmd.equals(Request.SELECTED)){
				String dateStr = ParamUtil.getString(request, "dateAttendance");
				System.out.println("ngay ddc chon: "+ dateStr);
				Date dayValue = df.parse(dateStr);
				System.out.println("ngay dc chon fomat: "+ dayValue);
				bean.put("dayValue", dayValue);
				int selectedPartId = ParamUtil.getInteger(request,"selectedPart");
				System.out.println("Bo phan Id: "+selectedPartId);
				bean.put("selectedPartId",selectedPartId);
				if(selectedPartId == -1){
					List<LmisViewAttdance> listAttDaily = LmisViewAttdanceLocalServiceUtil.getListAttByRootAndDay(orgId, dayValue);
					com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAttDaily.size());
					pagination.paging(request); listAttDaily = listAttDaily.subList(pagination.getStartIndex(), pagination.getEndIndex());
					bean.put("pagination", pagination);
					bean.put("listAttDaily",listAttDaily);
					bean.put("size", listAttDaily.size());
				}
				else{
					List<LmisViewAttDaily> listAttDaily = LmisViewAttDailyLocalServiceUtil.getListAttByRootAndDayOrg(orgId, dayValue,selectedPartId );
					com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAttDaily.size());
					pagination.paging(request); listAttDaily = listAttDaily.subList(pagination.getStartIndex(), pagination.getEndIndex());
					bean.put("pagination", pagination);
					bean.put("listAttDaily",listAttDaily);
					bean.put("size", listAttDaily.size());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		bean.put("CMD", Constants.CMD);
		bean.put("EDIT", Constants.EDIT);
		bean.put("TAB_PERSONAL", Request.TAB_PERSONAL);
		bean.put("TAB_MANAGER", Request.TAB_MANAGER);
		
		return new ModelAndView (this.getViewName(),"bean",bean);
	}
	public Date mergeHourMin(String hour,String min){
		SimpleDateFormat df=new SimpleDateFormat("HH:mm");
		String mergeStr=hour + ":" + min;
		try{
			return(Date)df.parse(mergeStr);
		}catch(ParseException e){
			System.out.println("Error in Function.mergeHourMin" +e.toString());
		}
		return null;
	}
	
}
