package com.larion.progate.cds.configuration.controllers;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.cds.model.CdsPoints;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsPointsLocalServiceUtil;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

 
public class CdsPointsController extends ParameterizableViewController {
	
	private PermissionAndRole perAndRoleOnTab1 = new PermissionAndRole(); //Config CDS Tree
	private PermissionAndRole perAndRoleOnTab2 = new PermissionAndRole(); //Config points
	private PermissionAndRole perAndRoleOnTab3 = new PermissionAndRole(); //Config periods
	private PermissionAndRole perAndRoleOnTab4 = new PermissionAndRole(); //Config minimum
	private PermissionAndRole perAndRoleOnTab5 = new PermissionAndRole(); //Config title
	
	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		Map<String, Object> bean = new HashMap<String, Object>();
		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
		if (rootId == 0)
		{
			HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
		}
		bean.put("orgId", rootId);
		
		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass()
				.getName(), request);
		int userId = (int) sc.getUserId();
		bean.put("userId", userId);
		
		perAndRoleOnTab1.check(rootId, userId, RequestConst.PERMISSION_CONFIG_CDS_TREE);
		perAndRoleOnTab2.check(rootId, userId, RequestConst.PERMISSION_CONFIG_POINTS);
		perAndRoleOnTab3.check(rootId, userId, RequestConst.PERMISSION_CONFIG_PERIODS);
		perAndRoleOnTab4.check(rootId, userId, RequestConst.PERMISSION_CONFIG_MINIMUM_REQUIREMENT);
		perAndRoleOnTab5.check(rootId, userId, RequestConst.PERMISSION_CONFIG_TITLE);
		
		bean.put("hasPermissionOnTab1", perAndRoleOnTab1.isPermitted());
		bean.put("hasPermissionOnTab2", perAndRoleOnTab2.isPermitted());
		bean.put("hasPermissionOnTab3", perAndRoleOnTab3.isPermitted());
		bean.put("hasPermissionOnTab4", perAndRoleOnTab4.isPermitted());
		bean.put("hasPermissionOnTab5", perAndRoleOnTab5.isPermitted());
		
		bean.put("tab", "cdsPoints");
		
		if(perAndRoleOnTab2.isPermitted()){
			List<CdsPoints> list = CdsPointsLocalServiceUtil.getCdsPointListByRootId(rootId);
			int size = list.size();
			bean.put("CdsPointList", list);
			bean.put("size", size);
			bean.put("rootId", rootId);
			boolean lockEditButton = CdsEvaluationPeriodsLocalServiceUtil.checkOpenOrClosePeriod(rootId);
			System.out.println("lockEditButton: "+lockEditButton);
			bean.put("lockEditButton", lockEditButton);
		}
		return new ModelAndView(this.getViewName(), "bean", bean);
	}

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		// TODO Auto-generated method stub
		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
		if (rootId == 0)
		{
			HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
		}
		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
		int userId = (int) sc.getUserId();
		
		perAndRoleOnTab2.check(rootId, userId, RequestConst.PERMISSION_CONFIG_CDS_TREE);
		
		if(perAndRoleOnTab2.isPermitted()){
			HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
			res.setCharacterEncoding("UTF-8");
			PrintWriter output = res.getWriter();
			
			String action = ParamUtil.getString(request, "handle");
			if(action.equals("add")){
				try {	
					int x = ParamUtil.getInteger(request, "id");
					int[] id = ParamUtil.getIntegerValues(request, "data0");
					String[] name = request.getParameterValues("data1");
					int[] value = ParamUtil.getIntegerValues(request, "data2");
					String[] des = request.getParameterValues("data3");
					if(x == -1){
						for(int i=0;i<5;i++){
							CdsPointsLocalServiceUtil.addCdsPoint(rootId, name[i], value[i], des[i], userId);
						}
					} else{
						for(int i=0;i<5;i++){
							CdsPointsLocalServiceUtil.updateCdsPoint(id[i], rootId, name[i], value[i], des[i], userId);
						}
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
			}
			if(action.equals("edit")){
				try {
					
					List<CdsPoints> cplist = CdsPointsLocalServiceUtil.getCdsPointListByRootId(rootId);
					Iterator<CdsPoints> icp = cplist.iterator();
					StringBuffer xml = new StringBuffer();
					
					xml.append("<?xml version=\"1.0\"?>\n");
					xml.append("<CdsPoints>\n");
					for(int i=1;i<6;i++){
						CdsPoints cp = icp.next();
						
						xml.append("<id"+i+">");
						xml.append(cp.getPrimaryKey());
						xml.append("</id"+i+">\n");
						
						xml.append("<name"+i+">");
						xml.append(cp.getPointName());
						xml.append("</name"+i+">\n");
						
						xml.append("<value"+i+">");
						xml.append(cp.getPointValue());
						xml.append("</value"+i+">\n");
						
						xml.append("<des"+i+">");
						xml.append(cp.getDescription());
						xml.append("</des"+i+">\n");
						
					}
					xml.append("</CdsPoints>\n");
					output.print(xml.toString());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
			}
			output.flush();
		}
	}

}