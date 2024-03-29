package com.larion.progate.orgMap.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.Functions;
import com.larion.progate.orgMap.constants.OrgMap_Const;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

public class EditOrgMapAction extends PortletAction {

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		int editSuccess = 0;
		int orgId = Integer.parseInt(actionRequest.getParameter(URLParameter_RS.ORG_ID));
		int viewMode =Integer.parseInt(actionRequest.getParameter(URLParameter_RS.VIEW_MODE));
		String title = actionRequest.getParameter(OrgMap_Const.TITLE);
		String imageMap = "";
		try{
			UploadPortletRequest uploadPortlet = PortalUtil.getUploadPortletRequest(actionRequest);
			imageMap = Functions.getPathOfUploadImage(actionRequest, actionResponse, uploadPortlet, OrgMap_Const.IMAGE_MAP);
		}catch(Exception e){
			
		}
		String description = actionRequest.getParameter(OrgMap_Const.DESCRIPTION);
		String currentUrl = actionRequest.getParameter(OrgMap_Const.CURRENT_URL);
		
		try {
			String orgMapType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgMap();
			int end = ProGateJournalArticleLocalServiceUtil.countArticleByType(orgId, orgMapType, "");
			List<ProGateJournalArticle> listOrgMap =  ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId, orgMapType, "", 0, end);
			if((listOrgMap != null) && (listOrgMap.size() != 0)){
				 ProGateJournalArticle orgMapArticle = listOrgMap.get(0); 
				 orgMapArticle.setTitle(title);
				 if(!imageMap.isEmpty()){
					 orgMapArticle.setSmallImageUrl(imageMap);
				 }
				 orgMapArticle.setDescription(description);
				 ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(orgMapArticle, true);
				 
			}
			editSuccess = 1; // success

		} catch (Exception e) {
			editSuccess = 2; // Error
		}
		actionResponse.setRenderParameter(URLParameter_RS.ORG_ID, Integer.toString(orgId));
		actionResponse.setRenderParameter(URLParameter_RS.VIEW_MODE, Integer.toString(viewMode));
		
		actionResponse.setRenderParameter(OrgMap_Const.TITLE, title);
		//actionResponse.setRenderParameter(OrgMap_Const.IMAGE_MAP, imageMap);
		actionResponse.setRenderParameter(OrgMap_Const.DESCRIPTION, description);
		actionResponse.setRenderParameter(OrgMap_Const.CURRENT_URL, currentUrl);
		actionRequest.setAttribute(OrgMap_Const.EDITED_SUCCESS, editSuccess);
		setForward(actionRequest, "portlet.orgMap.edit");

	}
}
