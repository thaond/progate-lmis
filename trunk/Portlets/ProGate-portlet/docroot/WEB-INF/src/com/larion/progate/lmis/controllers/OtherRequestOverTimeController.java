package com.larion.progate.lmis.controllers;

import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class OtherRequestOverTimeController extends ParameterizableViewController{
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		String tabAction=ParamUtil.getString(request, Request.TAB_OT_ACT, Request.TAB_OT_OTHER);
		String cmd=ParamUtil.getString(request, Constants.CMD,Constants.MANAGE);
		int rootId=ParamUtil.getInteger(request, Request.ROOT_ID);
		Map<String,Object>bean = new HashMap<String,Object>();
		int userId=0;
		String typeUser =Request.IS_STAFF;
		try {
			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), request);
			userId = (int) sc.getUserId();
			String userName=LmisUtils.getFullNameByUID(userId);
			bean.put("userName",userName );
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Bean Name
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
		bean.put("isStaff", Request.IS_STAFF);
		bean.put("isPm",Request.IS_PM);
		bean.put("isBod", Request.IS_BOD);
		bean.put("isSpec", "isSpec");
		bean.put("manage", Constants.MANAGE);
		//Bean Value
		typeUser = LmisUtils.getUserRoleByUID(userId,rootId);
		System.out.println("TabAction : "+tabAction);
		bean.put("tabAction", tabAction);
		bean.put("typeUser", typeUser);
		bean.put("cmd", cmd);
		bean.put("rootId", rootId);

		
		if (cmd.equals(Constants.MANAGE)){
			List<LmisViewRegistrationOvertime> lsOther = LmisViewRegistrationOvertimeLocalServiceUtil.getListOverTimeReqRoleSpec(rootId);
			/*DynamicQuery Q= DynamicQueryFactoryUtil.forClass(LmisViewRegistrationOvertime.class,PortletClassLoaderUtil.getClassLoader());
			Q.add(PropertyFactoryUtil.forName("rootId").eq(rootId));
			Q.addOrder(OrderFactoryUtil.asc("requestedStatus"));
			
			List<Object> ls = LmisViewRegistrationOvertimeLocalServiceUtil.dynamicQuery(Q);
			
			System.out.println("LSSSSSSSSSSS: "+ls);
			
			List<LmisViewRegistrationOvertime> lsOther = new ArrayList<LmisViewRegistrationOvertime>();
			for(int i=0;i<lsOther.size();i++){
				lsOther.add((LmisViewRegistrationOvertime)ls.get(i));
			}*/
			
			PaginationObject pagination = new PaginationObject("lmisAbsence",lsOther.size());
			pagination.paging(request); 
			bean.put("pagination", pagination);
			lsOther = lsOther.subList(pagination.getStartIndex(), pagination.getEndIndex());
			
			bean.put("lsOther", lsOther);
			bean.put("size", lsOther.size());
		}
		else{
			bean.put("lsOther", null);
		}
		return new ModelAndView(this.getViewName(),"bean",bean);
	}
}