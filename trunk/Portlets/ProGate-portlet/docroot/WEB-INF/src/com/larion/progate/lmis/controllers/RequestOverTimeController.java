package com.larion.progate.lmis.controllers;

import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class RequestOverTimeController extends ParameterizableViewController{
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Map<String,Object>bean = new HashMap<String,Object>();

		String tabAction=ParamUtil.getString(request, Request.TAB_OT_ACT, Request.TAB_OT_PER);
		int rootId=ParamUtil.getInteger(orgReq, Request.ROOT_ID);
		if(rootId==0){
			rootId = ParamUtil.getInteger(request, Request.ROOT_ID);
		}
		String cmd=ParamUtil.getString(request, Constants.CMD,Constants.MANAGE);
		int reqId = ParamUtil.getInteger(request, "reqId");
		int userId=0;
		System.out.println("Root ID:" + rootId);
		String typeUser = Request.IS_STAFF;
		try {
			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), request);
			userId = (int) sc.getUserId();
			String userName=LmisUtils.getFullNameByUID(userId);
			bean.put("userName",userName );
			bean.put("userId",userId );
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 *Kiem Tra Quyen User Hien Tai.... Then Bean.put("typeUser"
		 */
		// Bean Name
		bean.put("TAB_OT_PERSONAL", Request.TAB_OT_PER);
		bean.put("TAB_OT_MANAGER", Request.TAB_OT_MANAGER);
		bean.put("TAB_OT_OTHER", Request.TAB_OT_OTHER);
		bean.put("otPending",LmisConst.OverTimeReq_Status_Pending);
		bean.put("otAccepted",LmisConst.OverTimeReq_Status_Accepted);
		bean.put("otNotAccepted",LmisConst.OverTimeReq_Status_NotAccept);
		bean.put("otReported",LmisConst.OverTimeReq_Status_Create_Report);
		bean.put("otBaned", LmisConst.OverTimeReq_Status_Ban);
		bean.put("view",Constants.VIEW);// View list
		bean.put("approve",Constants.APPROVE);// View list
		bean.put("manage", Constants.MANAGE);
		bean.put("isStaff", Request.IS_STAFF);
		bean.put("isPm",Request.IS_PM);
		bean.put("isBod", Request.IS_BOD);
		bean.put("isSpec", "isSpec");

		//Bean Value
		bean.put("tabAction", tabAction);
		bean.put("cmd", cmd);
		bean.put("rootId", rootId);
		typeUser = LmisUtils.getUserRoleByUID(userId,rootId);
		bean.put("typeUser",typeUser);
		System.out.println(cmd + " " + typeUser);
		if(cmd.equals(Constants.DELETE)){
			boolean flag = LmisViewRegistrationOvertimeLocalServiceUtil.deleteOverTimeReq(rootId, reqId);
			bean.put("flag", flag);
		}
		if (typeUser.equals(Request.IS_PM)|| typeUser.equals(Request.IS_BOD) ) {
			try {
				List<LmisViewRegistrationOvertime> ls = LmisViewRegistrationOvertimeLocalServiceUtil
						.getListOverTimeReqRoleManager(rootId, userId);
				
				PaginationObject pagination = new PaginationObject("lmisAbsence",ls.size());
				pagination.paging(request); 
				bean.put("pagination", pagination);
				ls = ls.subList(pagination.getStartIndex(), pagination.getEndIndex());
				
				bean.put("ls", ls);
				bean.put("size", ls.size());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
			return new ModelAndView(this.getViewName(),"bean",bean);
		}
		if (typeUser.equals(Request.IS_STAFF) ) {
			List<LmisViewRegistrationOvertime> ls = LmisViewRegistrationOvertimeLocalServiceUtil
					.getListOverTimeReqRoleUser(userId, rootId);
			
			PaginationObject pagination = new PaginationObject("lmisAbsence",ls.size());
			pagination.paging(request); 
			bean.put("pagination", pagination);
			ls = ls.subList(pagination.getStartIndex(), pagination.getEndIndex());
			
			bean.put("ls", ls);
			bean.put("size", ls.size());
			return new ModelAndView(this.getViewName(),"bean",bean);
		}
		return new ModelAndView(this.getViewName(),"bean",bean);
	}
}