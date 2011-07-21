package com.larion.progate.lmis.controllers;

import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactory;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.lmis.model.LmisOvertimeMonthly;
import larion.progate.lmis.model.LmisViewOTApp;
import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval;
import larion.progate.lmis.service.LmisOvertimeMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOTAppLocalServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeaApprovalLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;
import larion.progate.model.Organization;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class ManageRequestOverTimeController extends
		ParameterizableViewController {
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		String tabAction = ParamUtil.getString(request, Request.TAB_OT_ACT);
		String cmd = ParamUtil.getString(request, Constants.CMD);
		int reqId = ParamUtil.getInteger(request, "reqId");
		int rootId = ParamUtil.getInteger(request, Request.ROOT_ID);

		Map<String, Object> bean = new HashMap<String, Object>();
		int userId = 0;
		try {
			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), request);
			userId = (int) sc.getUserId();
			String userName = LmisUtils.getFullNameByUID(userId);
			bean.put("userName", userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Bean Name
		bean.put("TAB_OT_PERSONAL", Request.TAB_OT_PER);
		bean.put("TAB_OT_MANAGER", Request.TAB_OT_MANAGER);
		bean.put("TAB_OT_OTHER", Request.TAB_OT_OTHER);
		bean.put("otPending", LmisConst.OverTimeReq_Status_Pending);
		bean.put("otAccepted", LmisConst.OverTimeReq_Status_Accepted);
		bean.put("otNotAccepted", LmisConst.OverTimeReq_Status_NotAccept);
		bean.put("otReported", LmisConst.OverTimeReq_Status_Created_Report);
		bean.put("otBaned", LmisConst.OverTimeReq_Status_Ban);
		bean.put("view", Constants.VIEW);// View list
		bean.put("approve", Constants.APPROVE);// View list
		bean.put("isStaff", Request.IS_STAFF);
		bean.put("isPm", Request.IS_PM);
		bean.put("isBod", Request.IS_BOD);
		bean.put("isSpec", "isSpec");
		bean.put("manage", Constants.MANAGE);
		// Bean Value
		String typeUser = LmisUtils.getUserRoleByUID(userId, rootId);
		bean.put("tabAction", tabAction);
		bean.put("typeUser", typeUser);
		bean.put("rootId", rootId);
		bean.put("cmd", cmd);
		int selectedOrg = ParamUtil.getInteger(request, "selectedOrg", -1);
		int selectedStatus = ParamUtil.getInteger(request, "selectedStatus", -1);
		bean.put("selectedStatus", selectedStatus);
		bean.put("selectedOrg", selectedOrg);
		if (typeUser.equals(LmisConst.IS_BOD)) {
			if (cmd.equals(Constants.APPROVE)) {
				List<LmisViewRegistrationOvertime> lsDetail = LmisViewRegistrationOvertimeLocalServiceUtil
						.getListOverTimeReqDetail(rootId, reqId);
				LmisViewRegistrationOvertime ls = null;
				if (lsDetail.size() > 0) {
					ls = lsDetail.get(0);
				}
				if (ls.getRequestedStatus() == LmisConst.OverTimeReport_Status_Pending) {
					bean.put("handle", "approve");
					bean.put("approve", "approve");
					System.out.println("Dzo approve, pending");
					Calendar cal = Calendar.getInstance();
					bean.put("totalHour",LmisOvertimeMonthlyLocalServiceUtil.countTotalOverTime(rootId, ls.getOrgId(), cal.get(Calendar.MONTH), cal.get(Calendar.YEAR)));
					System.out.println("total hour: "+LmisOvertimeMonthlyLocalServiceUtil.countTotalOverTime(rootId, ls.getOrgId(), Calendar.MONTH, Calendar.YEAR));
					System.out.println("Calendar: "+ cal.get(Calendar.MONTH) +" " +cal.get(Calendar.YEAR));
				}
				
				bean.put("lsDetail", lsDetail);
				bean.put("size", lsDetail.size());
				bean.put("ls", ls);
				bean.put("reqId", reqId);
				System.out.println("view " + typeUser);
				return new ModelAndView(this.getViewName(), "bean", bean);
			}
			if (cmd.equals(Constants.MANAGE)) {
				try {
					List<Organization> listSubOrg= LmisUtils.getOrganizationByRootId(rootId);
					bean.put("listSubOrg", listSubOrg);
					
					List<LmisViewOTApp> lsApp =new ArrayList<LmisViewOTApp>();
					if(selectedOrg==-1 && selectedStatus==-1){
						//System.out.println("selectedOrg==-1 && selectedStatus==-1:"+selectedOrg);
						lsApp =LmisViewOTAppLocalServiceUtil.getListOtApprovedByBod(rootId, userId);
						//System.out.println("LsAPP: "+lsApp );
					}else{
						System.out.println("selectedOrg !=-1 :"+selectedOrg);
						lsApp = LmisOvertimeRequestsLocalServiceUtil.filterTabManager(rootId, selectedOrg, userId, selectedStatus);
						System.out.println("LsAPP: "+lsApp );
					}
					
					
					int countPending = LmisViewRegistrationOvertimeLocalServiceUtil.countRequestPending(rootId,userId);
					System.out.println(cmd + " " + typeUser + " " + tabAction);
					System.out.println(lsApp);
					bean.put("countPending", countPending);
					
					PaginationObject pagination = new PaginationObject("lmisAbsence",lsApp.size());
					pagination.paging(request); 
					bean.put("pagination", pagination);
					lsApp = lsApp.subList(pagination.getStartIndex(), pagination.getEndIndex());
					
					bean.put("lsApp", lsApp);
					bean.put("size", lsApp.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(this.getViewName(), "bean", bean);
			}
			if (cmd.equals(Constants.VIEW)) {
				DynamicQuery Q = DynamicQueryFactoryUtil.forClass(LmisViewRegistrationOvertime.class, PortletClassLoaderUtil.getClassLoader());
				Q.add(PropertyFactoryUtil.forName("rootId").eq(rootId));
				Q.add(PropertyFactoryUtil.forName("requestId").eq(reqId));
				Q.addOrder(OrderFactoryUtil.asc("LastName"));
				List<Object> lsQ =LmisViewRegistrationOvertimeLocalServiceUtil.dynamicQuery(Q);
				List<LmisViewRegistrationOvertime> lsDetail = new ArrayList<LmisViewRegistrationOvertime>();
				
				for(int i=0;i<lsQ.size();i++){
					lsDetail.add((LmisViewRegistrationOvertime)lsQ.get(i));
				}
				LmisViewRegistrationOvertime ls = null;
				if (lsDetail.size() > 0) {
					ls = lsDetail.get(0);
					
				}
				
				bean.put("lsDetail", lsDetail);
				bean.put("ls", ls);
				bean.put("showApp", true); // Show button Approve on right panel
				bean.put("reqId", reqId);
				return new ModelAndView(this.getViewName(), "bean", bean);
			}
		}
		return new ModelAndView(this.getViewName(), "bean", bean);
	}

	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		res.setCharacterEncoding("UTF-8");
		PrintWriter output = res.getWriter();
		int rootId = ParamUtil.getInteger(request, Request.ROOT_ID);
		if (rootId == 0) {
			HttpServletRequest orgReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ROOT_ID);
		}
		String action = ParamUtil.getString(request, "handle");
		System.out.println("Called Action Handle " + rootId);
		if (action.equals("approved")) {
			try {
				ServiceContext sc = ServiceContextFactory.getInstance(this
						.getClass().getName(), request);
				int userId = (int) sc.getUserId();
				int orgIdreq = ParamUtil.getInteger(request, "orgIdreq");
				int reqId = ParamUtil.getInteger(request, "reqId");
				boolean isApproved = ParamUtil
						.getBoolean(request, "isApproved");

				String reason = ParamUtil.getString(request, "reason");
				// Test data
				System.out.println("Test data: " + rootId + " " + orgIdreq
						+ " " + reqId + " " + isApproved + " reason:" +reason);

				
				if (isApproved) {
					LmisViewRegistrationOvertimeLocalServiceUtil
							.doApproveIt(rootId, orgIdreq, userId, reqId,
									isApproved, reason);
				} else {

					LmisViewRegistrationOvertimeLocalServiceUtil
							.doApproveIt(rootId, orgIdreq, userId, reqId,
									isApproved, reason);
				}

			} catch (Exception e) {
				e.printStackTrace();
				//output.print("co loi xay ra khi them phe duyet ot");
			}
			output.flush();
		}else if(action.equals("delete")){
			try {
				int reqId = ParamUtil.getInteger(request, "reqId");
				boolean flag =LmisViewRegistrationOvertimeLocalServiceUtil.deleteOverTimeReq(rootId, reqId);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

}