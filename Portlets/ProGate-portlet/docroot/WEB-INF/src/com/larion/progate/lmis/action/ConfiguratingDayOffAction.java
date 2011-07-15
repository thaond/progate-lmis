package com.larion.progate.lmis.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.lmis.model.LmisEmailSettings;
import larion.progate.lmis.model.LmisViewEmailSettingDetailOrg;
import larion.progate.lmis.model.LmisViewEmailSettingDetailUser;
import larion.progate.lmis.model.LmisViewStaffRootOrgFN;
import larion.progate.model.Organization;
import larion.progate.lmis.service.LmisEmailSettingDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisEmailSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailOrgLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailUserLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgFNLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.compass.core.util.backport.java.util.Arrays;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.larion.progate.lmis.constants.Configuration_RS;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class ConfiguratingDayOffAction extends ParameterizableViewAction  {
	@Override
	public void handleActionRequestInternal(ActionRequest request, ActionResponse response, Map<String, Object> bean) throws Exception {
		
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Integer orgId=ParamUtil.getInteger(orgReq, "orgId");
		if(orgId==0){
			orgId= ParamUtil.getInteger(request, "orgId");
		}
		bean.put("orgId", orgId);
		
		//response data when use AJAX
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		res.setCharacterEncoding("UTF-8");
		PrintWriter output = res.getWriter();    
		int emailCategory = 2;
		int defaultEmailType = LmisEmailSettingsLocalServiceUtil.getListEmailSettingDefault(orgId, emailCategory, "3");
		int emailTypeId = ParamUtil.get(request, Configuration_RS.SELECT_EMAIL_TYPE ,defaultEmailType );
	
		//get and show all granted emails of org
		try{
			List<LmisViewEmailSettingDetailOrg> lmisViewEmailSettingDetailOrgs = LmisViewEmailSettingDetailOrgLocalServiceUtil.getListEmailOrgRelated(orgId, emailTypeId);		
			bean.put("lmisViewEmailSettingDetailOrgs", lmisViewEmailSettingDetailOrgs);
			
			StringBuffer xmlOrg = new StringBuffer();
			
			xmlOrg.append("<?xml version=\"1.0\"?>\n");
			xmlOrg.append("<LmisOrgEmail>\n");
			
			for(LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : lmisViewEmailSettingDetailOrgs){
				xmlOrg.append("<OrgRelatedId>");
				xmlOrg.append(lmisViewEmailSettingDetailOrg.getOrgRelatedId());
				xmlOrg.append("</OrgRelatedId>\n");
			}
			for(LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : lmisViewEmailSettingDetailOrgs){
				xmlOrg.append("<OrgRelatedEmail>");
				xmlOrg.append(lmisViewEmailSettingDetailOrg.getEmailOrg());
				xmlOrg.append("</OrgRelatedEmail>\n");
			}
			
			xmlOrg.append("</LmisOrgEmail>\n");
			output.print(xmlOrg.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		//output.flush();
		try{
			// get and show all granted emails of user
			List<LmisViewEmailSettingDetailUser> lmisViewEmailSettingDetailUsers = LmisViewEmailSettingDetailUserLocalServiceUtil.getListEmailUserRelated(orgId, emailTypeId);
			bean.put("lmisViewEmailSettingDetailUsers", lmisViewEmailSettingDetailUsers);
			
			StringBuffer xmlUser = new StringBuffer();
			
			xmlUser.append("<?xml version=\"1.0\"?>\n");
			xmlUser.append("<LmisUserEmail>\n");
			
			for(LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : lmisViewEmailSettingDetailUsers ){
				xmlUser.append("<UserId>");
				xmlUser.append(lmisViewEmailSettingDetailUser.getUserRelatedId());
				xmlUser.append("</UserId>\n");
			}
			for(LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : lmisViewEmailSettingDetailUsers ){
				xmlUser.append("<UserEmail>");
				xmlUser.append(lmisViewEmailSettingDetailUser.getEmailUser());
				xmlUser.append("</UserEmail>\n");
			}
			xmlUser.append("</LmisUserEmail>\n");
			output.print(xmlUser.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	//output.flush();
	}
	
	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
		
			
			//get rootId
			HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
			HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
			Integer orgId=ParamUtil.getInteger(orgReq, "orgId");
			if(orgId==0){
				orgId= ParamUtil.getInteger(request, "orgId");
			}
			bean.put("orgId", orgId);
			
			int appId =LmisConst.App_Id;
			String appName = LmisConst.App_Name;
			Integer userId=0;
			int category =LmisConst.Pers_Absence;
			String perId = LmisConst.Config_DayOff;
			String cmd=ParamUtil.getString(request, Constants.CMD);
			bean.put("cmd",cmd);
			
			String role=null;
			try{
				ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
				User user = UserLocalServiceUtil.getUser(sc.getUserId());
				Long userIdTemp = user.getUserId();
				userId = userIdTemp.intValue();
				role =  LmisUtils.getUserRoleByUID(userId,orgId);//get role of user by user id, org id
				bean.put("role", role);
				String userName=LmisUtils.getFullNameByUID(userId);
				bean.put("userName",userName );
			}catch (Exception e){
				e.printStackTrace();
			}
			int permission = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, category, orgId, userId,  perId);
			System.out.println("-------------------------DEBUG PERMISSION....");
			System.out.println(permission);
			System.out.println("-------------------------DEBUG PERMISSION....");
			bean.put("permission", permission);
			int emailCategory = 2;
			int defaultEmailType = LmisEmailSettingsLocalServiceUtil.getListEmailSettingDefault(orgId, emailCategory, "3");
			
			// check all fields is enable or disable
			boolean disable = ParamUtil.getBoolean(request, "disable", false);
			bean.put("disable", disable);
			try{
				// update config email
				if(Constants.UPDATE.equals(cmd)){
					int emailSettingId = ParamUtil.getInteger(request, "emailSettingId");
					
					int [] arrUserId = ParamUtil.getIntegerValues(request, "listUserId");
					int [] arrOrgId =	ParamUtil.getIntegerValues(request, "listOrgId");
					
					Integer[] myOrgId = new Integer[arrOrgId.length];		
					int i = 0;
					for(int val : arrOrgId) myOrgId[i++] = val;
					
					Integer[] myUserId = new Integer[arrUserId.length];
					int j = 0;
					for(int val : arrUserId) myUserId[j++] = val;		
					
					ArrayList<Integer> arrayUserId = new ArrayList<Integer> (Arrays.asList(myUserId));
					ArrayList<Integer> arrayOrgId = new ArrayList<Integer> (Arrays.asList(myOrgId));
				
					try{
					LmisEmailSettingDetailsLocalServiceUtil.updateEmailSettingDetail(orgId, emailSettingId, arrayOrgId, arrayUserId);
					}
					catch(Exception e){
						e.printStackTrace();
					}			
				}
						
				List<LmisEmailSettings> lmisEmailSettings =LmisEmailSettingsLocalServiceUtil.getListEmailSetting(orgId, emailCategory);//get all email type name of attendance info
				bean.put("lmisEmailSettings", lmisEmailSettings);
						
				//get all list granted email of org with relevant email type                                           
				int emailTypeId = ParamUtil.get(request, Configuration_RS.SELECT_EMAIL_TYPE ,defaultEmailType );
				bean.put("emailTypeId", emailTypeId);
				
				//get and show all granted emails of org
				List<LmisViewEmailSettingDetailOrg> lmisViewEmailSettingDetailOrgs = LmisViewEmailSettingDetailOrgLocalServiceUtil.getListEmailOrgRelated(orgId, emailTypeId);		
				bean.put("lmisViewEmailSettingDetailOrgs", lmisViewEmailSettingDetailOrgs);
				
				// get and show all granted emails of user
				List<LmisViewEmailSettingDetailUser> lmisViewEmailSettingDetailUsers = LmisViewEmailSettingDetailUserLocalServiceUtil.getListEmailUserRelated(orgId, emailTypeId);
				bean.put("lmisViewEmailSettingDetailUsers", lmisViewEmailSettingDetailUsers);
				
				//get list emails of organization
				List<Organization> organizations = LmisUtils.getOrganizationByRootId(orgId);
				bean.put("organizations", organizations);
	
				// get list emails of staff
				List<LmisViewStaffRootOrgFN> lmisViewStaffRootOrgFNs = LmisViewStaffRootOrgFNLocalServiceUtil.findstaff(orgId);
				bean.put("lmisViewStaffRootOrgFNs",lmisViewStaffRootOrgFNs);
				
				int countUser = lmisViewStaffRootOrgFNs.size();
				int countOrg = organizations.size();
				bean.put("countUser", countUser);
				bean.put("countOrg", countOrg);
			}catch(Exception e){
				e.printStackTrace();
			}
			bean.put("PM", Request.IS_PM);
			bean.put("BOD", Request.IS_BOD);
			bean.put("Staff", Request.IS_STAFF);
		}
///////////////////////////////////////////////////////////////////////////////////////////////////
}
