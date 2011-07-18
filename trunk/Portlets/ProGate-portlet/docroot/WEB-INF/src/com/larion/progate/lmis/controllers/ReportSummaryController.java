package com.larion.progate.lmis.controllers;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisViewStaffRootOrgOrdered;
import larion.progate.lmis.service.LmisViewStaffRootOrgOrderedLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisUtils;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class ReportSummaryController extends ParameterizableViewController{

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Map<String,Object>bean = new HashMap<String,Object>();
		try{
			String cmd=ParamUtil.getString(request, Constants.CMD,"-1");
			bean.put("cmd", cmd);
			
			String tabAction=ParamUtil.getString(request, Request.TAB_ACTION);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);
			
			int orgId=ParamUtil.getInteger(request, Request.ORG_ID);
			bean.put("orgId",orgId);
			System.out.println("--orgId: "+orgId);
			
			int selectedPartId = ParamUtil.getInteger(request,"selectedPart");
			System.out.println("Bo phan Id: "+selectedPartId);
			bean.put("selectedPartId", selectedPartId);
			
			Calendar toDay = Calendar.getInstance();
			int yearCa = toDay.get(Calendar.YEAR);
			int year = ParamUtil.getInteger(request, "year",yearCa);
			bean.put("year", year);
			
			int monthCa = toDay.get(Calendar.MONTH)+1;
			int toMonth = ParamUtil.getInteger(request, "toMonth",monthCa);
			bean.put("toMonth", toMonth);
			
			int fromMonth = ParamUtil.getInteger(request, "fromMonth",1);
			bean.put("fromMonth", fromMonth);
			
			List<larion.progate.model.Organization> listPart = LmisUtils.getOrganizationByRootId(orgId);
			bean.put("lsPart", listPart);
			
			List<LmisViewStaffRootOrgOrdered> lsUser = null;
			if(cmd.equals("-1")){
				 lsUser =	LmisViewStaffRootOrgOrderedLocalServiceUtil.findAttCode(orgId);
				System.out.println("-------------------------------list user: "+lsUser);
				bean.put("lsUser", lsUser);
			}
			else if (cmd.equals(Request.SELECTED)){
				if(selectedPartId == -1){
					 lsUser =	LmisViewStaffRootOrgOrderedLocalServiceUtil.findAttCode(orgId);
					System.out.println("-------------------------------list user: "+lsUser);
					bean.put("lsUser", lsUser);
				}
				else{
					 lsUser = LmisViewStaffRootOrgOrderedLocalServiceUtil.findAttCodeOrg(orgId, selectedPartId);
					bean.put("lsUser", lsUser);
				}
			}
			PaginationObject pagination = new PaginationObject("lmis",lsUser.size());
			pagination.paging(request); 
			lsUser = lsUser.subList(pagination.getStartIndex(), pagination.getEndIndex());
			bean.put("pagination", pagination);
			bean.put("lsUser", lsUser);
		}catch(Exception e){
			e.printStackTrace();
		}
		bean.put("TAB_REPORT", Request.TAB_REPORT);
		return new ModelAndView(this.getViewName(),"bean",bean);
	}
}

