
package com.larion.progate.lmis.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.util.SystemOutLogger;

import larion.progate.lmis.model.LmisViewAttDaily;
import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;
import larion.progate.lmis.service.LmisAttendanceDailyLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewAttDailyLocalServiceUtil;
import larion.progate.lmis.service.LmisViewAttdanceLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class ManagerAttendanceInfoAction extends ParameterizableViewAction {
	
	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
		
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yy");
		
		String tabAction = ParamUtil.getString(request, Request.TAB_ACTION,Request.TAB_PERSONAL);
		System.out.println(tabAction);
		bean.put("tabAction",tabAction);
		
		String cmd = ParamUtil.getString(request, Constants.CMD,"null");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^hanh dong tim kiem: "+ cmd);
		bean.put("cmd",cmd);
		
		String date = ParamUtil.getString(request, "dateAttendance",null);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ngay thang nam: "+ date);
		bean.put("date",date);
		
		int status = ParamUtil.getInteger(request, "selectedStatus",-1);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^trang thai duoc chon: "+ status);
		bean.put("status",status);
		
		int permissive = ParamUtil.getInteger(request, "selectedPermissive",-1);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^co phep: "+ permissive);
		bean.put("permissive",permissive);
		try{
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
			if(orgId==0){
				orgId=ParamUtil.getInteger(request, Request.ORG_ID);
				bean.put("orgId", orgId);
				System.out.println("---tabpersion orgId: "+ orgId);
			}
			
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
			List<LmisViewAttdance> listAttDaily = new ArrayList<LmisViewAttdance>();
			if(cmd.equals("null")){
				listAttDaily = LmisViewAttdanceLocalServiceUtil.getListAttDailyByUserId(userId, orgId);
			}
			else{
				Date dateValue = null;
				try{
					dateValue = df.parse(date);
				}
				catch (Exception e) {
					// TODO: handle exception
					dateValue = null;
				}
				listAttDaily = LmisViewAttdanceLocalServiceUtil.getListAttDailyFilterTabPersonal(orgId, userId, dateValue, status, permissive);
			}
			
			System.out.println("listatt: "+ listAttDaily);
			com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listAttDaily.size());
			pagination.paging(request); listAttDaily = listAttDaily.subList(pagination.getStartIndex(), pagination.getEndIndex());
			bean.put("pagination", pagination);
			bean.put("listAttDaily", listAttDaily);
			bean.put("size", listAttDaily.size());
			System.out.println("------------passs---------------");
		}catch (Exception e){
			e.printStackTrace();
		}	
		bean.put("TAB_PERSONAL", Request.TAB_PERSONAL);
		bean.put("TAB_MANAGER", Request.TAB_MANAGER);
		
	}

}

