package com.larion.progate.overview.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.overview.constants.Overview_Const;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

public class AddOverallAction extends PortletAction {

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		
		int addedSuccess = 0;
		int orgId = ParamUtil.getInteger(actionRequest,URLParameter_RS.ORG_ID);
		int viewMode =Integer.parseInt(actionRequest.getParameter(URLParameter_RS.VIEW_MODE));
		String intro = ParamUtil.getString(actionRequest, Overview_Const.INTRO);
		String vision = ParamUtil.getString(actionRequest,Overview_Const.VISION);
		String mission = ParamUtil.getString(actionRequest,Overview_Const.MISSION);
		String coreValue = ParamUtil.getString(actionRequest,Overview_Const.CORE_VALUE);
		String currentUrl = ParamUtil.getString(actionRequest,Overview_Const.CURRENT_URL);

		try {
			String introType = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeOrgOverallIntro();
			String visionType = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeOrgOverallVision();
			String missionType = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeOrgOverallMission();
			String coreValueType = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeOrgOverallCoreValue();
			 int end =
			 ProGateJournalArticleLocalServiceUtil.countArticleByType(orgId,
			 intro, "");
			
			
			// Get User
			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), actionRequest);
			com.liferay.portal.model.User user = UserLocalServiceUtil
					.getUser(sc.getUserId());
			int userId = (int) user.getUserId();
			ProGateJournalArticle introArticle = null ;
			ProGateJournalArticle visionArticle = null ;
			ProGateJournalArticle missionArticle = null ;
			ProGateJournalArticle coreValueArticle = null ;
			
			// intro
			List<ProGateJournalArticle> listIntro =  ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId, introType, "", 0, end);
			if((listIntro != null) && (listIntro.size() != 0)){
				introArticle = listIntro.get(0);
				introArticle.setContent(intro);
				ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(introArticle, true);
			}else{
				introArticle = ProGateJournalArticleLocalServiceUtil.createNewArticle(Integer.toString(orgId), userId, "Introduction", introType,"", intro, "", "", "");
			}
			// vision
			List<ProGateJournalArticle> listVision =  ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId, visionType, "", 0, end);
			if((listVision != null) && (listVision.size() != 0)){
				visionArticle = listVision.get(0);
				visionArticle.setContent(vision);
				ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(visionArticle, true);
			}else{
				visionArticle = ProGateJournalArticleLocalServiceUtil.createNewArticle(Integer.toString(orgId), userId, "Vision", visionType, "",vision, "", "", "");
			}
			
			// mission
			List<ProGateJournalArticle> listMission =  ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId, missionType, "", 0, end);
			if((listMission != null) && (listMission.size() != 0)){
				missionArticle = listMission.get(0);
				missionArticle.setContent(mission);
				ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(missionArticle, true);
			}else{
				missionArticle = ProGateJournalArticleLocalServiceUtil.createNewArticle(Integer.toString(orgId), userId, "Mission", missionType,"", mission, "", "", "");
			}
			
			// coreValue
			List<ProGateJournalArticle> listCoreValue =  ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId, coreValueType, "", 0, end);
			if((listCoreValue != null) && (listCoreValue.size() != 0)){
				coreValueArticle = listCoreValue.get(0);
				coreValueArticle.setContent(coreValue);
				ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(coreValueArticle, true);
			}else{
				coreValueArticle = ProGateJournalArticleLocalServiceUtil.createNewArticle(Integer.toString(orgId), userId, "Core Value",coreValueType, "", coreValue, "", "", "");	
			}
			
			addedSuccess = 1; // success

		} catch (Exception e) {
			addedSuccess = 2; // Error

		}
		actionResponse.setRenderParameter(URLParameter_RS.ORG_ID, Integer.toString(orgId));
		actionResponse.setRenderParameter(URLParameter_RS.VIEW_MODE, Integer.toString(viewMode));
		
		actionRequest.setAttribute(Overview_Const.ADDED_SUCCESS, addedSuccess);
		actionResponse.setRenderParameter(Overview_Const.INTRO, intro);
		actionResponse.setRenderParameter(Overview_Const.VISION, vision);
		actionResponse.setRenderParameter(Overview_Const.MISSION, mission);
		actionResponse.setRenderParameter(Overview_Const.CORE_VALUE,coreValue);
		actionResponse.setRenderParameter(Overview_Const.CURRENT_URL,currentUrl);
		
		setForward(actionRequest, "portlet.pg_overview.add");

	}
}
