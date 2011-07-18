package com.larion.progate.lmis.action;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;



import larion.progate.lmis.model.LmisAbsenceRequests;
import larion.progate.lmis.model.LmisAbsenceSettings;
import larion.progate.lmis.model.LmisViewStaffRootOrgOrdered;
import larion.progate.lmis.service.LmisAbsenceRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgOrderedLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;

public class SummaryReportAction extends ParameterizableViewAction{
	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		String tabAction = ParamUtil.getString(request, Request.TAB_ACTION,Request.TAB_ATTENDANCE);
		System.out.println(tabAction);
		bean.put("tabAction",tabAction);
		String cmd=ParamUtil.getString(request, Constants.CMD,"-1");
		bean.put("cmd", cmd);

		try{
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			System.out.println(userId);
			
			Integer orgId=ParamUtil.getInteger(orgReq, "orgId");
			bean.put("orgId",orgId);
			System.out.println("--orgId: "+orgId);
			if (orgId==0){
				orgId=ParamUtil.getInteger(request, Request.ORG_ID);
				bean.put("orgId", orgId);
				System.out.println("---tabpersion orgId: "+orgId);
			}
			
			int appId = LmisConst.App_Id;
			String appName = LmisConst.App_Name;
			int categoryId =  LmisConst.Pers_Att;
			String reportSumId = LmisConst.View_General_Report;
			//int report = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appId, categoryId, orgId, userId, reportSumId);
			//int report = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName,categoryId,orgId,userId,reportSumId);
			//bean.put("report", report);
			
			int selectedPartId = ParamUtil.getInteger(request,"selectedPart");
			System.out.println("Bo phan Id: "+selectedPartId);
			bean.put("selectedPartId", selectedPartId);
			
			Calendar toDay = Calendar.getInstance();
			int yearCa = toDay.get(Calendar.YEAR);
			int year = ParamUtil.getInteger(request, "year",yearCa);
			bean.put("year", year);
			
			int monthCa = toDay.get(Calendar.MONTH)+1;
			int month = ParamUtil.getInteger(request, "month",monthCa);
			bean.put("month", month);
			
			List<larion.progate.model.Organization> listPart = LmisUtils.getOrganizationByRootId(orgId);
			bean.put("lsPart", listPart);
			
			List<LmisViewStaffRootOrgOrdered> lsUser = null;
			
			if(cmd.equals("-1")){
				lsUser =	LmisViewStaffRootOrgOrderedLocalServiceUtil.findAttCode(orgId);
				
			}
			else if (cmd.equals(Request.SELECTED)){
				if(selectedPartId == -1){
					lsUser =	LmisViewStaffRootOrgOrderedLocalServiceUtil.findAttCode(orgId);
					
				}
				else{
					lsUser = LmisViewStaffRootOrgOrderedLocalServiceUtil.findAttCodeOrg(orgId, selectedPartId);					
				}
			}
			PaginationObject pagination = new PaginationObject("lmis",lsUser.size());
			pagination.paging(request); 
			lsUser = lsUser.subList(pagination.getStartIndex(), pagination.getEndIndex());
			bean.put("pagination", pagination);
			bean.put("lsUser", lsUser);
		
			
		}catch (Exception e){
			e.printStackTrace();
		}
		bean.put("TAB_ATTENDANCE", Request.TAB_ATTENDANCE);
		bean.put("TAB_ACTION", Request.TAB_ACTION);
	}

}