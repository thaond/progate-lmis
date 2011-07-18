package com.larion.progate.lmis.action;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

public class RequestOverTimeAction extends ParameterizableViewAction {
	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Integer rootId = ParamUtil.getInteger(orgReq, Request.ROOT_ID);
		if (rootId == 0 || rootId == null) {
			rootId = ParamUtil.getInteger(request, Request.ROOT_ID);
		}
		String tabAction = ParamUtil.getString(request, Request.TAB_OT_ACT,
				Request.TAB_OT_PER);
		String cmd = ParamUtil.getString(request, Constants.CMD,
				Constants.MANAGE);
		System.out.println(tabAction);
		Integer userId = 0;
		try {
			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			userId = userIdTemp.intValue();
			String userName = LmisUtils.getFullNameByUID(userId);
			bean.put("userName", userName);
			bean.put("userId",userId );
			bean.put("rootId", rootId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Kiem tra loai user, bean.put(typeUser,...)
		// Bean Name
		bean.put("otPending", LmisConst.OverTimeReq_Status_Pending);
		bean.put("otAccepted", LmisConst.OverTimeReq_Status_Accepted);
		bean.put("otNotAccepted", LmisConst.OverTimeReq_Status_NotAccept);
		bean.put("otReported", LmisConst.OverTimeReq_Status_Create_Report);
		bean.put("otBaned", LmisConst.OverTimeReq_Status_Ban);
		bean.put("TAB_OT_PERSONAL", Request.TAB_OT_PER);
		bean.put("TAB_OT_MANAGER", Request.TAB_OT_MANAGER);
		bean.put("TAB_OT_OTHER", Request.TAB_OT_OTHER);
		bean.put("manage", Constants.MANAGE);
		bean.put("isStaff", Request.IS_STAFF);
		bean.put("isPm", Request.IS_PM);
		bean.put("isBod", Request.IS_BOD);
		bean.put("isSpec", "isSpec");
		bean.put("view", Constants.VIEW);

		// Bean Value
		bean.put("tabAction", tabAction);
		String typeUser = Request.IS_Guest;
		typeUser = LmisUtils.getUserRoleByUID(userId, rootId);
		bean.put("typeUser", typeUser);
		bean.put("cmd", cmd);
		System.out.println(cmd + " - " + typeUser);

		if (typeUser.equals(Request.IS_PM) || typeUser.equals(Request.IS_BOD)) {
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

		}
		if (typeUser.equals(Request.IS_STAFF)) {

			List<LmisViewRegistrationOvertime> ls = LmisViewRegistrationOvertimeLocalServiceUtil
					.getListOverTimeReqRoleUser(userId, rootId);
			
			PaginationObject pagination = new PaginationObject("lmisAbsence",ls.size());
			pagination.paging(request); 
			bean.put("pagination", pagination);
			ls = ls.subList(pagination.getStartIndex(), pagination.getEndIndex());
			
			bean.put("ls", ls);
			bean.put("size", ls.size());
		}

	}
}