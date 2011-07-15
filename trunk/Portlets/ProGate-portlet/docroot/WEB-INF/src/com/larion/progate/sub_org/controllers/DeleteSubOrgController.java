package com.larion.progate.sub_org.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.larion.progate.leftMenu.constants.LeftMenu_Const;
import com.larion.progate.news_homepage.constants.News_Const;
import com.larion.progate.organization.menu.constants.URL_Const;
import com.liferay.portal.kernel.util.ParamUtil;

public class DeleteSubOrgController extends ParameterizableViewController{
	
	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		
		Map<String, Object> bean = new HashMap<String, Object>();
		
		int orgId = ParamUtil.getInteger(request,URLParameter_RS.ORG_ID);
		int orgRootId = ParamUtil.getInteger(request,URLParameter_RS.ORG_ROOT_ID);
		int viewMode = ParamUtil.getInteger(request,URLParameter_RS.VIEW_MODE);
		
		// Get current User
		try{
			
			if (orgId != 0){
				OrganizationLocalServiceUtil.deleteOrganization(Integer.valueOf(orgId));	
			}
			
		}catch(Exception e){
			
		}
		
		ProGateUtil.redirectToPageWithParams(request, response, 
				URL_Const.SUB_ORG, 
				new String[] {URLParameter_RS.ORG_ID ,URLParameter_RS.VIEW_MODE }, 
				new String[] {Integer.toString(orgRootId),Integer.toString(viewMode)});
		
	}
}