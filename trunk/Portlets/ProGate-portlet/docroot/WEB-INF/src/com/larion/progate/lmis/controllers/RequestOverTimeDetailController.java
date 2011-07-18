package com.larion.progate.lmis.controllers;

import com.larion.progate.common.constants.Request;

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

import java.io.PrintWriter;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.lmis.model.LmisViewOrgUserRoles;
import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.model.LmisViewStaffRootOrgFN;
import larion.progate.lmis.model.LmisViewStaffRootOrgOrdered;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewOrgUserRolesLocalServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgFNLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgOrderedLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.apache.ecs.storage.Array;
import org.compass.core.util.backport.java.util.Arrays;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class RequestOverTimeDetailController extends
		ParameterizableViewController {
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Map<String, Object> bean = new HashMap<String, Object>();

		String tabAction = ParamUtil.getString(request, Request.TAB_OT_ACT,
				Request.TAB_OT_PER);
		int rootId = ParamUtil.getInteger(request, Request.ROOT_ID);
		String cmd = ParamUtil.getString(request, Constants.CMD);
		int orgIdChange = ParamUtil.getInteger(request, "slt-org", 0);
		int reqId = ParamUtil.getInteger(request, "reqId");
		String otherdetail = ParamUtil.getString(request, "otherdetail");
		bean.put("reqId", reqId);
		Integer userId = 0;

		String typeUser = Request.IS_STAFF;
		try {
			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			userId = userIdTemp.intValue();
			String userName = LmisUtils.getFullNameByUID(userId);
			bean.put("userName", userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Bean Name
		bean.put("TAB_OT_PERSONAL", Request.TAB_OT_PER);
		bean.put("TAB_OT_MANAGER", Request.TAB_OT_MANAGER);
		bean.put("TAB_OT_OTHER", Request.TAB_OT_OTHER);
		bean.put("otPending",LmisConst.OverTimeReq_Status_Pending);
		bean.put("view", Constants.VIEW);// View list
		bean.put("manage", Constants.MANAGE);// View list
		bean.put("approve", Constants.APPROVE);// View list
		bean.put("isStaff", Request.IS_STAFF);
		bean.put("isPm", Request.IS_PM);
		bean.put("isBod", Request.IS_BOD);
		bean.put("isSpec", "isSpec");
		bean.put("edit", Constants.EDIT);
		bean.put("add", Constants.ADD);
		// Bean Value
		bean.put("tabAction", tabAction);
		bean.put("cmd", cmd);
		bean.put("rootId", rootId);
		typeUser = LmisUtils.getUserRoleByUID(userId, rootId);
		bean.put("typeUser", typeUser);

		if (cmd.equals(Constants.ADD)) {
			System.out.println("add " + typeUser);
			Date now = new Date();
			bean.put("now", now);
			List<LmisViewOrgUserRoles> lsOrg = new ArrayList<LmisViewOrgUserRoles>();
			if(typeUser.equals(LmisConst.IS_PM)){
				lsOrg = LmisViewOrgUserRolesLocalServiceUtil.getListOrgByUserIdPM(userId,rootId);
			}
			if(typeUser.equals(LmisConst.IS_BOD)){
				lsOrg = LmisViewOrgUserRolesLocalServiceUtil.getListOrgByRootId(rootId);
				System.out.println("Lay list org cua Root Ok");
			}
			
			if (lsOrg.size() > 0) {
				List<LmisViewStaffRootOrgOrdered> lsStaff;
				if (orgIdChange == 0) {
					lsStaff = LmisViewStaffRootOrgOrderedLocalServiceUtil.getListStaffOfOrg(rootId, lsOrg.get(0).getOrgId());
							
				} else {
					lsStaff = LmisViewStaffRootOrgOrderedLocalServiceUtil.getListStaffOfOrg(rootId, orgIdChange); 

				}
				bean.put("orgIdChange", orgIdChange);
				bean.put("lsStaff", lsStaff);
			}
			bean.put("lsOrg", lsOrg);
			return new ModelAndView(this.getViewName(), "bean", bean);
		}
		if (cmd.equals(Constants.VIEW)) {
			System.out.println("SYYYYYYYYYYYYYYYYYYYYYYYYYSout reqId: "+reqId);
			DynamicQuery Q = DynamicQueryFactoryUtil.forClass(LmisViewRegistrationOvertime.class, PortletClassLoaderUtil.getClassLoader());
			Q.add(PropertyFactoryUtil.forName("rootId").eq(rootId));
			Q.add(PropertyFactoryUtil.forName("requestId").eq(reqId));
			Q.addOrder(OrderFactoryUtil.asc("LastName"));
			List<Object> lsQ =LmisViewRegistrationOvertimeLocalServiceUtil.dynamicQuery(Q);
			List<LmisViewRegistrationOvertime> lsDetail = new ArrayList<LmisViewRegistrationOvertime>();
			
			for(int i=0;i<lsQ.size();i++){
				lsDetail.add((LmisViewRegistrationOvertime)lsQ.get(i));
			}
			 
			
			LmisViewRegistrationOvertime ls=null;
			if (lsDetail.size() > 0) {
				ls = lsDetail.get(0);
				
			}
			if(otherdetail.equals("otherdetail")){
				bean.put("otherdetail", otherdetail);
			}
					
			bean.put("lsDetail", lsDetail);
			bean.put("ls", ls);
			
			System.out.println("view " + typeUser);
			return new ModelAndView(this.getViewName(), "bean", bean);
		}
		if(cmd.equals(Constants.EDIT)){
			
			//get detail common
			List<LmisViewRegistrationOvertime> lsALl = LmisViewRegistrationOvertimeLocalServiceUtil.getListOverTimeReqDetail(rootId, reqId);
			bean.put("lsAll", lsALl);
			LmisViewRegistrationOvertime ls;
			if (lsALl.size() > 0) {
				ls = lsALl.get(0);
				List<LmisViewStaffRootOrgFN> lsDetail= LmisViewStaffRootOrgFNLocalServiceUtil.findByOrgID(ls.getOrgId());
				bean.put("lsDetail", lsDetail);
			} else {
				ls = null;
			}
			bean.put("ls", ls);
			bean.put("handle", "edit");
			bean.put("reqId", ls.getOtReqsId());
			System.out.println("view " + typeUser);
			
			return new ModelAndView(this.getViewName(), "bean", bean);
		}

		return new ModelAndView(this.getViewName(), "bean", bean);
	}

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		res.setCharacterEncoding("UTF-8");
		PrintWriter output = res.getWriter();
		System.out.println("dzo handleActionRequestInternal");
		int rootId = ParamUtil.getInteger(request, Request.ROOT_ID);
		if (rootId == 0) {
			HttpServletRequest orgReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ROOT_ID);
		}
		String action = ParamUtil.getString(request, "handle");
		String cmd = ParamUtil.getString(request, Constants.CMD);
		if (action.equals("add")) {
			try {
				SimpleDateFormat df = new SimpleDateFormat();

				ServiceContext sc = ServiceContextFactory.getInstance(this
						.getClass().getName(), request);
				int userId = (int) sc.getUserId();
				String regDateStr = ParamUtil.getString(request, "regDate");
				String reqDateStr = ParamUtil.getString(request, "reqDate");
				int orgIDreq = ParamUtil.getInteger(request, "orgIDreq");
				String otReason = ParamUtil.getString(request, "otReason");

				int[] arrUID = ParamUtil.getIntegerValues(request, "arrUID");
				double[] arrTotal = ParamUtil.getDoubleValues(request, "arrTotal");
				String[] arrReason = request.getParameterValues("arrReason");
				String[] arrHM = request.getParameterValues("arrHM");
				String[] arrEndTime = request.getParameterValues("arrEndTime");

				// Test received Data
//				System.out.println(regDateStr);
//				System.out.println(reqDateStr);
//				System.out.println(orgIDreq);
//				System.out.println(arrUID.toString());
//				System.out.println(arrReason.toString());
//				System.out.println(arrTotal.toString());
//				System.out.println(arrHM.toString());
//				System.out.println(arrEndTime.toString());
//				//
				Date regDate = LmisUtils.convertStrtoDate(regDateStr,
						"dd/MM/yyyy");
				Date reqDate = LmisUtils.convertStrtoDate(reqDateStr,
						"dd/MM/yyyy");

				try{
					
					
				LmisOvertimeRequestsLocalServiceUtil.addOtRequest(rootId, orgIDreq, userId, otReason, regDate, reqDate,arrUID,Arrays.asList(arrReason),arrTotal,Arrays.asList(arrHM),  Arrays.asList(arrEndTime));
				}catch(Exception e)
				{e.printStackTrace();

				}
			} catch (Exception e) {
				e.printStackTrace();
				output.print("co loi xay ra khi them ot request");
			}
		}
		if (action.equals("edit")) {
			try {
				SimpleDateFormat df = new SimpleDateFormat();

				ServiceContext sc = ServiceContextFactory.getInstance(this
						.getClass().getName(), request);
				int userId = (int) sc.getUserId();
				String reqDateStr = ParamUtil.getString(request, "reqDate");
				int reqId = ParamUtil.getInteger(request, "reqId");
				String otReason = ParamUtil.getString(request, "otReason");

				int[] arrUID = ParamUtil.getIntegerValues(request, "arrUID");
				double[] arrTotal = ParamUtil.getDoubleValues(request, "arrTotal");
				String[] arrReason = request.getParameterValues("arrReason");
				String[] arrHM = request.getParameterValues("arrHM");
				String[] arrEndTime = request.getParameterValues("arrEndTime");

				// Test recieved Data
				System.out.println(reqDateStr);
				System.out.println(reqId);
				System.out.println(arrUID.toString());
				System.out.println(arrReason.toString());
				System.out.println(arrTotal.toString());
				System.out.println(arrHM.toString());
				System.out.println(arrEndTime.toString());
				//
				Date reqDate = LmisUtils.convertStrtoDate(reqDateStr,
						"dd/MM/yyyy");

				try{
				//LmisOvertimeRequestsLocalServiceUtil.addOtRequest(rootId, orgIDreq, userId, otReason, regDate, reqDate,arrUID,Arrays.asList(arrReason),arrTotal,Arrays.asList(arrHM),  Arrays.asList(arrEndTime));
					LmisOvertimeRequestsLocalServiceUtil.editOtRequest(rootId, reqId, otReason, reqDate, arrUID,Arrays.asList(arrReason), arrTotal, Arrays.asList(arrHM),Arrays.asList( arrEndTime));
				}catch(Exception e)
				{e.printStackTrace();

				}
			} catch (Exception e) {
				e.printStackTrace();
				output.print("co loi xay ra khi them ot request");
			}
		}
		if(cmd.equals(Constants.DELETE)){
			try {
				int reqId = ParamUtil.getInteger(request, "reqId");
				boolean flag = LmisViewRegistrationOvertimeLocalServiceUtil.deleteOverTimeReq(rootId, reqId);
			} catch (Exception e) {
				System.out.println("Error in delete overtime request");
			}
			
		}
		output.flush();
	}
}