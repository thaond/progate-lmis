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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisViewTimeChangeReqs;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewTimeChangeReqsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class OtherChangeWorkingTimeController  extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Map<String,Object> bean = new HashMap<String,Object>();
		System.out.println("dzo other");
		//get userid
		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
		User user = UserLocalServiceUtil.getUser(sc.getUserId());
		Long userIdTemp = user.getUserId();
		Integer userId = userIdTemp.intValue();
		System.out.println("----userId: "+userId);
		String userName = LmisUtils.getFullNameByUID(userId);
		bean.put("userName", userName);

		//code here check permisson of current userID *****************************

		String tabAction = ParamUtil.getString(request, Request.TAB_ACT,Request.TAB_OTHER);
		System.out.println("---Other: "+tabAction);
		bean.put("tabAction",tabAction);
		//Integer rootId=ParamUtil.getInteger(orgReq, "rootId");
		int orgId=ParamUtil.getInteger(request, Request.ORG_ID);
		bean.put("orgId", orgId);
		System.out.println("---------------------------rootId: "+ orgId);

		String cmd= ParamUtil.getString(request, Constants.CMD, "null");
		System.out.println(cmd);
		bean.put("cmd",cmd);
		
		int selectedStatus = ParamUtil.getInteger(request, "selectedStatus",-1);
		bean.put("selectedStatus", selectedStatus);
		System.out.println("trang thai duoc chon: "+ selectedStatus);
		
		Date date =new Date();
		System.out.println("ngay: "+ date);
		bean.put("dayValue", date);
		
		//check if user is permited or not
		int appId = LmisConst.App_Id;
		String appName =  LmisConst.App_Name;
		int categoryId =  LmisConst.Pers_Att;
		String viewTimeChangeReqId = LmisConst.Manage_TimeChange_Request; //tab persion
		String approveTimeChangeReqId = LmisConst.Approve_TimeChange_Request; //tab manager
		String viewOrgTimeChangeReqId = LmisConst.View_Org_TimeChange_Request; //tab other
		int tabPersion = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, categoryId, orgId, userId, viewTimeChangeReqId);
		int tabManager = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, categoryId, orgId, userId, approveTimeChangeReqId);
		int tabOther = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, categoryId, orgId, userId, viewOrgTimeChangeReqId);
		System.out.println("----------------------debug---Quyen------------------------");
		System.out.println("tab ca nhan: "+ tabPersion);
		System.out.println("tab quan ly: "+ tabManager);
		System.out.println("tab khac: "+ tabOther);
		System.out.println("---------------------end debug--------------------------------");
		bean.put("tabPersion", tabPersion);
		bean.put("tabManager", tabManager);
		bean.put("tabOther", tabOther);
		
		if (cmd.equals(Constants.VIEW)){
			int selectedID = ParamUtil.getInteger(request,Request.SELECTED_ID);
			LmisViewTimeChangeReqs changeDetail = LmisViewTimeChangeReqsLocalServiceUtil.getDetailViewReqTimeChange(orgId, selectedID);
			bean.put("timeChangeDetail", changeDetail);
			String str = LmisTimeChangeRequestsLocalServiceUtil.getContentApprovals(orgId, selectedID);
			bean.put("contentApproval", str);
		}
		else if (cmd.equals(Request.UNDO_HANDER) || cmd.equals("null") || cmd.equals(Request.SELECTED)){
				//int rooId=ParamUtil.getInteger(request,"rootId"
			List<LmisViewTimeChangeReqs> listView = new ArrayList<LmisViewTimeChangeReqs>();
			if(selectedStatus == -1){
				listView = LmisViewTimeChangeReqsLocalServiceUtil.getListReqsByRootId(orgId);
			}
			else{
				listView = LmisViewTimeChangeReqsLocalServiceUtil.filterByStatusTabOther(orgId, selectedStatus);
			}
			System.out.println("Show hang` cua"+orgId);
			
			com.larion.progate.common.bean.PaginationObject pagination = new com.larion.progate.common.bean.PaginationObject("lmis",listView.size());
			pagination.paging(request); listView = listView.subList(pagination.getStartIndex(), pagination.getEndIndex());
			bean.put("pagination", pagination);
			System.out.println(listView);
			bean.put("lmisTimeChangeRequest",listView);
			bean.put("size",listView.size());
		}
		bean.put("CMD", Constants.CMD);
		bean.put("VIEW",Constants.VIEW);
		bean.put("UNDO_HANDER", Request.UNDO_HANDER);
		bean.put("TAB_PERSONAL", Request.TAB_PERSONAL);
		bean.put("TAB_MANAGER", Request.TAB_MANAGER);
		bean.put("TAB_OTHER", Request.TAB_OTHER);
		bean.put("SELECTED", Request.SELECTED);

		return new ModelAndView(this.getViewName(),"bean",bean);
	}
}