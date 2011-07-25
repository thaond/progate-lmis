package com.larion.progate.lmis.controllers;


import com.larion.progate.common.bean.PaginationObject;
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

public class ManagerChangeWorkingTimeController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Map<String,Object> bean = new HashMap<String,Object>();

		//get userid
		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
		User user = UserLocalServiceUtil.getUser(sc.getUserId());
		Long userIdTemp = user.getUserId();
		Integer userId = userIdTemp.intValue();
		String userName = LmisUtils.getFullNameByUID(userId);
		bean.put("userName", userName);
		//code here check permisson of current userID *****************************

		String tabAction=ParamUtil.getString(request, Request.TAB_ACT,Request.TAB_MANAGER);
		System.out.println(tabAction);
		bean.put("tabAction",tabAction);
		//Integer rootId=ParamUtil.getInteger(orgReq, "rootId");
		//bean.put("rootId",rootId);
		int orgId=ParamUtil.getInteger(request, Request.ORG_ID);
		bean.put("orgId", orgId);
		System.out.println("---------------------------------------------------rootID :"+orgId);
		String cmd= ParamUtil.getString(request, Constants.CMD, "null");
		System.out.println("----Manager: "+cmd);
		bean.put("cmd",cmd);
		
		int reviewNext = ParamUtil.getInteger(request, "next",0);
		bean.put("reviewNext", reviewNext);
		System.out.println("-------------review next: "+ reviewNext);
		
		int selectedStatus = ParamUtil.getInteger(request, "selectedStatus",-1);
		bean.put("selectedStatus", selectedStatus);
		System.out.println("trang thai duoc chon: "+ selectedStatus);
		
		//check if user is permited or not
		int appId = LmisConst.App_Id;
		String appName = LmisConst.App_Name;
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
		
		Date date =new Date();
		System.out.println("ngay: "+ date);
		bean.put("dayValue", date);	
		
		if (cmd.equals(Request.REVIEW) || cmd.equals(Constants.VIEW) ){
			int selectedID = ParamUtil.getInteger(request, Request.SELECTED_ID);
			bean.put("selectedID", selectedID);
			LmisViewTimeChangeReqs detail= LmisViewTimeChangeReqsLocalServiceUtil.getDetailViewReqTimeChange(orgId,selectedID);
			System.out.println(detail);
			bean.put("timeChangeDetail", detail);
			String str = LmisTimeChangeRequestsLocalServiceUtil.getContentApprovals(orgId, selectedID);
			bean.put("contentApproval", str);
		}
		/*else if(cmd.equals(Constants.VIEW)){
			int selectedID = ParamUtil.getInteger(request, Request.SELECTED_ID);
			bean.put("selectedID", selectedID);
			LmisViewTimeChangeReqs detail= LmisViewTimeChangeReqsLocalServiceUtil.getDetailViewReqTimeChange(orgId,selectedID);
			System.out.println(detail);
			bean.put("timeChangeDetail", detail);
			String reasonDetail = detail.getRequestedReason();
			System.out.println(reasonDetail);
			bean.put("reasonDetail", reasonDetail);
			String str = LmisTimeChangeRequestsLocalServiceUtil.getContentApprovals(orgId, selectedID);
			bean.put("contentApproval", str);
			
			System.out.println("Loi ne kung: "+ detail);
		}*/
		else{
				if (cmd.equals(Request.AGREE)){
					int selectedID = ParamUtil.getInteger(request, Request.SELECTED_ID);
					String reason=ParamUtil.getString(request, "review");
					System.out.println(reason);
					boolean bool= LmisTimeChangeRequestsLocalServiceUtil.doApproveIt(orgId, userId, selectedID, true, reason);
					if (bool){
						bean.put("message", "success");
					}
					else{
						bean.put("message","failed");
					}
				}
				else if (cmd.equals(Request.NOT_AGREE)){
					int selectedID= ParamUtil.getInteger(request, Request.SELECTED_ID);
					String reason=ParamUtil.getString(request, "review");
					System.out.println(reason);
					boolean bool= LmisTimeChangeRequestsLocalServiceUtil.doApproveIt(orgId, userId, selectedID, false, reason);
					if (bool){
						bean.put("message", "success");
					}
					else{
						bean.put("message", "failed");
					}
				}
				/*else if (cmd.equals(Request.UNDO_HANDER) || cmd.equals("null") || cmd.equals(Request.SELECTED)){*/
				//int rootId= ParamUtil.getInteger(request,"rootId");
				List<LmisViewTimeChangeReqs> listViewTimeChangeReqs = new ArrayList<LmisViewTimeChangeReqs>();
				if(selectedStatus == -1){
					listViewTimeChangeReqs = LmisViewTimeChangeReqsLocalServiceUtil.getListTimeChangeReqs(orgId, userId);
				}
				else{
					listViewTimeChangeReqs = LmisViewTimeChangeReqsLocalServiceUtil.filterByStatusTabManager(orgId, userId, selectedStatus );
				}
				PaginationObject pagination = new PaginationObject("lmis",listViewTimeChangeReqs.size());
				pagination.paging(request); 
				listViewTimeChangeReqs = listViewTimeChangeReqs.subList(pagination.getStartIndex(), pagination.getEndIndex());
				bean.put("pagination", pagination);
				bean.put("listViewTimeChangeReqs", listViewTimeChangeReqs);
				bean.put("size",listViewTimeChangeReqs.size());
				System.out.println(listViewTimeChangeReqs);
				int count = LmisTimeChangeRequestsLocalServiceUtil.countTimeChangeReqs(orgId, userId);
				bean.put("countPending", count);
			}
			/*List<LmisViewTimeChangeReqs> listViewTimeChangeReqs = LmisViewTimeChangeReqsLocalServiceUtil.getListTimeChangeReqs(orgId, userId);
			PaginationObject pagination = new PaginationObject("lmis",listViewTimeChangeReqs.size());
			pagination.paging(request); 
			listViewTimeChangeReqs = listViewTimeChangeReqs.subList(pagination.getStartIndex(), pagination.getEndIndex());
			bean.put("pagination", pagination);
			bean.put("listViewTimeChangeReqs", listViewTimeChangeReqs);
			bean.put("size",listViewTimeChangeReqs.size());
			System.out.println(listViewTimeChangeReqs);
			int count = LmisTimeChangeRequestsLocalServiceUtil.countTimeChangeReqs(orgId, userId);
			bean.put("countPending", count);
			System.out.println("--pass get list view time change requests----");*/
		bean.put("CMD", Constants.CMD);
		bean.put("VIEW",Constants.VIEW);
		bean.put("REVIEW",Request.REVIEW);
		bean.put("AGREE", Request.AGREE);
		bean.put("NOT_AGREE", Request.NOT_AGREE);
		bean.put("UNDO_HANDER", Request.UNDO_HANDER);
		bean.put("SELECTED", Request.SELECTED);
		bean.put("TAB_MANAGER", Request.TAB_MANAGER);
		

		return new ModelAndView(this.getViewName(),"bean",bean);
	}
}