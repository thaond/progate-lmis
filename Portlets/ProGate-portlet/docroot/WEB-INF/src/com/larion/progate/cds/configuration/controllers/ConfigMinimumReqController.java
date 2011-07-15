package com.larion.progate.cds.configuration.controllers;

import java.io.PrintWriter;
import java.util.ArrayList;
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

import larion.progate.cds.model.CdsMinimumRequirementLevels;
import larion.progate.cds.model.CdsMinimumRequirements;
import larion.progate.cds.service.CdsMinimumRequirementLevelsLocalServiceUtil;
import larion.progate.cds.service.CdsMinimumRequirementsLocalServiceUtil;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class ConfigMinimumReqController extends ParameterizableViewController {
	
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
		
		bean.put("tab", "configMinimumReq");
		
		if(perAndRoleOnTab4.isPermitted()){
			//System.out.println("Zo dc man controller cua minimum");
			List<CdsMinimumRequirements> mRs = CdsMinimumRequirementsLocalServiceUtil
			.getMinimumRequirementListByRootId(rootId);
			List<CdsMinimumRequirementLevels> allMRLevels = new ArrayList<CdsMinimumRequirementLevels>();
			List<Integer> mRHasLevels = new ArrayList<Integer>(); //so level cua mot MR
			List<Integer> nextMRLevelOrders = new ArrayList<Integer>();
			
			//order mac dinh cua mR se them moi
			int nextMROrder = 1;
			if (mRs.size() > 0){
				nextMROrder = mRs.get(mRs.size() - 1).getNumberOrder() + 1;
			}
			
			Iterator<CdsMinimumRequirements> itMR = mRs.iterator();
			
			while (itMR.hasNext()) {
				
				CdsMinimumRequirements mR = itMR.next();
				List<CdsMinimumRequirementLevels> mRLevels = CdsMinimumRequirementLevelsLocalServiceUtil
						.getCdsMRLevelListByMinimumRequirementId(mR.getPrimaryKey());
				
				//order mac dinh cua mRlevel se them moi
				if (mRLevels.size() > 0) {
					int nextMrLevelOrder = mRLevels.get(mRLevels.size()-1).getNumberOrder() + 1;
					nextMRLevelOrders.add(nextMrLevelOrder);
				} else {
					nextMRLevelOrders.add(1);
				}
				
				mRHasLevels.add(mRLevels.size());
				
				Iterator<CdsMinimumRequirementLevels> itMRLevel = mRLevels.iterator();
				
				while (itMRLevel.hasNext()) {
					
					CdsMinimumRequirementLevels level = itMRLevel.next();
					//System.out.println(level.getName());
					allMRLevels.add(level);
				}
			}
		
			bean.put("mRs", mRs);
			bean.put("sizeOfMRs", mRs.size());
			bean.put("allMRLevels", allMRLevels);
			bean.put("sizeOfAllMRLevels", allMRLevels.size());
			bean.put("mRHasLevels", mRHasLevels);
			
			bean.put("nextMROrder", nextMROrder);
			bean.put("nextMRLevelOrders", nextMRLevelOrders);
		}
		return new ModelAndView(this.getViewName(), "bean", bean);
	}
	
	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {

		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
		if (rootId == 0)
		{
			HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
		}
		
		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
		int userId = (int) sc.getUserId();

		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		res.setCharacterEncoding("UTF-8");
		PrintWriter output = res.getWriter();
		
		String type = ParamUtil.getString(request, "type");
		String action = ParamUtil.getString(request, "handle");

		System.out
				.println("-----------------------------DEBUG-------------------------------");
		System.out.println(type);
		System.out.println(action);
		System.out
				.println("-----------------------------END---------------------------------");

		if (type.equals("minimumReq")) {
			
			if (action.equals("checkNameExist")){
				String minimumRequirementName = StringEscapeUtils.escapeHtml(ParamUtil.getString(request, "minimumRequirementName"));
				boolean test = CdsMinimumRequirementsLocalServiceUtil.checkMinimumRequirementName(rootId, minimumRequirementName);
				if (test){
					output.print("true");
				} else {
					output.print("false");
				}
			}
			
			if (action.equals("add")) {

				String name = StringEscapeUtils.escapeHtml(ParamUtil.getString(request, "name"));
				int order = ParamUtil.getInteger(request, "order");
				int id = ParamUtil.getInteger(request, "id");

				try {
					if (id == -1) { // add
						CdsMinimumRequirementsLocalServiceUtil.addCdsMinimumRequirement(rootId,
								name, order, userId);
						output.print("ban da them thanh cong mot mR");
					} else { // edit
						CdsMinimumRequirementsLocalServiceUtil.updateCdsMinimumRequirement(id,
								name, order, userId);
						output.print("ban da sua thanh cong mot mR");
					}
				} catch (Exception e) {
					e.printStackTrace();
					if (id == -1) {
						output.print("co loi xay ra khi them mR");
					} else { // edit
						output.print("co loi xay ra khi sua mR");
					}
				}
			} else if (action.equals("delete")) {
				try {
					int id = ParamUtil.getInteger(request, "id");
					CdsMinimumRequirementsLocalServiceUtil.deleteCdsMinimumRequirement(id);
					output.print("ban da xoa thanh cong mot mR");
				} catch (Exception e) {
					e.printStackTrace();
					output.print("co loi xay ra khi xoa mR");
				}
			} else if (action.equals("edit")) {
				try {
					int id = ParamUtil.getInteger(request, "id");
					CdsMinimumRequirements c = CdsMinimumRequirementsLocalServiceUtil.getCdsMinimumRequirements(id);

					StringBuffer xml = new StringBuffer();

					xml.append("<?xml version=\"1.0\"?>\n");
					xml.append("<minimumReq>\n");

					xml.append("<id>");
					xml.append(c.getPrimaryKey());
					xml.append("</id>\n");

					xml.append("<name>");
					xml.append(c.getName());
					xml.append("</name>\n");

					xml.append("<order>");
					xml.append(c.getNumberOrder());
					xml.append("</order>\n");

					xml.append("</minimumReq>\n");

					output.print(xml.toString());

				} catch (Exception e) {
					e.printStackTrace();
					output.print("co loi xay ra khi get competency");
				}
			}
		}

		if (type.equals("mRLevel")) {
			
			if (action.equals("checkNameExist")){
				int parentId = ParamUtil.getInteger(request, "parentId");
				String minimumRequirementLevelName = StringEscapeUtils.escapeHtml(ParamUtil.getString(request, "minimumRequirementLevelName"));
				boolean test = CdsMinimumRequirementLevelsLocalServiceUtil.checkMinimumRequirementLevelName(parentId, minimumRequirementLevelName);
				if (test){
					output.print("true");
				} else {
					output.print("false");
				}
			}
			
			if (action.equals("add")) {
				String name = StringEscapeUtils.escapeHtml(ParamUtil.getString(request, "name"));
				int order = ParamUtil.getInteger(request, "order");
				int id = ParamUtil.getInteger(request, "id");
				int parentId = ParamUtil.getInteger(request, "parentId");

				try {

					if (id == -1) { // add
						CdsMinimumRequirementLevelsLocalServiceUtil.addCdsMinimumRequirementLevel(parentId, name,
								order, userId);
						output.print("ban da them thanh cong mot mRLevel");
					} else { // edit
						CdsMinimumRequirementLevelsLocalServiceUtil.updateCdsMinimumRequirementLevel(id, name, order,
								userId);
						output.print("ban da sua thanh cong mot mRLevel");
					}
				} catch (Exception e) {
					e.printStackTrace();
					if (id == -1) { // add
						output.print("co loi xay ra khi them mRLevel");
					} else {
						output.print("co loi xay ra khi sua mRLevel");
					}
				}
			} else if (action.equals("delete")) {
				try {

					int id = ParamUtil.getInteger(request, "id");
					CdsMinimumRequirementLevelsLocalServiceUtil.deleteCdsMinimumRequirementLevel(id);
					output.print("ban da xoa thanh cong mot mRLevel");

				} catch (Exception e) {
					e.printStackTrace();
					output.print("co loi xay ra khi xoa mRLevel");
				}
			} else if (action.equals("edit")) {
				try {
					int id = ParamUtil.getInteger(request, "id");
					CdsMinimumRequirementLevels l = CdsMinimumRequirementLevelsLocalServiceUtil.getCdsMinimumRequirementLevels(id);

					StringBuffer xml = new StringBuffer();

					xml.append("<?xml version=\"1.0\"?>\n");
					xml.append("<mRLevel>\n");

					xml.append("<id>");
					xml.append(l.getPrimaryKey());
					xml.append("</id>\n");

					xml.append("<parentId>");
					xml.append(l.getMinimumRequirementId());
					xml.append("</parentId>\n");

					xml.append("<name>");
					xml.append(l.getName());
					xml.append("</name>\n");

					xml.append("<order>");
					xml.append(l.getNumberOrder());
					xml.append("</order>\n");

					xml.append("</mRLevel>\n");

					output.print(xml.toString());

				} catch (Exception e) {
					e.printStackTrace();
					output.print("co loi xay ra khi get mRLevel");
				}
			}
		}

		output.flush();
	}
}
