package com.larion.progate.lmis.controllers;

import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.lmis.model.LmisViewAttDaily;
import larion.progate.lmis.model.LmisViewAttInfo;
import larion.progate.lmis.model.LmisViewOrgUserRoles;
import larion.progate.model.Organization;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewAttDailyLocalServiceUtil;
import larion.progate.lmis.service.LmisViewAttInfoLocalServiceUtil;
import larion.progate.lmis.service.LmisViewDayValueMaxLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOrgUserRolesLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.constants.Request;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class OtherAttendanceInfoController extends ParameterizableViewController{


	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
				
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);	
		Map<String,Object>bean = new HashMap<String,Object>();
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yy");
		try{
			String tabAction=ParamUtil.getString(request, Request.TAB_ACTION,Request.TAB_OTHER);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);
			
			String cmd = ParamUtil.getString(request, Constants.CMD,"-1");
			System.out.println("handle: "+ cmd);
			
			//get userid and user name
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
			
			//get permission
			String permission = LmisUtils.getUserRoleByUID(userId, orgId);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$Quyen han: "+permission);
			bean.put("permission", permission);
			
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
			
			if(permission.equals(LmisConst.IS_PM)){
				List<LmisViewOrgUserRoles> listPart = LmisViewOrgUserRolesLocalServiceUtil.getListOrgByUserIdPM(userId,orgId);
				System.out.println("list Part "+listPart);
				bean.put("listPart", listPart);
			}else if(permission.equals(LmisConst.IS_BOD)){
				List<Organization> listPart = LmisUtils.getOrganizationByRootId(orgId);
				bean.put("listPart",listPart);
			}
			List<LmisViewAttInfo> listAttDaily = new ArrayList<LmisViewAttInfo>();
			if(cmd.equals("-1") || cmd.equals(Constants.VIEW)){
				Date date =new Date();
				if(cmd.equals(Constants.VIEW)){		
					String dateStr = ParamUtil.getString(request, "dateAttendance");
					date = df.parse(dateStr);
				}
				bean.put("dayValue", date);
				if(permission.equals(LmisConst.IS_PM)){
					listAttDaily = LmisViewAttInfoLocalServiceUtil.getListAttManageByPM(orgId, userId, date, name);
				}else {
					listAttDaily = LmisViewAttInfoLocalServiceUtil.getListAttManageByBOD(orgId, userId, date,name);
				}
				System.out.println("ls cua tab khac: "+ listAttDaily);
				com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAttDaily.size());
				pagination.paging(request); 
				listAttDaily = listAttDaily.subList(pagination.getStartIndex(), pagination.getEndIndex());
				bean.put("pagination", pagination);
				bean.put("listAttDaily",listAttDaily);
				bean.put("size", listAttDaily.size());
			}
			
			else{//selected ID
				String dateStr = ParamUtil.getString(request, "dateAttendance");
				System.out.println("ngay ddc chon: "+ dateStr);
				Date dateValue = df.parse(dateStr);
				System.out.println("ngay dc chon fomat: "+ dateValue);
				bean.put("dayValue", dateValue);
				int selectedPartId = ParamUtil.getInteger(request,"selectedPart");
				System.out.println("Bo phan Id: "+selectedPartId);
				bean.put("selectedPartId",selectedPartId);			
				if(selectedPartId == -1){
					if(permission.equals(LmisConst.IS_PM)){
						listAttDaily = LmisViewAttInfoLocalServiceUtil.getListAttManageByPM(orgId, userId, dateValue,name);
					}else{
						listAttDaily = LmisViewAttInfoLocalServiceUtil.getListAttManageByBOD(orgId, userId, dateValue,name);
					}
					System.out.println("list tab khac: "+ listAttDaily);
					com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAttDaily.size());
					pagination.paging(request); listAttDaily = listAttDaily.subList(pagination.getStartIndex(), pagination.getEndIndex());
					bean.put("pagination", pagination);
					bean.put("listAttDaily",listAttDaily);
					bean.put("size", listAttDaily.size());
				}
				else{
					List<LmisViewAttDaily> listAttDaily_ = LmisViewAttDailyLocalServiceUtil.getListAttByRootAndDayOrg(orgId, dateValue, selectedPartId);
					System.out.println("list tab khac: "+ listAttDaily_);
					com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAttDaily_.size());
					pagination.paging(request); listAttDaily_ = listAttDaily_.subList(pagination.getStartIndex(), pagination.getEndIndex());
					bean.put("pagination", pagination);
					bean.put("listAttDaily",listAttDaily_);
					bean.put("size", listAttDaily_.size());
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		bean.put("CMD", Constants.CMD);
		bean.put("TAB_OTHER", Request.TAB_OTHER);
		return new ModelAndView (this.getViewName(),"bean",bean);
	}
}
