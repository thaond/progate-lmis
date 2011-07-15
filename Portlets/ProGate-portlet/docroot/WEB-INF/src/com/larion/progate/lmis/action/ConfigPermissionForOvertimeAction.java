package com.larion.progate.lmis.action;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.larion.progate.lmis.constants.LmisRequest;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisViewOrgUserRoles;
import larion.progate.model.Organization;
import larion.progate.model.ProGateOrgsUsersPermissions;
import larion.progate.model.ProGatePermissions;
import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.model.ViewOrgUsersPermissions;
import larion.progate.model.ViewProGatePermissionsRoles;
import larion.progate.model.impl.ProGateOrgsUsersPermissionsImpl;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOrgUserRolesLocalServiceUtil;
import larion.progate.service.ProGateOrgsUsersPermissionsLocalServiceUtil;
import larion.progate.service.ProGatePermissionsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.service.ViewProGatePermissionsRolesLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

public class ConfigPermissionForOvertimeAction extends ParameterizableViewAction {

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {
		String appName=LmisConst.App_Name;
		int categoryId = 1;
		int userId = ParamUtil.getInteger(request, "userId");
		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(rootId);
		System.out.println(userId);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		String[] listPerId = request.getParameterValues("listPerId");
		if(listPerId == null){
			boolean b = ProGateOrgsUsersPermissionsLocalServiceUtil.deleteProGateOrgsUsersPermission(appName, categoryId, rootId, userId);
			System.out.println(b);
		}
		if(listPerId != null){
		List<ProGateOrgsUsersPermissions> listId = new ArrayList<ProGateOrgsUsersPermissions>();
		for (int i = 0; i < listPerId.length; i++) {
			ProGateOrgsUsersPermissions a = new ProGateOrgsUsersPermissionsImpl();
			a.setPermissionId(listPerId[i]);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~````````");
			System.out.println(listPerId[i]);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~````````");
			listId.add(a);
		}
			boolean a = ProGateOrgsUsersPermissionsLocalServiceUtil.addProGateOrgsUsersPermission(appName, categoryId, rootId, userId, listId, 1, false);
			System.out.println(a);
		}
	}

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
		int appId = LmisConst.App_Id ;
		String appName = LmisConst.App_Name; // id of Lmis application
		int categoryId = LmisConst.Pers_OverTime; // attendance info module
		int priority =2; // 0 functions of user, 1 functions of user (user adds more), 2 functions of PM or BOD
		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
		if (rootId == 0)
		{
			HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID); //get org id from address bar
		}
		bean.put("orgId", rootId);
		
		String role=null;
		Integer IdOfUser=0;// id of user who manage this function 
		String cmd=ParamUtil.getString(request, Constants.CMD);
		bean.put("cmd",cmd);

		try{
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			IdOfUser = userIdTemp.intValue();
			role =  LmisUtils.getUserRoleByUID(IdOfUser,rootId);
			System.out.println(IdOfUser);
			String userName=LmisUtils.getFullNameByUID(IdOfUser);
			bean.put("userName",userName );
		}catch (Exception e){
			e.printStackTrace();
		}
		bean.put("role", role);
		//check if user is permited or not
		int category =  LmisConst.Pers_OverTime;
		String updateOTPer = LmisConst.Update_Permission_OT;
		String authorizedOTPer = LmisConst.Authorized_OT;
		int updateOTPermission = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, category, rootId, IdOfUser,  updateOTPer);
		int authorizedOTPermission = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, category, rootId, IdOfUser,  authorizedOTPer);
		
		bean.put("updatePermission", updateOTPermission);
		bean.put("authorizedPermission", authorizedOTPermission);
		
		String defaultTab = LmisRequest.TAB_BUILDING_PERMIT_1;
		if(updateOTPermission==0 && authorizedOTPermission !=0){
			defaultTab= LmisRequest.TAB_BUILDING_PERMIT_3;
		}
		String tabAction = ParamUtil.getString(request, LmisRequest.TAB_ACTION, defaultTab);
		
		try{
		if (LmisRequest.TAB_BUILDING_PERMIT_1.equals(tabAction)) {
			int roleId = ParamUtil.getInteger(request, "roleId", LmisConst.Staff);
			bean.put("roleId", roleId);
			List<ProGatePermissions> fullPer = ProGatePermissionsLocalServiceUtil.findProGatePermissions(appName, categoryId);
			bean.put("fullPer", fullPer);
			List<ViewProGatePermissionsRoles> rolePer = ViewProGatePermissionsRolesLocalServiceUtil.findProGatePermissionsRoles(appName, categoryId, roleId);
			bean.put("rolePer", rolePer);
		}

		if (LmisRequest.TAB_BUILDING_PERMIT_2.equals(tabAction)) {

			List<Organization> listOrg = LmisUtils.getOrganizationByRootId(rootId);

			bean.put("listOrg", listOrg);
			int org = ParamUtil.getInteger(request, "org",0);
			if (org==0){
				org= listOrg.get(0).getOrgId();
			}
			bean.put("org", org);
			//------------------
			List<ProgateOrganizationsStaffs> listUserId = LmisGeneralSettingsLocalServiceUtil.loadListProGateOrgStaff(org);

			System.out.println("listUserId *&^&*()(*&&^" +listUserId.toString());
			bean.put("listUserId", listUserId);
			System.out.println(listUserId.size());
			bean.put("datasize", listUserId.size());
			int userId = ParamUtil.getInteger(request, "userId", 0);
			System.out.println("userId "+ userId);
			if (userId == 0 && listUserId.size()!=0){
				userId = listUserId.get(0).getUserId();
				System.out.println("userId in If " + userId);

			}
			System.out.println("userId next "+ userId);
			bean.put("userId", userId);
			//////------------------------
			//int roleId = 0;
			if (userId!=0){
				//List<ViewProGatePermissionsRoles> rolePer = ViewProGatePermissionsRolesLocalServiceUtil.findProGatePermissionsRoles(appId, categoryId, roleId);
				//bean.put("rolePer", rolePer);
				List<ProGatePermissions> fullPer = ProGatePermissionsLocalServiceUtil.findProGatePermissions(appName, categoryId);
				bean.put("fullPer", fullPer);
				boolean delegate = false;
				List<ViewOrgUsersPermissions> userPer = ViewOrgUsersPermissionsLocalServiceUtil.findUsersPermissions(rootId, userId, appName, categoryId, priority, delegate);
				bean.put("userPer", userPer);
			}

		}

		if (LmisRequest.TAB_BUILDING_PERMIT_3.equals(tabAction)){
			List<LmisViewOrgUserRoles> listOrg= LmisViewOrgUserRolesLocalServiceUtil.getListOrgByUserIdPM(IdOfUser, rootId);
			System.out.println("-----------------------------------DEBUG LISTORG------------------");
			System.out.println("id of user "+ IdOfUser);
			System.out.println("list org"+listOrg.toString());
			System.out.println("-----------------------------------DEBUG LISTORG------------------");
			bean.put("listOrg", listOrg);
			int org = ParamUtil.getInteger(request, "org",0);
			if (org==0){
				org= listOrg.get(0).getOrgId();
			}
			bean.put("org", org);
			List<ProgateOrganizationsStaffs> listUserId = LmisGeneralSettingsLocalServiceUtil.loadListProGateOrgStaff(org);
			bean.put("listUserId", listUserId);
			bean.put("datasize", listUserId.size());
			int userId = ParamUtil.getInteger(request, "userId", 0);

			if (userId == 0 && listUserId.size()!=0){
				userId = listUserId.get(0).getUserId();
			}
			System.out.println("userId next "+ userId);
			bean.put("userId", userId);
			List<ProGateOrgsUsersPermissions> grantedPer =ProGateOrgsUsersPermissionsLocalServiceUtil.getListGrantPermissions(appId, categoryId, rootId, userId, IdOfUser);
			System.out.println("-------------------get list grant permission----------------------------");
			System.out.println(grantedPer.toString());
			System.out.println("-------------------get list grant permission----------------------------");
			bean.put("grantedPer", grantedPer);
			if(LmisRequest.GRANT.equals(cmd)){
				System.out.println("---------------------------DEBUG DELEGATE---------------------------------------------");
				System.out.println(cmd);
				System.out.println("---------------------------DEBUG DELEGATE---------------------------------------------");
				String[] listPerId = request.getParameterValues("listPerId");
				if(listPerId == null){
					boolean b = ProGateOrgsUsersPermissionsLocalServiceUtil.deleteProGateOrgsUsersPermission(appName,category,rootId, userId);
					System.out.println(b);
				}
				if(listPerId != null){
					List<ProGateOrgsUsersPermissions> listId = new ArrayList<ProGateOrgsUsersPermissions>();
					for (int i = 0; i < listPerId.length; i++) {
						ProGateOrgsUsersPermissions a = new ProGateOrgsUsersPermissionsImpl();
						a.setPermissionId(listPerId[i]);
						listId.add(a);
					}
					System.out.println("---------------------------DEbug listUserId---------------------------------------------");
					System.out.println(listId.toString());
					System.out.println("---------------------------DEBUG listUserId---------------------------------------------");
					ProGateOrgsUsersPermissionsLocalServiceUtil.editGrantPermission(appId, categoryId, rootId, userId, listId, 0, true, IdOfUser);
					System.out.println("------------Ban da luu thanh cong--------------------------------");
				}
			}	
			List<ViewProGatePermissionsRoles> rolePer = ViewProGatePermissionsRolesLocalServiceUtil.findProGatePermissionsRoles(appName, categoryId, LmisConst.PM);
			System.out.println("---------------------DEBUG LIST PERMISSION OF PM--------------------------");
			System.out.println(rolePer.toString());
			System.out.println("---------------------DEBUG LIST PERMISSION OF PM--------------------------");
			bean.put("userPer", rolePer);
		}
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
		}
		bean.put("activedTab", tabAction);
		bean.put("TAB_BUILDING_PERMIT_1", LmisRequest.TAB_BUILDING_PERMIT_1);
		bean.put("TAB_BUILDING_PERMIT_2", LmisRequest.TAB_BUILDING_PERMIT_2);
		bean.put("TAB_BUILDING_PERMIT_3", LmisRequest.TAB_BUILDING_PERMIT_3);
		bean.put("StaffRole", LmisConst.Staff);
		bean.put("PMRole", LmisConst.PM);
		bean.put("BODRole", LmisConst.BOD);
		bean.put("delegatePer", LmisConst.Authorized_OT);
	}

}