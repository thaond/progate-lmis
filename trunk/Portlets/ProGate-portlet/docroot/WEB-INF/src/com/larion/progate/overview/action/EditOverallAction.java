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

public class EditOverallAction extends PortletAction {

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		int editSuccess = 0;
		int orgId = ParamUtil.getInteger(actionRequest, URLParameter_RS.ORG_ID);
		int viewMode =Integer.parseInt(actionRequest.getParameter(URLParameter_RS.VIEW_MODE));
		String intro = ParamUtil.getString(actionRequest, Overview_Const.INTRO);
		String vision = ParamUtil.getString(actionRequest, Overview_Const.VISION);
		String mission = ParamUtil.getString(actionRequest, Overview_Const.MISSION);
		String coreValue = ParamUtil.getString(actionRequest, Overview_Const.CORE_VALUE);
		String currentUrl = ParamUtil.getString(actionRequest,Overview_Const.CURRENT_URL);
		
		try {
			String introType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallIntro();
			String visionType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallVision();
			String missionType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallMission();
			String coreValueType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallCoreValue();
			int end = ProGateJournalArticleLocalServiceUtil.countArticleByType(orgId, introType, "");
			
			 //Intro
			 List<ProGateJournalArticle> listIntro =  ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId, introType, "", 0, end);
			 if((listIntro != null) && (listIntro.size() != 0)){
				 ProGateJournalArticle introArticle = listIntro.get(0); 
				// if(intro.isEmpty()){
				//	 ProGateJournalArticleLocalServiceUtil.deleteProGateJournalArticle(introArticle);
				// }else{
					 introArticle.setContent(intro);
					 ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(introArticle, true);
				// }
			 }

			 //Vision
			 List<ProGateJournalArticle> listVision = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId,visionType, "", 0, end);
			 if((listVision != null) && (listVision.size() != 0)){
				 ProGateJournalArticle viArticle = listVision.get(0); 
				// if(vision.isEmpty()){
				//	 ProGateJournalArticleLocalServiceUtil.deleteProGateJournalArticle(viArticle);
				// }else{
					 viArticle.setContent(vision);
					 ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(viArticle, true);
				// }
			 }
			 
			 //Mission
			 List<ProGateJournalArticle> listMission = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId,missionType, "", 0, end);
			 if((listMission != null) && (listMission.size() != 0)){
				 ProGateJournalArticle misArticle = listMission.get(0); 
				// if(mission.isEmpty()){
				//	 ProGateJournalArticleLocalServiceUtil.deleteProGateJournalArticle(misArticle);
				// }else{
					 misArticle.setContent(mission);
					 ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(misArticle, true);
				// }
			 }
			 
			 //CoreValue
			 List<ProGateJournalArticle> listCoreValue = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId, coreValueType, "", 0, end);
			 if((listCoreValue != null) && (listCoreValue.size() != 0)){
				 ProGateJournalArticle coArticle = listCoreValue.get(0); 
				// if(coreValue.isEmpty()){
				//	 ProGateJournalArticleLocalServiceUtil.deleteProGateJournalArticle(coArticle);
				// }else{
					 coArticle.setContent(coreValue);
					 ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(coArticle, true);
				// }
			 }
			editSuccess = 1; // success

		} catch (Exception e) {
			editSuccess = 2; // Error

		}
		actionResponse.setRenderParameter(URLParameter_RS.ORG_ID, Integer.toString(orgId));
		actionResponse.setRenderParameter(URLParameter_RS.VIEW_MODE, Integer.toString(viewMode));
		
		actionRequest.setAttribute(Overview_Const.EDITED_SUCCESS, editSuccess);
		actionResponse.setRenderParameter(URLParameter_RS.ORG_ID, Integer.toString(orgId));
		actionResponse.setRenderParameter(Overview_Const.CURRENT_URL,currentUrl);
		setForward(actionRequest, "portlet.pg_overview.edit");

	}
}
