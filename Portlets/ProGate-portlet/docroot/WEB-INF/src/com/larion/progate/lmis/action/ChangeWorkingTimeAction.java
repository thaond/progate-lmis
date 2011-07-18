package com.larion.progate.lmis.action;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisTimeChangeRequests;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeRequestsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsFinderUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;
import com.larion.progate.common.bean.PaginationObject;

public class ChangeWorkingTimeAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

			HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
			HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);

			String tabAction=ParamUtil.getString(request, Request.TAB_ACT,Request.TAB_PERSONAL);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);

			String cmd=ParamUtil.getString(request, Constants.CMD,null);
			bean.put("cmd",cmd);
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
				System.out.println("CTIOV--orgId: "+orgId);
				if (orgId==0){
					orgId=ParamUtil.getInteger(request, Request.ORG_ID);
					System.out.println("---------action orgId: "+ orgId);
					bean.put("orgId",orgId);
				}
				Date date =new Date();
				System.out.println("ngay: "+ date);
				bean.put("dayValue", date);
				/*String permission = LmisUtils.getUserRoleByUID(userId, orgId);
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$Quyen han: "+permission);
				bean.put("permission", permission);*/
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
				
				List<LmisTimeChangeRequests> timeChangeRequestList = LmisTimeChangeRequestsLocalServiceUtil
				.getListRequestTimeChangeOf(orgId, userId);
				PaginationObject pagination = new PaginationObject("lmisAbsence",timeChangeRequestList.size());
				pagination.paging(request); 
				bean.put("pagination", pagination);
				timeChangeRequestList = timeChangeRequestList.subList(pagination.getStartIndex(), pagination.getEndIndex());
				bean.put("timeChangeRequest",timeChangeRequestList);
				int size = timeChangeRequestList.size();
				bean.put("size", size);
				System.out.println("-------pass ----------------");
			}catch (Exception e){
				e.printStackTrace();
			}

			bean.put("TAB_PERSONAL", Request.TAB_PERSONAL);
			bean.put("UNDO_HANDER", Request.UNDO_HANDER);
			

		/*try{
			HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
			HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
			//get userID current
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			System.out.println(userId);
			Integer rootId=ParamUtil.getInteger(orgReq, "rootId");
			bean.put("rootId",rootId);

			if (rootId == 0){
				System.out.println("---------error rootid----------");
			}

			List<LmisTimeChangeRequests> timeChangeRequestList = LmisTimeChangeRequestsLocalServiceUtil
			.getListRequestTimeChangeOf(rootId, userId);
			bean.put("timeChangeRequest",timeChangeRequestList);
			System.out.println("-------pass ----------------");

		}catch (Exception e){
			e.printStackTrace();
		}*/
	}
}