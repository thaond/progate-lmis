package com.larion.progate.lmis.action;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;
import com.larion.progate.lmis.constants.LmisRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisViewOvertimeReport;
import larion.progate.lmis.model.LmisViewOvertimeReportDetail;
import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.model.LmisViewReportOvertime;
import larion.progate.lmis.model.LmisViewReportOvertimeApproval;
import larion.progate.lmis.service.LmisOverTimeReportsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOvertimeReportDetailLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOvertimeReportLocalServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.LmisViewReportOvertimeApprovalLocalServiceUtil;
import larion.progate.lmis.service.LmisViewReportOvertimeLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;
import larion.progate.model.Organization;

/**
 * @author chenyuxuan
 *
 */

public class OvertimeReportAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

			//get rootId
			HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
			HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
			int orgId=ParamUtil.getInteger(orgReq, Request.ORG_ID);
			if (orgId==0){
				orgId = ParamUtil.getInteger(request, Request.ORG_ID);
			}
			bean.put("orgId", orgId);
			
			String role=null;
			Integer userId=0;
			String cmd=ParamUtil.getString(request, Constants.CMD);
			System.out.println("lenh duoc yeu cau la: "+ cmd);
			bean.put("cmd",cmd);

			try{
				ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
				User user = UserLocalServiceUtil.getUser(sc.getUserId());
				Long userIdTemp = user.getUserId();
				role =  LmisUtils.getUserRoleByUID(userId , orgId);
				userId = userIdTemp.intValue();
				System.out.println(userId);
				String userName=LmisUtils.getFullNameByUID(userId);
				bean.put("userName",userName );
			}catch (Exception e){
				e.printStackTrace();
			}
			//check if user is permited or not
			String appName = LmisConst.App_Name;
			int category =  LmisConst.Pers_OverTime;
			String viewOTReportPerId = LmisConst.View_Org_OT_Report;
			String manageOTReportPerId = LmisConst.Manage_OT_Report;
			String approveOTReportPerId = LmisConst.Approve_OT_Report;
			int manageOTReportPer = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, category, orgId, userId,  manageOTReportPerId);
			int viewOTReportPer = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, category, orgId, userId,  viewOTReportPerId);
			int approveOTReportPer = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, category, orgId, userId,  approveOTReportPerId);
			
			bean.put("manageOTReportPer", manageOTReportPer);
			bean.put("viewOTReportPer", viewOTReportPer);
			bean.put("approveOTReportPer", approveOTReportPer);
			//tab action
			String defaultTab = Request.TAB_PERSONAL;
			if(manageOTReportPer==0 && approveOTReportPer ==0){
				defaultTab= Request.TAB_OTHER;
			}
			if(manageOTReportPer==0 && approveOTReportPer !=0){
				defaultTab = Request.TAB_MANAGER; 
			}
			String tabAction=ParamUtil.getString(request, Request.TAB_ACTION, defaultTab);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);
			
			int subOrgId =  ParamUtil.getInteger(request, LmisRequest.SUB_ORG_ID);
			int reportId = ParamUtil.getInteger(request, LmisRequest.REPORT_ID);
			bean.put(LmisRequest.REPORT_ID, reportId);
			bean.put("subOrgId", subOrgId);
			
			Calendar currentDate = Calendar.getInstance();
			Date now = currentDate.getTime();
			bean.put("now", now);
			  SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
			  String currDate = formatter.format(currentDate.getTime());
			bean.put("currDate", currDate);
			
			int selectedOrg = ParamUtil.getInteger(request, "selectedOrg", -1);
			
			bean.put("selectedOrg", selectedOrg);
			int selectedStatus = ParamUtil.getInteger(request, "selectedStatus", -1);
			bean.put("selectedStatus", selectedStatus);
			System.out.println("-------------------DEBUG SELECTED ORG AND STATUS-----------------------");
			System.out.println("selectedOrg: " + selectedOrg);
			System.out.println("selectedstatus: " + selectedStatus);
			System.out.println("-------------------DEBUG SELECTED ORG AND STATUS-----------------------");
			//get list all suborg of root
			List<Organization> listSubOrg= LmisUtils.getOrganizationByRootId(orgId);
			bean.put("listSubOrg", listSubOrg);
			//Organization listSubOr = listSubOrg.get(0);listSubOr.getn

			try{
				
				int countItem = 0;
			if (Request.TAB_PERSONAL.equals(tabAction)){
				//get list of reports
				
				if (role.equals(Request.IS_PM)){
					//List<LmisViewOvertimeReport> lmisViewReportOvertimes = LmisViewOvertimeReportLocalServiceUtil.getListOverTimeRepRolePM(orgId, userId);
					DynamicQuery Q = DynamicQueryFactoryUtil.forClass(LmisViewOvertimeReport.class,PortletClassLoaderUtil.getClassLoader());
					Q.add(PropertyFactoryUtil.forName("rootId").eq(orgId));
					Q.add(PropertyFactoryUtil.forName("reportedBy").eq(userId));
					Q.addOrder(OrderFactoryUtil.asc("reportedStatus"));
					Q.addOrder(OrderFactoryUtil.desc("createdAt"));
					List<LmisViewOvertimeReport> lmisViewReportOvertimes = new ArrayList<LmisViewOvertimeReport>();
					
					List<Object> ls = LmisViewRegistrationOvertimeLocalServiceUtil.dynamicQuery(Q);
					for(int i=0;i<ls.size();i++){
						lmisViewReportOvertimes.add((LmisViewOvertimeReport)ls.get(i));
					}
					
					PaginationObject pagination = new PaginationObject("lmisAbsence",lmisViewReportOvertimes.size());
					pagination.paging(request);
					bean.put("pagination", pagination);
					lmisViewReportOvertimes = lmisViewReportOvertimes.subList(pagination.getStartIndex(), pagination.getEndIndex());
					bean.put("lmisViewReportOvertimes", lmisViewReportOvertimes);
					countItem = lmisViewReportOvertimes.size();
				}
				
				if(role.equals(Request.IS_BOD)){
					List<LmisViewOvertimeReport> lmisViewReportOvertimes =LmisViewOvertimeReportLocalServiceUtil.getListOverTimeRepRoleBOD(orgId, userId);
					bean.put("lmisViewReportOvertimes", lmisViewReportOvertimes);
					countItem = lmisViewReportOvertimes.size();
				}
				//create overtime report 
				if(LmisRequest.CREATE_REPORT.equals(cmd)){
					
					int reqId= ParamUtil.getInteger(request, LmisRequest.REQUEST_ID);
					List<LmisViewRegistrationOvertime> listAll = LmisViewRegistrationOvertimeLocalServiceUtil.getListOverTimeReqDetail(orgId, reqId);
					bean.put("listAll", listAll);
					LmisViewRegistrationOvertime ls;
					if (listAll.size() > 0) {
						ls = listAll.get(0);
					} else {
						ls = null;
					}
					bean.put("ls", ls);
				}


				//view report indetail***********************************************************
				if (Constants.VIEW.equals(cmd)){
					viewOvertimeReportInDetail(bean, subOrgId, reportId);
					boolean hideEditIcon = ParamUtil.getBoolean(request, "hideEditIcon");
					bean.put("hideEditIcon", hideEditIcon);
					//get approval feedback  for viewing overtime report in detail
					String feedback = LmisOvertimeApprovalsLocalServiceUtil.getApprovalFeedback(reportId, orgId);
					bean.put("feedback", feedback);
					
				}
				if (Constants.EDIT.equals(cmd)){
					bean.put("hideEdit",true);			
					viewOvertimeReportInDetail(bean, subOrgId, reportId);
					
				}
				if (LmisRequest.SEND_REPORT.equals(cmd)){
					try{
						
						String mode= ParamUtil.getString(request, "mode");
						SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						String otReason = ParamUtil.getString(request, "otReason");
						Date regDate = ParamUtil.getDate(request, "regDate", df);
						Date repDate = ParamUtil.getDate(request, "repDate", df);
						int arrUID[] = ParamUtil.getIntegerValues(request, "arrUserId");
						String[] arrHM = request.getParameterValues("arrHM");
						String[] arrEndTime = request.getParameterValues("arrEndTime");
						double[] arrTotal = ParamUtil.getDoubleValues(request, "arrTotalHour");
						for(int i=0; i<arrTotal.length; i++){
							System.out.println("arrTotal " +arrTotal[i]);
						}
						
						if(mode.equals("create")){
							LmisOverTimeReportsLocalServiceUtil.addOtReport(reportId, orgId, subOrgId, userId, otReason, regDate, repDate, arrUID, arrTotal, Arrays.asList(arrHM), Arrays.asList(arrEndTime));
						}
						if(mode.equals("edit")){
							LmisOverTimeReportsLocalServiceUtil.editOtReport(orgId, reportId, otReason, repDate, arrUID, arrTotal, Arrays.asList(arrHM), Arrays.asList(arrEndTime));
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}

			if (Request.TAB_MANAGER.equals(tabAction)){
				if (LmisRequest.APPROVED.equals(cmd)){
					String feedback = ParamUtil.getString(request, LmisRequest.FEEDBACK);
					boolean b=LmisViewReportOvertimeLocalServiceUtil.doApproveIt(orgId, subOrgId, userId,reportId, true, feedback);
					if(b==true){
						bean.put("approveOk", true);
					}
					else{
						bean.put("approveOk", false);
					}
				}
				if (LmisRequest.NOT_APPROVED.equals(cmd)){
					String feedback = ParamUtil.getString(request, LmisRequest.FEEDBACK);
					boolean b= LmisViewReportOvertimeLocalServiceUtil.doApproveIt(orgId, subOrgId, userId,reportId, false, feedback);
					if(b==true){
						bean.put("approveOk", true);
					}
					else{
						bean.put("approveOk", false);
					}
				}		
				boolean approve =false;
				if (Constants.APPROVE.equals(cmd)){
					approve=true;
					bean.put("hideApprove",approve);
					viewOvertimeReportInDetail(bean, subOrgId, reportId);
					//get approval feedback  for viewing overtime report in detail
					String feedback = LmisOvertimeApprovalsLocalServiceUtil.getApprovalFeedback(reportId, orgId);
					bean.put("feedback", feedback);
				}
				bean.put("hideApprove",approve);
				
				//count number of pending overtime report
				int countPendingOT= LmisViewReportOvertimeApprovalLocalServiceUtil.countReportPending(orgId);
				bean.put("countPendingOT", countPendingOT);
				List<LmisViewReportOvertimeApproval> lmisViewReportOvertimeApprovals = null;
				if(selectedOrg==-1 && selectedStatus==-1){
					 lmisViewReportOvertimeApprovals = LmisViewReportOvertimeApprovalLocalServiceUtil.getListApproval(
							orgId, userId);
				}
				else{
				 lmisViewReportOvertimeApprovals = LmisViewReportOvertimeApprovalLocalServiceUtil.getListApprovalForBOD(
			            orgId, userId, selectedOrg, selectedStatus);
				 System.out.println("------------------ggggggggggggggggggg------------------");
				 System.out.println(lmisViewReportOvertimeApprovals.toString());
				 System.out.println("------------------ggggggggggggggggggg------------------");
				}
				PaginationObject pagination = new PaginationObject("lmisAbsence",lmisViewReportOvertimeApprovals.size());
				pagination.paging(request);
				bean.put("pagination", pagination);
				lmisViewReportOvertimeApprovals = lmisViewReportOvertimeApprovals.subList(pagination.getStartIndex(), pagination.getEndIndex());
				bean.put("lmisViewReportOvertimeApprovals", lmisViewReportOvertimeApprovals);
				countItem = lmisViewReportOvertimeApprovals.size();
				
				if (Constants.VIEW.equals(cmd)){
					viewOvertimeReportInDetail(bean, subOrgId, reportId);
					//get approval feedback  for viewing overtime report in detail
					String feedback = LmisOvertimeApprovalsLocalServiceUtil.getApprovalFeedback(reportId, orgId);
					bean.put("feedback", feedback);
					
					//hide approval button if status is 2 or 3 (accepted or not accepted)
					int approveState = ParamUtil.getInteger(request, LmisRequest.APPROVE_STATUS);
					if(approveState==2 || approveState==3){
						bean.put("hideApproveOfView",true);

					}
				}
			}
			if (Request.TAB_OTHER.equals(tabAction)){
				List<LmisViewReportOvertime> lmisViewReportOvertimes =null;
				if(selectedOrg== -1){
					System.out.println("--------------------DEBUG TAB OTHER------------------");
					System.out.println(selectedOrg);
					
					lmisViewReportOvertimes = LmisViewReportOvertimeLocalServiceUtil.getListOverTimeRepRoleSpec(orgId);
					System.out.println(lmisViewReportOvertimes.toString());
					System.out.println("--------------------DEBUG TAB OTHER------------------");
				}
				else{
					lmisViewReportOvertimes = LmisViewReportOvertimeLocalServiceUtil.getListOverTimeRepRoleSpec(orgId, selectedOrg);
					System.out.println("--------------------DEBUG TAB OTHER WHEN ORG != -1------------------");
					System.out.println(lmisViewReportOvertimes.toString());
					System.out.println("--------------------DEBUG TAB OTHER WHEN ORG != -1------------------");
				}
				PaginationObject pagination = new PaginationObject("lmisAbsence",lmisViewReportOvertimes.size());
				pagination.paging(request);
				bean.put("pagination", pagination);
				lmisViewReportOvertimes = lmisViewReportOvertimes.subList(pagination.getStartIndex(), pagination.getEndIndex());
				bean.put("lmisViewReportOvertimes", lmisViewReportOvertimes);
				countItem = lmisViewReportOvertimes.size();
				//view
				if (Constants.VIEW.equals(cmd)){
					viewOvertimeReportInDetail(bean, subOrgId, reportId);
					//get approval feedback
					String feedback = LmisOvertimeApprovalsLocalServiceUtil.getApprovalFeedback(reportId, orgId);
					bean.put("feedback", feedback);
				}
			}
			bean.put("countItem", countItem);
		}catch(Exception e){
			e.printStackTrace();
		}
			bean.put("TAB_PERSONAL", Request.TAB_PERSONAL);
			bean.put("TAB_MANAGER", Request.TAB_MANAGER);
			bean.put("TAB_OTHER", Request.TAB_OTHER);
			bean.put("VIEW", Constants.VIEW);
			bean.put("EDIT", Constants.EDIT);
			bean.put(LmisRequest.GO_BACK, LmisRequest.GO_BACK);
			bean.put(LmisRequest.APPROVE, LmisRequest.APPROVE);
			bean.put(LmisRequest.CREATE_REPORT, LmisRequest.CREATE_REPORT);
			
			bean.put("pending", LmisConst.OverTimeReport_Status_Pending);
			bean.put("accepted", LmisConst.OverTimeReport_Status_Accepted);
			bean.put("notAccepted", LmisConst.OverTimeReport_Status_NotAccept);
			bean.put("neadToCreateReport", LmisConst.OverTimeReport_Status_Need_Create_Report);
			bean.put("disableStatus", LmisConst.OverTimeReport_Status_Ban);

	}
	/**
	 * @param bean
	 * @param subOrgId
	 * @param reportId
	 */
	public static void viewOvertimeReportInDetail(Map<String, Object> bean, int subOrgId, int reportId){
		try{
		List<LmisViewOvertimeReportDetail> lmisViewReportOvertimeDetails = LmisViewOvertimeReportDetailLocalServiceUtil.getListOverTimeRepDetail(subOrgId, reportId);
		bean.put("lmisViewReportOvertimeDetails", lmisViewReportOvertimeDetails);
		LmisViewOvertimeReportDetail lmisViewReportOvertimeDetail = lmisViewReportOvertimeDetails.get(0);
		bean.put("lmisViewReportOvertimeDetail", lmisViewReportOvertimeDetail);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}